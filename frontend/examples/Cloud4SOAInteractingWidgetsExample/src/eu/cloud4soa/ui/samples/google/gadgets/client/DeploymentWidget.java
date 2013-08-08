package eu.cloud4soa.ui.samples.google.gadgets.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;

public class DeploymentWidget extends Composite {

	public DeploymentWidget() {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("400px", "300px");
		
		Label lblPleaseSelectYour = new Label("Please, select your deployment file");
		verticalPanel.add(lblPleaseSelectYour);
		verticalPanel.setCellVerticalAlignment(lblPleaseSelectYour, HasVerticalAlignment.ALIGN_MIDDLE);
		
		final FileUpload fileUpload = new FileUpload();
		verticalPanel.add(fileUpload);
		fileUpload.setWidth("135px");
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setSize("403px", "71px");
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setSize("106px", "71px");
		horizontalPanel_1.add(verticalPanel_1);
		
		Label lblApplicationTechnology = new Label("Application Technology");
		verticalPanel_1.add(lblApplicationTechnology);
		
		final RadioButton rbJava = new RadioButton("Tech", "Java");
		rbJava.setChecked(true);
		verticalPanel_1.add(rbJava);
		
		final RadioButton rbPhp = new RadioButton("Tech", "PHP");
		verticalPanel_1.add(rbPhp);
		
		final RadioButton rbPython = new RadioButton("Tech", "Python");
		verticalPanel_1.add(rbPython);
		
		VerticalPanel verticalPanel_2 = new VerticalPanel();
		horizontalPanel_1.add(verticalPanel_2);
		
		Label lblPleaseSelectYour_1 = new Label("Please, select your provider target");
		verticalPanel_2.add(lblPleaseSelectYour_1);
		
		final ListBox selectPaaScomboBox = new ListBox();
		verticalPanel_2.add(selectPaaScomboBox);
		selectPaaScomboBox.addItem("PaaS Provider 1");
		selectPaaScomboBox.addItem("PaaS Provider 2");
		selectPaaScomboBox.addItem("PaaS Provider 3");
		horizontalPanel_1.setCellVerticalAlignment(selectPaaScomboBox, HasVerticalAlignment.ALIGN_MIDDLE);
		
		Button deployButton = new Button("New button");
		deployButton.addClickHandler(new ClickHandler(){

			public void onClick(ClickEvent event) {
				String deploymentFile = fileUpload.getFilename();
				String paasProvider = selectPaaScomboBox.getItemText(selectPaaScomboBox.getSelectedIndex());
				String applicationTech = null;
				if (rbJava.isChecked()){
					applicationTech = "Java";
				}else if (rbPhp.isChecked()){
					applicationTech = "PHP";
				}else if (rbPython.isChecked()){
					applicationTech = "Python";
				}
				
				boolean confirmed = Window.confirm("Please, confirm you wish to deploy file " 
						+ deploymentFile + " in provider " + paasProvider + " as " + applicationTech + " application");
				
				if (confirmed){
					publish (deploymentFile.substring(deploymentFile.lastIndexOf("\\") + 1));
				}
			}
			
		});
		deployButton.setText("Deploy");
		verticalPanel.add(deployButton);
	}
	
	public static native void publish (String application)/*-{
		gadgets.pubsub.publish("deployed-application", application);
	}-*/;

}
