package com.example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entites.CourseEntity;

public interface CourseRepo extends JpaRepository<CourseEntity, Integer> {

}
