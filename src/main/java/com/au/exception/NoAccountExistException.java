package com.au.exception;

public class NoAccountExistException  extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NoAccountExistException(String message) {
        super(message);
    }
}
