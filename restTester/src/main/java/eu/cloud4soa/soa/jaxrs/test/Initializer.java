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
import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.datamodel.core.UserInstance;
import eu.cloud4soa.api.datamodel.core.qos.LatencyInstance;
import eu.cloud4soa.api.datamodel.core.qos.ServiceQualityInstance;
import eu.cloud4soa.api.datamodel.core.qos.UptimeInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.APIInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.HttpRequestsHandlerInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.ChannelType;
import eu.cloud4soa.api.datamodel.core.utilBeans.ComputeInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.DBStorageComponentInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.DeveloperInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.HardwareCategoryType;
import eu.cloud4soa.api.datamodel.core.utilBeans.HardwareComponentInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.NetworkResourceInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.OperationInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.PaaSProviderInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.PaaSUserInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.SoftwareCategoryInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.SoftwareComponentInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.SqlDbCategoryInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.StorageResourceInstance;
import eu.cloud4soa.api.soa.ModelManager;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.codec.digest.DigestUtils;
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
public class Initializer {
    private static final Logger logger = LoggerFactory.getLogger(Initializer.class);
    
//    final String BASE_URI = "http://localhost:8080/cloud4soa.soa/services/REST/";
//    final String BASE_URI = "http://localhost:8080/frontend-dashboard-0.0.2-SNAPSHOT/services/REST/";

    final String BASE_URI = "http://localhost:8080/services/REST/";

    private PaaSInstance paaSInstance;
    private PaaSUserInstance paaSUserInstance;
    String paaSUserUsername = "";
    String paaSUserPassword = "";
    private String userInstanceUriId;
    private Map<String, String> paaSInstanceUriIds = new HashMap<String, String>();
//    private String selectedPaaS = "Beanstalk";
    private String selectedPaaS = "CloudBees";
    //Beanstalk
//    String publicKey="AKIAJRSZ7FBNKBAOUR6A";
//    String secretKey="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";
    //CloudBees
    String publicKey = "4184E8A5D19D02D9";
    String secretKey = "UZPYSQVJMQLVNNVK6GSZQPRUTAZ+QKNB9QCKDWVNQMK=";
    private DeveloperInstance developerInstance;
    String developerUsername = "";
    String developerPassword = "";
    private String developerInstanceUriId;
    private ApplicationInstance applicationInstance;
    private String applicationInstanceUriId;

    public String getApplicationInstanceUriId() {
        return applicationInstanceUriId;
    }

    public String getPaaSInstanceUriId(String paaSProviderName) {
        return paaSInstanceUriIds.get(paaSProviderName);
    }

    public static void main(String[] args) {
        Initializer initializer = new Initializer();
        initializer.initialize();
        try {
            initializer.retrieveApplicationProfile();
    //        initializer.createDB();
    //        initializer.deploy();
    //        initializer.stopApplication();
    //        initializer.undeployApplication();
    //        initializer.undeployApplication();
        } catch (SOAException ex) {
            logger.error("error in reading the response!", ex.getMessage());
        }
    }

    public void initialize() {

        createAppEnginePaaSUserInstance();
        createGoogleAppEngine();
        storeInfos();

        createBeanstalkPaaSUserInstance();
        createBeanstalk();
        storeInfos();

        createCloudBeesPaaSPaaSUserInstance();
        createCloudBeesPaaS();
        storeInfos();

        //Others
        createAppHarborPaaSUserInstance();
        createAppHarbor();
        storeInfos();

        createAzurePaaSUserInstance();
        createAzure();
        storeInfos();

        createCloudControlPaaSUserInstance();
        createCloudControl();
        storeInfos();

        createCloudFoundryPaaSUserInstance();
        createCloudFoundry();
        storeInfos();

        createCumuLogicPaaSUserInstance();
        createCumuLogic();
        storeInfos();

        createEngineYardPaaSUserInstance();
        createEngineYard();
        storeInfos();

        createHerokuPaaSUserInstance();
        createHeroku();
        storeInfos();

        createMuleiONPaaSUserInstance();
        createMuleiON();
        storeInfos();

        createOpenShiftPaaSUserInstance();
        createOpenShift();
        storeInfos();

        createPlayAppsPaaSUserInstance();
        createPlayApps();
        storeInfos();

        //User 
        createDeveloperInstance();
        storeDeveloperInstance();

        //Application  
        try {
            createApplicationInstance();
        } catch (FileNotFoundException ex) {
            logger.error(ex.getMessage());
        }
        storeApplicationInstance();
    }

    public void createDB() {
        //Databases 
        createDatabase();

    }

    public void retrieveApplicationProfile() throws SOAException {
        final String RS_URI = BASE_URI + "ModelManagerRS/";
        ModelManager modelManager = JAXRSClientFactory.create(RS_URI, ModelManager.class);
        List<ApplicationInstance> list = modelManager.retrieveAllApplicationProfile(developerInstanceUriId);
        if (list.size() == 1) {
            applicationInstance = list.get(0);
        }
    }

