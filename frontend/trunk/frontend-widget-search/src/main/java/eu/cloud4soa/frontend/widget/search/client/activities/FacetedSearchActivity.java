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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.Facet;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.FacetValue;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.events.SearchProviderEvent;
import eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService;
import eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryServiceAsync;
import eu.cloud4soa.frontend.widget.search.client.views.FacetedSearchView;

public class FacetedSearchActivity extends Cloud4SoaActivity implements FacetedSearchView.Presenter, EventHandler {
    private FacetedSearchView facetedSearchView;
    private Map<String, Facet> facets;
    private List<Facet> unfilteredFacets;
    private MessageBox mb;
    
    // Services
    private PaaSOfferingDiscoveryServiceAsync searchSOAService = GWT.create(PaaSOfferingDiscoveryService.class);
 
    public FacetedSearchActivity(Cloud4SOAUIClientFactory clientFactory) {
    	super (null, clientFactory);

        // TODO ask Yosu why the faceted search needed this
//        addHandler(UserLoggedInEvent.TYPE, new UserLoggedInEvent.Handler() {
//            @Override
//            public void onUserLogin(UserLoggedInEvent event) {
//            	facetedSearchView.collapseCustomizeFacetsView ();
//            }
//        });
    }

	/**
     * Invoked by the ActivityManager to start a new Activity
     */
    @Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {   	
    	getFacets();
    	facetedSearchView = GWT.create(FacetedSearchView.class); 
    	facetedSearchView.setPresenter(this);
    	facetedSearchView.initializeView();
    	
        containerWidget.setWidget(facetedSearchView.asWidget());

        registerViewDetacher(facetedSearchView);
    }

    /**
     * Ask user before stopping this activity
     */
    @Override
    public String mayStop() {
    	return null;
    }

    @Override
	public void getFacet(String facetLabel) {
    	if (facets != null && !facets.isEmpty()){
    		Facet facet = facets.get(facetLabel);
    		if (facet != null)
    			facetedSearchView.updateFacet(facet);
    	}
	}
    
	private void updateFacets(List<Facet> gotfacets) {
		for (Facet facet: gotfacets){
			facets.get(facet.getLabel()).setValues (facet.getValues());
		}
	}
		
	private void setFacets(List<Facet> gotfacets) {
		facets = new HashMap<String, Facet>();
		for (Facet facet: gotfacets){
			facets.put(facet.getLabel(), facet);
		}
		unfilteredFacets = cloneFacets(gotfacets);//Keep for resetting facets
	}
	
	private void resetFacets() {		
		for (Facet facet: unfilteredFacets){
			facets.get (facet.getLabel()).setValues(facet.getValues());
		}
		facetedSearchView.resetFacets(new ArrayList<Facet>(facets.values()));
	}

	private List<Facet> cloneFacets(List<Facet> facets) {
		List<Facet> results = new ArrayList<Facet>();
		for (Facet f: facets){
			List<FacetValue> values = new ArrayList<FacetValue>();
			for (FacetValue fv: f.getValues()){
				values.add(new FacetValue (fv.getValue(), fv.getDescription()));
			}
			Facet facet = new Facet (f.getType(), f.getCategory(), f.getLabel(), f.getComment(), f.getQueryType(), values);
			results.add(facet);
		}
		return results;
	}

	private AsyncCallback<ListLoadResult<PaaSOfferingModel>> callback = new AsyncCallback<ListLoadResult<PaaSOfferingModel>>() {
        @Override
		public void onFailure(Throwable caught) {
        	mb.close();
        	Window.alert("There was an error while retrieving search results. Please, contact site administration");
//        	handleRPCFailure("Error retrieving search results", caught);
        }

        @Override
		public void onSuccess(ListLoadResult<PaaSOfferingModel> data) {
        	mb.close();
            List<PaaSOfferingModel> results = data.getData();
            GWT.log("Data from faceted activity : "+ results.size());
            
        	if (!results.isEmpty()){//Returned search results. Filtering facets based on those results
        		Collections.sort(results);
        		filterFacets(results);
        	}
        	
        	SearchProviderEvent se = new SearchProviderEvent(null, results);
        	clientFactory.getEventBus().fireEvent(se);
        }
    };
    

	private void getFacets() {	    	
		searchSOAService.getAvailableFacets(new AsyncCallback<List<Facet>>(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("There was an error while retrieving available facets. Please, contact site administration");
//				handleRPCFailure("Error retrieving available facets", caught);
			}

			@Override
			public void onSuccess(List<Facet> gotfacets) {
				setFacets(gotfacets);
				facetedSearchView.setFacets(gotfacets);
			}});
	}
    
	private void filterFacets(List<PaaSOfferingModel> offerings) {
		List<String> offeringIds = getIds (offerings);
		
		searchSOAService.filterFacets(offeringIds, new AsyncCallback<List<Facet>>(){

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("There was an error while filtering facets. Please, contact site administration");
//				handleRPCFailure("Error filtering facets", caught);
			}

			@Override
			public void onSuccess(List<Facet> gotfacets) {
				updateFacets(gotfacets);
				for (Facet facet:facets.values())
					facetedSearchView.updateFacet(facet);
			}
		});
	}

    
	private List<String> getIds(List<PaaSOfferingModel> offerings) {
		List<String> ids = new ArrayList<String>();
		for (PaaSOfferingModel offer: offerings)
			ids.add(offer.getKey());
		return ids;
	}

	@Override
	public void searchPaaSOfferings(List<Facet> allCurrentFilters) {		
		if (!arefacetsSelected(allCurrentFilters)){
			resetFacets();
		}
		
        mb = MessageBox.wait("Searching...", Strings.EMPTY, "Searching for matching PaaS Offerings...");
        //setting query type from facets
        setQueryType(allCurrentFilters);
        searchSOAService.facetedSearchForMatchingPlatform(allCurrentFilters, callback);
	}

	private boolean arefacetsSelected(List<Facet> allCurrentFilters) {
		boolean result = false;
		
		for (Facet facet: allCurrentFilters){
			if (!facet.getValues().isEmpty()){
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	private void setQueryType(List<Facet> allCurrentFilters) {
		for (Facet facet: allCurrentFilters){
			facet.setQueryType(facets.get(facet.getLabel()).getQueryType());
		}
	}

}
