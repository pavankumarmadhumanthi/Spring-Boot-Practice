package com.example.entites;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Long number;

	@CreationTimestamp
	@Column(name = "date", updatable = false)
	private Date date;

	private String course;
	private String mode;
	private String status;
	@ManyToOne
	@JoinColumn(name = "counsellor_id")
	private Counsellor counsellor;
	@Override
	public String toString() {
		return "Enquiry [id=" + id + ", name=" + name + ", number=" + number + ", date=" + date + ", course=" + course
				+ ", mode=" + mode + ", status=" + status + ", counsellor=" + counsellor + "]";
	}
	
	

}
