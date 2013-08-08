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
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.COMBOBOX;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.TEXT;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata.COMBO_PROGRAMMING_LANGUAGE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel.*;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.RangeModel.MIN;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.RangeModel.REQUIRED;
import static eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData.KEY;
import static eu.cloud4soa.frontend.commons.client.gxt.WithTitle.TITLE;

/**
 * Define the basic information form in the application editor.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationEditorMetadata extends EntityMetadata implements IsSerializable {

    public ApplicationEditorMetadata() {
        field(FieldMetadata.create(KEY)
                .label("ID")
                .visible(false)
        );
        field(FieldMetadata.create(TITLE)
                .label("Title")
                .editType(TEXT)
                .regex("[\\w]*", "Please type a single word with only letters and digits with no spaces and punctuations.")
                .tooltip("Id of the application; this field should not contain spaces nor punctuations.")
        );
        field(FieldMetadata.create(VERSION)
                .label("Version")
                .editType(TEXT)
                .tooltip("Application version number")
        );
        field(FieldMetadata.create(PROGRAMMING_LANGUAGE)
                .label("Programming language")
                .editType(COMBOBOX)
                .tooltip("Main programming language for the application")
                .relatedEntityType(COMBO_PROGRAMMING_LANGUAGE)
        );
        field(FieldMetadata.create(ApplicationModel.APPLICATION_CODE)
                .label("Application code")
                .editType(TEXT)
                .tooltip("Path to the application code (the address of the code archive, in case of Java  application)")
        );
        field(FieldMetadata.create(ApplicationModel.LICENSE_TYPE)
                .label("License type")
                .editType(TEXT)
                .tooltip("License type of the application")
        );
        field(FieldMetadata.create(COMPUTE_SCALING_FACTOR, MIN)
                .label("Compute scaling factor")
                .editType(EditType.FLOAT)
                .allowDecimals(true)
                .allowNegative(false)
                .withRequiredFlag(COMPUTE_SCALING_FACTOR, REQUIRED)
                .tooltip("Minimum factor for vertical scaling (number of resources for the same instance)")
        );
        field(FieldMetadata.create(WEB_SCALING_FACTOR, MIN)
                .label("Web scaling factor")
                .editType(EditType.FLOAT)
                .withRequiredFlag(WEB_SCALING_FACTOR, REQUIRED)
                .allowDecimals(true)
                .allowNegative(false)
                .tooltip("Minimum factor for horizontal scaling (number of different instances)")
        );

    }
}
