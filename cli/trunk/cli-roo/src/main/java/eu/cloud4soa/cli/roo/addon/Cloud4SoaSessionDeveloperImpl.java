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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author vins
 */
public class Cloud4SoaSessionDeveloperImpl implements Cloud4SoaSessionDeveloper{
    private UserInstance userInstance;
    private Map<Integer, ApplicationInstance> cachedApplicationInstances;
    private boolean isApplicationsCacheValid;
    //Deployed Applications
    private Map<Integer, ApplicationInstance> cachedDeployedApplications;
    private boolean isDeployedApplicationsCacheValid;
    //Platforms
    private Map<Integer, PaaSInstance> cachedPaaSInstances;
    private boolean isPaaSProfilesCacheValid;
    //Matching Platforms
    Map<Integer, PaaSInstance> cachedMatchingPlatforms;
    private boolean isMatchingPlatformsCacheValid;
    protected Map<PaaSInstance, SlaTemplate> slaTemplateIds;
    
    protected String gitLocalPath;
    
    
    
    public Cloud4SoaSessionDeveloperImpl(UserInstance userInstance) {
        this.userInstance = userInstance;
        
        this.isApplicationsCacheValid = false;
        this.cachedApplicationInstances = new HashMap<Integer, ApplicationInstance>();
        
        this.isDeployedApplicationsCacheValid = false;
        this.cachedDeployedApplications = new HashMap<Integer, ApplicationInstance>();
        
        this.cachedPaaSInstances = new HashMap<Integer, PaaSInstance>();
        isPaaSProfilesCacheValid = false;
        
        this.cachedMatchingPlatforms  = new HashMap<Integer, PaaSInstance>();
        isMatchingPlatformsCacheValid = false;
        
        this.gitLocalPath = null;
    }

    @Override
    public UserInstance getUserInstance() {
        return userInstance;
    }
    
    @Override
    public String getUserInstanceUriId() {
        return userInstance.getUriId();
    }

    /* Application Profiles*/
    
    @Override
    public Map<Integer, ApplicationInstance> getCachedApplicationProfiles() {
        return cachedApplicationInstances;
    }

    @Override
    public void setCachedApplicationProfiles(List<ApplicationInstance> applicationInstances) {
        cachedApplicationInstances.clear();
        for (int i = 0; i < applicationInstances.size(); i++) {
            ApplicationInstance applicationInstance = applicationInstances.get(i);
            cachedApplicationInstances.put(i+1, applicationInstance);
        }
        isApplicationsCacheValid = true;
    }
    
    @Override
    public String getCachedApplicationId(Integer localId) {
        if(cachedApplicationInstances.get(localId) != null)
            return cachedApplicationInstances.get(localId).getUriId();
        return null;
    }
    
    @Override
    public ApplicationInstance getCachedApplicationProfile(Integer localId) {
            return cachedApplicationInstances.get(localId);
    }
    
    @Override
    public boolean isApplicationsCacheValid() {
        return isApplicationsCacheValid;
    }

    @Override
    public void invalidateApplicationsCache() {
        isApplicationsCacheValid = false;
        cachedApplicationInstances.clear();
    }
    
    /* Deployed Applications */
    
    @Override
    public Map<Integer, ApplicationInstance> getCachedDeployedApplications() {
        return cachedDeployedApplications;
    }

    @Override
    public void setCachedDeployedApplications(List<ApplicationInstance> applicationInstances) {
        cachedDeployedApplications.clear();
        for (int i = 0; i < applicationInstances.size(); i++) {
            ApplicationInstance applicationInstance = applicationInstances.get(i);
            cachedDeployedApplications.put(i+1, applicationInstance);
        }
        isDeployedApplicationsCacheValid = true;
    }

    @Override
    public String getCachedDeployedApplicationId(Integer localId) {
        if(cachedDeployedApplications.get(localId) != null)
            return cachedDeployedApplications.get(localId).getUriId();
        return null;
    }

    @Override
    public ApplicationInstance getCachedDeployedApplication(Integer localId) {
        return cachedDeployedApplications.get(localId);
    }

