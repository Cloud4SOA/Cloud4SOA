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

package eu.cloud4soa.frontend.commons.client.gxt;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.IsSerializable;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.DisplayableKeyValue;

/**
 * A GXT ModelData implementation that store a DisplayableKeyValue.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class DisplayableKeyValueModelData extends BaseModel implements DisplayableKeyValue, IsSerializable {

    public static final String KEY = "key";
    public static final String VALUE = "displayName";

    public DisplayableKeyValueModelData() {
    }

    public DisplayableKeyValueModelData(String key, String value) {
        set(KEY, key);
        set(VALUE, value);
    }

    public DisplayableKeyValueModelData(DisplayableKeyValue keyValue) {
        this(keyValue.getKey(), keyValue.getDisplayName());
    }

    @Override
    public String getDisplayName() {
        return get(VALUE);
    }

    @Override
    public String getKey() {
        return get(KEY);
    }
}
