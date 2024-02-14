package com.example.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entites.Counselor;

public interface CounselorRepo extends JpaRepository<Counselor, Integer> {
	  public Optional<Counselor> findByCemailAndCpassword(String name, String status);

}
