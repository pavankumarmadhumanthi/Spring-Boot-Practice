package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AutoWiringApp1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AutoWiringApp1Application.class, args);
		Car car = context.getBean(Car.class);
		boolean start = car.start();
		if(start) {
			System.out.println("Car is started succefully !"); 
		}
		else {
			System.out.println("car is failed to start");
		}
	}

}
