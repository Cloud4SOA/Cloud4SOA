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
import eu.cloud4soa.frontend.commons.client.places.ApplicationEditorPlace;
import eu.cloud4soa.frontend.commons.client.places.ApplicationProfileAware;
import eu.cloud4soa.frontend.widget.usermanagement.client.views.ApplicationEditorGuideView;

/**
 * The application editor guide activity.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationEditorGuideActivity extends Cloud4SoaActivity implements ApplicationEditorGuideView.Presenter {

    private ApplicationEditorGuideView view;

    public ApplicationEditorGuideActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {
        super(place, clientFactory);
    }

    @Override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view = GWT.create(ApplicationEditorGuideView.class);
        view.setPresenter(this);
        panel.setWidget(view);

        if (place instanceof ApplicationProfileAware && Strings.isNotEmpty(((ApplicationProfileAware) place).getApplicationProfileUriId()))
            view.setApplicationSelected(true);
        else
            view.setApplicationSelected(false);


        registerViewDetacher(view);
    }


    @Override
    public void onNewLinkClick() {
        goTo(new ApplicationEditorPlace(Strings.NEW_INSTANCE));
    }
}
