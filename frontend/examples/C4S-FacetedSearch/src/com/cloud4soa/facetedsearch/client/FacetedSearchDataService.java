package com.cloud4soa.facetedsearch.client;

import java.util.Map;
import java.util.ArrayList;
import com.cloud4soa.facetedsearch.shared.Provider;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("facetedsearch")
public interface FacetedSearchDataService extends RemoteService {

	String[] getProvider(int[] index);
	String[] getTechnology(int[] index);
	String[] getRating(int[] index);
	String[] getTool(int[] index);
	String[] getChannel(int[] index);
	String[] getResource(int[] index);
	String[] getFeature(int[] index);
	String[] getPricingPolicy(int[] index);
	Provider[] getProviders(Map<String, ArrayList<String>> index);
	
}
