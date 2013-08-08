/*
 * This file is part of Cloud4SOA Frontend.
 *
 *     Cloud4SOA Frontend is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cloud4SOA Frontend is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cloud4SOA Frontend.  If not, see <http://www.gnu.org/licenses/>.
 */

package eu.cloud4soa.frontend.commons.client.datamodel.frontend;

import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.activation.UnsupportedDataTypeException;
import java.net.MalformedURLException;
import java.util.*;


public class PaaSInstanceTest {

    // Title, URL, Status
    String[][] PAASOFFERINGS = {
            {"CloudControl PHP", "http://cloudcontrol.com/home/", "Available"},
            {"Google App Engine", "http://code.google.com/appengine/", "Available"},
            {"AWS Elastic Beanstalk", "http://aws.amazon.com/elasticbeanstalk/", "Available"},
            {"CloudBees", "http://www.cloudbees.com/dev.cb", "Available"},
            {"Cloud Foundry", "http://www.cloudfoundry.com/", "Available"},
            {"OpenShift", "https://openshift.redhat.com/app/", "Available"},
            {"Microsoft Windows Azure", "http://www.microsoft.com/windowsazure/", "Available"},
            {"Salesforce", "http://www.salesforce.com/", "Available"},
            {"CumuLogic", "http://cumulogic.com/", "Available"},
            {"Mule iON", "https://muleion.com/", "Available"}
    };

    // Title, URL
    String[][] PAASPROVIDERS = {
            {"CloudControl", "http://cloudcontrol.com"},
            {"Google", "http://www.google.com"},
            {"Amazon", "http://aws.amazon.com"},
            {"Cloudbees", "http://www.cloudbees.com"},
            {"Cloud Foundry", "http://www.cloudfoundry.com/"},
            {"Red Hat", "http://www.redhat.com/"},
            {"Microsoft", "http://www.microsoft.com"},
            {"Force.com", "http://www.force.com/"},
            {"CumuLogic", "http://cumulogic.com/"},
            {"MuleSoft", "http://www.mulesoft.com/"}
    };

    //Title, description, version, url
    String[][] CHANNELS = {
            {"CLI", "The command line client is a powerful interface to our API enabling developers to control all features of the cloudControl platform", "1.0", "http://cloudcontrol.com/CLI"},
            {"API", "The Java SDK includes a library called Remote API that lets you transparently access App Engine services from any Java application", "2011", "http://code.google.com/appengine/web"},
            {"WebInterface", "Web Interface to control all features of the PaaSOffering", "2011", "http://www.paasoffering.com/web"}
    };

    ChannelType[] CHANNEL_TYPES = {ChannelType.CLI, ChannelType.API, ChannelType.WebInterface};

    //Title, description, command, returned information
    String[][] OPERATIONS = {
            {"create", "create new application", "cctrlapp <app_name> create php", "void"},
            {"upload", "Upload your application in Google App Engine", "./appengine-java-sdk/bin/appcfg.sh [options] <action> <war-location>", "url"}
    };

    //Title, description, command
    String[][] OPERATION_TYPES = {
            {"CREATION_OP", "create new application", "cctrlapp <app_name> create php"},
            {"UPLOAD_OP", "upload new application", "./appengine-java-sdk/bin/appcfg.sh [options] <action> <war-location>"}
    };

    //Title, description, optional, value
    String[][] PARAMETERS = {
            {"app_name", "Application Name", "false", "hellocc"},
            {"action", "Action to be applied on App Engine concerning given application", "false", "upload"},
            {"war-location", "Path to application war", "false", ""}
    };

    //Title, terms, condition
    String[][] EXCEPTIONS = {
            {"APPLICATION_NOT_FOUND", "Application not found", "Uknown"},
            {"UNSPECIFIED_ACTION", "Action not specified", "Uknown"}
    };

    //Title, description
//	String[][] PRICING_POLICIES = {
//			{"Pay-as-you-go", 
//				"Add-ons are also completly pay-as-you-go add them on-demand and only pay for the time you used them."},
//			{"Paid pricing", 
//				"Paid pricing model. See http://www.google.com/enterprise/cloud/appengine/pricing.html"}
//	};

