package heatflow_monitor;

import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.*;

//log4j
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.commons.lang3.exception.ExceptionUtils;

import javax.swing.JLabel;

/*
class FetchData {
	private final ScheduledExecutorService scheduler =
	 Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
        final Runnable beeper = new Runnable() {
                public void run() { System.out.println("beep"); }
            };
    	final ScheduledFuture<?> beeperHandle =
            scheduler.scheduleAtFixedRate(beeper, 10, 10, SECONDS);
        scheduler.schedule(new Runnable() {
                public void run() { beeperHandle.cancel(true); }
            }, 60 * 60, SECONDS);
    }
 }
*/

class FetchData {

	Data2 heatingData;
	StatusPanel2 statusPanel;
	JLabel elapsedTimeLabelVal;
	
	int samplingInterval = 10;
	
	// log4j
	static Logger logger = Logger.getLogger(Heatflow.class.getName());
	
	// Create the scheduler
	ScheduledExecutorService scheduledExecutorService;
	
	ScheduledFuture<?> scheduledFuture;

	public FetchData(Data2 heatingData, StatusPanel2 statusPanel, JLabel elapsedTimeLabelVal) {
		this.heatingData = heatingData;
		this.statusPanel = statusPanel;
		this.elapsedTimeLabelVal = elapsedTimeLabelVal;
		
		logger.info("creating new fetch data object");
		
		scheduledExecutorService = Executors.newScheduledThreadPool(1);
		
		// scheduledExecutorService.setRemoveOnCancelPolicy(true);
	}

	// Create the task to execute
	Runnable r = new Runnable() {
    	@Override
    	public void run() {
        	System.out.println("Fetching new data");
        	logger.info("fetching new data");
        	
        	heatingData.readDataLine();
        	heatingData.printDataLineToLog();
        	heatingData.calculateLastGradient();
        	
        	System.out.println("Is this causing a problem?");
        	heatingData.calculateElapsedTime();
        	
        	System.out.println("elapsed time: " + heatingData.calculateElapsedTime());
        	
			elapsedTimeLabelVal.setText(heatingData.calculateElapsedTime() );
        	statusPanel.addDatarow();
        	statusPanel.setProbeStates();	
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
    
	// Wait 5 seconds
	// Thread.sleep(5000L);
		
	// Cancel the task
	public void stop() {
		scheduledFuture.cancel(false); // used to be false
		
		// scheduledExecutorService.shutdown();
	}
}