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
import eu.cloud4soa.api.datamodel.soa.GitRepoInfo;
import eu.cloud4soa.api.datamodel.soa.StringList;
import eu.cloud4soa.api.soa.ApplicationDeployment;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.ClientWebApplicationException;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.ServerWebApplicationException;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.apache.cxf.jaxrs.provider.ProviderFactory;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;
import org.apache.cxf.transport.http.HTTPConduit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vins
 */
public class ApplicationDeploymentClient {
    final Logger logger = LoggerFactory.getLogger(getClass());
    
    final String RS_URI = "ApplicationDeploymentRS/";

    public ApplicationDeploymentClient() {}

    /**
     * @return the BASE_URI
     */
    public String getBASE_URI() {
        return System.getProperty("cloud4soa.baseUrl")+RS_URI;
    }
    
 //   public boolean deployApplication(String applicationInstanceUriId, String paaSInstanceUriId, InputStream fileInputStream) throws FileNotFoundException {
    public boolean deployApplication(String applicationInstanceUriId, String paaSInstanceUriId, InputStream fileInputStream, String slaTemplaId) throws FileNotFoundException {
        String rsUri = getBASE_URI()+"deployApplication";
        boolean returnValue = false;
        
 /*       WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        HTTPConduit conduit = WebClient.getConfig(client).getHttpConduit();
        conduit.getClient().setReceiveTimeout(3600000);
        conduit.getClient().setConnectionTimeout(3600000);
  * 
  */
        
        WebClient client = WebClient.create(rsUri);
        HTTPConduit conduit = WebClient.getConfig(client).getHttpConduit();
        conduit.getClient().setReceiveTimeout(1000000);
        conduit.getClient().setConnectionTimeout(1000000);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
  //      client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
  //      client.type("multipart/mixed").accept(MediaType.APPLICATION_XML_TYPE);
        
        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);
        

        // POST the request
        List<Attachment> atts = new LinkedList<Attachment>();
        atts.add(new Attachment("applicationInstanceUriId",  MediaType.TEXT_PLAIN, applicationInstanceUriId));
        atts.add(new Attachment("paaSInstanceUriId", MediaType.TEXT_PLAIN, paaSInstanceUriId));
        if ( slaTemplaId != null ) {
            atts.add(new Attachment("slaTemplateId", MediaType.TEXT_PLAIN, slaTemplaId));
        }
        atts.add(new Attachment("applicationArchive", MediaType.APPLICATION_OCTET_STREAM, fileInputStream));
        
        
        Response response = null;
        try{
            response = client.post(new MultipartBody(atts));
            if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.ACCEPTED){
                try {
                    logger.trace(IOUtils.readStringFromStream((InputStream)response.getEntity()));
                    logger.warn(IOUtils.readStringFromStream((InputStream)response.getEntity()));
//                    System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response.getEntity()));
                    returnValue=true;
                } catch (IOException ex) {
                    logger.error("Error reading the REST response: "+ex.getMessage());
                }
            }
        } catch(ClientWebApplicationException cwe){
            logger.error("Ploblem performing deployment request: "+cwe.getMessage());
        } catch(ServerWebApplicationException cwe){
            logger.error("Error!: "+cwe.getMessage());
        }   
        
        try {
//            fis.close();
//            bis.close();
//            dis.close();
            fileInputStream.close();
        } catch (IOException ex) {
            logger.error("Error closing inputStream: "+ex.getMessage());
        }
        
        return returnValue;
    }
    
    public boolean startStopApplication(String applicationInstanceUriId, String startStopCommand) {
        String rsUri = getBASE_URI()+"startStopApplication";
        
        List<Attachment> atts = new LinkedList<Attachment>();
        atts.add(new Attachment("applicationInstance", MediaType.TEXT_PLAIN , applicationInstanceUriId));

        atts.add(new Attachment("startStopCommand", MediaType.TEXT_PLAIN , startStopCommand));
        
        WebClient webClient = WebClient.create(rsUri);
        webClient.type("multipart/form-data").accept(MediaType.TEXT_PLAIN);
        Response response = webClient.post(new MultipartBody(atts));
        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.ACCEPTED){
            try {
                logger.debug(IOUtils.readStringFromStream((InputStream)response.getEntity()));
            } catch (IOException ex) {
                logger.error("Error reading the REST response: "+ex.getMessage());
            }
            return true;
        }
        return false;
