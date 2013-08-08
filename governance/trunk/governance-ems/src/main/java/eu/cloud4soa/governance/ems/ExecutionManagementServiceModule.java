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
f * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cloud4soa.governance.ems;

import cloudadapter.Adapter;
import eu.cloud4soa.api.datamodel.semantic.app.ApplicationDeployment;
import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import eu.cloud4soa.adapter.rest.AdapterClient;
import eu.cloud4soa.adapter.rest.auth.CustomerCredentials;
import eu.cloud4soa.adapter.rest.common.Operation;
import eu.cloud4soa.adapter.rest.exception.AdapterClientException;
import eu.cloud4soa.adapter.rest.impl.AdapterClientCXF;
import eu.cloud4soa.adapter.rest.request.*;
import eu.cloud4soa.adapter.rest.response.*;
import eu.cloud4soa.adapter.rest.response.model.Database;
import eu.cloud4soa.adapter.rest.response.model.Deployment;
import eu.cloud4soa.governance.sla.enforcement.SLAEnforcementModule;
import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.datamodel.governance.DeployApplicationParameters;
import eu.cloud4soa.relational.datamodel.SLAPolicy;
import eu.cloud4soa.api.datamodel.governance.SlaContract;
import eu.cloud4soa.api.datamodel.soa.GitRepoInfo;
import eu.cloud4soa.api.governance.MonitoringModule;
import eu.cloud4soa.api.util.exception.adapter.C4SInternalException;
import eu.cloud4soa.api.util.exception.adapter.PaaSException;
import eu.cloud4soa.api.util.exception.adapter.PaaSConnectionException;
import eu.cloud4soa.governance.ems.util.ExecutionManagementUtil;
import eu.cloud4soa.api.util.exception.adapter.Cloud4SoaException;
import eu.cloud4soa.relational.datamodel.Account;
import eu.cloud4soa.relational.datamodel.GuaranteeTerm;
import eu.cloud4soa.relational.datamodel.SLAContract;
import eu.cloud4soa.relational.datamodel.SLATemplate;
import eu.cloud4soa.relational.datamodel.ServiceDescriptionTerm;
import eu.cloud4soa.relational.datamodel.User;
import eu.cloud4soa.relational.persistence.AccountRepository;
import eu.cloud4soa.relational.persistence.ApplicationInstanceRepository;
import eu.cloud4soa.relational.persistence.MonitoringJobRepository;
import eu.cloud4soa.relational.persistence.PaasRepository;
import eu.cloud4soa.relational.persistence.SLAContractRepository;
import eu.cloud4soa.relational.persistence.SLATemplateRepository;
import eu.cloud4soa.relational.persistence.UserRepository;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import openshift.Openshift_Aux;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author vincenzo
 */
public class ExecutionManagementServiceModule implements eu.cloud4soa.api.governance.ExecutionManagementServiceModule {

    final static Logger logger = LoggerFactory.getLogger(ExecutionManagementServiceModule.class);
    @Autowired
    private MonitoringModule monitoringModule;
    @Autowired
    private UserRepository userrepository;
    @Autowired
    private PaasRepository paasrepository;
    @Autowired
    private AccountRepository accountrepository;
    @Autowired
    private ApplicationInstanceRepository appinstancerepository;
    @Autowired
    private MonitoringJobRepository monitoringjobrepository;
    @Autowired
    private SLATemplateRepository sla_template_repository;
    @Autowired
    private SLAContractRepository sla_contract_repository;
    @Autowired
    private SLAEnforcementModule sla_enforcement_module;
    //@Autowired //cannot be called
    //private GitServices gitservices;
//    @Autowired
//    private GitRepoRepository gitrepo;
//    @Autowired 
//    private GitProxyRepository gitproxy;

//     ///AWS
//     String accessKeyId="AKIAJRSZ7FBNKBAOUR6A";
//     String secretAccessKey="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";
//     //CLOUDBEES
//     String api_key = "4184E8A5D19D02D9";
//     String api_secret = "UZPYSQVJMQLVNNVK6GSZQPRUTAZ+QKNB9QCKDWVNQMK=";
    
    private class DeploymentUrls {
        public String adapterAppUrl;
        public String deployedAppUrl;
    }
    
    /**
     * @param monitoringModule the monitoringModule to set
     */
    public void setMonitoringModule(MonitoringModule monitoringModule) throws Cloud4SoaException {
        this.monitoringModule = monitoringModule;
    }

/*    @Override
    public String deployApplication(File applicationArchive, ApplicationInstance applicationInstance, PaaSInstance paaSInstance, String publicKey, String secretKey, String accountName) throws Cloud4SoaException {
        List<Account> accounts;
        
        accounts = accountrepository.find("publickey = ? AND privatekey = ?", publicKey, secretKey);
        logger.info("accounts-size: " + accounts.size());
        
        DeploymentUrls urls = deployApplicationArchiveOnPaaS(applicationArchive, applicationInstance, paaSInstance, accountName, publicKey, secretKey, accounts);
        
        storeAppInfoIntoRelationalDB(accounts, applicationInstance, urls.deployedAppUrl, urls.adapterAppUrl);
        
        saveDeploymentInfoAndStartMonitoring(urls.deployedAppUrl, paaSInstance, urls.adapterAppUrl, applicationInstance, null);

        return urls.deployedAppUrl;

    }
* 
*/
    
    
    /*
     * Introduce the creation of the SLA contract
     * 
     */
/*    @Deprecated
    @Override
    public String deployApplication(File applicationArchive, ApplicationInstance applicationInstance, PaaSInstance paaSInstance, String publicKey, String secretKey, String accountName, String slaTemplateID) throws Cloud4SoaException {
        List<Account> accounts;

        String SLAcontractId;
        
        accounts = accountrepository.find("publickey = ? AND privatekey = ?", publicKey, secretKey);
        logger.info("accounts-size: " + accounts.size());
        
        DeploymentUrls urls = deployApplicationArchiveOnPaaS(applicationArchive, applicationInstance, paaSInstance, accountName, publicKey, secretKey, accounts);

        SLAcontractId = createSLAAgreement( slaTemplateID );
        
        storeAppInfoIntoRelationalDB(accounts, applicationInstance, urls.deployedAppUrl, urls.adapterAppUrl);
        
        saveDeploymentInfoAndStartMonitoring(urls.deployedAppUrl, paaSInstance, urls.adapterAppUrl, applicationInstance, SLAcontractId);

        return urls.deployedAppUrl;

    }
     * 
     */

    
    
    /*
     * Introduce the creation of the SLA contract
     * 
     */
    @Override
    public String deployApplication( DeployApplicationParameters parameters) throws Cloud4SoaException {
            
        File applicationArchive; 
        ApplicationInstance applicationInstance;
        PaaSInstance paaSInstance;
        String publicKey;
        String secretKey;
        String accountName;
        String slaTemplateID;
        List<eu.cloud4soa.api.datamodel.governance.SlaPolicy> penalties;   
        List<Account> accounts;
        String SLAcontractId;
        
        applicationInstance     = parameters.getApplicationInstance();
        paaSInstance            = parameters.getPaaSInstance();
        applicationArchive      = parameters.getApplicationArchive();
        publicKey               = parameters.getPublicKey();
        secretKey               = parameters.getSecretKey();
        accountName             = parameters.getAccountName();
        slaTemplateID           = parameters.getSlaTemplateID();
        penalties               = parameters.getPenalties();
        
        accounts = accountrepository.find("publickey = ? AND privatekey = ?", publicKey, secretKey);
        logger.info("accounts-size: " + accounts.size());
        
        DeploymentUrls urls = deployApplicationArchiveOnPaaS(applicationArchive, applicationInstance, paaSInstance, accountName, publicKey, secretKey, accounts);

        SLAcontractId = createSLAAgreement( slaTemplateID, penalties );
        
        storeAppInfoIntoRelationalDB(accounts, applicationInstance, urls.deployedAppUrl, urls.adapterAppUrl);
        
        saveDeploymentInfoAndStartMonitoring(urls.deployedAppUrl, paaSInstance, urls.adapterAppUrl, applicationInstance, SLAcontractId);

        sla_enforcement_module.startEnforcement(applicationInstance);
        
        return urls.deployedAppUrl;

    }
    
    
    
