package eu.cloud4soa.frontend.widget.search.client.data;

import java.util.ArrayList;
import java.util.List;

public class ApplicationStore {
	List<Application> applications;

	public List<Application> getApplications() {
		loadApplications();
		return applications;
	}
	
	
	
	private void loadApplications() {
		applications = new ArrayList<Application>();
		
		for (int i=0; i<100; i++){
			int j = i + 1;
			Application ap = new Application("Application " + j, "Provider " + j, i%2==0?true:false);
			applications.add(ap);
		}
	}
}
