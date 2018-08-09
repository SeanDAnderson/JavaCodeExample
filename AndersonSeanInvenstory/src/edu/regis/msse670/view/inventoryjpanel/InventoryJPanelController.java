package edu.regis.msse670.view.inventoryjpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import edu.regis.msse670.model.business.manager.InventoryManager;
import edu.regis.msse670.model.domain.DataSphere;

public class InventoryJPanelController implements ActionListener {
	
	private InventoryJPanel inventoryJPanel;
	private InventoryManager inventoryManager;
	protected DataSphere dataSphere;
	
	/**
	 * InventoryJPanel Controller constructor
	 * 
	 * @param ijp	InventoryJPanel that created the controller
	 * @param ds	DataSphere for data transfer 
	 */
	InventoryJPanelController(InventoryJPanel ijp, DataSphere ds){
		inventoryJPanel = ijp;
		dataSphere = ds;
		inventoryManager = new InventoryManager();
		
		inventoryJPanel.getBIAddButton().addActionListener(this);
		inventoryJPanel.getRIAddButton().addActionListener(this);
		inventoryJPanel.getIIAddButton().addActionListener(this);
		inventoryJPanel.getMoteAddButton().addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {


		if(e.getSource().equals(inventoryJPanel.getBIAddButton())){
			addBIToWorldInventory();
		}
		if(e.getSource().equals(inventoryJPanel.getRIAddButton())){
			addRIToWorldInventory();
		}
		if(e.getSource().equals(inventoryJPanel.getIIAddButton())){
			addIIToWorldInventory();
		}
		if(e.getSource().equals(inventoryJPanel.getMoteAddButton())){
			addMoteToWorldInventory();
		}
		

	}
	
	/**
	 * Adds a newly created Basic Inventory item to the World Inventory
	 */
	private void addBIToWorldInventory(){
						
		if (dataSphere.getWorldInventory() != null){
			System.out.println("Adding inventory to WorldInventory");
			dataSphere.setInventory1(dataSphere.getWorldInventory());
			dataSphere.setInventory2(inventoryJPanel.getBasicInventory());
			inventoryManager.performAction("addToInventory", dataSphere);
		}
		else{
			System.out.println("No World Inventory");
			JOptionPane.showMessageDialog(inventoryJPanel.getJFrame(), "You must have an active World Inventory first.");
		}
	}
	
	/**
	 * Adds a newly created Region Inventory item to the World Inventory
	 */
	private void addRIToWorldInventory(){
		
		if (dataSphere.getWorldInventory() != null){
			System.out.println("Adding Region to WorldInventory");
			dataSphere.setInventory1(dataSphere.getWorldInventory());
			dataSphere.setInventory2(inventoryJPanel.getRegion());
			inventoryManager.performAction("addToInventory", dataSphere);
		}
		else{
			System.out.println("No World Inventory");
			JOptionPane.showMessageDialog(inventoryJPanel.getJFrame(), "You must have an active World Inventory first.");
		}
	}
	
	/**
	 * Adds a newly created Item Inventory item to the World Inventory
	 */
	private void addIIToWorldInventory(){
		
		if (dataSphere.getWorldInventory() != null){
			System.out.println("Adding Item to WorldInventory");
			dataSphere.setInventory1(dataSphere.getWorldInventory());
			dataSphere.setInventory2(inventoryJPanel.getItem());
			inventoryManager.performAction("addToInventory", dataSphere);
		}
		else{
			System.out.println("No World Inventory");
			JOptionPane.showMessageDialog(inventoryJPanel.getJFrame(), "You must have an active World Inventory first.");
		}
	}
	
	/**
	 * Adds a newly created Mote Inventory item to the World Inventory
	 */
	private void addMoteToWorldInventory(){
		
		if (dataSphere.getWorldInventory() != null){
			System.out.println("Adding Mote to WorldInventory");
			dataSphere.setInventory1(dataSphere.getWorldInventory());
			dataSphere.setInventory2(inventoryJPanel.getMote());
			inventoryManager.performAction("addToInventory", dataSphere);
		}
		else{
			System.out.println("No World Inventory");
			JOptionPane.showMessageDialog(inventoryJPanel.getJFrame(), "You must have an active World Inventory first.");
		}
	}

}