    @Override
    public boolean isDeployedApplicationsCacheValid() {
        return isDeployedApplicationsCacheValid;
    }

    @Override
    public void invalidateDeployedApplications() {
        isDeployedApplicationsCacheValid = false;
        cachedDeployedApplications.clear();
    }

    /* PaaS Profiles*/
    
    @Override
    public Map<Integer, PaaSInstance> getCachedPaaSProfiles() {
        return cachedPaaSInstances;
    }

    @Override
    public void setCachedPaaSProfiles(List<PaaSInstance> paaSInstances) {
        cachedPaaSInstances.clear();
        for (int i = 0; i < paaSInstances.size(); i++) {
            PaaSInstance paaSInstance = paaSInstances.get(i);
            cachedPaaSInstances.put(i+1, paaSInstance);
        }
        isPaaSProfilesCacheValid = true;
    }

    @Override
    public String getCachedPaaSProfileId(Integer localId) {
        if(cachedPaaSInstances.get(localId) != null)
            return cachedPaaSInstances.get(localId).getUriId();
        return null;
    }

    @Override
    public PaaSInstance getCachedPaaSProfile(Integer localId) {
        return cachedPaaSInstances.get(localId);
    }

    @Override
    public PaaSInstance getCachedPaaSProfile(String uriId) {
        for (PaaSInstance paaSInstance : cachedPaaSInstances.values()) {
            if(paaSInstance.getUriId()!=null && paaSInstance.getUriId().equals(uriId))
                return paaSInstance;
        }
        return null;
    }
    
    @Override
    public boolean isPaaSProfilesCacheValid() {
        return isPaaSProfilesCacheValid;
    }

    @Override
    public void invalidatePaaSProfilesCache() {
        isPaaSProfilesCacheValid = false;
        cachedPaaSInstances.clear();
    }
    
    /* Matching Platforms */

    @Override
    public Map<Integer, PaaSInstance> getCachedMatchingPlatforms() {
        return cachedMatchingPlatforms;
    }

    @Override
    public void setCachedMatchingPlatforms(List<PaaSInstance> matchingPlatforms) {
        cachedMatchingPlatforms.clear();
        for (Entry<Integer, PaaSInstance> entry : cachedPaaSInstances.entrySet()) {
            for (PaaSInstance paaSInstance : matchingPlatforms) {
                String uriId = paaSInstance.getUriId();
                if(entry.getValue().getUriId().equals(uriId))
                    cachedMatchingPlatforms.put(entry.getKey(), entry.getValue());
            }
        }
        isMatchingPlatformsCacheValid = true;
    }

    @Override
    public boolean isMatchingPlatformsCacheValid() {
        return isMatchingPlatformsCacheValid;
    }

    @Override
    public void invalidateMatchingPlatformsCache() {
        isMatchingPlatformsCacheValid = false;
        cachedMatchingPlatforms.clear();
    }

    @Override
    public String getGitLocaRepositoryPath() {
        return gitLocalPath;
    }

    @Override
    public void setGitLocalRepositoryPath(String localRepository) {
        this.gitLocalPath = localRepository;
    }
    
    
    @Override
    public void setCachedSLATemplateIds(Map<PaaSInstance, SlaTemplate> slaTemplateIds) {
        this.slaTemplateIds = slaTemplateIds;
    }

    
    
    @Override
    public String getSlaTemplateId(String selectedPaaSUriId) {
        String slaTemplateId;
        Iterator<PaaSInstance> paasIterator;
        PaaSInstance currentPaaS;
        
        
        slaTemplateId = null;
        if (slaTemplateIds != null) {
            paasIterator = slaTemplateIds.keySet().iterator();
            while (paasIterator.hasNext() && slaTemplateId == null) {
                currentPaaS = paasIterator.next();
                if ( currentPaaS.getUriId().equals( selectedPaaSUriId ) ) {
                    slaTemplateId = slaTemplateIds.get( currentPaaS ).getId().toString();
                }
            }
        }
        
        return slaTemplateId;
    }
}
