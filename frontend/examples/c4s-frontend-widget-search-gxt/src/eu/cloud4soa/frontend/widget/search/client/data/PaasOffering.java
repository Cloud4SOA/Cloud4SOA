package eu.cloud4soa.frontend.widget.search.client.data;

import com.extjs.gxt.ui.client.data.BaseModel;

public class PaasOffering extends BaseModel{
	
	public PaasOffering(){
		
	}
	
	public PaasOffering (String name, String provider, String programmingLanguage){
		set ("name", name);
		set ("provider", provider);
		set ("programmingLanguage", programmingLanguage);
	}
	
}
