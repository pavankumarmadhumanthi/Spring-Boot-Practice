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
		OrderRepo order = context.getBean(OrderRepo.class);
		Orders o = new Orders();
		o.setOrderBy("arjun");

		Orders o1 = new Orders();
		o1.setOrderBy("pavan");

		Orders o2 = new Orders();
		o2.setOrderBy("kumar");

		List<Orders> asList = Arrays.asList(o, o1, o2);
		order.saveAll(asList);

		List<Orders> findAll = order.findAll();
		findAll.forEach(System.out::println);

	}

}
