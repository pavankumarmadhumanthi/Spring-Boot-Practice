package com.example.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	public User findByEmail(String email);

	public User findByEmailAndPassword(String email,String password);

}
