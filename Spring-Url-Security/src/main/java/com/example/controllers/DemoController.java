package com.example.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	@GetMapping("/contactus")
	public ResponseEntity<String> contacus() {
		return new ResponseEntity<>("+91 9573723234", HttpStatus.OK);
	}

	@GetMapping("/dashboard")
	public ResponseEntity<String> dashboard() {
		return new ResponseEntity<>("Dashboard is called", HttpStatus.OK);
	}

	@GetMapping("/download")
	public ResponseEntity<String> download() {
		return new ResponseEntity<>("Downloading resources", HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<String> home() {
		return new ResponseEntity<>("it is a home page", HttpStatus.OK);
	}

}
