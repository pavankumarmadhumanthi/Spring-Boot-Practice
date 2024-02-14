package com.example.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.example.Books;
import com.example.Repositories.BookRepo;


@Service
public class BookService {
	@Autowired
	private BookRepo repo;
	
	public Books saveBook(Books book) {
		Books save = repo.save(book);
		return save;
	}
	public List<Books> retrieveBook() {
		
		List<Books> findAll = repo.findAll();
		
		return findAll;
		
	}
}
