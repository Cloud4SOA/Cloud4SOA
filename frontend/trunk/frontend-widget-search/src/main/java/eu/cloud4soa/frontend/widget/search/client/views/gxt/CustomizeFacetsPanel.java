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
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.CheckBox;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.Facet;
import eu.cloud4soa.frontend.commons.client.events.SelectedFacetChangedEvent;
import eu.cloud4soa.frontend.widget.search.client.views.FacetedSearchView;

public class CustomizeFacetsPanel extends LayoutContainer {

	private int height = 200;
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

	public CustomizeFacetsPanel(final FacetedSearchView view) {
		this.view = view;
	}

	private void initializeView() {
		initialised = true;

		setHeight(height);
		setScrollMode(Scroll.NONE);
		setBorders(false);
		VBoxLayout layout = new VBoxLayout();
		layout.setPadding(new Padding(5));
		layout.setVBoxLayoutAlign(VBoxLayoutAlign.LEFT);
		setLayout(layout);
		VBoxLayoutData vboxData = new VBoxLayoutData(new Margins(2));

		ValueChangeHandler<Boolean> facetHandler = new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				System.out.println("Facet "
						+ ((CheckBox) event.getSource()).getText()
						+ " selected is "
						+ ((CheckBox) event.getSource()).getValue());
				// Send facet customisation change to FacetedSearchPanel
				try {
					view.getEventBus().fireEvent(
							new SelectedFacetChangedEvent(
									getFacetFromCheckBox((CheckBox) event
											.getSource()), ((CheckBox) event
											.getSource()).getValue()));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};

		// TODO Manage default selected facet from user's preferences
		for (Facet facet : facets.keySet()) {
			addFacetCheckbox(vboxData, facetHandler, facet, facets.get(facet));
		}

		layout();
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
			ValueChangeHandler<Boolean> facetHandler, Facet facet, boolean show) {
		CheckBox cb = new CheckBox(facet.getLabel());
		cb.addValueChangeHandler(facetHandler);
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
}
