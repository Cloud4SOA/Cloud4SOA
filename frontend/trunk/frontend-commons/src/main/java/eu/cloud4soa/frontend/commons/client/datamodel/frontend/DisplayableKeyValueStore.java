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

import java.util.*;

/**
 * Base class for the temporary in memory stores.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class DisplayableKeyValueStore<E extends DisplayableKeyValue> {
    private Map<String, E> store = new LinkedHashMap<String, E>();

    public void createAll(Collection<E> values) {
        for (E value : values)
            create(value);
    }

    public void create(E value) {
        store.put(value.getKey(), value);
    }

    public E retrieve(String key) {
        return store.get(key);
    }

    public List<E> retrieve(List<String> keys) {
        List<E> values = new ArrayList<E>();
        if (keys != null)
            for (String key : keys)
                values.add(store.get(key));
        
        return values;
    }


    public void update(E value) {
        store.put(value.getKey(), value);
    }

    public void delete(E value) {
        store.remove(value.getKey());
    }

    public List<E> list() {
        return new ArrayList<E>(store.values());
    }

}
