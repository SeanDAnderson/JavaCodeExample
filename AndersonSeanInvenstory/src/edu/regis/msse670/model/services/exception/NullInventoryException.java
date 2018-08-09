package edu.regis.msse670.model.services.exception;

/**
 * Exception for handling uninitialized Inventory objects
 * 
 * @author Maledictor
 *
 */
public class NullInventoryException extends Exception {

	private static final long serialVersionUID = 4255948428314087509L;

	public NullInventoryException(final String inMessage){
		super(inMessage);
	}
	
	public NullInventoryException(final String inMessage, final Throwable inNestedException){
		super(inMessage, inNestedException);
	}
	
}
