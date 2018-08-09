package edu.regis.msse670.invenstory.services.exception;

/**
 * Exception for handling a WorldInventory not saving properly
 * 
 * @author Maledictor
 *
 */
public class WorldInventorySaveException extends Exception {


	private static final long serialVersionUID = 2503448065639803369L;
	
	public WorldInventorySaveException(final String inMessage){
		super(inMessage);
	}
	
	public WorldInventorySaveException(final String inMessage, final Throwable inNestedException){
		super(inMessage, inNestedException);
	}

}
