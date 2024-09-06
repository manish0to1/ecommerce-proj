package com.shop.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecomm.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
