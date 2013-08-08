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

import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import eu.cloud4soa.api.datamodel.core.equivalence.EquivalenceRuleHWCategoryInstance;
import eu.cloud4soa.api.datamodel.repository.QueryResultRow;
import eu.cloud4soa.api.datamodel.repository.QueryResultTable;
import eu.cloud4soa.api.soa.ApplicationDeployment;
import eu.cloud4soa.api.soa.ModelManager;
import eu.cloud4soa.api.util.exception.SparqlQueryException;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;

/**
 *
 * @author vins
 */
public class ModelManagerTest {
//    final String BASE_URI = "http://soa-c4s.rhcloud.com/cloud4soa.soa/services/REST/";
    final String BASE_URI = "http://localhost:8080/services/REST/";
//    final String BASE_URI = "http://localhost:8080/frontend-dashboard-0.0.1-SNAPSHOT/services/REST/";
    private ApplicationInstance applicationInstance;
    private String developerInstanceUriId = "aaa";
    private String applicationInstanceUriId;

    public ModelManagerTest() {
        applicationInstanceUriId = "OnCloudBeesVincenzo";        
    }

    public static void main( String[] args ){
        ModelManagerTest mmt = new ModelManagerTest();
//        mmt.retrieveAllApplicationProfile();
//        mmt.retrieveAllDeployedApplicationProfile();
//        mmt.sparqlSelect();
//        mmt.retrieveApplicationProfile();
        mmt.addEquivalenceRule();
    }
    
    
//    
//    ApplicationSemanticModel createApplicationProfile();
//    
//    String storeApplicationProfile(
//            @Multipart(value = "applicationInstance", type = "application/json")ApplicationInstance applicationInstance,
//            @Multipart(value = "userInstanceUriId", type = "text/plain")String userInstanceUriId);
//    
//    void updateApplicationProfile(ApplicationInstance applicationInstance);
//    
//    void removeApplicationProfile(String applicationInstanceUriId);
//    
//    List<ApplicationInstance> retrieveAllApplicationProfile(String userInstanceUriId);
//    
//    PaaSSemanticModel createPaaSProfile();
//    
//    UserSemanticModel getUserSemanticModel();
//    
    
    public void retrieveAllApplicationProfile() throws SOAException{
        final String RS_URI = BASE_URI+"ModelManagerRS/";
        ModelManager modelManager = JAXRSClientFactory.create(RS_URI, ModelManager.class);
        List<ApplicationInstance> list = modelManager.retrieveAllApplicationProfile(developerInstanceUriId);
        for (ApplicationInstance applicationInstance : list) {
            System.out.println(applicationInstance);
        }
    }
    
