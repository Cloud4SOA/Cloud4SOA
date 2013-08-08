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


package eu.cloud4soa.persistence.test;

import eu.cloud4soa.c4sgitservice.dao.GitRepoRepository;
import eu.cloud4soa.c4sgitservice.dao.UserRepository;
import eu.cloud4soa.c4sgitservice.datamodel.GitRepo;
import eu.cloud4soa.c4sgitservice.datamodel.PubKey;
import eu.cloud4soa.c4sgitservice.datamodel.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pgouvas
 * Date: 8/3/12
 * Time: 7:58 AM
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:**/WEB-INF/GitProxy-context.xml"})
public class GitRepoRepositoryTest {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    UserRepository userdao;
    @Autowired
    GitRepoRepository gitrepo;


    @Test
    public void testWiring(){
        Assert.assertNotNull(userdao);
        Assert.assertNotNull(gitrepo);

    }

    @Ignore
    @Test
    public void testCreatePubKey(){
        User user = new User();
        user.setUsername("usernametest2");
        user.setPassword("passwordtest2");
        user = userdao.save(user);

        for (int i = 0; i < 5; i++) {
            GitRepo repo = new GitRepo();
            repo.setUser(user);
            repo.setGitrepo("repo1");
            gitrepo.save(repo);
        }
        List<GitRepo> repos = gitrepo.findByUser(user);

    }//EoM


    @Ignore
    @Test
    public void testDeleteRepo(){
        List<GitRepo> repos = gitrepo.findByGitrepo("repo1");
        gitrepo.delete(repos);
    }//EoM

    //@Ignore
    @Test
    public void testDeleteRemainingUsers(){
        List<User> users = userdao.findByUsername("usernametest2");
        for (int i = 0; i < users.size(); i++) {
            User user =  users.get(i);
            userdao.delete(user);
        }
    }//EoM


}//EoClass
