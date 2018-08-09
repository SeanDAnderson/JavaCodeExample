package edu.regis.msse670.invenstory.services;
import edu.regis.msse670.invenstory.domain.*;

/**
 * Factory Pattern interface for InventoryServicesImpl Plugin
 * @author Sean
 *
 */
public interface IInventoryServices {

	public boolean addToInventory(Inventory inventory, Inventory item);
	
	public boolean validateInventoryName(String name);
	
	public boolean validateInventorySize(String size);
}
