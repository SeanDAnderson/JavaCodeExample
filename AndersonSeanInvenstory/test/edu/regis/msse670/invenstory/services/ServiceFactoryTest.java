package edu.regis.msse670.invenstory.services;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;


public class ServiceFactoryTest extends TestCase {

	ServiceFactory serviceFactory;
	
	/** 
	 * Assigning values required for testing
	 * */
	@Before
	public void setUp() throws Exception {
		//super.setUp();
		
		serviceFactory = new ServiceFactory();
		
	}
	
	/** 
	 * Testing that serviceFactory creates an InventoryServicesImpl object
	 * correctly via the IInventoryServices interface
	 * */
	@Test
	public void testGetInventoryServices() {
		IInventoryServices inventoryServices = (IInventoryServices) serviceFactory.getInventoryServices();
		assertTrue(inventoryServices instanceof InventoryServicesImpl);
		System.out.println("testGetInventoryServices PASSED");
	}

	/** 
	 * Testing that serviceFactory creates a WorldInventoryServicesImpl object
	 * correctly via the IWorldInventoryServices interface
	 * */
	@Test
	public void testGetWorldInventoryServices(){
		IWorldInventoryServices worldInventoryServices = (IWorldInventoryServices) serviceFactory.getWorldInventoryServices();
		assertTrue(worldInventoryServices instanceof WorldInventoryServicesImpl);
		System.out.println("testGetWorldInventoryServices PASSED");
	}
}
