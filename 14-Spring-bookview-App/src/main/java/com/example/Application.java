package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//		BookService service = context.getBean(BookService.class);
//		Books b=new Books();
//		b.setBookName("Adv-java");
//		b.setBookPrice(555.00);
//		service.saveBook(b);
	}

}
