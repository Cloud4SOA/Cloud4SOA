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

package eu.cloud4soa.frontend.commons.server.services.soa.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.activation.UnsupportedDataTypeException;
import javax.ws.rs.core.Response;

import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.CLIInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.ChannelInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.ChannelType;
import eu.cloud4soa.api.datamodel.core.utilBeans.Cloud4SoaAccountInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.ExceptionInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.HardwareCategoryType;
import eu.cloud4soa.api.datamodel.core.utilBeans.HardwareComponentInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.OperationInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.PaaSProviderInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.PaaSUserInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.ParameterInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.SoftwareCategoryInstance;
import eu.cloud4soa.api.soa.AnnouncementModule;
import eu.cloud4soa.api.soa.PaaSOfferingDiscovery;
import eu.cloud4soa.api.soa.UserManagementAndSecurityModule;
import eu.cloud4soa.api.util.exception.soa.SOAException;

public class DataObjectLoader {
	private String userInstanceId;
	private List<eu.cloud4soa.api.datamodel.core.PaaSInstance> paasInstances;
	
	private UserManagementAndSecurityModule userManagementAndSecurityModule;
	private AnnouncementModule announcementModule;
	private PaaSOfferingDiscovery paaSOfferingDiscovery;
	
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
	
	
	public DataObjectLoader(UserManagementAndSecurityModule userManagementAndSecurityModule,
			AnnouncementModule announcementModule, PaaSOfferingDiscovery paaSOfferingDiscovery){
		this.userManagementAndSecurityModule = userManagementAndSecurityModule;
		this.announcementModule = announcementModule;
		this.paaSOfferingDiscovery = paaSOfferingDiscovery;
	}
	
	public List<PaaSInstance> createPaasInstances() throws UnsupportedDataTypeException, SOAException{
		// Create PaaS Instances
		paasInstances = createListCorePaaSInstances();
		
		// Store them
		for (eu.cloud4soa.api.datamodel.core.PaaSInstance instance: paasInstances){			
			userInstanceId = createTestUserInstance(instance.getPaaSProviderInstance());
			announcementModule.storePaaSInstance(instance, userInstanceId);
		}
		
		return paasInstances;
	}
	
	private String createTestUserInstance(PaaSProviderInstance paaSProviderInstance) throws SOAException {
		PaaSUserInstance paaSUserInstance = new PaaSUserInstance();
		paaSUserInstance.setFirstName("Yosu");
		paaSUserInstance.setFamilyname("Gorroñogoitia");
		paaSUserInstance.setAccountname("yosu");
		paaSUserInstance.setGeekcode("yosu");
		paaSUserInstance.setSurname("Gorroñogoitia");
		Calendar calendar = Calendar.getInstance(Locale.ITALY);
		calendar.set(1967, 3, 11);
		paaSUserInstance.setBirthday(Calendar.getInstance().getTime());
		paaSUserInstance.setCloud4SoaAccountUriId("yosu");
		paaSUserInstance.setAccountname("yosu");
		
		paaSUserInstance.setPaaSProviderInstance(paaSProviderInstance);
		
		Response resp = userManagementAndSecurityModule.createNewAccount(paaSUserInstance, "username", "password");
        String userId = (String)resp.getEntity();
		return userId;
		
	}
	
	private List<eu.cloud4soa.api.datamodel.core.PaaSInstance> createListCorePaaSInstances() throws UnsupportedDataTypeException {
		List<eu.cloud4soa.api.datamodel.core.PaaSInstance> instances = 
			new ArrayList<eu.cloud4soa.api.datamodel.core.PaaSInstance>();
		for (int i=0; i<PAASOFFERINGS.length; i++){
			instances.add(createCorePaaSInstance(i));
		}
		return instances;
	}
	
    private eu.cloud4soa.api.datamodel.core.PaaSInstance createCorePaaSInstance(int index) throws UnsupportedDataTypeException {
		eu.cloud4soa.api.datamodel.core.PaaSInstance paas = new eu.cloud4soa.api.datamodel.core.PaaSInstance ();
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
        
        if (CHANNEL_TYPES[channelIndex] == ChannelType.CLI){
        	((CLIInstance)channelInstance).setURL(CHANNELS[channelIndex][3]);
		}
		
        int operIndex = rand.nextInt(OPERATIONS.length);
        int parIndex = rand.nextInt(PARAMETERS.length);
        int exIndex = rand.nextInt(EXCEPTIONS.length);
        OperationInstance operationInstance = channelInstance.createAndAddOperation(
        		OPERATIONS[operIndex][0], OPERATIONS[operIndex][1], OPERATIONS[operIndex][2], OPERATIONS[operIndex][3]);
        ParameterInstance parameterInstance = new ParameterInstance(
        		PARAMETERS[parIndex][0], PARAMETERS[parIndex][1], new Boolean (PARAMETERS[parIndex][2]), PARAMETERS[parIndex][3]);
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
}
