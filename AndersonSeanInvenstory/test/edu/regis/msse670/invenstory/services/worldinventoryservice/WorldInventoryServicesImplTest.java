package edu.regis.msse670.invenstory.services.worldinventoryservice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.regis.msse670.invenstory.domain.*;
import edu.regis.msse670.invenstory.services.exception.*;
import edu.regis.msse670.invenstory.services.factory.ServiceFactory;
import edu.regis.msse670.invenstory.services.inventoryservice.*;

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
		serviceFactory = ServiceFactory.getFactory();
		worldInventoryServices = (IWorldInventoryServices) serviceFactory.getService("IWorldInventoryServices");
	}

	/** 
	 * Testing that nameIsUnique returns true when fed a unique name.
	 * */
	@Test
	public void testNameIsUniqueSucceed() {
		worldInventory = new WorldInventory("The World");
		
		try{
			IInventoryServices inventoryServices = (IInventoryServices) serviceFactory.getService("IInventoryServices");
			System.out.println("Preparing to populate WorldInventory");
			for(int i = 0; i < 10; i++){
				inventoryServices.addToNext(worldInventory, new BasicInventory("Name" + i, (byte) 5, 10));
			}
			assertTrue(worldInventoryServices.nameIsUnique(worldInventory, "Bob"));
			System.out.println("testNameIsUniqueSucceed PASSED");
		}
		catch (NullInventoryException nie) {
			nie.printStackTrace();
			fail("NullInventoryException");
		}
		catch (ServiceNotFoundException snfe){
			snfe.printStackTrace();
			fail("ServiceNotFoundException");
		}
	}

	/** 
	 * Testing that nameIsUnique returns true when fed a unique name.
	 * */
	@Test
	public void testNameIsUniqueFail() {
		worldInventory = new WorldInventory("The World");
		
		try{
			IInventoryServices inventoryServices = (IInventoryServices) serviceFactory.getService("IInventoryServices");
			System.out.println("Preparing to populate WorldInventory");
			for(int i = 0; i < 10; i++){
				inventoryServices.addToNext(worldInventory, new BasicInventory("Name" + i, (byte) 5, 10));
				System.out.println("Name" + i + " added");
			}
			System.out.println("Adding Bob");
			inventoryServices.addToNext(worldInventory, new BasicInventory("Bob", (byte) 5, 11));
			assertFalse(worldInventoryServices.nameIsUnique(worldInventory, "Bob"));
			System.out.println("testNameIsUniqueFail PASSED");
		}
		catch (NullInventoryException nie) {
			nie.printStackTrace();
			fail("NullInventoryException");
		}
		catch (ServiceNotFoundException snfe){
			snfe.printStackTrace();
			fail("ServiceNotFoundException");
		}
	}
}
