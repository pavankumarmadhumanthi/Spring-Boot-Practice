package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		ProductRepo repo = context.getBean(ProductRepo.class);
		Product product=new Product("java",850.00,77);
		
		
		product.setProductId(1);
		repo.save(product);
		
	}

}
