package com.shop.ecomm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.ecomm.exception.UserException;
import com.shop.ecomm.model.User;

@RestController
@RequestMapping("/auth")
public class AuthController {

	public ResponseEntity<AuthResponse> createUserHandler(@ResponseBody User user) throws UserException {

		String email = user.getEmail();
		String password = user.getPassword();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();

	}
}
