package com.au.exception;

public class NoTransactionExistException extends Exception{

	private static final long serialVersionUID = 1L;

	public NoTransactionExistException(String message) {
		super(message);
	}
}
