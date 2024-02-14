package com.example.jwtutil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class JwtTokenService {
	
	public String gerenateToken(String username) {
		Map<String,Object> claims=new HashMap();
		return createToken(claims,username);
		
	}

	private String createToken(Map<String, Object> claims, String username) {
		
		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(username)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
				.signWith(SignatureAlgorithm.HS256,getSecKey())
				.compact();
				
	}

	private byte[] getSecKey() {
		
		return null;
	}

}
