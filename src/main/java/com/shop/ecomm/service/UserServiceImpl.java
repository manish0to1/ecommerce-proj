package com.shop.ecomm.service;

import org.springframework.stereotype.Service;

import com.shop.ecomm.config.JwtProvider;
import com.shop.ecomm.exception.UserException;
import com.shop.ecomm.model.User;
import com.shop.ecomm.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private JwtProvider jwtProvider;

	public UserServiceImpl(UserRepository userRepository, JwtProvider jwtProvider) {

		this.userRepository = userRepository;
		this.jwtProvider = jwtProvider;
	}

	@Override
	public User findUserById(Long userId) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
