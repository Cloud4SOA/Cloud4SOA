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

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;
import org.springframework.roo.shell.CliAvailabilityIndicator;
import org.springframework.roo.shell.CliCommand;
import org.springframework.roo.shell.CliOption;
import org.springframework.roo.shell.CommandMarker;
import org.springframework.roo.shell.converters.StaticFieldConverter;

/**
 * Example of a command class. The command class is registered by the Roo shell following an
 * automatic classpath scan. You can provide simple user presentation-related logic in this
 * class. You can return any objects from each method, or use the logger directly if you'd
 * like to emit messages of different severity (and therefore different colors on 
 * non-Windows systems).
 * 
 * @since 1.1.1
 */
@Component // Use these Apache Felix annotations to register your commands class in the Roo container
@Service
public class Cloud4soaCommands implements CommandMarker { // All command types must implement the CommandMarker interface
	
	/**
	 * Get hold of a JDK Logger
	 */
	private Logger log = Logger.getLogger(getClass().getName());

	/**
	 * Get a reference to the AddonOperations from the underlying OSGi container
	 */
	@Reference private Cloud4soaOperations cloud4soaOperations; 
	
	/**
	 * Get a reference to the StaticFieldConverter from the underlying OSGi container;
	 * this is useful for 'type save' command tab completions in the Roo shell
	 */
//	@Reference private StaticFieldConverter staticFieldConverter;

	/**
	 * The activate method for this OSGi component, this will be called by the OSGi container upon bundle activation 
	 * (result of the 'addon install' command) 
	 * 
	 * @param context the component context can be used to get access to the OSGi container (ie find out if certain bundles are active)
	 */
	protected void activate(ComponentContext context) {
//	    staticFieldConverter.add(Cloud4soaPropertyName.class);
    }

	/**
	 * The deactivate method for this OSGi component, this will be called by the OSGi container upon bundle deactivation 
	 * (result of the 'addon remove' command) 
	 * 
	 * @param context the component context can be used to get access to the OSGi container (ie find out if certain bundles are active)
	 */
	protected void deactivate(ComponentContext context) {
//		staticFieldConverter.remove(Cloud4soaPropertyName.class);ù
	}

	/**
	 * This method is optional. It allows automatic command hiding in situations when the command should not be visible.
         * 
	 * @return true (default) if the command should be visible at this stage, false otherwise
	 */
	@CliAvailabilityIndicator("cloud4soa url")
	public boolean isGetRestUrlAvailable() {
		return true; // This command is always available!
	}
	
	/**
	 * This method show the cloud4soa url
	 */
        @CliCommand(value = "cloud4soa url show", help = "Prints the cloud4soa url")
	public void getRestUrl(){
                log.log(Level.SEVERE, "cloud4soa url: "+ cloud4soaOperations.getProperty("cloud4soa.baseUrl"));
	}
        
        /**
	 * This method modify the cloud4soa url
	 */
        @CliCommand(value = "cloud4soa url set", help = "Modify the cloud4soa url")
	public void setRestUrl(@CliOption(key = "url", mandatory = true, help = "The url") final String url){
                log.log(Level.SEVERE, "Old cloud4soa url: "+ cloud4soaOperations.getProperty("cloud4soa.baseUrl"));
                cloud4soaOperations.setProperty("cloud4soa.baseUrl", url);
                log.log(Level.INFO, "Cloud4soa url modified: "+ url);
	}
        
                /**
	 * This method modify the cloud4soa git proxy url
	 */
        @CliCommand(value = "cloud4soa git proxy set", help = "Modify the cloud4soa git proxy url")
	public void setGitProxyUrl(@CliOption(key = "url", mandatory = true, help = "The url") final String url){
                log.log(Level.SEVERE, "Old cloud4soa git proxy url: "+ cloud4soaOperations.getProperty("cloud4soa.gitProxyUrlKey"));
                cloud4soaOperations.setProperty("cloud4soa.gitProxyUrlKey", url);
                log.log(Level.INFO, "Cloud4soa git proxy url modified: "+ url);
	}
	
