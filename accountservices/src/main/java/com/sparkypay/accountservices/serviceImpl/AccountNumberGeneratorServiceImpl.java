package com.sparkypay.accountservices.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sparkypay.accountservices.repository.AccountRepository;

@Service
public class AccountNumberGeneratorServiceImpl {
	@Autowired
    private AccountRepository accountRepository;

    public String generateAccountNumber() {
        String accountNumber;
        do {
            accountNumber = "ACC" + UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        } while (accountRepository.existsByAccountNumber(accountNumber));
        return accountNumber;
    }
}
