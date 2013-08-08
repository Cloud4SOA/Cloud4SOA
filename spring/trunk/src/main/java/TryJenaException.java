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


import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.soa.AnnouncementModule;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author vins
 */
public class TryJenaException {

    private String paaSUserUriId = "509ee5e7-4719-4449-8c06-f31915011844";
    private String paaSInstanceUriId = "2c245db1-238e-46b3-99c4-ab3241cdf97f";
    private AnnouncementModule announcementModule;

    public TryJenaException() {
        System.out.println(System.getProperty("java.class.path"));
        String[] serviceResources = {"classpath*:spring/config/soa.xml"};

        ApplicationContext context = new ClassPathXmlApplicationContext(serviceResources);

        announcementModule = (AnnouncementModule)context.getBean("announcementModule");
    }
    
    
 
        public static void main( String[] args )
    {
        TryJenaException tje = new TryJenaException();
        System.out.println("*******retrieveAllPaaSInstances******");
        tje.retrieveAllPaaSInstances();
        System.out.println("*************************************");
        System.out.println("**********updatePaaSInstance*********");
        tje.updatePaaSInstance();
        System.out.println("*************************************");
    }
    
        private void retrieveAllPaaSInstances(){
        List<PaaSInstance> retrieveAllPaaSInstances = announcementModule.retrieveAllPaaSInstances(paaSUserUriId);
        for (PaaSInstance retrievedPaaSInstance : retrieveAllPaaSInstances) {
            System.out.println("retrievedPaaSInstance: "+retrievedPaaSInstance);
        }
    }
    
    private void updatePaaSInstance(){
        PaaSInstance retrievedPaaSInstance = announcementModule.getPaaSInstance(paaSInstanceUriId);
        System.out.println("retrieved retrievedPaaSInstance: "+ retrievedPaaSInstance.getUriId());
        retrievedPaaSInstance.setTitle(retrievedPaaSInstance.getTitle()+"***");
//        List<SoftwareComponentInstance> softwareComponents = retrievedPaaSInstance.getSoftwareComponents();
//        for (SoftwareComponentInstance softwareComponentInstance : softwareComponents) {
//            softwareComponentInstance.setVersion("4.0");
//            System.out.println("Modified version to 4.0");
//        }
        announcementModule.updatePaaSInstance(retrievedPaaSInstance);
        PaaSInstance retrievedModifiedPaaSInstance = announcementModule.getPaaSInstance(paaSInstanceUriId);
        System.out.println("retrieved retrievedModifiedPaaSInstance: "+ retrievedModifiedPaaSInstance.getTitle());
//        List<SoftwareComponentInstance> modifiedSoftwareComponents = retrievedModifiedPaaSInstance.getSoftwareComponents();
//        for (SoftwareComponentInstance softwareComponentInstance : modifiedSoftwareComponents) {
//            System.out.println("Updated version: "+softwareComponentInstance.getVersion());
//        }
    }
}
