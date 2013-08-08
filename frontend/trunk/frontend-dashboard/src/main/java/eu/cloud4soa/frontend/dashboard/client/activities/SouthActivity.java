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

package eu.cloud4soa.frontend.dashboard.client.activities;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.services.Version;
import eu.cloud4soa.frontend.commons.client.services.VersionAsync;
import eu.cloud4soa.frontend.dashboard.client.views.SouthView;

/**
 * Activity for the footer panel.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class SouthActivity extends Cloud4SoaActivity implements SouthView.Presenter {

    private SouthView view;

    public SouthActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {
        super(place, clientFactory);

    }


    @Override
    public void start(AcceptsOneWidget acceptsOneWidget, EventBus eventBus) {
        view = GWT.create(SouthView.class);
        view.setPresenter(this);

        VersionAsync version = GWT.create(Version.class);

        version.getVersion(new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                // ignore
            }

            @Override
            public void onSuccess(String result) {
                view.setVersion("Cloud4SOA Frontend version " + result);
            }
        });

        acceptsOneWidget.setWidget(view.asWidget());
        registerViewDetacher(view);
    }

}
