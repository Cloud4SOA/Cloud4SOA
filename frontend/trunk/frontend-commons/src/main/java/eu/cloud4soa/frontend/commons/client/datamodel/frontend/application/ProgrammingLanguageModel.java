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

package eu.cloud4soa.frontend.commons.client.datamodel.frontend.application;

import com.google.gwt.user.client.rpc.IsSerializable;
import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;
import eu.cloud4soa.frontend.commons.client.gxt.WithDescription;

/**
 * GXT Model for the programming language entity.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ProgrammingLanguageModel extends DisplayableKeyValueModelData implements IsSerializable, WithDescription {

    public static final String VERSION = "version";

    public ProgrammingLanguageModel() {
    }

    public ProgrammingLanguageModel(String key, String value) {
        super(key, value);
    }

    @Override
    public String getDisplayName() {
        return getDescription();
    }

    @Override
    public String getDescription() {
        return get(DESCRIPTION);
    }

    @Override
    public void setDescription(String description) {
        set(DESCRIPTION, description);
    }
}


