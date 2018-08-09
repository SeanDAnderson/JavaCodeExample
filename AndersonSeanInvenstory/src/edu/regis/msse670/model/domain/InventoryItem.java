package edu.regis.msse670.model.domain;

import java.util.ArrayList;

/**
 * Item object class, used to define in-world items within the game world.
 * Limited to containing other items (for storage containers and refillable items like bottle)
 * and Motes (for definition of system rules) and BasicInventories as Item or Mote tiers.
 * 
 * @author Sean
 *
 */
public class InventoryItem extends Inventory {

	private static final long serialVersionUID = -5320773736699176637L;

	/**
	 * Tag is used for declaring item type for event handling (not yet implemented)
	 */
	private String tag;
	
	/**
	 * Standard Item Constructor
	 * Tier is set to 126 so items can only contain other items and Motes.
	 * 
	 * @param name	String name of the item
	 * @param inventoryMax	Int size of the items internal inventory
	 * @param tag	String item type designator
	 */
	public InventoryItem (String name, int inventoryMax, String tag){
		this.name = name;
		this.inventoryMax = inventoryMax;
		this.inventoryStored = 0;
		this.tier = (byte) 126;
		this.objectInventory = new ArrayList<Inventory>(inventoryMax);
		this.tag = tag;
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
		InventoryItem other = (InventoryItem) obj;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}
	
	
	
}
