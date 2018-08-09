package edu.regis.msse670.view.mainjframe;


import java.awt.FlowLayout;

import javax.swing.JFrame;
import edu.regis.msse670.model.domain.DataSphere;
import edu.regis.msse670.view.inventoryjpanel.InventoryJPanel;
import edu.regis.msse670.view.worldinventoryjpanel.WorldInventoryJPanel;


public class MainJFrame extends JFrame {


	private static final long serialVersionUID = 8053706993345908888L;
	DataSphere dataSphere;
	WorldInventoryJPanel worldInventoryJPanel;
	InventoryJPanel inventoryJPanel;
	
	
	public MainJFrame (){
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("InvenStory");
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		dataSphere = new DataSphere();
		
		worldInventoryJPanel = new WorldInventoryJPanel(this, dataSphere);
		inventoryJPanel = new InventoryJPanel(this, dataSphere);
		
		
		
		this.add(worldInventoryJPanel);
		this.add(inventoryJPanel);
		
		
		this.setVisible(true);
	}
	
}
