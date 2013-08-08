/*
 *  Copyright 2013 Cloud4SOA, www.cloud4soa.eu
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cloud4soa.soa.jaxrs.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody;
import org.apache.cxf.jaxrs.provider.ProviderFactory;
import org.apache.cxf.jaxrs.provider.json.JSONProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author vinlau
 */
public class SemanticAppInitializer {
    final Logger logger = LoggerFactory.getLogger(getClass());
//    final String BASE_URI = "http://94.75.243.141/cloud4soa/services/REST/";
//    final String BASE_URI = "http://vmusoa02.deri.ie:8080/cloud4soa.soa/services/REST/";
//    final String BASE_URI = "http://soa-c4s.rhcloud.com/cloud4soa.soa/services/REST/";
//    final String BASE_URI = "http://soa-c4soa.rhcloud.com/cloud4soa.soa/services/REST/";
    final String BASE_URI = "http://localhost:8080/services/REST/";
    final String developerUriId = "FrancescoDandria";
    
    public static void main(String[] args) {
        SemanticAppInitializer initializer = new SemanticAppInitializer();
        initializer.initialize();
    }

    public void initialize() {
        
        try {
            String developerUserDir = "applicationProfiles";
            URL resource = scanPackage(developerUserDir);
            String protocol = resource.getProtocol();
            if (protocol.equals("file")) {
                File file = new File(resource.getFile());
                if(file.isDirectory()){
                    String[] list = file.list();
                    for (String fileName : list) {
                        String applicationTurtleProfile = loadTurtleFileIntoString(developerUserDir, fileName);
                        logger.info("Loaded application profile: "+fileName);
                        storeTurtleApplicationProfile(applicationTurtleProfile, developerUriId);
                    }
                }
            }
        } catch (IOException ex) {
            logger.error("Error during the creation of the Application profiles", ex);
        }
    }
    
    private URL scanPackage(String dir) throws IOException {
        URL resource = this.getClass().getClassLoader().getResource(dir);
        return resource;
    }
    
    private String loadTurtleFileIntoString(String dir, String fileName) throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream( dir + "/" + fileName );
        String applicationTurtleProfile = IOUtils.toString(is);
        return applicationTurtleProfile;
    }

    
    public String storeTurtleApplicationProfile(String applicationProfile, String userInstanceUriId){
        String rsUri = BASE_URI+"ModelManagerRS/storeTurtleApplicationProfile";
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
        registerJsonProvider();

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("applicationProfile", MediaType.TEXT_PLAIN , applicationProfile));

        atts.add(new Attachment("userInstanceUriId", MediaType.TEXT_PLAIN , userInstanceUriId));
        
        Response response = client.post(new MultipartBody(atts));
        String applicationInstanceUriId = null;
        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.CREATED){
            try {
                applicationInstanceUriId = org.apache.cxf.helpers.IOUtils.readStringFromStream((InputStream)response.getEntity());
                logger.debug("applicationInstanceUriId: "+applicationInstanceUriId);
            } catch (IOException ex) {
                logger.error("Error reading the REST response: "+ex.getMessage());
            }
        }
        return applicationInstanceUriId;
    }
    
        
    private void registerJsonProvider() {
        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);
    }
}