    @Override
    public eu.cloud4soa.api.datamodel.governance.ApplicationArchive retrieveApplication(ApplicationInstance applicationInstance) throws Cloud4SoaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void startStopApplication(ApplicationInstance applicationInstance, String startStopCommand, String publicKey, String secretKey, String accountName) throws Cloud4SoaException {

        AdapterClient adapterClient = new AdapterClientCXF();


        //CustomerCredentials credentials = new CustomerCredentials(publicKey, secretKey);
        List<Account> accounts = accountrepository.find("publickey = ? AND privatekey = ?", publicKey, secretKey);
        logger.info("accounts-size: " + accounts.size());
        eu.cloud4soa.relational.datamodel.ApplicationInstance appinInstance = new eu.cloud4soa.relational.datamodel.ApplicationInstance();
        String account = accounts.get(0).getAccountname();
        CustomerCredentials credentials = new CustomerCredentials(publicKey + "_" + secretKey + "_" + account, secretKey);


        String adapterLocation = "";
        String appVersion = "";
        //  adapterLocation = "http://adaptertest.elasticbeanstalk.com";

//        List<eu.cloud4soa.relational.datamodel.ApplicationInstance> applicationlist = appinstancerepository.findBy("uriID", applicationInstance.getUriId());
        List<eu.cloud4soa.relational.datamodel.ApplicationInstance> applicationlist = appinstancerepository.find("uriID = ? AND account.id = ?", applicationInstance.getUriId(), accounts.get(0).getId());
        if (applicationlist != null) {
            adapterLocation = ((eu.cloud4soa.relational.datamodel.ApplicationInstance) applicationlist.get(0)).getAdapterurl();
            //-->get account-->then from account get PaaS

            //For Amazon Elastic Beanstalk start/stop application we have to also pass as parameter the previous version of the application
            if (accounts.get(0).getPaas().getName().equalsIgnoreCase("Amazon PaaS Provider")) {
                appVersion = "@_@" + ((eu.cloud4soa.relational.datamodel.ApplicationInstance) applicationlist.get(applicationlist.size() - 1)).getVersion();
            }
        }



        OperationRequest operationRequest = new OperationRequest();
        operationRequest.setBaseUrl(adapterLocation);

        operationRequest.setApplicationName(applicationInstance.getTitle() + appVersion);
        operationRequest.setOperation(Operation.toOperation(startStopCommand));
/*
            eu.cloud4soa.relational.datamodel.ApplicationInstance appInstance= applicationlist.get(0);
        if(startStopCommand.equalsIgnoreCase("stop")){          
            System.out.println("runtime:"+appInstance.getRuntime());
            ///Placeholder for changing runtime - temporary some fixed values
            appInstance.setRuntime(110L);         
        }    
        if(startStopCommand.equalsIgnoreCase("start")){
        System.out.println("runtime:"+appInstance.getRuntime());
           ///Placeholder for changing runtime - temporary some fixed values
          appInstance.setRuntime(44L);  
        }
            appinstancerepository.store(appInstance);
      */  
            
            
        try {
            OperationResponse operationResponse = adapterClient.send(operationRequest, credentials);

            int status = operationResponse.getStatusCode().ordinal();
            logger.info(startStopCommand + " - " + operationResponse.getStatusCode().toString() + " " + (status > 199 && status < 300 ? "successfull" : "failed") + " for app: " + applicationInstance.getTitle());
            if (!(status > 199 && status < 300)) {
                throw new Cloud4SoaException("Error in performing the " + startStopCommand + " command for app: " + applicationInstance.getTitle()
                        + " - cause: " + operationResponse.getStatusCode().toString());
            }
        } catch (AdapterClientException e) {
            throw new Cloud4SoaException(new PaaSException(e.getMessage()));
        }
         catch (UnknownHostException e) {
            throw new Cloud4SoaException(new PaaSConnectionException(e.getMessage()));
        }

    }

    @Override
    public String createDatabase(ApplicationInstance applicationInstance, PaaSInstance paaSInstance, String publicKey, String secretKey, String accountName, String dbname, String dbuser, String dbpassword, String dbtype) throws Cloud4SoaException {
        AdapterClient adapterClient = new AdapterClientCXF();
        //CustomerCredentials credentials = new CustomerCredentials(publicKey, secretKey);
        List<Account> accounts = accountrepository.find("publickey = ? AND privatekey = ?", publicKey, secretKey);
        logger.info("accounts-size: " + accounts.size());
        String account = accounts.get(0).getAccountname();
        CustomerCredentials credentials = new CustomerCredentials(publicKey + "_" + secretKey + "_" + account, secretKey);


        //TODO: don't deploy the adapter again if it has been allready deployed(eg:from deployApplication)
        String paas_name = paaSInstance.getProviderTitle();

        String deployedAppUrl = "";
        String adapterAppUrl = "";
        String adapterLocation = "";
        if (paas_name.equalsIgnoreCase("CloudBees")) {
            //check if application alredy exists
            String cloudbeesAccount = "";
            cloudbeesAccount = accounts.get(0).getAccountname();
            //adapter deployment
            adapterAppUrl = uploadAdapterIfNeeded(applicationInstance, paaSInstance.getTitle(), accounts.get(0), "CloudBees", ExecutionManagementUtil.getCloudBeesAdapterPath(), publicKey, secretKey, cloudbeesAccount, "c4sad" + applicationInstance.getTitle(), "", "", "", "", "", "", "c4sad");
            storeAppInfoIntoRelationalDB(accounts, applicationInstance, deployedAppUrl, adapterAppUrl);
        } else if (paas_name.equalsIgnoreCase("Amazon PaaS Provider")) {
            //adapter deployment
            adapterAppUrl = uploadAdapterIfNeeded(applicationInstance, paaSInstance.getTitle(), accounts.get(0), "Beanstalk", ExecutionManagementUtil.getBeanstalkAdapterPath(), publicKey, secretKey, "", "c4sad" + applicationInstance.getTitle(), "adapterversion1", "cloud4soa", "", "", "", "", "");
            storeAppInfoIntoRelationalDB(accounts, applicationInstance, deployedAppUrl, adapterAppUrl);
            waitForBeanstalkApplicationReady("Beanstalk", publicKey, secretKey, "", "c4sad" + applicationInstance.getTitle(), "cloud4soa", "", "");

        } else if (paas_name.equalsIgnoreCase("Heroku")) {
            credentials = new CustomerCredentials(publicKey, secretKey);
            String herokuAdapterLocation = "http://c4s.herokuapp.com/";
            //replace this with the per application specific adapter
            adapterAppUrl   = herokuAdapterLocation;
            adapterLocation = herokuAdapterLocation;
        } else if (paas_name.equalsIgnoreCase("VMware")) {
            //adapter deployment
            adapterAppUrl = uploadAdapterIfNeeded(applicationInstance, paaSInstance.getTitle(), accounts.get(0), "CloudFoundry", ExecutionManagementUtil.getCloudBeesAdapterPath(), publicKey, secretKey, "", "c4sad" + applicationInstance.getTitle(), "", "", "", "", "", "", "c4sad");
            storeAppInfoIntoRelationalDB(accounts, applicationInstance, deployedAppUrl, adapterAppUrl);
        }

        if (paas_name.equalsIgnoreCase("Amazon PaaS Provider")) {
            String dbhost = Adapter.createDB("Beanstalk", publicKey, secretKey, "", "", "MySQL", "", "", dbname, dbuser, dbpassword);
            return dbhost;
        } /**
         * TODO extract
         */
        else {
            CreateDatabaseRequest createDatabaseRequest = new CreateDatabaseRequest();
            List<eu.cloud4soa.relational.datamodel.ApplicationInstance> applicationlist = appinstancerepository.find("uriID = ? AND account.id = ?", applicationInstance.getUriId(), accounts.get(0).getId());
            if (applicationlist != null && !applicationlist.isEmpty()) {
                adapterLocation = ((eu.cloud4soa.relational.datamodel.ApplicationInstance) applicationlist.get(0)).getAdapterurl();

            }
            createDatabaseRequest.setBaseUrl(adapterLocation);
            //application name is not actually used
            createDatabaseRequest.setApplicationName(applicationInstance.getTitle());
            createDatabaseRequest.setDatabaseName(dbname);
            // TODO commented in order to workaround bug #189
            createDatabaseRequest.setDatabaseUser(dbuser);
            createDatabaseRequest.setDatabasePassword(dbpassword);
            createDatabaseRequest.setDatabaseType(dbtype);

            try {
                CreateDatabaseResponse createDatabaseResponse = adapterClient.send(createDatabaseRequest, credentials);

                Database database = createDatabaseResponse.getDatabase();
                if (database != null) {
                    logger.info("create database successfull for app: " + applicationInstance.getTitle() + " with url: " + database.getHost());
                    return database.getHost();
                }
                return createDatabaseResponse.getStatusCode().toString();
            } catch (AdapterClientException e) {
                //throw new RuntimeException(e);
            throw new Cloud4SoaException(new PaaSException(e.getMessage()));
            }
              catch (UnknownHostException e) {
            throw new Cloud4SoaException(new PaaSConnectionException(e.getMessage()));
        }

        }//end of Remote Adapter call

    }

