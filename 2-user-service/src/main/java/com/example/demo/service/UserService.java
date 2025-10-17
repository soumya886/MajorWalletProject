package com.example.demo.service;

import com.example.demo.entity.Users;

public interface UserService {
	
Users registerUser(Users user);
Users searchById(int id);


}
