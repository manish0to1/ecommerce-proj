package com.shop.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecomm.model.Order;
import com.shop.ecomm.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	Order save(Order createdOrder);

}
