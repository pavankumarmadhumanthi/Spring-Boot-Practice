package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceProviderController {
	@GetMapping("/getdata")
	public ResponseEntity<String> getdata(){
		String str ="Hello Everyone How are you?";
		return new ResponseEntity<>(str,HttpStatus.OK);
	}

}
