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

import eu.cloud4soa.c4sgitservice.dao.PubKeyRepository;
import eu.cloud4soa.c4sgitservice.dao.UserRepository;
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
 * Date: 8/2/12
 * Time: 3:20 PM
 */

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:**/WEB-INF/GitProxy-context.xml"})
public class PubKeyRepositoryTest {

    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    PubKeyRepository pubkeydao;

    @Autowired
    UserRepository userdao;

    @Test
    public void testWiring(){
        Assert.assertNotNull(pubkeydao);
        Assert.assertNotNull(userdao);
    }


    @Ignore
    @Test
    public void testCreatePubKey(){
        User user = new User();
        user.setUsername("usernametest1");
        user.setPassword("passwordtest1");
        user = userdao.save(user);

        for (int i = 0; i < 5; i++) {
            PubKey pubKey = new PubKey();
            pubKey.setPubkey("testkey");
            pubKey.setUser(user);
            pubkeydao.save(pubKey);
        }


    }//EoM

    @Ignore
    @Test
    public void testFindByUser(){
        List<User> users = userdao.findByUsername("usernametest1") ;
        User user = null;
        if (users.size()>0) user=users.get(0);
        List<PubKey> pubkeys = pubkeydao.findByUser(user);
        logger.info("Pubkeys for user: "+ user+" "+pubkeys.size());
    }//EoM

    @Ignore
    @Test
    public void testDeletePubKey(){
       List<PubKey> pubkeys = pubkeydao.findByPubkey("testkey");
        for (int i = 0; i < pubkeys.size(); i++) {
            PubKey pubKey =  pubkeys.get(i);
            pubkeydao.delete(pubKey);
        }
    }//EoM


    @Ignore
    @Test
    public void testDeleteRemainingUsers(){
        List<User> users = userdao.findByUsername("usernametest1");
        for (int i = 0; i < users.size(); i++) {
            User user =  users.get(i);
            userdao.delete(user);
        }
    }//EoM

    @Ignore
    @Test
    public void testFindByUserAndPubkey(){
        List<User> users = userdao.findByUsername("testuser") ;
        User user = null;
        if (users.size()>0) user=users.get(0);
        String pubkey="pubkey";
        List<PubKey> pubkeys = pubkeydao.findByUserAndPubkey(user,pubkey);
        logger.info("Pubkeys for user: "+ user+" "+pubkeys.size());
    }//EoM


}
