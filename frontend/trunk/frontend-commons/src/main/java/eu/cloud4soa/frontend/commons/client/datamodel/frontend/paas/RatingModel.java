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

import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;

public class RatingModel extends DisplayableKeyValueModelData implements IsSerializable {
    public static final String COMMENT = "comment";
    public static final String VALUE = "value";

    public RatingModel() {
    }

    public RatingModel(String key, String value) {
        super(key, value);
    }
    
    public void setComment(String comment){
    	set (COMMENT, comment);
    }
    
    public String getComment (){
    	return get (COMMENT);
    }
    
    public void setValue(String value){
    	set (VALUE, value);
    }
    
    public String getValue (){
    	return get (VALUE);
    }
}