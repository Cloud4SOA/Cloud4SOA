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
package beanstalk;

import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import utils.DatabaseHelper;
import utils.ParseXmlString;
import beanstalk.BeansCheckDNSAvailabity;
import beanstalk.BeansCreateApplicationVersion;
import beanstalk.BeansDatabase;
import beanstalk.BeansDeleteApplicationVersion;
import beanstalk.BeansDescribeApplicationVersions;
import beanstalk.BeansDescribeEnvironments;
import beanstalk.BeansManageAppVersions;
import beanstalk.BeansStartApp;
import beanstalk.BeansUpdateEnvironment;
import beanstalk.BeanstalkDeployNoGUI;





/**
 *
 * @author jled
 */
public class Adapter {


    public static final String STOP_MOCKED="1234567";
    public static final String AWS_BEANSTALK="Beanstalk";
    public static final String CLOUDBEES_RUN="CloudBees";
    public static final String GAE="GoogleAppengine";
    public static final String CLOUDCONTROL="CloudControl";
    public static final String OPENSHIFT_X="OpenShift";//OpenShift Express
    /*
     * please try to define homogeneous objects which binds all needed properties
     * felt to use one hundred pieces of strings as parameter of methods does not make really sense for me
     * (dn)
     */


/////////////////////////////////////////////////////////////////////////
/////                                                        ////////////
///// Methods implemented in this class are described in WP6 ////////////
/////                                                        ////////////
////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////
//                 Information for CloudControl
// in this class the methods are called.In each method of Cloud4SOA Adapter API there is a case
// for CloudControl.Inside these cases CloudControl methods should be called, using any of the
// available attributes, or adding some more in case needed.
// Auxiliary classes is proposed to be created in package cloudcontrol. There cloudcontrol API can be
// called and methods that are called from this class(Adapter.class) can be implemented.
// More information about what each method does can be found in WP6 documents. (d6.1 and d6.2)
// Implemented methods can be tested through Tester class of package cloudadapter, or by implementing the appropriate method
// changes in project eu.cloud4soa.governance.ems class ExecutionManagementServiceModule, in order to
// have this methods used from Cloud4SOA project.
/////////////////////////////////////////////////////////////////////////






////////////////////////START OF API METHODS/////////////////////////

   public static String uploadAndDeployToEnv(String PaaS,String war, String publicKey, String secretKey, String accountName,String appName, String appVersion,
            String environment, String bucket, String host,String type, String apiversion, String description) throws BeanstalkAdapterException{
       String ret = "";
       String url="";
       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){



           // fix in order to keep it simple
           //no environment name needed, just the application will do the work
           environment=appName;


           //TODO check if application exists-> if exists call update, else call commit

           //check if environment(appname url) exists-> if exists call update, else call commit
       BeansCheckDNSAvailabity check_availability = new BeansCheckDNSAvailabity(publicKey, secretKey, environment);

       Boolean tmp=check_availability.CheckAvailability();
       Boolean app_exists=!tmp;

           if(app_exists==false){
               System.out.println("Creating application for AWS Beanstalk");
           AuxAdapter.commitBeanstalk(war, publicKey, secretKey, appName, appVersion, environment, bucket, host);
           } else if(app_exists==true){
               System.out.println("Updating application for AWS Beanstalk");
           AuxAdapter.updateBeanstalk(war, publicKey, secretKey, appName, appVersion, environment, bucket, host);
           }
       ///TODO store in a table the pairing between appname and appversion whenever doing deploying an application
       ///then we can stop and start again the latest application version that was deployed
       /// Table must be stored in a file in local filesystem or even better online(in user's aws filesystem)
           BeansManageAppVersions beans_versioning = new BeansManageAppVersions();
           beans_versioning.storeVersion(appName, appVersion, environment);
           url="http://"+environment+".elasticbeanstalk.com/";

       }//end if beanstalk
    
