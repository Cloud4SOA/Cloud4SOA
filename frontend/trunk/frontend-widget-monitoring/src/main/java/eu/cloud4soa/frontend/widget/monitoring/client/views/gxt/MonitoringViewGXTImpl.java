/*
 * This file is part of Cloud4SOA Frontend.
 *
 *     Cloud4SOA Frontend is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cloud4SOA Frontend is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cloud4SOA Frontend.  If not, see <http://www.gnu.org/licenses/>.
 */

package eu.cloud4soa.frontend.widget.monitoring.client.views.gxt;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.ui.client.Style.ButtonScale;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.IconAlign;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.DatePickerEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.ToggleButton;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FieldSet;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.Time;
import com.extjs.gxt.ui.client.widget.form.TimeField;
import com.extjs.gxt.ui.client.widget.layout.ColumnData;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.regexp.shared.MatchResult;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.monitoring.IMonitoringStatistic;
import eu.cloud4soa.frontend.commons.client.dialog.DialogHelper;
import eu.cloud4soa.frontend.commons.client.resources.Icons;
import eu.cloud4soa.frontend.widget.monitoring.client.activities.MonitoringActivity;
import eu.cloud4soa.frontend.widget.monitoring.client.views.MonitoringView;
import eu.cloud4soa.frontend.widget.monitoring.client.views.gxt.charts.ChartImpl;
import eu.cloud4soa.frontend.widget.monitoring.client.views.gxt.charts.ChartPoint;
import eu.cloud4soa.frontend.widget.monitoring.client.views.gxt.charts.ResponseCodePieChart;

