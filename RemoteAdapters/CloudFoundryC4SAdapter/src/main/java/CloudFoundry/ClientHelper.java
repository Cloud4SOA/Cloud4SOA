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


package cloudfoundry;

import eu.cloud4soa.adapter.rest.response.ListApplicationResponse;
import eu.cloud4soa.adapter.rest.response.ListDatabaseResponse;
import eu.cloud4soa.adapter.rest.response.model.Application;
import eu.cloud4soa.adapter.rest.response.model.Database;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.cloudfoundry.client.lib.CloudCredentials;
import org.cloudfoundry.client.lib.CloudFoundryClient;
import org.cloudfoundry.client.lib.domain.CloudApplication;
import org.cloudfoundry.client.lib.domain.CloudService;

/**
 *
 * @author davidcunha (david-g-cunha@ptinovacao.pt)
 */
public class ClientHelper {

    static String CC_URL = "http://api.cloudfoundry.com";
    //static String CC_URL = "http://api.cf.cloud4soa.eu";

    public static CloudFoundryClient init(String email, String password) throws MalformedURLException {
        CloudFoundryClient client = new CloudFoundryClient(new CloudCredentials(email, password), new URL(CC_URL));
        client.login();
        return client;
    }

    public ListApplicationResponse ApplicationInfo(String email, String password, String appname) throws Exception {

        Application[] apps_array = new Application[1];
        ListApplicationResponse response = new ListApplicationResponse();

        CloudFoundryClient client = init(email, password);
        CloudApplication cloudapp = client.getApplication(appname);

        Application app = new Application();
        app.setApplicationName(cloudapp.getName());

        List<String> uris = cloudapp.getUris();
        app.setUrl(uris.get(0));

        apps_array[0] = app;

        response.setApplications(apps_array);

        return response;
    }

    public ListApplicationResponse ApplicationsList(final String email, final String password) throws Exception {

        ListApplicationResponse response = new ListApplicationResponse();
        List<Application> list = new ArrayList<Application>();

        CloudFoundryClient client = init(email, password);

        List<CloudApplication> cloudapps = client.getApplications();

        for (CloudApplication cloudapp : cloudapps) {
            Application app = new Application();
            app.setApplicationName(cloudapp.getName());

            List<String> uris = cloudapp.getUris();
            app.setUrl(uris.get(0));

            list.add(app);
        }

        Application[] apps_array = new Application[list.size()];

        for (int i = 0; i < list.size(); i++) {
            apps_array[i] = list.get(i);
        }

        response.setApplications(apps_array);

        return response;
    }

    public String StartStopApplication(String email, String password, String appname, String method) throws Exception {

        String response = "";

        CloudFoundryClient client = init(email, password);

        if (method.equalsIgnoreCase("START")) {
            client.startApplication(appname);
            response = "started";
        }

        if (method.equalsIgnoreCase("STOP")) {
            client.stopApplication(appname);
            response = "stopped";
        }

        return response;
    }

    public String DeleteApplication(String email, String password, String appname) throws Exception {

        String response;

        CloudFoundryClient client = init(email, password);
        client.deleteApplication(appname);
        response = "deleted";

        return response;
    }

    public ListDatabaseResponse getDBList(String email, String password) throws Exception {

        ListDatabaseResponse response = new ListDatabaseResponse();
        List<Database> list = new ArrayList<Database>();

        CloudFoundryClient client = init(email, password);

        List<CloudService> cloudservices = client.getServices();

        for (CloudService cloudservice : cloudservices) {
            Database database = new Database();
            database.setDatabaseName(cloudservice.getName());
            database.setHost("Access via Caldecott");
            database.setPort("Access via Caldecott");
            database.setPassword("Access via Caldecott");
            database.setUserName("Access via Caldecott");

            list.add(database);
        }

        Database[] databases_array = new Database[list.size()];

        for (int i = 0; i < list.size(); i++) {
            databases_array[i] = list.get(i);
        }

        response.setDatabases(databases_array);

        return response;
    }

    public DatabaseObject getDBInfo(String email, String password, String dbname) throws Exception {

        DatabaseObject dbobj = new DatabaseObject();

        CloudFoundryClient client = init(email, password);
        CloudService cloudservice = client.getService(dbname);

        dbobj.setDbname(cloudservice.getName());
        dbobj.setDbidentifier(cloudservice.getName());
        dbobj.setDbhost("Access via Caldecott");
        dbobj.setPort(0);
        dbobj.setDbtype(cloudservice.getType());

        return dbobj;
    }

    public DatabaseObject createDatabase(String email, String password, String dbname, String appid) throws Exception {

        CloudFoundryClient client = init(email, password);

        CloudService cloudservice = new CloudService();
        cloudservice.setTier("free");
        cloudservice.setName(dbname);
        //MYSQL DATABASE (implementation of other systems (Redis, Mongo, etc) necessary
        cloudservice.setVersion("5.1");
        cloudservice.setVendor("mysql");
        cloudservice.setType("database");
        cloudservice.setProvider("core");
        client.createService(cloudservice);
        client.bindService(appid, dbname);

        return getDBInfo(email, password, dbname);
    }

    public String deleteDatabase(String email, String password, String dbname) throws Exception {

        String response;

        CloudFoundryClient client = init(email, password);
        client.deleteService(dbname);
        response = "deleted";

        return response;
    }
}
