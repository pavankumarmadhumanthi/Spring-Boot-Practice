package com.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		StudentRepo bean = context.getBean(StudentRepo.class);
		List<Object[]> projectiondata = bean.getProjectiondata();
		for(Object[] i:projectiondata) {
			System.out.println(Arrays.toString(i));

			
		}

	}

}
