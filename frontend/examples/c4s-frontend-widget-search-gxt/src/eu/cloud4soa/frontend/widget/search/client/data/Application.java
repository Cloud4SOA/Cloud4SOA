package eu.cloud4soa.frontend.widget.search.client.data;

import com.extjs.gxt.ui.client.data.BaseModel;

public class Application extends BaseModel{
	public Application(){
		
	}

	public Application (String acronym, String provider, Boolean status){
		set ("acronym", acronym);
		set ("provider", provider);
		set ("status", status);
		set ("command", status? "stop": "start");
		set ("undeploy", "undeploy");
		set ("seemonitoringdata", "See monitoring data");
			
	}
}
