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


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CloudBees;



import com.cloudbees.api.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ParseXmlString;
import eu.cloud4soa.adapter.rest.response.model.Application;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jled
 */
public class ClientHelper {
    
    String bees_server= "https://api.cloudbees.com/api";
    String apiversion = "1.0";
    String type = "xml";
    
    
    

    
        public Application ApplicationInfo(String ApiKey, String SecretKey,
            String account, String appname) throws Exception
        {
        Application app= new Application();    
        BeesClient client = new BeesClient(bees_server, ApiKey, SecretKey, type, apiversion);    
        //Properties properties;    
        ApplicationInfo response = client.applicationInfo(appname);
        System.out.println(response);
        app.setApplicationName(response.getTitle());
        app.setUrl(response.getUrls()[0]);
        app.setCreated(response.getCreated().toString());
        app.setLanguage("Java");
        return app;
    }
    
        public ArrayList<Application> ApplicationsList(String ApiKey, String SecretKey,
            String account) throws Exception
        {
        ArrayList<Application> applist = new ArrayList<Application>();
            
        BeesClient client = new BeesClient(bees_server, ApiKey, SecretKey, type, apiversion);    
        //Properties properties;    
        String ret ="nothing to return";
        ApplicationListResponse response = client.applicationList();
        System.out.println(response);
        for (int i=0;i<response.getApplications().size();i++){
            System.out.println("i="+i);
        ApplicationInfo appInfo = response.getApplications().get(i);
        Application app= new Application();
        app.setApplicationName(appInfo.getTitle());
        String []urls=appInfo.getUrls();
        app.setUrl(urls[0]);
        app.setCreated(appInfo.getCreated().toString());
        app.setLanguage("Java");
        applist.add(app);
        
        }
        
        return applist;
    }
    
        public String StartStopApplication (String ApiKey, String SecretKey,
            String account,String appname, String method) throws Exception
        {

        BeesClient client = new BeesClient(bees_server, ApiKey, SecretKey, type, apiversion);    
        //Properties properties;    
        String ret ="nothing to return";
        
        ApplicationStatusResponse response =null;
        if (method.equalsIgnoreCase("START"))
        response = client.applicationStart(appname);
        
        if (method.equalsIgnoreCase("STOP"))
        response = client.applicationStop(appname);
        
        
        System.out.println(response);
        ret = response.getStatus();
        
        return ret;
    }
    
    
        public String DeleteApplication (String ApiKey, String SecretKey,
            String account,String appname) throws Exception
        {

        BeesClient client = new BeesClient(bees_server, ApiKey, SecretKey, type, apiversion);    
        //Properties properties;    
        String ret ="nothing to return";
        
        ApplicationDeleteResponse response = client.applicationDelete(appname);

        ret = "Application not deleted";

        System.out.println(response);
        if(response.isDeleted()==true){ 
        ret="Application Deleted";
        }
                
        
        return ret;
    }
    
    
        
    
        public String getDBList(String ApiKey, String SecretKey,
            String account) throws Exception
        {

        BeesClient client = new BeesClient(bees_server, ApiKey, SecretKey, type, apiversion);    
        //Properties properties;    
        String ret ="nothing to return";
        DatabaseListResponse response = client.databaseList(account);
        System.out.println(response);
        String dbname = response.getDatabases().get(0).getName();
        ret=dbname;
        return ret;
    }        
    
        public DatabaseObject getDBInfo(String ApiKey, String SecretKey,
            String account,String dbname) throws Exception
        {
        DatabaseObject dbobj = new DatabaseObject();

        BeesClient client = new BeesClient(bees_server, ApiKey, SecretKey, type, apiversion);    
        DatabaseInfo response = client.databaseInfo(dbname, false);
        System.out.println(response);
        dbobj.setDbhost(response.getMaster());
        dbobj.setPort(response.getPort());
        dbobj.setDbname(response.getName());

        return dbobj;
    }        

    
     public String deployCloudBees(String war, String ApiKey, String SecretKey, String applicationname,
            String account,String type, String apiversion, String description) throws Cloud4SoaException {
        String ret = "";


       String bees_server= "https://api.cloudbees.com/api";


        ///default type= xml
        if (type.equalsIgnoreCase("")) {
            type = "xml";
        }

        ///default apiversion= 1.0
        if (apiversion.equalsIgnoreCase("")) {
            apiversion = "1.0";
        }
        ///default applicationname= account
        if (applicationname.equalsIgnoreCase("")) {
            applicationname = account+"-cloud4soa-app";
        }



       //create app_id literal in the form of username/applicationname
       String app_id=account+"/"+applicationname;
       //what is environment is not quite clear. Sees like environment is the account name, that is the second part of the created link
       String environment=account;

       BeesClient bees= new BeesClient(bees_server, ApiKey, SecretKey, type, apiversion);
        try {
            bees.applicationDeployWar(app_id, environment, description, war, null, null);
            // return deployed;
        } catch (Exception ex) {
            //Logger.getLogger(ClientHelper.class.getName()).log(Level.SEVERE, null, ex);
            throw new Cloud4SoaException( ex.getMessage());

        }

       utils.ParseXmlString parser=new ParseXmlString();
//      String url= parser.parse(bees.xml_response, "ApplicationDeployArchiveResponse", "url");
       String url="mock_url";
      System.out.println("Application deployed with URL: "+url);

      ret=url;
      return ret;
    }

    ///eom DeployCloudBees



