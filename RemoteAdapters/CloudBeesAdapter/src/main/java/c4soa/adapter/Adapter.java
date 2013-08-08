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

import CloudBees.ClientHelper;
import CloudBees.Cloud4SoaException;
import CloudBees.DatabaseObject;
import com.cloudbees.api.BeesClient;
import com.cloudbees.api.DatabaseCreateResponse;
import com.cloudbees.api.DatabaseInfo;
import eu.cloud4soa.adapter.rest.common.HttpStatus;
import eu.cloud4soa.adapter.rest.response.*;
import eu.cloud4soa.adapter.rest.request.*;
import eu.cloud4soa.adapter.rest.response.model.Application;
import eu.cloud4soa.adapter.rest.response.model.Database;
import eu.cloud4soa.adapter.rest.response.model.Metric;
import eu.cloud4soa.adapter.rest.response.model.Module;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.jaxrs.client.ClientWebApplicationException;
import org.apache.cxf.jaxrs.client.ServerWebApplicationException;
import javax.ws.rs.WebApplicationException;
import org.jdom.Element;
import utils.BenchmarkRunner;
import utils.VmMonitoring;

/**
 *
 * @author pgouvas
 */
/**
 *
 * @author pgouvas
 */
@Path("/c4s")
public class Adapter {

    @Context
    private MessageContext context;
    //Hardcoded credentials and any other hardoced stuff must be replace with database interaction
    //methods
    private static String api_key = "5B3C021C879DC288";
    private static String api_secret = "8KQIBWUEHRWTWGEIHI5EVLHCXW3YL3FQ9OYZC1NBER4=";
    private static String accountname = "testurl";//testurl      

    private void headerProcessing() {
        HttpHeaders headers = context.getHttpHeaders();
        List<String> api_key_list = headers.getRequestHeader("apiKey");
        System.out.println("listappheader_api:" + api_key_list);
        String api_as_string = api_key_list.get(0);
        System.out.println("api_as_string:" + api_as_string);
        String splitedStr[] = api_as_string.split("_");
        api_key = splitedStr[0];
        api_secret = splitedStr[1];
        accountname = splitedStr[2];

        System.out.println("publickey---" + api_key);
        System.out.println("privatekey---" + api_secret);
        System.out.println("account---" + accountname);

    }

    @GET
    @Path("/ems/application")
    @Produces({"application/json", "application/xml", "text/plain"})
    public ListApplicationResponse listApplications() throws ClientWebApplicationException {

        String msg = "nothing executed";
        ListApplicationResponse listApplicationResponse = new ListApplicationResponse();

        try {
            ClientHelper BeesClient = new ClientHelper();
            headerProcessing();

            ArrayList applist = BeesClient.ApplicationsList(api_key, api_secret, accountname);
            Application[] appArray = (Application[]) applist.toArray(new Application[applist.size()]);
            listApplicationResponse.setApplications(appArray);
        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            ResponseBuilder builder = javax.ws.rs.core.Response.status(Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error in listing applications.Log from CloudBees :" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");

            throw new WebApplicationException(builder.build());

        }
        //end jled    
        return listApplicationResponse;
    }

