package com.example.ProductProject.exception;

public class ProductIdNotFoundException extends RuntimeException {

	private String message;
	
	public ProductIdNotFoundException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
