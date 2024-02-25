package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.entity.StudentRepo;

@RestController
public class TestRestController {
	@Autowired
	private StudentRepo studentrepo;
	
	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return studentrepo.save(student);
	}
	@GetMapping("/alldata")
	public List<Student> findAllStudents(){
		return studentrepo.findAll();
	}

}
