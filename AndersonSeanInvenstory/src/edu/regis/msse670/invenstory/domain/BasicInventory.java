package edu.regis.msse670.invenstory.domain;

import java.util.*;

/**
 * BasicInventory is the most basic implementation of the Inventory abstact class.
 * It contains a unique identifying name, a tier and a <code>Storable</code> array.
 * The inventoryMax and inventoryStored ints are used to limit and track the contents of the
 * array respectively. This object will make up the bulk of a fully populated WorldInventory.
 * 
 * @author Sean
 * @version 1.0
 */
public class BasicInventory extends Inventory {

	private static final long serialVersionUID = 2329312783652212227L;

	/**
	 * Allocates a new inventory object.
	 * 
	 * @param	name	String for the object's name
	 * @param	tier	Byte for object's storage tier 
	 * @param	inventoryMax	Int defining the maximum number of objects that can be stored in the object inventory*/
public BasicInventory(String name, byte tier, int inventoryMax){
	this.name = name;
	this.tier = tier;
	this.inventoryMax = inventoryMax;
	inventoryStored = 0;
	objectInventory = new ArrayList<Inventory>(inventoryMax);
	
}	

}
