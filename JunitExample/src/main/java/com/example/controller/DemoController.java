package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.services.DemoService;

@Controller
public class DemoController {
	@Autowired
	private DemoService service;
	
	@GetMapping("/welcome")
	public void getMsg() {
		System.out.println("welcome !");
		System.out.println(service.msg());
	}

}
