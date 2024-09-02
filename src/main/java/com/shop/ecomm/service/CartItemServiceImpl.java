package com.shop.ecomm.service;

import org.springframework.stereotype.Service;

import com.shop.ecomm.exception.CartItemException;
import com.shop.ecomm.exception.UserException;
import com.shop.ecomm.model.Cart;
import com.shop.ecomm.model.CartItem;
import com.shop.ecomm.model.Product;

@Service
public class CartItemServiceImpl implements CartItemService {

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
