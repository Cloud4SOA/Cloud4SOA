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

import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.data.BasePagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.util.Theme;
import com.extjs.gxt.ui.client.util.ThemeManager;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.StatusCodeException;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.gwt.ss.client.loginable.LoginEvent;
import com.gwt.ss.client.loginable.LoginHandler;
import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.client.dialog.DialogHelper;
import eu.cloud4soa.frontend.commons.client.events.CurrentUserProfileUpdatedEvent;
import eu.cloud4soa.frontend.commons.client.events.RPCFailureOccurredEvent;
import eu.cloud4soa.frontend.commons.client.events.UserLogInCancelledEvent;
import eu.cloud4soa.frontend.commons.client.events.UserLoggedOutEvent;
import eu.cloud4soa.frontend.commons.client.places.ApplicationEditorPlace;
import eu.cloud4soa.frontend.commons.client.places.OfferEditorPlace;
import eu.cloud4soa.frontend.commons.client.places.SearchPlace;
import eu.cloud4soa.frontend.commons.client.places.WelcomePlace;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerService;
import eu.cloud4soa.frontend.commons.client.services.soa.ModelManagerServiceAsync;
import eu.cloud4soa.frontend.commons.client.services.soa.UserManagementAndSecurityService;
import eu.cloud4soa.frontend.commons.client.services.soa.UserManagementAndSecurityServiceAsync;
import eu.cloud4soa.frontend.theme.client.C4sTheme;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Cloud4SOADashboard implements EntryPoint {
    private Place defaultPlace = new WelcomePlace();
    private SimplePanel appWidget = new SimplePanel();
    private Cloud4SOAUIClientFactory clientFactory;
    private EventBus eventBus;

    public Cloud4SOADashboard() {
        clientFactory = GWT.create(Cloud4SOAUIClientFactory.class);
        eventBus = clientFactory.getEventBus();
    }

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        manageActivitiesAndPlaces();
    }

    private void manageActivitiesAndPlaces() {
        final PlaceController placeController = clientFactory.getPlaceController();

        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new Cloud4SOAUIActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(appWidget);

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        Cloud4SOAUIPlaceHistoryMapper historyMapper = GWT.create(Cloud4SOAUIPlaceHistoryMapper.class);
        final PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);


        // hack the css path in order to make it relative to the module path
        // (ThemeManager should do this, but it doesn't)
        Theme c4sTheme = C4sTheme.C4S_THEME;
        String c4sThemeFile = c4sTheme.getFile();
        c4sTheme.set("file", GWT.getModuleBaseURL() + "/" + c4sThemeFile);

        ThemeManager.register(c4sTheme);
        GXT.setDefaultTheme(c4sTheme, true);

        //Style for main panel
