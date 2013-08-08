/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.misc;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.ui.client.Style.Direction;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.fx.FxConfig;
import com.extjs.gxt.ui.client.util.Rectangle;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.layout.MarginData;
import com.google.gwt.user.client.Element;

public class FxExample extends LayoutContainer {

  private ContentPanel cp;

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    ButtonBar buttonBar = new ButtonBar();
    buttonBar.add(new Button("Slide In / Out", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        if (cp.isVisible()) {
          cp.el().slideOut(Direction.UP, FxConfig.NONE);
        } else {
          cp.el().slideIn(Direction.DOWN, FxConfig.NONE);
        }
      }
    }));
    buttonBar.add(new Button("Fade In / Out", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        cp.el().fadeToggle(FxConfig.NONE);
      }
    }));
    buttonBar.add(new Button("Move", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        Rectangle rect = cp.el().getBounds();
        cp.el().setXY(rect.x + 50, rect.y + 50, FxConfig.NONE);
      }
    }));

    buttonBar.add(new Button("Blink", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        cp.el().blink(FxConfig.NONE);
      }
    }));

    buttonBar.add(new Button("Reset", new SelectionListener<ButtonEvent>() {
      public void componentSelected(ButtonEvent ce) {
        cp.setPosition(10, 10);
      }
    }));

    cp = new ContentPanel();
    cp.setCollapsible(true);
    cp.setHeading("FX Demo");
    cp.setIcon(Resources.ICONS.text());
    cp.setBodyStyleName("pad-text");
    cp.addText(TestData.DUMMY_TEXT_SHORT);
    cp.setWidth(200);

    add(buttonBar, new MarginData(10));
    add(cp);
    cp.setStyleAttribute("position", "relative");
    cp.setPosition(10, 10);
  }

}
