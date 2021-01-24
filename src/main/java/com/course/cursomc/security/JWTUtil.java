package com.course.cursomc.security;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private String expiration;
	
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + Integer.parseInt(expiration)))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}
}
