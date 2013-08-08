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
import java.util.List;

import org.cobogw.gwt.user.client.ui.Rating;

import com.extjs.gxt.ui.client.Style.ButtonScale;
import com.extjs.gxt.ui.client.Style.IconAlign;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.CardPanel;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.HtmlContainer;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.resources.Icons;
import eu.cloud4soa.frontend.widget.search.client.data.Offering;
import eu.cloud4soa.frontend.widget.search.client.data.OfferingStore;
import eu.cloud4soa.frontend.widget.search.client.views.SearchResultsView;

public class SearchResultGrid extends CardPanel {
	private OfferingStore offeringsStore = new OfferingStore();
	private Grid<Offering> grid;
	private ListStore<Offering> store;
	private ColumnModel cm;
	private PagingToolBar toolBar;
	private List<PaaSOfferingModel> paaSofferingResults;
	private PaaSOfferingModel selectedPaaSOffering;
	private SearchResultsView searchResultView;
	private LayoutContainer noResultsPanel;
	private ContentPanel gridPanel;

	public SearchResultGrid(SearchResultGXTViewImpl searchResultGXTViewImpl) {
		this.searchResultView = searchResultGXTViewImpl;

		createView();
	}

	private void createView() {
		addStyleName("c4s-white-bg");

		List<Offering> offerings = offeringsStore.getOfferings();

		// Creating views for card panel
		// View one for grid
		// View two for empty results

		gridPanel = new ContentPanel();
		gridPanel.setHeaderVisible(false);
		gridPanel.setLayout(new FitLayout());
		gridPanel.setHeaderVisible(false);
		createGridView(offerings);
		add(gridPanel);

		noResultsPanel = new LayoutContainer();
		noResultsPanel.setLayout(new FitLayout());
		noResultsPanel.setLayout(new RowLayout(Orientation.VERTICAL));
		noResultsPanel.add(new HtmlContainer(
				"<div><b>There are no results to show</b></div>"), new RowData(
				1, 1, new Margins(10)));
		add(noResultsPanel);

		setActiveItem(noResultsPanel);
	}

	private void createGridView(List<Offering> offerings) {
		PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(offerings);

		// loader
		final PagingLoader loader = new BasePagingLoader(proxy);
		loader.setRemoteSort(true);

		store = new ListStore<Offering>(loader);

		toolBar = new PagingToolBar(10);
		toolBar.bind(loader);
		loader.load(0, 10);
		
		GridCellRenderer<Offering> ratingRenderer = new GridCellRenderer<Offering>() {  
			  
		    @Override
			public Object render(final Offering model, String property, ColumnData config, final int rowIndex,  
		          final int colIndex, ListStore<Offering> store, Grid<Offering> grid) {  

		        Rating rating = new Rating(model.<Integer>get(property), 5);
		        rating.setReadOnly(true);
		        rating.addValueChangeHandler(new ValueChangeHandler() {
					  @Override
					public void onValueChange(ValueChangeEvent event) {
					    GWT.log("selected: " + event.getValue());
					  }
					});
		        return rating;  
		    }  
		};  

		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		columns.add(new ColumnConfig("name", "PaaS Offer", 200));
		columns.add(new ColumnConfig("provider", "PaaS Provider", 180));
		columns.add(new ColumnConfig("deploymentMethod", "Deployment Method", 100));
		ColumnConfig ratingConfig = new ColumnConfig("averageRating", "Rating", 100);
		ratingConfig.setRenderer(ratingRenderer);
		columns.add(ratingConfig);
		columns.add(new ColumnConfig("score", "Matching score (%)", 100));

		// See more details column.
		ColumnConfig selection = new ColumnConfig("selected", "", 40);
		GridCellRenderer<Offering> renderer = new GridCellRenderer<Offering>() {
			@Override
			public Object render(final Offering model, String property,
					ColumnData config, final int rowIndex, final int colIndex,
					ListStore<Offering> store, Grid<Offering> grid) {

				SelectionListener sl = new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
						Info.display("Selected PaaS Offering", "<ul><li>"
								+ model.get("name") + "</li></ul>");
						((SearchResultGXTViewImpl) searchResultView)
								.showPaaSOfferingDetailsView();
					}
				};

				Button b = null;
				if (grid.getSelectionModel().getSelectedItem() != null
						&& grid.getSelectionModel().getSelectedItem()
								.get("name")
								.equals(store.getAt(rowIndex).get("name"))) {
					b = new Button(" ", sl);
					b.setIcon(AbstractImagePrototype.create(Icons.RESOURCES
							.moreDetails()));
					b.setIconAlign(IconAlign.LEFT);
					b.setToolTip("Click for more information");
					b.setScale(ButtonScale.SMALL);
					b.setSize(32, 32);
				}
				return b;
			}
		};
		selection.setRenderer(renderer);
		columns.add(selection);

		cm = new ColumnModel(columns);

		grid = new Grid<Offering>(store, cm);
		grid.addListener(Events.RowClick, new Listener<GridEvent<Offering>>() {

			@Override
			public void handleEvent(GridEvent<Offering> be) {
				String offering = be.getGrid().getSelectionModel()
						.getSelectedItem().getName();
				Info.display("Selected PaaS Offering", offering);
				selectedPaaSOffering = paaSofferingResults.get(be.getRowIndex());

				// Refreshing grid view to show more details button
				be.getGrid().getView().refresh(false);

				// Send Paas Offering selected event
				searchResultView.getPresenter().onPaaSOfferingSelected(
						selectedPaaSOffering);
			}

		});

		grid.setLoadMask(true);
		grid.setBorders(true);
		grid.setAutoExpandColumn("name");
		grid.getView().setForceFit(true);

		gridPanel.add(grid);
		gridPanel.setBottomComponent(toolBar);
	}

	public void setPaaSOfferingResults(List<PaaSOfferingModel> paaSofferings) {
		paaSofferingResults = paaSofferings;
		offeringsStore.load(paaSofferings);
		List<Offering> offerings = offeringsStore.getOfferings();

		if (offerings.isEmpty()) {
			setActiveItem(noResultsPanel);
			searchResultView.showPaaSOfferingDetails(null);
		} else {
			PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(offerings);

			// loader
			final PagingLoader loader = new BasePagingLoader(proxy);
			loader.setRemoteSort(true);

			ListStore<Offering> store = new ListStore<Offering>(loader);
			toolBar.bind(loader);
			loader.load(0, 10);

			grid.reconfigure(store, cm);

			setActiveItem(gridPanel);
			layout();
		}
		((SearchResultGXTViewImpl) searchResultView)
				.showPaaSOfferingResultsView();
	}

	public PaaSOfferingModel getSelectedPaaSOffering() {
		return selectedPaaSOffering;
	}
}
