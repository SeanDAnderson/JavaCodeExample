package edu.regis.msse670.model.domain;

import java.io.Serializable;

/**
 * Composite object for the easy transfer of data between the business layer and the presentation layer
 * 
 * inventory1 is the primary storage for inventory objects.
 * inventory2 is only used in functions where a second inventory object is 
 * 
 * @author Maledictor
 *
 */
public class DataSphere implements Serializable {

	private static final long serialVersionUID = -5701732774474523615L;

	private WorldInventory worldInventory;
	private Inventory inventory1;
	private Inventory inventory2;
	
	/**
	 * Validates that there are no null values within the DataSphere.
	 * 
	 * @return
	 */
	public boolean validate(){
		if (worldInventory == null){
			return false;
		}
		if (inventory1 == null){
			return false;
		}
		if (inventory2 == null){
			return false;
		}
		
		return true;
	}
	
	
	/**
	 * @return the worldInventory
	 */
	public WorldInventory getWorldInventory() {
		return worldInventory;
	}
	/**
	 * @param worldInventory the worldInventory to set
	 */
	public void setWorldInventory(WorldInventory worldInventory) {
		this.worldInventory = worldInventory;
	}
	/**
	 * @return the inventory1
	 */
	public Inventory getInventory1() {
		return inventory1;
	}
	/**
	 * @param inventory1 the inventory1 to set
	 */
	public void setInventory1(Inventory inventory1) {
		this.inventory1 = inventory1;
	}
	/**
	 * @return the inventory2
	 */
	public Inventory getInventory2() {
		return inventory2;
	}
	/**
	 * @param inventory2 the inventory2 to set
	 */
	public void setInventory2(Inventory inventory2) {
		this.inventory2 = inventory2;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inventory1 == null) ? 0 : inventory1.hashCode());
		result = prime * result + ((inventory2 == null) ? 0 : inventory2.hashCode());
		result = prime * result + ((worldInventory == null) ? 0 : worldInventory.hashCode());
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
		DataSphere other = (DataSphere) obj;
		if (inventory1 == null) {
			if (other.inventory1 != null)
				return false;
		} else if (!inventory1.equals(other.inventory1))
			return false;
		if (inventory2 == null) {
			if (other.inventory2 != null)
				return false;
		} else if (!inventory2.equals(other.inventory2))
			return false;
		if (worldInventory == null) {
			if (other.worldInventory != null)
				return false;
		} else if (!worldInventory.equals(other.worldInventory))
			return false;
		return true;
	}
	
	
	
	
}
