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

import eu.cloud4soa.api.datamodel.core.equivalence.EquivalenceRuleHWCategoryInstance;
import eu.cloud4soa.api.soa.ModelManager;
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
import org.apache.cxf.transport.http.HTTPConduit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vins
 */
public class SemanticPaaSInitializer {
    final Logger logger = LoggerFactory.getLogger(getClass());
//    final String BASE_URI = "http://94.75.243.141/cloud4soa/services/REST/";
//    final String BASE_URI = "http://vmusoa02.deri.ie:8080/cloud4soa.soa/services/REST/";
//    final String BASE_URI = "http://soa-c4s.rhcloud.com/cloud4soa.soa/services/REST/";
//final String BASE_URI = "http://soa-c4soa.rhcloud.com/cloud4soa.soa/services/REST/";
    final String BASE_URI = "http://localhost:8080/services/REST/";
//    final String BASE_URI = "http://test02.sindice.net:8038/cloud4soa/services/REST";

    public static void main(String[] args) {
        SemanticPaaSInitializer initializer = new SemanticPaaSInitializer();
        initializer.initialize();
///        initializer.retrieveApplicationProfile();
    }

    public void initialize() {

     try {
            String paasFileName = "CloudControl.ttl";
            String paasFileName2 = "CloudControlPython.ttl";
            String paasFileName3 = "CloudControlJava.ttl";
            String paasFileName4 = "CloudControlRuby.ttl";
            String paasUserTurtleProfile = loadPaaSUserTurtleProfile(paasFileName);
            String paaSUserUriId = storePaaSUserTurtleProfile(paasUserTurtleProfile, "cloudcontrol", "cloudcontrol");
            String paasOfferingTurtleProfile = loadPaaSOfferingTurtleProfile(paasFileName);
            String paasOfferingTurtleProfile2 = loadPaaSOfferingTurtleProfile(paasFileName2);
            String paasOfferingTurtleProfile3 = loadPaaSOfferingTurtleProfile(paasFileName3);
            String paasOfferingTurtleProfile4 = loadPaaSOfferingTurtleProfile(paasFileName4);
            String storePaaSUserInstance = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile);
            String storePaaSUserInstance2 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile2);
            String storePaaSUserInstance3 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile3);
            String storePaaSUserInstance4 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile4);
        } catch (IOException ex) {
            logger.error("Error during the creation of the CloudControl profile", ex);
        }   
   
     
      try {
            String paasFileName = "AppEngine.ttl";
            String paasFileName2 = "AppEnginePython.ttl";
            String paasUserTurtleProfile = loadPaaSUserTurtleProfile(paasFileName);
            String paaSUserUriId = storePaaSUserTurtleProfile(paasUserTurtleProfile, "appengine", "appengine");
            String paasOfferingTurtleProfile = loadPaaSOfferingTurtleProfile(paasFileName);
            String storePaaSUserInstance = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile);
             String paasOfferingTurtleProfile2 = loadPaaSOfferingTurtleProfile(paasFileName2);
            String storePaaSUserInstance2 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile2);
        } catch (IOException ex) {
            logger.error("Error during the creation of the AppEngine profile", ex);
        }
      
        


      try {
            String paasFileName = "Azure.ttl";
            String paasFileName2 = "AzureCsharp.ttl";
            String paasFileName3 = "AzureJava.ttl";
            String paasFileName4 = "AzureNodejs.ttl";
            String paasFileName5 = "AzurePHP.ttl";
            String paasFileName6 = "AzurePython.ttl";
            String paasUserTurtleProfile = loadPaaSUserTurtleProfile(paasFileName);
            String paaSUserUriId = storePaaSUserTurtleProfile(paasUserTurtleProfile, "azure", "azure");
            String paasOfferingTurtleProfile = loadPaaSOfferingTurtleProfile(paasFileName);
            String paasOfferingTurtleProfile2 = loadPaaSOfferingTurtleProfile(paasFileName2);
            String paasOfferingTurtleProfile3 = loadPaaSOfferingTurtleProfile(paasFileName3);
            String paasOfferingTurtleProfile4 = loadPaaSOfferingTurtleProfile(paasFileName4);
            String paasOfferingTurtleProfile5 = loadPaaSOfferingTurtleProfile(paasFileName5);
            String paasOfferingTurtleProfile6 = loadPaaSOfferingTurtleProfile(paasFileName6);
            String storePaaSUserInstance = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile);
            String storePaaSUserInstance2 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile2);
            String storePaaSUserInstance3 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile3);
            String storePaaSUserInstance4 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile4);
            String storePaaSUserInstance5 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile5);
            String storePaaSUserInstance6 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile6);
        } catch (IOException ex) {
            logger.error("Error during the creation of the Azure profile", ex);
        }
 
    
 
        try {
            String paasFileName = "Beanstalk.ttl";
            String paasFileName2 = "BeanstalkASP.ttl";
            String paasFileName3 = "BeanstalkCsharp.ttl";
            String paasFileName4 = "BeanstalkNodejs.ttl";
            String paasFileName5 = "BeanstalkPHP.ttl";
            String paasFileName6 = "BeanstalkPython.ttl";
            String paasFileName7 = "BeanstalkRuby.ttl";
                  
            String paasUserTurtleProfile = loadPaaSUserTurtleProfile(paasFileName);
            String paaSUserUriId = storePaaSUserTurtleProfile(paasUserTurtleProfile, "beanstalk", "beanstalk");
            String paasOfferingTurtleProfile = loadPaaSOfferingTurtleProfile(paasFileName);
            String paasOfferingTurtleProfile2 = loadPaaSOfferingTurtleProfile(paasFileName2);
            String paasOfferingTurtleProfile3 = loadPaaSOfferingTurtleProfile(paasFileName3);
            String paasOfferingTurtleProfile4 = loadPaaSOfferingTurtleProfile(paasFileName4);
            String paasOfferingTurtleProfile5 = loadPaaSOfferingTurtleProfile(paasFileName5);
            String paasOfferingTurtleProfile6 = loadPaaSOfferingTurtleProfile(paasFileName6);
            String paasOfferingTurtleProfile7 = loadPaaSOfferingTurtleProfile(paasFileName7);
            String storePaaSUserInstance = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile);
            String storePaaSUserInstance2 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile2);
            String storePaaSUserInstance3 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile3);
            String storePaaSUserInstance4 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile4);
            String storePaaSUserInstance5 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile5);
            String storePaaSUserInstance6 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile6);
            String storePaaSUserInstance7 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile7);
            
        } catch (IOException ex) {
            logger.error("Error during the creation of the Beanstalk profile", ex);
        }
          
      
        try {
            String paasFileName = "CloudBees.ttl";
            String paasFileName2 = "TestPaaS.ttl";
            String paasUserTurtleProfile = loadPaaSUserTurtleProfile(paasFileName);
            String paaSUserUriId = storePaaSUserTurtleProfile(paasUserTurtleProfile, "cloudbees", "cloudbees");
            String paasOfferingTurtleProfile = loadPaaSOfferingTurtleProfile(paasFileName);
            String paasOfferingTurtleProfile2 = loadPaaSOfferingTurtleProfile(paasFileName2);
            String storePaaSUserInstance = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile);
            String storePaaSUserInstance2 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile2);
        } catch (IOException ex) {
            logger.error("Error during the creation of the CloudBees profile", ex);
        }
        
        
        
        try {
            String paasFileName = "CloudFoundry.ttl";
            String paasFileName2 = "CloudFoundryRuby.ttl";
            String paasFileName3 = "CloudFoundryNodejs.ttl";
            String paasUserTurtleProfile = loadPaaSUserTurtleProfile(paasFileName);
            String paaSUserUriId = storePaaSUserTurtleProfile(paasUserTurtleProfile, "cloudfoundry", "cloudcontrol");
            String paasOfferingTurtleProfile = loadPaaSOfferingTurtleProfile(paasFileName);
            String paasOfferingTurtleProfile2 = loadPaaSOfferingTurtleProfile(paasFileName2);
            String paasOfferingTurtleProfile3 = loadPaaSOfferingTurtleProfile(paasFileName3);
            String storePaaSUserInstance = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile);
            String storePaaSUserInstance2 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile2);
            String storePaaSUserInstance3 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile3);
        } catch (IOException ex) {
            logger.error("Error during the creation of the CloudFoundry profile", ex);
        } 
 
          
 
 
 

       try {
            String paasFileName = "Heroku.ttl";
            String paasFileName2 = "HerokuPython.ttl";
            String paasFileName3 = "HerokuNodejs.ttl";
            String paasFileName4 = "HerokuRuby.ttl";
            String paasUserTurtleProfile = loadPaaSUserTurtleProfile(paasFileName);
            String paaSUserUriId = storePaaSUserTurtleProfile(paasUserTurtleProfile, "herokujava", "herokujava");
            String paasOfferingTurtleProfile = loadPaaSOfferingTurtleProfile(paasFileName);
            String paasOfferingTurtleProfile2 = loadPaaSOfferingTurtleProfile(paasFileName2);
            String paasOfferingTurtleProfile3 = loadPaaSOfferingTurtleProfile(paasFileName3);
            String paasOfferingTurtleProfile4 = loadPaaSOfferingTurtleProfile(paasFileName4);
            String storePaaSUserInstance = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile);
            String storePaaSUserInstance2 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile2);
            String storePaaSUserInstance3 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile3);
            String storePaaSUserInstance4 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile4);
        } catch (IOException ex) {
            logger.error("Error during the creation of the Heroku profile", ex);
        }
         
        
   
        
        try {
            String paasFileName = "OpenShift.ttl";
            String paasFileName2 = "OpenShiftPHP.ttl";
            String paasFileName3 = "OpenShiftPython.ttl";
            String paasFileName4 = "OpenShiftNodejs.ttl";
            String paasFileName5 = "OpenShiftRuby.ttl";
            String paasUserTurtleProfile = loadPaaSUserTurtleProfile(paasFileName);
            String paaSUserUriId = storePaaSUserTurtleProfile(paasUserTurtleProfile, "openshift", "openshift");
            String paasOfferingTurtleProfile = loadPaaSOfferingTurtleProfile(paasFileName);
            String paasOfferingTurtleProfile2 = loadPaaSOfferingTurtleProfile(paasFileName2);
            String paasOfferingTurtleProfile3 = loadPaaSOfferingTurtleProfile(paasFileName3);
            String paasOfferingTurtleProfile4 = loadPaaSOfferingTurtleProfile(paasFileName4);
            String paasOfferingTurtleProfile5 = loadPaaSOfferingTurtleProfile(paasFileName5);
            String storePaaSUserInstance = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile);
            String storePaaSUserInstance2 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile2);
            String storePaaSUserInstance3 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile3);
            String storePaaSUserInstance4 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile4);
            String storePaaSUserInstance5 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile5);
        } catch (IOException ex) {
            logger.error("Error during the creation of the OpenShift profile", ex);
        }  
        
   
        
         try {
            String paasFileName = "EngineYard.ttl";
            String paasFileName2 = "EngineYardNodeJs.ttl";
            String paasFileName3 = "EngineYardPHP.ttl";
            String paasUserTurtleProfile = loadPaaSUserTurtleProfile(paasFileName);
            String paaSUserUriId = storePaaSUserTurtleProfile(paasUserTurtleProfile, "engineyard", "engineyard");
            String paasOfferingTurtleProfile = loadPaaSOfferingTurtleProfile(paasFileName);
            String paasOfferingTurtleProfile2 = loadPaaSOfferingTurtleProfile(paasFileName2);
            String paasOfferingTurtleProfile3 = loadPaaSOfferingTurtleProfile(paasFileName3);
            String storePaaSUserInstance = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile);
            String storePaaSUserInstance2 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile2);
            String storePaaSUserInstance3 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile3);
        } catch (IOException ex) {
            logger.error("Error during the creation of the EngineYard profile", ex);
        } 
       
         
         try {
            String paasFileName = "AppHarbor.ttl";
            String paasFileName2 = "AppHarborCsharp.ttl";
            String paasUserTurtleProfile = loadPaaSUserTurtleProfile(paasFileName);
            String paaSUserUriId = storePaaSUserTurtleProfile(paasUserTurtleProfile, "appharbor", "appharbor");
            String paasOfferingTurtleProfile = loadPaaSOfferingTurtleProfile(paasFileName);
            String paasOfferingTurtleProfile2 = loadPaaSOfferingTurtleProfile(paasFileName2);
            String storePaaSUserInstance = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile);
            String storePaaSUserInstance2 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile2);
        } catch (IOException ex) {
            logger.error("Error during the creation of the AppHarbor profile", ex);
        }  
    
        
         
         try {
            String paasFileName = "dotCloud.ttl";
            String paasFileName2 = "dotCloudNodejs.ttl";
            String paasFileName3 = "dotCloudPHP.ttl";
            String paasFileName4 = "dotCloudPython.ttl";
            String paasFileName5 = "dotCloudRuby.ttl";
            String paasUserTurtleProfile = loadPaaSUserTurtleProfile(paasFileName);
            String paaSUserUriId = storePaaSUserTurtleProfile(paasUserTurtleProfile, "dotcloud", "dotcloud");
            String paasOfferingTurtleProfile = loadPaaSOfferingTurtleProfile(paasFileName);
            String paasOfferingTurtleProfile2 = loadPaaSOfferingTurtleProfile(paasFileName2);
            String paasOfferingTurtleProfile3 = loadPaaSOfferingTurtleProfile(paasFileName3);
            String paasOfferingTurtleProfile4 = loadPaaSOfferingTurtleProfile(paasFileName4);
            String paasOfferingTurtleProfile5 = loadPaaSOfferingTurtleProfile(paasFileName5);
            String storePaaSUserInstance = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile);
            String storePaaSUserInstance2 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile2);
            String storePaaSUserInstance3 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile3);
            String storePaaSUserInstance4 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile4);
            String storePaaSUserInstance5 = storePaaSOfferingTurtleProfile(paaSUserUriId, paasOfferingTurtleProfile5);
        } catch (IOException ex) {
            logger.error("Error during the creation of the dotCloud profile", ex);
        }  
           
    }

    private String loadPaaSUserTurtleProfile(String fileName) throws IOException {
        String paasUserDir = "paasUsers";
        String paasUserTurtleProfile = loadTurtleFileIntoString(paasUserDir, fileName);
        return paasUserTurtleProfile;
    }

    private String storePaaSUserTurtleProfile(String paasUserTurtleProfile, String username, String password) throws IOException {
        String errorMessage;
        String rsUri = BASE_URI+"UserManagementAndSecurityModuleRS/createNewUserAccount";
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
        registerJsonProvider();

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("userProfile", MediaType.TEXT_PLAIN , paasUserTurtleProfile));

        atts.add(new Attachment("username", MediaType.TEXT_PLAIN , username));
        
        atts.add(new Attachment("password", MediaType.TEXT_PLAIN , password));
        
        Response response = client.post(new MultipartBody(atts));
        String userInstanceUriId = null;
        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.CREATED){
            try {
                userInstanceUriId = IOUtils.readStringFromStream((InputStream)response.getEntity());
                logger.info("Response Status CREATED - userInstanceUriId: " + userInstanceUriId);
            } catch (IOException ex) {
                logger.error("Error reading the REST response: "+ex.getMessage());
            }
        } else {
            errorMessage = "Expected >>" + Response.Status.CREATED + "<<; received >>" +
                            Response.Status.fromStatusCode(response.getStatus()) + "<<";    
            throw new IOException( errorMessage );
        }
        return userInstanceUriId;
    }
    
    private void registerJsonProvider() {
        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);
    }

    private String loadPaaSOfferingTurtleProfile(String fileName) throws IOException {
        String paasUserDir = "paasProfiles";
        return loadTurtleFileIntoString(paasUserDir, fileName);
    }
    
    private String loadTurtleFileIntoString(String dir, String fileName) throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream( dir + "/" + fileName );
        String paasOfferingTurtleProfile = IOUtils.toString(is);
        return paasOfferingTurtleProfile;
    }

    private String storePaaSOfferingTurtleProfile(String paaSUserUriId, String paasUserTurtleProfile) {
        String rsUri = BASE_URI+"AnnouncementModuleRS/storeTurtlePaaSProfile";
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        HTTPConduit conduit = WebClient.getConfig(client).getHttpConduit();
        conduit.getClient().setReceiveTimeout(100000);
        conduit.getClient().setConnectionTimeout(100000);
        registerJsonProvider();

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("paasProfile", MediaType.TEXT_PLAIN , paasUserTurtleProfile));

        atts.add(new Attachment("userInstanceUriId", MediaType.TEXT_PLAIN , paaSUserUriId));
        
        Response response = client.post(new MultipartBody(atts));
        String paasInstanceUriId = null;
        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.CREATED){
            try {
                paasInstanceUriId = IOUtils.readStringFromStream((InputStream)response.getEntity());
                logger.info("paasInstanceUriId: "+paasInstanceUriId);
            } catch (IOException ex) {
                logger.error("Error reading the REST response: "+ex.getMessage());
            }
        }
        return paasInstanceUriId;
    }
    
    
    
    public void addEquivalenceRule() {
        EquivalenceRuleHWCategoryInstance erhc = new EquivalenceRuleHWCategoryInstance();
        
        erhc = createCloneEquivalenceRule("AppCell", 0.125f);
        
        try {
            insertEqRule(erhc);
        }catch(SOAException cwe){
            logger.error("Exception in adding "+ erhc.getHasSource() +" eq rule: ", cwe);
        }
    }    
        
        
    public EquivalenceRuleHWCategoryInstance createCloneEquivalenceRule( String category, float coefficient) {
        EquivalenceRuleHWCategoryInstance eqRule;

        eqRule = new EquivalenceRuleHWCategoryInstance();
        eqRule.setHasSource( category );
        eqRule.setHasTarget("ECU");
        eqRule.setHasConversionRate(coefficient);

        return eqRule;

    }
    
    
    public void insertEqRule( EquivalenceRuleHWCategoryInstance eqRule) throws SOAException {
        final String RS_URI = BASE_URI+"ModelManagerRS/";
        ModelManager modelManager = JAXRSClientFactory.create(RS_URI, ModelManager.class);
        
        logger.info("Before inserting the rule");
        Response response = modelManager.addEquivalenceRule( eqRule );
        logger.info("After inserting the rule");
        
    }
    
    
    public void addAllEquivalenceRules() {
        EquivalenceRuleHWCategoryInstance erhc = new EquivalenceRuleHWCategoryInstance();
        
        erhc = createCloneEquivalenceRule("Clone", 0.250f);
        erhc = createCloneEquivalenceRule("AppCell", 0.125f);
        erhc = createCloneEquivalenceRule("ECU", 1f);
        erhc = createCloneEquivalenceRule("Dyno", 2f);
        
        try {
            insertEqRule(erhc);
        }catch(SOAException cwe){
            logger.error("Exception in adding "+ erhc.getHasSource() +" eq rule: ", cwe);
        }
    }
}
