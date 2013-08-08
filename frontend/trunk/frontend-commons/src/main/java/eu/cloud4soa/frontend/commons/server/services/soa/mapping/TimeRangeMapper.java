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

import eu.cloud4soa.api.datamodel.semantic.measure.Second;
import eu.cloud4soa.api.datamodel.semantic.measure.TimeRange;
import eu.cloud4soa.api.datamodel.semantic.measure.TimeUnit;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementRangeModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

import java.util.ArrayList;

import static eu.cloud4soa.frontend.commons.client.Strings.defaultObject;

/**
 * Mapper for time range.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class TimeRangeMapper extends AbstractMapper<TimeRange, MeasurementRangeModel> {

    @Override
    protected MeasurementRangeModel readFrom(TimeRange soaInstance) {

        MeasurementRangeModel timeRangeModel = soaInstance == null ? new MeasurementRangeModel() : new MeasurementRangeModel(soaInstance.getUriId());

        TimeUnit defaultTimeUnit = new Second();


        timeRangeModel.setMin(new MeasurementUnitMapper<TimeUnit>()
                .from(soaInstance == null ? defaultTimeUnit : defaultObject(soaInstance.getMin(), defaultTimeUnit))
                .toModel()
        );

        timeRangeModel.setMax(new MeasurementUnitMapper<TimeUnit>()
                .from(soaInstance == null ? defaultTimeUnit : defaultObject(soaInstance.getMax(), defaultTimeUnit))
                .toModel()
        );

        timeRangeModel.setStep(new MeasurementUnitMapper<TimeUnit>()
                .from(soaInstance == null ? defaultTimeUnit : defaultObject(soaInstance.getStep(), defaultTimeUnit))
                .toModel()
        );

        if (soaInstance != null) {

            for (TimeUnit value : soaInstance.getOfferedTimeValues())
                timeRangeModel.getValues().add(new MeasurementUnitMapper<TimeUnit>()
                        .from(value)
                        .toModel());

        }


        return timeRangeModel;
    }

    @Override
    protected TimeRange writeTo(TimeRange soaInstance, MeasurementRangeModel frontendModel) {

        if (soaInstance == null)
            soaInstance = new TimeRange();

        if (soaInstance.getOfferedTimeValues() == null)
            soaInstance.setOfferedTimeValues(new ArrayList<TimeUnit>());

        soaInstance.setMin(
                new MeasurementUnitMapper<TimeUnit>()
                        .from(soaInstance.getMin())
                        .overWriteWith(frontendModel.getMin())
        );

        soaInstance.setMax(
                new MeasurementUnitMapper<TimeUnit>()
                        .from(soaInstance.getMax())
                        .overWriteWith(frontendModel.getMax())
        );

        soaInstance.setStep(
                new MeasurementUnitMapper<TimeUnit>()
                        .from(soaInstance.getStep())
                        .overWriteWith(frontendModel.getStep())
        );


        soaInstance.getOfferedTimeValues().clear();

        for (MeasurementModel value : frontendModel.getValues())
            soaInstance.getOfferedTimeValues().add(new MeasurementUnitMapper<TimeUnit>()
                    .overWriteWith(value));

        return soaInstance;
    }
}
