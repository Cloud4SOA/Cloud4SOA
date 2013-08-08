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
import java.util.List;

import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.data.LoadEvent;
import com.extjs.gxt.ui.client.event.LoadListener;
import com.extjs.gxt.ui.client.store.ListStore;
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
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAViolationModel;
import eu.cloud4soa.frontend.commons.client.dialog.DialogHelper;
import eu.cloud4soa.frontend.commons.client.events.MonitoringApplicationRequestedEvent;
import eu.cloud4soa.frontend.commons.client.events.SLAContractRequestedEvent;
import eu.cloud4soa.frontend.commons.client.events.SLAViolationsReceivedEvent;
import eu.cloud4soa.frontend.commons.client.events.SLAViolationsRequestedEvent;
import eu.cloud4soa.frontend.commons.client.events.UpdateDeployedApplicationsRequestedEvent;
import eu.cloud4soa.frontend.commons.client.events.UserLoggedOutEvent;
import eu.cloud4soa.frontend.commons.client.gxt.DeployedApplicationListStore;
import eu.cloud4soa.frontend.commons.client.services.soa.ApplicationDeploymentService;
import eu.cloud4soa.frontend.commons.client.services.soa.ApplicationDeploymentServiceAsync;
import eu.cloud4soa.frontend.widget.monitoring.client.views.ApplicationsDeployedView;
import eu.cloud4soa.frontend.widget.slamanagement.client.views.SLAContractView;

