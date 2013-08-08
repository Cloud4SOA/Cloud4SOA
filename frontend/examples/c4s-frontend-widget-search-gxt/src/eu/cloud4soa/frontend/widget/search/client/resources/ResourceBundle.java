package eu.cloud4soa.frontend.widget.search.client.resources;


import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;


public interface ResourceBundle extends ClientBundle{
	
	@Source("online.png")
  	ImageResource online();
	
	@Source("offline.png")
  	ImageResource offline();

}
