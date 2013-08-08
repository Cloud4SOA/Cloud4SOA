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

package eu.cloud4soa.frontend.widget.search.client.activities;

import java.util.Collections;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.ListDataProvider;

import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateModel;
import eu.cloud4soa.frontend.commons.client.events.PaaSOfferingDetailsRequestedEvent;
import eu.cloud4soa.frontend.commons.client.events.PaaSOfferingSelectedEvent;
import eu.cloud4soa.frontend.commons.client.events.SearchProviderEvent;
import eu.cloud4soa.frontend.widget.search.client.views.SearchResultsView;

public class SearchResultsActivity extends Cloud4SoaActivity implements SearchResultsView.Presenter, SearchProviderEvent.Handler, PaaSOfferingSelectedEvent.Handler {

    private SearchResultsView searchResultsView;
    
    public SearchResultsActivity(Cloud4SOAUIClientFactory clientFactory) {
    	super (null, clientFactory);    	
        addHandler(SearchProviderEvent.TYPE, this);
        addHandler(PaaSOfferingSelectedEvent.TYPE, this);
    }

    /**
     * The provider that holds the list of paas offerings in the database.
     */
    private ListDataProvider<PaaSOfferingModel> dataProvider = new ListDataProvider<PaaSOfferingModel>();

	/**
     * Invoked by the ActivityManager to start a new Activity
     */
    public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {    	
    	searchResultsView = GWT.create(SearchResultsView.class);
    	searchResultsView.setPresenter(this);
        containerWidget.setWidget(searchResultsView.asWidget());
        registerViewDetacher(searchResultsView);
    }

    /**
     * Ask user before stopping this activity
     */
    @Override
    public String mayStop() {
        return null;
    }


	private void setSearchResults (List<PaaSOfferingModel> data){
		Collections.sort(data);
		dataProvider.setList(data); //TODO Include rank score in the view
    	searchResultsView.setPaaSOfferingResults(dataProvider.getList());
    	searchResultsView.showResultsContainer(true);
	}

	public void addDataDisplay(CellTable<PaaSOfferingModel> ctPaaSOffers) {
		dataProvider.addDataDisplay(ctPaaSOffers);
	}

	@Override
	public void onProviderSearchRetrieved(SearchProviderEvent s) {
		setSearchResults(s.getOfferingList());
	}

	@Override
	public void onPaaSOfferingSelected(PaaSOfferingModel paasOffering) {
		clientFactory.getEventBus().fireEvent(new PaaSOfferingSelectedEvent(paasOffering));
	}

	@Override
	public void onPaaSOfferingDetailsRequested(PaaSOfferingModel paasOffering) {
		clientFactory.getEventBus().fireEvent(new PaaSOfferingDetailsRequestedEvent(paasOffering));
	}

	@Override
	public void onPaaSOfferingSelected(PaaSOfferingSelectedEvent event) {
		searchResultsView.showPaaSOfferingDetails(event.getPaaSOffering());
		searchResultsView. getPresenter().onPaaSOfferingDetailsRequested(event.getPaaSOffering());
	}
	
}
