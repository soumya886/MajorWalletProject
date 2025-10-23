package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TransactionDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.TransactionService;

@RestController
public class TransactionApi {

	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/transfer")
	public UserDto fundTranfer(@RequestBody TransactionDto transactionDto){
		return transactionService.fundTransfer(transactionDto);
	}
		
	}

