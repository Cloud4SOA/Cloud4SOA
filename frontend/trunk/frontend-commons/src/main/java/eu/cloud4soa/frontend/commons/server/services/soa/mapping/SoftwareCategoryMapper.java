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

import eu.cloud4soa.api.datamodel.semantic.inf.DB;
import eu.cloud4soa.api.datamodel.semantic.inf.NoSQLDB;
import eu.cloud4soa.api.datamodel.semantic.inf.SQLDB;
import eu.cloud4soa.api.datamodel.semantic.inf.SoftwareCategory;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareCategoryModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareCategoryModel.*;

/**
 * Mapper for the software category.
 *
 * @author Stefano Travelli (Cyntelx)
 */
public class SoftwareCategoryMapper extends AbstractMapper<SoftwareCategory, SoftwareCategoryModel> {

    @Override
    protected SoftwareCategoryModel readFrom(SoftwareCategory soaInstance) {

        SoftwareCategoryModel softwareCategoryModel = soaInstance == null ? new SoftwareCategoryModel() : new SoftwareCategoryModel(soaInstance.getUriId(), soaInstance.getTitle());

        if (soaInstance != null) {
            softwareCategoryModel.setTitle(Strings.defaultString(soaInstance.getTitle(), soaInstance.getUriId()));
            softwareCategoryModel.setDescription(Strings.defaultString(soaInstance.getDescription(), soaInstance.getTitle(), soaInstance.getUriId()));

            if (soaInstance instanceof NoSQLDB)
                softwareCategoryModel.setType(TYPE_NO_SQL_DATABASE);
            else if (soaInstance instanceof SQLDB)
                softwareCategoryModel.setType(TYPE_SQL_DATABASE);
            else if (soaInstance instanceof DB)
                softwareCategoryModel.setType(TYPE_DATABASE);
            else
                softwareCategoryModel.setType(TYPE_BASIC);
        }

    return softwareCategoryModel;
}

    @Override
    protected SoftwareCategory writeTo(SoftwareCategory soaInstance, SoftwareCategoryModel frontendModel) {

        if (soaInstance == null) {
            if (TYPE_NO_SQL_DATABASE.equals(frontendModel.getType()))
                soaInstance = new NoSQLDB();
            else if (TYPE_SQL_DATABASE.equals(frontendModel.getType()))
                soaInstance = new SQLDB();
            else if (TYPE_DATABASE.equals(frontendModel.getType()))
                soaInstance = new DB();
            else
                soaInstance = new SoftwareCategory();
        }

        soaInstance.setUriId(frontendModel.getKey());
        soaInstance.setTitle(frontendModel.getTitle());
        soaInstance.setDescription(frontendModel.getDescription());

        return soaInstance;
    }
}
