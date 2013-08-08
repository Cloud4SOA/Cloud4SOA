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
import java.util.Arrays;  
import java.util.List;
  
/*
import com.extjs.gxt.samples.resources.client.Resources;  
import com.extjs.gxt.samples.resources.client.TestData;  
import com.extjs.gxt.samples.resources.client.model.Folder;
*/  
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;  
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.ModelData;  
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;  
import com.extjs.gxt.ui.client.event.FieldEvent;  
import com.extjs.gxt.ui.client.event.Listener;  
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.TreeStore;  
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.CardPanel;
import com.extjs.gxt.ui.client.widget.ContentPanel;  
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.LayoutContainer;  
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;  
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;  
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;  
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;  
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;  
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;  
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.toolbar.LabelToolItem;  
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;  
import com.extjs.gxt.ui.client.widget.treegrid.CellTreeGridSelectionModel;  
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;  
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridCellRenderer;  
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridSelectionModel;  
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;

import com.google.gwt.user.client.ui.AbstractImagePrototype;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.resources.Icons;
import eu.cloud4soa.frontend.widget.search.client.data.Folder;
import eu.cloud4soa.frontend.widget.search.client.data.Offering;
import eu.cloud4soa.frontend.widget.search.client.data.OfferingDetails;
import eu.cloud4soa.frontend.widget.search.client.data.OfferingStore;
import eu.cloud4soa.frontend.widget.search.client.views.PaaSOfferingDetailsView;
 
//TODO Replace with read-only version of PaaS Offering Editor (Use OfferEditorViewGxtImpl extends Composite implements OfferEditorView)
public class PaaSOfferingDetailsTreeGridGXTView extends LayoutContainer {
	
	private SearchResultGXTViewImpl searchResultGXTViewImpl;
	private OfferingStore offeringsStore = new OfferingStore();
	private TreeStore<Offering> store;
	private PagingToolBar toolBar;
	private TreeGrid<ModelData> tree = null;
	private ColumnModel cm = null;
	private int height = 300;
	private CardPanel cp;
	private LayoutContainer noDetailsPanel;
	private LayoutContainer treePanel;
		
	public PaaSOfferingDetailsTreeGridGXTView(SearchResultGXTViewImpl searchResultGXTViewImpl) {
		this.searchResultGXTViewImpl = searchResultGXTViewImpl;
		
		createView();
	}
	
	void createView () {
		cp = new CardPanel();
		cp.setHeight(height);
		
		// Creating views for card panel
		// View one for tree
		// View two for empty results
	
		createTreeView();
		createNoDetailsPanel();	
		
		cp.setActiveItem(noDetailsPanel);
		add (cp);
	}
	
	private void createNoDetailsPanel() {
		noDetailsPanel = new LayoutContainer();
		noDetailsPanel.setLayout(new VBoxLayout(VBoxLayoutAlign.CENTER));
		noDetailsPanel.add(new Label ("Please, select a PaaS Offering to see its details"), new RowData (1, 1, new Margins (0)));
		
		
		//Back button
		Button back = new Button ();
		back.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.back()));
		back.setWidth (30);
		back.addListener(Events.Select, new Listener<ButtonEvent>(){
			@Override
			public void handleEvent(ButtonEvent be) {
				searchResultGXTViewImpl.showPaaSOfferingResultsView();
			}
			
		});
		
		noDetailsPanel.add(back, new VBoxLayoutData (new Margins(2)));
		cp.add(noDetailsPanel);
	}
	
	private void createTreeView() {
		final int buttonHeight = 30;
		final int buttonWidht = 40;
		Folder model = offeringsStore.getTreeOfferings();  
	    if (model == null) {
	    	model = offeringsStore.getTestTreeModel();
	    }
	    TreeStore<ModelData> store = new TreeStore<ModelData>();  
	    store.add(model.getChildren(), true);
	  	  
	    treePanel = new LayoutContainer();
//		treePanel.setLayout(new VBoxLayout(VBoxLayoutAlign.STRETCH));
		treePanel.setLayout(new RowLayout(Orientation.VERTICAL));
	  
	    tree = getTree(store);
	    tree.setBorders(true);
	    //tree.getStyle().setLeafIcon(Resources.ICONS.music());  
	    tree.setAutoExpandColumn("value"); 
	    tree.getView().setForceFit(true);
	    tree.setTrackMouseOver(false);  
	    tree.expandAll();
	    
	    setHeight(height);
		treePanel.add(tree, new RowData (1.0, 0.9, new Margins (2)));
		
		//Back button
		final Button back = new Button ();
		back.setIcon(AbstractImagePrototype.create(Icons.RESOURCES.back()));
		back.setWidth (buttonHeight);
		back.addListener(Events.Select, new Listener<ButtonEvent>(){
			@Override
			public void handleEvent(ButtonEvent be) {
				searchResultGXTViewImpl.showPaaSOfferingResultsView();
			}
			
		});
		LayoutContainer buttonPanel = new LayoutContainer();
		buttonPanel.setLayout(new VBoxLayout(VBoxLayoutAlign.CENTER));
		buttonPanel.add(back);
		treePanel.add (buttonPanel, new RowData (1.0, 0.1, new Margins (2)));
		
		cp.add(treePanel);
		
		//Setting correct Height
		tree.addListener(Events.Render, new Listener<ComponentEvent>(){
			@Override
			public void handleEvent(ComponentEvent be) {
				System.out.println ("Setting grid height");
				tree.setHeight(height - buttonHeight);
//				back.setWidth(buttonWidht);
				layout();
		}});
	}
	
	private ColumnModel getColumnModel() {
		if (cm == null) {
			ColumnConfig name = new ColumnConfig("name", "Name", 200);  
		    name.setRenderer(new TreeGridCellRenderer<ModelData>());
		    ColumnConfig value = new ColumnConfig("value", "Value", 200);
		    /*
		    ColumnConfig provider = new ColumnConfig("provider", "PaaS Provider", 100);  
		    ColumnConfig language = new ColumnConfig("programmingLanguage", "Programming Language", 100);
		    ColumnConfig hardware = new ColumnConfig("hardwareName", "Hardware", 100);
		    */
		    cm = new ColumnModel(Arrays.asList(name, value));
		}
		return cm;
	}
	
	private TreeGrid<ModelData> getTree(TreeStore<ModelData> store) {
		if (tree == null) {
			tree = new TreeGrid<ModelData>(store, getColumnModel());
		}
		return tree;
	}

	public void showPaaSOfferingDetails(PaaSOfferingModel paaSoffering) {
		GWT.log("Requested to show details for " + paaSoffering);
		if (paaSoffering == null){
			cp.setActiveItem(noDetailsPanel);
		}else{
		
			Folder model = offeringsStore.getTreeModel(paaSoffering);
			  
		    TreeStore<ModelData> store = new TreeStore<ModelData>();  
		    store.add(model.getChildren(), true);
		    tree = getTree(store);
		    tree.reconfigure(store, getColumnModel());
		    tree.expandAll();
			
			cp.setActiveItem(treePanel);
			cp.layout();
		}
	}
}