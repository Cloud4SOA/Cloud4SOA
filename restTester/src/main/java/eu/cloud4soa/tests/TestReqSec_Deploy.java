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
import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.ClientWebApplicationException;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;

/**
 *
 * @author vins
 */
public class TestReqSec_Deploy {
//    final String BASE_URI = "http://localhost:8080/cloud4soa.soa/services/REST/";
    final String BASE_URI = "http://localhost:8080/services/REST/";
    
    private String CloudBeesInstanceUriId = "6e708095-c76d-48f0-a9f7-0d41e4c0bf65";
    private String BeanstalkInstanceUriId = "83aca54a-f60b-41ae-b1e7-09142c3f4ca7";
    private String developerInstanceUriId = "d0a5c841-7c40-4af0-90c5-9a54b14ce5c6";

    private String userInstanceUriId;
    private Map<String, String> paaSInstanceUriIds = new HashMap<String, String>();
    
//    private String selectedPaaS = "Beanstalk";
    private String selectedPaaS = "CloudBees";
    private int numberTests = 20;
    
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
    
    //<applicationInstanceName, applicationInstanceUriId>
    private Map<String, String> applicationInstances = new HashMap<String, String>();


    public String getApplicationInstanceUriId(String applicationInstanceName) {
        return applicationInstances.get(applicationInstanceName);
    }

    public String getPaaSInstanceUriId(String paaSProviderName) {
        return paaSInstanceUriIds.get(paaSProviderName);
    }
    
    public static void main( String[] args ){
        TestReqSec_Deploy initializer = new TestReqSec_Deploy();
        initializer.initialize();
        initializer.deploy();
        initializer.writeOnFileDeployedApplicationsUriId();
    }
    
