package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entites.Client;
import com.example.repostitories.ClientRepo;
@Service
public class ClientService {
	
	@Autowired
	private ClientRepo repo;
	
	@Autowired
	private PasswordEncoder encoder;

	public String saveClient(Client client) {
		encoder.encode(client.getPassword());
		return repo.save(client)!=null?"success":"failed";
	}
	
	


}
