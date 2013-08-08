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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreSorter;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.user.client.ui.CheckBox;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.Facet;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.FacetValue;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSFacetModel;
import eu.cloud4soa.frontend.commons.client.events.SelectedFacetChangedEvent;
import eu.cloud4soa.frontend.widget.search.client.views.FacetedSearchView;

public class FacetedSearchPanel extends LayoutContainer {
	private SortedMap<Facet, ListStore<PaaSFacetModel>> stores;
	private CustomizeFacetsPanel customizePaaSFacetsPanel;
	private SortedMap<Facet, VerticalPanel> paaSFacetPanels = new TreeMap<Facet, VerticalPanel>();
	private FacetedSearchView mainview;
	private boolean initialised = false;

	private Map<Facet, ListView<PaaSFacetModel>> facetViews = new HashMap<Facet, ListView<PaaSFacetModel>>();

	private int vpWidth = 180;

	public FacetedSearchPanel(CustomizeFacetsPanel customizePaaSFacetsPanel,
			final FacetedSearchView view) {
		this.customizePaaSFacetsPanel = customizePaaSFacetsPanel;
		this.mainview = view;
	}

	private void initializeView() {
		initialised = true;

		// PaaSFacet stores
		initializePaaSFacetStores();

		LayoutContainer vp = createPaaSFacetedSearchView(customizePaaSFacetsPanel
				.getFacetCustomisation());

		add(vp);

		mainview.getEventBus().addHandler(SelectedFacetChangedEvent.TYPE,
				new SelectedFacetChangedEvent.Handler() {
					@Override
					public void onSelectedFacetChanged(
							SelectedFacetChangedEvent event) {
						Facet facet = event.getFacet();
						boolean selected = event.isSelected();
						System.out.println("Received change in PaaSFacet "
								+ facet.getLabel() + " selected is " + selected);

						modifyPaaSFacetsInPaaSFacetedSearchPanel(facet,
								selected);
					}
				});
		layout();
	}

	private void modifyPaaSFacetsInPaaSFacetedSearchPanel(Facet facet,
			boolean selected) {
		paaSFacetPanels.get(facet).setVisible(selected);
		repaint();
	}

	private LayoutContainer createPaaSFacetedSearchView(
			Map<Facet, CheckBox> paaSFacetsCustomisation) {

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(0);
		FillLayout hp_layout = new FillLayout(Orientation.HORIZONTAL);
		hp_layout.setAdjustForScroll(false);
		hp.setLayout(hp_layout);
		hp.setBorders(true);
		hp.setSize("100%", "100%");
		hp.setScrollMode(Scroll.AUTOX);

		for (Facet facet : stores.keySet()) {
			hp.add(createPaaSFacetPanel(stores.get(facet), facet,
					paaSFacetsCustomisation.get(facet).getValue()));
		}

		return hp;
	}

	private void initializePaaSFacetStores() {
		stores = new TreeMap<Facet, ListStore<PaaSFacetModel>>();
		ListStore<PaaSFacetModel> store;

		for (Facet facet : customizePaaSFacetsPanel.getFacetTypes().keySet()) {
			store = new ListStore<PaaSFacetModel>();
			store.setStoreSorter(new StoreSorter<PaaSFacetModel>());
			stores.put(facet, store);
		}

	}

