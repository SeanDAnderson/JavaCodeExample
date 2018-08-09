package edu.regis.msse670.invenstory.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataSphereTest {

	/**
	 * Tests that DataSphere validates properly
	 */
	@Test
	public void testValidate() {
		DataSphere dataSphere = new DataSphere();
		dataSphere.setWorldInventory(new WorldInventory("The World"));
		dataSphere.setInventory1(new BasicInventory("Item 1", (byte) 3, 4));
		dataSphere.setInventory2(new BasicInventory("Item 2", (byte) 17, 302));
		
		assertTrue("dataSphere validates", dataSphere.validate());
		System.out.println("testValidate Passed");
	}
	
	/**
	 * Tests that DataSphere fails validation properly
	 */
	@Test
	public void testNotValidate(){
		DataSphere dataSphere = new DataSphere();
		assertFalse("dataSphere does not validate", dataSphere.validate());
		System.out.println("testNotValidate PASSED");
	}
	
	/**
	 * Tests that DataSphere equals properly
	 */
	@Test
	public void testEquals(){
		DataSphere dataSphere = new DataSphere();
		DataSphere dataSphere2 = new DataSphere();
		
		dataSphere.setWorldInventory(new WorldInventory("The World"));
		dataSphere.setInventory1(new BasicInventory("Item 1", (byte) 3, 4));
		dataSphere.setInventory2(new BasicInventory("Item 2", (byte) 17, 302));
		dataSphere2.setWorldInventory(new WorldInventory("The World"));
		dataSphere2.setInventory1(new BasicInventory("Item 1", (byte) 3, 4));
		dataSphere2.setInventory2(new BasicInventory("Item 2", (byte) 17, 302));

		assertTrue("dataSphere equals dataSphere2", dataSphere.equals(dataSphere2));
		System.out.println("testEquals PASSED");
	}
	
	/**
	 * Tests that DataSphere fails equals properly
	 */
	@Test
	public void testNotEquals(){
		DataSphere dataSphere = new DataSphere();
		DataSphere dataSphere2 = new DataSphere();
		
		dataSphere.setWorldInventory(new WorldInventory("The World"));
		dataSphere.setInventory1(new BasicInventory("Item 1", (byte) 3, 4));
		dataSphere.setInventory2(new BasicInventory("Item 2", (byte) 17, 302));
		dataSphere2.setWorldInventory(new WorldInventory("The OTHER World"));
		dataSphere2.setInventory1(new BasicInventory("Item OTHER 1", (byte) 5, 40));
		dataSphere2.setInventory2(new BasicInventory("Item OTHER 2", (byte) 11, 32));

		assertFalse("dataSphere does not equal dataSphere2", dataSphere.equals(dataSphere2));
		System.out.println("testNotEquals PASSED");
	}

}
