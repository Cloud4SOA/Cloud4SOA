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

import eu.cloud4soa.api.datamodel.core.UserInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.DeveloperInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.PaaSProviderInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.PaaSUserInstance;
import eu.cloud4soa.api.datamodel.soa.UserPaaSCredentials;
import eu.cloud4soa.api.soa.UserManagementAndSecurityModule;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import java.io.FileNotFoundException;
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
public class UserManagementAndSecurityModuleTest {
//    final String BASE_URI = "http://localhost:8080/cloud4soa.soa/services/REST/UserManagementAndSecurityModuleRS/";
    final String BASE_URI = "http://localhost:8080/services/REST/UserManagementAndSecurityModuleRS/";
    private String userInstanceUriId;
    private static final Logger logger = LoggerFactory.getLogger(UserManagementAndSecurityModuleTest.class);
    
    public static void main( String[] args ) throws FileNotFoundException
    {
        UserManagementAndSecurityModuleTest adt = new UserManagementAndSecurityModuleTest();
        adt.storeUserCredentialsForPaaS();
        adt.readUserCredentialsForPaaS();
//        adt.createNewDeveloperAccount();
//        try {
//            adt.getUserInstance();
//        } catch (SOAException ex) {
//            logger.error(ex.getMessage());
//        }
    }
    
    public String createNewDeveloperAccount() {        
//        ProviderFactory.getSharedInstance().registerUserProvider(new JSONProvider());

//        WebClient webClient = WebClient.create(BASE_URI+"createNewAccount");
//        webClient.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE);
        UserManagementAndSecurityModule userMgt = JAXRSClientFactory.create(BASE_URI, UserManagementAndSecurityModule.class);
//        Response response = webClient.post(userInstanceUriId);
        UserInstance userInstance = new DeveloperInstance();
        userInstance.setAccountname("userAccountName");
        userInstance.setFamilyname("userFamilyname");
        userInstance.setFirstName("userFirstName");
        userInstance.setGeekcode("userGeekcode");
        userInstance.setSurname("userSurname");
        
        String username = "username";
        String password = "password";
//        Response response = userMgt.createNewAccount(userInstance, username, password);

        Response response = createNewAccountRS(userInstance, username, password);
        
//        Response response = webClient.post(userInstanceJsonObj.toString());
        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.CREATED)
            try {
                userInstanceUriId = IOUtils.readStringFromStream((InputStream)response.getEntity());
                System.out.println("Response Status : " + userInstanceUriId);
                return userInstanceUriId;
            } catch (IOException ex) {
                logger.error(ex.getMessage());
            }
        return null;
    }
    
    public String createNewPaaSUserAccount() {        
//        ProviderFactory.getSharedInstance().registerUserProvider(new JSONProvider());

//        WebClient webClient = WebClient.create(BASE_URI+"createNewAccount");
//        webClient.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE);
        UserManagementAndSecurityModule userMgt = JAXRSClientFactory.create(BASE_URI, UserManagementAndSecurityModule.class);
//        Response response = webClient.post(userInstanceUriId);
        PaaSUserInstance paaSUserInstance = createPaaSUserInstance();
        String username = "cloudControl";
        String password = "cloudControlPassword";
//        Response response = userMgt.createNewAccount(paaSUserInstance, username, password);
        
        Response response = createNewAccountRS(paaSUserInstance, username, password);
        
//        Response response = webClient.post(userInstanceJsonObj.toString());
        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.CREATED)
            try {
                userInstanceUriId = IOUtils.readStringFromStream((InputStream)response.getEntity());
                System.out.println("Response Status : " + userInstanceUriId);
                return userInstanceUriId;
            } catch (IOException ex) {
                logger.error(ex.getMessage());
            }
        return null;
    }

    private Response createNewAccountRS(UserInstance paaSUserInstance, String username, String password) {
        WebClient client = WebClient.create(BASE_URI+"createNewAccount");
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        //        ProviderFactory.getSharedInstance().registerUserProvider(new JSONProvider());
        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);
        List<Attachment> atts = new LinkedList<Attachment>();
        atts.add(new Attachment("userInstance", MediaType.APPLICATION_JSON , paaSUserInstance));
        atts.add(new Attachment("username", MediaType.TEXT_PLAIN , username));
        atts.add(new Attachment("password", MediaType.TEXT_PLAIN , password));
        Response response = client.post(new MultipartBody(atts));
        return response;
    }
    
    private UserInstance getUserInstance() throws SOAException {             
//        ProviderFactory.getSharedInstance().registerUserProvider(new JSONProvider());

//        WebClient webClient = WebClient.create(BASE_URI+"getUserInstance");
//        webClient.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE);
        UserManagementAndSecurityModule userMgt = JAXRSClientFactory.create(BASE_URI, UserManagementAndSecurityModule.class);
//        Response response = webClient.post(userInstanceUriId);
//		userInstanceUriId	= "6384a572-d01c-40ed-91fe-1acee92a63a4";
        UserInstance userInstance = userMgt.getUserInstance(userInstanceUriId);
        System.out.println("---- Retrieved userInstance, accountName: " + userInstance.getAccountname());
        System.out.println(userInstance instanceof DeveloperInstance);
//        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.ACCEPTED)
//        {
////                InputStream is = (InputStream)response.getEntity();
////                UserInstance userInstance = getFromInputStreamUsingJaxb(is);
//                UserInstance userInstance = (UserInstance) response.getEntity();
//                System.out.println("userInstance : " + userInstance);
//        }
        return userInstance;
    }

    private PaaSUserInstance createPaaSUserInstance() {
        PaaSUserInstance paaSUserInstance = new PaaSUserInstance();
        paaSUserInstance.setAccountname("cloudControl");
        paaSUserInstance.setFamilyname("cloudControl");
        paaSUserInstance.setFirstName("cloudControl");
        paaSUserInstance.setGeekcode("cloudControl");
        paaSUserInstance.setSurname("cloudControl");
//        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
//        cloud4SoaAccountInstance.setAccountname("cloudControl");
//        paaSUserInstance.setHoldsaccount(new Cloud4SoaAccountInstance());
        
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance("CloudControl", "http://cloudcontrol.com");

        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);
        
        return paaSUserInstance;
    }
    
    private void storeUserCredentialsForPaaS() {
        String userInstanceUriId = "Vincenzo";
        String paaSInstanceUriId = "amazon_beanstalk";
        String publicKey = "AKIAJRSZ7FBNKBAOUR6A";
        String secretKey = "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";
        UserManagementAndSecurityModule userMgt = JAXRSClientFactory.create(BASE_URI, UserManagementAndSecurityModule.class);
        try {
            Response response = userMgt.storeUserCredentialsForPaaS(userInstanceUriId, paaSInstanceUriId, publicKey, secretKey, "account");
            logger.debug("response: "+response);
        } catch (SOAException ex) {
            logger.error(ex.getMessage());
        }
                 
    }
    
    private void readUserCredentialsForPaaS() {
        String userInstanceUriId = "Vincenzo";
        UserManagementAndSecurityModule userMgt = JAXRSClientFactory.create(BASE_URI, UserManagementAndSecurityModule.class);
        try {
            List<UserPaaSCredentials> credentials = userMgt.readAllUserCredentialsForPaaS(userInstanceUriId);
            for (UserPaaSCredentials userPaaSCredential : credentials) {
                logger.debug("credential: "+userPaaSCredential);
            }
            
        } catch (SOAException ex) {
            logger.error(ex.getMessage());
        }
                 
    }
}
