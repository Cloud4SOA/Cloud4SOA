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

import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;

/**
 * Check whether the two password fiends are equal
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class PasswordValidator implements Validator {

    private TextField<String> password2;

    public PasswordValidator(TextField<String> password2) {
        this.password2 = password2;
    }

    @Override
    public String validate(Field<?> field, String s) {

        TextField<String> password1 = (TextField<String>) field;

        if ((password1.getValue() != null || password2.getValue() != null) && !password1.getValue().equals(password2.getValue())) {
            return "The two passwords don't match.";
        }

        return null;
    }
}
