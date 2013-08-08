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

package eu.cloud4soa.frontend.commons.client;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;

/**
 * Store browser side module wide instances.
 * 
 * @author Yosu Gorroñogoitia (Atos)
 * @author Stefano Travelli (Cyntelix)
 */
public class Cloud4SOAUIClientFactoryImpl implements Cloud4SOAUIClientFactory {

	private final EventBus eventBus = new SimpleEventBus();

	private final PlaceController placeController = new PlaceController(
			eventBus);

	private UserModel currentUser;

	@Override
	public com.google.gwt.event.shared.EventBus getEventBus() {
		return (com.google.gwt.event.shared.EventBus) eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public UserModel getCurrentUser() {
		return currentUser;
	}

	@Override
	public void setCurrentUser(UserModel userModel) {
		this.currentUser = userModel;
	}

	@Override
	public boolean isLoggedIn() {
		return currentUser != null;
	}

}
