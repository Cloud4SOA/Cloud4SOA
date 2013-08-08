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

package eu.cloud4soa.frontend.widget.slamanagement.client.views;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.governance.SLAApplication;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.governance.SLAProvider;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.governance.SLAStore;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAViolationModel;
import eu.cloud4soa.frontend.widget.slamanagement.client.activities.SLAViolationsActivity;

public class SLAViolationsGXTViewImpl extends LayoutContainer implements SLAViolationsView{
	
//	private Button btApplyRA;
//	private Button btHideShowCloseEvents;
	private Grid<SLAViolationModel> grid;
//	private boolean showClosedEvents = true;
	private ColumnModel cm;
	private SLAStore slaStore;
//	private boolean showedClosedEvents = true;
	private PagingToolBar bottomBar;
	ComboBox<SLAApplication> comboApplications;
	ComboBox<SLAProvider> comboProviders;
	
	private Presenter presenter;
	
	public SLAViolationsGXTViewImpl (){
		initializeWidget();
	}
	
	public SLAViolationsGXTViewImpl (SLAViolationsActivity presenter){
		this.presenter = presenter;
		initializeWidget();
	}
	
	private void initializeWidget() {
		if (this.slaStore != null)
			createView();
	}

	void createView() {
		removeAll();
		setLayout(new FitLayout());

		// Panel
		ContentPanel cp = new ContentPanel();
		cp.setHeading("SLA Violations");
		cp.setHeaderVisible(true);
		cp.setBorders(true);
		cp.setLayout(new FitLayout());
				
//		ToolBar toolBar = createToolbar();
//		cp.setTopComponent(toolBar);
		
		ContentPanel cp1 = new ContentPanel();
		cp1.setHeaderVisible(false);
		cp1.setLayout(new FitLayout());
		
		cp1.setTopComponent(createTopShortForm(cp));
		cp1.add(createGrid());
		
		cp.add (cp1);
		cp.setBottomComponent(bottomBar);
		
		add (cp);
		
		layout();
	}

