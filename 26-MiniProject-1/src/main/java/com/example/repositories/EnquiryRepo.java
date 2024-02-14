package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.example.entites.Counsellor;
import com.example.entites.Enquiry;

public interface EnquiryRepo extends JpaRepository<Enquiry, Integer>, QueryByExampleExecutor<Enquiry> {
	public List<Enquiry> findByCounsellor(Counsellor counsellor);

	
}