    public String operateCloudBees(String Operation,String ApiKey, String SecretKey, String applicationname,
            String account,String type, String apiversion) throws Cloud4SoaException {

        String ret="";
        String cloudbees_resp="";

       String bees_server= "https://api.cloudbees.com/api";


        ///default type= xml
        if (type.equalsIgnoreCase("")) {
            type = "xml";
        }

        ///default apiversion= 1.0
        if (apiversion.equalsIgnoreCase("")) {
            apiversion = "1.0";
        }
        ///default applicationname= account
        if (applicationname.equalsIgnoreCase("")) {
            applicationname = account+"-cloud4soa-app";
        }



       //create app_id literal in the form of username/applicationname
       String app_id=account+"/"+applicationname;
       //what is environment is not quite clear. Sees like environment is the account name, that is the second part of the created link
       String environment=account;

       BeesClient bees= new BeesClient(bees_server, ApiKey, SecretKey, type, apiversion);
       utils.ParseXmlString parser=new ParseXmlString();

        try {
            if(Operation.equalsIgnoreCase("START")){
            bees.applicationStart(app_id);
            //cloudbees_resp=parser.parse(bees.xml_response, "ApplicationStatusResponse", "status");
            }
            if(Operation.equalsIgnoreCase("STOP")){
            bees.applicationStop(app_id);
            //cloudbees_resp=parser.parse(bees.xml_response, "ApplicationStatusResponse", "status");
            }
            if(Operation.equalsIgnoreCase("DELETE")){
            bees.applicationDelete(app_id);
            //cloudbees_resp=parser.parse(bees.xml_response, "ApplicationDeleteResponse", "deleted");
            }
            if(Operation.equalsIgnoreCase("INFO")){
            bees.applicationInfo(app_id);
//            cloudbees_resp=parser.parse(bees.xml_response, "application", "status");
            }
            if(Operation.equalsIgnoreCase("RESTART"))
            bees.applicationRestart(app_id);

            if(Operation.equalsIgnoreCase("LIST")){
            bees.applicationList();
//            cloudbees_resp=parser.parse(bees.xml_response, "ApplicationListResponse", "status");
            }
        } catch (Exception ex) {
      //      Logger.getLogger(ClientHelper.class.getName()).log(Level.SEVERE, null, ex);
                    throw new Cloud4SoaException( ex.getMessage());

        }

     ret= cloudbees_resp;
     return ret;
    }//eom OperateCloudBees

    public DatabaseInfo operateDatabaseCloudBees(String Operation,String ApiKey, String SecretKey, String applicationname,
            String account,String type, String apiversion,String dbname,String dbuser, String dbpassport) throws Cloud4SoaException {

        DatabaseInfo db_inf=null;

       String bees_server= "https://api.cloudbees.com/api";
       String msg="";

        ///default type= xml
        if (type.equalsIgnoreCase("")) {
            type = "xml";
        }

        ///default apiversion= 1.0
        if (apiversion.equalsIgnoreCase("")) {
            apiversion = "1.0";
        }
        ///default applicationname= account
        if (applicationname.equalsIgnoreCase("")) {
            applicationname = account+"-cloud4soa-app";
        }

        ///default applicationname= account
        if (dbuser.equalsIgnoreCase("")) {
            dbuser = account+"dbuser";
        }
        if (dbuser.equalsIgnoreCase("")) {
            dbuser = account+"dbuser";
        }



       //create app_id literal in the form of username/applicationname
       String app_id=account+"/"+applicationname;
       //what is environment is not quite clear. Sees like environment is the account name, that is the second part of the created link
       String environment=account;
       DatabaseCreateResponse Cloudbees_db_resp = new DatabaseCreateResponse();
       BeesClient bees= new BeesClient(bees_server, ApiKey, SecretKey, type, apiversion);
       //utils.ParseXmlString parser=new ParseXmlString();

        try {
///////////////////START DB OPERATIONS///////////////////////////////////////
           if(Operation.equalsIgnoreCase("DBCREATE")){
            Cloudbees_db_resp= bees.databaseCreate(account, dbname, dbuser, dbpassport);
            //we use the dbid in order to get the rest info
            Cloudbees_db_resp.getDatabaseId();
            db_inf= bees.databaseInfo(Cloudbees_db_resp.getDatabaseId(), true);
            
           // parser.parse(bees.xml_response, "DatabaseCreateResponse", "databaseId");
            }

           if(Operation.equalsIgnoreCase("DBLIST")){
            bees.databaseList();
               //bees.database("ec2-174-129-9-255.compute-1.amazonaws.com", "cloud4soadb2", "cloud4soauser", "password");
            //parser.parse(bees.xml_response, "DatabaseListResponse", "databaseId");
            }
           if (Operation.equalsIgnoreCase("DBINFO")) {
                db_inf = bees.databaseInfo(dbname, false);
                //dbobj.setDbhost(cloudbeesbdinfo.getMaster());
                //dbobj.setPort(cloudbeesbdinfo.getPort());
                //dbobj.setDbname(cloudbeesbdinfo.getName());

            }

           if(Operation.equalsIgnoreCase("DBDELETE")){

           bees.databaseDelete(dbname);
               //bees.database("ec2-174-129-9-255.compute-1.amazonaws.com", "cloud4soadb2", "cloud4soauser", "password");
            //parser.parse(bees.xml_response, "DatabaseListResponse", "databaseId");
            }
///////////////////END DB OPERATIONS/////////////////////////////////////////

///////////////////START BACKUP OPERATIONS///////////////////////////////////////
///////////////////END BACKUP OPERATIONS/////////////////////////////////////////

        } catch (Exception ex) {
        //Logger.getLogger(ClientHelper.class.getName()).log(Level.SEVERE, null, ex);
             throw new Cloud4SoaException( ex.getMessage());
      
        }

        return db_inf;

    }//eom OperateDatabaseCloudBees

   
    
    
    
}
