package com.example.demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class MockPaymentGateway implements PayMentGateway {

	@Override
	public String pay() {
		// TODO Auto-generated method stub
		return "Its mock payment Gateway";
	}
	

}
