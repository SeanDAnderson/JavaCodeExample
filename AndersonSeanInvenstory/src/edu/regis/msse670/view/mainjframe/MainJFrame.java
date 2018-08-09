package edu.regis.msse670.view.mainjframe;

import javax.swing.*;
import edu.regis.msse670.model.domain.DataSphere;
import edu.regis.msse670.view.inventoryjpanel.InventoryJPanel;
import edu.regis.msse670.view.worldinventoryjpanel.WorldInventoryJPanel;


public class MainJFrame extends JFrame {


	private static final long serialVersionUID = 8053706993345908888L;
	DataSphere dataSphere;
	MainJFrameController mainJFrameController;
	WorldInventoryJPanel worldInventoryJPanel;
	InventoryJPanel inventoryJPanel;
	JMenuBar menuBar = new JMenuBar();
	JMenu fileMenu, inventoryMenu;
	JMenuItem newItem, saveItem, addItem, exitItem;
	
	JDesktopPane desktopPane = new JDesktopPane();
	
	public MainJFrame (){
		dataSphere = new DataSphere();
		
		mainJFrameController = new MainJFrameController(this, dataSphere);
		
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("InvenStory");
		
		getContentPane().add(desktopPane);
		setJMenuBar(menuBar);
		createMenu();
		
		
		
		worldInventoryJPanel = new WorldInventoryJPanel(this, dataSphere);
		inventoryJPanel = new InventoryJPanel(this, dataSphere);
		
		
		
		
		
		this.setVisible(true);
	}
	
	/**
	 * Creates the menu, separated into a method for maintainability and readability
	 */
	private void createMenu(){
		//File Menu
		fileMenu = new JMenu("File");
		//File Menu Items
		newItem = new JMenuItem("New World Inventory");
		fileMenu.add(newItem);
		newItem.addActionListener(e -> desktopPane.add(mainJFrameController.createInternalFrame("New World Inventory", worldInventoryJPanel)));
		saveItem = new JMenuItem("Save World Inventory");
		fileMenu.add(saveItem);
		saveItem.addActionListener(e -> mainJFrameController.saveWorldInventory());
		exitItem = new JMenuItem("Exit Program");
		fileMenu.add(exitItem);
		exitItem.addActionListener(e -> System.exit(0));
		
		//Inventory Menu
		inventoryMenu = new JMenu("Inventories");
		//Inventory Menu Items
		addItem = new JMenuItem("Add Inventory To World Inventory");
		inventoryMenu.add(addItem);
		addItem.addActionListener(e -> desktopPane.add(mainJFrameController.createInternalFrame("Add Inventory To World Inventory", inventoryJPanel)));
		menuBar.add(fileMenu);
		menuBar.add(inventoryMenu);
		}
	
	
}