       ret= url;
       return ret;
   }//eom uploadAndDeployToEnv
   //////////////////////////////////////////////////////////////////////////////////


   public static String deploy(String PaaS,String war, String publicKey, String secretKey, String accountName,String appName, String appVersion,
            String environment, String bucket, String host,String type, String apiversion, String description)throws BeanstalkAdapterException{
       String ret = "";
       String url="";
       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){



           // fix in order to keep it simple
           //no environment name needed, just the application will do the work
           environment=appName;


           //TODO check if application exists-> if exists call update, else call commit

           //check if environment(appname url) exists-> if exists call update, else call commit
       BeansCheckDNSAvailabity check_availability = new BeansCheckDNSAvailabity(publicKey, secretKey, environment);

       Boolean tmp=check_availability.CheckAvailability();
       Boolean app_exists=!tmp;

           if(app_exists==false){
               System.out.println("Creating application for AWS Beanstalk");
           AuxAdapter.commitBeanstalk("no_path_given", publicKey, secretKey, appName, appVersion, environment, bucket, host);
           } else if(app_exists==true){
               System.out.println("Updating application for AWS Beanstalk");
           AuxAdapter.updateBeanstalk("no_path_given", publicKey, secretKey, appName, appVersion, environment, bucket, host);
           }
       ///TODO store in a table the pairing between appname and appversion whenever doing deploying an application
       ///then we can stop and start again the latest application version that was deployed
       /// Table must be stored in a file in local filesystem or even better online(in user's aws filesystem)
           BeansManageAppVersions beans_versioning = new BeansManageAppVersions();
           beans_versioning.storeVersion(appName, appVersion, environment);
           url="http://"+environment+".elasticbeanstalk.com/";

       }//end if beanstalk
     

       ret= url;
       return ret;
   }//eom deploy
   //////////////////////////////////////////////////////////////////////////////////


   public static String deployToEnv(String PaaS,String war, String publicKey, String secretKey, String accountName,String appName, String appVersion,
            String environment, String bucket, String host,String type, String apiversion, String description)throws BeanstalkAdapterException{
       String ret = "";
       String url="";
       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){



           // fix in order to keep it simple
           //no environment name needed, just the application will do the work
           environment=appName;


           //TODO check if application exists-> if exists call update, else call commit

           //check if environment(appname url) exists-> if exists call update, else call commit
       BeansCheckDNSAvailabity check_availability = new BeansCheckDNSAvailabity(publicKey, secretKey, environment);

       Boolean tmp=check_availability.CheckAvailability();
       Boolean app_exists=!tmp;

           if(app_exists==false){
               System.out.println("Creating application for AWS Beanstalk");
           AuxAdapter.commitBeanstalk("no_path_given", publicKey, secretKey, appName, appVersion, environment, bucket, host);
           } else if(app_exists==true){
               System.out.println("Updating application for AWS Beanstalk");
           AuxAdapter.updateBeanstalk("no_path_given", publicKey, secretKey, appName, appVersion, environment, bucket, host);
           }
       ///TODO store in a table the pairing between appname and appversion whenever doing deploying an application
       ///then we can stop and start again the latest application version that was deployed
       /// Table must be stored in a file in local filesystem or even better online(in user's aws filesystem)
           BeansManageAppVersions beans_versioning = new BeansManageAppVersions();
           beans_versioning.storeVersion(appName, appVersion, environment);
           url="http://"+environment+".elasticbeanstalk.com/";

       }//end if beanstalk
     

       ret= url;
       return ret;
   }//eom deployToEnv
   //////////////////////////////////////////////////////////////////////////////////
   

   public static String undeploy(String PaaS,String war, String publicKey, String secretKey, String accountName,String appName, String appVersion,
            String environment, String bucket, String host,String type, String apiversion, String description)throws BeanstalkAdapterException{
       String ret = "";
       String url="";
       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
           //TODO also delete the version file

       }//end if beanstalk


       ret= url;
       return ret;
   }//eom undeploy
   //////////////////////////////////////////////////////////////////////////////////

    
    public static String attachEnvironment(String PaaS)throws BeanstalkAdapterException{
        String ret="";
        if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
       //AWS_BEANSTALK code here

       }
    
        return ret;
    }//eom attachEnvironment




   public static String stop(String PaaS,String publicKey, String secretKey, String accountName,String appName, String appVersion,
            String environment, String bucket, String host,String type, String apiversion, String description)throws BeanstalkAdapterException{
       String ret = null;



       //should keep current version also for future restarts
       //current version could be stored within the stopapp.war
       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){




           // fix in order to keep it simple
           //no environment name needed, just the application will do the work
           environment=appName;




       ///TODO: keep Working version before stop

       //Create unique version for StopApp.war
        String autogen=UUID.randomUUID().toString().replaceAll("-", "");
        String stop_unique_version = "version.stop." + autogen.toUpperCase();
        //TODO
        //Don't upload StopApp every time stop is called, just update environment with existing

       AuxAdapter.updateBeanstalk(STOP_MOCKED, publicKey, secretKey, appName, stop_unique_version, environment, bucket, host);
       }
      
       return ret;
   }//eom stop
   //////////////////////////////////////////////////////////////////////////////////

   public static String start(String PaaS,String publicKey, String secretKey, String accountName,String appName, String appVersion,
            String environment, String bucket, String host,String type, String apiversion, String description)throws BeanstalkAdapterException{
       String ret = null;


       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){


           // fix in order to keep it simple
           //no environment name needed, just the application will do the work
           environment=appName;




      BeansManageAppVersions beans_versioning = new BeansManageAppVersions();
      //get last version that worked. can also provide list of other version to choose from
     // String latest_version=beans_versioning.findLatestVersion(appName, environment);
      BeansStartApp bst = new BeansStartApp();

      bst.startApp(publicKey, secretKey, appName, appVersion, environment);
              
       }
      


       return ret;
   }//eom start
   //////////////////////////////////////////////////////////////////////////////////

   
   public static String delete(String PaaS,String publicKey, String secretKey, String appName, String appVersion,
            String environment)throws BeanstalkAdapterException{

       String ret = "";
       String resp="";

       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
           //System.out.println("Not implemented yet.");



           // fix in order to keep it simple
           //no environment name needed, just the application will do the work
           environment=appName;


           //TODO also delete the version file
           AuxAdapter.deleteBeanstalk( publicKey, secretKey, environment);
       }

       ret=resp;
       return ret;
   }//eom delete
  //////////////////////////////////////////////////////////////////////////////////



   public static String listApplications(String PaaS,String publicKey, String secretKey, String accountName,String appName, String appVersion,
            String environment, String bucket, String host,String type, String apiversion, String description)throws BeanstalkAdapterException{
       String ret = null;


       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
     //  CreateAppVersionBeanstalk(war, publicKey, secretKey, appName, appVersion, environment, bucket, host);
       }

       //CloudControl code here
       return ret;
   }//eom list applications
   //////////////////////////////////////////////////////////////////////////////////

   
   public static Boolean checkAppAvailability(String PaaS, String publicKey, String secretKey, String accountName,String appName, 
            String environment, String type, String apiversion)throws BeanstalkAdapterException{
       Boolean ret = null;


       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
     //  CreateAppVersionBeanstalk(war, publicKey, secretKey, appName, appVersion, environment, bucket, host);

       BeansCheckDNSAvailabity check_availability = new BeansCheckDNSAvailabity(publicKey, secretKey, environment);
       ret=check_availability.CheckAvailability();

       }
      
       return ret;
   }//eom checkAppAvailability
   /////////////////////////////////////////////////////////////////////////////
   
   
   public static String getAppURL(String PaaS, String publicKey, String secretKey, String accountName,String appName,
            String environment, String type, String apiversion) throws BeanstalkAdapterException{
       String ret = "";


     
       
       return ret;
   }
   
   
   public static String getAppStatus(String PaaS, String publicKey, String secretKey, String accountName,String appName,
            String environment, String type, String apiversion)throws BeanstalkAdapterException{
       String ret = "";

       String status="";
       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
             beanstalk.BeansDescribeEnvironments bst= new BeansDescribeEnvironments();
             String aws_resp=bst.getEnvironments(publicKey, secretKey, appName,"","","");
             utils.ParseXmlString parser=new ParseXmlString();
             status=parser.parse(aws_resp, "DescribeEnvironmentsResult", "Status");

       }

       ret=status;       
       return ret;
   }//eom getAppStatus

   public static String getRunningStatus(String PaaS, String publicKey, String secretKey, String accountName,String appName,
            String environment, String type, String apiversion)throws BeanstalkAdapterException{
       String ret = "";

       String status="";
       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){

             //TODO: at first find the where is the running application

             beanstalk.BeansDescribeEnvironments bst= new BeansDescribeEnvironments();
             String aws_resp=bst.getEnvironments(publicKey, secretKey, appName,"","","");
             utils.ParseXmlString parser=new ParseXmlString();
             status=parser.parse(aws_resp, "DescribeEnvironmentsResult", "Status");

       }
      
       ret=status;
       return ret;
   }///getRunningStatus

   public static String getAppStatistics(String PaaS, String publicKey, String secretKey, String accountName,String appName,
            String environment, String type, String apiversion)throws BeanstalkAdapterException{
       String ret = "";


       ///Getting statistics stored from Cloud4Soa monitoring thread


       
       String stats="";
       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){

       }
       else if (PaaS.equalsIgnoreCase(CLOUDBEES_RUN)){
       
       }

       else if (PaaS.equalsIgnoreCase(CLOUDCONTROL)){
       //CloudControl code here
       //if there is a method available that fetch statistics it can be used here--However, statistics
       //stored from Cloud4Soa monitoring thread will be retrieved for all providers

       }

       ///////////////code to unify status responses of PaaSes

       //ParseXmlString parser= new ParseXmlString();
       //ret=parser.parse(cloudbees_status, "error", "message");

       ret=stats;
       return ret;
   }//eom getAppStatistics
