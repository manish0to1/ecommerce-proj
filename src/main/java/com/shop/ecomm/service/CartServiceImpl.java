package com.shop.ecomm.service;

import org.springframework.stereotype.Service;

import com.shop.ecomm.exception.ProductException;
import com.shop.ecomm.model.Cart;
import com.shop.ecomm.model.User;
import com.shop.ecomm.repository.CartRepository;
import com.shop.ecomm.request.AddItemRequest;

@Service
public class CartServiceImpl implements CartService {

	private CartRepository cartRepository;
	private CartItemService cartItemService;

	// ######### Methods ########## //
	@Override
	public Cart createCart(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addCartItem(Long userId, AddItemRequest req) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findUserCart(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
