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

import com.google.gwt.user.client.rpc.IsSerializable;

import eu.cloud4soa.frontend.commons.client.gxt.DynamicFormModel;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

/**
 * GXT model for a C4S SLA Template
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class SLAContractGuaranteeTermSLOModel extends DynamicFormModel
		implements IsSerializable {

	// Service level objectives
	public final static String GuaranteeTermName = "GuaranteeTermName";
	public final static String KPIName = "KPIName";
	public final static String CustomServiceLevel = "CustomServiceLevel";

	public SLAContractGuaranteeTermSLOModel() {
	}

	public SLAContractGuaranteeTermSLOModel(String key, String value) {
		super(key, value, MetadataMapper.FORM_SLA_CONTRACT_GT_SLO);
	}

	public String getGuaranteeTermName() {
		return get(GuaranteeTermName);
	}

	public void setGuaranteeTermName(String guaranteeTermName) {
		set(GuaranteeTermName, guaranteeTermName);
	}

	public String getKPIName() {
		return get(GuaranteeTermName);
	}

	public void setKPIName(String kPIName) {
		set(KPIName, kPIName);
	}

	public String getCustomServiceLevel() {
		return get(CustomServiceLevel);
	}

	public void setCustomServiceLevel(String customServiceLevel) {
		set(CustomServiceLevel, customServiceLevel);
	}

}
