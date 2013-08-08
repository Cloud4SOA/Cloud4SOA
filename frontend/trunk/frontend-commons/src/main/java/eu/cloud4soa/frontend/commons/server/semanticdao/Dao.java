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

import eu.cloud4soa.api.datamodel.semantic.Thing;
import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;

import java.util.List;

/**
 * Define a generic DAO for frontend models.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public interface Dao<M extends DisplayableKeyValueModelData> {

    public List<M> pagedList(int offset, int size);

    public List<M> list();

    public String create(M model);

    public void update(M model);

    public void delete(M model);

    public M findByUriId(String uriId);

    int count();

}
