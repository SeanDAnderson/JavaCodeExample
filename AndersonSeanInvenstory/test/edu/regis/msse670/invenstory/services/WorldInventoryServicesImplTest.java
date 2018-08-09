package edu.regis.msse670.invenstory.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.regis.msse670.invenstory.domain.*;

/**
 * All tested methods are available through the interface so no
 * tests call directly from the implementation class
 */
public class WorldInventoryServicesImplTest {

	ServiceFactory serviceFactory;
	IWorldInventoryServices worldInventoryServices;
	WorldInventory worldInventory;
	
	/** 
	 * Assigning values to variables required for testing
	 * */
	@Before
	public void setUp() throws Exception {
		serviceFactory = new ServiceFactory();
		worldInventoryServices = serviceFactory.getWorldInventoryServices();
		worldInventory = new WorldInventory("The World");
	}

	/** 
	 * Testing that nameIsUnique is called correctly through the interface.
	 * */
	@Test
	public void testNameIsUnique() {
	
		assertTrue(worldInventoryServices.nameIsUnique(worldInventory, "Bob"));
		System.out.println("testNameIsUnique PASSED");
	}

	/** 
	 * Testing that saveWorldInventory is called correctly through the interface
	 * */
	@Test
	public void testSaveWorldInventory() {
		assertTrue(worldInventoryServices.saveWorldInventory(worldInventory));
		System.out.print("testSaveWorldInventory Passed");
	}

}
