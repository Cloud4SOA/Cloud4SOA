package eu.cloud4soa.frontend.widget.search.client.views;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.data.BasePagingLoader;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.PagingLoader;
import com.extjs.gxt.ui.client.data.PagingModelMemoryProxy;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionChangedListener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.layout.MarginData;
import com.extjs.gxt.ui.client.widget.toolbar.PagingToolBar;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Element;

import eu.cloud4soa.frontend.widget.search.client.data.PaasOffering;
import eu.cloud4soa.frontend.widget.search.client.data.PaasOfferingStore;
import eu.cloud4soa.frontend.widget.search.client.data.SLAApplication;
import eu.cloud4soa.frontend.widget.search.client.data.SLAProvider;
import eu.cloud4soa.frontend.widget.search.client.data.SLAStore;
import eu.cloud4soa.frontend.widget.search.client.data.SLAViolation;
import eu.cloud4soa.frontend.widget.search.client.resources.ResourceBundle;

public class SLAViolationsGXTViewImpl extends LayoutContainer {
	
	private final ResourceBundle rb = GWT.create(ResourceBundle.class);
	private Button btApplyRA;
	private Button btHideShowCloseEvents;
	private Grid<SLAViolation> grid;
	private boolean showClosedEvents = true;
	private ColumnModel cm;
	private SLAStore slaStore;
	private boolean showedClosedEvents = true;
	private PagingToolBar bottomBar;
	ComboBox<SLAApplication> comboApplications;
	ComboBox<SLAProvider> comboProviders;

	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);

		ContentPanel cp = new ContentPanel();
		cp.setHeaderVisible(false);
		add (cp);
		
		final ToolBar toolBar = createToolbar();
		cp.setTopComponent(toolBar);
		
		createGrid();
		LayoutContainer form = createTopForm(cp);
		form.setBorders(true);
		
		cp.add(form, new MarginData(0));
		cp.add(grid);
		
		cp.setBottomComponent(bottomBar);
			  
		setLayout(new FitLayout());
		final int height = 450;
		setHeight(height);
		
		
		//Setting correct Height
		grid.addListener(Events.Render, new Listener<ComponentEvent>(){
			@Override
			public void handleEvent(ComponentEvent be) {
				grid.setHeight(height - toolBar.getHeight());
				layout();
			}
		});
	}

	private LayoutContainer createTopForm(ContentPanel cp) {
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
	    
	    left.add(comboApplications, new MarginData (1));
	    
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
	    
	    right.add(comboProviders, new MarginData (1));
	    
	    form.add(left, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.495));  
	    form.add(right, new com.extjs.gxt.ui.client.widget.layout.ColumnData(.495));
	    return form;
	}

	private void createGrid() {
		
		// Store
		slaStore = new SLAStore();
		
		// loader
		PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(slaStore.getSLAViolations());
		
		final PagingLoader loader = new BasePagingLoader(proxy);
		loader.setRemoteSort(true);

		final ListStore<SLAViolation> store = new ListStore<SLAViolation>(loader);

		bottomBar = new PagingToolBar(10);
		bottomBar.bind(loader);
		loader.load(0, 10);

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

		ColumnConfig column = new ColumnConfig();
		column.setId("eventId");
		column.setHeader("Event ID");
		column.setWidth(100);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("metric");
		column.setHeader("Metric");
		column.setWidth(100);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("expectedValue");
		column.setHeader("Expected Value");
		column.setWidth(100);
		column.setRenderer(new GridCellRenderer<SLAViolation>(){
			@Override
			public Object render(SLAViolation model, String property,
				ColumnData config, int rowIndex, int colIndex,
				ListStore<SLAViolation> store, Grid<SLAViolation> grid) {
	            return "<span style='color:green'>" + model.get(property) + "</span>";
			}
		});
		configs.add(column);

		column = new ColumnConfig();
		column.setId("actualValue");
		column.setHeader("Actual Value");
		column.setWidth(150);
		column.setAlignment(HorizontalAlignment.CENTER);
		column.setRenderer(new GridCellRenderer<SLAViolation>(){
			@Override
			public Object render(SLAViolation model, String property,
				ColumnData config, int rowIndex, int colIndex,
				ListStore<SLAViolation> store, Grid<SLAViolation> grid) {
	            return "<span style='color:red'>" + model.get(property) + "</span>";
			}
		});
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("status");
		column.setHeader("Status");
		column.setWidth(70);
		column.setRenderer(new GridCellRenderer<SLAViolation>(){

			@Override
			public Object render(SLAViolation model, String property,
				ColumnData config, int rowIndex, int colIndex,
				ListStore<SLAViolation> store, Grid<SLAViolation> grid) {
				String color = "green";
				if (model.get(property).equals("Closed")){
					color = "green";
				}else if (model.get(property).equals("Open")){
					color = "red";
				}
	            return "<span style='color:" + color + "'>"
	                            + model.get(property) + "</span>";
			}
		});
		configs.add(column);

		column = new ColumnConfig();
		column.setId("application");
		column.setHeader("Application");
		column.setWidth(100);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("provider");
		column.setHeader("Provider");
		column.setWidth(100);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("date");
		column.setHeader("Date");
		column.setWidth(200);
		configs.add(column);
		
		column = new ColumnConfig();
		column.setId("recoveryAction");
		column.setHeader("Recovery Action");
		column.setWidth(200);
		column.setRenderer(new GridCellRenderer<SLAViolation>(){
		    
			@Override
			public Object render(SLAViolation model, String property,
				ColumnData config, int rowIndex, int colIndex,
				ListStore<SLAViolation> store, Grid<SLAViolation> grid) {
				if (model.get ("status").equals("Open")){
					ListStore<ModelData> listStore = new ListStore<ModelData>();
					ModelData data = createData((String)model.get(property));
					listStore.add(data);
					ComboBox<ModelData> combo = new ComboBox<ModelData>();
					combo.setStore(listStore);
				    combo.setDisplayField("value");
				    combo.setValue(data);
					
					if (model.get("status").equals("Closed")){
						combo.setEditable (false);
					}
		            return combo;
				}else{
					return "<span>"+ model.get(property) + "</span>";
				}
			}
			
			private ModelData createData(String str) {
		        BaseModelData data = new BaseModelData();
		        data.set("value", str);
		        return data;
		      }
		});
		configs.add(column);
		cm = new ColumnModel(configs);

		grid = new Grid<SLAViolation>(store, cm);
		grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		grid.setStyleAttribute("borderTop", "none");
		grid.setBorders(true);

		// Getting selectionInfo.display("Selected SLA violation on metric", (String) be
		grid.getSelectionModel().addListener(Events.SelectionChange,
				new Listener<SelectionChangedEvent<SLAViolation>>() {

					@Override
					public void handleEvent(
							SelectionChangedEvent<SLAViolation> be) {
						if (be.getSelectedItem()==null){
							return;
						}
						Info.display("Selected SLA violation on metric", (String) be
								.getSelectedItem().get("metric"));
					}

				});
		
		grid.setAutoHeight(true);
		grid.setDeferHeight(true);
	}

	private ToolBar createToolbar() {
		// Toolbar
		final ToolBar toolBar = new ToolBar();

		btApplyRA = new Button("Apply Recovery Action",
		IconHelper.createStyle("add16"));
		btApplyRA.setToolTip("Apply Recovery Action on a selected event");
		toolBar.add(btApplyRA);

		SelectionListener<ButtonEvent> sl = new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				String commandName = ce.getButton().getText();
				SLAViolation slaViolation = grid.getSelectionModel().getSelectedItem();
				String app = getSelectedApplication();
				String prov = getSelectedProvider();
				if (ce.getButton().equals(btHideShowCloseEvents)){
					if (showClosedEvents){
						btHideShowCloseEvents.setText("Show closed events");
						showClosedEvents = false;
						hideClosedEvents(app, prov);
					}else{
						btHideShowCloseEvents.setText("Hide closed events");
						showClosedEvents = true;
						showClosedEvents(app, prov);
					}
				}
				if (ce.getButton().equals(btApplyRA)){
					if (grid.getSelectionModel().getSelectedItem() == null){
						Info.display("Error", "Please, select an event before performing this action");
					}else{
						Info.display("Requested to apply recovery action", 
								"Recovery Action: " + slaViolation.get("recoveryAction") + " on event: " + slaViolation.get("eventId"));
					}
				}
			}
		};
		
		btApplyRA.addListener(Events.Select, sl);

		btHideShowCloseEvents = new Button("Hide closed events",
		IconHelper.createStyle("add16"));
		btHideShowCloseEvents.setToolTip("Hide/Show closed events");
		toolBar.add(btHideShowCloseEvents);

		btHideShowCloseEvents.addListener(Events.Select, sl);
		return toolBar;
	}
	
	private void showClosedEvents(String application, String provider) {
		showedClosedEvents = true;
		renderGrid (slaStore.filterByApplicationAndProvider(application, provider, showedClosedEvents));
	}

	private void hideClosedEvents(String application, String provider) {
		showedClosedEvents = false;
		renderGrid (slaStore.filterByApplicationAndProvider(application, provider, showedClosedEvents));
	}
	
	private void renderGrid(List<SLAViolation> list){
		PagingModelMemoryProxy proxy = new PagingModelMemoryProxy(list);
		
		final PagingLoader loader = new BasePagingLoader(proxy);
		loader.setRemoteSort(true);

		final ListStore<SLAViolation> store = new ListStore<SLAViolation>(loader);
		store.add(list);
		
		bottomBar.bind(loader);
		loader.load(0, 10);
		
		grid.reconfigure(store, cm);
	}
	
	
	protected void filterByApplicationAndProvider(String application, String provider) {
		renderGrid (slaStore.filterByApplicationAndProvider(application, provider, showedClosedEvents));
	}

	protected void resetGrid() {
		if (showedClosedEvents ){
			renderGrid (slaStore.getSLAViolations());
		}else{
			renderGrid (slaStore.getOpenSLAViolations());
		}
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

	
}
