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

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.helpers.IOUtils;
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
public class SemanticUserInitializer {
    final Logger logger = LoggerFactory.getLogger(getClass());
//    final String BASE_URI = "http://94.75.243.141/cloud4soa/services/REST/";
//    final String BASE_URI = "http://vmusoa02.deri.ie:8080/cloud4soa.soa/services/REST/";
//    final String BASE_URI = "http://soa-c4s.rhcloud.com/cloud4soa.soa/services/REST/";
//    final String BASE_URI = "http://soa-c4soa.rhcloud.com/cloud4soa.soa/services/REST/";
    final String BASE_URI = "http://localhost:8080/services/REST/";
//   final String BASE_URI = "http://test02.sindice.net:8038/cloud4soa/services/REST";
    
    public static void main(String[] args) {
        SemanticUserInitializer initializer = new SemanticUserInitializer();
        initializer.initialize();
    }

    public void initialize() {
        try {
            String developerFileName = "developer.ttl";
            String developerUserTurtleProfile = loadDeveloperTurtleProfile(developerFileName);
            String developerUriId = storeTurtleUserProfile(developerUserTurtleProfile, "fdandria", "ddandria");   
        } catch (IOException ex) {
            logger.error("Error during the creation of the Developer profile", ex);
        }
    }
    
    private String loadDeveloperTurtleProfile(String fileName) throws IOException {
        String developerUserDir = "developerUsers";
        return loadTurtleFileIntoString(developerUserDir, fileName);
    }
    
    private String loadTurtleFileIntoString(String dir, String fileName) throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream( dir + "/" + fileName );
        String developerTurtleProfile = IOUtils.toString(is);
        return developerTurtleProfile;
    }

    
    public String storeTurtleUserProfile(String userProfile, String username, String password){
        String rsUri = BASE_URI+"UserManagementAndSecurityModuleRS/createNewUserAccount";
        
        WebClient client = WebClient.create(rsUri);
        client.type("multipart/mixed").accept(MediaType.TEXT_PLAIN);
        
        registerJsonProvider();

        List<Attachment> atts = new LinkedList<Attachment>();

        atts.add(new Attachment("userProfile", MediaType.TEXT_PLAIN , userProfile));

        atts.add(new Attachment("username", MediaType.TEXT_PLAIN , username));
        
        atts.add(new Attachment("password", MediaType.TEXT_PLAIN , password));
        
        Response response = client.post(new MultipartBody(atts));
        String userInstanceUriId = null;
        if(Response.Status.fromStatusCode(response.getStatus())==Response.Status.CREATED){
            try {
                userInstanceUriId = IOUtils.readStringFromStream((InputStream)response.getEntity());
                logger.info("Response Status CREATED - userInstanceUriId: " + userInstanceUriId);
            } catch (IOException ex) {
                logger.error("Error reading the REST response: "+ex.getMessage());
            }
        }
        return userInstanceUriId;
    }
    
        
    private void registerJsonProvider() {
        JSONProvider jsonProvider = new JSONProvider();
        jsonProvider.setSupportUnwrapped(false);
        jsonProvider.setSerializeAsArray(true);
        ProviderFactory.getSharedInstance().registerUserProvider(jsonProvider);
    }
}