    @GET
    @Path("/ems/application/{appid}")
    @Produces({"application/json", "application/xml", "text/plain"})
    //public void getApplicationDetails(@PathParam("appid") String appid){
    public ApplicationResponse getApplicationDetails(@PathParam("appid") String appid) throws ServerWebApplicationException {
        String msg = "nothing executed";
        ApplicationResponse response = new ApplicationResponse();
        try {
            headerProcessing();
            ClientHelper BeesClient = new ClientHelper();
            Application app = BeesClient.ApplicationInfo(api_key, api_secret, accountname, accountname + "/" + appid);

            response.setApplication(app);

        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            ResponseBuilder builder = javax.ws.rs.core.Response.status(Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error in retrieving application details. Log from CloudBees: " + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());

        }

        return response;
    }

    @POST
    @Path("/ems/application/{app}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public CreateApplicationResponse createApplication(@PathParam("appid") String appid) throws WebApplicationException {
        ResponseBuilder builder = javax.ws.rs.core.Response.status(Status.INTERNAL_SERVER_ERROR);
        builder.type("application/xml");
        builder.entity("<error>Creating application not supported on CloudBees</error>");
        throw new WebApplicationException(builder.build());



        //return new CreateApplicationResponse();

    }

    @PUT
    @Path("/ems/application/{app}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public UpdateApplicationResponse updateApplication(@PathParam("app") String app) {
        return new UpdateApplicationResponse();
    }

    @DELETE
    @Path("/ems/application/{appid}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public DeleteApplicationResponse deleteApplication(@PathParam("appid") String appid) {

        DeleteApplicationResponse del_response = new DeleteApplicationResponse();
        String msg = "nothing executed";
        try {
            headerProcessing();

            ClientHelper BeesClient = new ClientHelper();
            msg = BeesClient.DeleteApplication(api_key, api_secret, accountname, accountname + "/" + appid);
            del_response.setStatusCode(HttpStatus.OK);

        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            del_response.setStatusCode(HttpStatus.Expectation_Failed);

            ResponseBuilder builder = javax.ws.rs.core.Response.status(Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while deleting application.Log from CloudBees:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());

        }
        System.out.println("cloubees_list_msg2:" + msg);
        del_response.setMessage(msg);
        return del_response;
    }

    @DELETE
    @Path("/ems/application/{appid}/deployment/{deploymentName}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public DeleteDeploymentResponse deleteDeployment(@PathParam("appid") String appid, @PathParam("deploymentName") String deployment) {

        String msg = "nothing executed";
        DeleteDeploymentResponse del_response = new DeleteDeploymentResponse();

        try {
            headerProcessing();
            ClientHelper BeesClient = new ClientHelper();
            msg = BeesClient.DeleteApplication(api_key, api_secret, accountname, accountname + "/" + appid);
            del_response.setStatusCode(HttpStatus.OK);

        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            del_response.setStatusCode(HttpStatus.Expectation_Failed);

            ResponseBuilder builder = javax.ws.rs.core.Response.status(Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while deleting application.Log from CloudBees:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());
        }
        del_response.setMessage(msg);
        return del_response;
    }

    //changed get to post in order to agree with adapter rest operation response
    @POST
    @Path("/ems/application/{appid}/operation/{op}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public OperationResponse StartStopApplication(@PathParam("appid") String appid, @PathParam("op") String operation) {

        ClientHelper BeesClient = new ClientHelper();
        String msg = "";
        OperationResponse response = new OperationResponse();

        try {
            headerProcessing();
            //START
            if (operation.equalsIgnoreCase("START")) {
                msg = BeesClient.StartStopApplication(api_key, api_secret, accountname, accountname + "/" + appid, "START");
            } //STOP     
            else if (operation.equalsIgnoreCase("STOP")) {
                msg = BeesClient.StartStopApplication(api_key, api_secret, accountname, accountname + "/" + appid, "STOP");
            } else {
                msg = "Operation Not Found";
            }

            response.setMessage(msg);
            response.setStatusCode(HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatusCode(HttpStatus.Expectation_Failed);
            System.out.println("exception msg:" + ex.getMessage());
            System.out.println("exception stack:" + ex.getStackTrace()[0]);
            ResponseBuilder builder = javax.ws.rs.core.Response.status(Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while modifying status of application.Log from CloudBees:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());

        }

        System.out.println("returned message:" + msg);




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
        ListDatabaseResponse response_list = new ListDatabaseResponse();
        try {
            headerProcessing();
            ClientHelper BeesClient = new ClientHelper();
            String msg = "getDBList: nothing executed";
            msg = BeesClient.getDBList(api_key, api_key, accountname);
        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            response_list.setStatusCode(HttpStatus.Internal_Server_Error);

            ResponseBuilder builder = javax.ws.rs.core.Response.status(Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while getting databases list.Log from CloudBees:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());

        }


        ///TODO fix, get data from response
        Database[] databases = new Database[2];
        ////mock database info
        int i = 0;
        Database db = new Database();
        db.setDatabaseName("dbaname");
        db.setHost("dbhostname");
        db.setPort("port");
        databases[0] = db;
        //////


        response_list.setDatabases(databases);
        return response_list;

    }

    @GET
    @Path("/ems/application/{appid}/deployment/{deploymentName}/database/{dbid}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public DatabaseResponse getDatabaseDetails(@PathParam("appid") String appid, @PathParam("deploymentName") String deploymentName, @PathParam("dbid") String dbid) {
        DatabaseResponse db_response = new DatabaseResponse();
        DatabaseObject dbobj = new DatabaseObject();

        try {

            headerProcessing();
            ClientHelper BeesClient = new ClientHelper();

            dbobj = BeesClient.getDBInfo(api_key, api_key, accountname, dbid);
        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);

            ResponseBuilder builder = javax.ws.rs.core.Response.status(Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while retrieving database info.Log from CloudBees:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());

        }


        ///TODO fix, get data from response
        //  Database[] databases = new Database[2];
        ////mock database info
        // int i = 0;
        Database db = new Database();
        db.setDatabaseName(dbobj.getDbname());
        db.setHost(dbobj.getDbhost());
        db.setPort(dbobj.getPort().toString());
        System.out.println("dbhost:" + dbobj.getDbname());
        System.out.println("dbname:" + dbobj.getDbhost());
        //databases[0] = db;
        //////


        db_response.setDatabase(db);

        return db_response;
    }
    //Path("/ems/database/{db}")

    //@Path("/ems/application/{appid}/deployment/{deploymentName}/database/{db}/databaseUser/{dbUser}/databasePassword/{dbPassword}/databaseType/{dbType}")
    @POST
    @Path("/ems/application/{appid}/deployment/{deploymentName}/database/{db}")
    @Produces({"application/json", "application/xml", "text/plain"})
    @Consumes(MediaType.APPLICATION_JSON)
    public CreateDatabaseResponse createDatabase(@PathParam("appid") String appid, @PathParam("deploymentName") String deploymentName, @PathParam("db") String db, CreateDatabaseRequest cdr) {
        //public CreateDatabaseResponse createDatabase(@PathParam("db") c4soa.resource.Database db){




        // CreateDatabaseRequest cdr = context.getContent(CreateDatabaseRequest.class);

        com.cloudbees.api.DatabaseInfo cloudbees_info_resp = null;

        try {
            System.out.println("dbuser" + cdr.getDatabaseUser());
            System.out.println("dbpass" + cdr.getDatabasePassword());
            String dbUser = cdr.getDatabaseUser();
            String dbPassword = cdr.getDatabasePassword();
            ClientHelper BeesClient = new ClientHelper();
            String msg = "getDBList: nothing executed";
            headerProcessing();

            cloudbees_info_resp = BeesClient.operateDatabaseCloudBees("DBCREATE", api_key, api_secret, "", accountname, "", "", db, dbUser, dbPassword);
        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            ResponseBuilder builder = javax.ws.rs.core.Response.status(Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while creating database.Log from CloudBees:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());
        }

        CreateDatabaseResponse createDB = new CreateDatabaseResponse();
        Database database = new Database();
        ///TODO fix mock value hostname
        database.setHost(cloudbees_info_resp.getMaster());
        database.setDatabaseName(cloudbees_info_resp.getName());
        database.setPort(Integer.toString(cloudbees_info_resp.getPort()));
        database.setUserName(cloudbees_info_resp.getOwner());
        database.setPassword(cloudbees_info_resp.getPassword());
        createDB.setDatabase(database);
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
        DeleteDatabaseResponse del_response = new DeleteDatabaseResponse();
        try {

            headerProcessing();
            ClientHelper BeesClient = new ClientHelper();
            String msg = "getDBList: nothing executed";
            BeesClient.operateDatabaseCloudBees("DBDELETE", api_key, api_secret, "", accountname, "", "", dbid, "", "");
            del_response.setMessage("database " + dbid + "deleted");
        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);

            ResponseBuilder builder = javax.ws.rs.core.Response.status(Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while deleting database .Log from CloudBees:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");
            throw new WebApplicationException(builder.build());
        }
        return del_response;

    }

    
    @GET
    @Path("/monitor")
    @Produces({"application/json", "application/xml", "text/plain"})
    public MonitorResponse doMonitoring() {
        MonitorResponse ret = new MonitorResponse();

        Module monitor = new Module();
        monitor.setModuleName("monitor");
        monitor.setDescription("cloud4soa monitoring");
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

    @GET
    @Path("/benchmark")
    @Produces({"application/json", "application/xml", "text/plain"})
    public MonitorDetailResponse doSimpleBenchmark() throws ClientWebApplicationException {
        MonitorDetailResponse ret = new MonitorDetailResponse();
        String benchmark = "";


        try {
            BenchmarkRunner bench = new BenchmarkRunner();
            Long benchLong = bench.benchmark();
            benchmark = Long.toString(benchLong);
            System.out.println("benchmark score:" + benchmark);
        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            ResponseBuilder builder = javax.ws.rs.core.Response.status(Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while executing the Cloud4SOA Benchmark :" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");

            throw new WebApplicationException(builder.build());
        }
        System.out.println("benchmark score2:" + benchmark);

        ret.setMessage("everything is fine, execution time:" + benchmark);
        return ret;
    }

    @GET
    @Path("/monitor/jvm")
    @Produces({"application/json", "application/xml", "text/plain"})
    public MonitorDetailResponse doJVMMonitoring() throws ClientWebApplicationException {
        MonitorDetailResponse ret = new MonitorDetailResponse();
        String value = "";


        try {
            VmMonitoring vm = new VmMonitoring();
            Element returnMonitoringInfo = vm.returnMonitoringInfo();
            value = returnMonitoringInfo.getChild("threads").getAttributeValue("opsys-system-load-avg");
            value += "," + returnMonitoringInfo.getChild("threads").getAttributeValue("total-cpu-percent");
            value += "," + returnMonitoringInfo.getChild("threads").getAttributeValue("heap-memory-max");
            value += "," + returnMonitoringInfo.getChild("threads").getAttributeValue("nonheap-memory-used");
            System.out.println("value" + value);
        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            ResponseBuilder builder = javax.ws.rs.core.Response.status(Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while executing the Cloud4SOA Benchmark :" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");

            throw new WebApplicationException(builder.build());
        }

        ret.setMessage("everything is fine, return:" + value);
        return ret;
    }

    @GET
    @Path("/monitor/pingicmp")
    @Produces({"application/json", "application/xml", "text/plain"})
    public MonitorDetailResponse doPingIcmp() throws ClientWebApplicationException {
        MonitorDetailResponse ret = new MonitorDetailResponse();
        String value = "";


        try {
            VmMonitoring vm = new VmMonitoring();
            long pingICMP = vm.pingICMP();
            value = "" + pingICMP;
            System.out.println("value" + value);
        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            ResponseBuilder builder = javax.ws.rs.core.Response.status(Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while executing the Cloud4SOA Benchmark :" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");

            throw new WebApplicationException(builder.build());
        }

        ret.setMessage("everything is fine, ping:" + value);
        return ret;
    }

    @GET
    @Path("/monitor/ping")
    @Produces({"application/json", "application/xml", "text/plain"})
    public MonitorDetailResponse doPingResponse(@QueryParam("adapterurl") String url) throws ClientWebApplicationException {
        MonitorDetailResponse ret = new MonitorDetailResponse();
        String value = "";


        try {
            VmMonitoring vm = new VmMonitoring(url);
            long pingresponse = vm.pingForResponse();
            value = "" + pingresponse;
            System.out.println("value" + value);
        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            ResponseBuilder builder = javax.ws.rs.core.Response.status(Status.INTERNAL_SERVER_ERROR);
            builder.type("application/xml");
            builder.entity("<error>Error while executing the Cloud4SOA Benchmark :" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");

            throw new WebApplicationException(builder.build());
        }

        ret.setMessage("everything is fine, ping:" + value);
        return ret;
    }

    @GET
    @Path("/monitor/extend/{applicationUrl}")
    @Produces({"application/json", "application/xml", "text/plain"})
    public ExtendedMonitorResponse doExtendedMonitoring(@PathParam("applicationUrl") String applicationUrl) throws ClientWebApplicationException {
        ExtendedMonitorResponse ret = new ExtendedMonitorResponse();
        String cpu_load = "";
        String memory_load = "";
        String cloudResponseTime = "";
        String containerResponseTime = "";


        //first try to get these metrics from the application
        VmMonitoring vm = new VmMonitoring();
        if ((applicationUrl != null && !"".equals(applicationUrl)) && vm.checkAppMetricsAvailability(applicationUrl) == 200) {
            Metric[] metrics = vm.getMetricsFromApp(applicationUrl);
            ret.setMetrics(metrics);

            ret.setMessage("metrics retrieved from application");

        } else {

            try {

                //metricsstring =vm.getMetricsFromApp();

                //VmMonitoring vm= new VmMonitoring();
                Element returnMonitoringInfo = vm.returnMonitoringInfo();
                cpu_load = returnMonitoringInfo.getChild("threads").getAttributeValue("total-cpu-percent");
                memory_load = returnMonitoringInfo.getChild("threads").getAttributeValue("heap-memory-max");
                String nonheap_memory = returnMonitoringInfo.getChild("threads").getAttributeValue("nonheap-memory-used");
                long pingresponse = vm.pingForResponse();
                containerResponseTime = "" + pingresponse;
                long pingICMP = vm.pingICMP();
                cloudResponseTime = "" + pingICMP;

            } catch (Exception ex) {
                Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
                ResponseBuilder builder = javax.ws.rs.core.Response.status(Status.INTERNAL_SERVER_ERROR);
                builder.type("application/xml");
                builder.entity("<error>Error while trying to get metrics from the adapter:" + ex.getMessage() + ". StackTrace: " + ex.getStackTrace()[0] + "</error>");

                throw new WebApplicationException(builder.build());
            }
            Metric[] metrics = new Metric[4];
            Metric cpuMetric = new Metric();
            cpuMetric.setMetricName("CPU_Load");
            cpuMetric.setValue(cpu_load);
            Metric memMetric = new Metric();
            memMetric.setMetricName("Memory_Load");
            memMetric.setValue(memory_load);
            Metric cloudMetric = new Metric();
            cloudMetric.setMetricName("CloudResponseTime");
            cloudMetric.setValue(cloudResponseTime);
            Metric containerMetric = new Metric();
            containerMetric.setMetricName("ContainerResponseTime");
            containerMetric.setValue(containerResponseTime);

            metrics[0] = cpuMetric;
            metrics[1] = memMetric;
            metrics[2] = cloudMetric;
            metrics[3] = containerMetric;
            ret.setMetrics(metrics);

            ret.setMessage("metric retrieved from adapter");


        }

        return ret;
    }
}
