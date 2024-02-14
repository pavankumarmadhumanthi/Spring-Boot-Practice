package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;

public interface StudentRepo extends CrudRepository<Student,Integer>{
	public List<Student> findByDep(String dep);
	
	public List<Student> findByDepAndName(String dep,String name);
	
	@Query("From Student where dep = :dep")
	public List<Student> m(String dep);
	

	@Query("select id  from Student")
	public List<Integer> getdata();
	
	
	@Query("select id,name from Student")
	public List<Object[]> getProjectiondata();
	

}
