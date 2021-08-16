package heatflow_monitor;

import javax.swing.UIManager;
import java.awt.*;
import java.lang.ThreadGroup;
import java.lang.Exception;

/**
 * <p>Title: Heatflow Monitor</p>
 * <p>Description: Provides monitor for OSU/UCSC heatflow probe data.</p>
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Company: UCSC</p>
 * @author Brecky Morris
 * @version 1.0
 */

public class Heatflow {

  private boolean packFrame = false;

  //Construct the application
  public Heatflow() {
	Monitor frame = new Monitor();
	// LayoutTest frame = new LayoutTest();
	//Validate frames that have preset sizes
	//Pack frames that have useful preferred size info, e.g. from their layout
	if (packFrame) {
	  frame.pack();
	}
	else {
	  frame.validate();
	}
	//Center the window
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension frameSize = frame.getSize();
	if (frameSize.height > screenSize.height) {
	  frameSize.height = screenSize.height;
	}
	if (frameSize.width > screenSize.width) {
	  frameSize.width = screenSize.width;
	}
	frame.setLocation((screenSize.width - frameSize.width) / 2, 
	(screenSize.height - frameSize.height) / 2);
	frame.setVisible(true);
  }
  
  //Main method
  public static void main(String[] args) {
  	ThreadGroup exceptionThreadGroup = new ExceptionGroup();
	new Thread(exceptionThreadGroup, "Init thread") {
		public void run() {
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			new Heatflow();
		}
	}.start();
  }
}