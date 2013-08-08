/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.windows;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.MessageBoxEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Format;
import com.extjs.gxt.ui.client.util.Params;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.ProgressBar;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.layout.FlowData;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Timer;

public class MessageBoxExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);
    final Listener<MessageBoxEvent> l = new Listener<MessageBoxEvent>() {
      public void handleEvent(MessageBoxEvent ce) {
        Button btn = ce.getButtonClicked();
        Info.display("MessageBox", "The '{0}' button was pressed", btn.getText());
      }
    };

    final ButtonBar buttonBar = new ButtonBar();
    buttonBar.setMinButtonWidth(75);
    
    buttonBar.add(new Button("Confirm", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        MessageBox.confirm("Confirm", "Are you sure you want to do that?", l);
      }
    }));

    buttonBar.add(new Button("Prompt", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        final MessageBox box = MessageBox.prompt("Name", "Please enter your name:");
        box.addCallback(new Listener<MessageBoxEvent>() {
          public void handleEvent(MessageBoxEvent be) {
            Info.display("MessageBox", "You entered '{0}'", new Params(be.getValue()));
          }
        });
      }
    }));

    buttonBar.add(new Button("Multiline Prompt", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        MessageBox box = MessageBox.prompt("Address", "Please enter your address:", true);
        box.addCallback(new Listener<MessageBoxEvent>() {
          public void handleEvent(MessageBoxEvent be) {
            String v = Format.ellipse(be.getValue(), 80);
            Info.display("MessageBox", "You entered '{0}'", new Params(v));
          }
        });
      }
    }));

    buttonBar.add(new Button("Yes/No/Cancel", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        MessageBox box = new MessageBox();
        box.setButtons(MessageBox.YESNOCANCEL);
        box.setIcon(MessageBox.QUESTION);
        box.setTitle("Save Changes?");
        box.addCallback(l);
        box.setMessage("You are closing a tab that has unsaved changes. Would you like to save your changes?");
        box.show();
      }
    }));

    buttonBar.add(new Button("Progress", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        final MessageBox box = MessageBox.progress("Please wait", "Loading items...",
            "Initializing...");
        final ProgressBar bar = box.getProgressBar();
        final Timer t = new Timer() {
          float i;

          @Override
          public void run() {
            bar.updateProgress(i / 100, (int) i + "% Complete");
            i += 5;
            if (i > 105) {
              cancel();
              box.close();
              Info.display("Message", "Items were loaded", "");
            }
          }
        };
        t.scheduleRepeating(500);
      }
    }));

    buttonBar.add(new Button("Wait", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        final MessageBox box = MessageBox.wait("Progress",
            "Saving your data, please wait...", "Saving...");
        Timer t = new Timer() {
          @Override
          public void run() {
            Info.display("Message", "Your fake data was saved", "");
            box.close();
          }
        };
        t.schedule(5000);
      }
    }));

    buttonBar.add(new Button("Alert", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        MessageBox.alert("Alert", "Access Denied", l);
      }
    }));
    add(buttonBar, new FlowData(10));
  }

}
