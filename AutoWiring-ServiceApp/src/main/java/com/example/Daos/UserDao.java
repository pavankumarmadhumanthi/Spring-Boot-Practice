package com.example.Daos;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	public boolean insertRecord() {
		System.out.println("Record inserted successfully");
		return true;
		
	}

}
