package edu.regis.msse670.model.services.worldinventoryservice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.regis.msse670.model.domain.BasicInventory;
import edu.regis.msse670.model.domain.WorldInventory;
import edu.regis.msse670.model.services.exception.NullInventoryException;
import edu.regis.msse670.model.services.exception.ServiceNotFoundException;
import edu.regis.msse670.model.services.exception.WorldInventoryLoadException;
import edu.regis.msse670.model.services.exception.WorldInventorySaveException;
import edu.regis.msse670.model.services.factory.ServiceFactory;
import edu.regis.msse670.model.services.inventoryservice.IInventoryServices;
import edu.regis.msse670.model.services.worldinventoryservice.IWorldInventoryServices;



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
	
	/**
	 * 
	 */
	@Test
	public void testSaveWorldInventory() {
		WorldInventory worldInventory = new WorldInventory("TheWorld");
		WorldInventory loadedWorldInventory = null;
		
		try{
			IInventoryServices inventoryServices = (IInventoryServices) serviceFactory.getService("IInventoryServices");
			IWorldInventoryServices worldInventoryServices = (IWorldInventoryServices) serviceFactory.getService("IWorldInventoryServices");
			System.out.println("Preparing to populate WorldInventory");
			for(int i = 0; i < 10; i++){
				inventoryServices.addToNext(worldInventory, new BasicInventory("NameA" + i, (byte) 5, 10));
				System.out.println(worldInventory.getObjectInventory().get(i).getName() + " added.");
				if (i == 2){
					inventoryServices.addToNext(worldInventory.getObjectInventory().get(2), new BasicInventory("NameB2", (byte) 5, 4));
				}
			}
			
			System.out.println("Saving: " + worldInventory.getName());
			for (int i = 0; i < worldInventory.getInventoryStored(); i++){
				System.out.println(worldInventory.getObjectInventory().get(i).getName());
				if (i == 2){
					System.out.println(worldInventory.getObjectInventory().get(2).getObjectInventory().get(0).getName());
				}
			}
			
			worldInventoryServices.saveWorldInventory(worldInventory);
			loadedWorldInventory = worldInventoryServices.loadWorldInventory("TheWorld.ser");
			
			System.out.println("Loaded: " + loadedWorldInventory.getName());
			for (int i = 0; i < loadedWorldInventory.getInventoryStored(); i++){
				System.out.println(loadedWorldInventory.getObjectInventory().get(i).getName());
				if (i == 2){
					System.out.println(loadedWorldInventory.getObjectInventory().get(2).getObjectInventory().get(0).getName());
				}
			}
			
		}
		catch (NullInventoryException nie) {
			nie.printStackTrace();
			fail("NullInventoryException");
		}
		catch (ServiceNotFoundException snfe){
			snfe.printStackTrace();
			fail("ServiceNotFoundException");
		}
		catch (WorldInventorySaveException wise){
			wise.printStackTrace();
			fail("WorldInventorySaveException");
		}
		catch (WorldInventoryLoadException wile){
			wile.printStackTrace();
			fail("WorldInventoryLoadException");
		}
		assertTrue(worldInventory.equals(loadedWorldInventory));
		System.out.println("testSaveWorldInventory succeed?");
	}
}
