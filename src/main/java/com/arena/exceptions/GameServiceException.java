package com.arena.exceptions;

public class GameServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8310132962794658848L;

	public GameServiceException(String message) {
		super(message);
	}

	public GameServiceException(String message, Throwable t) {
		super(message, t);
	}
}