	private VerticalPanel createPaaSFacetPanel(ListStore<PaaSFacetModel> store,
			Facet facet, boolean visible) {
		VerticalPanel vp = new VerticalPanel();
		vp.setLayout(new RowLayout(Orientation.VERTICAL));
		vp.setBorders(false);
		vp.setScrollMode(Scroll.NONE);
		vp.setSpacing(5);
		vp.setSize(String.valueOf(vpWidth), "100%");
		vp.setVisible(visible);

		Text txtNewText = new Text(facet.getLabel());
		//Structure tooltip with facet label and comment
		ToolTipConfig ttConfig = new ToolTipConfig();
		ttConfig.setTitle(facet.getLabel());
		ttConfig.setText(facet.getComment());
		txtNewText.setToolTip(ttConfig);
		
		txtNewText.setStyleAttribute("font-weight", "bold");
		txtNewText.setHeight(30);
		vp.add(txtNewText);

		ListView<PaaSFacetModel> lv = new ListView<PaaSFacetModel>();
		lv.setDisplayProperty("name");
		//TODO Add tooltip for each listview entry
		lv.setStore(store);
		lv.setSize(String.valueOf(vpWidth - 10), "185");
		// FIXME ListView does not show horizontal scroll bar when its contents
		// lv.setAutoWidth(true);
		// lv.setStyleAttribute("overflow-x", "scroll");

		// Handler to search based on changes on the selected facets
		lv.getSelectionModel().addListener(Events.SelectionChange,
				new Listener<SelectionChangedEvent<PaaSFacetModel>>() {
					@Override
					public void handleEvent(
							SelectionChangedEvent<PaaSFacetModel> sce) {
						List<Facet> facets = getAllCurrentFilters();
						StringBuffer sb = new StringBuffer();
						for (Facet facet : facets) {
							List<FacetValue> values = facet.getValues();
							for (FacetValue fv : values) {
								sb.append(fv.getValue() + " ");
							}
						}
						Info.display("Searching on facets selected",
								sb.toString());
						List<Facet> filters = getAllCurrentFilters();
						mainview.getPresenter().searchPaaSOfferings(filters);
					}
				});

		facetViews.put(facet, lv);

		vp.add(lv);
		paaSFacetPanels.put(facet, vp);
		return vp;
	}

	// FIXME Implement an updateFacets (List<Facet> facets) method for
	// efficiency if layout is required to update the view
	public void updateFacet(Facet facet) {
		if (facet == null) {
			return;
		}

		ListStore<PaaSFacetModel> store = stores.get(facet);
		if (store == null)
			return;
		List<FacetValue> filters = getCurrentFilters(facetViews.get(facet));

		if (filters != null && filters.size() == 0) {
			store.removeAll();
			if (facet.getValues().size() != 0) {
				store.add(getFacetModel(facet.getValues()));
			}
		}

		facetViews.get(facet).refresh();
	}

	public void setFacets(List<Facet> facets) {
		resetFacets(facets);
	}

	public void resetFacets(List<Facet> facets) {
		if (!initialised)
			initializeView();

		for (Facet facet : facets)
			setFacet(facet);
	}

	private void setFacet(Facet facet) {
		ListStore<PaaSFacetModel> store = stores.get(facet);
		store.removeAll();
		store.add(getFacetModel(facet.getValues()));

		facetViews.get(facet).refresh();
	}

	public static List<? extends PaaSFacetModel> getFacetModel(
			List<FacetValue> values) {
		List<PaaSFacetModel> facets = new ArrayList<PaaSFacetModel>();

		for (FacetValue fv : values) {
			String value = fv.getValue();
			String description = fv.getDescription();
			facets.add(new PaaSFacetModel(value, description));
		}

		return facets;
	}

	/**
	 * This method retrieves all data from filters
	 * 
	 * @return Map containing filter values
	 */
	public List<Facet> getAllCurrentFilters() {
		List<Facet> cf = new ArrayList<Facet>();

		Set<Facet> facets = facetViews.keySet();
		ListView<PaaSFacetModel> listView = null;
		for (Facet facet : facets) {
			listView = facetViews.get(facet);
			if (listView.isVisible()) {
				ArrayList<FacetValue> selectedFacets = this
						.getCurrentFilters(listView);
				if (!selectedFacets.isEmpty()) {
					Facet f = new Facet(facet.getType(), facet.getCategory(), facet.getLabel(),
							facet.getComment(), facet.getQueryType(),
							selectedFacets);
					cf.add(f);
				}
			}
		}

		return cf;
	}

	/**
	 * Helper method that retrieves data from one filter
	 * 
	 * @param listView
	 * @return ArrayList containing all filters
	 */
	private ArrayList<FacetValue> getCurrentFilters(
			ListView<PaaSFacetModel> listView) {
		ArrayList<FacetValue> flist = new ArrayList<FacetValue>();
		if (listView == null)
			return flist;
		List<PaaSFacetModel> selectedFacets = listView.getSelectionModel()
				.getSelectedItems();
		for (PaaSFacetModel facet : selectedFacets) {
			if (!((String) facet.get("name")).isEmpty())
				flist.add(new FacetValue((String) facet.get("name"), ""));
		}

		return flist;
	}
}