/////////////////////////////////////////////////////////////////////////////////////

   public static String getSummaryStatistics(String PaaS, String publicKey, String secretKey, String accountName,String appName,
            String environment, String type, String apiversion)throws BeanstalkAdapterException{
       String ret = "";


       ///Getting statistics stored from Cloud4Soa monitoring thread, for all version that application had



       String stats="";
       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){

       }
       else if (PaaS.equalsIgnoreCase(CLOUDBEES_RUN)){

       }

       else if (PaaS.equalsIgnoreCase(CLOUDCONTROL)){
       //CloudControl code here
       //if there is a method available that fetch statistics it can be used here--However, statistics
       //stored from Cloud4Soa monitoring thread will be retrieved for all providers

       }

       ///////////////code to unify status responses of PaaSes

       //ParseXmlString parser= new ParseXmlString();
       //ret=parser.parse(cloudbees_status, "error", "message");

       ret=stats;
       return ret;
   }//eom getSummaryStatistics
/////////////////////////////////////////////////////////////////////////////////////


//////////////DB RELATED METHODS//////////////////


   public static String createDB(String PaaS,String publicKey, String secretKey, String accountName, String host,String type,
           String apiversion, String description,String dbname,String dbuser,String dbpassword)throws BeanstalkAdapterException{
       String ret = null;



       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
       
       BeansDatabase beans_db= new BeansDatabase();
       beans_db.createDatabase(publicKey, secretKey,dbname,"MySQL",dbname+"cloud4soaid","instance class is ignored",5,dbuser,dbpassword);


       ///temporary fix in order to have an ip inserted in the database list
      // String myip="91.132.244.150/5";
       String acceptallips="0.0.0.0/0";
       beanstalk.BeansDatabase beansdb= new BeansDatabase();
       beans_db.allowIPConnectionWithDB(publicKey, secretKey, acceptallips);
       }

       return ret;
   }
   
   
   
    public static DatabaseObject getDBInfo(String PaaS, String publicKey, String secretKey, String accountName, String host, String dbtype,
            String apiversion, String description, String dbname, String dbuser, String dbpassword) throws BeanstalkAdapterException {
        DatabaseObject dbObject = new DatabaseObject();

            //
            BeansDatabase beandb=new BeansDatabase();
            //beandb.getDBEndpoint(publicKey, secretKey,dbname);
             dbObject = beandb.getDBInstanceInfo(publicKey, secretKey,dbname);

        return dbObject;
    }

   public static String getDBList(String PaaS,String publicKey, String secretKey, String accountName, String host,String type, 
           String apiversion, String description,String dbname,String dbuser,String dbpassword)throws BeanstalkAdapterException{
       String ret = null;

       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
       //
       }
      
       return ret;
   }

   public static String deleteDB(String PaaS,String publicKey, String secretKey, String accountName, String host,String type,
           String apiversion, String description,String dbname,String dbuser,String dbpassword)throws BeanstalkAdapterException{
       String ret = null;

       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){

       BeansDatabase beans_db= new BeansDatabase();
       
       beans_db.deleteDatabase(publicKey, secretKey,dbname+"cloud4soaid");

       }
    
       return ret;
   }

   public static String downloadDB(String PaaS,String publicKey, String secretKey, String accountName, String host,
           String type, String apiversion, String description,String dbname,String dbuser,String dbpassword,String localfile)throws BeanstalkAdapterException{
       String ret = null;

       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
     //  CreateAppVersionBeanstalk(war, publicKey, secretKey, appName, appVersion, environment, bucket, host);
              utils.DatabaseHelper dbhelp = new DatabaseHelper();
            try {
            String hostname= dbname+"cloud4soaid"+".coaodqyxxykq.us-east-1.rds.amazonaws.com";
            //String hostname= "mydbnamecloud4soaid.coaodqyxxykq.us-east-1.rds.amazonaws.com";

             dbhelp.storeDB(hostname, "3306", dbuser, dbpassword, dbname,localfile);
              //String db_content=dbhelp.getData(hostname, port, db_user, db_user_password, database);
                //System.out.println("db_content"+db_content);

            } catch (Exception ex) {
                Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       else if (PaaS.equalsIgnoreCase(CLOUDBEES_RUN)){
      // OperateCloudBees("DBLIST", publicKey, secretKey, "", accountName, type, apiversion);
          /* String hostname="localhost";
           String port="3306";
           String database="cloud4soa";
           String db_user="root";
           String db_user_password="!uflow!";
           * */

           String hostname="ec2-174-129-9-255.compute-1.amazonaws.com";
           String port="3306";
           //String database="cloud4soadb1";
          // String db_user="cloud4soauser";
           //String db_user_password="password";
           //logika 8a exw 8ema me paths pou exoun keno.fix this later
           //String file_to_save="/home/jled/UBITECH/Cloud4SOA/nov_2011/nov21/cloud4soadb1.sql";

       utils.DatabaseHelper dbhelp = new DatabaseHelper();
            try {

             dbhelp.storeDB(hostname, port, dbuser, dbpassword, dbname,localfile);
              //String db_content=dbhelp.getData(hostname, port, db_user, db_user_password, database);
                //System.out.println("db_content"+db_content);

            } catch (Exception ex) {
                Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       else if (PaaS.equalsIgnoreCase(CLOUDCONTROL)){
       //CloudControl code here

       }
       return ret;
   }

   public static String restoreDB(String PaaS,String publicKey, String secretKey, String accountName, String host,String type,
           String apiversion, String description,String dbname,String dbuser,String dbpassword,String localfile)throws BeanstalkAdapterException{
       String ret = null;

       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
     //  CreateAppVersionBeanstalk(war, publicKey, secretKey, appName, appVersion, environment, bucket, host);

       utils.DatabaseHelper dbhelp = new DatabaseHelper();
            try {
            String hostname= dbname+"cloud4soaid"+".coaodqyxxykq.us-east-1.rds.amazonaws.com";

             dbhelp.restoredb(hostname, "3306", dbuser, dbpassword, dbname,localfile);
              //String db_content=dbhelp.getData(hostname, port, db_user, db_user_password, database);
                //System.out.println("db_content"+db_content);

            } catch (Exception ex) {
                Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            }
       

       }
       else if (PaaS.equalsIgnoreCase(CLOUDBEES_RUN)){
      // OperateCloudBees("DBLIST", publicKey, secretKey, "", accountName, type, apiversion);
          /* String hostname="localhost";
           String port="3306";
           String database="cloud4soa";
           String db_user="root";
           String db_user_password="!uflow!";
           * */

           String hostname="ec2-174-129-9-255.compute-1.amazonaws.com";
           String port="3306";
           //String database="cloud4soadb1";
           //String db_user="cloud4soauser";
           //String db_user_password="password";
           //logika 8a exw 8ema me paths pou exoun keno.fix this later
           //String file_to_save="/home/jled/UBITECH/Cloud4SOA/nov_2011/nov21/cloud4soadb1.sql";

       utils.DatabaseHelper dbhelp = new DatabaseHelper();
            try {

             dbhelp.restoredb(hostname, port, dbuser, dbpassword, dbname,localfile);
              //String db_content=dbhelp.getData(hostname, port, db_user, db_user_password, database);
                //System.out.println("db_content"+db_content);

            } catch (Exception ex) {
                Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       else if (PaaS.equalsIgnoreCase(CLOUDCONTROL)){
       //CloudControl code here

       }
       return ret;
   }




///////////////////START VERSIONING OPERATIONS///////////////////////////////////////
    public static String getAppVersions(String PaaS, String publicKey, String secretKey,String appName)throws BeanstalkAdapterException{
        String ret="";

       //prosexe de 8elw na kanei kai deploy
       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
             beanstalk.BeansDescribeApplicationVersions bst= new BeansDescribeApplicationVersions();
     bst.decribeApplicationVersions(publicKey, secretKey, appName);
       }

       else if (PaaS.equalsIgnoreCase(CLOUDBEES_RUN)){
            System.out.println("Operation Not Supported From CloudBees Run@Cloud");
       }
       else if (PaaS.equalsIgnoreCase(CLOUDCONTROL)){
       //CloudControl code here

       }
        return ret;
    }//eom getAppVersions


   //This method presuppose that app exists already, and just an new version is uploaded

   public static String createAppVersion(String PaaS,String war, String publicKey, String secretKey, String accountName,String appName, String appVersion,
            String environment, String bucket, String host,String type, String apiversion, String description)throws BeanstalkAdapterException{
       String ret = null;


       //prosexe de 8elw na kanei kai deploy
       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
        BeansCreateApplicationVersion beansappversion= new  BeansCreateApplicationVersion();
            try {
                beansappversion.creatappversion(publicKey, secretKey, war, bucket, appName, appVersion);
                //CreateAppVersionBeanstalk(war, publicKey, secretKey, appName, appVersion, environment, bucket, host);
            } catch (Exception ex) {
                Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            }
       ////////////////////////////

       ////////////////////////////
       }

       return ret;
    }//eom createAppVersion
   //This method presuppose that app exists already, and just an new version is uploaded

   public static String createApplication(String PaaS,String war, String publicKey, String secretKey, String accountName,String appName,
            String environment, String bucket, String host,String type, String apiversion, String description)throws BeanstalkAdapterException{
       String ret = null;


       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){


       ////////////////////////////
       }
       else if (PaaS.equalsIgnoreCase(CLOUDBEES_RUN)){
       //AuxAdapter.deployCloudBees(war, publicKey, secretKey, appName, accountName, type, apiversion, description);
       }
       else if (PaaS.equalsIgnoreCase(CLOUDCONTROL)){
    	   // CLOUDCONTROL
//    	   ret = AuxAdapter.operateCloudControl("START", publicKey, secretKey, accountName, appName, appversion, environment, bucket, host, type, description, apiversion).toString();
       }
       return ret;
    }//eom createApplication
////////////////////////////////////////////////////////////////////////////////


   public static String deleteApplication(String PaaS,String war, String publicKey, String secretKey, String accountName,String appName,
            String environment, String bucket, String host,String type, String apiversion, String description)throws BeanstalkAdapterException{
       String ret = null;


       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){


       ////////////////////////////
       }
       else if (PaaS.equalsIgnoreCase(CLOUDBEES_RUN)){
       //AuxAdapter.deployCloudBees(war, publicKey, secretKey, appName, accountName, type, apiversion, description);
       }
       else if (PaaS.equalsIgnoreCase(CLOUDCONTROL)){
    	   // TODO
       //CloudControl code here

       }
       return ret;
    }//eom deleteApplication
