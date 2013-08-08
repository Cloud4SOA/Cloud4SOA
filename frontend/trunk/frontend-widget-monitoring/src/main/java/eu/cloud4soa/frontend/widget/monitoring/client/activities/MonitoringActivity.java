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

package eu.cloud4soa.frontend.widget.monitoring.client.activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.monitoring.IMonitoringStatistic;
import eu.cloud4soa.frontend.commons.client.dialog.DialogHelper;
import eu.cloud4soa.frontend.commons.client.events.MonitoringApplicationRequestedEvent;
import eu.cloud4soa.frontend.commons.client.services.soa.ApplicationDeploymentService;
import eu.cloud4soa.frontend.commons.client.services.soa.ApplicationDeploymentServiceAsync;
import eu.cloud4soa.frontend.commons.client.services.soa.MonitoringService;
import eu.cloud4soa.frontend.commons.client.services.soa.MonitoringServiceAsync;
import eu.cloud4soa.frontend.widget.monitoring.client.views.MonitoringView;

public class MonitoringActivity extends Cloud4SoaActivity implements
		MonitoringView.Presenter, EventHandler {

	// Services
	private MonitoringServiceAsync monitoringService = GWT
			.create(MonitoringService.class);
	private ApplicationDeploymentServiceAsync deployedappsService = GWT
			.create(ApplicationDeploymentService.class);

	// View
	private MonitoringView monitoringView;

	private List<ApplicationModel> applications;
	private MessageBox notificationBox;

	private Timer refreshTimer;

	// TODO Get these values by configuration
	private static final int REFRESH_INTERVAL = 10000; // ms
	public static final int MONITORING_MAX_NUM_DISPLAYABLE_VALUES = 50;
	public static final int MONITORING_MAX_NUM_REQUESTED_STATISTICS = 24 * 60 * 6; // one
																					// day
	public static final int RTCHART_STATISTICS_TIME_FRAME = 1000 * 60 * 5; // 5
																			// mins
																			// in
																			// miliseconds

	public MonitoringActivity(Cloud4SOAUIClientFactory clientFactory,
			List<ApplicationModel> applications) {
		super(null, clientFactory);
		this.applications = applications;

		initialize();
	}

	@Override
	public int getMaxNumberMonitoringDisplayableValues() {
		return MONITORING_MAX_NUM_DISPLAYABLE_VALUES;
	}

	private void initialize() {
		// No initialization tasks at the moment
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		this.monitoringView = GWT.create(MonitoringView.class);
		this.monitoringView.setPresenter(this);
		this.monitoringView.setMonitoredApplications(applications);
		this.monitoringView.initializeWidget(false);

		containerWidget.setWidget(this.monitoringView.asWidget());
		registerViewDetacher(monitoringView);
	}

	AsyncCallback<Map<String, List<IMonitoringStatistic>>> monitoringCallback = new AsyncCallback<Map<String, List<IMonitoringStatistic>>>() {

		@Override
		public void onFailure(Throwable caught) {
			// handleRPCFailure(caught);
			DialogHelper
					.showErrorDialog("There was an error collecting monitoring statistics on the selected applications"
							+ "\nPlease, contact site administrator");
			// Stop monitoring timer on any error
			if (refreshTimer != null)
				refreshTimer.cancel();
			// Notify the view
			monitoringView.stoppedMonitoring();
		}

		@Override
		public void onSuccess(Map<String, List<IMonitoringStatistic>> statistics) {
			GWT.log("Successfully collecting monitoring statistics for selected application");

			if (statistics.size() != 0) {
				GWT.log("Rendering monitoring data with interval: "
						+ REFRESH_INTERVAL + " ms");
				monitoringView.renderMonitoringData(applications, statistics);
			} else {// No valid statistics found
				DialogHelper.showDialog("Error", "Not valid statistics found");
			}
		}

	};

	@Override
	public void getRTMonitoringStatistics(
			final List<ApplicationModel> applications) {
		GWT.log("Getting monitoring statistics for selected applications"
				+ " with interval " + REFRESH_INTERVAL + " ms");

		// Cleaning up
		if (refreshTimer != null) {
			refreshTimer.cancel();
		}

		if (refreshTimer == null) {
			refreshTimer = new Timer() {
				@Override
				public void run() {
					getMonitoringStatistics(applications);
				}
			};
		}
		refreshTimer.scheduleRepeating(REFRESH_INTERVAL);
		getMonitoringStatistics(applications); // Immediate invocation
	}

	private void getMonitoringStatistics(
			final List<ApplicationModel> applications) {
		// Calculating RT time frame
		Date end = new Date();
		Date start = new Date();
		start.setTime(start.getTime() - RTCHART_STATISTICS_TIME_FRAME);
		List<String> applicationUriIds = new ArrayList<String>();
		for (ApplicationModel app : applications)
			applicationUriIds.add(app.getKey());
		monitoringService.getMonitoringStatisticsWhithinRangeLimited(
				applicationUriIds, start, end,
				MONITORING_MAX_NUM_REQUESTED_STATISTICS,
				MONITORING_MAX_NUM_DISPLAYABLE_VALUES, monitoringCallback);
	}

	@Override
	public void stopRTMonitoring() {
		GWT.log("Stopping RT monitoring statistics for monitored application");
		refreshTimer.cancel();
	}

	@Override
	public void getMonitoringStatisticsWhithinRangeLimited(
			List<ApplicationModel> applications, Date start, Date end) {
		GWT.log("Getting monitoring statistics for selected applications "
				+ " within dates: start= " + start.toString() + ", end= "
				+ end.toString() + ". Max results = "
				+ MONITORING_MAX_NUM_REQUESTED_STATISTICS);
		List<String> applicationUriIds = new ArrayList<String>();
		for (ApplicationModel app : applications)
			applicationUriIds.add(app.getKey());

		monitoringService.getMonitoringStatisticsWhithinRangeLimited(
				applicationUriIds, start, end,
				MONITORING_MAX_NUM_REQUESTED_STATISTICS,
				MONITORING_MAX_NUM_DISPLAYABLE_VALUES, monitoringCallback);
	}

	public void onMonitoringApplicationRequested(
			MonitoringApplicationRequestedEvent event) {
		applications = event.getApplications();
		boolean alreadyMonitored = event.isAlreadyMonitored();
		// Stopping refreshTimer if already monitored application is stopped
		if (alreadyMonitored && applications != null
				&& !areApplicationsRunning() || applications == null) {
			if (refreshTimer != null)
				refreshTimer.cancel();
		}
		monitoringView.monitorApplications(applications, alreadyMonitored);
	}

	private boolean areApplicationsRunning() {
		boolean result = true;
		for (ApplicationModel app : applications) {
			if (app.get(ApplicationModel.STATUS).equals(
					ApplicationModel.STATUS_OFFLINE)) {
				result = false;
				break;
			}
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.cloud4soa.frontend.commons.client.Disposable#dispose() Override
	 * this method to release resources allocated by this activity, when the
	 * place associated to this activity changes and the activity should be
	 * disposed of.
	 */
	@Override
	public void dispose() {
		if (refreshTimer != null)
			refreshTimer.cancel();
	}
}