        @CliCommand(value = "cloud4soa login", help = "Login")
	public void login(
		@CliOption(key = "username", mandatory = true, help = "The username") final String username,
		@CliOption(key = "password", mandatory = true, help = "The user's password") final String password) {
		cloud4soaOperations.login(username, password);
	}
        
        @CliCommand(value = "cloud4soa logout", help = "Logout")
	public void logout() {
		cloud4soaOperations.logout();
	}
        
        @CliAvailabilityIndicator("cloud4soa logout")
	public boolean isLogged() {
		return cloud4soaOperations.isLogged(); // This command is available only if the user is logged!
	}
        
        @CliAvailabilityIndicator("cloud4soa git proxy set")
	public boolean isProxySetAvailable() {
		return cloud4soaOperations.isLogged(); // This command is available only if the user is logged!
	}
        
        @CliAvailabilityIndicator({"cloud4soa login", "cloud4soa register", "cloud4soa url set"})
	public boolean isLoginAvailable() {
		return !cloud4soaOperations.isLogged(); // This command is available only if the user is not logged yet!
	}
             
//        @CliCommand(value = "cloud4soa register", help = "Register a new cloud4soa account")
//	public void register(
//		@CliOption(key = "file", mandatory = true, help = "A file that contains the user profile") final File file){
//		cloud4soaOperations.register(file);
//	}
        
        @CliCommand(value = "cloud4soa register", help = "Register a new cloud4soa user profile and account")
	public void register(
		@CliOption(key = "file", mandatory = true, help = "A file that contains the user profile") final File file, 
                @CliOption(key = "username", mandatory = true, help = "The cloud4soa username to be linked to the user profile") final String username, 
                @CliOption(key = "password", mandatory = true, help = "The cloud4soa user password") final String password){
		cloud4soaOperations.registerUserProfile(file, username, password);
	}
        
        /* Developer commands */
        
        @CliCommand(value = "cloud4soa show application profiles", help = "Show all application profiles stored by the user")
	public void showApplicationProfiles() {
		cloud4soaOperations.showApplicationProfiles();
	}
        
        @CliAvailabilityIndicator({"cloud4soa show application profiles", "cloud4soa create application profile", "cloud4soa show deployed applications"})
	public boolean isDeveloperCommandsAvailable() {
		return cloud4soaOperations.isLoggedAsDeveloper(); // This command is available only if the user is not logged yet!
	}
        
//        @CliCommand(value = "cloud4soa show application details", help = "Show application profile details")
//	public void showApplicationDetails(
//		@CliOption(key = "id", mandatory = true, help = "A local application profile id") final int localId){
//		cloud4soaOperations.showApplicationProfileDetails(localId);
//	}
//        
        /* Developer commands */
        @CliCommand(value = "cloud4soa show deployed applications", help = "Show all deployed applications owned by the user")
	public void showAllDeployedApplications() {
		cloud4soaOperations.showAllDeployedApplications();
	}
        
        @CliAvailabilityIndicator({"cloud4soa show application details","cloud4soa delete application profile", "cloud4soa search matching platforms"})
	public boolean isApplicationProfilesCached() {
		return cloud4soaOperations.isApplicationProfilesCached(); // This command is available only if application profiles are cached
	}
        
        @CliCommand(value = "cloud4soa create application profile", help = "Create and store a new cloud4soa application profile")
	public void createAndStoreApplicationProfile(
                @CliOption(key = { "", "file" }, help = "The file that contains the application profile", mandatory = true) final File file){
		cloud4soaOperations.createAndStoreApplicationProfile(file);
	}
           
//        @CliCommand(value = "cloud4soa create application profile", help = "Update an existent cloud4soa application profile")
//	public void updateApplicationProfile(
//                @CliOption(key = "id", mandatory = true, help = "A local application profile id") final int localId,
//                @CliOption(key = { "", "file" }, help = "The file that contains the application profile", mandatory = true) final File file){
//		cloud4soaOperations.updateApplicationProfile(localId, file);
//	}
        