    public void deploy() {
        //Applications 
        try {
            deployApplication();
        } catch (FileNotFoundException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void storeInfos() {

        userInstanceUriId = createPaaSUserAccount();
        storePaaSInstance();
    }

    public String createPaaSUserAccount() {
//        final String RS_URI = BASE_URI + "UserManagementAndSecurityModuleRS/";
//        ProviderFactory.getSharedInstance().registerUserProvider(new JSONProvider());

//        WebClient webClient = WebClient.create(BASE_URI+"createNewAccount");
//        webClient.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON_TYPE);
//        UserManagementAndSecurityModule userMgt = JAXRSClientFactory.create(RS_URI, UserManagementAndSecurityModule.class);
//        Response response = webClient.post(userInstanceUriId);

//        Response response = userMgt.createNewAccount(paaSUserInstance, paaSUserUsername, paaSUserPassword);
        Response response = createNewAccountRS(paaSUserInstance, paaSUserUsername, paaSUserPassword);

//        Response response = webClient.post(userInstanceJsonObj.toString());
        if (Response.Status.fromStatusCode(response.getStatus()) == Response.Status.CREATED) {
            try {
                userInstanceUriId = IOUtils.readStringFromStream((InputStream) response.getEntity());
                System.out.println("Response Status : " + userInstanceUriId);
                return userInstanceUriId;
            } catch (IOException ex) {
                logger.error(ex.getMessage());
            }
        }
        return null;
    }

    private void storePaaSInstance() {
        final String RS_URI = BASE_URI + "AnnouncementModuleRS/";

        WebClient client = WebClient.create(RS_URI + "storePaaSInstance");
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);

//        ProviderFactory.getSharedInstance().registerUserProvider(new JSONProvider());
        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("paaSInstance", MediaType.APPLICATION_JSON, paaSInstance));

        atts.add(new Attachment("userInstanceUriId", MediaType.TEXT_PLAIN, userInstanceUriId));

        Response response = client.post(new MultipartBody(atts));
        try {
            String paaSInstanceUriId = IOUtils.readStringFromStream((InputStream) response.getEntity());
            System.out.println(paaSUserInstance.getPaaSProviderInstance().getTitle() + " paaSInstanceUriId: " + paaSInstanceUriId);
            paaSInstanceUriIds.put(paaSUserInstance.getPaaSProviderInstance().getTitle(), paaSInstanceUriId);
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    private PaaSUserInstance createAppEnginePaaSUserInstance() {
        paaSUserInstance = new PaaSUserInstance();
        paaSUserInstance.setFamilyname("GoogleAppEngine");
        paaSUserInstance.setFirstName("GoogleAppEngine");
        paaSUserInstance.setGeekcode("GoogleAppEngine");
        paaSUserInstance.setSurname("GoogleAppEngine");
//        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
//        cloud4SoaAccountInstance.setAccountname("GoogleAppEngine");
//        paaSUserInstance.setHoldsaccount(new Cloud4SoaAccountInstance());
        paaSUserUsername="GoogleAppEngine";
        paaSUserPassword="GoogleAppEnginePassword";
        
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance("AppEngine", "http://code.google.com/appengine/");

        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);

        return paaSUserInstance;
    }

    public void createGoogleAppEngine() {
//        List<PaaSInstance> providedPaaSInstances = new ArrayList<PaaSInstance>();
        paaSInstance = new PaaSInstance();

        //Offering
        paaSInstance.setTitle("Google App Engine");

        //Channels
        APIInstance apiInstance = (APIInstance) paaSInstance.createAndAddChannel(ChannelType.API);
        apiInstance.setDescription("The Google AppEngine API");

        OperationInstance operationInstance = apiInstance.createAndAddOperation("Check Application Availability", "Checks whether the specified application name is available", "checkAppAvailability(in appName : String) :: Boolean", "");
        operationInstance = apiInstance.createAndAddOperation("Create Application Version", "Creates an application version which refers to the given application", "createAppVersion(in appVersion : VersionedApplication, in appID : unsigned long long) :: VersionedApplication", "");
        operationInstance = apiInstance.createAndAddOperation("Create Application", "Creates an empty application", "createApplication(in application : Application) :: Application", "");
        operationInstance = apiInstance.createAndAddOperation("Delete Application", "Deletes application", "deleteApplication(in appID : unsigned long long) :: Boolean", "");
        operationInstance = apiInstance.createAndAddOperation("Get Application Statistics", "Get statistics of the specified application versions", "getAppStatistics(in appID : unsigned long long, in version : String) :: Statistics", "");
        operationInstance = apiInstance.createAndAddOperation("Get Application Status", "Get status of the specified application version", "getAppStatus(in appID : unsigned long long, in version : String) :: AppStatus", "");
        operationInstance = apiInstance.createAndAddOperation("Get Running Status", "Get the status of the running instance that corresponds to the deployed application version", "getRunningStatus(in appID : unsigned long long, in version : String) :: InstanceStatus", "");
        operationInstance = apiInstance.createAndAddOperation("Get Summary Statistics", "Get summary statistics of all running (prior and current) application versions of the given application in the given environment", "getSummaryStatistics(in appID : unsigned long long, in envID : unsigned long long) :: Statistics", "");
        operationInstance = apiInstance.createAndAddOperation("List Applications", "It is used in order to return a list of all applications registered for a specific user a specific PaaS provider", "listApplications() :: sequence of Application", "");
        operationInstance = apiInstance.createAndAddOperation("Undeploy", "Undeploy the specified application version", "undeploy(in appID : unsigned long long, in version : String) :: InstanceStatus", "");
        operationInstance = apiInstance.createAndAddOperation("Update Application", "Updates Application elements", "updateApplication(in application : Application) :: Application", "");

        //HardwareComponents
        HardwareComponentInstance communicationalComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.NetworkCategory);
//        NetworkResourceInstance networkResourceInstance = (NetworkResourceInstance) communicationalComponent.getRelatedhwcategoryInstance();
        NetworkResourceInstance networkResourceInstance = (NetworkResourceInstance)communicationalComponent;
        networkResourceInstance.setTitle("googleNetwork");

        networkResourceInstance.setMaxBandwidthValue(999999999f);
        networkResourceInstance.setMinLatencyValue(2f);

        HardwareComponentInstance boxComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.HttpRequestHandlerCategory);
//        HttpRequestsHandlerInstance boxInstance = (HttpRequestsHandlerInstance) boxComponent.getRelatedhwcategoryInstance();
        HttpRequestsHandlerInstance boxInstance = (HttpRequestsHandlerInstance)boxComponent;
        boxInstance.setTitle("googleBox");
        boxInstance.setMaxHTTPRequests(100f);
        
        //        List<NetworkingUnit> bandwidthValues = new ArrayList<NetworkingUnit>();
//        NetworkingUnit nwu = new NetworkingUnit();
//        nwu.setValue(999999999f);
//        bandwidthValues.add(nwu);
//		networkResourceInstance.setBandwidthValues(bandwidthValues );

        HardwareComponentInstance computationalComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.ComputationalCategory);
//        ComputeInstance computeInstance = (ComputeInstance) computationalComponent.getRelatedhwcategoryInstance();
        ComputeInstance computeInstance = (ComputeInstance)computationalComponent;
        computeInstance.setTitle("googleCompute");
        computeInstance.setArchitecture("64 bit");
        computeInstance.setMaxCacheValue(1024f);
        computeInstance.setMaxHasCores(16f);
        computeInstance.setMaxMemoryValue(16000f);
//        computeInstance.setMaxSpeedValue(16f);
//        List<ComputingUnit> speedValues = new ArrayList<ComputingUnit>();
//        ComputingUnit cu = new ComputingUnit();
//        cu.setValue(999999999f);
//        speedValues.add(cu);
//        computeInstance.setSpeedValues(speedValues);

        HardwareComponentInstance storageComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.StorageCategory);
//        StorageResourceInstance storageResourceInstance = (StorageResourceInstance) storageComponent.getRelatedhwcategoryInstance();
        StorageResourceInstance storageResourceInstance = (StorageResourceInstance)storageComponent;
        storageResourceInstance.setTitle("googleStorage");
        storageResourceInstance.setMaxCapacityValue(999999999f);
        storageResourceInstance.setMaxBandwidthValue(999999999f);
        //   storageResourceInstance.setMaxBandwidthValue(999999999f);
