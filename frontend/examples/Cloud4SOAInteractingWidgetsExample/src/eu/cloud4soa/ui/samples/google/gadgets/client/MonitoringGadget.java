package eu.cloud4soa.ui.samples.google.gadgets.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.gadgets.client.Gadget;
import com.google.gwt.gadgets.client.UserPreferences;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.Window;

@com.google.gwt.gadgets.client.Gadget.ModulePrefs(
		title = "Cloud4SOA Monitoring Widget", 
		author = "Yosu Gorroñogoitia", 
		author_email = "jesus.gorronogoitia@atosresearch.eu",
		width = 300,
		height = 400
)
@com.google.gwt.gadgets.client.Gadget.InjectModulePrefs(files = {"AdditionalModulePrefs.xml"})
@com.google.gwt.gadgets.client.Gadget.UseLongManifestName(false)
@com.google.gwt.gadgets.client.Gadget.AllowHtmlQuirksMode(false)
public class MonitoringGadget extends Gadget<UserPreferences> {
	public MonitoringWidget mw;
	public VerticalPanel vp;
	
	protected void init(UserPreferences preferences) {
		mw = new MonitoringWidget();
	    RootPanel.get().add(mw);
	    vp = mw.getVerticalPanel();
	    subscribe();
	}
	
//	public void deployApplication (String application){
//		mw.deployApplication(application);
//	}
	
	public void deployApplication (String application, final VerticalPanel vp){
//		Window.alert ("Deploying Application: " + application);
		final Grid grid = new Grid (1, 2);
		Label lbApplication = new Label(application);
		grid.setWidget(0, 0, lbApplication);
		Button bUndeploy = new Button ("Undeploy");
		grid.setWidget(0, 1, bUndeploy);
		bUndeploy.addClickHandler(new ClickHandler (){

			public void onClick(ClickEvent event) {
				vp.remove(grid);
			}
			
		});
//		Window.alert ("Vertical panel: " + vp);
		vp.add(grid);
	}
	
	// Callback to handle messages received from channel.
//    public static native void callback(String sender, String application)/*-{
//      	alert("Deploying application: " + application);
//      	var _this = this;
////      	@eu.cloud4soa.ui.samples.google.gadgets.client.MonitoringGadget::test(Ljava/lang/String;) (application);
//      	_this.@eu.cloud4soa.ui.samples.google.gadgets.client.MonitoringGadget::deployApplication(Ljava/lang/String;) (application);
//      	alert("Application deployed");
//    }-*/;

// Function to subscribe to the channel. Registered to be executed at Gadget load.
//    public static native void subscribe() /*-{
//      $wnd.callback =
//          $entry(@eu.cloud4soa.ui.samples.google.gadgets.client.MonitoringGadget::callback(Ljava/lang/String;Ljava/lang/String;));
//      gadgets.pubsub.subscribe("deployed-application", $wnd.callback);
//    }-*/;

	
	// Callback to handle messages received from channel.
  public native void callback(String sender, String application)/*-{
//  		alert ("Invoked callback method");
//  		alert ("testdata: " + $wnd.testdata);
//  		alert ("vp: " + $wnd.vp);
    	$wnd.deploy (application, $wnd.vp);
  }-*/;	
	
	// Function to subscribe to the channel. Registered to be executed at Gadget load.
  public native void subscribe() /*-{
//  	var _this = this;
    $wnd.callback =
        $entry(this.@eu.cloud4soa.ui.samples.google.gadgets.client.MonitoringGadget::callback(Ljava/lang/String;Ljava/lang/String;));
//    alert ("Callback method: " + $wnd.callback);
    $wnd.deploy =
        $entry(this.@eu.cloud4soa.ui.samples.google.gadgets.client.MonitoringGadget::deployApplication(Ljava/lang/String;Lcom/google/gwt/user/client/ui/VerticalPanel;));      
//    alert ("Deploy method: " + $wnd.callback);
    $wnd.vp = this.@eu.cloud4soa.ui.samples.google.gadgets.client.MonitoringGadget::vp;
//    alert ("vp: " + $wnd.vp);
    gadgets.pubsub.subscribe("deployed-application", $wnd.callback);
  }-*/;	
	
}
    
    
