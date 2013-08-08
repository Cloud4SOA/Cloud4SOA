/* 
 * Ext GWT 2.2.5 - Ext for GWT 
 * Copyright(c) 2007-2010, Ext JS, LLC. 
 * licensing@extjs.com 
 *  
 * http://extjs.com/license 
 */  

package eu.cloud4soa.frontend.widget.search.client.dialog;  
    
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;  
import com.extjs.gxt.ui.client.core.El;  
import com.extjs.gxt.ui.client.core.XDOM;  
import com.extjs.gxt.ui.client.event.ComponentEvent;  
import com.extjs.gxt.ui.client.event.Events;  
import com.extjs.gxt.ui.client.event.Listener;  
import com.extjs.gxt.ui.client.widget.Component;  
import com.extjs.gxt.ui.client.widget.ComponentPlugin;  
import com.extjs.gxt.ui.client.widget.LayoutContainer;  
import com.extjs.gxt.ui.client.widget.Slider;  
import com.extjs.gxt.ui.client.widget.VerticalPanel;  
import com.extjs.gxt.ui.client.widget.button.Button;  
import com.extjs.gxt.ui.client.widget.form.CheckBox;  
import com.extjs.gxt.ui.client.widget.form.CheckBoxGroup;  
import com.extjs.gxt.ui.client.widget.form.DateField;  
import com.extjs.gxt.ui.client.widget.form.FormButtonBinding;  
import com.extjs.gxt.ui.client.widget.form.FormPanel;  
import com.extjs.gxt.ui.client.widget.form.Radio;  
import com.extjs.gxt.ui.client.widget.form.RadioGroup;  
import com.extjs.gxt.ui.client.widget.form.SliderField;  
import com.extjs.gxt.ui.client.widget.form.TextArea;  
import com.extjs.gxt.ui.client.widget.form.TextField;  
import com.extjs.gxt.ui.client.widget.form.TimeField;  
import com.extjs.gxt.ui.client.widget.layout.FormData;  
import com.google.gwt.user.client.Element;  
  
public class SimpleForm extends LayoutContainer {  
    
  private VerticalPanel vp;  
  private FormData formData;  
  
  @Override  
  protected void onRender(Element parent, int index) {  
    super.onRender(parent, index);  
    formData = new FormData("-20");  
    vp = new VerticalPanel();  
    vp.setSpacing(10);  
    createForm1();  
    add(vp);  
  }  
  
  private void createForm1() {  
    FormPanel simple = new FormPanel();  
    simple.setHeading("Custom Form");  
    simple.setFrame(true);  
    simple.setWidth(350);  
  
    ComponentPlugin plugin = new ComponentPlugin() {  
      public void init(Component component) {  
        component.addListener(Events.Render, new Listener<ComponentEvent>() {  
          public void handleEvent(ComponentEvent be) {  
            El elem = be.getComponent().el().findParent(".x-form-element", 3);  
            // should style in external CSS  rather than directly  
            elem.appendChild(XDOM.create("<div style='color: #615f5f;padding: 1 0 2 0px;'>" + be.getComponent().getData("text") + "</div>"));  
          }  
        });  
      }  
    };  
  
    TextField<String> firstName = new TextField<String>();  
    firstName.setFieldLabel("Name");  
    firstName.setAllowBlank(false);  
    firstName.addPlugin(plugin);  
    firstName.setData("text", "Enter your fist name");  
    simple.add(firstName, formData);  
  
    TextField<String> email = new TextField<String>();  
    email.setFieldLabel("Email");  
    email.setAllowBlank(false);  
    email.addPlugin(plugin);  
    email.setData("text", "Enter you email (required)");  
    simple.add(email, formData);  
    
    /*
    TextField passwordField = new TextField();
    passwordField.setPassword(true);
    simple.add(passwordField, formData);
    */
    
    Button b = new Button("Submit");  
    simple.addButton(b);  
    simple.addButton(new Button("Cancel"));  
  
    simple.setButtonAlign(HorizontalAlignment.CENTER);  
  
    FormButtonBinding binding = new FormButtonBinding(simple);  
    binding.addButton(b);  
  
    vp.add(simple);  
  }     
}