//        List<StorageUnit> capacityValues = new ArrayList<StorageUnit>();
//        StorageUnit su = new StorageUnit();
//        su.setValue(999999999f);
//        capacityValues.add(su);
//        storageResourceInstance.setCapacityValues(capacityValues);

        //SoftwareComponents
        SoftwareCategoryInstance developmnet_tool = new SoftwareCategoryInstance("developmnet_tool", "Impove/enhance the development");
        paaSInstance.createAndAddSoftwareComponent("Gaelyk", "A specialized servlet framework, leveraging the Groovy  language, offers rapid small application development on the GAE/J platform",
                "", "", developmnet_tool);
        paaSInstance.createAndAddSoftwareComponent("JRuby", "The cutting edge JRuby community has quickly embraced the GAE platform with both standalone Gems and near-complete Rails support",
                "", "", developmnet_tool);
        paaSInstance.createAndAddSoftwareComponent("Struts", "Struts 2 offers a widely-used and familiar framework to quickly take advantage of GAE/J web app hosting.",
                "", "", developmnet_tool);
        paaSInstance.createAndAddSoftwareComponent("google_Ant", "Ant build",
                "", "", developmnet_tool);
        paaSInstance.createAndAddSoftwareComponent("google_Maven", "Maven is a software tool for project management and build automation",
                "", "", developmnet_tool);
        paaSInstance.createAndAddSoftwareComponent("grails", "Grails is an open source web application framework which uses the Groovy programming language ",
                "", "", developmnet_tool);
        paaSInstance.createAndAddSoftwareComponent("wicket", "This popular web framework for the Java platform offers basic compatibility with GAE/J.",
                "", "", developmnet_tool);

        SoftwareCategoryInstance autoscaling = new SoftwareCategoryInstance("autoscaling", "Enable the automatic scaling of the reserources when needed");
        paaSInstance.createAndAddSoftwareComponent("googleAutoScaling", "Autoscaling of resources",
                "", "", autoscaling);

        SoftwareCategoryInstance security = new SoftwareCategoryInstance("security", "Enhance the security");
        paaSInstance.createAndAddSoftwareComponent("google_Authorisation", "GAE provides an API to use Google’s own authentication system",
                "", "", security);

        SoftwareCategoryInstance database = new SoftwareCategoryInstance("database", "Enable the permanent storage of data");
        paaSInstance.createAndAddSoftwareComponent("google_BlobStore", "The Blobstore allows your app to serve data objects",
                "", "", database);
        paaSInstance.createAndAddSoftwareComponent("google_DataStore", "The App Engine datastore is a schemaless object datastore, with a query engine and atomic transactions",
                "", "", database);

        SoftwareCategoryInstance performance = new SoftwareCategoryInstance("performance", "Improve the performance");
        paaSInstance.createAndAddSoftwareComponent("google_Cache", "GAE/J offers both a low level API as well as a JSR-107 JCache API to place objects in this simple key/value repository",
                "", "", performance);

        SoftwareCategoryInstance scheduling = new SoftwareCategoryInstance("scheduling", "Enable the scheduling of tasks");
        paaSInstance.createAndAddSoftwareComponent("google_Cron", "CRON Jobs execute on a scheduled recurrence.",
                "", "", scheduling);
        paaSInstance.createAndAddSoftwareComponent("google_TaskQueue", "Activities that can be worked asynchronously are a fit for the Task Queue.",
                "", "", scheduling);

        SoftwareCategoryInstance multimedia = new SoftwareCategoryInstance("multimedia", "Enable multimedia manipulation");
        paaSInstance.createAndAddSoftwareComponent("google_ImageManipulation", "GAE/J provides the native ability to resize, rotate, flip, crop and enahance images on the fly.",
                "", "", multimedia);

        SoftwareCategoryInstance communication = new SoftwareCategoryInstance("communication", "Enable the communication between users");
        paaSInstance.createAndAddSoftwareComponent("google_Mail", "GAE/J provides a mail-sending JavaMail implementation.",
                "", "", communication);
        paaSInstance.createAndAddSoftwareComponent("google_XMPP", "GAE/J impressively implements an API to allow web apps to participate in these IM conversations.",
                "", "", communication);

        SoftwareCategoryInstance load_balancer = new SoftwareCategoryInstance("load_balancer", "distribute workload across multiple resources");
        paaSInstance.createAndAddSoftwareComponent("google_loadBalancer", "Appengine load balancer",
                "", "", load_balancer);

        paaSInstance.setSupportedProgrammingLanguage("JAVA");


        //Pricing_policies
        //TODO Add pricing policies

        //Ratings
        //TODO Add ratings


//        providedPaaSInstances.add(paaSInstance);         
    }

    /*Beanstalk*/
    private PaaSUserInstance createBeanstalkPaaSUserInstance() {
        paaSUserInstance = new PaaSUserInstance();
        paaSUserInstance.setFamilyname("Beanstalk");
        paaSUserInstance.setFirstName("Beanstalk");
        paaSUserInstance.setGeekcode("Beanstalk");
        paaSUserInstance.setSurname("Beanstalk");
//        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
//        cloud4SoaAccountInstance.setAccountname("Beanstalk");
//        paaSUserInstance.setHoldsaccount(new Cloud4SoaAccountInstance());
        paaSUserUsername="Beanstalk";
        paaSUserPassword="BeanstalkPassword";

        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance("Beanstalk", "http://aws.amazon.com/elasticbeanstalk/");

        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);

        return paaSUserInstance;
    }

    public void createBeanstalk() {
//        List<PaaSInstance> providedPaaSInstances = new ArrayList<PaaSInstance>();
        paaSInstance = new PaaSInstance();

        //Offering
        paaSInstance.setTitle("AWS Elastic Beanstalk (beta)");

        //Channels
        APIInstance apiInstance = (APIInstance) paaSInstance.createAndAddChannel(ChannelType.API);
        apiInstance.setDescription("The Amazon Beanstalk API");

        OperationInstance operationInstance = apiInstance.createAndAddOperation("Check Application Availability", "Checks whether the specified application name is available", "checkAppAvailability(in appName : String) :: Boolean", "");
        operationInstance = apiInstance.createAndAddOperation("Create Application Version", "Creates an application version which refers to the given application", "createAppVersion(in appVersion : VersionedApplication, in appID : unsigned long long) :: VersionedApplication", "");
        operationInstance = apiInstance.createAndAddOperation("Create Application", "Creates an empty application", "createApplication(in application : Application) :: Application", "");
        operationInstance = apiInstance.createAndAddOperation("Create Environment", "Create a working environment, given the appropriate information set", "createEnvironment(in env : Environment) :: Environment", "");
        operationInstance = apiInstance.createAndAddOperation("Delete Application Version", "Deletes VersionedApplication of the application with the given ID and version string", "deleteAppVersion(in appID : unsigned long long, in version : String) :: Boolean", "");
        operationInstance = apiInstance.createAndAddOperation("Delete Application", "Deletes application", "deleteApplication(in appID : unsigned long long) :: Boolean", "");
        operationInstance = apiInstance.createAndAddOperation("Delete Environment", "Delete the environment that corresponds to the given ID", "deleteEnvironment(in envID : unsigned long long) :: Boolean", "");
        operationInstance = apiInstance.createAndAddOperation("Undeploy", "Undeploy the specified application version", "undeploy(in appID : unsigned long long, in version : String) :: InstanceStatus", "");
        operationInstance = apiInstance.createAndAddOperation("Update Application", "Updates Application elements", "updateApplication(in application : Application) :: Application", "");
        operationInstance = apiInstance.createAndAddOperation("Update Environment", "Update environment details", "updateEnvironment(in env : Environment) :: Environment", "");

        //HardwareComponents
        HardwareComponentInstance communicationalComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.NetworkCategory);
