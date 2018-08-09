package edu.regis.msse670.view.worldinventoryjpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.regis.msse670.model.business.manager.InventoryManager;
import edu.regis.msse670.model.domain.DataSphere;
import edu.regis.msse670.model.domain.WorldInventory;

public class WorldInventoryJPanelController implements ActionListener {
	private WorldInventoryJPanel worldInventoryJPanel;
	private InventoryManager inventoryManager;
	protected DataSphere dataSphere;
	
	public WorldInventoryJPanelController (){	
	}
	
	/**
	 * Constructor which assigns action listeners.
	 * 
	 * @param wijp	WorldInventoryJPanel that created the controller
	 * @param ds	DataSphere from the WorldInventoryJPanel for passing data
	 */
	public WorldInventoryJPanelController (WorldInventoryJPanel wijp, DataSphere ds){
		dataSphere = ds;
		worldInventoryJPanel = wijp;
		inventoryManager = new InventoryManager();
		
		worldInventoryJPanel.getNewWorldInventoryButton().addActionListener(this);
		worldInventoryJPanel.getSaveWorldInventoryButton().addActionListener(this);
	}
	
	/**
	 * Routes event triggers to desired methods.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(worldInventoryJPanel.getNewWorldInventoryButton())){
			newWorldInventory();
		}
		else if(e.getSource().equals(worldInventoryJPanel.getSaveWorldInventoryButton())){
			saveWorldInventory();
		}
	}
	
	/**
	 * Creates a new WorldInventory, saves it and returns confirmation message
	 */
	private void newWorldInventory(){
		dataSphere.setWorldInventory(new WorldInventory(worldInventoryJPanel.getNewWorldInventoryName()));
		System.out.println(worldInventoryJPanel.getNewWorldInventoryName());
		if(inventoryManager.performAction("newWorldInventory", dataSphere)){
			JOptionPane.showMessageDialog(worldInventoryJPanel.getJFrame(), "New World Inventory Created Successfully.");
			worldInventoryJPanel.updateWorldInventoryName();
		}
		else {
			JOptionPane.showMessageDialog(worldInventoryJPanel.getJFrame(), "There was an error, World Inventory not finalized.");
		}
	}
	
	/**
	 * Saves the active WorldInventory and returns confirmation message
	 */
	private void saveWorldInventory(){
		if(dataSphere.getWorldInventory() != null){
			if(inventoryManager.performAction("saveWorldInventory", dataSphere)){
				JOptionPane.showMessageDialog(worldInventoryJPanel.getJFrame(), "New World Inventory Saved Successfully.");
			}
			else {
				JOptionPane.showMessageDialog(worldInventoryJPanel.getJFrame(), "There was an error, World Inventory not saved.");
			}
		}
		else {
			JOptionPane.showMessageDialog(worldInventoryJPanel.getJFrame(), "You must have a World Inventory to save.");
		}
	}

}
