package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Users;
import com.example.demo.service.PayMentGateway;
import com.example.demo.service.UserService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserApi {
	
	@Value("${gateway}")
	private String msg;
	
	@Autowired
	private PayMentGateway gateWay;
	
@Autowired
private UserService userService;

@PostMapping(consumes = {"application/xml", "application/json"})
public ResponseEntity<Users> registerNewuser(@RequestBody @Valid Users user){
	Users u = userService.registerUser(user);
	return new ResponseEntity(u,HttpStatus.CREATED);
}

@GetMapping("/{id}")
public ResponseEntity<Users> searchById(@PathVariable ("id") int id){
	Users user = userService.searchById(id);
	return new ResponseEntity(user,HttpStatus.FOUND);
}

@GetMapping("/test")
public String getMsg() {
	return msg;
}

@GetMapping("/pay")
public String payment() {
	return gateWay.pay();
}

}
