package com.shop.ecomm.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shop.ecomm.exception.OrderException;
import com.shop.ecomm.model.Address;
import com.shop.ecomm.model.Cart;
import com.shop.ecomm.model.CartItem;
import com.shop.ecomm.model.Order;
import com.shop.ecomm.model.OrderItem;
import com.shop.ecomm.model.User;
import com.shop.ecomm.repository.AddressRepository;
import com.shop.ecomm.repository.OrderRepository;
import com.shop.ecomm.repository.UserRepository;

@Service
public class OrderServiceImpl implements OrderService {

//	private CartRepository cartRepository;
//	private CartService cartItemService;
//	private ProductService productService;
//
//	public OrderServiceImpl(CartRepository cartRepository, CartService cartItemService,
//			ProductService productService) {
//		this.cartRepository = cartRepository;
//		this.cartItemService = cartItemService;
//		this.productService = productService;
//	}

	private OrderRepository orderRepository;
	private CartService cartService;
	private AddressRepository addressRepository;
	private UserRepository userRepository;
	private OrderItemService orderItemService;
	private OrderItemRepository orderItemRepository;

	public OrderServiceImpl(OrderRepository orderRepository, CartService cartService,
			AddressRepository addressRepository, UserRepository userRepository, OrderItemService orderItemService,
			OrderItemRepository orderItemRepository) {

		this.orderRepository = orderRepository;
		this.cartService = cartService;
		this.addressRepository = addressRepository;
		this.userRepository = userRepository;
		this.orderItemService = orderItemService;
		this.orderItemRepository = orderItemRepository;
	}

	// #################### Methods ###################### //
	@Override
	public Order createOrder(User user, Address shippingAddress) {

		shippingAddress.setUser(user);
		Address.address = addressRepository.save(shippAddress);
		user.getAddresses().add(address);
		userRepository.save(user);

		Cart cart = cartService.findUserCart(user.getId());
		List<OrderItem> orderItems = new ArrayList<>();

		for (CartItem item : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();

			orderItem.setPrice(item.getPrice());
			orderItem.setProduct(item.getProduct());
			orderItem.setQuantity(item.getQuantity());
			orderItem.setSize(item.getSize());
			orderItem.setUserId(item.getUserId());
			orderItem.setDiscountedPrice(item.getDiscountedPrice());

			OrderItem createdOrderItem = orderItemRepository.save(orderItem);
			orderItems.add(createdOrderItem);
		}

		Order createdOrder = new Order();

		createdOrder.setUser(user);
		createdOrder.setOrderItems(orderItems);
		createdOrder.setTotalPrice(cart.getTotalPrice());
		createdOrder.setToalDiscountedPrice(cart.getTotalDiscountedPrice());
		createdOrder.setDiscount(cart.getDiscount());
		createdOrder.setTotalItem(cart.getTotalItem());

		createdOrder.setShippingAddress(address);
		createdOrder.setOrderDate(LocalDateTime.now());
		createdOrder.setOrderStatus(OrderStatus.PENDING);
		createdOrder.setPaymentDetails().setStatus(PaymentStatus.PENDING);
		createdOrder.setCreateAt(LocalDateTime.now());

		Order savedOrder = orderItemRepository.save(createdOrder);

		for (OrderItem item : orderItems) {
			item.setOrder(savedOrder);
			orderRepository.save(item);
		}
		return savedOrder;
	}

	@Override
	public Order findOrderById(Long orderId) throws OrderException {

		Optional<Order> opt = orderRepository.findById(orderId);
		if (opt.isPresent()) {
			return opt.get();
		}

		throw new OrderException("Order not exist with id :" + orderId);
	}

	@Override
	public List<Order> userOrderHistory(Long userId) {

		List<Order> orders = userRepository.getUsersOrders(userId);
		return orders;
	}

	@Override
	public Order placedOrder(Long orderId) throws OrderException {

		Order order = findOrderById(orderId);
		order.setOrderStatus(OrderStatus.PLACED);
		order.getPaymentDetails().setStatus(PaymentStatus.COMPLETED);
		return order;
	}

	@Override
	public Order shippingOrder(Long orderId) throws OrderException {

		Order order = findOrderById(orderId);
		order.setOrderStatus(OrderStatus.SHIPPED);

		return orderRepository.save(order);
	}

	@Override
	public Order confirmedOrder(Long orderId) throws OrderException {

		Order order = findOrderById(orderId);
		order.setOrderStatus(OrderStatus.CONFIRMED);

		return orderRepository.save(order);
	}

	@Override
	public Order deliveredOrder(Long orderId) throws OrderException {
		Order order = findOrderById(orderId);
		order.setOrderStatus(OrderStatus.DELIVERED);
		return orderRepository.save(order);
	}

	@Override
	public Order calceledOrder(Long orderId) throws OrderException {
		Order order = findOrderById(orderId);
		order.setOrderStatus(OrderStatus.CANCELLED);
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrder() {
		return orderRepository.findAll();
	}

	@Override
	public void deleteOrder(Long orderId) throws OrderException {
		Order order = findOrderById(orderId);
		orderRepository.deleteById(orderId);
	}
}
