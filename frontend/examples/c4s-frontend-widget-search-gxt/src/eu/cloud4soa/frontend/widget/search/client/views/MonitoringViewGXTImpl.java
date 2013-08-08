package eu.cloud4soa.frontend.widget.search.client.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.extjs.gxt.samples.client.Examples;
import com.extjs.gxt.samples.client.examples.model.ChartModelExample;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.layout.TableRowLayout;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.FitData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.LayoutData;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.charts.client.model.Legend;
import com.extjs.gxt.charts.client.model.Legend.Position;
import com.extjs.gxt.charts.client.model.Text;
import com.extjs.gxt.charts.client.model.axis.XAxis;
import com.extjs.gxt.charts.client.model.axis.YAxis;
import com.extjs.gxt.charts.client.model.charts.AreaChart;
import com.extjs.gxt.charts.client.model.charts.LineChart;
import com.extjs.gxt.charts.client.model.charts.PieChart;
import com.extjs.gxt.ui.client.widget.DatePicker;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Random;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.BoxLayout.BoxLayoutPack;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout.HBoxLayoutAlign;
import com.google.gwt.user.client.ui.Image;
import com.extjs.gxt.ui.client.event.DatePickerEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;

import eu.cloud4soa.frontend.widget.search.client.charts.ChartPoint;
import eu.cloud4soa.frontend.widget.search.client.charts.IChart;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.form.TimeField;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.widget.form.Time;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;

public class MonitoringViewGXTImpl extends LayoutContainer {
	private ChartImpl chartInstance;
	private int numSegments = 10;
	private String application;
	private LabelField lfRecording;
	private Html recordingImage;
	
	private String[] htmlColorCodes = new String[]{
			"#2E2EFE", //Blue
			"#B40431", //Red
			"#0B3B0B", //Green
			"#6A0888", //Magenta
			"#2A1B0A", //Brown
			"#B404AE", //Pink
			"#000000", //Black
			"#088A85", //Sky blue
			"#5E610B", //Yellow green
			"#B43104"  //Orange
		};
	
	public MonitoringViewGXTImpl(String application) {
		this.application = application;
		
		initializeWidget();
	}


	private void initializeWidget() {
		setSize("600px", "600px");
		setLayout(new FitLayout());
		
		ContentPanel cp = new ContentPanel();
		cp.setHeading("Monitoring ... " + application);
		cp.setCollapsible(false);
		cp.setScrollMode(Scroll.AUTOY);
		add(cp);
		
		
		//Button bar
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.setAlignment(HorizontalAlignment.LEFT);
		buttonBar.setBorders(true);
		
		Button btnStartstopApp = new Button("Start/Stop App");
		btnStartstopApp.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				Info.display("Button selected", "Start/Stop App");
				
			}
		});
		buttonBar.add(btnStartstopApp);
		
		Button btnUndeployApp = new Button("Undeploy App");
		btnUndeployApp.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				Info.display("Button selected", "Undeploy App");
			}
		});
		buttonBar.add(btnUndeployApp);
		
		final Button btnStartstopMonitor = new Button("Start Monitor");
		btnStartstopMonitor.addSelectionListener(new SelectionListener<ButtonEvent>() {
			public void componentSelected(ButtonEvent ce) {
				Info.display("Button selected", "Start/Stop Monitor");
				if (btnStartstopMonitor.getText().contains("Start")){
					lfRecording.setText("recording");
					btnStartstopMonitor.setText("Stop Monitor");
					recordingImage.setHtml("<img src=\"recording.jpg\" />");
				}else{
					lfRecording.setText("Not recording");
					btnStartstopMonitor.setText("Start Monitor");
					recordingImage.setHtml("<img src=\"non-recording.jpg\" />");
				}
			}
		});
		buttonBar.add(btnStartstopMonitor);
				
		lfRecording = new LabelField("Not recording");
		buttonBar.add(lfRecording);
		
		recordingImage = new Html("<img src=\"non-recording.jpg\" />");
		buttonBar.add(recordingImage);		
		
		cp.setTopComponent(buttonBar);
		
		
		// Monitoring metrics
		LayoutContainer lc = new LayoutContainer();
		lc.setLayout(new FlowLayout(5));
		
		// Timeframe section
		FieldSet fsTimeframe = new FieldSet();
		fsTimeframe.setHeight(100);
		fsTimeframe.setHeading("Time frame:");
		fsTimeframe.setCollapsible(true);
		VBoxLayout vbl_fsTimeframe = new VBoxLayout();
		vbl_fsTimeframe.setVBoxLayoutAlign(VBoxLayoutAlign.STRETCHMAX);
		fsTimeframe.setLayout(vbl_fsTimeframe);
		
		lc.add(fsTimeframe);
		
		LayoutContainer rtForm = new LayoutContainer();
		fsTimeframe.add(rtForm);
		rtForm.setLayout(new ColumnLayout());
		
		HorizontalPanel hp1 = new HorizontalPanel();
		
		VerticalPanel vp1 = new VerticalPanel();
		hp1.add(vp1);
		vp1.setSpacing(3);
		
		LabelField lfStartDate = new LabelField("Initial Date:");
		vp1.add(lfStartDate);
		
		LabelField lfEndDate = new LabelField("Final Date:");
		vp1.add(lfEndDate);
		
		VerticalPanel vp2 = new VerticalPanel();
		hp1.add(vp2);
		vp2.setSpacing(3);
		
		DateField dfStartDate = new DateField();
		dfStartDate.getDatePicker().addListener(Events.Select, new Listener<DatePickerEvent>() {
			public void handleEvent(DatePickerEvent e) {
				Info.display("Selected Initial date", e.getDate().toString());
			}
		});
		
		vp2.add(dfStartDate);
