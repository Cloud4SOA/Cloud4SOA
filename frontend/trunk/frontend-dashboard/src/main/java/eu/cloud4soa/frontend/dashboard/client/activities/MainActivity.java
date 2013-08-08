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

import com.extjs.gxt.ui.client.widget.Dialog;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import com.google.gwt.user.client.ui.Widget;
import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.events.MainViewEastExpandEvent;
import eu.cloud4soa.frontend.commons.client.events.MainViewEastShowEvent;
import eu.cloud4soa.frontend.commons.client.events.MainViewWestExpandEvent;
import eu.cloud4soa.frontend.commons.client.events.MainViewWestShowEvent;
import eu.cloud4soa.frontend.commons.client.events.MonitoringApplicationRequestedEvent;
import eu.cloud4soa.frontend.commons.client.events.SLAContractRequestedEvent;
import eu.cloud4soa.frontend.commons.client.events.SLAViolationsRequestedEvent;
import eu.cloud4soa.frontend.commons.client.events.SearchProviderEvent;
import eu.cloud4soa.frontend.commons.client.places.*;
import eu.cloud4soa.frontend.dashboard.client.views.MainView;
import eu.cloud4soa.frontend.widget.deployment.client.activities.DeployApplicationActivity;
import eu.cloud4soa.frontend.widget.deployment.client.activities.MigrateApplicationActivity;
import eu.cloud4soa.frontend.widget.deployment.client.activities.MigrateGuideActivity;
import eu.cloud4soa.frontend.widget.login.client.LoginActivity;
import eu.cloud4soa.frontend.widget.login.client.LostPasswordActivity;
import eu.cloud4soa.frontend.widget.login.client.RegisterActivity;
import eu.cloud4soa.frontend.widget.login.client.UserProfileActivity;
import eu.cloud4soa.frontend.widget.monitoring.client.activities.ApplicationsDeployedActivity;
import eu.cloud4soa.frontend.widget.monitoring.client.activities.ApplicationsDeployedGuideActivity;
import eu.cloud4soa.frontend.widget.monitoring.client.activities.MonitoringActivity;
import eu.cloud4soa.frontend.widget.search.client.activities.FacetedSearchActivity;
import eu.cloud4soa.frontend.widget.search.client.activities.FacetedSearchGuideActivity;
import eu.cloud4soa.frontend.widget.search.client.activities.SearchResultsActivity;
import eu.cloud4soa.frontend.widget.slamanagement.client.activities.SLAContractActivity;
import eu.cloud4soa.frontend.widget.slamanagement.client.activities.SLAViolationsActivity;
import eu.cloud4soa.frontend.widget.usermanagement.client.activities.*;
import eu.cloud4soa.frontend.widget.usermanagement.client.views.AdminGuideView;

