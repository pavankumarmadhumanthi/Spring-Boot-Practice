package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entites.Client;
import com.example.entites.Product;
import com.example.services.ClientService;
import com.example.services.ProductService;

@RestController
public class ClientController {
	
	@Autowired
	private ClientService cservice;
	
	@Autowired
	private ProductService pservice;
	
	@PostMapping("/saveproduct")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String addProduct(@RequestBody Product product) {
		Product saveProduct = pservice.saveProduct(product);
		return saveProduct!=null?"saved":"failed";
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/getproducts")
	public List<Product> allProducts(){
		return pservice.getProducts();
	}
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/saveclient")
	public String registerClient(@RequestBody Client client) {
		return cservice.saveClient(client);
	}
	

}
