package edu.regis.msse670.invenstory.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasicInventoryTest {

	/** 
	 * Tests if a valid object is created with a valid BasicInventory passed in
	 * */
	@Test
	public void testValidate() {
		BasicInventory inv1 = new BasicInventory("Bob", (byte) 50, 314);
		assertTrue("inv1 validates", inv1.validate());
		System.out.println("testValidate PASSED");

}

	 /**
	 * Tests if an invalid object is created with an invalid BasicInventory passed in
	 * */	
	@Test 
	public void testNotValidate() {
		String notAString = null;
		BasicInventory inv1 = new BasicInventory(notAString, (byte) 50, 314);
		assertFalse("inv1 does not validate", inv1.validate());
		System.out.println("testNotValidate PASSED");
		
	}
	
	/** 
	 * Tests if two BasicInventories are equal
	 * */
	@Test
	public void testEquals() {
		BasicInventory inv1 = new BasicInventory("The World", (byte) 50, 314);
		BasicInventory inv2 = new BasicInventory("The World", (byte) 50, 314);
		assertTrue("inv1 equals inv2", inv1.equals(inv2));
		System.out.println("testEquals PASSED");
	}
	
	/**
	 * Tests if two BasicInventories are non equal
	 *  */
	@Test
	public void testNotEquals() {
		BasicInventory inv1 = new BasicInventory("The World", (byte) 50, 314);
		BasicInventory inv2 = new BasicInventory("The Bolivian Navy on maneuvers in the South Pacific", (byte) 4, 12);
		assertFalse("inv1 does NOT equal inv2", inv1.equals(inv2));
		System.out.println("testNotEquals PASSED");		
	}
}