//    }
    }
    
    public boolean removeApplication(String applicationInstanceUriId) {
        String rsUri = getBASE_URI()+"removeApplication";
        
        List<Attachment> atts = new LinkedList<Attachment>();
        atts.add(new Attachment("applicationInstanceUriId", MediaType.TEXT_PLAIN , applicationInstanceUriId));
                
        WebClient webClient = WebClient.create(rsUri);
        webClient.type("multipart/form-data").accept(MediaType.TEXT_PLAIN);
        Response response = webClient.post(new MultipartBody(atts));
        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.ACCEPTED){
            try {
                logger.debug(IOUtils.readStringFromStream((InputStream)response.getEntity()));
            } catch (IOException ex) {
                logger.error("Error reading the REST response: "+ex.getMessage());
            }
            return true;
        }
        return false;
    }
    
        
    public List<ApplicationInstance> retrieveAllDeployedApplicationProfile(String developerInstanceUriId) throws SOAException {
        String rsUri = getBASE_URI();
        ApplicationDeployment applicationDeployment = JAXRSClientFactory.create(rsUri, ApplicationDeployment.class);
        List<ApplicationInstance> list = applicationDeployment.retrieveAllDeployedApplicationProfiles(developerInstanceUriId);
        return list;
    }
    
    public boolean createDatabase(String applicationInstanceUriId, String paaSInstanceUriId, String dbStorageComponentUriId) {
        String rsUri = getBASE_URI() + "createDatabase";
        boolean returnValue = false;
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        HTTPConduit conduit = WebClient.getConfig(client).getHttpConduit();
        conduit.getClient().setReceiveTimeout(3600000);
        conduit.getClient().setConnectionTimeout(3600000);
        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);

        // POST the request
        List<Attachment> atts = new LinkedList<Attachment>();
        atts.add(new Attachment("applicationInstanceUriId", "text/plain", applicationInstanceUriId));
        atts.add(new Attachment("paaSInstanceUriId", "text/plain", paaSInstanceUriId));
        atts.add(new Attachment("dbStorageComponentUriId", "text/plain", dbStorageComponentUriId));
        
        Response response = null;
        try{
            response = client.post(new MultipartBody(atts));
            if (Response.Status.fromStatusCode(response.getStatus()) == Response.Status.CREATED) {
                try {
                    System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response.getEntity()));
                    returnValue=true;
                } catch (IOException ex) {
                    logger.error("Error reading the REST response: "+ex.getMessage());
                }
            }
        } catch(ClientWebApplicationException cwe){
            logger.error("Ploblem performing db creation request: "+cwe.getMessage());
        }
        return returnValue;
    }
    
    public boolean initializeDatabase(String applicationInstanceUriId, String paaSInstanceUriId, String dbStorageComponentUriId, InputStream fileInputStream ) {
        String rsUri = getBASE_URI() + "initializeDatabase";
        boolean returnValue = false;
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);

        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);

        // POST the request
        List<Attachment> atts = new LinkedList<Attachment>();
        atts.add(new Attachment("applicationInstanceUriId", "text/plain", applicationInstanceUriId));
        atts.add(new Attachment("paaSInstanceUriId", "text/plain", paaSInstanceUriId));
        atts.add(new Attachment("dbStorageComponentUriId", "text/plain", dbStorageComponentUriId));
        atts.add(new Attachment("dumpFile", MediaType.APPLICATION_OCTET_STREAM, fileInputStream));
        
        Response response = null;
        try{
            response = client.post(new MultipartBody(atts));
            if (Response.Status.fromStatusCode(response.getStatus()) == Response.Status.OK) {
                try {
                    System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response.getEntity()));
                    returnValue=true;
                } catch (IOException ex) {
                    logger.error("Error reading the REST response: "+ex.getMessage());
                }
            }
        } catch(ClientWebApplicationException cwe){
            logger.error("Ploblem performing db initialization request: "+cwe.getMessage());
        }
        return returnValue;
    }
    
    public InputStream dumpDatabase(String applicationInstanceUriId, String paaSInstanceUriId, String dbStorageComponentUriId) throws SOAException {
        String rsUri = getBASE_URI() + "dumpDatabase";
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);

        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);

        // POST the request
        List<Attachment> atts = new LinkedList<Attachment>();
        atts.add(new Attachment("applicationInstanceUriId", "text/plain", applicationInstanceUriId));
        atts.add(new Attachment("paaSInstanceUriId", "text/plain", paaSInstanceUriId));
        atts.add(new Attachment("dbStorageComponentUriId", "text/plain", dbStorageComponentUriId));
        InputStream inputStream = null;
        Response response = null;
        try{
            response = client.post(new MultipartBody(atts));
            if (Response.Status.fromStatusCode(response.getStatus()) == Response.Status.OK) {
                    inputStream = (InputStream)response.getEntity();
            }
        } catch(ClientWebApplicationException cwe){
            logger.error("Ploblem performing the db dump request: "+cwe.getMessage());
        } catch(ServerWebApplicationException cwe){
            throw new SOAException(Response.Status.fromStatusCode(cwe.getStatus()), cwe.getMessage());
        } 
        return inputStream;
    }
    
    
    // Git keys management - CRUD operations ----------------------------/
    
    public String getC4SOAPublicKey() throws SOAException{
        String rsUri = getBASE_URI();
        
        ApplicationDeployment applicationDeployment = JAXRSClientFactory.create(rsUri, ApplicationDeployment.class);
        
        String c4SOAPublicKey = applicationDeployment.getC4SOAPublicKey();
        
        return c4SOAPublicKey;
    }
    
    public void registerPublicKeyForUser(String userInstanceUriId, String publicKey) throws SOAException{
        String rsUri = getBASE_URI();
        
        ApplicationDeployment applicationDeployment = JAXRSClientFactory.create(rsUri, ApplicationDeployment.class);
        
        applicationDeployment.registerPublicKeyForUser(userInstanceUriId, publicKey);

    }    
    
    public List<String> getPublicKeysForUser( String userInstanceUriId ) throws SOAException{
        String rsUri = getBASE_URI();
        
        ApplicationDeployment applicationDeployment = JAXRSClientFactory.create(rsUri, ApplicationDeployment.class);
        
        StringList stringList = applicationDeployment.getPublicKeysForUser(userInstanceUriId);
        
        List<String> publicKeysForUser = stringList.getList();
        
        return publicKeysForUser;
    }
    
    public void deletePublicKeyFromUser(String userInstanceUriId, String publicKey ) throws SOAException{
        String rsUri = getBASE_URI();
        
        ApplicationDeployment applicationDeployment = JAXRSClientFactory.create(rsUri, ApplicationDeployment.class);
        
        applicationDeployment.deletePublicKeyFromUser(userInstanceUriId, publicKey);
        
    }
    
 
