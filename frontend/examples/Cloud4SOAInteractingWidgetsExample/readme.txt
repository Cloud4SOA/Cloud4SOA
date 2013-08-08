Steps to create a GWT project with multiple interconnected Gadgets
------------------------------------------------------------------
1 - Create a GWT project: use GWT SDK 2.1.1. SDK 2.2.0 is incompatible
with current GWT-Gadgets library 1.2. Rename the module name (.gwt.xml, EntryPoint class)
with the name of the first gadget
2 - Create and add User Library for GWT-Gadgets
	- Download GWT-Gadgets library 1.2 from http://code.google.com/p/gwt-google-apis/wiki/Downloads?tm=2
3 - For each gadget (i.e. DeploymentGadget)
	- Excepting first gadget, create a new GWT module. For firts gadget, we already 
	have a module.
	- Edit src/eu/cloud4soa/ui/samples/google/gadgets/DeploymentGadget.gwt.xml
		-Update (the entry point class and module name):
		rename-to='deploymentgadget'
		<entry-point class='eu.cloud4soa.ui.samples.google.gadgets.client.DeploymentGadget'/>
		-Add:
		<!-- Other module inherits   -->
  		<inherits name='com.google.gwt.gadgets.Gadgets' />
	- Rename the EntryPoint class, in this example the new Entry point class is 
	eu.cloud4soa.ui.samples.google.gadgets.client.DeploymentGadget. Edit this class:
		-Remove implements in class definition, add extends Gadget<UserPreferences>
		-Add the following annotations (update title, author, author_email, width, height):
		@com.google.gwt.gadgets.client.Gadget.ModulePrefs(
			title = "Cloud4SOA Deployment Widget", 
			author = "Yosu Gorroñogoitia", 
			author_email = "jesus.gorronogoitia@atosresearch.eu",
			width = 300,
			height = 400
		)
		@com.google.gwt.gadgets.client.Gadget.InjectModulePrefs(files = {"AdditionalModulePrefs.xml"})
		@com.google.gwt.gadgets.client.Gadget.UseLongManifestName(false)
		@com.google.gwt.gadgets.client.Gadget.AllowHtmlQuirksMode(false) 
	- Remove onModuleLoad() method and other unrequired code.
	- Implement init method.

4- For Gadget intercomunication
	Publisher Gadget:
		- Use a Javascript native method like this to publish a message:
		public static native void publish (String application)/*-{
			gadgets.pubsub.publish("deployed-application", application);
		}-*/;
		where and application message is sent to "deployed-application" channel
		
	Subscriber Gadget:
		- Use a Javascript native method like this to subscribe to a message channel:
		  public native void subscribe() /*-{
    		//$wnd.callback =
        	//	$entry(this.@eu.cloud4soa.ui.samples.google.gadgets.client.MonitoringGadget::callback(Ljava/lang/String;Ljava/lang/String;));

    		//wnd.deploy =
        	//	$entry(this.@eu.cloud4soa.ui.samples.google.gadgets.client.MonitoringGadget::deployApplication(Ljava/lang/String;Lcom/google/gwt/user/client/ui/VerticalPanel;));      

    		//$wnd.vp = this.@eu.cloud4soa.ui.samples.google.gadgets.client.MonitoringGadget::vp;

    		gadgets.pubsub.subscribe("deployed-application", $wnd.callback);
  		  }-*/;	
  		  save any GWT property or method that the callback should invoke in a window global reference
  		  