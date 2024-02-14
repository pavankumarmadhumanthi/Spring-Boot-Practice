package com.example.restcontrollers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entites.Course;
import com.example.entites.service.CourseService;

@RestController
public class CourseRestController {
	private static Logger logger=LoggerFactory.getLogger(CourseRestController.class);
	
	
	@Autowired
	private CourseService service;
	
	@PostMapping("/save")
	public String saveCourse(@RequestBody Course course) {
		logger.info("Save method is called:: CourseRestController");
		boolean insert= service.insertCourse(course);
		if(insert) {
			return "inserted successfully";
		}else {
			return "failed to insert";
		}
	}
	@PutMapping("/update")
	public String updateCourse(@RequestBody Course course) {
		boolean insert= service.insertCourse(course);
		if(insert) {
			return "inserted successfully";
		}else {
			return "failed to insert";
		}
		
	}
	@DeleteMapping("/delete/{id}")
	public String deleteCourse(@PathVariable("id")Integer id) {
		service.deleteCourse(id);
		return "delete Performed";
	}
	@GetMapping("/courses")
	public List<Course> allCourses(){
		return service.allCourse();
	}
	@GetMapping("/course/{id}")
	public Course findCourse(@PathVariable("id")Integer id) {
		return service.getCourse(id);
		
	}

}
