package eu.cloud4soa.frontend.widget.search.client.views;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.Style.VerticalAlignment;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.StoreSorter;
import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.google.gwt.user.client.ui.CheckBox;

import eu.cloud4soa.frontend.widget.search.client.data.Facet;
import eu.cloud4soa.frontend.widget.search.client.data.Facet.FACET_TYPE;
import eu.cloud4soa.frontend.widget.search.client.data.FacetData;
import eu.cloud4soa.frontend.widget.search.client.events.SelectedFacetChangedEvent;

public class FacetedSearchPanel extends Composite {
	private Map<Facet.FACET_TYPE, ListStore<Facet>> stores;
	private CustomizeFacetsPanel customizeFacetsPanel;
	private Map<Facet.FACET_TYPE, VerticalPanel> facetPanels = new HashMap<Facet.FACET_TYPE, VerticalPanel>();
	private int vpWidth = 120;

	ListStore<Facet> storeProvider;
	ListStore<Facet> storeTech;
	ListStore<Facet> storeTools;
	ListStore<Facet> storeChannels;
	ListStore<Facet> storeRatings;
	ListStore<Facet> storeResources;
	ListStore<Facet> storeFeatures;
	ListStore<Facet> storePricingPolicies;

	public FacetedSearchPanel(CustomizeFacetsPanel customizeFacetsPanel, final FacetedSearchGXTViewImpl view) {
		this.customizeFacetsPanel = customizeFacetsPanel;
		
		// Facet stores
		initializeFacetStores();

		LayoutContainer vp = createFacetedSearchView(customizeFacetsPanel.getFacetCustomisation());

		initComponent(vp);
		
		view.getEventBus().addHandler(SelectedFacetChangedEvent.TYPE, new SelectedFacetChangedEvent.Handler()
        {
            @Override
            public void onSelectedFacetChanged(SelectedFacetChangedEvent event)
            {
                Facet.FACET_TYPE facet_type = event.getFacet_type();
                boolean selected= event.isSelected();
                System.out.println ("Received change in Facet " + facet_type.getName() + 
						" selected is " + selected);
                
                modifyFacetsInFacetedSearchPanel (facet_type, selected);
            }
        });

	}

	private void modifyFacetsInFacetedSearchPanel(
			FACET_TYPE facet_type, boolean selected) {
		facetPanels.get(facet_type).setVisible(selected);
		repaint();
	}
	
	private LayoutContainer createFacetedSearchView(
			Map<Facet.FACET_TYPE, CheckBox> facetsCustomisation) {

		HorizontalPanel hp = new HorizontalPanel();
		hp.setSpacing(0);
		FillLayout hp_layout = new FillLayout(Orientation.HORIZONTAL);
		hp_layout.setAdjustForScroll(true);
		hp.setLayout(hp_layout);
		hp.setBorders(true);
		hp.setSize("100%", "100%");
		hp.setScrollMode(Scroll.AUTOX);

		for (Facet.FACET_TYPE facet_type : stores.keySet()) {
			hp.add(createFacetPanel(stores.get(facet_type), facet_type, facetsCustomisation.get(facet_type).getValue()));
		}

		return hp;
	}

	private void initializeFacetStores() {
		stores = new HashMap<Facet.FACET_TYPE, ListStore<Facet>>();
		ListStore<Facet> store;

		store = new ListStore<Facet>();
		store.setStoreSorter(new StoreSorter<Facet>());
		store.add(FacetData.getProviders());
		stores.put(Facet.FACET_TYPE.PROVIDER, store);

		store = new ListStore<Facet>();
		store.setStoreSorter(new StoreSorter<Facet>());
		store.add(FacetData.getTechnologies());
		stores.put(Facet.FACET_TYPE.TECHNOLOGY, store);

		store = new ListStore<Facet>();
		store.setStoreSorter(new StoreSorter<Facet>());
		store.add(FacetData.getTools());
		stores.put(Facet.FACET_TYPE.TOOL, store);

		store = new ListStore<Facet>();
		store.setStoreSorter(new StoreSorter<Facet>());
		store.add(FacetData.getChannels());
		stores.put(Facet.FACET_TYPE.CHANNEL, store);

		store = new ListStore<Facet>();
		store.setStoreSorter(new StoreSorter<Facet>());
		store.add(FacetData.getRatings());
		stores.put(Facet.FACET_TYPE.RATING, store);

		store = new ListStore<Facet>();
		store.setStoreSorter(new StoreSorter<Facet>());
		store.add(FacetData.getResources());
		stores.put(Facet.FACET_TYPE.RESOURCE, store);

		store = new ListStore<Facet>();
		store.setStoreSorter(new StoreSorter<Facet>());
		store.add(FacetData.getFeatures());
		stores.put(Facet.FACET_TYPE.FEATURE, store);

		store = new ListStore<Facet>();
		store.setStoreSorter(new StoreSorter<Facet>());
		store.add(FacetData.getPricingPolicies());
		stores.put(Facet.FACET_TYPE.PRICING_POLICY, store);
	}

	private VerticalPanel createFacetPanel(ListStore<Facet> store, Facet.FACET_TYPE type, boolean visible) {
		VerticalPanel vp = new VerticalPanel();
		vp.setLayout(new RowLayout(Orientation.VERTICAL));
		vp.setBorders(false);
		vp.setScrollMode(Scroll.NONE);
		vp.setSpacing(5);
		vp.setSize(String.valueOf(vpWidth), "100%");
		vp.setVisible(visible);

		Text txtNewText = new Text(type.getName());
		txtNewText.setStyleAttribute("font-weight", "bold");
		vp.add(txtNewText);

		ListView<Facet> lv = new ListView<Facet>();
		lv.setDisplayProperty("name");
		lv.setStore(store);
		lv.setSize(String.valueOf(vpWidth-10), "140");

		vp.add(lv);
		facetPanels.put(type, vp);
		return vp;
	}

}
