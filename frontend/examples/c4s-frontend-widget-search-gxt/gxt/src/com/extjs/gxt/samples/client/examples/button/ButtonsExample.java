/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.button;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.ui.client.GXT;
import com.extjs.gxt.ui.client.Style.ButtonArrowAlign;
import com.extjs.gxt.ui.client.Style.ButtonScale;
import com.extjs.gxt.ui.client.Style.IconAlign;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.button.SplitButton;
import com.extjs.gxt.ui.client.widget.button.ToggleButton;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.google.gwt.user.client.Element;

public class ButtonsExample extends LayoutContainer {

  enum Category {
    MENU("Menu Buttons"), MENUBOTTOM("Menu Buttons (Arrow on bottom)"), NORMAL("Normal Buttons"), SPLIT("Split Buttons"), SPLITBOTTOM(
        "Split Buttons (Arrow on bottom)"), TOGGLE("Toggle Buttons");

    private String text;

    Category(String text) {
      this.text = text;

    }

    String getText() {
      return text;
    }
  }

  enum Type {

    BOTTOM("Icon and Text(bottom)"), ICON("Icon Only"), LEFT("Icon and Text (left)"), RIGHT("Icon and Text (right)"), TEXT(
        "Text Only"), TOP("Icon and Text (top)");

    private String text;

    Type(String text) {
      this.text = text;
    }

    String getText() {
      return text;
    }
  }

  private VerticalPanel vp;

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    vp = new VerticalPanel();
    vp.setSpacing(10);
    vp.getFocusSupport().setIgnore(false);

    for (Category cat : Category.values()) {
      vp.add(formatHeader(cat.getText()));

      for (Type type : Type.values()) {
        vp.add(format(type.getText()));

        ButtonBar hp = new ButtonBar();

        Button small = createButton(cat, type);
        Button medium = createButton(cat, type);
        Button large = createButton(cat, type);

        configureButton(small, type, ButtonScale.SMALL);
        configureButton(medium, type, ButtonScale.MEDIUM);
        configureButton(large, type, ButtonScale.LARGE);

        hp.add(small);
        hp.add(medium);
        hp.add(large);

        vp.add(hp);
      }
    }
    add(vp);
  }

  private void configureButton(Button btn, Type type, ButtonScale scale) {
    btn.setScale(scale);
    switch (type) {

      case LEFT:
        btn.setIconAlign(IconAlign.LEFT);
        break;
      case RIGHT:
        btn.setIconAlign(IconAlign.RIGHT);
        break;
      case BOTTOM:
        btn.setIconAlign(IconAlign.BOTTOM);
        break;
      case TOP:
        btn.setIconAlign(IconAlign.TOP);
        break;
    }

    switch (type) {
      case ICON:
        setIcon(btn, scale);
        break;
      case TEXT:
        btn.setText("Add User");
        break;
      default: {
        setIcon(btn, scale);
        btn.setText("Add User");
      }
    }
  }

  private Button createButton(Category cat, Type type) {
    Button btn = null;
    switch (cat) {
      case NORMAL:
        btn = new Button();
        break;
      case TOGGLE:
        btn = new ToggleButton();
        break;
      case MENU:
        btn = new Button();
        btn.setMenu(createMenu());
        break;
      case MENUBOTTOM:
        btn = new Button();
        btn.setMenu(createMenu());
        btn.setArrowAlign(ButtonArrowAlign.BOTTOM);
        break;
      case SPLIT:
        btn = new SplitButton();
        btn.setMenu(createMenu());
        break;
      case SPLITBOTTOM:
        btn = new SplitButton();
        btn.setMenu(createMenu());
        btn.setArrowAlign(ButtonArrowAlign.BOTTOM);
        break;
    }
    return btn;
  }

  private Menu createMenu() {
    Menu menu = new Menu();
    menu.add(new MenuItem("Menu Item 1"));
    menu.add(new MenuItem("Menu Item 2"));
    menu.add(new MenuItem("Menu Item 3"));
    return menu;
  }

  private Html format(String text) {
    Html html = new Html("<span class='text' style='margin: 10px'>" + text + "</span>");
    html.getFocusSupport().setIgnore(true);
    return html;
  }

  private Html formatHeader(String text) {
    String bg = "background-color: " + (GXT.isAriaEnabled() ? "#242b3a" : "#dd");
    Html html = new Html("<div class='text' style='width: 400px;padding: 4px;" + bg + "'><b>" + text
        + "</b></div>");
    html.getFocusSupport().setIgnore(true);
    return html;
  }

  private void setIcon(Button btn, ButtonScale scale) {
    switch (scale) {
      case SMALL:
        btn.setIcon(Resources.ICONS.add16());
        break;
      case MEDIUM:
        btn.setIcon(Resources.ICONS.add24());
        break;
      case LARGE:
        btn.setIcon(Resources.ICONS.add32());
        break;
    }

  }
}
