package eu.cloud4soa.frontend.widget.search.client.data;

import java.util.ArrayList;
import java.util.List;

public class FacetData {
	static String[] PAASPROVIDERS = {
			"CloudControl",
			"AppEngine",
			"Beanstalk",
			"CloudBees",
			"AppHarbor",
			"Azure",
			"CumuLogic",
			"Heroku",
			"OpenShift",
			"CloudFoundry",
			"EngineYard",
			"PlayApps"
	};
	static String[] PROGRAMMNING_LANGUAGE = {
			"PHP",
			"Java",
			"C/C++",
			"ASP.NET",
			"Python",
			"Scala",
			"Ruby"
	};
	static String[] RATINGS = {
			"5 star",
			"4 star",
			"3 star",
			"2 star",
			"1 star"
	};
	
	static String[] SOFTWARE_COMPONENTS = {
			"MySQL",
			"In-memory Storage",
			"MemChached",
			"SSL",
			"New Relic",
			"Mongo-DB"
	};
	
	static String[] CHANNELS = {
			"CLI",
			"API",
			"WebInterface"
	};
	
	static String[] HARDWARE_COMPONENTS = {
			"NetworkResource", 
			"Box", 
			"StorageResource", 
			"Compute"
	};
	
	static String[] PRICING_POLICIES = {
		"Pay as you go", 
		"Per license fee", 
		"Per user fee", 
		"Per computer fee"
};
	
	private static List<? extends Facet> populateList(String[] facets) {
		List<Facet> list = new ArrayList<Facet>();
		for (String f:facets){
			list.add (new Facet(f));
		}
		return list;
	}
	
	public static List<? extends Facet> getProviders() {
		return populateList(PAASPROVIDERS);
	}

	public static List<? extends Facet> getTechnologies() {
		return populateList(PROGRAMMNING_LANGUAGE);
	}

	public static List<? extends Facet> getTools() {
		return populateList(PAASPROVIDERS);
	}

	public static List<? extends Facet> getChannels() {
		return populateList(CHANNELS);
	}

	public static List<? extends Facet> getRatings() {
		return populateList(RATINGS);
	}

	public static List<? extends Facet> getResources() {
		return populateList(HARDWARE_COMPONENTS);
	}

	public static List<? extends Facet> getFeatures() {
		return populateList(SOFTWARE_COMPONENTS);
	}

	public static List<? extends Facet> getPricingPolicies() {
		return populateList(PRICING_POLICIES);
	}

}