//		dfStartDate.setFieldLabel("Start Time");
		
		DateField dfEndDate = new DateField();
		dfEndDate.getDatePicker().addListener(Events.Select, new Listener<DatePickerEvent>() {
			public void handleEvent(DatePickerEvent e) {
				Info.display("Selected Final date", e.getDate().toString());
			}
		});
		vp2.add(dfEndDate);
//		dfEndDate.setFieldLabel("Final time");
		rtForm.add(hp1, new ColumnData (.5));
		
		HorizontalPanel hp2 = new HorizontalPanel();
		
		VerticalPanel vp3 = new VerticalPanel();
		vp3.setWidth(75);
		hp2.add(vp3);
		vp3.setSpacing(3);
		
		LabelField lfStartTime = new LabelField("Initial Time:");
		vp3.add(lfStartTime);
//		lfStartTime.setName("lfStartTime");
		
		LabelField lfEndTime = new LabelField("Final Time:");
		vp3.add(lfEndTime);
		
		VerticalPanel vp4 = new VerticalPanel();
		hp2.add(vp4);
		vp4.setSpacing(3);
		
		TimeField tfStartTime = new TimeField();
		tfStartTime.addSelectionChangedListener(new SelectionChangedListener<Time>() {
			public void selectionChanged(SelectionChangedEvent<Time> se) {
				Info.display("Selected Initial time", se.getSelectedItem().getText());
			}
		});
		
		vp4.add(tfStartTime);
//		tfStartTime.setFieldLabel("New TimeField");
		
		TimeField tfEndTime = new TimeField();
		tfEndTime.addSelectionChangedListener(new SelectionChangedListener<Time>() {
			public void selectionChanged(SelectionChangedEvent<Time> se) {
				Info.display("Selected Initial time", se.getSelectedItem().getText());
			}
		});
		vp4.add(tfEndTime);
//		tfEndTime.setFieldLabel("New TimeField");
		rtForm.add(hp2, new ColumnData (.5));
		
		
		
		
		// Application information section
		FieldSet fsApplicationInfo = new FieldSet();
		fsApplicationInfo.setLayout(new ColumnLayout());
		fsApplicationInfo.setHeading(application + " Information");
		fsApplicationInfo.setCollapsible(true);
		
		Html name = new Html("<b>Name:</b> &nbsp; Application A");
		fsApplicationInfo.add(name, new ColumnData(0.45));
		
		Html status = new Html("<b>Status:</b> &nbsp; Alive");
		fsApplicationInfo.add(status, new ColumnData(0.45));
		
		Html archive = new Html("<b>Archive:</b> &nbsp; application.war");
		fsApplicationInfo.add(archive, new ColumnData(0.45));
		
		Html url = new Html("<b>URL:</b> &nbsp; <a href=\"http://www.application.org\" target=\"_blank\">http://www.application.org</a>");
		fsApplicationInfo.add(url, new ColumnData(0.45));
		
		Html provider = new Html("<b>Provider:</b> &nbsp; Google");
		fsApplicationInfo.add(provider, new ColumnData(0.45));
		
//		lc.add(fsApplicationInfo);
		
		// Application monitoring section
		FieldSet fsApplicationMonitoring = new FieldSet();
		fsApplicationMonitoring.setLayout(new FlowLayout());
		fsApplicationMonitoring.setHeading("Monitoring Parameters");
		fsApplicationMonitoring.setCollapsible(true);
		
		// Response time section
