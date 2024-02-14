package com.example.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.bindings.Passenger;
import com.example.bindings.Ticket;
@Service
public class PassengerService {
	public Ticket bookTicket(Passenger p) {
		String apiUrl="http://43.205.144.253:8080/ticket";
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> response = rt.postForEntity(apiUrl,p,Ticket.class);
		return response.getBody();
	}
	public List<Ticket> allTickets(){
		String apiUrl="http://43.205.144.253:8080/tickets";
		RestTemplate rt=new RestTemplate();
		ResponseEntity<Ticket[]> responseEntity = rt.getForEntity(apiUrl,Ticket[].class);
		return Arrays.asList(responseEntity.getBody());
		
	}
}
