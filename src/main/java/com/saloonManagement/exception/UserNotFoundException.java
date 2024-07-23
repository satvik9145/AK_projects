package com.saloonManagement.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(long id) {
		super("User Not found the user with Id " + id);
	}

}
