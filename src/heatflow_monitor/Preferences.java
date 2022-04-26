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
import org.apache.log4j.Logger;

class Preferences {

	private static final long serialVersionUID = 1L;
	
	String filename = "preferences.txt";

	// static String defaultPath = "";
	static int samplingInterval = 10; // in seconds
	
	// static String tempPath;
	
	static String dataFilename = "";
	static String suggestedDataFilename = "";
	static String dataFilePath = "";
	static String previousPath = "";
	static String inputFilename = "";

	// log4j
	static Logger logger = Logger.getLogger(Heatflow.class.getName() );

	/*
	public Preferences(String tempPath) {
	
		this.tempPath = tempPath;
		
		readPreferencesFile();
	}
	*/
	
	public static void writePreferencesFile(String tempPath) {

		String fullFilename = tempPath + "preferences.txt";
		logger.debug("trying to write the preferences file: " + fullFilename);
		
		logger.debug("samplingInterval " + samplingInterval);
		logger.debug("dataFilePath " + dataFilePath);
		logger.debug("inputFilename " + inputFilename);
		
		try {
		
			FileWriter preferencesWriter = new FileWriter(fullFilename);
			PrintWriter preferencesPrinter = new PrintWriter(preferencesWriter, true);

			preferencesPrinter.println("samplingInterval " + samplingInterval);
			preferencesPrinter.println("dataFilePath " + dataFilePath);
			preferencesPrinter.println("inputFilename " + inputFilename);

			preferencesPrinter.close();
			preferencesWriter.close();
		} catch (IOException error) {
		
			logger.error("can't write to the preferences file");

			JOptionPane.showMessageDialog(null, "File Error writing the preferences File " + 
					fullFilename + "\nException: " + error, "File Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void readPreferencesFile(String tempPath) {

		String fullFilename = tempPath + "preferences.txt";
		logger.info("trying to read the preferences file: " + fullFilename);
		
		try {
		
			BufferedReader preferences = new BufferedReader(new FileReader(fullFilename));

			String line;

			String[] fileTokens = new String[2];
			while ( (line = preferences.readLine() ) != null) {
				int i = 0;
				StringTokenizer st = new StringTokenizer(line, " ");
				while (st.hasMoreTokens() ) {
					fileTokens[i] = st.nextToken();
					logger.debug("fileTokens[" + i + "]: " + fileTokens[i]);
					i++;
				}
				
				if (fileTokens[0].equalsIgnoreCase("samplingInterval")) {
					samplingInterval = new Integer(Integer.parseInt(fileTokens[1])).intValue();
					logger.info("sampling interval: " + samplingInterval);
				} 		
				
				if (fileTokens[0].equalsIgnoreCase("dataFilePath")) {
					dataFilename = fileTokens[1].trim(); // shouldn't this be dataFilePath?
					logger.info("default data path: " + dataFilePath);
				}
				
				if (fileTokens[0].equalsIgnoreCase("inputFile")) {
					inputFilename = fileTokens[1].trim();
					logger.info("input file name: " + inputFilename);
				}
			}

			preferences.close();
		} catch (IOException error) {
		
			logger.error("Error reading the preferences file. : " + error);
		
			JOptionPane.showMessageDialog(null, "File Error Reading the preferences File: " + 
					fullFilename + "\nException: " + error, "File Error",
					JOptionPane.ERROR_MESSAGE);
			
		} catch (NumberFormatException error) {
		
			logger.error("Number Format Problem Reading the preferences File " + 
					fullFilename);
					
			JOptionPane.showMessageDialog(null, "Number Format Problem Reading the preferences File: " + 
					fullFilename + "\nException: " + error, "File Error",
					JOptionPane.ERROR_MESSAGE);
			
		} catch (Exception error) {
			logger.error("Error reading the preferences file. " + error);

			JOptionPane.showMessageDialog(null, "Unknown Error Reading the preferences File: " + 
					fullFilename + "\nException: " + error, "File Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static String getDataFilename() {
		return dataFilename;
	}
	
	public static String getSuggestedDataFilename() {
		return suggestedDataFilename;
	}
	
	public static int getSamplingInterval() {
		return samplingInterval;
	}
	
	public static String getInputFilename() {
		return inputFilename;
	}
	
	public static String getDataFilePath() {
		return dataFilePath;
	}
}
