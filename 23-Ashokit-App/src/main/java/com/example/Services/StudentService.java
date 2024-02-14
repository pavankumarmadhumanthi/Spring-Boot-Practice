package com.example.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.Entites.Counselor;

import com.example.Entites.Student;
import com.example.Repositories.StudentRepo;
@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentrepo;
	
	public Student saveStudent(Student student) {
		return studentrepo.save(student);
	}
	public int countStudents(String s,Integer sid) {
		return studentrepo.countBySestatusAndSid(s,sid);
		
	}
	
	public List<Student> getAllStudents(Counselor con){
		return studentrepo.findByCounselor(con);
	}
	

}
