package edu.regis.msse670.invenstory.domain;
/**
 * The <code>Storable</code> interface is used to designate objects that can be
 * stored within an <code>Inventory</code>'s internal inventory array.
 * 
 * Currently there are no non-<code>Inventory</code> class objects, but this will
 * change with future revisions.
 * 
 * @author Sean
 * @version 1.0
 */
public interface Storable {
	public String getName();
	public void setName(String name);
	public byte getTier();
	public void setTier(byte tier);
	public int getInventoryMax();
	public void setInventoryMax(int inventoryMax);
	public int getInventoryStored();
	public void setInventoryStored(int inventoryStored);
	public Storable[] getObjectInventory();
	public void setObjectInventory(Storable[] objectInventory);
	public boolean equals(Object obj);
	public int hashCode();
}
