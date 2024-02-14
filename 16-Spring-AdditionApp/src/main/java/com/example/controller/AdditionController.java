package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdditionController {
	@GetMapping("/addition")
	public String doAddition(@RequestParam("first") int num1, @RequestParam("second") int num2, Model model) {
		int sum = num1 + num2;
		model.addAttribute("first",num1);
		model.addAttribute("second",num2);
		model.addAttribute("sum", sum);
		return "index";
	}
	@GetMapping("/hello")
	public String sample() {
		
		return "index";
	}

	

}
