package com.example.Utilites;

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
	public class EmailUtility {
		private String subject="Password";
		private String message="Dont share with anyone!";
	}


