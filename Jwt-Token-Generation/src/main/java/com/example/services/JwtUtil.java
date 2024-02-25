package com.example.services;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtUtil {

	private static final String SECRET_KEY = "952dfe491480ca16ad6c1c8d51cab173f39ddfd5a4be43c789185e1bfa4e1649";
	private static final long EXPIRATION_TIME = 864000000; // 10 days

	public static String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
	}

	public static boolean validateToken(String token, UserDetails userDetails) {
		final String tokenUsername = extractUsername(token);
		return (tokenUsername.equals(userDetails) && !isTokenExpired(token));
	}

	private static boolean isTokenExpired(String token) {
		final Date expiration = extractExpiration(token);
		return expiration.before(new Date());
	}

	static String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	private static Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	private static <T> T extractClaim(String token, ClaimsResolver<T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private static Claims extractAllClaims(String token) {
		return  Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
		
	}
	
	
}
