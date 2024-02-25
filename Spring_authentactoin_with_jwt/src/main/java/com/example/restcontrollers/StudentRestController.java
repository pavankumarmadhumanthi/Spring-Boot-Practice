package com.example.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bindings.LoginForm;
import com.example.entites.Student;
import com.example.services.JwtUtils;
import com.example.services.StudentService;

@RestController
public class StudentRestController {
	@Autowired
	private StudentService studentservice;

	@Autowired
	private AuthenticationManager manager;

	@PostMapping("/register")
	public String addStudent(@RequestBody Student student) {
		return studentservice.saveStudent(student);
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/getall")
	public List<Student> getAllStudents() {
		return studentservice.findAllStudents();
	}

	@PostMapping("/login")
	public String getJwsToken(@RequestBody LoginForm form) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(form.getStudentEmail(),
				form.getPassword());
		Authentication authenticate = manager.authenticate(token);
		if (authenticate.isAuthenticated()) {
			UserDetails principal =(UserDetails)authenticate.getPrincipal();
			return JwtUtils.generateJwtToken(form.getStudentEmail(),principal);
		} else {
			return "Invalid user";
		}
	}
	@PreAuthorize("hasAuthority('ROLE_USER')")
	@GetMapping("/get")
	public Student getStudent(@RequestParam("id") Integer studentid) {
		return studentservice.findStudent(studentid);
	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("id") Integer studentid) {
		studentservice.deleteStudent(studentid);
		return "redirect:/getall";
	}

}
