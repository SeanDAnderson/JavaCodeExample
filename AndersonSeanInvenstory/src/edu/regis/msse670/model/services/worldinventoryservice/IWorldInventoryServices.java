package edu.regis.msse670.model.services.worldinventoryservice;

import edu.regis.msse670.model.domain.Inventory;
import edu.regis.msse670.model.domain.WorldInventory;
import edu.regis.msse670.model.services.IService;
import edu.regis.msse670.model.services.exception.NullInventoryException;
import edu.regis.msse670.model.services.exception.WorldInventoryLoadException;
import edu.regis.msse670.model.services.exception.WorldInventorySaveException;

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
