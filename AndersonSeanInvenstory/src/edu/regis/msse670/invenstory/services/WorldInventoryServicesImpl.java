package edu.regis.msse670.invenstory.services;

import edu.regis.msse670.invenstory.domain.*;

/**
 * The services specific to WorldInventory objects.
 * Note that Inventory services can also be use on WorldInventory objects.
 * @author Sean
 *
 */
public class WorldInventoryServicesImpl implements IWorldInventoryServices {

	/** 
	 * Currently a stub, full documentation when method is implemented
	 * 
	 * @param worldInventory WorldInventory object to be searched for the name
	 * @param name String to be searched for uniqueness in the WorldInventory
	 * */
	public boolean nameIsUnique(WorldInventory worldInventory, String name) {
		// TODO Auto-generated method stub
		System.out.println("Entering Method WorldInventorySerivicesImpl::nameIsUnique");
		return true;
	}

	
	/** 
	 * Currently a stub, full documentation when method is implemented
	 * 
	 * @param	worldInventory WorldInventory object to be exported to a save file
	 * */
	public boolean saveWorldInventory(WorldInventory worldInventory) {
		// TODO Auto-generated method stub
		System.out.println("Entering Method WorldInventoryServicesImpl::saveWorldInventory");
		return true;
	}

}
