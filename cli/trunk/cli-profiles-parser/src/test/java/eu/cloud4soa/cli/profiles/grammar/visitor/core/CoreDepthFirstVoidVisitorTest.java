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
package eu.cloud4soa.cli.profiles.grammar.visitor.core;

import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.datamodel.core.UserInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.APIInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.ChannelInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.ComputeInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.DeveloperInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.HardwareComponentInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.OperationInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.PaaSUserInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.SoftwareCategoryInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.SoftwareComponentInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.StorageResourceInstance;
import eu.cloud4soa.cli.profiles.grammar.CloudProfilesParser;
import eu.cloud4soa.cli.profiles.grammar.ParseException;
import eu.cloud4soa.cli.profiles.grammar.syntaxtree.Scope;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vins
 */
public class CoreDepthFirstVoidVisitorTest {

    private Logger logger = LoggerFactory.getLogger( CoreDepthFirstVoidVisitor.class.getName());

    private CloudProfilesParser cpp = null;
    
    private InputStream readFile(String fileName) throws FileNotFoundException{
        URL fileURL = this.getClass().getClassLoader().getResource(fileName);
        logger.debug("****************************** " + fileURL.getPath());
        if (fileURL == null)
            throw new FileNotFoundException(fileName);
        
        
        ByteArrayOutputStream bas = new ByteArrayOutputStream();
        
        File file = new File(fileURL.getPath());
        file.length();
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);
        return dis;
    }
    
    @Test
    public void TestApplicationProfile() throws FileNotFoundException, ParseException{
        InputStream is = readFile("applicationProfile.txt");

        cpp = new CloudProfilesParser(is);
        CoreDepthFirstVoidVisitor visitor = null;
        try {
            Scope scope = cpp.Scope();
            visitor = new CoreDepthFirstVoidVisitor();
            scope.accept(visitor);
        }
        catch (Exception e) {
            logger.error(" exception!!!! " + e.getClass().getName() );
          Assert.fail("Exception: "+e);
        }
        ApplicationInstance applicationInstance = visitor.getApplicationInstance();
        Assert.assertNotNull(applicationInstance);
        logger.debug("%%%%%%%%%%%" + applicationInstance);
        Assert.assertEquals("Application Acronym is different", "C4Sv1.0", applicationInstance.getAcronym());
        Assert.assertEquals("Application Version is different", "1.0", applicationInstance.getVersion());
        Assert.assertEquals("Application Archive Name is different", "SimpleAppName", applicationInstance.getArchiveFileName());
        Assert.assertEquals("Application Archive Extension Name is different", ".war", applicationInstance.getArchiveExtensionName());
        Assert.assertEquals("Application Programming language is different", "Java", applicationInstance.getProgramminglanguage());
        Assert.assertEquals("Application Programming language Version is different", "1.6", applicationInstance.getProgramminglanguageVersion());
//        Iterator<SoftwareComponentInstance> softwareComponents = applicationInstance.getSoftwareComponents();
        List<SoftwareComponentInstance> softwareComponents = applicationInstance.getSoftwareComponents();
//        Assert.assertTrue("Application SoftwareComponents is not empty", softwareComponents.hasNext());
        Assert.assertTrue("Application SoftwareComponents is not empty", softwareComponents.size()>0);
//        while (softwareComponents.hasNext()) {
        for (SoftwareComponentInstance softwareComponentInstance : softwareComponents) {
//            SoftwareComponentInstance softwareComponentInstance = softwareComponents.next();
            SoftwareCategoryInstance softwareCategoryInstance = softwareComponentInstance.getSoftwareCategoryInstance();
            // category: web_server description: (HostApplications) 
            Assert.assertEquals("SoftwareCategory name is different", "web server", softwareCategoryInstance.getTitle());
            Assert.assertEquals("SoftwareCategory description is different", "Host applications", softwareCategoryInstance.getDescription());
            //{ component : apache_tomcat description : (ApacheTomcatApplicationServer) version : 7.0 license : GPL} 
            Assert.assertEquals("SoftwareComponent name is different", "apache tomcat", softwareComponentInstance.getTitle());
            Assert.assertEquals("SoftwareComponent description is different", "Apache Tomcat Application Server", softwareComponentInstance.getDescription());
            Assert.assertEquals("SoftwareComponent version is different", "7.0", softwareComponentInstance.getVersion());
            Assert.assertEquals("SoftwareComponent license type is different", "GPL", softwareComponentInstance.getLicensetype());
//            Assert.assertFalse("Application has more than one SoftwareComponent ", softwareComponents.hasNext());
            Assert.assertFalse("Application has more than one SoftwareComponent ", softwareComponents.size()>1);
        }
//        Iterator<HardwareComponentInstance> hardwareComponents = applicationInstance.getHardwareComponents();
        List<HardwareComponentInstance> hardwareComponents = applicationInstance.getHardwareComponents();
//        Assert.assertTrue("Application hardwareComponents is not empty", hardwareComponents.hasNext());
        Assert.assertTrue("Application hardwareComponents is not empty", !hardwareComponents.isEmpty());
//        while (hardwareComponents.hasNext()) {
//            HardwareComponentInstance hardwareComponentInstance = hardwareComponents.next();
        for (HardwareComponentInstance hardwareComponentInstance : hardwareComponents) {
            //compute component : Pentium description : (intelPentium) architecture : x86 cores : 1 speed : 2000 memory : 1024 cache : 2048
            Assert.assertTrue("HardwareComponent relatedhwcategoryInstance is not a ComputeInstance", (hardwareComponentInstance.getRelatedhwcategoryInstance() instanceof ComputeInstance));
            ComputeInstance computeInstance = (ComputeInstance)hardwareComponentInstance.getRelatedhwcategoryInstance();
            Assert.assertEquals("HardwareComponent name is different", "Pentium", computeInstance.getTitle());
            Assert.assertEquals("HardwareComponent description is different", "intel Pentium", computeInstance.getDescription());
            Assert.assertEquals("HardwareComponent computeInstance Architecture is different", "x86", computeInstance.getArchitecture());
            Assert.assertNotNull("HardwareComponent computeInstance Cores is null", computeInstance.getHasCores());
            Assert.assertEquals("HardwareComponent computeInstance Cores is different", new Float(1), computeInstance.getHasCores().getMin());
            Assert.assertEquals("HardwareComponent computeInstance Speed is different", new Float(2000), computeInstance.getMinSpeedValue());
            Assert.assertEquals("HardwareComponent computeInstance Memory is different", new Float(1024), computeInstance.getMinMemoryValue());
            Assert.assertEquals("HardwareComponent computeInstance Cache is different", new Float(2048), computeInstance.getMinCacheValue());
//            Assert.assertFalse("Application has more than one HardwareComponent ", hardwareComponents.hasNext());
            Assert.assertFalse("Application has more than one HardwareComponent ", hardwareComponents.size()>1);
        }
        try {
            is.close();
        } catch (IOException ex) {
            logger.error("Error closing the stream", ex);
        }
    }

    
    @Test
    public void TestApplicationProfile1() throws FileNotFoundException, ParseException{
        InputStream is = readFile("applicationProfile_1.txt");
        
        cpp.ReInit(is);
        CoreDepthFirstVoidVisitor visitor = null;
        try {
            
            Scope scope = cpp.Scope();
            visitor = new CoreDepthFirstVoidVisitor();
            scope.accept(visitor);
        }
        catch (Exception e) {
            logger.error("error", e);
          Assert.fail("Exception: "+e);
        }
        ApplicationInstance applicationInstance = visitor.getApplicationInstance();
        Assert.assertNotNull(applicationInstance);
        logger.debug( "ApplicationInstance" + applicationInstance);
        Assert.assertEquals("Application Acronym is different", "C4Sv1.0", applicationInstance.getAcronym());
        Assert.assertEquals("Application Version is different", "1.0", applicationInstance.getVersion());
        Assert.assertEquals("Application Archive Name is different", "SimpleAppName", applicationInstance.getArchiveFileName());
        Assert.assertEquals("Application Archive Extension Name is different", ".war", applicationInstance.getArchiveExtensionName());
        Assert.assertEquals("Application Programming language is different", "Java", applicationInstance.getProgramminglanguage());
        Assert.assertEquals("Application Programming language Version is different", "1.6", applicationInstance.getProgramminglanguageVersion());
//        Iterator<SoftwareComponentInstance> softwareComponents = applicationInstance.getSoftwareComponents();
        List<SoftwareComponentInstance> softwareComponents = applicationInstance.getSoftwareComponents();

//        Assert.assertTrue("softwareComponents has no expected element", softwareComponents.hasNext());
        Assert.assertTrue("softwareComponents has no expected element", !softwareComponents.isEmpty());
//        SoftwareComponentInstance softwareComponentInstance = softwareComponents.next();
        SoftwareComponentInstance softwareComponentInstance = softwareComponents.get(0);        
        SoftwareCategoryInstance softwareCategoryInstance = softwareComponentInstance.getSoftwareCategoryInstance();
        // category: web_server description: (HostApplications) 
               Assert.assertEquals("SoftwareCategory name is different", "web server", softwareCategoryInstance.getTitle());
        Assert.assertEquals("SoftwareCategory description is different", "Host applications", softwareCategoryInstance.getDescription());
        //{ component : apache_tomcat description : (ApacheTomcatApplicationServer) version : 7.0 license : GPL} 
        Assert.assertEquals("SoftwareComponent name is different", "apache tomcat", softwareComponentInstance.getTitle());
        Assert.assertEquals("SoftwareComponent description is different", "Apache Tomcat Application Server", softwareComponentInstance.getDescription());
        Assert.assertEquals("SoftwareComponent version is different", "7.0", softwareComponentInstance.getVersion());
        Assert.assertEquals("SoftwareComponent license type is different", "GPL", softwareComponentInstance.getLicensetype());
        
//        Assert.assertTrue("softwareComponents has no expected element", softwareComponents.hasNext());
        Assert.assertTrue("softwareComponents has no expected element", softwareComponents.size()>1);
//        softwareComponentInstance = softwareComponents.next();
        softwareComponentInstance = softwareComponents.get(1);
        softwareCategoryInstance = softwareComponentInstance.getSoftwareCategoryInstance();
        // category: web_server description: (HostApplications) 
        Assert.assertEquals("SoftwareCategory name is different", "database", softwareCategoryInstance.getTitle());
        Assert.assertEquals("SoftwareCategory description is different", "Storage of data", softwareCategoryInstance.getDescription());
        //{ component : apache_tomcat description : (ApacheTomcatApplicationServer) version : 7.0 license : GPL} 
        Assert.assertEquals("SoftwareComponent name is different", "MySQL", softwareComponentInstance.getTitle());
        Assert.assertEquals("SoftwareComponent description is different", "MySQL server", softwareComponentInstance.getDescription());
        Assert.assertEquals("SoftwareComponent version is different", "5.6", softwareComponentInstance.getVersion());
        Assert.assertEquals("SoftwareComponent license type is different", "GPL", softwareComponentInstance.getLicensetype());
//        Assert.assertFalse("softwareComponents has an unexpected element", softwareComponents.hasNext());
        Assert.assertFalse("softwareComponents has an unexpected element", softwareComponents.size()>2);
        
//        Iterator<HardwareComponentInstance> hardwareComponents = applicationInstance.getHardwareComponents();
        List<HardwareComponentInstance> hardwareComponents = applicationInstance.getHardwareComponents();
//        hardwareComponents.hasNext();
//        Assert.assertTrue("Application hardwareComponents has no expected element", hardwareComponents.hasNext());
        Assert.assertTrue("Application hardwareComponents has no expected element", hardwareComponents.size()>0);
//        HardwareComponentInstance hardwareComponentInstance = hardwareComponents.next();
        HardwareComponentInstance hardwareComponentInstance = hardwareComponents.get(0);
        //compute component : Pentium description : (intelPentium) architecture : x86 cores : 1 speed : 2000 memory : 1024 cache : 2048
        Assert.assertTrue("HardwareComponent relatedhwcategoryInstance is not a ComputeInstance", (hardwareComponentInstance.getRelatedhwcategoryInstance() instanceof ComputeInstance));
        ComputeInstance computeInstance = (ComputeInstance)hardwareComponentInstance.getRelatedhwcategoryInstance();
        Assert.assertEquals("HardwareComponent name is different", "Pentium", computeInstance.getTitle());
        Assert.assertEquals("HardwareComponent description is different", "intel Pentium", computeInstance.getDescription());
        Assert.assertEquals("HardwareComponent computeInstance Architecture is different", "x86", computeInstance.getArchitecture());
        Assert.assertNotNull("HardwareComponent computeInstance Cores is null", computeInstance.getHasCores());
        Assert.assertEquals("HardwareComponent computeInstance Cores is different", new Float(1), computeInstance.getHasCores().getMin());
        Assert.assertEquals("HardwareComponent computeInstance Speed is different", new Float(2000), computeInstance.getMinSpeedValue());
        Assert.assertEquals("HardwareComponent computeInstance Memory is different", new Float(1024), computeInstance.getMinMemoryValue());
        Assert.assertEquals("HardwareComponent computeInstance Cache is different", new Float(2048), computeInstance.getMinCacheValue());
        
//        Assert.assertTrue("Application hardwareComponents has no expected element", hardwareComponents.hasNext());
        Assert.assertTrue("Application hardwareComponents has no expected element", hardwareComponents.size()>1);
//        hardwareComponentInstance = hardwareComponents.next();
        hardwareComponentInstance = hardwareComponents.get(1);
        //storage_resource component : FileSystem description : (FileSystemResource) capacity : 50000 
        Assert.assertTrue("HardwareComponent relatedhwcategoryInstance is not a ComputeInstance", (hardwareComponentInstance.getRelatedhwcategoryInstance() instanceof StorageResourceInstance));
        StorageResourceInstance storageResourceInstance = (StorageResourceInstance)hardwareComponentInstance.getRelatedhwcategoryInstance();
        Assert.assertEquals("HardwareComponent name is different", "FileSystem", storageResourceInstance.getTitle());
        Assert.assertEquals("HardwareComponent storageResourceInstance Capacity is different", new Float(50000), storageResourceInstance.getMinCapacityValue());
        
//        Assert.assertFalse("Application hardwareComponents an unexpected element", softwareComponents.hasNext());
        Assert.assertFalse("Application hardwareComponents has an unexpected element", softwareComponents.size()>2);
        
        try {
            is.close();
        } catch (IOException ex) {
            logger.error("Error closing the stream", ex);
        }
    }
    
    @Test
    public void TestPaaSProfile() throws FileNotFoundException, ParseException{
        InputStream is = readFile("paasProfile.txt");
        
        cpp.ReInit(is);
        CoreDepthFirstVoidVisitor visitor = null;
        try {
            Scope scope = cpp.Scope();
            visitor = new CoreDepthFirstVoidVisitor();
            scope.accept(visitor);
        }
        catch (Exception e) {
          Assert.fail("Exception: "+e);
        }
        PaaSInstance paasInstance = visitor.getPaaSInstance();
        Assert.assertNotNull(paasInstance);
        logger.debug("PaaSInstance " + paasInstance);
        Assert.assertEquals("PaaS title is different", "CloudBees", paasInstance.getTitle());
        
        //Channels
        List<ChannelInstance> channels = paasInstance.getChannels();
        Assert.assertNotNull("Channels is null", channels);
        Assert.assertEquals("Channels has a bad size", 1, channels.size());
        ChannelInstance channelInstance = channels.get(0);
        Assert.assertTrue("Channel is not an API", (channelInstance instanceof APIInstance));
        APIInstance apiInstance = (APIInstance)channelInstance;
        
        //Operations
        List<OperationInstance> operations = apiInstance.getOperations();
        Assert.assertNotNull("Operations list is null", operations);
        Assert.assertEquals("Operations list has a bad size", 1, operations.size());
        OperationInstance operationInstance = operations.get(0);
        Assert.assertEquals("Operation name is different", "checkApplicationAvailability", operationInstance.getTitle());
        Assert.assertEquals("Operation description is different", "Checks whether the specified application name is available", operationInstance.getDescription());
        Assert.assertEquals("Operation command is different", "checkAppAvailability", operationInstance.getOperationCommand());
        Assert.assertEquals("Operation informationReturned is different", "null", operationInstance.getInformationReturned());
        
        //Programming Language
        String supportedProgrammingLanguage = paasInstance.getSupportedProgrammingLanguage();
        Assert.assertEquals("ProgrammingLanguage is different", "Java", supportedProgrammingLanguage);
        String supportedProgrammingLanguageVersion = paasInstance.getSupportedProgrammingLanguageVersion();
        Assert.assertEquals("ProgrammingLanguage Version is different", "1.6", supportedProgrammingLanguageVersion);
        
        //Software
        List<SoftwareComponentInstance> softwareComponents = paasInstance.getSoftwareComponents();
        Assert.assertEquals("PaaSInstance SoftwareComponents is not empty", 1, softwareComponents.size());
        SoftwareComponentInstance softwareComponentInstance = softwareComponents.get(0);
        SoftwareCategoryInstance softwareCategoryInstance = softwareComponentInstance.getSoftwareCategoryInstance();
        // category: web_server description: (HostApplications)
        Assert.assertEquals("SoftwareCategory name is different", "web server", softwareCategoryInstance.getTitle());
        Assert.assertEquals("SoftwareCategory description is different", "Host applications", softwareCategoryInstance.getDescription());
        //{ component : apache_tomcat description : (ApacheTomcatApplicationServer) version : 7.0 license : GPL}
        Assert.assertEquals("SoftwareComponent name is different", "apache tomcat", softwareComponentInstance.getTitle());
        Assert.assertEquals("SoftwareComponent description is different", "Apache Tomcat Application Server", softwareComponentInstance.getDescription());
        Assert.assertEquals("SoftwareComponent version is different", "7.0", softwareComponentInstance.getVersion());
        Assert.assertEquals("SoftwareComponent license type is different", "GPL", softwareComponentInstance.getLicensetype());
        
        //Hardware
        List<HardwareComponentInstance> hardwareComponents = paasInstance.getHardwareComponents();
        Assert.assertEquals("PaaSInstance HardwareComponents is not empty", 1, hardwareComponents.size());
        HardwareComponentInstance hardwareComponentInstance = hardwareComponents.get(0);
        //compute component : Pentium description : (intelPentium) architecture : x86 cores : 1 speed : 2000 memory : 1024 cache : 2048
        Assert.assertTrue("HardwareComponent relatedhwcategoryInstance is not a ComputeInstance", (hardwareComponentInstance.getRelatedhwcategoryInstance() instanceof ComputeInstance));
        ComputeInstance computeInstance = (ComputeInstance)hardwareComponentInstance.getRelatedhwcategoryInstance();
        Assert.assertEquals("HardwareComponent name is different", "Pentium", computeInstance.getTitle());
        Assert.assertEquals("HardwareComponent description is different", "intel Pentium", computeInstance.getDescription());
        Assert.assertEquals("HardwareComponent computeInstance Architecture is different", "x86", computeInstance.getArchitecture());
        Assert.assertNotNull("HardwareComponent computeInstance Cores is null", computeInstance.getHasCores());
        Assert.assertEquals("HardwareComponent computeInstance Cores is different", new Float(1), computeInstance.getHasCores().getMin());
        Assert.assertEquals("HardwareComponent computeInstance Speed is different", new Float(2000), computeInstance.getMinSpeedValue());
        Assert.assertEquals("HardwareComponent computeInstance Memory is different", new Float(1024), computeInstance.getMinMemoryValue());
        Assert.assertEquals("HardwareComponent computeInstance Cache is different", new Float(2048), computeInstance.getMinCacheValue());
        
        try {
            is.close();
        } catch (IOException ex) {
            logger.error("Error closing the stream", ex);
        }

    }
    
    @Test
    public void TestUserProfile() throws FileNotFoundException, ParseException{
        InputStream is = readFile("userProfile.txt");
        
        cpp.ReInit(is);
        CoreDepthFirstVoidVisitor visitor = null;
        try {
            Scope scope = cpp.Scope();
            visitor = new CoreDepthFirstVoidVisitor();
            scope.accept(visitor);
        }
        catch (Exception e) {
          Assert.fail("Exception: "+e);
        }
        UserInstance userInstance = visitor.getUserInstance();
        Assert.assertNotNull(userInstance);
        logger.debug("UserInstance" + userInstance);
        Assert.assertTrue("UserInstance is not a DeveloperInstance", (userInstance instanceof DeveloperInstance));
        DeveloperInstance developer = (DeveloperInstance)userInstance;
        //username : vlaudizio password : pwd firstname : Vincenzo surname : Laudizio email : vincenzo.laudizio@gmail.com
        Assert.assertEquals("DeveloperInstance Accountname is different", "vlaudizio", developer.getAccountname());        
        Assert.assertEquals("DeveloperInstance Firstname is different", "Vincenzo", developer.getFirstName());      
        Assert.assertEquals("DeveloperInstance Surname is different", "Laudizio", developer.getSurname());      
        Assert.assertEquals("DeveloperInstance Email is different", "vincenzo.laudizio@gmail.com", developer.getPersonalmailbox());      
        
        try {
            is.close();
        } catch (IOException ex) {
            logger.error("Error closing the stream", ex);
        }
    }
    
    @Test
    public void TestUserProfile1() throws FileNotFoundException, ParseException{
        InputStream is = readFile("userProfile_1.txt");
        
        cpp.ReInit(is);
        CoreDepthFirstVoidVisitor visitor = null;
        try {
            Scope scope = cpp.Scope();
            visitor = new CoreDepthFirstVoidVisitor();
            scope.accept(visitor);
        }
        catch (Exception e) {
          Assert.fail("Exception: "+e);
        }
        UserInstance userInstance = visitor.getUserInstance();
        Assert.assertNotNull(userInstance);
        logger.debug("UserInstance" + userInstance);
        Assert.assertTrue("UserInstance is not a PaaSUserInstance", (userInstance instanceof PaaSUserInstance));
        PaaSUserInstance provider = (PaaSUserInstance)userInstance;
        Assert.assertEquals("PaaSUserInstance PaaSProvider Name is different", "CloudBees", provider.getPaaSProviderInstance().getTitle());
        Assert.assertEquals("PaaSUserInstance PaaSProvider HomePage is different", "http://www.cloudbees.com", provider.getPaaSProviderInstance().getHomePage());
        //username : vlaudizio password : pwd firstname : Vincenzo surname : Laudizio email : vincenzo.laudizio@gmail.com
        Assert.assertEquals("PaaSUserInstance Accountname is different", "CloudBees", provider.getAccountname());        
        Assert.assertEquals("PaaSUserInstance Firstname is different", "CloudBees", provider.getFirstName());      
        Assert.assertEquals("PaaSUserInstance Surname is different", "CloudBees", provider.getSurname());      
        Assert.assertEquals("PaaSUserInstance Email is different", "support@cloudbees.com", provider.getPersonalmailbox());      
        
        try {
            is.close();
        } catch (IOException ex) {
            logger.error("Error closing the stream", ex);
        }
    }
}