////////////////////////////////////////////////////////////////////////////////


   public static String updateApplication(String PaaS,String war, String publicKey, String secretKey, String accountName,String appName,
            String environment, String bucket, String host,String type, String apiversion, String description)throws BeanstalkAdapterException{
       String ret = null;


       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){


       ////////////////////////////
       }
       else if (PaaS.equalsIgnoreCase(CLOUDBEES_RUN)){
       //AuxAdapter.deployCloudBees(war, publicKey, secretKey, appName, accountName, type, apiversion, description);
       }
       else if (PaaS.equalsIgnoreCase(CLOUDCONTROL)){
       //CloudControl code here

       }
       return ret;
    }//eom updateApplication
////////////////////////////////////////////////////////////////////////////////



    public static String deleteAppVersion(String PaaS, String publicKey, String secretKey, String accountName,String appName, String appVersion,
            String environment, String bucket, String host,String type, String apiversion)throws BeanstalkAdapterException{
        String ret="";


       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
             beanstalk.BeansDeleteApplicationVersion bst= new BeansDeleteApplicationVersion();
             bst.deleteApplicationVersion(publicKey, secretKey, appName,appVersion);

             ///also delete the version from version files

       }

       else if (PaaS.equalsIgnoreCase(CLOUDBEES_RUN)){
            System.out.println("Operation Not Supported From CloudBees Run@Cloud");
       }
       else if (PaaS.equalsIgnoreCase(CLOUDCONTROL)){
       //CloudControl code here

       }
        return ret;
    }//eom deleteAppVersion


    ///exportAppVersion aka download application archive
    public static String exportAppVersion(String PaaS)throws BeanstalkAdapterException{
        String ret="";


        ///must use s3 calls
        if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){

       }
       else if (PaaS.equalsIgnoreCase(CLOUDBEES_RUN)){
            System.out.println("Operation Not Supported From CloudBees Run@Cloud");
       }
       else if (PaaS.equalsIgnoreCase(CLOUDCONTROL)){
       //CloudControl code here

       }
        return ret;
    }//eom deleteAppVersion

