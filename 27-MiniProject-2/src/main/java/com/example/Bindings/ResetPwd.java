package com.example.Bindings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResetPwd {
	private Integer id;
	private String password1;
	private String password2;
	

}
