package com.example.entities;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Student {
	private Integer id;
	private String name;
	private String email;
}
