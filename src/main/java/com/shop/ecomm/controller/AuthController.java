package com.shop.ecomm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.ecomm.config.JwtProvider;
import com.shop.ecomm.exception.UserException;
import com.shop.ecomm.model.User;
import com.shop.ecomm.repository.UserRepository;
import com.shop.ecomm.request.LoginRequest;
import com.shop.ecomm.response.AuthResponse;
import com.shop.ecomm.service.CustomUserServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {

	// instances
	private UserRepository userRepository;
	private JwtProvider jwtProvider;
	private PasswordEncoder passwordEncoder;
	private CustomUserServiceImpl customUserService;

	public AuthController(UserRepository userRepository, CustomUserServiceImpl customUserService,
			PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
		this.userRepository = userRepository;
		this.customUserService = customUserService;
		this.passwordEncoder = passwordEncoder;
		this.jwtProvider = jwtProvider;
	}

//	// sign up method
//	@PostMapping("/sign up")
//	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {
//
//		String email = user.getEmail();
//		String password = user.getPassword();
//		String firstName = user.getFirstName();
//		String lastName = user.getLastName();
//
//		User isEmailExist = userRepository.findByEmail(email);
//
//		// check for if email already exist then
//		if (isEmailExist != null) {
//			throw new UserException("Email is already used with another account !");
//		}
//
//		// other wise create new user with required information
//		User createdUser = new User();
//		createdUser.setEmail(email);
//		createdUser.setPassword(passwordEncoder.encode(password));
//		createdUser.setFirstName(firstName);
//		createdUser.setLastName(lastName);
//
//		User savedUser = userRepository.save(createdUser); // user saved
//
//		Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),
//				savedUser.getPassword());
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//
//		String token = jwtProvider.generatToken(authentication);
//
//		AuthResponse authResponse = new AuthResponse();
//		((AuthResponse) authentication).setJwt(token);
//		((AuthResponse) authentication).setMessage("Signup Successfully.");
//
//		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
//	}

	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {

		String email = user.getEmail();
		String password = user.getPassword();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();

		// Check if email already exists
		User isEmailExist = userRepository.findByEmail(email);
		if (isEmailExist != null) {
			throw new UserException("Email is already used with another account!");
		}

		// Create a new user
		User createdUser = new User();
		createdUser.setEmail(email);
		createdUser.setPassword(passwordEncoder.encode(password));
		createdUser.setFirstName(firstName);
		createdUser.setLastName(lastName);

		User savedUser = userRepository.save(createdUser);

		// Authenticate the user
		Authentication authentication = new UsernamePasswordAuthenticationToken(savedUser.getEmail(),
				savedUser.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Generate JWT token
		String token = jwtProvider.generatToken(authentication);

		// Create the response object
		AuthResponse authResponse = new AuthResponse();
		authResponse.setJwt(token);
		authResponse.setMessage("Signup Successfully.");

		return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
	}

	// login method
	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> loginUserHandler(@RequestBody LoginRequest loginRequest) {

		String username = loginRequest.getEmail();
		String password = loginRequest.getPassword();

		Authentication authentication = authenticate(username, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtProvider.generatToken(authentication);
		AuthResponse authResponse = new AuthResponse(token, "Signin Successfully.");

		return new ResponseEntity<AuthResponse>(authResponse, HttpStatus.CREATED);
	}

	private Authentication authenticate(String username, String password) {

		UserDetails userDetails = customUserService.loadUserByUsername(username);

		if (userDetails == null) {
			throw new BadCredentialsException("Invalid Username...!");
		}
		if (!passwordEncoder.matches(password, userDetails.getPassword())) {
			throw new BadCredentialsException("Invalid Password...!");
		}
		return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

	}
}
