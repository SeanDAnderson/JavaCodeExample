package edu.regis.msse670.invenstory.services;

import edu.regis.msse670.invenstory.domain.Inventory;

/**
 * The services related to Inventory objects (including subclasses such as
 * BasicInventory and WorldInventory).
 * Currently stubs, more documentation when methods are implemented
 * @author Sean
 *
 */
public class InventoryServicesImpl implements IInventoryServices {

	/** 
	 * Currently a stub, full documentation when method is implemented
	 * 
	 * @param	inventory	Inventory object that an object is being added to
	 * @param	item	Inventory object being added to inventory
	 * */
	public boolean addToInventory(Inventory inventory, Inventory item) {
		// TODO Auto-generated method stub
		System.out.println("Entering Method InventoryServicesImpl::addToInventory");
		checkInventoryAdd(inventory, item);
		return true;
	}

	/** 
	 * Currently a stub, full documentation when method is implemented
	 * 
	 * @param	name	String to be validated as an object name
	 * */
	public boolean validateInventoryName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Entering Method InventoryServicesImpl::validateInventoryName");
		return true;
	}
	
	/** 
	 * Currently a stub, full documentation when method is implemented
	 * 
	 * @param	size	String user input to be validated as an InventorySize int 
	 * */
	public boolean validateInventorySize(String size) {
		// TODO Auto-generated method stub
		System.out.println("Entering Method InventoryServicesImpl::validateInventorySize");
		return true;
	}
	
	/** 
	 * Currently a stub, full documentation when method is implemented
	 * 
	 * @param	inventory	Inventory object being checked for legal item addition
	 * @param	item	Inventory object being checked to be added to inventory
	 * */	
	private boolean checkInventoryAdd(Inventory inventory, Inventory item) {
		// TODO Auto-generated method stub
		System.out.println("Entering Method InventoryServicesImpl::checkInventoryAdd");
		return true;
	}

}
