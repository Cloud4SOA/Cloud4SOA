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

import eu.cloud4soa.api.datamodel.core.UserInstance;
import eu.cloud4soa.api.datamodel.soa.UserPaaSCredentials;
import eu.cloud4soa.api.soa.UserManagementAndSecurityModule;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vins
 */
public class UserManagementAndSecurityModuleClient {
    final Logger logger = LoggerFactory.getLogger(getClass());
    
    final String RS_URI = "UserManagementAndSecurityModuleRS/";

    public UserManagementAndSecurityModuleClient() {}
    
    /**
     * @return the BASE_URI
     */
    public String getBASE_URI() {
        return System.getProperty("cloud4soa.baseUrl")+RS_URI;
    }
    
//    public boolean createNewAccount(UserInstance userInstance){
//        String rsUri = BASE_URI;
//        
//        UserManagementAndSecurityModule userManagementAndSecurityModule = JAXRSClientFactory.create(rsUri, UserManagementAndSecurityModule.class);
//        Response response = userManagementAndSecurityModule.createNewAccount(userInstance);
//        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.CREATED){
//            try {
//                logger.debug("Response Status : CREATED - " + IOUtils.readStringFromStream((InputStream)response.getEntity()));
//            } catch (IOException ex) {
//                logger.error("Error reading the REST response: "+ex.getMessage());
//            }
//            return true;
//        }
//        return false;
//    }
    
    public String storeTurtleUserProfile(String userProfile, String username, String password){
        String rsUri = getBASE_URI()+"createNewUserAccount";
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
        registerJsonProvider();

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("userProfile", MediaType.TEXT_PLAIN , userProfile));

        atts.add(new Attachment("username", MediaType.TEXT_PLAIN , username));
        
        atts.add(new Attachment("password", MediaType.TEXT_PLAIN , password));
        
        Response response = client.post(new MultipartBody(atts));
        String userInstanceUriId = null;
        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.CREATED){
            try {
                userInstanceUriId = IOUtils.readStringFromStream((InputStream)response.getEntity());
                logger.debug("Response Status CREATED - userInstanceUriId: " + userInstanceUriId);
            } catch (IOException ex) {
                logger.error("Error reading the REST response: "+ex.getMessage());
            }
        }
        return userInstanceUriId;
    }
    
    public UserInstance getUserInstance(String userInstanceUriId) throws SOAException{
        String rsUri = getBASE_URI()+"getUserInstance";
        
        UserManagementAndSecurityModule userManagementAndSecurityModule = JAXRSClientFactory.create(rsUri, UserManagementAndSecurityModule.class);
        UserInstance userInstance = userManagementAndSecurityModule.getUserInstance(userInstanceUriId);
        logger.debug("userInstance: "+userInstance);
        return userInstance;
    }
    
    public UserInstance authenticateUser (String username, String password) throws ClientWebApplicationException{
        String rsUri = getBASE_URI()+"authenticateUser";
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.APPLICATION_XML_TYPE);
        
        registerJsonProvider();

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("username", MediaType.TEXT_PLAIN , username));

        atts.add(new Attachment("password", MediaType.TEXT_PLAIN , password));
        
//        Response response = client.post(new MultipartBody(atts));
        UserInstance userInstance = client.post(new MultipartBody(atts), UserInstance.class);
//        UserInstance userInstance = null;
        
