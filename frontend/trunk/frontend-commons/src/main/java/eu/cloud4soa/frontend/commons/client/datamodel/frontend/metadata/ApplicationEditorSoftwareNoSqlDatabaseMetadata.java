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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend.metadata;

import com.google.gwt.user.client.rpc.IsSerializable;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.CHECKBOX;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.COMBOBOX;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata.COMBO_NO_SQL_DB_CATEGORY;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.DbConfigurationModel.CACHE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.DbConfigurationModel.CAPACITY;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.RangeModel.MIN;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.RangeModel.REQUIRED;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.DB_CONFIGURATION;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.SOFTWARE_CATEGORY;

/**
 * No SQL database storage form metadata
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationEditorSoftwareNoSqlDatabaseMetadata extends EntityMetadata implements IsSerializable {

    public ApplicationEditorSoftwareNoSqlDatabaseMetadata() {

        field(FieldMetadata.create(SOFTWARE_CATEGORY)
                .label("Category")
                .editType(COMBOBOX)
                .tooltip("NoSQL Database component category")
                .relatedEntityType(COMBO_NO_SQL_DB_CATEGORY)
        );


        field(FieldMetadata.create(Strings.dotted(DB_CONFIGURATION, CAPACITY, MIN))
                .label("Database min capacity")
                .editType(EditType.EDIT_MEASURE_VALUE)
                .withRequiredFlag(Strings.dotted(DB_CONFIGURATION, CAPACITY, REQUIRED))
                .allowDecimals(false)
                .allowNegative(false)
                .tooltip("Type the required min database capacity, e.g. 10 Gb")
        );

        field(FieldMetadata.create(Strings.dotted(DB_CONFIGURATION, CACHE, MIN))
                .label("Database min cache size")
                .editType(EditType.EDIT_MEASURE_VALUE)
                .withRequiredFlag(DB_CONFIGURATION, CACHE, REQUIRED)
                .allowDecimals(false)
                .allowNegative(false)
                .tooltip("Type the required min database cache size, e.g. 10 Mb")
        );

        field(FieldMetadata.create(REQUIRED)
                .label(Strings.EMPTY)
                .boxLabel("NoSQL Database is required.")
                .editType(CHECKBOX)
                .tooltip("Check if NoSQL database is required.")
        );

    }
}
