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

package eu.cloud4soa.frontend.widget.deployment.client.activities;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.data.ChangeEvent;
import com.extjs.gxt.ui.client.data.ChangeListener;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAMetricModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAPolicyModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateGuaranteeTermModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserCredentialsModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.client.dialog.DialogHelper;
import eu.cloud4soa.frontend.commons.client.events.UpdateDeployedApplicationsRequestedEvent;
import eu.cloud4soa.frontend.commons.client.places.ApplicationProfileAware;
import eu.cloud4soa.frontend.commons.client.places.MonitoringPlace;
import eu.cloud4soa.frontend.commons.client.places.PaaSOfferingAware;
import eu.cloud4soa.frontend.commons.client.places.SLAAware;
import eu.cloud4soa.frontend.commons.client.places.SearchPlace;
import eu.cloud4soa.frontend.commons.client.services.soa.ApplicationDeploymentService;
import eu.cloud4soa.frontend.commons.client.services.soa.ApplicationDeploymentServiceAsync;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerService;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerServiceAsync;
import eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService;
import eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryServiceAsync;
import eu.cloud4soa.frontend.commons.client.services.soa.UserManagementAndSecurityService;
import eu.cloud4soa.frontend.commons.client.services.soa.UserManagementAndSecurityServiceAsync;
import eu.cloud4soa.frontend.widget.deployment.client.views.CliDeploymentView;
import eu.cloud4soa.frontend.widget.deployment.client.views.CreateDBView;
import eu.cloud4soa.frontend.widget.deployment.client.views.DBCreationReportView;
import eu.cloud4soa.frontend.widget.deployment.client.views.DeployApplicationView;
import eu.cloud4soa.frontend.widget.deployment.client.views.DeploymentReportView;
import eu.cloud4soa.frontend.widget.deployment.client.views.PaaSCredentialsView;
import eu.cloud4soa.frontend.widget.slamanagement.client.views.SLAPolicyEditorView;
import eu.cloud4soa.frontend.widget.slamanagement.client.views.SLATemplateViewGxtImpl;

/**
 * Deploy application activity.
 *
 * @author Stefano Travelli (Cyntelix)
 * @author Yosu Gorroñogoitia (Atos)
 */
