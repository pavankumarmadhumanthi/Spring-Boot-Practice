package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	@GetMapping("/hello")
	public String demo() {
		return "index";
	}
	
	
@PostMapping("/addition")
@ResponseBody
public String data(@RequestParam("first")Integer first,@RequestParam("second") Integer second) {
	int sum=first+second;
	return String.valueOf(sum);
	
}
}
