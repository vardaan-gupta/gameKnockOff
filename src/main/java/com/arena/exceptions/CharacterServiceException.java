package com.arena.exceptions;

public class CharacterServiceException extends RuntimeException {

	

	  /**
	 * 
	 */
	private static final long serialVersionUID = -7627399296549462254L;

	public CharacterServiceException(String message) {
	    super(message);
	  }   

	  public CharacterServiceException(String message, Throwable t) {
	      super(message, t);
	  }
}
