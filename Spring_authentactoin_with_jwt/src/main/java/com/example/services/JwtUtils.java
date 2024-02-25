package com.example.services;

import java.util.Date;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {
	private static final String secrectKey = "b3f5ddc9e14bc240db9a95d49fe43e3a75576d3734f70a95f9ca4ab99cf21d57";
	private static final Integer expireTime = 864000;

	public static String generateJwtToken(String username,UserDetails userdetails) {
		return Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + expireTime))
				.claim("authorities",userdetails.getAuthorities().toString())
				.signWith(SignatureAlgorithm.HS256, secrectKey).compact();
	}

	public static boolean isTokenValid(String token) {
		try {
			Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(secrectKey).build().parseClaimsJws(token);
			Date date = claims.getBody().getExpiration();
			Date now = new Date(System.currentTimeMillis());

			if (date != null && !date.before(now)) {
				return true;
			}
		} catch (JwtException e) {

		}
		return false;

	}

	public static Authentication getAuth(String token) {
		Claims payload = Jwts.parserBuilder().setSigningKey(secrectKey).build().parseClaimsJws(token).getBody();

		String subject = payload.getSubject();
		return new UsernamePasswordAuthenticationToken(subject, token);
	}

}
