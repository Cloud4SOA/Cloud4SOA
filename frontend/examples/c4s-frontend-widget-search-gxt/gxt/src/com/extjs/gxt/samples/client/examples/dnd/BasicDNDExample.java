/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.dnd;

import com.extjs.gxt.ui.client.core.El;
import com.extjs.gxt.ui.client.dnd.DragSource;
import com.extjs.gxt.ui.client.dnd.DropTarget;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.DNDEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FlowData;
import com.google.gwt.user.client.Element;

public class BasicDNDExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);
    
    El.fly(parent).addStyleName("dnd-example");
    
    HorizontalPanel hp = new HorizontalPanel();
    hp.setSpacing(10);

    final LayoutContainer container = new LayoutContainer();
    container.setLayoutOnChange(true);
    container.setBorders(true);
    container.setSize(200, 200);

    DropTarget target = new DropTarget(container) {
      @Override
      protected void onDragDrop(DNDEvent event) {
        super.onDragDrop(event);
        Html html = event.getData();
        container.add(html);
      }
    };
    target.setGroup("test");
    target.setOverStyle("drag-ok");

    final LayoutContainer sourceContainer = new LayoutContainer();
    sourceContainer.setLayoutOnChange(true);
    sourceContainer.setWidth(100);

    addSources(sourceContainer);

    Button reset = new Button("Reset");
    reset.addSelectionListener(new SelectionListener<ButtonEvent>() {
      @Override
      public void componentSelected(ButtonEvent ce) {
        container.removeAll();
        sourceContainer.removeAll();
        addSources(sourceContainer);
      }
    });

    hp.add(container);
    hp.add(sourceContainer);
    add(hp);
    add(reset, new FlowData(10));
  }

  private void addSources(LayoutContainer container) {
    for (int i = 0; i < 5; i++) {
      final Html html = new Html("Drag Me " + i);
      html.setStyleAttribute("padding", "5px");
      html.setStyleAttribute("border", "1px solid red");
      html.setStyleAttribute("cursor", "default");
      html.setStyleName("text");
      container.add(html, new FlowData(3));

      DragSource source = new DragSource(html) {
        @Override
        protected void onDragStart(DNDEvent event) {
          // by default drag is allowed
          event.setData(html);
          event.getStatus().update(El.fly(html.getElement()).cloneNode(true));
        }
      };
      // group is optional
      source.setGroup("test");
    }
  }

}
