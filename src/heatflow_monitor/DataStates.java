package heatflow_monitor;

import org.apache.log4j.Logger;

class DataStates {

	// log4j
static Logger logger = Logger.getLogger(Heatflow.class.getName() );

	static int probe1TempStatus = 0;
	static int probe2TempStatus = 0;
	static int probe3TempStatus = 0;
	static int probe4TempStatus = 0;
	static int baseTempStatus = 0;
	static int tiltStatus = 0;
	static int depthStatus = 0;
	static int batteryStatus = 0;
	static int fullGradientStatus = 0;
	static int upperGradientStatus = 0;
	static int middleGradientStatus = 0;
	static int lowerGradientStatus = 0;
	
	static int previousProbe1TempStatus = 0;
	static int previousProbe2TempStatus = 0;
	static int previousProbe3TempStatus = 0;
	static int previousProbe4TempStatus = 0;
	static int previousBaseTempStatus = 0;
	static int previousTiltStatus = 0;
	static int previousDepthStatus = 0;
	static int previousBatteryStatus = 0;
	static int previousFullGradientStatus = 0;
	static int previousUpperGradientStatus = 0;
	static int previousMiddleGradientStatus = 0;
	static int previousLowerGradientStatus = 0;

	public static int determineProbe1TempStatus(double probeTempValue) {
	
		logger.info("probe 1 temp status: " + probeTempValue);
		logger.info("probe 1 high limit: " + DataBounds.probeHighLimit);
		logger.info("probe 1 low limit: " + DataBounds.probeLowLimit);
	
		double temperatureDelta = 2.0;
		
		if (probeTempValue > DataBounds.probeHighLimit) {
			logger.info("temp 1 exceeded the high probe limit");
			probe1TempStatus = 2;
			return 0;
		}
		
		if (probeTempValue < DataBounds.probeLowLimit) {
			logger.info("temp 1 exceeded the low probe limit");
			probe1TempStatus = 2;
			return 0;
		}
		
		logger.info("probe temp 1 is within limits: " + probeTempValue);
		probe1TempStatus = 0;
		return 0;
	}
		
	public static int determineProbe2TempStatus(double probeTempValue) {
	
		logger.info("probe 2 temp status: " + probeTempValue);
		logger.info("probe 2 high limit: " + DataBounds.probeHighLimit);
		logger.info("probe 2 low limit: " + DataBounds.probeLowLimit);
	
		double temperatureDelta = 2.0;
		
		if (probeTempValue > DataBounds.probeHighLimit) {
			logger.info("temp 2 exceeded the high probe limit");
			probe2TempStatus = 2;
			return 0;
		}
		
		if (probeTempValue < DataBounds.probeLowLimit) {
			logger.info("temp 2 exceeded the low probe limit");
			probe2TempStatus = 2;
			return 0;
		}
		
		logger.info("probe temp 2 within limits: " + probeTempValue);
		probe2TempStatus = 0;
		return 0;
	}
	
	public static int determineProbe3TempStatus(double probeTempValue) {
	
		logger.info("probe 3 temp status: " + probeTempValue);
		logger.info("probe 3 high limit: " + DataBounds.probeHighLimit);
		logger.info("probe 3 low limit: " + DataBounds.probeLowLimit);
		
		double temperatureDelta = 2.0;
		
		if (probeTempValue > DataBounds.probeHighLimit) {
			logger.info("temp 3 exceeded the high probe limit");
			probe3TempStatus = 2;
			return 0;
		}
		
		if (probeTempValue < DataBounds.probeLowLimit) {
			logger.info("temp 3 exceeded the low probe limit");
			probe3TempStatus = 2;
			return 0;
		}
		
		logger.info("probe temp 3 within limits: " + probeTempValue);
		probe3TempStatus = 0;
		return 0;
	}
	
	public static int determineProbe4TempStatus(double probeTempValue) {
	
		logger.info("probe 4 temp status: " + probeTempValue);
		logger.info("probe 4 high limit: " + DataBounds.probeHighLimit);
		logger.info("probe 4 low limit: " + DataBounds.probeLowLimit);
		
		double temperatureDelta = 2.0;
		
		if (probeTempValue > DataBounds.probeHighLimit) {
			logger.info("temp 4 exceeded the high probe limit");
			probe4TempStatus = 2;
			return 0;
		}
		
		if (probeTempValue < DataBounds.probeLowLimit) {
			logger.info("temp 4 exceeded the low probe limit");
			probe4TempStatus = 2;
			return 0;
		}
		
		logger.info("probe temp 4 within limits: " + probeTempValue);
		probe4TempStatus = 0;
		return 0;
	}
	
