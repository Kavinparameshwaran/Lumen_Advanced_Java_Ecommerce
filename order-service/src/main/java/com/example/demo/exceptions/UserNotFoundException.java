package com.example.demo.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception{
	private String errorCode;
	public UserNotFoundException(String errorCode,String message) {
		super(message);
		this.errorCode=errorCode;
	}
	@Override
	public String getMessage() {
		return this.errorCode+":"+super.getMessage();
	}

}
