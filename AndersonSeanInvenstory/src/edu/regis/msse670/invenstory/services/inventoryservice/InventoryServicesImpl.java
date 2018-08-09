package edu.regis.msse670.invenstory.services.inventoryservice;

import java.util.ArrayList;

import edu.regis.msse670.invenstory.domain.Inventory;
import edu.regis.msse670.invenstory.services.exception.*;

/**
 * The services related to Inventory objects (including subclasses such as
 * BasicInventory and WorldInventory).
 * Currently stubs, more documentation when methods are implemented
 * @author Sean
 *
 */
public class InventoryServicesImpl implements IInventoryServices {

	/** 
	 * Service to add an item object to the next available slot in an inventory.
	 * Verifies that the inventory has space, that the item is allowed into the inventory,
	 * then adds it.
	 * 
	 * Returns false if the item cannot be added to the inventory.
	 * 
	 * @param	inventory	Inventory object that an object is being added to
	 * @param	item	Inventory object being added to inventory
	 * */
	public boolean addToNext(Inventory inventory, Inventory item) throws NullInventoryException {
		System.out.println("Entering Method InventoryServicesImpl::addToInventory");
		if (checkInventoryAdd(inventory, item) == true){
			ArrayList<Inventory> inv = inventory.getObjectInventory();
			inv.add(item);
			inventory.setInventoryStored(inventory.getInventoryStored() + 1);
			return true;
		}
		return false;
	}

	/** 
	 * validateInventoryName checks that the inventory name is not null.
	 * 
	 * @param	name	String to be validated as an object name
	 * */
	public boolean validateInventoryName(String name) {
		System.out.println("Entering Method InventoryServicesImpl::validateInventoryName");
		if(name == null){
			return false;
		}
		
		return true;
	}
	
	/** 
	 * Checks if an item is a legal addition to an inventory.
	 * First checks if the inventory has room (i.e. is not full)
	 * Second checks if the item tier and inventory tier allows the item to be placed into the inventory.
	 * 
	 * Returns true if the placement is legal.
	 * Returns false if the placement is not legal.
	 * 
	 * @param	inventory	Inventory object being checked for legal item addition
	 * @param	item	Inventory object being checked to be added to inventory
	 * */	
	private boolean checkInventoryAdd(Inventory inventory, Inventory item) throws NullInventoryException{
		System.out.println("Entering Method InventoryServicesImpl::checkInventoryAdd");
				
		try{
		//inventory space check
		if(inventory.getInventoryStored() >= inventory.getInventoryMax()) {
			System.out.println("Inventory is full");
			return false;
		}
		
		//Legal tier placement check
		//Items cannot be placed into inventories of a lower tier.
		if(inventory.getTier() > item.getTier()){
			System.out.println("This item cannot be placed in an inventory of " + inventory.getTier());
			return false;
		}
		}
		catch (NullPointerException e){
			throw new NullInventoryException("Cannot add item to null inventory!", e);
		}
		
		return true;
	}

}
