package com.example.demo.exceptions;

@SuppressWarnings("serial")
public class IdNotFoundException extends Exception{
	private String errorCode;
	public IdNotFoundException(String errorCode,String message) {
		super(message);
		this.errorCode=errorCode;
	}
	@Override
	public String getMessage() {
		return this.errorCode+":"+super.getMessage();
	}

}
