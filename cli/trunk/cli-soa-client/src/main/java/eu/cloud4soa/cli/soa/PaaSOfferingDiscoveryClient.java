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
package eu.cloud4soa.cli.soa;

import eu.cloud4soa.api.datamodel.core.MatchingPlatform;
import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.datamodel.core.PaaSProviderDetails;
import eu.cloud4soa.api.soa.PaaSOfferingDiscovery;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import java.util.List;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vins
 */
public class PaaSOfferingDiscoveryClient {
    final Logger logger = LoggerFactory.getLogger(getClass());
    
    final String RS_URI = "PaaSOfferingDiscoveryRS/";

    public PaaSOfferingDiscoveryClient() {}
    
    /**
     * @return the BASE_URI
     */
    public String getBASE_URI() {
        return System.getProperty("cloud4soa.baseUrl")+RS_URI;
    }
    
    public MatchingPlatform searchForMatchingPlatform(String applicationInstanceUriId) throws SOAException{
        String rsUri = getBASE_URI();
        
        PaaSOfferingDiscovery paaSOfferingDiscovery = JAXRSClientFactory.create(rsUri, PaaSOfferingDiscovery.class);
        MatchingPlatform matchingPlatforms = paaSOfferingDiscovery.searchForMatchingPlatform(applicationInstanceUriId);
        return matchingPlatforms;
    }
    
    public PaaSInstance searchForPaaS(String paaSInstanceUriId) throws SOAException{
        String rsUri = getBASE_URI();
        
        PaaSOfferingDiscovery paaSOfferingDiscovery = JAXRSClientFactory.create(rsUri, PaaSOfferingDiscovery.class);
        PaaSInstance paaSInstance = paaSOfferingDiscovery.searchForPaaS(paaSInstanceUriId);
        return paaSInstance;
    }
        
    public PaaSProviderDetails getPaaSProviderDetails(String paaSInstanceUriId) throws SOAException{
        String rsUri = getBASE_URI();
        
        PaaSOfferingDiscovery paaSOfferingDiscovery = JAXRSClientFactory.create(rsUri, PaaSOfferingDiscovery.class);
        PaaSProviderDetails paaSProviderDetails = paaSOfferingDiscovery.getPaaSProviderDetails(paaSInstanceUriId);
        return paaSProviderDetails;
    }
            
    public List<PaaSInstance> getAllAvailablePaaSInstances() throws SOAException{
        String rsUri = getBASE_URI();
        
        PaaSOfferingDiscovery paaSOfferingDiscovery = JAXRSClientFactory.create(rsUri, PaaSOfferingDiscovery.class);
        List<PaaSInstance> allAvailablePaaSInstances = paaSOfferingDiscovery.getAllAvailablePaaSInstances();
        return allAvailablePaaSInstances;
    }
    
}
