package com.sparkypay.userservices.config;

import org.modelmapper.ModelMapper;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class MyConfig {
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}

	 @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	            .info(new Info()
	                .title("My Custom API")
	                .version("1.0.0")
	                .description("This is a custom OpenAPI configuration for the application.")
	                .termsOfService("http://example.com/terms/")
	                .license(new io.swagger.v3.oas.models.info.License()
	                    .name("Apache 2.0")
	                    .url("http://springdoc.org")
	                )
	            );
	    }

	   
	 @Bean
	    public GroupedOpenApi publicApi() {
	        return GroupedOpenApi.builder()
	                .group("public")
	                .pathsToMatch("/users/**")
	                .build();
	    }
	public MyConfig() {
		// TODO Auto-generated constructor stub
	}

}
