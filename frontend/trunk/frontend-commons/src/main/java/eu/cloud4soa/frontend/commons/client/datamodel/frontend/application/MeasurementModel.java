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
import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;

/**
 * Model for a measurable unit.
 *
 * This model stores both the measure value and the measure unit.
 * An utility property (MEASURE_CLASS) provide the type of unit to be used so that the UI is able to enumerate
 * the possible choice for the user.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class MeasurementModel extends DisplayableKeyValueModelData implements IsSerializable {

    /**
     * The name of the property that stores the type of unit to be used for this measure.
     * This can be one of the following:
     * <p/>
     * - UNIT_COMPUTING
     * - UNIT_NETWORKING
     * - UNIT_TIME
     * - UNIT_STORAGE
     * - UNIT_UNKNOWN
     */
    public final static String MEASURE_CLASS = "measure-class";


    /**
     * The name of the property that stores the actual unit of measure
     */
    public final static String MEASURE_UNIT = "measureUnit";

    /**
     * The name of the property that store the value of the measure
     */
    public final static String MEASURE_VALUE = "measureValue";

    /**
     * Set of available types of unit of measure. Each type corresponds to a set of unit of measure.
     */
    public final static String UNIT_COMPUTING = "unit-computing";
    public final static String UNIT_NETWORKING = "unit-networking";
    public final static String UNIT_TIME = "unit-time";
    public final static String UNIT_STORAGE = "unit-storage";
    public final static String UNIT_UNKNOWN = "unit-unknown";

    /**
     * Set of values used for computing unit type
     */
    public final static String COMPUTING_FLOPS = "Flops";
    public final static String COMPUTING_KHZ = "KHz";
    public final static String COMPUTING_MHZ = "MHz";
    public final static String COMPUTING_GHZ = "GHz";

    /**
     * Set of values used for network unit type
     */
    public final static String NETWORK_TERABYTES_S = "TB/s";
    public final static String NETWORK_GIGABYTE_S = "GB/s";
    public final static String NETWORK_KILOBYTE_S = "KB/s";
    public final static String NETWORK_MEGABYTE_S = "MB/s";

    /**
     * Set of values used for time unit type
     */
    public final static String TIME_MILLISECONDS = "ms";
    public final static String TIME_SECONDS = "secs";
    public final static String TIME_MINUTES = "minutes";
    public final static String TIME_HOURS = "hours";

    /**
     * Set of values used for storage unit type
     */
    public final static String STORAGE_KILOBYTE = "KB";
    public final static String STORAGE_MEGABYTE = "MB";
    public final static String STORAGE_GIGABYTE = "GB";
    public final static String STORAGE_TERABYTE = "TB";

    /**
     * Generic value for unknown unit of measure.
     */
    public final static String MEASURE_UNKNOWN = "Units";


    public MeasurementModel(String key) {
        super(key, "measure");
    }

    protected MeasurementModel() {
    }

    public String getMeasureUnit() {
        return get(MEASURE_UNIT);
    }

    public void setMeasureUnit(String measureUnit) {
        set(MEASURE_UNIT, measureUnit);
    }

    public Float getMeasureValue() {
        return get(MEASURE_VALUE);
    }

    public void setMeasureValue(Float measureValue) {
        set(MEASURE_VALUE, measureValue);
    }

    public void setMeasureClass(String measureClass) {
        set(MEASURE_CLASS, measureClass);
    }

    public String getMeasureClass() {
        return get(MEASURE_CLASS);
    }

}
