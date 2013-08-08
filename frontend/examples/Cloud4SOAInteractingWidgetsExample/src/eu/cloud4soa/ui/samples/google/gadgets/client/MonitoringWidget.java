package eu.cloud4soa.ui.samples.google.gadgets.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MonitoringWidget extends Composite {
	
	public VerticalPanel verticalPanel = new VerticalPanel();
	
	public MonitoringWidget() {
		
		initWidget(verticalPanel);
		
		Label lblDeployedApplications_1 = new Label("Deployed Applications:");
		verticalPanel.add(lblDeployedApplications_1);
		
		deployApplication ("Application 1");
		deployApplication ("Application 2");
		
	}
	
	public VerticalPanel getVerticalPanel(){
		return verticalPanel;
	}

	public void deployApplication (final String application){
		final Grid grid = new Grid (1, 2);
		Label lbApplication = new Label(application);
		grid.setWidget(0, 0, lbApplication);
		Button bUndeploy = new Button ("Undeploy");
		grid.setWidget(0, 1, bUndeploy);
		bUndeploy.addClickHandler(new ClickHandler (){

			public void onClick(ClickEvent event) {
				getVerticalPanel().remove(grid);
			}
			
		});
		getVerticalPanel().add(grid);
	}
	
	
    
}
