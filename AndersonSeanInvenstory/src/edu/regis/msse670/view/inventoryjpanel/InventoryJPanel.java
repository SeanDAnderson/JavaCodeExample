package edu.regis.msse670.view.inventoryjpanel;

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
import edu.regis.msse670.model.domain.InventoryItem;
import edu.regis.msse670.model.domain.InventoryMote;
import edu.regis.msse670.model.domain.InventoryRegion;
import edu.regis.msse670.view.mainjframe.MainJFrame;

public class InventoryJPanel extends JPanel {

	private static final long serialVersionUID = -5352443094195166198L;
	
	protected DataSphere dataSphere;
	protected MainJFrame mainJFrame;
	private InventoryJPanelController inventoryJPanelController;
	
	private JLabel biFieldLabel, biNameLabel, biTierLabel, biInventoryMaxLabel, riFieldLabel, riNameLabel, iiFieldLabel, iiNameLabel, iiInventoryMaxLabel, iiTagLabel, moteFieldLabel, moteNameLabel, moteTagLabel;
	private JTextArea biNameText, riNameText, iiNameText, iiTagText, moteNameText, moteTagText;
	private JSpinner biTierSpinner, biInventoryMaxSpinner, iiInventoryMaxSpinner;
	private JButton biAddButton, riAddButton, iiAddButton, moteAddButton;

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
		
		//BasicInventory (bi)
		//Label initializations
		biFieldLabel = new JLabel("-----Basic Inventory-----");
		biNameLabel = new JLabel("Inventory Name:");
		biTierLabel = new JLabel("Inventory Tier:");
		biInventoryMaxLabel = new JLabel("Maximum Inventory Capacity:");
		//Input initializations
		biNameText = new JTextArea(1, 20);		
		biTierSpinner = new JSpinner(new SpinnerNumberModel(10, 0, 127, 1));
		biInventoryMaxSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 3000000, 1));
		biAddButton = new JButton("Add Basic Inventory to World Inventory");
		
		//Region Inventory (ri)
		//Label initializations
		riFieldLabel = new JLabel("-----Region-----");
		riNameLabel = new JLabel("Region Name:");
		//Input initializations
		riNameText = new JTextArea(1, 20);
		riAddButton = new JButton("Add Region To World Inventory");
		
		//Item Inventory (ii)
		//Label initializations
		iiFieldLabel = new JLabel("-----Item-----");
		iiNameLabel = new JLabel("Item Name:");
		iiInventoryMaxLabel = new JLabel("Maximum Inventory Capacity:");
		iiTagLabel = new JLabel("Item Tag: ");
		//Input initializations
		iiNameText = new JTextArea(1, 20);
		iiInventoryMaxSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 3000000, 1));
		iiTagText = new JTextArea(1, 20);
		iiAddButton = new JButton("Add Item To World Inventory");
		
		//Mote Inventory (mote)
		//Label initializations
		moteFieldLabel = new JLabel("-----Mote-----");
		moteNameLabel = new JLabel("Mote Name:");
		moteTagLabel = new JLabel("Mote Tag:");
		//Input initializations
		moteNameText = new JTextArea(1, 20);
		moteTagText = new JTextArea(1, 20);
		moteAddButton = new JButton("Add Mote To World Inventory");

		//BI adding
		this.add(biFieldLabel);
		this.add(biNameLabel);
		this.add(biNameText);
		this.add(biTierLabel);
		this.add(biTierSpinner);
		this.add(biInventoryMaxLabel);
		this.add(biInventoryMaxSpinner);
		this.add(biAddButton);
		//RI adding
		this.add(riFieldLabel);
		this.add(riNameLabel);
		this.add(riNameText);
		this.add(riAddButton);
		//II adding
		this.add(iiFieldLabel);
		this.add(iiNameLabel);
		this.add(iiNameText);
		this.add(iiInventoryMaxLabel);
		this.add(iiInventoryMaxSpinner);
		this.add(iiTagLabel);
		this.add(iiTagText);
		this.add(iiAddButton);
		//Mote Adding
		this.add(moteFieldLabel);
		this.add(moteNameLabel);
		this.add(moteNameText);
		this.add(moteTagLabel);
		this.add(moteTagText);
		this.add(moteAddButton);
		
		//constructing the controller
		inventoryJPanelController = new InventoryJPanelController(this, dataSphere);
		
	}
	
	public JButton getBIAddButton(){
		System.out.println("Returning Action Button");
		return biAddButton;
	}
	
	public JButton getRIAddButton(){
		System.out.println("Returning Action Button");
		return riAddButton;
	}
	
	public JButton getIIAddButton(){
		System.out.println("Returning Action Button");
		return iiAddButton;
	}
	
	public JButton getMoteAddButton(){
		System.out.println("Returning Action Button");
		return moteAddButton;
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
	 * @return	The completed Basic Inventory
	 */
	public Inventory getBasicInventory(){
		int i = (int) biTierSpinner.getValue();
		byte iByte = (byte) i;
		BasicInventory inventory = new BasicInventory(biNameText.getText(), (byte) iByte, (int) biInventoryMaxSpinner.getValue());
		return inventory;
	}
	
	/**
	 * Assigns values from user to a Region Inventory
	 * @return	The completed Region Inventory
	 */
	public Inventory getRegion(){
		InventoryRegion region = new InventoryRegion(riNameText.getText());
		return region;
	}
	
	/**
	 * Assigns values from user to an Item Inventory
	 * @return	The completed Item Inventory
	 */
	public Inventory getItem(){
		InventoryItem item = new InventoryItem(iiNameText.getText(), (int) iiInventoryMaxSpinner.getValue(), iiTagText.getText());
		return item;
	}
	
	/**
	 * Assigns values from user to a Mote
	 * @return	The completed Mote
	 */
	public Inventory getMote(){
		InventoryMote mote = new InventoryMote(moteNameText.getText(), moteTagText.getText());
		return mote;
	}
	
}
