package com.example.services;

import org.springframework.security.core.userdetails.User;

public interface UserService {
	public String saveUser(User user);
	public User getUser(Integer userid);

}
