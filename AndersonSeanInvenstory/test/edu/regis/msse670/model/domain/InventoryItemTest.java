package edu.regis.msse670.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryItemTest {

	/** 
	 * Tests if a valid object is created with a valid InventoryItem passed in
	 * */
	@Test
	public void testValidate() {
		InventoryItem item1 = new InventoryItem("Doomhammer", 8, "hammer");
		assertTrue("inv1 validates", item1.validate());
		System.out.println("testValidate PASSED");

}

	 /**
	 * Tests if an invalid object is created with an invalid InventoryItem passed in
	 * */	
	@Test 
	public void testNotValidate() {
		String notAString = null;
		InventoryItem item1 = new InventoryItem(notAString, 8, "hammer");
		assertFalse("inv1 does not validate", item1.validate());
		System.out.println("testNotValidate PASSED");
		
	}
	
	/** 
	 * Tests if two InventorieItems are equal
	 * */
	@Test
	public void testEquals() {
		InventoryItem item1 = new InventoryItem("Doomhammer", 8, "hammer");
		InventoryItem item2 = new InventoryItem("Doomhammer", 8, "hammer");
		assertTrue("item1 equals item2", item1.equals(item2));
		System.out.println("testEquals PASSED");
	}
	
	/**
	 * Tests if two InventorieItems are non equal
	 *  */
	@Test
	public void testNotEquals() {
		InventoryItem item1 = new InventoryItem("Doomhammer", 8, "hammer");
		InventoryItem item2 = new InventoryItem("Frostmourne", 8, "sword");
		assertFalse("item1 does NOT equal item2", item1.equals(item2));
		System.out.println("testNotEquals PASSED");		
	}

}
