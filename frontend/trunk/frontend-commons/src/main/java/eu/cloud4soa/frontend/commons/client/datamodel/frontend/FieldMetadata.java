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

import com.extjs.gxt.ui.client.data.BaseModelData;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.FieldEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.*;
import com.google.gwt.user.client.rpc.IsSerializable;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.*;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAMetricModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAPolicyDurationModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAPolicyExpressionModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAPolicyModel;
import eu.cloud4soa.frontend.commons.client.gxt.*;

/**
 * Describe how a field must be displayed and edited.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class FieldMetadata extends BaseModelData implements IsSerializable {

    public final static String COMBO_PROGRAMMING_LANGUAGE = "c4s-programming-language";
    public final static String COMBO_HARDWARE_CATEGORY = "c4s-hardware-category";
    public final static String COMBO_COMMUNICATION_CATEGORY = "c4s-communication-category";
    public final static String COMBO_COMPUTATION_CATEGORY = "c4s-computation-category";
    public final static String COMBO_STORAGE_CATEGORY = "c4s-storage-category";
    public final static String COMBO_SOFTWARE_CATEGORY = "c4s-software-category";
    public final static String COMBO_DATABASE_CATEGORY = "c4s-database-category";
    public final static String COMBO_SQL_DB_CATEGORY = "c4s-sql-db-category";
    public final static String COMBO_NO_SQL_DB_CATEGORY = "c4s-no-sql-db-category";
    public final static String COMBO_AVAILABLE_SLA_METRICS = "c4s-available-sla-metrics";
    public final static String COMBO_SLA_DURATION = "c4s-sla-duration";
    public final static String COMBO_SLA_EXPRESSION = "c4s-sla-expression";

    private final static int COMBO_BOX_LIST_WIDTH = 300;

    private final static String TYPE = "c4s-metadata-type";

    private final static String EDIT_TYPE = "c4s-metadata-edit-type";

    private final static String RELATED_ENTITY = "c4s-metadata-related-entity";

    private final static String NAME = "c4s-metadata-name";

    private final static String LABEL = "c4s-metadata-label";

    private final static String BOX_LABEL = "c4s-metadata-box-label";

    private final static String ALLOW_BLANK = "c4s-metadata-allow-blank";

    private final static String TOOLTIP = "c4s-metadata-tooltip";

    private final static String VISIBLE = "c4s-metadata-visible";

    private final static String READ_ONLY = "c4s-metadata-readonly";

    private final static String PASSWORD = "c4s-metadata-password";

    private final static String REGEX = "c4s-metadata-regex";

    private final static String REGEX_MESSAGE = "c4s-metadata-regex-message";

    private final static String ALLOW_NEGATIVE = "c4s-metadata-allow-negative";

    private final static String ALLOW_NEGATIVE_MESSAGE = "c4s-metadata-allow-negative-message";

    private final static String ALLOW_DECIMALS = "c4s-metadata-allow-decimals";

    private final static String MAX_VALUE = "c4s-metadata-max-value";

    private final static String MAX_VALUE_MESSAGE = "c4s-metadata-max-value-message";

    private final static String MIN_VALUE = "c4s-metadata-min-value";

    private final static String MIN_VALUE_MESSAGE = "c4s-metadata-min-value-message";

    private final static String MIN_LENGHT = "c4s-metadata-min-length";

    private final static String MAX_LENGHT = "c4s-metadata-max-length";

    private final static String WITH_REQUIRED_FLAG = "c4s-metadata-with-required-flag";

    public FieldMetadata() {
    }

    public static FieldMetadata create(String... name) {
        FieldMetadata fieldMetadata = new FieldMetadata();
        fieldMetadata.setName(Strings.dotted(name));
        return fieldMetadata;
    }

    public FieldMetadata editType(EditType editType) {
        setEditType(editType);
        return this;
    }

    public FieldMetadata relatedEntityType(String relatedEntityType) {
        setRelatedEntityType(relatedEntityType);
        return this;
    }

    public FieldMetadata label(String label) {
        setLabel(label);
        return this;
    }

    public FieldMetadata boxLabel(String boxLabel) {
        setBoxLabel(boxLabel);
        return this;
    }

    public FieldMetadata allowBlank(boolean mandatory) {
        setAllowBlank(mandatory);
        return this;
    }

    public FieldMetadata tooltip(String tooltip) {
        setTooltip(tooltip);
        return this;
    }

    public FieldMetadata visible(boolean visible) {
        setVisible(visible);
        return this;
    }

    public FieldMetadata readonly(boolean readonly) {
        setReadOnly(readonly);
        return this;
    }

    public FieldMetadata password(boolean password) {
        setPassword(password);
        return this;
    }

    public FieldMetadata regex(String regex, String message) {
        setRegex(regex);
        setRegexMessage(message);
        return this;
    }

    public FieldMetadata minLength(int length) {
        setMinLength(length);
        return this;
    }

    public FieldMetadata maxLength(int length) {
        setMaxLength(length);
        return this;
    }

    public FieldMetadata allowNegative(boolean allowNegative, String message) {
        setAllowNegative(allowNegative);
        setAllowNegativeMessage(message);
        return this;
    }

    public FieldMetadata allowNegative(boolean allowNegative) {
        return allowNegative(allowNegative, null);
    }

    public FieldMetadata allowDecimals(boolean allowDecimals) {
        setAllowDecimals(allowDecimals);
        return this;
    }

    public FieldMetadata maxValue(Number maxValue, String message) {
        setMaxValue(maxValue);
        setMaxValueMessage(message);
        return this;
    }

    public FieldMetadata minValue(Number minValue, String message) {
        setMinValue(minValue);
        setMinValueMessage(message);
        return this;
    }

    /**
     * Set the name (path) of the boolean model's property the 'required' must be bound to.
     *
     * @param name Name or dotted path of the required property.
     * @return The current field metadata.
     */
    public FieldMetadata withRequiredFlag(String... name) {
        setWithRequiredFlag(Strings.dotted(name));
        return this;
    }

    public String getRelatedEntityType() {
        return get(RELATED_ENTITY);
    }

    public void setRelatedEntityType(String relatedEntityType) {
        this.set(RELATED_ENTITY, relatedEntityType);
    }

    public EditType getEditType() {
        return nullSafeGet(EDIT_TYPE, EditType.TEXT);
    }

    public void setEditType(EditType editType) {
        this.set(EDIT_TYPE, editType);
    }

    public String getLabel() {
        return get(LABEL);
    }

    public void setLabel(String label) {
        this.set(LABEL, label);
    }

    public String getBoxLabel() {
        return get(BOX_LABEL);
    }

    public void setBoxLabel(String boxLabel) {
        set(BOX_LABEL, boxLabel);
    }

    public boolean isAllowBlank() {
        return nullSafeGet(ALLOW_BLANK, true);
    }

    public void setAllowBlank(boolean allowBlank) {
        this.set(ALLOW_BLANK, allowBlank);
    }

    public String getName() {
        return get(NAME);
    }

    public void setName(String name) {
        this.set(NAME, name);
    }

    public String getRegex() {
        return get(REGEX);
    }

    public String getRegexMessage() {
        return get(REGEX_MESSAGE);
    }

    public String getTooltip() {
        return get(TOOLTIP);
    }

    public void setTooltip(String tooltip) {
        this.set(TOOLTIP, tooltip);
    }

    public boolean isVisible() {
        return nullSafeGet(VISIBLE, true);
    }

    public void setVisible(boolean visible) {
        this.set(VISIBLE, visible);
    }

    public boolean isReadOnly() {
        return nullSafeGet(READ_ONLY, false);
    }

    public void setReadOnly(boolean readonly) {
        this.set(READ_ONLY, readonly);
    }

    private boolean isPassword() {
        return nullSafeGet(PASSWORD, false);
    }

    public void setPassword(boolean password) {
        this.set(PASSWORD, password);
    }

    public void setRegex(String regex) {
        this.set(REGEX, regex);
    }

    public void setRegexMessage(String regexMessage) {
        this.set(REGEX_MESSAGE, regexMessage);
    }

    public void setMinLength(int min) {
        this.set(MIN_LENGHT, min);
    }

    public int getMinLength() {
        return nullSafeGet(MIN_LENGHT, 0);
    }

    public void setMaxLength(int max) {
        this.set(MAX_LENGHT, max);
    }

    public int getMaxLength() {
        return nullSafeGet(MAX_LENGHT, 0);
    }

    public void setAllowNegative(boolean allowNegative) {
        this.set(ALLOW_NEGATIVE, allowNegative);
    }

    public boolean isAllowNegative() {
        return nullSafeGet(ALLOW_NEGATIVE, false);
    }

    public void setAllowNegativeMessage(String allowNegativeMessage) {
        this.set(ALLOW_NEGATIVE_MESSAGE, allowNegativeMessage);
    }

    public String getAllowNegativeMessage() {
        return nullSafeGet(ALLOW_NEGATIVE_MESSAGE, Strings.EMPTY);
    }

    public void setAllowDecimals(boolean allowDecimals) {
        this.set(ALLOW_DECIMALS, allowDecimals);
    }

    public boolean isAllowDecimals() {
        return nullSafeGet(ALLOW_DECIMALS, false);
    }

    public void setMinValue(Number minValue) {
        this.set(MIN_VALUE, minValue);
    }

    public Number getMinValue() {
        return get(MIN_VALUE);
    }

    public void setMinValueMessage(String minValueMessage) {
        this.set(MIN_VALUE_MESSAGE, minValueMessage);
    }

    public String getMinValueMessage() {
        return nullSafeGet(MIN_VALUE_MESSAGE, Strings.EMPTY);
    }

    public void setMaxValue(Number maxValue) {
        this.set(MAX_VALUE, maxValue);
    }

    public Number getMaxValue() {
        return get(MAX_VALUE);
    }

    public void setMaxValueMessage(String maxValueMessage) {
        this.set(MAX_VALUE_MESSAGE, maxValueMessage);
    }

    public String getMaxValueMessage() {
        return nullSafeGet(MAX_VALUE_MESSAGE, Strings.EMPTY);
    }

    public String getWithRequiredFlag() {
        return nullSafeGet(WITH_REQUIRED_FLAG, Strings.EMPTY);
    }

    public void setWithRequiredFlag(String name) {
        this.set(WITH_REQUIRED_FLAG, name);
    }

    private <T> T nullSafeGet(String fieldName, T defaultValue) {
        T value = get(fieldName);
        return value == null ? defaultValue : value;
    }

    /**
     * Add the described field to the given container.
     *
     * @param container The container the field should be added to.
     * @param modelData The model behind which the field belongs to.
     */
    public void addField(LayoutContainer container, BaseModelData modelData) {

        if (!isVisible())
            return;

        switch (this.getEditType()) {

            case TEXT:

                TextField<String> textField = new TextField<String>();
                textField.setAllowBlank(this.isAllowBlank());
                textField.setPassword(this.isPassword());
                if (this.getMinLength() > 0)
                    textField.setMinLength(this.getMinLength());
                if (this.getMaxLength() > 0)
                    textField.setMaxLength(this.getMaxLength());

                TextField<String>.TextFieldMessages messages = textField.new TextFieldMessages();
                textField.setMessages(messages);

                decorateField(textField);
                container.add(textField);

                if (Strings.isNotEmpty(getRegex()))
                    textField.setRegex(getRegex());

                if (Strings.isNotEmpty(getRegexMessage()))
                    messages.setRegexText(getRegexMessage());

                break;

            case DATE:
                DateField dateField = new DateField();
                dateField.setFormatValue(true);
                dateField
                        .setPropertyEditor(new DateTimePropertyEditor("dd/MM/yyyy"));

                decorateField(dateField);
                container.add(dateField);

                break;

            case TIME:
                TimeField timeField = new TimeField();
                timeField.setName(this.getName());
                timeField.setFieldLabel(this.getLabel());
                timeField.setToolTip(this.getTooltip());

                decorateField(timeField);
                container.add(timeField);

                break;

            case TIMESTAMP:
                DateField timestampField = new DateField();
                timestampField.setFormatValue(true);
                timestampField.setPropertyEditor(new DateTimePropertyEditor(
                        "dd/MM/yyyy HH:mm"));

                decorateField(timestampField);
                container.add(timestampField);

                break;

            case DOUBLE:
                NumberField doubleField = new NumberField();
                doubleField.setPropertyEditorType(Double.class);
                doubleField.setAllowBlank(this.isAllowBlank());

                applyNumberFieldValidation(doubleField);

                decorateField(doubleField);
                container.add(doubleField);

                break;

            case INTEGER:
                NumberField integerField = new NumberField();
                integerField.setPropertyEditorType(Integer.class);
                integerField.setAllowBlank(this.isAllowBlank());

                applyNumberFieldValidation(integerField);
                integerField.setAllowDecimals(false);

                decorateField(integerField);
                container.add(integerField);

                break;
            case FLOAT:
                NumberField floatField = new NumberField();
                floatField.setPropertyEditorType(Float.class);
                floatField.setAllowBlank(this.isAllowBlank());

                applyNumberFieldValidation(floatField);

                decorateField(floatField);
                container.add(floatField);

                if (Strings.isNotEmpty(getWithRequiredFlag())) {
                    CheckBox cb = new CheckBox();
                    cb.setLabelSeparator(Strings.EMPTY);
                    cb.setName(getWithRequiredFlag());
                    cb.setBoxLabel("Required value");
                    cb.setToolTip("Check this flag if you want to set this value as strictly required");
                    container.add(cb);
                }


                break;

            case COMBOBOX:
                ComboBox comboBoxField = null;
                if (COMBO_PROGRAMMING_LANGUAGE.equals(this.getRelatedEntityType())) {
                    ComboBox<ProgrammingLanguageModel> comboBox = new ComboBox<ProgrammingLanguageModel>();
                    comboBox.setStore(new ProgrammingLanguageListStore());
                    comboBox.setDisplayField(WithDescription.DESCRIPTION);
                    comboBox.setMinListWidth(COMBO_BOX_LIST_WIDTH);
                    comboBox.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboBoxField = comboBox;
                } else if (COMBO_HARDWARE_CATEGORY.equals(this
                        .getRelatedEntityType())) {
                    ComboBox<HardwareCategoryModel> comboBox = new ComboBox<HardwareCategoryModel>();
                    comboBox.setStore(new HardwareCategoryListStore());
                    comboBox.setDisplayField(WithTitle.TITLE);
                    comboBox.setTemplate(getCategoryTemplate());
                    comboBox.setMinListWidth(COMBO_BOX_LIST_WIDTH);
                    comboBox.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboBoxField = comboBox;
                } else if (COMBO_COMMUNICATION_CATEGORY.equals(this
                        .getRelatedEntityType())) {
                    ComboBox<HardwareCategoryModel> comboBox = new ComboBox<HardwareCategoryModel>();
                    comboBox.setStore(new CommunicationCategoryListStore());
                    comboBox.setDisplayField(WithTitle.TITLE);
                    comboBox.setTemplate(getCategoryTemplate());
                    comboBox.setMinListWidth(COMBO_BOX_LIST_WIDTH);
                    comboBox.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboBoxField = comboBox;
                } else if (COMBO_COMPUTATION_CATEGORY.equals(this
                        .getRelatedEntityType())) {
                    ComboBox<HardwareCategoryModel> comboBox = new ComboBox<HardwareCategoryModel>();
                    comboBox.setStore(new ComputationCategoryListStore());
                    comboBox.setDisplayField(WithTitle.TITLE);
                    comboBox.setTemplate(getCategoryTemplate());
                    comboBox.setMinListWidth(COMBO_BOX_LIST_WIDTH);
                    comboBox.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboBoxField = comboBox;
                } else if (COMBO_STORAGE_CATEGORY.equals(this
                        .getRelatedEntityType())) {
                    ComboBox<HardwareCategoryModel> comboBox = new ComboBox<HardwareCategoryModel>();
                    comboBox.setStore(new StorageCategoryListStore());
                    comboBox.setDisplayField(WithTitle.TITLE);
                    comboBox.setTemplate(getCategoryTemplate());
                    comboBox.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboBox.setMinListWidth(COMBO_BOX_LIST_WIDTH);
                    comboBoxField = comboBox;
                } else if (COMBO_SOFTWARE_CATEGORY.equals(this
                        .getRelatedEntityType())) {
                    ComboBox<SoftwareCategoryModel> comboBox = new ComboBox<SoftwareCategoryModel>();
                    comboBox.setStore(new SoftwareCategoryListStore());
                    comboBox.setDisplayField(WithTitle.TITLE);
                    comboBox.setTemplate(getCategoryTemplate());
                    comboBox.setMinListWidth(COMBO_BOX_LIST_WIDTH);
                    comboBox.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboBoxField = comboBox;
                } else if (COMBO_DATABASE_CATEGORY.equals(this
                        .getRelatedEntityType())) {
                    ComboBox<SoftwareCategoryModel> comboBox = new ComboBox<SoftwareCategoryModel>();
                    comboBox.setStore(new DatabaseCategoryListStore());
                    comboBox.setDisplayField(WithTitle.TITLE);
                    comboBox.setTemplate(getCategoryTemplate());
                    comboBox.setMinListWidth(COMBO_BOX_LIST_WIDTH);
                    comboBox.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboBoxField = comboBox;
                } else if (COMBO_SQL_DB_CATEGORY
                        .equals(this.getRelatedEntityType())) {
                    ComboBox<SoftwareCategoryModel> comboBox = new ComboBox<SoftwareCategoryModel>();
                    comboBox.setStore(new SqlDatabaseCategoryListStore());
                    comboBox.setDisplayField(WithTitle.TITLE);
                    comboBox.setTemplate(getCategoryTemplate());
                    comboBox.setMinListWidth(COMBO_BOX_LIST_WIDTH);
                    comboBox.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboBoxField = comboBox;
                } else if (COMBO_NO_SQL_DB_CATEGORY.equals(this
                        .getRelatedEntityType())) {
                    ComboBox<SoftwareCategoryModel> comboBox = new ComboBox<SoftwareCategoryModel>();
                    comboBox.setStore(new NoSqlDatabaseCategoryListStore());
                    comboBox.setDisplayField(WithTitle.TITLE);
                    comboBox.setTemplate(getCategoryTemplate());
                    comboBox.setMinListWidth(COMBO_BOX_LIST_WIDTH);
                    comboBox.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboBoxField = comboBox;
                } else if (COMBO_AVAILABLE_SLA_METRICS.equals(this
                        .getRelatedEntityType())) {
                    generateSLAPolicyCombo(COMBO_AVAILABLE_SLA_METRICS);
                    if (modelData instanceof SLAPolicyModel) {
                        SLAPolicyModel policyModel = (SLAPolicyModel) modelData;
                        ComboBox<SLAMetricModel> comboBox = new ComboBox<SLAMetricModel>();
                        ListStore<SLAMetricModel> store = new ListStore<SLAMetricModel>();
                        store.add(policyModel.getAvailableMetrics());
                        comboBox.setStore(store);
                        comboBox.setDisplayField(WithTitle.TITLE);
                        comboBox.setTemplate(getCategoryTemplate());
                        comboBox.setMinListWidth(COMBO_BOX_LIST_WIDTH);
                        comboBox.setTriggerAction(ComboBox.TriggerAction.ALL);
                        comboBoxField = comboBox;
                    }
                } else if (COMBO_SLA_DURATION.equals(this
                        .getRelatedEntityType())) {
                    if (modelData instanceof SLAPolicyModel) {
                        SLAPolicyModel policyModel = (SLAPolicyModel) modelData;
                        ComboBox<SLAPolicyDurationModel> comboBox = new ComboBox<SLAPolicyDurationModel>();
                        ListStore<SLAPolicyDurationModel> store = new ListStore<SLAPolicyDurationModel>();
                        store.add(policyModel.getDurations());
                        comboBox.setStore(store);
                        comboBox.setDisplayField(WithTitle.TITLE);
                        comboBox.setTemplate(getCategoryTemplate());
                        comboBox.setMinListWidth(COMBO_BOX_LIST_WIDTH);
                        comboBox.setTriggerAction(ComboBox.TriggerAction.ALL);
                        comboBoxField = comboBox;
                    }
                } else if (COMBO_SLA_EXPRESSION.equals(this
                        .getRelatedEntityType())) {
                    if (modelData instanceof SLAPolicyModel) {
                        SLAPolicyModel policyModel = (SLAPolicyModel) modelData;
                        ComboBox<SLAPolicyExpressionModel> comboBox = new ComboBox<SLAPolicyExpressionModel>();
                        ListStore<SLAPolicyExpressionModel> store = new ListStore<SLAPolicyExpressionModel>();
                        store.add(policyModel.getExpressions());
                        comboBox.setStore(store);
                        comboBox.setDisplayField(WithTitle.TITLE);
                        comboBox.setTemplate(getCategoryTemplate());
                        comboBox.setMinListWidth(COMBO_BOX_LIST_WIDTH);
                        comboBox.setTriggerAction(ComboBox.TriggerAction.ALL);
                        comboBoxField = comboBox;
                    }
                } else {
                    ComboBox<DisplayableKeyValueModelData> comboBox = new ComboBox<DisplayableKeyValueModelData>();
                    comboBox.setStore(new DynamicDisplayableKeyValueListStore(this
                            .getRelatedEntityType()));
                    comboBox.setDisplayField(DisplayableKeyValueModelData.VALUE);
                    comboBox.setTriggerAction(ComboBox.TriggerAction.ALL);
                    comboBoxField = comboBox;

                }

                decorateField(comboBoxField);
                container.add(comboBoxField);

                break;
            case CHECKBOX:
                CheckBox checkBox = new CheckBox();
                checkBox.setBoxLabel(this.getBoxLabel());

                decorateField(checkBox);
                container.add(checkBox);

                break;
            case EDIT_MEASURE_VALUE:

                NumberField valueField = new NumberField();
                valueField.setPropertyEditorType(Float.class);
                valueField.setAllowBlank(this.isAllowBlank());
                decorateField(valueField, Strings.dotted(this.getName(),
                        MeasurementModel.MEASURE_VALUE));

                RadioGroup unitField = createUnitField(
                        modelData.<MeasurementModel>get(Strings.dotted(this
                                .getName())), this.isReadOnly());

                applyNumberFieldValidation(valueField);

                container.add(valueField);
                container.add(unitField);

                if (Strings.isNotEmpty(getWithRequiredFlag())) {
                    CheckBox cb = new CheckBox();
                    cb.setLabelSeparator(Strings.EMPTY);
                    cb.setName(getWithRequiredFlag());
                    cb.setBoxLabel("Required value");
                    cb.setToolTip("Check this flag if you want to set this measure as strictly required");
                    container.add(cb);
                }

                break;
            case EDIT_MEASURE_RANGE:
                // range is composed of three fields: min, max and unit type

                NumberField rangeMinValueField = new NumberField();
                rangeMinValueField.setPropertyEditorType(Float.class);
                rangeMinValueField.setAllowBlank(this.isAllowBlank());
                decorateField(rangeMinValueField, Strings.dotted(this.getName(),
                        RangeModel.MIN, MeasurementModel.MEASURE_VALUE),
                        this.getLabel() + " min");

                RadioGroup minUnitField = createUnitField(
                        modelData.<MeasurementModel>get(Strings.dotted(
                                this.getName(), RangeModel.MIN)), this.isReadOnly());

                NumberField rangeMaxValueField = new NumberField();
                rangeMaxValueField.setPropertyEditorType(Float.class);
                rangeMaxValueField.setAllowBlank(this.isAllowBlank());
                decorateField(rangeMaxValueField, Strings.dotted(this.getName(),
                        RangeModel.MAX, MeasurementModel.MEASURE_VALUE), "max");

                RadioGroup maxUnitField = createUnitField(
                        modelData.<MeasurementModel>get(Strings.dotted(
                                this.getName(), RangeModel.MAX)), this.isReadOnly());

                applyDecimalAllowance(rangeMinValueField);
                applyDecimalAllowance(rangeMaxValueField);
                applyNegativeAllowance(rangeMinValueField);
                applyNegativeAllowance(rangeMaxValueField);
                rangeMaxValueField.setValidator(new RangeValidator(rangeMinValueField));

                container.add(rangeMinValueField);
                container.add(minUnitField);
                container.add(rangeMaxValueField);
                container.add(maxUnitField);

                break;

            case EDIT_NUMERIC_RANGE:
                // numeric range is composed of two numeric fields: min and max.
                NumberField numericMinValueField = new NumberField();
                numericMinValueField.setPropertyEditorType(Float.class);
                numericMinValueField.setAllowBlank(this.isAllowBlank());
                decorateField(numericMinValueField, Strings.dotted(this.getName(), RangeModel.MIN), this.getLabel() + " min");

                NumberField numericMaxValueField = new NumberField();
                numericMaxValueField.setPropertyEditorType(Float.class);
                numericMaxValueField.setAllowBlank(this.isAllowBlank());
                decorateField(numericMaxValueField, Strings.dotted(this.getName(), RangeModel.MAX), this.getLabel() + " max");

                applyDecimalAllowance(numericMinValueField);
                applyDecimalAllowance(numericMaxValueField);
                applyNegativeAllowance(numericMinValueField);
                applyNegativeAllowance(numericMaxValueField);
                numericMaxValueField.setValidator(new RangeValidator(numericMinValueField));

                container.add(numericMinValueField);
                container.add(numericMaxValueField);

                break;

            case PASSWORD:
                TextField<String> password1 = new TextField<String>();
                password1.setPassword(true);
                decorateField(password1);

                TextField<String> password2 = new TextField<String>();
                password2.setPassword(true);
                decorateField(password2, getName() + "_2", "Repeat");

                password1.setValidator(new PasswordValidator(password2));

                container.add(password1);
                container.add(password2);

                break;

            default:
                TextField<String> textFieldDef = new TextField<String>();
                textFieldDef.setAllowBlank(this.isAllowBlank());

                decorateField(textFieldDef);
                container.add(textFieldDef);

        }

    }

    /**
     * @param comboAvailableSlaMetrics
     */
    private void generateSLAPolicyCombo(String comboAvailableSlaMetrics) {
        // TODO Auto-generated method stub

    }

    private void applyNumberFieldValidation(NumberField numberField) {
        if (this.getMinValue() != null) {
            numberField.setMinValue(this.getMinValue());
            numberField.getMessages().setMinText(this.getMinValueMessage());
        }

        if (this.getMaxValue() != null) {
            numberField.setMaxValue(this.getMaxValue());
            numberField.getMessages().setMaxText(this.getMaxValueMessage());
        }

        applyDecimalAllowance(numberField);
        applyNegativeAllowance(numberField);
    }

    private void applyDecimalAllowance(NumberField numberField) {
        numberField.setAllowDecimals(this.isAllowDecimals());
    }

    private void applyNegativeAllowance(NumberField numberField) {
        numberField.setAllowNegative(this.isAllowNegative());
        if (!this.isAllowNegative() && Strings.isNotEmpty(this.getAllowNegativeMessage()))
            numberField.getMessages().setNegativeText(this.getAllowNegativeMessage());

    }

    private Radio createRadio(String value, String label, String currentValue) {
        Radio radio = new Radio();
        radio.setValueAttribute(value);
        radio.setBoxLabel(label);
        radio.setValue(value.equals(currentValue));
        return radio;
    }

    private void decorateField(Field field) {
        decorateField(field, this.getName());
    }

    private void decorateField(Field field, String name) {
        decorateField(field, name, this.getLabel());
    }

    private void decorateField(Field field, String name, String label) {
        field.setName(name);
        field.setFieldLabel(label);
        // if the label is empty (for checkboxes, for instance) the separator is
        // redundant
        if (Strings.isEmpty(this.getLabel()))
            field.setLabelSeparator(Strings.EMPTY);
        field.setToolTip(this.getTooltip());
        field.setReadOnly(this.isReadOnly());
    }

    private RadioGroup createUnitField(final MeasurementModel measurementModel,
                                       boolean readonly) {
        RadioGroup unitField = new RadioGroup();

        unitField.setReadOnly(readonly);

        if (!readonly)
            unitField.addListener(Events.Change, new Listener<FieldEvent>() {
                @Override
                public void handleEvent(FieldEvent be) {
                    RadioGroup radio = (RadioGroup) be.getField();
                    measurementModel.setMeasureUnit(radio.getValue()
                            .getValueAttribute());
                }
            });

        if (MeasurementModel.UNIT_COMPUTING.equals(measurementModel
                .getMeasureClass())) {
            // computing
            unitField.setFieldLabel("Computing unit");

            unitField.add(createRadio(MeasurementModel.COMPUTING_FLOPS,
                    "Flops", measurementModel.getMeasureUnit()));
            unitField.add(createRadio(MeasurementModel.COMPUTING_GHZ, "GHz",
                    measurementModel.getMeasureUnit()));
            unitField.add(createRadio(MeasurementModel.COMPUTING_MHZ, "MHz",
                    measurementModel.getMeasureUnit()));
            unitField.add(createRadio(MeasurementModel.COMPUTING_KHZ, "KHz",
                    measurementModel.getMeasureUnit()));

        } else if (MeasurementModel.UNIT_NETWORKING.equals(measurementModel
                .getMeasureClass())) {
            // networking
            unitField.setFieldLabel("Networking unit");

            unitField.add(createRadio(MeasurementModel.NETWORK_KILOBYTE_S,
                    "Kb/s", measurementModel.getMeasureUnit()));
            unitField.add(createRadio(MeasurementModel.NETWORK_MEGABYTE_S,
                    "Mb/s", measurementModel.getMeasureUnit()));
            unitField.add(createRadio(MeasurementModel.NETWORK_GIGABYTE_S,
                    "Gb/s", measurementModel.getMeasureUnit()));
            unitField.add(createRadio(MeasurementModel.NETWORK_TERABYTES_S,
                    "Tb/s", measurementModel.getMeasureUnit()));

        } else if (MeasurementModel.UNIT_STORAGE.equals(measurementModel
                .getMeasureClass())) {
            // storage
            unitField.setFieldLabel("Storage unit");

            unitField.add(createRadio(MeasurementModel.STORAGE_KILOBYTE, "Kb",
                    measurementModel.getMeasureUnit()));
            unitField.add(createRadio(MeasurementModel.STORAGE_MEGABYTE, "Mb",
                    measurementModel.getMeasureUnit()));
            unitField.add(createRadio(MeasurementModel.STORAGE_GIGABYTE, "Gb",
                    measurementModel.getMeasureUnit()));
            unitField.add(createRadio(MeasurementModel.STORAGE_TERABYTE, "Tb",
                    measurementModel.getMeasureUnit()));

        } else if (MeasurementModel.UNIT_TIME.equals(measurementModel
                .getMeasureClass())) {
            // time
            unitField.setFieldLabel("Networking unit");

            unitField.add(createRadio(MeasurementModel.TIME_MILLISECONDS, "ms",
                    measurementModel.getMeasureUnit()));
            unitField.add(createRadio(MeasurementModel.TIME_SECONDS, "sec",
                    measurementModel.getMeasureUnit()));
            unitField.add(createRadio(MeasurementModel.TIME_MINUTES, "min",
                    measurementModel.getMeasureUnit()));
            unitField.add(createRadio(MeasurementModel.TIME_HOURS, "hours",
                    measurementModel.getMeasureUnit()));

        } else {
            // unknown
            unitField.setFieldLabel("Unit");
            unitField.add(createRadio(MeasurementModel.UNIT_UNKNOWN, "Units",
                    measurementModel.getMeasureUnit()));

        }

        return unitField;
    }

    private native String getCategoryTemplate() /*-{
        return [
            '<tpl for="."><div class="x-combo-list-item">',
            '<h3>{title}</h3>',
            '{description}' ,
            ' </div>', '</tpl>'
        ].join("")

    }-*/;

}
