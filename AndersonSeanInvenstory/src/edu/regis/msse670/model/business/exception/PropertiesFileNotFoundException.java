package edu.regis.msse670.model.business.exception;

/**
 * Exception for when the properties file is not found or cannot be loaded.
 * @author Maledictor
 *
 */
public class PropertiesFileNotFoundException extends Exception {

	private static final long serialVersionUID = 4336711692128705618L;
	
	public PropertiesFileNotFoundException(final String inMessage, final Throwable inNestedException){
		super(inMessage, inNestedException);
	}

}
