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


package eu.cloud4soa.cli.roo.addon;

import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import eu.cloud4soa.api.datamodel.core.MatchingPlatform;
import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.datamodel.core.UserInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.DBCategoryInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.DBStorageComponentInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.DeveloperInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.NoSqlDbCategoryInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.PaaSUserInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.SoftwareComponentInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.SqlDbCategoryInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.StatusType;
import eu.cloud4soa.api.datamodel.repository.QueryResultRow;
import eu.cloud4soa.api.datamodel.repository.QueryResultTable;
import eu.cloud4soa.api.datamodel.soa.GitRepoInfo;
import eu.cloud4soa.api.datamodel.soa.UserPaaSCredentials;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import eu.cloud4soa.cli.profiles.template.generator.ApplicationDescriptionGenerator;
import eu.cloud4soa.cli.profiles.template.generator.DeveloperDescriptionGenerator;
import eu.cloud4soa.cli.profiles.template.generator.PaaSOfferingDescriptionGenerator;
import eu.cloud4soa.cli.profiles.template.generator.PaaSUserDescriptionGenerator;
import eu.cloud4soa.cli.roo.addon.commands.Cloud4soaCommand;
import eu.cloud4soa.cli.roo.addon.commands.InitializeGitProxyCommand;
import eu.cloud4soa.cli.roo.addon.commands.DeleteRepoCommand;
import eu.cloud4soa.cli.roo.addon.commands.GetReposCommand;
import eu.cloud4soa.cli.roo.addon.commands.GitManager;
import eu.cloud4soa.cli.soa.AnnouncementModuleClient;
import eu.cloud4soa.cli.soa.ApplicationDeploymentClient;
import eu.cloud4soa.cli.soa.ApplicationMigrationClient;
import eu.cloud4soa.cli.soa.ModelManagerClient;
import eu.cloud4soa.cli.soa.PaaSOfferingDiscoveryClient;
import eu.cloud4soa.cli.soa.UserManagementAndSecurityModuleClient;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;
import java.util.logging.Level;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.cxf.jaxrs.client.ClientWebApplicationException;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.osgi.service.component.ComponentContext;
import org.slf4j.LoggerFactory;
import org.springframework.roo.process.manager.FileManager;
import org.springframework.roo.shell.osgi.AbstractFlashingObject;
import org.springframework.roo.support.osgi.UrlFindingUtils;
import org.springframework.roo.support.util.Assert;
import org.springframework.roo.support.util.StringUtils;

    
    
/**
 * Implementation of {@link AddonOperations} interface.
 *
 * @since 1.1.1
 */
@Component
@Service
public class Cloud4soaOperationsImpl extends AbstractFlashingObject implements Cloud4soaOperations {
    // Constants
    private static final Logger logger = Logger.getLogger(Cloud4soaOperationsImpl.class.getName());
    private static final org.slf4j.Logger slf4jLogger = LoggerFactory.getLogger( Cloud4soaOperationsImpl.class);

    private static final char SEPARATOR = File.separatorChar;

    private AnnouncementModuleClient announcementModuleClient;
    private ApplicationDeploymentClient applicationDeploymentClient;
    private ModelManagerClient modelManagerClient;
    private PaaSOfferingDiscoveryClient paaSOfferingDiscoveryClient;
    private UserManagementAndSecurityModuleClient userManagementAndSecurityModuleClient;
    private ApplicationMigrationClient applicationMigrationClient; 

    //Template generator
    private ApplicationDescriptionGenerator applicationDescriptionGenerator;
    
    private boolean isLogged = false;
    private Cloud4SoaSessionDeveloper cloud4SoaSessionDeveloper;
    
    private Cloud4SoaSessionPaaSUser cloud4SoaSessionPaaSUser;
    
    private ComponentContext context;
    
    protected boolean isGitRepoCreated;
    protected boolean hasReposShowed;
    
        /**
     * Get a reference to the FileManager from the underlying OSGi container. Make sure you
     * are referencing the Roo bundle which contains this service in your add-on pom.xml.
     * 
     * Using the Roo file manager instead if java.io.File gives you automatic rollback in case
     * an Exception is thrown.
     */
    @Reference private FileManager fileManager;

    /**
     * Get a reference to the ProjectOperations from the underlying OSGi container. Make sure you
     * are referencing the Roo bundle which contains this service in your add-on pom.xml.
     */
//	@Reference private ProjectOperations projectOperations;

    
    public Cloud4soaOperationsImpl() {
//            RuntimeDelegate.setInstance(new RuntimeDelegateImpl());
        String baseUri = System.getProperty(baseUrlKey);
        this.announcementModuleClient = new AnnouncementModuleClient();
        this.applicationDeploymentClient = new ApplicationDeploymentClient();
        this.modelManagerClient = new ModelManagerClient();
        this.paaSOfferingDiscoveryClient = new PaaSOfferingDiscoveryClient();
        this.userManagementAndSecurityModuleClient = new UserManagementAndSecurityModuleClient();
        this.applicationMigrationClient = new ApplicationMigrationClient();
        this.isGitRepoCreated   = false;
        this.hasReposShowed     = false;
    }

    protected void activate(final ComponentContext context) {
            this.context = context;
    }

    protected void deactivate(final ComponentContext context) {
            this.context = null;
            this.cloud4SoaSessionDeveloper = null;
            this.announcementModuleClient = null;
            this.applicationDeploymentClient = null;
            this.modelManagerClient = null;
            this.paaSOfferingDiscoveryClient = null;
            this.userManagementAndSecurityModuleClient = null;
            this.applicationMigrationClient=null;
    }
    
    @Override
    public boolean isLogged() {
        return isLogged;
    }
    
    @Override
    public boolean isLoggedAsDeveloper() {
        return cloud4SoaSessionDeveloper!=null;
    }
    
    @Override
    public boolean isApplicationProfilesCached() {
        if(cloud4SoaSessionDeveloper!=null)
            return cloud4SoaSessionDeveloper.isApplicationsCacheValid();
        return false;
    }
    
    @Override
    public boolean isDeployedApplicationsCached() {
        if(cloud4SoaSessionDeveloper!=null)
            return cloud4SoaSessionDeveloper.isDeployedApplicationsCacheValid();
        return false;
    }
    
    @Override
    public boolean isPaaSProfilesCached() {
        if(cloud4SoaSessionDeveloper!=null)
            return cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid();
        else if(cloud4SoaSessionPaaSUser!=null)
            return cloud4SoaSessionPaaSUser.isPaaSProfilesCacheValid();
        return false;
    }





     /** {@inheritDoc} */
    @Override
    public String getProperty(String propertyName) {
            Assert.hasText(propertyName, "Property name required");
            return System.getProperty(propertyName);
    }

    
    @Override
    public void setProperty(String propertyName, String value) {
        Assert.hasText(propertyName, "Property name required");
        Assert.hasText(value, "Property value required");
        System.setProperty(propertyName, value);
    }

    /**
     * A private method which illustrates how to reference and manipulate resources
     * in the target project as well as the bundle classpath.
     * 
     * @param path
     * @param fileName
     */
//    private InputStream loadFile(File file) {
////            String targetFile = path + SEPARATOR + fileName;
//            String targetFile = fileName;
//            InputStream fileInputStream = fileManager.exists(targetFile) ? fileManager.getInputStream(targetFile) : null;
//            return fileInputStream;
////            // Use MutableFile in combination with FileManager to take advantage of Roo's transactional file handling which 
////            // offers automatic rollback if an exception occurs
////            MutableFile mutableFile = fileManager.exists(targetFile) ? fileManager.updateFile(targetFile) : fileManager.createFile(targetFile);
////            try {
////                    // Use FileCopyUtils for copying resources from your add-on to the target project
////                    // Use TemplateUtils to open an InputStream to a resource located in your bundle
////                    FileCopyUtils.copy(TemplateUtils.getTemplate(getClass(), fileName), mutableFile.getOutputStream());
////            } catch (IOException e) {
////                    throw new IllegalStateException(e);
////            }
//    }
    /**
     * Opens the given script for reading
     *
     * @param file the file to read (required)
     * @return a non-<code>null</code> input stream
     */
    private InputStream openFile(final File file) {
            Assert.notNull(file, "Resource to parser is required");

            InputStream inputStream = null;
            try {
                inputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (FileNotFoundException tryTheClassLoaderInstead) {}

            if (inputStream == null) {
                // Try to find the resource via the classloader
                Set<URL> urls = findUrls(file.getName());

                // Handle search system failure
                Assert.notNull(urls, "Unable to process classpath bundles to locate the script");

                // Handle the file simply not being present, but the search being OK
                Assert.notEmpty(urls, "Resource '" + file + "' not found on disk or in classpath");
                Assert.isTrue(urls.size() == 1, "More than one '" + file + "' was found in the classpath; unable to continue");
                try {
                    inputStream = urls.iterator().next().openStream();
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
            return inputStream;
    }

    protected Set<URL> findUrls(String resourceName) {
        return UrlFindingUtils.findUrls(context.getBundleContext(), "/" + resourceName);
    }
    
    //DEFINED BY ME
    // Constants
    private final static String baseUrlKey = "cloud4soa.baseUrl";
    private final static String baseGitProxyUrlKey = "cloud4soa.gitProxyUrlKey";
//    private final static String defaultUrl = "http://soa-c4s.rhcloud.com/cloud4soa.soa/services/REST/";
    private final static String defaultUrl = "http://localhost:8080/services/REST/";
    private final static String defaultGitProxyUrl = "localhost";
    private final static String fileName = "defaultProperties.txt";
    static {
        Properties defaultProps = new Properties();
        FileInputStream in;
//            try {
//                URL fileURL = Cloud4soaOperationsImpl.class.getClassLoader().getResource(fileName);
//                if (fileURL == null)
//                    throw new FileNotFoundException(fileName);
//
//
//                ByteArrayOutputStream bas = new ByteArrayOutputStream();
//
//                File file = new File(fileURL.getPath());
//                file.length();
//                FileInputStream fis = new FileInputStream(file);
//
//                defaultProps.load(fis);
//                fis.close();
            String cloud4soaBaseUrl = null;
            cloud4soaBaseUrl = defaultProps.containsKey(baseUrlKey) ? defaultProps.getProperty(baseUrlKey) : defaultUrl;
            // set the system properties
            System.setProperty(baseUrlKey, cloud4soaBaseUrl);
            
            String cloud4soaGitProxyUrl = null;
            cloud4soaGitProxyUrl = defaultProps.containsKey(baseGitProxyUrlKey) ? defaultProps.getProperty(baseGitProxyUrlKey) : defaultGitProxyUrl;
            // set the system properties
            System.setProperty(baseGitProxyUrlKey, cloud4soaGitProxyUrl);
//            }  catch (FileNotFoundException ex) {
//                Logger.getLogger(Cloud4soaOperationsImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }  catch (IOException ex) {
//                Logger.getLogger(Cloud4soaOperationsImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            finally {
//                System.setProperty(baseUrlKey, defaultUrl);
//            }
    }

    @Override
    public void login(final String username, final String password) {
            String successMessage = "Login succesful";
            String failureMessage = "Login failed";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() {
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = UserManagementAndSecurityModuleClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        UserInstance userInstance = null;
                        try {
                            userInstance = userManagementAndSecurityModuleClient.authenticateUser(username, password);
                        } catch (ClientWebApplicationException ex) {
                            logger.severe("Unable to establish a connection " + ex.getMessage());
                        }
                        Thread.currentThread().setContextClassLoader(originalCL);
                        if(userInstance != null){
                            isLogged = true;
                            this.displaySuccessMessage=false;
                            logger.info(this.successMessage);
                            if(userInstance instanceof DeveloperInstance){
                                logger.info("Welcome " + userInstance.getFirstName() + " you are now logged as a Developer.");
                                cloud4SoaSessionDeveloper = new Cloud4SoaSessionDeveloperImpl(userInstance);
                            }
                            if(userInstance instanceof PaaSUserInstance){
                                logger.info("Welcome " + userInstance.getFirstName() + " you are now logged as a PaaS Provider.");
                                cloud4SoaSessionPaaSUser = new Cloud4SoaSessionPaaSUserImpl((PaaSUserInstance)userInstance);
                            }
                        }
                        else {
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        }
                    }
            });
    }

//    @Override
//    public void register(final UserInstance userInstance) {
//            String successMessage = "Registration was successful";
//            String failureMessage = "Registration failed";
//            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
//                    @Override
//                    public void execute() throws Exception {
//                        boolean isCreated = userManagementAndSecurityModuleClient.createNewAccount(userInstance);
//                        logger.info(isCreated ? successMessage : failureMessage);
//                    }
//            });
//    }
    
    @Override
    public void registerUserProfile(final File file, final String username, final String password){
            String successMessage = "User Profile stored";
            String failureMessage = "Failed to store the User Profile";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        final InputStream fileInputStream = openFile(file);
                        if(fileInputStream==null){
                            logger.severe("Cannot open the file: "+file);
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        }
                            

                        DeveloperInstance developerInstance = null;

                        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
                        StringBuilder sb = new StringBuilder();
                        String line = null;

                        while ((line = br.readLine()) != null) {
                            sb.append(line + "\n");
                        }
                        String developerProfile = new String(sb);
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ModelManagerClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);

                        String developerInstanceUriId = userManagementAndSecurityModuleClient.storeTurtleUserProfile(developerProfile, username, password);

                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(developerInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        }

                    }
                    
            });
    }
    
    @Override
    public void logout() {
        if(cloud4SoaSessionDeveloper!=null)
            cloud4SoaSessionDeveloper=null;
        if(cloud4SoaSessionPaaSUser!=null)
            cloud4SoaSessionPaaSUser=null;
        this.isLogged = false;
    }
    
    /* Developer Commands */
    
    @Override
    public void showApplicationProfiles() {
        String failureMessage = "Application Profiles retrival failed";
            executeCommand(new Cloud4soaCommand(failureMessage) {
                    @Override
                    public void execute() throws Exception {
                        if(!cloud4SoaSessionDeveloper.isApplicationsCacheValid()){
                            try {
                                retrieveAllApplicationProfile();
                            } catch (SOAException ex) {
                                logger.log(Level.SEVERE, "{0}: {1}", new Object[]{failureMessage, ex.getMessage()});
                                this.displaySuccessMessage = false;
                                return;
                            }
                        }
                        Map<Integer, ApplicationInstance> cachedApplicationProfiles = cloud4SoaSessionDeveloper.getCachedApplicationProfiles();
                        ShellTableRenderer table = new ShellTableRenderer("Application Profiles", "ID", "Title", "Code", "Version", "Programming Language");
                        for (Integer id : cachedApplicationProfiles.keySet()) {
                            ApplicationInstance applicationInstance = cachedApplicationProfiles.get(id);
                            logger.fine("applicationInstance: "+applicationInstance);
                            table.addRow(Integer.toString(id), applicationInstance.getTitle(), applicationInstance.getApplicationcode(), applicationInstance.getVersion(), applicationInstance.getProgramminglanguage());
                        }
                        logger.info(table.getOutput());
                    }
            });
    }
    
    private void retrieveAllApplicationProfile() throws SOAException {
        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
        ClassLoader jaxrsExtCL = ModelManagerClient.class.getClassLoader();
        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
        
        List<ApplicationInstance> retrieveAllApplicationProfile = modelManagerClient.retrieveAllApplicationProfile(cloud4SoaSessionDeveloper.getUserInstanceUriId());

        Thread.currentThread().setContextClassLoader(originalCL);

        cloud4SoaSessionDeveloper.setCachedApplicationProfiles(retrieveAllApplicationProfile);
    }
    
    private void retrieveAllPaaSInstances() throws SOAException {
        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
        ClassLoader jaxrsExtCL = PaaSOfferingDiscoveryClient.class.getClassLoader();
        Thread.currentThread().setContextClassLoader(jaxrsExtCL);

        List<PaaSInstance> paaSProfiles = paaSOfferingDiscoveryClient.getAllAvailablePaaSInstances();

        Thread.currentThread().setContextClassLoader(originalCL);
        cloud4SoaSessionDeveloper.setCachedPaaSProfiles(paaSProfiles);
    }
    