    //Type
    HardwareCategoryType[] HARDWARE_COMPONENTS =
            {HardwareCategoryType.NetworkCategory,
                    HardwareCategoryType.StorageCategory,
                    HardwareCategoryType.ComputationalCategory};

    //type, description
    String[][] SOFTWARE_CATEGORIES = {
            {"RDBMS", "Relational database"},
            {"Memory Storage", "in-memory storage"},
            {"Security", "Security tools"},
            {"Monitoring", "Application monitoring tools"}
    };

    //title, Description, version, licenseType, title, category index
    String[][] SOFTWARE_COMPONENTS = {
            {"MySQL", "MySQL is one of the most used relational database systems for web applications", "5.5.16", "GPL", "0"},
            {"In-memory Storage", "In memory storage", "Apache", "2011", "1"},
            {"MemChached", "Speed up your deployment with super-fast in memory object caching", "Apache", "2011", "1"},
            {"SSL", "SSL encryption for sensitive data", "GPL", "2011", "2"},
            {"New Relic", "Monitor, troubleshoot and tune your apps 24x7", "Apache", "2011", "3"},
            {"Mongo-DB", "State of the art NoSQL document based database", "Apache", "2011", "0"},
    };

    //Value, comment
    String[][] RATINGS = {
            {"5 star", "Excelent PaaS provider"},
            {"4 star", "Very good PaaS provider"},
            {"3 star", "Good PaaS provider"},
            {"2 star", "Acceptable PaaS provider"},
            {"1 star", "Poor PaaS provider"}
    };

    //Value, comment
    String[][] PROGRAMMNING_LANGUAGE = {
            {"PHP", "5.3.8"},
            {"Java", "1.6"},
            {"C/C++", "11"},
            {"ASP.NET", "4"},
            {"Python", "2.7.2"},
            {"Scala", "2.9.1"},
            {"Ruby", "1.9.2"}
    };

    //Title, homepage
//	String[][] INFRASTRUCTURES = {
//			{"Amazon EC2", "http://aws.amazon.com/ec2/"},
//			{"Google App Engine", "http://code.google.com/appengine/docs/whatisgoogleappengine.html"}
//	};


//	@Test
//	public void createFrontendPaasInstanceTest() throws MalformedURLException{
//		PaaSOffering paasInstance = createFrontendPaaSInstance();
//		
//		Assert.assertNotNull(paasInstance);
//	}

    @Test
    @Ignore
    public void createCorePaasInstanceTest() throws MalformedURLException, UnsupportedDataTypeException {
        eu.cloud4soa.api.datamodel.core.PaaSInstance paasInstance = createCorePaaSInstance(0);
        Assert.assertNotNull(paasInstance);
    }

