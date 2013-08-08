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

package eu.cloud4soa.frontend.widget.usermanagement.client.images;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * Images used in the application tool tree
 *
 *
 * @author Stefano Travelli (Cyntelix)
 */
public interface ComponentSelectorImages extends ClientBundle {

    public static final ComponentSelectorImages INSTANCE = GWT.create(ComponentSelectorImages.class);

    @Source("requirements-16x16.png")
    ImageResource requirements();

    @Source("hardware-16x16.png")
    ImageResource hardwareComponent();

    @Source("communication-16x16.png")
    ImageResource hardwareNetworkComponent();

    @Source("computation-16x16.png")
    ImageResource hardwareComputeComponent();

    @Source("http_requests-16x16.png")
    ImageResource hardwareHttpRequestComponent();

    @Source("storage-16x16.png")
    ImageResource hardwareStorageComponent();

    @Source("software-16x16.png")
    ImageResource softwareComponent();

    @Source("software-16x16.png")
    ImageResource softwareGenericComponent();

    @Source("database-16x16.png")
    ImageResource softwareDatabaseComponent();

    @Source("nosqldatabase-16x16.png")
    ImageResource softwareNoSqlDatabaseComponent();

    @Source("sqldatabase-16x16.png")
    ImageResource softwareSqlDatabaseComponent();


}
