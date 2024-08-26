package com.shop.ecomm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.ecomm.config.JwtProvider;
import com.shop.ecomm.exception.UserException;
import com.shop.ecomm.model.User;
import com.shop.ecomm.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private UserRepository userRepository;

	private JwtProvider jwtProvider;

	public AuthController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ResponseEntity<AuthResponse> createUserHandler(@ResponseBody User user) throws UserException {

		String email = user.getEmail();
		String password = user.getPassword();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();

		User isEmailExist = userRepository.findByEmail(email);

		// check for if email already exist then
		if (isEmailExist != null) {
			throw new UserException("Email is already used with another account !");
		}

		// other wise create new user with required information
		User createdUser = new User();
		createdUser.setEmail(email);
		createdUser.setPassword(password);
		createdUser.setFirstName(firstName);
		createdUser.setLastName(lastName);

		User savedUser = userRepository.save(createdUser); // user saved

		Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtProvider.generatToken(authentication);
	}
}
