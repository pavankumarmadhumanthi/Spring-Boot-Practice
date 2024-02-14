package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bindings.Dashboard;
import com.example.bindings.QueryExam;
import com.example.entites.Counsellor;
import com.example.entites.Enquiry;

import com.example.services.CounsellorServiceImp;
import com.example.services.EmailService;
import com.example.services.EnquiryServiceImp;

import jakarta.servlet.http.HttpSession;
@Controller
public class CounsellorController {
	@Autowired
	private CounsellorServiceImp cservice;
	
	@Autowired 
	private HttpSession session;
	
	@Autowired
	private EmailService emailservice;
	
	@Autowired
	private EnquiryServiceImp eservice;
	
	
	

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("counsellor", new Counsellor());
		return "login";
	}
	@PostMapping("/validation")
	public String loginCounsellor(Counsellor counsellor, Model model) {
		Counsellor findCounsellor = cservice.findCounsellor(counsellor);
		if (findCounsellor != null) {
			session.setAttribute("counsellor", findCounsellor);
			return "redirect:/dashboard";
		} else {
			model.addAttribute("msg", "Invalid Credentials");
			return "login";
		}
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("counsellor", new Counsellor());
		return "register";
	}

	@PostMapping("/registration")
	public String registerCounsellor(Counsellor counsellor, Model model) {
		Counsellor saveCounsellor = cservice.saveCounsellor(counsellor);
		if (saveCounsellor!=null) {
			model.addAttribute("msg", "Registration is successful");
			return "register";
		} else {
			model.addAttribute("msg", "Failed to Register");
			return "register";
		}
	}
	@GetMapping("/dashboard")
	public String viewDashboard(Model model) {
		Counsellor counsellor = (Counsellor)session.getAttribute("counsellor");
		Dashboard dashboard = eservice.getDashboard(counsellor);
		model.addAttribute("dashboard", dashboard);
		
		return "dashboard";
	}
	
	@GetMapping("/recoverpwd")
	public String recoverPassword(@RequestParam("email")String email, Model model) {
		boolean getpwd = emailservice.getpwd(email);
		if(getpwd) {
			model.addAttribute("msg","Password send to given email");
		}else {
			model.addAttribute("msg","Invalid email");
		}
		return "forgotpwd";
	}
	@GetMapping("/forgotpwd")
	public String forgetPassword( Model model) {
		return "forgotpwd";
	}
	
	@GetMapping("/enquiries")
	public String viewEnquiries(Model model) {
		List<Enquiry> allEnquiries = eservice.findCousellorEnquiry((Counsellor)session.getAttribute("counsellor"));
		model.addAttribute("Enquiries", allEnquiries);
		model.addAttribute("example",new QueryExam());
		return "viewEnquiries";
	}

	@PostMapping("/queryexam")
	public String viewEnquiries(Model model,QueryExam example) {
		Enquiry e=new Enquiry();
		e.setCounsellor((Counsellor)session.getAttribute("counsellor"));
		e.setMode(example.getMode());
		e.setCourse(example.getCourse());
		e.setStatus(example.getStatus());
		List<Enquiry> allEnquiries = eservice.findByExam(e);
		model.addAttribute("example",e);
		
		model.addAttribute("Enquiries", allEnquiries);
		return "viewEnquiries";
	}
}
