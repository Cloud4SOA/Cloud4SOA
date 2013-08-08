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

package eu.cloud4soa.frontend.widget.deployment.client.views;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.event.*;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.*;
import com.extjs.gxt.ui.client.widget.layout.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserCredentialsModel;
import eu.cloud4soa.frontend.commons.client.gxt.MetadataCache;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

/**
 * Migrate view implementation.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class MigrateApplicationViewImpl extends LayoutContainer implements MigrateApplicationView {

    private Presenter presenter;
    private CardLayout cardLayout = new CardLayout();
    private LayoutContainer askCredentialCard = new LayoutContainer();
    private LayoutContainer databaseMigrationProgressCard = new LayoutContainer();
    private LayoutContainer showTargetEnvironmentDetailsCard = new LayoutContainer();
    private LayoutContainer uploadArtifactCard = new LayoutContainer();
    private LayoutContainer applicationMigrationProgressCard = new LayoutContainer();
    private LayoutContainer endSummaryCard = new LayoutContainer();
    private LayoutContainer cliInstructionsCard = new LayoutContainer();
    private LayoutContainer askMigrationStyleCard = new LayoutContainer();
    private LayoutContainer showManualInstructionsCard = new LayoutContainer();
    private FormPanel providerForm;
    private FieldSet providerFieldSet;
    private FormPanel credentialsForm;
    private FieldSet credentialsFieldSet;
    private FormPanel applicationForm;
    private FieldSet applicationFieldSet;
    private FormPanel targetEnvironmentForm;
    private FieldSet targetEnvironmentFieldSet;

    private CliMigrateView cliMigrateView = new CliMigrateView();

    private ManualInstructionsView manualInstructionsView = new ManualInstructionsView();


    public MigrateApplicationViewImpl() {

        this.setLayout(new FitLayout());
        this.addStyleName("c4s-white-bg");


        ContentPanel cardContainer = new ContentPanel(cardLayout);
        cardContainer.setHeaderVisible(true);
        cardContainer.setBorders(true);
        cardContainer.setHeading("Migrate application");

        // initialize the credential card
        initializeAskCredentialCard();
        cardContainer.add(askCredentialCard);

        // initialize the database migration card
        initializeDatabaseMigrationProgressCard();
        cardContainer.add(databaseMigrationProgressCard);

        // target environment details card
        initializeTargetEnvironmentCard();
        cardContainer.add(showTargetEnvironmentDetailsCard);

        // upload artifact card
        initializeUploadArtifactCard();
        cardContainer.add(uploadArtifactCard);

        // application migration progress card
        initializeApplicationMigrationProgressCard();
        cardContainer.add(applicationMigrationProgressCard);

        // summary card
        initializeEndSummaryCard();
        cardContainer.add(endSummaryCard);

        // cli instructions card
        initializeCliInstructionsCard();
        cardContainer.add(cliInstructionsCard);

        // ask migration style card
        initializeAskMigrationStyleCard();
        cardContainer.add(askMigrationStyleCard);

        // show manual instruction card
        initializeShowManualInstructionsCard();
        cardContainer.add(showManualInstructionsCard);

        setViewStatus(ViewStatus.ASK_CREDENTIALS);

        add(cardContainer);
    }

    private void initializeShowManualInstructionsCard() {
        showManualInstructionsCard.add(manualInstructionsView);
    }

    private void initializeCliInstructionsCard() {
       cliInstructionsCard.add(cliMigrateView);
    }

    private void initializeEndSummaryCard() {
        endSummaryCard.setLayout(new CenterLayout());
        endSummaryCard.addText("Your application was migrated to the new PaaS provider.");
    }

    private void initializeApplicationMigrationProgressCard() {
        applicationMigrationProgressCard.setLayout(new CenterLayout());
        applicationMigrationProgressCard.addText("Please, wait while Cloud4SOA migrates your application...");
    }

    private void initializeDatabaseMigrationProgressCard() {
        databaseMigrationProgressCard.setLayout(new CenterLayout());
        databaseMigrationProgressCard.addText("Please, wait while Cloud4SOA migrates your database...");
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setViewStatus(ViewStatus viewStatus) {

        switch (viewStatus) {

            case ASK_CREDENTIALS:
                cardLayout.setActiveItem(askCredentialCard);
                break;
            case DATABASE_MIGRATION_PROGRESS:
                cardLayout.setActiveItem(databaseMigrationProgressCard);
                break;
            case SHOW_TARGET_ENVIRONMENT_DETAILS:
                cardLayout.setActiveItem(showTargetEnvironmentDetailsCard);
                break;
            case UPLOAD_ARTIFACT:
                cardLayout.setActiveItem(uploadArtifactCard);
                break;
            case APPLICATION_MIGRATION_PROGRESS:
                cardLayout.setActiveItem(applicationMigrationProgressCard);
                break;
            case END_SUMMARY:
                cardLayout.setActiveItem(endSummaryCard);
                break;
            case CLI_INSTRUCTIONS:
                cardLayout.setActiveItem(cliInstructionsCard);
                break;
            case ASK_MIGRATION_STYLE:
                cardLayout.setActiveItem(askMigrationStyleCard);
                break;
            case SHOW_MANUAL_INSTRUCTIONS:
                cardLayout.setActiveItem(showManualInstructionsCard);
                break;
        }

    }

    private void initializeAskMigrationStyleCard() {
        FormData formData = new FormData("100%");

        askMigrationStyleCard.setLayout(new RowLayout(Style.Orientation.VERTICAL));


        FormPanel migrationStyleForm = new FormPanel();
        migrationStyleForm.setHeaderVisible(false);

        FieldSet migrationStyleFieldSet = new FieldSet();
        migrationStyleForm.add(migrationStyleFieldSet, formData);


        migrationStyleFieldSet.setHeading("Select migration style");
        migrationStyleFieldSet.setCheckboxToggle(false);
        migrationStyleFieldSet.setCollapsible(false);
        migrationStyleFieldSet.setStyleAttribute("padding", "8px");

        FormLayout providerFormLayout = new FormLayout();
        providerFormLayout.setLabelAlign(FormPanel.LabelAlign.LEFT);

        migrationStyleFieldSet.setLayout(providerFormLayout);

        migrationStyleFieldSet.add(new Text("For selected target provider Cloud4SOA supports both deployment with GIT by mean of the Cloud4SOA Command Line Interface and deployment with archive upload by mean of the Graphical User Interface. Which deployment style would you like to use?"));

        // height=-1 Component computed size
        askMigrationStyleCard.add(migrationStyleForm, new RowData(1, -1, new Margins(0)));

        Button gitButton = new Button("GIT with CLI");
        Button guiButton = new Button("Upload archive");

        migrationStyleForm.setButtonAlign(Style.HorizontalAlignment.CENTER);
        migrationStyleForm.getButtonBar().add(gitButton);
        migrationStyleForm.getButtonBar().add(guiButton);

        gitButton.addListener(Events.Select, new Listener<ButtonEvent>() {

            @Override
            public void handleEvent(ButtonEvent be) {
                presenter.onMigrationStyleSelected(MigrationStyle.CLI);
            }
        });

        guiButton.addListener(Events.Select, new Listener<ButtonEvent>() {
            @Override
            public void handleEvent(ButtonEvent be) {
                presenter.onMigrationStyleSelected(MigrationStyle.ARCHIVE);
            }
        });


    }

    private void initializeAskCredentialCard() {
        FormData formData = new FormData("100%");

        askCredentialCard.setLayout(new RowLayout(Style.Orientation.VERTICAL));


        providerForm = new FormPanel();
        providerForm.setHeaderVisible(false);
        credentialsForm = new FormPanel();
        credentialsForm.setHeaderVisible(false);

        providerFieldSet = new FieldSet();
        providerForm.add(providerFieldSet, formData);

        credentialsFieldSet = new FieldSet();
        credentialsForm.add(credentialsFieldSet, formData);

        providerFieldSet.setHeading("PaaS Provider to migrate to");
        providerFieldSet.setCheckboxToggle(false);
        providerFieldSet.setCollapsible(false);
        providerFieldSet.setStyleAttribute("padding", "8px");

        FormLayout providerFormLayout = new FormLayout();
        providerFormLayout.setLabelAlign(FormPanel.LabelAlign.LEFT);

        providerFieldSet.setLayout(providerFormLayout);

        credentialsFieldSet.setHeading("User Credentials in new PaaS Provider");
        credentialsFieldSet.setCheckboxToggle(false);
        credentialsFieldSet.setCollapsible(false);
        credentialsFieldSet.setStyleAttribute("padding", "8px");

        FormLayout credentialsFormLayout = new FormLayout();
        credentialsFormLayout.setLabelAlign(FormPanel.LabelAlign.LEFT);
        credentialsFieldSet.setLayout(credentialsFormLayout);

        FormLayout applicationFormLayout = new FormLayout();
        applicationFormLayout.setLabelAlign(FormPanel.LabelAlign.LEFT);

        // height=-1 Component computed size
        askCredentialCard.add(providerForm, new RowData(1, -1, new Margins(0)));
        askCredentialCard.add(credentialsForm, new RowData(1, -1, new Margins(0)));

        Button acceptButton = new Button("Next");

        credentialsForm.setButtonAlign(Style.HorizontalAlignment.CENTER);
        credentialsForm.getButtonBar().add(acceptButton);

        acceptButton.addListener(Events.Select, new Listener<ButtonEvent>() {

            @Override
            public void handleEvent(ButtonEvent be) {
                presenter.onCredentialsAccepted();
            }
        });

        FormButtonBinding binding = new FormButtonBinding(credentialsForm);
        binding.addButton(acceptButton);

    }

    private void initializeUploadArtifactCard() {
        FormData formData = new FormData("100%");
        uploadArtifactCard.setLayout(new RowLayout(Style.Orientation.VERTICAL));


        applicationForm = new FormPanel();
        applicationForm.setHeaderVisible(false);
        applicationFieldSet = new FieldSet();

        applicationForm.add(applicationFieldSet, formData);

        applicationFieldSet.setHeading("Application");
        applicationFieldSet.setCheckboxToggle(false);
        applicationFieldSet.setCollapsible(false);
        applicationFieldSet.setStyleAttribute("padding", "8px");

        FormLayout applicationFormLayout = new FormLayout();
        applicationFormLayout.setLabelAlign(FormPanel.LabelAlign.LEFT);

        applicationFieldSet.setLayout(applicationFormLayout);

        uploadArtifactCard.add(applicationForm, new RowData(1, -1, new Margins(0)));

        applicationForm.setEncoding(FormPanel.Encoding.MULTIPART);
        applicationForm.setMethod(FormPanel.Method.POST);
        applicationForm.setAction("applicationArtifactUpload");

        Button deployButton = new Button("Migrate application");
        applicationForm.setButtonAlign(Style.HorizontalAlignment.CENTER);
        applicationForm.getButtonBar().add(deployButton);

        FormButtonBinding binding = new FormButtonBinding(applicationForm);
        binding.addButton(deployButton);

        // Checking other forms text values before accepting to deploy the
        // application
        deployButton.addListener(Events.Select, new Listener<ButtonEvent>() {

            @Override
            public void handleEvent(ButtonEvent be) {
                presenter.onDeployClick();
            }
        });

        // Handling completed archive submission
        applicationForm.addListener(Events.Submit, new Listener<FormEvent>() {

            @Override
            public void handleEvent(FormEvent be) {
                presenter.onDeployUploadComplete();
            }
        });

    }

    private void initializeTargetEnvironmentCard() {
        FormData formData = new FormData("100%");

        showTargetEnvironmentDetailsCard.setLayout(new RowLayout(Style.Orientation.VERTICAL));

        targetEnvironmentForm = new FormPanel();
        targetEnvironmentForm.setHeaderVisible(false);
        targetEnvironmentFieldSet = new FieldSet();

        targetEnvironmentForm.add(targetEnvironmentFieldSet, formData);

        targetEnvironmentFieldSet.setHeading("New database information");
        targetEnvironmentFieldSet.setCheckboxToggle(false);
        targetEnvironmentFieldSet.setCollapsible(false);
        targetEnvironmentFieldSet.setStyleAttribute("padding", "8px");

        FormLayout applicationformLayout = new FormLayout();
        applicationformLayout.setLabelAlign(FormPanel.LabelAlign.LEFT);

        targetEnvironmentFieldSet.setLayout(applicationformLayout);

        // height=-1 Component computed size
        showTargetEnvironmentDetailsCard.add(targetEnvironmentForm, new RowData(1, -1, new Margins(0)));

        Button acceptButton = new Button("Next");
        targetEnvironmentForm.setButtonAlign(Style.HorizontalAlignment.CENTER);
        targetEnvironmentForm.getButtonBar().add(acceptButton);

        acceptButton.addListener(Events.Select, new Listener<ButtonEvent>() {
            @Override
            public void handleEvent(ButtonEvent be) {
                presenter.onTargetEnvironmentNextClick();
            }
        });

    }

    @Override
    public void bindPaaSOfferingForm(final PaaSOfferingModel paasOfferingModel) {

        providerFieldSet.removeAll();

        // build the application details form
        MetadataCache.getInstance().buildDynamicForm(
                MetadataMapper.CONTEXT_DEPLOYMENT_FORM, paasOfferingModel,
                providerFieldSet, new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {
                Info.display("error", "Something went wrong: " + caught.toString());
            }

            @Override
            public void onSuccess(Void result) {

                FormBinding formBinding = new FormBinding(providerForm, true);
                formBinding.bind(paasOfferingModel);
                formBinding.setUpdateOriginalValue(true);

                providerForm.layout();

            }
        });
    }

    @Override
    public void bindCredentialsForm(final UserCredentialsModel credentialsModel) {

        credentialsFieldSet.removeAll();

        // build the application details form
        MetadataCache.getInstance().buildDynamicForm(
                MetadataMapper.CONTEXT_DEPLOYMENT_FORM, credentialsModel,
                credentialsFieldSet, new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {
                Info.display("error", "Something went wrong: " + caught.toString());
            }

            @Override
            public void onSuccess(Void result) {

                FormBinding formBinding = new FormBinding(credentialsForm, true);
                formBinding.bind(credentialsModel);
                formBinding.setUpdateOriginalValue(true);

                askCredentialCard.layout();

            }
        });
    }

    @Override
    public void bindApplicationForm(final ApplicationModel applicationModel) {

        applicationFieldSet.removeAll();

        // build the application details form
        MetadataCache.getInstance().buildDynamicForm(
                MetadataMapper.CONTEXT_DEPLOYMENT_FORM, applicationModel,
                applicationFieldSet, new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {
                Info.display("error", "Something went wrong: " + caught.toString());
            }

            @Override
            public void onSuccess(Void result) {

                FileUploadField fileUpload = new FileUploadField();
                fileUpload.setFieldLabel("Application binary");
                fileUpload.setAllowBlank(false);
                // without a name file upload doesn't work on FF
                fileUpload.setName("app-binary");
                applicationFieldSet.add(fileUpload);

                FormBinding formBinding = new FormBinding(applicationForm, true);
                formBinding.bind(applicationModel);
                formBinding.setUpdateOriginalValue(true);

                applicationForm.layout();

            }
        });
    }

    @Override
    public void bindDatabaseComponentForm(final SoftwareComponentModel softwareComponentModel) {

        targetEnvironmentFieldSet.removeAll();

        // build the application details form
        MetadataCache.getInstance().buildDynamicForm(
                MetadataMapper.CONTEXT_DBCREATION_REPORT,
                softwareComponentModel, targetEnvironmentFieldSet, new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable caught) {
                Info.display("error",
                        "Something went wrong: " + caught.toString());
            }

            @Override
            public void onSuccess(Void result) {
                LabelField label = new LabelField();
                label.setText("Please, take note of the new database environment and adapt your application before uploading the new artifact.");
                targetEnvironmentFieldSet.add(label);

                FormBinding formBinding = new FormBinding(targetEnvironmentForm, true);
                formBinding.bind(softwareComponentModel);
                formBinding.setUpdateOriginalValue(true);

                targetEnvironmentForm.layout();

            }
        });
    }

    private native String host(String uri) /*-{
        var pattern = new RegExp('^(.*:)//([0-9a-z\\-.]+)(:[0-9]+)?(.*)$');
        var match = pattern.exec(uri);
        return (match == null) ? '' : match[2];
      }-*/;


    @Override
    public void populateCliCard(String username, String applicationUriId, String targetOfferingUriId) {
        cliMigrateView.populateInfo(
                host(GWT.getHostPageBaseURL()),
                GWT.getHostPageBaseURL(),
                username,
                applicationUriId,
                targetOfferingUriId
        );
    }

    @Override
    public void submitNewArtifact() {
        // todo show some progress entertainment
        applicationForm.submit();
    }
}
