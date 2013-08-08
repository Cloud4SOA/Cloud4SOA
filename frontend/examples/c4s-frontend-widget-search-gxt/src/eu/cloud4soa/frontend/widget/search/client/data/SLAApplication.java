package eu.cloud4soa.frontend.widget.search.client.data;

import com.extjs.gxt.ui.client.data.BaseModel;

public class SLAApplication extends BaseModel{
	public SLAApplication(){
		
	}

	public SLAApplication (String application){
		set ("application", application);
	}
	
	public String getApplication(){
		return get ("application");
	}
	
	@Override
	public boolean equals (Object o){
		boolean result = false;
		
		if (o instanceof SLAApplication){
			result = ((SLAApplication) o).getApplication().equals(getApplication());		
		}
		
		return result;
	}
}
