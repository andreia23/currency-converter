package com.jaya.challenge.api.currency.converter.exception;

/**
 * @author andreia
 *
 */
public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5861310537366287163L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
