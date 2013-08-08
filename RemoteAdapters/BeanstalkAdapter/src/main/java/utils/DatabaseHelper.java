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
package utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jled
 */
public class DatabaseHelper {
    private int BUFFER = 10485760;


public String storeDB(String host, String port, String dbUser,String dbPass, String dbName, String local_file){
        String msg="No Backup";
        try {
            String executeCmd = "";
            executeCmd = "mysqldump -h "+host+" -P " + port + " -u " + dbUser + " -p" + dbPass + " " + dbName + " -r "+local_file;
            System.out.println("Commmand to execute: "+executeCmd);
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                System.out.println("Backup taken successfully");
                msg="Backup taken successfully";
            } else {
                System.out.println("Could not take mysql backup");
                msg="Could not take mysql backup";
            }
        } catch (Exception ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;

}

public String restoredb(String host, String port, String dbUser,String dbPass, String dbName, String local_file){
    String msg="Nothing done in restoredb!";
    try {
            String[] executeCmd = new String[]{"/bin/sh", "-c", "mysql -h "+host+" -P " + port + " -u " + dbUser + " -p" + dbPass + " " + dbName + " < "+local_file};
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                System.out.println("success");
                msg="success";
            } else {
                System.out.println("restore failure");
                msg="restore failure";
            }
        } catch (Exception ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    return msg;

}

public String restoredbForBeanstalk(String host, String port, String dbUser,String dbPass, String dbName, String local_file){
    String msg="Nothing done in restoredb!";
    try {


        ///cmd:: mysqldump acme | mysql --host=hostname --user=username --password acme
            String executeCmd = "mysqldump "+dbName+" | mysql -h"+host+" -P " + port + " -u " + dbUser + " -p" + dbPass + " " + dbName + " -r "+local_file;
            System.out.println("run:--> "+executeCmd);
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                System.out.println("success");
                msg="success";
            } else {
                System.out.println("restore failure");
                msg="restore failure";
            }
        } catch (Exception ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    return msg;

}


}
