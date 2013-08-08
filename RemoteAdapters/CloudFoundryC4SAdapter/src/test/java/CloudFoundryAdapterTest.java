/*
 * Copyright [2013] [Cloud4SOA, www.cloud4soa.eu]
 *
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import cloudfoundry.ClientHelper;
import cloudfoundry.DatabaseObject;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 *
 * @author davidcunha (david-g-cunha@ptinovacao.pt)
 */
public class CloudFoundryAdapterTest {

    public static String APP_NAME = "test_app";
    public static String DB_APP_NAME = "db-appteste1";
    public static String DB_NAME = "mysql-test";
    //public static String USER = "davidgoncalvescunha@gmail.com";
    //public static String PASS = "csb123qwe";
    public static String USER = "atos@atoscf.com";
    public static String PASS = "4to5cf";

    public CloudFoundryAdapterTest() {
    }

    @Ignore
    @Test
    public void testAuthentication() throws Exception {
        System.out.println("Authentication");
        System.out.println("--------------------------------------");
        System.out.println("Authenticate with correct credentials");
        ClientHelper.init(USER, PASS);
        System.out.println("Authenticate with bad credentials");
        try {
            ClientHelper.init("fakeuser", "fakepass");
            fail("No exception!");
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("403"));
        }
    }
    
    @Ignore
    @Test
    public void testgetApplicationInfo() throws Exception {
        System.out.println("Getting Info of an Application");
        System.out.println("--------------------------------------");
        ClientHelper helper = new ClientHelper();
        Assert.notNull(helper.ApplicationInfo(USER, PASS, APP_NAME));

    }

    @Ignore
    @Test
    public void testApplicationsList() throws Exception {
        System.out.println("Getting List of Applications");
        System.out.println("--------------------------------------");
        ClientHelper helper = new ClientHelper();
        Assert.notNull(helper.ApplicationsList(USER, PASS));
    }

    @Ignore
    @Test
    public void testStartStopApplication() throws Exception {
        System.out.println("Starting and Stopping Application");
        System.out.println("--------------------------------------");
        ClientHelper helper = new ClientHelper();

        System.out.println("Stopping Application");
        assertEquals(helper.StartStopApplication(USER, PASS, APP_NAME, "STOP"), "stopped");

        System.out.println("--------------------------------------");

        System.out.println("Starting Application");
        assertEquals(helper.StartStopApplication(USER, PASS, APP_NAME, "START"), "started");

    }

    @Ignore
    @Test
    public void testDeleteApplication() throws Exception {
        System.out.println("Deleting Application");
        System.out.println("--------------------------------------");
        ClientHelper helper = new ClientHelper();

        assertEquals(helper.DeleteApplication(USER, PASS, APP_NAME), "deleted");
    }

    @Ignore
    @Test
    public void testCreateDatabase() throws Exception {
        System.out.println("Creating Database");
        System.out.println("--------------------------------------");
        ClientHelper helper = new ClientHelper();

        DatabaseObject dbobj = helper.createDatabase(USER, PASS, DB_NAME, DB_APP_NAME);

        assertEquals(dbobj.getDbidentifier(), "mysql-test");
    }

    @Ignore
    @Test
    public void testGetDBInfo() throws Exception {
        System.out.println("Getting info from Database");
        System.out.println("--------------------------------------");
        ClientHelper helper = new ClientHelper();

        DatabaseObject dbobj = helper.getDBInfo(USER, PASS, DB_NAME);

        assertEquals(dbobj.getDbidentifier(), "mysql-test");
    }

    @Ignore
    @Test
    public void testGetDBList() throws Exception {
        System.out.println("Getting List of Databases");
        System.out.println("--------------------------------------");
        ClientHelper helper = new ClientHelper();

        Assert.notNull(helper.getDBList(USER, PASS));

    }

    @Ignore
    @Test
    public void testDeleteDatabase() throws Exception {
        System.out.println("Deleting Database");
        System.out.println("--------------------------------------");
        ClientHelper helper = new ClientHelper();

        DatabaseObject dbobj = helper.createDatabase(USER, PASS, "mysql-test1", DB_APP_NAME);
        assertEquals(dbobj.getDbidentifier(), "mysql-test1");

        assertEquals(helper.deleteDatabase(USER, PASS, "mysql-test1"), "deleted");

    }
}
