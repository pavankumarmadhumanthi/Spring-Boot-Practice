package com.example.services;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String username = null;
		String token = null;
		Jws<Claims> claims = null;
		if (request.getHeader("Authorization") != null && request.getHeader("Authorization").startsWith("Bearer ")) {
			token = request.getHeader("Authorization").substring(7);
			claims = Jwts.parserBuilder()
					.setSigningKey("b3f5ddc9e14bc240db9a95d49fe43e3a75576d3734f70a95f9ca4ab99cf21d57").build()
					.parseClaimsJws(token);
			username = claims.getBody().getSubject();
		}
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			if (JwtUtils.isTokenValid(token)) {
				List<SimpleGrantedAuthority> authorities = Arrays.stream(claims.getBody().get("authorities").toString().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
				
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						username,null,authorities);
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
