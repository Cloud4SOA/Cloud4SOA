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

package eu.cloud4soa.frontend.widget.login.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;

/**
 * Activity for the password recovery page.
 *
 * @author Stefano Travelli (Cyntelix)
 * @since 14/02/12 23.44
 */
public class LostPasswordActivity extends Cloud4SoaActivity implements LostPasswordView.Presenter {

    private LostPasswordView view;

    public LostPasswordActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {
        super(place, clientFactory);
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        view = GWT.create(LostPasswordView.class);
        view.setPresenter(this);

        container.setWidget(view.asWidget());
        registerViewDetacher(view);
    }
}
