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

import eu.cloud4soa.api.datamodel.semantic.paas.Rating;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.RatingModel;
import eu.cloud4soa.frontend.commons.server.services.soa.utils.AbstractMapper;

public class RatingMapper extends AbstractMapper<Rating, RatingModel>{

	@Override
	protected RatingModel readFrom(Rating soaInstance) {
		RatingModel ratingModel = 
			soaInstance == null ? new RatingModel() : new RatingModel(soaInstance.getUriId(), soaInstance.getValue());

        if (soaInstance != null) {
        	ratingModel.set(RatingModel.VALUE, soaInstance.getValue());
        	ratingModel.set(RatingModel.COMMENT, soaInstance.getComment());
        	ratingModel.set("c4s-title", "Pricing policy component");
        }
        
        return ratingModel;
	}

	@Override
	protected Rating writeTo(Rating soaInstance,
			RatingModel frontendModel) {
		if (soaInstance == null) { 
	    	   soaInstance = new Rating();
	       }

	       soaInstance.setValue(frontendModel.<String>get(RatingModel.VALUE));
	       soaInstance.setComment(frontendModel.<String>get(RatingModel.COMMENT));
	        
	       return soaInstance;
	}

}
