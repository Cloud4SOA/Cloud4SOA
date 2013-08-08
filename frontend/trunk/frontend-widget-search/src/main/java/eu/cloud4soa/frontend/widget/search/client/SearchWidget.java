/*
 * This file is part of Cloud4SOA Frontend.
 *
 *     Cloud4SOA Frontend is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cloud4SOA Frontend is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cloud4SOA Frontend.  If not, see <http://www.gnu.org/licenses/>.
 */

package eu.cloud4soa.frontend.widget.search.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.widget.search.client.activities.SearchResultsActivity;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SearchWidget implements EntryPoint {
    
	public void onModuleLoad() {
		RootPanel panel = RootPanel.get("searchPanel");
		//Loading widget for debugging purposes only within the module. This avoids to load this module twice
		//since every widget module dependency is loaded from dashboard module
		if (panel != null){ 
			Cloud4SOAUIClientFactory clientFactory = GWT.create(Cloud4SOAUIClientFactory.class);
	        EventBus eventBus = clientFactory.getEventBus();
	        
	        SearchResultsActivity activity = new SearchResultsActivity(clientFactory);
	        
	        SimplePanel appWidget = new SimplePanel();
	        appWidget.addStyleName("searchPanel");
	        RootPanel.get("searchPanel").add(appWidget);
	        
	        activity.start(appWidget, eventBus);
		}
	}
}
