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
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractGuaranteeTermBLOModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractGuaranteeTermModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractGuaranteeTermSLOModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

/**
 * Mapper for the SLA Template Guarantee Term Model
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class SLAContractGuaranteeTermMapper extends
		AbstractMapper<GuaranteeTerm, SLAContractGuaranteeTermModel> {

	@Override
	protected SLAContractGuaranteeTermModel readFrom(GuaranteeTerm soaInstance) {

		SLAContractGuaranteeTermModel slaContractGuaranteeTermModel = new SLAContractGuaranteeTermModel(
				soaInstance.getGuaranteeTermName(),
				soaInstance.getGuaranteeTermName());

		// set of properties to show in the form
		slaContractGuaranteeTermModel.set(TITLE,
				soaInstance.getGuaranteeTermName());

		// Service Level Objectives
		SLAContractGuaranteeTermSLOModel slo = new SLAContractGuaranteeTermSLOModel(
				soaInstance.getGuaranteeTermName(), "Service Level Objectives");
		slo.setGuaranteeTermName(soaInstance.getGuaranteeTermName());
		slo.setKPIName(soaInstance.getKpiName());
		slo.setCustomServiceLevel(soaInstance.getCustomServiceLevel());
		slaContractGuaranteeTermModel.setServiceLevelObjectives(slo);

		// Business Level Objectives
		SLAContractGuaranteeTermBLOModel blo = new SLAContractGuaranteeTermBLOModel(
				soaInstance.getGuaranteeTermName(), "Business Level Objectives");

		blo.setPenaltyAssessmentInterval(soaInstance
				.getPenaltyAssessmentInterval());
		blo.setPenaltyValueUnit(soaInstance.getPenaltyValueUnit());
		blo.setPenaltyValueExpression(soaInstance.getPenaltyValueExpression());
		blo.setRewardAssessmentInterval(soaInstance
				.getRewardAssessmentInterval());
		blo.setRewardValueUnit(soaInstance.getRewardValueUnit());
		blo.setRewardValueExpression(soaInstance.getRewardValueExpression());

		slaContractGuaranteeTermModel.setBusinessLevelObjectives(blo);

		return slaContractGuaranteeTermModel;
	}

	@Override
	protected GuaranteeTerm writeTo(GuaranteeTerm soaInstance,
			SLAContractGuaranteeTermModel frontendModel) {
		// Not required
		throw new NotImplementedException();
	}
}
