package heatflow_monitor;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

import javax.swing.*;

//log4j
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.commons.lang3.exception.ExceptionUtils;

class DataBounds {

	private static final long serialVersionUID = 1L;
	
	static String filename = "databounds.txt";
	
	static double batteryLowLimit;
	static double tiltLowLimit;
	static double depthLowLimit;
	static double probeLowLimit;
	
	static double batteryHighLimit;
	static double tiltHighLimit;
	static double depthHighLimit; 
	static double probeHighLimit; 
	
	static double batteryWarnLimit;
	static double tiltWarnLimit;
	static double depthWarnLimit;
	static double probeWarnLimit;

	// log4j
	static Logger logger = Logger.getLogger(Heatflow.class.getName() );
	
	public static double getBatteryLowLimit() {
		return batteryLowLimit;
	}
	
	public static double getBatteryHighLimit() {
		return batteryHighLimit;
	}
	
	public static double getBatteryWarnLimit() {
		return batteryWarnLimit;
	}
	
	public static double getTiltLowLimit() {
		return tiltLowLimit;
	}
	
	public static double getTiltHighLimit() {
		return tiltHighLimit;
	}
	
	public static double getTiltWarnLimit() {
		return tiltWarnLimit;
	}
	
	public static double getDepthLowLimit() {
		return depthLowLimit;
	}
	
	public static double getDepthHighLimit() {
		return depthHighLimit;
	}
	
	public static double getDepthWarnLimit() {
		return depthWarnLimit;
	}
	
	public static double getProbeLowLimit() {
		return probeLowLimit;
	}
	
	public static double getProbeHighLimit() {
		logger.info("probeHighLimit from data bounds get: " + probeHighLimit);
		return probeHighLimit;
	}
	
	public static double getProbeWarnLimit() {
		return probeWarnLimit;
	}
	
	public static void setBatteryLowLimit(double batteryLowLimit) {
		batteryLowLimit = batteryLowLimit;
	}
	
	public static void setBatteryHighLimit(double batteryHighLimit) {
		batteryHighLimit = batteryHighLimit;
	}
	
	public static void setBatteryWarnLimit(double batteryWarnLimit) {
		batteryWarnLimit = batteryWarnLimit;
	}
	
	public static void setTiltLowLimit(double tiltLowLimit) {
		tiltLowLimit = tiltLowLimit;
	}
	
	public static void setTiltHighLimit(double tiltHighLimit) {
		tiltHighLimit = tiltHighLimit;
	}
	
	public static void setTiltWarnLimit(double tiltWarnLimit) {
		tiltWarnLimit = tiltWarnLimit;
	}
	
	public static void setDepthLowLimit(double depthLowLimit) {
		depthLowLimit = depthLowLimit;
	}
	
	public static void setDepthHighLimit(double depthHighLimit) {
		depthHighLimit = depthHighLimit;
	}
	
	public static void setDepthWarnLimit(double depthWarnLimit) {
		depthWarnLimit = depthWarnLimit;
	}
	
	public static void setProbeLowLimit(double probeLowLimit) {
		probeLowLimit = probeLowLimit;
	}
	
	/*
	public static void setProbeHighLimit(double probeHighLimit) {
		probeHighLimit = probeHighLimit;
		logger.info("probeHighLimit from data bounds set: " + probeHighLimit);
	}
	*/
	
	public static void setProbeWarnLimit(double probeWarnLimit) {
		probeWarnLimit = probeWarnLimit;
	}
	
	static void writeBoundsFile(String tempPath) {

		String fullFilename = tempPath + filename;
		logger.debug("trying to write the data bounds file: " + fullFilename);
		
		try {
			FileWriter dataBoundsWriter = new FileWriter(fullFilename);
			PrintWriter dataBoundsPrinter = new PrintWriter(dataBoundsWriter, true);
			
			logger.info("probeHighLimit from file write: " + probeHighLimit);
			// logger.info("probeHighLimit from file write: " + getProbeHighLimit());
			
			dataBoundsPrinter.println("battery," + 
			 getBatteryLowLimit() + "," +
	  		 getBatteryHighLimit() );
	  		 // getBatteryWarnLimit() );
			
			dataBoundsPrinter.println("tilt," +
			 getTiltLowLimit() + "," +
	  		 getTiltHighLimit() );
	  		 // getTiltWarnLimit() );
	  
			dataBoundsPrinter.println("depth," +
			 getDepthLowLimit() + "," +
	  		 getDepthHighLimit() );
	  		 // getDepthWarnLimit() );
			
			dataBoundsPrinter.println("probes," +
			 getProbeLowLimit() + "," +
	  		 getProbeHighLimit() );
	  		 // getProbeWarnLimit() );
			
			dataBoundsPrinter.close();
			dataBoundsWriter.close();
		} catch (IOException error) {
		
			logger.error("can't open file for saving");

			JOptionPane.showMessageDialog(null, "Error saving file " + fullFilename, "File Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void readBoundsFile(String tempPath) {

		String fullFilename = tempPath + filename;
		logger.info("trying to read the data file: " + fullFilename);
		try {
			BufferedReader dataBounds = new BufferedReader(new FileReader(fullFilename));

			String line;

			String[] fileTokens = new String[4];
			while ( (line = dataBounds.readLine() ) != null) {
				int i = 0;
				StringTokenizer st = new StringTokenizer(line, ",");
				while (st.hasMoreTokens() ) {
					fileTokens[i] = st.nextToken();
					logger.debug("fileTokens[" + i + "]: " + fileTokens[i]);
					i++;
				}

				if (fileTokens[0].compareTo("battery") == 0) {
				
					batteryLowLimit = (new Double(fileTokens[1]) ).doubleValue();
					batteryHighLimit = (new Double(fileTokens[2]) ).doubleValue();
					// batteryWarnLimit = (new Double(fileTokens[3]) ).doubleValue();
					
				} else if (fileTokens[0].compareTo("tilt") == 0) {
				
					tiltLowLimit = (new Double(fileTokens[1]) ).doubleValue();
					tiltHighLimit = (new Double(fileTokens[2]) ).doubleValue();
					// tiltWarnLimit = (new Double(fileTokens[3]) ).doubleValue();
					
				} else if (fileTokens[0].compareTo("depth") == 0) {
				
					depthLowLimit = (new Double(fileTokens[1]) ).doubleValue();
					depthHighLimit = (new Double(fileTokens[2]) ).doubleValue();
					// depthWarnLimit = (new Double(fileTokens[3]) ).doubleValue();
					
				} else if (fileTokens[0].compareTo("probes") == 0) {
				
					probeLowLimit = (new Double(fileTokens[1]) ).doubleValue();
					probeHighLimit = (new Double(fileTokens[2]) ).doubleValue();
					// probeWarnLimit = (new Double(fileTokens[3]) ).doubleValue();
						
				} 	
			}

			dataBounds.close();
		} catch (IOException error) {
			JOptionPane.showMessageDialog(null, "File Error Reading the Data Bounds File " + 
					fullFilename + "\nException: " + error, "File Error",
					JOptionPane.ERROR_MESSAGE);
			
		} catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(null, "Number Format Problem Reading the Data Bounds File " + 
					fullFilename + "\nException: " + error, "File Error",
					JOptionPane.ERROR_MESSAGE);
			
		} catch (Exception error) {
			logger.error("Error reading the control bounds file. " + error);

			JOptionPane.showMessageDialog(null, "Unknown Error Reading the Control Bounds File" + 
					fullFilename + "\nException: " + error, "File Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