    @Override
    public void detectSlaViolation(SlaContract slaContract) throws Cloud4SoaException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void unDeployApplication(ApplicationInstance applicationInstance, String publicKey, String privateKey, String accountName) throws Cloud4SoaException {
        AdapterClient adapterClient = new AdapterClientCXF();

        try {
            /*
             * (non-javadoc) Note: I dont know if the properties, I use to build
             * the request object, are correct. I do not know anything about the
             * c4s data model. -> @see RequestFactory
             *
             * @author (dn@cloudcontrol.de)
             */
            //CustomerCredentials credentials = new CustomerCredentials(publicKey, secretKey);
            List<Account> accounts = accountrepository.find("publickey = ? AND privatekey = ?", publicKey, privateKey);
            logger.info("accounts-size: " + accounts.size());
            eu.cloud4soa.relational.datamodel.ApplicationInstance appinInstance = new eu.cloud4soa.relational.datamodel.ApplicationInstance();
            String account = accounts.get(0).getAccountname();
            Account c4saccount = accounts.get(0);
            logger.info("account-id:" + c4saccount.getId());
            CustomerCredentials credentials = new CustomerCredentials(publicKey + "_" + privateKey + "_" + account, privateKey);

            DeleteDeploymentRequest deleteDeploymentRequest = new DeleteDeploymentRequest();

            String adapterLocation = "";

//            List<eu.cloud4soa.relational.datamodel.ApplicationInstance> applicationlist = appinstancerepository.findBy("uriID", applicationInstance.getUriId());
            List<eu.cloud4soa.relational.datamodel.ApplicationInstance> applicationlist = appinstancerepository.find("uriID = ? AND account.id = ?", applicationInstance.getUriId(), accounts.get(0).getId());
            if (applicationlist != null && !applicationlist.isEmpty()) {
                adapterLocation = ((eu.cloud4soa.relational.datamodel.ApplicationInstance) applicationlist.get(0)).getAdapterurl();
            } else {
                //Maybe we should decide to have a generic adapter at some PaaSes in order to be
                //able to manage the application even if the adapter-per-app can't be found
                adapterLocation = "http://adaptertest.elasticbeanstalk.com";
            }

            deleteDeploymentRequest.setBaseUrl(adapterLocation);
            deleteDeploymentRequest.setApplicationName(applicationInstance.getTitle());
            deleteDeploymentRequest.setDeploymentName(applicationInstance.getApplication().getDeployment().getUriId());

            DeleteDeploymentResponse deleteDeploymentResponse = adapterClient.send(deleteDeploymentRequest, credentials);

            int status = deleteDeploymentResponse.getStatusCode().ordinal();
            logger.info("Undeploying - " + deleteDeploymentResponse.getStatusCode().toString() + " " + (status > 199 && status < 300 ? "successful" : "failed") + " for app: " + applicationInstance.getTitle());
            if (!(status > 199 && status < 300)) {
                throw new Cloud4SoaException("Error in performing the undeployment command for app: " + applicationInstance.getTitle()
                        + " - cause: " + deleteDeploymentResponse.getStatusCode().toString());
            }
             

        try{
            //start of adapter deletion
            //Now also delete the one per application adapter
            DeleteDeploymentRequest deleteAdapterRequest = new DeleteDeploymentRequest();

            deleteAdapterRequest.setBaseUrl(adapterLocation);
            deleteAdapterRequest.setApplicationName("c4sad" + applicationInstance.getTitle());
            //under research
            deleteAdapterRequest.setDeploymentName("c4sad" + applicationInstance.getApplication().getDeployment().getUriId());
            logger.debug("c4sad" + applicationInstance.getApplication().getDeployment().getUriId() + " adapter deletion");
            //DeleteDeploymentResponse deleteAdapterResponse = adapterClient.send(deleteAdapterRequest, credentials);
            //will return a HTTP/1.1 502 Bad Gateway response
            adapterClient.send(deleteAdapterRequest, credentials);
            } catch (AdapterClientException e) {
            //This exception is thrown normally because we force the adapter to delete itself
            logger.info("Adapter deleted");
            logger.debug(e.getMessage());
            }               
            //int adapterstatus = deleteAdapterResponse.getStatusCode().ordinal();
            //logger.info("Undeploying - " + deleteAdapterResponse.getStatusCode().toString() + " " + (adapterstatus > 199 && adapterstatus < 300 ? "successful" : "failed") + " for app: " + "c4sad" + applicationInstance.getTitle());
            /////////////////////////
            //end of adapter deletion
        	sla_enforcement_module.stopEnforcement(applicationInstance);
            removeDeploymentInfoAnsStopMonitoring(applicationInstance, c4saccount);
        } catch (AdapterClientException e) {
            throw new Cloud4SoaException(new PaaSException(e.getMessage()));
        }
          catch (UnknownHostException e) {
            throw new Cloud4SoaException(new PaaSConnectionException(e.getMessage()));
        }



    }

