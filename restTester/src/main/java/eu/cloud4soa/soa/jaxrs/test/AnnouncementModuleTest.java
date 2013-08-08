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

import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.HttpRequestsHandlerInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.CLIInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.ChannelType;
import eu.cloud4soa.api.datamodel.core.utilBeans.ExceptionInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.HardwareCategoryType;
import eu.cloud4soa.api.datamodel.core.utilBeans.HardwareComponentInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.OperationInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.ParameterInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.SoftwareCategoryInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.SoftwareComponentInstance;
import eu.cloud4soa.api.soa.AnnouncementModule;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
public class AnnouncementModuleTest {
    private static final Logger logger = LoggerFactory.getLogger(AnnouncementModuleTest.class);
    
//    final String BASE_URI = "http://localhost:8080/cloud4soa.soa/services/REST/AnnouncementModuleRS/";
    final String BASE_URI = "http://localhost:8080/services/REST/AnnouncementModuleRS/";
    private String paaSInstanceUriId;
    private PaaSInstance paaSInstance;
    private UserManagementAndSecurityModuleTest userManagementAndSecurityModuleTest;
//    private String paaSUserUriId = "36c07620-69c0-464c-9b80-9bea69afaef0";
    private String paaSUserUriId = "7c956764-4d15-40c3-93f9-f3ea6e54abea";
    

    public AnnouncementModuleTest() {
        userManagementAndSecurityModuleTest = new UserManagementAndSecurityModuleTest();
    }
    
    
    
    public static void main( String[] args )
    {
        AnnouncementModuleTest amt = new AnnouncementModuleTest();
        try {
            //        amt.createPaaSInstance();
            //        amt.storePaaSInstance();
            //        amt.getPaaSInstance();
                    amt.retrieveAllPaaSInstances();
            //        amt.updatePaaSInstance();
                    
            //        amt.removePaaSInstance();
        } catch (SOAException ex) {
            logger.error("error: retrieveAllPaaSInstances", ex.getMessage());
        }
    }
    
//    PaaSInstance getPaaSInstance(String paasInstanceUriId);
//    
//    void storePaaSInstance(PaaSInstance paaSInstance, String userInstanceUriId);
//    
//    List<PaaSInstance> retrieveAllPaaSInstances(String userInstanceUriId);
//    
//    void updatePaaSInstance(PaaSInstance paaSInstance);
//
//    void removePaaSInstance(String paasInstanceUriId);

    private void storePaaSInstance() {
        paaSUserUriId = userManagementAndSecurityModuleTest.createNewPaaSUserAccount();
        
        WebClient client = WebClient.create(BASE_URI+"storePaaSInstance");
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
//        ProviderFactory.getSharedInstance().registerUserProvider(new JSONProvider());
        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("paaSInstance", MediaType.APPLICATION_JSON , paaSInstance));

        atts.add(new Attachment("userInstanceUriId", MediaType.TEXT_PLAIN , paaSUserUriId));
        
        Response response = client.post(new MultipartBody(atts));
        try {
            paaSInstanceUriId = IOUtils.readStringFromStream((InputStream)response.getEntity());
            System.out.println("paaSInstanceUriId: "+paaSInstanceUriId);
        } catch (IOException ex) {
            logger.error("error in reading the response!", ex.getMessage());
        }
    }
    
    
    private void getPaaSInstance() throws SOAException {
        AnnouncementModule announcementModule = JAXRSClientFactory.create(BASE_URI, AnnouncementModule.class);
        PaaSInstance retrievedPaaSInstance = announcementModule.getPaaSInstance(paaSInstanceUriId);
        System.out.println("retrievedPaaSInstance: "+retrievedPaaSInstance);
    }
    
    private void retrieveAllPaaSInstances() throws SOAException{
        AnnouncementModule announcementModule = JAXRSClientFactory.create(BASE_URI, AnnouncementModule.class);
        List<PaaSInstance> retrieveAllPaaSInstances = announcementModule.retrieveAllPaaSInstances(paaSUserUriId);
        for (PaaSInstance retrievedPaaSInstance : retrieveAllPaaSInstances) {
            System.out.println("retrievedPaaSInstance: "+retrievedPaaSInstance);
        }
    }
    
    private void updatePaaSInstance() throws SOAException{
        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);
        
        AnnouncementModule announcementModule = JAXRSClientFactory.create(BASE_URI, AnnouncementModule.class);
        PaaSInstance retrievedPaaSInstance = announcementModule.getPaaSInstance(paaSInstanceUriId);
        System.out.println("retrieved retrievedPaaSInstance: "+ retrievedPaaSInstance.getUriId());
        List<SoftwareComponentInstance> softwareComponents = retrievedPaaSInstance.getSoftwareComponents();
        for (SoftwareComponentInstance softwareComponentInstance : softwareComponents) {
            softwareComponentInstance.setVersion("4.0");
            System.out.println("Modified version to 4.0");
        }
        announcementModule.updatePaaSInstance(retrievedPaaSInstance);
        PaaSInstance retrievedModifiedPaaSInstance = announcementModule.getPaaSInstance(paaSInstanceUriId);
        List<SoftwareComponentInstance> modifiedSoftwareComponents = retrievedModifiedPaaSInstance.getSoftwareComponents();
        for (SoftwareComponentInstance softwareComponentInstance : modifiedSoftwareComponents) {
            System.out.println("Updated version: "+softwareComponentInstance.getVersion());
        }
    }
    
