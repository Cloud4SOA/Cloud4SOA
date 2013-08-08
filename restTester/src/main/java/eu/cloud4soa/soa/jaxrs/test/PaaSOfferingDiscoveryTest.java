/*
 *  Copyright 2013 Cloud4SOA, www.cloud4soa.eu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cloud4soa.soa.jaxrs.test;

import eu.cloud4soa.api.datamodel.core.MatchingPlatform;
import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.soa.PaaSOfferingDiscovery;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vins
 * modified by: zeginis
 */
public class PaaSOfferingDiscoveryTest {
    final String BASE_URI = "http://localhost:8080/services/REST/PaaSOfferingDiscoveryRS/";
 //   private String paaSInstanceName = "CloudBees";
    private static final Logger logger = LoggerFactory.getLogger(PaaSOfferingDiscoveryTest.class);
    final String[] applicationUriIds = {
        "AppBox.AppBox",
        "AppComplex.AppComplex",
        "AppComputeArchitecture.AppComputeArchitecture",
        "AppComputeCache.AppComputeCache",
        "AppComputeCores.AppComputeCores",
        "AppComputeMemory.AppComputeMemory",
        "AppComputePowerFactor.AppComputePowerFactor",
        "AppComputePowerFactorReq.AppComputePowerFactorReq",
        "AppComputePowerFactorHTTPReq.AppComputePowerFactorHTTPReq",
        "AppComputingScalingFactor.AppComputingScalingFactor",
        "AppDBcache.AppDBcache",
        "AppDBcapacity.AppDBcapacity",
        "AppNetworkBandwidth.AppNetworkBandwidth",
        "AppNetworkLatency.AppNetworkLatency",
        "AppPreferencesRanking.AppPreferencesRanking",
        "AppPreferences.AppPreferences",
        "AppProgrammingLanguage.AppProgrammingLanguage",
        "AppProgrammingLanguageDB.AppProgrammingLanguageDB",
        "AppProgrammingLanguagePython.AppProgrammingLanguagePython",
        "AppProgrammingLanguageBackwardsCompatible.AppProgrammingLanguageBackwardsCompatible",
        "AppQoSlatency.AppQoSlatency",
        "AppQoSuptime.AppQoSuptime",
        "AppRequirements.AppRequirements",
        "AppRequirementsAndPreferences.AppRequirementsAndPreferences",
        "AppStorageBandwidth.AppStorageBandwidth",
        "AppStorageCapacity.AppStorageCapacity",
        "AppSWcomponent.AppSWcomponent",
        "AppWebScalingFactor.AppWebScalingFactor",
        "BSCW"};

    public static void main(String[] args) {
        PaaSOfferingDiscoveryTest pdt = new PaaSOfferingDiscoveryTest();
     //   try {
     //       pdt.getAllAvailablePaaSInstances();
     //   } catch (SOAException ex) {
     //       logger.error(ex.getMessage());
     //   }
        try {
            pdt.searchForMatchingPlatform();
        } catch (SOAException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void searchForMatchingPlatform() throws SOAException {
        logger.info("******SearchForMatchingPlatform******");
        PaaSOfferingDiscovery paaSOfferingDiscovery = JAXRSClientFactory.create(BASE_URI, PaaSOfferingDiscovery.class);
        //String applicationUriId = initializer.getApplicationInstanceUriId();
        for (int i = 0; i < applicationUriIds.length; i++) {
            String appUriId = applicationUriIds[i];
            logger.info("Searching for application with UriID: " + appUriId);
            MatchingPlatform searchForMatchingPlatform = paaSOfferingDiscovery.searchForMatchingPlatform(appUriId);
            Map<PaaSInstance,Float> listPaaSInstance = searchForMatchingPlatform.getRankedListPaaSInstances();
            if (listPaaSInstance != null) {
                for (PaaSInstance paaSInstance : listPaaSInstance.keySet()) {
                    logger.info("matching paaSInstance : " + paaSInstance.getUriId() +", ranking: " +listPaaSInstance.get(paaSInstance));
                }
            }                  
        }
        logger.info("*************************************");
    }
    /*
    public void searchForPaaS() {
    String paaSInstanceUriId = initializer.getPaaSInstanceUriId(paaSInstanceName);
    PaaSOfferingDiscovery paaSOfferingDiscovery = JAXRSClientFactory.create(BASE_URI, PaaSOfferingDiscovery.class);
    PaaSInstance retrievedPaaSInstance = paaSOfferingDiscovery.searchForPaaS(paaSInstanceUriId);
    System.out.println(paaSInstanceName + " retrievedPaaSInstance : " + retrievedPaaSInstance);
    }*/

    public void getAllAvailablePaaSInstances() throws SOAException {
        logger.info("*****getAllAvailablePaaSInstances****");
        PaaSOfferingDiscovery paaSOfferingDiscovery = JAXRSClientFactory.create(BASE_URI, PaaSOfferingDiscovery.class);
        List<PaaSInstance> allAvailablePaaSInstances = paaSOfferingDiscovery.getAllAvailablePaaSInstances();
        for (PaaSInstance paaSInstance : allAvailablePaaSInstances) {
            logger.info("available paaSInstance : " + paaSInstance);
        }
         logger.info("*************************************");
    }
}