    @Override
    public String downloadDataBase(ApplicationInstance applicationInstance, String publicKey, String secretKey, String dbname, String dbuser, String dbpassword, String dbtype, String fileToStore) throws Cloud4SoaException {
        AdapterClient adapterClient = new AdapterClientCXF();
        String ret = "";
        List<Account> accounts = accountrepository.find("publickey = ? AND privatekey = ?", publicKey, secretKey);
        logger.info("accounts-size: " + accounts.size());
        eu.cloud4soa.relational.datamodel.ApplicationInstance appinInstance = new eu.cloud4soa.relational.datamodel.ApplicationInstance();
        String account = accounts.get(0).getAccountname();
        CustomerCredentials credentials = new CustomerCredentials(publicKey + "_" + secretKey + "_" + account, secretKey);
        
        String adapterLocation = "";

        List<eu.cloud4soa.relational.datamodel.ApplicationInstance> applicationlist = appinstancerepository.find("uriID = ? AND account.id = ?", applicationInstance.getUriId(), accounts.get(0).getId());
        if (applicationlist != null) {
            adapterLocation = ((eu.cloud4soa.relational.datamodel.ApplicationInstance) applicationlist.get(0)).getAdapterurl();
        }
        DatabaseRequest databaseRequest = new DatabaseRequest();
        databaseRequest.setBaseUrl(adapterLocation);
        databaseRequest.setApplicationName(applicationInstance.getTitle());
        databaseRequest.setDatabaseName(dbname);
        databaseRequest.setDeploymentName(applicationInstance.getPaaSOfferingDeploymentUriId());
        //databaseRequest.;

        if (accounts.get(0).getPaas().getName().equals("VMware")) {
            // Cloud Foundry code here
            Adapter.downloadDBCF(publicKey, secretKey, dbtype, dbname, fileToStore);
        } else {
            try {
                DatabaseResponse databaseResponse = adapterClient.send(databaseRequest, credentials);

                int status = databaseResponse.getStatusCode().ordinal();
                logger.info(" - " + databaseResponse.getStatusCode().toString() + " " + (status > 199 && status < 300 ? "successfull" : "failed") + " for app: " + applicationInstance.getTitle());

                try {
                    Database database = databaseResponse.getDatabase();
                    Adapter.downloadDB_REST(database.getHost(), database.getPort(), dbtype, dbname, dbuser, dbpassword, fileToStore);
                } catch (Cloud4SoaException e) {
                    logger.debug("couldn't download db succesfully");
                    throw new Cloud4SoaException(e.getMessage());
                }
            } catch (AdapterClientException e) {
                //throw new RuntimeException(e);
            throw new Cloud4SoaException(new PaaSException(e.getMessage()));
            }
              catch (UnknownHostException e) {
            throw new Cloud4SoaException(new PaaSConnectionException(e.getMessage()));
        }            
        }
        return ret;
    }

    
    
    @Override
    public String restoreDataBase(ApplicationInstance applicationInstance, PaaSInstance paaSInstance, String publicKey, String secretKey, String dbname, String dbuser, String dbpassword, String dbtype, String fileToRestore) throws Cloud4SoaException {
        AdapterClient adapterClient = new AdapterClientCXF();
        String ret = "";
        List<Account> accounts = accountrepository.find("publickey = ? AND privatekey = ?", publicKey, secretKey);
        logger.info("accounts-size: " + accounts.size());
        eu.cloud4soa.relational.datamodel.ApplicationInstance appinInstance = new eu.cloud4soa.relational.datamodel.ApplicationInstance();
        String account = accounts.get(0).getAccountname();
        CustomerCredentials credentials = new CustomerCredentials(publicKey + "_" + secretKey + "_" + account, secretKey);

        String adapterLocation = "";

        List<eu.cloud4soa.relational.datamodel.ApplicationInstance> applicationlist = appinstancerepository.find("uriID = ? AND account.id = ?", applicationInstance.getUriId(), accounts.get(0).getId());
        if (applicationlist != null) {
            adapterLocation = ((eu.cloud4soa.relational.datamodel.ApplicationInstance) applicationlist.get(0)).getAdapterurl();
        }
        DatabaseRequest databaseRequest = new DatabaseRequest();
        databaseRequest.setBaseUrl(adapterLocation);
        databaseRequest.setApplicationName(applicationInstance.getTitle());
        databaseRequest.setDatabaseName(dbname);
        databaseRequest.setDeploymentName(paaSInstance.getUriId());

        if (accounts.get(0).getPaas().getName().equals("VMware")) {
            // Cloud Foundry code here
            Adapter.restoreDBCF(publicKey, secretKey, dbtype, dbname, fileToRestore);
        } else {
            try {
                DatabaseResponse databaseResponse = adapterClient.send(databaseRequest, credentials);

                int status = databaseResponse.getStatusCode().ordinal();
                logger.info(" - " + databaseResponse.getStatusCode().toString() + " " + (status > 199 && status < 300 ? "successfull" : "failed") + " for app: " + applicationInstance.getTitle());

                try {
                    Database database = databaseResponse.getDatabase();
                    Adapter.restoreDB_REST(database.getHost(), database.getPort(), dbtype, dbname, dbuser, dbpassword, fileToRestore);
                } catch (Cloud4SoaException e) {
                    logger.debug("couldn't restore db dump succesfully");
            throw new Cloud4SoaException(new C4SInternalException(e.getMessage()));
                }
            } catch (AdapterClientException e) {
            throw new Cloud4SoaException(new PaaSException(e.getMessage()));
            }
              catch (UnknownHostException e) {
            throw new Cloud4SoaException(new PaaSConnectionException(e.getMessage()));
        }            
        }
        return ret;

    }

    
    
    private void waitForBeanstalkApplicationReady(String PaaS, String publicKey, String secretKey, String accountName, String appName,
            String environment, String type, String apiversion) throws Cloud4SoaException {
        String actualResponse = "";
        int busyWaitingTime = 10000;
        try {
            while (!actualResponse.equalsIgnoreCase("Ready")) {
                String appStatus = Adapter.getAppStatus(PaaS, publicKey, secretKey, accountName, appName, environment, type, apiversion);
                actualResponse = appStatus;
                if (actualResponse.equalsIgnoreCase("Terminating") || actualResponse.equalsIgnoreCase("Terminated")) {
                    throw new Cloud4SoaException("Error in set up the adapter deployment environment!");
                }
                logger.debug("Adapter Monitoring response status: " + actualResponse);
                Thread.sleep(busyWaitingTime);
            }
        } catch (InterruptedException ex) {
            logger.error("Error during the thread sleep");
        }
    }

    
    
    private String uploadAdapterIfNeeded(ApplicationInstance applicationInstance, String paaSInstanceTitle, Account account, String PaaS, String war, String publicKey, String secretKey, String accountName, String appName, String appVersion,
            String environment, String bucket, String host, String type, String apiversion, String description) throws Cloud4SoaException {
        String adapterAppUrl = "";

        List<eu.cloud4soa.relational.datamodel.ApplicationInstance> applicationlist = appinstancerepository.find("uriID = ? AND account.id = ?", applicationInstance.getUriId(), account.getId());
        ApplicationDeployment deployment = applicationInstance.getApplication().getDeployment();

        //adapter deployment
        // The adapter should be deployed if
        // a) the adapter is not deployed yet (first deployment)
        // b) the selected PaaS where to deploy is different from the actual one (already deployed on a different PaaS)
        //[applicationlist == null || applicationlist.isEmpty()] Case: the application is not deployed yet and the db is already created (infos stored only in the relational db)
        if (applicationlist == null || applicationlist.isEmpty() || (deployment != null && (StringUtils.isBlank(deployment.getAdapterURL()) || !deployment.getDeployingLocation().getTitle().equalsIgnoreCase(paaSInstanceTitle)))) {
            adapterAppUrl = Adapter.uploadAndDeployToEnv(PaaS, war, publicKey, secretKey, accountName, appName, appVersion, environment, bucket, host, type, apiversion, description);
        } else if (applicationlist != null && !applicationlist.isEmpty()) {
            adapterAppUrl = ((eu.cloud4soa.relational.datamodel.ApplicationInstance) applicationlist.get(0)).getAdapterurl();
        }

        return adapterAppUrl;
    }

    
    
    private void storeAppInfoIntoRelationalDB(List<Account> accounts, ApplicationInstance applicationInstance, String deployedAppUrl, String adapterAppUrl) {
        ////////DBtrans
        
        String appURI = "";
        List<eu.cloud4soa.relational.datamodel.ApplicationInstance> applicationlist = appinstancerepository.find("uriID = ? AND account.id = ?", applicationInstance.getUriId(), accounts.get(0).getId());
        if (applicationlist != null && !applicationlist.isEmpty()) {
            eu.cloud4soa.relational.datamodel.ApplicationInstance appinInstance =((eu.cloud4soa.relational.datamodel.ApplicationInstance) applicationlist.get(0));
            if(applicationInstance.getTitle()!=null){            
            appinInstance.setName(applicationInstance.getTitle());
            }
            if(deployedAppUrl!=null){            
            appinInstance.setAppurl(deployedAppUrl);
            }
            if(applicationInstance.getVersion()!=null){
            appinInstance.setVersion(applicationInstance.getVersion());
            }
            if(adapterAppUrl!=null){
            appinInstance.setAdapterurl(adapterAppUrl);
            }
            appinstancerepository.store(appinInstance);
            
        }  else{ 
	///Store AdapterLocation URL in database
        eu.cloud4soa.relational.datamodel.ApplicationInstance appinInstance = new eu.cloud4soa.relational.datamodel.ApplicationInstance();
        appinInstance.setAccount(accounts.get(0));
        appinInstance.setName(applicationInstance.getTitle());
        appinInstance.setAppurl(deployedAppUrl);
        appinInstance.setVersion(applicationInstance.getVersion());
        appinInstance.setAdapterurl(adapterAppUrl);
        appinInstance.setUriID(applicationInstance.getUriId());
        appinstancerepository.store(appinInstance);
        }
	////////DBtrans
    }
    
    
    
