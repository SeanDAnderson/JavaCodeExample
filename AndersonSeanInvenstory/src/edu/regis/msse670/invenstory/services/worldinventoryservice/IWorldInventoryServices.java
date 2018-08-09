package edu.regis.msse670.invenstory.services.worldinventoryservice;

import edu.regis.msse670.invenstory.domain.*;
import edu.regis.msse670.invenstory.services.IService;
import edu.regis.msse670.invenstory.services.exception.*;

/**
 * Factory pattern interface for WorldInventoryServicesImpl plugin
 * @author Sean
 *
 */
public interface IWorldInventoryServices extends IService{
	public final String NAME = "IWorldInventoryServices";

	public boolean nameIsUnique(Inventory worldInventory, String name) throws NullInventoryException;

	public boolean saveWorldInventory(WorldInventory inventory) throws WorldInventorySaveException;
	
	public WorldInventory loadWorldInventory(String location) throws WorldInventoryLoadException;
	
	public boolean validateWorldInventory(WorldInventory worldInventory);
}
