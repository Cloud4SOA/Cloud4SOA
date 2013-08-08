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

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.AccordionLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.event.shared.EventBus;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.Facet;
import eu.cloud4soa.frontend.widget.search.client.activities.FacetedSearchActivity;
import eu.cloud4soa.frontend.widget.search.client.views.FacetedSearchView;

public class CatalogueBrowsingGXTViewImpl extends LayoutContainer implements
		FacetedSearchView {
	private CBCustomizeFacetsPanel customizeFacetsPanel;
	private CBFacetedSearchPanel facetedSearchPanel;
	private ContentPanel customizeFacetsView;
	private int height = 300;

	// Use presenter (Activity) to communicate UI events to the business logic
	private Presenter presenter;

	// Default constructor required by GWT.create()
	public CatalogueBrowsingGXTViewImpl() {
	}

	@Override
	public EventBus getEventBus() {
		return ((FacetedSearchActivity) presenter).getClientFactory()
				.getEventBus();
	}

	@Override
	public void initializeView() {

		AccordionLayout aLayout = new AccordionLayout();
		setLayout(aLayout);
		addStyleName("c4s-white-bg");

		// Facet Customization
		ContentPanel fcPanel = new ContentPanel();
		fcPanel.setLayout(new FitLayout());
		fcPanel.setHeading("Facet Customization");
		fcPanel.setAnimCollapse(true);

		customizeFacetsPanel = new CBCustomizeFacetsPanel(this);
		fcPanel.add(customizeFacetsPanel);

		// Facets
		ContentPanel cbPanel = new ContentPanel();
		cbPanel.setLayout(new FitLayout());
		cbPanel.setHeading("Catalogue Browsing");
		cbPanel.setAnimCollapse(true);

		facetedSearchPanel = new CBFacetedSearchPanel(customizeFacetsPanel,
				this);
		cbPanel.add(facetedSearchPanel);

		// Accordion panels
		add(cbPanel);
		add(fcPanel);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void updateFacet(Facet facet) {
		facetedSearchPanel.updateFacet(facet);
	}

	@Override
	public void setFacets(List<Facet> facets) {
		customizeFacetsPanel.setFacets(facets);
		facetedSearchPanel.setFacets(facets);
	}

	public void getFacet(String facetLabel) {
		presenter.getFacet(facetLabel);
	}

	@Override
	public Presenter getPresenter() {
		return presenter;
	}

	@Override
	public void collapseCustomizeFacetsView() {
		customizeFacetsView.collapse();
	}

	@Override
	public void resetFacets(List<Facet> facets) {
		facetedSearchPanel.resetFacets(facets);
	}
}
