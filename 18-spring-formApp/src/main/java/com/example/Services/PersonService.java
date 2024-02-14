package com.example.Services;



import java.util.List;

import com.example.Entity.Person;


public interface PersonService {
	public boolean savePerson(Person person);
	public Person getPersonById(String email);
	public List<Person>getAllPersons();
	

}
