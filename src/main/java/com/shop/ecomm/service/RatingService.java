package com.shop.ecomm.service;

import java.util.List;

import com.shop.ecomm.exception.ProductException;
import com.shop.ecomm.model.Rating;
import com.shop.ecomm.model.User;
import com.shop.ecomm.request.RatingRequest;

public interface RatingService {

	public Rating createRating(RatingRequest req, User user) throws ProductException;

	public List<Rating> getProductRating(Long productId);

}
