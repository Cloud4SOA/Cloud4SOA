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


package beanstalk;

import beanstalk.BeansCreateApplication;
import beanstalk.BeansCreateEnvironment;
import beanstalk.BeanstalkDeploy;
import beanstalk.BeanstalkDeployGUI;
import beanstalk.BeanstalkDeployNoGUI;
import beanstalk.BeanstalkFirstDeployment;
import beanstalk.BeanstalkFirstDeploymentNoGUI;
//import cloudbees.BeesUpdate;
//import cloudbees.OpenORCreateWarArchive;
//import com.amazonaws.services.elasticbeanstalk.AWSElasticBeanstalk;
//import com.amazonaws.services.elasticbeanstalk.model.ListAvailableSolutionStacksRequest;
//import com.sun.media.sound.ModelAbstractChannelMixer;
import java.util.logging.Level;
import java.util.logging.Logger;
import beanstalk.BeansCheckDNSAvailabity;
import beanstalk.BeansDeleteApplicationVersion;
import beanstalk.BeansDescribeApplicationVersions;
import beanstalk.BeansDescribeEnvironments;
import beanstalk.BeansManageAppVersions;
import com.amazonaws.services.elasticbeanstalk.model.CheckDNSAvailabilityResult;
//import com.cloudbees.api.BeesClient;
//import com.cloudbees.api.BeesClientConfiguration;
import utils.ParseXmlString;


public class Tester {


