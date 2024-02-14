package com.example.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Models.Product;
import com.example.Services.ProductServiceImp;

@Controller
public class ProductController {
	@Autowired
	private ProductServiceImp service;

	@GetMapping("/products")
	public ModelAndView getProducts() {
		ModelAndView mv = new ModelAndView();
		List<Product> allProducts = service.getAllProducts();
		mv.addObject("products", allProducts);
		mv.setViewName("products.html");
		return mv;
	}

	@GetMapping("/newProduct")
	public ModelAndView saveNewProduct() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", new Product());
		mv.setViewName("newProduct.html");
		return mv;
	}

	@PostMapping("/saveProduct")
	public ModelAndView saveNewProduct(Product product) {
		ModelAndView mv = new ModelAndView();
		product.setStatus("Y");
		boolean saveProduct = service.saveProduct(product);
		if(saveProduct)
			mv.addObject("msg","Record Inserted");
		else
			mv.addObject("msg","Record failed to Insert");
		mv.setViewName("newProduct.html");
		return mv;
	}

	@GetMapping("/update")
	public ModelAndView updateProduct(Product product) {
		ModelAndView mv = new ModelAndView();
		Product productById = service.getProductById(product.getProductId());
		mv.addObject("product", productById);
		mv.setViewName("newProduct.html");
		return mv;
	}

	@GetMapping("/delete")
	public ModelAndView deleteProduct(@RequestParam("productId") Integer productId) {
		ModelAndView mv = new ModelAndView();
		service.deleteProductById(productId);
		List<Product> allProducts = service.getAllProducts();
		mv.addObject("products", allProducts);
		mv.setViewName("products.html");
		return mv;
	}

}
