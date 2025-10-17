package com.example.demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class VisaPayMentGateway  implements PayMentGateway{

	@Override
	public String pay() {
		// TODO Auto-generated method stub
		return "Its visa payment gateway";
	}
	

}
