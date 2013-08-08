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
import eu.cloud4soa.frontend.commons.client.gxt.WithDescription;
import eu.cloud4soa.frontend.commons.client.gxt.WithTitle;
import eu.cloud4soa.frontend.commons.client.gxt.WithType;

/**
 * Model for the hardware category.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class HardwareCategoryModel extends DisplayableKeyValueModelData implements IsSerializable, WithDescription, WithTitle, WithType {

    public final static String TYPE_BASIC = "c4s-hardware-category-basic";
    public final static String TYPE_COMMUNICATION = "c4s-hardware-category-communication";
    public final static String TYPE_COMPUTATION = "c4s-hardware-category-computation";
    public final static String TYPE_STORAGE =" c4s-hardware-category-storage";

    public HardwareCategoryModel() {
    }

    public HardwareCategoryModel(String key, String value) {
        super(key, value);
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

    @Override
    public String getType() {
        return get(TYPE);
    }

    @Override
    public void setType(String type) {
        set(TYPE, type);
    }
}
