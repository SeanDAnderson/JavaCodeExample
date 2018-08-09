package edu.regis.msse670.model.domain;

import java.util.ArrayList;

/**
 * Region inventory class. Regions are a step down from the WorldInventory and can
 * contain anything other than the WorldInventory itself, including other regions.
 * 
 * @author Sean
 *
 */
public class InventoryRegion extends Inventory {

	private static final long serialVersionUID = 8161990264909705162L;

	public InventoryRegion (String name){
		this.name = name;
		
		/** The maximum number of stored items is limited only by the range of int,
		 * in order to avoid errors related to inventoryStored trying to exceed that value */
		this.inventoryMax = 2147483647;
		
		/**
		 * Regions are one step below the WorldInventory in scale. The only inventories
		 * they cannot are WorldInventories. They may contain other Regions.
		 */
		this.tier = 1;
		
		this.inventoryStored = 0;
		this.objectInventory = new ArrayList<Inventory>(100);
	}
	
	
}
