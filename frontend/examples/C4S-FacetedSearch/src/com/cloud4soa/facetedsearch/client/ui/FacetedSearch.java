package com.cloud4soa.facetedsearch.client.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.cloud4soa.facetedsearch.client.FacetedSearchDataService;
import com.cloud4soa.facetedsearch.client.FacetedSearchDataServiceAsync;
import com.cloud4soa.facetedsearch.shared.Provider;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

/**
 * @author Xavi Sarda - ATOS
 *
 */
public class FacetedSearch extends Composite {
	
	private static final String PROVIDERS = "prov";
	private static final String TECHNOLOGIES = "tech";
	private static final String RATINGS = "rating";
	private static final String TOOLS = "tool";
	private static final String CHANNELS = "chnel";
	private static final String RESOURCES = "res";
	private static final String FEATURES = "feat";
	private static final String PAYMENT_METHODS = "pay";

	private String[] filters = {"PaaS provider", "Prog. Language", "Rating", "Tools", "Pricing policy", "Resources", "Channel", "Features"};
	private String[] filtersid = {PROVIDERS, TECHNOLOGIES, RATINGS, TOOLS, PAYMENT_METHODS, RESOURCES, CHANNELS, FEATURES};
	private Map<String, CheckBox> checkboxes = new HashMap<String, CheckBox>();
	private String[] defaultvisible = {PROVIDERS, TECHNOLOGIES, RATINGS, PAYMENT_METHODS};
	
	private static FacetedSearchUiBinder uiBinder = GWT.create(FacetedSearchUiBinder.class);
	private final FacetedSearchDataServiceAsync dataService = GWT.create(FacetedSearchDataService.class);
	private ListDataProvider<Provider> dataProvider = new ListDataProvider<Provider>();
	private ArrayList<Provider> providers = new ArrayList<Provider>();
	
	interface FacetedSearchUiBinder extends UiBinder<Widget, FacetedSearch> {}
	
	@UiField
	ListBox provlist;
	@UiField
	FlowPanel provcont;
	@UiField
	ListBox techlist;
	@UiField
	FlowPanel techcont;
	@UiField
	ListBox ratinglist;
	@UiField
	FlowPanel ratingcont;
	@UiField
	ListBox toollist;
	@UiField
	FlowPanel toolcont;
	@UiField
	ListBox chnellist;
	@UiField
	FlowPanel chnelcont;
	@UiField
	ListBox reslist;
	@UiField
	FlowPanel rescont;
	@UiField
	ListBox paylist;
	@UiField
	FlowPanel paycont;
	@UiField
	ListBox featlist;
	@UiField
	FlowPanel featcont;
	@UiField
	CellTable<Provider> provtable;
	@UiField
	FlowPanel favailable;
	@UiField
	FlowPanel searchtab;
	
	/**
	 * Default constructor
	 */
	public FacetedSearch() {
		initWidget(uiBinder.createAndBindUi(this));
		
		// Generating the list of available filters
		
		// Add a checkbox for available filter
	    for (int i = 0; i < this.filters.length; i++) {
	      CheckBox checkBox = new CheckBox(this.filters[i]);
	      this.checkboxes.put(this.filtersid[i], checkBox);
	      checkBox.setStyleName("filtertoggle");
	      checkBox.addValueChangeHandler(new VisbilityCheckboxesHandler(this.filtersid[i]));
	      favailable.add(checkBox);
	    }
		
	    //Turning visible these pre-defined fields
		for(int i = 0; i<this.defaultvisible.length; i++){
			this.turnVisible(this.defaultvisible[i]);
		}
		
		//Adding handlers
		RefreshSearchHandler handler = new RefreshSearchHandler();
		provlist.addChangeHandler(handler);
		techlist.addChangeHandler(handler);
		ratinglist.addChangeHandler(handler);
		toollist.addChangeHandler(handler);
		chnellist.addChangeHandler(handler);
		reslist.addChangeHandler(handler);
		featlist.addChangeHandler(handler);
		paylist.addChangeHandler(handler);
		
		//Initial providers information
		providers.add(new Provider("AWS", "AWS", "AWS"));
		providers.add(new Provider("sss", "sss", "sss"));
		providers.add(new Provider("aaa", "aaa", "aaa"));
		providers.add(new Provider("aaa", "aaa", "aaa"));
		providers.add(new Provider("zzz", "zzz", "zzz"));
		
		//Column information definition
		TextColumn<Provider> col1 = new TextColumn<Provider>() {
			@Override
			public String getValue(Provider object) {
				return object.getOffer();
			}
		};
		
		TextColumn<Provider> col2 = new TextColumn<Provider>() {
			@Override
			public String getValue(Provider object) {
				return object.getProvider();
			}
		};
		
		TextColumn<Provider> col3 = new TextColumn<Provider>() {
			@Override
			public String getValue(Provider object) {
				return object.getDescription();
			}
		};
		
		provtable.addColumn(col1, "Offer");
		provtable.addColumn(col2, "Provider");
		provtable.addColumn(col3, "Description");
		
		//Linking data to actual display
		dataProvider.addDataDisplay(provtable);
		dataProvider.setList(providers);
		
		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		SimplePager pager = new SimplePager(SimplePager.TextLocation.CENTER, pagerResources, true, 0 ,true);
		pager.setDisplay(provtable);
		pager.setPageSize(5);
		searchtab.add(pager);
	}
	