//		FieldSet fsResponseTime = new FieldSet();
//		fsResponseTime.setHeight(250);
//		fsResponseTime.setHeading("Response Time:");
//		fsResponseTime.setCollapsible(true);
//		VBoxLayout vbl_fsResponseTime = new VBoxLayout();
//		vbl_fsResponseTime.setVBoxLayoutAlign(VBoxLayoutAlign.STRETCHMAX);
//		fsResponseTime.setLayout(vbl_fsResponseTime);
		
		LayoutContainer rtGraph = new LayoutContainer();
		rtGraph.setLayout(new FitLayout());
		rtGraph.setBorders(true);
//		rtGraph.setStyleAttribute("bodyStyle", "'padding:20px;'");
		
		String urlChart = !Examples.isExplorer() ? "../../" : "";  
		urlChart += "resources/chart/open-flash-chart.swf"; 
		
		Chart chartRT = new Chart(urlChart);
		
		chartInstance = new ChartImpl("Response Time (ms)");
		List<List<ChartPoint>> chartValues = new ArrayList<List<ChartPoint>>();
		chartValues.add(getChartValues());
		chartValues.add(getChartValues());
		chartValues.add(getChartValues());
		chartValues.add(getChartValues());
		
		chartInstance.setCharModelAxes(chartValues, 10, 5);
		int i = 0;
		for (List<ChartPoint> values: chartValues){
			chartInstance.addLineChart(values, htmlColorCodes[i], "App " + i++);
		}
		chartRT.setChartModel(chartInstance.getChartModel());
		
		
		rtGraph.add(chartRT);
		chartRT.setHeight("200");
		
//		fsResponseTime.add(rtGraph);
		rtGraph.setHeight("");
		
//		fsApplicationMonitoring.add(fsResponseTime);
		
		//Response code
//		FieldSet fsResponseCode = new FieldSet();
//		fsResponseCode.setLayout(new FlowLayout(5));
//		fsResponseCode.setHeading("Response Code:");
//		fsResponseCode.setCollapsible(true);
		
		Chart chartRC = new Chart(urlChart);
		chartRC.setHeight("200");
		chartRC.setChartModel(new ResponseCodePieChart().getChartModel());
		
//		fsResponseCode.add(chartRC);
		
//		fsApplicationMonitoring.add(fsResponseCode);
		
//		lc.add(fsApplicationMonitoring);
		
		
		
		//Tab Panel section
		TabPanel tabPanel = new TabPanel();
		tabPanel.setWidth("100%");
		tabPanel.setAutoHeight(true);
		
		TabItem tIApplication = new TabItem("Selected Applications");  
//		tIApplication.addStyleName("pad-text"); 
		tIApplication.add(fsApplicationInfo, new FitData(5));
		tabPanel.add(tIApplication);  
	  
	    TabItem tIResponseTime = new TabItem("Response Time");  
//	    tIResponseTime.addStyleName("pad-text");  
	    tIResponseTime.add(rtGraph, new FitData(5));  
	    tabPanel.add(tIResponseTime);  
	    
	    TabItem tIResponseCode = new TabItem("Response Code");  
