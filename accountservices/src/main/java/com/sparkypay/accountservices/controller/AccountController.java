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

import com.sparkypay.accountservices.exception.AccountNotFoundException;
import com.sparkypay.accountservices.model.Account;
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
	@GetMapping("getAllAccount")
	public  ResponseEntity<List<Account>> getAllAccount(){
		List<Account> account = accountServiceImpl.getAllAccount();
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
	
	@PutMapping("updateAccount/{userId}")
    public ResponseEntity<Account> updateAccount(@PathVariable String userId, @RequestBody Account updatedAccount) {
        Account account = accountServiceImpl.updateAccount(userId, updatedAccount);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
	
	@DeleteMapping("deleteAccount/{userId}")
    public ResponseEntity<String> deleteAccount(@PathVariable String userId) {
        try {
        	accountServiceImpl.deleteAccount(userId);
            return new ResponseEntity<>("Account deleted successfully", HttpStatus.OK);
        } catch (AccountNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>("Failed to delete account", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
