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

import eu.cloud4soa.api.datamodel.semantic.paas.PricingPolicy;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PricingPolicyModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

public class PricingPolicyMapper extends AbstractMapper<PricingPolicy, PricingPolicyModel> {

    @Override
    protected PricingPolicyModel readFrom(PricingPolicy soaInstance) {
        PricingPolicyModel pricingPolicyModel =
                soaInstance == null ? new PricingPolicyModel() : new PricingPolicyModel(soaInstance.getUriId(), soaInstance.getTitle());

        if (soaInstance != null) {
            pricingPolicyModel.setTitle(soaInstance.getTitle());
            pricingPolicyModel.setDescription(soaInstance.getDescription());
            pricingPolicyModel.set("c4s-title", "Pricing policy component");
        }

        return pricingPolicyModel;
    }

    @Override
    protected PricingPolicy writeTo(PricingPolicy soaInstance,
                                    PricingPolicyModel frontendModel) {
        if (soaInstance == null) {
            soaInstance = new PricingPolicy();
        }

        soaInstance.setTitle(frontendModel.getTitle());
        soaInstance.setDescription(frontendModel.getDescription());


        return soaInstance;
    }

}