// Methods to support GIT ------------------------------------------------------    
    
    public GitRepoInfo initializeGitProxy( String userInstanceUriId, String paaSInstanceUriId, String applicationInstanceUriId) throws SOAException {
        String rsUri = getBASE_URI();
        
        ApplicationDeployment applicationDeployment = JAXRSClientFactory.create(rsUri, ApplicationDeployment.class);
        
        GitRepoInfo gitRepoInfo = applicationDeployment.initializeGitProxy(userInstanceUriId, paaSInstanceUriId, applicationInstanceUriId);

        return gitRepoInfo;
    }
    
    
    
    public void registerExistingGitRepo(String applicationInstanceUriId, String userInstanceUriId, String paaSInstanceUriId, String repositoryName, String gitUrl) throws SOAException {
        String rsUri = getBASE_URI();
        
        ApplicationDeployment applicationDeployment = JAXRSClientFactory.create(rsUri, ApplicationDeployment.class);
        
        applicationDeployment.registerGitRepository(applicationInstanceUriId, userInstanceUriId, paaSInstanceUriId, repositoryName, gitUrl);    
        
    }
    
    public Response commitGitDeploy( String userInstanceUriId, String paaSInstanceUriId, String applicationInstanceUriId) throws SOAException {
        String rsUri = getBASE_URI();
        
        ApplicationDeployment applicationDeployment = JAXRSClientFactory.create(rsUri, ApplicationDeployment.class);
        
        Response response = applicationDeployment.commitGitDeploy(userInstanceUriId, paaSInstanceUriId, applicationInstanceUriId);

        return response;
    }
    
    
    public String deleteRepo( String c4sUserUriId, String repoName ) throws SOAException {
        String  requestUri;
        List<Attachment> requestParameters;
        String responseMessage;
        
        requestUri = this.getBASE_URI() + "deleteRepo";
        
        requestParameters   = new LinkedList<Attachment>();
        requestParameters.add(new Attachment("c4sUserUriId", "text/plain", c4sUserUriId));
        requestParameters.add(new Attachment("repoName", "text/plain", repoName));
        
        responseMessage = postRequest(requestUri, requestParameters, Response.Status.CREATED);
        
        return responseMessage;
    }
    
    
    
    public String relocateRepo( String c4sUserUriId, String newPaasUriId ) throws SOAException {
        String  requestUri;
        List<Attachment> requestParameters;
        String responseMessage;
        
        requestUri = this.getBASE_URI() + "relocateRepo";
        
        requestParameters   = new LinkedList<Attachment>();
        requestParameters.add(new Attachment("c4sUserUriId", "text/plain", c4sUserUriId));
        requestParameters.add(new Attachment("newPaasUriId", "text/plain", newPaasUriId));
        
        responseMessage = postRequest(requestUri, requestParameters, Response.Status.CREATED);
        
        return responseMessage;
        
    }
    
    
    
    public Map<Long, Entry<String, String>> getRepos( String c4sUserUriId  ) throws SOAException {
        String                  rsUri;
        ApplicationDeployment   applicationDeployment;
                
        rsUri = getBASE_URI();
        applicationDeployment = JAXRSClientFactory.create(rsUri, ApplicationDeployment.class);
        Map<Long, Entry<String, String>> gitRepos = applicationDeployment.getGitRepos( c4sUserUriId );
        
        return gitRepos;
    }
    
