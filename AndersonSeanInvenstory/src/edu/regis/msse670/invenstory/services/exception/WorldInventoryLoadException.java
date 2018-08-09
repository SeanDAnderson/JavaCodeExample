package edu.regis.msse670.invenstory.services.exception;

/**
 * Exception for when a WorldInventory fails to load properly
 * 
 * @author Maledictor
 *
 */
public class WorldInventoryLoadException extends Exception {

	private static final long serialVersionUID = 274398179067157619L;

	public WorldInventoryLoadException(final String inMessage){
		super(inMessage);
	}
	
	public WorldInventoryLoadException(final String inMessage, final Throwable inNestedException){
		super(inMessage, inNestedException);
	}
}