	private LayoutContainer createTopLargeForm(ContentPanel cp) {
		ListStore<SLAApplication> applicationsStore = new ListStore<SLAApplication>();  
	    applicationsStore.add(slaStore.getApplications());  
	    
	    ListStore<SLAProvider> providersStore = new ListStore<SLAProvider>();  
	    providersStore.add(slaStore.getProviders()); 
		
		LayoutContainer form = new LayoutContainer();  
		form.setLayout(new ColumnLayout());
	    
	    LayoutContainer left = new LayoutContainer();  
	    left.setStyleAttribute("paddingRight", "10px");  
	    FormLayout layout = new FormLayout();
	    left.setLayout(layout); 
	    
	    SelectionChangedListener scListener = new SelectionChangedListener<SLAApplication>() {

			@Override
			public void selectionChanged(
					SelectionChangedEvent<SLAApplication> se) {
				String app = getSelectedApplication();
				String prov = getSelectedProvider();
				Info.display("Selected Application and Provider", app + ", " + prov);
				if (se.getSelectedItem() != null){
					filterByApplicationAndProvider(app, prov);
				}else{
					resetGrid();
				}
			}

			
		};
	    
		comboApplications = new ComboBox<SLAApplication>();
		comboApplications.setFieldLabel("Application");
		comboApplications.setAllowBlank(true);
		comboApplications.setForceSelection(true);
		comboApplications.setTriggerAction(TriggerAction.ALL);
		comboApplications.setStore(applicationsStore);
		comboApplications.setDisplayField("application");
		
		comboApplications.addSelectionChangedListener(scListener);
	    
	    left.add(comboApplications);
	    
	    LayoutContainer right = new LayoutContainer();  
	    right.setStyleAttribute("paddingLeft", "10px");  
	    layout = new FormLayout();   
	    right.setLayout(layout);
	    
	    comboProviders = new ComboBox<SLAProvider>();
	    comboProviders.setFieldLabel("Providers");
	    comboProviders.setAllowBlank(true);
	    comboProviders.setForceSelection(true);
	    comboProviders.setTriggerAction(TriggerAction.ALL);
	    comboProviders.setStore(providersStore);
	    comboProviders.setDisplayField("provider");
	    
	    comboProviders.addSelectionChangedListener(scListener);
	    
	    right.add(comboProviders);
	    
	    form.add(left, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));  
	    form.add(right, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.45));
	    return form;
	}
	
	private LayoutContainer createTopShortForm(ContentPanel cp) {
		ListStore<SLAApplication> applicationsStore = new ListStore<SLAApplication>();  
	    applicationsStore.add(slaStore.getApplications());  
	    
	    ListStore<SLAProvider> providersStore = new ListStore<SLAProvider>();  
	    providersStore.add(slaStore.getProviders()); 
		
		LayoutContainer form = new LayoutContainer();  
		VBoxLayout layout = new VBoxLayout();  
	    layout.setPadding(new Padding(5));  
	    layout.setVBoxLayoutAlign(VBoxLayoutAlign.LEFT);  
	    form.setLayout(layout);
	    form.setHeight(70);
	    form.addStyleName("c4s-white-bg");
	    
	    SelectionChangedListener scListener = new SelectionChangedListener<SLAApplication>() {

			@Override
			public void selectionChanged(
					SelectionChangedEvent<SLAApplication> se) {
				String app = getSelectedApplication();
				String prov = getSelectedProvider();
				Info.display("Selected Application and Provider", app + ", " + prov);
				if (se.getSelectedItem() != null){
					filterByApplicationAndProvider(app, prov);
				}else{
					resetGrid();
				}
			}

			
		};
	    
		LayoutContainer top = new LayoutContainer();  
		top.setStyleAttribute("paddingRight", "10px");  
	    FormLayout layout1 = new FormLayout();
	    top.setLayout(layout1); 
		
		comboApplications = new ComboBox<SLAApplication>();
		comboApplications.setFieldLabel("Application");
		comboApplications.setAllowBlank(true);
		comboApplications.setForceSelection(true);
		comboApplications.setTriggerAction(TriggerAction.ALL);
		comboApplications.setStore(applicationsStore);
		comboApplications.setDisplayField("application");
		
		comboApplications.addSelectionChangedListener(scListener);
	    
	    top.add(comboApplications);
	    
	    LayoutContainer bottom = new LayoutContainer();  
	    bottom.setStyleAttribute("paddingRight", "10px");  
	    FormLayout layout2 = new FormLayout();
	    bottom.setLayout(layout2);
	    
	    comboProviders = new ComboBox<SLAProvider>();
	    comboProviders.setFieldLabel("Providers");
	    comboProviders.setAllowBlank(true);
	    comboProviders.setForceSelection(true);
	    comboProviders.setTriggerAction(TriggerAction.ALL);
	    comboProviders.setStore(providersStore);
	    comboProviders.setDisplayField("provider");
	    
	    comboProviders.addSelectionChangedListener(scListener);
	    
	    bottom.add(comboProviders);
	    
	    form.add (top);
	    form.add(bottom);
	    
	    return form;
	}

	private Grid createGrid() {
		// Store
		//slaStore = new SLAStore();
		
		// loader
		PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(slaStore.getSLAViolations());
		
		final PagingLoader loader = new BasePagingLoader(proxy);
		loader.setRemoteSort(true);

		final ListStore<SLAViolationModel> store = new ListStore<SLAViolationModel>(loader);

		bottomBar = new PagingToolBar(10);
		bottomBar.bind(loader);
		loader.load(0, 10);

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

		ColumnConfig column = new ColumnConfig();
//		column.setId(SLAViolationModel.EVENT_ID);
//		column.setHeader("Event ID");
//		column.setWidth(50);
//		configs.add(column);
		
		column = new ColumnConfig();
		column.setId(SLAViolationModel.APPLICATION);
		column.setHeader("Application");
		column.setWidth(100);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId(SLAViolationModel.PROVIDER);
		column.setHeader("Provider");
		column.setWidth(100);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId(SLAViolationModel.METRIC);
		column.setHeader("Metric");
		column.setWidth(50);
		configs.add(column);

		column = new ColumnConfig();
		column.setId(SLAViolationModel.EXPECTED_VALUE);
		column.setHeader("Expected Value");
		column.setWidth(90);
		column.setRenderer(new GridCellRenderer<SLAViolationModel>(){
			@Override
			public Object render(SLAViolationModel model, String property,
				ColumnData config, int rowIndex, int colIndex,
				ListStore<SLAViolationModel> store, Grid<SLAViolationModel> grid) {
	            return "<span style='color:green'>" + model.get(property) + "</span>";
			}
		});
		configs.add(column);

		column = new ColumnConfig();
		column.setId(SLAViolationModel.ACTUAL_VALUE);
		column.setHeader("Actual Value");
		column.setWidth(90);
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setRenderer(new GridCellRenderer<SLAViolationModel>(){
			@Override
			public Object render(SLAViolationModel model, String property,
				ColumnData config, int rowIndex, int colIndex,
				ListStore<SLAViolationModel> store, Grid<SLAViolationModel> grid) {
	            return "<span style='color:red'>" + model.get(property) + "</span>";
			}
		});
		configs.add(column);
		
//		column = new ColumnConfig();
//		column.setId(SLAViolationModel.STATUS);
//		column.setHeader("Status");
//		column.setWidth(70);
//		column.setRenderer(new GridCellRenderer<SLAViolationModel>(){
//
//			@Override
//			public Object render(SLAViolationModel model, String property,
//				ColumnData config, int rowIndex, int colIndex,
//				ListStore<SLAViolationModel> store, Grid<SLAViolationModel> grid) {
//				String color = "green";
//				if (model.get(property).equals("Closed")){
//					color = "green";
//				}else if (model.get(property).equals("Open")){
//					color = "red";
//				}
//	            return "<span style='color:" + color + "'>"
//	                            + model.get(property) + "</span>";
//			}
//		});
//		configs.add(column);

		
		column = new ColumnConfig();
		column.setId(SLAViolationModel.DATE);
		column.setHeader("Date");
		column.setWidth(150);
		configs.add(column);
		
//		column = new ColumnConfig();
//		column.setId(SLAViolationModel.RECOVERY_ACTION);
//		column.setHeader("Recovery Action");
//		column.setWidth(200);
//		column.setRenderer(new GridCellRenderer<SLAViolationModel>(){
//		    
//			@Override
//			public Object render(SLAViolationModel model, String property,
//				ColumnData config, int rowIndex, int colIndex,
//				ListStore<SLAViolationModel> store, Grid<SLAViolationModel> grid) {
//				if (model.get ("status").equals("Open")){
//					ListStore<ModelData> listStore = new ListStore<ModelData>();
//					ModelData data = createData((String)model.get(property));
//					listStore.add(data);
//					ComboBox<ModelData> combo = new ComboBox<ModelData>();
//					combo.setStore(listStore);
//				    combo.setDisplayField("value");
//				    combo.setValue(data);
//					
//					if (model.get("status").equals("Closed")){
//						combo.setEditable (false);
//					}
//		            return combo;
//				}else{
//					return "<span>"+ model.get(property) + "</span>";
//				}
//			}
//			
//			private ModelData createData(String str) {
//		        BaseModelData data = new BaseModelData();
//		        data.set("value", str);
//		        return data;
//		      }
//		});
//		configs.add(column);
		
		cm = new ColumnModel(configs);

		grid = new Grid<SLAViolationModel>(store, cm);
		grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		grid.setStyleAttribute("borderTop", "none");
		grid.setBorders(true);

		// Getting selectionInfo.display("Selected SLA violation on metric", (String) be
		grid.getSelectionModel().addListener(Events.SelectionChange,
				new Listener<SelectionChangedEvent<SLAViolationModel>>() {

					@Override
					public void handleEvent(
							SelectionChangedEvent<SLAViolationModel> be) {
						if (be.getSelectedItem()==null){
							return;
						}
						Info.display("Selected SLA violation on metric", (String) be
								.getSelectedItem().get("metric"));
					}

				});
//		grid.setAutoHeight(true);
//		grid.setDeferHeight(true);
		
		return grid;
	}

