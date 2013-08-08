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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend.governance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAViolationModel;


public class SLAStore {
	List<SLAViolationModel> slaViolations;
//	List<SLAViolationModel> openSlaViolations;
	List<SLAApplication> applications;
	List<SLAProvider> providers;

	public List<SLAViolationModel> getSLAViolations() {
		if (slaViolations == null){
			loadSLAViolations();
		}
		return slaViolations;
	}
	
//	public List<SLAViolationModel> getOpenSLAViolations() {
//		if (openSlaViolations == null){
//			loadSLAViolations();
//		}
//		return openSlaViolations;
//	}
	
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
		slaViolations = new ArrayList<SLAViolationModel>();
//		openSlaViolations = new ArrayList<SLAViolationModel>();
		applications = new ArrayList<SLAApplication>();
		applications.add(new SLAApplication("-"));
		providers = new ArrayList<SLAProvider>();
		providers.add(new SLAProvider("-"));
		
		for (int i=0; i<100; i++){
			int j = i + 1;
			SLAViolationModel slav;
			boolean open = Math.round(Math.random())==0;
			if (i%2==0){
				long responseTime = Math.round(Math.random()*1000);
				slav = new SLAViolationModel("Event"+ i, "Response Time", responseTime + " ms", responseTime - responseTime/2 + " ms", 
						open?"Open":"Closed", "Application " + Math.round(Math.random()*10), "Application " + Math.round(Math.random()*10),
						"Provider " + Math.round(Math.random()*5),
						new Date().toString(), "Added additional box" );
			}else{
				String responseCode = Math.random()<0.5?"408 Request Timeout": "503 Service Unavailable";
				slav = new SLAViolationModel("Event"+ i, "Response Code", responseCode, "200 OK", 
						open?"Open":"Closed", "Application " + Math.round(Math.random()*10), 
						"Application " + Math.round(Math.random()*10),"Provider " + Math.round(Math.random()*5),
						new Date().toString(), "Restarted Service" );
			}
			
			slaViolations.add(slav);
//			if (open){
//				openSlaViolations.add(slav);
//			}
			SLAApplication slaa = new SLAApplication((String)slav.get("application"));
			if (!applications.contains(slaa)){
				applications.add(slaa);
			}
			
			Collections.sort(applications, new Comparator<SLAApplication>() {  
			      @Override
				public int compare(SLAApplication arg0, SLAApplication arg1) {  
			        return arg0.getApplication().compareTo(arg1.getApplication());  
			      }  
			});
			
			SLAProvider slap = new SLAProvider((String)slav.get("provider"));
			if (!providers.contains(slap)){
				providers.add(slap);
			}
			
			Collections.sort(providers, new Comparator<SLAProvider>() {  
			      @Override
				public int compare(SLAProvider arg0, SLAProvider arg1) {  
			        return arg0.getProvider().compareTo(arg1.getProvider());  
			      }  
			});
		}
	}
	
	private void loadSLAViolations(List<SLAViolationModel> list) {
		slaViolations = new ArrayList<SLAViolationModel>();
//		openSlaViolations = new ArrayList<SLAViolationModel>();
		applications = new ArrayList<SLAApplication>();
		applications.add(new SLAApplication("-"));
		providers = new ArrayList<SLAProvider>();
		providers.add(new SLAProvider("-"));
		
		for (SLAViolationModel slav: list){
			
			slaViolations.add(slav);
//			if (slav.get("status").equals("Open")){
//				openSlaViolations.add(slav);
//			}
			SLAApplication slaa = new SLAApplication((String)slav.get("application"));
			if (!applications.contains(slaa)){
				applications.add(slaa);
			}
			
			Collections.sort(applications, new Comparator<SLAApplication>() {  
			      @Override
				public int compare(SLAApplication arg0, SLAApplication arg1) {  
			        return arg0.getApplication().compareTo(arg1.getApplication());  
			      }  
			});
			
			SLAProvider slap = new SLAProvider((String)slav.get("provider"));
			if (!providers.contains(slap)){
				providers.add(slap);
			}
			
			Collections.sort(providers, new Comparator<SLAProvider>() {  
			      @Override
				public int compare(SLAProvider arg0, SLAProvider arg1) {  
			        return arg0.getProvider().compareTo(arg1.getProvider());  
			      }  
			});
		}
	}
	
	public List<SLAViolationModel> filterByApplicationAndProvider(
			String application, String provider) {
		List<SLAViolationModel> violations = slaViolations;
		
		if (application.equals("-") && provider.equals("-")){
			return violations;
		}
		
		List<SLAViolationModel> result = new ArrayList<SLAViolationModel>();
		
		for (SLAViolationModel slav: violations){
			if (slav.get(SLAViolationModel.APPLICATION).equals(application) && provider.equals("-")){
				result.add (slav);
			}else if (slav.get(SLAViolationModel.PROVIDER).equals(provider) && application.equals("-")){
				result.add (slav);
			}else if (slav.get(SLAViolationModel.APPLICATION).equals(application) && 
					  slav.get(SLAViolationModel.PROVIDER).equals(provider)){
				result.add (slav);
			}
		}
		return result;
	}

//	public List<SLAViolationModel> filterByApplicationAndProvider(
//			String application, String provider, boolean includeClosedEvents) {
//		List<SLAViolationModel> violations = includeClosedEvents?slaViolations:openSlaViolations;
//		
//		if (application.equals("-") && provider.equals("-")){
//			return violations;
//		}
//		
//		List<SLAViolationModel> result = new ArrayList<SLAViolationModel>();
//		
//		for (SLAViolationModel slav: violations){
//			if (slav.get("application").equals(application) && provider.equals("-")){
//				result.add (slav);
//			}else if (slav.get("provider").equals(provider) && application.equals("-")){
//				result.add (slav);
//			}else if (slav.get("application").equals(application) && slav.get("provider").equals(provider)){
//				result.add (slav);
//			}
//		}
//		return result;
//	}

	public void setViolations(List<SLAViolationModel> result) {
		loadSLAViolations(result);
	}

	/**
	 * @param applicationId
	 * @return
	 */
	public List<SLAViolationModel> filterByApplicationId(String applicationId) {
		
		List<SLAViolationModel> violations = slaViolations;
		List<SLAViolationModel> result = new ArrayList<SLAViolationModel>();
		
		for (SLAViolationModel slav: violations){
			if (slav.get(SLAViolationModel.APPLICATION_ID).equals(applicationId)){
				result.add (slav);
			}
		}
		return result;
		
	}

	
}
