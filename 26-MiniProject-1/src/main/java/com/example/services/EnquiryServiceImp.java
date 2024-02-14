package com.example.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import org.springframework.stereotype.Service;

import com.example.bindings.Dashboard;
import com.example.entites.Counsellor;
import com.example.entites.Enquiry;
import com.example.repositories.EnquiryRepo;

@Service
public class EnquiryServiceImp implements EnquiryService {

	@Autowired
	private EnquiryRepo repo;

	@Override
	public List<Enquiry> findEnquires() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enquiry saveEnquiry(Enquiry enquiry) {
		// TODO Auto-generated method stub
		return repo.save(enquiry);
	}

	@Override
	public List<Enquiry> findCousellorEnquiry(Counsellor counsellor) {
		return repo.findByCounsellor(counsellor);
	}

	public Dashboard getDashboard(Counsellor counsellor) {
		List<Enquiry> enquiries = repo.findByCounsellor(counsellor);
		Dashboard response = new Dashboard();

		response.setTotal(enquiries.size());
		response.setEnrolled(
				enquiries.stream().filter(e -> e.getStatus().equals("Enrolled")).collect(Collectors.toList()).size());
		response.setLost(
				enquiries.stream().filter(e -> e.getStatus().equals("Lost")).collect(Collectors.toList()).size());
		return response;

	}

	public List<Enquiry> findByExam(Enquiry enq){
		 Example<Enquiry> example = Example.of(enq);
		return repo.findAll(example);
		
	}

}
