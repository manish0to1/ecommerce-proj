package com.shop.ecomm.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.ecomm.exception.ProductException;
import com.shop.ecomm.model.Product;
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

		Product product = productService.findProductById(req.getProductId());
		Review review = new Review();
		review.setUser(user);
		review.setProduct(product);
		review.setReview(req.getReview());
		review.setCreatedAt(LocalDateTime.now());
		return reviewRepository.save(review);
	}

	@Override
	public List<Review> getAllReview(Long productId) {

		return reviewRepository.getAllProductsReview(productId);
	}

}
