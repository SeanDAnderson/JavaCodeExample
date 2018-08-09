package edu.regis.msse670.invenstory.services.worldinventoryservice;

import edu.regis.msse670.invenstory.domain.*;
import edu.regis.msse670.invenstory.services.IService;
import edu.regis.msse670.invenstory.services.exception.NullInventoryException;

/**
 * Factory pattern interface for WorldInventoryServicesImpl plugin
 * @author Sean
 *
 */
public interface IWorldInventoryServices extends IService{
	public final String NAME = "IWorldInventoryServices";

	public boolean nameIsUnique(Inventory worldInventory, String name) throws NullInventoryException;
	
}
