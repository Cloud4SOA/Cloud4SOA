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
package eu.cloud4soa.cli.roo.addon.commands;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import eu.cloud4soa.cli.roo.addon.Cloud4SoaSessionDeveloper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.CommitCommand;
import org.eclipse.jgit.api.FetchCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullCommand;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.merge.Merger;
import org.eclipse.jgit.merge.ResolveMerger;
import org.eclipse.jgit.merge.ThreeWayMerger;
import org.eclipse.jgit.storage.file.FileRepository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.transport.JschConfigSessionFactory;
import org.eclipse.jgit.transport.OpenSshConfig.Host;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.RemoteConfig;
import org.eclipse.jgit.transport.SshSessionFactory;
import org.eclipse.jgit.transport.URIish;
import org.eclipse.jgit.util.FS;
import java.util.logging.Logger;

/**
 *
 * @author frarav
 */
public class GitManager {
    
    private static final Logger logger = Logger.getLogger(GitManager.class.getName());

    protected Cloud4SoaSessionDeveloper session;
    protected String repoName;
    protected String  localPath;
    private Git git;
    private PushCommand pushCommand;
    private PullCommand pullCommand;
    private AddCommand addCommand;
    private CommitCommand commitCommand;
    private Repository gitRepository;
    private final String sshKeyDir;
    private final String passphrase;
    private final String gitProxyUrl;
    
    public GitManager(String gitProxyUrl, String repoName, String localPath, String sshKeyDir, String passphrase) {
        this.repoName   = repoName;
        this.localPath  = localPath;
        this.sshKeyDir = sshKeyDir;
        this.passphrase = passphrase;
        this.gitProxyUrl = gitProxyUrl;
    }
    
    public void testStatus() throws IOException, GitAPIException {
        Status status = git.status().call();
        logger.info( "Local Git Repository status");
        logger.info( "- "+ (status.isClean() ? "Clean" : "Not clean") );
        logger.info( "- "+ (status.getAdded().isEmpty() ? "No files added" : "Files added: " + status.getAdded()));
        logger.info( "- "+ (status.getChanged().isEmpty() ? "No files changed" : "Files added: " + status.getChanged() ));
        logger.info( "- "+ (status.getUntracked().isEmpty() ? "All files are tracked" : "Files untracked: " + status.getUntracked() ));
    }
    
    public void init() throws Exception {
        FileRepositoryBuilder builder;
        
        gitRepository = new FileRepository(localPath + "/" + ".git");
        builder = new FileRepositoryBuilder();
        gitRepository = builder.setGitDir(new File( localPath + "/.git")).readEnvironment().findGitDir().build();
        git = new Git( gitRepository );

        GithubSshSessionFactory factory = new GithubSshSessionFactory();
        factory.setKeyLocation(sshKeyDir);
        factory.setPassphrase(passphrase);
        SshSessionFactory.setInstance(factory);
        
    }
    
    public void setConfig() throws URISyntaxException, IOException, GitAPIException{
        StoredConfig config = gitRepository.getConfig();
        
        if(config.getString("remote", repoName, "url") == null || config.getString("remote", repoName, "url")!=gitProxyUrl){
            config.unset("remote", repoName, "url");
            RemoteConfig remoteConfig = new RemoteConfig(config, repoName);
            //cloud@94.75.243.141/proxyname.git
            //proxy<userid><applicationid>.git”
            //        String gitUrl = gitUser+"@"+gitProxyUrl+"/proxy"+this.userId+this.applicationId+".git";
            URIish uri = new URIish(gitProxyUrl);
            remoteConfig.addURI(uri);
            config.unset("remote", repoName, "fetch");
            RefSpec spec = new RefSpec("+refs/heads/*:refs/remotes/"+repoName+"/*");
            remoteConfig.addFetchRefSpec(spec);
            remoteConfig.update(config);
        }

        if(config.getString("branch", "master", "remote")==null || config.getString("branch", "master", "remote")!=repoName){
            config.unset("branch", "master", "remote");
            config.setString("branch", "master", "remote", repoName);
        }
        if(config.getString("branch", "master", "merge")==null || config.getString("branch", "master", "merge")!="refs/heads/master"){
            config.unset("branch", "master", "merge");
            config.setString("branch", "master", "merge", "refs/heads/master");            
        }
        config.save();
    }
    
        
    public void removeAll() throws GitAPIException{
        addCommand = git.add();
        addCommand.addFilepattern(".");
        //Needed to track all the removed files
        addCommand.setUpdate(true);
        addCommand.call();              
    }
    
