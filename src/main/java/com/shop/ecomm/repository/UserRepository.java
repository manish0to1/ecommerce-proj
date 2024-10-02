
package com.shop.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.ecomm.model.Order;
import com.shop.ecomm.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	// Find a user by email
	public User findByEmail(String email);

	// Custom query to retrieve orders associated with a user
	@Query("SELECT o FROM Order o WHERE o.user.id = :userId")
	public List<Order> findOrdersByUserId(@Param("userId") Long userId);
}

// ####################### Original #################### //
//package com.shop.ecomm.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.shop.ecomm.model.Order;
//import com.shop.ecomm.model.User;
//
//public interface UserRepository extends JpaRepository<User, Long> {
//
//	public User findByEmail(String email);
//
//	public List<Order> getUsersOrders(Long userId);
//}