	public static int determineBaseTempStatus(double probeTempValue) {
	
		logger.info("base temp status: " + probeTempValue);
		logger.info("base temp high limit: " + DataBounds.probeHighLimit);
		logger.info("base temp low limit: " + DataBounds.probeLowLimit);
		
		double temperatureDelta = 2.0;
		
		if (probeTempValue > DataBounds.probeHighLimit) {
			logger.info("temp base exceeded the high probe limit");
			baseTempStatus = 2;
			return 0;
		}
		
		if (probeTempValue < DataBounds.probeLowLimit) {
			logger.info("temp base exceeded the low probe limit");
			baseTempStatus = 2;
			return 0;
		}
		
		logger.info("base temp within limits: " + probeTempValue);
		baseTempStatus = 0;
		return 0;
	}
	
	public static int determineBatteryStatus(double batteryValue) {
	
		logger.info("battery status: " + batteryValue);
		logger.info("battery high limit: " + DataBounds.batteryHighLimit);
		logger.info("battery low limit: " + DataBounds.batteryLowLimit);
		
		double batteryDelta = 2.0;
		
		if (batteryValue > DataBounds.batteryHighLimit) {
			logger.info("battery exceeded the high probe limit");
			batteryStatus = 2;
			return 2;
		}
		
		if (batteryValue < DataBounds.batteryLowLimit) {
			logger.info("battery exceeded the low probe limit");
			batteryStatus = 2;
			return 2;
		}
		
		logger.info("battery within limits: " + batteryValue);
		batteryStatus = 0;
		return 0;
	}
	
	public static int determineTiltStatus(double tiltValue) {
	
		logger.info("tilt status: " + tiltValue);
		logger.info("tilt high limit: " + DataBounds.tiltHighLimit);
		logger.info("tilt low limit: " + DataBounds.tiltLowLimit);
		
		double tiltDelta = 2.0;
		
		if (tiltValue > DataBounds.tiltHighLimit) {
			logger.info("tilt exceeded the high tilt limit");
			tiltStatus = 2;
			return 0;
		}
		
		if (tiltValue < DataBounds.tiltLowLimit) {
			logger.info("tilt exceeded the low tilt limit");
			tiltStatus = 2;
			return 0;
		}
		
		logger.info("tilt within limits: " + tiltValue);
		tiltStatus = 0;
		return 0;
	}
	
	public static int determineDepthStatus(double depthValue) {
	
		logger.info("depth status: " + depthValue);
		logger.info("depth high limit: " + DataBounds.depthHighLimit);
		logger.info("depth low limit: " + DataBounds.depthLowLimit);
		
		double depthDelta = 2.0;
		
		if (depthValue > DataBounds.depthHighLimit) {
			logger.info("depth exceeded the high depth limit");
			depthStatus = 2;
			return 2;
		}
		
		if (depthValue < DataBounds.depthLowLimit) {
			logger.info("depth exceeded the low depth limit");
			depthStatus = 2;
			return 2;
		}
		
		logger.info("depth within limits: " + depthValue);
		depthStatus = 0;
		return 0;
	}
	
	public static int determineFullGradientStatus(double fullGradientValue) {
		return 0;
	}
	
	public static int determineUpperGradientStatus(double upperGradientValue) {
		return 0;
	}
	
	public static int determineMiddleGradientStatus(double middleGradientValue) {
		return 0;
	}
	
	public static int determineLowerGradientStatus(double lowerGradientValue) {
		return 0;
	}
	
	public static int getProbe1TempStatus() {
		return probe1TempStatus;
	}
	
	public static int getProbe2TempStatus() {
		return probe2TempStatus;
	}
	
	public static int getProbe3TempStatus() {
		return probe3TempStatus;
	}
	
	public static int getProbe4TempStatus() {
		return probe4TempStatus;
	}
	
	public static int getBaseTempStatus() {
		return baseTempStatus;
	}
	
	public static int getTiltStatus() {
		return tiltStatus;
	}
	
	public static int getDepthStatus() {
		return depthStatus;
	}
	
	public static int getBatteryStatus() {
		return batteryStatus;
	}

} 
