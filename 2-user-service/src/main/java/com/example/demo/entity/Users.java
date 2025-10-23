package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int userId;
	@NotBlank(message = "User Name cant be blank/null")
	@Column(unique = true)
private String userName;
	@NotBlank()
@Size(min = 8 , message  = "atleast should have 8 characters")

private String password;
	
private String phoneNo;

private String address;

private String email;
}
