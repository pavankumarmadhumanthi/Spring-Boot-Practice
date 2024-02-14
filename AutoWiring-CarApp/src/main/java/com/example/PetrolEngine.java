package com.example;

import org.springframework.stereotype.Component;

@Component
public class PetrolEngine implements Engine{

	@Override
	public boolean engine() {
		// TODO Auto-generated method stub
		System.out.println("Petrol Engine is started");
		return true;
	}
	

}
