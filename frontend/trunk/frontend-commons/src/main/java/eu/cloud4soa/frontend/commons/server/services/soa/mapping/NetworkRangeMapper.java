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

import eu.cloud4soa.api.datamodel.semantic.measure.MegaByteperSecond;
import eu.cloud4soa.api.datamodel.semantic.measure.NetworkingRange;
import eu.cloud4soa.api.datamodel.semantic.measure.NetworkingUnit;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.MeasurementRangeModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

import java.util.ArrayList;

/**
 * Mapper for network range.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class NetworkRangeMapper extends AbstractMapper<NetworkingRange, MeasurementRangeModel> {

    @Override
    protected MeasurementRangeModel readFrom(NetworkingRange soaInstance) {

        MeasurementRangeModel computingRangeModel = soaInstance == null ? new MeasurementRangeModel() : new MeasurementRangeModel(soaInstance.getUriId());

        NetworkingUnit defaultNetworkingUnit = new MegaByteperSecond();

        computingRangeModel.setMin(new MeasurementUnitMapper<NetworkingUnit>()
                .from(soaInstance == null ? defaultNetworkingUnit : Strings.defaultObject(soaInstance.getMin(), defaultNetworkingUnit))
                .toModel()
        );

        computingRangeModel.setMax(new MeasurementUnitMapper<NetworkingUnit>()
                .from(soaInstance == null ? defaultNetworkingUnit : Strings.defaultObject(soaInstance.getMax(), defaultNetworkingUnit))
                .toModel()
        );

        computingRangeModel.setStep(new MeasurementUnitMapper<NetworkingUnit>()
                .from(soaInstance == null ? defaultNetworkingUnit : Strings.defaultObject(soaInstance.getStep(), defaultNetworkingUnit))
                .toModel()
        );

        if (soaInstance != null) {
            for (NetworkingUnit value : soaInstance.getOfferedNetworkingValues())
                computingRangeModel.getValues().add(new MeasurementUnitMapper<NetworkingUnit>()
                        .from(value)
                        .toModel());

        }


        return computingRangeModel;
    }

    @Override
    protected NetworkingRange writeTo(NetworkingRange soaInstance, MeasurementRangeModel frontendModel) {

        if (soaInstance == null)
            soaInstance = new NetworkingRange();

        if (soaInstance.getOfferedNetworkingValues() == null)
            soaInstance.setOfferedNetworkingValues(new ArrayList<NetworkingUnit>());

        soaInstance.setMin(
                new MeasurementUnitMapper<NetworkingUnit>()
                        .from(soaInstance.getMin())
                        .overWriteWith(frontendModel.getMin())
        );

        soaInstance.setMax(
                new MeasurementUnitMapper<NetworkingUnit>()
                        .from(soaInstance.getMax())
                        .overWriteWith(frontendModel.getMax())
        );

        soaInstance.setStep(
                new MeasurementUnitMapper<NetworkingUnit>()
                        .from(soaInstance.getStep())
                        .overWriteWith(frontendModel.getStep())
        );

        soaInstance.getOfferedNetworkingValues().clear();

        for (MeasurementModel value : frontendModel.getValues())
            soaInstance.getOfferedNetworkingValues().add(new MeasurementUnitMapper<NetworkingUnit>()
                    .overWriteWith(value));

        return soaInstance;
    }
}
