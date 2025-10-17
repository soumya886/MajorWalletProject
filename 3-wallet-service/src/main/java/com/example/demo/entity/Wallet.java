package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Wallet {
	@Id
private int walletId;
private float walletBalance;
private Date creationDate;
private Date lastUpdated;
private WalletStatus status;
private int userId;

}
