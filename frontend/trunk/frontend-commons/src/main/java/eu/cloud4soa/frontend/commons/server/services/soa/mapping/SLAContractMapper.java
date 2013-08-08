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
import eu.cloud4soa.api.datamodel.governance.SlaContract;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractContextModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractGuaranteeTermModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractServiceModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

/**
 * Mapper for the SLA Template
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class SLAContractMapper extends
		AbstractMapper<SlaContract, SLAContractModel> {

	@Override
	protected SLAContractModel readFrom(SlaContract soaInstance) {

		SLAContractModel slaContractModel = new SLAContractModel(
				soaInstance.getId().toString(), soaInstance.getTemplateName());

		// set of properties to show in the form
		slaContractModel.set(TITLE, soaInstance.getTemplateName());

		// Context
		SLAContractContextModel sLAContractContextModel = new SLAContractContextModel(
				soaInstance.getId().toString(), "SLA Contract Context");
		sLAContractContextModel.setAgreementInitiator(soaInstance
				.getAgreementInitiator());
		sLAContractContextModel.setServiceProvider(soaInstance
				.getServiceProvider());
		sLAContractContextModel.setExpirationTime(soaInstance
				.getExpirationTime());
		slaContractModel.setContext(sLAContractContextModel);

		// Service
		SLAContractServiceModel sLAContractServiceModel = new SLAContractServiceModel(
				soaInstance.getId().toString(), "SLA Template Service");
		sLAContractServiceModel.setServiceName(null);
		sLAContractServiceModel.setServiceProvider(soaInstance
				.getServiceProvider());
		slaContractModel.setService(sLAContractServiceModel);

		// Guarantee Terms
		List<SLAContractGuaranteeTermModel> gts = slaContractModel
				.getGuaranteeTerms();

		for (GuaranteeTerm gt : soaInstance.getGuaranteeTerms())
			gts.add(new SLAContractGuaranteeTermMapper().from(gt).toModel());

		return slaContractModel;
	}

	@Override
	protected SlaContract writeTo(SlaContract soaInstance,
			SLAContractModel frontendModel) {
		// Not required
		throw new NotImplementedException();
	}
}
