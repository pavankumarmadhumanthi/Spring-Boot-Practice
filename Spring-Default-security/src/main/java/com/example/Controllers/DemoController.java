package com.example.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@GetMapping("/greet")
	
	public   ResponseEntity<String> greet() {
		return new ResponseEntity<>("Welcome to application",HttpStatus.OK);
	}

}
