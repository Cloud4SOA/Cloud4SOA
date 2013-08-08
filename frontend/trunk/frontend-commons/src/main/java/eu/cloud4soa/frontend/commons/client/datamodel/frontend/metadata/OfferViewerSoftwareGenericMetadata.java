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

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.COMBOBOX;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata.COMBO_SOFTWARE_CATEGORY;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.SOFTWARE_CATEGORY;

import com.google.gwt.user.client.rpc.IsSerializable;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;

/**
 * Define the software component form in the offer editor
 * 
 * @author Stefano Travelli (Cyntelix)
 */
public class OfferViewerSoftwareGenericMetadata extends EntityMetadata
		implements IsSerializable {

	public OfferViewerSoftwareGenericMetadata() {
		field(FieldMetadata.create(SOFTWARE_CATEGORY).label("Category")
				.editType(COMBOBOX).tooltip("Computation component category")
				.relatedEntityType(COMBO_SOFTWARE_CATEGORY).readonly(true));

		field(FieldMetadata.create(SoftwareComponentModel.TITLE).label("Title")
				.editType(EditType.TEXT)
				.tooltip("Title of the software component").readonly(true));

		field(FieldMetadata.create(SoftwareComponentModel.DESCRIPTION)
				.label("Description").editType(EditType.TEXT)
				.tooltip("Description of the software component")
				.readonly(true));

		field(FieldMetadata.create(SoftwareComponentModel.VERSION)
				.label("Version").editType(EditType.TEXT)
				.tooltip("Version of the offered software component")
				.readonly(true));

	}
}
