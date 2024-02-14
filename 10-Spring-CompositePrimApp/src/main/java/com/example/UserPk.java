package com.example;

import org.springframework.stereotype.Component;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPk {
	private Integer userId;
	private Long userPhone;
	
	

}
