package com.example.ProductProject.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
@Configuration
@OpenAPIDefinition
public class ApplicationDoc {
	
	Contact contact() {
		return new Contact().name("ram")
				.url("sys.in")
				.email("xyz@gmail.com");
	}
	
	Info info() {
		return new Info().title("Product management System")
				
				.description("RESTful API eith basic CRUD operations.")
				.version("v");
	}
	@Bean
	OpenAPI openAPI() {
		return new OpenAPI().info(info());
	}

}
