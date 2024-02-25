package com.example.repostitories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entites.Client;
@Repository
public interface ClientRepo extends JpaRepository<Client, Integer>{
	public Client findByClientName(String name);

}
