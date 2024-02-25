package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
		return student.map(e->new UserInfo(e)).orElseThrow(()->new UsernameNotFoundException("Invalid User Creditionals"));
	}
}

