package com.sparkypay.accountservices.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparkypay.accountservices.exception.AccountNotFoundException;
import com.sparkypay.accountservices.model.Account;
import com.sparkypay.accountservices.repository.AccountRepository;
import com.sparkypay.accountservices.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
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
        account.setStatus(true);; 
		return accountRepository.save(account);
	}

	public List<Account> getAllAccount() {
		
		return accountRepository.findAll();
	}

	public Account updateAccount(String userId, Account updatedAccount) {
		 Account existingAccount = getAccountByid(userId);

		 
		 existingAccount.setAccountName(updatedAccount.getAccountName());
	        existingAccount.setAccountType(updatedAccount.getAccountType());
	        existingAccount.setStatus(updatedAccount.getStatus());
	        existingAccount.setCurrency(updatedAccount.getCurrency());
	        existingAccount.setBalance(updatedAccount.getBalance());
	        existingAccount.setIban(updatedAccount.getIban());
	        existingAccount.setUpdatedAt(LocalDateTime.now());

	        return accountRepository.save(existingAccount);
	}

	public void deleteAccount(String userId) {
        Account existingAccount = accountRepository.findById(userId)
                .orElseThrow(() -> new AccountNotFoundException(userId));
        accountRepository.delete(existingAccount);
    }
}
