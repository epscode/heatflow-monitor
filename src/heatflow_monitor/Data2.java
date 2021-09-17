package heatflow_monitor;

import java.util.Vector;
import java.util.Date;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;
import java.util.zip.DataFormatException;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.lang.NumberFormatException;

import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import org.apache.log4j.Logger;

public class Data2 {

	private static final long serialVersionUID = 1L;
	
	// log4j
	static Logger logger = Logger.getLogger(Heatflow.class.getName());
	
	static int linesAlreadyRead = 0;
	
	String baseFilePath;
	String testDataFilePath;
	String tempDatafilename = "tempDatafilename.txt";
	
	Vector<Datum> heatflowData = new Vector<Datum>();
	
	String oneDecimalPattern = "0.0";
	DecimalFormat oneDecimalFormatter = new DecimalFormat(oneDecimalPattern);

	String twoDecimalPattern = "0.00";
	DecimalFormat twoDecimalFormatter = new DecimalFormat(twoDecimalPattern);

	String threeDecimalPattern = "0.000";
	DecimalFormat threeDecimalFormatter = new DecimalFormat(threeDecimalPattern);
	
	String sciNotationPattern = "0.000E0";
	DecimalFormat sciNotationaformatter = new DecimalFormat(sciNotationPattern);
	
	XYSeries probe1Series;
	XYSeries probe2Series;
	XYSeries probe3Series;
	XYSeries probe4Series;
	
	XYDataset temperatureData;
	XYDataset batteryData;
	XYDataset tiltData;
	XYDataset depthData;
	XYDataset baseTempData;
	
	XYSeries baseTempSeries;
	XYSeries depthSeries;
	XYSeries tiltSeries;
	XYSeries batterySeries;
	
	XYSeriesCollection temperatureDataset;
	XYSeriesCollection baseTempDataset;
	XYSeriesCollection depthDataset;
	XYSeriesCollection tiltDataset;
	XYSeriesCollection batteryDataset;
	
	// separate dataset for printing
	
	XYSeries probe1SeriesPrint;
	XYSeries probe2SeriesPrint;
	XYSeries probe3SeriesPrint;
	XYSeries probe4SeriesPrint;
	
	XYDataset temperatureDataPrint;
	XYDataset batteryDataPrint;
	XYDataset tiltDataPrint;
	XYDataset depthDataPrint;
	XYDataset baseTempDataPrint;
	
	XYSeries baseTempSeriesPrint;
	XYSeries depthSeriesPrint;
	XYSeries tiltSeriesPrint;
	XYSeries batterySeriesPrint;
	
	XYSeriesCollection temperatureDatasetPrint;
	XYSeriesCollection baseTempDatasetPrint;
	XYSeriesCollection depthDatasetPrint;
	XYSeriesCollection tiltDatasetPrint;
	XYSeriesCollection batteryDatasetPrint;
	
	MessagesPanel messagesPanel;
	
	public Data2(String baseFilePath, MessagesPanel messagesPanel) {
	 
		this.baseFilePath = baseFilePath;
		this.messagesPanel = messagesPanel;
		testDataFilePath = baseFilePath + "/test_data/";
		
		// readDatafile(testDataFilePath + "SyntheticData_210228.txt", false);
		// generatePlotData();
	}
	
	public void generatePlotData() {
		temperatureData = generateTemperatureData();
		baseTempData = generateBaseTempData();
		depthData = generateDepthData();
		tiltData = generateTiltData();
		batteryData = generateBatteryData();
	}
	
	public void clearAllData() {
	
		heatflowData.clear();
		
		// heatflowData.elementAt(lineNumber).setProbe1Temp(new Double(fileTokens[5]));
		
		probe1Series.clear();
		probe2Series.clear();
		probe3Series.clear();
		probe4Series.clear();
		
		baseTempSeries.clear();
	 	depthSeries.clear();
	 	tiltSeries.clear();
	 	batterySeries.clear();	
	}
		
	public XYSeriesCollection generateTemperatureData() {
	
		temperatureDataset = new XYSeriesCollection();
		
		probe1Series = new XYSeries("Probe 1");
		probe2Series = new XYSeries("Probe 2");
		probe3Series = new XYSeries("Probe 3");
		probe4Series = new XYSeries("Probe 4");
	
        for (int index = 0; index < getHeatflowSize(); index++) {
        	probe1Series.add(index, getHeatflowDatum(index).getProbe1Temp());
        	probe2Series.add(index, getHeatflowDatum(index).getProbe2Temp());
        	probe3Series.add(index, getHeatflowDatum(index).getProbe3Temp());
        	probe4Series.add(index, getHeatflowDatum(index).getProbe4Temp());
        }
        
        /*
        if(getHeatflowSize() > 50){
        probe1Series.add(510, getHeatflowDatum(5).getProbe1Temp());
        probe2Series.add(510, getHeatflowDatum(5).getProbe2Temp());
        probe3Series.add(510, getHeatflowDatum(5).getProbe3Temp());
        probe4Series.add(510, getHeatflowDatum(5).getProbe4Temp());
        }
        */
        
        return temperatureDataset;
    }
    
    public XYSeriesCollection generateTemperatureDataPrint() {
	
		temperatureDatasetPrint = new XYSeriesCollection();
		
		probe1SeriesPrint = new XYSeries("Probe 1");
		probe2SeriesPrint = new XYSeries("Probe 2");
		probe3SeriesPrint = new XYSeries("Probe 3");
		probe4SeriesPrint = new XYSeries("Probe 4");
	
		System.out.println("heat flow size from generateTemperatureDataPrint: " + getHeatflowSize() );
		
        for (int index = 0; index < getHeatflowSize(); index++) {
        
        	int record = getHeatflowDatum(index).getRecord();
        
        	if (record != -1) {
        	
        		System.out.println("probe 1 temp: " + getHeatflowDatum(index).getProbe1Temp() );
        		logger.info("probe 1 temp: " + getHeatflowDatum(index).getProbe1Temp() );
        		
        		probe1SeriesPrint.add(index, getHeatflowDatum(index).getProbe1Temp());
        		probe2SeriesPrint.add(index, getHeatflowDatum(index).getProbe2Temp());
        		probe3SeriesPrint.add(index, getHeatflowDatum(index).getProbe3Temp());
        		probe4SeriesPrint.add(index, getHeatflowDatum(index).getProbe4Temp());
        	}
        }
        
        temperatureDatasetPrint.addSeries(probe1SeriesPrint);
        temperatureDatasetPrint.addSeries(probe2SeriesPrint);
        temperatureDatasetPrint.addSeries(probe3SeriesPrint);
        temperatureDatasetPrint.addSeries(probe4SeriesPrint);
        
        return temperatureDatasetPrint;
    }
    
