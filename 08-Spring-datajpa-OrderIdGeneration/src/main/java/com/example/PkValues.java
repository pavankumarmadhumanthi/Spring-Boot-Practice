package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pk_val")
public class PkValues {

	@Id
	private Integer orderid;
}
