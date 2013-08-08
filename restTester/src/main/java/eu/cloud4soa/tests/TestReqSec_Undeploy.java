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
package eu.cloud4soa.tests;

import eu.cloud4soa.soa.jaxrs.test.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;

/**
 *
 * @author vins
 */
public class TestReqSec_Undeploy {
//    final String BASE_URI = "http://localhost:8080/cloud4soa.soa/services/REST/";
    final String BASE_URI = "http://localhost:8080/services/REST/";
    
    private String CloudBeesInstanceUriId = "6e708095-c76d-48f0-a9f7-0d41e4c0bf65";
    private String BeanstalkInstanceUriId = "83aca54a-f60b-41ae-b1e7-09142c3f4ca7";
    private String developerInstanceUriId = "d0a5c841-7c40-4af0-90c5-9a54b14ce5c6";

    private String userInstanceUriId;
    private Map<String, String> paaSInstanceUriIds = new HashMap<String, String>();
    
//    private String selectedPaaS = "Beanstalk";
    private String selectedPaaS = "CloudBees";
    private int numberTests = 10;
    
    private String getSecretKey(){
        if(selectedPaaS == "Beanstalk")
            return secretKeyBeanstalk;
        else if(selectedPaaS == "CloudBees")
            return secretKeyCloudBees;
        return null;
    }
    
    private String getPublicKey(){
        if(selectedPaaS == "Beanstalk")
            return publicKeyBeanstalk;
        else if(selectedPaaS == "CloudBees")
            return publicKeyCloudBees;
        return null;
    }
    
    //Beanstalk
    String publicKeyBeanstalk="AKIAJRSZ7FBNKBAOUR6A";
    String secretKeyBeanstalk="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";
    //CloudBees
    String publicKeyCloudBees="4184E8A5D19D02D9";
    String secretKeyCloudBees="UZPYSQVJMQLVNNVK6GSZQPRUTAZ+QKNB9QCKDWVNQMK=";
    
    //<applicationInstanceUriId>
    private List<String> applicationInstances = new ArrayList<String> ();

    public String getPaaSInstanceUriId(String paaSProviderName) {
        return paaSInstanceUriIds.get(paaSProviderName);
    }
    
    public static void main( String[] args ){
        TestReqSec_Undeploy initializer = new TestReqSec_Undeploy();
        initializer.initialize();
        initializer.readFromFileDeployedApplicationsUriId();
        initializer.undeploy();
    }
    
    public void initialize(){
        
        paaSInstanceUriIds.put("CloudBees", "6e708095-c76d-48f0-a9f7-0d41e4c0bf65");
        paaSInstanceUriIds.put("Beanstalk", "83aca54a-f60b-41ae-b1e7-09142c3f4ca7");
        
    }
    
    public void undeploy(){
        Collection<CallableNode> children = new ArrayList<CallableNode>();
        for (String applicationInstanceUriId : applicationInstances) {
            //Creazione Thread...
            CallableNode callableNode = new CallableNode(BASE_URI, applicationInstanceUriId, getPublicKey(), getSecretKey());
            children.add(callableNode);
        }
        ExecutorService executor = Executors.newFixedThreadPool(numberTests);  
        try {
            List<Future<Boolean>> invokeAll = executor.invokeAll(children);
            for (Future<Boolean> future : invokeAll) {
                    Boolean get = future.get();
            }
            System.out.print("All "+numberTests+ " undeploy requests are completed!");
            executor.shutdownNow();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestReqSec_Deploy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(TestReqSec_Deploy.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println("Number of applications: "+applicationInstances.size());
//        for (String applicationInstanceUriId : applicationInstances) {
//            //Creazione Thread...
//            
//            //Applications 
//            try {    
//                undeployApplication(applicationInstanceUriId);
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(TestReqSec_Undeploy.class.getName()).log(Level.SEVERE, null, ex);
//            }
//      }
    }   
    
//    public void undeployApplication(String applicationInstanceUriId) throws FileNotFoundException {
//        final String RS_URI = BASE_URI+"ApplicationDeploymentRS/removeApplication";
//
//        WebClient client = WebClient.create(RS_URI);
//        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
//        
//        // POST the request
////        Response response = applicationDeploymentRS.deployApplication(dis, applicationInstanceJsonObj, paaSInstanceJsonObj);
//        List<Attachment> atts = new LinkedList<Attachment>();
//        atts.add(new Attachment("applicationInstanceUriId", "text/plain", applicationInstanceUriId));
//        atts.add(new Attachment("publicKey", "text/plain", getPublicKey()));
//        atts.add(new Attachment("secretKey", "text/plain", getSecretKey()));
//
//        Response response = client.post(new MultipartBody(atts));
//        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.ACCEPTED)
//            try {
//                System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response.getEntity()));
//            } catch (IOException ex) {
//                Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
//            }
//    }

    private void readFromFileDeployedApplicationsUriId() {
        String applicationInstanceUriId;
        BufferedReader bufferedReader = null;
        try {
            String userHome = System.getProperty("user.home");
            File testFile = new File(userHome+File.separator+"TestsC4S"+File.separator+"testReqSec_Deploy_"+numberTests+".txt");
            bufferedReader = new BufferedReader(new FileReader(testFile));
            while ((applicationInstanceUriId = bufferedReader.readLine()) != null) { // while loop begins here
                applicationInstances.add(applicationInstanceUriId);
            } // end while 
        } catch (IOException ex) {
            Logger.getLogger(TestReqSec_Undeploy.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                Logger.getLogger(TestReqSec_Undeploy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
        private class CallableNode implements Callable<Boolean> {
        private final String applicationInstanceUriId;
        private final String BASE_URI;
        private final String publicKey;
        private final String secretKey;

        public CallableNode(String BASE_URI, String applicationInstanceUriId, String publicKey, String secretKey) {
            this.applicationInstanceUriId = applicationInstanceUriId;
            this.BASE_URI = BASE_URI;
            this.publicKey = publicKey;
            this.secretKey = secretKey;
        }

        public Boolean call() throws Exception {  
            final String RS_URI = BASE_URI+"ApplicationDeploymentRS/removeApplication";

            WebClient client = WebClient.create(RS_URI, false);
            client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);

            // POST the request
    //        Response response = applicationDeploymentRS.deployApplication(dis, applicationInstanceJsonObj, paaSInstanceJsonObj);
            List<Attachment> atts = new LinkedList<Attachment>();
            atts.add(new Attachment("applicationInstanceUriId", "text/plain", applicationInstanceUriId));
            atts.add(new Attachment("publicKey", "text/plain", publicKey));
            atts.add(new Attachment("secretKey", "text/plain", secretKey));

            Response response = client.post(new MultipartBody(atts));
            if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.ACCEPTED)
                try {
                    System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response.getEntity()));
                } catch (IOException ex) {
                    Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
                }

                return true;
            }   
    
   
    } 
}