        @CliCommand(value = "cloud4soa delete application profile", help = "Delete an existent cloud4soa application profile")
	public void deleteApplicationProfile(
                @CliOption(key = "id", mandatory = true, help = "A local application profile id") final int localId){
		cloud4soaOperations.deleteApplicationProfile(localId);
	}
        
        @CliCommand(value = "cloud4soa search matching platforms", help = "Search all the platforms that match with a specific application profile")
	public void searchForMatchingPlatform(
                @CliOption(key = "id", mandatory = true, help = "A local application profile id") final int localId){
		cloud4soaOperations.searchForMatchingPlatforms(localId);
	}
         
        @CliAvailabilityIndicator({"cloud4soa show paas profiles"})
	public boolean isLoggedAsDeveloperOrPaaSUser() {
		return cloud4soaOperations.isLoggedAsDeveloper() || cloud4soaOperations.isLoggedAsPaaSUser(); // This command is available only if is logged as Developer or PaaSUser
	}
        
        @CliCommand(value = "cloud4soa show paas profiles", help = "Show all available paas profiles")
	public void showAllAvailablePaaSProfiles(){
            if(this.isDeveloperCommandsAvailable())
		cloud4soaOperations.showAllAvailablePaaSProfiles();
            else if(this.isPaaSUserCommandsAvailable())
                cloud4soaOperations.showAllOwnedPaaSProfiles();
	}
        
        @CliAvailabilityIndicator({"cloud4soa deploy application"})
	public boolean isdeployApplicationAvailable() {
		return cloud4soaOperations.isApplicationProfilesCached() && cloud4soaOperations.isPaaSProfilesCached(); // This command is available only if application profiles are cached
	}
        
        @CliAvailabilityIndicator({"cloud4soa undeploy application"})
	public boolean isundeployApplicationAvailable() {
		return cloud4soaOperations.isDeployedApplicationsCached(); // This command is available only if application profiles are cached
	}
        
//        String applicationInstanceUriId, String paaSInstanceUriId, String publicKey, String secretKey, String fileName
        @CliCommand(value = "cloud4soa deploy application", help = "Search all the platforms that match with a specific application profile")
	public void deployApplication(
                @CliOption(key = "appId", mandatory = true, help = "The local application profile id") final int localAppId,
                @CliOption(key = "paasId", mandatory = true, help = "The local paas provider id") final int paasId,
                @CliOption(key = { "", "file" }, help = "The application archive", mandatory = true) final File file){
		cloud4soaOperations.deployApplication(localAppId, paasId, file);
	}
        
        @CliCommand(value = "cloud4soa undeploy application", help = "Undeploy a specific deployed application")
	public void undeployApplication(
                @CliOption(key = "id", mandatory = true, help = "The local deployed application id") final int localAppId){
		cloud4soaOperations.undeployApplication(localAppId);
	}
        
        @CliAvailabilityIndicator({"cloud4soa stop application","cloud4soa start application"})
	public boolean isDeployedApplicationsCached() {
		return cloud4soaOperations.isDeployedApplicationsCached(); // This command is available only if deployed applications are cached
	}
        
        @CliCommand(value = "cloud4soa stop application", help = "Stop a specific deployed application")
	public void stopApplication(
                @CliOption(key = "id", mandatory = true, help = "The local deployed application id") final int localAppId){
		cloud4soaOperations.startStopApplication(localAppId, "stop");
	}
        
        @CliCommand(value = "cloud4soa start application", help = "Start a specific deployed application")
	public void startApplication(
                @CliOption(key = "id", mandatory = true, help = "The local deployed application id") final int localAppId){
		cloud4soaOperations.startStopApplication(localAppId, "start");
	}
        
