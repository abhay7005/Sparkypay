package com.sparkypay.accountservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparkypay.accountservices.dto.AccountDto;
import com.sparkypay.accountservices.model.Account;
import com.sparkypay.accountservices.serviceImpl.AccountServiceImpl;

@RestController
@RequestMapping("account/")
public class AccountController {

    @Autowired
	AccountServiceImpl accountServiceImpl;
	
	@GetMapping("getAccountByid/{id}")
	public ResponseEntity<AccountDto> getAccountByid(@PathVariable String id) {
		AccountDto account = accountServiceImpl.getAccountByid(id);
		return ResponseEntity.ok(account);
	}
	@GetMapping("getAccountByAccountNo/{accountNumber}")
	public ResponseEntity<AccountDto> getAccountByAccountNo(@PathVariable String accountNumber) {
		AccountDto account = accountServiceImpl.getAccountByAccountNo(accountNumber);
		return ResponseEntity.ok(account);
	}
	
	@PostMapping("createAccount")
	public ResponseEntity<AccountDto> createAccount(@RequestBody Account account){
		AccountDto account2 = accountServiceImpl.createAccount(account);
		 return ResponseEntity.status(201).body(account2);
	}
	@GetMapping("getAllAccount")
	public  ResponseEntity<List<AccountDto>> getAllAccount(){
		List<AccountDto> account = accountServiceImpl.getAllAccount();
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	
	@PutMapping("updateAccount/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable String id, @RequestBody Account updatedAccount) {
        AccountDto account = accountServiceImpl.updateAccount(id, updatedAccount);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
	
	@DeleteMapping("deleteAccount/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable String id) {
        try {
        	accountServiceImpl.deleteAccount(id);
            return new ResponseEntity<>("Account deleted successfully", HttpStatus.OK);
        
        } catch (Exception ex) {
            return new ResponseEntity<>("Failed to delete account", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
