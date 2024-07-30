package com.sparkypay.accountservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class AccountservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountservicesApplication.class, args);
		
	}

}
