package edu.regis.msse670.invenstory.services.exception;

public class ServiceNotFoundException extends Exception {

	private static final long serialVersionUID = -8470029346801255710L;
	
	public ServiceNotFoundException(final String inMessage){
		super(inMessage);
	}
	
	public ServiceNotFoundException(final String inMessage, final Throwable inNestedException){
		super(inMessage, inNestedException);
	}
	
}
