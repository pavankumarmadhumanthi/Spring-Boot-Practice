package com.example.Services;

import java.util.List;

import com.example.Models.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	public boolean saveProduct(Product product);
	public Product getProductById(Integer productId);
	public void deleteProductById(Integer productId);

}