// -------------------------------------------------------------------------------
    
    
    protected String postRequest( String requestURI, List<Attachment> requestParameters, Response.Status expectedStatus) throws SOAException {
        WebClient client;
        Response response;
        String responseMessage;
        StringBuffer errorMessage;
        
        responseMessage = null;
        
        client = WebClient.create( requestURI );
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
        try{
            response = client.post( new MultipartBody( requestParameters) );
            
            if ( this.hasRequestSucceded(response, expectedStatus) ) {
                
                responseMessage = this.readResponseMessage(response);
                
            } else {
                
                errorMessage = new StringBuffer();
                errorMessage.append( "Received status ").append( this.getStatus(response).toString());
                errorMessage.append(" while expected status was ").append( expectedStatus);
                errorMessage.append( "; Response message: ").append( this.readResponseMessage(response) );
                throw new SOAException( this.getStatus(response), errorMessage.toString() );
            }
            
        } catch (IOException ex) {
            throw new SOAException(expectedStatus, "Error in reading the response message: " + ex.getMessage() );
        } catch(ClientWebApplicationException cwe){
            throw new SOAException( null, "Error in sending the REST request: " + cwe.getMessage());
        }
        
        return responseMessage;
    }
    
    
    
    protected Response.Status getStatus( Response response) {
        return Response.Status.fromStatusCode(response.getStatus());
    }
    
    
    
    protected boolean hasRequestSucceded( Response response, Response.Status expectedStatus) {
        return  this.getStatus(response) == expectedStatus;   
    }
    
    
    
    protected String readResponseMessage( Response response) throws IOException {
        String responseMessage;
        
        
        responseMessage = IOUtils.readStringFromStream((InputStream)response.getEntity());
        
        return responseMessage;
    }
    
    
}
