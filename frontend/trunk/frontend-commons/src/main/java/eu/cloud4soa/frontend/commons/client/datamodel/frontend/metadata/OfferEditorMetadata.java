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
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.*;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata.COMBO_PROGRAMMING_LANGUAGE;

/**
 * Define the basic information form in the offer editor.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class OfferEditorMetadata extends EntityMetadata implements IsSerializable {

    public OfferEditorMetadata() {
        field(FieldMetadata.create(DisplayableKeyValueModelData.KEY)
                .label("ID")
                .visible(false)
                .editType(TEXT)
        );
        field(FieldMetadata.create(PaaSOfferingModel.TITLE)
                .label("Title")
                .editType(TEXT)
                .tooltip("A single word title that identify the PaaS Offering")
        );
        field(FieldMetadata.create(PaaSOfferingModel.DESCRIPTION)
                .label("Description")
                .editType(TEXT)
                .tooltip("A description for the PaaS Offering")
        );
        field(FieldMetadata.create(PaaSOfferingModel.URL)
                .label("URL")
                .editType(TEXT)
                .regex("^(.*:)//([a-z\\-.]+)(:[0-9]+)?(.*)$", "String you wrote doesn't appear as a valid URL")
                .tooltip("The URL of the PaaS Offering")
        );

        field(FieldMetadata.create(PaaSOfferingModel.PROGRAMMING_LANGUAGE)
                .label("Programming language")
                .editType(COMBOBOX)
                .tooltip("Main programming language for the application")
                .relatedEntityType(COMBO_PROGRAMMING_LANGUAGE)
        );

        field(FieldMetadata.create(PaaSOfferingModel.COMPUTE_SCALING_FACTOR)
                .label("Compute scaling factor")
                .editType(EDIT_NUMERIC_RANGE)
                .allowNegative(false)
                .allowDecimals(true)
                .tooltip("The compute scaling factor")
        );
        field(FieldMetadata.create(PaaSOfferingModel.WEB_SCALING_FACTOR)
                .label("Web scaling factor")
                .editType(EDIT_NUMERIC_RANGE)
                .allowNegative(false)
                .allowDecimals(true)
                .tooltip("The web scaling factor")
        );

        field(FieldMetadata.create(PaaSOfferingModel.STATUS)
                .label("Status")
                .editType(TEXT)
                .tooltip("Status of the Offering (e.g. beta, running, etc.")
        );
    }
}
