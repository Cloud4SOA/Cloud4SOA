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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend.metadata;

import com.google.gwt.user.client.rpc.IsSerializable;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.TEXT;

/**
 * Define a readonly form with a basic set of fields that identify an application profile.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationSummaryMetadata extends EntityMetadata implements IsSerializable {

    public ApplicationSummaryMetadata() {

        field(FieldMetadata.create(ApplicationModel.TITLE)
                .label("Title")
                .editType(TEXT)
                .tooltip("Application title")
                .readonly(true)
        );
        field(FieldMetadata.create(ApplicationModel.VERSION)
                .label("Version")
                .editType(TEXT)
                .tooltip("Version number")
                .readonly(true)
        );
    }
}
