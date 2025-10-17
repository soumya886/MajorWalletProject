package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Wallet;
import com.example.demo.service.WalletService;
@RestController
@RequestMapping("/wallet")
public class WalletApi {
@Autowired 
private WalletService walletService;
@PostMapping("/{userId}")
public Wallet registerNewWallet (@PathVariable("userId") int userId) {
	return walletService.addNewWallet(userId);
}

}
