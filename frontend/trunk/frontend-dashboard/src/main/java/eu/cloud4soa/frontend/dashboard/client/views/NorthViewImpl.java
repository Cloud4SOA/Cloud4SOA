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

package eu.cloud4soa.frontend.dashboard.client.views;

import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Anchor;
import eu.cloud4soa.frontend.commons.client.Strings;
import eu.cloud4soa.frontend.commons.client.ui.ButtonImage;

/**
 * The header view implementation.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class NorthViewImpl extends Composite implements NorthView {

    private static Binder binder = GWT.create(Binder.class);
    @UiField
    ButtonImage searchImage;
    @UiField
    ButtonImage browseImage;
    @UiField
    ButtonImage applicationImage;
    @UiField
    ButtonImage offerImage;
    @UiField
    ButtonImage monitoringImage;
    @UiField
    ButtonImage deployImage;
    @UiField
    ButtonImage userProfileImage;
    @UiField
    ButtonImage registerImage;
    @UiField
    ButtonImage loginImage;
    @UiField
    ButtonImage logoutImage;
    @UiField
    ButtonImage adminImage;
    @UiField
    Anchor userAnchor;
    @UiField
    ButtonImage migrateImage;
    @UiField
    ContentPanel searchPanel;
    @UiField
    ContentPanel browsePanel;
    @UiField
    ContentPanel applicationPanel;
    @UiField
    ContentPanel offerPanel;
    @UiField
    ContentPanel monitoringPanel;
    @UiField
    ContentPanel deployPanel;
    @UiField
    ContentPanel migratePanel;
    @UiField
    ContentPanel userProfilePanel;
    @UiField
    ContentPanel adminPanel;
    @UiField
    ContentPanel registerPanel;
    @UiField
    ContentPanel loginPanel;
    @UiField
    ContentPanel logoutPanel;
    private Presenter presenter;

    public NorthViewImpl() {
        initComponent(binder.createAndBindUi(this));
    }

    @UiHandler("userAnchor")
    public void handleUserAnchorClick(ClickEvent event) {
        this.presenter.onUserProfileClick();
    }

    @UiHandler("migrateImage")
    public void handleMigrateClick(ClickEvent event) {
        if (!migrateImage.isSelected())
            this.presenter.onMigrateNavigation();
    }

    @UiHandler("applicationImage")
    public void handleApplicationClick(ClickEvent event) {
        if (!applicationImage.isSelected())
            this.presenter.onApplicationNavigation();
    }

    @UiHandler("deployImage")
    public void handleDeployClick(ClickEvent event) {
        if (!deployImage.isSelected())
            this.presenter.onDeployNavigation();
    }

    @UiHandler("loginImage")
    public void handleLoginClick(ClickEvent event) {
        if (!loginImage.isSelected())
            this.presenter.onLoginClick();
    }

    @UiHandler("logoutImage")
    public void handleLogoutClick(ClickEvent event) {
        if (!logoutImage.isSelected())
            this.presenter.onLogoutClick();
    }

    @UiHandler("monitoringImage")
    public void handleMonitorClick(ClickEvent event) {
        if (!monitoringImage.isSelected())
            this.presenter.onMonitorNavigation();
    }

    @UiHandler("offerImage")
    public void handleOfferClick(ClickEvent event) {
        if (!offerImage.isSelected())
            this.presenter.onOfferNavigation();
    }

    @UiHandler("registerImage")
    public void handleRegisterClick(ClickEvent event) {
        if (!registerImage.isSelected())
            this.presenter.onRegisterClick();
    }

    @UiHandler("searchImage")
    public void handleSearchClick(ClickEvent event) {
        if (!searchImage.isSelected())
            this.presenter.onSearchNavigation();
    }

    @UiHandler("browseImage")
    public void handleBrowseClick(ClickEvent event) {
        if (!browseImage.isSelected())
            this.presenter.onBrowseNavigation();
    }

    @UiHandler("userProfileImage")
    public void handleProfileClick(ClickEvent event) {
        if (!userProfileImage.isSelected())
            this.presenter.onUserProfileClick();
    }

    @UiHandler("adminImage")
    public void handleAdminClick(ClickEvent event) {
        if (!adminImage.isSelected())
            this.presenter.onAdminNavigation();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setApplicationVisible(boolean visible) {
        applicationPanel.setVisible(visible);
    }

    @Override
    public void setSearchVisible(boolean visible) {
        searchPanel.setVisible(visible);
    }

    @Override
    public void setBrowseVisible(boolean visible) {
        browsePanel.setVisible(visible);
    }

    @Override
    public void setOfferVisible(boolean visible) {
        offerPanel.setVisible(visible);
    }

    @Override
    public void setMonitoringVisible(boolean visible) {
        monitoringPanel.setVisible(visible);
    }

    @Override
    public void setDeployVisible(boolean visible) {
        deployPanel.setVisible(visible);
    }

    @Override
    public void setMigrateVisible(boolean visible) {
        migratePanel.setVisible(visible);
    }

    @Override
    public void setProfileVisible(boolean visible) {
        userProfilePanel.setVisible(visible);
    }

    @Override
    public void setRegisterVisible(boolean visible) {
        registerPanel.setVisible(visible);
    }

    @Override
    public void setLoginVisible(boolean visible) {
        loginPanel.setVisible(visible);
    }

    @Override
    public void setLogoutVisible(boolean visible) {
        logoutPanel.setVisible(visible);
    }

    @Override
    public void setApplicationSelected(boolean selected) {
        applicationImage.setSelected(selected);
    }

    @Override
    public void setSearchSelected(boolean selected) {
        searchImage.setSelected(selected);
    }

    @Override
    public void setBrowseSelected(boolean selected) {
        browseImage.setSelected(selected);
    }

    @Override
    public void setOfferSelected(boolean selected) {
        offerImage.setSelected(selected);
    }

    @Override
    public void setMonitoringSelected(boolean selected) {
        monitoringImage.setSelected(selected);
    }

    @Override
    public void setDeploySelected(boolean selected) {
        deployImage.setSelected(selected);
    }

    @Override
    public void setMigrateSelected(boolean selected) {
        migrateImage.setSelected(selected);
    }

    @Override
    public void setProfileSelected(boolean selected) {
        userProfileImage.setSelected(selected);
    }

    @Override
    public void setRegisterSelected(boolean selected) {
        registerImage.setSelected(selected);
    }

    @Override
    public void setLoginSelected(boolean selected) {
        loginImage.setSelected(selected);
    }

    @Override
    public void setLogoutSelected(boolean selected) {
        logoutImage.setSelected(selected);
    }

    @Override
    public void setAdminSelected(boolean selected) {
        adminImage.setSelected(selected);
    }

    @Override
    public void setAdminVisible(boolean visible) {
        adminPanel.setVisible(visible);
    }

    @Override
    public void setUsername(String username) {
        if (Strings.isEmpty(username))
            userAnchor.setText(Strings.EMPTY);
        else
            userAnchor.setText("Welcome, " + username);
    }

    @UiTemplate("NorthViewImpl.ui.xml")
    interface Binder extends UiBinder<Component, NorthViewImpl> {
    }
}
