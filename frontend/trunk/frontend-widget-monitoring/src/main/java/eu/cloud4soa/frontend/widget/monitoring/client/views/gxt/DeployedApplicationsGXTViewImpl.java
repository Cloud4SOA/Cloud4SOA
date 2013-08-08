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
import java.util.List;

import org.cobogw.gwt.user.client.ui.Rating;

import com.extjs.gxt.ui.client.Style.ButtonScale;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.IconAlign;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Image;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAViolationModel;
import eu.cloud4soa.frontend.commons.client.dialog.DialogHelper;
import eu.cloud4soa.frontend.commons.client.resources.Icons;
import eu.cloud4soa.frontend.commons.client.utils.C4SCommand;
import eu.cloud4soa.frontend.commons.client.utils.PaaSCommandExecution;
import eu.cloud4soa.frontend.commons.client.utils.PaaSCommandManagement;
import eu.cloud4soa.frontend.widget.monitoring.client.ResourceBundle;
import eu.cloud4soa.frontend.widget.monitoring.client.data.ApplicationStore;
import eu.cloud4soa.frontend.widget.monitoring.client.views.ApplicationsDeployedView;

/**
 * Copyright Atos Spain S.A. 2012
 * 
 * @author Yosu Gorroñogoitia - ATOS
 */

