package edu.regis.msse670.invenstory.services.factory;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import edu.regis.msse670.invenstory.services.inventoryservice.*;
import edu.regis.msse670.invenstory.services.worldinventoryservice.*;
import edu.regis.msse670.invenstory.services.exception.*;


public class ServiceFactoryTest extends TestCase {

	ServiceFactory serviceFactory;
	
	/** 
	 * Assigning values required for testing
	 * */
	@Before
	public void setUp() throws Exception {
		//super.setUp();
		
		serviceFactory = ServiceFactory.getFactory();
	}
	
	/** 
	 * Testing that serviceFactory creates an InventoryServicesImpl object
	 * correctly via the IInventoryServices interface
	 * */
	@Test
	public void testGetServicesInventoryServices() {
		IInventoryServices inventoryServices;
		try{
			inventoryServices = (IInventoryServices)serviceFactory.getService(IInventoryServices.NAME);
		assertTrue(inventoryServices instanceof InventoryServicesImpl);
		System.out.println("testGetServices PASSED");
	
		}
		catch (ServiceNotFoundException snfe){
			snfe.printStackTrace();
			fail("ServiceNotFoundException");
		}
	}
	/** 
	 * Testing that serviceFactory creates a WorldInventoryServicesImpl object
	 * correctly via the IWorldInventoryServices interface
	 * */
	@Test
	public void testGetServicesWorldInventoryServices(){
		IWorldInventoryServices worldInventoryServices;
		try{
			worldInventoryServices = (IWorldInventoryServices)serviceFactory.getService(IWorldInventoryServices.NAME);
		assertTrue(worldInventoryServices instanceof WorldInventoryServicesImpl);
		System.out.println("testGetInventoryServices PASSED");
	
		}
		catch (ServiceNotFoundException snfe){
			snfe.printStackTrace();
			fail("ServiceNotFoundException");
		}
	}
}