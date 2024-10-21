package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Student;

import com.example.services.KafkaProducerService;

@RestController
public class ProducerController {
	@Autowired
	private KafkaProducerService service;
	
	@PostMapping("/register")
	public void getStudent(@RequestBody Student student) {
		String msg = service.sendMessageToTopic(student);
		System.out.println(msg);
	}
	

}
