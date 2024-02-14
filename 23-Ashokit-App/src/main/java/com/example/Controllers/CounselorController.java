package com.example.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Entites.Counselor;
import com.example.Entites.Student;
import com.example.Services.CounselorService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CounselorController {
	@Autowired
	private CounselorService service;
	
	@Autowired
	private HttpSession session;

	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("counselor", new Counselor());
		return "register";
	}

	@PostMapping("/registration")
	public String registerCounselor(Counselor c, Model model) {
		Counselor saveCounselor = service.saveCounselor(c);
		if (saveCounselor != null) {
			model.addAttribute("msg", "Registration successfull");
		} else {
			model.addAttribute("msg", "Registration failed");
		}
		return "register";

	}

	@GetMapping("/index")
	public String loginForm(Model model) {
		model.addAttribute("counselor", new Counselor());
		return "index";
	}

	@PostMapping("/validation")
	public String loginCouselor(Model model, Counselor c) {
		 Optional<Counselor> findCounselor = service.findCounselor(c.getCemail(), c.getCpassword());
		if (findCounselor.isPresent()) {
			session.setAttribute("counselor",findCounselor.get());
			System.out.println(findCounselor.get());
			return "redirect:/home";
			
		} else {
			model.addAttribute("msg", "Invalid creditinals");
			return "index";
		}
	}
//	@GetMapping("/{id}")
//	public void print(@PathVariable("cid")Integer id) {
//		Counselor c=new Counselor();
//		c.setCid(id);
//	};
}
