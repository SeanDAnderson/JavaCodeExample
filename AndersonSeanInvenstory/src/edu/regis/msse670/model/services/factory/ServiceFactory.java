package edu.regis.msse670.model.services.factory;

import edu.regis.msse670.model.services.IService;
import edu.regis.msse670.model.services.exception.ServiceNotFoundException;

/**
 * Factory for creating service objects to be passed to the Business tier.
 * @author Sean
 *
 */
public class ServiceFactory {

/** 
 * Singleton pattern to prevent multiple instances of ServiceFactory object
 * */
	private ServiceFactory() {}

	private static ServiceFactory serviceFactory = new ServiceFactory();
	
/** 
 * getFactory returns a reference to the single ServiceFactory instance.
 * @return	ServiceFactory instance reference. 
 * */
	
	public static ServiceFactory getFactory(){
		return serviceFactory;
	}

	/** 
	 * getService attempts to find the service interface associated with the input service name
	 * and return an instance of that service object.
	 * @param	serviceName String of the name of the desired service
	 * @return	IService implementing class object associated with the service name
	 * */
	public IService getService(String serviceName) throws ServiceNotFoundException{
		try{
			Class<?> c = Class.forName(getImplName(serviceName));
			return (IService) c.newInstance();
 		}
		catch(Exception excp){
			serviceName = serviceName + " not found";
			throw new ServiceNotFoundException(serviceName, excp);
		}
	}

	/** 
	 * getImplName loads and searches the properties file for the desired service name
	 * and returns the String name of the service implementation, if found
	 * @param serviceName String name of the desired service
	 * @return String returns the property associated with the service name in the properties file
	 * */
	private String getImplName(String serviceName) throws Exception {
		java.util.Properties properties = new java.util.Properties();
		
		//getting the location of the properties file from the system settings
		String propertyFileLocation = "src/config/application.properties"; 
		
		//system out to verify value for testing
		System.out.println("Proterty file location: " + propertyFileLocation);
		
		java.io.FileInputStream fis = new java.io.FileInputStream(propertyFileLocation);
		
		//load the file stream into the properties object, closing the stream and returning the 
		//desired property
		properties.load(fis);
		System.out.println("Properties loaded");
		fis.close();
		System.out.println("Returning : " + properties.getProperty(serviceName)); 
		return properties.getProperty(serviceName);
	}
}
