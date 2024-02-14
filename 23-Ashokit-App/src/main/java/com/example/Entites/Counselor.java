package com.example.Entites;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Counselor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	@NotBlank(message = "Enter name")
	private String cname;
	@NotBlank(message = "Enter email")
	private String cemail;
	@NotBlank(message = "Enter password")
	private String cpassword;
	@NotNull(message = "enter Phone number")
	private Long cphone;

	@OneToMany(mappedBy = "counselor", cascade = CascadeType.ALL)
	private List<Student> students = new ArrayList<>();

	@Override
	public String toString() {
		return "Counselor [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", cpassword=" + cpassword
				+ ", cphone=" + cphone + "]";
	}

	
}
