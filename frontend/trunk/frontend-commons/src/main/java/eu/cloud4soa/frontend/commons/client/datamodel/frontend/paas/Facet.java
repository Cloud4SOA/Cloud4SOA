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

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Facet implements IsSerializable, Comparable<Facet>{
	public enum QueryType {COMPONENT_TITLE, COMPONENT_CATEGORY, NONE};
	public static String C4S_NAMESPACE = "http://www.cloud4soa.eu/v0.1/paas-model#";
	
	private String type;
	private String category; //Contains Hardware or Software component category, if QueryType is COMPONENT_CATEGORY
	private QueryType queryType;
	private String label;
	private String comment;
	
	private List<FacetValue> values = new ArrayList<FacetValue>();
	
	public Facet(){}
	
	public Facet (String type, String category, String label, String comment, QueryType queryType, List<FacetValue> values){
		this.type = type; //Type contains the PaaS offering property
		if (queryType == QueryType.COMPONENT_CATEGORY)
			this.category = category;
		this.queryType = queryType;
		this.values = values;
		this.label = label;
		this.comment = comment;
	}
	
	public String getType (){
		return type;
	}
	
	public List<FacetValue> getValues (){
		return values;
	}
	
	public void setValues(List<FacetValue> values) {
		this.values = values;
	}
	
	public QueryType getQueryType (){
		return queryType;
	}
	
	public void setQueryType (QueryType type){
		this.queryType = type;
	}
	
	public String getLabel() {
		return label;
	}

	public String getComment() {
		return comment;
	}
	
	public String getCategory(){
		return category;
	}

	@Override
	public int compareTo(Facet o) {
		return this.getLabel().compareTo(o.getLabel());
	}
	
	@Override
	public boolean equals (Object o){
		boolean result = false;
		if (o instanceof Facet){
			Facet facet = (Facet) o;
			result = this.getType().equals(facet.getType()) && this.getLabel().equals(facet.getLabel());
		}
		return result;
	}

	
}