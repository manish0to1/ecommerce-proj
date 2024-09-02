package com.shop.ecomm.service;

import com.shop.ecomm.exception.CartItemException;
import com.shop.ecomm.exception.UserException;
import com.shop.ecomm.model.Cart;
import com.shop.ecomm.model.CartItem;
import com.shop.ecomm.model.Product;

public interface CartItemService {

	public CartItem createCartItem(CartItem cartItem);

	public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;

	public Cart isCartItemExist(Cart cart, Product product, String size, Long userId);

	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;

	public CartItem findCartItemById(Long cartItemId) throws CartItemException;
}
