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
public class SLAContractGuaranteeTermBLOModel extends DynamicFormModel
		implements IsSerializable {

	// Business level objectives
	public final static String PenaltyAssessmentInterval = "PenaltyAssessmentInterval";
	public final static String PenaltyValueUnit = "PenaltyValueUnit";
	public final static String PenaltyValueExpression = "PenaltyValueExpression";

	public final static String RewardAssessmentInterval = "RewardAssessmentInterval";
	public final static String RewardValueUnit = "RewardValueUnit";
	public final static String RewardValueExpression = "RewardValueExpression";

	public SLAContractGuaranteeTermBLOModel() {
	}

	public SLAContractGuaranteeTermBLOModel(String key, String value) {
		super(key, value, MetadataMapper.FORM_SLA_CONTRACT_GT_BLO);
	}

	public String getPenaltyAssessmentInterval() {
		return get(PenaltyAssessmentInterval);
	}

	public void setPenaltyAssessmentInterval(String penaltyAssessmentInterval) {
		set(PenaltyAssessmentInterval, penaltyAssessmentInterval);
	}

	public String getPenaltyValueUnit() {
		return get(PenaltyValueUnit);
	}

	public void setPenaltyValueUnit(String penaltyValueUnit) {
		set(PenaltyValueUnit, penaltyValueUnit);
	}

	public String getPenaltyValueExpression() {
		return get(PenaltyValueExpression);
	}

	public void setPenaltyValueExpression(String penaltyValueExpression) {
		set(PenaltyValueExpression, penaltyValueExpression);
	}

	public String getRewardAssessmentInterval() {
		return get(RewardAssessmentInterval);
	}

	public void setRewardAssessmentInterval(String rewardAssessmentInterval) {
		set(RewardAssessmentInterval, rewardAssessmentInterval);
	}

	public String getRewardValueUnit() {
		return get(RewardValueUnit);
	}

	public void setRewardValueUnit(String rewardValueUnit) {
		set(RewardValueUnit, rewardValueUnit);
	}

	public String getRewardValueExpression() {
		return get(RewardValueExpression);
	}

	public void setRewardValueExpression(String rewardValueExpression) {
		set(RewardValueExpression, rewardValueExpression);
	}
}
