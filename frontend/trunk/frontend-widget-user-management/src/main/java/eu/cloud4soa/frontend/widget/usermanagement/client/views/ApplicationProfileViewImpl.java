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

package eu.cloud4soa.frontend.widget.usermanagement.client.views;

import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.DisplayableKeyValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Implementation of the Application Profile view.
 *
 * @author Stefano Travelli (Cyntelix)
 * @since 03/10/11 17.09
 */
public class ApplicationProfileViewImpl extends Composite //implements ApplicationProfileView
{
//    interface ApplicationProfileViewImplUiBinder extends UiBinder<Widget, ApplicationProfileViewImpl>
//    {
//    }
//
//    private static ApplicationProfileViewImplUiBinder binder = GWT.create(ApplicationProfileViewImplUiBinder.class);
//
//
//    @UiField
//    Button saveButton;
//
//    @UiField
//    Button searchButton;
//
//    @UiField
//    Button newProfileButton;
//
//    @UiField
//    ListBox applicationInstanceList;
//
//    @UiField
//    Button deleteButton;
//
//    @UiField
//    Button restoreButton;
//
//    @UiField
//    TextBox acronymTextBox;
//
//    @UiField
//    TextBox descriptionTextBox;
//
////    @UiField
////    ListBox archetypeList;
//
////    @UiField
////    ListBox hardwareRequirementList;
////
////    @UiField
////    ListBox softwareRequirementList;
//
//    @UiField
//    ListBox programmingLanguageList;
//
//
//    private Presenter presenter;
//
//    @Override
//    public void setPresenter(Presenter presenter)
//    {
//        this.presenter = presenter;
//    }
//
//    public ApplicationProfileViewImpl()
//    {
//        initWidget(binder.createAndBindUi(this));
//    }
//
//
//    private <E extends DisplayableKeyValue> void fillSimpleComboBox(SimpleComboBox<DisplayableKeyValue> listBox, List<E> values)
//    {
//        listBox.clear();
//        for (DisplayableKeyValue v : values)
//            listBox.add(v);
//    }
//
//
//    private <E extends DisplayableKeyValue> void fillListBox(ListBox listBox, List<E> values)
//    {
//        listBox.clear();
//        // add the empty value
//        listBox.addItem("", "");
//        for (DisplayableKeyValue v : values)
//            listBox.addItem(v.getDisplayName(), v.getKey());
//    }
//
////    @Override
////    public <E extends DisplayableKeyValue> void setApplicationInstanceValues(List<E> applicationInstanceValues)
////    {
////        fillListBox(applicationInstanceList, applicationInstanceValues);
////    }
////
////    @Override
////    public <E extends DisplayableKeyValue> void setArchetypeValues(List<E> archetypeValues)
////    {
////        //fillListBox(archetypeList, archetypeValues);
////    }
////
////
////    @Override
////    public <E extends DisplayableKeyValue> void setHardwareRequirementValues(List<E> hardwareRequirementValues)
////    {
////        //fillListBox(hardwareRequirementList, hardwareRequirementValues);
////    }
////
////    @Override
////    public <E extends DisplayableKeyValue> void setSoftwareRequirementValues(List<E> softwareRequirementValues)
////    {
////        //fillListBox(softwareRequirementList, softwareRequirementValues);
////    }
////
////    @Override
////    public <E extends DisplayableKeyValue> void setProgrammingLanguageValues(List<E> programmingLanguageValues)
////    {
////        fillListBox(programmingLanguageList, programmingLanguageValues);
////    }
//
//    @Override
//    public void refreshApplicationProfileList() {
//        // nothing to do in this view implementation.
//    }
//
//    @Override
//    public HasValue<String> getAcronym()
//    {
//        return acronymTextBox;
//    }
//
//    @Override
//    public HasValue<String> getDescription()
//    {
//        return descriptionTextBox;
//    }
//
//    @Override
//    public String getSelectedApplicationInstance()
//    {
//        return getSelectedListBoxValue(applicationInstanceList);
//    }
//
//    @Override
//    public void setSelectedApplicationInstance(String key)
//    {
//        setSelectedListBoxValue(applicationInstanceList, key);
//    }
//
//
//    @Override
//    public String getSelectedArchetype()
//    {
//        return null; //getSelectedListBoxValue(archetypeList);
//    }
//
//    @Override
//    public void setSelectedArchetype(String key)
//    {
//        //setSelectedListBoxValue(archetypeList, key);
//    }
//
//    @Override
//    public List<String> getSelectedHardwareRequirements()
//    {
//        return null; //getSelectedListBoxValues(hardwareRequirementList);
//    }
//
//    @Override
//    public void setSelectedHardwareRequirements(Collection<String> keys)
//    {
//        //setSelectedListBoxValues(hardwareRequirementList, keys);
//    }
//
//    @Override
//    public List<String> getSelectedSoftwareRequirements()
//    {
//        return null; //getSelectedListBoxValues(softwareRequirementList);
//    }
//
//    @Override
//    public void setSelectedSoftwareRequirements(Collection<String> keys)
//    {
//        //setSelectedListBoxValues(softwareRequirementList, keys);
//    }
//
//    @Override
//    public String getSelectedProgrammingLanguage()
//    {
//        return getSelectedListBoxValue(programmingLanguageList);
//    }
//
//    @Override
//    public void setSelectedProgrammingLanguage(String key)
//    {
//        setSelectedListBoxValue(programmingLanguageList, key);
//    }
//
//    @UiHandler("newProfileButton")
//    void handleNewProfileButtonClick(ClickEvent event)
//    {
//        if (presenter != null)
//            presenter.onNewProfileButtonClick();
//    }
//
//    @UiHandler("searchButton")
//    void handleSearchButtonClick(ClickEvent event)
//    {
//        if (presenter != null)
//            presenter.onSearchButtonClick();
//    }
//
//    @UiHandler("deleteButton")
//    void handleDeleteButtonClick(ClickEvent event)
//    {
//        if (presenter != null)
//            presenter.onDeleteButtonClick();
//    }
//
//    @UiHandler("restoreButton")
//    void handleRestoreButtonClick(ClickEvent event)
//    {
//        if (presenter != null)
//            presenter.onCancelButtonClick();
//    }
//
//    @UiHandler("saveButton")
//    void handleSaveButtonClick(ClickEvent event)
//    {
//        if (presenter != null)
//            presenter.onSaveButtonClick();
//    }
//
//    @UiHandler("applicationInstanceList")
//    void handleApplicationProfileChange(ChangeEvent event)
//    {
//        ListBox listBox = (ListBox) event.getSource();
//        if (presenter != null)
//            presenter.onSelectedInstanceChange(getSelectedListBoxValue(listBox));
//    }
//
////    @UiHandler("archetypeList")
////    void handleArchetypeChange(ChangeEvent event)
////    {
////        ListBox listBox = (ListBox) event.getSource();
////        if (presenter != null)
////            presenter.onArchetypeChange(getSelectedListBoxValue(listBox));
////    }
//
////    @UiHandler("hardwareRequirementList")
////    void handleHardwareRequirementsChange(ChangeEvent event)
////    {
////        ListBox listBox = (ListBox) event.getSource();
////        if (presenter != null)
////            presenter.onHardwareRequirementsChange(getSelectedListBoxValues(listBox));
////    }
////
////    @UiHandler("softwareRequirementList")
////    void handleSoftwareRequirementsChange(ChangeEvent event)
////    {
////        ListBox listBox = (ListBox) event.getSource();
////        if (presenter != null)
////            presenter.onSoftwareRequirementsChange(getSelectedListBoxValues(listBox));
////    }
//
//
//    @UiHandler("programmingLanguageList")
//    void handleProgrammingLanguageChange(ChangeEvent event)
//    {
//        ListBox listBox = (ListBox) event.getSource();
//        if (presenter != null)
//            presenter.onProgrammingLanguageChange(getSelectedListBoxValue(listBox));
//    }
//
//    private List<String> getSelectedListBoxValues(ListBox listBox)
//    {
//        List<String> selectedKeys = new ArrayList<String>();
//
//        for (int i = 0; i < listBox.getItemCount(); i++)
//            if (listBox.isItemSelected(i))
//                selectedKeys.add(listBox.getItemText(i));
//
//        return selectedKeys;
//    }
//
//    private void setSelectedListBoxValues(ListBox listBox, Collection<String> keys)
//    {
//        for (int i = 0; i < listBox.getItemCount(); i++)
//            listBox.setItemSelected(i, keys.contains(listBox.getItemText(i)));
//    }
//
//    private String getSelectedListBoxValue(ListBox listBox)
//    {
//        return listBox.getValue(listBox.getSelectedIndex());
//    }
//
//    private void setSelectedListBoxValue(ListBox listBox, String value)
//    {
//        for (int i = 0; i < listBox.getItemCount(); i++)
//            listBox.setItemSelected(i, listBox.getValue(i).equals(value));
//
//    }
//

}