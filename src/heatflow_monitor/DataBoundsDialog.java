package heatflow_monitor;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.StringTokenizer;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.util.*;

import org.apache.log4j.Logger;

class DataBoundsDialog extends CenterDialogBox {

	private static final long serialVersionUID = 1L;

	// log4j
	static Logger logger = Logger.getLogger(Heatflow.class.getName());

	JFrame frame;

	JButton okButton, cancelButton;
	
	JFormattedTextField batteryLowLimitField;
	JFormattedTextField tiltLowLimitField;
	JFormattedTextField depthLowLimitField;
	JFormattedTextField probeLowLimitField;
	
	JFormattedTextField batteryHighLimitField;
	JFormattedTextField tiltHighLimitField;
	JFormattedTextField depthHighLimitField; 
	JFormattedTextField probeHighLimitField; 
	
	JFormattedTextField batteryWarnLimitField;
	JFormattedTextField tiltWarnLimitField;
	JFormattedTextField depthWarnLimitField;
	JFormattedTextField probeWarnLimitField;
	
	double batteryLowLimit = 0.0;
	double tiltLowLimit = 0.0;
	double depthLowLimit = 0.0;
	double probeLowLimit = 0.0;
	
	double batteryHighLimit = 0.0;
	double tiltHighLimit = 0.0;
	double depthHighLimit = 0.0; 
	double probeHighLimit = 0.0; 
	
	// double batteryWarnLimit = 0.0;
	// double tiltWarnLimit = 0.0;
	// double depthWarnLimit = 0.0;
	// double probeWarnLimit = 0.0;
	
	String tempPath;

	public DataBoundsDialog(JFrame frame, String tempPath) {

		super(frame);
		setSize(450, 350);

		this.frame = frame;
		this.tempPath = tempPath;
		this.setModal(true);
		
		this.setTitle("Data Alarm");

		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		NumberFormatter formatter = new NumberFormatter(decimalFormat);
	
	 	batteryLowLimitField = new JFormattedTextField(formatter);
	 	tiltLowLimitField = new JFormattedTextField(formatter);
	 	depthLowLimitField = new JFormattedTextField(formatter);
	 	probeLowLimitField = new JFormattedTextField(formatter);
	
		batteryHighLimitField = new JFormattedTextField(formatter);
		tiltHighLimitField = new JFormattedTextField(formatter);
		depthHighLimitField = new JFormattedTextField(formatter);
		probeHighLimitField = new JFormattedTextField(formatter);
	
		// batteryWarnLimitField = new JFormattedTextField(formatter);
		// tiltWarnLimitField = new JFormattedTextField(formatter);
		// depthWarnLimitField = new JFormattedTextField(formatter);
		// probeWarnLimitField = new JFormattedTextField(formatter);
		
		setBoundsValues();
	
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		JPanel p = new JPanel();

		c.fill = GridBagConstraints.HORIZONTAL;
		p.setLayout(gridbag);

		c.insets = new Insets(10, 10, 10, 10);
		
		JLabel explaination = new JLabel("Values outside of bounds will trigger alarm.");
		
		c.weightx = 1.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		gridbag.setConstraints(explaination, c);
		p.add(explaination);
		
		
		JLabel lowLevelLabel = new JLabel("Low Alarm");
		c.gridwidth = 1;
		c.weightx = 0.3;
		c.gridx = 1;
		c.gridy = 1;
		gridbag.setConstraints(lowLevelLabel, c);
		p.add(lowLevelLabel);
		
		JLabel highLevelLabel = new JLabel("High Alarm");
		c.weightx = 0.3;
		c.gridx = 2;
		c.gridy = 1;
		gridbag.setConstraints(highLevelLabel, c);
		p.add(highLevelLabel);
		
		/*
		JLabel WarningLevelLabel = new JLabel("WARNING");
		c.weightx = 0.2;
		c.gridx = 3;
		c.gridy = 0;
		gridbag.setConstraints(WarningLevelLabel, c);
		p.add(WarningLevelLabel);
		*/
		
		JLabel batteryLabel = new JLabel("Battery Limits(v)");
		c.weightx = 0.4;
		c.gridx = 0;
		c.gridy = 2;
		gridbag.setConstraints(batteryLabel, c);
		p.add(batteryLabel);

		c.weightx = 0.3;
		c.gridx = 1;
		c.gridy = 2;
		gridbag.setConstraints(batteryLowLimitField, c);
		p.add(batteryLowLimitField);
		
		c.weightx = 0.3;
		c.gridx = 2;
		c.gridy = 2;
		gridbag.setConstraints(batteryHighLimitField, c);
		p.add(batteryHighLimitField);
		
		/*
		c.weightx = 0.2;
		c.gridx = 3;
		c.gridy = 1;
		gridbag.setConstraints(batteryWarnLimitField, c);
		p.add(batteryWarnLimitField);
		*/

		JLabel tiltLabel = new JLabel("Tilt Limits (C)");
		c.weightx = 0.4;
		c.gridx = 0;
		c.gridy = 3;
		gridbag.setConstraints(tiltLabel, c);
		p.add(tiltLabel);

		c.weightx = 0.3;
		c.gridx = 1;
		c.gridy = 3;
		gridbag.setConstraints(tiltLowLimitField, c);
		p.add(tiltLowLimitField);
		
		c.weightx = 0.3;
		c.gridx = 2;
		c.gridy = 3;
		gridbag.setConstraints(tiltHighLimitField, c);
		p.add(tiltHighLimitField);
		
		/*
		c.weightx = 0.2;
		c.gridx = 3;
		c.gridy = 2;
		gridbag.setConstraints(tiltWarnLimitField, c);
		p.add(tiltWarnLimitField);
		*/
		
		JLabel depthLabel = new JLabel("Depth Limits (m)");
		c.weightx = 0.4;
		c.gridx = 0;
		c.gridy = 4;
		gridbag.setConstraints(depthLabel, c);
		p.add(depthLabel);

		c.weightx = 0.3;
		c.gridx = 1;
		c.gridy = 4;
		gridbag.setConstraints(depthLowLimitField, c);
		p.add(depthLowLimitField);

		c.weightx = 0.3;
		c.gridx = 2;
		c.gridy = 4;
		gridbag.setConstraints(depthHighLimitField, c);
		p.add(depthHighLimitField);
		
		/*
		c.weightx = 0.2;
		c.gridx = 3;
		c.gridy = 3;
		gridbag.setConstraints(depthWarnLimitField, c);
		p.add(depthWarnLimitField);
		*/

		JLabel probeLabel = new JLabel("Probe Temperature Limits (C)");
		c.weightx = 0.4;
		c.gridx = 0;
		c.gridy = 5;
		gridbag.setConstraints(probeLabel, c);
		p.add(probeLabel);

		c.weightx = 0.3;
		c.gridx = 1;
		c.gridy = 5;
		gridbag.setConstraints(probeLowLimitField, c);
		p.add(probeLowLimitField);
		
		c.weightx = 0.3;
		c.gridx = 2;
		c.gridy = 5;
		gridbag.setConstraints(probeHighLimitField, c);
		p.add(probeHighLimitField);
		
		/*
		c.weightx = 0.2;
		c.gridx = 3;
		c.gridy = 4;
		gridbag.setConstraints(probeWarnLimitField, c);
		p.add(probeWarnLimitField);
		*/

		// layout for the button panel
		GridBagLayout gridbagButton = new GridBagLayout();
		GridBagConstraints gridButton = new GridBagConstraints();
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(gridbagButton);
		gridButton.fill = GridBagConstraints.HORIZONTAL;
		gridButton.insets = new Insets(0, 0, 0, 0);
		gridButton.weightx = 0.5;
		c.gridwidth = 5;
		c.gridx = 0;
		c.gridy = 6;
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

		// dataBounds.readBoundsFile();
		// setBoundsValues();

		setVisible(true);

	}

