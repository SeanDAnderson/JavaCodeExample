package edu.regis.msse670.invenstory.services.exception;

public class NullInventoryException extends Exception {

	private static final long serialVersionUID = 4255948428314087509L;

	public NullInventoryException(final String inMessage){
		super(inMessage);
	}
	
	public NullInventoryException(final String inMessage, final Throwable inNestedException){
		super(inMessage, inNestedException);
	}
	
}
