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

import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;

/**
 * A simple key value part of a tree.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class SimpleKeyValueTreeNode extends SimpleKeyValue implements DisplayableKeyValueTreeNode {

    private boolean hasChildren;
    private DisplayableKeyValueTreeNode parent;
    private DisplayableKeyValueModelData modelData;

    public SimpleKeyValueTreeNode(String key, String value, boolean hasChildren, DisplayableKeyValueTreeNode parent, DisplayableKeyValueModelData modelData) {
        super(key, value);
        this.hasChildren = hasChildren;
        this.parent = parent;
        this.modelData = modelData;
    }

    public SimpleKeyValueTreeNode() {
    }


    @Override
    public boolean hasChildren() {
        return hasChildren;
    }

    @Override
    public DisplayableKeyValueTreeNode getParent() {
        return parent;
    }

    @Override
    public DisplayableKeyValueModelData getModelData() {
        return modelData;
    }
}
