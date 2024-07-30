package com.sparkypay.accountservices.service;

import com.sparkypay.accountservices.model.Account;

public interface AccountService {

	Account getAccountByid(String userId);

	Account createAccount(Account account);
}
