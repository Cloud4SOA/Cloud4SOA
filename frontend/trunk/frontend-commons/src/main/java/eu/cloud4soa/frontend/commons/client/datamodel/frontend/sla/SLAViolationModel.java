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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla;

import com.google.gwt.user.client.rpc.IsSerializable;

import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;

public class SLAViolationModel extends DisplayableKeyValueModelData implements IsSerializable{

	public final static String EVENT_ID = "eventId";
	public final static String METRIC = "metric";
	public final static String EXPECTED_VALUE = "expectedValue";
	public final static String ACTUAL_VALUE = "actualValue";
	public final static String STATUS = "status";
	public final static String APPLICATION = "application";
	public static final String APPLICATION_ID = "application_id";
	public final static String PROVIDER = "provider";
	public final static String DATE = "date";
	public final static String RECOVERY_ACTION = "recoveryAction";
	
	
	
	public SLAViolationModel(){
		
	}
	
	public SLAViolationModel (String key, String value){
		super (key, value);
	}
	
	public SLAViolationModel (String eventId, String metric, String actualValue, String expectedValue, String status,
			String application, String applicationId, String provider, String date, String recoveryAction){
		
		set (EVENT_ID, eventId);
		set (METRIC, metric);
		set (EXPECTED_VALUE, expectedValue);
		set (ACTUAL_VALUE, actualValue);
		set (STATUS, status);
		set (APPLICATION, application);
		set (PROVIDER, provider);
		set (DATE, date);
		set (RECOVERY_ACTION, recoveryAction);
		set (APPLICATION_ID, applicationId);
			
	}
}
