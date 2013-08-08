package com.cloud4soa.facetedsearch.server;

import java.util.ArrayList;
import java.util.Map;

import com.cloud4soa.facetedsearch.client.FacetedSearchDataService;
import com.cloud4soa.facetedsearch.shared.Provider;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class FacetedSearchDataServiceImpl extends RemoteServiceServlet implements FacetedSearchDataService {
	private String[] providers = {"AWS", "Azure", "Google App Engine", "PHPnet"};
	private String[] technologies = {"PHP", "Java", ".Net", "Python", "Ruby", "PHP", "Java", ".Net", "Python", "Ruby"};
	private String[] rating = {"1 star", "2 star", "3 star", "4 star", "5 star"};
	private String[] tools = {"SQS", "SMS", "Storage on demand", "Relational Databases"};
	private String[] channels = {"API", "CLI", "Web"};
	private String[] resources = {"DB", "Load balancer", "Message queue", "NoSQL DB", "Email service", "24x7"};
	private String[] features = {"Elasticity", "High Availability", "Security", "SLAs"};
	private String[] pricingpolicies = {"Per use", "Per machine", "Per bandwidth", "Per se", "Per mutation", "Per colloni"};
	private ArrayList<Provider> providersobj= new ArrayList<Provider>();
	
	@Override
	public String[] getProvider(int[] index) {
		return this.providers;
	}
	
	@Override
	public String[] getTechnology(int[] index) {
		return this.technologies;
	}
	
	@Override
	public String[] getRating(int[] index) {
		return this.rating;
	}

	@Override
	public String[] getTool(int[] index) {
		return this.tools;
	}

	@Override
	public String[] getChannel(int[] index) {
		return this.channels;
	}
	
	@Override
	public String[] getResource(int[] index) {
		return this.resources;
	}

	@Override
	public String[] getFeature(int[] index) {
		return this.features;
	}

	@Override
	public String[] getPricingPolicy(int[] index) {
		return this.pricingpolicies;
	}

	@Override
	public Provider[] getProviders(Map<String, ArrayList<String>> index) {
		//Initial providers information
		//providersobj.add(new Provider("AWS", "AWS", "AWS"));
		//providersobj.add(new Provider("sss", "sss", "sss"));
		//providersobj.add(new Provider("aaa", "aaa", "aaa"));
		//providersobj.add(new Provider("aaa", "aaa", "aaa"));
		
		providersobj.add(new Provider("xxx", "xxx", "xxx"));
		providersobj.add(new Provider("zzz", "zzz", "zzz"));
		
		return this.providersobj.toArray(new Provider[]{});
	}

}
