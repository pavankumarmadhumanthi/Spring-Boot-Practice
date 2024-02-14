package com.example;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;


public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
	
	@Transactional
	@Modifying
	@Query(value="insert into Employee(empid, empname, empphno, empemail) values (:empid, :empname, :empphno, :empemail)",nativeQuery=true)
	void insertEmp(@Param("empid") Integer empid, @Param("empname") String empname, @Param("empphno") Long empphno, @Param("empemail") String empemail);

}