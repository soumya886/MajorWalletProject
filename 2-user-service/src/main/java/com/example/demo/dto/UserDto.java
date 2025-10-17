package com.example.demo.dto;


import lombok.Data;
@Data
public class UserDto {
	
private int userId;
private String userName;
private String phoneNo;
private AddressDto address;
private String email;
}