public class MonitoringViewGXTImpl extends LayoutContainer implements
		MonitoringView {
	private ChartImpl chartInstance;
	private List<ApplicationModel> monitoredApplications;
	private LabelField lbShowRTStats;
	private Presenter presenter;
	private ToggleButton btnShowMonitoringStats;

	private Map<String, Html> htmlName;
	private Map<String, Html> htmlStatus;
	private Map<String, Html> htmlProvider;
	private Map<String, Html> htmlArchive;
	private Map<String, Html> htmlVersion;
	private Map<String, Html> htmlSize;
	private Map<String, Html> htmlUrl;

	private DateField dfStartDate;
	private DateField dfEndDate;
	private TimeField tfStartTime;
	private TimeField tfEndTime;

	private Chart chartRT;
	// private Chart chartRC;
	private String urlChart;
	private LayoutContainer graphRT;
	private LayoutContainer graphRC;
	private TabPanel tabPanel;
	private TabItem tIApplication;
	private TabItem tIResponseTime;
	private TabItem tIResponseCode;

	private final String SHOW_MONITORING_STATS_COMMAND = "Show Monitoring Statistics";
	private final String STOP_SHOW_MONITORING_STATS_COMMAND = "Stop showing RT Monitoring Stats";
	private final String SHOWING_RT_MONITORING_STATS_LABEL = "Showing Realtime Monitoring Statistics";

	public MonitoringViewGXTImpl() {
	}

	public MonitoringViewGXTImpl(MonitoringActivity presenter,
			List<ApplicationModel> apps) {
		this.monitoredApplications = apps;
		this.presenter = presenter;
		initializeWidget(false);
	}

	@Override
	public void initializeWidget(boolean alreadyMonitored) {
		if (alreadyMonitored && monitoredApplications != null
				&& areApplicationsRunning()) {
			updateView();
			layout();
		} else {
			removeAll();
			createView();
			layout();
		}
	}

	private boolean areApplicationsRunning() {
		boolean result = true;
		for (ApplicationModel app : monitoredApplications) {
			if (app.get(ApplicationModel.STATUS).equals(
					ApplicationModel.STATUS_OFFLINE)) {
				result = false;
				break;
			}
		}

		return result;
	}

	private void updateView() {
		// Change button according to application status.
		if (!areApplicationsRunning()) {
			lbShowRTStats.setText("");
			btnShowMonitoringStats.setText(SHOW_MONITORING_STATS_COMMAND);
		}

		for (ApplicationModel app : monitoredApplications) {
			htmlName.get(app.getKey()).setHtml(
					"<b>Name:</b> &nbsp; " + getApplicationName(app));
			htmlStatus.get(app.getKey()).setHtml(
					"<b>Status:</b> &nbsp; " + getApplicationStatus(app));
			htmlProvider.get(app.getKey()).setHtml(
					"<b>Provider:</b> &nbsp; " + getProvider(app));
			htmlArchive.get(app.getKey()).setHtml(
					"<b>Archive:</b> &nbsp; " + getApplicationArchive(app));
			htmlVersion.get(app.getKey()).setHtml(
					"<b>Version:</b> &nbsp; " + getApplicationVersion(app));
			htmlSize.get(app.getKey()).setHtml(
					"<b>Version:</b> &nbsp; " + getApplicationSize(app));
			htmlUrl.get(app.getKey()).setHtml(
					"<b>URL:</b> &nbsp; <a href=\""
							+ getApplicationDeploymentIp(app)
							+ "\" target=\"_blank\">"
							+ getApplicationDeploymentIp(app) + "</a>");
		}
		// if application is stopped, clean monitored statistics
		if (!areApplicationsRunning()) {
			graphRT.removeAll();
			graphRC.removeAll();
		}

		// Enabling buttons and fields if application null or stopped
		if (areApplicationsRunning()) { // Enabling buttons and fields if
										// application is started
			btnShowMonitoringStats.setEnabled(true);

			dfStartDate.setEnabled(true);
			dfEndDate.setEnabled(true);
			tfStartTime.setEnabled(true);
			tfEndTime.setEnabled(true);
		}
	}

	private void createView() {
		htmlName = new HashMap<String, Html>();
		htmlStatus = new HashMap<String, Html>();
		htmlProvider = new HashMap<String, Html>();
		htmlArchive = new HashMap<String, Html>();
		htmlVersion = new HashMap<String, Html>();
		htmlSize = new HashMap<String, Html>();
		htmlUrl = new HashMap<String, Html>();

		// setHeight("600");
		setLayout(new FitLayout());

		ContentPanel cp = new ContentPanel();
		cp.setHeading("Monitoring selected applications");
		cp.addStyleName("c4s-white-bg");
		cp.setHeaderVisible(true);
		cp.setCollapsible(false);
		cp.setBorders(true);
		cp.setLayout(new FitLayout());
		// cp.setScrollMode(Scroll.AUTOY);
		// cp.setHeight("600");
		add(cp);

		// Button bar
		ToolBar toolBar = new ToolBar();
		toolBar.addStyleName("c4s-white-bg");
		toolBar.setAlignment(HorizontalAlignment.LEFT);
		toolBar.setBorders(false);

		btnShowMonitoringStats = new ToggleButton(SHOW_MONITORING_STATS_COMMAND);
		btnShowMonitoringStats.setScale(ButtonScale.LARGE);
		btnShowMonitoringStats.setIconAlign(IconAlign.BOTTOM);
		btnShowMonitoringStats.setIcon(AbstractImagePrototype
				.create(Icons.RESOURCES.buttonOscilloscope()));
		toolBar.add(btnShowMonitoringStats);

		lbShowRTStats = new LabelField("");
		lbShowRTStats.addInputStyleName("rtMonitoring");
		// lbShowRTStats.setLabelStyle("font-weight:bold;color:red");
		toolBar.add(new FillToolItem());
		toolBar.add(lbShowRTStats);

		btnShowMonitoringStats
				.addSelectionListener(new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
						Info.display("Button selected",
								"btnShowMonitoringStats");
						activateMonitoring(true);
					}
				});

		cp.setTopComponent(toolBar);

		// Main Monitoring panel
		final LayoutContainer lc = new LayoutContainer();
		lc.setLayout(new FlowLayout(5));

		// FIXME FieldSets can not be collapse, otherwise their content is not
		// visible.
		// Check to collapse these fields once the view has been rendered, by
		// capturing the corresponding event
		// fsApplicationInfoSection.collapse();

		// Time frame section
		lc.add(getTimeFrameSection());

		// Disabling buttons and fields if one application null or stopped
		if (monitoredApplications == null || !areApplicationsRunning()) { // Disabling
																			// buttons
																			// and
																			// fields
																			// if
																			// application
																			// is
																			// not
																			// provided
																			// or
																			// stopped
			btnShowMonitoringStats.setEnabled(false);
			btnShowMonitoringStats.setText("Show Monitoring Statistics");

			dfStartDate.setEnabled(false);
			dfEndDate.setEnabled(false);
			tfStartTime.setEnabled(false);
			tfEndTime.setEnabled(false);
		}

		// Tab Panel section
		tabPanel = new TabPanel();
		// tabPanel.setHeight(200);
		tabPanel.setAutoHeight(true);

		tIApplication = new TabItem("Selected Applications");
		tIApplication.setLayoutOnChange(true);
		tIApplication.setBorders(false);
		tIApplication.addListener(Events.Select,
				new Listener<ComponentEvent>() {
					@Override
					public void handleEvent(ComponentEvent be) {
						lc.layout();
					}
				});
		tIApplication.add(getSelectedApplicationsView(), new FitData(5));
		tabPanel.add(tIApplication);

		tIResponseTime = new TabItem("Response Time");
		tIResponseTime.setLayoutOnChange(true);
		tIResponseTime.addListener(Events.Select,
				new Listener<ComponentEvent>() {
					@Override
					public void handleEvent(ComponentEvent be) {
						lc.layout();
					}
				});
		tIResponseTime.add(getResponseTimeView(), new FitData(5));
		tabPanel.add(tIResponseTime);

		tIResponseCode = new TabItem("Response Code");
		tIResponseCode.setLayoutOnChange(true);
		tIResponseCode.addListener(Events.Select,
				new Listener<ComponentEvent>() {
					@Override
					public void handleEvent(ComponentEvent be) {
						lc.layout();
					}
				});
		tIResponseCode.add(getResponseCodeView(), new FitData(5));
		tabPanel.add(tIResponseCode);

		lc.add(tabPanel);

		cp.add(lc);
	}

	private LayoutContainer getResponseTimeView() {

		graphRT = new LayoutContainer();
		graphRT.setLayout(new FitLayout());
		graphRT.setScrollMode(Scroll.AUTOY);
		graphRT.setHeight(200);
		graphRT.setBorders(true);

		urlChart = !isExplorer() ? "../../" : "";
		urlChart += "resources/chart/open-flash-chart.swf";
		GWT.log("Chart URL: " + urlChart);
		// chart = new Chart(urlChart);

		// List<ChartPoint> values = getChartValues();
		// List<ChartPoint> values = new ArrayList<ChartPoint>();
		// chart.setChartModel(chartInstance.getChartModel("Response Time",
		// values));

		// rtGraph.add(chart);
		// chart.setHeight("200");

		// rtGraph.setHeight("");

		return graphRT;
	}

	private LayoutContainer getResponseCodeView() {
		// TODO Render a table of response codes for every selected application
		graphRC = new LayoutContainer();
		graphRC.setLayout(new RowLayout(Orientation.HORIZONTAL));
		graphRC.setHeight(200);
		graphRC.setScrollMode(Scroll.AUTOX);
		graphRC.setBorders(true);

		return graphRC;
	}

	private FieldSet getTimeFrameSection() {
		// Time frame section
		FieldSet fsTimeFrame = new FieldSet();
		fsTimeFrame.setLayout(new FlowLayout());
		fsTimeFrame.setHeading("Monitoring date/time frame");
		fsTimeFrame.setCollapsible(true);

		LayoutContainer rtForm = new LayoutContainer();
		fsTimeFrame.add(rtForm);
		rtForm.setLayout(new ColumnLayout());

		HorizontalPanel hp1 = new HorizontalPanel();

		VerticalPanel vp1 = new VerticalPanel();
		hp1.add(vp1);
		vp1.setSpacing(0);

		LabelField lfStartDate = new LabelField("Initial Date:");
		vp1.add(lfStartDate);

		LabelField lfEndDate = new LabelField("Final Date:");
		vp1.add(lfEndDate);

		VerticalPanel vp2 = new VerticalPanel();
		hp1.add(vp2);
		vp2.setSpacing(2);

		dfStartDate = new DateField();
		dfStartDate.getDatePicker().addListener(Events.Select,
				new Listener<DatePickerEvent>() {
					@Override
					public void handleEvent(DatePickerEvent e) {
						Info.display("Selected Initial date", e.getDate()
								.toString());
					}
				});

		vp2.add(dfStartDate);
		dfStartDate.setFieldLabel("Start Time");

		dfEndDate = new DateField();
		dfEndDate.getDatePicker().addListener(Events.Select,
				new Listener<DatePickerEvent>() {
					@Override
					public void handleEvent(DatePickerEvent e) {
						Info.display("Selected Final date", e.getDate()
								.toString());
					}
				});
		vp2.add(dfEndDate);
		dfEndDate.setFieldLabel("Final time");
		rtForm.add(hp1, new ColumnData(.5));

		HorizontalPanel hp2 = new HorizontalPanel();

		VerticalPanel vp3 = new VerticalPanel();
		hp2.add(vp3);
		vp3.setSpacing(0);

		LabelField lfStartTime = new LabelField("Initial Time:");
		vp3.add(lfStartTime);
		lfStartTime.setName("lfStartTime");

		LabelField lfEndTime = new LabelField("Final Time:");
		vp3.add(lfEndTime);

		VerticalPanel vp4 = new VerticalPanel();
		hp2.add(vp4);
		vp4.setSpacing(2);

		tfStartTime = new TimeField();
		tfStartTime.setForceSelection(false); // Still not working this issue
		tfStartTime
				.addSelectionChangedListener(new SelectionChangedListener<Time>() {
					@Override
					public void selectionChanged(SelectionChangedEvent<Time> se) {
						Info.display("Selected Initial time", se
								.getSelectedItem().getText());
					}
				});

		vp4.add(tfStartTime);
		tfStartTime.setFieldLabel("New TimeField");

		tfEndTime = new TimeField();
		tfEndTime.setForceSelection(false); // Still not working this issue
		tfEndTime
				.addSelectionChangedListener(new SelectionChangedListener<Time>() {
					@Override
					public void selectionChanged(SelectionChangedEvent<Time> se) {
						Info.display("Selected Initial time", se
								.getSelectedItem().getText());
					}
				});
		vp4.add(tfEndTime);
		tfEndTime.setFieldLabel("New TimeField");
		rtForm.add(hp2, new ColumnData(.5));

		return fsTimeFrame;
	}

	private LayoutContainer getSelectedApplicationsView() {
		LayoutContainer lc = new LayoutContainer();
		lc.setBorders(false);
		RowLayout layout = new RowLayout(Orientation.VERTICAL);
		lc.setHeight(200);
		lc.setScrollMode(Scroll.AUTOY);
		lc.setLayout(layout);
		if (monitoredApplications != null) {
			for (ApplicationModel app : monitoredApplications) {
				lc.add(getApplicationInformationFieldSet(app), new RowData(
						0.95, -1, new Margins(10)));
			}
		}
		return lc;
	}

	private FieldSet getApplicationInformationFieldSet(ApplicationModel app) {
		FieldSet fsApplicationInfo = new FieldSet();
		fsApplicationInfo.setBorders(true);
		fsApplicationInfo.setLayout(new ColumnLayout());
		fsApplicationInfo.setHeading(getApplicationName(app) + " Information");
		fsApplicationInfo.setCollapsible(true);

		Html html;

		html = new Html("&nbsp;<b>Name:</b> &nbsp; " + getApplicationName(app));
		htmlName.put(app.getKey(), html);
		fsApplicationInfo.add(html, new ColumnData(0.45));

		html = new Html("&nbsp;<b>Status:</b> &nbsp; "
				+ getApplicationStatus(app));
		htmlStatus.put(app.getKey(), html);
		fsApplicationInfo.add(html, new ColumnData(0.45));

		html = new Html("&nbsp;<b>Provider:</b> &nbsp; " + getProvider(app));
		htmlProvider.put(app.getKey(), html);
		fsApplicationInfo.add(html, new ColumnData(0.45));

		html = new Html("&nbsp;<b>Archive:</b> &nbsp; "
				+ getApplicationArchive(app));
		htmlArchive.put(app.getKey(), html);
		fsApplicationInfo.add(html, new ColumnData(0.45));

		html = new Html("&nbsp;<b>Version:</b> &nbsp; "
				+ getApplicationVersion(app));
		htmlVersion.put(app.getKey(), html);
		fsApplicationInfo.add(html, new ColumnData(0.45));

		// html = new Html("&nbsp;<b>Size:</b> &nbsp; " +
		// getApplicationSize(app));
		// htmlSize.put(app.getKey(), html);
		// fsApplicationInfo.add(html, new ColumnData(0.45));

		html = new Html("&nbsp;<b>URL:</b> &nbsp; <a href=\""
				+ getApplicationDeploymentIp(app) + "\" target=\"_blank\">"
				+ getApplicationDeploymentIp(app) + "</a>");
		htmlUrl.put(app.getKey(), html);
		fsApplicationInfo.add(html, new ColumnData(0.45));

		return fsApplicationInfo;
	}

	private String getProvider(ApplicationModel app) {
		return app.<String> get(ApplicationModel.PAAS_PROVIDER) != null ? app
				.<String> get(ApplicationModel.PAAS_PROVIDER) : "-";
	}

	private String getApplicationDeploymentIp(ApplicationModel app) {
		return app.<String> get(ApplicationModel.DEPLOYMENT_URL) != null ? app
				.<String> get(ApplicationModel.DEPLOYMENT_URL) : "-";
	}

	private String getApplicationArchive(ApplicationModel app) {
		return app.<String> get(ApplicationModel.ARCHIVE) != null ? app
				.<String> get(ApplicationModel.ARCHIVE) : "-";
	}

	private String getApplicationStatus(ApplicationModel app) {
		return app.<String> get(ApplicationModel.STATUS) != null ? app
				.<String> get(ApplicationModel.STATUS) : "-";
	}

	private String getApplicationName(ApplicationModel app) {
		return app.<String> get(ApplicationModel.TITLE) != null ? app
				.<String> get(ApplicationModel.TITLE) : "-";
	}

	private String getApplicationVersion(ApplicationModel app) {
		return app.<String> get(ApplicationModel.VERSION) != null ? app
				.<String> get(ApplicationModel.VERSION) : "-";
	}

	private String getApplicationSize(ApplicationModel app) {
		String result = "-";
		MeasurementModel mm = app
				.<MeasurementModel> get(ApplicationModel.APPLICATION_SIZE);
		if (mm != null) {
			result = mm.getMeasureValue() + " " + mm.getMeasureUnit();
		}
		return result;
	}

	public static boolean isExplorer() {
		String test = Window.Location.getPath();
		if (test.indexOf("pages") != -1) {
			return false;
		}
		return true;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;

	}

	@Override
	public void monitorApplications(List<ApplicationModel> app,
			boolean alreadyMonitored) {
		this.monitoredApplications = app;
		initializeWidget(alreadyMonitored);
	}

	@Override
	public void renderMonitoringData(List<ApplicationModel> apps,
			Map<String, List<IMonitoringStatistic>> stats) {

		// Guard Check monitoring stats
		boolean emptyStats = true;
		for (List<IMonitoringStatistic> stat : stats.values()) {
			if (!stat.isEmpty()) {
				emptyStats = false;
				break;
			}
		}
		if (emptyStats) {
			DialogHelper
					.showErrorDialog("There are not statistics for selected applications and date/time frame");
			graphRT.removeAll();
			graphRC.removeAll();
			return;
		}

		// Guard Remove empty statistics (there are some statistics)
		Map<String, List<IMonitoringStatistic>> statistics = new HashMap<String, List<IMonitoringStatistic>>();
		List<ApplicationModel> applications = new ArrayList<ApplicationModel>();
		int i = 0;
		for (String appId : stats.keySet()) {
			if (!stats.get(appId).isEmpty()) {
				statistics.put(appId, stats.get(appId));
				applications.add(getApplicationById(apps, appId));
			} else {
				DialogHelper
						.showErrorDialog("There are not monitoring statistics for application "
								+ getApplicationById(apps, appId).getTitle());
			}
			i++;
		}

		// Render Response time graph
		renderResponseTimeChart(applications, statistics);

		// Display Response code
		renderResponseCodeChart(applications, statistics);

		layout();
	}

	private void renderResponseCodeChart(List<ApplicationModel> applications,
			Map<String, List<IMonitoringStatistic>> statistics) {

		graphRC.removeAll();

		for (ApplicationModel app : applications) {
			Chart chartRC = new Chart(urlChart);
			chartRC.setHeight("200");
			ResponseCodePieChart pieChart = new ResponseCodePieChart(
					app.getTitle(), statistics.get(app.getKey()));
			chartRC.setChartModel(pieChart.getChartModel(app.getTitle()));

			graphRC.add(chartRC, new RowData(0.4, 1, new Margins(0)));
		}

	}

	private void renderResponseTimeChart(List<ApplicationModel> applications,
			Map<String, List<IMonitoringStatistic>> statistics) {
		chartRT = new Chart(urlChart);
		chartRT.setHeight("200");

		// ----------------------
		final int MAX_NUMBER_XAXIS_LABELS = 5;
		final int MAX_NUMBER_YAXIS_LABELS = 5;
		chartInstance = new ChartImpl(
				"Response Time for selected applications(ms)",
				presenter.getMaxNumberMonitoringDisplayableValues());
		List<List<ChartPoint>> chartValues = chartInstance.setCharModelAxes(
				statistics, MAX_NUMBER_XAXIS_LABELS, MAX_NUMBER_YAXIS_LABELS);
		int i = 0;
		for (List<ChartPoint> values : chartValues) {
			String label = applications.get(i).getTitle() + " ["
					+ applications.get(i).get(ApplicationModel.PAAS_PROVIDER)
					+ "]";
			chartInstance.addLineChart(values, chartInstance.getColorCodes(i),
					label);
			i++;
		}
		chartRT.setChartModel(chartInstance.getChartModel());

		// ----------------------

		graphRT.removeAll();
		graphRT.add(chartRT);
	}

	/**
	 * @param applications
	 * @param appId
	 * @return
	 */
	private ApplicationModel getApplicationById(
			List<ApplicationModel> applications, String appId) {
		for (ApplicationModel app : applications) {
			if (app.getKey().equals(appId))
				return app;
		}
		return null;
	}

	@Override
	public void activateMonitoring(boolean monitoringActivated) {
		if (btnShowMonitoringStats.getText().equals(
				SHOW_MONITORING_STATS_COMMAND)) {
			// Get initial and end date/time and start displaying the monitoring
			// data:
			// Visualise response time in graph,
			// If initial/end date/time not set, display realtime data. Trigger
			// a Timer to refresh data (done in MonitoringActivity)
			Date startDate = dfStartDate.getValue();
			Date endDate = dfEndDate.getValue();
			Time startTime = tfStartTime.getValue();
			String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
			RegExp regExp = RegExp.compile(TIME24HOURS_PATTERN);
			boolean error = false;
			String errorMsg = "";

			if (startTime == null) {
				String sTime = tfStartTime.getRawValue();
				if (sTime != null && !sTime.equals("")) {
					MatchResult matcher = regExp.exec(sTime);
					if (matcher != null) {
						int hour = Integer.parseInt(sTime.substring(0,
								sTime.indexOf(":")));
						int minutes = Integer.parseInt(sTime.substring(
								sTime.indexOf(":") + 1, sTime.length()));
						// Parser sTime raw value
						startTime = new Time(hour, minutes);
					} else {
						error = true;
						errorMsg = "Wrong initial time format";
					}
				}
			}
			Time endTime = tfEndTime.getValue();
			if (endTime == null) {
				String eTime = tfEndTime.getRawValue();
				if (eTime != null && !eTime.equals("")) {
					MatchResult matcher = regExp.exec(eTime);
					if (matcher != null) {
						int hour = Integer.parseInt(eTime.substring(0,
								eTime.indexOf(":")));
						int minutes = Integer.parseInt(eTime.substring(
								eTime.indexOf(":") + 1, eTime.length()));
						// Parser sTime raw value
						endTime = new Time(hour, minutes);
					} else {
						error = true;
						errorMsg = "Wrong final time format";
					}
				}
			}

			// Checking dates
			// Valid inputs: final date and final time can be omitted (default
			// current date and time)
			if (endDate != null || startTime != null) {
				if (startDate == null) {
					error = true;
					errorMsg = "Initial date must be set";
				}
			}
			if (!error && endTime != null) {
				if (startTime == null) {
					error = true;
					errorMsg = "Initial time must be set";
				}
			}

			if (error) {
				DialogHelper.showErrorDialog(errorMsg);
				return;
			}

			if (startDate != null && endDate == null) {
				endDate = new Date(); // default value is current date/time
			}

			// After time/date checking. Setting empty times to default values
			// If both start or end time are not set, we set start time to 00:00
			// and end time to 23:59
			if (startDate != null || endDate != null) {
				if (startTime == null)
					startTime = new Time(0, 0);
				if (endTime == null)
					endTime = new Time(23, 59);
			}

			if (startTime != null) {
				// start.set(Calendar.HOUR_OF_DAY, startTime.getHour());
				// start.set(Calendar.MINUTE, startTime.getMinutes());
				startDate.setHours(startTime.getHour());
				startDate.setMinutes(startTime.getMinutes());
				endDate.setSeconds(0);
			}

			if (endTime != null) {
				// end.set(Calendar.HOUR_OF_DAY, endTime.getHour());
				// end.set(Calendar.MINUTE, endTime.getMinutes());
				endDate.setHours(endTime.getHour());
				endDate.setMinutes(endTime.getMinutes());
				endDate.setSeconds(0);
			}

			if (startDate == null || endDate == null) {
				// Don't allowed realtime monitoring on stopped applications
				if (!areApplicationsRunning()) {
					DialogHelper
							.showErrorDialog("Realtime monitoring not available on stopped applications");
				} else {
					Dialog dialog = DialogHelper.showConfirmationDialog(
							"Monitoring statistics",
							"Showing real time monitoring statistics");
					Listener<ButtonEvent> onOKEvent = new SelectionListener<ButtonEvent>() {
						@Override
						public void componentSelected(ButtonEvent ce) {
							// Change showing RT monitoring statistic status
							lbShowRTStats
									.setText(SHOWING_RT_MONITORING_STATS_LABEL);
							btnShowMonitoringStats
									.setText(STOP_SHOW_MONITORING_STATS_COMMAND);
							layout();
							presenter
									.getRTMonitoringStatistics(monitoredApplications); // Timer
																						// is
																						// activated
																						// by
																						// MonitoringActivity
																						// in
																						// this
																						// method
						}
					};
					dialog.getButtonById(Dialog.YES).addSelectionListener(
							(SelectionListener<ButtonEvent>) onOKEvent);
				}
			} else {
				// FIXME Not using java.util.Calendar since produce a GWT
				// compilation error.
				// Ignoring deprecated methods used to merge date and time
				// objects
				// Calendar start = Calendar.getInstance();
				// start.setTime(startDate);

				// Calendar end = Calendar.getInstance();
				// end.setTime(endDate);
				final Date eDate = endDate;
				final Date sDate = startDate;
				if (startDate.after(endDate)) {
					DialogHelper
							.showDialog("Error in Monitoring time frame",
									"Start date/time should precede the final date/time");
				} else {
					Dialog dialog = DialogHelper.showConfirmationDialog(
							"Monitoring statistics",
							"Showing monitoring statistics in time frame: ["
									+ startDate + ", " + endDate + "]");
					Listener<ButtonEvent> onOKEvent = new SelectionListener<ButtonEvent>() {
						@Override
						public void componentSelected(ButtonEvent ce) {
							presenter
									.getMonitoringStatisticsWhithinRangeLimited(
											monitoredApplications, sDate, eDate);
						}
					};
					dialog.getButtonById(Dialog.YES).addSelectionListener(
							(SelectionListener<ButtonEvent>) onOKEvent);
				}
			}

		} else if (btnShowMonitoringStats.getText().equals(
				STOP_SHOW_MONITORING_STATS_COMMAND)) {
			lbShowRTStats.setText("");
			btnShowMonitoringStats.setText(SHOW_MONITORING_STATS_COMMAND);
			// Stop RT monitoring
			presenter.stopRTMonitoring();
		}

	}

	@Override
	public void stoppedMonitoring() {
		lbShowRTStats.setText("");
		btnShowMonitoringStats.setText(SHOW_MONITORING_STATS_COMMAND);
	}

	@Override
	public void setMonitoredApplications(List<ApplicationModel> applications) {
		this.monitoredApplications = applications;
	}

}
