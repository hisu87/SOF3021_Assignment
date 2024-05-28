package com.poly.exception;

@SuppressWarnings("serial")
public class RoleAlreadyExistException extends RuntimeException {

	public RoleAlreadyExistException(String message) {
		super(message);
	}
}
