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
import org.apache.log4j.Logger;

public class Datum {

	// log4j
	static Logger logger = Logger.getLogger(Heatflow.class.getName() );
	
	int record;
	Date samplingTime = new Date();
	long elapsedTime = 0;
	double tilt = 0.0;
	double depth = 0.0;
	double baseTemp = 0.0;
	double battery = 0.0;
	double probe1Temp = 0.0;
	double probe2Temp = 0.0;
	double probe3Temp = 0.0;
	double probe4Temp = 0.0;
	
	double fullGradient = 0.0;
	double upperGradient = 0.0;
	double middleGradient = 0.0;
	double lowerGradient = 0.0;
	
	String rawLine = "";
	
	Datum() {
	}
	
	Datum(String rawLine) {
		this.rawLine = rawLine;
	}
	
	Datum(int record,
	 Date samplingTime,
	 double tilt,
	 double depth,
	 double baseTemp,
	 double battery,
	 double probe1Temp,
	 double probe2Temp,
	 double probe3Temp,
	 double probe4Temp) {
	 
		this.record = record;
		this.samplingTime = samplingTime;
		this.baseTemp = baseTemp;
		this.depth = depth;
		this.tilt = tilt;
		this.battery = battery;
		this.probe1Temp = probe1Temp;
		this.probe2Temp = probe2Temp;
		this.probe3Temp = probe3Temp;
		this.probe4Temp = probe4Temp;
	}
	
	void setRawLine(String rawLine) {
		this.rawLine = rawLine;
	}
	
	String getRawLine() {
		return rawLine;
	}
	
	void setRecord(int record) {
		this.record = record;
	}
	
	void setSamplingTime(Date samplingTime) {
		this.samplingTime = samplingTime;
	}
	
	void setTilt(double tilt) {
		this.tilt = tilt;
	}
	
	void setDepth(double depth) {
		this.depth = depth;
	}
	
	void setBaseTemp(double baseTemp) {
		this.baseTemp = baseTemp;
	}
	
	void setBattery(double battery) {
		this.battery = battery;
	}
	
	void setProbe1Temp(double probe1Temp) {
		this.probe1Temp = probe1Temp;
	}
	
	void setProbe2Temp(double probe2Temp) {
		this.probe2Temp = probe2Temp;
	}
	
	void setProbe3Temp(double probe3Temp) {
		this.probe3Temp = probe3Temp;
	}
	
	void setProbe4Temp(double probe4Temp) {
		this.probe4Temp = probe4Temp;
	}
	
	int getRecord() {
		return record;
	}
	
	Date getSamplingTime() {
		return samplingTime;
	}
	
	double getTilt() {
		return tilt;
	}
	
	double getBaseTemp() {
		return baseTemp;
	}
	
	double getBattery() {
		return battery;
	}
	
	double getDepth() {
		return depth;	
	}
	
	double getProbe1Temp() {
		return probe1Temp;
	}
	
	double getProbe2Temp() {
		return probe2Temp;
	}
	
	double getProbe3Temp() {
		return probe3Temp;
	}
	
	double getProbe4Temp() {
		return probe4Temp;
	}
        
    double getFullGradient() {
    	return fullGradient;
    }
	
	double getUpperGradient() {
		return upperGradient;
	}
	
	double getMiddleGradient() {
		return middleGradient;
	}
	
	double getLowerGradient() {
		return lowerGradient;
	}
	
	void setFullGradient(double fullGradient) {
		this.fullGradient = fullGradient;
	}
	
	void setUpperGradient(double upperGradient) {
		this.upperGradient = upperGradient;
	}
	
	void setMiddleGradient(double middleGradient) {
		this.middleGradient = middleGradient;
	}
	
	void setLowerGradient(double lowerGradient) {
		this.lowerGradient = lowerGradient;
	}
	
	long getElapsedTime() {
		return elapsedTime;
	}
	
	void setElapsedTime(int elapsedTime) {
		this.elapsedTime = elapsedTime;
	}
	
	// calculate temperature differentials
	double calculateFullTemp(double probe1Temp, double probe4Temp) {
	
		double fullTemp = probe4Temp - probe1Temp;
		return fullTemp;
	}
	
