package com.cloud4soa.facetedsearch.client;

import java.util.ArrayList;
import java.util.Map;

import com.cloud4soa.facetedsearch.shared.Provider;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface FacetedSearchDataServiceAsync {
	
	void getTechnology(int[] index,AsyncCallback<String[]> callback);
	void getChannel(int[] index, AsyncCallback<String[]> callback);
	void getFeature(int[] index, AsyncCallback<String[]> callback);
	void getPricingPolicy(int[] index, AsyncCallback<String[]> callback);
	void getProvider(int[] index, AsyncCallback<String[]> callback);
	void getRating(int[] index, AsyncCallback<String[]> callback);
	void getResource(int[] index, AsyncCallback<String[]> callback);
	void getTool(int[] index, AsyncCallback<String[]> callback);
	void getProviders(Map<String, ArrayList<String>> index, AsyncCallback<Provider[]> callback);
	
}
