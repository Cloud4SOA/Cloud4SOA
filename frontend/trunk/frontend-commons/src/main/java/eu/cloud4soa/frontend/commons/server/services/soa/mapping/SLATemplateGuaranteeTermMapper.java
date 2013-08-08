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

package eu.cloud4soa.frontend.commons.server.services.soa.mapping;

import static eu.cloud4soa.frontend.commons.client.gxt.WithTitle.TITLE;

import org.apache.commons.lang.NotImplementedException;

import eu.cloud4soa.api.datamodel.governance.GuaranteeTerm;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateGuaranteeTermBLOModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateGuaranteeTermModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateGuaranteeTermSLOModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

/**
 * Mapper for the SLA Template Guarantee Term Model
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class SLATemplateGuaranteeTermMapper extends
		AbstractMapper<GuaranteeTerm, SLATemplateGuaranteeTermModel> {

	@Override
	protected SLATemplateGuaranteeTermModel readFrom(GuaranteeTerm soaInstance) {

		SLATemplateGuaranteeTermModel slaTemplateGuaranteeTermModel = new SLATemplateGuaranteeTermModel(
				soaInstance.getGuaranteeTermName(),
				soaInstance.getGuaranteeTermName());

		// set of properties to show in the form
		slaTemplateGuaranteeTermModel.set(TITLE,
				soaInstance.getGuaranteeTermName());

		// Service Level Objectives
		SLATemplateGuaranteeTermSLOModel slo = new SLATemplateGuaranteeTermSLOModel(
				soaInstance.getGuaranteeTermName(), "Service Level Objectives");
		slo.setGuaranteeTermName(soaInstance.getGuaranteeTermName());
		slo.setKPIName(soaInstance.getKpiName());
		slo.setCustomServiceLevel(soaInstance.getCustomServiceLevel());
		slaTemplateGuaranteeTermModel.setServiceLevelObjectives(slo);

		// Business Level Objectives
		SLATemplateGuaranteeTermBLOModel blo = new SLATemplateGuaranteeTermBLOModel(
				soaInstance.getGuaranteeTermName(), "Business Level Objectives");

		blo.setPenaltyAssessmentInterval(soaInstance
				.getPenaltyAssessmentInterval());
		blo.setPenaltyValueUnit(soaInstance.getPenaltyValueUnit());
		blo.setPenaltyValueExpression(soaInstance.getPenaltyValueExpression());
		blo.setRewardAssessmentInterval(soaInstance
				.getRewardAssessmentInterval());
		blo.setRewardValueUnit(soaInstance.getRewardValueUnit());
		blo.setRewardValueExpression(soaInstance.getRewardValueExpression());

		slaTemplateGuaranteeTermModel.setBusinessLevelObjectives(blo);

		return slaTemplateGuaranteeTermModel;
	}

	@Override
	protected GuaranteeTerm writeTo(GuaranteeTerm soaInstance,
			SLATemplateGuaranteeTermModel frontendModel) {
		// Not required
		throw new NotImplementedException();
	}
}