    @Test
    @Ignore
    public void createListCorePaasInstanceTest() throws MalformedURLException, UnsupportedDataTypeException {
        List<eu.cloud4soa.api.datamodel.core.PaaSInstance> instances = createListCorePaaSInstances();
        Assert.assertNotNull(instances);
        Assert.assertTrue(instances.size() > 0);
    }

//	private PaaSOffering createFrontendPaaSInstance() {
//		//PaaSOffering
//		PaaSOffering paasInstance = new PaaSOffering();
//		paasInstance.setTitle("Google App Engine Premiun");
//		paasInstance.setURL("http://code.google.com/appengine/");
//		paasInstance.setStatus("Active");
//		
//		//PaaSProvider
//		PaaSProvider provider = new PaaSProvider();
//		provider.setTitle("Google");
//		provider.setHomepage("http://www.google.com/about/corporate/company/");
//		paasInstance.setPaaSProvider(provider);
//		
//		//Ratings. Not supported by the review DEMO
//		Rating rating = new Rating();
//		rating.setComment("Reliable PaaS offer");
//		rating.setValue(Rating.RATING_VALUE.FOUR_STARS);
//		paasInstance.getRating().add(rating);
//		
//		//Software Components: TOOLS
//		SoftwareComponent sc = new SoftwareComponent();
//		sc.setTitle("MySQL");
//		sc.setDescription("MySQL is one of the most used relational database systems for web applications");
//		sc.setVersionname("5.5.16");
//		sc.setLicensetype("GPL");
//		SoftwareCategory softCategory = new SoftwareCategory();
//		softCategory.setTitle("RDBMS");
//		softCategory.setDescription("relational database");
//		sc.setRelatedswcategory(softCategory );
//		paasInstance.getOfferedSoftware().add(sc);
//        
//		//Hardware Components: RESOURCES
//		HardwareComponent hc = new HardwareComponent();
//		hc.setCategory(HardwareCategoryType.Box.name());
//		paasInstance.getOfferedHardwareComponents().add(hc);
//		
//		//Programming language
//		ProgrammingLanguage supportedLanguage = new ProgrammingLanguage();
//		supportedLanguage.setTitle("Java");
//		paasInstance.setSupportedLanguage(supportedLanguage);
//		
//		//PrincingPolicies. Not supported in review DEMO
//		PricingPolicy pp1 = new PricingPolicy();
//		pp1.setTitle("Paid");
//		pp1.setDescription("Paid pricing model. See http://www.google.com/enterprise/cloud/appengine/pricing.html");
//		paasInstance.getPricingPolicies().add (pp1);
//		
//		//Communication channels		
//		Channel channel = new Channel ();
//		channel.setTitle("CloudControl CLI");
//		channel.setDescription("The command line client is a powerful interface to our API enabling developers to control all features of the cloudControl platform");
//		channel.setVersion("1.0");
//		channel.setURL("http://cloudcontrol.com/CLI");
//		channel.setType(ChannelType.CLI.name());
//		
//		//Channel operations
//		Operation operation = new Operation();
//		operation.setTitle("create");
//		operation.setDescription("create new application");
//		operation.setOperationCommand("cctrlapp <app_name> create php");
//		channel.getOperations().add(operation);
//		
//		Parameter par = new Parameter();
//		par.setTitle("app_name");
//		par.setDescription("Application Namen");
//		par.setIsOptional(false);
//		par.setValue("hellocc");
//		operation.getRequiredParameters().add (par);
//
//		operation.getThrownException().add(new Exception ("Application not found"));
//		
//		paasInstance.getCommunicationChannels().add (channel);
//		
//		//Resources: They are HardwareComponents
//
//		return paasInstance;
//	}

    public List<eu.cloud4soa.api.datamodel.core.PaaSInstance> createListCorePaaSInstances() throws UnsupportedDataTypeException {
        List<eu.cloud4soa.api.datamodel.core.PaaSInstance> instances =
                new ArrayList<eu.cloud4soa.api.datamodel.core.PaaSInstance>();
        for (int i = 0; i < PAASOFFERINGS.length; i++) {
            instances.add(createCorePaaSInstance(i));
        }
        return instances;
    }

    private eu.cloud4soa.api.datamodel.core.PaaSInstance createCorePaaSInstance() {

        // UUID is created for any inner object property automatically
        eu.cloud4soa.api.datamodel.core.PaaSInstance paas = new eu.cloud4soa.api.datamodel.core.PaaSInstance();
        List<eu.cloud4soa.api.datamodel.core.PaaSInstance> providedPaaSInstances =
                new ArrayList<eu.cloud4soa.api.datamodel.core.PaaSInstance>();

        paas.setTitle("CloudControl PHP");

        //Offering
        paas.setURL("http://cloudcontrol.com/home/");
        paas.setStatus("Available");
        CLIInstance cLIInstance = (CLIInstance) paas.createAndAddChannel(ChannelType.CLI);
        cLIInstance.setTitle("CLI");
        cLIInstance.setDescription("The command line client is a powerful interface to our API enabling developers to control all features of the cloudControl platform");
        cLIInstance.setVersion("1.0");
        cLIInstance.setURL("http://cloudcontrol.com/CLI");
        OperationInstance operationInstance = cLIInstance.createAndAddOperation("create", "create new application", "cctrlapp <app_name> create php", "");
        ParameterInstance parameterInstance = new ParameterInstance("app_name", "Application Name", false, "hellocc");
        operationInstance.addRequiredParameter(parameterInstance);
        ExceptionInstance exceptionInstance = new ExceptionInstance("APPLICATION_NOT_FOUND", "Application not found", "Uknown");
        operationInstance.addThrownException(exceptionInstance);
        HardwareComponentInstance hardwareComponent = paas.createAndAddHardwareComponent(HardwareCategoryType.ComputationalCategory);
//      fill the hardwareComponent parameters
//        BoxInstance boxInstance = (BoxInstance) hardwareComponent.getRelatedhwcategoryInstance();
//      fill the boxInstance parameters
//		offering.getOfferedHardwareComponents().add (
//		createHardwareComponent("Master/Slave", "Master/Slave servers", "1.0", "CloudControl", "SAERRZX231"));
        SoftwareCategoryInstance softwareCategoryInstance = new SoftwareCategoryInstance("RDBMS", "relational database");
        paas.createAndAddSoftwareComponent("MySQL", "MySQL is one of the most used relational database systems for web applications",
                "5.5.16", "GPL", softwareCategoryInstance);
//		offering.getRating().add (createRating("5 star", "Excelent PaaS provider"));
        paas.setSupportedProgrammingLanguage("PHP");
//		offering.setUseInfrastructure(createIaaSProvider("Amazon EC2", "http://aws.amazon.com/ec2/")); 

        providedPaaSInstances.add(paas);

        //Provider
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance("CloudControl", "http://cloudcontrol.com");
        paaSProviderInstance.setProvidedPaaS(providedPaaSInstances);

        PaaSUserInstance paaSUserInstance = createPaaSUserInstance();
        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);

