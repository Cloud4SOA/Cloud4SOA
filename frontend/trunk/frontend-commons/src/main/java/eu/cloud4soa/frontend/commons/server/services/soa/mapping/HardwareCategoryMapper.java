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

import eu.cloud4soa.api.datamodel.semantic.inf.CommunicationalCategory;
import eu.cloud4soa.api.datamodel.semantic.inf.ComputationalCategory;
import eu.cloud4soa.api.datamodel.semantic.inf.HardwareCategory;
import eu.cloud4soa.api.datamodel.semantic.inf.StorageCategory;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareCategoryModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

import static eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.HardwareCategoryModel.*;

/**
 * Mapper for the hardware category.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class HardwareCategoryMapper extends AbstractMapper<HardwareCategory, HardwareCategoryModel> {
    @Override
    protected HardwareCategoryModel readFrom(HardwareCategory soaInstance) {

        HardwareCategoryModel hardwareCategoryModel = soaInstance == null ? new HardwareCategoryModel() : new HardwareCategoryModel(soaInstance.getUriId(), Strings.defaultString(soaInstance.getTitle(), soaInstance.getUriId()));

        if (soaInstance != null) {
            hardwareCategoryModel.setTitle(Strings.defaultString(soaInstance.getTitle(), soaInstance.getUriId()));
            hardwareCategoryModel.setDescription(Strings.defaultString(soaInstance.getDescription(), soaInstance.getTitle(), soaInstance.getUriId()));

            if (soaInstance instanceof StorageCategory)
                hardwareCategoryModel.setType(TYPE_STORAGE);
            else if (soaInstance instanceof ComputationalCategory)
                hardwareCategoryModel.setType(TYPE_COMPUTATION);
            else if (soaInstance instanceof CommunicationalCategory)
                hardwareCategoryModel.setType(TYPE_COMMUNICATION);
            else
                hardwareCategoryModel.setType(TYPE_BASIC);

        }
        return hardwareCategoryModel;
    }

    @Override
    protected HardwareCategory writeTo(HardwareCategory soaInstance, HardwareCategoryModel frontendModel) {

        if (soaInstance == null) {
            if (TYPE_STORAGE.equals(frontendModel.getType()))
                soaInstance = new StorageCategory();
            else if (TYPE_COMPUTATION.equals(frontendModel.getType()))
                soaInstance = new ComputationalCategory();
            else if (TYPE_COMMUNICATION.equals(frontendModel.getType()))
                soaInstance = new CommunicationalCategory();
            else
                soaInstance = new HardwareCategory();
        }
        soaInstance.setUriId(frontendModel.getKey());
        soaInstance.setTitle(frontendModel.getTitle());
        soaInstance.setDescription(frontendModel.getDescription());

        return soaInstance;
    }
}
