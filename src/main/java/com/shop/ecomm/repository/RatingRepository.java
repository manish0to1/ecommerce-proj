package com.shop.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecomm.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {

}