    protected String createSLAAgreement(String SLATempateId, List<eu.cloud4soa.api.datamodel.governance.SlaPolicy> penalties) {
        List<GuaranteeTerm> guaranteeTerms = new ArrayList<GuaranteeTerm>();
        List<ServiceDescriptionTerm> serviceDescriptionTerms = new ArrayList<ServiceDescriptionTerm>();
        
    	
    	SLATemplate sla_template = sla_template_repository.findById(Long.valueOf(SLATempateId));

    	logger.info("Copying guarantee terms");
    	for (GuaranteeTerm gt : sla_template.getGuaranteeTerms()) {
    		GuaranteeTerm newGuaranteeTerm = new GuaranteeTerm();
    		
    		newGuaranteeTerm.setCustomServiceLevel(gt.getCustomServiceLevel());
    		newGuaranteeTerm.setGuaranteeTermName(gt.getGuaranteeTermName());
    		newGuaranteeTerm.setKpiName(gt.getKpiName());
    		newGuaranteeTerm.setPenaltyAssessmentInterval(gt.getPenaltyAssessmentInterval());
    		newGuaranteeTerm.setPenaltyValueExpression(gt.getPenaltyValueExpression());
    		newGuaranteeTerm.setPenaltyValueUnit(gt.getPenaltyValueUnit());
    		newGuaranteeTerm.setRewardAssessmentInterval(gt.getRewardAssessmentInterval());
    		newGuaranteeTerm.setRewardValueExpression(gt.getRewardValueExpression());
    		newGuaranteeTerm.setRewardValueUnit(gt.getRewardValueUnit());
    		newGuaranteeTerm.setServiceScopeServiceName(gt.getServiceScopeServiceName());
    		
    		guaranteeTerms.add(newGuaranteeTerm);
    	}
    	
    	logger.info("Copying service description terms");
    	for (ServiceDescriptionTerm sdt : sla_template.getServiceDescriptionTerms()) {
    		ServiceDescriptionTerm newSDT = new ServiceDescriptionTerm();
    		
    		newSDT.setApplicationDescription(sdt.getApplicationDescription());
    		newSDT.setApplicationName(sdt.getApplicationName());
    		newSDT.setApplicationVersion(sdt.getApplicationVersion());
    		newSDT.setServiceDescriptionServiceName(sdt.getServiceDescriptionServiceName());
    		newSDT.setServiceDescriptionTermName(sdt.getServiceDescriptionTermName());
    		
    		serviceDescriptionTerms.add(newSDT);
    	}
    	
    	
    	
        SLAContract sla_contract = new SLAContract();
        sla_contract.setAgreementInitiator(sla_template.getAgreementInitiator());
        sla_contract.setAgreementResponder(sla_template.getAgreementResponder());
        sla_contract.setExpirationTime(sla_template.getExpirationTime());
        sla_contract.setServiceProvider(sla_template.getServiceProvider());
        sla_contract.setTemplateName(sla_template.getTemplateName());
        sla_contract.setGuaranteeTerms(guaranteeTerms);
        sla_contract.setServiceDescriptionTerms(serviceDescriptionTerms);
        sla_contract.setSlaPolicies(toDatamodelPenalties(penalties)); 
        
        sla_contract_repository.store(sla_contract);
        
        return String.valueOf(sla_contract.getId());
    }

    
    
    private void removeDeploymentInfoAnsStopMonitoring(ApplicationInstance applicationInstance, Account account) {

        //start monitoring
        logger.debug("call MonitoringModule.startMonitoring(governanceApplicationArchive)");
        monitoringModule.stopMonitoring(applicationInstance.getUriId());

        List<eu.cloud4soa.relational.datamodel.ApplicationInstance> applicationlist = appinstancerepository.find("uriID = ? AND account.id = ?", applicationInstance.getUriId(), account.getId());
        if (applicationlist != null && !applicationlist.isEmpty()) {
            appinstancerepository.delete(applicationlist.get(0));
        }
    }

    private void saveDeploymentInfoAndStartMonitoring(String deployedAppUrl, PaaSInstance paaSInstance, String adapterAppUrl, ApplicationInstance applicationInstance, String SLAContractID) {
        //FIX[Yosu] Set applicationInstance.deploymentIP with deployedAppUrl before invoking start monitoring
        eu.cloud4soa.api.datamodel.semantic.app.ApplicationDeployment newAppDeployment = new eu.cloud4soa.api.datamodel.semantic.app.ApplicationDeployment();
        newAppDeployment.setIP(deployedAppUrl);
        newAppDeployment.setDeployingLocation(paaSInstance.getPaaSOffering());
        newAppDeployment.setAdapterURL(adapterAppUrl);
        newAppDeployment.setSLAcontractID(SLAContractID);

        applicationInstance.getApplication().setDeployment(newAppDeployment);

        //start monitoring
        logger.debug("call MonitoringModule.startMonitoring(governanceApplicationArchive)");
        monitoringModule.startMonitoringJob(applicationInstance);
    }

    
    
    @Override
    public GitRepoInfo deployThroughGit(String gitCommand, ApplicationInstance applicationInstance, PaaSInstance paaSInstance, String publicKey, String secretKey, String accountName) throws Cloud4SoaException {
        List<Account> accounts;
        String deployedAppUrl = "";
        String adapterAppUrl = "";
        GitRepoInfo gitRepoInfo;
        
        gitRepoInfo = new GitRepoInfo();
        accounts = accountrepository.find("publickey = ? AND privatekey = ?", publicKey, secretKey);
        logger.info("accounts-size: " + accounts.size());
        
        gitRepoInfo = deployApplicationOnPaaSUsingGit(gitCommand, applicationInstance, paaSInstance, accountName, publicKey, secretKey, accounts);
        adapterAppUrl=gitRepoInfo.getAdapterUrl();
        deployedAppUrl=gitRepoInfo.getApplicationUrl();
        storeAppInfoIntoRelationalDB(accounts, applicationInstance, deployedAppUrl, adapterAppUrl);
        
        saveDeploymentInfoAndStartMonitoring(deployedAppUrl, paaSInstance, adapterAppUrl, applicationInstance, null);
  
        return gitRepoInfo;
    }
    
    
    
