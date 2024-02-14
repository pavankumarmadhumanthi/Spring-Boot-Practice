package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.bindings.EmailModel;
import com.example.entites.Counsellor;
import com.example.repositories.CounsellorRepo;

@Service
public class EmailService {
	@Autowired
	CounsellorRepo counsellorrepo;
	
	@Value("$(spring.mail.user)")
	private String fromMail;
	
	@Autowired
	private EmailModel model;
	
	public boolean getpwd(String email) {
		Counsellor findByEmail = counsellorrepo.findByEmail(email);
		if(findByEmail!=null) {
			sendMail(email,model,findByEmail.getPassword());
			return true;
		}
		else {
			return false;
		}
		
	}
	@Autowired
	private JavaMailSender mailsender;
	public void sendMail(String mail,EmailModel model,String pwd) {
		SimpleMailMessage simplemailmessage=new SimpleMailMessage();
		simplemailmessage.setFrom(fromMail);
		simplemailmessage.setSubject(model.getSubject());
		simplemailmessage.setText(model.getMessage()+pwd);
		simplemailmessage.setTo(mail);
		mailsender.send(simplemailmessage);
		
		
	}

}
