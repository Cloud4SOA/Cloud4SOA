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

package eu.cloud4soa.frontend.widget.slamanagement.client.activities;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.governance.SLAStore;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAViolationModel;
import eu.cloud4soa.frontend.commons.client.dialog.DialogHelper;
import eu.cloud4soa.frontend.commons.client.events.SLAViolationsReceivedEvent;
import eu.cloud4soa.frontend.commons.client.events.SLAViolationsRequestedEvent;
import eu.cloud4soa.frontend.commons.client.events.UserLoggedOutEvent;
import eu.cloud4soa.frontend.commons.client.services.soa.GovernanceService;
import eu.cloud4soa.frontend.commons.client.services.soa.GovernanceServiceAsync;
import eu.cloud4soa.frontend.widget.slamanagement.client.views.SLAViolationsView;

public class SLAViolationsActivity extends Cloud4SoaActivity implements
		SLAViolationsView.Presenter, EventHandler {

	// Services
	private GovernanceServiceAsync governanceService = GWT
			.create(GovernanceService.class);

	// View
	private SLAViolationsView sLAViolationsView;

	private Timer refreshTimer;
	private static final int REFRESH_INTERVAL = 60 * 1000; // ms (Refresh time is 1 min)
	private String selectedApplicationId;

	public SLAViolationsActivity(Cloud4SOAUIClientFactory clientFactory) {
		super(null, clientFactory);
		initialize();
	}

	private void initialize() {
		// Obtain SLA violations
		// Set timer
		refreshTimer = new Timer() {

			@Override
			public void run() {
				governanceService.getSLAViolations(
						new AsyncCallback<List<SLAViolationModel>>() {

							@Override
							public void onFailure(Throwable caught) {
								// handleRPCFailure(caught);
								DialogHelper
										.showErrorDialog("There was an error on trying to recover the SLA violations"
												+ "\nPlease, contact site administrator");
							}

							@Override
							public void onSuccess(List<SLAViolationModel> result) {
								SLAStore store = new SLAStore();
								store.setViolations(result);
								sLAViolationsView.setSLAViolationsData(store);
								
								//Filtering SLA violations if application is selected
								if (selectedApplicationId != null)
									sLAViolationsView.filterSLAViolationsByApplicationId(selectedApplicationId);
								
								//Notify reception of SLA violation to other interested views
								SLAViolationsReceivedEvent se = new SLAViolationsReceivedEvent(result);
								clientFactory.getEventBus().fireEvent(se);
							}
						});
			}
		};
		refreshTimer.scheduleRepeating(REFRESH_INTERVAL);
		refreshTimer.run();
		
		// Capturing logout to cancel timer that refresh the SLA violation view
		addHandler(UserLoggedOutEvent.TYPE, new UserLoggedOutEvent.Handler() {
			@Override
			public void onUserLogout(UserLoggedOutEvent event) {
				if (refreshTimer != null)
					refreshTimer.cancel();
			}
		});
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		// this.sLAViolationsView = new SLAViolationsGXTViewImpl(this); //TODO
		// Use GWT.create for retarded binding creation
		this.sLAViolationsView = GWT.create(SLAViolationsView.class);
		this.sLAViolationsView.setPresenter(this);

		containerWidget.setWidget(this.sLAViolationsView.asWidget());
		registerViewDetacher(sLAViolationsView);
	}

	/**
	 * @param event
	 */
	public void onSLAViolationRequested(SLAViolationsRequestedEvent event) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param applicationId
	 */
	public void filterSLAViolationsByApplicationId(String applicationId) {
		this.selectedApplicationId = applicationId;
		if (sLAViolationsView!=null)
			sLAViolationsView.filterSLAViolationsByApplicationId(applicationId);
	}
}
