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

import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.soa.AnnouncementModule;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.apache.cxf.jaxrs.provider.ProviderFactory;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vins
 */
public class AnnouncementModuleClient {
    final Logger logger = LoggerFactory.getLogger(getClass());
    
    final String RS_URI = "AnnouncementModuleRS/";

    public AnnouncementModuleClient() {}

    /**
     * @return the BASE_URI
     */
    public String getBASE_URI() {
        return System.getProperty("cloud4soa.baseUrl")+RS_URI;
    }
    
    public String storePaaSInstance(PaaSInstance paaSInstance, String paaSUserUriId) {  
        String rsUri = getBASE_URI()+"storePaaSInstance";
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
        registerJsonProvider();

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("paaSInstance", MediaType.APPLICATION_JSON , paaSInstance));

        atts.add(new Attachment("userInstanceUriId", MediaType.TEXT_PLAIN , paaSUserUriId));
        
        Response response = client.post(new MultipartBody(atts));
        String paaSInstanceUriId = null;
        try {
            paaSInstanceUriId = IOUtils.readStringFromStream((InputStream)response.getEntity());
            logger.debug("paaSInstanceUriId: "+paaSInstanceUriId);
        } catch (IOException ex) {
            logger.error("Error reading the REST response: "+ex.getMessage());
        }
        return paaSInstanceUriId;
    }
    
    public String storeTurtlePaaSProfile(String paasProfile, String userInstanceUriId){
        String rsUri = getBASE_URI()+"storeTurtlePaaSProfile";
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
        registerJsonProvider();

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("paasProfile", MediaType.TEXT_PLAIN , paasProfile));

        atts.add(new Attachment("userInstanceUriId", MediaType.TEXT_PLAIN , userInstanceUriId));
        
        Response response = client.post(new MultipartBody(atts));
        String paasInstanceUriId = null;
        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.CREATED){
            try {
                paasInstanceUriId = IOUtils.readStringFromStream((InputStream)response.getEntity());
                logger.debug("paasInstanceUriId: "+paasInstanceUriId);
            } catch (IOException ex) {
                logger.error("Error reading the REST response: "+ex.getMessage());
            }
        }
        return paasInstanceUriId;
    }
    
    public PaaSInstance getPaaSInstance(String paaSInstanceUriId) throws SOAException {
        String rsUri = getBASE_URI();
        
        AnnouncementModule announcementModule = JAXRSClientFactory.create(rsUri, AnnouncementModule.class);
        PaaSInstance retrievedPaaSInstance = null;

        retrievedPaaSInstance = announcementModule.getPaaSInstance(paaSInstanceUriId);

        logger.debug("retrievedPaaSInstance: "+retrievedPaaSInstance);
        return retrievedPaaSInstance;
    }
    
    public List<PaaSInstance> retrieveAllPaaSInstances(String paaSUserUriId) throws SOAException{
        String rsUri = getBASE_URI();
        
        AnnouncementModule announcementModule = JAXRSClientFactory.create(rsUri, AnnouncementModule.class);
        List<PaaSInstance> retrieveAllPaaSInstances = null;

        retrieveAllPaaSInstances = announcementModule.retrieveAllPaaSInstances(paaSUserUriId);

        for (PaaSInstance retrievedPaaSInstance : retrieveAllPaaSInstances) {
            logger.debug("retrievedPaaSInstance: "+retrievedPaaSInstance);
        }
        return retrieveAllPaaSInstances;
    }
    
    public void updatePaaSInstance(PaaSInstance modifiedPaaSInstance) throws SOAException{
        String rsUri = getBASE_URI();
        registerJsonProvider();
        
        AnnouncementModule announcementModule = JAXRSClientFactory.create(rsUri, AnnouncementModule.class);

        announcementModule.updatePaaSInstance(modifiedPaaSInstance);
    }
    
    public void removePaaSInstance(String paasInstanceUriId) throws SOAException{
        String rsUri = getBASE_URI();
        registerJsonProvider();
        
        AnnouncementModule announcementModule = JAXRSClientFactory.create(rsUri, AnnouncementModule.class);

        announcementModule.removePaaSInstance(paasInstanceUriId);
    }

    private void registerJsonProvider() {
        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);
    }
}
