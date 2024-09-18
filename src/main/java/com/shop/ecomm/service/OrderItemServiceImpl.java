package com.shop.ecomm.service;

import com.shop.ecomm.model.OrderItem;
import com.shop.ecomm.repository.OrderItemRepository;

public class OrderItemServiceImpl implements OrderItemService {

	private OrderItemRepository orderItemRepository;

	@Override
	public OrderItem createOrderItem(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}
}
