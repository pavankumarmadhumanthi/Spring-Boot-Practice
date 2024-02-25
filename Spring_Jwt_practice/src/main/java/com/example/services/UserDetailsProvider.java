package com.example.services;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.entites.Student;
import com.example.repos.StudentRepo;
@Component
public class UserDetailsProvider implements UserDetailsService{
	@Autowired
	private StudentRepo studentrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Student> student = studentrepo.findByStudentEmail(username);
		if(student.isPresent()) {
			
		Student student1 = student.get();
		return new User(student1.getStudentEmail(),student1.getPassword(),Collections.EMPTY_LIST);
	}else {
		throw new UsernameNotFoundException("Invalid Username");
	}

}
}
