int width = auxChartPanel.getWidth();
        	int height = auxChartPanel.getHeight();
        	BufferedImage originalImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        	auxChartPanel.paint(originalImage.getGraphics());
        	
        	// File outputfile = new File(plotFilename);
    		// ImageIO.write(originalImage, "png", outputfile);
    		
    		// String testimg = "/Users/elimorris/Desktop/" + "ImageToPdf.pdf";
    		
    		// convert to pdf
    		PdfDocument pdfDocument = new PdfDocument(new PdfWriter(plotFilename));
        	Document document = new Document(pdfDocument);
        	// pdfDocument.addNewPage();
        	
        	Image pdfImg = new Image(ImageDataFactory.create(originalImage, null));
                                            
			// pdfImg.scaleToFit(400.0f, 9999.9f);     // (if it's too big)	
        	
        	// itextImg.setHorizontalAlignment(HorizontalAlignment.CENTER);
			// pdfDocument.add(new Paragraph(pdfImg));
			
			// pdfDocument.add(pdfImg);
			
			document.add(pdfImg);
        	
        	
        	
        	
        	// document.add(image);
        	document.close();
        	
        	/*
		
			PdfDocument pdfDocument = 
			 new PdfDocument(new PdfWriter("/Users/elimorris/Desktop/" + "ImageToPdf.pdf"));
			 
        	Document document = new Document(pdfDocument);
		
			BufferedImage blackAndWhite = 
			 new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
            
            Graphics2D graphics = blackAndWhite.createGraphics();
            graphics.drawImage(blackAndWhite, 0, 0, null);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try {
				ImageIO.write(blackAndWhite, "png", baos);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Image image = new Image(ImageDataFactory.create(baos.toByteArray()));
			document.add(image);
			
			pdfDocument.close();
			
			/*
		
			int width = auxChartPanel.getWidth();
        	int height = auxChartPanel.getHeight();
        	BufferedImage originalImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        	auxChartPanel.paint(originalImage.getGraphics());
        	
        	File outputfile = new File(plotFilename);
    		ImageIO.write(originalImage, "png", outputfile);
    		
    		// convert to pdf
    		PdfDocument pdfDocument = new PdfDocument(new PdfWriter("/Users/elimorris/Desktop/" + "ImageToPdf.pdf"));
        	Document document = new Document(pdfDocument);
        	
        	// document.add(image);
        	pdfDocument.close();
        	*/
        	
        	/*
        	try {
    			images.add(new Image(ImageDataFactory.create(originalImage)));
  			} catch (MalformedURLException e) {
    			System.err.println(file.getPath());
    		}

        	ImageData imageData = ImageDataFactory.create(originalImage);
        	Image image = new Image(imageData);
        	image.setWidth(pdfDocument.getDefaultPageSize().getWidth() - 50);
        	image.setAutoScaleHeight(true);

        	document.add(image);
        	pdfDocument.close();
        	
        	BufferedImage blackAndWhite = new 
        	 BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
        	 
            Graphics2D graphics = blackAndWhite.createGraphics();
            graphics.drawImage(bufferedImage, 0, 0, null);
        	
        	PdfDocument pdfDocument = new PdfDocument(new PdfWriter(DEST));
        	Document document = new Document(pdfDocument);

        PdfToImageRenderer.renderPdf(new FileInputStream(SRC), new PageRange("1"), new PdfToImageRenderer.BufferedImageReadyListener() {
            @Override
            public void bufferedImageReady(BufferedImage bufferedImage, int i) {
                BufferedImage blackAndWhite = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
                Graphics2D graphics = blackAndWhite.createGraphics();
                graphics.drawImage(bufferedImage, 0, 0, null);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try {
                    ImageIO.write(blackAndWhite, "png", baos);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Image image = new Image(ImageDataFactory.create(baos.toByteArray()));
                document.add(image);
            }
        });

        pdfDocument.close();
        */
        	
    	} catch (IOException error) {
        
            logger.error("File not found in saving plot: " + error);
        }
        
        public void setBatteryLowLimit(double batteryLowLimit) {
		this.batteryLowLimit = batteryLowLimit;
	}
	
	public void	setTiltLowLimit(double tiltLowLimit) {
		this.tiltLowLimit = tiltLowLimit;
	}
	
	public void setDepthLowLimit(double depthLowLimit) {
		this.depthLowLimit = depthLowLimit;
	}
	
	public void	setProbeLowLimit(double probeLowLimit) {
		this.probeLowLimit = probeLowLimit;
	}
		
	public void	setBatteryHighLimit(double batteryHighLimit) {
		this.batteryHighLimit = batteryHighLimit;
	}
	
	public void	setTiltHighLimit(double tiltHighLimit) {
		this.tiltHighLimit = tiltHighLimit;
	}
	
	public void setDepthHighLimit(double depthHighLimit) {
		this.depthHighLimit = depthHighLimit;
	}
	
	public void setProbeHighLimit(double probeHighLimit) {
		this.depthHighLimit = depthHighLimit;
	}
		
	public void setBatteryWarnLimit(double batteryWarnLimit) {
		this.batteryWarnLimit = batteryWarnLimit;
	}
	
	public void setTiltWarnLimit(double tiltWarnLimit) {
		this.tiltWarnLimit = tiltWarnLimit;
	}
	
	public void setDepthWarnLimit(double depthWarnLimit) {
		this.depthWarnLimit = depthWarnLimit;
	}
	
	public void setProbeWarnLimit(double probeWarnLimit) {
		this.probeWarnLimit = probeWarnLimit;
	}
	
	






