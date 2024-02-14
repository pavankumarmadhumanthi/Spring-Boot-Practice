package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.bindings.Passenger;
import com.example.bindings.Ticket;
import com.example.services.PassengerService;

@Controller
public class ConfromTicketController {
	@Autowired
	private PassengerService service;
	
	@GetMapping("/index")
	public String showForm(Model model) {
		model.addAttribute("passenger",new Passenger());
		return "index";
		
	}
	@PostMapping("/bookticket")
	public String ticketBooking(Passenger passenger ,Model model) {
		Ticket ticket = service.bookTicket(passenger);
		//System.out.println(ticket);
		model.addAttribute("tickets",ticket);
		return "ticket";	
	}
	
	@GetMapping("/tickets")
	public String getTickets(Model model) {
		model.addAttribute("tickets",service.allTickets());
		return "ticket";
	}

}
