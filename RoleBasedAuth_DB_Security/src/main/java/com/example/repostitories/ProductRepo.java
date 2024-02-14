package com.example.repostitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entites.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
