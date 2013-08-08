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
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.COMBOBOX;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.TEXT;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata.COMBO_COMPUTATION_CATEGORY;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel.*;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.RangeModel.MIN;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.RangeModel.REQUIRED;

/**
 * Compute requirement metadata
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ApplicationEditorHardwareComputeMetadata extends EntityMetadata implements IsSerializable {

    public ApplicationEditorHardwareComputeMetadata() {

        field(FieldMetadata.create(HARDWARE_CATEGORY)
                .label("Category")
                .editType(COMBOBOX)
                .tooltip("Reference to the computation unit measure used by PaaS")
                .relatedEntityType(COMBO_COMPUTATION_CATEGORY)
        );

        // architecture
        field(FieldMetadata.create(ARCHITECTURE)
                .label("Architecture")
                .editType(TEXT)
                .tooltip("32bit or 64bit")
        );

        // cache
        field(FieldMetadata.create(CACHE, MIN)
                .label("Cache")
                .editType(EditType.EDIT_MEASURE_VALUE)
                .withRequiredFlag(CACHE, REQUIRED)
                .allowDecimals(false)
                .allowNegative(false)
                .tooltip("Minimum cache size of the computational unit")
        );

        // cores
        field(FieldMetadata.create(CORES, MIN)
                .label("Number of cores")
                .editType(EditType.FLOAT)
                .withRequiredFlag(CORES, REQUIRED)
                .allowDecimals(false)
                .allowNegative(false)
                .tooltip("Number of requested cores")
        );

        // memory
        field(FieldMetadata.create(Strings.dotted(MEMORY, MIN))
                .label("Memory")
                .editType(EditType.EDIT_MEASURE_VALUE)
                .withRequiredFlag(MEMORY, REQUIRED)
                .allowDecimals(false)
                .allowNegative(false)
                .tooltip("The required memory size for the compute unit")
        );

        //computational power factor
        field(FieldMetadata.create(POWER_FACTOR, MIN)
                .label("Computational power factor")
                .editType(EditType.FLOAT)
                .withRequiredFlag(POWER_FACTOR, REQUIRED)
                .allowDecimals(true)
                .allowNegative(false)
                .tooltip("Minimum factor for the computation units")
        );

    }
}
