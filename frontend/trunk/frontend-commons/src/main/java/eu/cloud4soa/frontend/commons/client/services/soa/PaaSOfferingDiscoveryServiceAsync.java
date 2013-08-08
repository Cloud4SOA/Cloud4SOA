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
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.InvocationException;
import com.gwt.ss.client.exceptions.GwtSecurityException;

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
 *
 * @author Yosu Gorroñogoitia (Atos)
 */
public interface PaaSOfferingDiscoveryServiceAsync {
    void searchForMatchingPlatform(String applicationInstanceId, AsyncCallback<ListLoadResult<PaaSOfferingModel>> callback);
    void facetedSearchForMatchingPlatform (List<Facet> facets, AsyncCallback<ListLoadResult<PaaSOfferingModel>> callback);
    void getAvailableFacets (AsyncCallback<List<Facet>> callback);
    void filterFacets(List<String> offeringIdes, AsyncCallback<List<Facet>> callback);
	void searchForPaaS(String paaSInstanceUriId, AsyncCallback<PaaSOfferingModel> callback) throws InvocationException;
	
	/*
    The following methods do nothing. For weird reason using EntityMetadata and FieldMetadata classes
    in a service methods signature is the only way to get them included in the serialization white list.
    Usually the GWT compiler put classes in the while list if one of these condition is meet:
     1) The class is part of a GWT-RPC method signature
     2) The class is reachable navigating the properties of a class from 1)
     3) The class has the IsSerializable interface

     Both EntityMetadata and FieldMetadata theoretically meet 2) and 3), however they are not picked up.
     The following useless method allow them to meet 1).
    */
    void whiteList1(AsyncCallback<HardwareComponentModel> async) throws GwtSecurityException;
    void whiteList2(AsyncCallback<MeasurementRangeModel> async) throws GwtSecurityException;
    void whiteList3(AsyncCallback<MeasurementModel> async) throws GwtSecurityException;
    void whiteList4(AsyncCallback<HardwareCategoryModel> async) throws GwtSecurityException;
    void whiteList5(AsyncCallback<NumericRangeModel> async) throws GwtSecurityException;
    void whiteList6(AsyncCallback<ChannelModel> async) throws GwtSecurityException;
    void whiteList7(AsyncCallback<ProgrammingLanguageModel> async) throws GwtSecurityException;
    void whiteList8(AsyncCallback<SoftwareCategoryModel> async) throws GwtSecurityException;
    void whiteList9(AsyncCallback<SoftwareComponentModel> async) throws GwtSecurityException;
    void whiteList10(AsyncCallback<DbConfigurationModel> async) throws GwtSecurityException;
    void whiteList11(AsyncCallback<SLATemplateModel> async) throws GwtSecurityException;
    void whiteList12(AsyncCallback<SLATemplateGuaranteeTermModel> async) throws GwtSecurityException;
    void whiteList13(AsyncCallback<SLAContractServiceModel> async) throws GwtSecurityException;
    void whiteList14(AsyncCallback<SLAContractContextModel> async) throws GwtSecurityException;
    void whiteList15(AsyncCallback<SLATemplateGuaranteeTermSLOModel> async) throws GwtSecurityException;
    void whiteList16(AsyncCallback<SLATemplateGuaranteeTermBLOModel> async) throws GwtSecurityException;
    void whiteList17(AsyncCallback<SLATemplateServiceModel> async) throws GwtSecurityException;
    void whiteList18(AsyncCallback<SLATemplateContextModel> async) throws GwtSecurityException;
}
