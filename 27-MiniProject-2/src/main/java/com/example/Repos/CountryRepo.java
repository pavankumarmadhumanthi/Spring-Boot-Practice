package com.example.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entities.Country;

public interface CountryRepo extends JpaRepository<Country, Integer>{

}
