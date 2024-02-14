package com.example.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entities.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	public Employee findByEmail(String email);

}
