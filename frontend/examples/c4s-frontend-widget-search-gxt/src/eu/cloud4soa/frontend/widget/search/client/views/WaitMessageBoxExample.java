package eu.cloud4soa.frontend.widget.search.client.views;


import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.google.gwt.user.client.Timer;

public class WaitMessageBoxExample extends LayoutContainer{
	
	public WaitMessageBoxExample(){
		final MessageBox mb = MessageBox.wait ("Progress",  
		           "Saving your data, please wait...", "Saving...");
		Timer t = new Timer() {  
			@Override  
			public void run() {  
				mb.close();  
			}  
		};  
		t.schedule(5000); 
	}
}
