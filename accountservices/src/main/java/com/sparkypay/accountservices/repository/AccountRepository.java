package com.sparkypay.accountservices.repository;



import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sparkypay.accountservices.model.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String>{

	boolean existsByAccountNumber(String accountNumber);

	Optional<Account> findByAccountNumber(String accountNumber);

}
