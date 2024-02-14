package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String productName;
	private Double productprice;
	private Integer productQty;
	@CreationTimestamp
	@Column(name = "creationdate", updatable = false)
	private LocalDate creationdate;
	
	@Column(name = "updatedate",insertable = false)
	@UpdateTimestamp
	private LocalDate updatedate;
	
	public Product() {
		
	}
	public Product(String productName, Double productprice, Integer productQty) {
		
		this.productName = productName;
		this.productprice = productprice;
		this.productQty = productQty;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductprice() {
		return productprice;
	}

	public void setProductprice(Double productprice) {
		this.productprice = productprice;
	}

	public Integer getProductQty() {
		return productQty;
	}

	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productprice=" + productprice
				+ ", productQty=" + productQty + "]";
	}
	
	

}