	public void okButton_actionPerformed(ActionEvent event) {
	
		double batteryLowLimit = new Double(batteryLowLimitField.getText()).doubleValue();
		double tiltLowLimit = new Double(tiltLowLimitField.getText()).doubleValue();
		double depthLowLimit = new Double(depthLowLimitField.getText()).doubleValue();
		double probeLowLimit = new Double(probeLowLimitField.getText()).doubleValue();
		
		double batteryHighLimit = new Double(batteryHighLimitField.getText()).doubleValue();
		double tiltHighLimit = new Double(tiltHighLimitField.getText()).doubleValue();
		double depthHighLimit = new Double(depthHighLimitField.getText()).doubleValue();
		double probeHighLimit = new Double(probeHighLimitField.getText()).doubleValue();
		
		logger.info("probeHighLimit from dialog: " + probeHighLimit);
		
		// double batteryWarnLimit = new Double(batteryWarnLimitField.getText()).doubleValue();
		// double tiltWarnLimit = new Double(tiltWarnLimitField.getText()).doubleValue();
		// double depthWarnLimit = new Double(depthWarnLimitField.getText()).doubleValue();
		// double probeWarnLimit = new Double(probeWarnLimitField.getText()).doubleValue();
		
		DataBounds.batteryLowLimit = batteryLowLimit;
		DataBounds.tiltLowLimit = tiltLowLimit;
		DataBounds.depthLowLimit = depthLowLimit;
		DataBounds.probeLowLimit = probeLowLimit;
		
		DataBounds.batteryHighLimit = batteryHighLimit;
		DataBounds.tiltHighLimit = tiltHighLimit;
		DataBounds.depthHighLimit = depthHighLimit;
		DataBounds.probeHighLimit = probeHighLimit;
		
		// DataBounds.batteryWarnLimit = batteryWarnLimit;
		// DataBounds.tiltWarnLimit = tiltWarnLimit;
		// DataBounds.depthWarnLimit = depthWarnLimit;
		// DataBounds.probeWarnLimit = probeWarnLimit;
		
		DataBounds.writeBoundsFile(tempPath);
		
		setVisible(false);
		dispose();
	}

	public void cancelButton_actionPerformed(ActionEvent ae) {

		setVisible(false);
		dispose();
	}

	public void setBoundsValues() {
	
		logger.info("trying to set the data bounds values");
	
		DataBounds.readBoundsFile(tempPath);
	
		batteryLowLimitField.setValue(DataBounds.getBatteryLowLimit() );
	 	tiltLowLimitField.setValue(DataBounds.getTiltLowLimit() );
	 	depthLowLimitField.setValue(DataBounds.getDepthLowLimit() );
	 	probeLowLimitField.setValue(DataBounds.getProbeLowLimit() );
	
		batteryHighLimitField.setValue(DataBounds.getBatteryHighLimit() );
		tiltHighLimitField.setValue(DataBounds.getTiltHighLimit() );
		depthHighLimitField.setValue(DataBounds.getDepthHighLimit() );
		probeHighLimitField.setValue(DataBounds.probeHighLimit);
	
		// batteryWarnLimitField.setValue(DataBounds.getBatteryWarnLimit() );
		// tiltWarnLimitField.setValue(DataBounds.getTiltWarnLimit() );
		// depthWarnLimitField.setValue(DataBounds.getDepthWarnLimit() );
		// probeWarnLimitField.setValue(DataBounds.getProbeWarnLimit() );
	}
}