//	private ToolBar createToolbar() {
//		// Toolbar
//		final ToolBar toolBar = new ToolBar();
//		toolBar.addStyleName("c4s-white-bg");
//
//		btApplyRA = new Button("Apply Recovery Action",
//		IconHelper.createStyle("add16"));
//		btApplyRA.setToolTip("Apply Recovery Action on a selected event");
//		toolBar.add(btApplyRA);
//
//		SelectionListener<ButtonEvent> sl = new SelectionListener<ButtonEvent>() {
//
//			@Override
//			public void componentSelected(ButtonEvent ce) {
//				String commandName = ce.getButton().getText();
//				SLAViolationModel slaViolation = grid.getSelectionModel().getSelectedItem();
//				String app = getSelectedApplication();
//				String prov = getSelectedProvider();
//				if (ce.getButton().equals(btHideShowCloseEvents)){
//					if (showClosedEvents){
//						btHideShowCloseEvents.setText("Show closed events");
//						showClosedEvents = false;
//						hideClosedEvents(app, prov);
//					}else{
//						btHideShowCloseEvents.setText("Hide closed events");
//						showClosedEvents = true;
//						showClosedEvents(app, prov);
//					}
//				}
//				if (ce.getButton().equals(btApplyRA)){
//					if (grid.getSelectionModel().getSelectedItem() == null){
//						Info.display("Error", "Please, select an event before performing this action");
//					}else{
//						Info.display("Requested to apply recovery action", 
//								"Recovery Action: " + slaViolation.get("recoveryAction") + " on event: " + slaViolation.get("eventId"));
//					}
//				}
//			}
//		};
//		
//		btApplyRA.addListener(Events.Select, sl);
//
//		btHideShowCloseEvents = new Button("Hide closed events",
//		IconHelper.createStyle("add16"));
//		btHideShowCloseEvents.setToolTip("Hide/Show closed events");
//		toolBar.add(btHideShowCloseEvents);
//
//		btHideShowCloseEvents.addListener(Events.Select, sl);
//		return toolBar;
//	}
	
