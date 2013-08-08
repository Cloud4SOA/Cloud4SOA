package eu.cloud4soa.frontend.widget.search.client.views;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormButtonBinding;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.CenterLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;

public class RegistrationForm extends LayoutContainer implements RegistrationView{
	private TextField<String> tfUsername;
	private TextField<String> tfPassword1;
	private TextField<String> tfPassword2;
	private TextField<String> tfFirstname;
	private TextField<String> tfSurname;
	private TextField<String> tfGeekcode;

	public RegistrationForm() {
		setWidth(350);
		createForm();
	}

	private void createForm() {
		setLayout(new CenterLayout());
		
		FormPanel form = new FormPanel();
		form.setFrame(true);
		form.setHeading("Registration Form");
		add (form);

		form.add(new LabelField("Please, enter the following account registration information"), new FormData("100%"));

		tfUsername = new TextField<String>();
		tfUsername.setFieldLabel("Username");
		tfUsername.setAllowBlank(false);
		form.add(tfUsername, new FormData("95%"));

		tfPassword1 = new TextField<String>();
		tfPassword1.setFieldLabel("Password");
		tfPassword1.setAllowBlank(false);
		tfPassword1.setPassword(true);		
		tfPassword1.getFocusSupport().setPreviousId(form.getButtonBar().getId());
		form.add(tfPassword1, new FormData("95%"));
		
		tfPassword2 = new TextField<String>();
		tfPassword2.setFieldLabel("Confirm password");
		tfPassword2.setAllowBlank(false);
		tfPassword2.setPassword(true);
		tfPassword2.getFocusSupport().setPreviousId(form.getButtonBar().getId());
		form.add(tfPassword2, new FormData("95%"));

		
		
		tfFirstname = new TextField<String>();
		tfFirstname.setFieldLabel("First name");
		tfFirstname.setAllowBlank(false);
		form.add(tfFirstname, new FormData("95%"));
				
		tfSurname = new TextField<String>();
		tfSurname.setFieldLabel("Surname");
		tfSurname.setAllowBlank(false);
		form.add(tfSurname, new FormData("95%"));
		
		tfGeekcode = new TextField<String>();
		tfGeekcode.setFieldLabel("Geek code");
		tfGeekcode.setAllowBlank(true);
		form.add(tfGeekcode, new FormData("95%"));
		
		Button btOk = new Button("OK");
		btOk.addSelectionListener(new SelectionListener<ButtonEvent>(){
			@Override
			public void componentSelected(ButtonEvent ce) {
				//Confirm both passwords match
				if (!tfPassword1.getValue().equals(tfPassword2.getValue())){
					showDialog(null, "Passwords don not match, please check them");
					tfPassword1.setValue("");
					tfPassword2.setValue("");
					return;
				}
				
				//TODO Check if username already exists
				
				//TODO Request registration activity to create a new user account
				
			}});
		
		form.addButton(btOk);
		
		Button btCancel = new Button("Cancel");
		btCancel.addSelectionListener(new SelectionListener<ButtonEvent>(){
			@Override
			public void componentSelected(ButtonEvent ce) {
				//TODO Go to welcome place
			}});
		form.addButton(btCancel);

		form.setButtonAlign(HorizontalAlignment.CENTER);

		FormButtonBinding binding = new FormButtonBinding(form);
		binding.addButton(btOk);

	}

	@Override
	public String getUserAccountProperty(UserAccountProperty property) {
		String value = null;
		switch (property){
		case USERNAME:
			value = tfUsername.getValue();
			break;
		case PASSWORD:
			value = tfPassword1.getValue();
			break;
		case FIRSTNAME:
			value = tfFirstname.getValue();
			break;
		case SURNAME:
			value = tfSurname.getValue();
			break;
		case GEEKCODE:
			value = tfGeekcode.getValue();
			break;
		}
		return value;
	}

	public static void showDialog(String heading, String message) {
		final Dialog dialog = new Dialog();
		if (heading == null) 
			heading = "Error";
		dialog.setHeading(heading);
		dialog.setButtons(Dialog.CLOSE);
		dialog.setBodyStyleName("pad-text");
		dialog.addText(message);
		dialog.getItem(0).getFocusSupport().setIgnore(true);
		dialog.setScrollMode(Scroll.AUTO);
		dialog.setHideOnButtonClick(true);
		dialog.show();
	}
}
