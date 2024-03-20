package com.example.ProductProject.utility;

public class ResponseStructure<G> {
private int statusCode;
private String message;
private G data;
public int getStatusCode() {
	return statusCode;
}
public ResponseStructure<G> setStatusCode(int statusCode) {
	this.statusCode = statusCode;
	return this;
}
public String getMessage() {
	return message;
}
public ResponseStructure<G> setMessage(String message) {
	this.message = message;
	return this;
}
public G getData() {
	return data;
}
public ResponseStructure<G> setData(G data) {
	this.data = data;
	return this;
}
}
