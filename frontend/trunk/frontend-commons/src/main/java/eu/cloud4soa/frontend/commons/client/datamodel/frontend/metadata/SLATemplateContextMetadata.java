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

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.TEXT;

import com.google.gwt.user.client.rpc.IsSerializable;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateContextModel;
import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;

/**
 * Define the basic information form for the SLA Template viewer.
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public class SLATemplateContextMetadata extends EntityMetadata implements
		IsSerializable {

	public SLATemplateContextMetadata() {
		field(FieldMetadata.create(DisplayableKeyValueModelData.KEY)
				.label("ID").visible(false).editType(TEXT));
		field(FieldMetadata
				.create(SLATemplateContextModel.AgreementInitiator)
				.label("Agreement Initiator")
				.editType(TEXT)
				.tooltip(
						"The initiator creates and manages an agreement on the availability of a service"
								+ " on behalf of either the service consumer or service provider, "
								+ "depending on the domain-specific signaling requirements"));
		field(FieldMetadata
				.create(SLATemplateContextModel.ServiceProvider)
				.label("Service Provider")
				.editType(TEXT)
				.tooltip(
						"A service provider is an entity entering into an"
								+ "agreement with the intent of providing a service according to conditions described by"
								+ "the agreement"));
		field(FieldMetadata
				.create(SLATemplateContextModel.ExpirationTime)
				.label("Expiration Time")
				.editType(TEXT)
				.tooltip(
						"Expiration time defines a time when an agreement is no longer"
								+ "valid, and the parties are no-longer obligated by the terms of the agreement"));
	}
}
