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
import java.util.Vector;

import javax.swing.*;
import org.apache.log4j.Logger;

class HeatProbeNames {

	private static final long serialVersionUID = 1L;
	
	static String filename = "heatprobenames.txt";

	static String probe1Name = "";
	static String probe2Name = "";
	static String probe3Name = "";
	static String probe4Name = "";
	
	static double probe1Depth = 0.0;
	static double probe2Depth = 0.0;
	static double probe3Depth = 0.0;
	static double probe4Depth = 0.0;
	
	static double upperDistance = 0.0;
	static double middleDistance = 0.0;
	static double lowerDistance = 0.0;
	static double fullDistance = 0.0;
	
	static Vector<String> possibleProbeNames = new Vector<String>();
	static Vector<Double> possibleProbeDepths = new Vector<Double>();
	
	static Frame frame;
	static String filepath;

	// log4j
	static Logger logger = Logger.getLogger(Heatflow.class.getName() );

	static public void setFilepath(String filepath) { 
		filepath = filepath;
	}
	
	static void writeProbeNamesFile(String filepath) {

		String fullFilename = filepath + "heatprobenames.txt";
		logger.debug("trying to write the heating probe names file: " + fullFilename);
		
		try {
			FileWriter probeNamesWriter = new FileWriter(fullFilename);
			PrintWriter probeNamesPrinter = new PrintWriter(probeNamesWriter, true);

			probeNamesPrinter.println("probe1 " + probe1Name + " " + probe1Depth);
			probeNamesPrinter.println("probe2 " + probe2Name + " " + probe2Depth);
			probeNamesPrinter.println("probe3 " + probe3Name + " " + probe3Depth);
			probeNamesPrinter.println("probe4 " + probe4Name + " " + probe4Depth);

			probeNamesPrinter.close();
			probeNamesWriter.close();
		} catch (IOException error) {
			logger.error("can't open file for saving: " + error);

			JOptionPane.showMessageDialog(null, "Error saving file: " + fullFilename, "File Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	static public void readProbeNamesFile(String filepath) {
	
		logger.info("file path: " + filepath);

		String fullFilename = filepath + "heatprobenames.txt";
		logger.info("trying to read the probe name file: " + fullFilename);
		try {
			BufferedReader probeNamesReader = new BufferedReader(new FileReader(fullFilename));

			String line;

			String[] fileTokens = new String[3];
			while ( (line = probeNamesReader.readLine() ) != null) {
				int i = 0;
				StringTokenizer st = new StringTokenizer(line, " ");
				while (st.hasMoreTokens() ) {
				
					fileTokens[i] = st.nextToken();
					logger.debug("fileTokens[" + i + "]: " + fileTokens[i]);
					i++;
				}

				if (fileTokens[0].compareTo("probe1") == 0) {
				
					probe1Name = fileTokens[1];
					logger.info("probe 1 name " + probe1Name);
					probe1Depth = new Double(fileTokens[2]).doubleValue();
					logger.info("probe 1 depth " + probe1Depth);
				} else if (fileTokens[0].compareTo("probe2") == 0) {
				
					probe2Name = fileTokens[1];
					logger.info("probe 2 name: " + probe2Name);
					probe2Depth = new Double(fileTokens[2]).doubleValue();
					logger.info("probe 2 depth " + probe2Depth);
				} else if (fileTokens[0].compareTo("probe3") == 0) {
				
					probe3Name = fileTokens[1];
					logger.info("probe 3 name: " + probe3Name);
					probe3Depth = new Double(fileTokens[2]).doubleValue();
					logger.info("probe 3 depth " + probe3Depth);
				} else if (fileTokens[0].compareTo("probe4") == 0) {
				
					probe4Name = fileTokens[1];
					logger.info("probe 4 name: " + probe4Name);
					probe4Depth = new Double(fileTokens[2]).doubleValue();
					logger.info("probe 4 depth " + probe4Depth);
				} else if ( 
				 (probe1Name.compareTo("") == 0) ||
			 	 (probe2Name.compareTo("") == 0) || 
			 	 (probe3Name.compareTo("") == 0) || 
			 	 (probe4Name.compareTo("") == 0) ) {
					JOptionPane.showMessageDialog(null, "File error reading the probe name file: 1 " + 
					fullFilename, "File Error",
					JOptionPane.ERROR_MESSAGE);
				}
			}

			probeNamesReader.close();
			
		} catch (IOException error) {
		
			logger.info("Error reading the probe file name: " + fullFilename);
		
			JOptionPane.showMessageDialog(null, "File error reading the probe name File: 3 " + 
					fullFilename + "\nException: " + error, "File Error",
					JOptionPane.ERROR_MESSAGE);
			
		} catch (NumberFormatException error) {
		
			logger.info("Error reading the probe file name: " + fullFilename);
		
			JOptionPane.showMessageDialog(null, "File error reading the probe name File: 4 " + 
					fullFilename + "\nException: " + error, "File Error",
					JOptionPane.ERROR_MESSAGE);
			
		} catch (Exception error) {
		
			logger.info("Error reading the probe file name: " + fullFilename);

			JOptionPane.showMessageDialog(null, "Unknown error reading the probe name File: 5 " + 
					fullFilename, "File Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	static String getProbe1Name() {
		logger.info("probe 1: " + probe1Name);
		return probe1Name;
	}
	
	static String getProbe2Name() {
		logger.info("probe 2: " + probe2Name);
		return probe2Name;
	}
	
	static String getProbe3Name() {
		logger.info("probe 3: " + probe3Name);
		return probe3Name;
	}
	
	static String getProbe4Name() {
		logger.info("probe 4: " + probe4Name);
		return probe4Name;
	}
	
	
	// depths of probes
	static double getProbe1Depth() {
		logger.info("probe 1: " + probe1Depth);
		return probe1Depth;
	}
	
	static double getProbe2Depth() {
		logger.info("probe 2: " + probe2Depth);
		return probe2Depth;
	}
	
	static double getProbe3Depth() {
		logger.info("probe 3: " + probe3Depth);
		return probe3Depth;
	}
	
	static double getProbe4Depth() {
		logger.info("probe 4: " + probe4Depth);
		return probe4Depth;
	}
	
	static void writePossibleProbeNamesFile(String filepath) { 

		String fullFilename = filepath + "possibleHeatprobenames.txt";
		logger.debug("trying to write the heating probe possible names file: " + fullFilename);
		logger.info("file name including the path: " + fullFilename);
		
		try {
		
			FileWriter probeNamesWriter = new FileWriter(fullFilename);
			PrintWriter probeNamesPrinter = new PrintWriter(probeNamesWriter, true);

			logger.info("size of possible probe names: " + possibleProbeNames.size() );
			for (int probeNumber = 0; probeNumber < possibleProbeNames.size(); probeNumber++) {
			
				logger.info("probe number: " + probeNumber);
			
				probeNamesPrinter.println("probe" + probeNumber + " " + 
				 getPossibleProbeName(probeNumber) + " " + getPossibleProbeDepth(probeNumber));
			}

			probeNamesPrinter.close();
			probeNamesWriter.close();
		} catch (IOException error) {
			logger.error("can't open file for saving: " + error);

			JOptionPane.showMessageDialog(null, "Error saving file: " + fullFilename, "File Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	static public void readPossibleProbeNamesFile(String filepath) {

		String fullFilename = filepath + "possibleHeatprobenames.txt";
		logger.info("trying to read the possible heat probe file: " + fullFilename);
		
		// clear the list beforehand
		clearPossibleProbeName();
		
		try {
		
			BufferedReader probeNamesReader = new BufferedReader(new FileReader(fullFilename));

			String line;

			String[] fileTokens = new String[3];
			while ( (line = probeNamesReader.readLine() ) != null) {
				int i = 0;
				StringTokenizer st = new StringTokenizer(line, " ");
				while (st.hasMoreTokens() ) {
					fileTokens[i] = st.nextToken();
					logger.debug("fileTokens[" + i + "]: " + fileTokens[i]);
					i++;
				}
				
				setPossibleProbeName(fileTokens[1]);
				setPossibleProbeDepth(new Double(fileTokens[2]).doubleValue());
				
				/*
				for (int probeNumber = 0; probeNumber < possibleProbeNames.size(); probeNumber++) {
			
					if (fileTokens[0].compareTo(getPossibleProbeName(probeNumber) ) == 0) {
					
						logger.info("probe name from read possible probe name file: " + fileTokens[1]);
						setPossibleProbeName(fileTokens[1]);
					}
				}
				*/
			}
				 
			probeNamesReader.close();
		} catch (IOException error) {
		
			logger.info("Error reading the possible probe file name: " + fullFilename);
		
			JOptionPane.showMessageDialog(null, "File Error reading the possible probe name File: " + 
					fullFilename + "\nException: " + error, "File Error",
					JOptionPane.ERROR_MESSAGE);
			
		} catch (NumberFormatException error) {
		
			logger.info("Error reading the possible probe file name: " + fullFilename);
		
			JOptionPane.showMessageDialog(null, "File Error reading the possible probe name File: " + 
					fullFilename + "\nException: " + error, "File Error",
					JOptionPane.ERROR_MESSAGE);
			
		} catch (Exception error) {
		
			logger.info("Error reading the probe name file: " + error);
			logger.info("Error reading the possible probe file name: " + fullFilename);

			JOptionPane.showMessageDialog(null, "Unknown Error reading the possible probe name File: " + 
					fullFilename, "File Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	static void setPossibleProbeName(String probeName) {
	
		possibleProbeNames.add(probeName);
		
		logger.info("possible probe names: " + possibleProbeNames.size() );
	}
	
	static String getPossibleProbeName(int index) {
	
		logger.info("index number from get possible probe name: " + index);
		logger.info("size of possible probe names: " + possibleProbeNames.size() );
		
		return possibleProbeNames.elementAt(index);
	}
	
	static void clearPossibleProbeName() {
		possibleProbeNames.clear();
	}
	
	static Vector<String> getPossibleProbeNames() {
		
		return possibleProbeNames;
	}
	
	
	static void setPossibleProbeDepth(double probeDepth) {
		possibleProbeDepths.add(probeDepth);
		
		logger.info("possible probe depths: " + possibleProbeDepths.size() );
	}
	
	static double getPossibleProbeDepth(int index) {
	
		logger.info("index number from get possible probe depths: " + index);
		logger.info("size of possible probe depths: " + possibleProbeDepths.size() );
		
		return possibleProbeDepths.elementAt(index);
	}
	
	static Vector<Double> getPossibleProbeDepths() {
		return possibleProbeDepths;
	}
}