//        NetworkResourceInstance networkResourceInstance = (NetworkResourceInstance) communicationalComponent.getRelatedhwcategoryInstance();
        NetworkResourceInstance networkResourceInstance = (NetworkResourceInstance)communicationalComponent;
        networkResourceInstance.setTitle("beanstalk_network");
        networkResourceInstance.setMaxBandwidthValue(999999999f);
//        List<NetworkingUnit> bandwidthValues = new ArrayList<NetworkingUnit>();
//        NetworkingUnit nwu = new NetworkingUnit();
//        nwu.setValue(999999999f);
//        bandwidthValues.add(nwu);
//        networkResourceInstance.setBandwidthValues(bandwidthValues);

        HardwareComponentInstance computationalComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.ComputationalCategory);
//        ComputeInstance computeInstance = (ComputeInstance) computationalComponent.getRelatedhwcategoryInstance();
        ComputeInstance computeInstance = (ComputeInstance) computationalComponent;
        computeInstance.setTitle("beanstalk_compute");
        computeInstance.setArchitecture("32 and 64 bit");
        computeInstance.setMaxMemoryValue(64f);
//        computeInstance.setMaxSpeedValue(999999999f);

//        List<ComputingUnit> speedValues = new ArrayList<ComputingUnit>();
//        ComputingUnit cu = new ComputingUnit();
//        cu.setValue(999999999f);
//        speedValues.add(cu);
//        computeInstance.setSpeedValues(speedValues);

        HardwareComponentInstance storageComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.StorageCategory);
//        StorageResourceInstance storageResourceInstance = (StorageResourceInstance) storageComponent.getRelatedhwcategoryInstance();
        StorageResourceInstance storageResourceInstance = (StorageResourceInstance)storageComponent;
        storageResourceInstance.setTitle("amazon_storage");
        storageResourceInstance.setMaxCapacityValue(1690f);

//        List<StorageUnit> capacityValues = new ArrayList<StorageUnit>();
//        StorageUnit su = new StorageUnit();
//        su.setValue(1690f);
//        capacityValues.add(su);
//        storageResourceInstance.setCapacityValues(capacityValues);

        //SoftwareComponents
        SoftwareCategoryInstance web_server = new SoftwareCategoryInstance("web_server", "Host applications");
        paaSInstance.createAndAddSoftwareComponent("apache_tomcat", "Apache Tomcat",
                "", "", web_server);

        SoftwareCategoryInstance autoscaling = new SoftwareCategoryInstance("autoscaling", "Enable the automatic scaling of the reserources when needed");
        paaSInstance.createAndAddSoftwareComponent("beanstalk_autoscaling", "Beanstalk autoscaling",
                "", "", autoscaling);

        SoftwareCategoryInstance load_balancer = new SoftwareCategoryInstance("load_balancer", "distribute workload across multiple resources");
        paaSInstance.createAndAddSoftwareComponent("beanstalk_loadbalancer", "Beanstalk load balancer",
                "", "", load_balancer);

        paaSInstance.setSupportedProgrammingLanguage("JAVA");

//        providedPaaSInstances.add(paaSInstance);         
    }

    /*CloudBeesPaaS*/
    private PaaSUserInstance createCloudBeesPaaSPaaSUserInstance() {
        paaSUserInstance = new PaaSUserInstance();
        paaSUserInstance.setFamilyname("cloudBeesPaaS");
        paaSUserInstance.setFirstName("cloudBeesPaaS");
        paaSUserInstance.setGeekcode("cloudBeesPaaS");
        paaSUserInstance.setSurname("cloudBeesPaaS");
//        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
//        cloud4SoaAccountInstance.setAccountname("cloudBeesPaaS");
//        paaSUserInstance.setHoldsaccount(new Cloud4SoaAccountInstance());
        paaSUserUsername="cloudBeesPaaS";
        paaSUserPassword="cloudBeesPaaSPassword";
        
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance("CloudBees", "http://www.cloudbees.com");

        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);

        return paaSUserInstance;
    }

    public void createCloudBeesPaaS() {
//        List<PaaSInstance> providedPaaSInstances = new ArrayList<PaaSInstance>();
        paaSInstance = new PaaSInstance();

        //Offering
        paaSInstance.setTitle("The CloudBees platform  lets companies build, test and deploy Java web applications in the cloud.");

        //Channels
        APIInstance apiInstance = (APIInstance) paaSInstance.createAndAddChannel(ChannelType.API);

        OperationInstance operationInstance = apiInstance.createAndAddOperation("Check Application Availability", "Checks whether the specified application name is available", "checkAppAvailability(in appName : String) :: Boolean", "");
        operationInstance = apiInstance.createAndAddOperation("Get Running Status", "Get the status of the running instance that corresponds to the deployed application version", "getRunningStatus(in appID : unsigned long long, in version : String) :: InstanceStatus", "");
        operationInstance = apiInstance.createAndAddOperation("Get Summary Statistics", "Get summary statistics of all running (prior and current) application versions of the given application in the given environment", "getSummaryStatistics(in appID : unsigned long long, in envID : unsigned long long) :: Statistics", "");
        operationInstance = apiInstance.createAndAddOperation("List Applications", "It is used in order to return a list of all applications registered for a specific user a specific PaaS provider", "listApplications() :: sequence of Application", "");
        operationInstance = apiInstance.createAndAddOperation("Start", "Start a non-started instance of the specified application version", "start(in appID : unsigned long long, in version : String) :: InstanceStatus", "");
        operationInstance = apiInstance.createAndAddOperation("Stop", "Stop an already started instance of the specified application version", "stop(in appID : unsigned long long, in version : String) :: InstanceStatus", "");
        operationInstance = apiInstance.createAndAddOperation("Undeploy", "Undeploy the specified application version", "undeploy(in appID : unsigned long long, in version : String) :: InstanceStatus", "");
        operationInstance = apiInstance.createAndAddOperation("Upload and Deploy to Environment", "Creates a new application (if needed), then a new application version, upload the respective executable file, associate and deploy it to the specified environment", "uploadAndDeployToEnv(in app : Application, in appVersion : VersionedApplication, in env : Environment) :: ApplicationSpace", "");
        
        //HardwareComponents
        HardwareComponentInstance computationalComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.ComputationalCategory);
