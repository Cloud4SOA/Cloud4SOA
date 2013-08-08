/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.misc;

import com.extjs.gxt.ui.client.core.Template;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Element;

public class ToolTipsExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int pos) {
    super.onRender(parent, pos);
    HorizontalPanel hp = new HorizontalPanel();
    hp.setSpacing(10);

    Button btn = new Button("Basic");
    btn.setToolTip(new ToolTipConfig("Information", "Prints the current document"));
    hp.add(btn);

    btn = new Button("Closable");
    ToolTipConfig config = new ToolTipConfig();
    config.setTitle("Information");
    config.setText("Prints the current document");
    config.setCloseable(true);
    btn.setToolTip(config);
    hp.add(btn);

    btn = new Button("Mouse Tracking");
    config = new ToolTipConfig();
    config.setTitle("Information");
    config.setText("Prints the current document");
    config.setTrackMouse(true);
    btn.setToolTip(config);
    hp.add(btn);

    btn = new Button("Anchor");
    config = new ToolTipConfig();
    config.setTitle("Information");
    config.setText("Prints the current document");
    config.setMouseOffset(new int[] {0, 0});
    config.setAnchor("left");
    btn.setToolTip(config);
    hp.add(btn);

    btn = new Button("Custom");
    config = new ToolTipConfig();
    config.setText("Prints the current document");
    config.setTitle("Template Tip");
    config.setMouseOffset(new int[] {0, 0});
    config.setAnchor("left");
    config.setTemplate(new Template(getTemplate(GWT.getHostPageBaseURL())));
    config.setCloseable(true);
    config.setMaxWidth(415);
    btn.setToolTip(config);
    hp.add(btn);

    add(hp);
  }

  private native String getTemplate(String base) /*-{
    var html = [
    '<div><ul style="list-style: disc; margin: 0px 0px 5px 15px">',
    '<li>5 bedrooms</li>',
    '<li>2 baths</li>',
    '<li>Large backyard</li>',
    '<li>Close to metro</li>',
    '</ul>',
    '<img width="400" height="300" src="' + base + 'samples/images/examples/house.jpg" style="border: 1px solid #ddd">',
    '</div>'
    ];
    return html.join("");
  }-*/;

}
