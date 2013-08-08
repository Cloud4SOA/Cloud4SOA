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


package c4soa.adapter;

import beanstalk.Adapter;
import beanstalk.BeansDatabase;
import beanstalk.BeanstalkAdapterException;
import beanstalk.DatabaseObject;
import eu.cloud4soa.adapter.rest.common.HttpStatus;
import eu.cloud4soa.adapter.rest.response.*;
import eu.cloud4soa.adapter.rest.response.model.Application;
import eu.cloud4soa.adapter.rest.response.model.Database;
import eu.cloud4soa.adapter.rest.response.model.Module;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import org.apache.cxf.jaxrs.ext.MessageContext;

/**
 *
 * @author pgouvas
 */
/**
 *
 * @author pgouvas
 */
@Path("/c4s")
public class GenericAdapter {
    ///AWS

    @Context
    private MessageContext context;
    private static String accessKeyId = "";
    private static String secretAccessKey = "";

    @GET
    @Path("/ems/application")
    @Produces({"application/json", "application/xml", "text/plain"})
    public ListApplicationResponse listApplications() {

        return new ListApplicationResponse();
    }

    @GET
    @Path("/ems/application/{appid}")
    @Produces({"application/json", "application/xml", "text/plain"})
    //public void getApplicationDetails(@PathParam("appid") String appid){
    public ListApplicationResponse getApplicationDetails(@PathParam("appid") String appid) {
        String availability = "unknown";
        
        HttpHeaders headers = context.getHttpHeaders();
        List<String> api_key_list = headers.getRequestHeader("apiKey");
        System.out.println("listappheader_api:" + api_key_list);
        String api_as_string = api_key_list.get(0);
        System.out.println("api_as_string:" + api_as_string);
        String splitedStr[] = api_as_string.split("_");
        accessKeyId = splitedStr[0];
        secretAccessKey = splitedStr[1];
        System.out.println("publickey---" + accessKeyId);
        System.out.println("privatekey---" + secretAccessKey);
        
        Boolean av = false;
        long deleteme = 2343;
        try {
            av = Adapter.checkAppAvailability("Beanstalk", accessKeyId, secretAccessKey, "", "", appid, "", "");


            if (av == true) {
                availability = "application name available";
                deleteme = 11111;
            } else if (av == false) {
                availability = "application exists";
                deleteme = 222222;
            }
            availability += "____" + av.toString();
        } catch (BeanstalkAdapterException ex) {
            Logger.getLogger(GenericAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }

        ListApplicationResponse response = new ListApplicationResponse();
        //eu.cloud4soa.adapter.rest.response.model.Application app = new Application();
        //app.setApplicationName(availability);


        response.setResponseTime(deleteme);
        return response;
    }

    @POST
    @Path("/ems/application/{app}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public CreateApplicationResponse createApplication(@PathParam("app") c4soa.resource.Application app) {
        return new CreateApplicationResponse();

    }

    @PUT
    @Path("/ems/application/{app}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public UpdateApplicationResponse updateApplication(@PathParam("app") c4soa.resource.Application app) {
        return new UpdateApplicationResponse();
    }

    @DELETE
    @Path("/ems/application/{appid}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public DeleteApplicationResponse deleteApplication(@PathParam("appid") String appid) {
        DeleteApplicationResponse del_response = new DeleteApplicationResponse();
        HttpHeaders headers = context.getHttpHeaders();
        List<String> api_key_list = headers.getRequestHeader("apiKey");
        System.out.println("listappheader_api:" + api_key_list);
        String api_as_string = api_key_list.get(0);
        System.out.println("api_as_string:" + api_as_string);
        String splitedStr[] = api_as_string.split("_");
        accessKeyId = splitedStr[0];
        secretAccessKey = splitedStr[1];
        System.out.println("publickey---" + accessKeyId);
        System.out.println("privatekey---" + secretAccessKey);
        try {
            ///actually the appName attribute is used
            Adapter.delete("Beanstalk", accessKeyId, secretAccessKey, appid, "", appid);
            del_response.setMessage("Deletion of app(environment):" + appid + " succeess");
        } catch (BeanstalkAdapterException ex) {
            del_response.setMessage("Error in deletion of app(environment):" + appid + ". Exception" + ex.getMessage());
            Logger.getLogger(GenericAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }


        return del_response;
    }

    @DELETE
    @Path("/ems/application/{appid}/deployment/{deploymentName}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public DeleteDeploymentResponse deleteDeployment(@PathParam("appid") String appid, @PathParam("deploymentName") String deployment) {

        HttpHeaders headers = context.getHttpHeaders();
        List<String> api_key_list = headers.getRequestHeader("apiKey");
        System.out.println("listappheader_api:" + api_key_list);
        String api_as_string = api_key_list.get(0);
        System.out.println("api_as_string:" + api_as_string);
        String splitedStr[] = api_as_string.split("_");
        accessKeyId = splitedStr[0];
        secretAccessKey = splitedStr[1];
        System.out.println("publickey---" + accessKeyId);
        System.out.println("privatekey---" + secretAccessKey);
        
        DeleteDeploymentResponse del_response = new DeleteDeploymentResponse();

        try {
            Adapter.delete(Adapter.AWS_BEANSTALK, accessKeyId, secretAccessKey, appid, "", appid);
            del_response.setMessage("Deletion of app(environment):" + appid + "succeess");

        } catch (BeanstalkAdapterException ex) {
            del_response.setMessage("Error in deletion of app(environment):" + appid + ". Exception" + ex.getMessage());
            Logger.getLogger(GenericAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return del_response;
    }

    @POST
    @Path("/ems/application/{appid}/operation/{op}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public OperationResponse StartStopApplication(@PathParam("appid") String appid, @PathParam("op") String operation) {
        OperationResponse response = new OperationResponse();


        HttpHeaders headers = context.getHttpHeaders();
        List<String> api_key_list = headers.getRequestHeader("apiKey");
        System.out.println("listappheader_api:" + api_key_list);
        String api_as_string = api_key_list.get(0);
        System.out.println("api_as_string:" + api_as_string);
        String splitedStr[] = api_as_string.split("_");
        accessKeyId = splitedStr[0];
        secretAccessKey = splitedStr[1];
        System.out.println("publickey---" + accessKeyId);
        System.out.println("privatekey---" + secretAccessKey);

        String appname = appid;
        String version = "0.1";
        if (appid.contains("@_@")) {
            String[] split = appid.split("@_@");
            appname = split[0];
            version = split[1];
        }

        try {
            //START
            if (operation.equalsIgnoreCase("START")) {
                Adapter.start("Beanstalk", accessKeyId, secretAccessKey, "", appname, version, appname, "", "", "", "", "");
                response.setMessage("Started");
            }

            //STOP
            if (operation.equalsIgnoreCase("STOP")) {
                Adapter.stop("Beanstalk", accessKeyId, secretAccessKey, "", appname, "version1.12w6dfg3", appname, "", "", "", "", "");
                response.setMessage("Stopped");
            }
        } catch (BeanstalkAdapterException ex) {
            Logger.getLogger(GenericAdapter.class.getName()).log(Level.SEVERE, null, ex);
            response.setMessage("Error while stopping the application msg:" + ex.getError());
        }



        return response;
    }

    //DATABASE RELATED METHODS
    //Path("/ems/database")
    // /application/${applicationName}/deployment/${deploymentName}/database
    //
    @GET
    @Path("/ems/application/{appid}/deployment/{deploymentName}/database/")
    @Produces({"application/json", "application/xml", "text/plain"})
    public ListDatabaseResponse getDBList() {
        HttpHeaders headers = context.getHttpHeaders();
        List<String> api_key_list = headers.getRequestHeader("apiKey");
        System.out.println("listappheader_api:" + api_key_list);
        String api_as_string = api_key_list.get(0);
        System.out.println("api_as_string:" + api_as_string);
        String splitedStr[] = api_as_string.split("_");
        accessKeyId = splitedStr[0];
        secretAccessKey = splitedStr[1];
        System.out.println("publickey---" + accessKeyId);
        System.out.println("privatekey---" + secretAccessKey);
        ListDatabaseResponse response_list = new ListDatabaseResponse();

        return response_list;

    }


    @GET
    @Path("/ems/application/{appid}/deployment/{deploymentName}/database/{dbid}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public DatabaseResponse getDatabaseDetails(@PathParam("appid") String appid, @PathParam("deploymentName") String deploymentName, @PathParam("dbid") String dbid) {
      
        HttpHeaders headers = context.getHttpHeaders();
        List<String> api_key_list = headers.getRequestHeader("apiKey");
        System.out.println("listappheader_api:" + api_key_list);
        String api_as_string = api_key_list.get(0);
        System.out.println("api_as_string:" + api_as_string);
        String splitedStr[] = api_as_string.split("_");
        accessKeyId = splitedStr[0];
        secretAccessKey = splitedStr[1];
        System.out.println("publickey---" + accessKeyId);
        System.out.println("privatekey---" + secretAccessKey);
            DatabaseObject dbobj = new DatabaseObject();
            BeansDatabase beandb=new BeansDatabase();
            try{
            //beandb.getDBEndpoint(publicKey, secretKey,dbname);
             dbobj = beandb.getDBInstanceInfo(accessKeyId, secretAccessKey,dbid);
                } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
        }


        ///TODO fix, get data from response
      //  Database[] databases = new Database[2];
        ////mock database info
        int i = 0;
        Database db = new Database();
        db.setDatabaseName(dbobj.getDbname());
        db.setHost(dbobj.getDbhost());
        db.setPort(dbobj.getPort().toString());
        //databases[0] = db;
        //////

        DatabaseResponse db_response = new DatabaseResponse();

        db_response.setDatabase(db);
        
        return db_response;
        
    }
    //Path("/ems/database/{db}")   
    @POST
    @Path("/ems/application/{appid}/deployment/{deploymentName}/database/{db}/databaseUser/{dbUser}/databasePassword/{dbPassword}/databaseType/{dbType}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public CreateDatabaseResponse createDatabase(@PathParam("db") String db, @PathParam("dbUser") String dbUser, @PathParam("dbPassword") String dbPassword) {
        HttpHeaders headers = context.getHttpHeaders();
        List<String> api_key_list = headers.getRequestHeader("apiKey");
        System.out.println("listappheader_api:" + api_key_list);
        String api_as_string = api_key_list.get(0);
        System.out.println("api_as_string:" + api_as_string);
        String splitedStr[] = api_as_string.split("_");
        accessKeyId = splitedStr[0];
        secretAccessKey = splitedStr[1];
        System.out.println("cloud4soa_createDatabase called");
        System.out.println("privatekey---" + secretAccessKey);
        System.out.println("privatekey---" + secretAccessKey);
        CreateDatabaseResponse createDB = new CreateDatabaseResponse();
        
        
        //createDB.setDatabase(null);
       BeansDatabase beans_db= new BeansDatabase();
       DatabaseObject dbobj = new DatabaseObject();
       
       dbobj=beans_db.createDatabase(accessKeyId, secretAccessKey,db,"MySQL",db+"cloud4soaid","instance class is ignored",5,dbUser,dbPassword);

       // DatabaseObject dbobj = new DatabaseObject();
        //int i = 0;
        Database db1 = new Database();               
        db1.setDatabaseName(dbobj.getDbname());
        db1.setHost(dbobj.getDbhost());
        db1.setPort(dbobj.getPort().toString());
        createDB.setDatabase(db1);
        

        System.out.println("createdb response:-->"+createDB.toString());
       
        return createDB;
    }

    @PUT
    @Path("/ems/database/{db}")
    @Produces({"application/json", "application/xml", "text/plain"})
    //public UpdateDatabaseResponse updateDatabase(@PathParam("app") c4soa.resource.Database db){
    public UpdateDatabaseResponse updateDatabase(@PathParam("app") String db) {
        return new UpdateDatabaseResponse();
    }

    //Path("/ems/database/{dbid}")    
    @DELETE
    @Path("/ems/application/{appid}/deployment/{deploymentName}/database/{dbid}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public DeleteDatabaseResponse deleteDatabase(@PathParam("dbid") String dbid) {


        return new DeleteDatabaseResponse();

    }

    /*
     * @GET @Path("/monitor/{appid}")
     * @Produces({"application/json","application/xml","text/plain"}) public
     * MonitorResponse getMonitoring(@PathParam("appid") String appid){
     *
     *
     *
     * MonitorResponse monrequest = new MonitorResponse();
     *
     * return monrequest; }
     *
     * @GET @Path("/monitor/{appid}/detail")
     * @Produces({"application/json","application/xml","text/plain"}) public
     * MonitorDetailResponse getMonitoringDetailed(@PathParam("appid") String
     * appid){
     *
     *
     * MonitorDetailResponse monrequest = new MonitorDetailResponse();
     *
     *
     *
     *
     * return monrequest;
    }
     */
    @GET
    @Path("/monitor")
    @Produces({"application/json", "application/xml", "text/plain"})
    public MonitorResponse doMonitoring() {
        MonitorResponse ret = new MonitorResponse();

        Module monitor = new Module();
        monitor.setModuleName("monitor");
        monitor.setDescription("cloud4soa monitoring");
        //monitor.
        ret.setModule(monitor);
        return ret;
    }

    @GET
    @Path("/monitor/detail")
    @Produces({"application/json", "application/xml", "text/plain"})
    public MonitorDetailResponse doDetailedMonitoring() {

        MonitorDetailResponse ret = new MonitorDetailResponse();

        ret.setMessage("everything is fine");
        return ret;
    }
}