     public XYDataset generateBaseTempData() {
    
    	baseTempDataset = new XYSeriesCollection();
        
        baseTempSeries = new XYSeries("BW Temp");
        
        for (int index = 0; index < getHeatflowSize(); index++) {
        	baseTempSeries.add(index, getHeatflowDatum(index).getBaseTemp());
        }
		
        baseTempDataset.addSeries(baseTempSeries);
        
        return baseTempDataset;
    }
    
    public XYDataset generateBaseTempDataPrint() {
    
    	baseTempDatasetPrint = new XYSeriesCollection();
        
        baseTempSeriesPrint = new XYSeries("BW Temp");
        
        for (int index = 0; index < getHeatflowSize(); index++) {
        
        	int record = getHeatflowDatum(index).getRecord();
        
        	System.out.println("base temp record: " + record);
        	
        	if (record != -1) {
        		baseTempSeriesPrint.add(index, getHeatflowDatum(index).getBaseTemp());
        	}
        }
		
        baseTempDatasetPrint.addSeries(baseTempSeriesPrint);
        
        return baseTempDatasetPrint;
    }
        
    public XYDataset generateDepthData() {
    
    	depthDataset = new XYSeriesCollection();
        
        depthSeries = new XYSeries("Depth");
        
        for (int index = 0; index < getHeatflowSize(); index++) {
        	depthSeries.add(index, getHeatflowDatum(index).getDepth());
        }
        
        depthDataset.addSeries(depthSeries);
        
        return depthDataset;
    }
    
    public XYDataset generateDepthDataPrint() {
    
    	depthDatasetPrint = new XYSeriesCollection();
        
        depthSeriesPrint = new XYSeries("Depth");
        
        for (int index = 0; index < getHeatflowSize(); index++) {
        
        	int record = getHeatflowDatum(index).getRecord();
        
        	if (record != -1) {
        		depthSeriesPrint.add(index, getHeatflowDatum(index).getDepth());
        	}
        }
        
        depthDatasetPrint.addSeries(depthSeriesPrint);
        
        return depthDatasetPrint;
    }
        
    public XYDataset generateTiltData() {
    
    	tiltDataset = new XYSeriesCollection();
    	
    	tiltSeries = new XYSeries("Tilt");
    	
    	for (int index = 0; index < getHeatflowSize(); index++) {
        	tiltSeries.add(index, getHeatflowDatum(index).getTilt());
        }
    	
        tiltDataset.addSeries(tiltSeries);
        
        return tiltDataset;
    }
    
    public XYDataset generateTiltDataPrint() {
    
    	tiltDatasetPrint = new XYSeriesCollection();
    	
    	tiltSeriesPrint = new XYSeries("Tilt");
    	
    	for (int index = 0; index < getHeatflowSize(); index++) {
    	
    		int record = getHeatflowDatum(index).getRecord();
    	
    		if (record != -1) {
        		tiltSeriesPrint.add(index, getHeatflowDatum(index).getTilt());
        	}
        }
    	
        tiltDatasetPrint.addSeries(tiltSeriesPrint);
        
        return tiltDatasetPrint;
    }
    
    public XYDataset generateBatteryData() {
    
    	batteryDataset = new XYSeriesCollection();
        
        batterySeries = new XYSeries("Battery");
        
        for (int index = 0; index < getHeatflowSize(); index++) {
        	batterySeries.add(index, getHeatflowDatum(index).getBattery());
        }
        
        batteryDataset.addSeries(batterySeries);
        
        return batteryDataset;
    }
    
    public XYDataset generateBatteryDataPrint() {
    
    	batteryDatasetPrint = new XYSeriesCollection();
        
        batterySeriesPrint = new XYSeries("Battery");
        
        for (int index = 0; index < getHeatflowSize(); index++) {
        
        	int record = getHeatflowDatum(index).getRecord();
        
        	if (record != -1) {
        		batterySeriesPrint.add(index, getHeatflowDatum(index).getBattery());
        	}
        }
        
        batteryDatasetPrint.addSeries(batterySeriesPrint);
        
        return batteryDatasetPrint;
    }
	
	public void zeroLinesAlreadyRead() {
	
		logger.info("zeroing lines already read");
		linesAlreadyRead = 0;
	}
	
	public void clearData() {
		heatflowData.clear();
	}
	
	public long calculateElapsedTime(int element) {
		
		Date samplingTime = heatflowData.elementAt(element).getSamplingTime();
		
		Date firstSamplingTime = heatflowData.elementAt(0).getSamplingTime();
		
		long diffInMillies = Math.abs(samplingTime.getTime() - firstSamplingTime.getTime());
		long elapsedTime = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);