	/*
	double calculateUpperTemp(double probe1Temp, double probe2Temp) {
	
		double upperTemp = probe2Temp - probe1Temp;
		return upperTemp;
	}
	*/
	
	double calculateLowerTemp(double probe3Temp, double probe4Temp) {
	
		double lowerTemp = probe4Temp - probe3Temp;
		return lowerTemp;
	}
	
	double calculateMiddleTemp(double probe2Temp, double probe3Temp) {
		
		double middleTemp = probe3Temp - probe2Temp;
		return middleTemp;
	}
	
	double calculateUpperTemp(double probe1Temp, double probe2Temp) {
		
		double upperTemp = probe2Temp - probe1Temp;
		return upperTemp;
	}
	
	// calculate distance differentials
	double calculateFullDistance(double probe1Depth, double probe4Depth) {
	
		double fullDistance = probe4Depth - probe1Depth;
		return fullDistance;
	}
	
	double calculateLowerDistance(double probe1Depth, double probe2Depth) {
	
		double lowerDistance = probe2Depth - probe1Depth;
		return lowerDistance;
	}
	
	double calculateMiddleDistance(double probe2Depth, double probe3Depth) {
		
		double middleDistance = probe3Depth - probe2Depth;
		return middleDistance;
	}
	
	double calculateUpperDistance(double probe3Depth, double probe4Depth) {
		
		double upperDistance = probe4Depth - probe3Depth;
		return upperDistance;
	}
	
	// calculate temp gradients
	double calculateFullGradient(double fullTempDiff, double fullDistanceDiff) {
	
		double fullGradient = fullTempDiff / fullDistanceDiff;
		return fullGradient;
	}
	
	double calculateUpperGradient(double upperTempDiff, double upperDistanceDiff) {
	
		double upperGradient = upperTempDiff / upperDistanceDiff;
		return upperGradient;
	}
	
	double calculateMiddleGradient(double middleTempDiff, double middleDistanceDiff) {
		
		double middleGradient = middleTempDiff / middleDistanceDiff;
		return middleGradient;
	}
	
	double calculateLowerGradient(double lowerTempDiff, double lowerDistanceDiff) {
		
		double lowerGradient = lowerTempDiff / lowerDistanceDiff;
		return lowerGradient;
	}
	
	double calculateCompleteFullGradient() {
	
		double temperatureDifference = calculateFullTemp(probe1Temp, probe4Temp);
		double distanceDifference = 
		 calculateFullDistance(HeatProbeNames.getProbe1Depth(), HeatProbeNames.getProbe4Depth());
		 
		 logger.info("full temp diff: " + temperatureDifference);
		 logger.info("full distance diff: " + distanceDifference);
		 
		return (temperatureDifference / distanceDifference);
	}
	
	double calculateCompleteUpperGradient() {
	
		double temperatureDifference = calculateUpperTemp(probe1Temp, probe2Temp);
		double distanceDifference = 
		 calculateFullDistance(HeatProbeNames.getProbe1Depth(), HeatProbeNames.getProbe2Depth());
		 
		return (temperatureDifference / distanceDifference);
	}
	
	double calculateCompleteMiddleGradient() {
	
		double temperatureDifference = calculateMiddleTemp(probe2Temp, probe3Temp);
		double distanceDifference = 
		 calculateFullDistance(HeatProbeNames.getProbe2Depth(), HeatProbeNames.getProbe3Depth());
		 
		return (temperatureDifference / distanceDifference);
	}
	
	double calculateCompleteLowerGradient() {
	
		double temperatureDifference = calculateLowerTemp(probe3Temp, probe4Temp);
		double distanceDifference = 
		 calculateFullDistance(HeatProbeNames.getProbe3Depth(), HeatProbeNames.getProbe4Depth());
		 
		return (temperatureDifference / distanceDifference);
	}
	
	void calculateCompleteGradients() {
	
		this.fullGradient = calculateCompleteFullGradient();
		this.upperGradient = calculateCompleteUpperGradient();
		this.middleGradient = calculateCompleteMiddleGradient();
		this.lowerGradient = calculateCompleteLowerGradient();
		
		logger.info("full gradient: " + fullGradient);
		logger.info("upper gradient: " + upperGradient);
		logger.info("middle gradient: " + middleGradient);
		logger.info("lower gradient: " + lowerGradient);	
	}
}