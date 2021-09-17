package heatflow_monitor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.apache.log4j.Logger;

public class MessagesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// static String lineMessage = "";
	
	
	public JTextArea messagesArea;

	// log4j
	static Logger logger = Logger.getLogger(Heatflow.class.getName() );
	
	public MessagesPanel() {
		super(new GridBagLayout());
 
		messagesArea = new JTextArea(2, 20);
		messagesArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(messagesArea);

		//Add Components to this panel.
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;

		c.fill = GridBagConstraints.HORIZONTAL;
		add(messagesArea, c);

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1.0;
		c.weighty = 1.0;
		add(scrollPane, c);
	}
	
	public void setMessage(String message) {
		messagesArea.setText(message);
	}
	
	/*
	public void setMessages(Vector<String> messages) {
		messageArea.setText(messages);
	}
	*/
	
	public void addStatus(String line) {
		messagesArea.append("\n" + line);
	}
	
	public void setErrorCondition(boolean ifError) {
	
		if (ifError) {
			messagesArea.setBackground(new Color (255,114,118)); // Color.RED
		} else {
			messagesArea.setBackground(new Color (152,251,152)); // new Color(0, 153, 0) );


		}
	}
	
}