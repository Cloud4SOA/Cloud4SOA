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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import eu.cloud4soa.frontend.commons.client.gxt.DynamicFormModel;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

/**
 * GXT model for a C4S SLA Contract
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class SLAContractModel extends DynamicFormModel implements
		IsSerializable {

	// Context
	public final static String Context = "Context";

	// Service
	public final static String Service = "Service";

	// Guarantee Terms
	public final static String GuaranteeTerms = "GuaranteeTerms";

	public SLAContractModel() {
	}

	public SLAContractModel(String key, String value) {
		super(key, value, MetadataMapper.FORM_SLA_CONTRACT);
	}

	public List<SLAContractGuaranteeTermModel> getGuaranteeTerms() {
		List<SLAContractGuaranteeTermModel> guaranteeTerms = get(GuaranteeTerms);
		if (guaranteeTerms == null) {
			guaranteeTerms = new ArrayList<SLAContractGuaranteeTermModel>();
			set(GuaranteeTerms, guaranteeTerms);
		}
		return guaranteeTerms;
	}

	public SLAContractContextModel getContext() {
		return get(Context);
	}

	public void setContext(SLAContractContextModel context) {
		set(Context, context);
	}

	public SLAContractServiceModel getService() {
		return get(Service);
	}

	public void setService(SLAContractServiceModel service) {
		set(Service, service);
	}

}
