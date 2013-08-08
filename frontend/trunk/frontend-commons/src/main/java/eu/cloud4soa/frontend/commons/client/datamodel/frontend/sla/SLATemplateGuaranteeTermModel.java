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
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ProgrammingLanguageModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.client.gxt.DynamicFormModel;
import eu.cloud4soa.frontend.commons.client.gxt.WithDescription;
import eu.cloud4soa.frontend.commons.client.gxt.WithTitle;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * GXT model for a C4S SLA Template
 *
 * @author Yosu Gorroñogoitia (Atos)
 */
public class SLATemplateGuaranteeTermModel extends DynamicFormModel implements IsSerializable {

	//Service level objectives
	public final static String SLO = "SLO";
    
    //Business level objectives
	public final static String BLO = "BLO";


    public SLATemplateGuaranteeTermModel() {
    }

    public SLATemplateGuaranteeTermModel(String key, String value) {
        super(key, value, MetadataMapper.FORM_SLA_TEMPLATE_GT);
    }

    public SLATemplateGuaranteeTermSLOModel getServiceLevelObjectives() {
        return get(SLO);
    }

    public void setServiceLevelObjectives(SLATemplateGuaranteeTermSLOModel slo) {
        set(SLO, slo);
    }

    public SLATemplateGuaranteeTermBLOModel getBusinessLevelObjectives() {
        return get(BLO);
    }

    public void setBusinessLevelObjectives(SLATemplateGuaranteeTermBLOModel blo) {
        set(BLO, blo);
    }
   
}
