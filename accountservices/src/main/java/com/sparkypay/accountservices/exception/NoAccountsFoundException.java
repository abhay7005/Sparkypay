package com.sparkypay.accountservices.exception;

public class NoAccountsFoundException extends RuntimeException{
	public NoAccountsFoundException() {
        super("No accounts found.");
    }
}
