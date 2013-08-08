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

package eu.cloud4soa.frontend.widget.usermanagement.client.views;

import com.extjs.gxt.ui.client.binding.FormBinding;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.jhickman.web.gwt.gxtuibinder.client.GxtEvent;
import com.jhickman.web.gwt.gxtuibinder.client.GxtUiHandler;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.gxt.MetadataCache;
import eu.cloud4soa.frontend.commons.client.resources.Icons;

import static eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper.CONTEXT_APPLICATION_SUMMARY;

/**
 * GXT implementation of the application profile readonly view.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationProfileViewGxtImpl extends Composite implements
        ApplicationProfileView {

    interface Binder extends UiBinder<Component, ApplicationProfileViewGxtImpl> {
    }

    private static Binder binder = GWT.create(Binder.class);

    private Presenter presenter;

    @UiField
    FormPanel applicationProfileForm;

    @UiField
    Button deleteButton;

    @UiField
    Button editButton;

    @UiField
    Button cancelButton;

    @UiField
    Button deployButton;
    @UiField
    ToolBar toolbar;

    public ApplicationProfileViewGxtImpl() {
        initComponent(binder.createAndBindUi(this));

        FormLayout applicationProfileLayout = new FormLayout();
        applicationProfileLayout.setLabelAlign(FormPanel.LabelAlign.RIGHT);
        applicationProfileLayout.setLabelWidth(80);
        applicationProfileLayout.setLabelPad(10);
        applicationProfileForm.setLayout(applicationProfileLayout);

        cancelButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonRewind()));
        cancelButton.setToolTip("Back to the application profiles list");

        editButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.documentEdit()));
        editButton.setToolTip("Edit this application profile");

        deployButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.hardDriveUpload()));
        deployButton.setToolTip("Deploy an application matching this profile onto the selected PaaS Offering");

        deleteButton.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.buttonRemove()));
        deleteButton.setToolTip("Remove this application profile");


    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }


    @GxtUiHandler(uiField = "cancelButton", eventType = GxtEvent.Select)
    public void handleCancelClick(ButtonEvent event) {
        presenter.onCancelButtonClick();
    }

    @GxtUiHandler(uiField = "editButton", eventType = GxtEvent.Select)
    public void handleEditButtonClick(ButtonEvent event) {
        presenter.onEditButtonClick();
    }

    @GxtUiHandler(uiField = "deployButton", eventType = GxtEvent.Select)
    public void handleDeployButtonClick(ButtonEvent event) {
        presenter.onDeployButtonClick();
    }

    @GxtUiHandler(uiField = "deleteButton", eventType = GxtEvent.Select)
    public void handleDeleteButtonClick(ButtonEvent event) {
        presenter.onDeleteButtonClick();
    }


    @Override
    public void setCancelButtonVisible(boolean visible) {
        cancelButton.setVisible(visible);
    }

    @Override
    public void setEditButtonVisible(boolean visible) {
        editButton.setVisible(visible);
    }

    @Override
    public void setDeployButtonVisible(boolean visible) {
        deployButton.setVisible(visible);
    }

    @Override
    public void setDeleteButtonVisible(boolean visible) {
        deleteButton.setVisible(visible);
    }

    @Override
    public void bindApplication(final ApplicationModel applicationModel) {

        applicationProfileForm.removeAll();

        if (applicationModel != null) {

            MetadataCache.getInstance().buildDynamicForm(CONTEXT_APPLICATION_SUMMARY, applicationModel, applicationProfileForm, new AsyncCallback<Void>() {
                @Override
                public void onFailure(Throwable caught) {
                    Info.display("error", "Something went wrong: " + caught.toString());
                }

                @Override
                public void onSuccess(Void result) {
                    FormBinding formBinding = new FormBinding(applicationProfileForm, true);
                    formBinding.bind(applicationModel);
                    formBinding.setUpdateOriginalValue(true);

                    applicationProfileForm.layout();
                }
            });
        }
    }
}
