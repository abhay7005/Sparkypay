package com.sparkypay.accountservices.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparkypay.accountservices.dto.AccountDto;
import com.sparkypay.accountservices.exception.ResourceNotFoundException;
import com.sparkypay.accountservices.model.Account;
import com.sparkypay.accountservices.repository.AccountRepository;
import com.sparkypay.accountservices.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	AccountNumberGeneratorServiceImpl accountNumberGeneratorServiceImpl;

	@Autowired
	ModelMapper modelMapper;

	public AccountDto getAccountByid(String id) {
		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + id));
		return modelMapper.map(account, AccountDto.class);

	}

	public AccountDto createAccount(Account account) {
		account.setAccountNumber(accountNumberGeneratorServiceImpl.generateAccountNumber());
		account.setCreatedAt(LocalDateTime.now());
		account.setUpdatedAt(LocalDateTime.now());
		account.setStatus(true);
		;
		Account account2 = accountRepository.save(account);
		return modelMapper.map(account, AccountDto.class);

	}

	public List<AccountDto> getAllAccount() {

		List<Account> accounts = accountRepository.findAll();
		List<AccountDto> list = new ArrayList();
		for (Account account : accounts) {
			AccountDto dto = modelMapper.map(account, AccountDto.class);
			list.add(dto);
		}

		return list;
	}

	public AccountDto updateAccount(String userId, Account updatedAccount) {
		Account existingAccount = accountRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + userId));

		 
		 existingAccount.setAccountName(updatedAccount.getAccountName());
	        existingAccount.setAccountType(updatedAccount.getAccountType());
	        existingAccount.setStatus(updatedAccount.getStatus());
	        existingAccount.setCurrency(updatedAccount.getCurrency());
	        existingAccount.setBalance(updatedAccount.getBalance());
	        existingAccount.setIban(updatedAccount.getIban());
	        existingAccount.setUpdatedAt(LocalDateTime.now());

	        Account account = accountRepository.save(existingAccount);
	        return modelMapper.map(account, AccountDto.class);
			
	        
	}

	public void deleteAccount(String userId) {
		Account existingAccount = accountRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found with ID: " + userId));
		accountRepository.delete(existingAccount);
	}

	public AccountDto getAccountByAccountNo(String accountNumber) {
		Account account = accountRepository.findByAccountNumber(accountNumber).orElseThrow(
				() -> new ResourceNotFoundException("Account not found with account number: " + accountNumber));
		return modelMapper.map(account, AccountDto.class);
	}
}
