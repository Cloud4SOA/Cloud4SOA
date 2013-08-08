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

package eu.cloud4soa.frontend.commons.server.services.soa;

import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.ListLoadResult;
import com.google.gwt.user.client.rpc.InvocationException;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import eu.cloud4soa.api.datamodel.core.MatchingPlatform;
import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.datamodel.governance.SlaTemplate;
import eu.cloud4soa.api.soa.PaaSOfferingDiscovery;
import eu.cloud4soa.api.soa.PaaSOfferingRecommendation;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.*;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.ChannelModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.Facet;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.*;
import eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService;
import eu.cloud4soa.frontend.commons.server.services.FacetedSearch;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.PaaSOfferMapper;
import eu.cloud4soa.frontend.commons.server.services.soa.mapping.SLATemplateMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel.AVERAGE_RATING;


/**
 * @author Yosu Gorroñogoitia (Atos)
 */
@SuppressWarnings({"GwtServiceNotRegistered"})
@Transactional
@Component
@Secured("IS_AUTHENTICATED_FULLY")
public class PaaSOfferingDiscoveryServiceImpl extends RemoteServiceServlet implements PaaSOfferingDiscoveryService {

    final Logger logger = LoggerFactory.getLogger(PaaSOfferingDiscoveryServiceImpl.class);

    @Qualifier("paaSOfferingDiscovery")
    @Autowired
    private PaaSOfferingDiscovery paaSOfferingDiscoverySoaService;

    @Qualifier("paaSOfferingRecommendation")
    @Autowired
    private PaaSOfferingRecommendation offeringRecommendationSoaService;

    @Autowired
    private FacetedSearch facetedSearch;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    public ListLoadResult<PaaSOfferingModel> searchForMatchingPlatform(String applicationInstanceId) {
        logger.debug("Invoking searchForMatchingPlatform in SOA PaaSOfferingDiscovery with "
                + " applicationInstanceId: " + applicationInstanceId);
        List<PaaSOfferingModel> matchings = new ArrayList<PaaSOfferingModel>();
        MatchingPlatform mp = null;
        try {
            mp = paaSOfferingDiscoverySoaService.searchForMatchingPlatform(applicationInstanceId);


            Map<PaaSInstance, Float> rankedPaaSInstances = mp.getRankedListPaaSInstances();

            for (PaaSInstance instance : rankedPaaSInstances.keySet()) {
                PaaSOfferingModel offer = new PaaSOfferMapper().from(
                        instance.getPaaSOffering()).toModel();
                offer.setScore(rankedPaaSInstances.get(instance) * 100); //Score as percentage
                offer.setProvider(instance.getProviderTitle());

                // Average Rating
                float averageRating = offeringRecommendationSoaService.getAveragePaaSUserExperienceRate(instance.getPaaSOffering().getUriId());
                if (Double.isNaN(averageRating))
                    averageRating = 0;
                offer.<Integer>set(AVERAGE_RATING, Math.round(averageRating));

                SlaTemplate slaTemplate = mp.getListSlaContract().get(instance);
                if (slaTemplate != null) {
                    SLATemplateModel slaTemplateModel = new SLATemplateMapper()
                            .from(slaTemplate).toModel();
                    offer.setSLATemplate(slaTemplateModel);
                }
                matchings.add(offer);
            }
        } catch (SOAException e) {
            String msg = "An error occurred while searching for matching platforms.";
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }

        return new BaseListLoadResult<PaaSOfferingModel>(matchings);
    }

    @Override
    public ListLoadResult<PaaSOfferingModel> facetedSearchForMatchingPlatform(List<Facet> facets) {
        List<PaaSInstance> results = facetedSearch.facetedSearchSPARQL(facets);

        List<PaaSOfferingModel> matchings = new ArrayList<PaaSOfferingModel>();

        try {
            for (PaaSInstance instance : results) {
                PaaSOfferingModel offer = new PaaSOfferMapper().from(
                        instance.getPaaSOffering()).toModel();

                // There is no SLA template in catalogue browsing (faceted search)
                offer.setSLATemplate(null);

                // Average Rating
                float averageRating = offeringRecommendationSoaService.getAveragePaaSUserExperienceRate(instance.getPaaSOffering().getUriId());
                if (Double.isNaN(averageRating))
                    averageRating = 0;
                offer.<Integer>set(AVERAGE_RATING, Math.round(averageRating));

                offer.setScore(1.0f);// Faceted search score is by default 1.0
                offer.setProvider(instance.getProviderTitle());
                matchings.add(offer);
            }
        } catch (SOAException e) {
            String msg = "An error occurred while searching for matching platforms.";
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }

        return new BaseListLoadResult<PaaSOfferingModel>(matchings);
    }

