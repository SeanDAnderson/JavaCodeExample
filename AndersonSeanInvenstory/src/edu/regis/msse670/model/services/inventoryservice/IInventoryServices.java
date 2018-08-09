package edu.regis.msse670.model.services.inventoryservice;

import edu.regis.msse670.model.domain.Inventory;
import edu.regis.msse670.model.services.IService;
import edu.regis.msse670.model.services.exception.NullInventoryException;

/**
 * Factory Pattern interface for InventoryServicesImpl Plugin
 * @author Sean
 *
 */
public interface IInventoryServices extends IService {
	
	public final String NAME = "IInventoryServices";

	public boolean addToNext(Inventory inventory, Inventory item) throws NullInventoryException;
	
	public boolean validateInventoryName(String name);
}