        @CliCommand(value = "cloud4soa migrate application", help = "Migrate a specific deployed application")
	public void migrateApplication(
                @CliOption(key = "id", mandatory = true, help = "The local deployed application id") final int localAppId,
                @CliOption(key = "paasId", mandatory = true, help = "The local paas provider id") final int paasId,
                @CliOption(key = { "", "file" }, help = "The application archive", mandatory = true) final File file){
		cloud4soaOperations.migrateApplication(localAppId, paasId, file);
	}
        
        @CliAvailabilityIndicator({"cloud4soa migrate application"})
	public boolean isMigrateApplicationAvailable() {
		return cloud4soaOperations.isDeployedApplicationsCached() && cloud4soaOperations.isPaaSProfilesCached(); // This command is available only if application profiles are cached
	}
        
        @CliCommand(value = "cloud4soa migrate commit", help = "Commit migration changes a specific application")
	public void commitMigration(
                @CliOption(key = "id", mandatory = true, help = "The local deployed application id") final int localAppId){
		cloud4soaOperations.commitMigration(localAppId);
	}
                
        @CliCommand(value = "cloud4soa migrate rollback", help = "Rollback migration changes a specific application")
	public void rollbackMigration(
                @CliOption(key = "id", mandatory = true, help = "The local deployed application id") final int localAppId){
		cloud4soaOperations.rollbackMigration(localAppId);
	}
        
        @CliAvailabilityIndicator({"cloud4soa migrate commit", "cloud4soa migrate rollback"})
	public boolean isCommitRollbackMigrationApplicationAvailable() {
		return cloud4soaOperations.isDeployedApplicationsCached() && cloud4soaOperations.isPaaSProfilesCached(); // This command is available only if application profiles are cached
	}
        
        /* DB related commands */
        
        @CliCommand(value = "cloud4soa show application dbs", help = "Show all application profile databases")
	public void showApplicationProfileDBs(@CliOption(key = "appId", mandatory = true, help = "The local application id") final int localAppId) {
		cloud4soaOperations.showAllApplicationProfileDBs(localAppId);
	}
        
        @CliAvailabilityIndicator({"cloud4soa show application dbs"})
	public boolean isShowApplicationProfileDBsAvailable() {
		return cloud4soaOperations.isApplicationProfilesCached(); // This command is available only if the user is not logged yet!
	}
        
        @CliCommand(value = "cloud4soa db create", help = "Creates a db for a specific application on the selected PaaS")
	public void createDB(@CliOption(key = "appId", mandatory = true, help = "The local application id") final int localAppId,
                @CliOption(key = "paasId", mandatory = true, help = "The local paas provider id") final int paasId,
                @CliOption(key = "dbName", mandatory = true, help = "The db storage component name") final String dbName){
		cloud4soaOperations.createDatabase(localAppId, paasId, dbName);
	}
        
        @CliAvailabilityIndicator({"cloud4soa db create", "cloud4soa db initialize", "cloud4soa db dump"})
	public boolean isCreateDBAvailable() {
		return cloud4soaOperations.isApplicationProfilesCached() && cloud4soaOperations.isPaaSProfilesCached(); // This command is available only if application profiles are cached
	}
        
        @CliCommand(value = "cloud4soa db initialize", help = "Initializes a db for a specific application on the selected PaaS by using a dump file")
	public void initializeDB(@CliOption(key = "appId", mandatory = true, help = "The local application id") final int localAppId,
                @CliOption(key = "paasId", mandatory = true, help = "The local paas provider id") final int paasId,
                @CliOption(key = "dbName", mandatory = true, help = "The db storage component name") final String dbName,
                @CliOption(key = { "", "file" }, help = "The dump file", mandatory = true) final File file){
		cloud4soaOperations.initializeDatabase(localAppId, paasId, dbName, file);
	}
        