	/**
	 * This metyhod retrieves all data from filters
	 * @return Map containing filter values
	 */
	public Map<String,ArrayList<String>> getAllCurrentFilters(){
		HashMap<String, ArrayList<String>> cf = new HashMap<String, ArrayList<String>>();
		
		ArrayList<String> prov = this.getCurrentFilters(provlist);
		ArrayList<String> tech = this.getCurrentFilters(techlist);
		ArrayList<String> rating = this.getCurrentFilters(ratinglist);
		ArrayList<String> tool = this.getCurrentFilters(toollist);
		ArrayList<String> chnel = this.getCurrentFilters(chnellist);
		ArrayList<String> res = this.getCurrentFilters(reslist);
		ArrayList<String> feat = this.getCurrentFilters(featlist);
		ArrayList<String> pay = this.getCurrentFilters(paylist);

		cf.put(PROVIDERS, prov);
		cf.put(TECHNOLOGIES, tech);
		cf.put(RATINGS, rating);
		cf.put(TOOLS, tool);
		cf.put(CHANNELS, chnel);
		cf.put(RESOURCES, res);
		cf.put(FEATURES, feat);
		cf.put(PAYMENT_METHODS, pay);
		
		return cf;
	}
	
	/**
	 * Helper method that retrieves data from one filter
	 * @param lbox
	 * @return ArrayList containing all filters
	 */
	private ArrayList<String> getCurrentFilters(ListBox lbox){
		ArrayList<String> flist = new ArrayList<String>();
		for(int i = 0; i < lbox.getItemCount(); i++){
			if(lbox.isItemSelected(i)){
				flist.add(lbox.getItemText(i));
			}
		}
		return flist;
	}
	
