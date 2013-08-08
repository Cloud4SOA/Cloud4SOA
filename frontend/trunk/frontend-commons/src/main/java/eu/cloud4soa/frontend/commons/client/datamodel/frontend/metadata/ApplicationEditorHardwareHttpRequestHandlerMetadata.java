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
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.COMBOBOX;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata.COMBO_COMPUTATION_CATEGORY;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel.*;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.RangeModel.MIN;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.RangeModel.REQUIRED;

/**
 * HTTP request handler metadata
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationEditorHardwareHttpRequestHandlerMetadata extends EntityMetadata implements IsSerializable {

    public ApplicationEditorHardwareHttpRequestHandlerMetadata() {

        field(FieldMetadata.create(HARDWARE_CATEGORY)
                .label("Category")
                .editType(COMBOBOX)
                .tooltip("Possible unit that the different PaaS use to manage the HTTP requests")
                .relatedEntityType(COMBO_COMPUTATION_CATEGORY)
        );


        //computational power factor
        field(FieldMetadata.create(POWER_FACTOR, MIN)
                .label("Computational power factor")
                .editType(EditType.FLOAT)
                .withRequiredFlag(POWER_FACTOR, REQUIRED)
                .allowDecimals(true)
                .allowNegative(false)
                .tooltip("Minimum factor about the HTTP request handlers")
        );

        // http requests
        field(FieldMetadata.create(HTTP_REQUESTS, MIN)
                .label("Number of HTTP Requests")
                .editType(EditType.FLOAT)
                .withRequiredFlag(HTTP_REQUESTS, REQUIRED)
                .allowDecimals(false)
                .allowNegative(false)
                .tooltip("Number of HTTP requests that each handler can manage")
        );

    }
}
