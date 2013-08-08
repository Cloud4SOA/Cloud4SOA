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

package eu.cloud4soa.frontend.commons.client.gxt;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.DisplayableKeyValue;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.DisplayableKeyValueTreeNode;

/**
 * GXT model for a generic key value tree node
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class DisplayableKeyValueTreeModelData extends DisplayableKeyValueModelData implements DisplayableKeyValueTreeNode {

    private final static String HAS_CHILDREN = "c4s-hasChildren";

    private final static String PARENT = "c4s-parent";

    private final static String NODE_MODEL = "c4s-node-model";

    public DisplayableKeyValueTreeModelData(DisplayableKeyValue keyValue, boolean hasChildren, DisplayableKeyValueTreeModelData parent) {
        super(keyValue);
        set(HAS_CHILDREN, hasChildren);
        set(PARENT, parent);
    }

    public DisplayableKeyValueTreeModelData(DisplayableKeyValueTreeNode keyValueTreeNode) {
        super(keyValueTreeNode);
        set(NODE_MODEL, keyValueTreeNode.getModelData());
        set(HAS_CHILDREN, Boolean.toString(keyValueTreeNode.hasChildren()));
        set(PARENT, keyValueTreeNode.getParent());
    }

    public DisplayableKeyValueTreeModelData() {
    }

    public boolean hasChildren() {
        return Boolean.parseBoolean(this.<String>get(HAS_CHILDREN));
    }

    public DisplayableKeyValueTreeModelData getParent() {
        return get(PARENT);
    }

    @Override
    public DisplayableKeyValueModelData getModelData() {
        return get(NODE_MODEL);
    }

}

