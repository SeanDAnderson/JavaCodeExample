package edu.regis.msse670.invenstory.business.manager;

import edu.regis.msse670.invenstory.business.exception.*;
import edu.regis.msse670.invenstory.domain.DataSphere;
import edu.regis.msse670.invenstory.services.exception.*;
import edu.regis.msse670.invenstory.services.factory.*;
import edu.regis.msse670.invenstory.services.propertiescustodian.PropertiesCustodian;
import edu.regis.msse670.invenstory.services.*;

/**
 * Superclass for all manager facades in the business layer.
 * 
 * @author Maledictor
 *
 */
public abstract class Manager {
	
	/**
	 * Getting a reference to the static factory object for use in calling services.
	 */
	protected ServiceFactory factory = ServiceFactory.getFactory();
	
	/**
	 * Loads application.properties into the Properties Custodian when a manager is first called or initialized. 
	 */
	static {
		try{
			Manager.loadProperties();
		}
		catch (PropertiesFileNotFoundException pfnfe){
			System.out.println("The file \"application.properties\" failed to load correctly. Application closing.");
			System.exit(1);
		}
	}
		
	/**
	 * Genericized method for calling services from the service layer. 
	 * 
	 * @param serviceName
	 * @return
	 * @throws ServiceNotFoundException
	 */
	protected IService getService(String serviceName) throws ServiceNotFoundException {
	
		return factory.getService(serviceName);
	}
	
	/**
	 * Generic method that all managers will use to perform requested actions.
	 * 
	 * @param commandString	The name of the requested service
	 * @param dataSphere	Holds application domain information
	 * @return
	 */
	public abstract boolean performAction(String commandString, DataSphere dataSphere);
	
	
	/**
	 * Used to load in the properties file into the PropertiesCustodian. 
	 * 
	 * @throws PropertiesFileNotFoundException
	 */
	public static void loadProperties () throws PropertiesFileNotFoundException {
		String propertyFileLocation = System.getProperty("prop_location");
		
		if (propertyFileLocation != null){
			PropertiesCustodian.loadProperties(propertyFileLocation);
		}
	}
}
