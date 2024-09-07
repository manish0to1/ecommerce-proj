package com.shop.ecomm.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.ecomm.exception.ProductException;
import com.shop.ecomm.model.Product;
import com.shop.ecomm.model.Rating;
import com.shop.ecomm.model.User;
import com.shop.ecomm.repository.RatingRepository;
import com.shop.ecomm.request.RatingRequest;

@Service
public class RatingServiceImpl implements RatingService {

	private RatingRepository ratingRepository;
	private ProductService productService;

	public RatingServiceImpl(RatingRepository ratingRepository, ProductService productService) {
		this.ratingRepository = ratingRepository;
		this.productService = productService;
	}

	// #################### Methods ################### //
	@Override
	public Rating createRating(RatingRequest req, User user) throws ProductException {

		Product product = productService.findProductById(req.getProductId());

		Rating rating = new Rating();
		rating.setProduct(product);
		rating.setUser(user);
		rating.setRating(req.getRating());
		rating.setCreatedAt(LocalDateTime.now());

		return ratingRepository.save(rating);

	}

	@Override
	public List<Rating> getProductRating(Long productId) {
		return ratingRepository.getAllProductsRating(productId);
	}

}
