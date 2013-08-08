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

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.TEXT;

import com.google.gwt.user.client.rpc.IsSerializable;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.ApplicationModel;

/**
 * Project: c4s-frontend-commons
 * 
 * @author "Yosu Gorroñogoitia" Creation time: Sep 25, 2012
 */
public class DeploymentFormApplicationMetadata extends EntityMetadata implements
		IsSerializable {
	public DeploymentFormApplicationMetadata() {

		field(FieldMetadata.create(ApplicationModel.TITLE).label("Name")
				.editType(TEXT).tooltip("Application name").allowBlank(false));
		field(FieldMetadata.create(ApplicationModel.VERSION).label("Version")
				.editType(TEXT).tooltip("Application version"));
		// field(FieldMetadata.create(ApplicationModel.DESCRIPTION)
		// .label("Description").editType(TEXT)
		// .tooltip("Application description"));

	}
}