//        ComputeInstance computeInstance = (ComputeInstance) computationalComponent.getRelatedhwcategoryInstance();
        ComputeInstance computeInstance = (ComputeInstance)computationalComponent;
        computeInstance.setTitle("cloudBees_compute");
//        computeInstance.setMaxSpeedValue(4f);
        computeInstance.setArchitecture("64 bit");
        computeInstance.setMaxCacheValue(512f);
        computeInstance.setMaxHasCores(4f);
        computeInstance.setMaxMemoryValue(8000f);
        
        HardwareComponentInstance boxComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.HttpRequestHandlerCategory);
//        HttpRequestsHandlerInstance boxInstance = (HttpRequestsHandlerInstance) boxComponent.getRelatedhwcategoryInstance();
        HttpRequestsHandlerInstance boxInstance = (HttpRequestsHandlerInstance)boxComponent;
        boxInstance.setTitle("cloudBeesBox");
        boxInstance.setMaxHTTPRequests(20f);
        
        //HardwareComponents
        HardwareComponentInstance communicationalComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.NetworkCategory);
//        NetworkResourceInstance networkResourceInstance = (NetworkResourceInstance) communicationalComponent.getRelatedhwcategoryInstance();
        NetworkResourceInstance networkResourceInstance = (NetworkResourceInstance)communicationalComponent;
        networkResourceInstance.setTitle("cloudBeesNetwork");
        networkResourceInstance.setMaxBandwidthValue(2000f);
        networkResourceInstance.setMinLatencyValue(4f);
       
      
        HardwareComponentInstance storageComponent = paaSInstance.createAndAddHardwareComponent(HardwareCategoryType.StorageCategory);
//        StorageResourceInstance storageResourceInstance = (StorageResourceInstance) storageComponent.getRelatedhwcategoryInstance();
        StorageResourceInstance storageResourceInstance = (StorageResourceInstance)storageComponent;
        storageResourceInstance.setTitle("cloudBees_storage");
        storageResourceInstance.setMaxCapacityValue(50f);
        storageResourceInstance.setMaxBandwidthValue(999999999f);


        //SoftwareComponents
        SoftwareCategoryInstance autoscaling = new SoftwareCategoryInstance("autoscaling", "Enable the automatic scaling of the reserources when needed");
        paaSInstance.createAndAddSoftwareComponent("AutoScaling", "CloudBees autoscaling of resources",
                "", "", autoscaling);

        SoftwareCategoryInstance database = new SoftwareCategoryInstance("database", "Enable the permanent storage of data");
        paaSInstance.createAndAddSoftwareComponent("JFrog", "Binary repository in the cloud",
                "", "", database);
        paaSInstance.createAndAddSoftwareComponent("MySQL", "MySQL server",
                "", "", database);
        paaSInstance.createAndAddSoftwareComponent("cloudant", "Reliable, distributed Database-as-a-Service, based on Apache CouchDB",
                "", "", database);

        SoftwareCategoryInstance developmnet_tool = new SoftwareCategoryInstance("developmnet_tool", "Impove/enhance the development");
        paaSInstance.createAndAddSoftwareComponent("Jenkins", "Jenkins Hudson",
                "", "", developmnet_tool);
        paaSInstance.createAndAddSoftwareComponent("Sauce_Labs_OnDemand", "Manual and Selenium-driven cross-browser testing on the cloud",
                "", "", developmnet_tool);
        paaSInstance.createAndAddSoftwareComponent("Sonar", "Continuously inspect your source code",
                "", "", developmnet_tool);

        SoftwareCategoryInstance monitoring = new SoftwareCategoryInstance("monitoring", "Monitor the lifecycle of an application");
        paaSInstance.createAndAddSoftwareComponent("NewRelic", "Real-time web monitoring and analytics, delivered as a service",
                "", "", monitoring);

        SoftwareCategoryInstance security = new SoftwareCategoryInstance("security", "Enhance the security");
        paaSInstance.createAndAddSoftwareComponent("SSL", "provide communication security over the Internet",
                "", "", security);

        paaSInstance.setSupportedProgrammingLanguage("JAVA");

        //ONLY FOR THE DEMO:
        paaSInstance.setSlaId("templateId");
