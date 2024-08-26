package com.shop.ecomm.service;

import com.shop.ecomm.exception.UserException;
import com.shop.ecomm.model.User;

public interface UserService {

	public User findUserById(Long userId) throws UserException;

	public User findUserProfileByJwt(String jwt) throws UserException;
}
