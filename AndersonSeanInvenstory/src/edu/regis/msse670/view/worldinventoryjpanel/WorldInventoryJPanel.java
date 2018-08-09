package edu.regis.msse670.view.worldinventoryjpanel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.regis.msse670.model.domain.DataSphere;
import edu.regis.msse670.view.mainjframe.MainJFrame;

/**
 * Leftmost panel, controls WorldInventory behavior and displays WorldInventory information.
 * 
 * @author Maledictor
 *
 */
public class WorldInventoryJPanel extends JPanel {

	private static final long serialVersionUID = 8397868080558480877L;

	
	private DataSphere dataSphere;
	private MainJFrame mainJFrame;
	private WorldInventoryJPanelController worldInventoryJPanelController;
	private JLabel worldInventoryLabel, worldInventoryName;
	private JButton newWorldInventoryButton, saveWorldInventoryButton, viewWorldInventoryButton;
	private JTextArea newWorldInventoryNameText;
	
	/**
	 * The panel constructor takes a reference to the mainJFrame for creating messages
	 * and the DataSphere reference for passing information.
	 * 
	 * It is a box panel
	 * 
	 * @param	mainJFrame	MainJFrame that calls the panel
	 * @param	dataShpere	The DataSphere used for transmitting data. 
	 */
	public WorldInventoryJPanel(MainJFrame mainJFrame, DataSphere dataSphere){
		this.mainJFrame = mainJFrame;
		this.dataSphere = dataSphere;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setSize(400, 400);
		
		worldInventoryLabel = new JLabel("------World Inventory------");
		worldInventoryName = new JLabel("No World Inventory Loaded");
		newWorldInventoryButton = new JButton("Create New World Inventory");
		saveWorldInventoryButton = new JButton("Save World Inventory");
		viewWorldInventoryButton = new JButton("View World Inventory");
		newWorldInventoryNameText = new JTextArea("New World Inventory Name", 1, 20);
		
		this.add(worldInventoryLabel);
		this.add(worldInventoryName);
		this.add(viewWorldInventoryButton);
		this.add(newWorldInventoryNameText);
		this.add(newWorldInventoryButton);
		
		
		
		worldInventoryJPanelController = new WorldInventoryJPanelController(this, dataSphere);
		
		/**
		 * The viewWorldInventory button utilizes an anonymous actionListener class
		 * This is primarily to fulfill assignment requirements, I do not think I would have
		 * used it here otherwise.
		 */
		viewWorldInventoryButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String worldInventoryString;
						
						/**
						 * As long as the WorldInventory is not null the button will display it's name and information
						 * as well as the names of all of the inventories stored within the WorldInventory. 
						 */
						if (dataSphere.getWorldInventory() != null){
							worldInventoryString = "World Inventory: " + dataSphere.getWorldInventory().getName() + System.lineSeparator() +
									"Inventory Items Stored: " + dataSphere.getWorldInventory().getInventoryStored() + System.lineSeparator();
							for (int i = 0; i < dataSphere.getWorldInventory().getInventoryStored(); i++){
								worldInventoryString += dataSphere.getWorldInventory().getObjectInventory().get(i).getName() + System.lineSeparator();
							}
							}
						else{
							worldInventoryString = "No active World Inventory";
						}	
				
						JOptionPane.showMessageDialog(mainJFrame, worldInventoryString);
					}
		}
	);
	}	
	
	public DataSphere getDataSphere(){
		return dataSphere;
	}
	
	public JButton getNewWorldInventoryButton(){
		return newWorldInventoryButton;
	}
	
	public JButton getSaveWorldInventoryButton(){
		return saveWorldInventoryButton;
	}
	
	public String getNewWorldInventoryName(){
		return newWorldInventoryNameText.getText();
	}
	
	public MainJFrame getJFrame(){
		return mainJFrame;
	}
	
	/**
	 * Updates the World Inventory name displayed
	 * For use with methods that update the active world inventory (either via creation or loading)
	 */
	public void updateWorldInventoryName(){
		if(dataSphere.getWorldInventory() != null){
		worldInventoryName.setText(dataSphere.getWorldInventory().getName());
		}
	}
}
