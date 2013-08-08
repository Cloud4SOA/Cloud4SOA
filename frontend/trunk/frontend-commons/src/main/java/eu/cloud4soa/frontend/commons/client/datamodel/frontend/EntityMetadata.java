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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend;

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.ArrayList;
import java.util.List;

/**
 * Define how an entity must be displayed and edited.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class EntityMetadata extends BaseModelData implements IsSerializable {

    private final static String FIELDS = "c4s-metadata-fields";

    public EntityMetadata() {
    }

    public List<FieldMetadata> getFieldsMetadata() {
        List<FieldMetadata> fields = get(FIELDS);
        if (fields == null) {
            fields = new ArrayList<FieldMetadata>();
            set(FIELDS, fields);
        }
        return fields;
    }

    public void setFieldsMetadata(List<FieldMetadata> fieldsMetadata) {
        this.set(FIELDS, fieldsMetadata);
    }

    public static EntityMetadata entity() {
        return new EntityMetadata();
    }

    public EntityMetadata field(FieldMetadata fieldMetadata) {
        getFieldsMetadata().add(fieldMetadata);
        return this;
    }
}
