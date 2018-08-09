package edu.regis.msse670.model.business.manager;

import edu.regis.msse670.model.domain.DataSphere;
import edu.regis.msse670.model.services.exception.NullInventoryException;
import edu.regis.msse670.model.services.exception.ServiceNotFoundException;
import edu.regis.msse670.model.services.exception.WorldInventorySaveException;
import edu.regis.msse670.model.services.inventoryservice.IInventoryServices;
import edu.regis.msse670.model.services.worldinventoryservice.IWorldInventoryServices;

/**
 * A Manager to handle common Inventory use cases.
 * @author Maledictor
 *
 */
public class InventoryManager extends Manager {

	/**
	 * Override of Manager performActrion
	 * Included methods:
	 * newWorldInventory
	 * saveWorldInventory
	 * addToInventory
	 */
	@Override
	public boolean performAction(String commandString, DataSphere dataSphere) {
		
		boolean action = false;
		 
			
		switch (commandString) {
		case "newWorldInventory": action = newWorldInventory(dataSphere);
			break;
		case "saveWorldInventory": action = saveWorldInventory(dataSphere);
			break;
		case "addToInventory": action = addToInventory(dataSphere);
			break;
		}
		
		
		return action;
	}
	
	
	
	
	
	
	/**
	 * Saves a newly created world inventory. 
	 * 
	 * @param dataSphere
	 * @return Boolean returns true if successful and false if failed
	 */
	public boolean newWorldInventory (DataSphere dataSphere) {
		boolean isCreated = false;
		IWorldInventoryServices iWorldInventoryServices;
		 
		
			try{
				iWorldInventoryServices = (IWorldInventoryServices) factory.getService("IWorldInventoryServices");
				if(iWorldInventoryServices.validateWorldInventory(dataSphere.getWorldInventory())){
					isCreated = iWorldInventoryServices.saveWorldInventory(dataSphere.getWorldInventory());
				}
				else {
					System.out.println("Invalid WorldInventory, could not be created.");
				}
			}
			catch (WorldInventorySaveException wise){
				System.out.println("The WorldInventory " + dataSphere.getWorldInventory().getName() + " could not be created.");
			}
			catch (ServiceNotFoundException snfe) {
				System.out.println("The requested service was not found. The WorldInventory " + dataSphere.getWorldInventory().getName() + " could not be created.");
			}
		
		return isCreated;
	}
	
	
	/**
	 * Saves a pre-existing world inventory. 
	 * 
	 * @param dataSphere
	 * @return
	 */
	public boolean saveWorldInventory (DataSphere dataSphere) {
		boolean isSaved = false;
		
		IWorldInventoryServices iWorldInventoryServices;
		
		
		try{
			iWorldInventoryServices = (IWorldInventoryServices) factory.getService("IWorldInventoryServices");
			isSaved = iWorldInventoryServices.saveWorldInventory(dataSphere.getWorldInventory());
		}
		catch (WorldInventorySaveException wise){
			System.out.println("The WorldInventory " + dataSphere.getWorldInventory().getName() + " could not be saved.");
		}
		catch (ServiceNotFoundException snfe) {
			System.out.println("The requested service was not found. The WorldInventory " + dataSphere.getWorldInventory().getName() + " could not be saved.");
		}

		
		return isSaved;		
	}
	
	/**
	 * Adds an item to the designated inventory. 
	 * Inventory 1 is the receiving inventory.
	 * Inventory 2 is the item being added.
	 * 
	 * @param dataSphere DataSphere containing items 1 and 2.
	 * @return Boolean returns true if added successfully and false is adding failed. 
	 */
	public boolean addToInventory (DataSphere dataSphere) {
		boolean isAdded = false;
		
		IInventoryServices iInventoryServices; 
		
		try{
			iInventoryServices = (IInventoryServices) factory.getService("IInventoryServices");
			isAdded = iInventoryServices.addToNext(dataSphere.getInventory1(), dataSphere.getInventory2());
		}
		catch (NullInventoryException nie) {
			System.out.println("NullInventoryException, item could not be added to inventory.");
		}
		catch (ServiceNotFoundException snfe){
			System.out.print("The requested service was not found. The item was not added to the inventory.");
		}
		
		
		return isAdded;
	}
	
}
