package com.shop.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecomm.model.Order;
import com.shop.ecomm.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

	public List<Order> getUsersOrders(Long userId);
}
