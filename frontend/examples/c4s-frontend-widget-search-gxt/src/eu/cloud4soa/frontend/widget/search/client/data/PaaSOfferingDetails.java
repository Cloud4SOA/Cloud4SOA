package eu.cloud4soa.frontend.widget.search.client.data;

import com.extjs.gxt.ui.client.data.BaseModel;

public class PaaSOfferingDetails extends BaseModel{
	
	public PaaSOfferingDetails(){
		
	}
	public PaaSOfferingDetails (String property, String value, String section){
		set ("property", property);
		set ("value", value);
		set ("section", section);
	}
	
	public String getProperty() {
		return get ("property");
	}
	
	public String getValue() {
		return get ("value");
	}
	
	public String getSection() {
		return get("section");
	}
}
