package com.example.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bindings.UserLogin;
import com.example.entities.User_Info;
import com.example.services.UserServiceImpl;

@RestController
public class User_InfoController {
	@Autowired
	private UserServiceImpl service;
	
	@Autowired
	private AuthenticationManager manager;
	
	
	
	@GetMapping("/user")
	public String getUser(@RequestParam("id")Integer id) {
		return  "Hi user";
		
	}
	@PostMapping("/logins")
	public String validation(@RequestBody UserLogin login) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login.getUseremail(), login.getPassword());
		Authentication authenticate = manager.authenticate(token);
		if(authenticate.isAuthenticated()) {
			return "success";
		}else {
			return "failed";
		}
	}

	@PostMapping("/register")
	public String userRegister(@RequestBody User_Info user) {
		String saveUser = service.saveUser(user);
		return saveUser!=null?"registered":"failed";
	}

}
