package eu.cloud4soa.frontend.widget.search.client.data;

import java.util.ArrayList;
import java.util.List;

public class PaasOfferingStore {
	List<PaasOffering> offerings;

	public List<PaasOffering> getPaasOffering() {
		loadOfferings();
		return offerings;
	}
	
	public List<PaasOffering> getPaasOffering2() {
		loadOfferings2();
		return offerings;
	}
	
	private void loadOfferings() {
		offerings = new ArrayList<PaasOffering>();
		
		for (int i=0; i<100; i++){
			int j = i + 1;
			PaasOffering po = new PaasOffering("OfferingA " + j, "ProviderA " + j,  i%2==0?"Java":"PHP");
			offerings.add(po);
		}
	}
	
	private void loadOfferings2() {
		offerings = new ArrayList<PaasOffering>();
		
		for (int i=0; i<100; i++){
			int j = i + 1;
			PaasOffering po = new PaasOffering("OfferingB " + j, "ProviderB " + j,  i%2==0?".NET":"Python");
			offerings.add(po);
		}
	}

	public static List<PaaSOfferingDetails> getPaaSOfferingDetails() {
		List<PaaSOfferingDetails> pods = new ArrayList<PaaSOfferingDetails>();
		
		PaaSOfferingDetails pod = new PaaSOfferingDetails ("Title", "CloudControl", "PaaS Offering"); pods.add(pod);
		pod = new PaaSOfferingDetails ("Status", "Active", "PaaS Offering"); pods.add(pod);
		pod = new PaaSOfferingDetails ("URL", "http://wwww.cloudcontrol.com", "PaaS Offering"); pods.add(pod);
		pod = new PaaSOfferingDetails ("Title", "PHP", "Supported Language"); pods.add(pod);
		pod = new PaaSOfferingDetails ("Version", "5.3.2", "Supported Language"); pods.add(pod);
		pod = new PaaSOfferingDetails ("Title", "Cloud Control", "PaaS Provider"); pods.add(pod);
		pod = new PaaSOfferingDetails ("Home page", "http://wwww.cloudcontrol.com", "PaaS Provider"); pods.add(pod);
		
		return pods;
	}
}
