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

import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.InteractionStyle;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.client.dialog.DialogHelper;
import eu.cloud4soa.frontend.commons.client.events.PaaSOfferingSelectedEvent;
import eu.cloud4soa.frontend.commons.client.events.SearchProviderEvent;
import eu.cloud4soa.frontend.commons.client.events.UserApplicationDeletedEvent;
import eu.cloud4soa.frontend.commons.client.events.UserApplicationSelectedChangeEvent;
import eu.cloud4soa.frontend.commons.client.places.*;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerService;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerServiceAsync;
import eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService;
import eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryServiceAsync;
import eu.cloud4soa.frontend.widget.usermanagement.client.views.ApplicationProfileView;

/**
 * The application profile read only view activity.
 * It's a panel that shows some basic application profiles data
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationProfileActivity extends Cloud4SoaActivity implements
        ApplicationProfileView.Presenter {

    private ApplicationProfileView view;
    private InteractionStyle interactionStyle = InteractionStyle.CASE_1;
    private ModelManagerServiceAsync modelManagerService = GWT.create(ModelManagerService.class);
    private PaaSOfferingDiscoveryServiceAsync paaSOfferingDiscoveryService = GWT.create(PaaSOfferingDiscoveryService.class);
    private ApplicationModel applicationModel;
    private PaaSOfferingModel selectedPaaSOffering;

    public ApplicationProfileActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {
        super(place, clientFactory);

        addHandler(PaaSOfferingSelectedEvent.TYPE,

                new PaaSOfferingSelectedEvent.Handler() {
                    @Override
                    public void onPaaSOfferingSelected(
                            PaaSOfferingSelectedEvent event) {
                        view.setDeployButtonVisible(event.getPaaSOffering() != null
                                && Boolean.TRUE.equals(ApplicationProfileActivity.this.clientFactory.getCurrentUser().get(UserModel.USER_ROLE_DEPLOY)));
                        selectedPaaSOffering = event.getPaaSOffering();
                    }
                });

    }

    private String getCurrentApplicationUriId() {
        if (place instanceof ApplicationProfileAware)
            return ((ApplicationProfileAware) place).getApplicationProfileUriId();

        return null;
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view = GWT.create(ApplicationProfileView.class);
        view.setPresenter(this);

        view.setCancelButtonVisible(true);
        view.setDeleteButtonVisible(true);
        view.setEditButtonVisible(true);
        view.setDeployButtonVisible(false);

        panel.setWidget(view.asWidget());

        retrieveApplicationProfile();
        if (!(place instanceof MigratePlace && ((MigratePlace) place).getPaaSOfferingUriId() != null)) {
            performMatchmakingSearch();
        }
        registerViewDetacher(view);
    }

    private void performMatchmakingSearch() {
        final MessageBox mb = MessageBox.wait("Searching...",
                Strings.EMPTY, "Searching for matching PaaS Offerings...");
        paaSOfferingDiscoveryService.searchForMatchingPlatform(getCurrentApplicationUriId(), new ActivityCallback<ListLoadResult<PaaSOfferingModel>>() {

            @Override
            public void onSuccess(ListLoadResult<PaaSOfferingModel> result) {
                mb.close();
                view.setDeployButtonVisible(false);
                SearchProviderEvent se = new SearchProviderEvent(applicationModel, result.getData());
                clientFactory.getEventBus().fireEvent(se);
            }
        });
    }

    @Override
    public void onDeleteButtonClick() {

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
                        view.bindApplication(null);
                        goTo(new SearchPlace(Strings.EMPTY));
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
    public void onCancelButtonClick() {
        if (place instanceof MigratePlace)
            goTo(new MigratePlace(Strings.EMPTY, Strings.EMPTY));
        else
            goTo(new SearchPlace(Strings.EMPTY));
    }

    @Override
    public void onEditButtonClick() {
        goTo(new ApplicationEditorPlace(getCurrentApplicationUriId()));
    }

    private void retrieveApplicationProfile() {

        final String uriId = getCurrentApplicationUriId();

        if (Strings.isNotEmpty(uriId)) {

            modelManagerService.retrieveOneApplicationInstance(uriId,
                    new AsyncCallback<ApplicationModel>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            DialogHelper
                                    .showErrorDialog("There was an error while trying to retrieve all application profile");
                            handleRPCFailure(caught);
                        }

                        @Override
                        public void onSuccess(ApplicationModel application) {
                            applicationModel = application;
                            view.bindApplication(applicationModel);
                            clientFactory.getEventBus().fireEvent(new UserApplicationSelectedChangeEvent(uriId));
                        }
                    });
        }
    }

    @Override
    public void onDeployButtonClick() {
        if (place instanceof MigratePlace)
            goTo(new MigratePlace(getCurrentApplicationUriId(), selectedPaaSOffering.getKey()));
        else
            goTo(new DeployPlace(getCurrentApplicationUriId(), selectedPaaSOffering.getKey(), selectedPaaSOffering.getSLATemplate()));
    }
}