//        userInstance = (UserInstance)response.getEntity();
//        logger.debug("userInstance: "+userInstance);
        
        return userInstance;
    }
    
    public boolean storeUserCredentialsForPaaS (String userInstanceUriId, String paaSInstanceUriId, String publicKey, String secretKey, String accountName) throws ClientWebApplicationException{
        String rsUri = getBASE_URI()+"storeUserCredentialsForPaaS";
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
        registerJsonProvider();

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("userInstanceUriId", MediaType.TEXT_PLAIN , userInstanceUriId));

        atts.add(new Attachment("paaSInstanceUriId", MediaType.TEXT_PLAIN , paaSInstanceUriId));
        
        atts.add(new Attachment("publicKey", MediaType.TEXT_PLAIN , publicKey));
        
        atts.add(new Attachment("secretKey", MediaType.TEXT_PLAIN , secretKey));
        
        if(accountName!=null && !accountName.isEmpty())
            atts.add(new Attachment("accountName", MediaType.TEXT_PLAIN , accountName));
        
        Response response = client.post(new MultipartBody(atts));

        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.ACCEPTED){
            try {
                String responseString = IOUtils.readStringFromStream((InputStream)response.getEntity());
                logger.debug("Response Status ACCEPTED - " + responseString);
            } catch (IOException ex) {
                logger.error("Error reading the REST response: "+ex.getMessage());
            }
            return true;
        }
        return false;
    }
    
    public List<UserPaaSCredentials> readAllUserCredentialsForPaaS (String userInstanceUriId) throws SOAException{
        String rsUri = getBASE_URI();
        
        UserManagementAndSecurityModule userManagementAndSecurityModule = JAXRSClientFactory.create(rsUri, UserManagementAndSecurityModule.class);
        List<UserPaaSCredentials> readAllUserCredentialsForPaaS = userManagementAndSecurityModule.readAllUserCredentialsForPaaS(userInstanceUriId);
        
        return readAllUserCredentialsForPaaS;
    }
    
    public UserPaaSCredentials readUserCredentialsForPaaS (String userInstanceUriId, String paaSInstanceUriId) throws SOAException {
        String rsUri = getBASE_URI()+"readUserCredentialsForPaaS";
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.APPLICATION_JSON);
        
        registerJsonProvider();

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("userInstanceUriId", MediaType.TEXT_PLAIN , userInstanceUriId));

        atts.add(new Attachment("paaSInstanceUriId", MediaType.TEXT_PLAIN , paaSInstanceUriId));
        UserPaaSCredentials userPaaSCredentials;
        try{
            userPaaSCredentials = client.post(new MultipartBody(atts), UserPaaSCredentials.class);
        } catch(ServerWebApplicationException cwe){
            throw new SOAException(Response.Status.fromStatusCode(cwe.getStatus()), cwe.getMessage());
        }   
        
        return userPaaSCredentials;
    }
    
    public boolean updateUserCredentialsForPaaS (String userInstanceUriId, String paaSInstanceUriId, String publicKey, String secretKey, String accountName) throws ClientWebApplicationException{
        String rsUri = getBASE_URI()+"updateUserCredentialsForPaaS";
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
        registerJsonProvider();

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("userInstanceUriId", MediaType.TEXT_PLAIN , userInstanceUriId));

        atts.add(new Attachment("paaSInstanceUriId", MediaType.TEXT_PLAIN , paaSInstanceUriId));
        
        atts.add(new Attachment("publicKey", MediaType.TEXT_PLAIN , publicKey));
        
        atts.add(new Attachment("secretKey", MediaType.TEXT_PLAIN , secretKey));
        
        if(accountName!=null && !accountName.isEmpty())
            atts.add(new Attachment("accountName", MediaType.TEXT_PLAIN , accountName));
        
        Response response = client.post(new MultipartBody(atts));

        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.ACCEPTED){
            try {
                String responseString = IOUtils.readStringFromStream((InputStream)response.getEntity());
                logger.debug("Response Status ACCEPTED - " + responseString);
            } catch (IOException ex) {
                logger.error("Error reading the REST response: "+ex.getMessage());
            }
            return true;
        }
        return false;
    }
    
        
    public boolean removeUserCredentialsForPaaS (String userInstanceUriId, String paaSInstanceUriId) throws SOAException {
        String rsUri = getBASE_URI()+"removeUserCredentialsForPaaS";
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
        registerJsonProvider();

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("userInstanceUriId", MediaType.TEXT_PLAIN , userInstanceUriId));

        atts.add(new Attachment("paaSInstanceUriId", MediaType.TEXT_PLAIN , paaSInstanceUriId));

        Response response = client.post(new MultipartBody(atts));

        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.ACCEPTED){
            try {
                String responseString = IOUtils.readStringFromStream((InputStream)response.getEntity());
                logger.debug("Response Status ACCEPTED - " + responseString);
            } catch (IOException ex) {
                logger.error("Error reading the REST response: "+ex.getMessage());
            }
            return true;
        }
        return false;
    }
    //Credentials management
    /*
    @POST
    @Produces("text/plain")
    @Path("/storeUserCredentialsForPaaS")
    public Response storeUserCredentialsForPaaS (
            @Multipart(value = "userInstanceUriId", type = "text/plain") String userInstanceUriId,
            @Multipart(value = "paaSInstanceUriId", type = "text/plain") String paaSInstanceUriId,
            @Multipart(value = "publicKey", type = "text/plain") String publicKey, 
            @Multipart(value = "secretKey", type = "text/plain") String secretKey,
            @Multipart(value = "accountName", type = "text/plain", required = false) String accountName) throws SOAException;
    
    @POST
    @Produces("text/plain")
    @Path("/removeUserCredentialsForPaaS")
    public Response removeUserCredentialsForPaaS (
            @Multipart(value = "userInstanceUriId", type = "text/plain") String userInstanceUriId,
            @Multipart(value = "paaSInstanceUriId", type = "text/plain") String paaSInstanceUriId) throws SOAException;
    
    @POST
    @Produces("text/plain")
    @Path("/updateUserCredentialsForPaaS")
    public Response updateUserCredentialsForPaaS (
            @Multipart(value = "userInstanceUriId", type = "text/plain") String userInstanceUriId,
            @Multipart(value = "paaSInstanceUriId", type = "text/plain") String paaSInstanceUriId,
            @Multipart(value = "publicKey", type = "text/plain") String publicKey, 
            @Multipart(value = "secretKey", type = "text/plain") String secretKey,
            @Multipart(value = "accountName", type = "text/plain", required = false) String accountName) throws SOAException;
    
    @POST
    @Produces({"application/xml","application/json"})
    @Path("/readUserCredentialsForPaaS")
    public UserPaaSCredentials readUserCredentialsForPaaS (
            @Multipart(value = "userInstanceUriId", type = "text/plain") String userInstanceUriId,
            @Multipart(value = "paaSInstanceUriId", type = "text/plain") String paaSInstanceUriId) throws SOAException;
    
    @POST
    @Produces({"application/xml","application/json"})
    @Path("/readAllUserCredentialsForPaaS")
    public List<UserPaaSCredentials> readAllUserCredentialsForPaaS (
            @Multipart(value = "userInstanceUriId", type = "text/plain") String userInstanceUriId) throws SOAException;
    */
        
    private void registerJsonProvider() {
        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);
    }

}
