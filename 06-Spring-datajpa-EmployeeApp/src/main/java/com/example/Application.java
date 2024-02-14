package com.example;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		EmployeeRepo bean = context.getBean(EmployeeRepo.class);
		boolean value=true;
		Scanner sc =new Scanner(System.in);
		while(value) {
			System.out.println("operations on the employee table");
			System.out.println("1.To insert new record");
			System.out.println("2.To update employee record");
			System.out.println("3.To delete employee");
			System.out.println("4.To get name of employee");
			System.out.println("5.exit");
			int num=sc.nextInt();
			switch(num) {
			case 1:
			}
			
			
		}

	}

}
