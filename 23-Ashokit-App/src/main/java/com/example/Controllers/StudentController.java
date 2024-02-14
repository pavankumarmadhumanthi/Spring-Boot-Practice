package com.example.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Entites.Counselor;
import com.example.Entites.Student;
import com.example.Services.StudentService;

import jakarta.servlet.http.HttpSession;
@Controller
public class StudentController {
	private static final String Counselor = null;

	@Autowired
	private StudentService sservice;
	
	@Autowired
	private HttpSession session;

	@GetMapping("/home")
	public String getAllEntries(Model model, HttpSession session) {
		
		Counselor counselor = (Counselor) session.getAttribute("counselor");
		
		int total = sservice.countStudents("New",counselor.getCid());
		int enrolled = sservice.countStudents("Enrolled",counselor.getCid());
		int lost = sservice.countStudents("Lost",counselor.getCid());
		model.addAttribute("total",total);
		model.addAttribute("enrolled",enrolled);
		model.addAttribute("lost",lost);
		session.setAttribute("counselor", counselor);
		return "home";
		
	}
	
	@GetMapping("/addstudent")
	public String studentForm(Model model,HttpSession session) {
		model.addAttribute("student",new Student());
		return "studentForm";
	}
	@PostMapping("/registerstudent")
	public String saveStudent(Student student,Model model,HttpSession session) {
		Counselor counselor = (Counselor) session.getAttribute("counselor");
		System.out.println(counselor);
		student.setCounselor(counselor);
		Student saveStudent = sservice.saveStudent(student);
		System.out.println(student);
		if(saveStudent!=null) {
			model.addAttribute("msg","Student added successfully");
			return "studentForm";
		}else {
			model.addAttribute("msg","failed to insert");
			return "studentForm";
		}
	}
	@GetMapping("/students")
	public String allStudents(Model model,HttpSession session) {
		
		List<Student> allStudents = sservice.getAllStudents((Counselor)session.getAttribute("counselor"));
		model.addAttribute("students", allStudents);
		return "studentsview";
		
	}
}