    public void retrieveApplicationProfile(){
        final String RS_URI = BASE_URI+"ModelManagerRS/retrieveApplicationProfile";
//        ModelManager modelManager = JAXRSClientFactory.create(RS_URI, ModelManager.class);
//        ApplicationInstance applicationProfile = modelManager.retrieveApplicationProfile(applicationInstanceUriId, developerInstanceUriId);
//            System.out.println(applicationProfile);
            
        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        WebClient client = WebClient.create(RS_URI, Collections.singletonList(jsonProvider));
        client.type("multipart/mixed").accept(MediaType.APPLICATION_JSON);
        List<Attachment> atts = new LinkedList<Attachment>();
        atts.add(new Attachment("applicationInstanceUriId", MediaType.TEXT_PLAIN, applicationInstanceUriId));
        atts.add(new Attachment("userInstanceUriId", MediaType.TEXT_PLAIN, developerInstanceUriId));
        try{
            ApplicationInstance applicationInstance =  client.post(new MultipartBody(atts), ApplicationInstance.class);
            System.out.println("Response Status : " + applicationInstance.getOwnerUriId());
                //                    System.out.println("Response Status : " + .);
        }catch(WebApplicationException cwe){
            try {
                System.out.println("Exception: "+IOUtils.readStringFromStream((InputStream)cwe.getResponse().getEntity()));
            } catch (IOException ex) {
                Logger.getLogger(ModelManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
//    private void storeApplicationInstance() {
//        final String RS_URI = BASE_URI+"ModelManagerRS/storeApplicationProfile";
//
//        WebClient client = WebClient.create(RS_URI);
//        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
//        
//        List<Attachment> atts = new LinkedList<Attachment>();
//        atts.add(new Attachment("applicationInstance", "application/json", applicationInstance));
//        atts.add(new Attachment("userInstanceUriId", "text/plain", developerInstanceUriId));
//        
//        
//        Response response = client.post(new MultipartBody(atts));
//        try {
//            applicationInstanceUriId = IOUtils.readStringFromStream((InputStream)response.getEntity());
//            System.out.println("applicationInstanceUriId: "+applicationInstanceUriId);
//        } catch (IOException ex) {
//            Logger.getLogger(AnnouncementModuleTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    private void createApplicationInstance() throws FileNotFoundException{
//        URL fileURL = this.getClass().getClassLoader().getResource("SimpleWar.war");
//        if (fileURL == null)
//            throw new FileNotFoundException("SimpleWar.war");
//        
//        
//        ByteArrayOutputStream bas = new ByteArrayOutputStream();
//        
//        File file = new File(fileURL.getPath());
//        file.length();
//        FileInputStream fis = new FileInputStream(file);
//        BufferedInputStream bis = new BufferedInputStream(fis);
//        DataInputStream dis = new DataInputStream(bis);
//        
//        //Calculate digest from InputStream
////        InputStream tempIs = new FileInputStream(file);
//        String tempFileDigest = null;
//        try {
//            FileInputStream tempFis = new FileInputStream(file);
//            tempFileDigest = DigestUtils.sha256Hex(tempFis);
//        } catch (IOException ex) {
//            Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        applicationInstance = new ApplicationInstance();
//        applicationInstance.setAcronym("C4Sv1.0");
//        applicationInstance.setApplicationcode("C4Sv1.0");
//        applicationInstance.setDigest(tempFileDigest);
//        applicationInstance.setProgramminglanguage("Java");
//        applicationInstance.setProgramminglanguageVersion("1.6");
//        applicationInstance.setSizeQuantity(new Float(file.length()));
//        applicationInstance.setVersion("1.0");
//        applicationInstance.setArchiveFileName("SimpleWar");
//        applicationInstance.setArchiveExtensionName(".war");
//        
//        try {
//            fis.close();
//            bis.close();
//            dis.close();
//        } catch (IOException ex) {
//            Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    private void retrieveAllDeployedApplicationProfile() throws SOAException {
        final String RS_URI = BASE_URI+"ApplicationDeploymentRS/";
        ApplicationDeployment modelManager = JAXRSClientFactory.create(RS_URI, ApplicationDeployment.class);
        List<ApplicationInstance> list = modelManager.retrieveAllDeployedApplicationProfiles(developerInstanceUriId);
        for (ApplicationInstance applicationInstance : list) {
            System.out.println(applicationInstance);
            System.out.println(applicationInstance.getStatus());
        }
    }
    
    public void sparqlSelect(){
        String rdf = "http://www.w3.org/1999/02/22-rdf-syntax-ns#";
        String query = "SELECT ?object WHERE { ?object <" + rdf + "type>  <"+ rdf + "Property> }";
//        String query = "SELECT ?object WHERE { ?object <" + rdf + "type1>  <"+ rdf + "Property1> }";
        
        final String RS_URI = BASE_URI+"ModelManagerRS/";
        ModelManager modelManager = JAXRSClientFactory.create(RS_URI, ModelManager.class);
        WebClient.client(modelManager).accept("application/json");
        try {
            QueryResultTable queryResultTable = modelManager.sparqlSelect(query);
            for (Iterator<QueryResultRow> it = queryResultTable.iterator(); it.hasNext();) {
                QueryResultRow queryResultRow = it.next();
                System.out.println(queryResultRow);
            }
        } catch (SparqlQueryException ex) {
            Logger.getLogger(ModelManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void addEquivalenceRule(){
        final String RS_URI = BASE_URI+"ModelManagerRS/";
        ModelManager modelManager = JAXRSClientFactory.create(RS_URI, ModelManager.class);
       
   //     EquivalenceRuleHWCategoryInstance gearrule = new EquivalenceRuleHWCategoryInstance();
   //     gearrule.setHasSource("ECU");
   //     gearrule.setHasTarget("Gear");
   //     gearrule.setHasConversionRate(2.0f);
                    
        EquivalenceRuleHWCategoryInstance appcellrule = new EquivalenceRuleHWCategoryInstance();
        appcellrule.setHasSource("AppCell");
        appcellrule.setHasTarget("ECU");
        appcellrule.setHasConversionRate(0.125f);
        
        EquivalenceRuleHWCategoryInstance clonerule = new EquivalenceRuleHWCategoryInstance();
        clonerule.setHasSource("Clone");
        clonerule.setHasTarget("ECU");
        clonerule.setHasConversionRate(0.5f);
        
           
     //   EquivalenceRuleHWCategoryInstance dynoRule = new EquivalenceRuleHWCategoryInstance();
     //   dynoRule.setHasSource("Dyno");
     //   dynoRule.setHasTarget("ECU");
     //   dynoRule.setHasConversionRate(0.75f);
        
    //   EquivalenceRuleHWCategoryInstance dotCloudWorkerrule = new EquivalenceRuleHWCategoryInstance();
    //    dotCloudWorkerrule.setHasSource("dotCloudWorker");
     //   dotCloudWorkerrule.setHasTarget("ECU");
      //  dotCloudWorkerrule.setHasConversionRate(0.25f);
               
        
    //    EquivalenceRuleHWCategoryInstance gearRule = new EquivalenceRuleHWCategoryInstance();
    //    gearRule.setHasSource("Gear");
    //    gearRule.setHasTarget("ECU");
    //    gearRule.setHasConversionRate(0.5f);
        
        try{
            Response response1 = modelManager.addEquivalenceRule(clonerule);
            Response response2 = modelManager.addEquivalenceRule(appcellrule);
       //    Response response3 = modelManager.addEquivalenceRule(dotCloudWorkerrule);
        //    Response response4 = modelManager.addEquivalenceRule(dynoRule);
         //   Response response5 = modelManager.addEquivalenceRule(gearRule);
            
            try {
               System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response1.getEntity()));
               System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response2.getEntity()));
                //System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response3.getEntity()));
            //    System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response4.getEntity()));
           //     System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response5.getEntity()));
            } catch (IOException ex) {
                Logger.getLogger(ModelManagerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SOAException cwe){
            System.out.println("Exception: "+cwe.getMessage());
        }
    }
}