//    @Override
//    public void showApplicationProfileDetails(final Integer localId){
//        String failureMessage = "Application Profile Details retrival failed";
//            executeCommand(new Cloud4soaCommand(failureMessage) {
//                    @Override
//                    public void execute() throws Exception {
//                        Assert.isTrue(cloud4SoaSessionDeveloper.isApplicationsCacheValid());
//                        ApplicationInstance applicationInstance = cloud4SoaSessionDeveloper.getCachedApplicationProfile(localId);
//                        if(applicationInstance != null){
////                            ShellTableRenderer table = new ShellTableRenderer("Application Profile Details", "ID", "Acronym", "Code", "Version");
////                            table.addRow(Integer.toString(localId), applicationInstance.getAcronym(), applicationInstance.getApplicationcode().toString(), applicationInstance.getVersion());
////                            logger.info(table.getOutput());
//                            PrinterVisitor pv = new PrinterVisitor();
//                            String applicationRepresentation = pv.visit(applicationInstance);
//                            logger.info(applicationRepresentation);
//                        }
//                        else {
//                            logger.severe("id parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedApplicationProfiles().keySet());
//                            return;
//                        }
//                    }
//            });
//    }
    
    
    @Override
    public void showAllDeployedApplications() {
         String failureMessage = "Deployed Applications details retrival failed";
            executeCommand(new Cloud4soaCommand(failureMessage) {
                    @Override
                    public void execute() throws Exception {
//                        if(!cloud4SoaSessionDeveloper.isDeployedApplicationsCacheValid()){
                            List<ApplicationInstance> deployedApplicationProfiles;
                            ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                            ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                            Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                            try{
                                deployedApplicationProfiles = applicationDeploymentClient.retrieveAllDeployedApplicationProfile(cloud4SoaSessionDeveloper.getUserInstanceUriId());
                            } catch(SOAException ex){
                                logger.log(Level.SEVERE, "{0}: {1}", new Object[]{failureMessage, ex.getMessage()});
                                this.displaySuccessMessage=false;
                                return;
                            }
                            Thread.currentThread().setContextClassLoader(originalCL);
                            
                            if(deployedApplicationProfiles == null){
                                logger.severe(failureMessage);
                                return;
                            }
                            cloud4SoaSessionDeveloper.setCachedDeployedApplications(deployedApplicationProfiles);
//                        }
                        Map<Integer, ApplicationInstance> cachedDeployerApplications = cloud4SoaSessionDeveloper.getCachedDeployedApplications();
                        ShellTableRenderer table = new ShellTableRenderer("Deployed Applications", "ID", "Title","Version", "Programming Language", "Status", "Platform", "Url");
                        if(!cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid()){
                            List<PaaSInstance> paaSProfiles;
                            originalCL = Thread.currentThread().getContextClassLoader();
                            jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                            Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                            try {
                                paaSProfiles = paaSOfferingDiscoveryClient.getAllAvailablePaaSInstances();
                            } catch (SOAException ex) {
                                logger.log(Level.SEVERE, "{0}: {1}", new Object[]{failureMessage, ex.getMessage()});
                                this.displaySuccessMessage = false;
                                return;
                            }
                            Thread.currentThread().setContextClassLoader(originalCL);
                            
                            cloud4SoaSessionDeveloper.setCachedPaaSProfiles(paaSProfiles);
                        }
                        for (Integer id : cachedDeployerApplications.keySet()) {
                            ApplicationInstance applicationInstance = cachedDeployerApplications.get(id);
                            PaaSInstance platform = cloud4SoaSessionDeveloper.getCachedPaaSProfile(applicationInstance.getPaaSOfferingDeploymentUriId());  
                            table.addRow(Integer.toString(id), applicationInstance.getTitle(), applicationInstance.getVersion(), applicationInstance.getProgramminglanguage(), applicationInstance.getStatus().toString(), platform.getProviderTitle(), applicationInstance.getDeploymentIP());
                        }
                        logger.info(table.getOutput());
                    }
            });
    }
    
    @Override
    public void createAndStoreApplicationProfile(final File file){
            String successMessage = "Application Profile stored";
            String failureMessage = "Failed to store Application Profile";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        final InputStream fileInputStream = openFile(file);
                        if(fileInputStream==null){
                            logger.severe("Cannot open the file: "+file);
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        }

                        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
                        StringBuilder sb = new StringBuilder();
                        String line = null;

                        while ((line = br.readLine()) != null) {
                            sb.append(line + "\n");
                        }
                        String applicationProfile = new String(sb);
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ModelManagerClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);

                        String applicationInstanceUriId = modelManagerClient.storeTurtleApplicationProfile(applicationProfile, cloud4SoaSessionDeveloper.getUserInstanceUriId());

                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(applicationInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        }
                        else
                            cloud4SoaSessionDeveloper.invalidateApplicationsCache();

                    }
                    
            });
    }

    private ApplicationInstance getApplicationInstanceFromFile() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void updateApplicationProfile(Integer localId, File file) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteApplicationProfile(final Integer localId) {
        String successMessage = "Application Profile deleted";
        String failureMessage = "Application Profile retrival failed";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isApplicationsCacheValid());
                        String applicationInstanceUriId = cloud4SoaSessionDeveloper.getCachedApplicationId(localId);
                        if(applicationInstanceUriId != null){
                            
                            ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                            ClassLoader jaxrsExtCL = ModelManagerClient.class.getClassLoader();
                            Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                            try {
                                modelManagerClient.removeApplicationProfile(applicationInstanceUriId);
                            } catch (SOAException ex) {
                                logger.log(Level.SEVERE, "{0}: {1}", new Object[]{failureMessage, ex.getMessage()});
                                this.displaySuccessMessage = false;
                                return;
                            }
                            Thread.currentThread().setContextClassLoader(originalCL);
                            
                            if(applicationInstanceUriId == null){
                                this.displaySuccessMessage=false;
                                logger.severe(this.failureMessage);
                            }
                            else{
                                cloud4SoaSessionDeveloper.invalidateApplicationsCache();
                                cloud4SoaSessionDeveloper.invalidateDeployedApplications();
                            }
                        }
                        else {
                            this.displaySuccessMessage=false;
                            logger.severe("id parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedApplicationProfiles().keySet());
                            return;
                        }
                    }
            });
    }

    @Override
    public void searchForMatchingPlatforms(final Integer localId) {
        String failureMessage = "Impossible to search for matching platforms";
            executeCommand(new Cloud4soaCommand(failureMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isApplicationsCacheValid());
                        String applicationInstanceUriId = cloud4SoaSessionDeveloper.getCachedApplicationId(localId);
                        if(applicationInstanceUriId != null){
                            
                            ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                            ClassLoader jaxrsExtCL = ModelManagerClient.class.getClassLoader();
                            Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                            
                            MatchingPlatform matchingPlatform = null;
                            try {
                                matchingPlatform = paaSOfferingDiscoveryClient.searchForMatchingPlatform(applicationInstanceUriId);
                            } catch (SOAException ex) {
                                logger.log(Level.SEVERE, "{0}: {1}", new Object[]{failureMessage, ex.getMessage()});
                                this.displaySuccessMessage = false;
                                return;
                            }
                            Thread.currentThread().setContextClassLoader(originalCL);
                            
                            if(matchingPlatform == null){
                                this.displaySuccessMessage=false;
                                logger.severe(this.failureMessage);
                            }
                            else{
                                List<PaaSInstance> listPaaSInstance = matchingPlatform.getListPaaSInstance();
                                if(!cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid()){
                                    List<PaaSInstance> paaSProfiles;
                                    originalCL = Thread.currentThread().getContextClassLoader();
                                    jaxrsExtCL = PaaSOfferingDiscoveryClient.class.getClassLoader();
                                    Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                                    try {
                                        paaSProfiles = paaSOfferingDiscoveryClient.getAllAvailablePaaSInstances();
                                    } catch (SOAException ex) {
                                        logger.log(Level.SEVERE, "{0}: {1}", new Object[]{failureMessage, ex.getMessage()});
                                        this.displaySuccessMessage = false;
                                        return;
                                    }
                                    Thread.currentThread().setContextClassLoader(originalCL);

                                    cloud4SoaSessionDeveloper.setCachedPaaSProfiles(paaSProfiles);
                                }
                                if(listPaaSInstance==null)
                                    listPaaSInstance = new ArrayList<PaaSInstance>();
//                                cloud4SoaSessionDeveloper.setCachedPaaSProfiles(listPaaSInstance);
                                cloud4SoaSessionDeveloper.setCachedMatchingPlatforms(listPaaSInstance);
                                cloud4SoaSessionDeveloper.setCachedSLATemplateIds( matchingPlatform.getListSlaContract() );
//                                Map<Integer, PaaSInstance> cachedPaaSProfiles = cloud4SoaSessionDeveloper.getCachedPaaSProfiles();
                                Map<Integer, PaaSInstance> cachedMatchingPlatforms = cloud4SoaSessionDeveloper.getCachedMatchingPlatforms();
                                ShellTableRenderer table = new ShellTableRenderer("Matching Platforms", "ID", "Provider Name", "Offering Title", "Programming Language");
                                for (Integer id : cachedMatchingPlatforms.keySet()) {
                                    PaaSInstance paaSInstance = cachedMatchingPlatforms.get(id);
                                    logger.fine("paaSInstance: " + paaSInstance);
                                    table.addRow(Integer.toString(id), paaSInstance.getProviderTitle(), paaSInstance.getTitle(), paaSInstance.getSupportedProgrammingLanguage());
                                }
                                logger.info(table.getOutput());
                            }
                        }
                        else {
                            this.displaySuccessMessage=false;
                            logger.severe("id parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedApplicationProfiles().keySet());
                            return;
                        }
                    }
            });
    }

    @Override
    public void showAllAvailablePaaSProfiles() {
        String failureMessage = "PaaS Profiles retrival failed";
            executeCommand(new Cloud4soaCommand(failureMessage) {
                    @Override
                    public void execute() throws Exception {
                        if(!cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid()){
                            List<PaaSInstance> paaSProfiles;
                            ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                            ClassLoader jaxrsExtCL = PaaSOfferingDiscoveryClient.class.getClassLoader();
                            Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                            try {
                                paaSProfiles = paaSOfferingDiscoveryClient.getAllAvailablePaaSInstances();
                            } catch (SOAException ex) {
                                logger.log(Level.SEVERE, "{0}: {1}", new Object[]{failureMessage, ex.getMessage()});
                                this.displaySuccessMessage = false;
                                return;
                            }
                            Thread.currentThread().setContextClassLoader(originalCL);
                            
                            cloud4SoaSessionDeveloper.setCachedPaaSProfiles(paaSProfiles);
                        }
                        Map<Integer, PaaSInstance> cachedPaaSProfiles = cloud4SoaSessionDeveloper.getCachedPaaSProfiles();
                        ShellTableRenderer table = new ShellTableRenderer("Available Platforms", "ID", "Provider Name", "Offering Title", "Programming Language");
//                        for (Integer id : cachedPaaSProfiles.keySet()) {
//                            PaaSInstance paaSInstance = cachedPaaSProfiles.get(id);
                        for (Integer id : cachedPaaSProfiles.keySet()) {
                            PaaSInstance paaSInstance = cachedPaaSProfiles.get(id);
                            logger.fine("paaSInstance: "+paaSInstance);
                            table.addRow(Integer.toString(id), paaSInstance.getProviderTitle(), paaSInstance.getTitle(), paaSInstance.getSupportedProgrammingLanguage());
                        }
                        logger.info(table.getOutput());
                    }
            });
    }

    @Override
    public void deployApplication(final Integer localAppId, final Integer paasId, final File file) {
        String successMessage = "Application deployed";
        String failureMessage = "Failed to deploy the Application";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isApplicationsCacheValid());
                        Assert.isTrue(cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid());
                        logger.info("Deploying the application...");
                        String applicationInstanceUriId = cloud4SoaSessionDeveloper.getCachedApplicationId(localAppId);
                        if(applicationInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("appId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedApplicationProfiles().keySet());
                            return;
                        }
                        String paaSInstanceUriId = cloud4SoaSessionDeveloper.getCachedPaaSProfileId(paasId);
                        if(paaSInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("paasId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedPaaSProfiles().keySet());
                            return;
                        }
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        
                        try {
                            UserPaaSCredentials userCredentialsForPaaS = userManagementAndSecurityModuleClient.readUserCredentialsForPaaS(cloud4SoaSessionDeveloper.getUserInstanceUriId(), paaSInstanceUriId);
                        } catch (SOAException e) {                                                 
                            this.displaySuccessMessage=false;
                            logger.severe("No stored Credentials for the specific PaaS");
                            Thread.currentThread().setContextClassLoader(originalCL);
                            return;
                        } 
                       
                        Thread.currentThread().setContextClassLoader(originalCL);
                        
                        
                        // retrieve the SLA template id; if it's not cached, try to generate an SLATemplate.
                        String slaTemplateId = null;
                        slaTemplateId = cloud4SoaSessionDeveloper.getSlaTemplateId( paaSInstanceUriId );
                        
                        
                        final InputStream fileInputStream = openFile(file);
                        if(fileInputStream==null){
                            logger.severe("Cannot open the file: "+file);
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                            return;
                        }
                        
                        
                        originalCL = Thread.currentThread().getContextClassLoader();
                        jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        
                        flash(Level.FINE, "Deploying application: " + cloud4SoaSessionDeveloper.getCachedApplicationProfile(localAppId).getTitle(), MY_SLOT);
 //                       boolean isApplicationDeployed = false;
                        boolean isApplicationDeployed = applicationDeploymentClient.deployApplication(applicationInstanceUriId, paaSInstanceUriId, fileInputStream, slaTemplateId);
                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(!isApplicationDeployed){
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        } 
                        else{
//                            ApplicationInstance cachedApplicationProfile = null;
//                            originalCL = Thread.currentThread().getContextClassLoader();
//                            jaxrsExtCL = ModelManagerClient.class.getClassLoader();
//                            Thread.currentThread().setContextClassLoader(jaxrsExtCL);
//                            List<ApplicationInstance> retrieveAllApplicationProfile = modelManagerClient.retrieveAllApplicationProfile(cloud4SoaSessionDeveloper.getUserInstanceUriId());
//                            Thread.currentThread().setContextClassLoader(originalCL);
//                             
//                            cloud4SoaSessionDeveloper.setCachedApplicationProfiles(retrieveAllApplicationProfile);
//                            for (ApplicationInstance applicationInstance : retrieveAllApplicationProfile) {
//                                if(applicationInstance.getUriId().equals(applicationInstanceUriId))
//                                    cachedApplicationProfile = applicationInstance;
//                            }
                           
                            
                            
                            
                            //Updating SizeQuantity, ArchiveFileName, ExtensionName, (Digest?)
                            ApplicationInstance cachedApplicationProfile = cloud4SoaSessionDeveloper.getCachedApplicationProfile(localAppId);
                            
                            cachedApplicationProfile.setSizeQuantity(new Float(file.length()));
                            String extension = FilenameUtils.getExtension(file.getName());
                            String baseName = FilenameUtils.getBaseName(file.getName());
                            cachedApplicationProfile.setArchiveFileName(baseName);
                            cachedApplicationProfile.setArchiveExtensionName(FilenameUtils.EXTENSION_SEPARATOR_STR+extension);

                            originalCL = Thread.currentThread().getContextClassLoader();
                            jaxrsExtCL = ModelManagerClient.class.getClassLoader();
                            Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                            try{
                                modelManagerClient.updateApplicationProfile(cachedApplicationProfile);
                            } catch(SOAException ex){
                                logger.log(Level.SEVERE, "{0}: {1}", new Object[]{failureMessage, ex.getMessage()});
                                this.displaySuccessMessage=false;
                                return;
                            }
                            Thread.currentThread().setContextClassLoader(originalCL);
                            
                            cloud4SoaSessionDeveloper.invalidateApplicationsCache();
                            cloud4SoaSessionDeveloper.invalidateDeployedApplications();
                        }
                    }
            });
    }
    
    @Override
    public void undeployApplication(final Integer localAppId) {
        String successMessage = "Application undeployed succesfully";
        String failureMessage =  "Failed to undeploy the Application";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isDeployedApplicationsCacheValid());
                        if(!cloud4SoaSessionDeveloper.getCachedDeployedApplications().containsKey(localAppId)){
                            this.displaySuccessMessage=false;
                            logger.severe("id parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedDeployedApplications().keySet());
                            return;
                        }
                        StatusType status = cloud4SoaSessionDeveloper.getCachedDeployedApplications().get(localAppId).getStatus();
                        if((!status.equals(StatusType.Deployed) && !status.equals(StatusType.Stopped))){
                            this.displaySuccessMessage=false;
                            logger.severe("Application is not deployed");
                            return;
                        }
                        String applicationInstanceUriId = cloud4SoaSessionDeveloper.getCachedDeployedApplicationId(localAppId);

                        ApplicationInstance applicationProfile = cloud4SoaSessionDeveloper.getCachedDeployedApplications().get(localAppId);
                        String paaSInstanceUriId = applicationProfile.getPaaSOfferingDeploymentUriId();
                                                                       
                        flash(Level.FINE, "Performing undeploy command on application: " + cloud4SoaSessionDeveloper.getCachedDeployedApplications().get(localAppId).getTitle(), MY_SLOT);
                        
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        
                        try {
                            UserPaaSCredentials userCredentialsForPaaS = userManagementAndSecurityModuleClient.readUserCredentialsForPaaS(cloud4SoaSessionDeveloper.getUserInstanceUriId(), paaSInstanceUriId);
                        } catch (SOAException e) {                                                 
                            this.displaySuccessMessage=false;
                            logger.severe("No stored Credentials for the specific PaaS");
                            Thread.currentThread().setContextClassLoader(originalCL);
                            return;
                        } 
                        
                        Thread.currentThread().setContextClassLoader(originalCL);
                        
                        originalCL = Thread.currentThread().getContextClassLoader();
                        jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                       
                        boolean isUndeployed = applicationDeploymentClient.removeApplication(applicationInstanceUriId);

                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(!isUndeployed){
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        }
                        cloud4SoaSessionDeveloper.invalidateDeployedApplications();
                    }
            });
    }

    @Override
    public void startStopApplication(final Integer localAppId, final String command) {
        String successMessage = command.equalsIgnoreCase("stop") ? "Application stopped succesfully" : "Application started succesfully";
        String failureMessage =  "Failed to " + command + " the Application";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isDeployedApplicationsCacheValid());
                        if(!cloud4SoaSessionDeveloper.getCachedDeployedApplications().containsKey(localAppId)){
                            this.displaySuccessMessage=false;
                            logger.severe("id parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedDeployedApplications().keySet());
                            return;
                        }
                        StatusType status = cloud4SoaSessionDeveloper.getCachedDeployedApplications().get(localAppId).getStatus();
                        if((status.equals(StatusType.Stopped) && command.equals("stop")) 
                                || (status.equals(StatusType.Deployed) && command.equals("start"))){
                            this.displaySuccessMessage=false;
                            logger.severe("Application is already " + (command.equalsIgnoreCase("stop") ? "stopped" : "started"));
                            return;
                        }
                        String applicationInstanceUriId = cloud4SoaSessionDeveloper.getCachedDeployedApplicationId(localAppId);
                        ApplicationInstance applicationProfile = cloud4SoaSessionDeveloper.getCachedDeployedApplications().get(localAppId);
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        
                        try {
                            UserPaaSCredentials userCredentialsForPaaS = userManagementAndSecurityModuleClient.readUserCredentialsForPaaS(cloud4SoaSessionDeveloper.getUserInstanceUriId(), applicationProfile.getPaaSOfferingDeploymentUriId());
                        } catch (SOAException e) {                                                 
                            this.displaySuccessMessage=false;
                            logger.severe("No stored Credentials for the specific PaaS");
                            Thread.currentThread().setContextClassLoader(originalCL);
                            return;
                        } 
                        
                        Thread.currentThread().setContextClassLoader(originalCL);
                        flash(Level.FINE, "Performing "+ command + " command on application: " + cloud4SoaSessionDeveloper.getCachedDeployedApplications().get(localAppId).getTitle(), MY_SLOT);
                        
                        originalCL = Thread.currentThread().getContextClassLoader();
                        jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        boolean isStatusChanged = applicationDeploymentClient.startStopApplication(applicationInstanceUriId, command);

                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(!isStatusChanged){
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        }
                        cloud4SoaSessionDeveloper.invalidateDeployedApplications();
                    }
            });
    }
    
    /* DB related operations */
    
