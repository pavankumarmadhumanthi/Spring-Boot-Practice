package com.example.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entites.Student;
import com.example.repos.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentrepo;

	@Autowired
	private PasswordEncoder encoder;

	public String saveStudent(Student student) {
		if (studentrepo.findByStudentEmail(student.getStudentEmail()) == null) {
			student.setPassword(encoder.encode(student.getPassword()));
			studentrepo.save(student);
			return "Record saved successfully";
		} else {
			return "Email already exists";
		}

	}
	
	public List<Student> findAllStudents(){
		return studentrepo.findAll();
	}

}
