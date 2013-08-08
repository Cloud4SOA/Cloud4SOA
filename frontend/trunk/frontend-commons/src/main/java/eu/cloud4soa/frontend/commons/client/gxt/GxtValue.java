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

import com.extjs.gxt.ui.client.widget.form.Field;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;

/**
 * Provide the HasValue behaviours for a GXT Field widget (which, unfortunately doesn't
 * implement this interface).
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class GxtValue<T> implements HasValue<T> {
    private Field<T> field;

    public GxtValue(Field<T> field) {
        this.field = field;
    }

    @Override
    public T getValue() {
        return field.getValue();
    }

    @Override
    public void setValue(T value) {
        field.setValue(value);
    }

    @Override
    public void setValue(T value, boolean fireEvents) {
        field.setFireChangeEventOnSetValue(fireEvents);
        field.setValue(value);
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<T> valueChangeHandler) {
        return field.addHandler(valueChangeHandler, ValueChangeEvent.getType());
    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        field.fireEvent(event);
    }
}
