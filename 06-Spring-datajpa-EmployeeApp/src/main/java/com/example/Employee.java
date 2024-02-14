package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Employee {
	
	@Id

	int empid;
	String empname;
	Long empphno;
	String empemail;
	
	
	public Integer getEmpid() {
		return empid;
	}


	public void setEmpid(Integer empid) {
		this.empid = empid;
	}


	public String getEmpname() {
		return empname;
	}


	public void setEmpname(String empname) {
		this.empname = empname;
	}


	public Long getEmpphno() {
		return empphno;
	}


	public void setEmpphno(Long empphno) {
		this.empphno = empphno;
	}


	public String getEmpemail() {
		return empemail;
	}


	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empid + ", empname=" + empname + ", empphno=" + empphno + ", empemail=" + empemail
				+ "]";
	}
	
	

}
