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


import eu.cloud4soa.cli.roo.addon.commands.GitManager;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author frarav
 */
public class GitPushCommandTest{
    
    private static Logger logger  = LoggerFactory.getLogger( GitPushCommandTest.class );

    @Ignore
    @Test
    public void GitPushCommandTest() {
        String repoName = "repoName"; 
        String repositoryPath = "/home/user/repoDir";
        String sshKeyDir = "/home/user/.ssh/id_rsa"; 
        String passphrase = "xxxxx";     
        String gitProxyUrl = "cloud@94.75.243.141/proxy36.git";
        
        GitManager gitPushCommand = new GitManager(gitProxyUrl, repoName, repositoryPath, sshKeyDir, passphrase);
        try {
            gitPushCommand.init();
            gitPushCommand.setConfig();
            gitPushCommand.testStatus();
            gitPushCommand.pull();
            gitPushCommand.removeAll();
            gitPushCommand.addAll();
            gitPushCommand.commit();
            gitPushCommand.push();
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
        }
    }
}
