package edu.regis.msse670.invenstory.domain;

/**
 * WorldInventory is the lowest tier inventory in the inventory heirarchy. 
 * All other inventories must be stored within the WorldInventory,
 * whether directly or as part of another inventory. The tier logic only allows a
 * <code>Storable</code> to be stored in another inventory of the same tier or lower.
 * WorldInventory is the only inventory that can accept every other item.
 * There can only be a single WorldInventory at a time.
 * 
 * @author Sean
 * @version 1.0 
 */
public class WorldInventory extends Inventory {


	
	/**Allocated a new WorldInventory object 
	 * 
	 * @param	name	String defining the inventory's ID, should be unique
	 * */
	public WorldInventory(String name) {
		this.name = name;
		
		/** The maximum number of stored items is limited only by the range of int,
		 * in order to avoid errors related to inventoryStored trying to exceed that value */
		inventoryMax = 2147483647;
		
		/** The WorldInventory is the lowest tier inventory in the heirarchy at 0.
		 * This value cannot not be changed.*/
		tier = 0;
		
		inventoryStored = 0;
	}
	
	@Override
	/**Overrides the default setter because the WorldInventory variable is final.
	 * 
	 *	@param	tier	Byte accepted to ensure override rather than overload.*/
	public void setTier(byte tier){
	 System.out.println("World Inventory tier cannot be changed.");
	}

}