public class DeployApplicationActivity extends Cloud4SoaActivity implements
		DeployApplicationView.Presenter, CreateDBView.Presenter,
		PaaSCredentialsView.Presenter, DeploymentReportView.Presenter,
		DBCreationReportView.Presenter,  SLAPolicyEditorView.Presenter{

	private DeploymentState currentState = DeploymentState.CREDENTIALS;
	private DeployApplicationView deployView;
	private CreateDBView createDBView;
	private PaaSCredentialsView paasCredentialsView;
	private DBCreationReportView dbCreationReportView;
	private DeploymentReportView deploymentReportView;
	private SLAPolicyEditorView slaPolicyEditorView;
	private ApplicationDeploymentServiceAsync deploymentService = 
		GWT.create(ApplicationDeploymentService.class);
	private ModelManagerServiceAsync modelManagerService = 
		GWT.create(ModelManagerService.class);
	private UserManagementAndSecurityServiceAsync userService =
		GWT.create(UserManagementAndSecurityService.class);
	private PaaSOfferingDiscoveryServiceAsync paaSOfferingDiscoveryService = 
		GWT.create(PaaSOfferingDiscoveryService.class);
	private String paaSOfferingUriId;
	private String applicationUriId;
	private MessageBox notificationBox;
	private AcceptsOneWidget parentContainer;
	private boolean credentialsObtained = false;
	private ApplicationModel applicationModel;
	private PaaSOfferingModel paaSOfferingModel;
	private SLATemplateModel slaTemplateModel;
	private UserCredentialsModel originalCredentialsModel;
	private UserCredentialsModel credentialsModel;
	private SoftwareComponentModel softwareComponentModel;
	private List<SLAMetricModel> slaPolicyMetricTypes = new ArrayList<SLAMetricModel>();
	private List<SLAPolicyModel> slaPolicies = new ArrayList<SLAPolicyModel>();


	public DeployApplicationActivity(Place place,
			Cloud4SOAUIClientFactory clientFactory) {
		super(place, clientFactory);

		// addHandler(PaaSOfferingSelectedEvent.TYPE,
		// new PaaSOfferingSelectedEvent.Handler() {
		// @Override
		// public void onPaaSOfferingSelected(
		// PaaSOfferingSelectedEvent event) {
		// bindDeploymentData();
		// }
		// });

	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.parentContainer = panel;

        if (place instanceof ApplicationProfileAware)
            applicationUriId = ((ApplicationProfileAware) place).getApplicationProfileUriId();

        if (place instanceof PaaSOfferingAware)
            paaSOfferingUriId = ((PaaSOfferingAware) place).getPaaSOfferingUriId();

        if (place instanceof SLAAware){
        	slaTemplateModel = ((SLAAware) place).getSLATemplate();
        	getMetricTypes();
        }

        loadApplicationData();
	}

	/**
	 * Get the available metric types from the SLA Template
	 * @return
	 */
	private void getMetricTypes() {
		for (SLATemplateGuaranteeTermModel gt: slaTemplateModel.getGuaranteeTerms()){
			SLAMetricModel metric = new SLAMetricModel();
			metric.setTitle(gt.getServiceLevelObjectives().getKPIName());
			metric.setExpression(gt.getBusinessLevelObjectives().getPenaltyValueExpression());
			if (!slaPolicyMetricTypes.contains(metric)){
				slaPolicyMetricTypes.add(metric);
			}
		}
	}

	private void onDataLoaded() {
		manageDeploymentState();
	}

	/**
	 * C4S Deployment state diagram
	 */
	private void manageDeploymentState() {
		switch (currentState) {
		case SLA_TEMPLATE:
			showSLATemplateView();
			currentState = DeploymentState.SLA_POLICIES;
			break;
		case SLA_POLICIES:
			showSLAPoliciesView();
			currentState = DeploymentState.DBCREATION;
			break;
		case CREDENTIALS:
			showCredentialsForm();
			if (paaSOfferingModel.isGitSupported())
				currentState = DeploymentState.CLI_DEPLOYMENT;
			else
				currentState = DeploymentState.SLA_TEMPLATE;
			break;
		case CLI_DEPLOYMENT:
			showCLIDeploymentView();
			break;
		case DBCREATION:
			if (hasDBSoftwareComponents()) {
				showDBCreationForm();
				currentState = DeploymentState.DBCREATION_REPORT;
			} else {
				showDeploymentForm();
				currentState = DeploymentState.DEPLOYMENT_REPORT;
			}
			break;
		case DBCREATION_REPORT:
			showDBCreationReportForm();
			currentState = DeploymentState.DBCREATION;
			break;
		case DEPLOYMENT_REPORT:
			showDeploymentReportForm();
			currentState = DeploymentState.MONITORING;
			break;
		case MONITORING:
			goTo(new MonitoringPlace());
			break;

		}
	}

	private void showSLATemplateView() {
		ContentPanel view = new ContentPanel();
		view.addStyleName("c4s-white-bg");
		view.setHeading("Application Deployment: Accept SLA Template");
		view.setLayout(new FitLayout());
		SLATemplateViewGxtImpl slaTemplateView = new SLATemplateViewGxtImpl();
		view.add (slaTemplateView);
		Button bReject = new Button ("Reject");
		Button bAccept = new Button ("Accept");
		bReject.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				onSLATemplateRejected();
			}
		});

		bAccept.addListener(Events.Select, new Listener<ButtonEvent>() {
			@Override
			public void handleEvent(ButtonEvent be) {
				onSLATemplateAccepted();
			}
		});

		ToolBar toolbar = new ToolBar();
		toolbar.addStyleName("c4s-white-bg");

		toolbar.add(new FillToolItem());
		toolbar.add(bReject);
		toolbar.add(bAccept);

		view.setBottomComponent(toolbar);
		parentContainer.setWidget(view);

		slaTemplateView.bindSLATemplate(slaTemplateModel);
	}

	/**
	 *
	 */
	protected void onSLATemplateAccepted() {
		manageDeploymentState();
	}

	private void onSLATemplateRejected() {
		goTo(new SearchPlace(Strings.EMPTY));
	}


	private void showSLAPoliciesView() {
		slaPolicyEditorView = GWT.create(SLAPolicyEditorView.class);
		slaPolicyEditorView.setPresenter(this);
		parentContainer.setWidget(slaPolicyEditorView);
	}

    private native String host(String uri) /*-{
        var pattern = new RegExp('^(.*:)//([0-9a-z\\-.]+)(:[0-9]+)?(.*)$');
        var match = pattern.exec(uri);
        return match[2];
      }-*/;

    private native String port(String uri) /*-{
        var pattern = new RegExp('^(.*:)//([0-9a-z\\-.]+)(:[0-9]+)?(.*)$');
        var match = pattern.exec(uri);
        return (match[3] == null) ? '' : match[3];
      }-*/;


	/**
	 *
	 */
	private void showCLIDeploymentView() {
		ContentPanel view = new ContentPanel();
		view.setBodyBorder(true);
		view.addStyleName("c4s-white-bg");
		view.setHeading("CLI Deployment");
		view.setLayout(new FitLayout());
		CliDeploymentView cliDeploymentView = new CliDeploymentView();

        // TODO verify whether the parameter must be PaaS Offering Id or PaaS Id
        cliDeploymentView.populateInfo(
                this.host(GWT.getHostPageBaseURL()),
                GWT.getHostPageBaseURL(),
                this.clientFactory.getCurrentUser().<String>get(UserModel.USER_ACCOUNTNAME),
                applicationUriId,
                paaSOfferingUriId
        );

        view.add (cliDeploymentView);
		parentContainer.setWidget(view.asWidget());
	}

	/**
	 *
	 */
	private void showCredentialsForm() {
		paasCredentialsView = GWT.create(PaaSCredentialsView.class);
		paasCredentialsView.setPresenter(this);
		parentContainer.setWidget(paasCredentialsView.asWidget());

		bindCredentialsData();
	}

	/**
	 *
	 */
	private void bindCredentialsData() {
		paasCredentialsView.bindCredentialsForm(credentialsModel);
		paasCredentialsView.bindPaaSOfferingForm(paaSOfferingModel);
	}

	/**
	 *
	 */
	private void showDBCreationForm() {
		createDBView = GWT.create(CreateDBView.class);
		createDBView.setPresenter(this);
		parentContainer.setWidget(createDBView.asWidget());

		bindDBCreationData();
	}

	/**
	 *
	 */
	private void showDBCreationReportForm() {
		dbCreationReportView = GWT.create(DBCreationReportView.class);
		dbCreationReportView.setPresenter(this);
		parentContainer.setWidget(dbCreationReportView.asWidget());

		bindDBCreationReportData();
	}

	private void bindDBCreationReportData() {
		// Update AP
		modelManagerService.retrieveOneApplicationInstance(applicationUriId,
				new AsyncCallback<ApplicationModel>() {

					@Override
					public void onSuccess(ApplicationModel app) {
						applicationModel = app;
						updateSoftwareComponentModel();
						dbCreationReportView
								.bindDBCreationReportForm(softwareComponentModel);
					}

					@Override
					public void onFailure(Throwable caught) {
						DialogHelper
								.showErrorDialog("There was an error while trying to retrieve the application. Contact Site Administrator");
					}
				});
	}

	/**
	 * Update software component model after reloading the AP
	 */
	protected void updateSoftwareComponentModel() {
		List<SoftwareComponentModel> scs = applicationModel
				.getSoftwareComponents();
		for (SoftwareComponentModel sc : scs) {
			if (sc.getKey().equals(softwareComponentModel.getKey())) {
				softwareComponentModel = sc;
				break;
			}
		}
	}

	/**
	 *
	 */
	private void showDeploymentForm() {
		deployView = GWT.create(DeployApplicationView.class);

		// Deployment view
		deployView.setPresenter(this);
		parentContainer.setWidget(deployView.asWidget());
		bindDeploymentData();
		// registerViewDetacher(deployView);
	}

	/**
	 *
	 */
	private void showDeploymentReportForm() {
		deploymentReportView = GWT.create(DeploymentReportView.class);
		deploymentReportView.setPresenter(this);
		parentContainer.setWidget(deploymentReportView.asWidget());

		bindDeploymentReportData();
		// registerViewDetacher(deploymentReportView);
	}

	private void bindDBCreationData() {
		createDBView.bindDBForm(softwareComponentModel);
	}

	/**
	 * Determines the next SQL or No-SQL Software component model
	 *
	 * @return
	 */
	private boolean hasDBSoftwareComponents() {
		boolean has = false;

		List<SoftwareComponentModel> scs = applicationModel
				.getSoftwareComponents();
		int index = 0;
		if (softwareComponentModel != null)
			index = scs.indexOf(softwareComponentModel) + 1;
		if (index < scs.size()) {
			SoftwareComponentModel sc;
			int i;
			for (i = index, sc = scs.get(i); i < scs.size(); i++) {
				if (sc.getType().equals(
						SoftwareComponentModel.TYPE_SQL_DATABASE)
						|| sc.getType().equals(
								SoftwareComponentModel.TYPE_NO_SQL_DATABASE)) {
					has = true;
					softwareComponentModel = sc;
					break;
				}
			}
		}
		if (!has)
			softwareComponentModel = null;
		return has;
	}

	/**
	 *
	 */
	private void loadApplicationData() {
		modelManagerService.retrieveOneApplicationInstance(applicationUriId,
				new AsyncCallback<ApplicationModel>() {

					@Override
					public void onSuccess(ApplicationModel app) {
						applicationModel = app;
						loadProviderData();
					}

					@Override
					public void onFailure(Throwable caught) {
						DialogHelper
								.showErrorDialog("There was an error while trying to retrieve the application. Contact Site Administrator");
					}
				});
	}

	void loadProviderData() {
		paaSOfferingDiscoveryService.searchForPaaS(paaSOfferingUriId,
				new AsyncCallback<PaaSOfferingModel>() {

					@Override
					public void onFailure(Throwable caught) {
						DialogHelper
								.showErrorDialog("There was an error while trying to retrieve the provider. Contact Site Administrator");
					}

					@Override
					public void onSuccess(PaaSOfferingModel offer) {
						paaSOfferingModel = offer;
						loadCredentialsData();
					}

				});
	}

	void loadCredentialsData() {
		userService.readUserCredentialsForPaaS(paaSOfferingUriId,
				new AsyncCallback<UserCredentialsModel>() {

					@Override
					public void onFailure(Throwable caught) {
						GWT.log("Failed retrieval of user credentials (keys) for PaaS");
						credentialsObtained = false;
						credentialsModel = new UserCredentialsModel("key",
								"value");
						credentialsModel.set(UserCredentialsModel.USER_URIID,
								clientFactory.getCurrentUser().getKey());
						credentialsModel.set(UserCredentialsModel.PAAS_URIID,
								paaSOfferingUriId);

						originalCredentialsModel = new UserCredentialsModel();
						onDataLoaded();
					}

					@Override
					public void onSuccess(UserCredentialsModel credentials) {
						credentialsObtained = false;
						if (credentials != null) { // Credentials obtained
							credentialsModel = credentials;
							credentialsModel.set(
									UserCredentialsModel.USER_URIID,
									clientFactory.getCurrentUser().getKey());
							credentialsModel.set(
									UserCredentialsModel.PAAS_URIID,
									paaSOfferingUriId);

							originalCredentialsModel = new UserCredentialsModel(
									"key", "value");
							originalCredentialsModel
									.set(UserCredentialsModel.PUBLIC_KEY,
											credentials
													.<String> get(UserCredentialsModel.PUBLIC_KEY));
							originalCredentialsModel
									.set(UserCredentialsModel.PRIVATE_KEY,
											credentials
													.<String> get(UserCredentialsModel.PRIVATE_KEY));
							originalCredentialsModel
									.set(UserCredentialsModel.ACCOUNT_NAME,
											credentials
													.<String> get(UserCredentialsModel.ACCOUNT_NAME));

							credentialsObtained = Strings.isNotEmpty(credentials.getKey());
							onDataLoaded();
						}
					}
				});

	}

	private void bindDeploymentData() {
		deployView.bindApplicationForm(applicationModel);
	}

	private void bindDeploymentReportData() {
		// Update AP
		modelManagerService.retrieveOneApplicationInstance(applicationUriId,
				new AsyncCallback<ApplicationModel>() {

					@Override
					public void onSuccess(ApplicationModel app) {
						applicationModel = app;
						deploymentReportView
								.bindDeploymentReportForm(applicationModel);
					}

					@Override
					public void onFailure(Throwable caught) {
						DialogHelper
								.showErrorDialog("There was an error while trying to retrieve the application. Contact Site Administrator");
					}
				});
	}

	@Override
	public void onDeployClick() {
		deployApplication();
	}

	private void updatePaaSAccountKeys() {
		AsyncCallback<Void> callback = new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Error storing/updating user credentials for PaaS");
				manageDeploymentState();
			}

			@Override
			public void onSuccess(Void result) {
				GWT.log("Successful store/update of user credentials for PaaS");
				manageDeploymentState();
			}
		};

		if (credentialsObtained) {
			userService
					.updateUserCredentialsForPaaS(credentialsModel, callback);
		} else {
			userService.storeUserCredentialsForPaaS(credentialsModel, callback);
		}
	}

	private void deployApplication() {
		notificationBox = MessageBox.wait("Action in Progress",
				"Deploying application, please wait...", "Deploying ...");
		deploymentService.clearFiles(new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable throwable) {
				notificationBox.close();
				DialogHelper
						.showErrorDialog("There was an error while trying to clear files"
								+ "\nPlease, contact site administrator");
				// handleRPCFailure(throwable);
			}

			@Override
			public void onSuccess(Void aVoid) {
				deployView.submitFile();
			}
		});
	}

	@Override
	public void onDeployUploadComplete() {
		// upload completed. Deploy the application

		String archiveName = deployView.getApplicationArchiveName();
		String slaTemplateId = slaTemplateModel.getKey();
		deploymentService.deployApplication(applicationUriId,
				paaSOfferingUriId, archiveName, slaTemplateId, slaPolicies,
				new AsyncCallback<String>() {
					@Override
					public void onFailure(Throwable throwable) {
						notificationBox.close();
						DialogHelper
								.showErrorDialog("There was an error while trying to deploy the application"
										+ "\nPlease, contact site administrator");
						// handleRPCFailure(throwable);
					}

					@Override
					public void onSuccess(String result) {
						// Window.alert(result);
						notificationBox.close();
						DialogHelper.showDialog("Success", "Application "
								+ applicationUriId
								+ " has been successfully deployed");
						// dirty check for deployment outcome
						if (result.toLowerCase().contains("successfully")) {
							// todo honor this event
							clientFactory.getEventBus().fireEvent(
									new UpdateDeployedApplicationsRequestedEvent());
						}

						manageDeploymentState();
					}
				});
	}

	@Override
	public void onDBCreationUploadComplete() {
		continueDBCreation();
	}

	private void continueDBCreation() {
		// Update application profile
		modelManagerService.updateApplicationInstance(applicationModel,
				new AsyncCallback<Void>() {
					@Override
					public void onFailure(Throwable throwable) {
						notificationBox.close();
						DialogHelper
								.showErrorDialog("There was an error while trying to update the application profile"
										+ "\nPlease, contact site administrator");
					}

					@Override
					public void onSuccess(Void result) {
						createDB();
					}
				});
	}

	/**
	 *
	 */
	private void createDB() {
		// CreateDB
		deploymentService.createDatabase(applicationUriId, paaSOfferingUriId,
				softwareComponentModel.getKey(), new AsyncCallback<Void>() {
					@Override
					public void onFailure(Throwable throwable) {
						notificationBox.close();
						DialogHelper
								.showErrorDialog("There was an error while trying to create the database"
										+ "\nPlease, contact site administrator");
					}

					@Override
					public void onSuccess(Void result) {
						if (createDBView.isInitializationRequested()) {
							initializeDB();
						} else {
							notificationBox.close();
							DialogHelper.showDialog("Success",
									"Database has been successfully created");
							manageDeploymentState();
						}
					}

				});
	}

	private void initializeDB() {
		// InitializeDB
		deploymentService.initializeDatabase(applicationUriId,
				paaSOfferingUriId, softwareComponentModel.getKey(),
				new AsyncCallback<Void>() {
					@Override
					public void onFailure(Throwable throwable) {
						notificationBox.close();
						DialogHelper
								.showErrorDialog("There was an error while trying to initialize the database"
										+ "\nPlease, contact site administrator");
					}

					@Override
					public void onSuccess(Void result) {
						notificationBox.close();
						DialogHelper
								.showDialog("Success",
										"Database has been successfully created and initialised");
						manageDeploymentState();
					}

				});
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * eu.cloud4soa.frontend.widget.usermanagement.client.views.CreateDBView
	 * .Presenter#onDBCreationClick()
	 */
	@Override
	public void onDBCreationClick() {
		initiateDBCreation();
	}

	/**
	 *
	 */
	private void initiateDBCreation() {
		notificationBox = MessageBox.wait("Action in Progress",
				"Creating database, please wait...", "Creating ...");
		deploymentService.clearFiles(new AsyncCallback<Void>() {
			@Override
			public void onFailure(Throwable throwable) {
				notificationBox.close();
				DialogHelper
						.showErrorDialog("There was an error while trying to clear files"
								+ "\nPlease, contact site administrator");
			}

			@Override
			public void onSuccess(Void aVoid) {
				if (createDBView.isInitializationRequested()) {
					createDBView.submitDBInitializationFiles();
				} else {
					continueDBCreation();
				}
			}
		});
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * eu.cloud4soa.frontend.widget.usermanagement.client.views.PaaSCredentialsView
	 * .Presenter#onCredentialsAccepted()
	 */
	@Override
	public void onCredentialsAccepted() {
		String newPublicKey = credentialsModel
				.<String> get(UserCredentialsModel.PUBLIC_KEY);
		String newPrivateKey = credentialsModel
				.<String> get(UserCredentialsModel.PRIVATE_KEY);
		String newAccountName = credentialsModel
				.<String> get(UserCredentialsModel.ACCOUNT_NAME);
		String originalPublicKey = originalCredentialsModel
				.<String> get(UserCredentialsModel.PUBLIC_KEY);
		String originalPrivateKey = originalCredentialsModel
				.<String> get(UserCredentialsModel.PRIVATE_KEY);
		String originalAccountName = originalCredentialsModel
				.<String> get(UserCredentialsModel.ACCOUNT_NAME);

		if (newPublicKey == null && newPrivateKey == null) {
			DialogHelper
					.showErrorDialog("Please, enter your account keys for selected PaaS Provider");
		}
		if (!newPublicKey.equals(originalPublicKey)
				|| !newPrivateKey.equals(originalPrivateKey)
				|| (newAccountName != null && !newAccountName
						.equals(originalAccountName)))
			updatePaaSAccountKeys();
		else {
			manageDeploymentState();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * eu.cloud4soa.frontend.widget.usermanagement.client.views.PaaSCredentialsView
	 * .Presenter#onCredentialsCancelled()
	 */
	@Override
	public void onCredentialsCancelled() {
		goTo(new SearchPlace(Strings.EMPTY));
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * eu.cloud4soa.frontend.widget.usermanagement.client.views.DeploymentReportView
	 * .Presenter#onDeploymentReportAcceptedClick()
	 */
	@Override
	public void onDeploymentReportAcceptedClick() {
		manageDeploymentState();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * eu.cloud4soa.frontend.widget.usermanagement.client.views.DBCreationReportView
	 * .Presenter#onDBCreationReportAcceptedClick()
	 */
	@Override
	public void onDBCreationReportAcceptedClick() {
		manageDeploymentState();
	}

    private enum DeploymentState {
        SLA_TEMPLATE, SLA_POLICIES, CREDENTIALS, DBCREATION, DBCREATION_REPORT, DEPLOYMENT, DEPLOYMENT_REPORT, MONITORING, CLI_DEPLOYMENT
    }


	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.widget.slamanagement.client.views.SLAPolicyEditorView.Presenter#addSLAPolicy()
	 */
	@Override
	public void addSLAPolicy() {
		SLAPolicyModel slaPolicyModel = new SLAPolicyModel();
		slaPolicyModel.setAvailableMetrics(slaPolicyMetricTypes);
		slaPolicyModel.set(Strings.NEW_COMPONENT, true);
		slaPolicies.add(slaPolicyModel);

		slaPolicyModel.addChangeListener(new ChangeListener(){

			@Override
			public void modelChanged(ChangeEvent event) {
				onSLAPolicyFieldChanged();
			}});

		slaPolicyEditorView.bindSLAPolicies(slaPolicies);
		slaPolicyEditorView.enableToProceed(false);
	}

	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.widget.slamanagement.client.views.SLAPolicyEditorView.Presenter#onSLAPolicyDeleteButtonClick(eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAPolicyModel)
	 */
	@Override
	public void onSLAPolicyDeleteButtonClick(SLAPolicyModel slaPolicyModel) {
		slaPolicies.remove(slaPolicyModel);
		slaPolicyEditorView.bindSLAPolicies(slaPolicies);
		onSLAPolicyFieldChanged();
	}

	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.widget.slamanagement.client.views.SLAPolicyEditorView.Presenter#onSLAPolicyCancel()
	 */
	@Override
	public void onSLAPolicyCancel() {
		goTo(new SearchPlace(Strings.EMPTY));
	}

	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.widget.slamanagement.client.views.SLAPolicyEditorView.Presenter#onSLAPolicyDone()
	 */
	@Override
	public void onSLAPolicyDone() {
		manageDeploymentState();
	}

	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.widget.deployment.client.views.DeployApplicationView.Presenter#onCancelDeploymentClick()
	 */
	@Override
	public void onCancelDeploymentClick() {
		goTo(new SearchPlace(Strings.EMPTY));
	}

	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.widget.deployment.client.views.CreateDBView.Presenter#onCancelDBCreationClick()
	 */
	@Override
	public void onCancelDBCreationClick() {
		goTo(new SearchPlace(Strings.EMPTY));
	}

	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.widget.slamanagement.client.views.SLAPolicyEditorView.Presenter#onSLAPolicyFieldChanged()
	 */
	@Override
	public void onSLAPolicyFieldChanged() {
		boolean enable = false;
		if (isSLAPoliciesOK())
			enable = true;

		if (slaPolicyEditorView!=null)
			slaPolicyEditorView.enableToProceed(enable);
	}

	/**
	 * Validate created SLA policies
	 * @return
	 */
	private boolean isSLAPoliciesOK() {
		boolean result = true;

		for (SLAPolicyModel policy: slaPolicies){
			if (policy.getMetricType() == null)
				result = false;
			if (policy.getDuration() == null)
				result = false;
			if (policy.getExpression() == null)
				result = false;
			if (policy.getNumberOfBreaches() == null)
				result = false;
			if (!result)
				break;
		}

		return result;
	};

}