	/**
	 * Helper method to display information retrieved from filters
	 * @param map
	 * @return String
	 */
	public String turnMapIntoLabels(Map<String,ArrayList<String>> map){
		String ret = "";
		Set<String> keys = map.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()){
			String k = it.next();
			ret+=k+"\n";
			ArrayList<String> slist= map.get(k);
			if(slist != null){
				for(int i = 0; i<slist.size(); i++){
					ret+=slist.get(i)+",";
				}
				ret+="\n";
			}
		}
		return ret;
	}
	
	/**
	 * Method to turn visible one filter
	 * @param String indicating which filter must be shown
	 */
	private void turnVisible(String kind){
		if(kind.equals(PROVIDERS)){
			dataService.getProvider(null, new InitialAsyncCallback(provlist));
			turnVisibleHelper(kind, provcont);
		}else if(kind.equals(TECHNOLOGIES)){
			dataService.getTechnology(null, new InitialAsyncCallback(techlist));
			turnVisibleHelper(kind, techcont);
		}else if(kind.equals(RATINGS)){
			dataService.getRating(null, new InitialAsyncCallback(ratinglist));
			turnVisibleHelper(kind, ratingcont);
		}else if(kind.equals(TOOLS)){
			dataService.getTool(null, new InitialAsyncCallback(toollist));
			turnVisibleHelper(kind, toolcont);
		}else if(kind.equals(CHANNELS)){
			dataService.getChannel(null, new InitialAsyncCallback(chnellist));
			turnVisibleHelper(kind, chnelcont);
		}else if(kind.equals(RESOURCES)){
			dataService.getResource(null, new InitialAsyncCallback(reslist));
			turnVisibleHelper(kind, rescont);
		}else if(kind.equals(FEATURES)){
			dataService.getFeature(null, new InitialAsyncCallback(featlist));
			turnVisibleHelper(kind, featcont);
		}else if(kind.equals(PAYMENT_METHODS)){
			dataService.getPricingPolicy(null, new InitialAsyncCallback(paylist));
			turnVisibleHelper(kind, paycont);
		}
	}
	
	/**
	 * Helper method for turning filters visible
	 * @param kind
	 * @param fpanel
	 */
	private void turnVisibleHelper(String kind, FlowPanel fpanel){
		CheckBox cbox = this.checkboxes.get(kind);
		fpanel.setVisible(true);
		cbox.setValue(true);
	}
	
	/**
	 * Method to turn invisible one filter
	 * @param String indicating which filter must be hidden
	 */
	private void turnNoVisible(String kind){
		if(kind.equals(PROVIDERS)){
			turnNoVisibleHelper(kind, provcont, provlist);
		}else if(kind.equals(TECHNOLOGIES)){
			turnNoVisibleHelper(kind, techcont, techlist);
		}else if(kind.equals(RATINGS)){
			turnNoVisibleHelper(kind, ratingcont, ratinglist);
		}else if(kind.equals(TOOLS)){
			turnNoVisibleHelper(kind, toolcont, toollist);
		}else if(kind.equals(CHANNELS)){
			turnNoVisibleHelper(kind, chnelcont, chnellist);
		}else if(kind.equals(RESOURCES)){
			turnNoVisibleHelper(kind, rescont, reslist);
		}else if(kind.equals(FEATURES)){
			turnNoVisibleHelper(kind, featcont, featlist);
		}else if(kind.equals(PAYMENT_METHODS)){
			turnNoVisibleHelper(kind, paycont, paylist);
		}
	}
	
	/**
	 * Helper method for turning filters invisible
	 * @param kind
	 * @param fpanel
	 */
	private void turnNoVisibleHelper(String kind, FlowPanel fpanel, ListBox lbox){
		fpanel.setVisible(false);
		//Clear Selection
		for(int i = 0; i < lbox.getItemCount(); i++){
			lbox.setItemSelected(i, false);
		}
	}
	
	private class InitialAsyncCallback implements AsyncCallback<String[]>{
		private ListBox lbox;
		
		public InitialAsyncCallback(ListBox listbox){
			this.lbox = listbox;
		}
		
		@Override
		public void onFailure(Throwable caught) {
			// TODO Show error message
		}

		@Override
		public void onSuccess(String[] result) {
			for(String r : result){
				this.lbox.addItem(r);
			}
		}
	}
	
	private class RefreshSearchHandler implements ChangeHandler{
		@Override
		public void onChange(ChangeEvent event) {
			dataService.getProviders(getAllCurrentFilters(), new AsyncCallback<Provider[]>() {
				@Override
				public void onFailure(Throwable caught) {
					// TODO Show error message
				}
				@Override
				public void onSuccess(Provider[] result) {
					ArrayList<Provider> newprov = new ArrayList<Provider>();
					for(Provider p : result){
						newprov.add(p);
					}
					providers = newprov;
					dataProvider.setList(providers);
				}
			});
		}
	}
	
	private class VisbilityCheckboxesHandler implements ValueChangeHandler<Boolean>{
		private String kind;

		public VisbilityCheckboxesHandler(String kind){
			this.kind = kind;
		}
		@Override
		public void onValueChange(ValueChangeEvent<Boolean> event) {
			if(event.getValue()){
				turnVisible(this.kind);
			}else{
				turnNoVisible(this.kind);
			}
		}
	}
}