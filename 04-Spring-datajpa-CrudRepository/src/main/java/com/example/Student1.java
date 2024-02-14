package com.example;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student1 {
	@Id
	private Integer id;
	private String name;
	private Long phno;
	private String email;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate creationdate;
	
	
	@UpdateTimestamp
	@Column(insertable = true)
	private LocalDate updatedate;
	
	public LocalDate getCreationdate() {
		return creationdate;
	}


	public void setCreationdate(LocalDate creationdate) {
		this.creationdate = creationdate;
	}


	public LocalDate getUpdatedate() {
		return updatedate;
	}


	public void setUpdatedate(LocalDate updatedate) {
		this.updatedate = updatedate;
	}


	public Student1() {
		
	}
	

	public Student1(Integer id, String name, Long phno, String email) {
		this.id = id;
		this.name = name;
		this.phno = phno;
		this.email = email;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student1 [id=" + id + ", name=" + name + ", phno=" + phno + ", email=" + email + "]";
	}
	
	

}
