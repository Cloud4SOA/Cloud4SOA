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

package eu.cloud4soa.frontend.commons.server.services.soa.mapping;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.DB_CONFIGURATION;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.DB_DEPLOYMENT_LOCATION_URL;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.DB_NAME;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.DB_PASSWORD;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.DB_USER;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.LICENSE_TYPE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.REQUIRED;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.SOFTWARE_CATEGORY;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.TYPE_DATABASE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.TYPE_GENERIC;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.TYPE_NO_SQL_DATABASE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.TYPE_SQL_DATABASE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel.VERSION;
import eu.cloud4soa.api.datamodel.semantic.inf.DB;
import eu.cloud4soa.api.datamodel.semantic.inf.DBStorageComponent;
import eu.cloud4soa.api.datamodel.semantic.inf.NoSQLDB;
import eu.cloud4soa.api.datamodel.semantic.inf.SQLDB;
import eu.cloud4soa.api.datamodel.semantic.inf.SoftwareComponent;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.DbConfigurationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

/**
 * Mapper for software component.
 * 
 * @author Stefano Travelli (Cyntelix)
 */
public class SoftwareComponentMapper extends
		AbstractMapper<SoftwareComponent, SoftwareComponentModel> {

	@Override
	protected SoftwareComponentModel readFrom(SoftwareComponent soaInstance) {
		SoftwareComponentModel softwareComponentModel = soaInstance == null ? new SoftwareComponentModel()
				: new SoftwareComponentModel(soaInstance.getUriId(),
						soaInstance.getTitle());

		if (soaInstance != null) {
			softwareComponentModel.setType(TYPE_GENERIC);
			softwareComponentModel.setDescription(soaInstance.getDescription());
			softwareComponentModel.setTitle(soaInstance.getTitle());
			softwareComponentModel.set(REQUIRED, soaInstance.getIsRequired());
			softwareComponentModel.set(LICENSE_TYPE,
					soaInstance.getLicensetype());
			softwareComponentModel.set(VERSION, soaInstance.getVersion());
			softwareComponentModel.set(
					SOFTWARE_CATEGORY,
					new SoftwareCategoryMapper().from(
							soaInstance.getRelatedswcategory()).toModel());

			softwareComponentModel.setFormTitle("Software component");

			if (soaInstance instanceof DBStorageComponent) {
				DBStorageComponent dbStorageComponent = (DBStorageComponent) soaInstance;

				softwareComponentModel.set(DB_NAME,
						dbStorageComponent.getDbname());
				softwareComponentModel.set(DB_USER,
						dbStorageComponent.getDbuser());
				// softwareComponentModel.set(DB_PASSWORD,
				// dbStorageComponent.getDbpassword());//DB password not read
				// (Yosu)

				if (dbStorageComponent.getDBdeployment() != null)
					softwareComponentModel.set(DB_DEPLOYMENT_LOCATION_URL,
							dbStorageComponent.getDBdeployment().getUrl());

				softwareComponentModel.set(
						DB_CONFIGURATION,
						new DbConfigurationMapper().from(
								dbStorageComponent.getDBconfiguration())
								.toModel());

				// check if the software category point to a subclass. It
				// should, actually
				if (soaInstance.getRelatedswcategory() instanceof DB) {
					softwareComponentModel.setType(TYPE_DATABASE);
					softwareComponentModel.setFormTitle("Database component");
					softwareComponentModel
							.setFormType(MetadataMapper.FORM_SOFTWARE_DATABASE_COMPONENT);
				}
				if (soaInstance.getRelatedswcategory() instanceof NoSQLDB) {
					softwareComponentModel.setType(TYPE_NO_SQL_DATABASE);
					softwareComponentModel
							.setFormTitle("NoSQL Database component");
					softwareComponentModel
							.setFormType(MetadataMapper.FORM_SOFTWARE_NO_SQL_DB_COMPONENT);
				}
				if (soaInstance.getRelatedswcategory() instanceof SQLDB) {
					softwareComponentModel.setType(TYPE_SQL_DATABASE);
					softwareComponentModel
							.setFormTitle("SQL Database component");
					softwareComponentModel
							.setFormType(MetadataMapper.FORM_SOFTWARE_SQL_DB_COMPONENT);
				}

			}
		}

		return softwareComponentModel;

	}

	@Override
	protected SoftwareComponent writeTo(SoftwareComponent soaInstance,
			SoftwareComponentModel frontendModel) {

		if (soaInstance == null) {
			if (TYPE_GENERIC.equals(frontendModel.getType()))
				soaInstance = new SoftwareComponent();
			else
				soaInstance = new DBStorageComponent();
		}

		soaInstance.setTitle(frontendModel.getTitle());
		soaInstance.setDescription(frontendModel.getDescription());

		soaInstance.setRelatedswcategory(new SoftwareCategoryMapper().from(
				soaInstance.getRelatedswcategory()).overWriteWith(
				frontendModel.getSoftwareCategory()));

		if (soaInstance instanceof DBStorageComponent) {
			DBStorageComponent dbStorageComponent = (DBStorageComponent) soaInstance;

			dbStorageComponent.setDbname(frontendModel.<String> get(DB_NAME));
			dbStorageComponent.setDbuser(frontendModel.<String> get(DB_USER));
			dbStorageComponent.setDbpassword(frontendModel
					.<String> get(DB_PASSWORD));

			dbStorageComponent
					.setDBconfiguration(new DbConfigurationMapper()
							.from(dbStorageComponent.getDBconfiguration())
							.overWriteWith(
									frontendModel
											.<DbConfigurationModel> get(DB_CONFIGURATION)));
		}

		soaInstance.setIsRequired(frontendModel.<Boolean> get(REQUIRED));
		soaInstance.setLicensetype(frontendModel.<String> get(LICENSE_TYPE));
		soaInstance.setVersion(frontendModel.<String> get(VERSION));

		return soaInstance;
	}
}