    /*
     * Introduce the creation of the SLA contract
     * 
     */
    @Override
    public GitRepoInfo deployThroughGit(
            String              gitCommand, 
            ApplicationInstance applicationInstance, 
            PaaSInstance        paaSInstance, 
            String              publicKey, 
            String              secretKey, 
            String              accountName, 
            String              slaTemplateId    ) throws Cloud4SoaException {
        
        List<Account> accounts;
        String deployedAppUrl = "";
        String adapterAppUrl = "";
        GitRepoInfo gitRepoInfo;
        String SLAContractID;
        
        gitRepoInfo = new GitRepoInfo();
        accounts = accountrepository.find("publickey = ? AND privatekey = ?", publicKey, secretKey);
        logger.info("accounts-size: " + accounts.size());
        
        gitRepoInfo = deployApplicationOnPaaSUsingGit(gitCommand, applicationInstance, paaSInstance, accountName, publicKey, secretKey, accounts);
        adapterAppUrl=gitRepoInfo.getAdapterUrl();
        deployedAppUrl=gitRepoInfo.getApplicationUrl();        
        storeAppInfoIntoRelationalDB(accounts, applicationInstance, deployedAppUrl, adapterAppUrl);
        
        /*
         * SLAContractID = createSLAAgreement(slaTemplateId); //TODO put penalties
         *
         * saveDeploymentInfoAndStartMonitoring(deployedAppUrl, paaSInstance, adapterAppUrl, applicationInstance, SLAContractID);
         * 
         */

        return gitRepoInfo;
    }
     
    
    
    
    protected DeploymentUrls deployApplicationArchiveOnPaaS(
            File applicationArchive, 
            ApplicationInstance applicationInstance, 
            PaaSInstance paaSInstance, 
            String accountName,
            String publicKey, 
            String secretKey,
            List<Account> accounts)  throws Cloud4SoaException {
        
        
        //----------------DataBase interaction ---------------------------------------------------
/*        long paasid = 0;
        List<Paas> paaslist = paasrepository.findBy("name", paaSInstance.getProviderTitle());
        if (paaslist != null && !paaslist.isEmpty()) {
            paasid = ((Paas) paaslist.get(0)).getId();
        } else {
            //DB entry - it shouldnt be here
        }
         * 
         */
         

        //User
 /*       long userid = 0;
        List<User> userlist = userrepository.findBy("uriID", applicationInstance.getOwnerUriId());
        if (userlist != null && !userlist.isEmpty()) {
            userid = ((User) userlist.get(0)).getId();
        } else {
            //DB entry - it shouldnt be here
        }
         * 
         */
        
        
        AdapterClient adapterClient = new AdapterClientCXF();
        CustomerCredentials credentials = new CustomerCredentials(publicKey, secretKey);
        
        
        ///For CloudBees, upload adapter with the simple, old C4S server side adapter
        ///Due to the fact that we cannot use right now deployment through the c4sad, deployment(both initial and update) can only be done
        /// with the old adapter
        String paas_name = paaSInstance.getProviderTitle();

        DeploymentUrls urls = new DeploymentUrls();
        
        if (paas_name.equalsIgnoreCase("CloudBees")) {

            String cloudbeesAccount = "";
            cloudbeesAccount = accounts.get(0).getAccountname();

            //adapter deployment
            urls.adapterAppUrl = uploadAdapterIfNeeded(applicationInstance, paaSInstance.getTitle(), accounts.get(0), "CloudBees", ExecutionManagementUtil.getCloudBeesAdapterPath(), publicKey, secretKey, cloudbeesAccount, "c4sad" + applicationInstance.getTitle(), "", "", "", "", "", "", "c4sad");

            //application deployment
            urls.deployedAppUrl = Adapter.uploadAndDeployToEnv("CloudBees", applicationArchive.getAbsolutePath(), publicKey, secretKey, cloudbeesAccount, applicationInstance.getTitle(), "", "", "", "", "", "", "");

//            storeAppInfoIntoRelationalDB(accounts, applicationInstance, deployedAppUrl, adapterAppUrl);

//            saveDeploymentInfoAndStartMonitoring(deployedAppUrl, paaSInstance, adapterAppUrl, applicationInstance);


        } else if (paas_name.equalsIgnoreCase("Amazon PaaS Provider")) {
            //adapter deployment
            urls.adapterAppUrl = uploadAdapterIfNeeded(applicationInstance, paaSInstance.getTitle(), accounts.get(0), "Beanstalk", ExecutionManagementUtil.getBeanstalkAdapterPath(), publicKey, secretKey, "", "c4sad" + applicationInstance.getTitle(), "adapterversion1", "cloud4soa", "", "", "", "", "");

            //application deployment
            urls.deployedAppUrl = Adapter.uploadAndDeployToEnv("Beanstalk", applicationArchive.getAbsolutePath(), publicKey, secretKey, "", applicationInstance.getTitle(), applicationInstance.getVersion(), applicationInstance.getTitle(), "", "", "", "", "");

            waitForBeanstalkApplicationReady("Beanstalk", publicKey, secretKey, "", applicationInstance.getTitle(), "cloud4soa", "", "");

//            storeAppInfoIntoRelationalDB(accounts, applicationInstance, deployedAppUrl, adapterAppUrl);

//            saveDeploymentInfoAndStartMonitoring(deployedAppUrl, paaSInstance, adapterAppUrl, applicationInstance);


        } else if (paas_name.equalsIgnoreCase("Red Hat")) {
            String gitURI = Adapter.createApplication("OpenShift", publicKey, secretKey, "", applicationInstance.getTitle(), "");
            //adapter deployment if needed
            urls.deployedAppUrl = Adapter.getAppURL("OpenShift", publicKey, secretKey, "", applicationInstance.getTitle(), "", "", "");
            urls.adapterAppUrl = "";
            urls.deployedAppUrl = gitURI;
            //RAW-input  ssh://a2f3b6f89a8840e5bb9a46d714bead0a@c4swgit-cloud4soaexpress.rhcloud.com/~/git/c4swgit.git/
            //should be tranformed to
            //OPENSHIFT_FORMAT = "13b46159875741a18b84a6d3ec932b31@c4sgit-cloud4soaexpress.rhcloud.com/~/git/c4sgit.git/"
            //OPENSHIFT_URL = "13b46159875741a18b84a6d3ec932b31@c4sgit-cloud4soaexpress.rhcloud.com"
            //OPENSHIFT_REPO = "~/git/c4sgit.git/"            

            //application deployment

//            //step 2: register repository
//            String[] temp = ExecutionManagementUtil.convertFromOpenshift(gitURI);
//            String giturl = temp[0];
//            String reponame = temp[1];
//            gitservices.registerGitRepository(""+ userid, giturl, reponame , ""+paasid);
//            //step 3: register proxy
//            //TODO change
//            String proxyname = "proxy"+userid+applicationInstance.getTitle().replaceAll(" ", "").trim().toLowerCase();
//            gitservices.registerGitProxy("" + userid, proxyname);
//            //step 4: binding                        
//            String gitid = "";
//            String proxyid = "";
//            List<GitRepo> repos = gitrepo.findByGitrepo(reponame);
//            gitid = ""+ ((GitRepo)repos.get(0)).getId();
//            List<GitProxy> proxies = gitproxy.findByProxyname(proxyname);
//            proxyid = "" + ((GitProxy) proxies.get(0)).getId();
//            
//            gitservices.bindProxyToGit("" + userid, proxyid, gitid);
 
//            storeAppInfoIntoRelationalDB(accounts, applicationInstance, deployedAppUrl, adapterAppUrl);
        } else if (paas_name.equalsIgnoreCase("VMware")) {

            //adapter deployment
            urls.adapterAppUrl = uploadAdapterIfNeeded(applicationInstance, paaSInstance.getTitle(), accounts.get(0), "CloudFoundry", ExecutionManagementUtil.getCloudFoundryAdapterPath(), publicKey, secretKey, "", "c4sad" + applicationInstance.getTitle(), "", "", "", "", "", "", "c4sad");

            //application deployment
            urls.deployedAppUrl = Adapter.uploadAndDeployToEnv("CloudFoundry", applicationArchive.getAbsolutePath(), publicKey, secretKey, "", applicationInstance.getTitle(), "", "", "", "", "", "", "");

//            storeAppInfoIntoRelationalDB(accounts, applicationInstance, deployedAppUrl, adapterAppUrl);

//            saveDeploymentInfoAndStartMonitoring(deployedAppUrl, paaSInstance, adapterAppUrl, applicationInstance);

        } else {
            String adapterLocation = "";
            //  adapterLocation = "http://adaptertest.elasticbeanstalk.com";
            List<eu.cloud4soa.relational.datamodel.ApplicationInstance> applicationlist = appinstancerepository.find("uriID = ? AND account.id = ?", applicationInstance.getUriId(), accounts.get(0).getId());
            if (applicationlist != null && !applicationlist.isEmpty()) {
                adapterLocation = ((eu.cloud4soa.relational.datamodel.ApplicationInstance) applicationlist.get(0)).getAdapterurl();
            }

            /**
             * TODO extract
             */
            CreateDeploymentRequest createDeploymentRequest = new CreateDeploymentRequest();
            createDeploymentRequest.setBaseUrl(adapterLocation);

            createDeploymentRequest.setApplicationName(applicationInstance.getTitle());


            try {
                CreateDeploymentResponse createDeploymentResponse = adapterClient.send(createDeploymentRequest, credentials);

                Deployment deployment = createDeploymentResponse.getDeployment();

                if (deployment != null) {
                    logger.info("Deploy successful. URL of the application: " + deployment.getSubDomain());
//    			ExecutionManagementUtil.infixDeploymentLocation(applicationInstance, deployment.getSubDomain());
                } else {
                    logger.warn("Deploy failed. " + createDeploymentResponse.getStatusCode().toString());
                    throw new Cloud4SoaException("Deploy failed. " + createDeploymentResponse.getStatusCode().toString());

                }
//                saveDeploymentInfoAndStartMonitoring(deployedAppUrl, paaSInstance, adapterAppUrl, applicationInstance);

            } catch (AdapterClientException e) {
            throw new Cloud4SoaException(new PaaSException(e.getMessage()));
            }
              catch (UnknownHostException e) {
            throw new Cloud4SoaException(new PaaSConnectionException(e.getMessage()));
        }            
            
        }
        return urls;
    }
    
    
    
