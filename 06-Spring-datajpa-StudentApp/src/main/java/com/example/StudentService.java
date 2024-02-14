package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	public StudentRepo studentRepo;
	
	public StudentService(StudentRepo studentRepo) {
		this.studentRepo=studentRepo;
	}
	
	public void saveStudet() {
		Student s=new Student(101,"pavan","pavan@gmail.com","cse");
		studentRepo.save(s);
	}
	public void saveallStudents() {
		Student s1=new Student(102,"naveen","naveen@gmail.com","cse");
		Student s2=new Student(103,"pavankumar","pavan@gmail.com","mech");
		Student s3=new Student(104,"arjun","arjun@gmail.com","cse");
		ArrayList<Student> al=new ArrayList<>();
		al.add(s1);
		al.add(s2);
		al.add(s3);
		studentRepo.saveAll(al);
	}
	public void findStudent() {
		Optional<Student> id = studentRepo.findById(101);
		if(id.isPresent()) {
			System.out.println(id);
		}
		
	}
	public void findAllStudents() {
		ArrayList<Integer> al=new ArrayList<>();
		al.add(102);
		al.add(103);
		Iterable<Student> all = studentRepo.findAllById(al);
		System.out.println(studentRepo.count());
		
		for(Student i: all) {
			System.out.println(i);
		}
	}
	public void findwithDep(String dep) {
		List<Student> findByDep = studentRepo.findByDep(dep);
		for(Student i :findByDep) {
			System.out.println(i);
		}
	}
	
	public void findwithName(String dep,String name) {
		List<Student> findByDepAndfindByName = studentRepo.findByDepAndName(dep, name);
		System.out.println(findByDepAndfindByName);
	}
	public void findby(String dep) {
		List<Student> students=studentRepo.findByDep(dep);
		for(Student i:students) {
			System.out.println(i);
		}
	}

}
