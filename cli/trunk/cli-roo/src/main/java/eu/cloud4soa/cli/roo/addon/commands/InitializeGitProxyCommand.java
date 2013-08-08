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


package eu.cloud4soa.cli.roo.addon.commands;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import eu.cloud4soa.api.datamodel.soa.GitRepoInfo;
import eu.cloud4soa.api.util.exception.soa.SOAException;
import eu.cloud4soa.cli.soa.ApplicationDeploymentClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author frarav
 */
public class InitializeGitProxyCommand extends Cloud4soaCommand {
    
    private static Logger logger  = LoggerFactory.getLogger( InitializeGitProxyCommand.class );

    private ApplicationDeploymentClient applicationDeploymentClient;
    
    protected String userInstanceUriId;
    protected String paaSInstanceUriId;
    protected String applicationInstanceUriId;
    protected GitRepoInfo gitRepoInfo;

    public InitializeGitProxyCommand(String userInstanceUriId, String paaSInstanceUriId, String applicationInstanceUriId) {
        super( "" , "" );
        applicationDeploymentClient = new ApplicationDeploymentClient();
        this.userInstanceUriId = userInstanceUriId;
        this.paaSInstanceUriId = paaSInstanceUriId;
        this.applicationInstanceUriId = applicationInstanceUriId;
    }
       
    
    @Override
    public void execute() throws Exception {
        
        try {           
            gitRepoInfo = applicationDeploymentClient.initializeGitProxy(userInstanceUriId, paaSInstanceUriId, applicationInstanceUriId);
            this.successMessage = "git repository created - repositoryName: " +gitRepoInfo.getRepositoryName()+" url: "+gitRepoInfo.getUrl();
        
        } catch( SOAException se) {
        
            this.displaySuccessMessage = false;
            this.failureMessage = "Impossible to create the git repository on the PaaS: " + se.getMessage();
            logger.error( se.getMessage() );
            throw se;
        
        } 
        
    }

    public GitRepoInfo getGitRepoInfo() {
        return gitRepoInfo;
    }      
    
}
