package com.example.demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.constant.AppConstant;
import com.example.demo.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NotificationConsumerService {
@Autowired
	private SimpleMailMessage mailMessage;
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private ObjectMapper objMapper;
	
	@KafkaListener(topics = AppConstant.NEW_USER,groupId = "group-id")
	public void consumeMessage(ConsumerRecord<String, String> consumer) {
		System.out.println("Received the msg");
		String k = consumer.key();
		String jsonText = consumer.value();
		System.out.println("Receive JSON "+ jsonText);
		
		try {
			UserDto userDto = objMapper.readValue(jsonText,UserDto.class);
			
			mailMessage.setTo(userDto.getEmail());
			mailMessage.setSubject("Registration successful");
			String msg = "Hi" + userDto.getUserName()+ " , congratulations";
			mailMessage.setText(msg);
			mailSender.send(mailMessage);
			System.out.println("Mail send");
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
