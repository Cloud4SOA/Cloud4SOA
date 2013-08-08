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

import com.extjs.gxt.ui.client.widget.Info;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.gwt.ss.client.GwtLogoutAsync;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.server.security.C4sSubject;
import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.events.CurrentUserProfileUpdatedEvent;
import eu.cloud4soa.frontend.commons.client.events.UserLoggedOutEvent;
import eu.cloud4soa.frontend.commons.client.places.*;
import eu.cloud4soa.frontend.commons.client.services.soa.UserManagementAndSecurityService;
import eu.cloud4soa.frontend.commons.client.services.soa.UserManagementAndSecurityServiceAsync;
import eu.cloud4soa.frontend.dashboard.client.views.NorthView;

/**
 * Activity for the header panel.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class NorthActivity extends Cloud4SoaActivity implements
        NorthView.Presenter {

    private NorthView view;

    private UserManagementAndSecurityServiceAsync userService = GWT
            .create(UserManagementAndSecurityService.class);

    @Override
    public void start(AcceptsOneWidget acceptsOneWidget, EventBus eventBus) {
        view = GWT.create(NorthView.class);
        view.setPresenter(this);


        // manage places
        if (clientFactory.isLoggedIn()) {

            userService.isUserInRole(UserModel.USER_ROLE_ADMINISTRATOR, new Cloud4SoaActivity.ActivityCallback<Boolean>() {
                @Override
                public void onSuccess(Boolean result) {
                    view.setAdminVisible(result);
                }
            });

            view.setUsername(clientFactory.getCurrentUser().getDisplayName());
            view.setSearchVisible(Boolean.TRUE.equals(clientFactory.getCurrentUser().get(UserModel.USER_ROLE_MATCH)));
            view.setBrowseVisible(Boolean.TRUE.equals(clientFactory.getCurrentUser().get(UserModel.USER_ROLE_BROWSE)));
            view.setApplicationVisible(Boolean.TRUE.equals(clientFactory.getCurrentUser().get(UserModel.USER_ROLE_MATCH)));
            view.setOfferVisible(true);
            view.setMonitoringVisible(Boolean.TRUE.equals(clientFactory.getCurrentUser().get(UserModel.USER_ROLE_MONITOR)));



            // never give direct access to the deploy place
            view.setDeployVisible(false);
            view.setMigrateVisible(Boolean.TRUE.equals(clientFactory.getCurrentUser().get(UserModel.USER_ROLE_MIGRATE)));
            view.setProfileVisible(true);
            view.setRegisterVisible(false);
            view.setLoginVisible(false);
            view.setLogoutVisible(true);

            if (!clientFactory.getCurrentUser().isProvider()) {
                view.setOfferVisible(false);
            }
            if (!clientFactory.getCurrentUser().isDeveloper()) {
                view.setSearchVisible(false);
                view.setBrowseVisible(false);
                view.setApplicationVisible(false);
                view.setMonitoringVisible(false);
                view.setDeployVisible(false);
                view.setMigrateVisible(false);
            }

        } else {
            view.setUsername(Strings.EMPTY);
            view.setSearchVisible(false);
            view.setBrowseVisible(false);
            view.setApplicationVisible(false);
            view.setOfferVisible(false);
            view.setMonitoringVisible(false);
            view.setDeployVisible(false);
            view.setMigrateVisible(false);
            view.setProfileVisible(false);
            view.setRegisterVisible(true);
            view.setLoginVisible(true);
            view.setLogoutVisible(false);
            view.setAdminVisible(false);
        }

        view.setSearchSelected(false);
        view.setBrowseSelected(false);
        view.setApplicationSelected(false);
        view.setOfferSelected(false);
        view.setMonitoringSelected(false);
        view.setDeploySelected(false);
        view.setMigrateSelected(false);
        view.setProfileSelected(false);
        view.setRegisterSelected(false);
        view.setLoginSelected(false);
        view.setLogoutSelected(false);
        view.setAdminSelected(false);

        if (place instanceof SearchPlace)
            view.setSearchSelected(true);
        else if (place instanceof BrowsePlace)
            view.setBrowseSelected(true);
        else if (place instanceof ApplicationEditorPlace)
            view.setApplicationSelected(true);
        else if (place instanceof OfferEditorPlace)
            view.setOfferSelected(true);
        else if (place instanceof MonitoringPlace)
            view.setMonitoringSelected(true);
        else if (place instanceof DeployPlace) {
            // show the deploy icon when the deploy place is active
            view.setDeployVisible(true);
            view.setDeploySelected(true);
        } else if (place instanceof MigratePlace) {
            view.setMigrateSelected(true);
        } else if (place instanceof UserProfilePlace)
            view.setProfileSelected(true);
        else if (place instanceof RegisterPlace)
            view.setRegisterSelected(true);
        else if (place instanceof LoginPlace)
            view.setLoginSelected(true);
        else if (place instanceof AdminPlace)
            view.setAdminSelected(true);

        acceptsOneWidget.setWidget(view.asWidget());
        registerViewDetacher(view);
    }

    public NorthActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {
        super(place, clientFactory);

        addHandler(CurrentUserProfileUpdatedEvent.TYPE, new CurrentUserProfileUpdatedEvent.Handler() {
            @Override
            public void onUserProfileUpdated(CurrentUserProfileUpdatedEvent event) {
                view.setUsername(NorthActivity.this.clientFactory.getCurrentUser().getDisplayName());
            }
        });
    }

    @Override
    public void onLoginClick() {

        goTo(new LoginPlace(Strings.EMPTY));
    }

    @Override
    public void onLogoutClick() {

        GwtLogoutAsync logoutService = GwtLogoutAsync.Util.getInstance();

        logoutService.j_gwt_security_logout(new ActivityCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                String userUri = clientFactory.getCurrentUser().getKey();
                clientFactory.setCurrentUser(null);
                clientFactory.getEventBus().fireEvent(
                        new UserLoggedOutEvent(userUri));
                Info.display("Logout", "The user has been logged out.");
                goTo(new WelcomePlace());
            }
        });
    }

    @Override
    public void onRegisterClick() {
        goTo(new RegisterPlace(""));
    }

    @Override
    public void onUserProfileClick() {
        goTo(new UserProfilePlace());
    }

    @Override
    public void onHomeNavigation() {
        userService.isLoggedIn(new AsyncCallback<Boolean>() {
            @Override
            public void onFailure(Throwable caught) {
                handleRPCFailure(caught);
            }

            @Override
            public void onSuccess(Boolean result) {
                if (result)
                    goTo(new SearchPlace(Strings.EMPTY));
                else
                    goTo(new WelcomePlace());
            }
        });
    }

    @Override
    public void onApplicationNavigation() {
        goTo(new ApplicationEditorPlace(Strings.EMPTY));
    }

    @Override
    public void onSearchNavigation() {
        goTo(new SearchPlace(Strings.EMPTY));
    }

    @Override
    public void onOfferNavigation() {
        goTo(new OfferEditorPlace(Strings.EMPTY));
    }

    @Override
    public void onMonitorNavigation() {
        goTo(new MonitoringPlace());
    }

    @Override
    public void onDeployNavigation() {
        goTo(new DeployPlace(Strings.EMPTY, Strings.EMPTY, null));
    }

    @Override
    public void onMigrateNavigation() {
        goTo(new MigratePlace(Strings.EMPTY, Strings.EMPTY));
    }

    @Override
    public void onBrowseNavigation() {
        goTo(new BrowsePlace());
    }

    @Override
    public void onAdminNavigation() {
        goTo(new AdminPlace());
    }
}
