package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.UserDto;

@Service
public class TransactionService {
	private Logger log=LoggerFactory.getLogger(TransactionService.class);
	
	@Autowired
	private RestTemplate restTemplate;
	public UserDto fundTransfer(TransactionDto transactionDto) {
		log.info("fund tranfering from {} and to {}",transactionDto.getFromUserId(),transactionDto.getToUserId());
		
		String url = "http://user-service/users/"+transactionDto.getFromUserId();
		// call the user service
		UserDto userDto = restTemplate.getForObject(url, UserDto.class);
		return userDto;
	}
	
}
