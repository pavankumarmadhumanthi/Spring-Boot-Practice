package com.example.Bindings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterForm {

	private String username;
	private String email;
	private Long phone;
	private String country;
	private String state;
	private String city;

}
