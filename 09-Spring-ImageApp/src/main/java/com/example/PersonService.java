package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	@Autowired
	PersonRepo repo;
	
	public void savePerson(String name,Long phone,byte[] image){
		
		Person p=new Person();
		p.setName(name);
		p.setPhone(phone);
		p.setImage(image);
		repo.save(p);
	}
	public void updatePerson(int id,String name) {
		
		
	}
		
	}
	

