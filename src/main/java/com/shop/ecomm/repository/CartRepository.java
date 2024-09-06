package com.shop.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecomm.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
