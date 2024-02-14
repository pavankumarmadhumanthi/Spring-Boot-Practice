package com.example.Entities;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String username;
	private String password;
	private String pwdstatus;

	@Column(unique = true)
	private String email;
	private Long phone;
	private String country;
	private String state;
	private String city;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Date createdon;
	
	
	@UpdateTimestamp
	@Column(insertable = false)
	private Date updatedon;
	

}
