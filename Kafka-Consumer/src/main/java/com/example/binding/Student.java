package com.example.binding;

import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@Data
public class Student {
	private Integer id;
	private String name;
	private String email;

}
