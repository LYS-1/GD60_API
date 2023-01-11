package com.iu.api3.exception;

public class CustomException extends Exception{
	
	public CustomException() {
		
	}
	
	public CustomException(String msg) {
		System.out.println(msg);
	}
	
}