//    String applicationInstanceUriId, String paaSInstanceUriId, String dbStorageComponentUriId, String publicKey, String secretKey
    @Override
    public void createDatabase(final Integer localAppId, final Integer paasId, final String dbName) {
        String successMessage = "Database created";
        String failureMessage = "Failed to create the Database";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isApplicationsCacheValid());
                        Assert.isTrue(cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid());
                        String applicationInstanceUriId = cloud4SoaSessionDeveloper.getCachedApplicationId(localAppId);
                        if(applicationInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("appId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedApplicationProfiles().keySet());
                            return;
                        }
                        String paaSInstanceUriId = cloud4SoaSessionDeveloper.getCachedPaaSProfileId(paasId);
                        if(paaSInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("paasId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedPaaSProfiles().keySet());
                            return;
                        }
                        
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        
                        try {
                            UserPaaSCredentials userCredentialsForPaaS = userManagementAndSecurityModuleClient.readUserCredentialsForPaaS(cloud4SoaSessionDeveloper.getUserInstanceUriId(), paaSInstanceUriId);
                        } catch (SOAException e) {                                                 
                            this.displaySuccessMessage=false;
                            logger.severe("No stored Credentials for the specific PaaS");
                            Thread.currentThread().setContextClassLoader(originalCL);
                            return;
                        } 
                        
                        Thread.currentThread().setContextClassLoader(originalCL);
                        
                        //Check if the dbUri exists for the given application (profile)
                        ApplicationInstance cachedApplicationProfile = cloud4SoaSessionDeveloper.getCachedApplicationProfile(localAppId);
                        boolean found = false;
                        DBStorageComponentInstance dbStorageComponentInstance = null;
                        List<SoftwareComponentInstance> softwareComponents = cachedApplicationProfile.getSoftwareComponents();
                        String dbStorageComponentUriId = "";
                        for (SoftwareComponentInstance softwareComponentInstance : softwareComponents) {
                            logger.warning("softwareComponentInstance UriId:"+softwareComponentInstance.getUriId());
                            logger.warning("DBname:"+dbName);
                            if(softwareComponentInstance instanceof DBStorageComponentInstance){                                
                                if(((DBStorageComponentInstance)softwareComponentInstance).getDbname().equalsIgnoreCase(dbName)){
                                    dbStorageComponentInstance = (DBStorageComponentInstance)softwareComponentInstance;
                                    dbStorageComponentUriId = dbStorageComponentInstance.getUriId();
                                    logger.warning("found dbStorageComponent with uriId: "+dbStorageComponentUriId);
                                    break;
                                }
                            }
                        }
                        if(dbStorageComponentInstance == null){
                            this.displaySuccessMessage=false;
                            logger.severe("db parameter must be one of the DBStorageComponent specified inside the application profile");
                            return;
                        }                                               
                            
                        originalCL = Thread.currentThread().getContextClassLoader();
                        jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        flash(Level.FINE, "Creating database: " + dbStorageComponentInstance.getDbname(), MY_SLOT);
                        boolean isDBCreated = applicationDeploymentClient.createDatabase(applicationInstanceUriId, paaSInstanceUriId, dbStorageComponentUriId);

                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(!isDBCreated){
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        } 
                        else{
                            cloud4SoaSessionDeveloper.invalidateApplicationsCache();
                            retrieveAllApplicationProfile();
                        }
                    }
            });
    }
    
    @Override
    public void initializeDatabase(final Integer localAppId, final Integer paasId, final String dbName, final File file) {
        String successMessage = "Database initialized";
        String failureMessage = "Failed to initialize the Database";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isApplicationsCacheValid());
                        Assert.isTrue(cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid());
                        String applicationInstanceUriId = cloud4SoaSessionDeveloper.getCachedApplicationId(localAppId);
                        if(applicationInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("appId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedApplicationProfiles().keySet());
                            return;
                        }
                        String paaSInstanceUriId = cloud4SoaSessionDeveloper.getCachedPaaSProfileId(paasId);
                        if(paaSInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("paasId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedPaaSProfiles().keySet());
                            return;
                        }
                        
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        
                        try {
                            UserPaaSCredentials userCredentialsForPaaS = userManagementAndSecurityModuleClient.readUserCredentialsForPaaS(cloud4SoaSessionDeveloper.getUserInstanceUriId(), paaSInstanceUriId);
                        } catch (SOAException e) {                                                 
                            this.displaySuccessMessage=false;
                            logger.severe("No stored Credentials for the specific PaaS");
                            Thread.currentThread().setContextClassLoader(originalCL);
                            return;
                        } 
                        
                        Thread.currentThread().setContextClassLoader(originalCL);
                        
                        //Check if the dbUri exists for the given application (profile)
                        ApplicationInstance cachedApplicationProfile = cloud4SoaSessionDeveloper.getCachedApplicationProfile(localAppId);
                        boolean found = false;
                        DBStorageComponentInstance dbStorageComponentInstance = null;
                        List<SoftwareComponentInstance> softwareComponents = cachedApplicationProfile.getSoftwareComponents();
                        String dbStorageComponentUriId = "";
                        for (SoftwareComponentInstance softwareComponentInstance : softwareComponents) {
                            logger.warning("softwareComponentInstance UriId:"+softwareComponentInstance.getUriId());
                            logger.warning("DBname:"+dbName);
                            if(softwareComponentInstance instanceof DBStorageComponentInstance){                                
                                if(((DBStorageComponentInstance)softwareComponentInstance).getDbname().equalsIgnoreCase(dbName)){
                                    dbStorageComponentInstance = (DBStorageComponentInstance)softwareComponentInstance;
                                    dbStorageComponentUriId = dbStorageComponentInstance.getUriId();
                                    logger.warning("found dbStorageComponent with uriId: "+dbStorageComponentUriId);
                                    break;
                                }
                            }
                        }
                        if(dbStorageComponentInstance == null){
                            this.displaySuccessMessage=false;
                            logger.severe("db parameter must be one of the DBStorageComponent specified inside the application profile");
                            return;
                        }

                        final InputStream fileInputStream = openFile(file);
                        if(fileInputStream==null){
                            logger.severe("Cannot open the file: "+file);
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                            return;
                        }
                            
                        originalCL = Thread.currentThread().getContextClassLoader();
                        jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        flash(Level.FINE, "Initializing database: " + dbStorageComponentInstance.getDbname(), MY_SLOT);
                        boolean isDBCreated = applicationDeploymentClient.initializeDatabase(applicationInstanceUriId, paaSInstanceUriId, dbStorageComponentUriId, fileInputStream);

                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(!isDBCreated){
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        }
                    }
            });
    }
    
    
    @Override
    public void dumpDatabase(final Integer localAppId, final Integer paasId, final String dbName, final File file) {
        String successMessage = "Database dumped succesfully";
        String failureMessage = "Failed to dump the Database";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isApplicationsCacheValid());
                        Assert.isTrue(cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid());
                        String applicationInstanceUriId = cloud4SoaSessionDeveloper.getCachedApplicationId(localAppId);
                        if(applicationInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("appId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedApplicationProfiles().keySet());
                            return;
                        }
                        String paaSInstanceUriId = cloud4SoaSessionDeveloper.getCachedPaaSProfileId(paasId);
                        if(paaSInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("paasId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedPaaSProfiles().keySet());
                            return;
                        }
                        
                        if(file.isDirectory()){
                            this.displaySuccessMessage=false;
                            logger.severe("file parameter must not be a directory!");
                            return;
                        }
                        
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        
                        try {
                            UserPaaSCredentials userCredentialsForPaaS = userManagementAndSecurityModuleClient.readUserCredentialsForPaaS(cloud4SoaSessionDeveloper.getUserInstanceUriId(), paaSInstanceUriId);
                        } catch (SOAException e) {                                                 
                            this.displaySuccessMessage=false;
                            logger.severe("No stored Credentials for the specific PaaS");
                            Thread.currentThread().setContextClassLoader(originalCL);
                            return;
                        } 
                        
                        Thread.currentThread().setContextClassLoader(originalCL);
                        
                        //Check if the dbUri exists for the given application (profile)
                        ApplicationInstance cachedApplicationProfile = cloud4SoaSessionDeveloper.getCachedApplicationProfile(localAppId);
                        boolean found = false;
                        DBStorageComponentInstance dbStorageComponentInstance = null;
                        List<SoftwareComponentInstance> softwareComponents = cachedApplicationProfile.getSoftwareComponents();
                        String dbStorageComponentUriId = "";
                        for (SoftwareComponentInstance softwareComponentInstance : softwareComponents) {
                            logger.warning("softwareComponentInstance UriId:"+softwareComponentInstance.getUriId());
                            logger.warning("DBname:"+dbName);
                            if(softwareComponentInstance instanceof DBStorageComponentInstance){                                
                                if(((DBStorageComponentInstance)softwareComponentInstance).getDbname().equalsIgnoreCase(dbName)){
                                    dbStorageComponentInstance = (DBStorageComponentInstance)softwareComponentInstance;
                                    dbStorageComponentUriId = dbStorageComponentInstance.getUriId();
                                    logger.warning("found dbStorageComponent with uriId: "+dbStorageComponentUriId);
                                    break;
                                }
                            }
                        }
                        if(dbStorageComponentInstance == null){
                            this.displaySuccessMessage=false;
                            logger.severe("db parameter must be one of the DBStorageComponent specified inside the application profile");
                            return;
                        }

                        final InputStream fileInputStream;
                            
                        originalCL = Thread.currentThread().getContextClassLoader();
                        jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        flash(Level.FINE, "Dumping database: " + dbStorageComponentInstance.getDbname(), MY_SLOT);
                        
                        try {
                            fileInputStream = applicationDeploymentClient.dumpDatabase(applicationInstanceUriId, paaSInstanceUriId, dbStorageComponentUriId);
                        } catch (SOAException e) {
                            this.displaySuccessMessage = false;
                            logger.severe("Ploblem performing the db dump request: "+e.getMessage());
                            Thread.currentThread().setContextClassLoader(originalCL);
                            return;
                        }

                        Thread.currentThread().setContextClassLoader(originalCL);

                        FileUtils.copyInputStreamToFile(fileInputStream, file);
                        
                    }
            });
    }
    
    @Override
    public void showAllApplicationProfileDBs(final Integer localAppId) {
        String failureMessage = "DB retrival failed from the specific application profile";
            executeCommand(new Cloud4soaCommand(failureMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isApplicationsCacheValid());
                        ApplicationInstance applicationProfile = cloud4SoaSessionDeveloper.getCachedApplicationProfile(localAppId);
                        if(!cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid())
                            retrieveAllPaaSInstances();
                        
                        List<DBStorageComponentInstance> dbStorageComponentList = new ArrayList<DBStorageComponentInstance>();
                        List<SoftwareComponentInstance> softwareComponents = applicationProfile.getSoftwareComponents();
                        for (SoftwareComponentInstance softwareComponentInstance : softwareComponents) {
                            if(softwareComponentInstance instanceof DBStorageComponentInstance){
                                DBStorageComponentInstance dbStorageComponentInstance = (DBStorageComponentInstance)softwareComponentInstance;
                                dbStorageComponentList.add(dbStorageComponentInstance);
                            }
                        }
                        if(dbStorageComponentList.isEmpty()){
                            this.displaySuccessMessage=false;
                            logger.severe("The selected application profile has no db associated");
                            return;
                        }
                        
                        ShellTableRenderer table = new ShellTableRenderer("Application DBs", "Name", "Type", "Category", "User", "Password", "Deployment Location", "Url");
//                        Map<String, List<String>> dBdeploymentInfo = getDBdeploymentInfo(applicationProfile.getUriId());
                        for (DBStorageComponentInstance dbStorageComponentInstance : dbStorageComponentList) {
                            String dbType;
                            DBCategoryInstance relatedhwcategoryInstance = dbStorageComponentInstance.getRelatedhwcategoryInstance();
                            if(relatedhwcategoryInstance instanceof SqlDbCategoryInstance)
                                dbType = "SqlDB";
                            else if(relatedhwcategoryInstance instanceof NoSqlDbCategoryInstance)
                                dbType = "NoSqlDB"; 
                            else dbType = "N/S"; 
                            String deploymentLocationUriId = dbStorageComponentInstance.getDeploymentLocationUriId();
                            String deploymentLocation = "";
                            String deploymentUrl = "";
                            if(deploymentLocationUriId!=null && !deploymentLocationUriId.isEmpty()){
                                PaaSInstance deploymentLocationPaaSInstance = cloud4SoaSessionDeveloper.getCachedPaaSProfile(deploymentLocationUriId);
                                deploymentLocation = deploymentLocationPaaSInstance.getTitle();
                                deploymentUrl = dbStorageComponentInstance.getUrl();
                            }
                            table.addRow(dbStorageComponentInstance.getDbname(), dbType, relatedhwcategoryInstance.getTitle(), dbStorageComponentInstance.getDbuser(), dbStorageComponentInstance.getDbpassword(), deploymentLocation, deploymentUrl);
                        }
                        logger.info(table.getOutput());
                    }
            });
    }
    
    private Map<String, List<String>> getDBdeploymentInfo(String applicationProfileUriId) throws RuntimeException{
        String query = 
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
                + "PREFIX c4s-inf-m: <http://www.cloud4soa.eu/v0.1/infrastructural-domain#> "
                + "PREFIX dcterms: <http://purl.org/dc/terms/> "
                + "PREFIX essential-metamodel: <http://www.enterprise-architecture.org/essential-metamodel.owl#> "
                + "PREFIX c4s-app-m: <http://www.cloud4soa.eu/v0.1/application-domain#> "
                + "SELECT ?dbStorageComponentUriId ?paasOfferingUriId ?deploymentUrl WHERE "
                + "{ "
                + "essential-metamodel:"+applicationProfileUriId+" c4s-app-m:requiresSoftwareComponent ?dbStorageComponentUriId. "
                + "?dbStorageComponentUriId a c4s-inf-m:DBStorageComponent . "
                + "?dbStorageComponentUriId c4s-inf-m:hasDBdeployment ?deployment . "
                + "?deployment c4s-inf-m:DB_deployment_location ?paasOfferingUriId . "
                + "?deployment c4s-inf-m:hasUrl ?deploymentUrl . "
                + "}";

        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
        ClassLoader jaxrsExtCL = PaaSOfferingDiscoveryClient.class.getClassLoader();
        Thread.currentThread().setContextClassLoader(jaxrsExtCL);

        QueryResultTable resultTable = modelManagerClient.sparqlSelect(query);

        Thread.currentThread().setContextClassLoader(originalCL);

        if(resultTable == null){
            throw new RuntimeException("An error happens when querying the model");
        }
        if(resultTable.getResultingRows().isEmpty()){
            throw new RuntimeException("There is no DB resource to show");
        }
        Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
        for (Iterator<QueryResultRow> it = resultTable.iterator(); it.hasNext();) {
            QueryResultRow queryResultRow = it.next();
            String dbStorageComponentUriId = queryResultRow.getStringValue("dbStorageComponentUriId");
            String paasOfferingUriId = queryResultRow.getStringValue("paasOfferingUriId");
            String deploymentUrl = queryResultRow.getStringValue("deploymentUrl");
            List<String> deploymentInfo = new LinkedList<String>();
            deploymentInfo.add(paasOfferingUriId);
            deploymentInfo.add(deploymentUrl);
            map.put(dbStorageComponentUriId, deploymentInfo);
        }
        return map;
    }
    
