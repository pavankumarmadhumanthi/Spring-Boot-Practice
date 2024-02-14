package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	private Engine eng;

	@Autowired
	public Car(Engine eng) {
		this.eng = eng;
	}

	public boolean start() {

		System.out.println("Car engine is starting");
		if (eng != null) {
			return true;
		} else {
			return false;
		}
	}

}
