package com.example.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Person;
import com.example.Repo.PersonRepo;

@Service
public class PersonServiceImp implements PersonService {
	@Autowired
	private PersonRepo repo;

	public boolean savePerson(Person person) {
		Person save = repo.save(person);
		if (save != null) {
			return true;
		} else
			return false;

	}



	@Override
	public Person getPersonById(String email) {
		// TODO Auto-generated method stub
		Optional<Person> findById = repo.findById(email);
		if (findById.isPresent()) {
			Person person = findById.get();
			return person;
		} else {
			return null;
		}

	}



	@Override
	public List<Person> getAllPersons() {
		
		return repo.findAll();
	}

}
