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
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.EDIT_MEASURE_RANGE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata.COMBO_SQL_DB_CATEGORY;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.DbConfigurationModel.CACHE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.DbConfigurationModel.CAPACITY;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.DB_CONFIGURATION;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.SOFTWARE_CATEGORY;

import com.google.gwt.user.client.rpc.IsSerializable;

import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;

/**
 * Offer editor SQL database form metadata
 * 
 * @author Stefano Travelli (Cyntelix)
 */
public class OfferViewerSoftwareSqlDatabaseMetadata extends EntityMetadata
		implements IsSerializable {

	public OfferViewerSoftwareSqlDatabaseMetadata() {

		field(FieldMetadata.create(SOFTWARE_CATEGORY).label("Category")
				.editType(COMBOBOX).tooltip("SQL Database component category")
				.relatedEntityType(COMBO_SQL_DB_CATEGORY).readonly(true));

		field(FieldMetadata.create(Strings.dotted(DB_CONFIGURATION, CAPACITY))
				.label("Database capacity").editType(EDIT_MEASURE_RANGE)
				.tooltip("Type the offered database capacity").readonly(true));

		field(FieldMetadata.create(Strings.dotted(DB_CONFIGURATION, CACHE))
				.label("Database cache size").editType(EDIT_MEASURE_RANGE)
				.tooltip("Type the offered database cache size").readonly(true));
	}
}
