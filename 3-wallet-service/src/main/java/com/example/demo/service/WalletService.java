package com.example.demo.service;

import com.example.demo.dto.AddMoneyDto;
import com.example.demo.entity.Wallet;

public interface WalletService {
Wallet addNewWallet(int userId);
Wallet addMoney(AddMoneyDto addMoneyDto);
}
