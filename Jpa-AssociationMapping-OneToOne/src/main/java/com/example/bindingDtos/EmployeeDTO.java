package com.example.bindingDtos;

import com.example.entities.Employee;

import lombok.Data;
@Data
public class EmployeeDTO {

	private Integer empId;
	private String empName;
	private AddressDTO address;

	public EmployeeDTO(Employee employee) {
		super();
		this.empId = employee.getEmpId();
		this.empName = employee.getEmpName();
		if(employee.getAddress()!=null) {
			
		
		this.address = new AddressDTO(employee.getAddress());
	}

}
}
