package edu.regis.msse670.invenstory.services;

/**
 * Factory for creating service objects to be passed to the Business tier.
 * @author Sean
 *
 */
public class ServiceFactory {

	/** 
	 * Creates an object to provide services related to Inventory subclass objects
	 * */
	public IInventoryServices getInventoryServices(){
	
		return new InventoryServicesImpl();
	}
	
	/** 
	 * Creates an object to provide services related to a WorldInventory object.
	 */
	public IWorldInventoryServices getWorldInventoryServices(){
		
		return new WorldInventoryServicesImpl();
	}
}
