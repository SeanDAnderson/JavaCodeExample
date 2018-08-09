package edu.regis.msse670.view.inventoryjpanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import edu.regis.msse670.model.business.manager.InventoryManager;
import edu.regis.msse670.model.domain.BasicInventory;
import edu.regis.msse670.model.domain.DataSphere;
import edu.regis.msse670.view.worldinventoryjpanel.WorldInventoryJPanel;

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
		
		inventoryJPanel.getAddButton().addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {


		if(e.getSource().equals(inventoryJPanel.getAddButton())){
			addToWorldInventory();
		}

	}
	
	/**
	 * Adds a newly created Inventory item to the World Inventory
	 */
	private void addToWorldInventory(){
						
		if (dataSphere.getWorldInventory() != null){
			System.out.println("Adding inventory to WorldInventory");
			dataSphere.setInventory1(dataSphere.getWorldInventory());
			dataSphere.setInventory2(inventoryJPanel.getInventory());
			inventoryManager.performAction("addToInventory", dataSphere);
		}
		else{
			System.out.println("No World Inventory");
			JOptionPane.showMessageDialog(inventoryJPanel.getJFrame(), "You must have an active World Inventory first.");
		}
	}

}
