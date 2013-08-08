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

import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import eu.cloud4soa.api.datamodel.repository.QueryResultTable;
import eu.cloud4soa.api.soa.ModelManager;
import eu.cloud4soa.api.util.exception.SparqlQueryException;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
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
public class ModelManagerClient {
    final Logger logger = LoggerFactory.getLogger(getClass());
    
    final String RS_URI = "ModelManagerRS/";

    public ModelManagerClient() {}

    /**
     * @return the BASE_URI
     */
    public String getBASE_URI() {
        return System.getProperty("cloud4soa.baseUrl")+RS_URI;
    }
    
    public String storeApplicationProfile(ApplicationInstance applicationInstance, String userInstanceUriId){
        String rsUri = getBASE_URI()+"storeApplicationProfile";
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
        registerJsonProvider();

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("applicationInstance", MediaType.APPLICATION_JSON , applicationInstance));

        atts.add(new Attachment("userInstanceUriId", MediaType.TEXT_PLAIN , userInstanceUriId));
        
        Response response = client.post(new MultipartBody(atts));
        String applicationInstanceUriId = null;
        try {
            applicationInstanceUriId = IOUtils.readStringFromStream((InputStream)response.getEntity());
            logger.debug("applicationInstanceUriId: "+applicationInstanceUriId);
            
        } catch (IOException ex) {
            logger.error("Error reading the REST response: "+ex.getMessage());
        }
        return applicationInstanceUriId;
    }
    
    public void updateApplicationProfile(ApplicationInstance modifiedApplicationInstance) throws SOAException{
        String rsUri = getBASE_URI();
        registerJsonProvider();
        
        ModelManager modelManager = JAXRSClientFactory.create(rsUri, ModelManager.class);
        modelManager.updateApplicationProfile(modifiedApplicationInstance);
    }
    
    public void removeApplicationProfile(String applicationInstanceUriId) throws SOAException{
        String rsUri = getBASE_URI();
        
        ModelManager modelManager = JAXRSClientFactory.create(rsUri, ModelManager.class);
        modelManager.removeApplicationProfile(applicationInstanceUriId);
    }
    
    public List<ApplicationInstance> retrieveAllApplicationProfile(String userInstanceUriId) throws SOAException{
        String rsUri = getBASE_URI();
        ModelManager modelManager = JAXRSClientFactory.create(rsUri, ModelManager.class);
        List<ApplicationInstance> applicationProfiles = modelManager.retrieveAllApplicationProfile(userInstanceUriId);
        return applicationProfiles; 
    }   
    
    public QueryResultTable sparqlSelect(String sparqlQuery){
        String rsUri = getBASE_URI();
        registerJsonProvider();
        QueryResultTable sparqlSelect = null;
        ModelManager modelManager = JAXRSClientFactory.create(rsUri, ModelManager.class);
        try {
            sparqlSelect = modelManager.sparqlSelect(sparqlQuery);
        } catch (SparqlQueryException ex) {
           logger.error("SparqlQueryException: "+ex);
        }
        return sparqlSelect;
    }
    
    public String storeTurtleApplicationProfile(String applicationProfile, String userInstanceUriId){
        String rsUri = getBASE_URI()+"storeTurtleApplicationProfile";
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
        registerJsonProvider();

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("applicationProfile", MediaType.TEXT_PLAIN , applicationProfile));

        atts.add(new Attachment("userInstanceUriId", MediaType.TEXT_PLAIN , userInstanceUriId));
        
        Response response = client.post(new MultipartBody(atts));
        String applicationInstanceUriId = null;
        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.CREATED){
            try {
                applicationInstanceUriId = IOUtils.readStringFromStream((InputStream)response.getEntity());
                logger.debug("applicationInstanceUriId: "+applicationInstanceUriId);
            } catch (IOException ex) {
                logger.error("Error reading the REST response: "+ex.getMessage());
            }
        }
        return applicationInstanceUriId;
    }
    
    private void registerJsonProvider() {
        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);
    }
    
}
