package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo emprepo;
	
	@Autowired
	private AddressRepo addressrepo;
	
	@Transactional(rollbackOn=Exception.class)
	
	public void saveEmployee() {
		Employee emp=new Employee();
		emp.setEmpName("naveen");
		emp.setEmpSalary(4520.00);
		Employee save = emprepo.save(emp);
		
		Address add=new Address();
		add.setId(save.getEmpId());
		add.setStreet("vizag");
		add.setState("AndhraPradesh");
		add.setPin(531026);
		addressrepo.save(add);
		
	
		
		
	}

}
