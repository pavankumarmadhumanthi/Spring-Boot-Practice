package com.example.bindings;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailModel {
	private String subject="Password recovery";
	private String message="Dont share with anyone!";

}