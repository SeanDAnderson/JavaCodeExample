package edu.regis.msse670.model.domain;

import java.util.ArrayList;

/**
 * Mote Inventory Class. Motes are used to define the characteristics of all other inventory objects.
 * Motes have only names and tags available, by placing a mote into another inventory the characteristics
 * of that inventory are defined.
 * 
 * For instance, placing a Mote with the "Continent" tag into an inventory will allow the game system to
 * identify that inventory as a continent-type region.
 * 
 * Note: Currently Inventories can only be added to WorldInventory objects.
 * 
 * @author Sean
 *
 */
public class InventoryMote extends Inventory {

	private static final long serialVersionUID = 2828300784949853576L;

	/**
	 * Tag is used for declaring item type for event handling (not yet implemented)
	 */
	private String tag;
	
	/**
	 * Mote constructor.
	 * 
	 * @param name
	 * @param tag
	 */
	public InventoryMote (String name, String tag){
		this.name = name;
		this.tag = tag;
		this.inventoryMax = 0;
		this.inventoryStored = 0;
		this.objectInventory = new ArrayList<Inventory>(inventoryMax);
		this.tier = (byte) 127;
	}

	/**
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryMote other = (InventoryMote) obj;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}
	
	
	
}
