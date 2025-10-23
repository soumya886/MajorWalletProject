package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.constant.AppConstant;
import com.example.demo.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MessageSender {
@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

@Autowired
private ObjectMapper mapper;
public void sendNotification(UserDto usrDto) {
	try {
	String jsonText = mapper.writeValueAsString(usrDto);
	System.out.println(jsonText);
	kafkaTemplate.send(AppConstant.NEW_USER, usrDto.getUserName(), jsonText);
	System.out.println("Send to kafka");
}
	catch (JsonProcessingException e) {
		e.printStackTrace();
	}
	
}


}
