package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entites.Course;

public interface CourseRepo extends JpaRepository<Course,Integer> {
	

}
