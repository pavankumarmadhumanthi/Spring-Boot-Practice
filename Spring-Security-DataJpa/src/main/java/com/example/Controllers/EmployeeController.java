package com.example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bindings.LoginData;
import com.example.Entities.Employee;
import com.example.Services.EmployeeServiceImp;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeServiceImp service;

	@Autowired
	private AuthenticationManager manager;
	


	@PostMapping("/register")
	public String registerEmpolyee(@RequestBody Employee emp) {
		
		return service.saveEmploye(emp) != null ? "success" : "Failed";
	}

	@PostMapping("/login")
	public ResponseEntity<String> validation(@RequestBody LoginData data) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(data.getEmail(),
				data.getPassword());
		
		try {
			Authentication authenticate = manager.authenticate(token);
			if (authenticate.isAuthenticated())
				return new ResponseEntity<>("Success", HttpStatus.OK);
		} catch (Exception e) {
		}
		return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/welcome")
	public String getData() {
		return "welcome";
	}

}