        return paas;
    }

    private PaaSUserInstance createPaaSUserInstance() {
        PaaSUserInstance userInstance = new PaaSUserInstance();
        userInstance.setFirstName("Yosu");
        userInstance.setFamilyname("Gorroñogoitia");
        userInstance.setGeekcode("yosu");
        userInstance.setSurname("Gorroñogoitia");
        Calendar calendar = Calendar.getInstance(Locale.ITALY);
        calendar.set(1967, 3, 11);
        userInstance.setBirthday(Calendar.getInstance().getTime());
        //Assigned by the system
//		userInstance.setCloud4SoaAccountUriId("http:www.cloud4soa.eu/yosu#");
        Cloud4SoaAccountInstance cloud4SoaAccountInstance = new Cloud4SoaAccountInstance();
        cloud4SoaAccountInstance.setAccountname("cloudcontrol");
        //Assigned by the system
//		cloud4SoaAccount.setUriId("http:www.cloud4soa.eu/yosu#");
        userInstance.setHoldsaccount(cloud4SoaAccountInstance);
        return userInstance;
    }

    private eu.cloud4soa.api.datamodel.core.PaaSInstance createCorePaaSInstance(int index) throws UnsupportedDataTypeException {
        eu.cloud4soa.api.datamodel.core.PaaSInstance paas = new eu.cloud4soa.api.datamodel.core.PaaSInstance();
        List<eu.cloud4soa.api.datamodel.core.PaaSInstance> providedPaaSInstances =
                new ArrayList<eu.cloud4soa.api.datamodel.core.PaaSInstance>();

        Random rand = new Random();

        //Offering
        paas.setTitle(PAASOFFERINGS[index][0]);
        paas.setURL(PAASOFFERINGS[index][1]);
        paas.setStatus(PAASOFFERINGS[index][2]);

        int channelIndex = rand.nextInt(CHANNEL_TYPES.length);
        ChannelInstance channelInstance = (ChannelInstance) paas.createAndAddChannel(CHANNEL_TYPES[channelIndex]);

        channelInstance.setTitle(CHANNELS[channelIndex][0]);
        channelInstance.setDescription(CHANNELS[channelIndex][1]);
        channelInstance.setVersion(CHANNELS[channelIndex][2]);

        if (CHANNEL_TYPES[channelIndex] == ChannelType.CLI) {
            ((CLIInstance) channelInstance).setURL(CHANNELS[channelIndex][3]);
        }

        int operIndex = rand.nextInt(OPERATIONS.length);
        int parIndex = rand.nextInt(PARAMETERS.length);
        int exIndex = rand.nextInt(EXCEPTIONS.length);
        OperationInstance operationInstance = channelInstance.createAndAddOperation(
                OPERATIONS[operIndex][0], OPERATIONS[operIndex][1], OPERATIONS[operIndex][2], OPERATIONS[operIndex][3]);
        ParameterInstance parameterInstance = new ParameterInstance(
                PARAMETERS[parIndex][0], PARAMETERS[parIndex][1], new Boolean(PARAMETERS[parIndex][2]), PARAMETERS[parIndex][3]);
        operationInstance.addRequiredParameter(parameterInstance);
        ExceptionInstance exceptionInstance = new ExceptionInstance(EXCEPTIONS[exIndex][0], EXCEPTIONS[exIndex][1], EXCEPTIONS[exIndex][2]);
        operationInstance.addThrownException(exceptionInstance);

        //Not exposed by the review DEMO
//		offering.getPricingPolicies().add(
//				createPricingPolicy(PRICING_POLICIES[index][0], PRICING_POLICIES[index][1]));


//		offering.getHostsApplication().add (createApplication());

        int hcIndex = rand.nextInt(HARDWARE_COMPONENTS.length);
        HardwareComponentInstance hardwareComponent = paas.createAndAddHardwareComponent(HARDWARE_COMPONENTS[hcIndex]);
//		HardwareCategoryInstance boxInstance =  hardwareComponent.getRelatedhwcategoryInstance();
//		HardwareComponentInstance hcinstance = paas.getHardwareComponents().next();

        int scIndex = rand.nextInt(SOFTWARE_COMPONENTS.length);
        SoftwareCategoryInstance softwareCategoryInstance =
                new SoftwareCategoryInstance(
                        SOFTWARE_CATEGORIES[Integer.valueOf(SOFTWARE_COMPONENTS[scIndex][4])][0],
                        SOFTWARE_CATEGORIES[Integer.valueOf(SOFTWARE_COMPONENTS[scIndex][4])][1]);
        paas.createAndAddSoftwareComponent(SOFTWARE_COMPONENTS[scIndex][0], SOFTWARE_COMPONENTS[scIndex][1],
                SOFTWARE_COMPONENTS[scIndex][2], SOFTWARE_COMPONENTS[scIndex][3], softwareCategoryInstance);

        //Not exposed by the review DEMO
//		offering.getRating().add (createRating(RATINGS[index][0], RATINGS[index][1]));

        int plIndex = rand.nextInt(PROGRAMMNING_LANGUAGE.length);
        paas.setSupportedProgrammingLanguage(PROGRAMMNING_LANGUAGE[plIndex][0]);

        //Not exposed by the review DEMO
//		offering.setUseInfrastructure(createIaaSProvider(INFRASTRUCTURES[index][0], INFRASTRUCTURES[index][1])); 


        //Provider
        PaaSProviderInstance paaSProviderInstance = new PaaSProviderInstance(PAASPROVIDERS[index][0], PAASPROVIDERS[index][1]);
        paaSProviderInstance.setProvidedPaaS(providedPaaSInstances);
        paas.setPaaSProviderInstance(paaSProviderInstance);

        PaaSUserInstance paaSUserInstance = createPaaSUserInstance();
        paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);

        return paas;
    }