        @CliCommand(value = "cloud4soa db dump", help = "Dump a db of a specific application that is created on a specific PaaS")
	public void dumpDB(@CliOption(key = "appId", mandatory = true, help = "The local application id") final int localAppId,
                @CliOption(key = "paasId", mandatory = true, help = "The local paas provider id") final int paasId,
                @CliOption(key = "dbName", mandatory = true, help = "The db storage component name") final String dbName,
                @CliOption(key = { "", "file" }, help = "The file where to dump the db", mandatory = true) final File file){
		cloud4soaOperations.dumpDatabase(localAppId, paasId, dbName, file);
	}
        
        @CliCommand(value = "cloud4soa migrate databases", help = "Migrate a specific deployed databases")
	public void migrateDBs(
                @CliOption(key = "id", mandatory = true, help = "The local deployed application id") final int localAppId,
                @CliOption(key = "paasId", mandatory = true, help = "The local paas provider id") final int paasId){
		cloud4soaOperations.migrateDBs(localAppId, paasId);
	}
        
        @CliAvailabilityIndicator({"cloud4soa migrate databases"})
	public boolean isMigrateDBsAvailable() {
		return cloud4soaOperations.isDeployedApplicationsCached() && cloud4soaOperations.isPaaSProfilesCached(); // This command is available only if application profiles are cached
	}
        
//        @CliCommand(value = "cloud4soa show paas details", help = "Show paas profile details")
//	public void showPaaSDetails(
//		@CliOption(key = "id", mandatory = true, help = "A local paas profile id") final int localId){
//		cloud4soaOperations.showPaaSProfileDetails(localId);
//	}
        
        @CliCommand(value = "cloud4soa credentials register", help = "Show all user credentials")
	public void registerCredentials(
            @CliOption(key = "paasId", mandatory = true, help = "The local paas provider id") final int paasId,
            @CliOption(key = "publicKey", mandatory = true, help = "The paas provider publicKey") final String publicKey,
            @CliOption(key = "secretKey", mandatory = true, help = "The paas provider secretKey") final String secretKey,
            @CliOption(key = "accountName", mandatory = false, help = "The paas provider accountName") final String accountName){
            cloud4soaOperations.registerCredentials(paasId, publicKey, secretKey, accountName);
	}
        
        @CliCommand(value = "cloud4soa credentials show all", help = "Register a new user credential for a specific paas")
	public void showAllCredentials(){
            cloud4soaOperations.showAllCredentials();
	}
        
        @CliCommand(value = "cloud4soa credentials show specific", help = "Show a specific user credential for a specific paas")
	public void showCredentials(
            @CliOption(key = "paasId", mandatory = true, help = "The local paas provider id") final int paasId){
            cloud4soaOperations.showCredentials(paasId);
	}
        
        @CliCommand(value = "cloud4soa credentials update", help = "Update an existing user credential for a specific paas")
	public void updateUserCredentials(
            @CliOption(key = "paasId", mandatory = true, help = "The local paas provider id") final int paasId,
            @CliOption(key = "publicKey", mandatory = true, help = "The paas provider publicKey") final String publicKey,
            @CliOption(key = "secretKey", mandatory = true, help = "The paas provider secretKey") final String secretKey,
            @CliOption(key = "accountName", mandatory = false, help = "The paas provider accountName") final String accountName){
            cloud4soaOperations.updateCredentials(paasId, publicKey, secretKey, accountName);
	}
        
        @CliCommand(value = "cloud4soa credentials remove", help = "Remove an existing user credential for a specific paas")
	public void removeUserCredentials(
            @CliOption(key = "paasId", mandatory = true, help = "The local paas provider id") final int paasId){
            cloud4soaOperations.removeUserCredentials(paasId);
	}
        
        @CliAvailabilityIndicator({"cloud4soa credentials register", "cloud4soa credentials show all", "cloud4soa credentials show specific", "cloud4soa credentials update", "cloud4soa credentials remove"})
	public boolean isRegisterCredentialsAvailable() {
		return cloud4soaOperations.isLoggedAsDeveloper() && cloud4soaOperations.isPaaSProfilesCached();
	}
        /* PaaS User commands */

