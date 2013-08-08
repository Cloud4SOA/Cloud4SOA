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

package eu.cloud4soa.soa;

import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.DBStorageComponentInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.SoftwareComponentInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.StatusType;
import eu.cloud4soa.api.datamodel.governance.DeployApplicationParameters;
import eu.cloud4soa.api.datamodel.governance.SlaTemplate;
import eu.cloud4soa.api.datamodel.semantic.app.ApplicationDeployed;
import eu.cloud4soa.api.datamodel.semantic.app.ApplicationMigrated;
import eu.cloud4soa.api.datamodel.semantic.app.ApplicationMigrating;
import eu.cloud4soa.api.datamodel.semantic.app.DBMigrated;
import eu.cloud4soa.api.datamodel.semantic.app.DBMigrating;
import eu.cloud4soa.api.datamodel.semantic.app.ErrorInApplicationMigration;
import eu.cloud4soa.api.datamodel.semantic.app.ErrorInApplicationStopping;
import eu.cloud4soa.api.datamodel.semantic.app.ErrorInDBMigration;
import eu.cloud4soa.api.datamodel.semantic.inf.DBDeployment;
import eu.cloud4soa.api.datamodel.semantic.inf.DBStorageComponent;
import eu.cloud4soa.api.datamodel.semantic.paas.PaaSOffering;
import eu.cloud4soa.api.governance.ExecutionManagementServiceModule;
import eu.cloud4soa.api.repository.ApplicationProfilesRepository;
import eu.cloud4soa.api.repository.PaaSOfferingProfilesRepository;
import eu.cloud4soa.api.util.exception.adapter.Cloud4SoaException;
import eu.cloud4soa.api.util.exception.repository.RepositoryException;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import eu.cloud4soa.governance.sla.client.SLAModule;
import eu.cloud4soa.relational.datamodel.Account;
import eu.cloud4soa.relational.datamodel.Paas;
import eu.cloud4soa.relational.datamodel.User;
import eu.cloud4soa.relational.persistence.AccountRepository;
import eu.cloud4soa.relational.persistence.PaasRepository;
import eu.cloud4soa.relational.persistence.UserRepository;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author vincenzo
 */
@Transactional
public class ApplicationMigration implements eu.cloud4soa.api.soa.ApplicationMigration{
    
    final Logger logger = LoggerFactory.getLogger(ApplicationMigration.class);
    
    private ApplicationProfilesRepository applicationProfilesRepository;
    private PaaSOfferingProfilesRepository paaSOfferingProfilesRepository;
    private ExecutionManagementServiceModule executionManagementServiceModule;
    private SLAModule slaModule;
    
    //Relational DB
    @Autowired
    private UserRepository userrepository;  
    @Autowired
    private PaasRepository paasrepository;
    @Autowired
    private AccountRepository accountrepository;
    
    /**
     * @param applicationProfilesRepository the applicationProfilesRepository to set
     */
    public void setApplicationProfilesRepository(ApplicationProfilesRepository applicationProfilesRepository) {
        this.applicationProfilesRepository = applicationProfilesRepository;
    }

    /**
     * @param paaSOfferingProfilesRepository the paaSOfferingProfilesRepository to set
     */
    public void setPaaSOfferingProfilesRepository(PaaSOfferingProfilesRepository paaSOfferingProfilesRepository) {
        this.paaSOfferingProfilesRepository = paaSOfferingProfilesRepository;
    }
    
    
    /**
     * @param executionManagementServiceModule the executionManagementServiceModule to set
     */
    public void setExecutionManagementServiceModule(ExecutionManagementServiceModule executionManagementServiceModule) {
        this.executionManagementServiceModule = executionManagementServiceModule;
    }

    
    
    public void setSlaModule(SLAModule slaModule) {
        this.slaModule = slaModule;
    }
    
    
     