//	private eu.cloud4soa.api.datamodel.core.PaaSInstance createCorePaaSInstanceOld(int index) {
//		eu.cloud4soa.api.datamodel.core.PaaSInstance paas = new eu.cloud4soa.api.datamodel.core.PaaSInstance ();
//		eu.cloud4soa.api.datamodel.semantic.paas.PaaSOffering offering = paas.getPaaSOffering();
//		eu.cloud4soa.api.datamodel.semantic.ent.PaaSProvider provider = paas.getPaaSProvider();
//		
//		//Offering
//		offering.setTitle(PAASOFFERINGS[index][0]);
//		offering.setURL(PAASOFFERINGS[index][1]);
//		offering.setStatus(PAASOFFERINGS[index][2]);
//		offering.getCommunicationChannels().add(
//				createChannel(CHANNELS[index][0], CHANNELS[index][1], CHANNELS[index][2], 
//						createOperation(OPERATIONS[index][0], OPERATIONS[index][1], OPERATIONS[index][2], 
//								createOperationType(
//										OPERATION_TYPES[index][0], OPERATION_TYPES[index][1], OPERATION_TYPES[index][2]), 
//								createParameter(
//										PARAMETERS[index][0], PARAMETERS[index][1], PARAMETERS[index][2], 
//										PARAMETERS[index][3]), OPERATIONS[index][3],
//								createException(EXCEPTIONS[index][0], EXCEPTIONS[index][1], EXCEPTIONS[index][2]))));
//		offering.getPricingPolicies().add(
//				createPricingPolicy(PRICING_POLICIES[index][0], PRICING_POLICIES[index][1]));
//		offering.getHostsApplication().add (createApplication());
//		offering.getOfferedHardwareComponents().add (
//				createHardwareComponent(HARDWARE_COMPONENTS[index][0], HARDWARE_COMPONENTS[index][1], 
//						HARDWARE_COMPONENTS[index][2], HARDWARE_COMPONENTS[index][3], HARDWARE_COMPONENTS[index][4]));
//		offering.getOfferedSoftware().add(
//				createSoftwareComponent(SOFTWARE_COMPONENTS[index][0], SOFTWARE_COMPONENTS[index][1], 
//						SOFTWARE_COMPONENTS[index][2], SOFTWARE_COMPONENTS[index][3], 
//						SOFTWARE_COMPONENTS[index][4], SOFTWARE_COMPONENTS[index][5]));
//		offering.getRating().add (createRating(RATINGS[index][0], RATINGS[index][1]));
//		offering.setSupportedLanguage(createProgrammingLanguage(PROGRAMMNING_LANGUAGE[index][0], PROGRAMMNING_LANGUAGE[index][1]));
//		offering.setUseInfrastructure(createIaaSProvider(INFRASTRUCTURES[index][0], INFRASTRUCTURES[index][1])); 
//
//		
//		//Provider
//		provider.getProvidePaaS().add(offering);
//		provider.setTitle(PAASPROVIDERS[index][0]); 
//		provider.setHomepage(createHomepage(PAASPROVIDERS[index][1])); 
//		
//		eu.cloud4soa.api.datamodel.semantic.user.PaaSUser user = provider.getUser();
//	
//		return paas;
//	}

    private eu.cloud4soa.api.datamodel.semantic.foaf.Document createHomepage(String homepageUrl) {
        eu.cloud4soa.api.datamodel.semantic.foaf.Document doc = new eu.cloud4soa.api.datamodel.semantic.foaf.Document();
        //TODO
        return doc;
    }

    private ApplicationInstance createCoreApplicationInstance() {
        ApplicationInstance app = new ApplicationInstance();

        app.setAcronym("C4SFE");
        app.setApplicationcode("WAR");
        app.setDigest("b928fb9e52853eca082b9313ef6d2678");
        app.setVersion("0.2");

        app.setArchiveExtensionName("war");
        app.setArchiveFileName("frontend-dashboard-0.0.1-SNAPSHOT.war");

        app.setProgramminglanguage("Java");
        app.setProgramminglanguageVersion("1.6");

        app.setDeploymentIP("?"); //What is Deployment IP

        app.setOwnerUriId(createPaaSUserInstance().getUriId());

        app.setPaaSOfferingDeployment(createCorePaaSInstance());

        app.setSizeQuantity(4.2f);

        return app;
    }

    private eu.cloud4soa.api.datamodel.semantic.app.InterfaceBetweenApplications createInterface() {
        eu.cloud4soa.api.datamodel.semantic.app.InterfaceBetweenApplications interf = new eu.cloud4soa.api.datamodel.semantic.app.InterfaceBetweenApplications();

//		interf.setCalledapplication(calledapplication); //Yosu: Do we need them by the review Demo
//		interf.setCallerapplication(callerapplication);

        interf.setDescribedindocument(createDocument()); //Yosu: questions concerning Document

        return interf;
    }

    private eu.cloud4soa.api.datamodel.semantic.app.ApplicationManual createApplicationManual() {
        eu.cloud4soa.api.datamodel.semantic.app.ApplicationManual am = new eu.cloud4soa.api.datamodel.semantic.app.ApplicationManual();

        //TODO

        return am;
    }

    private eu.cloud4soa.api.datamodel.semantic.app.ApplicationStatus createApplicationStatus() {
        eu.cloud4soa.api.datamodel.semantic.app.ApplicationStatus status = new eu.cloud4soa.api.datamodel.semantic.app.ApplicationStatus();
//		status.setDescribedindocument(createDocument());
        return status;
    }

    private eu.cloud4soa.api.datamodel.semantic.measure.Capacity createSize(float size) {
        eu.cloud4soa.api.datamodel.semantic.measure.Capacity s = new eu.cloud4soa.api.datamodel.semantic.measure.Capacity();
        eu.cloud4soa.api.datamodel.semantic.measure.Unit unit = new eu.cloud4soa.api.datamodel.semantic.measure.Unit();
        s.setMeasuredas(unit);
        s.setQuantity(size);
        return s;
    }

    private eu.cloud4soa.api.datamodel.semantic.app.ApplicationArchive createApplicationArchive(String title, String filename, String extension) {
        eu.cloud4soa.api.datamodel.semantic.app.ApplicationArchive aa = new eu.cloud4soa.api.datamodel.semantic.app.ApplicationArchive();

        aa.setTitle(title);
        aa.setFileName(filename);
        aa.setExtensionName(extension);

        return aa;
    }

    private eu.cloud4soa.api.datamodel.semantic.foaf.Document createDocument() {
        eu.cloud4soa.api.datamodel.semantic.foaf.Document doc = new eu.cloud4soa.api.datamodel.semantic.foaf.Document();

        // TODO

        return doc;
    }

    private eu.cloud4soa.api.datamodel.semantic.app.ApplicationDeployment createApplicationDeployment() {
        eu.cloud4soa.api.datamodel.semantic.app.ApplicationDeployment ad = new eu.cloud4soa.api.datamodel.semantic.app.ApplicationDeployment();

        // [Yosu] This object should be created after deployment by the deployment service

        return ad;
    }

    private eu.cloud4soa.api.datamodel.semantic.ent.Company createCompany() {
        eu.cloud4soa.api.datamodel.semantic.ent.Company co = new eu.cloud4soa.api.datamodel.semantic.ent.Company();

        //TODO

        return co;
    }

    private eu.cloud4soa.api.datamodel.semantic.user.Developer createDeveloper(String firstName, String familyName, String geekCode) {
        eu.cloud4soa.api.datamodel.semantic.user.Developer developer = new eu.cloud4soa.api.datamodel.semantic.user.Developer();

        developer.setFirstName(firstName);
        developer.setFamilyname(familyName);
        developer.setGeekcode(geekCode);
        developer.setSurname(familyName);
        Calendar calendar = Calendar.getInstance(Locale.ITALY);
        calendar.set(1967, 3, 11);
        developer.setBirthday(Calendar.getInstance().getTime());
        developer.setAIMchatID(null);
        developer.setCurrentproject(null);

        //TODO: Complete

        return developer;
    }

    private eu.cloud4soa.api.datamodel.semantic.ent.IaaSProvider createIaaSProvider(String title, String homepage) {
        eu.cloud4soa.api.datamodel.semantic.ent.IaaSProvider iaas = new eu.cloud4soa.api.datamodel.semantic.ent.IaaSProvider();
        iaas.setTitle(title);
        iaas.setHomepage(createHomepage(homepage));
        return iaas;
    }

    private eu.cloud4soa.api.datamodel.semantic.other.ProgrammingLanguage createProgrammingLanguage(String language, String version) {
        eu.cloud4soa.api.datamodel.semantic.other.ProgrammingLanguage pl = new eu.cloud4soa.api.datamodel.semantic.other.ProgrammingLanguage();
        pl.setTermsTitle(language);
        pl.setVersion(version);
        return pl;
    }

    private eu.cloud4soa.api.datamodel.semantic.paas.Rating createRating(String value, String comment) {
        eu.cloud4soa.api.datamodel.semantic.paas.Rating rating = new eu.cloud4soa.api.datamodel.semantic.paas.Rating();
        rating.setValue(value);
        rating.setComment(comment);
        return rating;
    }

    private eu.cloud4soa.api.datamodel.semantic.inf.SoftwareComponent createSoftwareComponent(String description, String licenseType,
                                                                                              String category, String supplierTitle, String title, String version) {
        eu.cloud4soa.api.datamodel.semantic.inf.SoftwareComponent sc = new eu.cloud4soa.api.datamodel.semantic.inf.SoftwareComponent();
        sc.setDescription(description);
        sc.setLicensetype(licenseType);
        eu.cloud4soa.api.datamodel.semantic.inf.SoftwareCategory relatedswcategory = new eu.cloud4soa.api.datamodel.semantic.inf.SoftwareCategory();
        relatedswcategory.setTitle(category);
        sc.setRelatedswcategory(relatedswcategory);
        sc.setTitle(title);
        sc.setVersion(version);
        return sc;
    }

    private eu.cloud4soa.api.datamodel.semantic.inf.HardwareComponent createHardwareComponent(String title, String description, String version, String supplierTitle, String HWCode) {
        eu.cloud4soa.api.datamodel.semantic.inf.HardwareComponent hc = new eu.cloud4soa.api.datamodel.semantic.inf.HardwareComponent();

        hc.setTitle(title);
        hc.setDescription(description);
        hc.setVersion(version);
        eu.cloud4soa.api.datamodel.semantic.inf.HardwareCategory relatedhwcategory = new eu.cloud4soa.api.datamodel.semantic.inf.HardwareCategory();
        hc.setRelatedhwcategory(relatedhwcategory);

        return hc;
    }

    private eu.cloud4soa.api.datamodel.semantic.paas.PricingPolicy createPricingPolicy(String title, String description) {
        eu.cloud4soa.api.datamodel.semantic.paas.PricingPolicy pp = new eu.cloud4soa.api.datamodel.semantic.paas.PricingPolicy();
        pp.setTitle(title);
        pp.setDescription(description);
        return pp;
    }

    private eu.cloud4soa.api.datamodel.semantic.paas.Channel createChannel(String title, String description, String version,
                                                                           eu.cloud4soa.api.datamodel.semantic.paas.Operation operation) {
        eu.cloud4soa.api.datamodel.semantic.paas.Channel ch = new eu.cloud4soa.api.datamodel.semantic.paas.Channel();
        ch.setTitle(title);
        ch.setDescription(description);
        ch.getSupportedOperations().add(operation);
        ch.setVersion(version);
        return ch;
    }

    private eu.cloud4soa.api.datamodel.semantic.paas.OperationType createOperationType(String title, String description, String command) {
        eu.cloud4soa.api.datamodel.semantic.paas.OperationType operationType = new eu.cloud4soa.api.datamodel.semantic.paas.OperationType();
        operationType.setTitle(title);
        operationType.setDescription(description);
        operationType.setOperationCommand(command);
        return operationType;
    }

    private eu.cloud4soa.api.datamodel.semantic.paas.Operation createOperation(String title, String description, String command,
                                                                               eu.cloud4soa.api.datamodel.semantic.paas.OperationType operationType, eu.cloud4soa.api.datamodel.semantic.paas.Parameter parameter, String returnInfo,
                                                                               eu.cloud4soa.api.datamodel.semantic.paas.Exception ex) {
        eu.cloud4soa.api.datamodel.semantic.paas.Operation op = new eu.cloud4soa.api.datamodel.semantic.paas.Operation();
        op.setTitle(title);
        op.setDescription(description);
        op.setOperationCommand(command);
        op.setOperationType(operationType);
        op.getRequiredParameters().add(parameter);
        op.setInformationReturned(returnInfo);
        op.getThrownException().add(ex);
        return op;
    }

    private eu.cloud4soa.api.datamodel.semantic.paas.Exception createException(String title, String description, String condition) {
        eu.cloud4soa.api.datamodel.semantic.paas.Exception ex = new eu.cloud4soa.api.datamodel.semantic.paas.Exception();
        ex.setTitle(title);
        ex.setDescription(description);
        ex.setCondition(condition);
        return ex;
    }

    private eu.cloud4soa.api.datamodel.semantic.paas.Parameter createParameter(String title, String description, String optional, String value) {
        eu.cloud4soa.api.datamodel.semantic.paas.Parameter p = new eu.cloud4soa.api.datamodel.semantic.paas.Parameter();
        p.setTitle(title);
        p.setDescription(description);
        p.setIsOptional(new Boolean(optional));
        p.setValue(value);
        return p;
    }
}
