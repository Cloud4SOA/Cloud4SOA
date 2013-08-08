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

import eu.cloud4soa.api.datamodel.core.PaaSInstance;
import eu.cloud4soa.api.datamodel.core.UserInstance;
import eu.cloud4soa.api.datamodel.core.utilBeans.PaaSUserInstance;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vins
 */
class Cloud4SoaSessionPaaSUserImpl implements Cloud4SoaSessionPaaSUser {
    private PaaSUserInstance userInstance;
    //PaaS profiles
    private Map<Integer, PaaSInstance> cachedPaaSInstances;
    private boolean isPaaSProfilesCacheValid;

    public Cloud4SoaSessionPaaSUserImpl(PaaSUserInstance userInstance) {
        this.userInstance = userInstance;
        
        this.cachedPaaSInstances = new HashMap<Integer, PaaSInstance>();
        isPaaSProfilesCacheValid = false;
    }


    @Override
    public PaaSUserInstance getUserInstance() {
        return userInstance;
    }
    
    @Override
    public String getUserInstanceUriId() {
        return userInstance.getUriId();
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
    public boolean isPaaSProfilesCacheValid() {
        return isPaaSProfilesCacheValid;
    }

    @Override
    public void invalidatePaaSProfilesCache() {
        isPaaSProfilesCacheValid = false;
        cachedPaaSInstances.clear();
    }
    
}