		return elapsedTime;
	}
	
	public String calculateElapsedTime() {
	
		String timeString = "00:00:00";
	
		int heatFlowSize = getHeatflowSize();
		
		if (heatFlowSize > 0) {
			
			Date latestSamplingTime = heatflowData.elementAt(heatFlowSize - 1).getSamplingTime();
		
			Date firstSamplingTime = heatflowData.elementAt(0).getSamplingTime();
		
			long diffInMillies = Math.abs(latestSamplingTime.getTime() - firstSamplingTime.getTime());
			long elapsedTime = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			
			
			System.out.println("diffInMillies:" + diffInMillies);
			System.out.println("elapsedTime: " + elapsedTime);
			
			if (elapsedTime < 3600 * 24 * 30) {
			
				timeString = String.format("%02d:%02d:%02d",
			 	 TimeUnit.MILLISECONDS.toHours(diffInMillies),
			 	 TimeUnit.MILLISECONDS.toMinutes(diffInMillies),
			 	 TimeUnit.MILLISECONDS.toSeconds(diffInMillies) - 
			 	 TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(diffInMillies)));
			}
		}
    	
    	return timeString;
	}
	
	public long calculateTimeInterval(int element) {
	
		if (element > 0) {
		
			for (int index = 1; (element - index) >= 0; index++) {	
				Date samplingTime = heatflowData.elementAt(element).getSamplingTime();
				Date samplingTimeMinus1 = heatflowData.elementAt(element - index).getSamplingTime();
		
				long diffInMillies = Math.abs(samplingTime.getTime() - samplingTimeMinus1.getTime());
				long elapsedTime = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);
				
				logger.info("element " + element );
				logger.info("index " + index);
				logger.info("diffInMillies " + diffInMillies);
				
				
				if (elapsedTime < 360000) {
					return elapsedTime;
				}
			}	
		} 
		
		return 0;
	}
	
	public void printDataLineToLog() {
	
		logger.info("trying to print data line: " + linesAlreadyRead);
		// System.out.println("trying to print data line: " + linesAlreadyRead);	
		
		logger.info("record: " + heatflowData.elementAt(linesAlreadyRead - 1).getRecord());
		logger.info("batt: " + heatflowData.elementAt(linesAlreadyRead - 1).getBattery());
		logger.info("tilt: " + heatflowData.elementAt(linesAlreadyRead - 1).getTilt());
		logger.info("depth: " + heatflowData.elementAt(linesAlreadyRead - 1).getDepth());
		logger.info("base temp: " + heatflowData.elementAt(linesAlreadyRead - 1).getBaseTemp());
		logger.info("temp1: " + heatflowData.elementAt(linesAlreadyRead - 1).getProbe1Temp());
		logger.info("temp2: " + heatflowData.elementAt(linesAlreadyRead - 1).getProbe2Temp());
		logger.info("temp3: " + heatflowData.elementAt(linesAlreadyRead - 1).getProbe3Temp());
		logger.info("temp4: " + heatflowData.elementAt(linesAlreadyRead - 1).getProbe4Temp());
		
		/*
		System.out.println("trying to print data line: " + linesAlreadyRead);	
		System.out.println("batt: " + heatflowData.elementAt(linesAlreadyRead - 1).getBattery());
		System.out.println("tilt: " + heatflowData.elementAt(linesAlreadyRead - 1).getTilt());
		System.out.println("depth: " + heatflowData.elementAt(linesAlreadyRead - 1).getDepth());
		System.out.println("base temp: " + heatflowData.elementAt(linesAlreadyRead - 1).getBaseTemp());
		System.out.println("temp1: " + heatflowData.elementAt(linesAlreadyRead - 1).getProbe1Temp());
		System.out.println("temp2: " + heatflowData.elementAt(linesAlreadyRead - 1).getProbe2Temp());
		System.out.println("temp3: " + heatflowData.elementAt(linesAlreadyRead - 1).getProbe3Temp());
		System.out.println("temp4: " + heatflowData.elementAt(linesAlreadyRead - 1).getProbe4Temp());
		*/
	}
	
	public void readDataLine() {
	
		String fullFilename = testDataFilePath + "SyntheticData_210228_currupted.txt";
		logger.info("trying to read the data file: " + fullFilename);
		System.out.println("trying to read the data file: " + fullFilename);
		
			// 21-02-25 08:00:00,24.700,0.000,2656.000,1.824,1.833,1.849,1.795,1.812
		
		try {
		
			BufferedReader inputData = new BufferedReader(new FileReader(fullFilename));

			String line;
			int lineNumber = 0;

			String[] fileTokens = new String[9];
			while ( (line = inputData.readLine() ) != null) {
			
				int elementNumber = 0;
			
				if (lineNumber >= linesAlreadyRead) {
				
					// add the line even if it's screwed up
					heatflowData.add(new Datum(line));
					// heatflowData.elementAt(lineNumber).setRecord(new Integer(lineNumber));
					
					try {
					
						StringTokenizer st = new StringTokenizer(line, ",");
			
						while (st.hasMoreTokens() ) {
							fileTokens[elementNumber] = st.nextToken();
							logger.debug("fileTokens[" + elementNumber + "]: " + fileTokens[elementNumber]);
							elementNumber++;
						}
						
						System.out.println("number of elements: " + elementNumber);
						
						
						if (elementNumber != 9) {
							heatflowData.elementAt(lineNumber).setRecord(new Integer(-1));
							throw new Exception("Parse Error");
						}
						
				
						/*
						} else {
							String message = (lineNumber + 1) + ": Complete data line returned";
							messagesPanel.setMessage(message);
						}
						*/
				
						// need to check each field can convert
			
						String pattern = "yyyy-MM-dd hh:mm:ss";
						SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
						Date samplingTime = simpleDateFormat.parse(fileTokens[0]);
						
						heatflowData.elementAt(lineNumber).setRecord(new Integer(lineNumber));
						
						heatflowData.elementAt(lineNumber).setSamplingTime(samplingTime);
						
						heatflowData.elementAt(lineNumber).setBattery(new Double(fileTokens[1]));
						heatflowData.elementAt(lineNumber).setTilt(new Double(fileTokens[2]));
						heatflowData.elementAt(lineNumber).setDepth(new Double(fileTokens[3]));
						heatflowData.elementAt(lineNumber).setBaseTemp(new Double(fileTokens[4]));
				
						heatflowData.elementAt(lineNumber).setProbe1Temp(new Double(fileTokens[5]));
						heatflowData.elementAt(lineNumber).setProbe2Temp(new Double(fileTokens[6]));
						heatflowData.elementAt(lineNumber).setProbe3Temp(new Double(fileTokens[7]));
						heatflowData.elementAt(lineNumber).setProbe4Temp(new Double(fileTokens[8]));
						
						// for the plots
						probe1Series.add(lineNumber + 1, getHeatflowDatum(lineNumber).getProbe1Temp());
						probe2Series.add(lineNumber + 1, getHeatflowDatum(lineNumber).getProbe2Temp());
						probe3Series.add(lineNumber + 1, getHeatflowDatum(lineNumber).getProbe3Temp());
						probe4Series.add(lineNumber + 1, getHeatflowDatum(lineNumber).getProbe4Temp());
				
						baseTempSeries.add(lineNumber + 1, getHeatflowDatum(lineNumber).getBaseTemp());
						depthSeries.add(lineNumber + 1, getHeatflowDatum(lineNumber).getDepth());
						tiltSeries.add(lineNumber + 1, getHeatflowDatum(lineNumber).getTilt());
						batterySeries.add(lineNumber + 1, getHeatflowDatum(lineNumber).getBattery());
				
						// for the plot states
						DataStates.determineProbe1TempStatus(getHeatflowDatum(lineNumber).getProbe1Temp());
						DataStates.determineProbe2TempStatus(getHeatflowDatum(lineNumber).getProbe2Temp());
						DataStates.determineProbe3TempStatus(getHeatflowDatum(lineNumber).getProbe3Temp());
						DataStates.determineProbe4TempStatus(getHeatflowDatum(lineNumber).getProbe4Temp());
						DataStates.determineBaseTempStatus(getHeatflowDatum(lineNumber).getBaseTemp());
						DataStates.determineBatteryStatus(getHeatflowDatum(lineNumber).getBattery());
						DataStates.determineTiltStatus(getHeatflowDatum(lineNumber).getTilt());
						DataStates.determineDepthStatus(getHeatflowDatum(lineNumber).getDepth());
	
						// String message = (lineNumber + 1) + ": Complete data line returned";
						// messagesPanel.setMessage(message);
						
						messagesPanel.setMessage(line);
						
						messagesPanel.setErrorCondition(false);
						messagesPanel.addStatus("Data is complete");
				
					} catch (NumberFormatException error) {
					
						heatflowData.elementAt(lineNumber).setRecord(new Integer(-1));
					
						// String message = "Number format problem reading the input " + 
					 	//  " Exception: " + error;
					 	
					 	String message = line + "\n" +
					 	 "Couldn't parse the input line";
					 	 
					 	logger.info(message);
					 	
					 	messagesPanel.setErrorCondition(true);
						messagesPanel.setMessage(message);
						
						// errors in red and bold
						// idea, maybe show line and then comment as ok or bad, turn area green or red
						// can display more than one line at a time or can reduce size, use larger text
		
					} catch (ParseException error) {
					
						heatflowData.elementAt(lineNumber).setRecord(new Integer(-1));
				
						// String message = "Parse error reading the input " + 
					 	//  " Exception: " + error;
					 	
					 	String message = line + "\n" +
					 	 "Couldn't parse the input line";
					 	 
					 	logger.info(message);
					 	
					 	messagesPanel.setErrorCondition(true);
						messagesPanel.setMessage(message);
						
						// test error checking by screwing up data lines -add incoming text window
						// it would be nice to have elapsed time on the screen somewhere maybe in the menu
					} catch (Exception error) {
					
						heatflowData.elementAt(lineNumber).setRecord(new Integer(-1));
					
						// String message = "Parse error reading the input " +
						//  " Exception: " + error;
						 
						String message = line + "\n" +
					 	 "Couldn't parse the input line";
						  
						logger.info(message);
						
						messagesPanel.setErrorCondition(true);
						messagesPanel.setMessage(message);
						
					} finally {
					
						String tempFilename = Preferences.getDataFilename();
						writeDatafileLine(tempFilename, lineNumber);
						
						System.out.println("added a line, linesAlreadyRead: " + linesAlreadyRead);
						System.out.println("added a line, lineNumber: " + lineNumber);
				
						linesAlreadyRead++;
				
						return;
					}
				}
			
				lineNumber++;
			}

			inputData.close();
		
		} catch(IOException error) {
			
			String message = "Error reading the input datafile " + 
			 fullFilename + "\nException: " + error;
			messagesPanel.setMessage(message);
		} 
	}
	
	public void readDatafile(String filename, boolean newFile) {
	 
		String fullFilename = filename;
		logger.info("trying to read the data file (affirm): " + fullFilename);
		
		int errors = 0;
		messagesPanel.setErrorCondition(false);
		
		try {
		
			BufferedReader inputData = new BufferedReader(new FileReader(fullFilename));

			String line;
			int lineNumber = 0;

			String[] fileTokens = new String[9];
			while ( (line = inputData.readLine() ) != null) {
			
				try {
				
					heatflowData.add(new Datum(line));
					
					int elementNumber = 0;
				
					StringTokenizer st = new StringTokenizer(line, ",");
		
					while (st.hasMoreTokens() ) {
						fileTokens[elementNumber] = st.nextToken();
						logger.debug("fileTokens[" + elementNumber + "]: " + fileTokens[elementNumber]);
						elementNumber++;
					}
					
					System.out.println("number of elements: " + elementNumber);
					
					if (elementNumber != 9) {
						heatflowData.elementAt(lineNumber).setRecord(new Integer(-1));
						throw new Exception("Parse Error");
					}
		
					// need to check each field can convert
		
					String pattern = "yyyy-MM-dd hh:mm:ss";
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
					Date samplingTime = simpleDateFormat.parse(fileTokens[0]);
					
					heatflowData.elementAt(lineNumber).setRecord(new Integer(lineNumber));
					
					heatflowData.elementAt(lineNumber).setSamplingTime(samplingTime);
					
					heatflowData.elementAt(lineNumber).setBattery(new Double(fileTokens[1]));
					heatflowData.elementAt(lineNumber).setTilt(new Double(fileTokens[2]));
					heatflowData.elementAt(lineNumber).setDepth(new Double(fileTokens[3]));
					heatflowData.elementAt(lineNumber).setBaseTemp(new Double(fileTokens[4]));
			
					heatflowData.elementAt(lineNumber).setProbe1Temp(new Double(fileTokens[5]));
					heatflowData.elementAt(lineNumber).setProbe2Temp(new Double(fileTokens[6]));
					heatflowData.elementAt(lineNumber).setProbe3Temp(new Double(fileTokens[7]));
					heatflowData.elementAt(lineNumber).setProbe4Temp(new Double(fileTokens[8]));
					
					// for the plots
					probe1Series.add(lineNumber + 1, getHeatflowDatum(lineNumber).getProbe1Temp());
					probe2Series.add(lineNumber + 1, getHeatflowDatum(lineNumber).getProbe2Temp());
					probe3Series.add(lineNumber + 1, getHeatflowDatum(lineNumber).getProbe3Temp());
					probe4Series.add(lineNumber + 1, getHeatflowDatum(lineNumber).getProbe4Temp());
			
					baseTempSeries.add(lineNumber + 1, getHeatflowDatum(lineNumber).getBaseTemp());
					depthSeries.add(lineNumber + 1, getHeatflowDatum(lineNumber).getDepth());
					tiltSeries.add(lineNumber + 1, getHeatflowDatum(lineNumber).getTilt());
					batterySeries.add(lineNumber + 1, getHeatflowDatum(lineNumber).getBattery());
					
					/*
					// for the plot states
					DataStates.determineProbe1TempStatus(getHeatflowDatum(lineNumber).getProbe1Temp());
					DataStates.determineProbe2TempStatus(getHeatflowDatum(lineNumber).getProbe2Temp());
					DataStates.determineProbe3TempStatus(getHeatflowDatum(lineNumber).getProbe3Temp());
					DataStates.determineProbe4TempStatus(getHeatflowDatum(lineNumber).getProbe4Temp());
					DataStates.determineBaseTempStatus(getHeatflowDatum(lineNumber).getBaseTemp());
					DataStates.determineBatteryStatus(getHeatflowDatum(lineNumber).getBattery());
					DataStates.determineTiltStatus(getHeatflowDatum(lineNumber).getTilt());
					DataStates.determineDepthStatus(getHeatflowDatum(lineNumber).getDepth());
					
					messagesPanel.setMessage(line);
					
					messagesPanel.setErrorCondition(false);
					messagesPanel.addStatus("Data is complete");
					*/
				
				} catch (NumberFormatException error) {
				
					errors++;
					
					heatflowData.elementAt(lineNumber).setRecord(new Integer(-1));
			
					String message = "Number format problem reading the input " + 
					 " Exception: " + error;
				 
					logger.info(message);
				
					messagesPanel.setErrorCondition(true);
					messagesPanel.setMessage(message);
					
				} catch (ParseException error) {
				
					errors++;
					
					heatflowData.elementAt(lineNumber).setRecord(new Integer(-1));
		
					String message = "Parse error reading the input " + 
					 " Exception: " + error;
				 
					logger.info(message);
				
					messagesPanel.setErrorCondition(true);
					messagesPanel.setMessage(message);
				
				} catch (Exception error) {
				
					errors++;
					
					heatflowData.elementAt(lineNumber).setRecord(new Integer(-1));
				
					String message = "Parse error reading the input " +
					 " Exception: " + error;
					  
					logger.info(message);
					
					messagesPanel.setErrorCondition(true);
					messagesPanel.setMessage(message);
						
				} finally {
				
					System.out.println("added a line, lineNumber: " + lineNumber);
					
					lineNumber++;
				}
			}

			inputData.close();
			
			if (errors == 0) {
		
				String message = "There were " + errors + " lines that were read incorrectly.";
		
				messagesPanel.setErrorCondition(false);
				messagesPanel.setMessage(message);
			} else {
		
				String message = "There were " + errors + " lines that were read incorrectly.";
		
				messagesPanel.setErrorCondition(true);
				messagesPanel.setMessage(message);
			}
		
		} catch(IOException error) {
			
			String message = "Error reading the input datafile " + 
			 fullFilename + "\nException: " + error;
			messagesPanel.setMessage(message);
		}
		
		return;
	}
	
	public void readData() {
	
		String fullFilename = testDataFilePath + "SyntheticData_210228_currupted.txt";
		logger.info("trying to read the data file: " + fullFilename);
		System.out.println("trying to read the data file: " + fullFilename);
		
		messagesPanel.setErrorCondition(false);
		int errors = 0;
		
		try {
		
			BufferedReader inputData = new BufferedReader(new FileReader(fullFilename));

			String line;
			int lineNumber = 0;
			

			String[] fileTokens = new String[9];
			while ( (line = inputData.readLine() ) != null) {
			
				try {
				
					int elementNumber = 0;
				
					StringTokenizer st = new StringTokenizer(line, ",");
		
					while (st.hasMoreTokens() ) {
						fileTokens[elementNumber] = st.nextToken();
						logger.debug("fileTokens[" + elementNumber + "]: " + fileTokens[elementNumber]);
						elementNumber++;
					}
					
					System.out.println("number of elements: " + elementNumber);
					
					if (elementNumber != 9) {
						heatflowData.elementAt(lineNumber).setRecord(new Integer(-1));
						throw new Exception("Parse Error");
					}
		
					// need to check each field can convert
		
					String pattern = "yyyy-MM-dd hh:mm:ss";
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
					Date samplingTime = simpleDateFormat.parse(fileTokens[0]);
					
					heatflowData.elementAt(lineNumber).setRecord(new Integer(lineNumber));
					
					heatflowData.elementAt(lineNumber).setSamplingTime(samplingTime);
					
					heatflowData.elementAt(lineNumber).setBattery(new Double(fileTokens[1]));
					heatflowData.elementAt(lineNumber).setTilt(new Double(fileTokens[2]));
					heatflowData.elementAt(lineNumber).setDepth(new Double(fileTokens[3]));
					heatflowData.elementAt(lineNumber).setBaseTemp(new Double(fileTokens[4]));
			
					heatflowData.elementAt(lineNumber).setProbe1Temp(new Double(fileTokens[5]));
					heatflowData.elementAt(lineNumber).setProbe2Temp(new Double(fileTokens[6]));
					heatflowData.elementAt(lineNumber).setProbe3Temp(new Double(fileTokens[7]));
					heatflowData.elementAt(lineNumber).setProbe4Temp(new Double(fileTokens[8]));
					
					// for the plots
					probe1Series.add(lineNumber, getHeatflowDatum(lineNumber).getProbe1Temp());
					probe2Series.add(lineNumber, getHeatflowDatum(lineNumber).getProbe2Temp());
					probe3Series.add(lineNumber, getHeatflowDatum(lineNumber).getProbe3Temp());
					probe4Series.add(lineNumber, getHeatflowDatum(lineNumber).getProbe4Temp());
			
					baseTempSeries.add(lineNumber, getHeatflowDatum(lineNumber).getBaseTemp());
					depthSeries.add(lineNumber, getHeatflowDatum(lineNumber).getDepth());
					tiltSeries.add(lineNumber, getHeatflowDatum(lineNumber).getTilt());
					batterySeries.add(lineNumber, getHeatflowDatum(lineNumber).getBattery());
			
					// for the plot states
					DataStates.determineProbe1TempStatus(getHeatflowDatum(lineNumber).getProbe1Temp());
					DataStates.determineProbe2TempStatus(getHeatflowDatum(lineNumber).getProbe2Temp());
					DataStates.determineProbe3TempStatus(getHeatflowDatum(lineNumber).getProbe3Temp());
					DataStates.determineProbe4TempStatus(getHeatflowDatum(lineNumber).getProbe4Temp());
					DataStates.determineBaseTempStatus(getHeatflowDatum(lineNumber).getBaseTemp());
					DataStates.determineBatteryStatus(getHeatflowDatum(lineNumber).getBattery());
					DataStates.determineTiltStatus(getHeatflowDatum(lineNumber).getTilt());
					DataStates.determineDepthStatus(getHeatflowDatum(lineNumber).getDepth());
					
					messagesPanel.setMessage(line);
					
					messagesPanel.setErrorCondition(false);
					messagesPanel.addStatus("Data is complete");
				
				} catch (NumberFormatException error) {
					
					heatflowData.elementAt(lineNumber).setRecord(new Integer(-1));
			
					String message = "Number format problem reading the input " + 
					 " Exception: " + error;
				 
					logger.info(message);
				
					messagesPanel.setErrorCondition(true);
					messagesPanel.setMessage(message);
					
					errors++;
						
				} catch (ParseException error) {
					
					heatflowData.elementAt(lineNumber).setRecord(new Integer(-1));
		
					String message = "Parse error reading the input " + 
					 " Exception: " + error;
				 
					logger.info(message);
				
					messagesPanel.setErrorCondition(true);
					messagesPanel.setMessage(message);
					
					errors++;
				
				} catch (Exception error) {
					
					heatflowData.elementAt(lineNumber).setRecord(new Integer(-1));
				
					String message = "Parse error reading the input " +
					 " Exception: " + error;
					  
					logger.info(message);
					
					messagesPanel.setErrorCondition(true);
					messagesPanel.setMessage(message);
					
					errors++;
						
				} finally {
					
					String tempFilename = Preferences.getDataFilename();
					writeDatafileLine(tempFilename, lineNumber);
					
					System.out.println("added a line, linesAlreadyRead: " + linesAlreadyRead);
					System.out.println("added a line, lineNumber: " + lineNumber);
			
					lineNumber++;
				}
			}

			inputData.close();
			
			if (errors == 0) {
		
				String message = "There were " + errors + " lines that were read incorrectly.";
		
				messagesPanel.setErrorCondition(true);
				messagesPanel.setMessage(message);
			} else {
		
				String message = "There were " + errors + " lines that were read incorrectly.";
		
				messagesPanel.setErrorCondition(false);
				messagesPanel.setMessage(message);
			}
		
		} catch(IOException error) {
			
			String message = "Error reading the input datafile " + 
			 fullFilename + "\nException: " + error;
			messagesPanel.setMessage(message);
		} 
		
		
		
		return;
	}
	
	/*
	public void readDatafile(String filename, boolean newFile) {
	 
		String fullFilename = filename;
		logger.info("trying to read the data file: " + fullFilename);
		
		// 21-02-25 08:00:00,24.700,0.000,2656.000,1.824,1.833,1.849,1.795,1.812
		
		try {
			BufferedReader inputData = new BufferedReader(new FileReader(fullFilename));

			String line;
			int lineNumber = 0;

			String[] fileTokens = new String[9];
			while ( (line = inputData.readLine() ) != null) {
				int i = 0;
				StringTokenizer st = new StringTokenizer(line, ",");
				
				heatflowData.add(new Datum(line));
				
				while (st.hasMoreTokens() ) {
					fileTokens[i] = st.nextToken();
					// logger.debug("fileTokens[" + i + "]: " + fileTokens[i]);
					i++;
				}
				
				heatflowData.elementAt(lineNumber).setRecord(new Integer(lineNumber));
				
				String pattern = "yyyy-MM-dd hh:mm:ss";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				Date samplingTime = simpleDateFormat.parse(fileTokens[0]);
				heatflowData.elementAt(lineNumber).setSamplingTime(samplingTime);
				heatflowData.elementAt(lineNumber).setBattery(new Double(fileTokens[1]));
				heatflowData.elementAt(lineNumber).setTilt(new Double(fileTokens[2]));
				heatflowData.elementAt(lineNumber).setDepth(new Double(fileTokens[3]));
				heatflowData.elementAt(lineNumber).setBaseTemp(new Double(fileTokens[4]));
				heatflowData.elementAt(lineNumber).setProbe1Temp(new Double(fileTokens[5]));
				heatflowData.elementAt(lineNumber).setProbe2Temp(new Double(fileTokens[6]));
				heatflowData.elementAt(lineNumber).setProbe3Temp(new Double(fileTokens[7]));
				heatflowData.elementAt(lineNumber).setProbe4Temp(new Double(fileTokens[8]));
				
				if (newFile) {
				
					probe1Series.add(lineNumber, getHeatflowDatum(lineNumber).getProbe1Temp());
        			probe2Series.add(lineNumber, getHeatflowDatum(lineNumber).getProbe2Temp());
        			probe3Series.add(lineNumber, getHeatflowDatum(lineNumber).getProbe3Temp());
        			probe4Series.add(lineNumber, getHeatflowDatum(lineNumber).getProbe4Temp());
        			
        			baseTempSeries.add(lineNumber, getHeatflowDatum(lineNumber).getBaseTemp());
	 				depthSeries.add(lineNumber, getHeatflowDatum(lineNumber).getDepth());
	 				tiltSeries.add(lineNumber, getHeatflowDatum(lineNumber).getTilt());
	 				batterySeries.add(lineNumber, getHeatflowDatum(lineNumber).getBattery());
	 			}
				
				// logger.debug("last element of depthVector: " + depthVector.lastElement() );
				
				lineNumber++;
				
				
			}

			inputData.close();
		} catch (IOException error) {
			JOptionPane.showMessageDialog(null, "File error reading the input datafile " + 
					fullFilename + "\nException: " + error, "File Error",
					JOptionPane.ERROR_MESSAGE);
			
		} catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(null, "Number format problem reading the input datafile " + 
					fullFilename + "\nException: " + error, "File Error",
					JOptionPane.ERROR_MESSAGE);
			
		} catch (Exception error) {
			logger.error("Error reading the input data file. " + error);

			JOptionPane.showMessageDialog(null, "Unknown error reading the input datafile " + 
					fullFilename + "\nException: " + error, "File Error",
					JOptionPane.ERROR_MESSAGE);
		}
	
	}
	*/
	
	public Datum getHeatflowDatum(int index) {
		return heatflowData.elementAt(index);
	}
	
	public int getHeatflowSize() {
		return heatflowData.size();
	}
	
	public void writeDatafile(String filename) {
	
		String fullFilename = filename;
		logger.debug("trying to write the raw data file: " + filename);
		int lineNumber = 0;
		
		try {
		
			FileWriter dataWriter = new FileWriter(fullFilename);
			PrintWriter dataPrinter = new PrintWriter(dataWriter, true);
			
			for (int line = 0; line < getHeatflowSize(); line++) {
			
				String rawLine = heatflowData.elementAt(lineNumber).getRawLine();
				dataPrinter.print(rawLine);
			}
			
			dataPrinter.close();
			dataWriter.close();
		} catch (IOException error) {
			logger.error("can't open file for saving: " + error);

			JOptionPane.showMessageDialog(null, "Error saving file " + fullFilename, "File Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void writeDatafileParsed(String filename) {
	
		// baseFilePath + "/saveddata/" + 
		String fullFilename = filename;
		logger.debug("trying to write the test data file: " + filename);
		int lineNumber = 0;
		
		try {
		
			FileWriter dataWriter = new FileWriter(fullFilename);
			PrintWriter dataPrinter = new PrintWriter(dataWriter, true);
			
			for (int line = 0; line < getHeatflowSize(); line++) {
			
				// watch number of decimal places in file
			
				// idk if we want this - maybe
				// dataPrinter.print(heatflowData.elementAt(lineNumber).getRecord() + ",");
				
				Date samplingTime = heatflowData.elementAt(lineNumber).getSamplingTime();
				
				String pattern = "yy-MM-dd HH:mm:ss";
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

				String samplingTimeString = simpleDateFormat.format(samplingTime);
				dataPrinter.print(samplingTimeString + ","); 
				
				double batteryVal = heatflowData.elementAt(lineNumber).getBattery();
				double tiltVal = heatflowData.elementAt(lineNumber).getTilt();
				double depthVal = heatflowData.elementAt(lineNumber).getDepth();
				double baseTempVal = heatflowData.elementAt(lineNumber).getBaseTemp();
				double probe1TempVal = heatflowData.elementAt(lineNumber).getProbe1Temp();
				double probe2TempVal = heatflowData.elementAt(lineNumber).getProbe2Temp();
				double probe3TempVal = heatflowData.elementAt(lineNumber).getProbe3Temp();
				double probe4TempVal = heatflowData.elementAt(lineNumber).getProbe4Temp();
				
				dataPrinter.print(twoDecimalFormatter.format(batteryVal) + ",");
				dataPrinter.print(twoDecimalFormatter.format(tiltVal) + ",");
				dataPrinter.print(threeDecimalFormatter.format(depthVal) + ",");
				dataPrinter.print(threeDecimalFormatter.format(baseTempVal) + ",");
        		dataPrinter.print(threeDecimalFormatter.format(probe1TempVal) + ",");
        		dataPrinter.print(threeDecimalFormatter.format(probe2TempVal) + ",");
        		dataPrinter.print(threeDecimalFormatter.format(probe3TempVal) + ",");
        		dataPrinter.print(threeDecimalFormatter.format(probe4TempVal));
				dataPrinter.println();
			}
			
			dataPrinter.close();
			dataWriter.close();
		} catch (IOException error) {
			logger.error("can't open file for saving: " + error);

			JOptionPane.showMessageDialog(null, "Error saving file " + fullFilename, "File Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void calculateGradients() {
	
		for (int index = 0; index < heatflowData.size(); index++) {
			heatflowData.elementAt(index).calculateCompleteGradients();
		}
	}
	
	public void calculateGradient(int index) {
	
		heatflowData.elementAt(index).calculateCompleteGradients();
	}
	
	public void calculateLastGradient() {
	
		heatflowData.lastElement().calculateCompleteGradients();
	}
	
	/*
	public void clearAllData() {
	
		heatflowData.clear();
		
		temperatureDataset.removeSeries(probe1Series);
	 	temperatureDataset.removeSeries(probe2Series);
	 	temperatureDataset.removeSeries(probe3Series);
	 	temperatureDataset.removeSeries(probe4Series);
	 	
	 	baseTempDataset.removeSeries(baseTempSeries);
	 	depthDataset.removeSeries(depthSeries);
		tiltDataset.removeSeries(tiltSeries);
		batteryDataset.removeSeries(batterySeries);	
		
		temperatureData = generateTemperatureData();
		
		probe1Series.setKey(HeatProbeNames.getProbe1Name());
		probe2Series.setKey(HeatProbeNames.getProbe2Name());
		probe3Series.setKey(HeatProbeNames.getProbe3Name());
		probe4Series.setKey(HeatProbeNames.getProbe4Name());
		
		temperatureDataset.addSeries(probe1Series);
		temperatureDataset.addSeries(probe2Series);
		temperatureDataset.addSeries(probe3Series);
		temperatureDataset.addSeries(probe4Series);
	}
	*/
	
	public void changeSeriesNames() {
		
		logger.info("get probe1 name: " + HeatProbeNames.getProbe1Name());
		logger.info("get probe2 name: " + HeatProbeNames.getProbe2Name());
		logger.info("get probe3 name: " + HeatProbeNames.getProbe3Name());
		logger.info("get probe4 name: " + HeatProbeNames.getProbe4Name());
		
		temperatureDataset.removeSeries(probe1Series);
		temperatureDataset.removeSeries(probe2Series);
		temperatureDataset.removeSeries(probe3Series);
		temperatureDataset.removeSeries(probe4Series);
		
		probe1Series.setKey(HeatProbeNames.getProbe1Name());
		probe2Series.setKey(HeatProbeNames.getProbe2Name());
		probe3Series.setKey(HeatProbeNames.getProbe3Name());
		probe4Series.setKey(HeatProbeNames.getProbe4Name());
		
		temperatureDataset.addSeries(probe1Series);
		temperatureDataset.addSeries(probe2Series);
		temperatureDataset.addSeries(probe3Series);
		temperatureDataset.addSeries(probe4Series);
	}
	
	public void zeroWritingDatafile() {
		String fullFilename = Preferences.getDataFilename();
		logger.debug("trying to write the test data file: " + fullFilename);
		
		try {	
			FileWriter dataWriter = new FileWriter(fullFilename, false); // should start new file
			PrintWriter dataPrinter = new PrintWriter(dataWriter, true);
			
			dataPrinter.close();
			dataWriter.close();
		} catch (IOException error) {
		
			logger.error("can't open file for saving: " + error);

			JOptionPane.showMessageDialog(null, "Error saving file " + fullFilename, "File Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void writeDatafileLine(String filename, int lineNumber) {
	
		// String fullFilename = baseFilePath + "/saveddata/" + filename;
		String fullFilename = Preferences.getDataFilename();
		logger.debug("trying to write the test data file: " + fullFilename);
		
		try {
		
			FileWriter dataWriter = new FileWriter(fullFilename, true); // should append file
			PrintWriter dataPrinter = new PrintWriter(dataWriter, true);
			
			String rawLine = heatflowData.elementAt(lineNumber).getRawLine();
			dataPrinter.println(rawLine); 
			
			dataPrinter.close();
			dataWriter.close();
		} catch (IOException error) {
		
			logger.error("can't open file for saving: " + error);

			// JOptionPane.showMessageDialog(null, "Error saving file " + fullFilename, "File Error",
			//		JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void writeDatafileLineParsed(String filename, int lineNumber) {
	
		// String fullFilename = baseFilePath + "/saveddata/" + filename;
		String fullFilename = Preferences.getDataFilename();
		logger.debug("trying to write the test data file: " + fullFilename);
		
		try {
		
			FileWriter dataWriter = new FileWriter(fullFilename, true); // should append file
			PrintWriter dataPrinter = new PrintWriter(dataWriter, true);
			
			// watch number of decimal places in file
		
			// idk if we want this - maybe
			// dataPrinter.print(heatflowData.elementAt(lineNumber).getRecord() + ",");
			
			Date samplingTime = heatflowData.elementAt(lineNumber).getSamplingTime();
			
			String pattern = "yy-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			String samplingTimeString = simpleDateFormat.format(samplingTime);
			dataPrinter.print(samplingTimeString + ","); 
			
			double batteryVal = heatflowData.elementAt(lineNumber).getBattery();
			double tiltVal = heatflowData.elementAt(lineNumber).getTilt();
			double depthVal = heatflowData.elementAt(lineNumber).getDepth();
			double baseTempVal = heatflowData.elementAt(lineNumber).getBaseTemp();
			double probe1TempVal = heatflowData.elementAt(lineNumber).getProbe1Temp();
			double probe2TempVal = heatflowData.elementAt(lineNumber).getProbe2Temp();
			double probe3TempVal = heatflowData.elementAt(lineNumber).getProbe3Temp();
			double probe4TempVal = heatflowData.elementAt(lineNumber).getProbe4Temp();
			
			dataPrinter.print(twoDecimalFormatter.format(batteryVal) + ",");
			dataPrinter.print(twoDecimalFormatter.format(tiltVal) + ",");
			dataPrinter.print(threeDecimalFormatter.format(depthVal) + ",");
			dataPrinter.print(threeDecimalFormatter.format(baseTempVal) + ",");
			dataPrinter.print(threeDecimalFormatter.format(probe1TempVal) + ",");
			dataPrinter.print(threeDecimalFormatter.format(probe2TempVal) + ",");
			dataPrinter.print(threeDecimalFormatter.format(probe3TempVal) + ",");
			dataPrinter.print(threeDecimalFormatter.format(probe4TempVal));
			dataPrinter.println();
			
			dataPrinter.close();
			dataWriter.close();
		} catch (IOException error) {
		
			logger.error("can't open file for saving: " + error);

			JOptionPane.showMessageDialog(null, "Error saving file " + fullFilename, "File Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	void setTempdatafilename(String tempDatafilename) {
	
		this.tempDatafilename = tempDatafilename;
	}
}