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

package eu.cloud4soa.frontend.commons.server.services.soa.utils;

import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;

/**
 * Common interface and utilities for translating soa instances to and from frontend models.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public abstract class AbstractMapper<A, M extends DisplayableKeyValueModelData> {

    private A soaInstance;

    /**
     * Create a frontend model from the given soa instance.
     *
     * @param soaInstance The soa instance to read the properties from
     * @return The frontend instance
     */
    public final AbstractMapper<A, M> from(A soaInstance) {
        this.soaInstance = soaInstance;
        return this;
    }

    public final M toModel() {
        return readFrom(soaInstance);
    }

    protected abstract M readFrom(A soaInstance);

    /**
     * Overwrite properties in the given soa instance reading from the given frontend instance.
     * <p/>
     * Since the frontend instance doesn't usually manage all the properties of the soa instance,
     * the pattern here is that an existent soa instance must be given and this method overwrites
     * only the properties managed by the frontend instance.
     * Hence, the resulting soa instance is still a complete instance.
     *
     * @param frontendModel the frontend instance to read properties from
     * @return The overwritten soa instance
     */
    public final A overWriteWith(M frontendModel) {
        if (frontendModel != null)
            return writeTo(soaInstance, frontendModel);
        else
            return soaInstance;
    }

    protected abstract A writeTo(A soaInstance, M frontendModel);


}