    public void addAll() throws GitAPIException{
        addCommand = git.add();
        addCommand.addFilepattern(".");
        addCommand.call();              
    }
    
    public void commit() throws GitAPIException{
        commitCommand = git.commit(); //git commit -m "commit for deploy to heroku"
        commitCommand.setMessage("commit for deploy through cloud4soa");
        commitCommand.call();              
    }
    
    public void push() throws GitAPIException{
        pushCommand = git.push();
        pushCommand.setRemote( repoName );
        logger.info("Performing the git push command");
        Iterable<PushResult> call = pushCommand.call();
//        for (PushResult pushResult : call) {
//            logger.info("push result:"+pushResult.getMessages());
//        }
    }
    
    public void fetch() throws GitAPIException{
        FetchCommand fetchCommand = git.fetch();
        fetchCommand.setRemote( repoName );
        fetchCommand.call();              
    }
    
    public void pull() throws GitAPIException, IOException{
        pullCommand = git.pull();
        logger.info("Performing the git pull/merge command");
        PullResult pullResult = pullCommand.call();
            logger.info("Fetched From: "+pullResult.getFetchedFrom());
            logger.info("Fetch Result: "+pullResult.getFetchResult().getMessages());
            logger.info("Merge Result:"+pullResult.getMergeResult());
            logger.info("Rebase Result:"+pullResult.getRebaseResult());
            logger.info(pullResult.isSuccessful() ? "Pull/Merge success" : "Failed to Pull/Merge");
    }


    public static class GithubSshSessionFactory extends JschConfigSessionFactory {

        private String passphrase;
        private String key;

        public void setPassphrase(String passphrase) {
            this.passphrase = passphrase;
        }

        public void setKeyLocation(String key) {
            this.key = key;
        }

        @Override
        protected void configure(Host hc, Session session) {
            // do nothing
            session.setConfig("StrictHostKeyChecking", "no");
        }

        @Override
        protected JSch createDefaultJSch(FS fs) throws JSchException {
            final JSch jsch = new JSch();
            knownHosts(jsch, fs);
            if (key != null) {
                jsch.addIdentity(new File(key).getAbsolutePath(),
                        passphrase);
                logger.info(".ssh directory used: "+new File(key).getAbsolutePath());
            } else {
                final File home = fs.userHome();
                if (home == null) {
                    return jsch;
                }
                final File sshdir = new File(home, ".ssh");
                if (sshdir.isDirectory()) {
                    jsch.addIdentity(new File(sshdir, "id_rsa").getAbsolutePath(),
                            passphrase);                    
                    logger.info(".ssh directory used: "+sshdir.getAbsolutePath());
                }
            }
            return jsch;
        }

        private static void knownHosts(final JSch sch, FS fs) throws JSchException {
            final File home = fs.userHome();
            if (home == null) {
                return;
            }
            final File known_hosts = new File(new File(home, ".ssh"), "known_hosts");
            try {
                final FileInputStream in = new FileInputStream(known_hosts);
                try {
                    logger.info("Try to read the ssh known_hosts file: "+known_hosts.getAbsolutePath());
                    sch.setKnownHosts(in);
                } finally {
                    in.close();
                }
            } catch (FileNotFoundException none) {
                // Oh well. They don't have a known hosts in home.
                logger.severe("known_hosts file not found: "+known_hosts.getAbsolutePath());
            } catch (IOException err) {
                // Oh well. They don't have a known hosts in home.
                logger.severe("Error while reading the known_hosts file: "+err.getMessage());
            }
        }
    }

}
