package com.shop.ecomm.service;

import java.util.List;

import com.shop.ecomm.exception.ProductException;
import com.shop.ecomm.model.Review;
import com.shop.ecomm.model.User;
import com.shop.ecomm.request.ReviewRequest;

public interface ReviewService {

	public Review createReview(ReviewRequest req, User user) throws ProductException;

	public List<Review> getAllReview(Long productId);
}
