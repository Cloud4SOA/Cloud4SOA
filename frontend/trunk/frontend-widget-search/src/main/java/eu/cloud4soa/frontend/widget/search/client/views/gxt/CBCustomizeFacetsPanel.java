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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.CheckBox;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.Facet;
import eu.cloud4soa.frontend.commons.client.events.SelectedFacetChangedEvent;
import eu.cloud4soa.frontend.widget.search.client.views.FacetedSearchView;

public class CBCustomizeFacetsPanel extends ContentPanel {

	private Map<Facet, CheckBox> cbFacets = new HashMap<Facet, CheckBox>();
	private SortedMap<Facet, Boolean> facets;
	private FacetedSearchView view;
	private boolean initialised = false;

	public SortedMap<Facet, Boolean> getFacetTypes() {
		return facets;
	}

	public Map<Facet, CheckBox> getFacetCustomisation() {
		return cbFacets;
	}

	public CBCustomizeFacetsPanel(final FacetedSearchView view) {
		this.view = view;
		setHeaderVisible(false);
		setScrollMode(Scroll.AUTO);

		// add(new Label(""));
		setBorders(true);

		// setHeight(300);
	}

	private void initializeView() {
		initialised = true;

		VBoxLayoutData vboxData = new VBoxLayoutData(new Margins(5));

		Listener<FieldEvent> facetListener = new Listener<FieldEvent>() {
			@Override
			public void handleEvent(FieldEvent fe) {
				System.out.println("Facet "
						+ ((CheckBox) fe.getSource()).getBoxLabel()
						+ " selected is "
						+ ((CheckBox) fe.getSource()).getValue());
				// Send facet customisation change to FacetedSearchPanel
				try {
					view.getEventBus().fireEvent(
							new SelectedFacetChangedEvent(
									getFacetFromCheckBox((CheckBox) fe
											.getSource()), ((CheckBox) fe
											.getSource()).getValue()));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};

		// TODO Manage default selected facet from user's preferences
		for (Facet facet : facets.keySet()) {
			addFacetCheckbox(vboxData, facetListener, facet, facets.get(facet));
		}

		((LayoutContainer) view).layout();
	}

	public void setFacets(List<Facet> gotFacets) {
		facets = new TreeMap<Facet, Boolean>();
		for (Facet facet : gotFacets) {
			facets.put(facet, true);
		}

		// Initialize view
		if (!initialised)
			initializeView();
	}

	private void addFacetCheckbox(VBoxLayoutData vboxData,
			Listener<FieldEvent> facetListener, Facet facet, boolean show) {
		CheckBox cb = new CheckBox();
		cb.setBoxLabel(facet.getLabel());
		//Structure tooltip with facet label and comment
		ToolTipConfig ttConfig = new ToolTipConfig();
		ttConfig.setTitle(facet.getLabel());
		ttConfig.setText(facet.getComment());
		cb.setToolTip(ttConfig);
		cb.addListener(Events.OnClick, facetListener);
		add(cb, vboxData);
		cb.setValue(show);
		cbFacets.put(facet, cb);
	}

	private Facet getFacetFromCheckBox(CheckBox box) {
		Facet result = null;
		for (Facet facet : cbFacets.keySet()) {
			if (cbFacets.get(facet).equals(box)) {
				result = facet;
				break;
			}
		}
		return result;
	}

	/**
	 * @param facet
	 * @return
	 */
	public boolean isFacetSelected(Facet facet) {
		return cbFacets.get(facet).getValue();
	}
}
