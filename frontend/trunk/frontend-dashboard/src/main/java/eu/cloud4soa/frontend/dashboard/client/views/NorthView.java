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

package eu.cloud4soa.frontend.dashboard.client.views;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Header view contract for the header.
 * 
 * @author Stefano Travelli (Cyntelix)
 */
public interface NorthView extends IsWidget {

	void setPresenter(Presenter presenter);

	void setSearchVisible(boolean visible);

	void setBrowseVisible(boolean visible);

	void setApplicationVisible(boolean visible);

	void setOfferVisible(boolean visible);

	void setMonitoringVisible(boolean visible);

	void setDeployVisible(boolean visible);

    void setMigrateVisible(boolean visible);

	void setProfileVisible(boolean visible);

	void setRegisterVisible(boolean visible);

	void setLoginVisible(boolean visible);

	void setLogoutVisible(boolean visible);

    void setAdminVisible(boolean visible);

	void setSearchSelected(boolean selected);

	void setBrowseSelected(boolean selected);

	void setApplicationSelected(boolean selected);

	void setOfferSelected(boolean selected);

	void setMonitoringSelected(boolean selected);

	void setDeploySelected(boolean selected);

    void setMigrateSelected(boolean selected);

	void setProfileSelected(boolean selected);

	void setRegisterSelected(boolean selected);

	void setLoginSelected(boolean selected);

	void setLogoutSelected(boolean selected);

    void setAdminSelected(boolean selected);

    void setUsername(String username);

	public interface Presenter {
		void goTo(Place place);

		void onLoginClick();

		void onLogoutClick();

		void onRegisterClick();

		void onUserProfileClick();

		void onHomeNavigation();

		void onSearchNavigation();

		void onApplicationNavigation();

		void onOfferNavigation();

		void onMonitorNavigation();

		void onDeployNavigation();

        void onMigrateNavigation();

		void onBrowseNavigation();

        void onAdminNavigation();

	}

}