///////////////////END VERSIONING OPERATIONS/////////////////////////////////////////

///////////////////START OF ENVIROMENT RELATED OPERATIONS/////////////////////////////////////////
    public static String getAppEnvironments(String PaaS)throws BeanstalkAdapterException{
        String ret="";


     if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
       //AWS_BEANSTALK code here

       }
     else if (PaaS.equalsIgnoreCase(CLOUDBEES_RUN)){
       //CLOUDBEES code here

       }
     else if (PaaS.equalsIgnoreCase(CLOUDCONTROL)){
       //CloudControl code here

       }
        return ret;
    }//eom getAppEnvironments
 ////////////////////////////////////////////////////

    public static String getAppVersions(String PaaS)throws BeanstalkAdapterException{
        String ret="";


     if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
       //AWS_BEANSTALK code here

       }
     else if (PaaS.equalsIgnoreCase(CLOUDBEES_RUN)){
       //CLOUDBEES code here

       }
     else if (PaaS.equalsIgnoreCase(CLOUDCONTROL)){
       //CloudControl code here

       }
        return ret;
    }//eom getAppVersions
///////////////////////////////////////

    
    
    public static String getRunningAppVersion(String PaaS)throws BeanstalkAdapterException{
        String ret="";

        if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
       //AWS_BEANSTALK code here

       }
     else if (PaaS.equalsIgnoreCase(CLOUDBEES_RUN)){
       //CLOUDBEES code here

       }
     else if (PaaS.equalsIgnoreCase(CLOUDCONTROL)){
       //CloudControl code here

       }
        return ret;
    }//eom getRunningAppVersion


    ///attach an application version on an enviroment
    //public static String attachEnvironment(String PaaS,String war, String publicKey, String secretKey, String accountName,String appName, String appVersion,
    public static String updateEnvironment(String PaaS,String war, String publicKey, String secretKey, String accountName,String appName, String appVersion,
            String environment, String bucket, String host,String type, String apiversion, String description)throws BeanstalkAdapterException{
        String ret="";
       if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
                   System.out.println("starting BeansUpdateEnvironment");

            BeansUpdateEnvironment bst_updateenvironment= new BeansUpdateEnvironment();
                try {
                    bst_updateenvironment.updateenvironment(publicKey, secretKey, environment, appName, appVersion, "descriptionUpdateby-app:"+appName+"-version:"+appVersion);
                } catch (Exception ex) {
                    Logger.getLogger(BeanstalkDeployNoGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
                   else if (PaaS.equalsIgnoreCase(CLOUDBEES_RUN)){

                       
       }
     else if (PaaS.equalsIgnoreCase(CLOUDCONTROL)){
       //CloudControl code here

       }
        return ret;
    }//eom attachEnvironment
//////////////////////////////////////////////////////////////////////////////////
    
    //One method only for Creating Updating or Deleting an environment
    //replacing methods
    public static String CRUDEnvironment(String PaaS)throws BeanstalkAdapterException{
        String ret="";
        if (PaaS.equalsIgnoreCase(AWS_BEANSTALK)){
       //AWS_BEANSTALK code here

       }
     else if (PaaS.equalsIgnoreCase(CLOUDBEES_RUN)){
       //CLOUDBEES code here
       System.out.println("CRUDEnvironment method is not applicable for CloudBees RUN@cloud.");
       }
     else if (PaaS.equalsIgnoreCase(CLOUDCONTROL)){
       //CloudControl code here
       //As far as I know this method is not applicable for CloudControl

       }
        return ret;
    }//eom CRUDEnvironment

    
}
