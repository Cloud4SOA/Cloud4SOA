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

package eu.cloud4soa.frontend.dashboard.client;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.dashboard.client.activities.MainActivity;

/**
 * Manage the main activity.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class Cloud4SOAUIActivityMapper implements ActivityMapper {
	private Cloud4SOAUIClientFactory clientFactory;

	public Cloud4SOAUIActivityMapper(Cloud4SOAUIClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }
	
	public Activity getActivity(Place place) {

        // the activity to launch is always the MainActivity. It's up
        // to this activity to model the portal based on the actual place
        return new MainActivity(place, clientFactory);
	}

}
