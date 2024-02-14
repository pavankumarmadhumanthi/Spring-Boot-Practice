package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entites.Student;
import com.example.Repositories.StudentRepo;

@Service
public class StudentServiceImp implements StudentService{
	@Autowired
	private StudentRepo repo;

	@Override
	public boolean saveStudent(Student student) {
		repo.save(student);
		
		return false;
	}

}
