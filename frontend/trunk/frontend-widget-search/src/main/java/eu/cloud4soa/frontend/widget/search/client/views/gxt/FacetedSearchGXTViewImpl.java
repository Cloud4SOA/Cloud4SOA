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

package eu.cloud4soa.frontend.widget.search.client.views.gxt;

import java.util.List;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.event.shared.EventBus;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.Facet;
import eu.cloud4soa.frontend.widget.search.client.activities.FacetedSearchActivity;
import eu.cloud4soa.frontend.widget.search.client.views.FacetedSearchView;

public class FacetedSearchGXTViewImpl extends LayoutContainer implements FacetedSearchView{
	private CustomizeFacetsPanel customizeFacetsPanel;
	private FacetedSearchPanel facetedSearchPanel;
	private ContentPanel customizeFacetsView;
	private int height = 300;
	
	//Use presenter (Activity) to communicate UI events to the business logic
	private Presenter presenter;
	
	//Default constructor required by GWT.create() 
	public FacetedSearchGXTViewImpl(){
	}
	
	@Override
	public EventBus getEventBus() {
		return ((FacetedSearchActivity) presenter).getClientFactory().getEventBus();
	}

	@Override
	public void initializeView() {
		final BorderLayout layout = new BorderLayout();
		setLayout(layout);
		setStyleAttribute("padding", "10px");

		final ContentPanel west = new ContentPanel();
		west.setHeading("Customize facets");
		customizeFacetsPanel = new CustomizeFacetsPanel(this);
		west.add(customizeFacetsPanel);

		ContentPanel center = new ContentPanel();
		facetedSearchPanel = new FacetedSearchPanel(customizeFacetsPanel, this);
		center.add(facetedSearchPanel);
		center.setHeading("Faceted Search");
		center.setScrollMode(Scroll.NONE);

		BorderLayoutData westData = new BorderLayoutData(LayoutRegion.WEST, .25f);
		westData.setSplit(true);
		westData.setCollapsible(true);
		westData.setMargins(new Margins(0, 5, 0, 5));

		BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER,.75f);
		centerData.setMargins(new Margins(0, 5, 0, 5));

		add(west, westData);
		add(center, centerData);

		setHeight(height);
		
		customizeFacetsView = west;
		
		addListener(Events.Render, new Listener<ComponentEvent>(){

			@Override
			public void handleEvent(ComponentEvent be) {
				west.collapse(); //We keep collapsed the CustomizeFacetsPanel at loading the faceted search
			}
			
		});
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void updateFacet(Facet facet) {
		facetedSearchPanel.updateFacet (facet);
	}
	
	@Override
	public void setFacets(List<Facet> facets) {
		customizeFacetsPanel.setFacets (facets);
		facetedSearchPanel.setFacets (facets);
	}
	
	public void getFacet (String facetLabel){
		presenter.getFacet(facetLabel);
	}
	
	@Override
	public Presenter getPresenter (){
		return presenter;
	}

	@Override
	public void collapseCustomizeFacetsView() {
		customizeFacetsView.collapse();
	}

	@Override
	public void resetFacets(List<Facet> facets) {
		facetedSearchPanel.resetFacets (facets);
	}
}
