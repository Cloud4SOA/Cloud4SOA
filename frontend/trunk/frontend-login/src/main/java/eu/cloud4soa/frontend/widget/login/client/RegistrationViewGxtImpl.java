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

package eu.cloud4soa.frontend.widget.login.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormButtonBinding;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.user.client.ui.HasValue;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.user.UserModel;
import eu.cloud4soa.frontend.commons.client.dialog.DialogHelper;
import eu.cloud4soa.frontend.commons.client.gxt.DisplayableKeyValueModelData;
import eu.cloud4soa.frontend.commons.client.gxt.GxtValue;

public class RegistrationViewGxtImpl extends LayoutContainer implements
		RegistrationView {
	private TextField<String> tfUsername;
	private TextField<String> tfPassword1;
	private TextField<String> tfPassword2;
	private TextField<String> tfFirstname;
	private TextField<String> tfSurname;
	private TextField<String> tfGeekcode;
	private TextField<String> tfEmail;
	private ComboBox<DisplayableKeyValueModelData> cbAccountType;
	private DateField dfBirthday;
	private Presenter presenter;

	public RegistrationViewGxtImpl() {
		setWidth(350);
		createForm();
	}

	private void createForm() {
		setLayout(new CenterLayout());

		FormPanel form = new FormPanel();
		form.setFrame(true);
		form.setHeading("Registration Form");
		add(form);

		form.add(
				new LabelField(
						"Please, enter the following account registration information"),
				new FormData("100%"));

		tfUsername = new TextField<String>();
		tfUsername.setFieldLabel("Username");
		tfUsername.setAllowBlank(false);
		form.add(tfUsername, new FormData("95%"));

		tfPassword1 = new TextField<String>();
		tfPassword1.setFieldLabel("Password");
		tfPassword1.setAllowBlank(false);
		tfPassword1.setPassword(true);
		tfPassword1.getFocusSupport()
				.setPreviousId(form.getButtonBar().getId());
		form.add(tfPassword1, new FormData("95%"));

		tfPassword2 = new TextField<String>();
		tfPassword2.setFieldLabel("Confirm password");
		tfPassword2.setAllowBlank(false);
		tfPassword2.setPassword(true);
		tfPassword2.getFocusSupport()
				.setPreviousId(form.getButtonBar().getId());
		form.add(tfPassword2, new FormData("95%"));

		tfFirstname = new TextField<String>();
		tfFirstname.setFieldLabel("First name");
		tfFirstname.setAllowBlank(false);
		form.add(tfFirstname, new FormData("95%"));

		tfSurname = new TextField<String>();
		tfSurname.setFieldLabel("Surname");
		tfSurname.setAllowBlank(false);
		form.add(tfSurname, new FormData("95%"));

		// dfBirthday = new DateField();
		// dfBirthday.setFieldLabel("Birthday");
		// tfSurname.setAllowBlank(true);
		// form.add(dfBirthday, new FormData("95%"));
		//
		// tfGeekcode = new TextField<String>();
		// tfGeekcode.setFieldLabel("Geek code");
		// tfGeekcode.setAllowBlank(true);
		// form.add(tfGeekcode, new FormData("95%"));

		tfEmail = new TextField<String>();
		tfEmail.setFieldLabel("Email");
		tfEmail.setAllowBlank(false);
		form.add(tfEmail, new FormData("95%"));

		ListStore<DisplayableKeyValueModelData> accountTypeStore = new ListStore<DisplayableKeyValueModelData>();
		accountTypeStore.add(getUserTypes());

		cbAccountType = new ComboBox<DisplayableKeyValueModelData>();
		cbAccountType.setFieldLabel("Account Type");
		cbAccountType.setAllowBlank(false);
		cbAccountType.setForceSelection(true);
		cbAccountType.setStore(accountTypeStore);
		cbAccountType.setDisplayField("displayName");

		form.add(cbAccountType, new FormData("95%"));

		Button btOk = new Button("OK");
		btOk.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				// Confirm both passwords match
				if (!tfPassword1.getValue().equals(tfPassword2.getValue())) {
					DialogHelper
							.showErrorDialog("Passwords do not match, please check them");
					tfPassword1.setValue("");
					tfPassword2.setValue("");
					return;
				}

				// Request registration activity to create a new user account
				presenter.onRegister();
			}
		});

		form.addButton(btOk);

		Button btCancel = new Button("Cancel");
		btCancel.addSelectionListener(new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				// Go to welcome place
				presenter.onCancelRegisterNewUser();
			}
		});
		form.addButton(btCancel);

		form.setButtonAlign(HorizontalAlignment.CENTER);

		FormButtonBinding binding = new FormButtonBinding(form);
		binding.addButton(btOk);

	}

	private List<DisplayableKeyValueModelData> getUserTypes() {

		List<DisplayableKeyValueModelData> types = new ArrayList<DisplayableKeyValueModelData>();

        types.add(new DisplayableKeyValueModelData(UserModel.USER_TYPE_DEVELOPER, "Developer"));
        // paas provider user registration is temporary disabled see #948
//        types.add(new DisplayableKeyValueModelData(UserModel.USER_TYPE_PROVIDER, "PaaS Provider"));

		return types;
	}

	@Override
	public HasValue<String> getUserAccountProperty(UserAccountProperty property) {
		TextField<String> value = null;
		switch (property) {
		case USERNAME:
			value = tfUsername;
			break;
		case PASSWORD:
			value = tfPassword1;
			break;
		case FIRSTNAME:
			value = tfFirstname;
			break;
		case SURNAME:
			value = tfSurname;
			break;
		case GEEKCODE:
			value = tfGeekcode;
			break;
		case EMAIL:
			value = tfEmail;
			break;
		}
		return new GxtValue<String>(value);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public HasValue<Date> getUserAccountBirthday() {
		return new GxtValue<Date>(dfBirthday);
	}

	@Override
	public String getAccountType() {
		return cbAccountType.getSelection().get(0).getKey();
	}

}
