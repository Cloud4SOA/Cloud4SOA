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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eu.cloud4soa.frontend.commons.client.services.soa;

import java.util.List;

import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.google.gwt.user.client.rpc.InvocationException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.DbConfigurationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareCategoryModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementRangeModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.NumericRangeModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ProgrammingLanguageModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareCategoryModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.ChannelModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.Facet;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractContextModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractServiceModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateContextModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateGuaranteeTermBLOModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateGuaranteeTermModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateGuaranteeTermSLOModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateServiceModel;

/**
 * @author Yosu Gorroñogoitia (Atos)
 */
@RemoteServiceRelativePath("PaaSOfferingDiscoveryService")
public interface PaaSOfferingDiscoveryService extends RemoteService {
	ListLoadResult<PaaSOfferingModel> searchForMatchingPlatform(String applicationInstanceId);
	ListLoadResult<PaaSOfferingModel> facetedSearchForMatchingPlatform(List<Facet> facets) throws InvocationException;
    List<Facet> getAvailableFacets ();
    List<Facet> filterFacets(List<String> offeringIdes);
    PaaSOfferingModel searchForPaaS(String paaSInstanceUriId) throws InvocationException;
    
    /*
    The following two methods do nothing. For weird reason these classes
    in a service methods signature is the only way to get them included in the serialization white list.
    Usually the GWT compiler put classes in the while list if one of these condition is meet:
     1) The class is part of a GWT-RPC method signature
     2) The class is reachable navigation the properties of a class from 1)
     3) The class has the IsSerializable interface

     These classes theoretically meet 2) and 3), however they are not picked up.
     The following useless method allow them to meet 1).
    */

   HardwareComponentModel whiteList1();
   MeasurementRangeModel whiteList2();
   MeasurementModel whiteList3();
   HardwareCategoryModel whiteList4();
   NumericRangeModel whiteList5();
   ChannelModel whiteList6();
   ProgrammingLanguageModel whiteList7();
   SoftwareCategoryModel whiteList8();
   SoftwareComponentModel whiteList9();
   DbConfigurationModel whiteList10();
   SLATemplateModel whiteList11();
   SLATemplateGuaranteeTermModel whiteList12();
   SLAContractServiceModel whiteList13();
   SLAContractContextModel whiteList14();
   SLATemplateGuaranteeTermSLOModel whiteList15();
   SLATemplateGuaranteeTermBLOModel whiteList16();
   SLATemplateServiceModel whiteList17();
   SLATemplateContextModel whiteList18();
}
