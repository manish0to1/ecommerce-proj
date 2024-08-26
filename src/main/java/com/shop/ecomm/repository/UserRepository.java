package com.shop.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecomm.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
