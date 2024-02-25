package com.example.bindingDtos;

import com.example.entities.Address;

import lombok.Data;
@Data
public class AddressDTO {
	private String city;
	private String state;
	private String country;
	private Integer pincode;
	public AddressDTO(Address address) {
		super();
		this.city = address.getCity();
		this.state = address.getState();
		this.country = address.getCountry();
		this.pincode = address.getPincode();
	}

}
