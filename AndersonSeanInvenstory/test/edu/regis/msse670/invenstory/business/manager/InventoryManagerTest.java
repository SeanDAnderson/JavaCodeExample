package edu.regis.msse670.invenstory.business.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.regis.msse670.invenstory.domain.BasicInventory;
import edu.regis.msse670.invenstory.domain.DataSphere;
import edu.regis.msse670.invenstory.domain.WorldInventory;

public class InventoryManagerTest {
	private InventoryManager inventoryManager;
	private DataSphere dataSphere;
	
	
	@Before
	public void setUp() throws Exception {
		dataSphere = new DataSphere();
		dataSphere.setWorldInventory(new WorldInventory("The World"));
		dataSphere.setInventory1(new BasicInventory("Chest", (byte) 6, 20));
		dataSphere.setInventory2(new BasicInventory("Bottle", (byte) 7, 1));
		inventoryManager = new InventoryManager();	
				
			
		}

		/**
		 * Test to verify NewWorldInventory is called successfully
		 */
		@Test
		public void testNewWorldInventory() {
			assertTrue("NewWorldInventory successfuly called.", inventoryManager.performAction("newWorldInventory", dataSphere));
			System.out.println("testNewWorldInventory PASSED");
		}
		
		/**
		 * Test to verify SaveWorldInventory is called successfully
		 */
		@Test
		public void testSaveWorldInventory(){
			System.out.println("saveWorldTest");
			assertTrue("SaveWorldInventory successfuly called", inventoryManager.performAction("saveWorldInventory", dataSphere));
			System.out.println("testSaveWorldInventory PASSED");
		}
		
		/**
		 * Test to verify AddToInventory is called successfully
		 */
		@Test
		public void testAddToInventory() {
			assertTrue("AddToInventory successfully called", inventoryManager.performAction("addToInventory", dataSphere));
			System.out.println("testAddToInventory PASSED");
		}
}
