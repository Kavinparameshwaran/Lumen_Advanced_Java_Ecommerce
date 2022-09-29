package com.example.demo.utils;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(value = RuntimeException.class)
	public MyExceptionHandler handleException(Exception ex, WebRequest request) {
		return new MyExceptionHandler(LocalDate.now(),ex.getMessage(),request.getDescription(false));
	}
}
