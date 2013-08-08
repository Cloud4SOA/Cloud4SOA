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
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.events.PaaSOfferingDetailsRequestedEvent;
import eu.cloud4soa.frontend.commons.client.events.PaaSOfferingSelectedEvent;
import eu.cloud4soa.frontend.widget.usermanagement.client.views.PaaSOfferView;

/**
 * PaaSOffer activity. Provide a list of PaaS offers for editing
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class PaaSOfferActivity extends Cloud4SoaActivity implements PaaSOfferView.Presenter {
    private PaaSOfferView view = GWT.create(PaaSOfferView.class);

    private PaaSOfferingModel paaSOffer;

    public PaaSOfferActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {
        super(place, clientFactory);

        addHandler(PaaSOfferingDetailsRequestedEvent.TYPE, new PaaSOfferingDetailsRequestedEvent.Handler() {
            @Override
            public void onPaaSOfferingDetailsRequested(PaaSOfferingDetailsRequestedEvent event) {
                boundPaaSOffering(event.getPaaSOffering());
            }
        });

    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view.setPresenter(this);
        panel.setWidget(view.asWidget());
        registerViewDetacher(view);
    }

    private void boundPaaSOffering(PaaSOfferingModel paaSOffer) {
        this.paaSOffer = paaSOffer;
        view.getOfferTitle().setValue(paaSOffer.getTitle());
        view.getProvider().setValue(paaSOffer.getProvider());
        view.getProgrammingLanguage().setValue(paaSOffer.getProgrammingLanguage().getDisplayName());
        view.setPricingPolicyValues(paaSOffer.getPricingPolicyModels());

        // if the application profile is not set don't allow deployment
        view.setDeployButtonEnabled(false);
    }

    @Override
    public void onDeployClick() {
        if (paaSOffer != null) {
            clientFactory.getEventBus().fireEvent(new PaaSOfferingSelectedEvent(paaSOffer));
        }
    }
}
