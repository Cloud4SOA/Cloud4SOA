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

import eu.cloud4soa.api.datamodel.semantic.measure.ComputingRange;
import eu.cloud4soa.api.datamodel.semantic.measure.ComputingUnit;
import eu.cloud4soa.api.datamodel.semantic.measure.GigaHertz;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementRangeModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

import static eu.cloud4soa.frontend.commons.client.Strings.defaultObject;

/**
 * Mapper for computing range.
 * todo ComputingRange is not used anymore
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ComputingRangeMapper extends AbstractMapper<ComputingRange, MeasurementRangeModel> {

    @Override
    protected MeasurementRangeModel readFrom(ComputingRange soaInstance) {

        MeasurementRangeModel computingRangeModel = soaInstance == null ? new MeasurementRangeModel() : new MeasurementRangeModel(soaInstance.getUriId());

        ComputingUnit defaultComputingUnit = new GigaHertz();

        computingRangeModel.setMin(new MeasurementUnitMapper<ComputingUnit>()
                .from(soaInstance == null ? defaultComputingUnit : defaultObject(soaInstance.getMin(), defaultComputingUnit))
                .toModel()
        );

        computingRangeModel.setMax(new MeasurementUnitMapper<ComputingUnit>()
                .from(soaInstance == null ? defaultComputingUnit : defaultObject(soaInstance.getMax(), defaultComputingUnit))
                .toModel()
        );

        computingRangeModel.setStep(new MeasurementUnitMapper<ComputingUnit>()
                .from(soaInstance == null ? defaultComputingUnit : defaultObject(soaInstance.getStep(), defaultComputingUnit))
                .toModel()
        );

        if (soaInstance != null)
            for (ComputingUnit value : soaInstance.getOfferedComputingValues())
                computingRangeModel.getValues().add(new MeasurementUnitMapper<ComputingUnit>()
                        .from(value)
                        .toModel());


        return computingRangeModel;
    }

    @Override
    protected ComputingRange writeTo(ComputingRange soaInstance, MeasurementRangeModel frontendModel) {

        soaInstance.setMin(
                new MeasurementUnitMapper<ComputingUnit>()
                        .from(soaInstance.getMin())
                        .overWriteWith(frontendModel.getMin())
        );

        soaInstance.setMax(
                new MeasurementUnitMapper<ComputingUnit>()
                        .from(soaInstance.getMax())
                        .overWriteWith(frontendModel.getMax())
        );

        soaInstance.setStep(
                new MeasurementUnitMapper<ComputingUnit>()
                        .from(soaInstance.getStep())
                        .overWriteWith(frontendModel.getStep())
        );

        soaInstance.getOfferedComputingValues().clear();

        for (MeasurementModel value : frontendModel.getValues())
            soaInstance.getOfferedComputingValues().add(new MeasurementUnitMapper<ComputingUnit>()
                    .overWriteWith(value));

        return soaInstance;
    }
}
