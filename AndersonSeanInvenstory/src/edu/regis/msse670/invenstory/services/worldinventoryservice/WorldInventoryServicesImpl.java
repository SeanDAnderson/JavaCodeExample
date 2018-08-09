package edu.regis.msse670.invenstory.services.worldinventoryservice;

import java.util.ArrayList;

import edu.regis.msse670.invenstory.domain.*;
import edu.regis.msse670.invenstory.services.exception.*;

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
	public boolean nameIsUnique(Inventory worldInventory, String name) throws NullInventoryException {
		System.out.println("Entering Method WorldInventorySerivicesImpl::nameIsUnique");
		ArrayList<Inventory> inv;
		
		try{
		inv = worldInventory.getObjectInventory();
		
			if(worldInventory.getName() == name){
				System.out.println("Name is already in use.");
				return false;
			}
			System.out.println(worldInventory.getName() + " is not the same as " + name);
			if (worldInventory.getInventoryStored()>0){
				for (int i = 0; i < worldInventory.getInventoryStored(); i++){
			
					if(!nameIsUnique(inv.get(i), name)){
						System.out.println("Name is already in use.");
						return false;
					}
				
					System.out.println(name + " is not the same as " + inv.get(i).getName());
				}
			}
		}
		catch(NullPointerException npe){
			System.out.println("Uninitialized Inventory object in WorldInventory!");
			throw new NullInventoryException ("Uninitialized Inventory object in WorldInventory!", npe);
		}	
		
		return true;
	}


}
