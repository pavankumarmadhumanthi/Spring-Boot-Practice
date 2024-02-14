package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Services.AcceptorService;

import reactor.core.publisher.Mono;

@RestController
public class ServiceAcceptorController {
	@Autowired
	private AcceptorService service;
	@GetMapping("/data")
	public ResponseEntity<String> getData(){
		String providerData = service.getProviderData();
		return new ResponseEntity<>(providerData,HttpStatus.OK);
		
	}
	
	

}
