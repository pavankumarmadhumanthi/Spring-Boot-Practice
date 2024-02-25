package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class College {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer collegeId;
	private String collegeName;
	private Long phoNumber;
	

}
