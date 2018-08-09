package edu.regis.msse670.invenstory.services.inventoryservice;
import edu.regis.msse670.invenstory.domain.*;
import edu.regis.msse670.invenstory.services.IService;
import edu.regis.msse670.invenstory.services.exception.NullInventoryException;

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
