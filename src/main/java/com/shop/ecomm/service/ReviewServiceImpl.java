package com.shop.ecomm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.ecomm.exception.ProductException;
import com.shop.ecomm.model.Review;
import com.shop.ecomm.model.User;
import com.shop.ecomm.repository.ProductRepository;
import com.shop.ecomm.repository.ReviewRepository;
import com.shop.ecomm.request.ReviewRequest;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository reviewRepository;
	private ProductRepository productRepository;
	private ProductService productService;

	public ReviewServiceImpl(ReviewRepository reviewRepository, ProductRepository productRepository,
			ProductService productService) {
		this.reviewRepository = reviewRepository;
		this.productRepository = productRepository;
		this.productService = productService;

	}

	// ############# Methods ############## //
	@Override
	public Review createReview(ReviewRequest req, User user) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> getAllReview(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
