package com.example.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.Entity.EmailModel;

@Service
public class MailService {
	@Autowired
	private JavaMailSender mailsender;
	
	@Value("$(spring.mail.user)")
	private String fromMail;
	
	public void sendMail(String mail,EmailModel model) {
		SimpleMailMessage simplemailmessage=new SimpleMailMessage();
		simplemailmessage.setFrom(fromMail);
		simplemailmessage.setSubject(model.getSubject());
		simplemailmessage.setText(model.getMessage());
		simplemailmessage.setTo(mail);
		mailsender.send(simplemailmessage);
		
		
	}

}
