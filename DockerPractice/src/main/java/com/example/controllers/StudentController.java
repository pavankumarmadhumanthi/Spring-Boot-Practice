package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Repository.StudentRepo;
import com.example.entites.Student;

@RestController
public class StudentController {
	@Autowired
	private StudentRepo studentRepo;
	@GetMapping("/getstudents")
	public List<Student> getNames(){
		List<Student> findAll = studentRepo.findAll();
		return findAll;
		
		
	}

}
