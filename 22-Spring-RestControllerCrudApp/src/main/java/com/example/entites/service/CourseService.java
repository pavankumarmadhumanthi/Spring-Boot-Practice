package com.example.entites.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entites.Course;
import com.example.repositories.CourseRepo;


@Service
public class CourseService {
	@Autowired
	private CourseRepo repo;
	
	public boolean insertCourse(Course course) {
		Course save = repo.save(course);
		if(save!=null) {
			return true;
		}else {
			return false;
		}
	}
	public List<Course> allCourse(){
		return repo.findAll();
	}
	
	public Course getCourse(Integer id) {
		return repo.findById(id).get();
	}
	
	public void deleteCourse(Integer id) {
		repo.deleteById(id);
	}

}
