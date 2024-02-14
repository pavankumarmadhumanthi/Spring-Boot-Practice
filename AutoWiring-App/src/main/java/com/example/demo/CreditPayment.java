package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class CreditPayment implements Payment {

	@Override
	public boolean payment() {
		// TODO Auto-generated method stub
		System.out.println("Payment is done using the credit card");
		return true;
	}

}
