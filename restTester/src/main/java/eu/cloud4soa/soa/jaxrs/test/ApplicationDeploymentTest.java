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


package eu.cloud4soa.soa.jaxrs.test;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.apache.cxf.jaxrs.provider.ProviderFactory;
//import org.apache.wink.providers.json.JsonProvider;
//import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONObject;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;
import org.json.JSONException;
import org.json.JSONObject;


public class ApplicationDeploymentTest 
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        ApplicationDeploymentTest adt = new ApplicationDeploymentTest();
//        adt.startStopApplication();
        adt.deployApplication();
    }

    public void deployApplication() throws FileNotFoundException {
//        final String BASE_URI = "http://localhost:8080/frontend-dashboard-0.0.1-SNAPSHOT/services/REST/ApplicationDeploymentRS/deployApplication";
        final String BASE_URI = "http://localhost:8080/cloud4soa.soa/services/REST/ApplicationDeploymentRS/deployApplication";

        WebClient client = WebClient.create(BASE_URI);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
//        ContentDisposition cd = new ContentDisposition("attachment;filename=image.jpg");
//        Attachment att = new Attachment("root", imageInputStream, cd);

        
//        ApplicationDeployment applicationDeploymentRS = (ApplicationDeployment) JAXRSClientFactory.create("http://localhost:8080/books", ApplicationDeployment.class);
//        WebClient.client(applicationDeploymentRS).type("multipart/mixed");


        
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

                    
//        JSONObject applicationInstanceJsonObj=new JSONObject();
//        try {
//            applicationInstanceJsonObj.put("acronym","App1");
//            applicationInstanceJsonObj.put("applicationcode","001");
//            applicationInstanceJsonObj.put("programminglanguage","Java");
//        } catch (JSONException ex) {
//            ex.printStackTrace();
//        }
//
//        System.out.println(applicationInstanceJsonObj);
        
        JSONObject applicationInstanceJsonObj=new JSONObject();
        try {
            applicationInstanceJsonObj.put("acronym","SimpleWar");
            applicationInstanceJsonObj.put("archiveFileName","app");
            applicationInstanceJsonObj.put("archiveExtensionName",".war");
            applicationInstanceJsonObj.put("digest", tempFileDigest);
            applicationInstanceJsonObj.put("sizeQuantity",file.length());
            applicationInstanceJsonObj.put("version","2");
//            applicationInstanceJsonObj.put("","");
        } catch (JSONException ex) {
            Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(applicationInstanceJsonObj);
        
        JSONObject paaSInstanceJsonObj=new JSONObject();
        try {
//            paaSInstanceJsonObj.put("providerTitle","CloudBees");
            paaSInstanceJsonObj.put("providerTitle","Beanstalk");
        } catch (JSONException ex) {
            Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(paaSInstanceJsonObj);
        
        ProviderFactory.getSharedInstance().registerUserProvider(new JSONProvider());
        // POST the request
//        Response response = applicationDeploymentRS.deployApplication(dis, applicationInstanceJsonObj, paaSInstanceJsonObj);
        Attachment att1 = new Attachment("applicationInstance", "application/json", applicationInstanceJsonObj.toString());
        Attachment att2 = new Attachment("paaSInstance", "application/json", paaSInstanceJsonObj.toString());
        Attachment att3 = new Attachment("applicationArchive", "application/octet-stream", dis);
        List<Attachment> listAttch = new LinkedList<Attachment>();
        listAttch.add(att1);
        listAttch.add(att2);
        listAttch.add(att3);
        Response response = client.post(new MultipartBody(listAttch));
        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.ACCEPTED)
            try {
                System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response.getEntity()));
            } catch (IOException ex) {
                Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        try {
            fis.close();
            bis.close();
            dis.close();
        } catch (IOException ex) {
            Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void startStopApplication() {
//        final String BASE_URI = "http://localhost:8080/cloud4soa.soa/services/REST/";

        
        JSONObject applicationInstanceJsonObj=new JSONObject();
        try {
            applicationInstanceJsonObj.put("acronym","App1");
            applicationInstanceJsonObj.put("applicationcode","001");
            applicationInstanceJsonObj.put("programminglanguage","Java");
        } catch (JSONException ex) {
            ex.printStackTrace();
        }

        System.out.println(applicationInstanceJsonObj);
        
        JSONObject startStopCommandJsonObj=new JSONObject();
        try {
            startStopCommandJsonObj.put("startStopCommand", "start");
        } catch (JSONException ex) {
            Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(startStopCommandJsonObj);
        
        //Cannot use Multipart with Proxy
//        ApplicationDeployment applicationDeploymentRS = (ApplicationDeployment) JAXRSClientFactory.create("http://localhost:8080/soa-0.0.1-SNAPSHOT/", ApplicationDeployment.class);
//        Response response = applicationDeploymentRS.startStopApplication(applicationInstanceJsonObj, startStopCommandJsonObj);
        
        ProviderFactory.getSharedInstance().registerUserProvider(new JSONProvider());

       JSONObject tosend = null;
       JSONObject tosend1 = null;
        try {
//            tosend = new JSONObject().put("application", applicationInstanceJsonObj);
            tosend = applicationInstanceJsonObj;
            tosend1 = new JSONObject().put("startStopCommandJsonObj", startStopCommandJsonObj);
        } catch (JSONException ex) {
            Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("applicationInstance", MediaType.APPLICATION_JSON , tosend.toString()));

        atts.add(new Attachment("startStopCommandJsonObj", MediaType.APPLICATION_JSON , tosend1.toString()));
        
//        WebClient webClient = WebClient.create("http://localhost:8080/frontend-dashboard-0.0.1-SNAPSHOT/services/REST/ApplicationDeploymentRS/startStopApplication");
            WebClient webClient = WebClient.create("http://localhost:8080/cloud4soa.soa/services/REST/ApplicationDeploymentRS/startStopApplication");
        webClient.type("multipart/form-data").accept(MediaType.TEXT_PLAIN);
//        Response response = webClient.post(new MultipartBody(atts));
//          Map<String, Object> objects = new LinkedHashMap<String, Object>();
//        objects.put(MediaType.APPLICATION_JSON, tosend.toString());
//        objects.put(MediaType.APPLICATION_JSON, tosend1.toString());
        MultipartBody body = new MultipartBody(atts, true);
        Response response = webClient.post(body);
        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.ACCEPTED)
            try {
                System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response.getEntity()));
            } catch (IOException ex) {
                Logger.getLogger(ApplicationDeploymentTest.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
}
