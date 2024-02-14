package com.example.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entites.Counselor;
import com.example.Repositories.CounselorRepo;
@Service
public class CounselorService {
	@Autowired
	private CounselorRepo counselorrepo;
	
	public Optional<Counselor> findCounselor(String name,String password) {
		Optional<Counselor> optional = counselorrepo.findByCemailAndCpassword(name, password);
		return optional;	
	}
	
	public Counselor saveCounselor(Counselor c) {
		
		return counselorrepo.save(c);
		
	}
}
