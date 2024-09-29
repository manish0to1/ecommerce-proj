package com.shop.ecomm.service;

import java.util.List;

import com.shop.ecomm.exception.OrderException;
import com.shop.ecomm.model.Address;
import com.shop.ecomm.model.Order;
import com.shop.ecomm.model.User;

public interface OrderService {

	// CRUD Operations
	public Order createOrder(User user, Address shippingAddress);

	public Order findOrderById(Long orderId) throws OrderException;

	public void deleteOrder(Long orderId) throws OrderException;

	// Status Update Methods
	public Order placedOrder(Long orderId) throws OrderException;

	public Order shippedOrder(Long orderId) throws OrderException;

	public Order confirmedOrder(Long orderId) throws OrderException;

	public Order deliveredOrder(Long orderId) throws OrderException;

	public Order calceledOrder(Long orderId) throws OrderException;

	// Retrieval Methods
	public List<Order> userOrderHistory(Long userId);

	public List<Order> getAllOrders();

//	public Order (Long orderId);

//	public List<Order> getAllOrder();
}
