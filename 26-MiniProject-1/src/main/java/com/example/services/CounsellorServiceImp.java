package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entites.Counsellor;
import com.example.repositories.CounsellorRepo;

@Service
public class CounsellorServiceImp implements CounsellorService{
	@Autowired
	private CounsellorRepo repo;

	@Override
	public Counsellor saveCounsellor(Counsellor counsellor) {
		// TODO Auto-generated method stub
		
		return repo.save(counsellor);
	}

	@Override
	public Counsellor findCounsellor(Counsellor counsellor) {
		// TODO Auto-generated method stub
		
		return repo.findByEmailAndPassword(counsellor.getEmail(),counsellor.getPassword());
	}

}
