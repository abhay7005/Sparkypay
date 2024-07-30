package com.sparkypay.accountservices.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparkypay.accountservices.exception.AccountNotFoundException;
import com.sparkypay.accountservices.model.Account;
import com.sparkypay.accountservices.repository.AccountRepository;

@Service
public class AccountServiceImpl {
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AccountNumberGeneratorServiceImpl accountNumberGeneratorServiceImpl;
	
	public Account getAccountByid(String userId) {
		return accountRepository.findById(userId)
                .orElseThrow(() -> new AccountNotFoundException(userId));
		
	}

	public Account createAccount(Account account) {
		account.setAccountNumber(accountNumberGeneratorServiceImpl.generateAccountNumber());
		account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(LocalDateTime.now());
        account.setStatus(true);; // Set account as active by default
		return accountRepository.save(account);
	}

	
}