//    public void createTestPaasInstance() {
//            paaSInstance = new PaaSInstance();
//            paaSInstance.setTitle("CloudControl");
//            paaSInstance.setSupportedProgramminglanguage("PHP");
//            paaSInstance.setProviderTitle("Cloud Control Inc.");
//            paaSInstance.setStatus("Active");
//            paaSInstance.setURL("http://cloudcontrol.com/");
//    }
    
    public void createPaaSInstance(){
//        List<PaaSInstance> providedPaaSInstances = new ArrayList<PaaSInstance>();
        paaSInstance = new PaaSInstance();
        
        paaSInstance.setTitle("CloudControl PHP");
        
        //Offering
        paaSInstance.setURL("http://cloudcontrol.com/home/");
        paaSInstance.setStatus("Available"); 
        CLIInstance cLIInstance = (CLIInstance) paaSInstance.createAndAddChannel(ChannelType.CLI);
        cLIInstance.setTitle("CLI");
        cLIInstance.setDescription("The command line client is a powerful interface to our API enabling developers to control all features of the cloudControl platform");
        cLIInstance.setVersion("1.0");
        cLIInstance.setURL("http://cloudcontrol.com/CLI");
        OperationInstance operationInstance = cLIInstance.createAndAddOperation("create", "create new application", "cctrlapp <app_name> create php", "");
        ParameterInstance parameterInstance = new ParameterInstance("app_name", "Application Name", false, "hellocc");
        operationInstance.addRequiredParameter(parameterInstance);
        ExceptionInstance exceptionInstance = new ExceptionInstance("APPLICATION_NOT_FOUND", "Application not found", "Uknown");
        operationInstance.addThrownException(exceptionInstance);
        HardwareComponentInstance hardwareComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.HttpRequestHandlerCategory);
//        List<HardwareComponentInstance> hardwareComponents = paaSInstance.getHardwareComponents();
//        for (HardwareComponentInstance hardwareComponentInstance : hardwareComponents) {
//            System.out.println("*** "+hardwareComponentInstance);
//        }
        
        hardwareComponent.setTitle("cloudcontrol box");
        
//      fill the hardwareComponent parameters
//        HttpRequestsHandlerInstance boxInstance = (HttpRequestsHandlerInstance) hardwareComponent.getRelatedhwcategoryInstance();
        HttpRequestsHandlerInstance boxInstance = (HttpRequestsHandlerInstance)hardwareComponent;
        List<Float> v = new ArrayList<Float>();
        v.add(3f);
        boxInstance.setHTTPRequestsValues(v);
        System.out.println(hardwareComponent.getRelatedhwcategoryInstance());
        
        SoftwareCategoryInstance softwareCategoryInstance = new SoftwareCategoryInstance("RDBMS", "relational database");
        paaSInstance.createAndAddSoftwareComponent("MySQL", "MySQL is one of the most used relational database systems for web applications", 
        		"5.5.16", "GPL", softwareCategoryInstance);
        paaSInstance.setSupportedProgrammingLanguage("PHP");
     
//        providedPaaSInstances.add(paaSInstance);         
    }
}
