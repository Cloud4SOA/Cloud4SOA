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

import java.util.List;

import org.apache.commons.lang.NotImplementedException;

import eu.cloud4soa.api.datamodel.governance.GuaranteeTerm;
import eu.cloud4soa.api.datamodel.governance.SlaTemplate;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateContextModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateGuaranteeTermModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateServiceModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

/**
 * Mapper for the SLA Template
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class SLATemplateMapper extends
		AbstractMapper<SlaTemplate, SLATemplateModel> {

	@Override
	protected SLATemplateModel readFrom(SlaTemplate soaInstance) {

		SLATemplateModel slaTemplateModel = new SLATemplateModel(
				soaInstance.getId().toString(), soaInstance.getTemplateName());

		// set of properties to show in the form
		slaTemplateModel.set(TITLE, soaInstance.getTemplateName());

		// Context
		SLATemplateContextModel sLATemplateContextModel = new SLATemplateContextModel(
				soaInstance.getId().toString(), "SLA Template Context");
		sLATemplateContextModel.setAgreementInitiator(soaInstance
				.getAgreementInitiator());
		sLATemplateContextModel.setServiceProvider(soaInstance
				.getServiceProvider());
		sLATemplateContextModel.setExpirationTime(soaInstance
				.getExpirationTime());
		slaTemplateModel.setContext(sLATemplateContextModel);

		// Service
		SLATemplateServiceModel sLATemplateServiceModel = new SLATemplateServiceModel(
				soaInstance.getId().toString(), "SLA Template Service");
		sLATemplateServiceModel.setServiceName(null);
		sLATemplateServiceModel.setServiceProvider(soaInstance
				.getServiceProvider());
		slaTemplateModel.setService(sLATemplateServiceModel);

		// Guarantee Terms
		List<SLATemplateGuaranteeTermModel> gts = slaTemplateModel
				.getGuaranteeTerms();

		for (GuaranteeTerm gt : soaInstance.getGuaranteeTerms())
			gts.add(new SLATemplateGuaranteeTermMapper().from(gt).toModel());

		return slaTemplateModel;
	}

	@Override
	protected SlaTemplate writeTo(SlaTemplate soaInstance,
			SLATemplateModel frontendModel) {
		// Not required
		throw new NotImplementedException();
	}
}