public class ApplicationsDeployedActivity extends Cloud4SoaActivity implements
		ApplicationsDeployedView.Presenter, EventHandler {

	private static final int REFRESH_INTERVAL = 60000; // ms
	private ApplicationsDeployedView deployedappsView;
	private Timer refreshTimer;
	private List<ApplicationModel> monitoredApplications;
	private MessageBox notificationBox;
	private SLAContractView slaContractView;

	// Services
	private ApplicationDeploymentServiceAsync deployedappsService = GWT
			.create(ApplicationDeploymentService.class);

	public ApplicationsDeployedActivity(Cloud4SOAUIClientFactory clientFactory) {
		super(null, clientFactory);
	}

	private void initialize() {

		retrieveDeployedApps();

		if (refreshTimer == null) {
			refreshTimer = new Timer() {
				@Override
				public void run() {
					retrieveDeployedApps();
				}
			};
		}
		refreshTimer.scheduleRepeating(REFRESH_INTERVAL);

		// Capturing logout to cancel timer that refresh the applications
		// deployed view
		addHandler(UserLoggedOutEvent.TYPE, new UserLoggedOutEvent.Handler() {
			@Override
			public void onUserLogout(UserLoggedOutEvent event) {
				if (refreshTimer != null)
					refreshTimer.cancel();
			}
		});


		// Refreshing the applications deployed view upon any change on the list
		// of deployed applications
		addHandler(UpdateDeployedApplicationsRequestedEvent.TYPE,
				new UpdateDeployedApplicationsRequestedEvent.Handler() {

					@Override
					public void onDeployedApplicationsUpdateRequested(
							UpdateDeployedApplicationsRequestedEvent event) {
						retrieveDeployedApps();
					}

				});
		
		// Refreshing the applications deployed view upon any change on the list
		// of deployed applications
		addHandler(SLAViolationsReceivedEvent.TYPE,
				new SLAViolationsReceivedEvent.Handler() {

					@Override
					public void onSLAViolationsReceived(SLAViolationsReceivedEvent s) {
						if (s.getViolations().size() != 0){
							checkApplicationStatus(s.getViolations());
						}
						
					}

				});


	}

	/**
	 * @param violations
	 */
	protected void checkApplicationStatus(List<SLAViolationModel> violations) {
		this.deployedappsView.checkApplicationStatus(violations);
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		this.deployedappsView = GWT.create(ApplicationsDeployedView.class);
		this.deployedappsView.setPresenter(this);

		initialize();

		containerWidget.setWidget(this.deployedappsView.asWidget());
		registerViewDetacher(deployedappsView);
	}

	/**
	 * Ask user before stopping this activity
	 */
	@Override
	public String mayStop() {
		return null;
	}

	@Override
	public void retrieveDeployedApps() {
		ListStore<ApplicationModel> applicationStore = new DeployedApplicationListStore();
		applicationStore.getLoader().load();
		applicationStore.getLoader().addLoadListener(new LoadListener() {
			@Override
			public void loaderLoad(LoadEvent le) {
				setDeployedAppsListInView(le
						.<ListLoadResult<ApplicationModel>> getData().getData());
			}

			@Override
			public void loaderLoadException(LoadEvent le) {
				DialogHelper
						.showErrorDialog("There was an error while trying to retrieve all deployed application profiles"
								+ "\nPlease, contact site administrator");
				// handleRPCFailure(le.exception);
			}
		});
	}

	private void setDeployedAppsListInView(List<ApplicationModel> dapps) {
		this.deployedappsView.defineDeployedApps(dapps);

		if (monitoredApplications == null) {
			return;
		}

		// If Monitoring View active with one application, request to update
		// this view
		// Checking if monitoredApplication is still in the list
		boolean alreadyMonitored = false;

		if (!dapps.containsAll(monitoredApplications)) {
			DialogHelper
					.showDialog(
							"Warning",
							"Some monitored applications has been dropped from the list of deployed applications. Resetting monitoring view");
			monitoredApplications = null;
		} else {
			List<ApplicationModel> oldMonitoredApplications = monitoredApplications;
			monitoredApplications = new ArrayList<ApplicationModel>();
			for (ApplicationModel app : oldMonitoredApplications)
				monitoredApplications.add(dapps.get(dapps.indexOf(app)));
			alreadyMonitored = true;
		}
		MonitoringApplicationRequestedEvent se = new MonitoringApplicationRequestedEvent(
				monitoredApplications, alreadyMonitored);
		clientFactory.getEventBus().fireEvent(se);
	}

	@Override
	public void startApplication(ApplicationModel app, String publicKey,
			String privateKey) {
		callback.setCommand("start");
		callback.setApplication((String) app.get(ApplicationModel.TITLE));
		notificationBox = MessageBox.wait("Action in Progress",
				"Starting application, please wait...", "Starting ...");
		deployedappsService.startApplication(
				(String) app.get(ApplicationModel.APPLICATION_URIID),
				publicKey, privateKey, callback);
	}

	@Override
	public void stopApplication(ApplicationModel app, String publicKey,
			String privateKey) {
		callback.setCommand("stop");
		callback.setApplication((String) app.get(ApplicationModel.TITLE));
		notificationBox = MessageBox.wait("Action in Progress",
				"Stopping application, please wait...", "Stopping ...");
		deployedappsService.stopApplication(
				(String) app.get(ApplicationModel.APPLICATION_URIID),
				publicKey, privateKey, callback);
	}

	@Override
	public void undeployApplication(ApplicationModel app, String publicKey,
			String privateKey) {
		callback.setCommand("undeploy");
		callback.setApplication((String) app.get(ApplicationModel.TITLE));
		notificationBox = MessageBox.wait("Action in Progress",
				"Undeploying application, please wait...", "Undeploying ...");
		deployedappsService.undeployApplication(
				(String) app.get(ApplicationModel.APPLICATION_URIID),
				publicKey, privateKey, callback);
	}

	private ApplicationAsyncCallback<Void> callback = new ApplicationAsyncCallback<Void>();

	class ApplicationAsyncCallback<Void> implements AsyncCallback<Void> {
		String command;
		String application;

		public void setCommand(String command) {
			this.command = command;
		}

		public void setApplication(String application) {
			this.application = application;
		}

		@Override
		public void onFailure(Throwable caught) {
			notificationBox.close();
			// handleRPCFailure(caught);
			DialogHelper.showErrorDialog("There was an error on trying to "
					+ command + " the application " + application
					+ "\nPlease, contact site administrator");
		}

		@Override
		public void onSuccess(Void result) {
			notificationBox.close();
			DialogHelper.showDialog("Success", "Successfully executed command "
					+ command + " on the application " + application);
			retrieveDeployedApps();
		}
	}

	@Override
	public void monitoringApplications(List<ApplicationModel> applications) {
		this.monitoredApplications = applications;
		MonitoringApplicationRequestedEvent se = new MonitoringApplicationRequestedEvent(
				applications, false);
		clientFactory.getEventBus().fireEvent(se);
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
		refreshTimer.cancel();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.cloud4soa.frontend.widget.appdeployed.client.views.
	 * ApplicationsDeployedView
	 * .Presenter#onSLAContractViewRequested(java.lang.String)
	 */
	@Override
	public void onSLAContractViewRequested(String slaContractId) {
		if (slaContractId == null){
			DialogHelper
				.showErrorDialog("SLA Contract not available. Please, contact site administrator");
			return;
		}
		SLAContractRequestedEvent se = new SLAContractRequestedEvent(
				slaContractId);
		clientFactory.getEventBus().fireEvent(se);
	}

	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.widget.monitoring.client.views.ApplicationsDeployedView.Presenter#onRatingPaaSOffering(eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel, java.lang.Object)
	 */
	@Override
	public void onRatingPaaSOffering(ApplicationModel model, int rating) {
		deployedappsService.storeUserExperienceRate(model.getKey(), rating, new AsyncCallback<Void>(){

			@Override
			public void onFailure(Throwable caught) {
				DialogHelper
				.showErrorDialog("There was a problem to store your rating. Please, contact site administrator");
			}

			@Override
			public void onSuccess(java.lang.Void result) {
				// Ignored
			}});
	}

	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.widget.monitoring.client.views.ApplicationsDeployedView.Presenter#onSLAViolationViewRequested()
	 */
	@Override
	public void onSLAViolationViewRequested() {
		SLAViolationsRequestedEvent se = new SLAViolationsRequestedEvent(null);
		clientFactory.getEventBus().fireEvent(se);
		
	}

	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.widget.monitoring.client.views.ApplicationsDeployedView.Presenter#onFilterSLAViolations(java.lang.String)
	 */
	@Override
	public void onFilterSLAViolations(String applicationId) {
		SLAViolationsRequestedEvent se = new SLAViolationsRequestedEvent(applicationId);
		clientFactory.getEventBus().fireEvent(se);
	}

}
