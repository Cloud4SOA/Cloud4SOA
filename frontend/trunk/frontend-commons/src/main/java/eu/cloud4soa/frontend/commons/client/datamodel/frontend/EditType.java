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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

/**
 * Types of edit styles.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public enum EditType implements Serializable, IsSerializable {
    TEXT,
    INTEGER,
    FLOAT,
    DOUBLE,
    DATE,
    TIME,
    TIMESTAMP,
    COMBOBOX,
    CHECKBOX,
    EDIT_MEASURE_VALUE,
    EDIT_MEASURE_RANGE,
    EDIT_NUMERIC_RANGE,
    PASSWORD
}
