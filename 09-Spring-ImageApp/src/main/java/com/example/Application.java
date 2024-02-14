package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.services.ExcelService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context
		= SpringApplication.run(Application.class, args);
		
//		File f=new File("C:\\Users\\pavan\\Downloads\\virat.jpeg");
//		FileInputStream fis= new FileInputStream(f);
//		byte[] image = fis.readAllBytes();
//		PersonService service = context.getBean(PersonService.class);
//		service.savePerson("Raju",464546467L, image);
//		PersonRepo person = context.getBean(PersonRepo.class);
//		person.updatePerson(1,"pavan");
		ExcelService bean = context.getBean(ExcelService.class);
		bean.generateExcel();
	}

}
