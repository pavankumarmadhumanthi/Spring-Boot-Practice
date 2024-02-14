package com.example;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	private StudentRepo service;
	public StudentService(StudentRepo service){
		this.service=service;
		
	}
	public void sortAllStudent(String id) {
		Sort by = Sort.by(id);
		List<Student1> findAll = service.findAll(by);
		for(Student1 i:findAll) {
			System.out.println(i);
		}
	}
	public void studentPaging(int pageno,int pagesize) {
		PageRequest of = PageRequest.of(pageno-1, pagesize);
		Page<Student1> findAll = service.findAll(of);
		for(Student1 i:findAll) {
			System.out.println(i);
		}
		
	}
	public void queryByExample(Student1 s) {
		Example<Student1> of = Example.of(s);
		List<Student1> findAll = service.findAll(of);
		for(Student1 i:findAll) {
			System.out.println(i);
		}
	}
	


}
