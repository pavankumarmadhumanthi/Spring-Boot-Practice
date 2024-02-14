package com.example;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Orders {
	@Id
	@GenericGenerator(name = "CustomGenerator", type = com.example.CustomGenerator.class)
	@GeneratedValue(generator = "CustomGenerator")
	private String orderId;

	private String orderBy;

	@CreationTimestamp
	@Column(updatable = false)
	private String orderDate;

}
