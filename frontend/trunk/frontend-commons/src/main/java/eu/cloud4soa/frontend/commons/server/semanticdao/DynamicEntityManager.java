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

package eu.cloud4soa.frontend.commons.server.semanticdao;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.DisplayableKeyValue;

import java.util.List;

/**
 * The contract of the dynamic entity manager.
 *
 * @author Stefano Travelli (Cyntelix)
 * @since 28/02/12 14.03
 */
public interface DynamicEntityManager {
    
    public List<DisplayableKeyValue> retrieveAllEntities(String type);
    public DisplayableKeyValue retrieveOneEntity(String type, String key);
}