/**
 * Presenter of the main view.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class MainActivity extends Cloud4SoaActivity implements
        MainView.Presenter {

    private MainView view;

    private Dialog errorDialog;

    public MainActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {
        super(place, clientFactory);

        // upon request, collapse, expand, hide or show the left and right panes
        addHandler(MainViewWestExpandEvent.TYPE,
                new MainViewWestExpandEvent.Handler() {
                    @Override
                    public void onMainViewWestExpandRequest(
                            MainViewWestExpandEvent event) {
                        if (event.isExpand())
                            view.expandWest();
                        else
                            view.collapseWest();
                    }
                });

        addHandler(MainViewEastExpandEvent.TYPE,
                new MainViewEastExpandEvent.Handler() {
                    @Override
                    public void onMainViewEastExpandRequest(
                            MainViewEastExpandEvent event) {
                        if (event.isExpand())
                            view.expandEast();
                        else
                            view.collapseEast();
                    }
                });

        addHandler(MainViewWestShowEvent.TYPE,
                new MainViewWestShowEvent.Handler() {
                    @Override
                    public void onMainViewWestShowRequest(
                            MainViewWestShowEvent event) {
                        if (event.isShow())
                            view.showWest();
                        else
                            view.hideWest();
                    }
                });

        addHandler(MainViewEastShowEvent.TYPE,
                new MainViewEastShowEvent.Handler() {
                    @Override
                    public void onMainViewEastShowRequest(
                            MainViewEastShowEvent event) {
                        if (event.isShow())
                            view.showEast();
                        else
                            view.hideEast();
                    }
                });

    }

    @Override
    public void start(final AcceptsOneWidget panel, final EventBus eventBus) {
        view = GWT.create(MainView.class);
        view.setPresenter(this);

        // in the north we always put the NorthActivity
        NorthActivity northActivity = new NorthActivity(place, clientFactory);
        northActivity.start(view.getNorth(), eventBus);

        // in the south we always put the SouthActivity
        SouthActivity southActivity = new SouthActivity(place, clientFactory);
        southActivity.start(view.getSouth(), eventBus);

        view.showNorth();
        view.showSouth();
        view.showCenter();

        if (place instanceof WelcomePlace) {
            // configure the welcome view
            WelcomeActivity welcomeActivity = new WelcomeActivity(place,
                    clientFactory);
            welcomeActivity.start(view.getCenter(), eventBus);

            view.hideEast();
            view.hideWest();

        } else if (place instanceof SearchPlace) {

            if (Strings.isEmpty(((SearchPlace) place)
                    .getApplicationProfileUriId())) {
                ApplicationProfileListActivity applicationProfileListActivity = new ApplicationProfileListActivity(
                        place, clientFactory);
                applicationProfileListActivity.start(view.getWest(), eventBus);

                SearchGuideActivity searchGuideActivity = new SearchGuideActivity(
                        place, clientFactory);
                searchGuideActivity.start(view.getCenter(), eventBus);

            } else {

                ApplicationProfileActivity applicationProfileActivity = new ApplicationProfileActivity(
                        place, clientFactory);
                applicationProfileActivity.start(view.getWest(), eventBus);

                // if a search event is emitted, we show the search result
                // widget
                addHandler(SearchProviderEvent.TYPE,
                        new SearchProviderEvent.Handler() {
                            @Override
                            public void onProviderSearchRetrieved(
                                    SearchProviderEvent s) {
                                createSearchResultWidget(s);
                            }
                        });

            }

            view.hideEast();
            view.showWest();
            view.expandWest();

        } else if (place instanceof BrowsePlace) {

            FacetedSearchActivity facetedSearchActivity = new FacetedSearchActivity(
                    clientFactory);
            facetedSearchActivity.start(view.getWest(), eventBus);

            // if a search event is emitted, we show the search result widget
            addHandler(SearchProviderEvent.TYPE,
                    new SearchProviderEvent.Handler() {
                        @Override
                        public void onProviderSearchRetrieved(
                                SearchProviderEvent s) {
                            createSearchResultWidget(s);
                        }
                    });

            FacetedSearchGuideActivity catalogueBrowseGuideActivity = new FacetedSearchGuideActivity(
                    place, clientFactory);
            catalogueBrowseGuideActivity.start(view.getCenter(), eventBus);

            view.hideEast();
            view.showWest();
            view.expandWest();

        } else if (place instanceof DeployPlace) {
            DeployApplicationActivity deployApplicationActivity = new DeployApplicationActivity(place, clientFactory);
//            HasOneWidget widget = view.addNewWidget("Deploy application", false, MainView.Position.TOP_CENTER);
            deployApplicationActivity.start(view.getCenter(), eventBus);
        } else if (place instanceof MigratePlace) {
            view.showCenter();
            boolean applicationSelected = Strings.isNotEmpty(((MigratePlace) place).getApplicationProfileUriId());
            boolean offeringSelected = Strings.isNotEmpty(((MigratePlace) place).getPaaSOfferingUriId());

            if (!applicationSelected && !offeringSelected) {
                // no application nor offering is selected. Show list of deployed applications and the migration guide
                ApplicationProfileListActivity deployedApplications = new ApplicationProfileListActivity(place, clientFactory);
                deployedApplications.start(view.getWest(), eventBus);

                MigrateGuideActivity migrateGuideActivity = new MigrateGuideActivity(place, clientFactory);
                migrateGuideActivity.start(view.getCenter(), eventBus);

            } else if (applicationSelected && !offeringSelected) {
                // application is selected, no offering. Show matchmaking offerings an the application details on the left

                ApplicationProfileActivity applicationProfileActivity = new ApplicationProfileActivity(place, clientFactory);
                applicationProfileActivity.start(view.getWest(), eventBus);

                // if a search event is emitted, we show the search result
                // widget
                addHandler(SearchProviderEvent.TYPE,
                        new SearchProviderEvent.Handler() {
                            @Override
                            public void onProviderSearchRetrieved(SearchProviderEvent s) {
                                createSearchResultWidget(s);
                            }
                        });


            } else if (applicationSelected /*&& offeringSelected*/) {
                // both application and offering are selected (second flag check is redundant, hence it's commented out.
                // Start migrating with the deploy widget showing the application details on the left
                ApplicationProfileActivity applicationProfileActivity = new ApplicationProfileActivity(
                        place, clientFactory);
                applicationProfileActivity.start(view.getWest(), eventBus);

                MigrateApplicationActivity migrateApplicationActivity = new MigrateApplicationActivity(place, clientFactory);
                migrateApplicationActivity.start(view.getCenter(), eventBus);

            } else {
                // last case is application not selected with offering selected. Show list of deployed applications
                // don't know what to do with the selected offering so far
                ApplicationsDeployedActivity deployedApplications = new ApplicationsDeployedActivity(clientFactory);
                deployedApplications.start(view.getWest(), eventBus);

                MigrateGuideActivity migrateGuideActivity = new MigrateGuideActivity(place, clientFactory);
                migrateGuideActivity.start(view.getCenter(), eventBus);

            }


        } else if (place instanceof MonitoringPlace) {

            ApplicationsDeployedActivity applicationsDeployedActivity = new ApplicationsDeployedActivity(
                    clientFactory);
            // applicationsDeployedActivity.start(
            // view.addNewWidget("Deployed applications", false,
            // MainView.Position.TOP_LEFT), eventBus);
            applicationsDeployedActivity.start(view.getWest(), eventBus);

            ApplicationsDeployedGuideActivity applicationsDeployedGuideActivity = new ApplicationsDeployedGuideActivity(
                    place, clientFactory);
            applicationsDeployedGuideActivity.start(view.getCenter(), eventBus);

            final SLAViolationsActivity sLAViolationsActivity = new SLAViolationsActivity(clientFactory);
            sLAViolationsActivity.start(view.getEast(), eventBus);

            // if a monitoring event is emitted, we show the monitoring widget
            addHandler(MonitoringApplicationRequestedEvent.TYPE,
                    new MonitoringApplicationRequestedEvent.Handler() {

                        MonitoringActivity monitoringActivity;

                        @Override
                        public void onMonitoringApplicationRequested(
                                MonitoringApplicationRequestedEvent event) {

                            monitoringActivity = createMonitoringWidget(event);
                            
                            
                            view.hideEast();
                            view.collapseEast();
                            view.layout();
                        }
                    });

            // if a show SLA contract event is emitted, we show the SLA contract
            // widget
            addHandler(SLAContractRequestedEvent.TYPE,
                    new SLAContractRequestedEvent.Handler() {

                        SLAContractActivity slaContractActivity;

                        @Override
                        public void onSLAContractRequested(
                                SLAContractRequestedEvent event) {

                            slaContractActivity = createSLAContractWidget(event);
                            view.layout();
                        }
                    });
            
            // if a show SLA violation event is emitted, we show the SLA violations widget
            addHandler(SLAViolationsRequestedEvent.TYPE,
                    new SLAViolationsRequestedEvent.Handler() {

                        @Override
                        public void onSLAViolationsRequested(
                                SLAViolationsRequestedEvent event) {

                        	//Requested to open SLA violation views in central panel. No application selected
                        	if (sLAViolationsActivity != null && event.getApplicationId() == null){
                        		showSLAViolationsWidget(sLAViolationsActivity);
                        	
                        		view.hideEast();
                        		view.collapseEast();
                        		view.layout();
                        	}
                        	//Selected application. Filtering SLA Violations view
                        	if (sLAViolationsActivity != null && event.getApplicationId() != null)
                        		sLAViolationsActivity.filterSLAViolationsByApplicationId(event.getApplicationId());
                        	
                        }
                    });

            view.showWest();
            view.expandWest();

            view.showEast();
            view.expandEast();

        } else if (place instanceof LoginPlace) {

            LoginActivity loginActivity = new LoginActivity(place,
                    clientFactory);
            loginActivity.start(view.getCenter(), eventBus);

            view.hideEast();
            view.hideWest();

        } else if (place instanceof LostPasswordPlace) {

            LostPasswordActivity lostPasswordActivity = new LostPasswordActivity(
                    place, clientFactory);
            lostPasswordActivity.start(view.getCenter(), eventBus);

            view.hideEast();
            view.hideWest();

        } else if (place instanceof RegisterPlace) {
            // configure the register view
            RegisterActivity registerActivity = new RegisterActivity(place,
                    clientFactory);
            registerActivity.start(view.getCenter(), eventBus);

            view.hideEast();
            view.hideWest();

        } else if (place instanceof UserProfilePlace) {
            // configure the user profile place.
            view.hideEast();
            view.hideWest();

            // put the user profile activity in the center
            UserProfileActivity userProfileActivity = new UserProfileActivity(
                    place, clientFactory);
            userProfileActivity.start(view.getCenter(), eventBus);

        } else if (place instanceof OfferEditorPlace) {

            // west and/or east could contains palettes of features to put in
            // the offer
            view.hideEast();
            view.expandWest();
            view.showWest();

            OfferEditorPlace offerEditorPlace = (OfferEditorPlace) place;

            if (Strings.isEmpty(offerEditorPlace.getPaaSOfferingUriId())) {
                PaaSOfferingListActivity paaSOfferingListActivity = new PaaSOfferingListActivity(
                        place, clientFactory);
                paaSOfferingListActivity.start(view.getWest(), eventBus);

                PaaSOfferingEditorGuideActivity paaSOfferingEditorGuideActivity = new PaaSOfferingEditorGuideActivity(
                        place, clientFactory);
                paaSOfferingEditorGuideActivity.start(view.getCenter(),
                        eventBus);

            } else {
                OfferEditorActivity offerEditorActivity = new OfferEditorActivity(
                        place, clientFactory);
                offerEditorActivity.start(view.getCenter(), eventBus);

                PaaSOfferingEditorGuideActivity paaSOfferingEditorGuideActivity = new PaaSOfferingEditorGuideActivity(
                        place, clientFactory);
                paaSOfferingEditorGuideActivity.start(view.getWest(), eventBus);
            }

        } else if (place instanceof ApplicationEditorPlace) {

            // west and/or east could contains palettes of features to put in
            // the application
            view.hideEast();
            view.showWest();
            view.showCenter();

            if (Strings.isEmpty(((ApplicationEditorPlace) place)
                    .getApplicationProfileUriId())) {
                ApplicationProfileListActivity applicationProfileListActivity = new ApplicationProfileListActivity(
                        place, clientFactory);
                applicationProfileListActivity.start(view.getWest(), eventBus);

                ApplicationEditorGuideActivity applicationEditorGuideActivity = new ApplicationEditorGuideActivity(
                        place, clientFactory);
                applicationEditorGuideActivity
                        .start(view.getCenter(), eventBus);

            } else {
                ApplicationEditorActivity applicationEditorActivity = new ApplicationEditorActivity(
                        place, clientFactory);
                applicationEditorActivity.start(view.getCenter(), eventBus);

                ApplicationEditorGuideActivity applicationEditorGuideActivity = new ApplicationEditorGuideActivity(
                        place, clientFactory);
                applicationEditorGuideActivity.start(view.getWest(), eventBus);
            }

        } else if (place instanceof AdminPlace) {

            view.hideEast();
            view.showWest();
            view.showCenter();

            if (Strings.isEmpty(((AdminPlace) place).getUserUriId())) {
                UserListActivity userListActivity = new UserListActivity(place, clientFactory);
                userListActivity.start(view.getWest(), eventBus);

                AdminGuideActivity adminGuideActivity = new AdminGuideActivity(place, clientFactory);
                adminGuideActivity.start(view.getCenter(), eventBus);

            } else {
                UserEditorActivity userEditorActivity = new UserEditorActivity(place, clientFactory);
                userEditorActivity.start(view.getCenter(), eventBus);

                UserEditorGuideActivity userEditorGuideActivity = new UserEditorGuideActivity(place, clientFactory);
                userEditorGuideActivity.start(view.getWest(), eventBus);
            }


        } else {
            // what else? Configure the welcome view as well
            WelcomeActivity welcomeActivity = new WelcomeActivity(place,
                    clientFactory);
            welcomeActivity.start(view.addNewWidget(null, false,
                    MainView.Position.TOP_CENTER), eventBus);

            view.hideEast();
            view.hideWest();
        }

        panel.setWidget(view.asWidget());

        registerViewDetacher(view);

        if ((!(place instanceof WelcomePlace))
                && (!(place instanceof LoginPlace))
                && (!(place instanceof RegisterPlace)))
            // not allowed to stay here without being logged in
            if (!clientFactory.isLoggedIn()) {
                GWT.runAsync(new RunAsyncCallback() {
                    @Override
                    public void onFailure(Throwable reason) {
                        //
                    }

                    @Override
                    public void onSuccess() {
                        goTo(new LoginPlace(Strings.EMPTY));
                    }
                });
            }

    }

    private void createSearchResultWidget(
            SearchProviderEvent searchProviderEvent) {
        SearchResultsActivity searchResultsActivity = new SearchResultsActivity(
                clientFactory);
        searchResultsActivity.start(view.getCenter(), this.getClientFactory()
                .getEventBus());

        view.layout();

        // allow the widget to process the event (not that elegant..)
        searchResultsActivity.onProviderSearchRetrieved(searchProviderEvent);
    }

    private MonitoringActivity createMonitoringWidget(
            MonitoringApplicationRequestedEvent event) {
        MonitoringActivity monitoringActivity = new MonitoringActivity(
                clientFactory, event.getApplications());

        // HasOneWidget widgetContainer = view.addNewWidget(
        // "Monitoring selected applications", true,
        // MainView.Position.TOP_CENTER);

        monitoringActivity.start(view.getCenter(), this.getClientFactory()
                .getEventBus());

        view.layout();

        // allow the widget to process the event (not that elegant..)
        monitoringActivity.onMonitoringApplicationRequested(event);

        return monitoringActivity;
    }

    private SLAContractActivity createSLAContractWidget(
            SLAContractRequestedEvent event) {
        SLAContractActivity slaContractActivity = new SLAContractActivity(
                clientFactory, event.getSLAContractId());
        
        slaContractActivity.start(view.getCenter(), this.getClientFactory()
                .getEventBus());

        view.layout();

        // allow the widget to process the event (not that elegant..)
        slaContractActivity.onSLAContractRequested(event);

        return slaContractActivity;
    }
    
    private void showSLAViolationsWidget(SLAViolationsActivity sLAViolationsActivity) {
    	sLAViolationsActivity.start(view.getCenter(), this.getClientFactory().getEventBus());
        view.layout();
    }

}
