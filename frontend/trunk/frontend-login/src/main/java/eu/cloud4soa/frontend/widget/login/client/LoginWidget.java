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

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.places.LoginPlace;

/**
 * Login widget loader for debugging outside of the dashboard.
 *
 * @author Stefano Travelli
 * @since 20/09/11 15.35
 */
public class LoginWidget implements EntryPoint
{

    private Place place = new LoginPlace("");

    public void onModuleLoad()
    {
        RootPanel rootPanel = RootPanel.get("loginWidgetContainer");

        if (rootPanel != null)
        {
            Cloud4SOAUIClientFactory clientFactory = GWT.create(Cloud4SOAUIClientFactory.class);
            EventBus eventBus = clientFactory.getEventBus();

            LoginActivity activity = new LoginActivity(place, clientFactory);

            SimplePanel panel = new SimplePanel();
            rootPanel.add(panel);

            activity.start(panel, eventBus);
        }
    }
}
