package com.shop.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecomm.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
