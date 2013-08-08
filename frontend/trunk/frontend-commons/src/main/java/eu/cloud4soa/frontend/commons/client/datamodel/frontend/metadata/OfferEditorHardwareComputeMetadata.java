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

import com.google.gwt.user.client.rpc.IsSerializable;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.*;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata.COMBO_COMPUTATION_CATEGORY;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel.*;

/**
 * Offer editor compute requirement metadata
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class OfferEditorHardwareComputeMetadata extends EntityMetadata implements IsSerializable {

    public OfferEditorHardwareComputeMetadata() {

        field(FieldMetadata.create(HARDWARE_CATEGORY)
                .label("Category")
                .editType(COMBOBOX)
                .tooltip("Computation component category")
                .relatedEntityType(COMBO_COMPUTATION_CATEGORY)
        );

        // architecture
        field(FieldMetadata.create(ARCHITECTURE)
                .label("Architecture")
                .editType(TEXT)
                .tooltip("The architecture")
        );

        field(FieldMetadata.create(CACHE)
                .label("Cache")
                .editType(EDIT_MEASURE_RANGE)
                .allowDecimals(false)
                .allowNegative(false)
                .tooltip("The offered range of cache size")
        );

        // cores
        field(FieldMetadata.create(CORES)
                .label("Number of cores")
                .editType(EDIT_NUMERIC_RANGE)
                .allowDecimals(false)
                .allowNegative(false)
                .tooltip("Type the offered number of cores")
        );

        // memory
        field(FieldMetadata.create(MEMORY)
                .label("Memory")
                .editType(EDIT_MEASURE_RANGE)
                .allowDecimals(false)
                .allowNegative(false)
                .tooltip("Type the offered memory size")
        );

        //computational power factor
        field(FieldMetadata.create(POWER_FACTOR)
                .label("Computational power factor")
                .editType(EDIT_NUMERIC_RANGE)
                .allowDecimals(false)
                .allowNegative(false)
                .tooltip("Type the offered computation power factor")
        );

    }
}
