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

package eu.cloud4soa.frontend.commons.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * Resources for rendering graphic elements regarding the places
 * 
 * @author Stefano Travelli (Cyntelix)
 */
public interface PlaceIcons extends ClientBundle {

	public static final PlaceIcons RESOURCES = GWT.create(PlaceIcons.class);

	@Source("design/logo.png")
	@ImageResource.ImageOptions(height = 100, width = 300)
	ImageResource logo();

	@Source("blue/application.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource application();

	@Source("red/application.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource application_over();

	@Source("blue/search.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource search();

	@Source("red/search.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource search_over();

	@Source("blue/web.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource browse();

	@Source("red/web.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
    ImageResource browse_over();

	@Source("blue/software.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource deploy();

	@Source("red/software.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource deploy_over();

	@Source("blue/oscilloscope.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource monitoring();

	@Source("red/oscilloscope.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource monitoring_over();

	@Source("design/PaasOffers.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource offer();

	@Source("design/PaasOffers_over.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource offer_over();

	@Source("blue/user-card.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource userProfile();

	@Source("red/user-card.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource userProfile_over();

    @Source("blue/equalizer.png")
   	@ImageResource.ImageOptions(height = 48, width = 48)
    ImageResource adminPlace();

    @Source("red/equalizer.png")
   	@ImageResource.ImageOptions(height = 48, width = 48)
    ImageResource adminPlace_over();

	@Source("blue/link.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource register();

	@Source("red/link.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource register_over();

	@Source("blue/key.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource login();

	@Source("red/key.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource login_over();

	@Source("blue/navigation-right.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource logout();

	@Source("red/navigation-right.png")
	@ImageResource.ImageOptions(height = 48, width = 48)
	ImageResource logout_over();

    @Source("blue/button-shuffle.png")
    @ImageResource.ImageOptions(height = 48, width = 48)
    ImageResource migrate();

    @Source("red/button-shuffle.png")
    @ImageResource.ImageOptions(height = 48, width = 48)
    ImageResource migrate_over();

}
