package heatflow_monitor;

import java.awt.*;
import javax.swing.*;
import java.util.Date;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.border.*;
import org.apache.log4j.Logger;
import javax.swing.table.TableColumn;
import javax.swing.table.JTableHeader;
import java.text.SimpleDateFormat;
import javax.swing.table.TableColumnModel;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentAdapter;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

class StatusPanel2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public boolean DEBUG = false;

	// log4j
	static Logger logger = Logger.getLogger(Heatflow.class.getName() );
	
	JTable table;
	
	// StatusTableModel statusTableModel;
	
	JScrollPane jscrollPane;
	
	Data2 heatingData;
	
	Vector<String> columnNames;
	Vector<String> tooltips;
	
	StatusColumnCellRenderer recordNumberStatusColor;
	StatusColumnCellRenderer timeIntervalStatusColor;
	
	StatusColumnCellRenderer probe1StatusColor;
	StatusColumnCellRenderer probe2StatusColor;
	StatusColumnCellRenderer probe3StatusColor;
	StatusColumnCellRenderer probe4StatusColor;
	
	StatusColumnCellRenderer bwStatusColor;
	StatusColumnCellRenderer depthStatusColor;
	StatusColumnCellRenderer tiltStatusColor;
	StatusColumnCellRenderer batteryStatusColor;
	
	StatusColumnCellRenderer probe1GradientStatusColor;
	StatusColumnCellRenderer probe2GradientStatusColor;
	StatusColumnCellRenderer probe3GradientStatusColor;
	StatusColumnCellRenderer probe4GradientStatusColor;
                                      
	Vector<String> row1;
	Vector<String> row2;
	Vector<String> row3;
	Vector<String> row4;
	Vector<String> row5;
	Vector<String> row6;
	Vector<String> row7;
	Vector<String> row8;
	Vector<String> row9;
	Vector<String> row10;
	Vector<String> row11;
	Vector<String> row12;
	Vector<String> row13;
	Vector<Vector> alldata;
	
	DecimalFormat oneDecimalFormatter;
	DecimalFormat twoDecimalFormatter;
	DecimalFormat threeDecimalFormatter;
	DecimalFormat sciNotationFormatter;
	
	public static int rowNum;
	 
	DefaultTableModel tableModel;
	
	boolean scrollTableEnable = true;
	 
	 // StatusTableModel tableModel;
	
	public StatusPanel2(Data2 heatingData) {
	
		super(new GridLayout(1, 1));
		
		this.heatingData = heatingData;
		
		boolean DEBUG = false;
		
        int sizeOfHeatingData = heatingData.getHeatflowSize();
        
        loadTooltips();
        
		columnNames = new Vector<String>();
		
		String oneDecimalPattern = "0.0";
		oneDecimalFormatter = new DecimalFormat(oneDecimalPattern);

		String twoDecimalPattern = "0.00";
		twoDecimalFormatter = new DecimalFormat(twoDecimalPattern);

		String threeDecimalPattern = "0.000";
		threeDecimalFormatter = new DecimalFormat(threeDecimalPattern);
	
		String sciNotationPattern = "0.000E0";
		sciNotationFormatter = new DecimalFormat(sciNotationPattern);
	
		rowNum = 0;
		
		tableModel = new DefaultTableModel();
      	// table = new JTable(tableModel);
      	
      	table = new JTable(tableModel){
   			@Override
       			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
          			Component component = super.prepareRenderer(renderer, row, column);
           			int rendererWidth = component.getPreferredSize().width;
           			TableColumn tableColumn = getColumnModel().getColumn(column);
           			tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, 
           			 tableColumn.getPreferredWidth()));
           			 
           			return component;
        		}
    		};
		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      	
      	JTableHeader header = table.getTableHeader();
      	header.setBackground(Color.white);
      	header.setForeground(Color.black);
      	
      	header.setFont(new Font("SansSerif", Font.BOLD, 12));
    	
    	Border thickBorder = BorderFactory.createLineBorder(Color.BLACK, 1, false);
    	UIManager.getDefaults().put("TableHeader.cellBorder", thickBorder);

		tableModel.addColumn(" Record");
      	tableModel.addColumn(" Time Int. (s)"); 
		tableModel.addColumn(HeatProbeNames.getProbe1Name() + " (C)");
		tableModel.addColumn(HeatProbeNames.getProbe2Name() + " (C)");
		tableModel.addColumn(HeatProbeNames.getProbe3Name() + " (C)");
		tableModel.addColumn(HeatProbeNames.getProbe4Name() + " (C)");
		tableModel.addColumn(" BW Temp (C)");
		tableModel.addColumn(" Depth (m)"); 
		tableModel.addColumn(" Tilt (deg)"); 
		tableModel.addColumn(" Batt (V)");
		tableModel.addColumn("<html>&nbsp;GradF (&#176;C/m)<html>");
		tableModel.addColumn("<html>&nbsp;GradU (&#176;C/m)</html>");
		tableModel.addColumn("<html>&nbsp;GradM (&#176;C/m)</html>");
		tableModel.addColumn("<html>&nbsp;GradL (&#176;C/m)</b></html>");
      	
      	// set the color of each of the quantities
      	recordNumberStatusColor = new StatusColumnCellRenderer();
      	timeIntervalStatusColor = new StatusColumnCellRenderer();		
		probe1StatusColor = new StatusColumnCellRenderer();		
		probe2StatusColor = new StatusColumnCellRenderer();		
		probe3StatusColor = new StatusColumnCellRenderer();	
		probe4StatusColor = new StatusColumnCellRenderer();		
		bwStatusColor = new StatusColumnCellRenderer();	
		depthStatusColor = new StatusColumnCellRenderer();	
		tiltStatusColor = new StatusColumnCellRenderer();	
		batteryStatusColor = new StatusColumnCellRenderer();		
		probe1GradientStatusColor = new StatusColumnCellRenderer();		
		probe2GradientStatusColor = new StatusColumnCellRenderer();		
		probe3GradientStatusColor = new StatusColumnCellRenderer();		
		probe4GradientStatusColor = new StatusColumnCellRenderer();		
		
		setProbeStates();
		
		table.getColumnModel().getColumn(0).setCellRenderer(recordNumberStatusColor);
		table.getColumnModel().getColumn(1).setCellRenderer(timeIntervalStatusColor);
		table.getColumnModel().getColumn(2).setCellRenderer(probe1StatusColor);
		table.getColumnModel().getColumn(3).setCellRenderer(probe2StatusColor);
		table.getColumnModel().getColumn(4).setCellRenderer(probe3StatusColor);
		table.getColumnModel().getColumn(5).setCellRenderer(probe4StatusColor);
		table.getColumnModel().getColumn(6).setCellRenderer(bwStatusColor);	
		table.getColumnModel().getColumn(7).setCellRenderer(depthStatusColor);		
		table.getColumnModel().getColumn(8).setCellRenderer(tiltStatusColor);
		table.getColumnModel().getColumn(9).setCellRenderer(batteryStatusColor);
		table.getColumnModel().getColumn(10).setCellRenderer(probe1GradientStatusColor);
		table.getColumnModel().getColumn(11).setCellRenderer(probe2GradientStatusColor);
		table.getColumnModel().getColumn(12).setCellRenderer(probe3GradientStatusColor);
		table.getColumnModel().getColumn(13).setCellRenderer(probe4GradientStatusColor);
  		
  		ColumnHeaderToolTips tips = new ColumnHeaderToolTips();
        
    	for (int c = 0; c < table.getColumnCount(); c++) {
      		TableColumn col = table.getColumnModel().getColumn(c);
      		tips.setToolTip(col, tooltips.get(c)) ;
    	}
    	
    	header.addMouseMotionListener(tips);
        
        table.setGridColor(Color.white);
      	table.setShowGrid(true);
      	table.setShowVerticalLines(true);
        table.setEnabled(false);
        
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
		
		table.setFillsViewportHeight(true);
		
		table.addComponentListener(new ComponentAdapter() {
    		public void componentResized(ComponentEvent e) {
    			if (scrollTableEnable) {
        			table.scrollRectToVisible(table.getCellRect(table.getRowCount()-1, 0, true));
        		}
    		}
		});
		
        jscrollPane = new JScrollPane(table);
        
        jscrollPane.getViewport().setBackground(Color.black);
        
        this.setBackground(Color.black);
        
        //add the table to the JPanel
        this.add(jscrollPane);
        
        this.setVisible(true);
    }
    
    void addDatarow() {
    
    	logger.info("adding a data row: " + rowNum);
    	System.out.println("adding a data row: " + rowNum);
    	
    	Vector<String> line = new Vector<String>();
    	// line = alldata.elementAt(rowNum);
    	
    	int lineNumber = heatingData.getHeatflowSize() - 1;
    	logger.info("heating data line number: " + lineNumber);
    	
    	int recordNumber = heatingData.getHeatflowDatum(rowNum).getRecord() + 1;
		String valueString = String.valueOf(recordNumber);
		line.add(valueString);
    	
		double timeInterval = heatingData.calculateTimeInterval(rowNum);
		valueString = oneDecimalFormatter.format(timeInterval);
		line.add(valueString);
		
		double probe1Temp = heatingData.getHeatflowDatum(rowNum).getProbe1Temp();
		valueString = threeDecimalFormatter.format(probe1Temp);
		line.add(valueString);
		
		double probe2Temp = heatingData.getHeatflowDatum(rowNum).getProbe2Temp();
		valueString = threeDecimalFormatter.format(probe2Temp);
		line.add(valueString);
		
		double probe3Temp = heatingData.getHeatflowDatum(rowNum).getProbe3Temp();
		valueString = threeDecimalFormatter.format(probe3Temp);
		line.add(valueString);
		
		double probe4Temp = heatingData.getHeatflowDatum(rowNum).getProbe4Temp();
		valueString = threeDecimalFormatter.format(probe4Temp);
		line.add(valueString);
		
		double baseTemp = heatingData.getHeatflowDatum(rowNum).getBaseTemp();
		valueString = threeDecimalFormatter.format(baseTemp);
		line.add(valueString);
		
		double depth = heatingData.getHeatflowDatum(rowNum).getDepth();
		valueString = oneDecimalFormatter.format(depth);
		line.add(valueString);
		
		double tilt = heatingData.getHeatflowDatum(rowNum).getTilt();
		valueString = twoDecimalFormatter.format(tilt);
		line.add(valueString);
		
		double battery = heatingData.getHeatflowDatum(rowNum).getBattery();
		valueString = twoDecimalFormatter.format(battery);
		line.add(valueString);
		
		double full = heatingData.getHeatflowDatum(rowNum).getFullGradient();
		valueString = sciNotationFormatter.format(full);
		line.add(valueString);
		
		double upper = heatingData.getHeatflowDatum(rowNum).getUpperGradient();
		valueString = sciNotationFormatter.format(upper);
		line.add(valueString);
		
		double middle = heatingData.getHeatflowDatum(rowNum).getMiddleGradient();
		valueString = sciNotationFormatter.format(middle);
		line.add(valueString);
		
		double lower = heatingData.getHeatflowDatum(rowNum).getLowerGradient();
		valueString = sciNotationFormatter.format(lower);
    	line.add(valueString);
    	
    	tableModel.addRow(line);
    	
    	rowNum++;
    }
	
	void setTimeIntervalStatusColor(int state) {
		
		if (state == 0) {
			timeIntervalStatusColor.clear();
		} else if (state == 1) {
			timeIntervalStatusColor.clear();
			timeIntervalStatusColor.setWarning(true);
		} else if (state == 2) {
			timeIntervalStatusColor.clear();
			timeIntervalStatusColor.setError(true);
		} else {
			logger.info("not a valid state");
		}
	}
	
	void setProbe1StatusState(int state) {
	
		logger.info("state from probe 1 status: " + state);
	
		if (state == 0) {
			probe1StatusColor.clear();
		} else if (state == 1) {
			probe1StatusColor.clear();
			probe1StatusColor.setWarning(true);
		} else if (state == 2) {
			logger.info("STATE 2 from probe 1 status: " + state);
			probe1StatusColor.clear();
			probe1StatusColor.setError(true);
		} else {
			logger.info("not a valid state");
		}
	}
	
	void setProbe2StatusState(int state) {
	
		logger.info("state from probe 2 status: " + state);
		
		if (state == 0) {
			probe2StatusColor.clear();
		} else if (state == 1) {
			probe2StatusColor.clear();
			probe2StatusColor.setWarning(true);
		} else if (state == 2) {
			logger.info("STATE 2 from probe 2 status: " + state);
			probe2StatusColor.clear();
			probe2StatusColor.setError(true);
		} else {
			logger.info("not a valid state");
		}
	}
	
	void setProbe3StatusState(int state) {
	
		logger.info("state from probe 3 status: " + state);
		
		if (state == 0) {
			probe3StatusColor.clear();
		} else if (state == 1) {
			probe3StatusColor.clear();
			probe3StatusColor.setWarning(true);
		} else if (state == 2) {
			probe3StatusColor.clear();
			probe3StatusColor.setError(true);
		} else {
			logger.info("not a valid state");
		}
	}
	
	void setProbe4StatusState(int state) {
	
		logger.info("state from probe 4 status: " + state);
		
		if (state == 0) {
			probe4StatusColor.clear();
		} else if (state == 1) {
			probe4StatusColor.clear();
			probe4StatusColor.setWarning(true);
		} else if (state == 2) {
			probe4StatusColor.clear();
			probe4StatusColor.setError(true);
		} else {
			logger.info("not a valid state");
		}
	}
	
	void setBWStatusState(int state) {
	
		logger.info("state from BW status: " + state);
		
		if (state == 0) {
			bwStatusColor.clear();
		} else if (state == 1) {
			bwStatusColor.clear();
			bwStatusColor.setWarning(true);
		} else if (state == 2) {
			bwStatusColor.clear();
			bwStatusColor.setError(true);
		} else {
			logger.info("not a valid state");
		}
	}
	
	void setDepthStatusState(int state) {
	
		logger.info("state from depth status: " + state);
		
		if (state == 0) {
			depthStatusColor.clear();
		} else if (state == 1) {
			depthStatusColor.clear();
			depthStatusColor.setWarning(true);
		} else if (state == 2) {
			depthStatusColor.clear();
			depthStatusColor.setError(true);
		} else {
			logger.info("not a valid state");
		}
	}
	
	void setTiltStatusState(int state) {
	
		logger.info("state from tilt status: " + state);
		
		if (state == 0) {
			tiltStatusColor.clear();
		} else if (state == 1) {
			tiltStatusColor.clear();
			tiltStatusColor.setWarning(true);
		} else if (state == 2) {
			tiltStatusColor.clear();
			tiltStatusColor.setError(true);
		} else {
			logger.info("not a valid state");
		}
	}
	
	void setBatteryStatusState(int state) {
	
		logger.info("state from battery status: " + state);
		
		if (state == 0) {
			batteryStatusColor.clear();
		} else if (state == 1) {
			batteryStatusColor.clear();
			batteryStatusColor.setWarning(true);
		} else if (state == 2) {
			batteryStatusColor.clear();
			batteryStatusColor.setError(true);
		} else {
			logger.info("not a valid state");
		}
	}
	
	void setProbe1GradientStatusState(int state) {
		
		if (state == 0) {
			probe1GradientStatusColor.clear();
		} else if (state == 1) {
			probe1GradientStatusColor.clear();
			probe1GradientStatusColor.setWarning(true);
		} else if (state == 2) {
			probe1GradientStatusColor.clear();
			probe1GradientStatusColor.setError(true);
		} else {
			logger.info("not a valid state");
		}
	}
	
	void setProbe2GradientStatusState(int state) {
		
		if (state == 0) {
			probe2GradientStatusColor.clear();
		} else if (state == 1) {
			probe2GradientStatusColor.clear();
			probe2GradientStatusColor.setWarning(true);
		} else if (state == 2) {
			probe2GradientStatusColor.clear();
			probe2GradientStatusColor.setError(true);
		} else {
			logger.info("not a valid state");
		}
	}
	
	void setProbe3GradientStatusStatus(int state) {
		
		if (state == 0) {
			probe3GradientStatusColor.clear();
		} else if (state == 1) {
			probe3GradientStatusColor.clear();
			probe3GradientStatusColor.setWarning(true);
		} else if (state == 2) {
			probe3GradientStatusColor.clear();
			probe3GradientStatusColor.setError(true);
		} else {
			logger.info("not a valid state");
		}
	}
	
	void setProbe4GradientStatusStatus(int state) {
		
		if (state == 0) {
			probe4GradientStatusColor.clear();
		} else if (state == 1) {
			probe4GradientStatusColor.clear();
			probe4GradientStatusColor.setWarning(true);
		} else if (state == 2) {
			probe4GradientStatusColor.clear();
			probe4GradientStatusColor.setError(true);
		} else {
			logger.info("not a valid state");
		}
	}
	
	public void loadTooltips() {
	
		tooltips = new Vector<String>();
	
		tooltips.add("<html>Record Number</html>");
		tooltips.add("<html>Time Interval Between Readings (seconds)</html>");
		tooltips.add("<html>Temperature of Probe 1 (Celsius)</html>");
		tooltips.add("<html>Temperature of Probe 2 (Celsius)</html>");
		tooltips.add("<html>Temperature of Probe 3 (Celsius)</html>");
		tooltips.add("<html>Temperature of Probe 4 (Celsius)</html>");
		tooltips.add("<html>Temperature of Bottom Water (Celsius)</html>");
		tooltips.add("<html>Depth of Probe (meters)</html>"); 
		tooltips.add("<html>Tilt from Vertical (degrees)</html>"); 
		tooltips.add("<html>Battery Voltage (volts)</html>");
		tooltips.add("<html>Gradient across full interval from deepest to shallowest telemetered data (&#176;C/m)</html>");
		tooltips.add("<html>Gradient of upper interval (&#176;C/m)</html>");
		tooltips.add("<html>Gradient of middle interval (&#176;C/m)</html>");
		tooltips.add("<html>Gradient of lower interval (&#176;C/m)</html>");    
	}
	
    public void setProbeStates() {
    
    	setProbe1StatusState(DataStates.getProbe1TempStatus());
		setProbe2StatusState(DataStates.getProbe2TempStatus());
		setProbe3StatusState(DataStates.getProbe3TempStatus());
		setProbe4StatusState(DataStates.getProbe4TempStatus());
		setBWStatusState(DataStates.getBaseTempStatus());
		setDepthStatusState(DataStates.getDepthStatus());
		setTiltStatusState(DataStates.getTiltStatus());
		setBatteryStatusState(DataStates.getBatteryStatus());
	}
    
    public void clearData() {
    
    	rowNum = 0;
    	
		tableModel.setRowCount(0); // This will remove all data from the model
		
		table.repaint();
    } 
    
    public void updateTable() {
    
    	setProbeStates();
    	
    	table.repaint();
    	table.invalidate();
		jscrollPane.repaint();
    }      
    
	public void changeColumnName() {
	
		logger.info("resetting the column names for the status panel");
	
		JTableHeader header = table.getTableHeader();
		TableColumnModel colMod = header.getColumnModel();
		
		logger.info("column 1: " + HeatProbeNames.getProbe1Name() );
		logger.info("column 2: " + HeatProbeNames.getProbe2Name() );
		logger.info("column 3: " + HeatProbeNames.getProbe3Name() );
		logger.info("column 4: " + HeatProbeNames.getProbe4Name() );
		
		TableColumn tabCol = colMod.getColumn(2);
		tabCol.setHeaderValue(" " + HeatProbeNames.getProbe1Name() + " (C)");
		
		tabCol = colMod.getColumn(3);
		tabCol.setHeaderValue(" " + HeatProbeNames.getProbe2Name() + " (C)");
		
		tabCol = colMod.getColumn(4);
		tabCol.setHeaderValue(" " + HeatProbeNames.getProbe3Name() + " (C)");
		
		tabCol = colMod.getColumn(5);
		tabCol.setHeaderValue(" " + HeatProbeNames.getProbe4Name() + " (C)");
		
		/*
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
 
 		System.out.println("header columns: " + table.getColumnCount() );
		for (int column = 0; column < table.getColumnCount(); column++) {
    		TableColumn tableColumn = colMod.getColumn(column);
    		int preferredWidth = tableColumn.getMinWidth();
    		System.out.println("preferredWidth: " + preferredWidth);
    		int maxWidth = tableColumn.getMaxWidth();
    		
    		for (int row = 0; row < table.getRowCount(); row++) {
        		TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
        		Component c = table.prepareRenderer(cellRenderer, row, column);
        		int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
        		preferredWidth = Math.max(preferredWidth, width);
 
        		//  We've exceeded the maximum width, no need to check other rows
 
        		if (preferredWidth >= maxWidth)
        		{
            		preferredWidth = maxWidth;
            		break;
        		}
    		}
 
    		tableColumn.setPreferredWidth( preferredWidth );
		}
		*/
		
		header.repaint();
	}
	
	public void setScrollTableEnable(boolean scrollTableEnable) {
  		this.scrollTableEnable = scrollTableEnable;
  	}
  
  	public boolean getScrollTableEnable() {
  		return scrollTableEnable;
  	}
	
}

class ColumnHeaderToolTips extends MouseMotionAdapter {
  TableColumn curCol;
  
  Map tips = new HashMap();
  
  public void setToolTip(TableColumn col, String tooltip) {
    if (tooltip == null) {
      tips.remove(col);
    } else {
      tips.put(col, tooltip);
    }
  }
  
public void mouseMoved(MouseEvent evt) {
    JTableHeader header = (JTableHeader) evt.getSource();
    JTable table = header.getTable();
    TableColumnModel colModel = table.getColumnModel();
    int vColIndex = colModel.getColumnIndexAtX(evt.getX());
    TableColumn col = null;
    if (vColIndex >= 0) {
      col = colModel.getColumn(vColIndex);
    }
    if (col != curCol) {
      header.setToolTipText((String) tips.get(col));
      curCol = col;
    }
  }
  
}
