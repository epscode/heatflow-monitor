package heatflow_monitor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;
import java.awt.image.BufferedImage;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.data.Range;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import static org.jfree.chart.renderer.xy.StandardXYItemRenderer.*;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.*;
import org.jfree.chart.axis.AxisSpace;
import org.jfree.ui.RectangleInsets;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.UIUtils;
import org.jfree.data.xy.XYDataset;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.renderer.AbstractRenderer.*;
import java.util.concurrent.TimeUnit;

import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.axis.AxisLocation;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;

import static org.jfree.chart.renderer.xy.StandardXYItemRenderer.*;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.axis.AxisLocation;

import org.jfree.chart.ChartFactory.*;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import org.jfree.chart.axis.AxisLabelLocation;
import org.jfree.chart.axis.Axis;

import java.text.SimpleDateFormat;
// import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;
import java.awt.image.BufferedImage;

import java.util.Vector;
import java.util.Date;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import java.util.Arrays;
import java.util.List;

import java.awt.*;
import java.awt.event.*;

import javax.swing.text.*;
import java.util.Hashtable;

import it.sauronsoftware.junique.AlreadyLockedException;
import it.sauronsoftware.junique.JUnique;

import javax.swing.*;

import java.io.*;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.text.*;
import java.util.Hashtable;

import javax.swing.border.*;

//log4j
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.commons.lang3.exception.ExceptionUtils;

import org.apache.log4j.PropertyConfigurator;

// create pdf
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.DocumentException;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.orsonpdf.PDFDocument;
import com.orsonpdf.PDFGraphics2D;
import com.orsonpdf.Page;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.plaf.basic.BasicMenuBarUI;

import java.util.Vector;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.property.AreaBreakType;

import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import java.awt.print.PrinterJob;
import java.io.File;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.apache.pdfbox.printing.PDFPrintable;

import java.awt.print.*;
 
public class Monitor extends JFrame implements WindowListener {

	// log4j
	static Logger logger = Logger.getLogger(Heatflow.class.getName());

