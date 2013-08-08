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
public class SLATemplateModel extends DynamicFormModel implements IsSerializable {

	//Context
	public final static String Context = "Context";

    //Service
    public final static String Service = "Service";
    
    //Guarantee Terms
    public final static String GuaranteeTerms = "GuaranteeTerms";

    public SLATemplateModel() {
    }

    public SLATemplateModel(String key, String value) {
        super(key, value, MetadataMapper.FORM_SLA_TEMPLATE);
    }

    public List<SLATemplateGuaranteeTermModel> getGuaranteeTerms() {
        List<SLATemplateGuaranteeTermModel> guaranteeTerms = get(GuaranteeTerms);
        if (guaranteeTerms == null) {
        	guaranteeTerms = new ArrayList<SLATemplateGuaranteeTermModel>();
            set(GuaranteeTerms, guaranteeTerms);
        }
        return guaranteeTerms;
    }



    public SLATemplateContextModel getContext() {
        return get(Context);
    }


    public void setContext(SLATemplateContextModel context) {
        set(Context, context);
    }

    public SLATemplateServiceModel getService() {
        return get(Service);
    }


    public void setService(SLATemplateServiceModel service) {
        set(Service, service);
    }

}
