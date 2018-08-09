package edu.regis.msse670.view.inventoryjpanel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JSpinner;
import javax.swing.JTextArea;

import javax.swing.SpinnerNumberModel;

import edu.regis.msse670.model.domain.BasicInventory;
import edu.regis.msse670.model.domain.DataSphere;
import edu.regis.msse670.model.domain.Inventory;
import edu.regis.msse670.view.mainjframe.MainJFrame;

public class InventoryJPanel extends JPanel {

	private static final long serialVersionUID = -5352443094195166198L;
	
	protected DataSphere dataSphere;
	protected MainJFrame mainJFrame;
	private InventoryJPanelController inventoryJPanelController;
	
	private JLabel nameLabel;
	private JLabel tierLabel;
	private JLabel inventoryMaxLabel;
	private JTextArea nameText;
	private JSpinner tierSpinner;
	private JSpinner inventoryMaxSpinner;
	private JButton addButton;

	/**
	 * constructor for InventoryJPanel
	 * The rightmost panel which controls non-world Inventories
	 * 
	 * @param mainJFrame	MainJFrame for message creation
	 * @param dataSphere	DataShpere for data passing
	 */
	public InventoryJPanel (MainJFrame mainJFrame, DataSphere dataSphere){
		//assigning DataSphere reference 
		this.dataSphere = dataSphere;
		this.mainJFrame = mainJFrame;
		
		//layout
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setSize(400, 400);
		
		//Label initializations
		nameLabel = new JLabel("Inventory Name:");
		tierLabel = new JLabel("Inventory Tier:");
		inventoryMaxLabel = new JLabel("Maximum Inventory Capacity:");
		//Input initializations
		nameText = new JTextArea("Enter Unique Name", 1, 20);		
		tierSpinner = new JSpinner(new SpinnerNumberModel(10, 0, 127, 1));
		inventoryMaxSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 3000000, 1));
		addButton = new JButton("Add to World Inventory");
		

		this.add(nameLabel);
		this.add(nameText);
		this.add(tierLabel);
		this.add(tierSpinner);
		this.add(inventoryMaxLabel);
		this.add(inventoryMaxSpinner);
		this.add(addButton);
		
		//constructing the controller
		inventoryJPanelController = new InventoryJPanelController(this, dataSphere);
		
	}
	
	public JButton getAddButton(){
		System.out.println("Returning Action Button");
		return addButton;
	}
	
	public DataSphere getDataSphere(){
		return dataSphere;
	}
	
	public MainJFrame getJFrame(){
		return mainJFrame;
	}
	
	/**
	 * Assigns values from user to a Basic Inventory
	 * The input numeric string is converted to a byte.
	 * @return
	 */
	public Inventory getInventory(){
		int i = (int) tierSpinner.getValue();
		byte iByte = (byte) i;
		BasicInventory inventory = new BasicInventory(nameText.getText(), (byte) iByte, (int) inventoryMaxSpinner.getValue());
		return inventory;
	}
	
}
