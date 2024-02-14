package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.User_Info;


public interface UserRepo extends JpaRepository<User_Info, Integer>{
	public User_Info findByEmail(String email);

}
