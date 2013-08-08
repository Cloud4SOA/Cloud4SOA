package eu.cloud4soa.frontend.widget.search.client.views;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.SimplePanel;

import eu.cloud4soa.frontend.widget.search.client.data.PaasOffering;
import eu.cloud4soa.frontend.widget.search.client.data.PaasOfferingStore;
import eu.cloud4soa.frontend.widget.search.client.images.Icons;

public class SearchResultGrid extends LayoutContainer {
	Grid<PaasOffering> grid;
	PaasOfferingStore offeringsStore;
	ColumnModel cm;
	PagingToolBar toolBar;
	SearchResultGXTViewImpl panel;
	
	public SearchResultGrid(SearchResultGXTViewImpl searchResultGXTViewImpl) {
		this.panel = searchResultGXTViewImpl;
	}

	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);

		offeringsStore = new PaasOfferingStore();
		PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(
				offeringsStore.getPaasOffering());

		// loader
		final PagingLoader loader = new BasePagingLoader(proxy);
		loader.setRemoteSort(true);

		ListStore<PaasOffering> store = new ListStore<PaasOffering>(loader);

		toolBar = new PagingToolBar(10);
		toolBar.bind(loader);
		loader.load(0, 10);

		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		columns.add(new ColumnConfig("name", "PaaS Offer", 200));
		columns.add(new ColumnConfig("provider", "PaaS Provider", 200));
		columns.add(new ColumnConfig("programmingLanguage",
				"Programming Language", 200));

		ColumnConfig selection = new ColumnConfig("selected", "", 40);
		selection.setHidden(false);

		GridCellRenderer<PaasOffering> renderer = new GridCellRenderer<PaasOffering>() {

//			private boolean init;

			public Object render(final PaasOffering model, String property,
					ColumnData config, final int rowIndex, final int colIndex,
					ListStore<PaasOffering> store, Grid<PaasOffering> grid) {

				SelectionListener sl = new SelectionListener<ButtonEvent>() {
					@Override
					public void componentSelected(ButtonEvent ce) {
						Info.display("Selected PaaS Offering", "<ul><li>"
								+ model.get("name") + "</li></ul>");
						panel.showDetails();
					}
				};

				Button b = null;
				if (grid.getSelectionModel().getSelectedItem()!= null && grid.getSelectionModel().getSelectedItem().get("name").equals(store.getAt(rowIndex).get("name"))){
					b = new Button("·", sl);
//					b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
//					b.setHeight(grid.getView().getRow(0).getClientHeight()-10);
					b.setIcon(Icons.RESOURCES.moreDetails());
					b.setToolTip("Click for more information");
				}

				return b;
			}

		};
		selection.setRenderer(renderer);
		columns.add(selection);

		cm = new ColumnModel(columns);

		// Preloading grid
		grid = new Grid<PaasOffering>(store, cm);
		// grid.addListener(Events.Attach, new
		// Listener<GridEvent<PaasOffering>>() {
		// public void handleEvent(GridEvent<PaasOffering> be) {
		// loader.load(0, 10);
		// }
		// });

		grid.addListener(Events.RowClick,
				new Listener<GridEvent<PaasOffering>>() {

					@Override
					public void handleEvent(GridEvent<PaasOffering> be) {
						String offering = be.getGrid().getSelectionModel()
								.getSelectedItem().get("name");
						be.getGrid().getView().refresh(false);
						Info.display("Selected PaaS Offering", offering);
					}

				});

		grid.setLoadMask(true);
		grid.setBorders(true);
		grid.setAutoExpandColumn("name");


		ContentPanel cp = new ContentPanel();
		cp.setHeaderVisible(false);
		cp.setTopComponent(toolBar);
		cp.add(grid);
		setLayout(new FitLayout());
		add(cp);
		final int height = 300;
		setHeight(height);
		
		//Setting correct Height
		grid.addListener(Events.Render, new Listener<ComponentEvent>(){
			@Override
			public void handleEvent(ComponentEvent be) {
				System.out.println ("Setting grid height");
				grid.setHeight(height-toolBar.getHeight());
				layout();
			}});
	}

	public void changeDataProvider() {
		offeringsStore = new PaasOfferingStore();
		PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(
				offeringsStore.getPaasOffering2());

		// loader
		final PagingLoader loader = new BasePagingLoader(proxy);
		loader.setRemoteSort(true);

		ListStore<PaasOffering> store = new ListStore<PaasOffering>(loader);
		toolBar.bind(loader);
		loader.load(0, 10);

		grid.reconfigure(store, cm);

	}
}