	// Construct the frame
	public Monitor() {
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    // for the edit menu entries
    private JTextField dummyField = new JTextField();
    
    // the cut, copy, paste menu entries
    Hashtable actions;
    
    // the menubar
    JMenuBar jMenuBar;
    
    // the absolute file path of the program
    String absoluteBasePath = "";
    
    // The File Menu
	public JMenu jMenuFile;
	public JMenuItem jMenuFileNew;
	public JMenuItem jMenuFileOpen;
	public JMenuItem jMenuFileStart;
	public JMenuItem jMenuFileStop;
	public JMenuItem jMenuConfigLabels;
	public JMenuItem jMenuFileExport;
	public JMenuItem jMenuFileExportPlot;
	public JMenuItem jMenuFilePreferences;
	public JMenuItem jMenuFileDataBounds;
	public JMenuItem jMenuFilePrint;
	public JMenuItem jMenuFileExit;
	
	// The Edit Menu
	public JMenu jMenuEdit;
	
	// The View Menu
	JMenu jMenuView;
	JMenuItem jMenuViewTemperaturePlot;
	JMenuItem jMenuViewBaseTemperaturePlot;
	JMenuItem jMenuViewDepthPlot;
	JMenuItem jMenuViewBatteryPlot;
	JMenuItem jMenuViewTiltPlot;
	JMenuItem jMenuViewScrollEnable;
	
	// Control Menu
	JMenu jMenuControl;
	JMenuItem jMenuControlStart;
	
	// The Help Menu
	public JMenu jMenuHelp;
	public JMenuItem jMenuHelpManual;
	public JMenuItem jMenuHelpAbout;
	
	// data class 
	Data2 heatingData;
	
	// document for testing pdf creation
	Document document;
	
	// subplots of the main chart
	CombinedDomainXYPlot auxPlot;
	XYPlot temperaturePlot;
	XYPlot baseTempPlot;
	XYPlot depthPlot;
	XYPlot tiltPlot;
	XYPlot batteryPlot;
	
	// subplots of the main plot suitable for printing (size and color inversion)
	CombinedDomainXYPlot printingPlot;
	/*
	XYPlot temperaturePlotPrint;
	XYPlot baseTempPlotPrint;
	XYPlot depthPlotPrint;
	XYPlot tiltPlotPrint;
	XYPlot batteryPlotPrint;
	*/
	// the renderers for the plot traces for screen and for print
	XYItemRenderer temperatureRenderer;
	// XYItemRenderer temperatureRendererPrint;
	
	// charts for screen and for print
	ChartPanel auxChartPanel;
	ChartPanel printingPanel;
	
	// whether the plots are currently visible
	boolean temperaturePlotVisible = true;
    boolean baseTempPlotVisible = true;
    boolean depthPlotVisible = true;
    boolean tiltPlotVisible = true;
    boolean batteryPlotVisible = true;
    
    // checkboxes for whether the plot traces are visible
    JCheckBox probe1Checkbox;
    JCheckBox probe2Checkbox;
    JCheckBox probe3Checkbox;
    JCheckBox probe4Checkbox;
    
    // the probe traces for the probe data series
    XYSeries probe1Series;
	XYSeries probe2Series;
	XYSeries probe3Series;
	XYSeries probe4Series;
    
    // the file paths for the temp and help directories
	String tempPath = "";
	String helpPath = "";
	
	boolean acquisitionIsStarted = false;
	
	// the class to fetch data periodically from a file
	FetchData fetchData;
	
	// the data panel at the top of the screen
	StatusPanel2 statusPanel;
	
	// The two charts, screen chart and printing chart
	JFreeChart auxChart;
	JFreeChart printingChart;
	
	JLabel elapsedTimeLabelVal;
	
	// formatters for significant digit formatting
    String zeroDecimalPattern = "#";
	DecimalFormat zeroDecimalFormatter = new DecimalFormat(zeroDecimalPattern);
        
	String oneDecimalPattern = "0.0";
	DecimalFormat oneDecimalFormatter = new DecimalFormat(oneDecimalPattern);

	String twoDecimalPattern = "0.00";
	DecimalFormat twoDecimalFormatter = new DecimalFormat(twoDecimalPattern);

	String threeDecimalPattern = "0.000";
	DecimalFormat threeDecimalFormatter = new DecimalFormat(threeDecimalPattern);
	
	String sciNotationPattern = "0.000E0";
	DecimalFormat sciNotationaformatter = new DecimalFormat(sciNotationPattern);
	
	// double lowerBoundTempPlot = 0.0;
	// double upperBoundTempPlot = 0.0;
	
	NumberAxis recordsRange;
	
	MessagesPanel messagesPanel;

    private void init() {
    
    	//PropertiesConfigurator is used to configure logger from properties file
        // PropertyConfigurator.configure("log4j.xml");
        
        //DOMConfigurator is used to configure logger from xml configuration file
        DOMConfigurator.configure("log4j.xml");
 
        //Log in console in and log file
        logger.debug("Log4j appender configuration is successful!");
    
    	// File Paths
    	File baseFileObject = new File("");
		absoluteBasePath = baseFileObject.getAbsolutePath();
		logger.debug("absolute current working directory: " + absoluteBasePath);

		helpPath = absoluteBasePath + "/help/";
		tempPath = absoluteBasePath + "/temp/";
		
		// read the preferences file
		// Preferences preferences = new Preferences(tempPath);
		Preferences.readPreferencesFile(tempPath);
		
		// read data bounds file
		logger.info("trying to set the data bounds values");
		DataBounds.readBoundsFile(tempPath);
		
		// set the path for the heat probe file names
		HeatProbeNames.setFilepath(tempPath);
		
		// read the probes file
		HeatProbeNames.readProbeNamesFile(tempPath);
		
		elapsedTimeLabelVal = new JLabel("00:00:00");
		
    	// Get the screen size
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		
		messagesPanel = new MessagesPanel();
		
		
		// initializing the data class
		heatingData = new Data2(absoluteBasePath, messagesPanel);
		
		// initializing the panel that displays the data text
		statusPanel = new StatusPanel2(heatingData);

        // temperatures plot     
		temperatureRenderer = new StandardXYItemRenderer(); 
		NumberAxis temperatureRange = new NumberAxis("Probe Temps (C)");
		temperatureRange.setLabelPaint(Color.white);
    	temperatureRange.setTickLabelPaint(Color.white);
		temperaturePlot = new XYPlot(heatingData.generateTemperatureData(), null, 
		 temperatureRange, temperatureRenderer); 
		temperaturePlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
		temperatureRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
		temperatureRenderer.setBaseStroke(new BasicStroke(2.0f));
		((AbstractRenderer) temperatureRenderer).setAutoPopulateSeriesStroke(false);
		temperatureRange.setNumberFormatOverride(threeDecimalFormatter); // set decimal format
		temperatureRange.setAutoRangeIncludesZero(false);
		temperatureRenderer.setSeriesPaint(0, new Color(255, 255, 0)); 	// red
		temperatureRenderer.setSeriesPaint(1, new Color(255, 0 ,0)); 	// yellow
		temperatureRenderer.setSeriesPaint(2, new Color(0, 0, 255)); 	// blue
		temperatureRenderer.setSeriesPaint(3, new Color(0, 204, 0)); 	// green
		temperaturePlot.setBackgroundPaint(Color.black);
		
        // base temp plot
        NumberAxis baseTempRange = new NumberAxis("BW Temp (C)");
        baseTempRange.setLabelPaint(Color.white);
    	baseTempRange.setTickLabelPaint(Color.white);
        XYItemRenderer baseTempRenderer = new StandardXYItemRenderer(); 
        baseTempPlot = new XYPlot(heatingData.generateBaseTempData(), null, 
         baseTempRange, baseTempRenderer); 		
		baseTempRange.setNumberFormatOverride(threeDecimalFormatter); // set decimal format
		baseTempPlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
		baseTempRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
		baseTempRenderer.setBaseStroke(new BasicStroke(2.0f));
		((AbstractRenderer) baseTempRenderer).setAutoPopulateSeriesStroke(false);
		baseTempRange.setAutoRangeIncludesZero(false);
		baseTempRenderer.setSeriesPaint(0, Color.green);
		baseTempPlot.setBackgroundPaint(Color.black);
		
		// depth plot
		XYItemRenderer depthRenderer = new StandardXYItemRenderer(); 
		NumberAxis depthRange = new NumberAxis("Depth (m)");
		depthRange.setLabelPaint(Color.white);
    	depthRange.setTickLabelPaint(Color.white);
		depthPlot = new XYPlot(heatingData.generateDepthData(), null, 
		 depthRange, depthRenderer); 
		depthRange.setNumberFormatOverride(oneDecimalFormatter); // set decimal format
		depthPlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
		depthRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
		depthRenderer.setBaseStroke(new BasicStroke(2.0f));
		((AbstractRenderer) depthRenderer).setAutoPopulateSeriesStroke(false);
		depthRange.setAutoRangeIncludesZero(false);
		depthRenderer.setSeriesPaint(0, Color.PINK);
		depthPlot.setBackgroundPaint(Color.black);
		
		// tilt plot
		XYItemRenderer tiltRenderer = new StandardXYItemRenderer(); 
		NumberAxis tiltRange = new NumberAxis("Tilt (deg)");
		tiltRange.setLabelPaint(Color.white);
    	tiltRange.setTickLabelPaint(Color.white);
		tiltPlot = new XYPlot(heatingData.generateTiltData(), null, 
		 tiltRange, tiltRenderer); 
		tiltPlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT); 
		tiltRenderer.setSeriesPaint(0, new Color(51, 204, 255));
		tiltRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
		tiltRange.setNumberFormatOverride(twoDecimalFormatter); // set decimal format
		tiltRenderer.setBaseStroke(new BasicStroke(2.0f));
		((AbstractRenderer) tiltRenderer).setAutoPopulateSeriesStroke(false);
		tiltRange.setAutoRangeIncludesZero(false);
		tiltPlot.setBackgroundPaint(Color.black);
		
		// battery plot
		XYItemRenderer batteryRenderer = new StandardXYItemRenderer(); 
		NumberAxis batteryRange = new NumberAxis("Batt (V)");
		batteryRange.setLabelPaint(Color.white);
    	batteryRange.setTickLabelPaint(Color.white);
		batteryPlot = new XYPlot(heatingData.generateBatteryData(), null, 
		 batteryRange, batteryRenderer); 
		batteryRenderer.setSeriesPaint(0, new Color(255, 0, 0));
		batteryRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
		batteryRenderer.setBaseStroke(new BasicStroke(2.0f));
		((AbstractRenderer) batteryRenderer).setAutoPopulateSeriesStroke(false);
		batteryRange.setNumberFormatOverride(twoDecimalFormatter); // set decimal format	
		batteryPlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
		batteryRange.setAutoRangeIncludesZero(false);
		batteryPlot.setBackgroundPaint(Color.black);
				
		// combine the subplots into one chart
		recordsRange = new NumberAxis("Record");
		recordsRange.setNumberFormatOverride(zeroDecimalFormatter); // set decimal format
		recordsRange.setLabelPaint(Color.white);
    	recordsRange.setTickLabelPaint(Color.white);
    	
        auxPlot = new CombinedDomainXYPlot(recordsRange);
        auxPlot.setGap(10.0);
        auxPlot.add(temperaturePlot, 2);
        auxPlot.add(baseTempPlot, 1);
        auxPlot.add(depthPlot, 1);
        auxPlot.add(tiltPlot, 1);
        auxPlot.add(batteryPlot, 1);
        
		// standard file name 
		Date timeNow = new Date();
		String pattern = "yy-MM-dd.HH.mm.ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dateFilename = simpleDateFormat.format(timeNow);
		heatingData.setTempdatafilename("logfileUSBL" + dateFilename + ".txt");
		
		// calculate the temperature / relative depth gradients (deg / meter)
		heatingData.calculateGradients();
        
		// set the layout attributes for the screen plot
        auxPlot.setOrientation(PlotOrientation.VERTICAL);
                
        auxChart = new JFreeChart(
		null, JFreeChart.DEFAULT_TITLE_FONT, auxPlot, false);
		
		auxChart.setBackgroundPaint(Color.black);
		
		auxChartPanel = new ChartPanel(auxChart, false);	
		
		JPanel probeChooserPanel = new JPanel();
		probeChooserPanel.setLayout(new BoxLayout(probeChooserPanel, BoxLayout.PAGE_AXIS));
		// probeChooserPanel.setPreferredSize(new Dimension(100, 600));
		probeChooserPanel.setMinimumSize(new Dimension(100, 600));
		
		probe1Checkbox = new JCheckBox("Probe 1");
		probe2Checkbox = new JCheckBox("Probe 2");
		probe3Checkbox = new JCheckBox("Probe 3");
		probe4Checkbox = new JCheckBox("Probe 4");
		
		probe1Checkbox.setForeground(Color.white);
		probe2Checkbox.setForeground(Color.white);
		probe3Checkbox.setForeground(Color.white);
		probe4Checkbox.setForeground(Color.white);
		
		probe1Checkbox.setAlignmentX(Component.LEFT_ALIGNMENT);
		probe2Checkbox.setAlignmentX(Component.LEFT_ALIGNMENT);
		probe3Checkbox.setAlignmentX(Component.LEFT_ALIGNMENT);
		probe4Checkbox.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		// for the elapsed time
		JLabel elapsedTimeLabel = new JLabel("Time:");
		elapsedTimeLabel.setToolTipText("Elapsed time of measurements during this file");
		
		elapsedTimeLabel.setForeground(Color.white);
		elapsedTimeLabelVal.setForeground(Color.white);
		Font timeFont = new Font("SansSerif", Font.BOLD, 12);
		elapsedTimeLabel.setFont(timeFont);
		elapsedTimeLabelVal.setFont(timeFont);
		
		int top = 10; int left = 10; int bottom = 0; int right = 10;
		int vtop = 0; int vleft = 10; int vbottom = 25; int vright = 10;
		Border empty = BorderFactory.createEmptyBorder(top, left, bottom, right);
		Border emptyV = BorderFactory.createEmptyBorder(vtop, vleft, vbottom, vright);
		elapsedTimeLabel.setBorder(empty);
		elapsedTimeLabelVal.setBorder(empty);
		
		probeChooserPanel.add(elapsedTimeLabel);
		probeChooserPanel.add(elapsedTimeLabelVal);
		probeChooserPanel.add(probe1Checkbox);
        probeChooserPanel.add(probe2Checkbox);
        probeChooserPanel.add(probe3Checkbox);
        probeChooserPanel.add(probe4Checkbox);
		
		probe1Checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				probe1Checkbox_actionPerformed(e);
			}
		});
		
		probe2Checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				probe2Checkbox_actionPerformed(e);
			}
		});
		
		probe3Checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				probe3Checkbox_actionPerformed(e);
			}
		});
		
		probe4Checkbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				probe4Checkbox_actionPerformed(e);
			}
		});
		
        probe1Checkbox.setSelected(true);
        probe2Checkbox.setSelected(true);
        probe3Checkbox.setSelected(true);
        probe4Checkbox.setSelected(true);
        
		probeChooserPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		// rename Probe chooser
		// HeatProbeNames.readProbeNamesFile(tempPath);
		// changeProbeNames();
		// changeSeriesNames();
		
		this.add(messagesPanel, BorderLayout.PAGE_START);
		
		JPanel plotPanel = new JPanel();
		
		probeChooserPanel.setPreferredSize(new Dimension(100, 100));
		plotPanel.setLayout(new BorderLayout());
        plotPanel.add(auxChartPanel,BorderLayout.CENTER);
        plotPanel.add(probeChooserPanel,BorderLayout.LINE_START);

		probeChooserPanel.setBackground(Color.black);
		plotPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		// main panel
        //Create a split pane with the two scroll panes in it.
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
    	 statusPanel, plotPanel);
		
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(120);
		
		this.add(splitPane, BorderLayout.CENTER);
		
		// fetch data
		fetchData = new FetchData(heatingData, statusPanel, elapsedTimeLabelVal);
		
        logger.info("window width: " + this.getWidth() );
        logger.info("window height: " + this.getHeight() );
        
        this.setSize(new Dimension(1200, 800));
        
        logger.info("after running the heat probe name dialog box.");
		changeProbeNames();
		changeSeriesNames();
        
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE ); 
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (true) {
					System.exit(0);
				} else {
					System.out.println("not exiting");
				}
			}
		});
        
        jMenuBar = new JMenuBar();
        
        // The File Menu
		jMenuFile = new JMenu();
		jMenuFileNew = new JMenuItem();
		jMenuFileOpen = new JMenuItem();
		jMenuFilePreferences = new JMenuItem();
		jMenuFileDataBounds = new JMenuItem();
		jMenuConfigLabels = new JMenuItem();
		jMenuFileExport = new JMenuItem();
		jMenuFileExportPlot = new JMenuItem();
		jMenuFilePrint = new JMenuItem();
		jMenuFileExit = new JMenuItem();
		
		// The Edit menu
		createActionTable(dummyField);
		jMenuEdit = createEditMenu();
		
		jMenuView = new JMenu();
		jMenuViewTemperaturePlot = new JMenuItem();
		jMenuViewBaseTemperaturePlot = new JMenuItem();
		jMenuViewDepthPlot = new JMenuItem();
		jMenuViewBatteryPlot = new JMenuItem();
		jMenuViewTiltPlot = new JMenuItem();
		jMenuViewScrollEnable = new JMenuItem();
		
		jMenuControl = new JMenu();
		jMenuControlStart = new JMenuItem();
		
		// The Help Menu
		jMenuHelp = new JMenu();
		jMenuHelpAbout = new JMenuItem();
		jMenuHelpManual = new JMenuItem();
		
		// start a new file
		jMenuFileNew.setText("New...");
		jMenuFileNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuFileNew_actionPerformed(e);
			}
		});
		
		// open the file
		jMenuFileOpen.setText("Open...");
		jMenuFileOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuFileOpen_actionPerformed(e);
			}
		});
		
		// set the range of data outside of which we flag errors
		jMenuFileDataBounds.setText("Set Data Alarms...");
		jMenuFileDataBounds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuFileDataBounds_actionPerformed(e);
			}
		});
		
		// configure the probe names
		jMenuConfigLabels.setText("Configure Probe Names...");
		jMenuConfigLabels.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuConfigLabels_actionPerformed(e);
			}
		});
		
		// print the plot
		jMenuFilePrint.setText("Print...");
		jMenuFilePrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuFilePrint_actionPerformed(e);
			}
		});
		
		// Export data file 
		jMenuFileExport.setText("Export Data As...");
		jMenuFileExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuFileExport_actionPerformed(e);
			}
		});
		
		// Export plot file 
		jMenuFileExportPlot.setText("Export PDF Plot As...");
		jMenuFileExportPlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuFileExportPlot_actionPerformed(e);
			}
		});
		
		/*
		// File preferences
		jMenuFilePreferences.setText("File Preferences...");
		jMenuFilePreferences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuFilePreferences_actionPerformed(e);
			}
		});
		*/
		
		// exit the program
		jMenuFileExit.setText("Exit");
		jMenuFileExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuFileExit_actionPerformed(e);
			}
		});
		
		// show and hide temperature plot
		jMenuViewTemperaturePlot.setText("Hide Temperature Plot");
		jMenuViewTemperaturePlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuViewTemperaturePlot_actionPerformed(e);
			}
		});
		
		// show and hide BW temperature plot
		jMenuViewBaseTemperaturePlot.setText("Hide BW Temperature Plot");
		jMenuViewBaseTemperaturePlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuViewBaseTemperaturePlot_actionPerformed(e);
			}
		});
		
		// show and hide depth plot
		jMenuViewDepthPlot.setText("Hide Depth Plot");
		jMenuViewDepthPlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuViewDepthPlot_actionPerformed(e);
			}
		});
		
		// show and hide the battery plot
		jMenuViewBatteryPlot.setText("Hide Battery Plot");
		jMenuViewBatteryPlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuViewBatteryPlot_actionPerformed(e);
			}
		});
		
		// show and hide the tilt plot
		jMenuViewTiltPlot.setText("Hide Tilt Plot");
		jMenuViewTiltPlot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuViewTiltPlot_actionPerformed(e);
			}
		});
		
		// stop the data table from scrolling when new data come in
		jMenuViewScrollEnable.setText("Disable Table Scrolling");
		jMenuViewScrollEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuViewScrollEnable_actionPerformed(e);
			}
		});
		
		// start or stop the acquisition process
		jMenuControlStart.setText("Start Acquisition");
		jMenuControlStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuControlStart_actionPerformed(e);
			}
		});
		
		// information about the program
		jMenuHelpAbout.setText("About");
		jMenuHelpAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuHelpAbout_actionPerformed(e);
			}
		});
		
		// Show manual
		jMenuHelpManual.setText("User Guide...");
		jMenuHelpManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuHelpManual_actionPerformed(e);
			}
		});
		
		// sets the text for the top-line menu items
		jMenuFile.setText("File");
		jMenuView.setText("View");
		jMenuControl.setText("Control");
		jMenuHelp.setText("Help");
		
		// add items to the file menu
		jMenuFile.add(jMenuFileNew);
		jMenuFile.add(jMenuFileOpen);
		jMenuFile.addSeparator();;
		jMenuFile.add(jMenuFileDataBounds);
		jMenuFile.add(jMenuConfigLabels);
		jMenuFile.addSeparator();
		jMenuFile.add(jMenuFileExportPlot);
		jMenuFile.add(jMenuFilePrint);
		jMenuFile.addSeparator();
		jMenuFile.add(jMenuFileExit);
		
		// add items to the view menu
		jMenuView.add(jMenuViewTemperaturePlot);
		jMenuView.add(jMenuViewBaseTemperaturePlot);
		jMenuView.add(jMenuViewDepthPlot);
		jMenuView.add(jMenuViewTiltPlot);
		jMenuView.add(jMenuViewBatteryPlot);
		jMenuView.addSeparator();
		jMenuView.add(jMenuViewScrollEnable);
		
		// add items to the control menu
		jMenuControl.add(jMenuControlStart);
		
		// add items to the help menu
		jMenuHelp.add(jMenuHelpAbout);
		jMenuHelp.addSeparator();
		jMenuHelp.add(jMenuHelpManual);
		
		// Adds the file menu to the menu bar
		jMenuBar.add(jMenuFile);
		
		// Adds the edit menu to the menu bar
		jMenuBar.add(jMenuEdit);
		
		// adds the view menu to the menu bar
		jMenuBar.add(jMenuView);
		
		// adds the control menu to the menu bar
		jMenuBar.add(jMenuControl);
		
		// adds the help menu to the menu bar
		jMenuBar.add(jMenuHelp);
		
		// Add the menu bar
		this.setJMenuBar(jMenuBar);
		
		// set the title to the program
		this.setTitle("Heatflow Monitor");
		
		// adds a hook so that when the program opens, the 'save' dialog box will
		// pop up
		this.addWindowListener(this);
		
		// set the acquisition menu entry to disabled
		jMenuControlStart.setEnabled(false);
    }
    
    void plottingDisplay() {
    
    	// temperatures plot     
		XYItemRenderer temperatureRendererPrint = new StandardXYItemRenderer(); 
		NumberAxis temperatureRange = new NumberAxis("Probe Temps (C)");
		temperatureRange.setLabelPaint(Color.white);
    	temperatureRange.setTickLabelPaint(Color.white);
		XYPlot temperaturePlot = new XYPlot(heatingData.generateTemperatureData(), null, 
		 temperatureRange, temperatureRenderer); 
		temperaturePlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
		temperatureRendererPrint.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
		temperatureRendererPrint.setBaseStroke(new BasicStroke(2.0f));
		((AbstractRenderer) temperatureRenderer).setAutoPopulateSeriesStroke(false);
		temperatureRange.setNumberFormatOverride(threeDecimalFormatter); // set decimal format
		temperatureRange.setAutoRangeIncludesZero(false);
		temperatureRenderer.setSeriesPaint(0, new Color(255, 255, 0)); 	// red
		temperatureRenderer.setSeriesPaint(1, new Color(255, 0 ,0)); 	// yellow
		temperatureRenderer.setSeriesPaint(2, new Color(0, 0, 255)); 	// blue
		temperatureRenderer.setSeriesPaint(3, new Color(0, 204, 0)); 	// green
		temperaturePlot.setBackgroundPaint(Color.black);
		
        // base temp plot
        NumberAxis baseTempRange = new NumberAxis("BW Temp (C)");
        baseTempRange.setLabelPaint(Color.white);
    	baseTempRange.setTickLabelPaint(Color.white);
        XYItemRenderer baseTempRenderer = new StandardXYItemRenderer(); 
        baseTempPlot = new XYPlot(heatingData.generateBaseTempData(), null, 
         baseTempRange, baseTempRenderer); 		
		baseTempRange.setNumberFormatOverride(threeDecimalFormatter); // set decimal format
		baseTempPlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
		baseTempRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
		baseTempRenderer.setBaseStroke(new BasicStroke(2.0f));
		((AbstractRenderer) baseTempRenderer).setAutoPopulateSeriesStroke(false);
		baseTempRange.setAutoRangeIncludesZero(false);
		baseTempRenderer.setSeriesPaint(0, Color.green);
		baseTempPlot.setBackgroundPaint(Color.black);
		
		// depth plot
		XYItemRenderer depthRenderer = new StandardXYItemRenderer(); 
		NumberAxis depthRange = new NumberAxis("Depth (m)");
		depthRange.setLabelPaint(Color.white);
    	depthRange.setTickLabelPaint(Color.white);
		XYPlot depthPlot = new XYPlot(heatingData.generateDepthData(), null, 
		 depthRange, depthRenderer); 
		depthRange.setNumberFormatOverride(oneDecimalFormatter); // set decimal format
		depthPlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
		depthRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
		depthRenderer.setBaseStroke(new BasicStroke(2.0f));
		((AbstractRenderer) depthRenderer).setAutoPopulateSeriesStroke(false);
		depthRange.setAutoRangeIncludesZero(false);
		depthRenderer.setSeriesPaint(0, Color.PINK);
		depthPlot.setBackgroundPaint(Color.black);
		
		// tilt plot
		XYItemRenderer tiltRenderer = new StandardXYItemRenderer(); 
		NumberAxis tiltRange = new NumberAxis("Tilt (deg)");
		tiltRange.setLabelPaint(Color.white);
    	tiltRange.setTickLabelPaint(Color.white);
		XYPlot tiltPlot = new XYPlot(heatingData.generateTiltData(), null, 
		 tiltRange, tiltRenderer); 
		tiltPlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT); 
		tiltRenderer.setSeriesPaint(0, new Color(51, 204, 255));
		tiltRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
		tiltRange.setNumberFormatOverride(twoDecimalFormatter); // set decimal format
		tiltRenderer.setBaseStroke(new BasicStroke(2.0f));
		((AbstractRenderer) tiltRenderer).setAutoPopulateSeriesStroke(false);
		tiltRange.setAutoRangeIncludesZero(false);
		tiltPlot.setBackgroundPaint(Color.black);
		
		// battery plot
		XYItemRenderer batteryRenderer = new StandardXYItemRenderer(); 
		NumberAxis batteryRange = new NumberAxis("Batt (V)");
		batteryRange.setLabelPaint(Color.white);
    	batteryRange.setTickLabelPaint(Color.white);
		XYPlot batteryPlot = new XYPlot(heatingData.generateBatteryData(), null, 
		 batteryRange, batteryRenderer); 
		batteryRenderer.setSeriesPaint(0, new Color(255, 0, 0));
		batteryRenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
		batteryRenderer.setBaseStroke(new BasicStroke(2.0f));
		((AbstractRenderer) batteryRenderer).setAutoPopulateSeriesStroke(false);
		batteryRange.setNumberFormatOverride(twoDecimalFormatter); // set decimal format	
		batteryPlot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
		batteryRange.setAutoRangeIncludesZero(false);
		batteryPlot.setBackgroundPaint(Color.black);
				
		// combine the subplots into one chart
		NumberAxis recordsRangePrint = new NumberAxis("Record");
		recordsRangePrint.setNumberFormatOverride(zeroDecimalFormatter); // set decimal format
		recordsRangePrint.setLabelPaint(Color.white);
    	recordsRangePrint.setTickLabelPaint(Color.white);
    	
    	double lowerBoundTempPlot = recordsRange.getLowerBound();
		double upperBoundTempPlot = recordsRange.getUpperBound();
			
		logger.info("lowerbound print:" + lowerBoundTempPlot);
    	logger.info("upperbound print:" + upperBoundTempPlot);
    		
    	recordsRangePrint.setRange(new Range(lowerBoundTempPlot, upperBoundTempPlot));
    	
        CombinedDomainXYPlot printingPlot = new CombinedDomainXYPlot(recordsRange);
        printingPlot.setGap(10.0);
        printingPlot.add(temperaturePlot, 2);
        printingPlot.add(baseTempPlot, 1);
        printingPlot.add(depthPlot, 1);
        printingPlot.add(tiltPlot, 1);
        printingPlot.add(batteryPlot, 1);
    }
    
    // Create the edit menu.
	protected JMenu createEditMenu() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		final int MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();
        
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);

        JMenuItem menuItem = new JMenuItem(new DefaultEditorKit.CutAction() );
        menuItem.setText("Cut");
        menuItem.setMnemonic(KeyEvent.VK_X);
        
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_X,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask() ) );
         
        editMenu.add(menuItem);

        menuItem = new JMenuItem(new DefaultEditorKit.CopyAction() );
        menuItem.setText("Copy");
        menuItem.setMnemonic(KeyEvent.VK_C);
        
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_C,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask() ) );
        
        editMenu.add(menuItem);

        menuItem = new JMenuItem(new DefaultEditorKit.PasteAction() );
        menuItem.setText("Paste");
        menuItem.setMnemonic(KeyEvent.VK_V);
        
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_V,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask() ) );
        
        editMenu.add(menuItem);
		
		return editMenu;
	}
	
	private void createActionTable(JTextComponent textComponent) {
		logger.debug("what does this actiontable do");
		actions = new Hashtable();
		Action[] actionsArray = textComponent.getActions();
		for (int i = 0; i < actionsArray.length; i++) {
			Action a = actionsArray[i];
			actions.put(a.getValue(Action.NAME), a);
		}
	}
	
	public String getBaseFilePath() {
		return absoluteBasePath;
	}
	
	// checkboxes for showing and hiding temperature traces in the main temperature plot
	void probe1Checkbox_actionPerformed(ActionEvent e) {
		logger.info("probe 1 checkbox clicked");
		System.out.println("probe 1 checkbox clicked");
		
        temperatureRenderer.setSeriesVisible(0, !temperatureRenderer.isSeriesVisible(0), true);
	}
	
	void probe2Checkbox_actionPerformed(ActionEvent e) {
		logger.info("probe 2 checkbox clicked");
		System.out.println("probe 2 checkbox clicked");
		
		temperatureRenderer.setSeriesVisible(1, !temperatureRenderer.isSeriesVisible(1), true);
	}
	
	void probe3Checkbox_actionPerformed(ActionEvent e) {
		logger.info("probe 3 checkbox clicked");
		System.out.println("probe 3 checkbox clicked");
		
		temperatureRenderer.setSeriesVisible(2, !temperatureRenderer.isSeriesVisible(2), true);
	}
	
	void probe4Checkbox_actionPerformed(ActionEvent e) {
		logger.info("probe 4 checkbox clicked");
		System.out.println("probe 4 checkbox clicked");
		
		temperatureRenderer.setSeriesVisible(3, !temperatureRenderer.isSeriesVisible(3), true);
	}
	
	// New file menu entry 
	void jMenuFileNew_actionPerformed(ActionEvent e) {
		logger.info("new file selected");
		
		heatingData.clearAllData();
		statusPanel.clearData();
		// heatingData.zeroWritingDatafile(); // try this next test
		
		heatingData.zeroLinesAlreadyRead();
		
		// stop acquisition if already started
		if (acquisitionIsStarted) {
		
			jMenuControlStart.setText("Start Acquisition");
			this.setTitle("Heatflow Monitor - Acquisition Stopped");
			acquisitionIsStarted = false;
			
			fetchData.stop();
		}
		
		logger.info("set the data filename");
		getFilenameForDataSaving(Preferences.getDataFilename());
	}
	
	// open file menu entry
	void jMenuFileOpen_actionPerformed(ActionEvent e) {
		logger.info("open file");
		
		if (getFilenameForOpening() ) {
			
			logger.info("opening a new file.");
		}
	}

	// export data menu entry - not used
	void jMenuFileExport_actionPerformed(ActionEvent e) {
		logger.info("export data function");
		
		getFilenameForDataSaving("");
	}
	
	// export plot menu entry
	void jMenuFileExportPlot_actionPerformed(ActionEvent e) {
		logger.info("export plot function");
		
		getFilenameForPlotSaving();
	}
	
	// data bounds menu entry
	void jMenuFileDataBounds_actionPerformed(ActionEvent e) {
	
		DataBoundsDialog dataBoundsDialog = 
		 new DataBoundsDialog(this, tempPath);
		 
		statusPanel.updateTable();
	}
	
	// temperature probe labels menu entry
	void jMenuConfigLabels_actionPerformed(ActionEvent e) {
		logger.info("config plot label names");
		
		HeatProbeNamesDialog heatProbeNamesDialog = 
		 new HeatProbeNamesDialog(this, tempPath);
		 
		 logger.info("after running the heat probe name dialog box.");
		 changeProbeNames();
		 changeSeriesNames();
	}
	
	// print plots menu entry
	void jMenuFilePrint_actionPerformed(ActionEvent e) {
		logger.info("print a snapshot of the data collected");
		
		try {
		
			savePlot(tempPath + "tempPdf.pdf");
			logger.info("made it past saved plot");
		
			PDDocument snapshot = PDDocument.load(new File(tempPath + "tempPdf.pdf"));
			logger.info("made it to loading plot");
			
			plottingDisplay();
		
			PrintService myPrintService = findPrintService("Printer Name");
			
			// Scaling.SHRINK_TO_FIT
			PDFPrintable printable = new PDFPrintable(snapshot);
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPrintable(printable);
			// job.print();
		
			boolean ok = job.printDialog();
			if (ok) {
		
				try {
			
					job.print();
				} catch (PrinterException error) {
			
					// The job did not successfully complete
					logger.info("did not print successfully:\n" + error);
					
					JOptionPane.showMessageDialog(null, "Couldn't print " + 
			 		 "\nException: " + error, "Printing Error",
			 		 JOptionPane.ERROR_MESSAGE);
				}
			}
			
        } catch (IOException error) {
        
			logger.info("saving temporary printer file didn't work:\n" + error);
			
			JOptionPane.showMessageDialog(null, "File error printing temporary pdf file " + 
			 tempPath + "tempPdf.pdf" + "\nException: " + error, "File Error",
			 JOptionPane.ERROR_MESSAGE);
		} 
    }
    
    // preference menu entry 
    /*
    void jMenuFilePreferences_actionPerformed(ActionEvent e) {
	
		PreferencesDialog preferencesDialog = 
		  new PreferencesDialog(this, tempPath);
	}
	*/
    
    // File | Exit action performed
	public void jMenuFileExit_actionPerformed(ActionEvent event) {
		
		if (true ) {
			System.exit(0);
		}
	}
    
    // Show and hide temperature plot menu entry
	void jMenuViewTemperaturePlot_actionPerformed(ActionEvent e) {
		logger.info("temperature plot");
		
		temperaturePlotVisible = !temperaturePlotVisible;
		determinePlotVisibility();
	}
	
	// Show and hide BW temperature plot menu entry
	void jMenuViewBaseTemperaturePlot_actionPerformed(ActionEvent e) {
		logger.info("base temperature plot");
		
		baseTempPlotVisible = !baseTempPlotVisible;
		determinePlotVisibility();
	}
	
	// Show and hide the depth plot menu entry
	void jMenuViewDepthPlot_actionPerformed(ActionEvent e) {
		logger.info("depth plot");
		
		depthPlotVisible = !depthPlotVisible;
		determinePlotVisibility();
	}
	
	// Show and hide the battery plot menu entry
	void jMenuViewBatteryPlot_actionPerformed(ActionEvent e) {
		logger.info("battery plot");
		
		batteryPlotVisible = !batteryPlotVisible;
		determinePlotVisibility();
	}
	
	// Show and hide the tilt plot menu entry
	void jMenuViewTiltPlot_actionPerformed(ActionEvent e) {
		logger.info("tilt plot");
		
		tiltPlotVisible = !tiltPlotVisible;
		determinePlotVisibility();
	}
	
	// Show and hide the enable / disable the scroll menu entry
	void jMenuViewScrollEnable_actionPerformed(ActionEvent e) {
    
    	jMenuViewScrollEnable.setText("Disable Table Scrolling");
    	
    	logger.info("table scrollbar control");
    	
    	if (statusPanel.getScrollTableEnable() ) {
    	
    		logger.info("table scrollbar disabled");
    	
    		jMenuViewScrollEnable.setText("Enable Table Scrolling");
    		statusPanel.setScrollTableEnable(false);
    	} else {
    	
    		logger.info("table scrollbar enabled");
    	
    		jMenuViewScrollEnable.setText("Disable Table Scrolling");
    		statusPanel.setScrollTableEnable(true);
    	}
    }
	
	// Show and hide the start and stop the acquisition menu entry
	void jMenuControlStart_actionPerformed(ActionEvent e) {
		logger.info("start acquisition");
		
		if (acquisitionIsStarted) {
		
			jMenuControlStart.setText("Start Acquisition");
			this.setTitle("Heatflow Monitor - Acquisition Stopped");
			logger.info("Heatflow Monitor - Acquisition Stopped");
			acquisitionIsStarted = false;
			
			fetchData.stop();
		} else {
		
			jMenuControlStart.setText("Stop Acquisition");
			this.setTitle("Heatflow Monitor - Acquisition Started");
			logger.info("Heatflow Monitor - Acquisition Started");
			acquisitionIsStarted = true;
			
			// fetch data
			// fetchData = new FetchData(heatingData, statusPanel);
			
			fetchData.start();
		}
	}
	
	// File | About action performed
	public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
		logger.debug("should be showing the about box.");
		About_Box dlg = new About_Box(this);
		Dimension dlgSize = dlg.getPreferredSize();
		Dimension frmSize = getSize();
		Point loc = getLocation();
		dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, 
		 (frmSize.height - dlgSize.height) / 2 + loc.y);
		dlg.setModal(true);
		dlg.pack();
		dlg.show();
	}
	
	/*
	// Show and hide the manual menu entry
	void jMenuHelpManualDisplay_actionPerformed(ActionEvent e) {
		logger.info("showing user manual - display");
		
		SimpleSwingBrowser displayBrowser = new SimpleSwingBrowser();
    	displayBrowser.setVisible(true);
        displayBrowser.loadURL("file://" + helpPath + "display_manual.html");
	}
	
	void jMenuHelpManualTheory_actionPerformed(ActionEvent e) {
		logger.info("showing user manual - theory of operation");
		
		SimpleSwingBrowser theoryBrowser = new SimpleSwingBrowser();
    	theoryBrowser.setVisible(true);
        theoryBrowser.loadURL("file://" + helpPath + "theory_manual.html");
	}
	*/
	
	void jMenuHelpManual_actionPerformed(ActionEvent e) {
		logger.info("showing user manual");
		
		SimpleSwingBrowser browser = new SimpleSwingBrowser();
    	browser.setVisible(true);
        browser.loadURL("file://" + helpPath + "manual.html");
	}
	
	// determine if the plots are visible and add if they aren't
	void determinePlotVisibility() {
	
		// Removing all the plots
		for (int index = auxPlot.getSubplots().size() - 1; index >= 0; index-- ) {
    		auxPlot.remove((XYPlot)auxPlot.getSubplots().get(index));
		}
	
		if (temperaturePlotVisible) {
			auxPlot.add(temperaturePlot, 2);
			jMenuViewTemperaturePlot.setText("Hide Temperature Plot");
		} else {
			jMenuViewTemperaturePlot.setText("Show Temperature Plot");
		}
		
		if (baseTempPlotVisible) {
			auxPlot.add(baseTempPlot, 1);
			jMenuViewBaseTemperaturePlot.setText("Hide Base Temperature Plot");	
		} else {
			jMenuViewBaseTemperaturePlot.setText("Show Base Temperature Plot");
		}
		
		if (depthPlotVisible) {
			auxPlot.add(depthPlot, 1);
			jMenuViewDepthPlot.setText("Hide Depth Plot");	
		} else {
			jMenuViewDepthPlot.setText("Show Depth Plot");
		}
		
		if (tiltPlotVisible) {
			auxPlot.add(tiltPlot, 1);
			jMenuViewTiltPlot.setText("Hide Tilt Plot");	
		} else {
			jMenuViewTiltPlot.setText("Show Tilt Plot");
		}
		
		if (batteryPlotVisible) {
			auxPlot.add(batteryPlot, 1);
			jMenuViewBatteryPlot.setText("Hide Battery Plot");	
		} else {
			jMenuViewBatteryPlot.setText("Show Battery Plot");
		}	
	}
	
	// get the data filename
	public boolean getFilenameForDataSaving(String datafilename) {

		String filename = "";
		String extension = "txt";
		File datafileDirectory = new File(Preferences.dataFilePath);
		SafeJFileChooser safeFileDialog = new SafeJFileChooser(datafileDirectory, "txt");
		int returnVal = safeFileDialog.showSaveDialog(this);
		
		String parentPath;

		if (returnVal == SafeJFileChooser.APPROVE_OPTION) {
		
			File file = safeFileDialog.getSelectedFile();

			if (!file.getName().endsWith(extension)) {
			
				logger.debug("saving: " + file.getName() + "." + extension);
				logger.debug("directory: " + file.getAbsolutePath() + "." + extension);
				filename = file.getAbsolutePath() + "." + extension;
				parentPath = file.getAbsoluteFile().getParent();
				logger.info("parent path: " + parentPath);
			} else {
			
				logger.debug("saving: " + file.getName());
				logger.debug("directory: " + file.getAbsolutePath());
				filename = file.getAbsolutePath();
				parentPath = file.getAbsoluteFile().getParent();
				logger.info("parent path: " + parentPath);
			}
			
			this.setTitle("Heatflow Monitor - " + filename);
			logger.debug("filename from saving dialog: " + filename);
			
			Preferences.dataFilename = filename;
			Preferences.dataFilePath = parentPath;
			Preferences.writePreferencesFile(tempPath);
			
			heatingData.clearAllData();
			statusPanel.clearData();
			heatingData.zeroWritingDatafile(); // try this next test
		
			heatingData.zeroLinesAlreadyRead();
			
			jMenuControlStart.setEnabled(true);

			return true;
		}

		logger.debug("Save as command canceled by user.");
		Preferences.dataFilename = "";
		
		// safeFileDialog = new SafeJFileChooser(extension);
		// returnVal = safeFileDialog.showSaveDialog(this);
		
		return false;
	}
	
	// pop up the file save dialog box when the program opens
	/*
	public void windowOpened(WindowEvent e) {
        logger.debug("WindowListener method called: windowOpened.");
        
        /*
        // delay until main window pops up. 
        // read data bounds file
		logger.info("trying to set the data bounds values");
		DataBounds.readBoundsFile(tempPath);
		
		// set the path for the heat probe file names
		HeatProbeNames.setFilepath(tempPath);
		
		// read the probes file
		HeatProbeNames.readProbeNamesFile(tempPath);
    	
    
		do {
			logger.info("set the data filename");
			getFilenameForDataSaving(Preferences.getDataFilename());
		} while (Preferences.getDataFilename().compareTo("") == 0); 
		
	}
	*/
	
	// required for overriding window operations - required but not used
	
	@Override
	public void windowOpened(WindowEvent e) {
		logger.info(e.toString());
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		logger.info(e.toString());
	}

	@Override
	public void windowClosed(WindowEvent e) {
		logger.info(e.toString());
	}

	@Override
	public void windowIconified(WindowEvent e) {
		logger.info(e.toString());
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		logger.info(e.toString());
	}

	@Override
	public void windowActivated(WindowEvent e) {
		logger.info(e.toString());
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		logger.info(e.toString());
	}
	
	// get filename for the saving the plots
	public boolean getFilenameForPlotSaving() {

		String filename = "";
		String extension = "pdf";
		File parentPath = new File(Preferences.dataFilePath);
		SafeJFileChooser safeFileDialog = new SafeJFileChooser(parentPath, extension);
		int returnVal = safeFileDialog.showSaveDialog(this);

		if (returnVal == SafeJFileChooser.APPROVE_OPTION) {
			File file = safeFileDialog.getSelectedFile();

			if (!file.getName().endsWith(extension)) {
			
				logger.debug("saving: " + file.getName() + "." + extension);
				logger.debug("directory: " + file.getAbsolutePath() + "." + extension);
				filename = file.getAbsolutePath() + "." + extension;
			} else {
			
				logger.debug("saving: " + file.getName());
				logger.debug("directory: " + file.getAbsolutePath());
				filename = file.getAbsolutePath();
			}
			
			logger.debug("filename from saving dialog: " + filename);
			
			savePlot(filename);

			return true;
		}

		logger.debug("Save as command canceled by user.");
		return false;
	}
	
	public boolean getFilenameForOpening() {
	
		String filename = "";
		String extension = "txt";
		File parentPath = new File(Preferences.dataFilePath);
		SafeJFileChooser safeFileDialog = new SafeJFileChooser(parentPath, extension);
		int returnVal = safeFileDialog.showOpenDialog(this);

		if (returnVal == SafeJFileChooser.APPROVE_OPTION) {
			File file = safeFileDialog.getSelectedFile();
			logger.debug("opening: " + file.getName());
			logger.debug("directory: " + file.getAbsolutePath());
			filename = file.getAbsolutePath();
			
			// open the file
			logger.info("data filename: " + filename);
			
			// clear old data 
			heatingData.clearAllData();
			statusPanel.clearData();
			heatingData.zeroLinesAlreadyRead();
			
			heatingData.readDatafile(filename, true);
			heatingData.calculateGradients();
			
			changeProbeNames();
		 	changeSeriesNames();
		 	
		 	this.setTitle("Heatflow Monitor - " + filename);
			
		 	for (int recordNumber = 0; recordNumber < heatingData.getHeatflowSize(); recordNumber++) {
        		statusPanel.addDatarow();
        		statusPanel.setProbeStates();
        	}
        	
        	if (acquisitionIsStarted) {
		
				jMenuControlStart.setText("Start Acquisition");
				this.setTitle("Heatflow Monitor - Acquisition Stopped");
				acquisitionIsStarted = false;
			
				fetchData.stop();
			}
			
			return true;
		}

		logger.debug("open file command canceled by user.");
		return false;
	}
	
	// rename Probe chooser
	public void changeProbeNames() {
		
		logger.info("reporting from changeProbeNames");
		logger.info("get probe1 name: " + HeatProbeNames.getProbe1Name());
		logger.info("get probe2 name: " + HeatProbeNames.getProbe2Name());
		logger.info("get probe3 name: " + HeatProbeNames.getProbe3Name());
		logger.info("get probe4 name: " + HeatProbeNames.getProbe4Name());
		
		probe1Checkbox.setText(("<html><font color='yellow'>&#8212;</font>" + HeatProbeNames.getProbe1Name() + "</html>"));
		probe2Checkbox.setText(("<html><font color='red'>&#8212;</font>" + HeatProbeNames.getProbe2Name() + "</html>"));
		probe3Checkbox.setText(("<html><font color='blue'>&#8212;</font>" + HeatProbeNames.getProbe3Name() + "</html>"));
		probe4Checkbox.setText(("<html><font color='green'>&#8212;</font>" + HeatProbeNames.getProbe4Name()  + "</html>"));
		
		statusPanel.changeColumnName();
	}

	public void changeSeriesNames() {
	
		logger.info("change probe series names");
		
		heatingData.changeSeriesNames();
	}
	
	 private byte[] generateChartPDF() {
	 
	 	SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
		String currentTime = formatter.format(date);
	 
	 	String chartTitle = Preferences.getDataFilename() + " - " + formatter.format(date);
	 
	 	printingChart = new JFreeChart(
		 chartTitle, JFreeChart.DEFAULT_TITLE_FONT, printingPlot, true);
		
		printingChart.setBackgroundPaint(Color.white);
		
        // here we use OrsonPDF to generate PDF in a byte array
        PDFDocument doc = new PDFDocument();
        Rectangle bounds = new Rectangle(7 * 72, 10 * 72);
        Page page = doc.createPage(bounds);
        PDFGraphics2D g2 = page.getGraphics2D();
        // JFreeChart chart = createChart(createDataset());
        printingChart.draw(g2, bounds);
        return doc.getPDFBytes();
    }

    private static PrintService findPrintService(String printerName) {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService printService : printServices) {
            if (printService.getName().trim().equals(printerName)) {
                return printService;
            }
        }
        return null;
    }
	
	public void savePlot(String plotFilename) {
	
		try {
		
			logger.info("trying to save the plot to a file (2): " + plotFilename);
	
			// temperatures plot
			NumberAxis temperatureRangePrint = new NumberAxis("Probe Temps (C)");
			XYItemRenderer temperatureRendererPrint = new StandardXYItemRenderer(); 
			
			
			// XYPlot temperaturePlotPrint = new XYPlot(heatingData.generateTemperatureDataPrint(), 
			// null, temperatureRangePrint, temperatureRendererPrint);
			 
			XYPlot temperaturePlotPrint = new XYPlot(heatingData.generateTemperatureDataPrint(), 
			 null, temperatureRangePrint, temperatureRendererPrint); 
			 
			temperaturePlotPrint.setBackgroundPaint(Color.white);
			temperatureRangePrint.setLabelPaint(Color.black);
    		temperatureRangePrint.setTickLabelPaint(Color.black);
			temperaturePlotPrint.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
			temperatureRendererPrint.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
			temperatureRendererPrint.setBaseStroke(new BasicStroke(1.0f));
			((AbstractRenderer) temperatureRendererPrint).setAutoPopulateSeriesStroke(false);
			temperatureRangePrint.setNumberFormatOverride(threeDecimalFormatter); // set decimal format
			temperatureRangePrint.setAutoRangeIncludesZero(false);
			temperatureRendererPrint.setSeriesPaint(0, new Color(255, 255, 0)); // red
			// temperatureRendererPrint.setSeriesPaint(1, new Color(255, 0 ,0)); 	// yellow
			// temperatureRendererPrint.setSeriesPaint(2, new Color(0, 0, 255)); 	// blue
			// temperatureRendererPrint.setSeriesPaint(3, new Color(0, 204, 0)); 	// green
			
    		
			// base temp plot
			NumberAxis baseTempRangePrint = new NumberAxis("BW Temp (C)");
			XYItemRenderer baseTempRendererPrint = new StandardXYItemRenderer(); 
			XYPlot baseTempPlotPrint = new XYPlot(heatingData.generateBaseTempDataPrint(), 
			 null, baseTempRangePrint, baseTempRendererPrint);
			baseTempRangePrint.setLabelPaint(Color.black);
    		baseTempRangePrint.setTickLabelPaint(Color.black);
			baseTempRangePrint.setNumberFormatOverride(threeDecimalFormatter); // set decimal format
			baseTempPlotPrint.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
			baseTempRendererPrint.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
			baseTempRendererPrint.setBaseStroke(new BasicStroke(1.0f));
			((AbstractRenderer) baseTempRendererPrint).setAutoPopulateSeriesStroke(false);
			baseTempRangePrint.setAutoRangeIncludesZero(false);
			baseTempRendererPrint.setSeriesPaint(0, Color.green);
		
			// depth plot
			XYItemRenderer depthRendererPrint = new StandardXYItemRenderer(); 
			NumberAxis depthRangePrint = new NumberAxis("Depth (m)");
			XYPlot depthPlotPrint = new XYPlot(heatingData.generateDepthDataPrint(), null, 
			 depthRangePrint, depthRendererPrint); 
			depthRangePrint.setNumberFormatOverride(oneDecimalFormatter); // set decimal format
			depthPlotPrint.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
			depthRendererPrint.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
			depthRendererPrint.setBaseStroke(new BasicStroke(1.0f));
			((AbstractRenderer) depthRendererPrint).setAutoPopulateSeriesStroke(false);
			depthRangePrint.setAutoRangeIncludesZero(false);
			depthRendererPrint.setSeriesPaint(0, Color.PINK);
		
			// tilt plot
			XYItemRenderer tiltRendererPrint = new StandardXYItemRenderer(); 
			NumberAxis tiltRangePrint = new NumberAxis("Tilt (deg)");
			XYPlot tiltPlotPrint = new XYPlot(heatingData.generateTiltDataPrint(), null, 
			 tiltRangePrint, tiltRendererPrint); 
			tiltPlotPrint.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT); 
			tiltRendererPrint.setSeriesPaint(0, new Color(51, 204, 255));
			tiltRendererPrint.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
			tiltRangePrint.setNumberFormatOverride(twoDecimalFormatter); // set decimal format
			tiltRendererPrint.setBaseStroke(new BasicStroke(1.0f));
			((AbstractRenderer) tiltRendererPrint).setAutoPopulateSeriesStroke(false);
			tiltRangePrint.setAutoRangeIncludesZero(false);
		
			// battery plot
			XYItemRenderer batteryRendererPrint = new StandardXYItemRenderer();
			XYLineAndShapeRenderer BatteryLineRendererPrint = new XYLineAndShapeRenderer(true, false);
			NumberAxis batteryRangePrint = new NumberAxis("Batt (V)");
			XYPlot batteryPlotPrint = new XYPlot(heatingData.generateBatteryDataPrint(), 
			 null, batteryRangePrint, batteryRendererPrint); 
			batteryPlotPrint.setRenderer(BatteryLineRendererPrint);
			batteryRendererPrint.setSeriesPaint(0, new Color(255, 0, 0));
			batteryRendererPrint.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
			batteryRendererPrint.setBaseStroke(new BasicStroke(1.0f));
			((AbstractRenderer) batteryRendererPrint).setAutoPopulateSeriesStroke(false);
			batteryRangePrint.setNumberFormatOverride(twoDecimalFormatter); // set decimal format	
			batteryPlotPrint.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
			batteryRangePrint.setAutoRangeIncludesZero(false);
			
			
			// combine the subplots into one chart
			NumberAxis recordsRangePrint = new NumberAxis("Record");
			recordsRangePrint.setNumberFormatOverride(zeroDecimalFormatter); // set decimal format
    		
    		double lowerBoundTempPlot = recordsRange.getLowerBound();
			double upperBoundTempPlot = recordsRange.getUpperBound();
			
			logger.info("lowerbound print:" + lowerBoundTempPlot);
    		logger.info("upperbound print:" + upperBoundTempPlot);
    		
    		recordsRangePrint.setRange(new Range(lowerBoundTempPlot, upperBoundTempPlot));
		
			printingPlot = new CombinedDomainXYPlot(recordsRangePrint);
			printingPlot.setGap(10.0);
			printingPlot.add(temperaturePlotPrint, 2);
			printingPlot.add(baseTempPlotPrint, 1);
			printingPlot.add(depthPlotPrint, 1);
			printingPlot.add(tiltPlotPrint, 1);
			printingPlot.add(batteryPlotPrint, 1);
		
			// rename Probe chooser
			// HeatProbeNames.readProbeNamesFile(tempPath);
			// changeProbeNames();
			// changeSeriesNames();
		
			PdfWriter writer = new PdfWriter(plotFilename);
        	PdfDocument targetPDF = new PdfDocument(writer);
        	document = new Document(targetPDF); // , pagesize3x5
		
			Document document = new Document(targetPDF); 
	        
        	PdfReader reader = new PdfReader(new ByteArrayInputStream(generateChartPDF()));
        	PdfDocument chartDoc = new PdfDocument(reader);
        	PdfFormXObject chart = chartDoc.getFirstPage().copyAsFormXObject(targetPDF);
        	Image chartImage = new Image(chart);
        	document.add(new Paragraph().add(chartImage));
        	
        	document.close();
        	
    	} catch (IOException error) {
        
            logger.error("File not found in saving plot: " + error);
        }
	}
	
	public void itemStateChanged(ItemEvent e) {
	}
	
	private void customizeMenuBar(JMenuBar menuBar) {

    	menuBar.setUI(new BasicMenuBarUI() {

        	@Override
        	public void paint(Graphics g, JComponent c) {
           		g.setColor(Color.black);
            	g.fillRect(0, 0, c.getWidth(), c.getHeight());
        	}

    	});

    	MenuElement[] menus = menuBar.getSubElements();

    	for (MenuElement menuElement : menus) {

        	JMenu menu = (JMenu) menuElement.getComponent();
        	changeComponentColors(menu);
        	menu.setOpaque(true);

        	MenuElement[] menuElements = menu.getSubElements();

        	for (MenuElement popupMenuElement : menuElements) {

         	   JPopupMenu popupMenu = (JPopupMenu) popupMenuElement.getComponent();
         	   popupMenu.setBorder(null);
         	   
         	   MenuElement[] menuItens = popupMenuElement.getSubElements();
         	   
         	   for (MenuElement menuItemElement : menuItens) {
         	   
         	   	JMenuItem menuItem = (JMenuItem) menuItemElement.getComponent();
                changeComponentColors(menuItem);
                menuItem.setOpaque(true);
            	}
        	}
    	}
	}

	private void changeComponentColors(Component comp) {
    	comp.setBackground(Color.black);
    	comp.setForeground(Color.white);
	}
}
