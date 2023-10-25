package com.valtech.training.day2;

public class DivideByZeroException extends RuntimeException{

	
	// if we want to pass our own message for the exception
	public DivideByZeroException(String message) {
		super(message);
	}
}
