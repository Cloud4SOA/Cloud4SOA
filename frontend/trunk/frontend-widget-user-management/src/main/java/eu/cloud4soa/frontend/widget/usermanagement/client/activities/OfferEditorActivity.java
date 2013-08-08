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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.places.OfferEditorPlace;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerService;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerServiceAsync;
import eu.cloud4soa.frontend.widget.usermanagement.client.views.OfferEditorView;

/**
 * Detailed editor of an offer.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class OfferEditorActivity extends Cloud4SoaActivity implements OfferEditorView.Presenter {

    private OfferEditorView view;

    private PaaSOfferingModel paaSOffering;

    private ModelManagerServiceAsync modelManagerService = GWT.create(ModelManagerService.class);

    public OfferEditorActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {
        super(place, clientFactory);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view = GWT.create(OfferEditorView.class);
        view.setPresenter(this);
        panel.setWidget(view);
        refreshOfferDetails();
        registerViewDetacher(view);
    }

    private String getCurrentOfferUriId() {
        if (place instanceof OfferEditorPlace)
            return ((OfferEditorPlace) place).getPaaSOfferingUriId();

        return null;
    }

    private void refreshOfferDetails() {
        // retrieve the selected application
        modelManagerService.retrieveOnePaaSOffering(getCurrentOfferUriId(), new ActivityCallback<PaaSOfferingModel>() {

            @Override
            public void onSuccess(PaaSOfferingModel result) {
                paaSOffering = result;
                view.bindPaaSOffering(result);
            }
        });
    }


    @Override
    public void onSaveButtonClick() {

        if (Strings.isEmpty(paaSOffering.getKey()))
            modelManagerService.storePaaSOffering(paaSOffering, new ActivityCallback<String>() {

                @Override
                public void onSuccess(String result) {
                    goTo(new OfferEditorPlace(result));
                }
            });

        else
            modelManagerService.updatePaaSOffering(paaSOffering, new ActivityCallback<Void>() {

                @Override
                public void onSuccess(Void result) {
                    refreshOfferDetails();
                }
            });
    }

    @Override
    public void onCloseButtonClick() {
        goTo(new OfferEditorPlace(Strings.EMPTY));
    }

    @Override
    public void onHardwareComponentDeleteButtonClick(HardwareComponentModel hardwareComponentModel) {
        paaSOffering.getHardwareComponents().remove(hardwareComponentModel);
        view.bindPaaSOffering(paaSOffering);
    }

    @Override
    public void onSoftwareComponentDeleteButtonClick(SoftwareComponentModel softwareComponentModel) {
        paaSOffering.getSoftwareComponents().remove(softwareComponentModel);
        view.bindPaaSOffering(paaSOffering);
    }

    private void addHardwareComponent(String componentType) {
        modelManagerService.createHardwareComponent(componentType, new ActivityCallback<HardwareComponentModel>() {
            @Override
            public void onSuccess(HardwareComponentModel result) {
                result.set(Strings.NEW_COMPONENT, true);
                paaSOffering.getHardwareComponents().add(result);
                view.bindPaaSOffering(paaSOffering);
            }
        });
    }

    private void addSoftwareComponent(String componentType) {
        modelManagerService.createSoftwareComponent(componentType, new ActivityCallback<SoftwareComponentModel>() {
            @Override
            public void onSuccess(SoftwareComponentModel result) {
                result.set(Strings.NEW_COMPONENT, true);
                paaSOffering.getSoftwareComponents().add(result);
                view.bindPaaSOffering(paaSOffering);
            }
        });
    }

    @Override
    public void addHardwareComputeComponent() {
        addHardwareComponent(HardwareComponentModel.TYPE_COMPUTATION);
    }

    @Override
    public void addHardwareGenericComponent() {
        // not managed
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
    public void addNoSqlDatabaseComponent() {
        addSoftwareComponent(SoftwareComponentModel.TYPE_NO_SQL_DATABASE);
    }
}
