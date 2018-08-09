package edu.regis.msse670.model.services.worldinventoryservice;

import java.util.ArrayList;

import edu.regis.msse670.model.domain.Inventory;
import edu.regis.msse670.model.domain.WorldInventory;
import edu.regis.msse670.model.services.exception.NullInventoryException;
import edu.regis.msse670.model.services.exception.WorldInventoryLoadException;
import edu.regis.msse670.model.services.exception.WorldInventorySaveException;

import java.io.*;



/**
 * The services specific to WorldInventory objects.
 * Note that Inventory services can also be use on WorldInventory objects.
 * @author Sean
 *
 */
public class WorldInventoryServicesImpl implements IWorldInventoryServices {

	/** 
	 * Check all Inventory objects, beginning with the submitted WorldInventory, to see if any
	 * have a name that is identical to the name fed to the method. 
	 * 
	 * Returns true if the name is unique (there is no other object with an identical name)
	 * Returns false if the name is not unique (there is another object with an identical name) 
	 * 
	 * @param worldInventory WorldInventory object to be searched for the name
	 * @param name String to be searched for uniqueness in the WorldInventory
	 * @return	Boolean indicating uniqueness of name (true) or non-uniqueness of name (false)
	 * @throws	NullInventoryException
	 * */
	public boolean nameIsUnique(Inventory worldInventory, String name) throws NullInventoryException {
		System.out.println("Entering Method WorldInventorySerivicesImpl::nameIsUnique");
		ArrayList<Inventory> inv;
		
		try{
		inv = worldInventory.getObjectInventory();
		
			if(worldInventory.getName() == name){
				System.out.println("Name is already in use.");
				return false;
			}
			System.out.println(worldInventory.getName() + " is not the same as " + name);
			if (worldInventory.getInventoryStored()>0){
				for (int i = 0; i < worldInventory.getInventoryStored(); i++){
			
					if(!nameIsUnique(inv.get(i), name)){
						System.out.println("Name is already in use.");
						return false;
					}
				
					System.out.println(name + " is not the same as " + inv.get(i).getName());
				}
			}
		}
		catch(NullPointerException npe){
			System.out.println("Uninitialized Inventory object in WorldInventory!");
			throw new NullInventoryException ("Uninitialized Inventory object in WorldInventory!", npe);
		}	
		
		return true;
	}

	/**
	 * Writes the nested inventories within a WorldInventory to a file using serialization.
	 *  
	 * @param inventory WorldInventory object to be saved
	 * @return	Boolean indicating whether or not the file was successfully saved.
	 * @throws WorldInventorySaveException
	 */
	public boolean saveWorldInventory(WorldInventory inventory) throws WorldInventorySaveException {
		String worldInventoryName;
		OutputStream file;
		OutputStream buffer;
		ObjectOutput output;
		
		if (inventory == null){
			System.out.print("Inventory Null, cannot write to file");
			return false;
		}
		worldInventoryName = inventory.getName(); 
		try{
			file = new FileOutputStream(worldInventoryName + ".ser");
			buffer = new BufferedOutputStream(file);
			output = new ObjectOutputStream(buffer); 
		
			try{
				output.writeObject(inventory);
			}
			finally{
				output.close();
			}
		}
		catch (FileNotFoundException fnfe) {
			System.out.println(worldInventoryName + ".ser could not be found. File not loaded.");
			throw new WorldInventorySaveException ("File not found, no file loaded.", fnfe);
		}
		catch (IOException ioe){
			System.out.println("IOException, file not saved.");
			throw new WorldInventorySaveException ("IOException, file not saved", ioe);
		}
	
		
		
		
		return true; 
	}
	
	
	/**
	 * Loads a previously saved WorldInventoryObject.
	 * 
	 * @param	location String indicating the location of the file to be loaded.
	 * @return	WorldInventory object loaded from file.
	 */
	public WorldInventory loadWorldInventory(String location) throws WorldInventoryLoadException {
		WorldInventory worldInventory;
		InputStream file;
		InputStream buffer;
		ObjectInput input;
		
		try{
			file = new FileInputStream(location);
			buffer = new BufferedInputStream(file);
			input = new ObjectInputStream(buffer);
			try{	
				worldInventory = (WorldInventory)input.readObject();
			}
			finally {	
				input.close();
			}
		}
		catch (FileNotFoundException fnfe) {
			System.out.println(location + " could not be found. File not loaded.");
			throw new WorldInventoryLoadException ("FileNotFoundException, no file loaded.", fnfe);
		}
		catch (IOException ioe){
			System.out.println("IOException, file not saved.");
			throw new WorldInventoryLoadException ("IOException, file not loaded", ioe);
		}
		catch (ClassNotFoundException cnfe){
			System.out.println("Class not found. WorldInventory load failed.");
			throw new WorldInventoryLoadException ("ClassNotFoundException, load failed.", cnfe);
		}
		
		return worldInventory;
	}

	/**
	 * Checks that a WorldInventory object is valid. 
	 * 
	 * @param worldInventory WorldInventory object being evaluated
	 * @return
	 */
	public boolean validateWorldInventory(WorldInventory worldInventory){
		
		if (worldInventory == null){
			return false;
		}
		if (worldInventory.getName() == null){
			return false;
		}
		
		return true;
	}
}
