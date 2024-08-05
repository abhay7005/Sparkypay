package com.sparkypay.accountservices.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sparkypay.accountservices.dto.AccountDto;
import com.sparkypay.accountservices.model.Account;

@Transactional
public interface AccountService {

	AccountDto getAccountByid(String id);

	AccountDto createAccount(Account account);

	List<AccountDto> getAllAccount();

	AccountDto updateAccount(String id, Account updatedAccount);

	void deleteAccount(String id);

	AccountDto getAccountByAccountNo(String accountNumber);
}
