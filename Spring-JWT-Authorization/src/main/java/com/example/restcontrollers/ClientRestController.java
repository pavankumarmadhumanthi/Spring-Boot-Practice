package com.example.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.configservice.TokenGenerator;
import com.example.entity.Client;
import com.example.services.ClientService;
import com.example.services.UserDetailsServiceProvider;
import com.examples.bindings.UserLoginForm;

public class ClientRestController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceProvider userdetails;
	
	@Autowired
	private ClientService service;
	
	
	
	@PostMapping("/login")
	public String clientLogin(@RequestBody UserLoginForm form) throws Exception {
		 try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(form.getCName(),
	                    		form.getPassword())
	            );
	        } catch (BadCredentialsException e) {
	            throw new Exception("Incorrect username or password", e);
	        }

	        final UserDetails userDetails = userdetails
	                .loadUserByUsername(form.getCName());

	        final String jwt = TokenGenerator.generateToken(userDetails);

		return jwt;
	}
	@PostMapping("/register")
	public Client registerClient(@RequestBody Client client) {
		return service.saveClient(client);
		
	}
	

}