//    private String removePrefix(Class classInstance, String stringWithPrefix){
//        String developerInstanceUri;
//        try {
//            developerInstanceUri = classInstance.getMethod("getUriId", new Class[0]).getAnnotation(RDFSubject.class).prefix();
//        } catch (NoSuchMethodException ex) {
//            logger.error(ex.getMessage());
//        } catch (SecurityException ex) {
//            logger.error(ex.getMessage());
//        }
//        String userUriIdWithoutPrefix = stringWithPrefix;
//        if(stringWithPrefix.toString().contains(developerInstanceUri.toString()))
//            userUriIdWithoutPrefix = stringWithPrefix.toString().replace(developerInstanceUri.toString(), "");
//        return userUriIdWithoutPrefix;
//    }
    
    /* PaaS User commands */

    @Override
    public boolean isLoggedAsPaaSUser() {
        return cloud4SoaSessionPaaSUser!=null;
    }

//    @Override
//    public void createAndStorePaaSProfile(final File file) {
//        String successMessage = "PaaS Profile stored";
//            String failureMessage = "Failed to store PaaS Profile";
//            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
//                    @Override
//                    public void execute() throws Exception {
//                        final InputStream fileInputStream = openFile(file);
//                        if(fileInputStream==null){
//                            logger.severe("Cannot open the file: "+file);
//                            this.displaySuccessMessage=false;
//                            logger.severe(this.failureMessage);
//                        }
//                            
//                        CloudProfilesParser cloudProfilesParser = getCloudProfilesParser(fileInputStream);
//                        PaaSInstance paasInstance = null;
//
//                        CoreDepthFirstVoidVisitor visitor = null;
//                        try {
//                            Scope scope = cloudProfilesParser.Scope();
//                            visitor = new CoreDepthFirstVoidVisitor();
//                            scope.accept(visitor);
//                        }
//                        catch (Exception e) {
//                            logger.severe("Parsing error : "+e);
//                            this.displaySuccessMessage=false;
//                            logger.severe(this.failureMessage);
//                        }
//                        if(visitor.getPaaSInstance() != null){
//                            paasInstance = visitor.getPaaSInstance();
//                            
//                            ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
//                            ClassLoader jaxrsExtCL = ModelManagerClient.class.getClassLoader();
//                            Thread.currentThread().setContextClassLoader(jaxrsExtCL);
//                            
//                            String paaSInstanceUriId = announcementModuleClient.storePaaSInstance(paasInstance, cloud4SoaSessionPaaSUser.getUserInstanceUriId());
//                            
//                            Thread.currentThread().setContextClassLoader(originalCL);
//                            
//                            if(paaSInstanceUriId == null){
//                                this.displaySuccessMessage=false;
//                                logger.severe(this.failureMessage);
//                            }
//                            else
//                                cloud4SoaSessionPaaSUser.invalidatePaaSProfilesCache();
//                        }
//                        else {
//                            logger.severe("No PaaS Profile is found!");
//                            logger.severe("Please check the file content");
//                            this.displaySuccessMessage=false;
//                            logger.severe(this.failureMessage);
//                        }
//                    }
//                    
//            });
//    }
    
    @Override
    public void createAndStorePaaSProfile(final File file){
            String successMessage = "PaaS Profile stored";
            String failureMessage = "Failed to store PaaS Profile";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        final InputStream fileInputStream = openFile(file);
                        if(fileInputStream==null){
                            logger.severe("Cannot open the file: "+file);
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        }
                            
                        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
                        StringBuilder sb = new StringBuilder();
                        String line = null;

                        while ((line = br.readLine()) != null) {
                            sb.append(line + "\n");
                        }
                        String paasProfile = new String(sb);
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ModelManagerClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);

                        String paasInstanceUriId = announcementModuleClient.storeTurtlePaaSProfile(paasProfile, cloud4SoaSessionPaaSUser.getUserInstanceUriId());

                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(paasInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        }
                        else
                            cloud4SoaSessionPaaSUser.invalidatePaaSProfilesCache();

                    }
                    
            });
    }

    @Override
    public void showAllOwnedPaaSProfiles() {
        String failureMessage = "PaaS Profiles retrival failed";
            executeCommand(new Cloud4soaCommand(failureMessage) {
                    @Override
                    public void execute() throws Exception {
                        if(!cloud4SoaSessionPaaSUser.isPaaSProfilesCacheValid()){
                            List<PaaSInstance> paaSProfiles;
                            ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                            ClassLoader jaxrsExtCL = PaaSOfferingDiscoveryClient.class.getClassLoader();
                            Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                            try {
                                paaSProfiles = paaSOfferingDiscoveryClient.getAllAvailablePaaSInstances();
                            } catch (SOAException ex) {
                                logger.log(Level.SEVERE, "{0}: {1}", new Object[]{failureMessage, ex.getMessage()});
                                this.displaySuccessMessage = false;
                                return;
                            }
                            Thread.currentThread().setContextClassLoader(originalCL);
                            String paaSProviderUriId = cloud4SoaSessionPaaSUser.getUserInstance().getPaaSProviderInstance().getUriId();
                            
                            List<PaaSInstance> ownedPaaSProfiles = new ArrayList<PaaSInstance>();
                            //filter PaaS profiles by PaaSUser Uri Id
                            for (PaaSInstance paaSInstance : paaSProfiles) {
                                if(paaSInstance.getPaaSProviderInstance().getUriId().equals(paaSProviderUriId))
                                    ownedPaaSProfiles.add(paaSInstance);
                            }
                            
                            cloud4SoaSessionPaaSUser.setCachedPaaSProfiles(ownedPaaSProfiles);
                        }
                        Map<Integer, PaaSInstance> cachedPaaSProfiles = cloud4SoaSessionPaaSUser.getCachedPaaSProfiles();
                        ShellTableRenderer table = new ShellTableRenderer("Available Profiles", "Offering Title", "Programming Language", "Programming Language Version");
                        for (PaaSInstance paaSInstance : cachedPaaSProfiles.values()) {
                            logger.fine("paaSInstance: "+paaSInstance);
                            table.addRow(paaSInstance.getTitle(), paaSInstance.getSupportedProgrammingLanguage(), paaSInstance.getSupportedProgrammingLanguageVersion());
                        }
                        logger.info(table.getOutput());
                    }
            });
    }

    
