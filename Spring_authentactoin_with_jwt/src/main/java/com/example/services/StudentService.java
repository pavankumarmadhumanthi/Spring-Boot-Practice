package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entites.Student;
import com.example.repos.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo studentrepo;

	@Autowired
	private PasswordEncoder encoder1;

	public String saveStudent(Student student) {
		Optional<Student> optionalStudent = studentrepo.findByStudentEmail(student.getStudentEmail());
		if (optionalStudent.isEmpty()) {
			student.setPassword(encoder1.encode(student.getPassword()));
			studentrepo.save(student);
			return "Record saved successfully";
		} else {
			return "Email already exists";
		}

	}
	
	public List<Student> findAllStudents(){
		return studentrepo.findAll();
	}
	
	public Student findStudent(Integer id) {
		return studentrepo.findById(id).get();
	}
	
	public void deleteStudent(Integer id) {
		studentrepo.deleteById(id);
	}

}