//        providedPaaSInstances.add(paaSInstance);         
    }

    /*AppHarbor*/
    private PaaSUserInstance createAppHarborPaaSUserInstance() {
        paaSUserInstance = new PaaSUserInstance();
        paaSUserInstance.setFamilyname("AppHarbor");
        paaSUserInstance.setFirstName("AppHarbor");
        paaSUserInstance.setGeekcode("AppHarbor");
        paaSUserInstance.setSurname("AppHarbor");
//        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
//        cloud4SoaAccountInstance.setAccountname("AppHarbor");
//        paaSUserInstance.setHoldsaccount(new Cloud4SoaAccountInstance());
        paaSUserUsername="AppHarbor";
        paaSUserPassword="AppHarborPassword";
        
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance("AppHarbor", "https://appharbor.com/");

        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);

        return paaSUserInstance;
    }

    public void createAppHarbor() {
//        List<PaaSInstance> providedPaaSInstances = new ArrayList<PaaSInstance>();
        paaSInstance = new PaaSInstance();

        //Offering
        paaSInstance.setTitle("AppHarbor");


        paaSInstance.setSupportedProgrammingLanguage("ASP.NET");

//        providedPaaSInstances.add(paaSInstance);         
    }

    /*Azure*/
    private PaaSUserInstance createAzurePaaSUserInstance() {
        paaSUserInstance = new PaaSUserInstance();
        paaSUserInstance.setFamilyname("Azure");
        paaSUserInstance.setFirstName("Azure");
        paaSUserInstance.setGeekcode("Azure");
        paaSUserInstance.setSurname("Azure");
//        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
//        cloud4SoaAccountInstance.setAccountname("Azure");
//        paaSUserInstance.setHoldsaccount(new Cloud4SoaAccountInstance());
        paaSUserUsername="Azure";
        paaSUserPassword="AzurePassword";
        
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance("Azure", "http://www.windowsazure.com/en-us/");

        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);

        return paaSUserInstance;
    }

    public void createAzure() {
//        List<PaaSInstance> providedPaaSInstances = new ArrayList<PaaSInstance>();
        paaSInstance = new PaaSInstance();

        //Offering
        paaSInstance.setTitle("Azure");


        paaSInstance.setSupportedProgrammingLanguage("ASP.NET");

//        providedPaaSInstances.add(paaSInstance);         
    }

    /*CloudControl*/
    private PaaSUserInstance createCloudControlPaaSUserInstance() {
        paaSUserInstance = new PaaSUserInstance();
        paaSUserInstance.setFamilyname("CloudControl");
        paaSUserInstance.setFirstName("CloudControl");
        paaSUserInstance.setGeekcode("CloudControl");
        paaSUserInstance.setSurname("CloudControl");
//        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
//        cloud4SoaAccountInstance.setAccountname("CloudControl");
//        paaSUserInstance.setHoldsaccount(new Cloud4SoaAccountInstance());
        paaSUserUsername="CloudControl";
        paaSUserPassword="CloudControlPassword";
        
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance("CloudControl", "https://www.cloudcontrol.com/");

        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);

        return paaSUserInstance;
    }

    public void createCloudControl() {
//        List<PaaSInstance> providedPaaSInstances = new ArrayList<PaaSInstance>();
        paaSInstance = new PaaSInstance();

        //Offering
        paaSInstance.setTitle("CloudControl");


        paaSInstance.setSupportedProgrammingLanguage("PHP 5.3.2");

//        providedPaaSInstances.add(paaSInstance);         
    }

    /*CloudFoundry*/
    private PaaSUserInstance createCloudFoundryPaaSUserInstance() {
        paaSUserInstance = new PaaSUserInstance();
        paaSUserInstance.setFamilyname("CloudFoundry");
        paaSUserInstance.setFirstName("CloudFoundry");
        paaSUserInstance.setGeekcode("CloudFoundry");
        paaSUserInstance.setSurname("CloudFoundry");
//        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
//        cloud4SoaAccountInstance.setAccountname("CloudFoundry");
//        paaSUserInstance.setHoldsaccount(new Cloud4SoaAccountInstance());
        paaSUserUsername="CloudFoundry";
        paaSUserPassword="CloudFoundryPassword";
        
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance("CloudFoundry", "http://www.cloudfoundry.com/");

        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);

        return paaSUserInstance;
    }

    public void createCloudFoundry() {
//        List<PaaSInstance> providedPaaSInstances = new ArrayList<PaaSInstance>();
        paaSInstance = new PaaSInstance();

        //Offering
        paaSInstance.setTitle("CloudFoundry");


        paaSInstance.setSupportedProgrammingLanguage("Spring Java");

//        providedPaaSInstances.add(paaSInstance);         
    }

    /*CumuLogic*/
    private PaaSUserInstance createCumuLogicPaaSUserInstance() {
        paaSUserInstance = new PaaSUserInstance();
        paaSUserInstance.setFamilyname("CumuLogic");
        paaSUserInstance.setFirstName("CumuLogic");
        paaSUserInstance.setGeekcode("CumuLogic");
        paaSUserInstance.setSurname("CumuLogic");
//        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
//        cloud4SoaAccountInstance.setAccountname("CumuLogic");
//        paaSUserInstance.setHoldsaccount(new Cloud4SoaAccountInstance());
        paaSUserUsername="CumuLogic";
        paaSUserPassword="CumuLogicPassword";
        
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance("CumuLogic", "http://www.cumulogic.com/");

        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);

        return paaSUserInstance;
    }

    public void createCumuLogic() {
//        List<PaaSInstance> providedPaaSInstances = new ArrayList<PaaSInstance>();
        paaSInstance = new PaaSInstance();

        //Offering
        paaSInstance.setTitle("CumuLogic");


        paaSInstance.setSupportedProgrammingLanguage("Java");

//        providedPaaSInstances.add(paaSInstance);         
    }

    /* Engine Yard*/
    private PaaSUserInstance createEngineYardPaaSUserInstance() {
        paaSUserInstance = new PaaSUserInstance();
        paaSUserInstance.setFamilyname("EngineYard");
        paaSUserInstance.setFirstName("EngineYard");
        paaSUserInstance.setGeekcode("EngineYard");
        paaSUserInstance.setSurname("EngineYard");
//        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
//        cloud4SoaAccountInstance.setAccountname("EngineYard");
//        paaSUserInstance.setHoldsaccount(new Cloud4SoaAccountInstance());
        paaSUserUsername="EngineYard";
        paaSUserPassword="EngineYardPassword";
        
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance("EngineYard", "http://www.engineyard.com/");

        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);

        return paaSUserInstance;
    }

    public void createEngineYard() {
//        List<PaaSInstance> providedPaaSInstances = new ArrayList<PaaSInstance>();
        paaSInstance = new PaaSInstance();

        //Offering
        paaSInstance.setTitle("EngineYard");


        paaSInstance.setSupportedProgrammingLanguage("Ruby 1.9.2");

//        providedPaaSInstances.add(paaSInstance);         
    }

    /*Heroku*/
    private PaaSUserInstance createHerokuPaaSUserInstance() {
        paaSUserInstance = new PaaSUserInstance();
        paaSUserInstance.setFamilyname("Heroku");
        paaSUserInstance.setFirstName("Heroku");
        paaSUserInstance.setGeekcode("Heroku");
        paaSUserInstance.setSurname("Heroku");
//        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
//        cloud4SoaAccountInstance.setAccountname("Heroku");
//        paaSUserInstance.setHoldsaccount(new Cloud4SoaAccountInstance());
        paaSUserUsername="Heroku";
        paaSUserPassword="HerokuPassword";
        
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance("Heroku", "http://www.heroku.com/");

        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);

        return paaSUserInstance;
    }

    public void createHeroku() {
//        List<PaaSInstance> providedPaaSInstances = new ArrayList<PaaSInstance>();
        paaSInstance = new PaaSInstance();

        //Offering
        paaSInstance.setTitle("Heroku");


        paaSInstance.setSupportedProgrammingLanguage("Java");

//        providedPaaSInstances.add(paaSInstance);         
    }

    /*MuleiON*/
    private PaaSUserInstance createMuleiONPaaSUserInstance() {
        paaSUserInstance = new PaaSUserInstance();
        paaSUserInstance.setFamilyname("MuleiON");
        paaSUserInstance.setFirstName("MuleiON");
        paaSUserInstance.setGeekcode("MuleiON");
        paaSUserInstance.setSurname("MuleiON");
//        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
//        cloud4SoaAccountInstance.setAccountname("MuleiON");
//        paaSUserInstance.setHoldsaccount(new Cloud4SoaAccountInstance());
        paaSUserUsername="MuleiON";
        paaSUserPassword="MuleiONPassword";
        
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance("MuleiON", "http://www.mulesoft.com/");

        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);

        return paaSUserInstance;
    }

    public void createMuleiON() {
//        List<PaaSInstance> providedPaaSInstances = new ArrayList<PaaSInstance>();
        paaSInstance = new PaaSInstance();

        //Offering
        paaSInstance.setTitle("MuleiON");


        paaSInstance.setSupportedProgrammingLanguage("");

//        providedPaaSInstances.add(paaSInstance);         
    }

    /*OpenShift*/
    private PaaSUserInstance createOpenShiftPaaSUserInstance() {
        paaSUserInstance = new PaaSUserInstance();
        paaSUserInstance.setFamilyname("OpenShift");
        paaSUserInstance.setFirstName("OpenShift");
        paaSUserInstance.setGeekcode("OpenShift");
        paaSUserInstance.setSurname("OpenShift");
//        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
//        cloud4SoaAccountInstance.setAccountname("OpenShift");
//        paaSUserInstance.setHoldsaccount(new Cloud4SoaAccountInstance());
        paaSUserUsername="OpenShift";
        paaSUserPassword="OpenShiftPassword";
        
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance("OpenShift", "https://openshift.redhat.com/app/");

        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);

        return paaSUserInstance;
    }

    public void createOpenShift() {
//        List<PaaSInstance> providedPaaSInstances = new ArrayList<PaaSInstance>();
        paaSInstance = new PaaSInstance();

        //Offering
        paaSInstance.setTitle("OpenShift");


        paaSInstance.setSupportedProgrammingLanguage("PHP");

//        providedPaaSInstances.add(paaSInstance);         
    }

    /*PlayApps*/
    private PaaSUserInstance createPlayAppsPaaSUserInstance() {
        paaSUserInstance = new PaaSUserInstance();
        paaSUserInstance.setFamilyname("PlayApps");
        paaSUserInstance.setFirstName("PlayApps");
        paaSUserInstance.setGeekcode("PlayApps");
        paaSUserInstance.setSurname("PlayApps");
//        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
//        cloud4SoaAccountInstance.setAccountname("PlayApps");
//        paaSUserInstance.setHoldsaccount(new Cloud4SoaAccountInstance());
        paaSUserUsername="PlayApps";
        paaSUserPassword="PlayAppsPassword";
        
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance("PlayApps", "http://www.playapps.net/");

        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);

        return paaSUserInstance;
    }

    public void createPlayApps() {
//        List<PaaSInstance> providedPaaSInstances = new ArrayList<PaaSInstance>();
        paaSInstance = new PaaSInstance();

        //Offering
        paaSInstance.setTitle("PlayApps");


        paaSInstance.setSupportedProgrammingLanguage("Play Framework");

//        providedPaaSInstances.add(paaSInstance);         
    }

    /*
     * USER
     */
    private void createDeveloperInstance() {
        developerInstance = new DeveloperInstance();
        developerInstance.setFirstName("Francesco");
        developerInstance.setFamilyname("D'Andria");
        developerInstance.setGeekcode("fdandria");
        developerInstance.setSurname("D'Andria");
        Calendar calendar = Calendar.getInstance(Locale.ITALY);
        calendar.set(1974, 4, 11);
        developerInstance.setBirthday(calendar.getTime());
//        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
//        cloud4SoaAccountInstance.setAccountname("fdandria");
//        developerInstance.setHoldsaccount(cloud4SoaAccountInstance);
        developerUsername = "fdandria";
        developerPassword = "fdandriaPassword";
    }

    private void storeDeveloperInstance() {
//        final String RS_URI = BASE_URI + "UserManagementAndSecurityModuleRS/";
//        UserManagementAndSecurityModule userMgt = JAXRSClientFactory.create(RS_URI, UserManagementAndSecurityModule.class);

//        Response response = userMgt.createNewAccount(developerInstance, developerUsername, developerPassword);
        Response response = createNewAccountRS(developerInstance, developerUsername, developerPassword);
//        Response response = webClient.post(userInstanceJsonObj.toString());
        if (Response.Status.fromStatusCode(response.getStatus()) == Response.Status.CREATED) {
            try {
                developerInstanceUriId = IOUtils.readStringFromStream((InputStream) response.getEntity());
                System.out.println("Response Status : " + developerInstanceUriId);
            } catch (IOException ex) {
                logger.error(ex.getMessage());
            }
        }
    }
    
    private Response createNewAccountRS(UserInstance paaSUserInstance, String username, String password) {
        final String RS_URI = BASE_URI + "UserManagementAndSecurityModuleRS/";
        WebClient client = WebClient.create(RS_URI+"createNewAccount");
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

    public void deployApplication() throws FileNotFoundException {
        final String RS_URI = BASE_URI + "ApplicationDeploymentRS/deployApplication";

        WebClient client = WebClient.create(RS_URI);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);


        URL fileURL = this.getClass().getClassLoader().getResource("SimpleWar.war");
        if (fileURL == null) {
            throw new FileNotFoundException("SimpleWar.war");
        }


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
            logger.error(ex.getMessage());
        }

        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);

        // POST the request
