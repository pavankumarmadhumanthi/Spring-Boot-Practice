package com.example.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import com.example.entites.Client;
import com.example.repostitories.ClientRepo;

@Component
public class UserDetailsProvider implements UserDetailsService{
	
	@Autowired
	private ClientRepo repo;

	   @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        Client user = repo.findByClientName(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found with username: " + username);
	        }
	        return new User(
	            user.getClientName(),
	            user.getPassword(),
	            true,
	            true,
	            true,
	            true,
	            getAuthorities(Arrays.asList(user.getRoles().split(",")))
	        );
	    }

	    private Collection<? extends GrantedAuthority> getAuthorities(Collection<String> roles) {
	        return roles.stream()
	                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
	                .collect(Collectors.toList());
	    }
	
}