public class BackgroundMenuBar extends JMenuBar {
    Color bgColor=Color.WHITE;

    public void setColor(Color color) {
        bgColor=color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(bgColor);
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

    }
}


/*  
        // Base Temp Chart
        XYSeriesCollection baseTempDataset = generateBaseTempData();
        JFreeChart baseTempChart = ChartFactory.createXYLineChart(
            null,
            null,
            "Base Temp (C)",
            baseTempDataset,
            PlotOrientation.VERTICAL,
            false,
            true,
            false
        );
        
        XYPlot baseTempPlot = (XYPlot) baseTempChart.getPlot();
        baseTempPlot.setDomainPannable(true);
        baseTempPlot.setRangePannable(true);
        ChartUtils.applyCurrentTheme(baseTempChart);
        
		NumberAxis baseTempRange = (NumberAxis) baseTempPlot.getRangeAxis();
		NumberFormat oneDigitFormatter = DecimalFormat.getInstance();
		oneDigitFormatter.setMinimumFractionDigits(1);
		oneDigitFormatter.setMaximumFractionDigits(1);
		baseTempRange.setNumberFormatOverride(oneDigitFormatter);
		
		ChartPanel baseTempChartPanel = new ChartPanel(baseTempChart, false);
        baseTempChartPanel.setDisplayToolTips(true);  
        baseTempChartPanel.setPreferredSize(new Dimension(800, 130));
        
        // Depth Chart
        XYSeriesCollection depthDataset = generateDepthData();
        JFreeChart depthChart = ChartFactory.createXYLineChart(
            null,
            null,
            "Depth (m)",
            depthDataset,
            PlotOrientation.VERTICAL,
            false,
            true,
            false
        );
        
        XYPlot depthPlot = (XYPlot) depthChart.getPlot();
        depthPlot.setDomainPannable(true);
        depthPlot.setRangePannable(true);
        ChartUtils.applyCurrentTheme(depthChart);
        
        
        
		NumberAxis depthRange = (NumberAxis) depthPlot.getRangeAxis();
		depthRange.setNumberFormatOverride(oneDigitFormatter);
		
		
		
		ChartPanel depthChartPanel = new ChartPanel(depthChart, false);
        depthChartPanel.setDisplayToolTips(true);  
        depthChartPanel.setPreferredSize(new Dimension(800, 130));
        
        // Tilt Chart
        XYSeriesCollection tiltDataset = generateTiltData();
        JFreeChart tiltChart = ChartFactory.createXYLineChart(
            null,
            null,
            "Tilt (deg)",
            tiltDataset,
            PlotOrientation.VERTICAL,
            false,
            true,
            false
        );
        
        XYPlot tiltPlot = (XYPlot) tiltChart.getPlot();
        tiltPlot.setDomainPannable(true);
        tiltPlot.setRangePannable(true);
        ChartUtils.applyCurrentTheme(tiltChart);
        
		NumberAxis tiltRange = (NumberAxis) tiltPlot.getRangeAxis();
		tiltRange.setNumberFormatOverride(oneDigitFormatter);
		
		ChartPanel tiltChartPanel = new ChartPanel(tiltChart, false);
        tiltChartPanel.setDisplayToolTips(true);  
        tiltChartPanel.setPreferredSize(new Dimension(800, 130));
        // tiltChartPanel.setMinimumSize(new Dimension(100, 100));
        
        // Battery Chart
        XYSeriesCollection batteryDataset = generateBatteryData();
        JFreeChart batteryChart = ChartFactory.createXYLineChart(
            null,
            null,
            "Battery (v)",
            batteryDataset,
            PlotOrientation.VERTICAL,
            false,
            true,
            false
        );
        

        
        XYPlot batteryPlot = (XYPlot) batteryChart.getPlot();
        batteryPlot.setDomainPannable(true);
        batteryPlot.setRangePannable(true);
        ChartUtils.applyCurrentTheme(batteryChart);
        
		NumberAxis batteryRange = (NumberAxis) batteryPlot.getRangeAxis();
		batteryRange.setNumberFormatOverride(oneDigitFormatter);
		
		ChartPanel batteryChartPanel = new ChartPanel(batteryChart, false);
        batteryChartPanel.setDisplayToolTips(true);  
        batteryChartPanel.setPreferredSize(new Dimension(800, 130));
*/



