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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas;

import com.google.gwt.user.client.rpc.IsSerializable;

public class FacetValue implements IsSerializable, Comparable<FacetValue>{
	
	private String value;
	private String description;
	public final static String FACET_VALUE_VARIABLE = "v";
	public final static String FACET_VALUE_DESCRIPTION_VARIABLE = "d";

	
	public FacetValue(){}
	
	public FacetValue (String value, String description){
		this.value = value;
		this.description = description;
	}
	
	public String getValue (){
		return value;
	}
	

	public String getDescription() {
		return description;
	}

	@Override
	public int compareTo(FacetValue o) {
		return this.getValue().compareTo(o.getValue());
	}
	
	@Override
	public boolean equals (Object o){
		boolean result = false;
		if (o instanceof FacetValue){
			FacetValue facet = (FacetValue) o;
			result = this.getValue().equals(facet.getValue());
		}
		return result;
	}

	
}