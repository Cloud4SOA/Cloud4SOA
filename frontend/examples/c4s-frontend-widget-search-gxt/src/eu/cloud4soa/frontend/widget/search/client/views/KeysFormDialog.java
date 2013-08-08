package eu.cloud4soa.frontend.widget.search.client.views;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormButtonBinding;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;

public class KeysFormDialog extends Window {

	public KeysFormDialog() {
		setWidth(350);
		createForm();
	}

	private void createForm() {
		FormPanel form = new FormPanel();
		this.setHeading("Confirmation");
		form.setFrame(true);
		form.setHeaderVisible(false);
		
		setLayout(new RowLayout(Orientation.VERTICAL));

		LabelField message1 = new LabelField(
				"Do you want to stop the application?");
		LabelField message2 = new LabelField(
				"Please, provide your keys for PaaS provider");
		form.add(message1, new FormData("100%"));
		form.add(message2, new FormData("100%"));

		TextField<String> publicKey = new TextField<String>();
		publicKey.setFieldLabel("Public Key");
		publicKey.setAllowBlank(false);
		publicKey.getFocusSupport().setPreviousId(form.getButtonBar().getId());
		form.add(publicKey, new FormData("100%"));

		TextField<String> privateKey = new TextField<String>();
		privateKey.setFieldLabel("Private Key");
		privateKey.setAllowBlank(false);
		form.add(privateKey, new FormData("100%"));

		Button ok = new Button("OK");
		form.addButton(ok);
		form.addButton(new Button("Cancel"));

		form.setButtonAlign(HorizontalAlignment.CENTER);

		FormButtonBinding binding = new FormButtonBinding(form);
		binding.addButton(ok);

		add(form);
	}

}
