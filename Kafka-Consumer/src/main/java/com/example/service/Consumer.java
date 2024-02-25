package com.example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	

@KafkaListener(topics = AppConstants.TOPIC, groupId="group_ashokit_order")
public void subscribeMsg(String student) {
		System.out.print("*** Msg Recieved From Kafka *** :: ");
		System.out.println(student);
	//logic
}

}
