package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		BookRepository book = context.getBean(BookRepository.class);
		System.out.println(book.getClass());
		Book bk=new Book();
		bk.setBookId(2112);
		bk.setBookName("java");
		bk.setBookPrice(234);
		Book save = book.save(bk);
		System.out.println(save);
		
	}

}
