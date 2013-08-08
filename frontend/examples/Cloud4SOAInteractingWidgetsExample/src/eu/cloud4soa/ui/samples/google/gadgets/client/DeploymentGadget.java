package eu.cloud4soa.ui.samples.google.gadgets.client;

import com.google.gwt.gadgets.client.Gadget;
import com.google.gwt.gadgets.client.UserPreferences;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
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
public class DeploymentGadget extends Gadget<UserPreferences>  {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";


	/**
	 * This is the entry point method.
	 */
	protected void init(UserPreferences preferences) {
		DeploymentWidget dw = new DeploymentWidget();
	    RootPanel.get().add(dw);
	}
	
	
}
