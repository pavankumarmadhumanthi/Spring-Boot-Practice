package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Resturant {
	private Payment pay;
	
	
	@Autowired
	public void setPay(Payment pay) {
		this.pay = pay;
	}



	public void getPayment() {
		boolean done = pay.payment();
		if(done) {
			System.out.println("Payment done successfully");
		}else {
			System.out.println("Payment Failed");
		}
		
	}
	

}
