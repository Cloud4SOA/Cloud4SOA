package eu.cloud4soa.frontend.widget.search.client.views;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.LabelField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.button.Button;

public class KeysFormDialog2 extends Window {

	public KeysFormDialog2() {
		setHeading("Confirmation");
		setLayout(new RowLayout(Orientation.VERTICAL));
		
		FormPanel frmpnlNewFormpanel = new FormPanel();
		frmpnlNewFormpanel.setHeaderVisible(false);
		frmpnlNewFormpanel.setHeading("New FormPanel");
		frmpnlNewFormpanel.setCollapsible(false);
		frmpnlNewFormpanel.setFrame(true);
		
		LabelField lblfldNewLabelfield = new LabelField("Do you want to stop the application?");
		frmpnlNewFormpanel.add(lblfldNewLabelfield, new FormData("100%"));
		lblfldNewLabelfield.setWidth("");
		
		LabelField lblfldNewLabelfield_1 = new LabelField("Please, provide your keys for PaaS provider");
		frmpnlNewFormpanel.add(lblfldNewLabelfield_1, new FormData("100%"));
		lblfldNewLabelfield_1.setWidth("");
		
		TextField txtfldNewTextfield = new TextField();
		frmpnlNewFormpanel.add(txtfldNewTextfield, new FormData("140%"));
		txtfldNewTextfield.setWidth("");
		txtfldNewTextfield.setFieldLabel("Public Key");
		
		TextField txtfldNewTextfield_1 = new TextField();
		frmpnlNewFormpanel.add(txtfldNewTextfield_1, new FormData("140%"));
		txtfldNewTextfield_1.setFieldLabel("Private Key");
		
		Button btnNewButton = new Button("Ok");
		frmpnlNewFormpanel.addButton(btnNewButton);
		
		Button btnNewButton_1 = new Button("Cancel");
		frmpnlNewFormpanel.addButton(btnNewButton_1);
		
		add(frmpnlNewFormpanel);
	}

}
