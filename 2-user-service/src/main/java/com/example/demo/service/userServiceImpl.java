package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.exception.ApplicationException;
import com.example.demo.repository.UserRepository;
@Service
public class userServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public Users registerUser(Users user) {
		Users exisitingUser = userRepo.findByUserId(user.getUserId());
		if(exisitingUser!=null) {
			throw new ApplicationException("User already exists...");
		}
		return userRepo.save(user);
	}
	@Override
	public Users searchById(int id) {
		// optional return type of findById cause user might 
		return userRepo.findById(id).orElseThrow(()-> new ApplicationException("User doesn't exists"));
	}

}
