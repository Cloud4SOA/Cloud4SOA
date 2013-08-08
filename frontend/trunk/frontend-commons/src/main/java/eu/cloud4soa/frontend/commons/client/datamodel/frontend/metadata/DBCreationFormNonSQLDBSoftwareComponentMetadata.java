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

/*******************************************************************************
 * Copyright (c) 2012 Atos Spain S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the LGPLv3 Lesser General Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * Contributors:
 *     Atos Spain S.A. - initial API and implementation
 *******************************************************************************/
package eu.cloud4soa.frontend.commons.client.datamodel.frontend.metadata;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.COMBOBOX;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.TEXT;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata.COMBO_NO_SQL_DB_CATEGORY;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.SOFTWARE_CATEGORY;

import com.google.gwt.user.client.rpc.IsSerializable;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;

/**
 * Project: c4s-frontend-commons
 * 
 * @author "Yosu Gorroñogoitia" Creation time: Sep 25, 2012
 */
public class DBCreationFormNonSQLDBSoftwareComponentMetadata extends
		EntityMetadata implements IsSerializable {
	public DBCreationFormNonSQLDBSoftwareComponentMetadata() {

		field(FieldMetadata.create(SoftwareComponentModel.DB_NAME)
				.label("Database Name").editType(TEXT).tooltip("Database name")
				.allowBlank(false).minLength(4));
		field(FieldMetadata.create(SoftwareComponentModel.DB_USER)
				.label("Database User").editType(TEXT).tooltip("Database User")
				.allowBlank(false));
		field(FieldMetadata.create(SoftwareComponentModel.DB_PASSWORD)
				.label("Database Password").editType(TEXT)
				.tooltip("Database Password").allowBlank(false).password(true));
		field(FieldMetadata.create(SoftwareComponentModel.DB_PASSWORD2)
				.label("Confirm Database Password").editType(TEXT)
				.tooltip("Confirm Database Password").allowBlank(false)
				.password(true));
		field(FieldMetadata.create(SOFTWARE_CATEGORY).label("Category")
				.editType(COMBOBOX)
				.tooltip("NoSQL Database component category")
				.relatedEntityType(COMBO_NO_SQL_DB_CATEGORY));

		// field(FieldMetadata.create(Strings.dotted(DB_CONFIGURATION,
		// CAPACITY))
		// .label("Database min capacity")
		// .editType(EditType.EDIT_MEASURE_RANGE)
		// .tooltip("Type the offered database capacity"));
		//
		// field(FieldMetadata.create(Strings.dotted(DB_CONFIGURATION, CACHE))
		// .label("Database cache size")
		// .editType(EditType.EDIT_MEASURE_RANGE)
		// .tooltip("Type the offered database cache size"));

	}
}
