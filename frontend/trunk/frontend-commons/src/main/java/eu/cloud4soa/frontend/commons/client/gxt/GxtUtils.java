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

import com.extjs.gxt.ui.client.fx.FxConfig;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.DisplayableKeyValue;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.KeyedValue;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.SimpleKeyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility methods for GXT
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class GxtUtils {

    /**
     * Softly hide a component.
     *
     * @param component The component to hide.
     */
    public static void softHide(Component component) {
        if (component.isVisible())
            if (component.isRendered())
                component.el().fadeOut(FxConfig.NONE);
            else
                component.hide();
    }

    /**
     * Softly show a component.
     *
     * @param component The component to show.
     */
    public static void softShow(Component component) {
        if (!component.isVisible())
            if (component.isRendered())
                component.el().fadeIn(FxConfig.NONE);
            else
                component.show();
    }

    /**
     * Set the element with a certain key as selected in a key value combobox.
     *
     * @param comboBox The key value combobox.
     * @param key      The key of the item to be marked as selected.
     */
    public static <H extends DisplayableKeyValueModelData> void selectComboBoxElement(ComboBox<H> comboBox, String key) {
        for (int i = 0; i < comboBox.getStore().getCount(); i++)
            if (key != null && key.equals(comboBox.getStore().getAt(i).getKey())) {
                comboBox.setValue(comboBox.getStore().getAt(i));
                return;
            }
        comboBox.setValue(null);
    }

    public static <E extends DisplayableKeyValueModelData> void selectGridElement(Grid<E> grid, String key) {
        for (int i = 0; i < grid.getStore().getCount(); i++)
            if (grid.getStore().getAt(i).getKey().equals(key)) {
                grid.getSelectionModel().select(i, false);
                return;
            }
        grid.getSelectionModel().getSelectedItems().clear();
    }

    public static String safeKey(KeyedValue keyValue) {
        return keyValue == null ? "" : keyValue.getKey();
    }

    public static String safeDisplayName(DisplayableKeyValue keyValue) {
        return keyValue == null ? "" : keyValue.getDisplayName();
    }

    public static List<String> safeKeys(List<? extends KeyedValue> keyedValues) {
        List<String> list = new ArrayList<String>();
        if (keyedValues != null)
            for (KeyedValue keyedValue : keyedValues)
                list.add(keyedValue.getKey());

        return list;
    }

    public static List<DisplayableKeyValue> stringArray2List(String[] sa) {
        List<DisplayableKeyValue> list = new ArrayList<DisplayableKeyValue>();
        if (sa != null)
            for (String s : sa)
                list.add(new SimpleKeyValue(s, s));

        return list;
    }


}
