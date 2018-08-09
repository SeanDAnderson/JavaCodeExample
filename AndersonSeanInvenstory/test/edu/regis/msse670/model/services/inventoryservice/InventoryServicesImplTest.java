package edu.regis.msse670.model.services.inventoryservice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.regis.msse670.model.domain.BasicInventory;
import edu.regis.msse670.model.services.exception.NullInventoryException;
import edu.regis.msse670.model.services.factory.ServiceFactory;
import edu.regis.msse670.model.services.inventoryservice.IInventoryServices;



public class InventoryServicesImplTest {
	
	ServiceFactory serviceFactory;
	IInventoryServices inventoryServices;
	BasicInventory inventory;
	BasicInventory item;
	
	/** 
	 * Assigning values needed for testing.
	 * */
	@Before
	public void setUp() throws Exception {
		
		serviceFactory = ServiceFactory.getFactory();
		inventoryServices = (IInventoryServices) serviceFactory.getService("IInventoryServices");
	}

	/** 
	 * Tests that addToNext returns true for a valid inventory/item combination
	 * Includes test for private function checkInventoryAdd calling correctly.
	 * */
	@Test
	public void testAddToInventorySucceed() {
		inventory = new BasicInventory("Thing", (byte) 10, 247);
		item = new BasicInventory("Stuff", (byte) 11, 1);
		
		try{
		assertTrue(inventoryServices.addToNext(inventory, item));
		System.out.println("testAddToNext PASSED");
		}
		catch (NullInventoryException nie) {
			nie.printStackTrace();
			fail("NullInventoryException");
		}
	}
	
	/** 
	 * Tests that addToNext returns false for an invalid inventory/item combination
	 * Includes test for private function checkInventoryAdd calling correctly.
	 * */
	@Test
	public void testAddToInventoryTierFail() {
		inventory = new BasicInventory("Thing", (byte) 12, 247);
		item = new BasicInventory("Stuff", (byte) 11, 1);
		
		try{
		assertFalse(inventoryServices.addToNext(inventory, item));
		System.out.println("testAddToNextFail PASSED");
		}
		catch (NullInventoryException nie) {
			nie.printStackTrace();
			fail("NullInventoryException");
		}
	}

	/** 
	 * Tests that addToNext returns false for an invalid inventory/item combination
	 * Includes test for private function checkInventoryAdd calling correctly.
	 * */
	@Test
	public void testAddToInventoryFullFail() {
		inventory = new BasicInventory("Thing", (byte) 1, 1);
		item = new BasicInventory("Stuff", (byte) 11, 1);
		
		try{ 
		inventoryServices.addToNext(inventory, item);
		}
		catch (NullInventoryException nie){
			System.out.println("Test addition failed");
		}
		item = new BasicInventory("Stuff", (byte) 11, 1);
		
		try{
		assertFalse(inventoryServices.addToNext(inventory, item));
		System.out.println("testAddToNextFail PASSED");
		}
		catch (NullInventoryException nie) {
			nie.printStackTrace();
			fail("NullInventoryException");
		}
	}
	
	/** 
	 * Tests that validateInventoryName is returns true for a valid name string.
	 * */
	@Test
	public void testValidateInventoryNameSucceed() {
		assertTrue(inventoryServices.validateInventoryName("Bobert"));
		System.out.println("testValidateInventoryNameSucceed PASSED");
	}
	
	/** 
	 * Tests that validateInventoryName is returns false for a invalid name string.
	 * */
	@Test
	public void testValidateInventoryNameFail() {
		String name = null;
		assertFalse(inventoryServices.validateInventoryName(name));
		System.out.println("testValidateInventoryNameFail PASSED");
	}
	

}
