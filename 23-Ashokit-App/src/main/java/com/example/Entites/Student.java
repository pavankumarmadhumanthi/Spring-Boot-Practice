package com.example.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	private String sname;
	private Long snumber;
	private String sclsmode;
	private String scourse;
	private String sestatus;
	@ManyToOne
	@JoinColumn(name = "counselor_id")
	private Counselor counselor;
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", snumber=" + snumber + ", sclsmode=" + sclsmode
				+ ", scourse=" + scourse + ", sestatus=" + sestatus + "]";
	}
	
	
	

}
