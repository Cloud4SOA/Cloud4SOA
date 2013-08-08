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

import com.google.gwt.user.client.rpc.IsSerializable;
import eu.cloud4soa.frontend.commons.client.gxt.DynamicFormModel;
import eu.cloud4soa.frontend.commons.client.gxt.WithDescription;
import eu.cloud4soa.frontend.commons.client.gxt.WithType;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

/**
 * Model for an hardware component.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class HardwareComponentModel extends DynamicFormModel implements IsSerializable, WithDescription, WithType {

    public static final String VERSION = "version";
    public static final String HARDWARE_CATEGORY = "hardwareCategory";
    public static final String BANDWIDTH = "bandwidth";
    public static final String LATENCY = "latency";
    public static final String CAPACITY = "capacity";
    public static final String POWER_FACTOR = "powerFactor";
    public static final String ARCHITECTURE = "architecture";
    public static final String CACHE = "cache";
    public static final String MEMORY = "memory";
    public static final String CORES = "cores";
    public static final String STATE = "state";
    public static final String SUPPORT_ERROR_CORRECTION = "supportErrorCorrection";
    public static final String HTTP_REQUESTS = "httpRequests";

    public final static String TYPE_NETWORK = "c4s-network";
    public final static String TYPE_COMPUTATION = "c4s-computation";
    public final static String TYPE_STORAGE = "c4s-storage";
    public final static String TYPE_HTTP_REQUEST_HANDLER = "c4s-http-request-handler";

    public HardwareComponentModel() {
    }

    public HardwareComponentModel(String key, String value) {
        super(key, value, MetadataMapper.FORM_HARDWARE_GENERIC_COMPONENT);
    }

    public HardwareCategoryModel getHardwareCategory() {
        return get(HARDWARE_CATEGORY);
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
    public String getType() {
        return get(TYPE);
    }

    @Override
    public void setType(String type) {
        set(TYPE, type);
    }

}
