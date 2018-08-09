package edu.regis.msse670.model.services.propertiescustodian;

import java.io.*;
import java.util.*;

import edu.regis.msse670.model.business.exception.PropertiesFileNotFoundException;



/**
 * Loads, stores and searches the properties file for use in the application 
 * @author Maledictor
 *
 */
public class PropertiesCustodian {

	private static Properties properties;
	
	
	/**
	 * Attempts to load the properties file and store it in the static properties variable.
	 * 
	 * @param propertiesFileLocation
	 * @throws PropertiesFileNotFoundException
	 */
	public static void loadProperties(String propertiesFileLocation) throws PropertiesFileNotFoundException {
		
		properties = new Properties();
		FileInputStream fis = null;
		
		System.out.println("Loading properties from file at location: " + propertiesFileLocation);
		
		try {
			fis = new FileInputStream(propertiesFileLocation);
			properties.load(fis);
			
			System.out.println("Properties successfully loaded from file.");			
		}
		catch (FileNotFoundException fnfe){
			System.out.println("Properties file not found.");
			throw new PropertiesFileNotFoundException("PropertyFileNotFound while loading properties file", fnfe);
		}
		catch (IOException ioe){
			System.out.println("IOException, propertiies file not loaded.");
			throw new PropertiesFileNotFoundException("IOException while loading properties file.", ioe);
		}
		catch (Exception e){
			System.out.println("Exception while loading properties file.");
			throw new PropertiesFileNotFoundException("Exception while loading properties file.", e);
		}
		finally {
			if (fis != null){
				try {
					fis.close();
				}
				catch (IOException ioe){
					ioe.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * Uses the key parameter to search the loaded properties file for the associated value.
	 * 
	 * @param key String to be found in the properties file
	 * @return String associated with the key in the properties file. 
	 */
	static public String getPropertyString (String key){
		return properties.getProperty(key);
	}
}
