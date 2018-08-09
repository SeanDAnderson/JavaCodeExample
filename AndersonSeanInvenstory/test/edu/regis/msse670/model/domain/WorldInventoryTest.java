package edu.regis.msse670.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorldInventoryTest {

	/** 
	 * Tests if a valid object is created with a valid WorldInventory passed in
	 * */
	@Test
	public void testValidate() {
		WorldInventory world1 = new WorldInventory("The World");
		assertTrue("world1 validates", world1.validate());
		System.out.println("testValidate PASSED");
	}
	 /**
	 * Tests if an invalid object is created with an invalid WorldInventory passed in
	 * */	
	@Test 
	public void testNotValidate() {
		String notAString = null;
		WorldInventory world1 = new WorldInventory(notAString);
		assertFalse("world1 does not validate", world1.validate());
		System.out.println("testNotValidate PASSED");
		
	}
	
	/** 
	 * Tests if two WorldInventories are equal
	 * */
	@Test
	public void testEquals() {
		WorldInventory world1 = new WorldInventory("The World");
		WorldInventory world2 = new WorldInventory("The World");
		assertTrue("world1 equals world2", world1.equals(world2));
		System.out.println("testEquals PASSED");
	}
	
	/**
	 * Tests if two WorldInventories are non equal
	 *  */
	@Test
	public void testNotEquals() {
		WorldInventory world1 = new WorldInventory("The World");
		WorldInventory world2 = new WorldInventory("The Bolivian Navy on maneuvers in the South Pacific");
		assertFalse("world1 does NOT equal world2", world1.equals(world2));
		System.out.println("testNotEquals PASSED");		
	}
}
