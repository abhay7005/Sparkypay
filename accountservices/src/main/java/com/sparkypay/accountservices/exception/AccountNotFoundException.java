package com.sparkypay.accountservices.exception;

public class AccountNotFoundException extends RuntimeException{
	 public AccountNotFoundException(String userId) {
	        super("Account not found with id: " + userId);
	    }
}
