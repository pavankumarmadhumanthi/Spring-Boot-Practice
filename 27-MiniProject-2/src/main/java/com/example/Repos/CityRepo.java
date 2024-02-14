package com.example.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entities.City;

public interface CityRepo extends JpaRepository<City, Integer>{

	List<City> findBySid(Integer stateid);

}
