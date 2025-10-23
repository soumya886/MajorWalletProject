package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Users;
import com.example.demo.exception.ApplicationException;
import com.example.demo.repository.UserRepository;
@Service
public class userServiceImpl implements UserService{
	
	Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private MessageSender msgSender;
	
	@Override
	public Users registerUser(Users user) {
		Users exisitingUser = userRepo.findByUserName(user.getUserName());
		
		if(exisitingUser!=null) {
			throw new ApplicationException("User already exists...");
		}
		Users saveUser =  userRepo.save(user);
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(user, dto);
		msgSender.sendNotification(dto);
		return saveUser;
	
	}
	@Override
	public Users searchById(int id) {
		
		log.info("searching the user {}",id);
		
		// optional return type of findById cause user might 
		return userRepo.findById(id).orElseThrow(()-> new ApplicationException("User doesn't exists"));
	}

}
