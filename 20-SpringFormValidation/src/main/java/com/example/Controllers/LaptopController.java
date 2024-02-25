package com.example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Entites.Laptop;
import com.example.Services.LaptopServiceImp;

import jakarta.validation.Valid;
@Controller
public class LaptopController {
	@Autowired
	private LaptopServiceImp service; 
	@GetMapping("/index")
	public String view(Model model) {
		model.addAttribute("laptop",new Laptop());
		return "index";
	}
	@PostMapping("/validate")
	public String validateLaptop(@Valid Laptop laptop,BindingResult result,Model model) {
		if (result.hasErrors()) {
	        return "index";
	    }
		else {
			service.saveLaptop(laptop);
			model.addAttribute("msg","record inserted");
			
		return "redirect:/index";
	}
	}
	@PostMapping("/register")
	public String registerLaptop(Laptop laptop) {
		service.saveLaptop(laptop);
		return "redirect:/index";
	}
		
}
