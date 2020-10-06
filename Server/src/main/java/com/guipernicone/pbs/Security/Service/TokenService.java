package com.guipernicone.pbs.Security.Service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.guipernicone.pbs.User.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${jwt.expiration}")
	private String expiration;
	
	@Value("${jwt.secret}")
	private String secret;
	
	public String generateToken(Authentication authentication) {
		User user = ( User ) authentication.getPrincipal();
		
		Date today = new Date();
		Date expirationDate = new Date(today.getTime() + Long.parseLong(expiration));
				
		return Jwts.builder()
				.setIssuer("Pokemon Battle Simulator")
				.setSubject(user.getId())
				.setIssuedAt(today)
				.setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

}