// statusPanel.setSize(800, 100);
		
		// this.setMinimumSize(new Dimension(this.getWidth(), 60) );
		// this.setPreferredSize(new Dimension(this.getWidth(), 60) );
		
		
// temperatureData.removeSeries(probe1Series);
		// probe1Series.setKey("carp");
		// temperatureData.addSeries(probe1Series);
		
		
/*
		renderer1.setSeriesPaint(0, Color.black);
		renderer2.setSeriesPaint(0, Color.black);
		renderer3.setSeriesPaint(0, Color.black);
		renderer4.setSeriesPaint(0, Color.black);
		*/
		
		
		
/*
		// Get the reserve space that jfree chart sets aside for the axis
		
		baseTempPlot.setAxisOffset(new RectangleInsets(50, 50, 50, 50) );
		
		AxisSpace space = temperatureRangeAxis.reserveSpace(
			g2, 
			temperaturePlot, 
			new Rectangle(width, height), 
			temperaturePlot.getRangeAxisEdge(), 
			temperaturePlot.getFixedRangeAxisSpace());

		// Give that space a fixed width
		space.setLeft(fixedAxisWidth);

		// Set it in the plot
		temperaturePlot.setFixedRangeAxisSpace(space);
		*/
		
/*
		GridBagLayout gridbagProbeChoose = new GridBagLayout();
		GridBagConstraints gridBagConstraintsProbeChoose = new GridBagConstraints();
		gridBagConstraintsProbeChoose.insets = new Insets(5, 5, 5, 5);
		gridBagConstraintsProbeChoose.fill = gridBagConstraintsProbeChoose.HORIZONTAL;
		
		gridBagConstraintsProbeChoose.weighty = 1;
		
       	// Probe 1 Name and checkbox
		jcb1 = new JCheckBox();
       	jcb1.setSelected(true);
       	gridBagConstraintsProbeChoose.weighty = 0.5;
        gridBagConstraintsProbeChoose.gridx = 0;
		gridBagConstraintsProbeChoose.gridy = 0;
		anchor.gridBagConstraintsProbeChoose = gridBagConstraintsProbeChoose.WEST;
		gridbagProbeChoose.setConstraints(jcb1, gridBagConstraintsProbeChoose);
		probeChooserPanel.add(jcb1);
		
		probe1Label = new JLabel("T6 test");
       	gridBagConstraintsProbeChoose.weighty = 0.5;
        gridBagConstraintsProbeChoose.gridx = 1;
		gridBagConstraintsProbeChoose.gridy = 0;
		gridbagProbeChoose.setConstraints(probe1Label, gridBagConstraintsProbeChoose);
		probeChooserPanel.add(probe1Label);
		
		// Probe 2 Name and checkbox
		jcb2 = new JCheckBox();
       	jcb2.setSelected(true);
       	gridBagConstraintsProbeChoose.weighty = 0.5;
        gridBagConstraintsProbeChoose.gridx = 0;
		gridBagConstraintsProbeChoose.gridy = 1;
		gridbagProbeChoose.setConstraints(jcb2, gridBagConstraintsProbeChoose);
		probeChooserPanel.add(jcb2);
		
		probe2Label = new JLabel("T7");
       	gridBagConstraintsProbeChoose.weighty = 0.5;
        gridBagConstraintsProbeChoose.gridx = 1;
		gridBagConstraintsProbeChoose.gridy = 1;
		gridbagProbeChoose.setConstraints(probe2Label, gridBagConstraintsProbeChoose);
		probeChooserPanel.add(probe2Label);
		

		// Probe 3 Name and checkbox
		jcb3 = new JCheckBox();
       	jcb3.setSelected(true);
       	gridBagConstraintsProbeChoose.weighty = 0.5;
        gridBagConstraintsProbeChoose.gridx = 0;
		gridBagConstraintsProbeChoose.gridy = 2;
		gridbagProbeChoose.setConstraints(jcb3, gridBagConstraintsProbeChoose);
		probeChooserPanel.add(jcb3);
		
		probe3Label = new JLabel("T8");
       	gridBagConstraintsProbeChoose.weighty = 0.5;
        gridBagConstraintsProbeChoose.gridx = 1;
		gridBagConstraintsProbeChoose.gridy = 2;
		gridbagProbeChoose.setConstraints(probe3Label, gridBagConstraintsProbeChoose);
		probeChooserPanel.add(probe3Label);
		
		// Probe 4 Name and checkbox
		jcb4 = new JCheckBox();
       	jcb4.setSelected(true);
       	gridBagConstraintsProbeChoose.weighty = 0.5;
        gridBagConstraintsProbeChoose.gridx = 0;
		gridBagConstraintsProbeChoose.gridy = 3;
		gridbagProbeChoose.setConstraints(jcb4, gridBagConstraintsProbeChoose);
		probeChooserPanel.add(jcb4);
		
		probe4Label = new JLabel("T10");
       	gridBagConstraintsProbeChoose.weighty = 0.5;
        gridBagConstraintsProbeChoose.gridx = 1;
		gridBagConstraintsProbeChoose.gridy = 3;
		gridbagProbeChoose.setConstraints(probe4Label, gridBagConstraintsProbeChoose);
		probeChooserPanel.add(probe4Label);
*/

