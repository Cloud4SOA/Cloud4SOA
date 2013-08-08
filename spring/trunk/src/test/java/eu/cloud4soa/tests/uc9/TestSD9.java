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

package eu.cloud4soa.tests.uc9;

import eu.cloud4soa.api.soa.ApplicationDeployment;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author vincenzo
 */
public class TestSD9 {
//    public static void main(String[] args) {
//        System.out.println(System.getProperty("java.class.path"));
//        String[] serviceResources = {"classpath*:spring/config/applicationContext.xml"};
//
//        ApplicationContext context = new ClassPathXmlApplicationContext(serviceResources);
//
//        ApplicationDeployment applicationDeployment = (ApplicationDeployment)context.getBean("applicationDeployment");
//        applicationDeployment.deployApplication(null, null, null);
//    }
    @Ignore
    @Test
    public void testSd9(){
        System.out.println(System.getProperty("java.class.path"));
        String[] serviceResources = {"classpath*:spring/config/applicationContext.xml"};

        ApplicationContext context = new ClassPathXmlApplicationContext(serviceResources);

        ApplicationDeployment applicationDeployment = (ApplicationDeployment)context.getBean("applicationDeployment");
        //build ApplicationInstance from ApplicationSemanticModel + applicationInstance
        eu.cloud4soa.api.datamodel.frontend.ApplicationArchive frontendApplicationArchive = new eu.cloud4soa.api.datamodel.frontend.ApplicationArchive() {};
        //build ApplicationInstance from ApplicationSemanticModel + applicationInstance
        eu.cloud4soa.api.datamodel.frontend.ApplicationInstance frontendApplicationInstance = new eu.cloud4soa.api.datamodel.frontend.ApplicationInstance() {};
        //build PaaSInstance from PaaSSemanticModel + paaSInstance
        eu.cloud4soa.api.datamodel.frontend.PaaSInstance frontendPaaSInstance = new eu.cloud4soa.api.datamodel.frontend.PaaSInstance() {};

//        applicationDeployment.deployApplication(frontendApplicationArchive, frontendApplicationInstance, frontendPaaSInstance);
    }

}
