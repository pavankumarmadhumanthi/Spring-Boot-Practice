package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entites.Product;
import com.example.repo.ProductRepo;

@RestController
public class ProductRestController {
	@Autowired
	private ProductRepo repo;
	
	@PostMapping("/register")
	@PreAuthorize("hasRole('ADMIN')")
	public String addProduct(@RequestBody Product product) {
		Product save = repo.save(product);
		return save!=null?"success":"Failed";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/getproduct")
	public Product getProduct(@RequestParam("id") Integer id) {
		return repo.findById(id).get();
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/products")
	public List<Product>getProducts() {
		return repo.findAll();
	}
	@GetMapping("/welcome")
	public String greet() {
		return "hello everyone";
	}
}
