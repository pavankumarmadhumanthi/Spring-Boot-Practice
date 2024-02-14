package com.example.Services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Entities.Employee;
import com.example.Repos.EmployeeRepo;

@Service
public class EmployeeServiceImp {
	@Autowired
	private EmployeeRepo repo;

	@Autowired
	private PasswordEncoder encode;

	public Employee saveEmploye(Employee emp) {
		emp.setPassword(encode.encode(emp.getPassword()));
		return repo.save(emp);
	}
}