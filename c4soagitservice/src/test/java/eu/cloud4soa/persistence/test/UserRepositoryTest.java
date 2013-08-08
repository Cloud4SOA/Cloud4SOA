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


import java.util.List;
import java.util.Random;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import eu.cloud4soa.c4sgitservice.dao.UserRepository;
import eu.cloud4soa.c4sgitservice.datamodel.*;


/**
 * Created with IntelliJ IDEA.
 * User: pgouvas
 * Date: 8/2/12
 * Time: 12:30 PM
 */

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:**/WEB-INF/GitProxy-context.xml"})
public class UserRepositoryTest {
    
    protected final Log logger = LogFactory.getLog(getClass());
    
    
    @Autowired
    UserRepository userdao;

    @Test
    public void testWiring(){
        Assert.assertNotNull(userdao);
    }
    
    @Ignore
    @Test
    public void testCreateUser(){
        User user = new User();
        user.setUsername("usernametest");
        user.setPassword("passwordtest");
        userdao.save(user);
    }

    @Ignore
    @Test
    public void testfindUserById(){
        User user1 = userdao.findByUserId(new Long(1));
        logger.info("User  with id 1:"+user1);
    }

    @Ignore
    @Test
    public void testfindUserByUsername(){
        List<User> users = userdao.findByUsername("usernametest");
        logger.info("Users  with username usernametest:"+users);
    }

    @Ignore
    @Test
    public void testfindUserByUsernameAndPassword(){
        List<User> users = userdao.findByUsernameAndPassword("testuser","testuser");
        logger.info("Users  with username and password:"+users);
    }

    @Ignore
    @Test
    public void testdeleteUsers(){
        List<User> users = userdao.findByUsername("usernametest");
        for (int i = 0; i < users.size(); i++) {
            User user =  users.get(i);
            userdao.delete(user);
        }
    }

}//EoC
