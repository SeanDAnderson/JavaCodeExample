package edu.regis.msse670.invenstory.services;

import edu.regis.msse670.invenstory.domain.WorldInventory;

/**
 * Factory pattern interface for WorldInventoryServicesImpl plugin
 * @author Sean
 *
 */
public interface IWorldInventoryServices {

	public boolean nameIsUnique(WorldInventory worldInventory, String name);
	
	public boolean saveWorldInventory(WorldInventory worldInventory);
	
}
