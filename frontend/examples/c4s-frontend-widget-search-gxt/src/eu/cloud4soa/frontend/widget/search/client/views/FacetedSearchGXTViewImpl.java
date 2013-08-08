package eu.cloud4soa.frontend.widget.search.client.views;

import java.util.HashMap;
import java.util.Map;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class FacetedSearchGXTViewImpl extends LayoutContainer {
	private CustomizeFacetsPanel customizeFacetsPanel;
	private FacetedSearchPanel facetedSearchPanel;
	private final EventBus eventBus = new SimpleEventBus();

	public EventBus getEventBus() {
		return eventBus;
	}

	protected void onRender(Element target, int index) {
		super.onRender(target, index);

		final BorderLayout layout = new BorderLayout();
		setLayout(layout);
		setStyleAttribute("padding", "10px");

		ContentPanel west = new ContentPanel();
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
		westData.setMargins(new Margins(0, 5, 0, 0));

		BorderLayoutData centerData = new BorderLayoutData(LayoutRegion.CENTER,.75f);
		centerData.setMargins(new Margins(0));

		add(west, westData);
		add(center, centerData);

		setHeight(300);
	}
}