 public static void main(String[] args) throws Exception {


     ///AWS

     //CLOUDBEES

     //testmail@mailinator.com --- testaccountname
     //String api_key = "4184E8A5D19D02D9";
     //String api_secret = "UZPYSQVJMQLVNNVK6GSZQPRUTAZ+QKNB9QCKDWVNQMK=";

     String tmp="";

     //beanstalk.BeansDeleteApplicationVersion bst= new BeansDeleteApplicationVersion();
    // bst.deleteApplicationVersion(accessKeyId, secretAccessKey, "applicatsionname","appversion");
    //BeansManageAppVersions temp= new BeansManageAppVersions();
    //temp.findLatestVersion("app", "cloud4soa");


   //tmp=Adapter.uploadAndDeployToEnv("Beanstalk","/home/jled/UBITECH/Cloud4SOA/october_2011/dummysites/uploads/SampleApp3.war", accessKeyId, secretAccessKey,"", "cloud4soa1", "1.1", "cloud4soa1", "", "", "", "", "");
    // String tmp2=Adapter.uploadAndDeployToEnv("CloudBees", "/home/jled/UBITECH/Cloud4SOA/october_2011/dummysites/uploads/SampleApp3.war", api_key, api_secret,"testaccountname", "cloud4soa1", "", "", "", "", "", "", "description");

     //tmp=Adapter.uploadAndDeployToEnv("CloudBees", "/home/jled/NetBeansProjects/CloudBeesAdapter/target/CloudBeesC4SAdapter-1.0-SNAPSHOT.war", api_key, api_secret,"testaccountname", "c4sAdapter", "", "", "", "", "", "", "cloud4soa_ems_application");
     
     //String url = Adapter.getAppURL("CloudBees", api_key, api_secret,"testaccountname", "c4sadapter", "", "", "");


      //System.out.println("Application deployed with URL: "+url);
     
     
     //Adapter.uploadAndDeployToEnv("GoogleAppengine", "/home/jled/UBITECH/Cloud4SOA/october_2011/dummysites/uploads/SampleApp1.war", "", "!depR66!","g.ledakis@gmail.com", "cloud4soa1", "1", "", "", "", "", "", "");

     //Adapter.stop("Beanstalk", accessKeyId, secretAccessKey,"", "cloud4soa1", "version1.12w6dfg3", "cloud4soa1", "","","","","");
     //Adapter.stop("CloudBees", api_key, api_secret,"testaccountname","cloud4soa1","" ,"","" ,"","","","");
     //tmp=Adapter.delete("CloudBees", api_key, api_secret,"testaccountname","cloud4soa3","" ,"","" ,"","","","");
     //Adapter.delete("Beanstalk", accessKeyId, secretAccessKey,"", "", "", "cloud4soa5", "","","","","");
     //Adapter.start("Beanstalk", accessKeyId, secretAccessKey,"","cloud4soa1","1.1" ,"cloud4soa1","" ,"","","","");
     //Adapter.start("CloudBees", api_key, api_secret,"testaccountname","cloud4soa1","" ,"","" ,"","","","");
         

//     Adapter.listApplications("CloudBees", api_key, api_secret,"testaccountname","","" ,"","" ,"","","","");
     //Adapter.createDB("CloudBees", api_key, api_secret,"testaccountname","","" ,"","","","","");
    //Adapter.createDB("Beanstalk", accessKeyId, secretAccessKey,"","","MySQL" ,"","","mydbname","dbuser","password");
     //Adapter.deleteDB("CloudBees", api_key, api_secret,"testaccountname","","" ,"","" ,"","","","");;
     //Adapter.downloadDB("CloudBees", api_key, api_secret,"testaccountname","","" ,"","" ,"","","","");;
   //  Adapter.downloadDB("Beanstalk", accessKeyId, secretAccessKey,"","","MySQL" ,"","","mydbname","password","dbuser","/home/jled/UBITECH/Cloud4SOA/dbexport.sql");


     //Adapter.checkAppAvailability("Beanstalk", accessKeyId, secretAccessKey,"", "", "cloud4soa", "","");
     //Adapter.checkAppAvailability("CloudBees", api_key, api_secret,"testaccountname","newapp","" ,"","");


      //tmp=Adapter.getAppStatus("CloudBees", "4184E8A5D19D02D9", "UZPYSQVJMQLVNNVK6GSZQPRUTAZ+QKNB9QCKDWVNQMK=","testaccountname","cloud4soa3","" ,"","");
     //String status=Adapter.getAppStatus("Beanstalk", accessKeyId, secretAccessKey,"", "", "cloud4soa", "","");


//   String toString="";
//   toString = Adapter.start("cloudControl", api_key, api_secret,"testaccountname","cloud4soa1","" ,"","" ,"","","","");
//   System.out.println(toString);
//   toString = Adapter.listApplications("cloudControl", api_key, api_secret,"testaccountname","","" ,"","" ,"","","","");
//   System.out.println(toString);
//   toString = Adapter.stop("cloudControl", api_key, api_secret,"testaccountname","cloud4soa1","" ,"","" ,"","","","");
//   System.out.println(toString);
//   toString = Adapter.listApplications("cloudControl", api_key, api_secret,"testaccountname","","" ,"","" ,"","","","");
//   System.out.println(toString);
     
     
     

     System.out.println("tmp:::"+tmp);



     ////////////////OLD TESTS///////////////////
         // Adapter.UpdateBeanstalk("", "AKIAJRSZ7FBNKBAOUR6A", "7MPB3TqHf5Ds5UAX+nYORlY7/50kB01/vQbvJyyx", "SimpleWar", "version1.12w663", "cloud4soa", "", "");
    //if args for cloudbees
    //create cloudbees-web.xml file
    // bst.commitupdate(args);
    ///CreateBeesXMLfile.createfile(accessKeyId, secretAccessKey,"SimpleWar");
    //CreateBeesXMLfile.main(args);
     //BeesUpdate bu= new BeesUpdate();
    // bu.commitupdate();

   //  com.cloudbees.api.BeesClientConfiguration conf= new BeesClientConfiguration(

    // BeesClient bclient = new BeesClient("https://api.cloudbees.com/api", api_key, api_secret, "xml", "1.0");
    //Adapter.DeployCloudBees("/home/jled/NetBeansProjects/SimpleWar/dist/SimpleWar.war", api_key, api_secret, "newapp", "testaccountname","", "", "descriptiontest");
   //Adapter.OperateCloudBees("LIST", api_key, api_secret, "newapp", "testaccountname","", "");



 }
}
