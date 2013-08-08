package eu.cloud4soa.frontend.widget.search.client.data;

import com.extjs.gxt.ui.client.data.BaseModel;

public class SLAProvider extends BaseModel{

	public SLAProvider (String provider){
		set ("provider", provider);
	}
	
	public String getProvider(){
		return get ("provider");
	}
	
	@Override
	public boolean equals (Object o){
		boolean result = false;
		
		if (o instanceof SLAProvider){
			result = ((SLAProvider) o).getProvider().equals(getProvider());		
		}
		
		return result;
	}
}