        @CliAvailabilityIndicator({"cloud4soa create paas profile"}) //"cloud4soa show paas profiles", 
	public boolean isPaaSUserCommandsAvailable() {
		return cloud4soaOperations.isLoggedAsPaaSUser(); // This command is available only if the user is not logged yet!
	}
        
        
        @CliCommand(value = "cloud4soa create paas profile", help = "Create and store a new cloud4soa paas profile")
	public void createAndStorePaaSProfile(
                @CliOption(key = { "", "file" }, help = "The file that contains the paas profile", mandatory = true) final File file){
		cloud4soaOperations.createAndStorePaaSProfile(file);
	}
        
                
//        @CliCommand(value = "cloud4soa show paas details", help = "Show paas profile details")
//	public void showPaaSProfileDetails(
//		@CliOption(key = "id", mandatory = true, help = "A local paas profile id") final int localId){
//		cloud4soaOperations.showPaaSProfileDetails(localId);
//	}
        
                
//        @CliAvailabilityIndicator({"cloud4soa show paas details"})
//	public boolean isPaaSProfilesCached() {
//		return cloud4soaOperations.isPaaSProfilesCached(); // This command is available only if application profiles are cached
//	}
        
        
        @CliCommand(value = "cloud4soa create template application profile", help = "Create an application profile template")
	public void createApplicationProfileTemplate(
                @CliOption(key = "fileName", mandatory = true, help = "The name of the file where to save the application profile template") final String fileName){
		cloud4soaOperations.createApplicationProfileTemplate(fileName);
	}
        
                
        @CliAvailabilityIndicator({"cloud4soa create template application profile"})
	public boolean isCreateApplicationProfileTemplateAvailable() {
		return cloud4soaOperations.isCreateApplicationProfileTemplateAvailable(); // This command is available only if application profiles are cached
	}
        
        
        @CliCommand(value = "cloud4soa create template developer profile", help = "Create a developer user profile template")
	public void createDeveloperProfileTemplate(
                @CliOption(key = "fileName", mandatory = true, help = "The name of the file where to save the developer user profile template") final String fileName){
		cloud4soaOperations.createDeveloperProfileTemplate(fileName);
	}                
             
        
        @CliAvailabilityIndicator({"cloud4soa create template developer profile"})
	public boolean isCreateDeveloperProfileTemplateAvailable() {
		return cloud4soaOperations.isCreateDeveloperProfileTemplateAvailable(); // This command is available only if application profiles are cached
	}
        
                
        @CliCommand(value = "cloud4soa create template paas offering profile", help = "Create a paas offering profile template")
	public void createPaaSProfileTemplate(
                @CliOption(key = "fileName", mandatory = true, help = "The name of the file where to save the paas offering profile template") final String fileName){
		cloud4soaOperations.createPaaSProfileTemplate(fileName);
	}
        
        
        @CliAvailabilityIndicator({"cloud4soa create template paas offering profile"})
	public boolean isCreatePaaSProfileTemplateAvailable() {
		return cloud4soaOperations.isCreatePaaSProfileTemplateAvailable(); // This command is available only if application profiles are cached
	}

        
        @CliCommand(value = "cloud4soa create template paas user profile", help = "Create a paas user profile template")
	public void createPaaSUserProfileTemplate(
                @CliOption(key = "fileName", mandatory = true, help = "The name of the file where to save the paas user profile template") final String fileName){
		cloud4soaOperations.createPaaSUserProfileTemplate(fileName);
	}
        
                
        @CliAvailabilityIndicator({"cloud4soa create template paas user profile"})
	public boolean isCreatePaaSUserProfileTemplateAvailable() {
		return cloud4soaOperations.isCreatePaaSUserProfileTemplateAvailable();
	}
        
        @CliCommand(value = "cloud4soa show available databases", help = "Show available databases")
	public void showAvailableDBs(){
		cloud4soaOperations.showAvailableDBs();
	}
        
        @CliAvailabilityIndicator({"cloud4soa show available databases"})
	public boolean isShowAvailableDBsAvailable() {
		return true;
	}
        
