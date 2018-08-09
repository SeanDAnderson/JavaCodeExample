package edu.regis.msse670.view.mainjframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import edu.regis.msse670.model.business.manager.InventoryManager;
import edu.regis.msse670.model.domain.DataSphere;

public class MainJFrameController implements ActionListener {
	DataSphere dataSphere;
	MainJFrame mainJFrame;
	private InventoryManager inventoryManager;
	
	public MainJFrameController (MainJFrame mainJFrame, DataSphere dataSphere){
		this.dataSphere = dataSphere;
		this.mainJFrame = mainJFrame;
		inventoryManager = new InventoryManager();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Saves the active WorldInventory and returns confirmation message
	 */
	public void saveWorldInventory(){
		if(dataSphere == null){
			JOptionPane.showMessageDialog(mainJFrame, "WorldInventory Not Initialized!");
			return;
		}
		if(dataSphere.getWorldInventory() != null){
			if(inventoryManager.performAction("saveWorldInventory", dataSphere)){
				JOptionPane.showMessageDialog(mainJFrame, "New World Inventory Saved Successfully.");
			}
			else {
				JOptionPane.showMessageDialog(mainJFrame, "There was an error, World Inventory not saved.");
			}
		}
		else {
			JOptionPane.showMessageDialog(mainJFrame, "You must have a World Inventory to save.");
		}
		
	}
	
	/**
	 * Automates internal frame construction
	 * 
	 * @param name	String for the internal frame's name
	 * @param jPanel	JPanel for the internal frame's content
	 * @return	JInternal frame created by the method.
	 */
	public JInternalFrame createInternalFrame(String name, JPanel jPanel){
		JInternalFrame internalFrame = new JInternalFrame(name, true, true);
		internalFrame.add(jPanel);
		internalFrame.setSize(400, 400);
		internalFrame.pack();
		internalFrame.setVisible(true);
		return internalFrame;
	}

}
