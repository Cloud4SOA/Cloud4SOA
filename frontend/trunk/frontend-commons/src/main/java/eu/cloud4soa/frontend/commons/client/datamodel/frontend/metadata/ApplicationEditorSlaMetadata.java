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

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;

/**
 * Define the sla section form in the application editor.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationEditorSlaMetadata extends EntityMetadata implements IsSerializable {


    public ApplicationEditorSlaMetadata() {
        field(FieldMetadata.create(ApplicationModel.SLA_UPTIME)
                .label("Uptime (%)")
                .editType(EditType.FLOAT)
                .tooltip("Percentage of time that HTTP response code is 200")
        );

        field(FieldMetadata.create(ApplicationModel.SLA_MAX_LATENCY)
                .label("Maximum Latency (ms)")
                .editType(EditType.FLOAT)
                .allowDecimals(false)
                .allowNegative(false)
                .tooltip("Maximum acceptable response time in milliseconds")
        );

    }
}
