package com.shop.ecomm.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class AppConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				// Set session management to state less
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(authorize -> authorize.requestMatchers("/api/**").authenticated() // Protect
																											// /api/**
																											// endpoints
						.anyRequest().permitAll() // Allow all other requests
				).addFilterBefore(new JwtValidator(), BasicAuthenticationFilter.class) // Add JWT filter
				.csrf(csrf -> csrf.disable()) // Disable CSRF
				.cors(cors -> cors.configurationSource(corsConfigurationSource())) // Apply CORS configuration
				.httpBasic(withDefaults()) // Enable HTTP Basic Authentication
				.formLogin(withDefaults()); // Enable form-based login

		return http.build();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		return request -> {
			CorsConfiguration cfg = new CorsConfiguration();

			cfg.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200")); // Allowed origins
			cfg.setAllowedMethods(Collections.singletonList("*")); // Allow all HTTP methods
			cfg.setAllowCredentials(true); // Allow credentials
			cfg.setAllowedHeaders(Collections.singletonList("*")); // Allow all headers
			cfg.setExposedHeaders(Arrays.asList("Authorization")); // Expose Authorization header
			cfg.setMaxAge(3600L); // Cache CORS configuration for 1 hour

			return cfg;
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

// ###################################### Original ################################################### //
//package com.shop.ecomm.config;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//@Configuration
//public class AppConfig {
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		// Set session management to state less
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//				.authorizeHttpRequests(
//						Authorize -> Authorize.requestMatchers("/api/**").authenticated().anyRequest().permitAll())
//				.addFilterBefore(new JwtValidator(), BasicAuthenticationFilter.class).csrf().disable().cors()
//				.configurationSource(new CorsConfigurationSource() {
//
//					@Override
//					public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//
//						CorsConfiguration cfg = new CorsConfiguration();
//
//						cfg.setAllowedOrigins(Arrays.asList("http://localhost:3000", // react local host
//								"http://localhost:4200" // angular local host
//						));
//						cfg.setAllowedMethods(Collections.singletonList("*"));
//						cfg.setAllowCredentials(true);
//						cfg.setAllowedHeaders(Collections.singletonList("*"));
//						cfg.setExposedHeaders(Arrays.asList("Authorization"));
//						cfg.setMaxAge(3600L);
//						return cfg;
//					}
//				}).and().httpBasic().and().formLogin();
//
//		return http.build();
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//
//		return new BCryptPasswordEncoder();
//	}
//}
