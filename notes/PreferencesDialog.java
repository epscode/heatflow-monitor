package heatflow_monitor;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

import org.apache.log4j.Logger;

class PreferencesDialog extends CenterDialogBox {

	JFrame frame;

	private static final long serialVersionUID = 1L;

	JButton okButton, cancelButton;

	boolean cancel;
	boolean okStatus = false;

	JTextField filePathField;
	
	JButton directoryButton;
	
	String tempPath = "";
	String dataSavePath = "";
	
	String directory = "";
	
	// Preferences preferences;
	
	// log4j
	static Logger logger = Logger.getLogger(Heatflow.class.getName());

	public PreferencesDialog(JFrame frame, String tempPath) {
	
		super(frame);
		setSize(700, 200);

		this.frame = frame;
		this.tempPath = tempPath;
		this.setModal(true);
	
		// preferences = new Preferences(tempPath);
		dataSavePath = preferences.getDefaultPath();

		
		directoryButton = new JButton("Select Directory");
		
		cancel = false;

		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		JPanel p = new JPanel();

		c.fill = GridBagConstraints.HORIZONTAL;
		p.setLayout(gridbag);

		c.insets = new Insets(10, 10, 10, 10);

		JLabel filePathLabel = new JLabel("Path for data saving");
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		gridbag.setConstraints(filePathLabel, c);
		p.add(filePathLabel);

		filePathField = new JTextField(30);
		filePathField.setText(dataSavePath);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		gridbag.setConstraints(filePathField, c);
		p.add(filePathField);
		
		directoryButton = new JButton("Select Directory");
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		gridbag.setConstraints(directoryButton, c);
		p.add(directoryButton);
		
		directoryButton.addActionListener(new ActionListener() { 
  			public void actionPerformed(ActionEvent e) { 
    			directoryButton_actionPerformed(e);
  			} 
		});
		
		// layout for the button panel
		GridBagLayout gridbagButton = new GridBagLayout();
		GridBagConstraints gridButton = new GridBagConstraints();
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(gridbagButton);
		gridButton.fill = GridBagConstraints.HORIZONTAL;
		gridButton.insets = new Insets(0, 0, 0, 0);
		gridButton.weightx = 0.5;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		gridbag.setConstraints(buttonPanel, c);
		p.add(buttonPanel);

		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelButton_actionPerformed(e);
			}
		});

		gridButton.gridx = 0;
		gridButton.gridy = 0;
		gridButton.fill = GridBagConstraints.NONE;
		gridbagButton.setConstraints(cancelButton, gridButton);
		buttonPanel.add(cancelButton);

		okButton = new JButton("OK");
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okButton_actionPerformed(e);
			}
		});

		gridButton.gridx = 1;
		gridbagButton.setConstraints(okButton, gridButton);
		buttonPanel.add(okButton);

		getContentPane().add(p);

		getRootPane().setDefaultButton(okButton);

		Dimension frmSize = getSize();
		Point loc = getLocation();

		setVisible(true);
	}
	
	private void directoryButton_actionPerformed(ActionEvent e) {
		logger.info("directory selection activated");
		
		if (getFilenameForDataSaving() ) {
			logger.info("directory name from button: " + directory);
			
			filePathField.setText(directory);
		}
	}

	public void okButton_actionPerformed(ActionEvent event) {
		
		preferences.defaultPath = filePathField.getText();
		preferences.writePreferencesFile();
			
		setVisible(false);
		dispose();
	}

	public void cancelButton_actionPerformed(ActionEvent ae) {
		cancel = true;

		setVisible(false);
		dispose();
	}
	
	public boolean getFilenameForDataSaving() {

		String extension = "txt";
		SafeJFileChooser safeFileDialog = new SafeJFileChooser(extension);
		
		safeFileDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = safeFileDialog.showSaveDialog(this);

		if (returnVal == SafeJFileChooser.APPROVE_OPTION) {
			File file = safeFileDialog.getSelectedFile();

			logger.debug("saving in directory: " + file.getName());
				
			logger.debug("saving: " + file.getName());
			logger.debug("directory: " + file.getAbsolutePath());
			directory = file.getAbsolutePath();

			logger.debug("directory from saving dialog: " + directory);

			return true;
		}

		logger.debug("Save as command canceled by user.");
		return false;
	}
}
