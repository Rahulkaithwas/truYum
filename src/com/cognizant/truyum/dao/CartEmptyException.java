
package com.cognizant.truyum.dao;


public class CartEmptyException extends Exception {

	
	private static final long serialVersionUID = 6539196163290646747L;
	private String message;

	public CartEmptyException(String message) {
		super(message);

		this.message = message;

	}

	
	public String getMessage() {
		return message;
	}

	
	public void setMessage(String message) {
		this.message = message;
	}

}
