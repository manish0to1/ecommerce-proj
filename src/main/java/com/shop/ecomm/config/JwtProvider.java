package com.shop.ecomm.config;

import java.sql.Time;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

@Service
public class JwtProvider {

	public String generatTokString(Authentication auth) {
		
		String jwt = Jwts.builder()
				.setIssuer(new Date())
				.setExpiration(new Date((new Date().getTime()+846000000))
		
		return null;
		
	}
}
