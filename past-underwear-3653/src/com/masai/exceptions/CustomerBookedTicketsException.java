package com.masai.exceptions;

public class CustomerBookedTicketsException extends Exception {
	public CustomerBookedTicketsException() {
		
	}
	
	public CustomerBookedTicketsException(String message) {
		super(message);
	}
}
