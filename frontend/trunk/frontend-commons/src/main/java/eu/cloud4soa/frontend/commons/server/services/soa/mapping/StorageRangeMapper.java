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

import eu.cloud4soa.api.datamodel.semantic.measure.GigaByte;
import eu.cloud4soa.api.datamodel.semantic.measure.StorageRange;
import eu.cloud4soa.api.datamodel.semantic.measure.StorageUnit;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementRangeModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

import java.util.ArrayList;

import static eu.cloud4soa.frontend.commons.client.Strings.defaultObject;

/**
 * Mapper for storage range.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class StorageRangeMapper extends AbstractMapper<StorageRange, MeasurementRangeModel> {

    @Override
    protected MeasurementRangeModel readFrom(StorageRange soaInstance) {

        MeasurementRangeModel measurementRangeModel = soaInstance == null ? new MeasurementRangeModel() : new MeasurementRangeModel(soaInstance.getUriId());

        StorageUnit defaultStorageUnit = new GigaByte();

        measurementRangeModel.setMin(new MeasurementUnitMapper<StorageUnit>()
                .from(soaInstance == null ? defaultStorageUnit : defaultObject(soaInstance.getMin(), defaultStorageUnit))
                .toModel());

        measurementRangeModel.setMax(new MeasurementUnitMapper<StorageUnit>()
                .from(soaInstance == null ? defaultStorageUnit : defaultObject(soaInstance.getMax(), defaultStorageUnit))
                .toModel()
        );

        measurementRangeModel.setStep(new MeasurementUnitMapper<StorageUnit>()
                .from(soaInstance == null ? defaultStorageUnit : defaultObject(soaInstance.getStep(), defaultStorageUnit))
                .toModel()
        );


        if (soaInstance != null) {
            measurementRangeModel.setRequired(Boolean.TRUE.equals(soaInstance.getIsRequired()));

            for (StorageUnit value : soaInstance.getOfferedStorageValues())
                measurementRangeModel.getValues().add(new MeasurementUnitMapper<StorageUnit>()
                        .from(value)
                        .toModel());
        }


        return measurementRangeModel;
    }

    @Override
    protected StorageRange writeTo(StorageRange soaInstance, MeasurementRangeModel frontendModel) {

        if (soaInstance == null)
            soaInstance = new StorageRange();

        if (soaInstance.getOfferedStorageValues() == null)
            soaInstance.setOfferedStorageValues(new ArrayList<StorageUnit>());

        soaInstance.setMin(
                new MeasurementUnitMapper<StorageUnit>()
                        .from(soaInstance.getMin())
                        .overWriteWith(frontendModel.getMin())
        );

        soaInstance.setMax(
                new MeasurementUnitMapper<StorageUnit>()
                        .from(soaInstance.getMax())
                        .overWriteWith(frontendModel.getMax())
        );

        soaInstance.setStep(
                new MeasurementUnitMapper<StorageUnit>()
                        .from(soaInstance.getStep())
                        .overWriteWith(frontendModel.getStep())
        );

        soaInstance.setIsRequired(frontendModel.isRequired());

        soaInstance.getOfferedStorageValues().clear();

        for (MeasurementModel value : frontendModel.getValues())
            soaInstance.getOfferedStorageValues().add(new MeasurementUnitMapper<StorageUnit>()
                    .overWriteWith(value));

        return soaInstance;
    }
}
