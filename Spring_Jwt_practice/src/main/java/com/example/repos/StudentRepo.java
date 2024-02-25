package com.example.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entites.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	public Optional<Student> findByStudentEmail(String email);

}