//        Response response = applicationDeploymentRS.deployApplication(dis, applicationInstanceJsonObj, paaSInstanceJsonObj);
        List<Attachment> atts = new LinkedList<Attachment>();
        atts.add(new Attachment("applicationInstanceUriId", "text/plain", applicationInstanceUriId));
        atts.add(new Attachment("paaSInstanceUriId", "text/plain", paaSInstanceUriIds.get(selectedPaaS)));
        atts.add(new Attachment("publicKey", "text/plain", publicKey));
        atts.add(new Attachment("secretKey", "text/plain", secretKey));
        atts.add(new Attachment("applicationArchive", "application/octet-stream", dis));

        Response response = client.post(new MultipartBody(atts));
        if (Response.Status.fromStatusCode(response.getStatus()) == Response.Status.ACCEPTED) {
            try {
                System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream) response.getEntity()));
            } catch (IOException ex) {
                logger.error(ex.getMessage());
            }
        }

        try {
            fis.close();
            bis.close();
            dis.close();
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
    
    public void startApplication() {
    	startstopApplication ("start");
    }
    
    public void stopApplication() {
    	startstopApplication ("stop");
    }
    
    public void startstopApplication(String command) {
        final String RS_URI = BASE_URI+"ApplicationDeploymentRS/startStopApplication";


        WebClient client = WebClient.create(RS_URI);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);

        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);
        
        // POST the request