//	    tIResponseCode.addStyleName("pad-text");  
	    tIResponseCode.add(chartRC, new FitData(5));  
	    tabPanel.add(tIResponseCode);  
	    
	    lc.add(tabPanel);
	    
	    cp.add(lc);
	}
	
	class ResponseCodePieChart {  
	    public ChartModel getChartModel() {  
	      ChartModel cd = new ChartModel("Response Code", "font-size: 14px; font-family: Verdana;");  
	      cd.setBackgroundColour("#fffff0");  
	      PieChart pie = new PieChart();  
	      pie.setAlpha(0.5f);  
	      pie.setTooltip("#label#<br>#percent#");  
	      pie.setAnimate(false);  
	      pie.setAlphaHighlight(true);  
	      pie.setGradientFill(true);  
	      pie.setColours("#ff0000", "#00aa00");  
	      
	      String[] httpCodes = new String[]{"HTTP 200 OK", "HTTP 401 Unauthorized"};
	      int sections = 2;
	      
	      for (int n = 0; n < sections; n++) {  
	        pie.addSlices(new PieChart.Slice(Random.nextInt(100), httpCodes[n]));  
	      }  
	      
	      cd.addChartConfig(pie);  
	      return cd;  
	    }  
	  }  

	
	  private List<ChartPoint> getChartValues() {
		List<ChartPoint> values = new ArrayList<ChartPoint>();
		for (double i=0.2; i<=100; i+=1.1){
			values.add (new ChartPoint (i, Math.random()*2*i*i-Math.random()*3*i));
		}
		return values;
	}


	class ChartImpl implements IChart { 
		ChartModel cm;
		
	    public ChartImpl(String title) {  
	      cm = new ChartModel(title, "font-size: 12px; font-family: Verdana;");  
	      cm.setBackgroundColour("#ffffff");  	      
	      
	      //LEYEND
	      Legend legend = new Legend(Position.RIGHT, true);
	      legend.setPadding(10);
	      cm.setLegend(legend);
	      
	      
	    }
	    
	    public ChartModel getChartModel() {
			return cm;
		}

		public void setCharModelAxes (List<List<ChartPoint>> chartValues, int numberHorizontalLabels, int numberVerticalLabels){
	      //AXIS (Assumed all charts have the same horizontal values)
	      
	      XAxis xa = new XAxis();  
	      List<String> xAxisLabels = getXAxisLabels (chartValues.get(0), numberHorizontalLabels);
	      xa.setLabels(xAxisLabels);
	      xa.setSteps(numberHorizontalLabels);
	      
	      cm.setXAxis(xa);  
	      
	      
	      YAxis ya = new YAxis();  
	      List<String> yAxisLabels = getYAxisLabels (chartValues, numberVerticalLabels);
	      ya.setLabels(yAxisLabels);  
	      ya.setSteps(numberVerticalLabels);

	      
	      //Set Y axis range [min, max]
	      ya.setRange(getYMinForMultipleCharts (chartValues), getYMaxForMultipleCharts (chartValues));
	      
	      cm.setYAxis(ya);
	    }
	    
	    public void addLineChart(List<ChartPoint>values, String color, String label){
	    	LineChart graph = new LineChart();  
	    	graph.setText(label);
		    graph.setColour(color);  
		      
		    for (ChartPoint value: values) {  
		        graph.addValues(value.getY());  
		    }  
		    cm.addChartConfig(graph);  
	    }

	    private double getXMax(List<ChartPoint> values) {
	    	double max = values.get(0).getX();
			for (ChartPoint cp: values){
				if (cp.getX()>max)
					max = cp.getX();
			}
			return max;
		}
	    
	    private double getYMax(List<ChartPoint> values) {
	    	double max = values.get(0).getY();
			for (ChartPoint cp: values){
				if (cp.getY()>max)
					max = cp.getY();
			}
			return max;
		}
	    
	    private double getXMin(List<ChartPoint> values) {
	    	double min = values.get(0).getX();
			for (ChartPoint cp: values){
				if (cp.getX()<min)
					min = cp.getX();
			}
			return min;
		}
	    
	    private double getYMin(List<ChartPoint> values) {
	    	double min = values.get(0).getY();
			for (ChartPoint cp: values){
				if (cp.getY()<min)
					min = cp.getY();
			}
			return min;
		}
	    
	    private double getYMinForMultipleCharts(List<List<ChartPoint>> values) {
	    	double result = Double.POSITIVE_INFINITY;
	    	for (List<ChartPoint> vals: values){
	    		double min = getYMin (vals);
	    		if (min < result)
	    			result = min;
	    	}
	    	return result;
		}
	    
	    private double getYMaxForMultipleCharts(List<List<ChartPoint>> values) {
	    	double result = Double.NEGATIVE_INFINITY;
	    	for (List<ChartPoint> vals: values){
	    		double max = getYMax (vals);
	    		if (max > result)
	    			result = max;
	    	}
	    	return result;
		}

		//Get always 10 labels regardless the number of points
		private List<String> getXAxisLabels(List<ChartPoint> values, int maxNumberLabels) {
			List<String> xValues = new ArrayList<String>();
			if (values.isEmpty())
				return xValues;
			
			NumberFormat fmt = NumberFormat.getFormat("###.#");
			
			int delta = values.size()/(maxNumberLabels-1);
			int i = 0;
			for (ChartPoint value: values){
				if (i%delta == 0)
					xValues.add(fmt.format(Math.round(value.getX())));
				else
					xValues.add("");
				i++;
			}
			return xValues;
		}
		
		private List<String> getYAxisLabels(List<List<ChartPoint>> values, int maxNumberLabels) {
			List<String> yValues = new ArrayList<String>();
			if (values.isEmpty())
				return yValues;
			
			double min = getYMinForMultipleCharts(values);
			double max = getYMaxForMultipleCharts(values);
			double delta = (max - min)/(maxNumberLabels-1);
			
			NumberFormat fmt = NumberFormat.getFormat("###.#");
			double label = min;
			while (label <= (max + delta)){
				yValues.add(fmt.format(Math.round(label)));
				label += delta;
			}
			
			return yValues;
		}
	}

}
