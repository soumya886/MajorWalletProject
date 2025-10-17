package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.AddMoneyDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Wallet;
import com.example.demo.entity.WalletStatus;
import com.example.demo.exception.ApplicationException;
import com.example.demo.repository.WalletRepository;

public class WalletServiceImpl implements WalletService {
@Autowired
private WalletRepository repository;
	
	@Override
	public Wallet addNewWallet(int userId) {
		boolean userCheck = verifyUser(userId);
		if(!userCheck) {
			throw new RuntimeException("User does not exist " + userId);
		}
		// 1 wallet per user
		boolean existingWallet = repository.findByUserId(userId).isPresent();
		if(existingWallet) {
			throw new RuntimeException("wallet already ezists for user" + userId);
		}
		
				
		Wallet w = new Wallet();
		w.setStatus(WalletStatus.ACTIVE);
		w.setUserId(userId);
		repository.save(w);
		return w;
	}

	@Override
	public Wallet addMoney(AddMoneyDto addMoneyDto) {
		Wallet wallet = repository.findByUserId(addMoneyDto.getUserId()).orElseThrow(()->
		new RuntimeException("Wallet not found for User" + addMoneyDto.getUserId() ));
		
		wallet.setWalletBalance(wallet.getWalletBalance()+addMoneyDto.getAmt());
		return repository.save(wallet);
		
		
	}
	
	boolean verifyUser(int userId) {
		RestTemplate template = new RestTemplate();
		// no load balancing yet
		String url = "http://localhost:9000/users/"+userId;
		UserDto user = template.getForObject(url,UserDto.class);
		if(user!=null) {
			return true;
		}
		else return false;
	}

}
