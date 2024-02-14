package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class DebitPayment implements Payment{

	@Override
	public boolean payment() {
		// TODO Auto-generated method stub
		System.out.println("Payment is done using the debit card");
		return true;
	}
	
	

}
