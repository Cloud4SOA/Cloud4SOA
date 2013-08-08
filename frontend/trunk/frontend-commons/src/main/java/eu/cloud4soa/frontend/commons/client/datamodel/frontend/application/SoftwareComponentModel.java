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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend.application;

import com.google.gwt.user.client.rpc.IsSerializable;

import eu.cloud4soa.frontend.commons.client.gxt.DynamicFormModel;
import eu.cloud4soa.frontend.commons.client.gxt.WithDescription;
import eu.cloud4soa.frontend.commons.client.gxt.WithTitle;
import eu.cloud4soa.frontend.commons.client.gxt.WithType;
import eu.cloud4soa.frontend.commons.server.services.soa.MetadataMapper;

/**
 * Model of a software component to be used in the UI.
 * 
 * @author Stefano Travelli (Cyntelix)
 */
public class SoftwareComponentModel extends DynamicFormModel implements
		IsSerializable, WithTitle, WithDescription, WithType {

	public static final String SOFTWARE_CATEGORY = "softwareCategory";
	public static final String LICENSE_TYPE = "licenseType";
	public static final String VERSION = "version";
	public static final String REQUIRED = "required";
	public static final String DB_CONFIGURATION = "dbConfiguration";
	public static final String DB_DEPLOYMENT_LOCATION_URL = "dbDeployment";
	public static final String DB_NAME = "dbName";
	public static final String DB_USER = "dbUser";
	public static final String DB_PASSWORD = "dbPassword";
	public static final String DB_PASSWORD2 = "dbPassword2";

	public final static String TYPE_GENERIC = "c4s-software-category-generic";
	public final static String TYPE_DATABASE = " c4s-software-category-database";
	public final static String TYPE_SQL_DATABASE = "c4s-software-category-sql-database";
	public final static String TYPE_NO_SQL_DATABASE = "c4s-software-category-no-sql-database";

	public SoftwareComponentModel(String key, String value) {
		super(key, value, MetadataMapper.FORM_SOFTWARE_GENERIC_COMPONENT);
	}

	public SoftwareComponentModel() {
	}

	public SoftwareCategoryModel getSoftwareCategory() {
		return get(SOFTWARE_CATEGORY);
	}

	@Override
	public String getDescription() {
		return get(DESCRIPTION);
	}

	@Override
	public void setDescription(String description) {
		set(DESCRIPTION, description);
	}

	@Override
	public String getType() {
		return get(TYPE);
	}

	@Override
	public void setType(String type) {
		set(TYPE, type);
	}

	@Override
	public String getTitle() {
		return get(TITLE);
	}

	@Override
	public void setTitle(String title) {
		set(TITLE, title);
	}
}
