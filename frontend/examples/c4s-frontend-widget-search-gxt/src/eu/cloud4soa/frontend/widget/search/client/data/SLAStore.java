package eu.cloud4soa.frontend.widget.search.client.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class SLAStore {
	List<SLAViolation> slaViolations;
	List<SLAViolation> openSlaViolations;
	List<SLAApplication> applications;
	List<SLAProvider> providers;

	public List<SLAViolation> getSLAViolations() {
		if (slaViolations == null){
			loadSLAViolations();
		}
		return slaViolations;
	}
	
	public List<SLAViolation> getOpenSLAViolations() {
		if (openSlaViolations == null){
			loadSLAViolations();
		}
		return openSlaViolations;
	}
	
	public List<SLAApplication> getApplications() {
		if (applications == null){
			loadSLAViolations();
		}
		return applications;
	}
	
	public List<SLAProvider> getProviders() {
		if (providers == null){
			loadSLAViolations();
		}
		return providers;
	}
	
	
	
	private void loadSLAViolations() {
		slaViolations = new ArrayList<SLAViolation>();
		openSlaViolations = new ArrayList<SLAViolation>();
		applications = new ArrayList<SLAApplication>();
		applications.add(new SLAApplication("-"));
		providers = new ArrayList<SLAProvider>();
		providers.add(new SLAProvider("-"));
		
		for (int i=0; i<100; i++){
			int j = i + 1;
			SLAViolation slav;
			boolean open = Math.round(Math.random())==0;
			if (i%2==0){
				long responseTime = Math.round(Math.random()*1000);
				slav = new SLAViolation("Event"+ i, "Response Time", responseTime + " ms", responseTime - responseTime/2 + " ms", 
						open?"Open":"Closed", "Application " + Math.round(Math.random()*10), 
						"Provider " + Math.round(Math.random()*5),
						new Date().toString(), "Added additional box" );
			}else{
				String responseCode = Math.random()<0.5?"408 Request Timeout": "503 Service Unavailable";
				slav = new SLAViolation("Event"+ i, "Response Code", responseCode, "200 OK", 
						open?"Open":"Closed",
						"Application " + Math.round(Math.random()*10), "Provider " + Math.round(Math.random()*5),
						new Date().toString(), "Restarted Service" );
			}
			
			slaViolations.add(slav);
			if (open){
				openSlaViolations.add(slav);
			}
			SLAApplication slaa = new SLAApplication((String)slav.get("application"));
			if (!applications.contains(slaa)){
				applications.add(slaa);
			}
			
			Collections.sort(applications, new Comparator<SLAApplication>() {  
			      public int compare(SLAApplication arg0, SLAApplication arg1) {  
			        return arg0.getApplication().compareTo(arg1.getApplication());  
			      }  
			});
			
			SLAProvider slap = new SLAProvider((String)slav.get("provider"));
			if (!providers.contains(slap)){
				providers.add(slap);
			}
			
			Collections.sort(providers, new Comparator<SLAProvider>() {  
			      public int compare(SLAProvider arg0, SLAProvider arg1) {  
			        return arg0.getProvider().compareTo(arg1.getProvider());  
			      }  
			});
		}
	}

	public List<SLAViolation> filterByApplicationAndProvider(
			String application, String provider, boolean includeClosedEvents) {
		List<SLAViolation> violations = includeClosedEvents?slaViolations:openSlaViolations;
		
		if (application.equals("-") && provider.equals("-")){
			return violations;
		}
		
		List<SLAViolation> result = new ArrayList<SLAViolation>();
		
		for (SLAViolation slav: violations){
			if (slav.get("application").equals(application) && provider.equals("-")){
				result.add (slav);
			}else if (slav.get("provider").equals(provider) && application.equals("-")){
				result.add (slav);
			}else if (slav.get("application").equals(application) && slav.get("provider").equals(provider)){
				result.add (slav);
			}
		}
		return result;
	}

	
}
