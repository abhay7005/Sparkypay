package com.sparkypay.userservices.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MyConfig {
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}

	public MyConfig() {
		// TODO Auto-generated constructor stub
	}

}
