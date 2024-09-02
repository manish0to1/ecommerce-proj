package com.shop.ecomm.service;

import com.shop.ecomm.exception.CartItemException;
import com.shop.ecomm.exception.UserException;
import com.shop.ecomm.model.CartItem;

public interface CartItemService {

	public CartItem createCartItem(CartItem cartItem);

	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;

}
