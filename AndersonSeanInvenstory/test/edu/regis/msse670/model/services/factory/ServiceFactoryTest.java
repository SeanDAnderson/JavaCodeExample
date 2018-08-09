package edu.regis.msse670.model.services.factory;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import edu.regis.msse670.model.services.exception.ServiceNotFoundException;
import edu.regis.msse670.model.services.factory.ServiceFactory;
import edu.regis.msse670.model.services.inventoryservice.IInventoryServices;
import edu.regis.msse670.model.services.inventoryservice.InventoryServicesImpl;
import edu.regis.msse670.model.services.worldinventoryservice.IWorldInventoryServices;
import edu.regis.msse670.model.services.worldinventoryservice.WorldInventoryServicesImpl;




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