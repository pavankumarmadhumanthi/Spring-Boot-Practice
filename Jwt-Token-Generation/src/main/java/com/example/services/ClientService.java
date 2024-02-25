package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.Client;
import com.example.repos.ClientRepo;
@Service
public class ClientService {
	@Autowired
	private ClientRepo repo;
	
	@Autowired 
	private PasswordEncoder encoder;
	
	public Client saveClient(Client client) {
		client.setPassword(encoder.encode(client.getPassword()));
		return repo.save(client);
	}
	

}
