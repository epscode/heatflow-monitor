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
import java.util.*;
import javax.swing.*;
import java.util.ArrayList;
import org.apache.log4j.Logger;

class HeatProbeNamesDialog extends CenterDialogBox {

	JFrame frame;

	private static final long serialVersionUID = 1L;

	JButton okButton, cancelButton;

	boolean cancel;
	boolean okStatus = false;
	
	String tempPath = "";

	// log4j
	static Logger logger = Logger.getLogger(Heatflow.class.getName());
	
	JComboBox officialNameChooser1;
	JComboBox officialNameChooser2;
	JComboBox officialNameChooser3;
	JComboBox officialNameChooser4;
	
	JLabel depth1Label;
	JLabel depth2Label;
	JLabel depth3Label;
	JLabel depth4Label;
	
	String twoDecimalPattern = "0.00";
	DecimalFormat twoDecimalFormatter = new DecimalFormat(twoDecimalPattern);

	public HeatProbeNamesDialog(JFrame frame, String tempPath) {

		super(frame);
		setSize(325, 300);

		this.frame = frame;
		this.tempPath = tempPath;
		this.setModal(true);
		
		this.setTitle("Heat Probe Names");
		
		HeatProbeNames.readPossibleProbeNamesFile(tempPath);
		
		logger.info("possible name choices");
		for (int index = 0; index < HeatProbeNames.getPossibleProbeNames().size(); index++) {
			logger.info("possible name: " + HeatProbeNames.getPossibleProbeName(index));	
		}
		
		officialNameChooser1 = new JComboBox(HeatProbeNames.getPossibleProbeNames());
		officialNameChooser2 = new JComboBox(HeatProbeNames.getPossibleProbeNames());
		officialNameChooser3 = new JComboBox(HeatProbeNames.getPossibleProbeNames());
		officialNameChooser4 = new JComboBox(HeatProbeNames.getPossibleProbeNames());
		
		depth1Label = new JLabel();
		depth2Label = new JLabel();
		depth3Label = new JLabel();
		depth4Label = new JLabel();
		
		officialNameChooser1.setSelectedItem(HeatProbeNames.getProbe1Name());
		officialNameChooser2.setSelectedItem(HeatProbeNames.getProbe2Name());
		officialNameChooser3.setSelectedItem(HeatProbeNames.getProbe3Name());
		officialNameChooser4.setSelectedItem(HeatProbeNames.getProbe4Name());
		
		depth1Label.setText(twoDecimalFormatter.format(HeatProbeNames.getProbe1Depth()) + " m");
		depth2Label.setText(twoDecimalFormatter.format(HeatProbeNames.getProbe2Depth()) + " m");
		depth3Label.setText(twoDecimalFormatter.format(HeatProbeNames.getProbe3Depth()) + " m");
		depth4Label.setText(twoDecimalFormatter.format(HeatProbeNames.getProbe4Depth()) + " m");
		
		officialNameChooser1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				officialNameChooser1_actionPerformed(e);
			}
		});
		
		officialNameChooser2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				officialNameChooser2_actionPerformed(e);
			}
		});
		
		officialNameChooser3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				officialNameChooser3_actionPerformed(e);
			}
		});
		
		officialNameChooser4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				officialNameChooser4_actionPerformed(e);
			}
		});

		cancel = false;
		
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		JPanel p = new JPanel();

		c.fill = GridBagConstraints.HORIZONTAL;
		p.setLayout(gridbag);

		c.insets = new Insets(10, 10, 10, 10);

		JLabel Probe1NameLabel = new JLabel("Probe 1 Name");
		c.weightx = 0.4;
		c.gridx = 0;
		c.gridy = 0;
		gridbag.setConstraints(Probe1NameLabel, c);
		p.add(Probe1NameLabel);
		
		c.weightx = 0.3;
		c.gridx = 1;
		c.gridy = 0;
		gridbag.setConstraints(officialNameChooser1, c);
		p.add(officialNameChooser1);
		
		c.weightx = 0.3;
		c.gridx = 2;
		c.gridy = 0;
		gridbag.setConstraints(depth1Label, c);
		p.add(depth1Label);
		
		JLabel Probe2NameLabel = new JLabel("Probe 2 Name");
		c.weightx = 0.4;
		c.gridx = 0;
		c.gridy = 1;
		gridbag.setConstraints(Probe2NameLabel, c);
		p.add(Probe2NameLabel);
		
		c.weightx = 0.3;
		c.gridx = 1;
		c.gridy = 1;
		gridbag.setConstraints(officialNameChooser2, c);
		p.add(officialNameChooser2);
		
		c.weightx = 0.3;
		c.gridx = 2;
		c.gridy = 1;
		gridbag.setConstraints(depth2Label, c);
		p.add(depth2Label);
		
		JLabel Probe3NameLabel = new JLabel("Probe 3 Name");
		c.weightx = 0.4;
		c.gridx = 0;
		c.gridy = 2;
		gridbag.setConstraints(Probe3NameLabel, c);
		p.add(Probe3NameLabel);
		
		c.weightx = 0.3;
		c.gridx = 1;
		c.gridy = 2;
		gridbag.setConstraints(officialNameChooser3, c);
		p.add(officialNameChooser3);
		
		c.weightx = 0.3;
		c.gridx = 2;
		c.gridy = 2;
		gridbag.setConstraints(depth3Label, c);
		p.add(depth3Label);
		
		JLabel Probe4NameLabel = new JLabel("Probe 4 Name");
		c.weightx = 0.4;
		c.gridx = 0;
		c.gridy = 3;
		gridbag.setConstraints(Probe4NameLabel, c);
		p.add(Probe4NameLabel);
		
		c.weightx = 0.3;
		c.gridx = 1;
		c.gridy = 3;
		gridbag.setConstraints(officialNameChooser4, c);
		p.add(officialNameChooser4);
		
		c.weightx = 0.3;
		c.gridx = 2;
		c.gridy = 3;
		gridbag.setConstraints(depth4Label, c);
		p.add(depth4Label);
		
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
		c.gridy = 4;
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

	public void okButton_actionPerformed(ActionEvent event) {
	
		String probe1Input = String.valueOf(officialNameChooser1.getSelectedItem());
		String probe2Input = String.valueOf(officialNameChooser2.getSelectedItem());
		String probe3Input = String.valueOf(officialNameChooser3.getSelectedItem());
		String probe4Input = String.valueOf(officialNameChooser4.getSelectedItem());
		
		boolean areThereDuplicates = 
			findDuplicateNames(probe1Input, probe2Input, probe3Input, probe4Input);
			
		if (areThereDuplicates) {
		
			JOptionPane.showMessageDialog(null, 
			 "Probe Names can't be the same ", 
			 "Naming Error",
			 JOptionPane.ERROR_MESSAGE);
		
		} else {
		
			HeatProbeNames.probe1Name = probe1Input;
			HeatProbeNames.probe2Name = probe2Input;
			HeatProbeNames.probe3Name = probe3Input;
			HeatProbeNames.probe4Name = probe4Input;
			
			// parse label 1
			String[] label1 = (depth1Label.getText()).split(" ");
			HeatProbeNames.probe1Depth = new Double(label1[0]).doubleValue();
		
			// parse label 2
			String[] label2 = (depth2Label.getText()).split(" ");
			HeatProbeNames.probe2Depth = new Double(label2[0]).doubleValue();
			
			// parse label 3
			String[] label3 = (depth3Label.getText()).split(" ");
			HeatProbeNames.probe3Depth = new Double(label3[0]).doubleValue();
			
			// parse label 4
			String[] label4 = (depth4Label.getText()).split(" ");
			HeatProbeNames.probe4Depth = new Double(label4[0]).doubleValue();
		
			// need to check for duplicates
			// HeatProbeNames.setPossibleProbeName(probe1Input);
			// HeatProbeNames.setPossibleProbeName(probe2Input);
			// HeatProbeNames.setPossibleProbeName(probe3Input);
			// HeatProbeNames.setPossibleProbeName(probe4Input);
			
			HeatProbeNames.writeProbeNamesFile(tempPath);
			
			// HeatProbeNames.writePossibleProbeNamesFile(tempPath);
			setVisible(false);
		
			dispose();
		}
	}
	
	public boolean findDuplicateNames(String probe1Input, 
	 String probe2Input, String probe3Input, String probe4Input) {
	 
	 	ArrayList<String> probeNames = new ArrayList<String>();
        probeNames.add(probe1Input);
       	probeNames.add(probe2Input);
        probeNames.add(probe3Input);
        probeNames.add(probe4Input);
  
        /* Collections.sort method is sorting the
        elements of ArrayList in ascending order. */
        Collections.sort(probeNames);
  
        // Let us print the sorted list
        System.out.println("List after the use of" +
                           " Collection.sort() :\n" + probeNames);

		// look for duplicates
		for (int index = 0; index < 3; index++) {
		
			if (probeNames.get(index).compareTo(probeNames.get(index + 1)) == 0) {
			
				logger.info("found a duplicate entry");
				return true;
			}
		}
	
		return false;
	}

	public void cancelButton_actionPerformed(ActionEvent ae) {
	
		cancel = true;

		setVisible(false);
		dispose();
	}
	
	private void officialNameChooser1_actionPerformed(ActionEvent event) {
	
		logger.info("official name chooser 1");
		
		int officialNameChooser1Index = officialNameChooser1.getSelectedIndex();
		
		double officialNameChooser1Depth = HeatProbeNames.getPossibleProbeDepth(officialNameChooser1Index);
		
		depth1Label.setText(twoDecimalFormatter.format(officialNameChooser1Depth) + " m");
	}
	
	private void officialNameChooser2_actionPerformed(ActionEvent event) {
	
		logger.info("official name chooser 2");
		
		int officialNameChooser2Index = officialNameChooser2.getSelectedIndex();
		
		double officialNameChooser2Depth = HeatProbeNames.getPossibleProbeDepth(officialNameChooser2Index);
		
		depth2Label.setText(twoDecimalFormatter.format(officialNameChooser2Depth) + " m");
	}
	
	private void officialNameChooser3_actionPerformed(ActionEvent event) {
	
		logger.info("official name chooser 3");
		
		int officialNameChooser3Index = officialNameChooser3.getSelectedIndex();
		
		double officialNameChooser3Depth = HeatProbeNames.getPossibleProbeDepth(officialNameChooser3Index);
		
		depth3Label.setText(twoDecimalFormatter.format(officialNameChooser3Depth) + " m");
	}
	
	private void officialNameChooser4_actionPerformed(ActionEvent event) {
	
		logger.info("official name chooser 4");
		
		int officialNameChooser4Index = officialNameChooser4.getSelectedIndex();
		
		double officialNameChooser4Depth = HeatProbeNames.getPossibleProbeDepth(officialNameChooser4Index);
		
		depth4Label.setText(twoDecimalFormatter.format(officialNameChooser4Depth) + " m");
	}
}
