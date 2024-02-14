package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entites.Counsellor;
import com.example.entites.Enquiry;

import com.example.services.EnquiryServiceImp;

import jakarta.servlet.http.HttpSession;

@Controller
public class EnquiryController {
	@Autowired
	private EnquiryServiceImp eservice;
	
	@PostMapping("/saveenquiry")
	public String registerEnquiry(Enquiry enquiry,HttpSession session,Model model) {
		enquiry.setCounsellor((Counsellor)session.getAttribute("counsellor"));
		Enquiry saveEnquiry = eservice.saveEnquiry(enquiry);
		if(saveEnquiry!=null) {
			model.addAttribute("msg","Enquiry Added");
			return "addenquiry";
		}else {
			model.addAttribute("msg","Enquiry failed to added");
			return "addenquiry";
		}
	}
		@GetMapping("/addenquiry")
		public String viewEnquirey(Model model) {
			model.addAttribute("enquiry",new Enquiry());
			return "addenquiry";
		}
	
		
	}

