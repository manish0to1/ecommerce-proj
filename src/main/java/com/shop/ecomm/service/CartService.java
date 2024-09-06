package com.shop.ecomm.service;

import com.shop.ecomm.exception.ProductException;
import com.shop.ecomm.model.Cart;
import com.shop.ecomm.model.User;
import com.shop.ecomm.request.AddItemRequest;

public interface CartService {

	public Cart createCart(User user);

	public String addCartItem(Long userId, AddItemRequest req) throws ProductException;

	public Cart findUserCart(Long userId);

}
