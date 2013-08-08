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
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.DisplayableKeyValue;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.InteractionStyle;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.SimpleKeyValue;
import eu.cloud4soa.frontend.commons.client.events.InteractionStyleChangeEvent;
import eu.cloud4soa.frontend.commons.client.events.PaaSOfferingDetailsRequestedEvent;
import eu.cloud4soa.frontend.widget.usermanagement.client.views.UserManagementMainView;

import java.util.ArrayList;
import java.util.List;


public class UserManagementMainActivity extends Cloud4SoaActivity implements UserManagementMainView.Presenter {

    // Used to obtain views, eventBus, placeController
    // Alternatively, could be injected via GIN

    private UserManagementMainView view = GWT.create(UserManagementMainView.class);


    private InteractionStyle interactionStyle = InteractionStyle.CASE_1;

    public UserManagementMainActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {
        super(place, clientFactory);
        // when a PaaS offering details request arrives...
        addHandler(PaaSOfferingDetailsRequestedEvent.TYPE, new PaaSOfferingDetailsRequestedEvent.Handler() {
            @Override
            public void onPaaSOfferingDetailsRequested(PaaSOfferingDetailsRequestedEvent event) {
                // ... show the PaaS offering tab
                view.selectPaaSOfferPanel();

            }
        });
    }


    /**
     * Invoked by the ActivityManager to start a new Activity
     */
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
        callServices();
        view.setPresenter(this);
        containerWidget.setWidget(view.asWidget());

        // start activities for tabs (these could be configurable in the future)

        ApplicationProfileActivity applicationProfileActivity = new ApplicationProfileActivity(place, clientFactory);
        applicationProfileActivity.start(view.getApplicationProfilePanel(), clientFactory.getEventBus());

        PaaSOfferActivity paasOfferActivity = new PaaSOfferActivity(place, clientFactory);
        paasOfferActivity.start(view.getPaaSOfferPanel(), clientFactory.getEventBus());

        registerViewDetacher(view);
    }



    private void callServices() {

        List<DisplayableKeyValue> interactionStyleValues = new ArrayList<DisplayableKeyValue>();

        for (InteractionStyle i : InteractionStyle.values())
            interactionStyleValues.add(new SimpleKeyValue(i.name(), i.description()));

        view.setInteractionStyleValues(interactionStyleValues);

        view.setSelectedInteractionStyle(interactionStyle.name());

    }


    @Override
    public void onInteractionChange(String value) {
        interactionStyle = InteractionStyle.valueOf(value);
        clientFactory.getEventBus().fireEvent(new InteractionStyleChangeEvent(interactionStyle));
    }


}