    protected GitRepoInfo deployApplicationOnPaaSUsingGit(    
                                String gitCommand, 
                                ApplicationInstance applicationInstance, 
                                PaaSInstance paaSInstance, 
                                String accountName,
                                String publicKey, 
                                String secretKey,
                                List<Account> accounts)  throws Cloud4SoaException {

        GitRepoInfo gitRepoInfo;
        String deployedAppUrl;
        String adapterAppUrl;
        
        gitRepoInfo = new GitRepoInfo();
        deployedAppUrl = null;
        adapterAppUrl = null;
        
        //User
        long userid = 0;
        List<User> userlist = userrepository.findBy("uriID", applicationInstance.getOwnerUriId());
        if (userlist != null && !userlist.isEmpty()) {
            userid = ((User) userlist.get(0)).getId();
        } else {
            //DB entry - it shouldnt be here
        }
        
        CustomerCredentials credentials = new CustomerCredentials(publicKey, secretKey);
        CustomerCredentials credentialsOpenShift = new CustomerCredentials(publicKey+"_"+secretKey, secretKey);
        
        String encyptedCredentials=ExecutionManagementUtil.createCloudControlApiKey(publicKey, secretKey);
        CustomerCredentials credentialsCloudControl = new CustomerCredentials(encyptedCredentials, encyptedCredentials);
        
        logger.info("accounts-size: " + accounts.size());
        String paas_name = paaSInstance.getProviderTitle();

        String giturl = null;
        String reponame = null;

        //step 1: create repository and return the git uri
        if (paas_name.equalsIgnoreCase("Red Hat")) {
           // String gitURI = Adapter.createApplication("OpenShift", publicKey, secretKey, "", applicationInstance.getTitle(), "");
            //adapter deployment if needed
            //adapterAppUrl = Adapter.getAppURL("OpenShift", publicKey, secretKey, "", applicationInstance.getTitle(), "", "", "");
            //deployedAppUrl = adapterAppUrl;
            AdapterClient adapterClient = new AdapterClientCXF();

            String openShiftAdapterLocation = "http://rhoshiftadapter.testurl.cloudbees.net/";
            //replace this with the per application specific adapter
            adapterAppUrl = openShiftAdapterLocation;
            
            
            
            //String[] temp = ExecutionManagementUtil.convertFromOpenshift(gitURI);
            //giturl = temp[0];
            //reponame = temp[1];
            CreateApplicationRequest createAppRequest = new CreateApplicationRequest();
            createAppRequest.setBaseUrl(adapterAppUrl);

            String applicationTitle = applicationInstance.getTitle();
            String applicationTitleLowerCase = applicationTitle.toLowerCase();

            if (!Character.isLetter(applicationTitleLowerCase.charAt(0))) {
                throw new Cloud4SoaException("Application title must start with a letter in order to be deployed on OpenShift");
            }
            createAppRequest.setApplicationName(applicationTitleLowerCase);
            if (applicationInstance.getProgramminglanguage() != null) {
                createAppRequest.setLanguage(applicationInstance.getProgramminglanguage());
            }


            try {
                CreateApplicationResponse createAppResponse = adapterClient.send(createAppRequest, credentialsOpenShift);

                int status = createAppResponse.getStatusCode().ordinal();
                logger.info("createApplication:" + " - " + createAppResponse.getStatusCode().toString() + " " + (status > 199 && status < 300 ? "successfull" : "failed") + " for app: " + applicationInstance.getTitle());
                deployedAppUrl = createAppResponse.getApplication().getUrl();
                String[] temp = ExecutionManagementUtil.convertFromOpenshift(createAppResponse.getApplication().getRepository());
                giturl = temp[0];
                reponame = temp[1];
                logger.info("giturl:"+giturl);
                logger.info("reponame:"+reponame);
            } catch (AdapterClientException e) {
                //throw new RuntimeException(e);
            throw new Cloud4SoaException(new PaaSException(e.getMessage()));
            }
              catch (UnknownHostException e) {
               throw new Cloud4SoaException(new PaaSConnectionException(e.getMessage()));
           }
            //Read C4SOA-Proxy key If Exists Pr register            
            String privatekeypath = System.getProperty("user.home") + "/.ssh/" + userid ;
            String pubkeypath = System.getProperty("user.home") + "/.ssh/" + userid + ".pub";
            logger.info("PUBLIC KEY PATH:" + pubkeypath);
            String sshkey = "";
            sshkey = ExecutionManagementUtil.getPublicKey(userid);
            //if it does not exist
            if (sshkey == null || sshkey.trim().equals("")) {
                //generate it            
                ExecutionManagementUtil.GenerateSSHKeyPair(userid + "");
                //read it
                sshkey = ExecutionManagementUtil.getPublicKey(userid);
            }

            logger.info("The final key is " + sshkey);


            openshift.Openshift_Aux sshkeyrequest= new Openshift_Aux(publicKey,secretKey);
            
            sshkeyrequest.registerSSHKey(privatekeypath,pubkeypath, "c4sServerKey");
            /*
            //Always register the key                       
            //CreateSSHKeyRequest createsshrequest = new CreateSSHKeyRequest();
            //createsshrequest.setBaseUrl(adapterAppUrl);
            //createsshrequest.setApiKey(publicKey);
            //createsshrequest.setSshKey(sshkey);
            //createsshrequest.setApplicationName(applicationTitle);* 
            try {
                CreateSSHKeyResponse response = adapterClient.send(createsshrequest, credentials);
                int status = response.getStatusCode().ordinal();
                System.out.println("response:" + " - " + response.getStatusCode().toString() + " " + (status > 199 && status < 300 ? "successfull" : "failed"));
            } catch (AdapterClientException e) {
                e.printStackTrace();
            }*/

        }//OpenShift

        if (paas_name.equalsIgnoreCase("Heroku")) {
            AdapterClient adapterClient = new AdapterClientCXF();

            String herokuAdapterLocation = "http://c4s.herokuapp.com/";
            //replace this with the per application specific adapter
            adapterAppUrl = herokuAdapterLocation;

            CreateApplicationRequest createAppRequest = new CreateApplicationRequest();
            createAppRequest.setBaseUrl(herokuAdapterLocation);

            String applicationTitle = applicationInstance.getTitle();
            String applicationTitleLowerCase = applicationTitle.toLowerCase();

            if (!Character.isLetter(applicationTitleLowerCase.charAt(0))) {
                throw new Cloud4SoaException("Application title must start with a letter in order to be deployed on heroku");
            }
            createAppRequest.setApplicationName(applicationTitleLowerCase);
            if (applicationInstance.getProgramminglanguage() != null) {
                createAppRequest.setLanguage(applicationInstance.getProgramminglanguage());
            }


            try {
                CreateApplicationResponse createAppResponse = adapterClient.send(createAppRequest, credentials);

                int status = createAppResponse.getStatusCode().ordinal();
                logger.info("createApplication:" + " - " + createAppResponse.getStatusCode().toString() + " " + (status > 199 && status < 300 ? "successfull" : "failed") + " for app: " + applicationInstance.getTitle());
                deployedAppUrl = createAppResponse.getApplication().getUrl();
                String[] temp = ExecutionManagementUtil.convertFromHeroku(createAppResponse.getApplication().getRepository());
                giturl = temp[0];
                reponame = temp[1];

            } catch (AdapterClientException e) {
                //throw new RuntimeException(e);
            throw new Cloud4SoaException(new PaaSException(e.getMessage()));
            } catch (UnknownHostException e) {
            throw new Cloud4SoaException(new PaaSConnectionException(e.getMessage()));
        }

            //Read C4SOA-Proxy key If Exists Pr register            
            String pubkeypath = System.getProperty("user.home") + "/.ssh/" + userid + ".pub";
            logger.info("PUBLIC KEY PATH:" + pubkeypath);
            String sshkey = "";
            sshkey = ExecutionManagementUtil.getPublicKey(userid);
            //if it does not exist
            if (sshkey == null || sshkey.trim().equals("")) {
                //generate it            
                ExecutionManagementUtil.GenerateSSHKeyPair(userid + "");
                //read it
                sshkey = ExecutionManagementUtil.getPublicKey(userid);
            }

            logger.info("The final key is " + sshkey);

            //Always register the key                       
            CreateSSHKeyRequest createsshrequest = new CreateSSHKeyRequest();
            createsshrequest.setBaseUrl(herokuAdapterLocation);
            createsshrequest.setApiKey(publicKey);
            createsshrequest.setSshKey(sshkey);
            createsshrequest.setApplicationName(applicationTitle);

            try {
                CreateSSHKeyResponse response = adapterClient.send(createsshrequest, credentials);
                int status = response.getStatusCode().ordinal();
                System.out.println("response:" + " - " + response.getStatusCode().toString() + " " + (status > 199 && status < 300 ? "successfull" : "failed"));
            } catch (AdapterClientException e) {
                //e.printStackTrace();
            throw new Cloud4SoaException(new PaaSException(e.getMessage()));
                
            } catch (UnknownHostException e) {
            throw new Cloud4SoaException(new PaaSConnectionException(e.getMessage()));
        }            

        }//Heroku
        
        if (paas_name.equalsIgnoreCase("CloudControl PaaS Provider")) {
            AdapterClient adapterClient = new AdapterClientCXF();

            String cloudControlAdapterLocation = "http://c4s.cloudcontrolled.com/";
            //replace this with the per application specific adapter
            adapterAppUrl = cloudControlAdapterLocation;

            CreateApplicationRequest createAppRequest = new CreateApplicationRequest();
            createAppRequest.setBaseUrl(cloudControlAdapterLocation);

            String applicationTitle = applicationInstance.getTitle();
            String applicationTitleLowerCase = applicationTitle.toLowerCase();

            if (!Character.isLetter(applicationTitleLowerCase.charAt(0))) {
                throw new Cloud4SoaException("Application title must start with a letter in order to be deployed");
            }
            createAppRequest.setApplicationName(applicationTitleLowerCase);
            if (applicationInstance.getProgramminglanguage() != null) {
                createAppRequest.setLanguage(applicationInstance.getProgramminglanguage());
            }


            try {
                CreateApplicationResponse createAppResponse = adapterClient.send(createAppRequest, credentialsCloudControl);

                int status = createAppResponse.getStatusCode().ordinal();
                logger.info("createApplication:" + " - " + createAppResponse.getStatusCode().toString() + " " + (status > 199 && status < 300 ? "successfull" : "failed") + " for app: " + applicationInstance.getTitle());
                deployedAppUrl = createAppResponse.getApplication().getUrl();
                String[] temp = ExecutionManagementUtil.convertFromCloudControl(createAppResponse.getApplication().getRepository());
                giturl = temp[0];
                reponame = temp[1];

            } catch (AdapterClientException e) {
                //throw new RuntimeException(e);
            throw new Cloud4SoaException(new PaaSException(e.getMessage()));
            } catch (UnknownHostException e) {
            throw new Cloud4SoaException(new PaaSConnectionException(e.getMessage()));
        }
            

            //Read C4SOA-Proxy key If Exists Pr register            
            String pubkeypath = System.getProperty("user.home") + "/.ssh/" + userid + ".pub";
            logger.info("PUBLIC KEY PATH:" + pubkeypath);
            String sshkey = "";
            sshkey = ExecutionManagementUtil.getPublicKey(userid);
            //if it does not exist
            if (sshkey == null || sshkey.trim().equals("")) {
                //generate it            
                ExecutionManagementUtil.GenerateSSHKeyPair(userid + "");
                //read it
                sshkey = ExecutionManagementUtil.getPublicKey(userid);
            }

            logger.info("The final key is " + sshkey);

            //Always register the key                       
            CreateSSHKeyRequest createsshrequest = new CreateSSHKeyRequest();
            createsshrequest.setBaseUrl(cloudControlAdapterLocation);
            createsshrequest.setApiKey(publicKey);
            createsshrequest.setSshKey(sshkey);
            createsshrequest.setApplicationName(applicationTitle);

            try {
                CreateSSHKeyResponse response = adapterClient.send(createsshrequest, credentialsCloudControl);
                int status = response.getStatusCode().ordinal();
                System.out.println("response:" + " - " + response.getStatusCode().toString() + " " + (status > 199 && status < 300 ? "successfull" : "failed"));
            } catch (AdapterClientException e) {
              //  e.printStackTrace();
            throw new Cloud4SoaException(new PaaSException(e.getMessage()));            
            } catch (UnknownHostException e) {
            throw new Cloud4SoaException(new PaaSConnectionException(e.getMessage()));
        }

        }//CloudControl PaaS Provider


        long appId = 0;
        List<eu.cloud4soa.relational.datamodel.ApplicationInstance> applicationlist = appinstancerepository.find("uriID = ? AND account.id = ?", applicationInstance.getUriId(), accounts.get(0).getId());
        if (applicationlist != null && !applicationlist.isEmpty()) {
            appId = ((eu.cloud4soa.relational.datamodel.ApplicationInstance) applicationlist.get(0)).getId();
        } else {
            //DB entry - it shouldnt be here
        }

        gitRepoInfo.setUrl(giturl);
        gitRepoInfo.setRepositoryName(reponame);
        gitRepoInfo.setApplicationId("" + appId);
        gitRepoInfo.setUserId("" + userid);
        gitRepoInfo.setApplicationUrl(deployedAppUrl);
        gitRepoInfo.setAdapterUrl(adapterAppUrl);
        
        return gitRepoInfo;
    }
    
    private List<SLAPolicy> toDatamodelPenalties (List<eu.cloud4soa.api.datamodel.governance.SlaPolicy> penalties) {
    	List <SLAPolicy> ret = new ArrayList<SLAPolicy>();
    	SLAPolicy pen;
    	
    	for (eu.cloud4soa.api.datamodel.governance.SlaPolicy penalty : penalties) {
    		pen = new SLAPolicy();
    		pen.setBreach(penalty.getBreach());
    		pen.setMetric_name(penalty.getMetric_name());
    		pen.setTime_interval(penalty.getTime_interval());
    		pen.setValue_expr(penalty.getValue_expr());
    		ret.add(pen);
    	}
    	
    	return ret;
    }
}
