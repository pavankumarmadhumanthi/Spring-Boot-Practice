package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.entities.Student;
@Service
public class KafkaProducerService{
	@Autowired
	private KafkaTemplate<String,Student> template;
	
	public String sendMessageToTopic(Student student) {
		try {
			template.send("test1",student);
			return "send message to topic";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "send message to topic is failed";
	}

}