    @Override
    public PaaSOfferingModel searchForPaaS(String paaSInstanceUriId)
            throws InvocationException {
        PaaSInstance instance = null;
        try {
            instance = paaSOfferingDiscoverySoaService.searchForPaaS(paaSInstanceUriId);
        } catch (SOAException e) {
            String msg = "An error occurred while searching for PaaS offers.";
            logger.error(msg, e);
            throw new RuntimeException(msg, e);
        }

        PaaSOfferingModel offer = new PaaSOfferMapper().from(
                instance.getPaaSOffering()).toModel();
        offer.setProvider(instance.getProviderTitle());
        return offer;
    }


    // Return possible PaaSInstance facets (properties) for search, populated
    // with possible values
    @Override
    public List<Facet> getAvailableFacets() {
        return facetedSearch.getAvailableFacets();
    }

    @Override
    public List<Facet> filterFacets(List<String> offeringIds) {
        return facetedSearch.filterFacets(offeringIds);
    }



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

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList1()
     */
    @Override
    public HardwareComponentModel whiteList1() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList2()
     */
    @Override
    public MeasurementRangeModel whiteList2() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList3()
     */
    @Override
    public MeasurementModel whiteList3() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList4()
     */
    @Override
    public HardwareCategoryModel whiteList4() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList5()
     */
    @Override
    public NumericRangeModel whiteList5() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList6()
     */
    @Override
    public ChannelModel whiteList6() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList7()
     */
    @Override
    public ProgrammingLanguageModel whiteList7() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList8()
     */
    @Override
    public SoftwareCategoryModel whiteList8() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList9()
     */
    @Override
    public SoftwareComponentModel whiteList9() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList10()
     */
    @Override
    public DbConfigurationModel whiteList10() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList11()
     */
    @Override
    public SLATemplateModel whiteList11() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList12()
     */
    @Override
    public SLATemplateGuaranteeTermModel whiteList12() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList13()
     */
    @Override
    public SLAContractServiceModel whiteList13() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList14()
     */
    @Override
    public SLAContractContextModel whiteList14() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList15()
     */
    @Override
    public SLATemplateGuaranteeTermSLOModel whiteList15() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList16()
     */
    @Override
    public SLATemplateGuaranteeTermBLOModel whiteList16() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList17()
     */
    @Override
    public SLATemplateServiceModel whiteList17() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see eu.cloud4soa.frontend.commons.client.services.soa.PaaSOfferingDiscoveryService#whiteList18()
     */
    @Override
    public SLATemplateContextModel whiteList18() {
        // TODO Auto-generated method stub
        return null;
    }

    // private SLATemplateModel getSLATemplate(SlaTemplate slaTemplate) {
    // // return loadSLATemplateFromClasspath("Cloud4SOA_SLAOffer.xml");
    // }

//	/**
//	 * Testing purpose. Loads an XML-based testing SLA Template from classpath
//	 * 
//	 * @param xmlName
//	 * @return
//	 */
//	private String loadSLATemplateFromClasspath(String xmlName) {
//		StringBuilder data = new StringBuilder();
//		String fileContent = "";
//		InputStream in = null;
//		try {
//			in = this.getClass().getResourceAsStream("/" + xmlName);
//			BufferedReader br = new BufferedReader(new InputStreamReader(in));
//
//			while ((fileContent = br.readLine()) != null) {
//				data = data.append(fileContent).append("\n");
//			}
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (in != null)
//				try {
//					in.close();
//				} catch (IOException e) {
//					// Ignored
//				}
//		}
//
//		return data.toString();
//	}

}
