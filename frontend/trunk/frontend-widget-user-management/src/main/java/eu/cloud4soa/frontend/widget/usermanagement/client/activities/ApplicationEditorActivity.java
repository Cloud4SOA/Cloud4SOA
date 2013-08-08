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

package eu.cloud4soa.frontend.widget.usermanagement.client.activities;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.client.dialog.DialogHelper;
import eu.cloud4soa.frontend.commons.client.events.UserApplicationDeletedEvent;
import eu.cloud4soa.frontend.commons.client.places.ApplicationEditorPlace;
import eu.cloud4soa.frontend.commons.client.places.ApplicationProfileAware;
import eu.cloud4soa.frontend.commons.client.places.SearchPlace;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerService;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerServiceAsync;
import eu.cloud4soa.frontend.widget.usermanagement.client.views.ApplicationEditorView;

/**
 * Detailed editor of an application profile.
 * It's a panel that shows all the details of the application profile and allow to edit it.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationEditorActivity extends Cloud4SoaActivity implements ApplicationEditorView.Presenter {

    private ApplicationEditorView view;

    private ModelManagerServiceAsync modelManagerService = GWT.create(ModelManagerService.class);

    private ApplicationModel applicationModel;


    public ApplicationEditorActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {
        super(place, clientFactory);
    }

    private String getCurrentApplicationUriId() {
        if (place instanceof ApplicationProfileAware)
            return ((ApplicationProfileAware) place).getApplicationProfileUriId();

        return null;
    }

    private String getApplicationTemplate() {
        if (place instanceof ApplicationEditorPlace)
            return ((ApplicationEditorPlace) place).getApplicationTemplate();

        return null;
    }


    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view = GWT.create(ApplicationEditorView.class);
        view.setPresenter(this);
        panel.setWidget(view);
        refreshApplicationDetails();
        registerViewDetacher(view);
    }

    private void refreshApplicationDetails() {

        if (Strings.NEW_INSTANCE.equals(getCurrentApplicationUriId())) {
            modelManagerService.createApplicationFromTemplate(getApplicationTemplate(), new ActivityCallback<ApplicationModel>() {
                @Override
                public void onSuccess(ApplicationModel result) {
                    applicationModel = result;
                    view.bindInstance();
                }
            });

        } else {

            // retrieve the selected application
            modelManagerService.retrieveOneApplicationInstance(getCurrentApplicationUriId(), new ActivityCallback<ApplicationModel>() {

                @Override
                public void onSuccess(ApplicationModel result) {
                    applicationModel = result;
                    view.bindInstance();
                }
            });
        }
    }


        @Override
        public void onApplicationDetailsSaveButtonClick () {

            if (applicationModel.getKey() != null)

                modelManagerService.updateApplicationInstance(applicationModel, new ActivityCallback<Void>() {

                    @Override
                    public void onSuccess(Void result) {
                        Info.display("debug", "Successful updated");
                        refreshApplicationDetails();
                    }
                });
            else
                modelManagerService.storeApplicationProfile(applicationModel, new ActivityCallback<String>() {

                    @Override
                    public void onSuccess(String result) {
                        goTo(new ApplicationEditorPlace(result));
                    }
                });
        }


        @Override
        public void onApplicationDetailsCloseButtonClick () {
            Info.display("debug", "Close (click");
            // return to the application list
            goTo(new ApplicationEditorPlace(null));
        }

        @Override
        public void onHardwareComponentDeleteButtonClick (HardwareComponentModel hardwareComponentModel){
            applicationModel.getHardwareComponents().remove(hardwareComponentModel);
            view.bindInstance();
        }

        @Override
        public void onSoftwareComponentDeleteButtonClick (SoftwareComponentModel softwareComponentModel){
            applicationModel.getSoftwareComponents().remove(softwareComponentModel);
            view.bindInstance();
        }

    private void addHardwareComponent(String componentType) {
        modelManagerService.createHardwareComponent(componentType, new ActivityCallback<HardwareComponentModel>() {

            @Override
            public void onSuccess(HardwareComponentModel result) {
                result.set(Strings.NEW_COMPONENT, true);
                applicationModel.getHardwareComponents().add(result);
                view.bindInstance();
            }
        });
    }

    private void addSoftwareComponent(String componentType) {
        modelManagerService.createSoftwareComponent(componentType, new ActivityCallback<SoftwareComponentModel>() {

            @Override
            public void onSuccess(SoftwareComponentModel result) {
                result.set(Strings.NEW_COMPONENT, true);
                applicationModel.getSoftwareComponents().add(result);
                view.bindInstance();
            }
        });
    }

    @Override
    public void onApplicationDetailsDeleteButtonClick() {

        if (Strings.isEmpty(applicationModel.getKey())) {
            // not saved yet, so just refresh the page
            goTo(new ApplicationEditorPlace(Strings.NEW_INSTANCE));
            return;
        }

        final Dialog confirm = DialogHelper.showConfirmationDialog("Delete application", "You are about to delete your application profile '" + applicationModel.getDisplayName() + "'. Are you sure?");

        confirm.getButtonById(Dialog.YES).addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                confirm.hide();

                modelManagerService.removeApplicationProfile(
                        getCurrentApplicationUriId(), new AsyncCallback<Void>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        DialogHelper.showErrorDialog("There was an error while trying to remove application profile "
                                + getCurrentApplicationUriId());
                        handleRPCFailure(caught);
                    }

                    @Override
                    public void onSuccess(Void result) {
                        clientFactory.getEventBus().fireEvent(new UserApplicationDeletedEvent(getCurrentApplicationUriId()));
                        view.bindInstance();
                        goTo(new ApplicationEditorPlace(Strings.EMPTY));
                    }
                });
            }
        });

        confirm.getButtonById(Dialog.NO).addSelectionListener(new SelectionListener<ButtonEvent>() {
            @Override
            public void componentSelected(ButtonEvent ce) {
                confirm.hide();
                Info.display("Delete application", "Operation canceled.");
            }
        });

    }

    @Override
    public void onApplicationDetailsSearchButtonClick() {

        if (applicationModel.getKey() != null)

            modelManagerService.updateApplicationInstance(applicationModel, new ActivityCallback<Void>() {

                @Override
                public void onSuccess(Void result) {
                    goTo(new SearchPlace(getCurrentApplicationUriId()));
                }
            });
        else
            modelManagerService.storeApplicationProfile(applicationModel, new ActivityCallback<String>() {

                @Override
                public void onSuccess(String result) {
                    goTo(new SearchPlace(result));
                }
            });
    }


    @Override
    public ApplicationModel getInstance() {
        return applicationModel;
    }

    @Override
    public void addHardwareComputeComponent() {
        addHardwareComponent(HardwareComponentModel.TYPE_COMPUTATION);
    }

    @Override
    public void addHardwareNetworkComponent() {
        addHardwareComponent(HardwareComponentModel.TYPE_NETWORK);
    }

    @Override
    public void addHardwareHttpRequestHandlerComponent() {
        addHardwareComponent(HardwareComponentModel.TYPE_HTTP_REQUEST_HANDLER);
    }

    @Override
    public void addHardwareStorageComponent() {
        addHardwareComponent(HardwareComponentModel.TYPE_STORAGE);
    }

    @Override
    public void addSoftwareGenericComponent() {
        addSoftwareComponent(SoftwareComponentModel.TYPE_GENERIC);
    }

    @Override
    public void addSoftwareSqlDatabaseComponent() {
        addSoftwareComponent(SoftwareComponentModel.TYPE_SQL_DATABASE);
    }

    @Override
    public void addSoftwareNoSqlDatabaseComponent() {
        addSoftwareComponent(SoftwareComponentModel.TYPE_NO_SQL_DATABASE);
    }

}
