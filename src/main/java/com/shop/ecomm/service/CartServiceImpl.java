package com.shop.ecomm.service;

import org.springframework.stereotype.Service;

import com.shop.ecomm.exception.ProductException;
import com.shop.ecomm.model.Cart;
import com.shop.ecomm.model.CartItem;
import com.shop.ecomm.model.Product;
import com.shop.ecomm.model.User;
import com.shop.ecomm.repository.CartRepository;
import com.shop.ecomm.request.AddItemRequest;

@Service
public class CartServiceImpl implements CartService {

	private CartRepository cartRepository;
	private CartItemService cartItemService;
	private ProductService productService;

	public CartServiceImpl(CartRepository cartRepository, CartItemService cartItemService,
			ProductService productService) {

		this.cartRepository = cartRepository;
		this.cartItemService = cartItemService;
		this.productService = productService;
	}

	// ######### Methods ########## //
	@Override
	public Cart createCart(User user) {

		Cart cart = new Cart();
		cart.setUser(user);
		return cartRepository.save(cart);
	}

	@Override
	public String addCartItem(Long userId, AddItemRequest req) throws ProductException {

		Cart cart = cartRepository.findByUserId(userId);
		Product product = productService.findProductById(req.getProductId());
		CartItem isPresent = cartItemService.isCartItemExist(cart, product, req.getSize(), userId);

		if (isPresent == null) {
			CartItem cartItem = new CartItem();
			cartItem.setCart(cart);
			cartItem.setProduct(product);
			cartItem.setQuantity(req.getQuantity());
			cartItem.setUserId(userId);

			int price = req.getQuantity() * product.getDiscountedPrice();
			cartItem.setPrice(price);
			cartItem.setSize(req.getSize());

			CartItem createCartItem = cartItemService.createCartItem(cartItem);
			cart.getCartItems().add(createCartItem);

		}
		return "item add to cart";
	}

	@Override
	public Cart findUserCart(Long userId) {

		Cart cart = cartRepository.findByUserId(userId);

		int totalPrice = 0;
		int totalDiscountedPrice = 0;
		int totalItem = 0;

		for (CartItem cartItem : cart.getCartItems()) {
			totalPrice = totalPrice + cartItem.getPrice();
			totalDiscountedPrice = totalDiscountedPrice + cartItem.getDiscountedPrice();
			totalItem = totalItem + cartItem.getQuantity();
		}

		cart.setTotalItem(totalItem);

		cart.setTotalPrice(totalPrice);

		cart.setDiscount(totalPrice - totalDiscountedPrice);

		cart.setTotalDiscountedPrice(totalDiscountedPrice);

		return cartRepository.save(cart);
	}

}
