package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.Employee;
import com.example.repos.EmployeeRepo;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo repo;
	
	public Employee saveEmployee(Employee college) {
		return repo.save(college);
	}
	
	public List<Employee> getEmployee(){
		return repo.findAll();
	}

}
