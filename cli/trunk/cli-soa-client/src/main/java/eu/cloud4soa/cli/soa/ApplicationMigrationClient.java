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

import eu.cloud4soa.api.soa.ApplicationMigration;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.Client;
import org.apache.cxf.jaxrs.client.ClientWebApplicationException;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.ServerWebApplicationException;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.apache.cxf.transport.http.HTTPConduit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vins
 */
public class ApplicationMigrationClient {
    final Logger logger = LoggerFactory.getLogger(getClass());
    
    final String RS_URI = "ApplicationMigrationRS/";

    public ApplicationMigrationClient() {}

    /**
     * @return the BASE_URI
     */
    public String getBASE_URI() {
        return System.getProperty("cloud4soa.baseUrl")+RS_URI;
    }
    
    public boolean migrateApplication(String applicationInstanceUriId, String newPaaSInstanceUriId, InputStream is) throws SOAException {
        String rsUri = getBASE_URI()+"migrateApplication";
        boolean returnValue = false;
        
        WebClient client = WebClient.create(rsUri);
        HTTPConduit conduit = WebClient.getConfig(client).getHttpConduit();
        conduit.getClient().setReceiveTimeout(1000000);
        conduit.getClient().setConnectionTimeout(1000000);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
        // POST the request
        List<Attachment> atts = new LinkedList<Attachment>();
        atts.add(new Attachment("applicationInstanceUriId",  MediaType.TEXT_PLAIN, applicationInstanceUriId));
        atts.add(new Attachment("newPaaSInstanceUriId", MediaType.TEXT_PLAIN, newPaaSInstanceUriId));
        atts.add(new Attachment("applicationArchive", MediaType.APPLICATION_OCTET_STREAM, is));
        Response response = null;
        
        
        try{
            response = client.post(new MultipartBody(atts));
            if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.OK){
                try {
                    System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response.getEntity()));
                    returnValue=true;
                } catch (IOException ex) {
                    logger.error("Error reading the REST response: "+ex.getMessage());
                }
            }
        } catch(ClientWebApplicationException cwe){
            logger.error("Ploblem performing Application migration request: "+cwe.getMessage());
        } catch(ServerWebApplicationException cwe){
            logger.error("Error performing Application migration request");
            throw new SOAException(Response.Status.fromStatusCode(cwe.getStatus()), cwe.getMessage());
        }       
        
        try {
            is.close();
        } catch (IOException ex) {
            logger.error("Error closing inputStream: "+ex.getMessage());
        }
        
        return returnValue;
    }
    
    public boolean migrateDatabases(String applicationInstanceUriId, String newPaaSInstanceUriId) throws SOAException {
        String rsUri = getBASE_URI()+"migrateDatabases";
        boolean returnValue = false;
        
        WebClient client = WebClient.create(rsUri);
        HTTPConduit conduit = WebClient.getConfig(client).getHttpConduit();
        conduit.getClient().setReceiveTimeout(1000000);
        conduit.getClient().setConnectionTimeout(1000000);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
        // POST the request
        List<Attachment> atts = new LinkedList<Attachment>();
        atts.add(new Attachment("applicationInstanceUriId",  MediaType.TEXT_PLAIN, applicationInstanceUriId));
        atts.add(new Attachment("newPaaSInstanceUriId", MediaType.TEXT_PLAIN, newPaaSInstanceUriId));
        Response response = null;
        
        
        try{
            response = client.post(new MultipartBody(atts));
            if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.OK){
                try {
                    System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response.getEntity()));
                    returnValue=true;
                } catch (IOException ex) {
                    logger.error("Error reading the REST response: "+ex.getMessage());
                }
            }
//            else {
//                try {
//                    logger.error("Error performing DB migration request: "+Response.Status.fromStatusCode(response.getStatus())+" - "+"Response Status : " + IOUtils.readStringFromStream((InputStream)response.getEntity()));
//                } catch (IOException ex) {
//                    logger.error("Error reading the REST response: "+ex.getMessage());
//                }
//            }
        } catch(ClientWebApplicationException cwe){
            logger.error("Ploblem performing DB migration request: "+cwe.getMessage());
        } catch(ServerWebApplicationException cwe){
            throw new SOAException(Response.Status.fromStatusCode(cwe.getStatus()), cwe.getMessage());
        }          
        
        return returnValue;
    }
    
    public boolean commitMigration(String applicationInstanceUriId) throws SOAException {
        String rsUri = getBASE_URI();
        boolean returnValue = false;
        
        ApplicationMigration applicationMigration = JAXRSClientFactory.create(rsUri, ApplicationMigration.class);

        Client client = WebClient.client(applicationMigration);
        HTTPConduit conduit = WebClient.getConfig(client).getHttpConduit();
        conduit.getClient().setReceiveTimeout(1000000);
        conduit.getClient().setConnectionTimeout(1000000);
        
        Response response = applicationMigration.commitMigration(applicationInstanceUriId);

        if (Response.Status.fromStatusCode(response.getStatus()) == Response.Status.OK) {
            try {
                System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream) response.getEntity()));
                returnValue = true;
            } catch (IOException ex) {
                logger.error("Error reading the REST response: " + ex.getMessage());
            }
        }
        return returnValue;
    }
    
    public boolean rollbackMigration(String applicationInstanceUriId) throws SOAException {
        String rsUri = getBASE_URI();
        boolean returnValue = false;
        
        ApplicationMigration applicationMigration = JAXRSClientFactory.create(rsUri, ApplicationMigration.class);
        
        Client client = WebClient.client(applicationMigration);
        HTTPConduit conduit = WebClient.getConfig(client).getHttpConduit();
        conduit.getClient().setReceiveTimeout(1000000);
        conduit.getClient().setConnectionTimeout(1000000);
        
        Response response = applicationMigration.rollbackMigration(applicationInstanceUriId);

        if (Response.Status.fromStatusCode(response.getStatus()) == Response.Status.OK) {
            try {
                System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream) response.getEntity()));
                returnValue = true;
            } catch (IOException ex) {
                logger.error("Error reading the REST response: " + ex.getMessage());
            }
        }
        return returnValue;
    }
    
}
