package eu.cloud4soa.frontend.widget.search.client.data;

import com.extjs.gxt.ui.client.data.BaseModel;

public class SLAViolation extends BaseModel{

	public SLAViolation (String eventId, String metric, String actualValue, String expectedValue, String status,
			String application, String provider, String date, String recoveryAction){
		set ("eventId", eventId);
		set ("metric", metric);
		set ("expectedValue", expectedValue);
		set ("actualValue", actualValue);
		set ("status", status);
		set ("application", application);
		set ("provider", provider);
		set ("date", date);
		set ("recoveryAction", recoveryAction);
			
	}
}