//        appWidget.addStyleName("mainPanel");
        RootPanel.get().add(appWidget);

        registerNavigationEventHandler(placeController);

        // check if the user session is alive in the server
        UserManagementAndSecurityServiceAsync uma = GWT.create(UserManagementAndSecurityService.class);


        uma.getC4sMode(new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                // nothing to do
            }

            @Override
            public void onSuccess(String result) {
                setC4sMode(result);
            }
        });

        uma.currentUser(new AsyncCallback<UserModel>() {
            @Override
            public void onFailure(Throwable caught) {
                // error checking the user
                placeController.goTo(defaultPlace);
            }

            @Override
            public void onSuccess(UserModel result) {
                if (result == null) {
                    // not logged in
                    placeController.goTo(defaultPlace);
                } else {
                    // logged in
                    clientFactory.setCurrentUser(result);
                    // Go to the place represented on URL else default place
                    historyHandler.handleCurrentHistory();
                }
            }
        });
    }


    private native void setC4sMode(String c4sMode)/*-{
            $wnd.c4s_mode = c4sMode;
      }-*/;


    /**
     * Navigation event handler cannot be managed by the main activity, since this could lead to event loop while
     * the main activity is created and the same event handlers get registered over and over.
     */
    private void registerNavigationEventHandler(final PlaceController placeController) {

        eventBus.addHandler(LoginEvent.getType(), new LoginHandler() {
            @Override
            public void setLoginHandlerRegistration(HandlerRegistration hr) {
                // nothing to do
            }

            @Override
            public void onLogin(LoginEvent e) {
                if (e.isLoginSuccessful()) {
                    UserManagementAndSecurityServiceAsync userService = GWT.create(UserManagementAndSecurityService.class);
                    userService.currentUser(new AsyncCallback<UserModel>() {
                        @Override
                        public void onFailure(Throwable caught) {
                            // something wrong happened
                            MessageBox.alert("Ops.. something went wrong", caught.toString(), new Listener<MessageBoxEvent>() {
                                @Override
                                public void handleEvent(MessageBoxEvent messageBoxEvent) {
                                }
                            });
                        }

                        @Override
                        public void onSuccess(UserModel userModel) {
                            clientFactory.setCurrentUser(userModel);
                            if (userModel.isDeveloper()) {
                                // check if the developer has some application profile
                                ModelManagerServiceAsync modelManagerService = GWT.create(ModelManagerService.class);

                                modelManagerService.retrieveCurrentUserApplicationProfiles(new BasePagingLoadConfig(), new AsyncCallback<PagingLoadResult<ApplicationModel>>() {
                                    @Override
                                    public void onFailure(Throwable caught) {
                                        // something wrong happened
                                        placeController.goTo(new SearchPlace(Strings.EMPTY));
                                    }

                                    @Override
                                    public void onSuccess(PagingLoadResult<ApplicationModel> result) {
                                        if (result.getTotalLength() == 0) {
                                            // no application profile found. Go creating one in the application editor place
                                            placeController.goTo(new ApplicationEditorPlace(Strings.EMPTY));
                                        } else {
                                            // application profiles are already there. Go searching in the search place
                                            placeController.goTo(new SearchPlace(Strings.EMPTY));
                                        }
                                    }
                                });

                            } else {
                                // logged in user is a PaaS provider. Go to the offer editor
                                placeController.goTo(new OfferEditorPlace(Strings.EMPTY));
                            }
                        }
                    });
                }
            }
        });

        eventBus.addHandler(UserLoggedOutEvent.TYPE, new UserLoggedOutEvent.Handler() {
            @Override
            public void onUserLogout(UserLoggedOutEvent event) {
                placeController.goTo(new WelcomePlace());
            }
        });

        eventBus.addHandler(UserLogInCancelledEvent.TYPE, new UserLogInCancelledEvent.Handler() {
            @Override
            public void onLoginCancelled(UserLogInCancelledEvent event) {
                // when the user cancel the login, go back to the welcome page
                placeController.goTo(new WelcomePlace());
            }
        });

        eventBus.addHandler(CurrentUserProfileUpdatedEvent.TYPE, new CurrentUserProfileUpdatedEvent.Handler() {
            @Override
            public void onUserProfileUpdated(CurrentUserProfileUpdatedEvent event) {

                if (clientFactory.getCurrentUser().isDeveloper())
                    placeController.goTo(new SearchPlace(Strings.EMPTY));
                else
                    placeController.goTo(new OfferEditorPlace(Strings.EMPTY));
            }
        });

        eventBus.addHandler(RPCFailureOccurredEvent.TYPE, new RPCFailureOccurredEvent.Handler() {
            @Override
            public void onRPCFailure(RPCFailureOccurredEvent event) {
                if (event.getCaught() instanceof StatusCodeException && ((StatusCodeException) event.getCaught()).getStatusCode() == 0)
                    DialogHelper.showErrorDialog("You might have lost connectivity with the Cloud4SOA server. Please, try reloading the page.");
                else
                    DialogHelper.showErrorDialog(event.getCaught().getMessage());
            }
        });

    }
}