//    @Override
//    public void showPaaSProfileDetails(final Integer localId){
//        String failureMessage = "PaaS Profile Details retrival failed";
//            executeCommand(new Cloud4soaCommand(failureMessage) {
//                    @Override
//                    public void execute() throws Exception {
////                        Assert.isTrue(cloud4SoaSessionPaaSUser.isPaaSProfilesCacheValid() || cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid());
//                        if(cloud4SoaSessionPaaSUser!=null){
//                            PaaSInstance paasInstance = cloud4SoaSessionPaaSUser.getCachedPaaSProfile(localId);
//                            if(paasInstance != null){
//    //                            ShellTableRenderer table = new ShellTableRenderer("Application Profile Details", "ID", "Acronym", "Code", "Version");
//    //                            table.addRow(Integer.toString(localId), applicationInstance.getAcronym(), applicationInstance.getApplicationcode().toString(), applicationInstance.getVersion());
//    //                            logger.info(table.getOutput());
//                                PrinterVisitor pv = new PrinterVisitor();
//                                String paasRepresentation = pv.visit(paasInstance);
//                                logger.info(paasRepresentation);
//                            }
//                            else {
//                                logger.severe("id parameter must be one of the following: " + cloud4SoaSessionPaaSUser.getCachedPaaSProfiles().keySet());
//                                return;
//                            }
//                        }
//                        else if(cloud4SoaSessionDeveloper!=null){
//                            PaaSInstance paasInstance = cloud4SoaSessionDeveloper.getCachedPaaSProfile(localId);
//                            if(paasInstance != null){
//    //                            ShellTableRenderer table = new ShellTableRenderer("Application Profile Details", "ID", "Acronym", "Code", "Version");
//    //                            table.addRow(Integer.toString(localId), applicationInstance.getAcronym(), applicationInstance.getApplicationcode().toString(), applicationInstance.getVersion());
//    //                            logger.info(table.getOutput());
//                                PrinterVisitor pv = new PrinterVisitor();
//                                String paasRepresentation = pv.visit(paasInstance);
//                                logger.info(paasRepresentation);
//                            }
//                            else {
//                                logger.severe("id parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedPaaSProfiles().keySet());
//                                return;
//                            }
//                        }
//                    }
//            });
//    }

    @Override
    public void createApplicationProfileTemplate(final String fileName) {
        String failureMessage = "Application profile template generation failed";
            executeCommand(new Cloud4soaCommand(failureMessage) {
                    @Override
                    public void execute() throws Exception {
                        String applicationId = "Application123456";
                        String latencyUriId = "Latency123456";
                        String uptimeUriId = "Uptime123456";
                        String timeRangeUriId = "TimeRange123456";
                        String timeUnitMaxUriId = "MilliSecondMax1";
                        String timeUnitMinUriId = "MilliSecondMax2";
                        
                        
                        
                        ApplicationDescriptionGenerator applicationDescriptionGenerator = new ApplicationDescriptionGenerator();
                        try{
                            applicationDescriptionGenerator.setValue("applicationUriId", applicationId);
                            applicationDescriptionGenerator.setValue("latencyUriId", latencyUriId);
                            applicationDescriptionGenerator.setValue("uptimeUriId", uptimeUriId);
                            applicationDescriptionGenerator.setValue("timeRangeUriId", timeRangeUriId);
                            applicationDescriptionGenerator.setValue("timeUnitMaxUriId", timeUnitMaxUriId);
                            applicationDescriptionGenerator.setValue("timeUnitMinUriId", timeUnitMinUriId);
                            File file = new File(fileName);
                  
                            if(file.exists()){
                                logger.severe("Description file already exists!");
                                logger.severe("Please delete it or change the file name parameter");
                                this.displaySuccessMessage=false;
                                logger.severe(this.failureMessage);
                                return;
                            }

                            FileOutputStream fos = new FileOutputStream(file);
                            applicationDescriptionGenerator.evaluateTemplate(fos);
                        } catch(AssertionError exp){
                            logger.severe(exp.getMessage());
                        } catch(IllegalArgumentException exp){
                            logger.severe(exp.getMessage());
                        }
                    }
            });
    }

    @Override
    public boolean isCreateApplicationProfileTemplateAvailable() {
        return true;
    }
    
    
    @Override
    public void createDeveloperProfileTemplate(final String fileName) {
        String failureMessage = "User developer profile template generation failed";
            executeCommand(new Cloud4soaCommand(failureMessage) {
                    @Override
                    public void execute() throws Exception {
                        String developerId = "Developer123456";                      
                        
                        DeveloperDescriptionGenerator developerDescriptionGenerator = new DeveloperDescriptionGenerator();
                        try{
                            developerDescriptionGenerator.setValue("developerUriId", developerId);

                            File file = new File(fileName);
                  
                            if(file.exists()){
                                logger.severe("Description file already exists!");
                                logger.severe("Please delete it or change the file name parameter");
                                this.displaySuccessMessage=false;
                                logger.severe(this.failureMessage);
                                return;
                            }

                            FileOutputStream fos = new FileOutputStream(file);
                            developerDescriptionGenerator.evaluateTemplate(fos);
                        } catch(AssertionError exp){
                            logger.severe(exp.getMessage());
                        } catch(IllegalArgumentException exp){
                            logger.severe(exp.getMessage());
                        }
                    }
            });
    }

    @Override
    public boolean isCreateDeveloperProfileTemplateAvailable() {
        return true;
    }
    
    @Override
    public void createPaaSUserProfileTemplate(final String fileName) {
        String failureMessage = "User paas profile template generation failed";
            executeCommand(new Cloud4soaCommand(failureMessage) {
                    @Override
                    public void execute() throws Exception {
                        String paasUserId = "PaaSUser123456";                      
                        String paasProviderId = "PaaSProvider123456";          
                        String homepageId = "Document123456";          
                        
                        PaaSUserDescriptionGenerator paaSUserDescriptionGenerator = new PaaSUserDescriptionGenerator();
                        try{
                            paaSUserDescriptionGenerator.setValue("paasUserUriId", paasUserId);
                            paaSUserDescriptionGenerator.setValue("paasProviderUriId", paasProviderId);
                            paaSUserDescriptionGenerator.setValue("homepageUriId", homepageId);

                            File file = new File(fileName);
                  
                            if(file.exists()){
                                logger.severe("Description file already exists!");
                                logger.severe("Please delete it or change the file name parameter");
                                this.displaySuccessMessage=false;
                                logger.severe(this.failureMessage);
                                return;
                            }

                            FileOutputStream fos = new FileOutputStream(file);
                            paaSUserDescriptionGenerator.evaluateTemplate(fos);
                        } catch(AssertionError exp){
                            logger.severe(exp.getMessage());
                        } catch(IllegalArgumentException exp){
                            logger.severe(exp.getMessage());
                        }
                    }
            });
    }

    @Override
    public boolean isCreatePaaSUserProfileTemplateAvailable() {
        return true;
    }
    
    @Override
    public void createPaaSProfileTemplate(final String fileName) {
        String failureMessage = "PaaS offering profile template generation failed";
            executeCommand(new Cloud4soaCommand(failureMessage) {
                    @Override
                    public void execute() throws Exception {
                        String paasOfferingUriId = "PaaSOffering123456";
                        String latencyUriId = "Latency123456";
                        String uptimeUriId = "Uptime123456";
                        String timeRangeUriId = "TimeRange123456";
                        String timeUnitMaxUriId = "MilliSecondMax1";
                        String timeUnitMinUriId = "MilliSecondMin2";
                        
                        
                        
                        PaaSOfferingDescriptionGenerator paaSOfferingDescriptionGenerator = new PaaSOfferingDescriptionGenerator();
                        try{
                            paaSOfferingDescriptionGenerator.setValue("paasOfferingUriId", paasOfferingUriId);
                            paaSOfferingDescriptionGenerator.setValue("latencyUriId", latencyUriId);
                            paaSOfferingDescriptionGenerator.setValue("uptimeUriId", uptimeUriId);
                            paaSOfferingDescriptionGenerator.setValue("timeRangeUriId", timeRangeUriId);
                            paaSOfferingDescriptionGenerator.setValue("timeUnitMaxUriId", timeUnitMaxUriId);
                            paaSOfferingDescriptionGenerator.setValue("timeUnitMinUriId", timeUnitMinUriId);
                            File file = new File(fileName);
                  
                            if(file.exists()){
                                logger.severe("Description file already exists!");
                                logger.severe("Please delete it or change the file name parameter");
                                this.displaySuccessMessage=false;
                                logger.severe(this.failureMessage);
                                return;
                            }

                            FileOutputStream fos = new FileOutputStream(file);
                            paaSOfferingDescriptionGenerator.evaluateTemplate(fos);
                        } catch(AssertionError exp){
                            logger.severe(exp.getMessage());
                        } catch(IllegalArgumentException exp){
                            logger.severe(exp.getMessage());
                        }
                    }
            });
    }

    @Override
    public boolean isCreatePaaSProfileTemplateAvailable() {
        return true;
    }
    
    @Override
    public void showAvailableDBs() {
        String failureMessage = "List available DB resources failed";
            executeCommand(new Cloud4soaCommand(failureMessage) {
                    @Override
                    public void execute() throws Exception {
                        String query = 
                                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
                                + "PREFIX c4s-inf-m: <http://www.cloud4soa.eu/v0.1/infrastructural-domain#>"
                                + "PREFIX dcterms: <http://purl.org/dc/terms/>"
                                + "SELECT ?label ?object ?title ?description WHERE { "
                                + "{ c4s-inf-m:DB rdfs:label ?label . ?object rdf:type c4s-inf-m:DB . OPTIONAL { ?object dcterms:title ?title } . OPTIONAL { ?object dcterms:description ?description }} "
                                + "UNION "
                                + "{ c4s-inf-m:SQLDB rdfs:label ?label . ?object rdf:type c4s-inf-m:SQLDB . OPTIONAL { ?object dcterms:title ?title } . OPTIONAL { ?object dcterms:description ?description }} "
                                + "UNION "
                                + "{ c4s-inf-m:noSQLDB rdfs:label ?label . ?object rdf:type c4s-inf-m:noSQLDB . OPTIONAL { ?object dcterms:title ?title } . OPTIONAL { ?object dcterms:description ?description }} } ";

                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = PaaSOfferingDiscoveryClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);

                        QueryResultTable resultTable = modelManagerClient.sparqlSelect(query);

                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(resultTable == null){
                            logger.severe("An error happens when querying the model");
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                            return;
                        }
                        if(resultTable.getResultingRows().isEmpty()){
                            logger.info("There is no DB resource to show");
                            this.displaySuccessMessage=false;
                            return;
                        }
//                        ShellTableRenderer table = new ShellTableRenderer("DB Categories", "Id", "Type", "Title", "Description");
                        ShellTableRenderer table = new ShellTableRenderer("DB Categories", "Id", "Type", "Title");
                        for (Iterator<QueryResultRow> it = resultTable.iterator(); it.hasNext();) {
                            QueryResultRow queryResultRow = it.next();
                            String id = queryResultRow.getStringValue("object");
                            String label = queryResultRow.getStringValue("label");
                            String title = queryResultRow.getStringValue("title");
//                            String description = queryResultRow.getStringValue("description");
//                            table.addRow(id, label, title, description);
                            table.addRow(id, label, title);
                        }
                        logger.info(table.getOutput());
                    }
            });

    }
    
    @Override
    public void showAvailableProgrammingLanguages() {
        String failureMessage = "List available Programming Languages failed";
            executeCommand(new Cloud4soaCommand(failureMessage) {
                    @Override
                    public void execute() throws Exception {
                        String query = 
                                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
                                + "PREFIX other: <http://www.cloud4soa.eu/v0.1/other#>"
                                + "PREFIX dcterms: <http://purl.org/dc/terms/>"
                                + "SELECT ?object ?title ?version WHERE { ?object rdf:type other:ProgrammingLanguage . OPTIONAL { ?object dcterms:title ?title } . OPTIONAL { ?object dcterms:hasVersion ?version }}";
                        
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = PaaSOfferingDiscoveryClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        
                        QueryResultTable resultTable = modelManagerClient.sparqlSelect(query);

                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(resultTable == null){
                            logger.severe("An error happens when querying the model");
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                            return;
                        }
                        if(resultTable.getResultingRows().isEmpty()){
                            logger.info("There is no Programming Language resource to show");
                            this.displaySuccessMessage=false;
                            return;
                        }
                        ShellTableRenderer table = new ShellTableRenderer("Programming Languages", "id", "title", "version");
                        for (Iterator<QueryResultRow> it = resultTable.iterator(); it.hasNext();) {
                            QueryResultRow queryResultRow = it.next();
                            String id = queryResultRow.getStringValue("object");
                            String title = queryResultRow.getStringValue("title");
                            String version = queryResultRow.getStringValue("version");
                            table.addRow(id, title, version);
                        }
                        logger.info(table.getOutput());
                    }
            });

    }

    @Override
    public void showAvailableComputationals() {
        String failureMessage = "List available Computational categories failed";
            executeCommand(new Cloud4soaCommand(failureMessage) {
                    @Override
                    public void execute() throws Exception {
                        String query = 
                                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                                + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
                                + "PREFIX c4s-inf-m: <http://www.cloud4soa.eu/v0.1/infrastructural-domain#>"
                                + "PREFIX dcterms: <http://purl.org/dc/terms/>"
                                + "SELECT ?object ?title ?description WHERE { "
                                + "?object rdf:type c4s-inf-m:Computational_Category OPTIONAL { ?object dcterms:title ?title } . OPTIONAL { ?object dcterms:description ?description }} ";

                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = PaaSOfferingDiscoveryClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);

                        QueryResultTable resultTable = modelManagerClient.sparqlSelect(query);

                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(resultTable == null){
                            logger.severe("An error happens when querying the model");
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                            return;
                        }
                        if(resultTable.getResultingRows().isEmpty()){
                            logger.info("There is no Computational category resource to show");
                            this.displaySuccessMessage=false;
                            return;
                        }
//                        ShellTableRenderer table = new ShellTableRenderer("DB Categories", "Id", "Type", "Title", "Description");
                        ShellTableRenderer table = new ShellTableRenderer("Computational Categories", "Id", "Title", "Description");
                        for (Iterator<QueryResultRow> it = resultTable.iterator(); it.hasNext();) {
                            QueryResultRow queryResultRow = it.next();
                            String id = queryResultRow.getStringValue("object");
                            String title = queryResultRow.getStringValue("title");
                            String description = queryResultRow.getStringValue("description");
//                            table.addRow(id, label, title, description);
                            table.addRow(id, title, description);
                        }
                        logger.info(table.getOutput());
                    }
            });
    }

    @Override
    public void registerCredentials(final Integer paasId, final String publicKey, final String secretKey, final String accountName) {
        String successMessage = "Credentials registered";
        String failureMessage = "Failed to register the credentials";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid());
                        String paaSInstanceUriId = cloud4SoaSessionDeveloper.getCachedPaaSProfileId(paasId);
                        if(paaSInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("paasId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedPaaSProfiles().keySet());
                            return;
                        }
                        Assert.hasText(publicKey, "publicKey parameter has no text");    
                        Assert.hasText(secretKey, "secretKey parameter has no text");

                            
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        flash(Level.FINE, "Registering credentials", MY_SLOT);
                        boolean isCredentialRegistered = userManagementAndSecurityModuleClient.storeUserCredentialsForPaaS(cloud4SoaSessionDeveloper.getUserInstanceUriId(), paaSInstanceUriId, publicKey, secretKey, accountName);
                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(!isCredentialRegistered){
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        } 
                    }
            });
    }

    @Override
    public void showAllCredentials() {
        String failureMessage = "Show stored user credentials for paases failed";
            executeCommand(new Cloud4soaCommand(failureMessage) {
                    @Override
                    public void execute() throws Exception {
                        List<UserPaaSCredentials> allUserCredentialsForPaaS;
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = PaaSOfferingDiscoveryClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        try {
                            allUserCredentialsForPaaS = userManagementAndSecurityModuleClient.readAllUserCredentialsForPaaS(cloud4SoaSessionDeveloper.getUserInstanceUriId());
                        } catch (SOAException e) {
                            Thread.currentThread().setContextClassLoader(originalCL);
                            logger.info("Error: "+e.getMessage());
                            this.displaySuccessMessage=false;
                            return;
                        }
                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(!cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid())
                            retrieveAllPaaSInstances();
                        
                        ShellTableRenderer table = new ShellTableRenderer("Credentials", "PaaS", "PublicKey", "PrivateKey", "AccountName");
                        for (UserPaaSCredentials userPaaSCredentials : allUserCredentialsForPaaS) {
                            String paasId = userPaaSCredentials.getPaaSInstanceUriId();
                            PaaSInstance paaSInstance = cloud4SoaSessionDeveloper.getCachedPaaSProfile(paasId);
                            String paasTitle = paaSInstance.getTitle();
                            String publicKey = userPaaSCredentials.getPublicKey();
                            String secretKey = userPaaSCredentials.getSecretKey();
                            String accountName = userPaaSCredentials.getAccountName();
                            
                            table.addRow(paasTitle, publicKey, secretKey, accountName);
                        }
                        logger.info(table.getOutput());
                    }
            });
    }

    @Override
    public void showCredentials(final Integer paasId) {
        String failureMessage = "Show stored user credentials for paas failed";
            executeCommand(new Cloud4soaCommand(failureMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid());
                        String paaSProfileUriId = cloud4SoaSessionDeveloper.getCachedPaaSProfileId(paasId);
                        UserPaaSCredentials userPaaSCredentials;
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = PaaSOfferingDiscoveryClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        try {
                            userPaaSCredentials = userManagementAndSecurityModuleClient.readUserCredentialsForPaaS(cloud4SoaSessionDeveloper.getUserInstanceUriId(), paaSProfileUriId);
                        } catch (SOAException e) {
                            Thread.currentThread().setContextClassLoader(originalCL);
                            logger.info("Error: "+e.getMessage());
                            this.displaySuccessMessage=false;
                            return;
                        }
                        Thread.currentThread().setContextClassLoader(originalCL);
                       
                        ShellTableRenderer table = new ShellTableRenderer("Credentials", "PaaS", "PublicKey", "PrivateKey", "AccountName");

                        String paasId = userPaaSCredentials.getPaaSInstanceUriId();
                        PaaSInstance paaSInstance = cloud4SoaSessionDeveloper.getCachedPaaSProfile(paasId);
                        String paasTitle = paaSInstance.getTitle();
                        String publicKey = userPaaSCredentials.getPublicKey();
                        String secretKey = userPaaSCredentials.getSecretKey();
                        String accountName = userPaaSCredentials.getAccountName();
                        
                        table.addRow(paasTitle, publicKey, secretKey, accountName);
                        
                        logger.info(table.getOutput());
                    }
            });
    }

    @Override
    public void updateCredentials(final Integer paasId, final String publicKey, final String secretKey, final String accountName) {
        String successMessage = "Credentials updated";
        String failureMessage = "Failed to update the credentials";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid());
                        String paaSInstanceUriId = cloud4SoaSessionDeveloper.getCachedPaaSProfileId(paasId);
                        if(paaSInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("paasId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedPaaSProfiles().keySet());
                            return;
                        }
                        Assert.hasText(publicKey, "publicKey parameter has no text");    
                        Assert.hasText(secretKey, "secretKey parameter has no text");

                            
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        flash(Level.FINE, "Updating credentials", MY_SLOT);
                        boolean isCredentialRegistered = userManagementAndSecurityModuleClient.updateUserCredentialsForPaaS(cloud4SoaSessionDeveloper.getUserInstanceUriId(), paaSInstanceUriId, publicKey, secretKey, accountName);
                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(!isCredentialRegistered){
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        } 
                    }
            });
    }

    @Override
    public void removeUserCredentials(final Integer paasId) {
        String successMessage = "Credentials removed";
        String failureMessage = "Failed to remove the credentials";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid());
                        String paaSInstanceUriId = cloud4SoaSessionDeveloper.getCachedPaaSProfileId(paasId);
                        if(paaSInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("paasId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedPaaSProfiles().keySet());
                            return;
                        }
                            
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        flash(Level.FINE, "Removing credentials", MY_SLOT);
                        boolean isCredentialRemoved = userManagementAndSecurityModuleClient.removeUserCredentialsForPaaS(cloud4SoaSessionDeveloper.getUserInstanceUriId(), paaSInstanceUriId);
                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(!isCredentialRemoved){
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        } 
                    }
            });
    }

    @Override
    public void migrateApplication(final int localAppId, final int paasId, final File file) {
        String successMessage = "Application migrated";
        String failureMessage = "Failed to migrate the Application";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isDeployedApplicationsCacheValid());
                        Assert.isTrue(cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid());
                        String applicationInstanceUriId = cloud4SoaSessionDeveloper.getCachedDeployedApplicationId(localAppId);
                        if(applicationInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("appId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedDeployedApplications().keySet());
                            return;
                        }
                        String paaSInstanceUriId = cloud4SoaSessionDeveloper.getCachedPaaSProfileId(paasId);
                        if(paaSInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("paasId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedPaaSProfiles().keySet());
                            return;
                        }
                        
                        String paaSProfileUriId = cloud4SoaSessionDeveloper.getCachedPaaSProfileId(paasId);
                        UserPaaSCredentials userPaaSCredentials;
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = PaaSOfferingDiscoveryClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        try {
                            userPaaSCredentials = userManagementAndSecurityModuleClient.readUserCredentialsForPaaS(cloud4SoaSessionDeveloper.getUserInstanceUriId(), paaSProfileUriId);
                        } catch (SOAException e) {
                            Thread.currentThread().setContextClassLoader(originalCL);
                            logger.info("Error: "+e.getMessage());
                            this.displaySuccessMessage=false;
                            return;
                        }
                        Thread.currentThread().setContextClassLoader(originalCL);
                        
                        final InputStream fileInputStream = openFile(file);
                        if(fileInputStream==null){
                            logger.severe("Cannot open the file: "+file);
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                            return;
                        }
                            
                        originalCL = Thread.currentThread().getContextClassLoader();
                        jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        flash(Level.FINE, "Migrating application: " + cloud4SoaSessionDeveloper.getCachedDeployedApplication(localAppId).getTitle(), MY_SLOT);
                        
                        boolean isApplicationMigrated ;
                        
                        try {
                            isApplicationMigrated = applicationMigrationClient.migrateApplication(applicationInstanceUriId, paaSProfileUriId, fileInputStream);
                        } catch (SOAException e) {
                            Thread.currentThread().setContextClassLoader(originalCL);
                            logger.info("Error: " + e.getMessage());
                            this.displaySuccessMessage = false;
                            logger.severe(this.failureMessage);
                            return;
                        }
                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(!isApplicationMigrated){
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        } 
                        else{                          
                            cloud4SoaSessionDeveloper.invalidateApplicationsCache();
                            cloud4SoaSessionDeveloper.invalidateDeployedApplications();
                        }
                    }
            });
    }

    @Override
    public void migrateDBs(final int localAppId, final int paasId) {
        String successMessage = "Databases migrated for Application: "+localAppId;
        String failureMessage = "Failed to migrate Databases for the Application"+localAppId;
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isDeployedApplicationsCacheValid());
                        Assert.isTrue(cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid());
                        String applicationInstanceUriId = cloud4SoaSessionDeveloper.getCachedDeployedApplicationId(localAppId);
                        if(applicationInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("appId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedDeployedApplications().keySet());
                            return;
                        }
                        String paaSInstanceUriId = cloud4SoaSessionDeveloper.getCachedPaaSProfileId(paasId);
                        if(paaSInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("paasId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedPaaSProfiles().keySet());
                            return;
                        }
                        
                        String paaSProfileUriId = cloud4SoaSessionDeveloper.getCachedPaaSProfileId(paasId);
                        UserPaaSCredentials userPaaSCredentials;
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = PaaSOfferingDiscoveryClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        try {
                            userPaaSCredentials = userManagementAndSecurityModuleClient.readUserCredentialsForPaaS(cloud4SoaSessionDeveloper.getUserInstanceUriId(), paaSProfileUriId);
                        } catch (SOAException e) {
                            Thread.currentThread().setContextClassLoader(originalCL);
                            logger.info("Error: "+e.getMessage());
                            this.displaySuccessMessage=false;
                            return;
                        }
                        Thread.currentThread().setContextClassLoader(originalCL);
                            
                        originalCL = Thread.currentThread().getContextClassLoader();
                        jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        flash(Level.FINE, "Migrating databases: " + cloud4SoaSessionDeveloper.getCachedDeployedApplication(localAppId).getTitle(), MY_SLOT);
                        
                        boolean areDBsMigrated ;
                        
                        try {
                            areDBsMigrated = applicationMigrationClient.migrateDatabases(applicationInstanceUriId, paaSInstanceUriId);
                        } catch (SOAException e) {
                            Thread.currentThread().setContextClassLoader(originalCL);
                            logger.info("Error: " + e.getMessage());
                            this.displaySuccessMessage = false;
                            logger.severe(this.failureMessage);
                            return;
                        }
                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(!areDBsMigrated){
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        } 
                        else{                          
                            cloud4SoaSessionDeveloper.invalidateApplicationsCache();
                            cloud4SoaSessionDeveloper.invalidateDeployedApplications();
                            try {
                                retrieveAllApplicationProfile();
                                showAllApplicationProfileDBs(localAppId);
                            } catch (SOAException ex) {
                                    logger.log(Level.SEVERE, "{0}: {1}", new Object[]{failureMessage, ex.getMessage()});
                                    this.displaySuccessMessage = false;
                                    return;
                            }                            
                        }                       
                    }
            });                       
    }

    @Override
    public void commitMigration(final int localAppId) {
        String successMessage = "Migration changes committed";
        String failureMessage = "Failed to commit migration changes for the Application";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isDeployedApplicationsCacheValid());
                        Assert.isTrue(cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid());
                        String applicationInstanceUriId = cloud4SoaSessionDeveloper.getCachedDeployedApplicationId(localAppId);
                        if(applicationInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("appId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedDeployedApplications().keySet());
                            return;
                        }
                            
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        flash(Level.FINE, "Committing migration changes for application: " + cloud4SoaSessionDeveloper.getCachedDeployedApplication(localAppId).getTitle(), MY_SLOT);
                        boolean isMigrationChangesCommitted;
                        try {
                            isMigrationChangesCommitted = applicationMigrationClient.commitMigration(applicationInstanceUriId);                            
                        } catch (SOAException e) {
                            Thread.currentThread().setContextClassLoader(originalCL);
                            logger.info("Error: "+e.getMessage());
                            this.displaySuccessMessage=false;
                            return;
                        }
                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(!isMigrationChangesCommitted){
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        } 
                        else{                          
                            cloud4SoaSessionDeveloper.invalidateApplicationsCache();
                            cloud4SoaSessionDeveloper.invalidateDeployedApplications();
                        }
                    }
            });
    }

    @Override
    public void rollbackMigration(final int localAppId) {
        String successMessage = "Migration changes rollback succesfully";
        String failureMessage = "Failed to rollback migration changes for the Application";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        Assert.isTrue(cloud4SoaSessionDeveloper.isDeployedApplicationsCacheValid());
                        Assert.isTrue(cloud4SoaSessionDeveloper.isPaaSProfilesCacheValid());
                        String applicationInstanceUriId = cloud4SoaSessionDeveloper.getCachedDeployedApplicationId(localAppId);
                        if(applicationInstanceUriId == null){
                            this.displaySuccessMessage=false;
                            logger.severe("appId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedDeployedApplications().keySet());
                            return;
                        }
                            
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        flash(Level.FINE, "Doing rollback migration changes for application: " + cloud4SoaSessionDeveloper.getCachedDeployedApplication(localAppId).getTitle(), MY_SLOT);
                        boolean isMigrationChangesCommitted;
                        try {
                            isMigrationChangesCommitted = applicationMigrationClient.rollbackMigration(applicationInstanceUriId);                            
                        } catch (SOAException e) {
                            Thread.currentThread().setContextClassLoader(originalCL);
                            logger.info("Error: "+e.getMessage());
                            this.displaySuccessMessage=false;
                            return;
                        }
                        Thread.currentThread().setContextClassLoader(originalCL);

                        if(!isMigrationChangesCommitted){
                            this.displaySuccessMessage=false;
                            logger.severe(this.failureMessage);
                        } 
                        else{                          
                            cloud4SoaSessionDeveloper.invalidateApplicationsCache();
                            cloud4SoaSessionDeveloper.invalidateDeployedApplications();
                        }
                    }
            });
    }

        
    @Override
    public void getC4SOAPublicKey() {
        String successMessage = "Cloud4soa public key retrieved succesfully";
        String failureMessage = "Impossible to retrieve cloud4soa public key";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                            
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        flash(Level.FINE, "Retrieving the cloud4soa public key", MY_SLOT);
                        try {
                            String c4SOAPublicKey = applicationDeploymentClient.getC4SOAPublicKey();
                            logger.info(c4SOAPublicKey);
                        } catch (SOAException e) {
                            Thread.currentThread().setContextClassLoader(originalCL);
                            logger.info("Error: "+e.getMessage());
                            this.displaySuccessMessage=false;
                            return;
                        }
                        Thread.currentThread().setContextClassLoader(originalCL);

                    }
            });
        }

        @Override
        public void registerPublicKeyForUser() {
            String successMessage = "User public key registered succesfully";
            String failureMessage = "Impossible to register user public key";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        String sshKeyFileAbsolutePath=System.getProperty("user.home")+File.separator+".ssh"+File.separator+"id_rsa.pub";           
                        String rsa_key_value = FileUtils.readFileToString(new File(sshKeyFileAbsolutePath));
                        
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        flash(Level.FINE, "Registering user public key", MY_SLOT);
                        try {
                            applicationDeploymentClient.registerPublicKeyForUser(cloud4SoaSessionDeveloper.getUserInstanceUriId(), rsa_key_value);
                        } catch (SOAException e) {
                            Thread.currentThread().setContextClassLoader(originalCL);
                            logger.info("Error: "+e.getMessage());
                            this.displaySuccessMessage=false;
                            return;
                        }
                        Thread.currentThread().setContextClassLoader(originalCL);

                    }
            });
        }

        @Override
        public void getPublicKeysForUser() {
            String successMessage = "User public keys retrieved succesfully";
            String failureMessage = "Impossible to retrieve user public keys";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                        List<String> publicKeysForUser;
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        flash(Level.FINE, "Retrieving the user public keys", MY_SLOT);
                        try {
                            publicKeysForUser = applicationDeploymentClient.getPublicKeysForUser(cloud4SoaSessionDeveloper.getUserInstanceUriId());
                        } catch (SOAException e) {
                            Thread.currentThread().setContextClassLoader(originalCL);
                            logger.info("Error: "+e.getMessage());
                            this.displaySuccessMessage=false;
                            return;
                        }
                        Thread.currentThread().setContextClassLoader(originalCL);
                        
                        ShellTableRenderer table = new ShellTableRenderer("Public keys", "Key");
                        for (String publicKey : publicKeysForUser) {            
                            table.addRow(publicKey);
                        }
                        logger.info(table.getOutput());

                    }
            });
        }

        @Override
        public void deletePublicKeyFromUser(final String publicKey) {
            String successMessage = "User public key deleted succesfully";
            String failureMessage = "Impossible to delete user public key";
            executeCommand(new Cloud4soaCommand(failureMessage, successMessage) {
                    @Override
                    public void execute() throws Exception {
                            
                        ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
                        ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                        flash(Level.FINE, "Deleting user public key", MY_SLOT);
                        try {
                            applicationDeploymentClient.deletePublicKeyFromUser(cloud4SoaSessionDeveloper.getUserInstanceUriId(), publicKey);
                        } catch (SOAException e) {
                            Thread.currentThread().setContextClassLoader(originalCL);
                            logger.info("Error: "+e.getMessage());
                            this.displaySuccessMessage=false;
                            return;
                        }
                        Thread.currentThread().setContextClassLoader(originalCL);

                    }
            });
        }


        @Override
        public void deleteRepo(String repoId) {
            Cloud4soaCommand command;
            String userUriId;

            userUriId = cloud4SoaSessionDeveloper.getUserInstance().getAccountname();
            command   = new DeleteRepoCommand(userUriId, repoId);
            try {

                this.setContextAndExecuteCommand( command );       
                this.isGitRepoCreated   = false;

            } catch(Exception e) {
                 slf4jLogger.error( "Error in createGitRepo", e);
            }

        }



        @Override
        public void getRepos() {
            Cloud4soaCommand command;
            String userUriId;

            userUriId = cloud4SoaSessionDeveloper.getUserInstance().getAccountname();
            command   = new GetReposCommand(userUriId);
            try {

                this.setContextAndExecuteCommand( command );       
                this.isGitRepoCreated   = false;
                this.hasReposShowed     = true;

            } catch(Exception e) {
                 slf4jLogger.error( "Error in createGitRepo", e);
            }

        }

        @Override
        public void registerExistingGitRepo(int paasId, String repoName, String gitUri) {
            Cloud4soaCommand command;
            String userUriId;

            userUriId = cloud4SoaSessionDeveloper.getUserInstance().getAccountname();

            command   = new GetReposCommand(userUriId);
            try {

                this.setContextAndExecuteCommand( command );       


            } catch(Exception e) {
                 slf4jLogger.error( "Error in createGitRepo", e);
            }

        }

        @Override
        public void relocateRepo(int newPaasUriId) {
            throw new UnsupportedOperationException("Not supported yet.");
        }



        @Override
        public void gitPush(Integer localAppId, Integer paasId, File repoPath,  String passphrase) {
            
            String applicationInstanceUriId = cloud4SoaSessionDeveloper.getCachedApplicationId(localAppId);
            if (applicationInstanceUriId == null) {
                logger.severe("appId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedApplicationProfiles().keySet());
                return;
            }
            String paaSInstanceUriId = cloud4SoaSessionDeveloper.getCachedPaaSProfileId(paasId);
            if (paaSInstanceUriId == null) {
                logger.severe("paasId parameter must be one of the following: " + cloud4SoaSessionDeveloper.getCachedPaaSProfiles().keySet());
                return;
            }

            if (!repoPath.isDirectory()) {
                logger.severe("The parameter localPath need to be a directory!");
                return;
            }
            
            String sshPubKeyFileAbsolutePath=System.getProperty("user.home")+File.separator+".ssh"+File.separator+"id_rsa.pub";           
            String sshPrivKeyFileAbsolutePath=System.getProperty("user.home")+File.separator+".ssh"+File.separator+"id_rsa";           
            try {
                registerPubKeyIfNeeded(sshPubKeyFileAbsolutePath);
            } catch (IOException ex) {
                logger.severe("Error in reading the public key from the file: "+sshPubKeyFileAbsolutePath);
                return;
            } catch (SOAException ex) {
                logger.info("Error: " + ex.getMessage());
                return;
            }
                    
            String repoAbsolutePath = repoPath.getAbsolutePath();           

                       
            String userInstanceUriId = cloud4SoaSessionDeveloper.getUserInstance().getUriId();

            /*
             * createGitRepo: This method will create the real repository at the PaaS side and will return the GIT_URL and GIT_REPO_NAME. 
             * These two strings will be used by the method registerRepo
             */
            GitRepoInfo gitRepoInfo = null;
            try {
                gitRepoInfo = initializeGitProxy(userInstanceUriId, paaSInstanceUriId, applicationInstanceUriId);
            } catch (Exception ex) {
                logger.severe("Error: "+ex.getMessage());
                return;
            }

            String repoName = gitRepoInfo.getRepositoryName();
            String gitUrl = gitRepoInfo.getUrl();
            String userId = gitRepoInfo.getUserId();
            String baseGitProxyUrl = System.getProperty(baseGitProxyUrlKey);
            
            String applicationName = cloud4SoaSessionDeveloper.getCachedApplicationProfile(localAppId).getTitle().replaceAll(" ", "").trim().toLowerCase();
            String proxyName = "proxy" + userId + applicationName;
            String gitProxyUrl = "cloud"+"@"+baseGitProxyUrl+":"+proxyName;
            GitManager gitManager = new GitManager(gitProxyUrl, "cloud4soa", repoAbsolutePath, sshPrivKeyFileAbsolutePath, passphrase);
            
            
            try {
                logger.info("Git init() ");
                gitManager.init();  
                logger.info("Git setConfig() ");
                gitManager.setConfig();
                logger.info("Git testStatus() ");
                gitManager.testStatus();
                try{
                    logger.info("Git pull() ");
                    gitManager.pull();
                }catch (Exception pulex){ logger.info("First time push @ Heroku"); }
                logger.info("Git removeAll() ");
                gitManager.removeAll();
                logger.info("Git addAll() ");
                gitManager.addAll();
                logger.info("Git commit() ");
                gitManager.commit();
            
                try {
                    gitManager.push();
                    logger.info("Git Push performed succesfully");
                    
                    commitGitDeploy(userInstanceUriId, paaSInstanceUriId, applicationInstanceUriId);

                } catch(TransportException e) {
                    logger.severe("Impossible to communicate with the cloud4soa proxy - cause: "+e.getMessage());
                    return;
                } catch (InvalidRemoteException ex){
                    logger.severe("Git command error Remote - cause: "+ex.getMessage());
                } catch (GitAPIException ex) {
                    logger.severe("Git command error - cause: "+ex.getMessage());
                } 
                
            } catch (Exception ex) {
                logger.severe("Error in performing a git command - cause: "+ex.getMessage());
                return;
            }
        }
        
        private void commitGitDeploy(String userInstanceUriId, String paaSInstanceUriId, String applicationInstanceUriId){
            logger.info("Committing the Git deploy");

            ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
            ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
            Thread.currentThread().setContextClassLoader(jaxrsExtCL);
            flash(Level.FINE, "Retrieving the user public keys", MY_SLOT);
            try {
                applicationDeploymentClient.commitGitDeploy(userInstanceUriId, paaSInstanceUriId, applicationInstanceUriId);
                logger.info("Git deploy committed");
            } catch (SOAException e) {
                Thread.currentThread().setContextClassLoader(originalCL);
                logger.severe("Error in committing the git deploy - cause: " + e.getMessage());
            }
            Thread.currentThread().setContextClassLoader(originalCL);

        }
        
        private void registerPubKeyIfNeeded(String sshKeyFileAbsolutePath) throws IOException, SOAException{
            List<String> publicKeysForUser;
            ClassLoader originalCL = Thread.currentThread().getContextClassLoader();
            ClassLoader jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
            Thread.currentThread().setContextClassLoader(jaxrsExtCL);
            flash(Level.FINE, "Retrieving the user public keys", MY_SLOT);
            try {
                publicKeysForUser = applicationDeploymentClient.getPublicKeysForUser(cloud4SoaSessionDeveloper.getUserInstanceUriId());
            } catch (SOAException e) {
                Thread.currentThread().setContextClassLoader(originalCL);
                throw e;
            }
            Thread.currentThread().setContextClassLoader(originalCL);

            String rsa_key_value = FileUtils.readFileToString(new File(sshKeyFileAbsolutePath));

            if (!publicKeysForUser.contains(rsa_key_value)) {
                originalCL = Thread.currentThread().getContextClassLoader();
                jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
                Thread.currentThread().setContextClassLoader(jaxrsExtCL);
                flash(Level.FINE, "Registering user public key", MY_SLOT);
                try {
                    applicationDeploymentClient.registerPublicKeyForUser(cloud4SoaSessionDeveloper.getUserInstanceUriId(), rsa_key_value);
                } catch (SOAException e) {
                    Thread.currentThread().setContextClassLoader(originalCL);
                    throw e;
                }
                Thread.currentThread().setContextClassLoader(originalCL);
            }
                
        }
        
        private GitRepoInfo initializeGitProxy(String userInstanceUriId, String paaSInstanceUriId, String applicationInstanceUriId) throws Exception{
            Cloud4soaCommand command;

            command   = new InitializeGitProxyCommand(userInstanceUriId, paaSInstanceUriId, applicationInstanceUriId);

            this.setContextAndExecuteCommand( command );
            
            return ((InitializeGitProxyCommand)command).getGitRepoInfo();

        }
    
/*    private abstract class Cloud4soaCommand {
            protected String failureMessage = "";
            protected String successMessage = "";
            protected String gerund;
            protected boolean displaySuccessMessage = true;

            protected Cloud4soaCommand(final String failureMessage, final String successMessage, final String gerund) {
                    this.failureMessage = failureMessage;
                    this.successMessage = successMessage;
                    this.gerund = gerund;
            }

            protected Cloud4soaCommand(final String failureMessage, final String successMessage) {
                    this(failureMessage, successMessage, "Performing operation");
            }

            protected Cloud4soaCommand(final String failureMessage) {
                    this(failureMessage, null);
            }

            public abstract void execute() throws Exception;

            public String getFailureMessage() {
                    return failureMessage;
            }

            public String getSuccessMessage() {
                    return successMessage;
            }

            public String getGerund() {
                    return gerund;
            }

            public boolean isDisplaySuccessMessage() {
                    return displaySuccessMessage;
            }
    }
     * 
     */
    
    
    protected void setContextAndExecuteCommand( final Cloud4soaCommand command) {
        ClassLoader originalCL;
        ClassLoader jaxrsExtCL;
        
        originalCL = Thread.currentThread().getContextClassLoader();
        jaxrsExtCL = ApplicationDeploymentClient.class.getClassLoader();
        Thread.currentThread().setContextClassLoader(jaxrsExtCL);
        try {
            printFlashingMessage(command);
            this.executeCommand(command);
        } finally {
            Thread.currentThread().setContextClassLoader(originalCL);
        }
        
    }
    
    
    protected void printFlashingMessage( Cloud4soaCommand command )  {
        String commandName;
        
        commandName = command.getClass().getName();
        flash(Level.FINE, "Executing command " + commandName, MY_SLOT);
    }
    

    
    private void executeCommand(final Cloud4soaCommand command) {
            Timer timer = new Timer();
            try {
                    final char[] statusIndicators = new char[]{'|', '/', '-', '\\'};
                    final int[] statusCount = new int[]{0};
                    TimerTask timerTask = new TimerTask() {
                            @Override
                            public void run() {
                                    flash(Level.FINE, command.getGerund() + " " + statusIndicators[statusCount[0]], MY_SLOT);
                                    if (statusCount[0] < statusIndicators.length - 1) {
                                            statusCount[0] = statusCount[0] + 1;
                                    } else {
                                            statusCount[0] = 0;
                                    }
                            }
                    };
                    timer.scheduleAtFixedRate(timerTask, 0, 100);
                    command.execute();
                    if (StringUtils.hasText(command.getSuccessMessage()) && command.isDisplaySuccessMessage()) {
                            logger.info(command.getSuccessMessage());
                    }
            } catch (Exception e) {
                    throw new IllegalStateException(command.getFailureMessage() + " - " + e.getMessage(), e);
            } finally {
                    timer.cancel();
                    flash(Level.FINE, "Complete!", MY_SLOT);
                    flash(Level.FINE, "", MY_SLOT);
            }
    }
}