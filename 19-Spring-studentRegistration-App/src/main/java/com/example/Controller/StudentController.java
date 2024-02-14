package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Entites.CourseEntity;
import com.example.Entites.Student;
import com.example.Repositories.CourseRepo;
import com.example.Service.StudentServiceImp;

@Controller
public class StudentController {
	@Autowired
	private StudentServiceImp service; 
	@Autowired
	private CourseRepo course;
	
	@GetMapping("/index")
	public String registerForm(Model model) {
		model.addAttribute("student",new Student());
		List<CourseEntity> courses = course.findAll();
		model.addAttribute("courses", courses);
		return "index";
	}
	@PostMapping("/register")
	public String saveStudent(Student student,Model model) {
		boolean value = service.saveStudent(student);
		if(value) {
			model.addAttribute("msg","Register successfull");
		}else {
			model.addAttribute("msg","Register Failed");
		}
		return "redirect:/index";	
	}
}
