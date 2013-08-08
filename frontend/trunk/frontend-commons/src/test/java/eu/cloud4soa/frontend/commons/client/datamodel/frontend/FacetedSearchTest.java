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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.activation.UnsupportedDataTypeException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.extjs.gxt.ui.client.data.ListLoadResult;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.Facet;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.Facet.QueryType;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.FacetValue;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.server.services.soa.PaaSOfferingDiscoveryServiceImpl;

//@RunWith(SpringJUnit4ClassRunner.class)
////@ContextConfiguration(locations = {"classpath:UserManagementCtx.xml", "classpath:PaaSOfferingDiscoveryCtx.xml","classpath:AnnouncementModuleCtx.xml"})
//@ContextConfiguration(locations = {"classpath:META-INF/soa.xml"})
public class FacetedSearchTest {
	// private String userInstanceId;
	// List<eu.cloud4soa.api.datamodel.core.PaaSInstance> paasInstances;
	// @Autowired
	// private UserManagementAndSecurityModule userManagementAndSecurityModule;
	// @Autowired
	// private AnnouncementModule announcementModule;
	// @Autowired
	// private PaaSOfferingDiscovery paaSOfferingDiscovery;

	PaaSOfferingDiscoveryServiceImpl discovery;

	@Before
	public void setUp() throws FileNotFoundException,
			UnsupportedDataTypeException {
		// createPaasInstances();
		discovery = new PaaSOfferingDiscoveryServiceImpl();
		// discovery.setAllPaaSInstances(paasInstances);
	}

	@Test
	@Ignore
	public void getAvailableFacetsTest() {
		List<Facet> facets = discovery.getAvailableFacets();
		Assert.assertNotNull(facets);
	}

	@Test
	@Ignore
	public void facetedSearchTest() {
		// Assert.assertNotNull(paasInstances);

		// discovery.setPaaSOfferingDiscoverySoaService(paaSOfferingDiscovery);

		List<Facet> facets = new ArrayList<Facet>();

//		 String[] languages = new String[]{"Java"};
//		 PaaSFacet facetLanguage = new PaaSFacet(PaaSFacetType.TECHNOLOGIES,
//		 Arrays.asList(languages));
//		 facets.add(facetLanguage);

//		 String[] channels = new String[]{"CLI", "API"};
//		 PaaSFacet facetChannel = new PaaSFacet(PaaSFacetType.CHANNELS,
//		 Arrays.asList(channels));
//		 facets.add(facetChannel);

//		String[] tools = new String[] { "Google" };
//		PaaSFacet facetTools = new PaaSFacet(PaaSFacetType.TOOLS,
//				Arrays.asList(tools));
//		facets.add(facetTools);
		
		String type = "http://www.cloud4soa.eu/v0.1/paas-model#providedByPaaSProvider";
		QueryType queryType = QueryType.COMPONENT_TITLE;
		List<FacetValue> values = new ArrayList<FacetValue>();
		values.add (new FacetValue("CloudBees", ""));
		values.add (new FacetValue("Microsoft", ""));
		Facet facetProviders = new Facet(type, null, "", "", queryType, values);
		facets.add(facetProviders);

		ListLoadResult<PaaSOfferingModel> offerings = discovery
				.facetedSearchForMatchingPlatform(facets);

		System.out
				.print("REPORT: Searching for PaaS Offering that matches facets: ");
		for (Facet f : facets) {
			System.out.print("Facet (" + f.getType() + "): " + f.getValues());
		}
		System.out.println();
		System.out.print("REPORT: Results obtained: " + offerings.getData().size());
		for (PaaSOfferingModel offering : offerings.getData()) {
			System.out.print(offering);
		}
		System.out.println();
		Assert.assertNotNull(offerings);

	}

	// private void createPaasInstances() throws UnsupportedDataTypeException {
	// // Create PaaS Instances
	// PaaSInstanceTest paaSInstanceTest = new PaaSInstanceTest();
	// paasInstances =
	// paaSInstanceTest.createListCorePaaSInstances();
	//
	// // Store them
	// for (eu.cloud4soa.api.datamodel.core.PaaSInstance instance :
	// paasInstances) {
	// userInstanceId =
	// createTestUserInstance(instance.getPaaSProviderInstance());
	// announcementModule.storePaaSInstance(instance, userInstanceId);
	// }
	//
	// // Read all existing PaaS instances
	// List<PaaSInstance> paasInstances =
	// paaSOfferingDiscovery.getAllAvailablePaaSInstances();
	//
	// Assert.assertTrue(paasInstances != null && paasInstances.size() != 0);
	// }
	//
	// private String createTestUserInstance(PaaSProviderInstance
	// paaSProviderInstance) {
	// PaaSUserInstance paaSUserInstance = new PaaSUserInstance();
	// paaSUserInstance.setFirstName("Yosu");
	// paaSUserInstance.setFamilyname("Gorroñogoitia");
	// paaSUserInstance.setAccountname("yosu");
	// paaSUserInstance.setGeekcode("yosu");
	// paaSUserInstance.setSurname("Gorroñogoitia");
	// Calendar calendar = Calendar.getInstance(Locale.ITALY);
	// calendar.set(1967, 3, 11);
	// paaSUserInstance.setBirthday(Calendar.getInstance());
	// paaSUserInstance.setCloud4SoaAccountUriId("yosu");
	// paaSUserInstance.setAccountname("yosu");
	// // cloud4SoaAccount.setUriId("http:www.cloud4soa.eu/yosu#");
	//
	// paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);
	//
	// Response resp =
	// userManagementAndSecurityModule.createNewAccount(paaSUserInstance);
	// String userId = (String) resp.getEntity();
	// return userId;
	//
	// }
}