public class DeployedApplicationsGXTViewImpl extends LayoutContainer implements
		ApplicationsDeployedView, PaaSCommandExecution {
	private Presenter presenter;
	private final String BUTTON_MONITORING_DETAILS = "Monitoring";
	private final String BUTTON_SLA_CONTRACT = "SLA contract";
	private final String BUTTON_SLA_VIOLATION = "SLA violations";
	private final ResourceBundle rb = GWT.create(ResourceBundle.class);
	private Button btnStartStop;
	private Grid<ApplicationModel> grid;
	private List<ApplicationModel> lstDeployedApps;
	private List<SLAViolationModel> violations;
	private ColumnModel cm;
	private int height = 300;
	private ApplicationModel selectedApplication;
	private DeployedApplicationsGXTViewImpl instance;

	public DeployedApplicationsGXTViewImpl() {
		createView();
		instance = this;
	}

	public DeployedApplicationsGXTViewImpl(Presenter prsntr) {
		this.presenter = prsntr;
		instance = this;

		createView();
	}

	private void createView() {
		setLayout(new FitLayout());

		// Panel
		ContentPanel cp = new ContentPanel();
		cp.setHeading("Deployed Applications");
		cp.setHeaderVisible(true);
		cp.setBorders(true);
		cp.setLayout(new FitLayout());
//		cp.setHeight(height);

		// // Toolbar
		ToolBar toolBar = new ToolBar();
		toolBar.addStyleName("c4s-white-bg");
		cp.setTopComponent(toolBar);

		btnStartStop = new Button("Start/Stop");
		btnStartStop.setScale(ButtonScale.LARGE);
		btnStartStop.setIconAlign(IconAlign.BOTTOM);
		btnStartStop.setIcon(AbstractImagePrototype.create(Icons.RESOURCES
				.buttonPower()));
		btnStartStop.setToolTip("Start/Stop application");
		toolBar.add(btnStartStop);

		SelectionListener<ButtonEvent> sl = new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				String commandName = ce.getButton().getText();
				List<ApplicationModel> applications = grid.getSelectionModel()
						.getSelectedItems();
				String message = "";
				C4SCommand command = null;
				if (applications == null || applications.isEmpty()) {
					message = "Please, select one deployed application";
					DialogHelper.showDialog(null, message);
				} else if (!commandName.equals(BUTTON_MONITORING_DETAILS)
						&& applications.size() > 1) {
					message = "Please, select only one deployed application";
					DialogHelper.showDialog(null, message);
				} else {
					if (commandName.equals("Start")) {
						message = "Do you want to start the application "
								+ applications.get(0).getTitle() + "?";
						command = C4SCommand.START;
					} else if (commandName.equals("Stop")) {
						message = "Do you want to stop the application "
								+ applications.get(0).getTitle() + "?";
						command = C4SCommand.STOP;
					} else if (commandName.equals("Undeploy")) {
						message = "Do you want to undeploy application "
								+ applications.get(0).getTitle() + "?";
						command = C4SCommand.UNDEPLOY;
					} else if (commandName.equals(BUTTON_MONITORING_DETAILS)) {
						message = "Do you want to see monitoring details of selected applications?";
						command = C4SCommand.SEE_MONITORING_DETAILS;
					} else if (commandName.equals(BUTTON_SLA_CONTRACT)) {
						message = "Do you want to see the SLA contract of selected application?";
						command = C4SCommand.SEE_SLA_CONTRACT;
					} 

					if (commandName.equals(BUTTON_MONITORING_DETAILS)) {
						showMonitoringApplicationConfirmationDialog(message,
								applications);
					} else if (commandName.equals(BUTTON_SLA_CONTRACT)) {
						String slaContractId = applications.get(0).getSLAContractId();
						showSLAContractViewConfirmationDialog(message, slaContractId); 
					} else {
						new PaaSCommandManagement()
								.managePaaSCommand(instance, instance, message,
										command, applications.get(0));
					}
				}
			}
		};

		btnStartStop.addListener(Events.Select, sl);

		Button btnUndeploy = new Button("Undeploy");
		btnUndeploy.setScale(ButtonScale.LARGE);
		btnUndeploy.setIconAlign(IconAlign.BOTTOM);
		btnUndeploy.setToolTip("Undeploy application");
		btnUndeploy.setIcon(AbstractImagePrototype.create(Icons.RESOURCES
				.buttonRemove()));
		toolBar.add(btnUndeploy);

		btnUndeploy.addListener(Events.Select, sl);

		Button btnMonitor = new Button(BUTTON_MONITORING_DETAILS);
		btnMonitor.setScale(ButtonScale.LARGE);
		btnMonitor.setIconAlign(IconAlign.BOTTOM);
		btnMonitor.setToolTip("See application monitoring details");
		btnMonitor.setIcon(AbstractImagePrototype.create(Icons.RESOURCES
				.buttonOscilloscope()));
		toolBar.add(btnMonitor);

		btnMonitor.addListener(Events.Select, sl);

		Button btnSLAContract = new Button(BUTTON_SLA_CONTRACT);
		btnSLAContract.setScale(ButtonScale.LARGE);
		btnSLAContract.setIconAlign(IconAlign.BOTTOM);
		btnSLAContract.setToolTip("See application SLA contract details");
		btnSLAContract.setIcon(AbstractImagePrototype.create(Icons.RESOURCES
				.slaContract()));
		toolBar.add(btnSLAContract);

		btnSLAContract.addListener(Events.Select, sl);
		
		Button btnSLAViolation = new Button(BUTTON_SLA_VIOLATION);
		btnSLAViolation.setScale(ButtonScale.LARGE);
		btnSLAViolation.setIconAlign(IconAlign.BOTTOM);
		btnSLAViolation.setToolTip("See SLA violations");
		btnSLAViolation.setIcon(AbstractImagePrototype.create(Icons.RESOURCES
				.slaViolation()));
		toolBar.add(btnSLAViolation);

		btnSLAViolation.addListener(Events.Select, new SelectionListener<ButtonEvent>(){

			@Override
			public void componentSelected(ButtonEvent ce) {
				String message = "Do you want to see the SLA violations?";
				showSLAViolationViewConfirmationDialog(message);
			}
			
		});

		cp.setTopComponent(toolBar);

		GridCellRenderer<ApplicationModel> status = new GridCellRenderer<ApplicationModel>() {
			@Override
			public Object render(ApplicationModel model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<ApplicationModel> store,
					Grid<ApplicationModel> grid) {
				
				return getStatusIcon(model, property);
			}
			
		};
		
		GridCellRenderer<ApplicationModel> ratingRenderer = new GridCellRenderer<ApplicationModel>() {  
			  
		    @Override
			public Object render(final ApplicationModel model, String property, ColumnData config, final int rowIndex,  
		          final int colIndex, ListStore<ApplicationModel> store, Grid<ApplicationModel> grid) {  

		        Rating ratingWidget = new Rating(model.<Integer>get(property), 5);
		        ratingWidget.addValueChangeHandler(new ValueChangeHandler() {
					  @Override
					public void onValueChange(ValueChangeEvent event) {
					    GWT.log("selected: " + event.getValue());
					    //Modify rating of PaaS Offering
					    presenter.onRatingPaaSOffering (model, (Integer) event.getValue());
					  }
					});
		        return ratingWidget;  
		    }  
		};  

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

		ColumnConfig column = new ColumnConfig();
		column.setId(ApplicationModel.TITLE);
		column.setHeader("Application");
		column.setWidth(100);
		configs.add(column);

		column = new ColumnConfig();
		column.setId(ApplicationModel.PAAS_PROVIDER);
		column.setHeader("Provider");
		column.setWidth(100);
		configs.add(column);

		GridCellRenderer<ApplicationModel> urlRender = new GridCellRenderer<ApplicationModel>() {
			@Override
			public String render(ApplicationModel model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<ApplicationModel> store,
					Grid<ApplicationModel> grid) {
				String url = (String) model.get(property);
				return "<a href=\"" + url + "\" target=\"_blank\">" + url
						+ "</a>";
			}
		};

		column = new ColumnConfig();
		column.setId(ApplicationModel.DEPLOYMENT_URL);
		column.setHeader("URL");
		column.setWidth(100);
		column.setRenderer(urlRender);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId(ApplicationModel.RATING);
		column.setHeader("Rating");
		column.setWidth(100);
		column.setRenderer(ratingRenderer);
		configs.add(column);

		column = new ColumnConfig();
		column.setId(ApplicationModel.STATUS);
		column.setHeader("Status");
		column.setRenderer(status);
		column.setWidth(75);
		column.setAlignment(HorizontalAlignment.CENTER);
		configs.add(column);

		final ListStore<ApplicationModel> store = new ListStore<ApplicationModel>();
		store.add(new ApplicationStore().getApplications(lstDeployedApps));

		cm = new ColumnModel(configs);

		grid = new Grid<ApplicationModel>(store, cm);
		grid.getSelectionModel().setSelectionMode(SelectionMode.MULTI);
		grid.setStyleAttribute("borderTop", "none");
		grid.setAutoExpandColumn(ApplicationModel.TITLE);
		grid.getView().setForceFit(true);
		grid.setBorders(false);
		add(grid);

		// Getting selection
		grid.getSelectionModel().addListener(Events.SelectionChange,
				new Listener<SelectionChangedEvent<ApplicationModel>>() {

					@Override
					public void handleEvent(
							SelectionChangedEvent<ApplicationModel> be) {
						if (be.getSelectedItem() == null) {
							return;
						}
						Info.display("Selected application", be
								.getSelectedItem().getTitle());
						boolean online = be.getSelectedItem()
								.get(ApplicationModel.STATUS)
								.equals(ApplicationModel.STATUS_ONLINE);
						btnStartStop.setText(online ? "Stop" : "Start");
						btnStartStop.setToolTip(online ? "Stop application"
								: "Start application");
						btnStartStop.setIcon(online ? AbstractImagePrototype
								.create(Icons.RESOURCES.buttonStop())
								: AbstractImagePrototype.create(Icons.RESOURCES
										.buttonPlay()));
						
						//If SLA Violation shown filter violations of selected application
						presenter.onFilterSLAViolations (be.getSelectedItem().getKey());
					}

				});

		cp.add(grid);
		add(cp);

	}



	@Override
	public void executeCommand(final ApplicationModel application,
			final C4SCommand command, String publicKey, String privateKey) {
		if (publicKey != null && publicKey.length() > 0 && privateKey != null
				&& privateKey.length() > 0) {
			switch (command) {
			case START:
				presenter.startApplication(application, publicKey, privateKey);
				break;
			case STOP:
				presenter.stopApplication(application, publicKey, privateKey);
				break;
			case UNDEPLOY:
				presenter.undeployApplication(application, publicKey,
						privateKey);
				break;
			}
		}
	}

	private void showMonitoringApplicationConfirmationDialog(String message,
			final List<ApplicationModel> applications) {
		final Dialog dialog = DialogHelper
				.showConfirmationDialog(null, message);
		Listener<ButtonEvent> onOKEvent = new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Info.display("Accepted", "Monitoring selected applications");
				presenter.monitoringApplications(applications);
			}
		};
		dialog.getButtonById(Dialog.YES).addListener(Events.Select, onOKEvent);
	}

	private void showSLAContractViewConfirmationDialog(String message,
			final String slaContractId) {
		final Dialog dialog = DialogHelper
				.showConfirmationDialog(null, message);
		Listener<ButtonEvent> onOKEvent = new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Info.display("Accepted", "Showing SLA contract");
				presenter.onSLAContractViewRequested(slaContractId);
			}
		};
		dialog.getButtonById(Dialog.YES).addListener(Events.Select, onOKEvent);
	}
	
	private void showSLAViolationViewConfirmationDialog(String message) {
		final Dialog dialog = DialogHelper
				.showConfirmationDialog(null, message);
		Listener<ButtonEvent> onOKEvent = new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				Info.display("Accepted", "Showing SLA violations");
				presenter.onSLAViolationViewRequested();
			}
		};
		dialog.getButtonById(Dialog.YES).addListener(Events.Select, onOKEvent);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void defineDeployedApps(List<ApplicationModel> dalst) {

		this.lstDeployedApps = dalst;

		final ListStore<ApplicationModel> store = new ListStore<ApplicationModel>();
		store.add(new ApplicationStore().getApplications(lstDeployedApps));

		grid.reconfigure(store, cm);

		selectedApplication = grid.getSelectionModel().getSelectedItem();
		if (selectedApplication != null && btnStartStop != null) {
			btnStartStop.setText(selectedApplication.get(
					ApplicationModel.STATUS).equals(
					ApplicationModel.STATUS_ONLINE) ? "Stop" : "Start");
			btnStartStop.setToolTip(selectedApplication.get(
					ApplicationModel.STATUS).equals(
					ApplicationModel.STATUS_ONLINE) ? "Stop application"
					: "Start application");
		}

	}

	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.widget.monitoring.client.views.ApplicationsDeployedView#checkApplicationStatus(java.util.List)
	 */
	@Override
	public void checkApplicationStatus(List<SLAViolationModel> violations) {
		this.violations = violations;
		defineDeployedApps(lstDeployedApps);
	}
	
	private Image getStatusIcon(ApplicationModel model, String property) {
		
		boolean enabled = Boolean.valueOf(model.get(property).equals(
				ApplicationModel.STATUS_ONLINE) ? true : false);
		ImageResource resource = enabled ? rb.online() : rb.offline();
		if (enabled){ //Checking available violations for this application
			if (hasViolations (model.getKey())){
				resource = rb.violations();
			}
		}
		
		Image icon = new Image();
		icon.setUrl(resource.getURL());
		return icon;
	}

	private boolean hasViolations(String application_id) {
		boolean result = false;
		if (violations != null)
			for (SLAViolationModel violation: violations)
				if (violation.get(SLAViolationModel.APPLICATION_ID).equals(application_id)){
					result = true;
					break;
				}
		return result;
	}
}
