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

import eu.cloud4soa.api.datamodel.governance.SLAViolation;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAViolationModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

/**
 * Mapper for the SLA Template
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class SLAViolationMapper extends
		AbstractMapper<SLAViolation, SLAViolationModel> {

	@Override
	protected SLAViolationModel readFrom(SLAViolation soaInstance) {

		SLAViolationModel slaViolationModel = new SLAViolationModel(
				soaInstance.getId().toString(), soaInstance.getMetric_name());
		
		
		slaViolationModel.set(SLAViolationModel.EVENT_ID, soaInstance.getId());
		slaViolationModel.set(SLAViolationModel.METRIC, soaInstance.getMetric_name());
		slaViolationModel.set(SLAViolationModel.EXPECTED_VALUE, soaInstance.getExpected_value());
		slaViolationModel.set(SLAViolationModel.ACTUAL_VALUE, soaInstance.getActual_value());
		slaViolationModel.set(SLAViolationModel.APPLICATION_ID, soaInstance.getApplication_instance_uri_id());
		slaViolationModel.set(SLAViolationModel.APPLICATION, soaInstance.getApplication_instance_uri_id()); //FIXME Obtain application name from id
		slaViolationModel.set(SLAViolationModel.PROVIDER, soaInstance.getApplication_instance_uri_id()); //FIXME Obtain provider name from application id
		slaViolationModel.set(SLAViolationModel.DATE, soaInstance.getDate_and_time());
		
		return slaViolationModel;
	}

	@Override
	protected SLAViolation writeTo(SLAViolation soaInstance,
			SLAViolationModel frontendModel) {
		// Not required
		throw new NotImplementedException();
	}
}
