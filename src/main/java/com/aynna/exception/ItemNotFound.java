package com.aynna.exception;

public class ItemNotFound extends Exception {

	public ItemNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public ItemNotFound(String message) {
		super(message);
	}
	
}
