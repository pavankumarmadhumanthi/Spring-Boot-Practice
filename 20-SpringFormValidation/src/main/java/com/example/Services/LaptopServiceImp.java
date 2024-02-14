package com.example.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entites.Laptop;
import com.example.Repositories.LaptopRepo;
@Service
public class LaptopServiceImp implements LaptopService{
	@Autowired
	private LaptopRepo repo;

	@Override
	public boolean saveLaptop(Laptop laptop) {
		repo.save(laptop);
		return false;
	}

}
