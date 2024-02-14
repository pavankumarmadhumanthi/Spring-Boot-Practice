package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entites.Product;
import com.example.repostitories.ProductRepo;
@Service
public class ProductService {
	@Autowired
	private ProductRepo repo;
	
	public  Product saveProduct(Product product) {
		return repo.save(product);
	}
	
	public List<Product> getProducts(){
		return repo.findAll();
	}

}
