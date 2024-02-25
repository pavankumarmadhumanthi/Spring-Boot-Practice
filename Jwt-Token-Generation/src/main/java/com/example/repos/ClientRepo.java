package com.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Client;

public interface ClientRepo extends JpaRepository<Client, Integer>{
	public Client findByCname(String name);

}
