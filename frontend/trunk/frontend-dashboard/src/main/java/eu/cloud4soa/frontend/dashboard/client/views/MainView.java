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

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaPresenter;

/**
 * Interface of the main view.
 *
 * @author Stefano Travelli (Cyntelix)
 * @since 15/02/12 17.33
 */
public interface MainView extends IsWidget {

    enum Position {TOP_LEFT, BOTTOM_LEFT, TOP_RIGHT, BOTTOM_RIGHT, TOP_CENTER, BOTTOM_CENTER}


    public void setPresenter(Presenter presenter);

    public AcceptsOneWidget getNorth();

    public AcceptsOneWidget getSouth();

    public AcceptsOneWidget getWest();

    public AcceptsOneWidget getEast();

    public AcceptsOneWidget getCenter();

    public void showNorth();

    public void showSouth();

    public void showWest();

    public void showEast();

    public void showCenter();

    public void hideNorth();

    public void hideSouth();

    public void hideWest();

    public void hideEast();

    public void hideCenter();

    public void collapseWest();

    public void collapseEast();

    public void expandWest();

    public void expandEast();

    public HasOneWidget addNewWidget(String heading, boolean allowClosing, Position position);

    public interface Presenter extends Cloud4SoaPresenter {

    }

	void layout();

}