//	private void showClosedEvents(String application, String provider) {
//		showedClosedEvents = true;
//		renderGrid (slaStore.filterByApplicationAndProvider(application, provider, showedClosedEvents));
//	}
//
//	private void hideClosedEvents(String application, String provider) {
//		showedClosedEvents = false;
//		renderGrid (slaStore.filterByApplicationAndProvider(application, provider, showedClosedEvents));
//	}
	
	private void renderGrid(List<SLAViolationModel> list){
		PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list);
		
		final PagingLoader loader = new BasePagingLoader(proxy);
		loader.setRemoteSort(true);

		final ListStore<SLAViolationModel> store = new ListStore<SLAViolationModel>(loader);
		store.add(list);
		
		bottomBar.bind(loader);
		loader.load(0, 10);
		
		grid.reconfigure(store, cm);
	}
	
	
	protected void filterByApplicationAndProvider(String application, String provider) {
		renderGrid (slaStore.filterByApplicationAndProvider(application, provider));
	}

	protected void resetGrid() {
//		if (showedClosedEvents ){
			renderGrid (slaStore.getSLAViolations());
//		}else{
//			renderGrid (slaStore.getOpenSLAViolations());
//		}
	}
	
	private String getSelectedApplication() {
		String app = "-";
		List<SLAApplication> apps = comboApplications.getSelection();
		if (apps.size() != 0){
			app = apps.get(0).getApplication(); //TODO: Support multiple selection
		}
		return app;
	}

	private String getSelectedProvider() {
		String prov = "-";
		List<SLAProvider> provs = comboProviders.getSelection();
		if (provs.size() != 0){
			prov = provs.get(0).getProvider(); //TODO: Support multiple selection
		}
		return prov;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setSLAViolationsData(SLAStore store) {
		this.slaStore = store;
		//Refresh data in view
		createView();
	}

	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.widget.slamanagement.client.views.SLAViolationsView#filterSLAViolationsByApplicationId(java.lang.String)
	 */
	@Override
	public void filterSLAViolationsByApplicationId(String applicationId) {
		renderGrid (slaStore.filterByApplicationId(applicationId));
	}

	
}
