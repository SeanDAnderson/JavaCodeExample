package edu.regis.msse670.model.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryMoteTest {

	/** 
	 * Tests if a valid object is created with a valid BasicInventory passed in
	 * */
	@Test
	public void testValidate() {
		InventoryMote mote1 = new InventoryMote("Magic", "Magic");
		assertTrue("mote1 validates", mote1.validate());
		System.out.println("testValidate PASSED");

}

	 /**
	 * Tests if an invalid object is created with an invalid BasicInventory passed in
	 * */	
	@Test 
	public void testNotValidate() {
		String notAString = null;
		InventoryMote mote1 = new InventoryMote(notAString, "Magic");;
		assertFalse("mote1 does not validate", mote1.validate());
		System.out.println("testNotValidate PASSED");
		
	}
	
	/** 
	 * Tests if two InventoryMotes are equal
	 * */
	@Test
	public void testEquals() {
		InventoryMote mote1 = new InventoryMote("Magic", "Magic");
		InventoryMote mote2 = new InventoryMote("Magic", "Magic");
		assertTrue("mote1 equals mote2", mote1.equals(mote2));
		System.out.println("testEquals PASSED");
	}
	
	/**
	 * Tests if two InventorieMotes are non equal
	 *  */
	@Test
	public void testNotEquals() {
		InventoryMote mote1 = new InventoryMote("Magic", "Magic");
		InventoryMote mote2 = new InventoryMote("Science", "Science");
		assertFalse("mote1 does NOT equal mote2", mote1.equals(mote2));
		System.out.println("testNotEquals PASSED");		
	}

}
