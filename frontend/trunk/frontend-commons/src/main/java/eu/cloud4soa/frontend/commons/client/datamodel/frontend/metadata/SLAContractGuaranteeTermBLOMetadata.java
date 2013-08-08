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
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateGuaranteeTermBLOModel;

/**
 * Define the basic information form for the SLA Contract viewer.
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class SLAContractGuaranteeTermBLOMetadata extends EntityMetadata
		implements IsSerializable {

	public SLAContractGuaranteeTermBLOMetadata() {

		// Business level objective
		field(FieldMetadata
				.create(SLATemplateGuaranteeTermBLOModel.PenaltyAssessmentInterval)
				.label("Penalty Assessment Interval").editType(TEXT)
				.tooltip("Defines the assessment interval as a duration"));
		field(FieldMetadata
				.create(SLATemplateGuaranteeTermBLOModel.PenaltyValueUnit)
				.label("Penalty Value Unit").editType(TEXT)
				.tooltip("Defines the unit for assessing penalty"));
		field(FieldMetadata
				.create(SLATemplateGuaranteeTermBLOModel.PenaltyValueExpression)
				.label("Penalty Value Expression").editType(TEXT)
				.tooltip("Defines the assessment amount"));
		field(FieldMetadata
				.create(SLATemplateGuaranteeTermBLOModel.RewardAssessmentInterval)
				.label("Reward Assessment Interval").editType(TEXT)
				.tooltip("Defines the assessment interval as a duration"));
		field(FieldMetadata
				.create(SLATemplateGuaranteeTermBLOModel.RewardValueUnit)
				.label("Reward Value Unit").editType(TEXT)
				.tooltip("Defines the unit for assessing reward"));
		field(FieldMetadata
				.create(SLATemplateGuaranteeTermBLOModel.RewardValueExpression)
				.label("Reward Value Expression").editType(TEXT)
				.tooltip("Defines the assessment amount"));
	}
}
