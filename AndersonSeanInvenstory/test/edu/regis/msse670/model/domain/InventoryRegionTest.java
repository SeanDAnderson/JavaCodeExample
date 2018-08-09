package edu.regis.msse670.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryRegionTest {

	/** 
	 * Tests if a valid object is created with a valid InventoryRegion passed in
	 * */
	@Test
	public void testValidate() {
		InventoryRegion region1 = new InventoryRegion("Ironforge");
		assertTrue("region1 validates", region1.validate());
		System.out.println("testValidate PASSED");

}

	 /**
	 * Tests if an invalid object is created with an invalid InventoryRegion passed in
	 * */	
	@Test 
	public void testNotValidate() {
		String notAString = null;
		InventoryRegion region1 = new InventoryRegion(notAString);
		assertFalse("region1 does not validate", region1.validate());
		System.out.println("testNotValidate PASSED");
		
	}
	
	/** 
	 * Tests if two InventoryRegions are equal
	 * */
	@Test
	public void testEquals() {
		InventoryRegion region1 = new InventoryRegion("Ironforge");
		InventoryRegion region2 = new InventoryRegion("Ironforge");
		assertTrue("region1 equals region2", region1.equals(region2));
		System.out.println("testEquals PASSED");
	}
	
	/**
	 * Tests if two InventoryRegions are non equal
	 *  */
	@Test
	public void testNotEquals() {
		InventoryRegion region1 = new InventoryRegion("Ironforge");
		InventoryRegion region2 = new InventoryRegion("Dalaran");
		assertFalse("region1 does NOT equal region2", region1.equals(region2));
		System.out.println("testNotEquals PASSED");		
	}

}
