package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person,Integer>{
	@Procedure(value = "person_pro")
	public void updatePerson(@Param("ids")Integer id,@Param("nam")String name);
	
	

}