// JPanel mainPanel = new JPanel(); 
		
		/*
		GridBagLayout mainGridbag = new GridBagLayout();
		GridBagConstraints mainGridBagConstraints = new GridBagConstraints();
		mainGridBagConstraints.insets = new Insets(0, 0, 0, 0);
		mainGridBagConstraints.fill = mainGridBagConstraints.HORIZONTAL;
		// mainGridBagConstraints.gridwidth = 1000;
		//mainGridBagConstraints.gridheight = h;
		mainGridBagConstraints.weightx = 1.0;
		mainGridBagConstraints.weighty = 1.0;
		
		mainGridBagConstraints.gridx = 1;
		// mainGridBagConstraints.gridy = 0;
		mainGridbag.setConstraints(statusPanel, mainGridBagConstraints);
		mainPanel.add(statusPanel);
		
		mainGridBagConstraints.gridx = 0;
		mainGridBagConstraints.gridy = 1;
		mainGridbag.setConstraints(plotPanel, mainGridBagConstraints);
		mainPanel.add(plotPanel);
		*/
		
		//getContentPane().add(statusPanel, BorderLayout.NORTH);
		// getContentPane().add(plotPanel, BorderLayout.CENTER);
		
		// this.add(splitPane);
		
// getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        // frame.setLocationRelativeTo(null);
        // frame.setVisible(true);
        
// try a screenshot
		// makeScreenshot(this);
		
		// Create an instance of the image so we can do some calculations
		// BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		// Create an instance of the Graphics2D from your image
		// Graphics2D g2 = image.createGraphics();
		
try {
    	
    		Rectangle rec = this.getBounds();
    	
    		logger.info("width: " + rec.width);
    		logger.info("height: " + rec.height);
    	
    	
    		BufferedImage bufferedImage = 
    	 	 new BufferedImage(rec.width, rec.height, BufferedImage.TYPE_INT_ARGB);
    	
    		this.paint(bufferedImage.getGraphics());
        	// Create temp file
        	logger.info("screen temp path: " + tempPath);
        	// File temp = File.createTempFile(tempPath + "screenshot", ".png");

			File outputfile = new File(tempPath + "screenshot.png");
        	// Use the ImageIO API to write the bufferedImage to a temporary file
        	ImageIO.write(bufferedImage, "png", outputfile);

        	// Delete temp file when program exits
        	// temp.deleteOnExit();
    	} catch (IOException ioe) {
        	ioe.printStackTrace();
    	}
    	
    	makeScreenshotApp(this);
    	
