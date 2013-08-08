package eu.cloud4soa.frontend.widget.search.client.images;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.ImageBundle;
import com.google.gwt.user.client.ui.ImageBundle.Resource;

@SuppressWarnings("deprecation")
public interface Icons extends ImageBundle{
	
	public static final Icons RESOURCES = GWT.create(Icons.class);
	
	@Resource("more-details.png")
	  AbstractImagePrototype moreDetails();

}
