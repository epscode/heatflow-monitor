package heatflow_monitor;

import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;
import javax.swing.JLabel;

//log4j
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.commons.lang3.exception.ExceptionUtils;

class FetchData {

	Data2 heatingData;
	StatusPanel2 statusPanel;
	JLabel elapsedTimeLabelVal;
	boolean testMode = false;
	
	int samplingInterval = 10;
	
	// log4j
	static Logger logger = Logger.getLogger(Heatflow.class.getName());
	
	// Create the scheduler
	ScheduledExecutorService scheduledExecutorService;
	
	ScheduledFuture<?> scheduledFuture;
	
	public void setMode(boolean testMode) {
		this.testMode = testMode;
	}
	
	public boolean getMode() {
		return testMode;
	}

	public FetchData(Data2 heatingData, StatusPanel2 statusPanel, JLabel elapsedTimeLabelVal) {
	
		this.heatingData = heatingData;
		this.statusPanel = statusPanel;
		this.elapsedTimeLabelVal = elapsedTimeLabelVal;
		
		logger.info("creating new fetch data object");
		
		scheduledExecutorService = Executors.newScheduledThreadPool(1);
	}

	// Create the task to execute
	Runnable r = new Runnable() {
    	@Override
    	public void run() {
        	System.out.println("Fetching new data");
        	logger.info("fetching new data");
        	
        	if (testMode == true) {
        	
				heatingData.readDataLine();
				heatingData.printDataLineToLog();
				heatingData.calculateLastGradient();
			
				System.out.println("Is this causing a problem?");
				heatingData.calculateElapsedTime();
			
				System.out.println("elapsed time: " + heatingData.calculateElapsedTime());
			
				elapsedTimeLabelVal.setText(heatingData.calculateElapsedTime() );
				statusPanel.addDatarow();
				statusPanel.setProbeStates();
				
        	} else {
        	
        		heatingData.readLastLineFromDataFile();
        		
        		// only update data display if we have new data
        		if (heatingData.newData) {
        			heatingData.printDataLineToLog();
					heatingData.calculateLastGradient();
			
					System.out.println("after calculating the gradient");
					heatingData.calculateElapsedTime();
				
					System.out.println("elapsed time: " + heatingData.calculateElapsedTime());
			
					elapsedTimeLabelVal.setText(heatingData.calculateElapsedTime() );
				
					System.out.println("make it adding a row to the status window");
					statusPanel.addDatarow();
					statusPanel.setProbeStates();
				}
        	}
    	}
	};
	
	public void start() {
	
		samplingInterval = Preferences.samplingInterval;
	
		logger.info("sampling interval: " + samplingInterval);
		logger.info("starting the fetch data process");
	
		// Schedule the task such that it will be executed every second
		scheduledFuture =
    		scheduledExecutorService.scheduleAtFixedRate(r, 1, samplingInterval, TimeUnit.SECONDS);
    }
		
	// Cancel the task
	public void stop() {
	
		logger.info("stopping the fetch data process");
		scheduledFuture.cancel(false); // used to be false
	}
}