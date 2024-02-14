package com.example.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Models.Product;
import com.example.Repositories.ProductRepo;

@Service
public class ProductServiceImp implements ProductService{
	@Autowired
	private ProductRepo repo;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findByStatus("Y");
	}

	@Override
	public boolean saveProduct(Product product) {
		// TODO Auto-generated method stub
		Product save = repo.save(product);
		if(save!=null) 
			return true;
		else
			return false;
		
	}

	@Override
	public Product getProductById(Integer productId) {
		// TODO Auto-generated method stub
		Optional<Product> findById = repo.findById(productId);
		if(findById.isPresent()) {
			Product product = findById.get();
			return product;
		}else {
			return null;
		}
		
	}

	@Override
	public void deleteProductById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Product> findById = repo.findById(id);
		if(findById.isPresent()) {
			Product product = findById.get();
			product.setStatus("N");
			repo.save(product);
		}
	}

}