    public void initialize(){
        
        paaSInstanceUriIds.put("CloudBees", "6e708095-c76d-48f0-a9f7-0d41e4c0bf65");
        paaSInstanceUriIds.put("Beanstalk", "83aca54a-f60b-41ae-b1e7-09142c3f4ca7");
        
        for (int i = 0; i < numberTests; i++) {
            String applicationName="c4sTestReqSeqT"+numberTests+"N"+i;
        
            //Application  
            try {
                ApplicationInstance applicationInstance = createApplicationInstance(applicationName);
                String applicationInstanceUriId = storeApplicationInstance(applicationInstance);
                applicationInstances.put(applicationName, applicationInstanceUriId);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Initializer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void deploy(){
        Collection<CallableNode> children = new ArrayList<CallableNode>();
        for (String applicationInstanceName : applicationInstances.keySet()) {
            String applicationInstanceUriId = applicationInstances.get(applicationInstanceName);
            //Creazione Thread...
            CallableNode callableNode = new CallableNode(BASE_URI, applicationInstanceUriId, getPaaSInstanceUriId(selectedPaaS), getPublicKey(), getSecretKey());
            children.add(callableNode);
        }
        ExecutorService executor = Executors.newFixedThreadPool(numberTests);  
        try {
            List<Future<Boolean>> invokeAll = executor.invokeAll(children);
            for (Future<Boolean> future : invokeAll) {
                while (!future.isDone());
                Boolean get = future.get();
            }
            System.out.print("All "+numberTests+ " deploy requests are completed!");
            executor.shutdownNow();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestReqSec_Deploy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(TestReqSec_Deploy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //            //Applications
        //            try {
        //                deployApplication(applicationInstanceUriId);
        //            } catch (FileNotFoundException ex) {
        //                Logger.getLogger(TestReqSec_Deploy.class.getName()).log(Level.SEVERE, null, ex);
        //            }
    }   
    
//    public void deployApplication(String applicationInstanceUriId) throws FileNotFoundException {
//        final String RS_URI = BASE_URI+"ApplicationDeploymentRS/deployApplication";
//
//        WebClient client = WebClient.create(RS_URI);
//        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
//
//        
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
//        JSONProvider jsonProvider = new JSONProvider();
//        jsonProvider.setSupportUnwrapped(false);
//        jsonProvider.setSerializeAsArray(true);
//        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);
//        
//        // POST the request
////        Response response = applicationDeploymentRS.deployApplication(dis, applicationInstanceJsonObj, paaSInstanceJsonObj);
//        List<Attachment> atts = new LinkedList<Attachment>();
//        atts.add(new Attachment("applicationInstanceUriId", "text/plain", applicationInstanceUriId));
//        atts.add(new Attachment("paaSInstanceUriId", "text/plain", paaSInstanceUriIds.get(selectedPaaS)));
//        atts.add(new Attachment("publicKey", "text/plain", getPublicKey()));
//        atts.add(new Attachment("secretKey", "text/plain", getSecretKey()));
//        atts.add(new Attachment("applicationArchive", "application/octet-stream", dis));
//
//        Response response = client.post(new MultipartBody(atts));
//        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.ACCEPTED)
//            try {
//                System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response.getEntity()));
//            } catch (IOException ex) {
//                Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        
//        try {
//            fis.close();
//            bis.close();
//            dis.close();
//        } catch (IOException ex) {
//            Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    private ApplicationInstance createApplicationInstance(String applicationName) throws FileNotFoundException{
        URL fileURL = this.getClass().getClassLoader().getResource("SimpleWar.war");
        if (fileURL == null)
            throw new FileNotFoundException("SimpleWar.war");
        
        
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        
        File file = new File(fileURL.getPath());
        file.length();
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);
        
        //Calculate digest from InputStream
//        InputStream tempIs = new FileInputStream(file);
        String tempFileDigest = null;
        try {
            FileInputStream tempFis = new FileInputStream(file);
            tempFileDigest = DigestUtils.sha256Hex(tempFis);
        } catch (IOException ex) {
            Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        ApplicationInstance applicationInstance = null;
        applicationInstance = new ApplicationInstance();
        applicationInstance.setAcronym(applicationName);
        applicationInstance.setApplicationcode(applicationName);
        applicationInstance.setDigest(tempFileDigest);
        applicationInstance.setProgramminglanguage("Java");
        applicationInstance.setProgramminglanguageVersion("1.6");
        applicationInstance.setSizeQuantity(new Float(file.length()));
        applicationInstance.setVersion("1.0");
        applicationInstance.setArchiveFileName("SimpleWar");
        applicationInstance.setArchiveExtensionName(".war");
        
        try {
            fis.close();
            bis.close();
            dis.close();
        } catch (IOException ex) {
            Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return applicationInstance;
    }
    
    private String storeApplicationInstance(ApplicationInstance applicationInstance) {
        final String RS_URI = BASE_URI+"ModelManagerRS/storeApplicationProfile";
        String applicationInstanceUriId = null;
        
        WebClient client = WebClient.create(RS_URI, false);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
        List<Attachment> atts = new LinkedList<Attachment>();
        atts.add(new Attachment("applicationInstance", "application/json", applicationInstance));
        atts.add(new Attachment("userInstanceUriId", "text/plain", developerInstanceUriId));
        
        Response response = client.post(new MultipartBody(atts));
        try {
            applicationInstanceUriId = IOUtils.readStringFromStream((InputStream)response.getEntity());
            System.out.println("applicationInstanceUriId: "+applicationInstanceUriId);
        } catch (IOException ex) {
            Logger.getLogger(AnnouncementModuleTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return applicationInstanceUriId;
        }
    }

    private void writeOnFileDeployedApplicationsUriId() {
        BufferedWriter bufferedWriter = null;
        try {
            String userHome = System.getProperty("user.home");
            File testFile = new File(userHome+File.separator+"TestsC4S"+File.separator+"testReqSec_Deploy_"+numberTests+".txt");
            bufferedWriter = new BufferedWriter(new FileWriter(testFile));
            Collection<String> values = applicationInstances.values();
            for (String applicationInstanceUriId : values) {
                 bufferedWriter.write(applicationInstanceUriId);
                 bufferedWriter.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(TestReqSec_Deploy.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(TestReqSec_Deploy.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private class CallableNode implements Callable<Boolean> {
        private final String applicationInstanceUriId;
        private final String BASE_URI;
        private final String publicKey;
        private final String secretKey;
        private final String paaSInstanceUriId;

        public CallableNode(String BASE_URI, String applicationInstanceUriId, String paaSInstanceUriId, String publicKey, String secretKey) {
            this.applicationInstanceUriId = applicationInstanceUriId;
            this.BASE_URI = BASE_URI;
            this.publicKey = publicKey;
            this.secretKey = secretKey;
            this.paaSInstanceUriId = paaSInstanceUriId;
        }

        public Boolean call() throws Exception {  
            final String RS_URI = BASE_URI+"ApplicationDeploymentRS/deployApplication";
            JSONProvider jsonProvider = new JSONProvider();
            jsonProvider.setSupportUnwrapped(false);
            jsonProvider.setSerializeAsArray(true);
            WebClient client = WebClient.create(RS_URI, Collections.singletonList(jsonProvider));
            
            client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);


            URL fileURL = this.getClass().getClassLoader().getResource("SimpleWar.war");
            if (fileURL == null)
                throw new FileNotFoundException("SimpleWar.war");


            ByteArrayOutputStream bas = new ByteArrayOutputStream();

            File file = new File(fileURL.getPath());
            file.length();
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            DataInputStream dis = new DataInputStream(bis);

            //Calculate digest from InputStream
    //        InputStream tempIs = new FileInputStream(file);
            String tempFileDigest = null;
            try {
                FileInputStream tempFis = new FileInputStream(file);
                tempFileDigest = DigestUtils.sha256Hex(tempFis);
            } catch (IOException ex) {
                Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
            }

            // POST the request
    //        Response response = applicationDeploymentRS.deployApplication(dis, applicationInstanceJsonObj, paaSInstanceJsonObj);
            List<Attachment> atts = new LinkedList<Attachment>();
            atts.add(new Attachment("applicationInstanceUriId", "text/plain", applicationInstanceUriId));
            atts.add(new Attachment("paaSInstanceUriId", "text/plain", paaSInstanceUriId));
            atts.add(new Attachment("publicKey", "text/plain", publicKey));
            atts.add(new Attachment("secretKey", "text/plain", secretKey));
            atts.add(new Attachment("applicationArchive", "application/octet-stream", dis));
            try{
            Response response = client.post(new MultipartBody(atts));
            if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.ACCEPTED)
                try {
                    System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response.getEntity()));
                } catch (IOException ex) {
                    Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }catch(ClientWebApplicationException cwe){
                System.out.println("Exception: "+cwe.getCause());
//                cwe.printStackTrace();
            }

            try {
                fis.close();
                bis.close();
                dis.close();
            } catch (IOException ex) {
                Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
            }

            return true;
        }   
    
   
    } 
    
} 
