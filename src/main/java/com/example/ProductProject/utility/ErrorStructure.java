package com.example.ProductProject.utility;

public class ErrorStructure<D> {

	public int getErrorStatusCode() {
		return errorStatusCode;
	}
	public  ErrorStructure<D> setErrorStatusCode(int errorStatusCode) {
		this.errorStatusCode = errorStatusCode;
		return this;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public ErrorStructure<D> setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}
	public D getErrorData() {
		return errorData;
	}
	public ErrorStructure<D> setErrorData(D errorData) {
		this.errorData = errorData;
		return this;
	}
	private int errorStatusCode;
	private String errorMessage;
	private D errorData;
	private Object rootCause;
	public Object getRootCause() {
		return rootCause;
	}
	public ErrorStructure<D> setRootCause(Object rootCause) {
		this.rootCause = rootCause;
		return this;
	}
}
