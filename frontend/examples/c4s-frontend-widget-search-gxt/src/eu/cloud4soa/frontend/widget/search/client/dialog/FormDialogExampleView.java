package eu.cloud4soa.frontend.widget.search.client.dialog;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Label;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FlowData;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class FormDialogExampleView extends LayoutContainer {

	private TextField<String> publickey;
	private TextField<String> privatekey;
	
	@Override
	protected void onRender(Element parent, int pos) {
		super.onRender(parent, pos);

		final Dialog simple = new Dialog();
		simple.setHeading("Start application");
		simple.setButtons(Dialog.OKCANCEL);
		simple.setBodyStyleName("pad-text");
		simple.addText("Do you want to start selected application. Please enter your account keys:");
		simple.getItem(0).getFocusSupport().setIgnore(true);
		simple.setScrollMode(Scroll.AUTO);
		simple.setHideOnButtonClick(true);
		
		simple.getButtonById(Dialog.OK).addListener(Events.Select, new Listener<ButtonEvent>(){

			@Override
			public void handleEvent(ButtonEvent be) {
				MessageBox.prompt("Clicked OK:","public key: " + publickey.getValue() + " ,private key: " + privatekey.getValue());
			}} );
		

		VerticalPanel vp = new VerticalPanel();
		vp.setSpacing(10);
		createForm(vp);
		simple.add(vp);

		ButtonBar buttons = new ButtonBar();

		buttons.add(new Button("Form dialog",
				new SelectionListener<ButtonEvent>() {
					public void componentSelected(ButtonEvent ce) {
						simple.show();
					}
				}));

		add(buttons, new FlowData(10));
	}

	private void createForm(VerticalPanel vp) {
		HorizontalPanel hp1 = new HorizontalPanel();
		hp1.setSpacing(5);

		hp1.add(new Label("Public key:"));
		publickey = new TextField<String>();
		publickey.setFieldLabel("Public key");
		publickey.setAllowBlank(false);
		hp1.add(publickey);

		vp.add(hp1);

		HorizontalPanel hp2 = new HorizontalPanel();
		hp2.setSpacing(5);
		
		hp2.add(new Label("Private key:"));
		privatekey = new TextField<String>();
		privatekey.setFieldLabel("Private key");
		privatekey.setAllowBlank(false);
		hp2.add(privatekey);
		
		vp.add(hp2);

	}
}