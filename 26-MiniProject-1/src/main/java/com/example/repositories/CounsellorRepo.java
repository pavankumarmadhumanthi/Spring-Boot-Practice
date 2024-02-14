package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entites.Counsellor;

public interface CounsellorRepo extends JpaRepository<Counsellor, Integer> {
	public Counsellor findByEmailAndPassword(String email, String password);
	public Counsellor findByEmail(String email);

}
