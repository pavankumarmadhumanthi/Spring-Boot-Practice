package com.example.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Models.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	public List<Product> findByStatus(String s);

}
