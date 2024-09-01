package com.shop.ecomm.service;

import java.util.List;

import com.shop.ecomm.model.Order;
import com.shop.ecomm.model.User;

public interface OrderService {

	public Order createOrder(User user, Address shippingAddress);

	public Order findOrderById(Long orderId) throws OrderException;

	public List<Order> userOrderHistory(Long userId);

	public Order placedOrder(Long orderId) throws OrderException;

	public Order confirmedOrder(Long orderId) throws OrderException;

	public Order deliveredOrder(Long orderId) throws OrderException;

	public Order calceledOrder(Long orderId) throws OrderException;

}
