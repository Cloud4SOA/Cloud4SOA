/*
 * This file is part of Cloud4SOA Frontend.
 *
 *     Cloud4SOA Frontend is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cloud4SOA Frontend is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cloud4SOA Frontend.  If not, see <http://www.gnu.org/licenses/>.
 */

package eu.cloud4soa.frontend.commons.client.datamodel.frontend.application;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

import eu.cloud4soa.frontend.commons.client.gxt.DynamicFormModel;
import eu.cloud4soa.frontend.commons.client.gxt.WithDescription;
import eu.cloud4soa.frontend.commons.client.gxt.WithTitle;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

/**
 * GXT Model for the application profile.
 *
 * @author Stefano Travelli (Cyntelix)
 * @author Yosu Gorroñogoitia (Atos)
 */
public class ApplicationModel extends DynamicFormModel implements IsSerializable, WithDescription, WithTitle {
    public final static String STATUS_ONLINE = "Deployed";
    public final static String STATUS_OFFLINE = "Stopped";

    public static final String VERSION = "version";
    public static final String PROGRAMMING_LANGUAGE = "programmingLanguage";
    public static final String ACRONYM = "acronym";
    public static final String APPLICATION_CODE = "applicationCode";
    public static final String ADAPTER_URL = "adapterUrl";
    public static final String DIGEST = "digest";
    public static final String DEPLOYMENT_URL = "deploymentUrl";
    public static final String APPLICATION_SIZE = "size";
    public static final String LICENSE_TYPE = "licenseType";
    public static final String COMPUTE_SCALING_FACTOR = "computeScalingFactor";
    public static final String WEB_SCALING_FACTOR = "webScalingFactor";

    /**
     * use model.getKey() to retrieve the uriId
     */
    @Deprecated
    public static final String APPLICATION_URIID = "uriId";

    public static final String OWNER_URIID = "ownerId";
    public static final String ARCHIVE = "archive";
    public static final String PAAS_PROVIDER = "provider";
    public static final String PAAS_PROVIDER_URIID = "providerUriId";
    public static final String STATUS = "status";
    public static final String RATING = "rating";

    public static final String SLA_UPTIME = "uptime";
    public static final String SLA_MAX_LATENCY = "maxLatency";
    public static final String SLA_CONTRACT_ID = "slaContractId";

    public static final String SOFT_COMPONENTS = "softwareComponents";
    public static final String HARD_COMPONENTS = "hardwareComponents";

    public ApplicationModel() {
    }

    public ApplicationModel(String key, String value) {
        super(key, value, MetadataMapper.FORM_APPLICATION);
    }

    public List<SoftwareComponentModel> getSoftwareComponents() {
        List<SoftwareComponentModel> softwareComponents = get(SOFT_COMPONENTS);
        if (softwareComponents == null) {
            softwareComponents = new ArrayList<SoftwareComponentModel>();
            set(SOFT_COMPONENTS, softwareComponents);
        }
        return softwareComponents;
    }

    public List<HardwareComponentModel> getHardwareComponents() {
        List<HardwareComponentModel> hardwareComponents = get(HARD_COMPONENTS);
        if (hardwareComponents == null) {
            hardwareComponents = new ArrayList<HardwareComponentModel>();
            set(HARD_COMPONENTS, hardwareComponents);
        }
        return hardwareComponents;
    }

    public void setProgrammingLanguage(ProgrammingLanguageModel programmingLanguageModel) {
        set(PROGRAMMING_LANGUAGE, programmingLanguageModel);
    }

    public ProgrammingLanguageModel getProgrammingLanguage() {
        ProgrammingLanguageModel programmingLanguage = get(PROGRAMMING_LANGUAGE);
        if (programmingLanguage == null) {
            programmingLanguage = new ProgrammingLanguageModel();
            set(PROGRAMMING_LANGUAGE, programmingLanguage);
        }
        return programmingLanguage;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;

        if (o instanceof ApplicationModel)
            result = ((ApplicationModel) o).getKey().equals(this.getKey());

        return result;
    }

    @Override
    public String getDescription() {
        return get(DESCRIPTION);
    }

    @Override
    public void setDescription(String description) {
        set(DESCRIPTION, description);
    }

    @Override
    public String getTitle() {
        return get(TITLE);
    }

    @Override
    public void setTitle(String title) {
        set(TITLE, title);
    }

	/**
	 * @return
	 */
	public String getSLAContractId() {
		return get(SLA_CONTRACT_ID);
	}
}
