package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.binding.UserData;
import com.example.entites.Client;
import com.example.repostitories.ClientRepo;
@Component
public class UserDetailsProvider implements UserDetailsService{
	
	@Autowired
	private ClientRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Client> client = repo.findByClientname(username);
		
		return client.map(UserData::new).orElseThrow(()-> new UsernameNotFoundException(username));
	}
	

}
