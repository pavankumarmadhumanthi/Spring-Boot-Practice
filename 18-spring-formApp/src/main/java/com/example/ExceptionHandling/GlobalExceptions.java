package com.example.ExceptionHandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptions {
	
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "errorView";
	}

}
