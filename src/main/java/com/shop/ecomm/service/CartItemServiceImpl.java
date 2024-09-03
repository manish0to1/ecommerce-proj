package com.shop.ecomm.service;

import org.springframework.stereotype.Service;

import com.shop.ecomm.exception.CartItemException;
import com.shop.ecomm.exception.UserException;
import com.shop.ecomm.model.Cart;
import com.shop.ecomm.model.CartItem;
import com.shop.ecomm.model.Product;
import com.shop.ecomm.repository.CartItemRepository;
import com.shop.ecomm.repository.CartRepository;

@Service
public class CartItemServiceImpl implements CartItemService {

	private CartItemRepository cartItemRepository;

	private UserService userService;

	private CartRepository cartRepository;

	public CartItemServiceImpl(CartItemRepository cartItemRepository, UserService userService,
			CartRepository cartRepository) {

		this.cartItemRepository = cartItemRepository;

		this.userService = userService;

		this.cartRepository = cartRepository;

	}

	// ############## Methods ################### //
	@Override
	public CartItem createCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart isCartItemExist(Cart cart, Product product, String size, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {
		// TODO Auto-generated method stub

	}

	@Override
	public CartItem findCartItemById(Long cartItemId) throws CartItemException {
		// TODO Auto-generated method stub
		return null;
	}

}
