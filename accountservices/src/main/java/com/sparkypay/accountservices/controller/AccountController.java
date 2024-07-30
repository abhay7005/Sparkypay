package com.sparkypay.accountservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparkypay.accountservices.model.Account;
import com.sparkypay.accountservices.service.AccountService;
import com.sparkypay.accountservices.serviceImpl.AccountServiceImpl;

@RestController
@RequestMapping("account/")
public class AccountController {

    @Autowired
	AccountServiceImpl accountServiceImpl;
	
	@GetMapping("getAccountByid/{userId}")
	public ResponseEntity<Account> getAccountByid(@PathVariable String userId) {
		Account account = accountServiceImpl.getAccountByid(userId);
		return ResponseEntity.ok(account);
	}
	
	
	@PostMapping("createAccount")
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		Account account2 = accountServiceImpl.createAccount(account);
		 return ResponseEntity.status(201).body(account2);
	}
}
