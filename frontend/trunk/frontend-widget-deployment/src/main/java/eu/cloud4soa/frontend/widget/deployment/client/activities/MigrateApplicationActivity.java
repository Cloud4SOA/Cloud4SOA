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
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserCredentialsModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.client.places.ApplicationProfileAware;
import eu.cloud4soa.frontend.commons.client.places.MigratePlace;
import eu.cloud4soa.frontend.commons.client.places.PaaSOfferingAware;
import eu.cloud4soa.frontend.commons.client.services.soa.*;
import eu.cloud4soa.frontend.widget.deployment.client.views.MigrateApplicationView;

/**
 * Migrate application activity. Place must specify both application and offering for this activity to start.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class MigrateApplicationActivity extends Cloud4SoaActivity implements MigrateApplicationView.Presenter {

    private MigrateApplicationView view = GWT.create(MigrateApplicationView.class);
    private UserManagementAndSecurityServiceAsync userService = GWT.create(UserManagementAndSecurityService.class);
    private ModelManagerServiceAsync modelManagerService = GWT.create(ModelManagerService.class);
    private ApplicationDeploymentServiceAsync applicationDeploymentService = GWT.create(ApplicationDeploymentService.class);
    private String applicationUriId;
    private String offeringUriId;
    private UserCredentialsModel userCredentialsModel;

    public MigrateApplicationActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {
        super(place, clientFactory);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view);
        registerViewDetacher(view);
        applicationUriId = place instanceof ApplicationProfileAware ? ((ApplicationProfileAware) place).getApplicationProfileUriId() : null;
        offeringUriId = place instanceof PaaSOfferingAware ? ((PaaSOfferingAware) place).getPaaSOfferingUriId() : null;

        if (applicationUriId == null || offeringUriId == null)
            goTo(new MigratePlace(applicationUriId, offeringUriId));
        else
            askCredentials();
    }

    private void askCredentials() {
        view.setViewStatus(MigrateApplicationView.ViewStatus.ASK_CREDENTIALS);

        userService.readUserCredentialsForPaaS(offeringUriId, new AsyncCallback<UserCredentialsModel>() {

            @Override
            public void onFailure(Throwable caught) {
                // failure means that credentials are not there.
                userCredentialsModel = new UserCredentialsModel();
                userCredentialsModel.set(UserCredentialsModel.PAAS_URIID, offeringUriId);
                userCredentialsModel.set(UserCredentialsModel.USER_URIID, getClientFactory().getCurrentUser().getKey());
                view.bindCredentialsForm(userCredentialsModel);
            }

            @Override
            public void onSuccess(UserCredentialsModel result) {
                userCredentialsModel = result;
                view.bindCredentialsForm(userCredentialsModel);
            }
        });


        modelManagerService.retrieveOnePaaSOffering(offeringUriId, new ActivityCallback<PaaSOfferingModel>() {
            @Override
            public void onSuccess(PaaSOfferingModel offeringModel) {
                view.bindPaaSOfferingForm(offeringModel);
            }
        });

    }

    private void migrateDatabase() {
        view.setViewStatus(MigrateApplicationView.ViewStatus.DATABASE_MIGRATION_PROGRESS);

        applicationDeploymentService.migrateDatabase(applicationUriId, offeringUriId, new ActivityCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                showTargetEnvironmentDetails();
            }
        });
    }

    private void showTargetEnvironmentDetails() {
        view.setViewStatus(MigrateApplicationView.ViewStatus.SHOW_TARGET_ENVIRONMENT_DETAILS);
        modelManagerService.retrieveOneApplicationInstance(applicationUriId, new ActivityCallback<ApplicationModel>() {
            @Override
            public void onSuccess(ApplicationModel result) {

                SoftwareComponentModel databaseModel = null;

                for (SoftwareComponentModel softwareComponentModel : result.getSoftwareComponents())
                    if (SoftwareComponentModel.TYPE_SQL_DATABASE.equals(softwareComponentModel.getType())
                            || SoftwareComponentModel.TYPE_NO_SQL_DATABASE.equals(softwareComponentModel.getType())) {
                        databaseModel = softwareComponentModel;
                        break;
                    }

                if (databaseModel != null)
                    view.bindDatabaseComponentForm(databaseModel);
                else
                    // no database, so go straight to upload
                    uploadArtifact();
            }
        });


    }

    private void uploadArtifact() {
        view.setViewStatus(MigrateApplicationView.ViewStatus.UPLOAD_ARTIFACT);

        modelManagerService.retrieveOneApplicationInstance(applicationUriId, new ActivityCallback<ApplicationModel>() {
            @Override
            public void onSuccess(ApplicationModel result) {
                view.bindApplicationForm(result);
            }
        });
    }

    private void migrateApplication() {
        view.setViewStatus(MigrateApplicationView.ViewStatus.APPLICATION_MIGRATION_PROGRESS);

        applicationDeploymentService.migrateApplication(applicationUriId, offeringUriId, new ActivityCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                showEndSummary();
            }
        });

    }

    private void showEndSummary() {
        view.setViewStatus(MigrateApplicationView.ViewStatus.END_SUMMARY);

    }

    private void showCliInstructions() {
        view.setViewStatus(MigrateApplicationView.ViewStatus.CLI_INSTRUCTIONS);
        view.populateCliCard(
                this.getClientFactory().getCurrentUser().<String>get(UserModel.USER_ACCOUNTNAME),
                applicationUriId,
                offeringUriId
        );
    }

    @Override
    public void onCredentialsAccepted() {

        if (Strings.isEmpty(userCredentialsModel.getKey()))
            userService.storeUserCredentialsForPaaS(userCredentialsModel, new ActivityCallback<Void>() {
                @Override
                public void onSuccess(Void result) {
                    checkIfMigrationNeedsToBeDoneViaCli();
                }
            });
        else
            userService.updateUserCredentialsForPaaS(userCredentialsModel, new ActivityCallback<Void>() {
                @Override
                public void onSuccess(Void result) {
                    checkIfMigrationNeedsToBeDoneViaCli();
                }
            });

    }

    private void checkIfMigrationNeedsToBeDoneViaCli() {
        // check if the application needs to be migrate with the CLI
        modelManagerService.retrieveOnePaaSOffering(offeringUriId, new ActivityCallback<PaaSOfferingModel>() {
            @Override
            public void onSuccess(PaaSOfferingModel result) {

                if (result.isGitSupported() && result.isArchiveSupported()) {
                    // both styles are supported. Ask the user
                    askMigrationStyle();
                } else if (result.isGitSupported()) {
                    // git is supported. Direct the user to the CLI
                    showCliInstructions();
                } else if (result.isArchiveSupported()) {
                    // archive is supported. Go ahead with the GUI
                    checkDatabaseMigration();
                } else {
                    // no deployment method is supported
                    performOperationManually();
                }
            }
        });
    }

    @Override
    public void onMigrationStyleSelected(MigrateApplicationView.MigrationStyle migrationStyle) {
        switch (migrationStyle) {

            case UNKNOWN:
                checkIfMigrationNeedsToBeDoneViaCli();
                break;
            case CLI:
                showCliInstructions();
                break;
            case ARCHIVE:
                checkDatabaseMigration();
                break;
        }
    }

    private void askMigrationStyle() {
        view.setViewStatus(MigrateApplicationView.ViewStatus.ASK_MIGRATION_STYLE);
    }

    private void performOperationManually() {
        view.setViewStatus(MigrateApplicationView.ViewStatus.SHOW_MANUAL_INSTRUCTIONS);
    }

    private void checkDatabaseMigration() {
        // check whether the application needs database migration or not

        modelManagerService.retrieveOneApplicationInstance(applicationUriId, new ActivityCallback<ApplicationModel>() {
            @Override
            public void onSuccess(ApplicationModel result) {

                boolean hasDatabase = false;

                for (SoftwareComponentModel softwareComponentModel : result.getSoftwareComponents())
                    if (SoftwareComponentModel.TYPE_SQL_DATABASE.equals(softwareComponentModel.getType())
                            || SoftwareComponentModel.TYPE_NO_SQL_DATABASE.equals(softwareComponentModel.getType())) {
                        hasDatabase = true;
                        break;
                    }

                if (hasDatabase)
                    migrateDatabase();
                else
                    showTargetEnvironmentDetails();
            }
        });
    }

    @Override
    public void onTargetEnvironmentNextClick() {
        uploadArtifact();
    }

    @Override
    public void onDeployClick() {
        view.submitNewArtifact();
    }

    @Override
    public void onDeployUploadComplete() {
        migrateApplication();
    }
}
