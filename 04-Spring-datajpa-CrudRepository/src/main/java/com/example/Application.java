package com.example;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		StudentRepo student = context.getBean(StudentRepo.class);
//		
		student.save(new Student1 (108,"bhanu kumar",5444337L,"bhanukumar@gmail.com"));
//		
//		Iterable<Student1> findAll = student.findAll();
//		for(Student1 i:findAll) {
//			System.out.println(i);
//		}
//		Optional<Student1> findById = student.findById(101);
//		if(findById.isPresent()) {
//			System.out.println(findById);
//		}
//		System.out.println(student.count());
		
		
//		StudentService bean = context.getBean(StudentService.class);
//		bean.sortAllStudent("name");
		
//		StudentService bean = context.getBean(StudentService.class);
//		bean.studentPaging(2,3);
		
//		StudentService bean = context.getBean(StudentService.class);
//			Student1 s=new Student1();
//			s.setId(101);
//			bean.queryByExample(s);
	}
	

}
