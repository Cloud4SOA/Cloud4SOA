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

/**
 * Interface of commands that are available via the Roo shell.
 *
 * @since 1.1.1
 */
public interface Cloud4soaOperations {

	/**
	 * Indicate of the install tags command should be available
	 * 
	 * @return true if it should be available, otherwise false
	 */
//	boolean isInstallTagsCommandAvailable();

	/**
	 * @param propertyName to obtain (required)
	 * @return a message that will ultimately be displayed on the shell
	 */
	String getProperty(String propertyName);
        
        void setProperty(String propertyName, String value);
        
        boolean isLogged();
        
        /**
	 * @param userInstance to obtain all the user information
	 * @return a message that will ultimately be displayed on the shell
	 */
//        void register(UserInstance userInstance);
        
        /**
	 * @param propertyName to obtain (required)
	 * @return a message that will ultimately be displayed on the shell
	 */
        void login(String username, String password);
        
        void logout();
                
        void registerUserProfile(File file, String username, String password);
        
        /* Developer Commands */
        
        boolean isLoggedAsDeveloper();
        
        boolean isApplicationProfilesCached();
        
        boolean isDeployedApplicationsCached();
        
        void showApplicationProfiles();
        
//        void showApplicationProfileDetails(Integer localId);
        
        void showAllDeployedApplications();

        void createAndStoreApplicationProfile(File file);

        void updateApplicationProfile(Integer localId, File file);

        void deleteApplicationProfile(Integer localId);

        void searchForMatchingPlatforms(Integer localId);

        void showAllAvailablePaaSProfiles();

        void deployApplication(Integer localAppId, Integer paasId, File file);

        void undeployApplication(Integer localAppId);
        
        boolean isPaaSProfilesCached();

        void startStopApplication(Integer localAppId, String command);
        
        void migrateApplication(int localAppId, int paasId, File file);

        /* DB related commands */
        
        void showAllApplicationProfileDBs(Integer localAppId);
        
        void createDatabase(Integer localAppId, Integer paasId, String dbStorageComponentUriId);
        
        void initializeDatabase(Integer localAppId, Integer paasId, String dbStorageComponentUriId, File file);
        
        void dumpDatabase(Integer localAppId, Integer paasId, String dbName, File file);
        
        /* PaaS User commands */
        
        boolean isLoggedAsPaaSUser();

        void createAndStorePaaSProfile(File file);

        void showAllOwnedPaaSProfiles();

//        void showPaaSProfileDetails(Integer localId);

        void createApplicationProfileTemplate(String fileName);

        boolean isCreateApplicationProfileTemplateAvailable();
        
        void createPaaSProfileTemplate(String fileName);
        
        boolean isCreatePaaSProfileTemplateAvailable(); 
        
        void createDeveloperProfileTemplate(String fileName);
        
        boolean isCreateDeveloperProfileTemplateAvailable();
        
        void createPaaSUserProfileTemplate(String fileName);
        
        boolean isCreatePaaSUserProfileTemplateAvailable();

        void showAvailableDBs();

        void showAvailableProgrammingLanguages();

        void showAvailableComputationals();
        
        //Credentials management operations

        void registerCredentials(Integer paasId, String publicKey, String secretKey, String accountName);

        void showAllCredentials();

        void showCredentials(Integer paasId);

        void updateCredentials(Integer paasId, String publicKey, String secretKey, String accountName);

        void removeUserCredentials(Integer paasId);

        void migrateDBs(int localAppId, int paasId);

        void commitMigration(int localAppId);

        void rollbackMigration(int localAppId);
        
        // Git keys management - CRUD operations ----------------------------/
        
        void getC4SOAPublicKey();

        void registerPublicKeyForUser();

        void getPublicKeysForUser();

        void deletePublicKeyFromUser(String publicKey );
        
// methods to support GIT ------------------------------------------------------        
                
        public void registerExistingGitRepo( int paasUriId, String repoName, String gitUri );
        
        public void deleteRepo( String repoId );
        
        public void getRepos();
        
        public void relocateRepo(int newPaasUriId);
        
        public void gitPush( Integer localAppId, Integer paasId, File repoPath, String passphrase);
    
}