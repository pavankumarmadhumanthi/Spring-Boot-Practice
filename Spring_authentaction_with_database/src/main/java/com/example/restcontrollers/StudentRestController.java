package com.example.restcontrollers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bindings.LoginForm;
import com.example.entites.Student;
import com.example.services.StudentService;

@RestController
public class StudentRestController {
	@Autowired
	private StudentService studentservice;

	
	
	
	@PostMapping("/register")
	public String addStudent(@RequestBody Student student) {
	
		return studentservice.saveStudent(student);
	}
	@GetMapping("/getall")
	public List<Student> getAllStudents(){
		return studentservice.findAllStudents();
	}

	
}
