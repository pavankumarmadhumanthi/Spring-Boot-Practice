package com.example;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RestControllerDemo {
	@GetMapping("/hello")
	public void ObjectToJson() throws Exception, DatabindException, IOException {
		Student s=new Student(101,"pavan","cse");
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(new File("demo.json"), s);
		System.out.println("completed");
	}
	@GetMapping("/convert")
	public void jsonToObject() throws Exception, DatabindException, IOException {
		ObjectMapper mapper =new ObjectMapper();
		Student student = mapper.readValue(new File("demo.json"),Student.class);
		System.out.println(student);		
	}

}
