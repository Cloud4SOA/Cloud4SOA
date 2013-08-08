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

import eu.cloud4soa.api.datamodel.semantic.measure.NumericRange;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.NumericRangeModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

/**
 * Mapper for numeric range
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class NumericRangeMapper extends AbstractMapper<NumericRange, NumericRangeModel> {

    @Override
    protected NumericRangeModel readFrom(NumericRange soaInstance) {

        NumericRangeModel numericRangeModel;

        if (soaInstance == null) {
            numericRangeModel = new NumericRangeModel();
        } else {

            numericRangeModel = new NumericRangeModel(soaInstance.getUriId());

            numericRangeModel.setRequired(Boolean.TRUE.equals(soaInstance.getIsRequired()));

            numericRangeModel.setMin(soaInstance.getMin());
            numericRangeModel.setMax(soaInstance.getMax());
            numericRangeModel.setStep(soaInstance.getStep());
            numericRangeModel.getValues().addAll(soaInstance.getOfferedNumericValues());
        }

        return numericRangeModel;
    }

    @Override
    protected NumericRange writeTo(NumericRange soaInstance, NumericRangeModel frontendModel) {

        if (soaInstance == null)
            soaInstance = new NumericRange();

        soaInstance.setIsRequired(frontendModel.isRequired());
        soaInstance.setMin(frontendModel.getMin());
        soaInstance.setMax(frontendModel.getMax());
        soaInstance.setStep(frontendModel.getStep());
        soaInstance.setOfferedNumericValues(frontendModel.getValues());

        return soaInstance;
    }
}
