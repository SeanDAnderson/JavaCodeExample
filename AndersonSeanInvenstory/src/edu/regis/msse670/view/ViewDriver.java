package edu.regis.msse670.view;

import edu.regis.msse670.view.mainjframe.MainJFrame;
import edu.regis.msse670.view.mainjframe.MainJFrameController;

public class ViewDriver {

	public ViewDriver(){
		MainJFrame mainJFrame = new MainJFrame();
		MainJFrameController mainJFrameController = new MainJFrameController();
	}
	
	public static void main(String args[]){
		new ViewDriver();
	}
}
