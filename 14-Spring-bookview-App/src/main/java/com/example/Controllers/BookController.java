package com.example.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Books;
import com.example.Services.BookService;

@Controller
public class BookController {
	@Autowired
	public BookService service;
	
	@GetMapping("/books")
	public ModelAndView getBookdata() {
		ModelAndView mv=new ModelAndView();
		List<Books> retrieveBook = service.retrieveBook();
		mv.addObject("books", retrieveBook);
		mv.setViewName("booksview");
		return mv;
	}
	
	@GetMapping("/save")
	public ModelAndView newBook() {
		ModelAndView mv =new ModelAndView();
		mv.addObject("book",new Books());
		mv.setViewName("saveBook");
		return mv;
	}
	
	@PostMapping("/savebook")
	public ModelAndView saveNewBook(Books book) {
		service.saveBook(book);
		ModelAndView mv=new ModelAndView();
		List<Books> retrieveBook = service.retrieveBook();
		mv.addObject("books", retrieveBook);;
		mv.setViewName("booksview");
		return mv;
		
		
	}
	

	

}
