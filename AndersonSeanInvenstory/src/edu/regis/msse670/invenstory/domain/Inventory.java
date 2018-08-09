package edu.regis.msse670.invenstory.domain;

import java.util.*;
import java.io.*;

/**
 * The <code>Inventory</code> class represents objects which can contain other
 * <code>Inventory</code> objects in an internal inventory array. It is abstract,
 * and cannot be implemented itself. Rather it is extended into the classes:
 * <code>WorldInv</code>, <code>BasicInv</code>
 * And future classes:
 * <code>EffectInv</code>, <code>TriggerInv</code>, <code>MoteInv</code> and <code>ItemInv</code>
 * @author Sean
 *
 */
public abstract class Inventory implements Serializable {

	private static final long serialVersionUID = -874226773898054104L;

	/**The value is used as the primary identifier for the object and must be unique. */
	public String name;
	
	/**The value is used to determine in another inventory is allowed to be stored within
	 * the object. only objects with higher tier values are allowed to be stored.
	 * The exception is tier -1, which can be stored in any object but never accepts other
	 * objects for storage. 
	 */
	protected byte tier;
	
	/**The ArrayList acts as 'storage' for other <code>Inventory</code> objects.
	 * The maximum number of stored objects is defined by <code>inventoryMax</code>
	 * and the current number of stored items is tracked by <code>inventoryStored</code>.
	 */
	protected ArrayList<Inventory> objectInventory;
	
	/**Value sets the maximum stored objects. 0 allows no storage*/
	protected int inventoryMax;
	/**Value tracks number of currently stored objects */
	protected int inventoryStored;

	/** Validates that there are no unexpected null values within the object.
	 * Note that both byte and int default to a non-null value (0) and that
	 * objectInventory is expected to return null when empty.
	 * 
	 *  @return boolean
	 * */
	public boolean validate(){
		if (name == null) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the tier
	 */
	public byte getTier() {
		return tier;
	}

	/**
	 * @param tier the tier to set
	 */
	public void setTier(byte tier) {
		this.tier = tier;
	}

	/**
	 * @return the objectInventory
	 */
	public ArrayList<Inventory> getObjectInventory() {
		return objectInventory;
	}

	/**
	 * @param objectInventory the objectInventory to set
	 */
	public void setObjectInventory(ArrayList<Inventory> objectInventory) {
		this.objectInventory = objectInventory;
	}

	/**
	 * @return the inventoryMax
	 */
	public int getInventoryMax() {
		return inventoryMax;
	}

	/**
	 * @param inventoryMax the inventoryMax to set
	 */
	public void setInventoryMax(int inventoryMax) {
		this.inventoryMax = inventoryMax;
	}

	/**
	 * @return the inventoryStored
	 */
	public int getInventoryStored() {
		return inventoryStored;
	}

	/**
	 * @param inventoryStored the inventoryStored to set
	 */
	public void setInventoryStored(int inventoryStored) {
		this.inventoryStored = inventoryStored;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + inventoryMax;
		result = prime * result + inventoryStored;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((objectInventory == null) ? 0 : objectInventory.hashCode());
		result = prime * result + tier;
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		if (inventoryMax != other.inventoryMax)
			return false;
		if (inventoryStored != other.inventoryStored)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (objectInventory == null) {
			if (other.objectInventory != null)
				return false;
		} else if (!objectInventory.equals(other.objectInventory))
			return false;
		if (tier != other.tier)
			return false;
		return true;
	}
	
	
	
	
}
