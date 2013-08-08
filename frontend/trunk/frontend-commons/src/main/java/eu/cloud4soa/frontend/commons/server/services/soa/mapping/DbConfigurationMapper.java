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

import eu.cloud4soa.api.datamodel.semantic.inf.DBConfiguration;
import eu.cloud4soa.api.datamodel.semantic.measure.StorageRange;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.DbConfigurationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementRangeModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.DbConfigurationModel.CACHE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.DbConfigurationModel.CAPACITY;

/**
 * Mapper for DbConfiguration
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class DbConfigurationMapper extends AbstractMapper<DBConfiguration, DbConfigurationModel> {

    @Override
    protected DbConfigurationModel readFrom(DBConfiguration soaInstance) {

        DbConfigurationModel dbConfigurationModel = soaInstance == null ? new DbConfigurationModel() : new DbConfigurationModel(soaInstance.getUriId());

        dbConfigurationModel.set(CACHE, new StorageRangeMapper()
                .from(soaInstance == null ? new StorageRange() : soaInstance.getHasDBcache())
                .toModel()
        );

        dbConfigurationModel.set(CAPACITY, new StorageRangeMapper()
                .from(soaInstance == null ? new StorageRange() : soaInstance.getHasDBcapacity())
                .toModel()
        );

        return dbConfigurationModel;
    }

    @Override
    protected DBConfiguration writeTo(DBConfiguration soaInstance, DbConfigurationModel frontendModel) {

        if (soaInstance == null)
            soaInstance = new DBConfiguration();

        soaInstance.setHasDBcache(new StorageRangeMapper()
                .from(soaInstance.getHasDBcache())
                .overWriteWith(frontendModel.<MeasurementRangeModel>get(CACHE)));

        soaInstance.setHasDBcapacity(new StorageRangeMapper()
                .from(soaInstance.getHasDBcapacity())
                .overWriteWith(frontendModel.<MeasurementRangeModel>get(CAPACITY)));

        return soaInstance;
    }
}
