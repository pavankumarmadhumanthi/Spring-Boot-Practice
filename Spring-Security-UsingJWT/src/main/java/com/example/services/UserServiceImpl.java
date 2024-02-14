package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entities.User_Info;
import com.example.repos.UserRepo;
@Service
public class UserServiceImpl {
	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private PasswordEncoder encoder;


	public String saveUser(User_Info user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userrepo.save(user);
		return "success";
	}



}