//        Response response = applicationDeploymentRS.deployApplication(dis, applicationInstanceJsonObj, paaSInstanceJsonObj);
        List<Attachment> atts = new LinkedList<Attachment>();
        atts.add(new Attachment("applicationInstance", "text/plain", applicationInstanceUriId));
        atts.add(new Attachment("startStopCommand", "text/plain", command));
        atts.add(new Attachment("publicKey", "text/plain", publicKey));
        atts.add(new Attachment("secretKey", "text/plain", secretKey));
     

        Response response = client.post(new MultipartBody(atts));
        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.ACCEPTED)
            try {
                System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream)response.getEntity()));
            } catch (IOException ex) {
                logger.error(ex.getMessage());
            }
    }
    
    public void undeployApplication() {
        final String RS_URI = BASE_URI+"ApplicationDeploymentRS/removeApplication";

        WebClient client = WebClient.create(RS_URI);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);

        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);
        
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
                logger.error(ex.getMessage());
            }
    }
    

    private void createApplicationInstance() throws FileNotFoundException{

        URL fileURL = this.getClass().getClassLoader().getResource("SimpleWar.war");
        if (fileURL == null) {
            throw new FileNotFoundException("SimpleWar.war");
        }


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
            logger.error(ex.getMessage());
        }

        applicationInstance = new ApplicationInstance();
        applicationInstance.setAcronym("C4Sv1.0");
        applicationInstance.setApplicationcode("C4Sv1.0");
        applicationInstance.setDigest(tempFileDigest);
        applicationInstance.setProgramminglanguage("JAVA");

        applicationInstance.setProgramminglanguageVersion("1.6");
        applicationInstance.setSizeQuantity(new Float(file.length()));
        applicationInstance.setVersion("1.0");
        applicationInstance.setArchiveFileName("SimpleWar");
        applicationInstance.setArchiveExtensionName(".war");

        DBStorageComponentInstance dbStorageComponentInstance = new DBStorageComponentInstance();
        dbStorageComponentInstance.setDbname("c4sDB");
        dbStorageComponentInstance.setDbuser("c4sDBuser");
        dbStorageComponentInstance.setDbpassword("c4sDBpassword");
        dbStorageComponentInstance.setDbtype("MySQL");
        SqlDbCategoryInstance sqlDbCategoryInstance = new SqlDbCategoryInstance();
        sqlDbCategoryInstance.setTitle("MySQL");
        dbStorageComponentInstance.setRelatedhwcategoryInstance(sqlDbCategoryInstance);
        ArrayList<SoftwareComponentInstance> arrayList = new ArrayList<SoftwareComponentInstance>();
        arrayList.add(dbStorageComponentInstance);
        applicationInstance.setSoftwareComponents(arrayList);
        
        ArrayList<ServiceQualityInstance> serviceQualityInstances = new ArrayList<ServiceQualityInstance>() {};
        LatencyInstance latencyInstance = new LatencyInstance();
        latencyInstance.setHasTimeRangeValue(1f, 2f);
        UptimeInstance uptimeInstance = new UptimeInstance();
        uptimeInstance.setHasPercentage(99f);
        serviceQualityInstances.add(latencyInstance);
        serviceQualityInstances.add(uptimeInstance);
        applicationInstance.setServiceQualities(serviceQualityInstances);

        //zeginis-->
        SoftwareCategoryInstance autoscaling = new SoftwareCategoryInstance("autoscaling", "Enable the automatic scaling of the reserources when needed");
        applicationInstance.createAndAddSoftwareComponent("", "", "", "", autoscaling);

        HardwareComponentInstance communicationalComponent = applicationInstance.createAndAddHardwareComponent(HardwareCategoryType.NetworkCategory);
//        NetworkResourceInstance networkResourceInstance = (NetworkResourceInstance) communicationalComponent.getRelatedhwcategoryInstance();
        NetworkResourceInstance networkResourceInstance = (NetworkResourceInstance)communicationalComponent;
       
        networkResourceInstance.setMinBandwidthValue(1000f);
        networkResourceInstance.setMaxLatencyValue(4f);

        HardwareComponentInstance boxComponent = applicationInstance.createAndAddHardwareComponent(HardwareCategoryType.HttpRequestHandlerCategory);
//        HttpRequestsHandlerInstance boxInstance = (HttpRequestsHandlerInstance) boxComponent.getRelatedhwcategoryInstance();
        HttpRequestsHandlerInstance boxInstance = (HttpRequestsHandlerInstance)boxComponent;
        boxInstance.setMinHTTPRequests(10f);
        
        HardwareComponentInstance computeComponent = applicationInstance.createAndAddHardwareComponent(HardwareCategoryType.ComputationalCategory);
//        ComputeInstance computeInstance = (ComputeInstance) computeComponent.getRelatedhwcategoryInstance();
        ComputeInstance computeInstance = (ComputeInstance)computeComponent;
        computeInstance.setArchitecture("64 bit");
        computeInstance.setMinCacheValue(64f);
        computeInstance.setMinHasCores(2f);
        computeInstance.setMinMemoryValue(1024f);
//        computeInstance.setMinSpeedValue(4f);
        
        HardwareComponentInstance storageComponent = applicationInstance.createAndAddHardwareComponent(HardwareCategoryType.StorageCategory);
//        StorageResourceInstance storageResourceInstance = (StorageResourceInstance) storageComponent.getRelatedhwcategoryInstance();
        StorageResourceInstance storageResourceInstance = (StorageResourceInstance)storageComponent;
        storageResourceInstance.setTitle("googleStorage");
        storageResourceInstance.setMaxCapacityValue(12000f);
        storageResourceInstance.setMaxBandwidthValue(1000f);

        try {
            fis.close();
            bis.close();
            dis.close();
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    private void storeApplicationInstance() {
        final String RS_URI = BASE_URI + "ModelManagerRS/storeApplicationProfile";

        WebClient client = WebClient.create(RS_URI);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);

        List<Attachment> atts = new LinkedList<Attachment>();
        atts.add(new Attachment("applicationInstance", "application/json", applicationInstance));
        atts.add(new Attachment("userInstanceUriId", "text/plain", developerInstanceUriId));

        System.out.println("Storing application instance for user: " + developerInstanceUriId);

        Response response = client.post(new MultipartBody(atts));
        try {
            applicationInstanceUriId = IOUtils.readStringFromStream((InputStream) response.getEntity());
            System.out.println("applicationInstanceUriId: " + applicationInstanceUriId);
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public void createDatabase() {
        final String RS_URI = BASE_URI + "ApplicationDeploymentRS/createDatabase";

        WebClient client = WebClient.create(RS_URI);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);

        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);

        // POST the request
        List<Attachment> atts = new LinkedList<Attachment>();
        atts.add(new Attachment("applicationInstanceUriId", "text/plain", applicationInstanceUriId));
        atts.add(new Attachment("paaSInstanceUriId", "text/plain", paaSInstanceUriIds.get(selectedPaaS)));
        atts.add(new Attachment("dbStorageComponentUriId", "text/plain", applicationInstance.getHardwareComponents().get(0).getUriId()));
        atts.add(new Attachment("publicKey", "text/plain", publicKey));
        atts.add(new Attachment("secretKey", "text/plain", secretKey));

        Response response = client.post(new MultipartBody(atts));
        if (Response.Status.fromStatusCode(response.getStatus()) == Response.Status.CREATED) {
            try {
                System.out.println("Response Status : " + IOUtils.readStringFromStream((InputStream) response.getEntity()));
            } catch (IOException ex) {
                logger.error(ex.getMessage());
            }
        }
    }
}
