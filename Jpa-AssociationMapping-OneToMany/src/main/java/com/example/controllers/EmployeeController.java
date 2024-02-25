package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Address;
import com.example.entities.Employee;
import com.example.repos.AddressRepo;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired 
	private AddressRepo addressrepo;
	
	@PostMapping("/register")
	public Employee addCollege(@RequestBody Employee college) {
		return service.saveEmployee(college);
	}
	
	@GetMapping("/getall")
	public List<Employee> getColleges(){
		return service.getEmployee();
	}
	@PostMapping("/addaddress")
	public Address addAddress(@RequestBody Address address) {
		return addressrepo.save(address);
	}

}
