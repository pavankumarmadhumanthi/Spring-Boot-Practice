package com.example.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Entity.EmailModel;
import com.example.Entity.Person;
import com.example.Services.MailService;
import com.example.Services.PersonServiceImp;

@Controller
public class PersonController {
	@Autowired
	private PersonServiceImp service;
	@Autowired
	private MailService mailservice;

	@GetMapping("/")
	public String viewForm(Model model) {
		model.addAttribute("person", new Person());
		return "index";
	}

	public String allrecords(Model model) {

		return "viewHtml";

	}

	@PostMapping("/register")
	public String register(Person person, Model model) {
		boolean savePerson = service.savePerson(person);

		if (savePerson) {
			mailservice.sendMail(person.getEmail(), new EmailModel("Greetings",
					"Your account is created sucessfully !" + "For further details contact pavankumarmadhumathi"));
			model.addAttribute("msg", "Register succesfull");

		} else {
			model.addAttribute("msg", "Register not successfull");
		}
		model.addAttribute("person", new Person());
		return "index";
	}

	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("person", new Person());
		return "login";
	}

	@PostMapping("/validation")
	public String personLogin(Person person, Model model) {
		Person personById = service.getPersonById(person.getEmail());
		System.out.println(personById);
		if (personById != null && personById.getPassword().equals(person.getPassword())) {

			return "redirect:/all";
		} else {
			model.addAttribute("msg", "Invalid User or Password");
			return "login";
		}
	}

	@GetMapping("/all")
	public String findAllPersons(Model model) {
		List<Person> allPersons = service.getAllPersons();
		model.addAttribute("allPersons", allPersons);
		return "viewAll";

	}
}
