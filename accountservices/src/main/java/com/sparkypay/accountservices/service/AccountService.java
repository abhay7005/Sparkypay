package com.sparkypay.accountservices.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sparkypay.accountservices.model.Account;
@Transactional
public interface AccountService {

	Account getAccountByid(String userId);

	Account createAccount(Account account);

	List<Account> getAllAccount();

	Account updateAccount(String userId, Account updatedAccount);
	
	void deleteAccount(String userId);
}
