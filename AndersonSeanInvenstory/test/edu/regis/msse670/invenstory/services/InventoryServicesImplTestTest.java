package edu.regis.msse670.invenstory.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.regis.msse670.invenstory.domain.*;

public class InventoryServicesImplTestTest {
	
	ServiceFactory serviceFactory;
	IInventoryServices inventoryServices;
	BasicInventory inventory;
	BasicInventory item;
	
	/** 
	 * Assigning values needed for testing.
	 * */
	@Before
	public void setUp() throws Exception {
		
		serviceFactory = new ServiceFactory();
		inventoryServices = serviceFactory.getInventoryServices();
		inventory = new BasicInventory("Thing", (byte) 10, 247);
		item = new BasicInventory("Stuff", (byte) 11, 1);
	}

	/** 
	 * Tests that addToInventory is called correctly.
	 * Includes test for private function checkInventoryAdd calling correctly.
	 * */
	@Test
	public void testAddToInventory() {
		assertTrue(inventoryServices.addToInventory(inventory, item));
		System.out.println("testAddToInventory PASSED");
	}
	
	/** 
	 * Tests that validateInventoryName is called correctly
	 * */
	@Test
	public void testValidateInventoryName() {
		assertTrue(inventoryServices.validateInventoryName("Bobert"));
		System.out.println("testValidateInventoryName PASSED");
	}
	
	/** 
	 * Tests that validateInventorySize is called correctly
	 * */
	@Test
	public void testValidateInventorySize() {
		assertTrue(inventoryServices.validateInventorySize("103"));
		System.out.println("testValidateInventorySize PASSED");
	}
	

}
