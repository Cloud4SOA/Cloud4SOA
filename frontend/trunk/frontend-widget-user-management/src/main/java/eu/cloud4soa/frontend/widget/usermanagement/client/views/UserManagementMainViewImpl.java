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

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.DisplayableKeyValue;

import java.util.List;

public class UserManagementMainViewImpl extends Composite implements UserManagementMainView {
    interface Binder extends UiBinder<Widget, UserManagementMainViewImpl> {
    }

    private static final Binder binder = GWT.create(Binder.class);

    public UserManagementMainViewImpl() {
        initWidget(binder.createAndBindUi(this));
    }


    @UiField
    ListBox interactionStyleList;

    @UiField
    SimplePanel paaSOfferPanel;

    @UiField
    SimplePanel applicationProfilePanel;

    @UiField
    TabLayoutPanel tabLayout;


    private Presenter presenter;

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }


    @UiHandler("interactionStyleList")
    public void handleChange(ChangeEvent event) {
        ListBox listBox = (ListBox) event.getSource();
        if (presenter != null)
            presenter.onInteractionChange(getSelectedListBoxValue(listBox));
    }

    private String getSelectedListBoxValue(ListBox listBox) {
        return listBox.getValue(listBox.getSelectedIndex());
    }

    private void setSelectedListBoxValue(ListBox listBox, String value) {
        for (int i = 0; i < listBox.getItemCount(); i++)
            listBox.setItemSelected(i, listBox.getValue(i).equals(value));

    }

    @Override
    public <E extends DisplayableKeyValue> void setInteractionStyleValues(List<E> interactionStyleValues) {
        fillListBox(interactionStyleList, interactionStyleValues);
    }

    private <E extends DisplayableKeyValue> void fillListBox(ListBox listBox, List<E> values) {
        listBox.clear();
        // add the empty value
        listBox.addItem("", "");
        for (DisplayableKeyValue v : values)
            listBox.addItem(v.getDisplayName(), v.getKey());
    }

    @Override
    public AcceptsOneWidget getApplicationProfilePanel() {
        return applicationProfilePanel;
    }

//    @Override
//    public AcceptsOneWidget getDeployedApplicationPanel() {
//        return deployedApplicationsPanel;
//    }

    @Override
    public AcceptsOneWidget getPaaSOfferPanel() {
        return paaSOfferPanel;
    }

    @Override
    public void setSelectedInteractionStyle(String key) {
        setSelectedListBoxValue(interactionStyleList, key);
    }

    @Override
    public void selectPaaSOfferPanel() {
        tabLayout.selectTab(paaSOfferPanel);
    }

//    @Override
//    public void selectDeployedApplicationPanel() {
//        tabLayout.selectTab(deployedApplicationsPanel);
//    }
}