    @Override
    public Response migrateApplication(String applicationInstanceUriId, String newPaaSInstanceUriId, InputStream is) throws SOAException {
        
        DeployApplicationParameters deployParameters;
        String SLATemplateId;
        
        logger.debug("received applicationInstanceUriId: " + applicationInstanceUriId + " , paaSInstanceUriId: " + newPaaSInstanceUriId);
        ApplicationInstance applicationInstance = getApplicationInstance(applicationInstanceUriId);
        logger.debug("retrieved applicationInstance: " + applicationInstance);
        PaaSInstance newPaaSInstance = getPaaSInstance(newPaaSInstanceUriId);
        logger.debug("retrived newPaaSInstance: " + newPaaSInstance);
        String oldPaaSInstanceUriId = applicationInstance.getPaaSOfferingDeploymentUriId();
        logger.debug("oldPaaSInstanceUriId: " + oldPaaSInstanceUriId);
        PaaSInstance oldPaaSInstance = getPaaSInstance(oldPaaSInstanceUriId);
        logger.debug("retrived oldPaaSInstance: " + oldPaaSInstance);
                   
        //Obtain credentials for the new PaaS
        Account oldPaaSCredentials = getAccount(applicationInstance.getOwnerUriId(), oldPaaSInstance.getProviderTitle());
        //Obtain credentials for the new PaaS
        Account newPaaSCredentials = getAccount(applicationInstance.getOwnerUriId(), newPaaSInstance.getProviderTitle());

        /**
         * ...
         * 1) Check the Application Status -> the mDBs migration, if any, should be made before the Application migration 
         * 2) Stop the Application if it's running and has no DBs
         * ...
         */
        // 1) Check if migrateDBs migration is performed, if any
        List<DBStorageComponentInstance> dbStorageComponentList = new ArrayList<DBStorageComponentInstance>();
        List<SoftwareComponentInstance> softwareComponents = applicationInstance.getSoftwareComponents();
        for (SoftwareComponentInstance softwareComponentInstance : softwareComponents) {
            if (softwareComponentInstance instanceof DBStorageComponentInstance) {
                DBStorageComponentInstance dbStorageComponentInstance = (DBStorageComponentInstance) softwareComponentInstance;
                dbStorageComponentList.add(dbStorageComponentInstance);
            }
        }

        boolean condition = (!dbStorageComponentList.isEmpty() && applicationInstance.getStatus().compareTo(StatusType.DBMigrated)!=0);
        ifConditionThrowsException(condition, Response.Status.BAD_REQUEST, "The MigrationDBs is the first step of the migration if the application has one or more DBs");       
        
        // 2) Stop App On Old PaaS
        if (applicationInstance.getStatus().compareTo(StatusType.Running) == 0 || applicationInstance.getStatus().compareTo(StatusType.Deployed) == 0) {
            try {
                executionManagementServiceModule.startStopApplication(applicationInstance, "stop", oldPaaSCredentials.getPublickey(), oldPaaSCredentials.getPrivatekey(), oldPaaSCredentials.getAccountname());
            } catch (Cloud4SoaException ex) {
                logger.error("[Application " + applicationInstanceUriId + "] Failed to stop the application on the old PaaS: " + oldPaaSInstanceUriId);
                // Change the Application Status
                applicationInstance.setApplicationStatus(new ErrorInApplicationStopping());
                throw new SOAException(Status.INTERNAL_SERVER_ERROR, "[Application " + applicationInstanceUriId + "] Failed to stop the application on the old PaaS: " + oldPaaSInstanceUriId);
            }
        }
        
        // Change the Application Status
        applicationInstance.setApplicationStatus(new ApplicationMigrating());

        //3) Deploy App (the archive file) On New PaaS
        try {
            File applicationArchiveFile = this.getApplicationArchiveFile(applicationInstance, is);

            // a) Retrieving the infos of the old deployment
            eu.cloud4soa.api.datamodel.semantic.app.ApplicationDeployment oldDeployment = applicationInstance.getApplication().getDeployment();
            
            logger.debug("Going to deploy application " + applicationInstanceUriId + " on PaaS " + newPaaSInstanceUriId);
            
//            String deployedAppURL = executionManagementServiceModule.deployApplication(applicationArchiveFile, applicationInstance, newPaaSInstance, newPaaSCredentials.getPublickey(), newPaaSCredentials.getPrivatekey(), newPaaSCredentials.getAccountname());
            
            deployParameters = new DeployApplicationParameters();
            deployParameters.setApplicationArchive(applicationArchiveFile);
            deployParameters.setApplicationInstance( applicationInstance);
            deployParameters.setPaaSInstance( newPaaSInstance );
            deployParameters.setPublicKey( newPaaSCredentials.getPublickey() );
            deployParameters.setSecretKey( newPaaSCredentials.getPrivatekey() );
            deployParameters.setAccountName( newPaaSCredentials.getAccountname() );
            deployParameters.setSlaTemplateID( this.getSlaTemplateId(applicationInstance, oldPaaSInstance) );
           
            String deployedAppURL = executionManagementServiceModule.deployApplication( deployParameters );
            
            logger.debug("Deploy successfull; url of the deployed application: " + deployedAppURL);                       

            // b) Set migrated Application infos as the new deployment
            eu.cloud4soa.api.datamodel.semantic.app.ApplicationDeployment newAppDeployment = applicationInstance.getApplication().getDeployment();
            // c) Move old deployment to the property migratedFrom of the new one
            newAppDeployment.setMigratedFrom(oldDeployment);
            applicationInstance.getApplication().setDeployment(newAppDeployment);
            
            logger.debug("[Application " + applicationInstanceUriId + "] The application has been deployed succesfully on new PaaS: " + newPaaSInstanceUriId);
            // Change the Application Status
            applicationInstance.setApplicationStatus(new ApplicationMigrated());
            
            try {
                applicationProfilesRepository.updateApplicationInstance(applicationInstance);
            } catch (RepositoryException ex) {
                throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, "Error on updating the Profile after the Application migration: "+ex.getMessage());
            }
            
            String responseMessage = "Application " + applicationInstance.getTitle()
                    + " successfully migrated on PaaS " + newPaaSInstance.getProviderTitle()
                    + "; URL: " + deployedAppURL;
            return Response.status(Response.Status.OK).entity(responseMessage).type(MediaType.TEXT_PLAIN).build();

        } catch (Cloud4SoaException ex) {
            /**
             * ...
             * 3a) Failure case: Change the status to ERROR - Code: migrating App failure
             * ...
             */
            logger.debug("[Application " + applicationInstanceUriId + "] Deploy App On New PaaS has failed!");
            // Change the Application Status
            applicationInstance.setApplicationStatus(new ErrorInApplicationMigration());
            
            try {
                applicationProfilesRepository.updateApplicationInstance(applicationInstance);
            } catch (RepositoryException ex1) {
                throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, ex1.getMessage());
            }
            throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, "Error in migrating the application: " + ex.getMessage());
        } catch (SOAException ex) {
            try {
                executionManagementServiceModule.unDeployApplication(applicationInstance, oldPaaSCredentials.getPublickey(), oldPaaSCredentials.getPrivatekey(), oldPaaSCredentials.getAccountname());
            } catch (Cloud4SoaException ex1) {
               throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, "Error in undeploying the application on the new PaaS - Please try to remove it manually: "+ex1.getMessage());
            }
            throw ex; 
        }
    }

    @Override
    public Response migrateDatabases(String applicationInstanceUriId, String newPaaSInstanceUriId) throws SOAException {

        ifConditionThrowsException(applicationInstanceUriId == null || applicationInstanceUriId.isEmpty(), Response.Status.BAD_REQUEST, "applicationInstanceUriId is null or empty");
        ifConditionThrowsException(newPaaSInstanceUriId == null || newPaaSInstanceUriId.isEmpty(), Response.Status.BAD_REQUEST, "newPaaSInstanceUriId is null or empty");

        logger.debug("received applicationInstanceUriId: "+ applicationInstanceUriId +" , paaSInstanceUriId: " + newPaaSInstanceUriId);
        ApplicationInstance applicationInstance = getApplicationInstance(applicationInstanceUriId);
        logger.debug("retrieved applicationInstance: " + applicationInstance );
        PaaSInstance newPaaSInstance = getPaaSInstance(newPaaSInstanceUriId);
        logger.debug("retrieved newPaaSInstance: " + newPaaSInstance);
        String oldPaaSInstanceUriId = applicationInstance.getPaaSOfferingDeploymentUriId();
        logger.debug("oldPaaSInstanceUriId: " + oldPaaSInstanceUriId);
       
        PaaSInstance oldPaaSInstance = null;
        try {
            oldPaaSInstance = paaSOfferingProfilesRepository.getPaaSInstance(oldPaaSInstanceUriId);
            logger.debug("retrived oldPaaSInstance: " + oldPaaSInstance);
        } catch (RepositoryException ex) {
            throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
        
        //Obtain credentials for the new PaaS
        Account oldPaaSCredentials = getAccount(applicationInstance.getOwnerUriId(), oldPaaSInstance.getProviderTitle());
        //Obtain credentials for the new PaaS
        Account newPaaSCredentials = getAccount(applicationInstance.getOwnerUriId(), newPaaSInstance.getProviderTitle());
        
        //1) Stop App On Old PaaS
        if (applicationInstance.getStatus().compareTo(StatusType.Running) == 0 || applicationInstance.getStatus().compareTo(StatusType.Deployed) == 0) {
            try {
                executionManagementServiceModule.startStopApplication(applicationInstance, "stop", oldPaaSCredentials.getPublickey(), oldPaaSCredentials.getPrivatekey(), oldPaaSCredentials.getAccountname());
            } catch (Cloud4SoaException ex) {
                logger.error("[Application " + applicationInstanceUriId + "] Failed to stop the application on the old PaaS: " + oldPaaSInstanceUriId);
                // Change the Application Status
                applicationInstance.setApplicationStatus(new ErrorInApplicationStopping());
                throw new SOAException(Status.INTERNAL_SERVER_ERROR, "[Application " + applicationInstanceUriId + "] Failed to stop the application on the old PaaS: " + oldPaaSInstanceUriId);
            }
        }
        
        /**
         * ...
         * 2) Migrate all DBs
         * ...
         * 2a) Failure case: 
         *  - Destroy all DBs on the new PaaS
         *  - Start the App on the old PaaS
         * ...
         */
        List<DBStorageComponentInstance> dbStorageComponentList = new ArrayList<DBStorageComponentInstance>();
        List<SoftwareComponentInstance> softwareComponents = applicationInstance.getSoftwareComponents();
        for (SoftwareComponentInstance softwareComponentInstance : softwareComponents) {
            if(softwareComponentInstance instanceof DBStorageComponentInstance){
                DBStorageComponentInstance dbStorageComponentInstance = (DBStorageComponentInstance)softwareComponentInstance;
                dbStorageComponentList.add(dbStorageComponentInstance);
            }
        }
        
        Map<String, String> dbsDeployedOnNewPaaS = new HashMap<String, String>();
        if(!dbStorageComponentList.isEmpty()){
            logger.debug("[Application " + applicationInstanceUriId + "] The application has "+dbStorageComponentList.size()+" databases to be migrated");
            // Change the Application Status
            applicationInstance.setApplicationStatus(new DBMigrating());
            
            // 2) Migrate all DBs
            // 2.1) create DB on the new PaaS/
            for (DBStorageComponentInstance dbStorageComponentInstance : dbStorageComponentList) {
                String dbName = dbStorageComponentInstance.getDbname();
                String dbUser = dbStorageComponentInstance.getDbuser();
                String dbPassword = dbStorageComponentInstance.getDbpassword();
                String dbType = dbStorageComponentInstance.getRelatedhwcategoryInstance().getTitle();
                logger.debug("[Application " + applicationInstanceUriId + "] migrating DB "+dbName+" on the new paas "+newPaaSInstanceUriId);
                String dbUrl;
                try {
                    dbUrl = executionManagementServiceModule.createDatabase(applicationInstance, newPaaSInstance, newPaaSCredentials.getPublickey(), newPaaSCredentials.getPrivatekey(), newPaaSCredentials.getAccountname(), dbName, dbUser, dbPassword, dbType);
                    logger.debug("[Application " + applicationInstanceUriId + "] created DB on the new paas with url: " + dbUrl);
                    dbsDeployedOnNewPaaS.put(dbStorageComponentInstance.getUriId(), dbUrl);
                } catch (Cloud4SoaException ex) {
                    // 2a) Failure case
                    String failureCause = "Error on creating DB "+dbName+" on the new paas "+newPaaSInstanceUriId+" :"+ex.getMessage();
                    logger.error("[Application " + applicationInstanceUriId + "] "+failureCause);

                    // Change the Application Status
                    applicationInstance.setApplicationStatus(new ErrorInDBMigration());
                    
                    try {
                        applicationProfilesRepository.updateApplicationInstance(applicationInstance);
                    } catch (RepositoryException ex1) {
                        throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, "Error on updating the Profile after creating the DBs: "+ex1.getMessage());
                    }
                    
                    throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, failureCause);
                }
            }
            
            
            for (DBStorageComponentInstance dbStorageComponentInstance : dbStorageComponentList) {
                
                // 2.2) dump DB from the old PaaS/
                String dbName = dbStorageComponentInstance.getDbname();
                String dbUser = dbStorageComponentInstance.getDbuser();
                String dbPassword = dbStorageComponentInstance.getDbpassword();
                String dbType = dbStorageComponentInstance.getRelatedhwcategoryInstance().getTitle();
                File dbDumpFile = null;
                try {
                    dbDumpFile = File.createTempFile(dbName+"_"+"dump", "sql");
                } catch (IOException ex) {
                    logger.error("Impossible to create temporary dump file for database: "+dbName);
                    applicationInstance.setApplicationStatus(new ErrorInDBMigration());
                }
                logger.debug("[Application " + applicationInstanceUriId + "] dumping DB " + dbName + " on file " + dbDumpFile.getName());
                try {
                    executionManagementServiceModule.downloadDataBase(applicationInstance, oldPaaSCredentials.getPublickey(), oldPaaSCredentials.getPrivatekey(), dbName, dbUser, dbPassword, dbType, dbDumpFile.getAbsolutePath());
                } catch (Cloud4SoaException ex) {
                    String error = "Impossible to dump database: " + dbName+ " cause: " + ex.getMessage();
                    logger.error(error);
                    ErrorInDBMigration errorInDBMigration = new ErrorInDBMigration();
                    errorInDBMigration.setCause(error);
                    applicationInstance.setApplicationStatus(errorInDBMigration);
                    //revert in Failure case
                    // ... remove the db from the new PaaS
                    // ... Missing!
                    throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, "Error in dumping the DB: "+dbName);
                }
                
                // 2.3) initialize DB on the new PaaS/
                try {
                    executionManagementServiceModule.restoreDataBase(applicationInstance, newPaaSInstance, newPaaSCredentials.getPublickey(), newPaaSCredentials.getPrivatekey(), dbName, dbUser, dbPassword, dbType, dbDumpFile.getAbsolutePath());
                    dbDumpFile.delete();
                } catch (Cloud4SoaException ex) {
                    String error = "Impossible to restore database: " + dbName + " cause: " + ex.getMessage();
                    logger.error(error);
                    ErrorInDBMigration errorInDBMigration = new ErrorInDBMigration();
                    errorInDBMigration.setCause(error);
                    applicationInstance.setApplicationStatus(errorInDBMigration);
                    //revert in Failure case
                    // ... remove the db from the new PaaS
                    // ... Missing!
                    throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, "Error in initializing the DB: "+dbName);
                }
                
            }
            
            
            //update DBs infos with the new deployments
            if(!dbsDeployedOnNewPaaS.isEmpty()){
                for (DBStorageComponentInstance dbStorageComponentInstance : dbStorageComponentList) {
                    String dbUrl = dbsDeployedOnNewPaaS.get(dbStorageComponentInstance.getUriId());
                    // a) Retrieving the infos of the old deployment
                    DBDeployment oldDBdeployment = ((DBStorageComponent)dbStorageComponentInstance.getSoftwareComponent()).getDBdeployment();
                    
                    // b) Set migrated DB infos as the new deployment
                    DBDeployment dbDeployment = new DBDeployment();
                    dbDeployment.setDeploymentLocation(newPaaSInstance.getPaaSOffering());
                    ((DBStorageComponent)dbStorageComponentInstance.getSoftwareComponent()).setDBdeployment(dbDeployment);
                    dbStorageComponentInstance.setUrl(dbUrl);
                    
                    // c) Move old deployment to the property migratedFrom of the new one
                    dbDeployment.setMigratedFrom(oldDBdeployment);
                }
            }
            
            // Change the Application Status
            applicationInstance.setApplicationStatus(new DBMigrated());

            try {
                applicationProfilesRepository.updateApplicationInstance(applicationInstance);
            } catch (RepositoryException ex) {
                throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, "Error on updating the Profile after the DBs migration: "+ex.getMessage());
            }
            
            return Response.status(Response.Status.OK).entity("migrateDatabases processed successfully").type(MediaType.TEXT_PLAIN).build();
        }
        return Response.status(Response.Status.OK).entity("migrateDatabases processed successfully: No databases to be migrated").type(MediaType.TEXT_PLAIN).build();
    }
    
    private void ifConditionThrowsException(boolean condition, Response.Status responseStatus, String errorMessage) throws SOAException{
        if(condition){
            logger.debug(errorMessage);
            throw new SOAException(responseStatus, errorMessage);
        }
    }
    
    private Account getAccount(String userInstanceUriId, String providerTitle) throws SOAException {
        //----------------DataBase interaction ---------------------------------------------------
        
        //User
        User accountuser = null;
        List<User> userlist = userrepository.findBy("uriID", userInstanceUriId);
        ifConditionThrowsException(userlist == null || userlist.isEmpty(), Response.Status.INTERNAL_SERVER_ERROR, "No existing user entry in the relational DB having with uriId: "+userInstanceUriId);
        accountuser = ((User) userlist.get(0));
        
        //Paas
        Paas accountpaas = null;
        List<Paas> paaslist = paasrepository.findBy("name", providerTitle);
        ifConditionThrowsException(paaslist == null || paaslist.isEmpty(), Response.Status.INTERNAL_SERVER_ERROR, "No existing paas entry in the relational DB with name: "+providerTitle);
        accountpaas = ((Paas) paaslist.get(0));

        //Credentials (Account for the pair userid - paasid)
        Account account = null;
        List<Account> accounts = accountrepository.find("user = ? AND paas = ?", accountuser, accountpaas);
        ifConditionThrowsException(accounts == null || accounts.isEmpty(), Response.Status.BAD_REQUEST, "No existing pair user - paas account: " + accountuser.getId() + " - " + accountpaas.getId());
        account = ((Account) accounts.get(0));
                
        return account;        
    }

    
    private ApplicationInstance getApplicationInstance(String applicationInstanceUriId) throws SOAException {
        ApplicationInstance applicationInstance;
        try {
            applicationInstance = applicationProfilesRepository.getApplicationInstance(applicationInstanceUriId);
        } catch (RepositoryException ex) {
            throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
        return applicationInstance;
    }
    
    
    private PaaSInstance getPaaSInstance(String newPaaSInstanceUriId) throws SOAException {
        PaaSInstance newPaaSInstance;
        try {
            newPaaSInstance = paaSOfferingProfilesRepository.getPaaSInstance(newPaaSInstanceUriId);
        } catch (RepositoryException ex) {
            throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
        return newPaaSInstance;
    }
    
     
    private File getApplicationArchiveFile( ApplicationInstance appInstance, InputStream is ) throws SOAException {
        String              fileName;
        String              fileExtension;
        File                file;
        OutputStream        out;
        
        file = null;
        fileName                = appInstance.getArchiveFileName();
        fileExtension           = appInstance.getArchiveExtensionName();

        logger.debug(   "applicationInstance fileName: " + fileName + "." + fileExtension);
        try {
            file    = File.createTempFile(fileName, fileExtension);
            out     = new FileOutputStream(file);
            IOUtils.copy(is, out);
            out.close();
            is.close();
            logger.debug("File is created: "    + file.getAbsolutePath());
        
        } catch (FileNotFoundException ex) {
            logger.debug("Failed to process attachments", ex);
            throw new SOAException( Response.Status.BAD_REQUEST, 
                    "File not " + fileName + "." + fileExtension + " not found." );
            
        } catch (IOException ex) {
            logger.debug("Failed to process attachments", ex);
            throw new SOAException(Response.Status.BAD_REQUEST, "Failed to process attachments. Reason : " + ex.getMessage());
        }
        
        return file;
    }

    @Override
    public Response commitMigration(String applicationInstanceUriId) throws SOAException {
        ifConditionThrowsException(applicationInstanceUriId == null || applicationInstanceUriId.isEmpty(), Response.Status.BAD_REQUEST, "applicationInstanceUriId is null or empty");
        
        logger.debug("received applicationInstanceUriId: "+ applicationInstanceUriId);
        ApplicationInstance applicationInstance = getApplicationInstance(applicationInstanceUriId);
        
        ifConditionThrowsException(applicationInstance.getStatus().compareTo(StatusType.Migrated)!=0, Response.Status.BAD_REQUEST, "the application needs to be migrated succesfully before committing the changes");
 
        // Change the Application Status
        applicationInstance.setApplicationStatus(new ApplicationDeployed());
                
        // a) Retrieving the infos of the old deployment
        eu.cloud4soa.api.datamodel.semantic.app.ApplicationDeployment currentDeployment = applicationInstance.getApplication().getDeployment();
        eu.cloud4soa.api.datamodel.semantic.app.ApplicationDeployment oldDeployment = currentDeployment.getMigratedFrom();
        
        ifConditionThrowsException(oldDeployment==null, Response.Status.INTERNAL_SERVER_ERROR, "Error in retrieving the old Application deployment infos");
        
        String oldPaaSTitle = oldDeployment.getDeployingLocation().getPaaSProvider().getTitle();
        
        //Obtain credentials for the new PaaS
        Account oldPaaSCredentials = getAccount(applicationInstance.getOwnerUriId(), oldPaaSTitle);
        
        //Remove databases if any 
        //....
        List<DBStorageComponentInstance> dbStorageComponentList = new ArrayList<DBStorageComponentInstance>();
        List<SoftwareComponentInstance> softwareComponents = applicationInstance.getSoftwareComponents();
        for (SoftwareComponentInstance softwareComponentInstance : softwareComponents) {
            if (softwareComponentInstance instanceof DBStorageComponentInstance) {
                DBStorageComponentInstance dbStorageComponentInstance = (DBStorageComponentInstance) softwareComponentInstance;
                dbStorageComponentList.add(dbStorageComponentInstance);
            }
        }
       
        if (!dbStorageComponentList.isEmpty()) {
            logger.debug("[Application " + applicationInstanceUriId + "] The application has " + dbStorageComponentList.size() + " databases to be destroyed from the old paas");

            // 2) Destroy all DBs from the old PaaS
            for (DBStorageComponentInstance dbStorageComponentInstance : dbStorageComponentList) {
                DBDeployment dBdeployment = dbStorageComponentInstance.getDBStorageComponent().getDBdeployment();
                DBDeployment oldDBdeployment = dBdeployment.getMigratedFrom();
                ifConditionThrowsException(oldDBdeployment == null, Response.Status.INTERNAL_SERVER_ERROR, "Error in retrieving the old DB deployment infos");
                PaaSOffering oldPaaSDBdeploymentLocation = oldDBdeployment.getDeploymentLocation();
                oldPaaSTitle = oldPaaSDBdeploymentLocation.getPaaSProvider().getTitle();
                oldPaaSCredentials = getAccount(applicationInstance.getOwnerUriId(), oldPaaSTitle);
                //... remove DBs from the old paas
                //...
            }
        }
        try {
            //Remove application
            executionManagementServiceModule.unDeployApplication(applicationInstance, oldPaaSCredentials.getPublickey(), oldPaaSCredentials.getPrivatekey(), oldPaaSCredentials.getAccountname());
        } catch (Cloud4SoaException ex) {
            logger.error("Failed to undeploy the application from the old PaaS", ex);
            Status responseStatus = Response.Status.INTERNAL_SERVER_ERROR;
            String responseMessage = ex.getError();
            throw new SOAException(responseStatus, responseMessage);
        }
        
        try {
            applicationProfilesRepository.updateApplicationInstance(applicationInstance);
        } catch (RepositoryException ex) {
            throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, "Error on updating the Profile after after doing the migration commit: " + ex.getMessage());
        }

        return Response.status(Response.Status.OK).entity("Migration committed successfully.").type(MediaType.TEXT_PLAIN).build();
    }

    @Override
    public Response rollbackMigration(String applicationInstanceUriId) throws SOAException {
        ifConditionThrowsException(applicationInstanceUriId == null || applicationInstanceUriId.isEmpty(), Response.Status.BAD_REQUEST, "applicationInstanceUriId is null or empty");

        logger.debug("received applicationInstanceUriId: " + applicationInstanceUriId);
        ApplicationInstance applicationInstance = getApplicationInstance(applicationInstanceUriId);

        ifConditionThrowsException(applicationInstance.getStatus().compareTo(StatusType.Running) == 0 || applicationInstance.getStatus().compareTo(StatusType.Stopped) == 0 || applicationInstance.getStatus().compareTo(StatusType.Deployed) == 0, Response.Status.BAD_REQUEST, "the application needs to be in a migration state in order to rollback the changes");

        restoreApplicationDBs(applicationInstance);

        restoreApplication(applicationInstance);

        // Change the Application Status
        applicationInstance.setApplicationStatus(new ApplicationDeployed());
        
        try {
            applicationProfilesRepository.updateApplicationInstance(applicationInstance);
        } catch (RepositoryException ex1) {
            throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, "Error on updating the Profile after doing the migration rollback: " + ex1.getMessage());
        }

        return Response.status(Response.Status.OK).entity("Migration rollback successfully.").type(MediaType.TEXT_PLAIN).build();

    }
   
    private void restoreApplication(ApplicationInstance applicationInstance) throws SOAException {
        eu.cloud4soa.api.datamodel.semantic.app.ApplicationDeployment deployment = applicationInstance.getApplication().getDeployment();
        
        //Remove the application from the new paas
        if (applicationInstance.getStatus().compareTo(StatusType.Migrated) == 0 || applicationInstance.getApplicationStatus() instanceof ErrorInApplicationMigration) {
                        
            String newPaaSTitle = deployment.getDeployingLocation().getPaaSProvider().getTitle();
            Account newPaaSCredentials = getAccount(applicationInstance.getOwnerUriId(), newPaaSTitle);
            try {
                //Remove application
                executionManagementServiceModule.unDeployApplication(applicationInstance, newPaaSCredentials.getPublickey(), newPaaSCredentials.getPrivatekey(), newPaaSCredentials.getAccountname());
            } catch (Cloud4SoaException ex1) {
                throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, "Error in undeploying the application from the new PaaS - Please try to remove it manually: " + ex1.getMessage());
            }
        }
        
        try {
            eu.cloud4soa.api.datamodel.semantic.app.ApplicationDeployment oldDeployment = deployment.getMigratedFrom();
            String oldPaaSTitle = oldDeployment.getDeployingLocation().getPaaSProvider().getTitle();
            Account oldPaaSCredentials = getAccount(applicationInstance.getOwnerUriId(), oldPaaSTitle);
            executionManagementServiceModule.startStopApplication(applicationInstance, "start", oldPaaSCredentials.getPublickey(), oldPaaSCredentials.getPrivatekey(), oldPaaSCredentials.getAccountname());
            //Change the Application deployment infos (Recover the old ones)
            applicationInstance.getApplication().setDeployment(oldDeployment);
        } catch (Cloud4SoaException ex1) {
            throw new SOAException(Response.Status.INTERNAL_SERVER_ERROR, "Error in starting the application on the new PaaS - Please try to remove it manually: " + ex1.getMessage());
        }

    }
   
    private void restoreApplicationDBs(ApplicationInstance applicationInstance) throws SOAException {
        String applicationInstanceUriId = applicationInstance.getUriId();
        //Migration case: the application deployment info is the old one
        //Retrieving the paaSOfferingDeploymentUriId (the old one)
        String paaSOfferingDeploymentUriId = applicationInstance.getPaaSOfferingDeploymentUriId();

        //Remove databases if any 

        List<DBStorageComponentInstance> dbStorageComponentList = new ArrayList<DBStorageComponentInstance>();
        List<SoftwareComponentInstance> softwareComponents = applicationInstance.getSoftwareComponents();
        for (SoftwareComponentInstance softwareComponentInstance : softwareComponents) {
            if (softwareComponentInstance instanceof DBStorageComponentInstance) {
                DBStorageComponentInstance dbStorageComponentInstance = (DBStorageComponentInstance) softwareComponentInstance;
                dbStorageComponentList.add(dbStorageComponentInstance);
            }
        }

        if (!dbStorageComponentList.isEmpty()) {
            logger.debug("[Application " + applicationInstanceUriId + "] The application has " + dbStorageComponentList.size() + " databases to be destroyed from the old paas");

            // 2) Destroy all DBs from the old PaaS
            for (DBStorageComponentInstance dbStorageComponentInstance : dbStorageComponentList) {
                DBDeployment dBdeployment = dbStorageComponentInstance.getDBStorageComponent().getDBdeployment();               
                DBStorageComponent dBStorageComponent = dbStorageComponentInstance.getDBStorageComponent();
                //DBMigrated and ErrorInDBMigration case: the application deployment info is not aligned with the DB deployment infos
                if (applicationInstance.getStatus().compareTo(StatusType.DBMigrated) == 0 || applicationInstance.getApplicationStatus() instanceof ErrorInDBMigration) {
                    //Check if the current DB is deployed on the new paas (it could be not if any Error)
                    if (!dBdeployment.getDeploymentLocation().getUriId().equals(paaSOfferingDeploymentUriId)) {
                        removeDBFromTheNewPaaS(dBStorageComponent, applicationInstance);
                    }
                }
                //Migrated and ErrorInApplicationMigration case: the application deployment info is aligned with the DB deployment infos
                else if (applicationInstance.getStatus().compareTo(StatusType.Migrated) == 0 || applicationInstance.getApplicationStatus() instanceof ErrorInApplicationMigration) {
                    removeDBFromTheNewPaaS(dBStorageComponent, applicationInstance);
                }
            }
        }

    }
    
    
    private void removeDBFromTheNewPaaS(DBStorageComponent dBStorageComponent, ApplicationInstance applicationInstance) throws SOAException {
        DBDeployment dBdeployment = dBStorageComponent.getDBdeployment();
        
        DBDeployment newDBdeployment = dBdeployment.getMigratedFrom();
        ifConditionThrowsException(newDBdeployment == null, Response.Status.INTERNAL_SERVER_ERROR, "Error in retrieving the new DB deployment infos");
        PaaSOffering newPaaSDBdeploymentLocation = newDBdeployment.getDeploymentLocation();

        String newPaaSTitle = newPaaSDBdeploymentLocation.getPaaSProvider().getTitle();
        Account newPaaSCredentials = getAccount(applicationInstance.getOwnerUriId(), newPaaSTitle);
        
        //... remove DBs from the new paas
        
        //...
        
        //Recover old infos
        DBDeployment oldDBdeployment = dBdeployment.getMigratedFrom();
        dBStorageComponent.setDBdeployment(oldDBdeployment);
    }
    
    
    
    protected String getSlaTemplateId( ApplicationInstance applicationInstance, PaaSInstance paasInstance) {
        SlaTemplate slaTemplate;
        String      slaTemplateId;
        
        slaTemplate = slaModule.startNegotiation(applicationInstance, paasInstance);
        slaTemplateId = slaTemplate.getId().toString();
        
        return slaTemplateId;
    }

}