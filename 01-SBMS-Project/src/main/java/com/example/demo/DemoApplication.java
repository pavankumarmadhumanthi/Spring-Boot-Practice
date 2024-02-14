package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
		System.out.println(run.getClass().getName());
		System.out.println(run.getBeanDefinitionCount());
	}
	
	
	@Bean
	public Hello get() {
		Hello h1=null;
		Hello hl=new Hello();
		
		return h1;
	}

}