        @CliCommand(value = "cloud4soa show available computational", help = "Show available computational categories")
	public void showAvailableComputationals(){
		cloud4soaOperations.showAvailableComputationals();
	}
        
        @CliAvailabilityIndicator({"cloud4soa show available computational"})
	public boolean isShowAvailableComputationalsAvailable() {
		return true;
	}
        
        @CliCommand(value = "cloud4soa show available programming languages", help = "Show available programming languages")
	public void showAvailableProgrammingLanguages(){
		cloud4soaOperations.showAvailableProgrammingLanguages();
	}
        
        @CliAvailabilityIndicator({"cloud4soa show available programming languages"})
	public boolean isshowAvailableProgrammingLanguagesAvailable() {
		return true;
	}
                
//        @CliAvailabilityIndicator({"cloud4soa create application profile template"})
//	public boolean isCreateApplicationProfileTemplateAvailable() {
//		return cloud4soaOperations.isCreateApplicationProfileTemplateAvailable(); // This command is available only if application profiles are cached
//	}
     
        
    // Git keys management - CRUD operations ----------------------------/

    @CliCommand(value= "cloud4soa git key c4s", help = "Command to retrieve the cloud4soa public key")
    public void getC4sKey(){
        cloud4soaOperations.getC4SOAPublicKey();
    }
    
    @CliAvailabilityIndicator("cloud4soa git key c4s")
    public boolean isGitKeyRegisterAvailable() {
        return cloud4soaOperations.isLoggedAsDeveloper();
    }
        
    @CliCommand(value= "cloud4soa git key register", help = "Command to register a user public key")
    public void registerUserPubKey(){
        cloud4soaOperations.registerPublicKeyForUser();
    }
    
    @CliAvailabilityIndicator("cloud4soa git key register")
    public boolean isRegisterUserPubKeyAvailable() {
        return cloud4soaOperations.isLoggedAsDeveloper();
    }
    
    @CliCommand(value= "cloud4soa git key list", help = "Command to retrieve the user public keys")
    public void listUserPubKeys(){
        cloud4soaOperations.getPublicKeysForUser();
    }
    
    @CliAvailabilityIndicator("cloud4soa git key list")
    public boolean isListUserPubKeysAvailable() {
        return cloud4soaOperations.isLoggedAsDeveloper();
    }
    
    @CliCommand(value= "cloud4soa git key delete", help = "Command to delete a user public key")
    public void deleteUserPubKey(@CliOption(key = "publicKey", mandatory = true, help = "the public key to be removed") final String publicKey){
        cloud4soaOperations.deletePublicKeyFromUser(publicKey);
    }
    
    @CliAvailabilityIndicator("cloud4soa git key delete")
    public boolean isDeleteUserPubKeyAvailable() {
        return cloud4soaOperations.isLoggedAsDeveloper();
    }
     
    // ------------------------------------------------------------------/       
    
    @CliCommand(value= "cloud4soa deploy gitPush", help = "Push the code on the repository sected by the createGitRepo command")
    public void gitPush(
            @CliOption(key = "appId", mandatory = true, help = "The local application profile id") 
                final int appId,
            @CliOption(key = "paasId", mandatory = true, help = "The local paas provider id") 
                final int paasId,
            @CliOption(key = "repoPath", mandatory = true, help = "the root directory of the local git repository") 
                final File repoPath,
            @CliOption(key = "passphrase", mandatory = true, help = "the passphrase needed to use the ssh keys") 
                final String passphrase
            ) {
        cloud4soaOperations.gitPush(appId, paasId, repoPath, passphrase);
    }        
    
    @CliAvailabilityIndicator({"cloud4soa deploy gitPush"})
    public boolean isDeployGitPushAvailable() {
        return cloud4soaOperations.isApplicationProfilesCached() && cloud4soaOperations.isPaaSProfilesCached(); // This command is available only if application profiles are cached;
    }
}