package com.example.services;

import java.util.List;

import com.example.entites.Counsellor;
import com.example.entites.Enquiry;

public interface EnquiryService {
	public List<Enquiry> findEnquires();
	public Enquiry saveEnquiry(Enquiry enquiry);
	public List<Enquiry> findCousellorEnquiry(Counsellor counsellor);
	

}
