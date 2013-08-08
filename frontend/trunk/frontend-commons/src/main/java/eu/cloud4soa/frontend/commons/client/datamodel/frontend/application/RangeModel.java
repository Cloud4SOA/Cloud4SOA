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

import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;

import java.util.ArrayList;
import java.util.List;

/**
 * Common settings fro range model.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public abstract class RangeModel<A> extends DisplayableKeyValueModelData {

    public static final String REQUIRED = "required";
    public static final String MIN = "min";
    public static final String MAX = "max";
    public static final String STEP = "step";
    public static final String VALUES = "values";

    protected RangeModel(String key) {
        super(key, "range");
    }

    protected RangeModel() {
    }

    public List<A> getValues() {
        List<A> values = get(VALUES);
        if (values == null) {
            values = new ArrayList<A>();
            set(VALUES, values);
        }
        return values;
    }

    public A getMin() {
        return get(MIN);
    }

    public void setMin(A min) {
        set(MIN, min);
    }

    public A getMax() {
        return get(MAX);
    }

    public void setMax(A max) {
        set(MAX, max);
    }

    public A getStep() {
        return get(STEP);
    }

    public void setStep(A step) {
        set(STEP, step);
    }

    public void setRequired(boolean required) {
        set(REQUIRED, required);
    }

    public boolean isRequired() {
        return Boolean.TRUE.equals(this.get(REQUIRED));
    }


}
