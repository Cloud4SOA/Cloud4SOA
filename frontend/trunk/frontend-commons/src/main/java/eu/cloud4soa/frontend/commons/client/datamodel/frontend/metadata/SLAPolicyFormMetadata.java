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

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.COMBOBOX;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.TEXT;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata.COMBO_AVAILABLE_SLA_METRICS;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata.COMBO_SLA_DURATION;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata.COMBO_SLA_EXPRESSION;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAPolicyModel.DURATION;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAPolicyModel.EXPRESSION;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAPolicyModel.METRIC_TYPE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAPolicyModel.NUMBER_OF_BREACHES;

import com.google.gwt.user.client.rpc.IsSerializable;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;

/**
 * Entity metadata for the hardware component form in the offer editor
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class SLAPolicyFormMetadata extends EntityMetadata
		implements IsSerializable {

	public SLAPolicyFormMetadata() {

		field(FieldMetadata.create(METRIC_TYPE).label("Metric Name")
				.editType(COMBOBOX)
				.tooltip("SLA Metric Type")
				.relatedEntityType(COMBO_AVAILABLE_SLA_METRICS));
		
		field(FieldMetadata.create(DURATION).label("Duration (seg)")
				.editType(COMBOBOX)
				.tooltip("Time Interval")
				.relatedEntityType(COMBO_SLA_DURATION));
		
		field(FieldMetadata.create(NUMBER_OF_BREACHES).label("Number of breaches")
				.editType(TEXT).tooltip("Number of SLA breaches detected in the time interval"));

		field(FieldMetadata.create(EXPRESSION).label("Expression")
				.editType(COMBOBOX)
				.tooltip("Expression that defines type of violation triggered")
				.relatedEntityType(COMBO_SLA_EXPRESSION));

	}
}
