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

import org.apache.commons.lang.NotImplementedException;

import eu.cloud4soa.api.datamodel.governance.SlaPolicy;
import eu.cloud4soa.api.datamodel.governance.SlaPolicy.SlaPenaltyType;
import eu.cloud4soa.api.datamodel.governance.SlaTemplate.ServiceGuaranteeType;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAPolicyModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

/**
 * Mapper for the SLA Policy
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class SLAPolicyMapper extends
		AbstractMapper<SlaPolicy, SLAPolicyModel> {


	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper#readFrom(java.lang.Object)
	 */
	@Override
	protected SLAPolicyModel readFrom(SlaPolicy soaInstance) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	/* (non-Javadoc)
	 * @see eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper#writeTo(java.lang.Object, eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData)
	 */
	@Override
	public SlaPolicy writeTo(SlaPolicy penalty, SLAPolicyModel frontendModel) {
		penalty.setMetric_name(ServiceGuaranteeType.valueOf(frontendModel.getMetricType()));
		//FIXME penalty.setTime_interval(Integer.parseInt(frontendModel.getDuration()));
		penalty.setBreach(Integer.parseInt(frontendModel.getNumberOfBreaches()));
		penalty.setValue_expr(SlaPenaltyType.valueOf(frontendModel.getExpression())); //TODO change type
		return penalty;
	}
}
