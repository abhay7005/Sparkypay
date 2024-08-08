package com.sparkypay.userservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication

public class UserservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserservicesApplication.class, args);
	}

}