/*
    private static class UpdateAction extends AbstractAction {

        private final XYPlot plot;

        public UpdateAction(CombinedDomainXYPlot plot, int i) {
            super("Update plot " + (i + 1));
            this.plot = (XYPlot) plot.getSubplots().get(i);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            plot.setDataset(PlottingSolution.generateData());
        }
    }

    private static class VisibleAction extends AbstractAction {

        private XYItemRenderer renderer;
        private int i;

        public VisibleAction(XYItemRenderer renderer, int i) {
            super("Probe " + (i + 1));
            this.renderer = renderer;
            this.i = i;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            renderer.setSeriesVisible(i, !renderer.getSeriesVisible(i));
        }
    }
*/

/*
    private static XYSeriesCollection generateData() {
        XYSeriesCollection data = new XYSeriesCollection();
        for (int i = 0; i < MAX; i++) {
            data.addSeries(generateSeries("Probe " + (i + 1)));
        }
        return data;
    }

    private static XYSeries generateSeries(String key) {
        XYSeries series = new XYSeries(key);
        for (int i = 0; i < 16; i++) {
            series.add(RND.nextGaussian(), RND.nextGaussian());
        }
        return series;
    }
    
    private static XYSeriesCollection generateDepthData() {
        XYSeriesCollection data = new XYSeriesCollection();
        data.addSeries(generateDepthSeries("Record "));
       
        return data;
    }
    
    private static XYSeries generateDepthSeries(String key) {
        XYSeries series = new XYSeries(key);
        for (int i = 0; i < 16; i++) {
            series.add(RND.nextGaussian(), RND.nextGaussian());
        }
        return series;
    }
    */
    
/*
		this.setLocation(
			(appSize.width - dialogSize.width) / 2 + appLocation.x,
			(appSize.height - dialogSize.height) / 2 + appLocation.y);

 
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRect);
 
		ImageIO.write(image, fileType, new File(new File(tempPath + "screenshot.png");));
		*/
		
/*
		try {
	
			PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
    		Document document = new Document(pdf);
    		String line = "Hello! Welcome to iTextPdf";
    		document.add(new Paragraph(line));
    		document.close();

    		System.out.println("Awesome PDF just got created.");
    	} catch (IOException error) {
    	
    		// logger.error("File IO Exception: " + error);
    		System.out.println("File IO Exception: " + error);
    	}
    	
    	try {
    	
            PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
    		Document document = new Document(pdf);
            
            int width = auxChartPanel.getWidth();
        	int height = auxChartPanel.getHeight();
        	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        	auxChartPanel.paint(image.getGraphics());
        	
        	File outputfile = new File(DEST);
    		ImageIO.write(image, "png", outputfile);
            
            
            // Image pdfImage = Image.getInstance(writer, image, 1);
        	// pdfImage.scalePercent(50);
        	
        	// document.add(pdfImage);
        	System.out.println("printed!");
        	
            document.close();
            
        // } catch (DocumentException e1) {
        
        //    e1.printStackTrace();
        } catch (FileNotFoundException e1) {
        
            e1.printStackTrace();
        } catch (IOException e1) {
        
            e1.printStackTrace();
        }
*/	


public void pdfTest() {
	
		String DEST = tempPath + "screenshot3.png";
		
		try {
			int width = auxChartPanel.getWidth();
        	int height = auxChartPanel.getHeight();
        	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        	auxChartPanel.paint(image.getGraphics());
        	
        	File outputfile = new File(DEST);
    		ImageIO.write(image, "png", outputfile);
    	} catch (IOException e1) {
        
            e1.printStackTrace();
        }
	}
	
	
