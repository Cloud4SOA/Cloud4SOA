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
package eu.cloud4soa.cli.roo.addon;

import eu.cloud4soa.api.datamodel.core.ApplicationInstance;
import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.datamodel.core.UserInstance;
import eu.cloud4soa.api.datamodel.governance.SlaTemplate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vins
 */
public interface Cloud4SoaSessionDeveloper {
    
    UserInstance getUserInstance();
    
    String getUserInstanceUriId();
    
    /* ApplicationInstances */
    
    Map<Integer, ApplicationInstance> getCachedApplicationProfiles();
    
    void setCachedApplicationProfiles(List<ApplicationInstance> applicationInstances);
    
    String getCachedApplicationId(Integer localId);
    
    ApplicationInstance getCachedApplicationProfile(Integer localId);
    
    boolean isApplicationsCacheValid();
    
    void invalidateApplicationsCache();
    
    /* Deployed Applications */
    
    Map<Integer, ApplicationInstance> getCachedDeployedApplications();
    
    void setCachedDeployedApplications(List<ApplicationInstance> applicationInstances);
    
    String getCachedDeployedApplicationId(Integer localId);
    
    ApplicationInstance getCachedDeployedApplication(Integer localId);
    
    boolean isDeployedApplicationsCacheValid();
    
    void invalidateDeployedApplications();
    
    /* PaaSInstances */
    
    Map<Integer, PaaSInstance> getCachedPaaSProfiles();
    
    void setCachedPaaSProfiles(List<PaaSInstance> paaSInstances);
    
    String getCachedPaaSProfileId(Integer localId);
    
    PaaSInstance getCachedPaaSProfile(Integer localId);
    
    PaaSInstance getCachedPaaSProfile(String uriId);
    
    boolean isPaaSProfilesCacheValid();
    
    void invalidatePaaSProfilesCache();
    
    /* Matching Platforms */
    
    Map<Integer, PaaSInstance> getCachedMatchingPlatforms();
    
    void setCachedMatchingPlatforms(List<PaaSInstance> matchingPlatforms);
    
    public void setCachedSLATemplateIds( Map<PaaSInstance, SlaTemplate> slaTemplateIds);
    
    public String getSlaTemplateId( String selectedPaaSId);
    
    
    
    boolean isMatchingPlatformsCacheValid();
    
    void invalidateMatchingPlatformsCache();
    
    public void   setGitLocalRepositoryPath( String localRepository);
    
    public String getGitLocaRepositoryPath();
    
}
