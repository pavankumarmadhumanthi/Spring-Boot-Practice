package com.example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Bindings.Dashboard;
import com.example.Services.DashboardServiceImp;

@Controller
public class DashboardController {
	@Autowired
	private DashboardServiceImp dashboardservice;
	
	@GetMapping("/dishboardview")
	public String showDashboard(Model model) {
		Dashboard quote = dashboardservice.getQuote();
		model.addAttribute("quote", quote.getText());
		return "dashboard";
		}

}
