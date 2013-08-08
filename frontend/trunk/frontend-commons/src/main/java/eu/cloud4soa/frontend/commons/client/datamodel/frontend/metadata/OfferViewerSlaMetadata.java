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

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.FLOAT;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.TEXT;

import com.google.gwt.user.client.rpc.IsSerializable;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;

/**
 * Define the sla section form in the offer editor .
 * 
 * @author Stefano Travelli (Cyntelix)
 */
public class OfferViewerSlaMetadata extends EntityMetadata implements
		IsSerializable {

	public OfferViewerSlaMetadata() {
		field(FieldMetadata.create(PaaSOfferingModel.SLA_UPTIME)
				.label("Uptime").editType(TEXT)
				.tooltip("Percentage of time that HTTP response code is 200")
				.readonly(true));
		field(FieldMetadata.create(PaaSOfferingModel.SLA_MAX_LATENCY)
				.label("Maximum Latency (ms)").editType(FLOAT)
				.tooltip("Maximum acceptable response time in milliseconds")
				.readonly(true));

	}
}