public void makeScreenshot(JFrame argFrame) {
    
    	Rectangle rec = argFrame.getBounds();
    	
    	logger.info("width: " + rec.width);
    	logger.info("height: " + rec.height);
    	
    	BufferedImage bufferedImage = 
    	 new BufferedImage(rec.width, rec.height, BufferedImage.TYPE_INT_ARGB);
    	
    	argFrame.paint(bufferedImage.getGraphics());

    	try {
        	// Create temp file
        	logger.info("screen temp path: " + tempPath);
        	// File temp = File.createTempFile(tempPath + "screenshot", ".png");

			File outputfile = new File(tempPath + "screenshot.png");
        	// Use the ImageIO API to write the bufferedImage to a temporary file
        	ImageIO.write(bufferedImage, "png", outputfile);

        	// Delete temp file when program exits
        	// temp.deleteOnExit();
    	} catch (IOException ioe) {
        	ioe.printStackTrace();
    	}
	}
	
	public void makeScreenshotApp(JFrame argFrame) {
	
		Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

            int dx = centerPoint.x - windowSize.width / 2;
            int dy = centerPoint.y - windowSize.height / 2;    
            setLocation(dx, dy);
	
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		Rectangle screenRect = new Rectangle(screenSize); 
		
		Dimension appSize = this.getSize();
		Point appLocation = this.getLocation();
		
		Rectangle rec = argFrame.getBounds();
    	
    	
    	logger.info("width: " + rec.width);
    	logger.info("height: " + rec.height);
    	
    	logger.info("application x: " + appLocation.x);
    	logger.info("application y: " + appLocation.y);
    	
		
	}
	
	void jMenuViewTemperaturePlot_actionPerformed(ActionEvent e) {
		logger.info("temperature plot");
	
/*
		if (temperaturePlotVisible && 
		 (baseTempPlotVisible || 
		 depthPlotVisible || 
		 tiltPlotVisible || 
		 batteryPlotVisible)
		 ) {
		 
			auxPlot.remove(temperaturePlot);
			jMenuViewTemperaturePlot.setText("Hide Temperature Plot");
		} else {
		
			jMenuViewTemperaturePlot.setText("Show Temperature Plot");
		
			// remove all plots
			if (temperaturePlotVisible) { 
				auxPlot.remove(temperaturePlot);
			}
			
			if (depthPlotVisible) {
				auxPlot.remove(depthPlot);
			}
			
			if (tiltPlotVisible) {
				auxPlot.remove(tiltPlot);
			}
			
			if (batteryPlotVisible) {
				auxPlot.remove(batteryPlot);
			}
			
			auxPlot.add(temperaturePlot);
			auxPlot.add(baseTempPlot);
    		auxPlot.add(depthPlot);
    		auxPlot.add(tiltPlot);
    		auxPlot.add(batteryPlot);
			
			temperaturePlotVisible = true;
    		baseTempPlotVisible = true;
    		depthPlotVisible = true;
    		tiltPlotVisible = true;
    		batteryPlotVisible = true;
		}
		*/
		
private XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 = new XYSeries("Object 1");
		XYSeries series2 = new XYSeries("Object 2");
		XYSeries series3 = new XYSeries("Object 3");
 
		series1.add(1.0, 2.0);
		series1.add(2.0, 3.0);
		series1.add(3.0, 2.5);
		series1.add(3.5, 2.8);
		series1.add(4.2, 6.0);
 
		series2.add(2.0, 1.0);
		series2.add(2.5, 2.4);
		series2.add(3.2, 1.2);
		series2.add(3.9, 2.8);
		series2.add(4.6, 3.0);
 
		series3.add(1.2, 4.0);
		series3.add(2.5, 4.4);
		series3.add(3.8, 4.2);
		series3.add(4.3, 3.8);
		series3.add(4.5, 4.0);
 
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);
 
		return dataset;
	}
	
/*
        double probe1Temp[] = {0.0, 0.0, 0.0};
        double probe2Temp[] = {0.0, 0.0, 0.0};
        double probe3Temp[] = {0.0, 0.0, 0.0};
        double probe4Temp[] = {0.0, 0.0, 0.0};
        double probeBaseTemp[] = {0.0, 0.0, 0.0};
        double probeDepthTemp[] = {0.0, 0.0, 0.0};
        double probeBattery[] = {0.0, 0.0, 0.0};
        
        double full[] = {0.0, 0.0, 0.0};
        double upper[] = {0.0, 0.0, 0.0};
        double middle[] = {0.0, 0.0, 0.0};
        double lower[] = {0.0, 0.0, 0.0};
        */
        
// Object[][] data = new Object[][];
        
        // old "21-01-21 10:03:32"
        
        /*
        Object[][] data = new Object[][] {
            {10, 11.1, 12.2, 13.3, 14.4, 16.6, 17.7, 18.8, 12.5, 0.1, 0.2, 0.3, 0.4},
            {11, 12.1, 13.2, 14.3, 15.4, 17.6, 19.7, 19.8, 12.3, 0.2, 0.3, 0.4, 0.5},
            {12, 13.2, 14.2, 15.3, 16.4, 18.6, 11.7, 11.8, 12.1, 0.3, 0.4, 0.5, 0.6}
        };
        */
        
