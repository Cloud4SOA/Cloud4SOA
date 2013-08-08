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

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.TEXT;

import com.google.gwt.user.client.rpc.IsSerializable;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateGuaranteeTermSLOModel;
import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;

/**
 * Define the basic information form for the SLA Contract viewer.
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class SLAContractGuaranteeTermSLOMetadata extends EntityMetadata
		implements IsSerializable {

	public SLAContractGuaranteeTermSLOMetadata() {
		// Service Level Objective
		field(FieldMetadata.create(DisplayableKeyValueModelData.KEY)
				.label("ID").visible(false).editType(TEXT));
		field(FieldMetadata
				.create(SLATemplateGuaranteeTermSLOModel.GuaranteeTermName)
				.label("Guarantee Term Name").editType(TEXT)
				.tooltip("Represents the name given to a guarantee"));
		field(FieldMetadata
				.create(SLATemplateGuaranteeTermSLOModel.KPIName)
				.label("KPI Name")
				.editType(TEXT)
				.tooltip(
						"This name of a key performance indicator associated with the service"));
		field(FieldMetadata
				.create(SLATemplateGuaranteeTermSLOModel.CustomServiceLevel)
				.label("Custom Service Level")
				.editType(TEXT)
				.tooltip(
						"Can be customized by using a domain specific expression or assertion language"));
	}
}
