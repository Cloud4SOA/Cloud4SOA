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

/**
 * A base class for models that allow a dynamic form.
 * <p/>
 * This class just add a property that holds the form generation key.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public abstract class DynamicFormModel extends DisplayableKeyValueModelData {

    private static String FORM_TYPE = "c4s-form-type";
    private static String FORM_TITLE = "c4s-form-title";

    protected DynamicFormModel(String key, String value, String formType) {
        super(key, value);
        set(FORM_TYPE, formType);
    }

    protected DynamicFormModel() {
    }

    /**
     * Type string that identifies the type of form to be rendered for this model.
     *
     * @return The form type
     */
    public String getFormType() {
        return get(FORM_TYPE);
    }

    public void setFormType(String formType) {
        set(FORM_TYPE, formType);
    }

    /**
     * The title of the panel that contains the form for this model.
     *
     * @return The form title.
     */
    public String getFormTitle() {
        return get(FORM_TITLE);
    }

    public void setFormTitle(String formTitle) {
        set(FORM_TITLE, formTitle);
    }
}
