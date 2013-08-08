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

/**
 * The contract of an entity that can be identified with a string key value and
 * visually represented with a displayable description.
 *
 * @author Stefano Travelli (Cyntelix)
 * @since 08/08/11 12.42
 */
public interface DisplayableKeyValue extends KeyedValue
{

    /**
     * The description of the entity instance.
     *
     * @return The description.
     */
    public String getDisplayName();

}
