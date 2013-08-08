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

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.COMBOBOX;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.EDIT_MEASURE_RANGE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.EDIT_NUMERIC_RANGE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.EditType.TEXT;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata.COMBO_COMPUTATION_CATEGORY;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel.ARCHITECTURE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel.CACHE;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel.CORES;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel.HARDWARE_CATEGORY;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel.MEMORY;
import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareComponentModel.POWER_FACTOR;

import com.google.gwt.user.client.rpc.IsSerializable;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.EntityMetadata;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.FieldMetadata;

/**
 * Offer editor compute requirement metadata
 * 
 * @author Stefano Travelli (Cyntelix)
 */
public class OfferViewerHardwareComputeMetadata extends EntityMetadata
		implements IsSerializable {

	public OfferViewerHardwareComputeMetadata() {

		field(FieldMetadata.create(HARDWARE_CATEGORY).label("Category")
				.editType(COMBOBOX).tooltip("Computation component category")
				.relatedEntityType(COMBO_COMPUTATION_CATEGORY).readonly(true));

		// architecture
		field(FieldMetadata.create(ARCHITECTURE).label("Architecture")
				.editType(TEXT).tooltip("The architecture").readonly(true));

		field(FieldMetadata.create(CACHE).label("Cache")
				.editType(EDIT_MEASURE_RANGE)
				.tooltip("The offered range of cache size").readonly(true));

		// cores
		field(FieldMetadata.create(CORES).label("Number of cores")
				.editType(EDIT_NUMERIC_RANGE)
				.tooltip("Type the offered number of cores").readonly(true));

		// memory
		field(FieldMetadata.create(MEMORY).label("Memory")
				.editType(EDIT_MEASURE_RANGE)
				.tooltip("Type the offered memory size").readonly(true));

		// computational power factor
		field(FieldMetadata.create(POWER_FACTOR)
				.label("Computational power factor")
				.editType(EDIT_NUMERIC_RANGE)
				.tooltip("Type the offered computation power factor")
				.readonly(true));

	}
}
