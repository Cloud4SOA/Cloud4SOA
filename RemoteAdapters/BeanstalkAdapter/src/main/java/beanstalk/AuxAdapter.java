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


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import utils.ParseXmlString;
import beanstalk.BeansCheckDNSAvailabity;
import beanstalk.BeansDeleteApplication;
import beanstalk.BeansTerminateEnvironment;
import beanstalk.BeanstalkDeploy;
import beanstalk.BeanstalkDeployNoGUI;
import beanstalk.BeanstalkFirstDeployment;
import beanstalk.BeanstalkFirstDeploymentNoGUI;



/**
 *
 * @author jled
 */
public class AuxAdapter {






    ///////////////////////END OF API METHODS/////////////////

    public static void commitBeanstalk(String war, String AWSKeyId, String AWSSecretKey, String applicationname, String appversion,
            String environment, String bucket, String host) throws BeanstalkAdapterException{
        boolean deployed = true;

        ///if no war file give show file chooser
        boolean showJFileLoader = false;
        if (war.equalsIgnoreCase("")) {
            showJFileLoader = true;
        }
        ///if no host give give default
        String host_name = host;
        if (host.equalsIgnoreCase("")) {
            host_name = "elasticbeanstalk.us-east-1.amazonaws.com";
        }

        ///if no bucket given, create bucket name from AWSKeyId
        String bucket_name = bucket;
        if (bucket.equalsIgnoreCase("")) {
            bucket_name = "s3-cloud4soa-autobucket-" + AWSKeyId.toLowerCase();
        }

        ///if no environment name given, create environment name from AWSKeyId
        String environment_name = environment;
        // if (environment.equalsIgnoreCase("")) {
        //     environment_name = "c4soa-" + AWSKeyId.toLowerCase().;
        //  }

        //Check if CNAME is available. CNAME is envirmonment name

        BeansCheckDNSAvailabity check_availability = new BeansCheckDNSAvailabity(AWSKeyId, AWSSecretKey, environment);
        if (check_availability.CheckAvailability() == true) {

            if (showJFileLoader == true) {
                BeanstalkFirstDeployment beans_first = new BeanstalkFirstDeployment(showJFileLoader);
                beans_first.deploy(war, AWSKeyId, AWSSecretKey, applicationname, appversion, environment_name, bucket_name, host_name);
            } else {
                BeanstalkFirstDeploymentNoGUI beans_first = new BeanstalkFirstDeploymentNoGUI(showJFileLoader);
                beans_first.deploy(war, AWSKeyId, AWSSecretKey, applicationname, appversion, environment_name, bucket_name, host_name);

            }

        }//end if available
        else {
            System.out.println("Environment Name :" + environment + " is not available.Please choose another environment name.");
        }//end if name not available



        // return deployed;
    }









    /////////////////////////--BEANSTALK--//////////////////////////////////////////////////////////////////////


    public static void updateBeanstalk(String war, String AWSKeyId, String AWSSecretKey, String applicationname, String appversion,
            String environment, String bucket, String host) throws BeanstalkAdapterException{
        boolean deployed = true;

        ///if no war file give show file chooser
        boolean showJFileLoader = false;
        if (war.equalsIgnoreCase("")) {
            showJFileLoader = true;
        }
        ///if no host give give default
        String host_name = host;
        if (host.equalsIgnoreCase("")) {
            host_name = "elasticbeanstalk.us-east-1.amazonaws.com";
        }

        ///if no bucket given, create bucket name from AWSKeyId
        //for this update function we don't actually create the bucket, just trying to guess the name
        String bucket_name = bucket;
        if (bucket.equalsIgnoreCase("")) {
            bucket_name = "s3-cloud4soa-autobucket-" + AWSKeyId.toLowerCase();
        }

        ///if no environment name given, create environment name from AWSKeyId
        //for this update function we don't actually create the environment, just trying to guess the name
        String environment_name = environment;
        if (environment.equalsIgnoreCase("")) {
            environment_name = "autogenenvironment-" + AWSKeyId.toLowerCase();
        }


        if (showJFileLoader == true) {
            BeanstalkDeploy bstDeploy = new BeanstalkDeploy(true);
            bstDeploy.deploy(war, AWSKeyId, AWSSecretKey, applicationname, appversion, environment_name, bucket_name, host_name);
        } else {
            BeanstalkDeployNoGUI bstDeploy = new BeanstalkDeployNoGUI(false);
            bstDeploy.deploy(war, AWSKeyId, AWSSecretKey, applicationname, appversion, environment_name, bucket_name, host_name);
        }


        //  return deployed;
    }


    public static void deleteBeanstalk( String AWSKeyId, String AWSSecretKey, String environment) throws BeanstalkAdapterException {
        boolean deployed = true;


        ///if no environment name given, create environment name from AWSKeyId
        //for this update function we don't actually create the environment, just trying to guess the name
        String environment_name = environment;
        if (environment.equalsIgnoreCase("")) {
            environment_name = "autogenenvironment-" + AWSKeyId.toLowerCase();
        }



            BeansTerminateEnvironment bstDelete = new BeansTerminateEnvironment();
            BeansDeleteApplication bstappDelete = new BeansDeleteApplication();
        try
        {
            //delete environment
            bstDelete.terminateenvironment(AWSKeyId, AWSSecretKey, environment);
            //now delete application
            String appname=environment;
            bstappDelete.deleteApplication(AWSKeyId, AWSSecretKey, appname);
            //  return deployed;
        } catch (Exception ex) {
            Logger.getLogger(Adapter.class.getName()).log(Level.SEVERE, null, ex);
            throw new BeanstalkAdapterException(ex.getMessage());
        }
    }
    
}
