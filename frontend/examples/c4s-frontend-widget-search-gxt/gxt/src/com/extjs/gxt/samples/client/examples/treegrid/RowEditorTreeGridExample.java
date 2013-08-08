/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client.examples.treegrid;

import java.util.Arrays;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.samples.resources.client.TestData;
import com.extjs.gxt.samples.resources.client.model.Folder;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.grid.CellEditor;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.RowEditor;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGrid;
import com.extjs.gxt.ui.client.widget.treegrid.TreeGridCellRenderer;
import com.google.gwt.user.client.Element;

public class RowEditorTreeGridExample extends LayoutContainer {

  @Override
  protected void onRender(Element parent, int index) {
    super.onRender(parent, index);

    setLayout(new FlowLayout(10));

    Folder model = TestData.getTreeModel();

    TreeStore<ModelData> store = new TreeStore<ModelData>();
    store.add(model.getChildren(), true);

    ColumnConfig name = new ColumnConfig("name", "Name", 100);
    name.setRenderer(new TreeGridCellRenderer<ModelData>());
    TextField<String> text = new TextField<String>();
    text.setAllowBlank(false);
    name.setEditor(new CellEditor(text));
    
    ColumnConfig author = new ColumnConfig("author", "Author", 100);
    author.setEditor(new CellEditor(new TextField<String>()));
    ColumnConfig size = new ColumnConfig("genre", "Genre", 100);
    size.setEditor(new CellEditor(new TextField<String>()));

    ColumnModel cm = new ColumnModel(Arrays.asList(name, author, size));

    ContentPanel cp = new ContentPanel();
    cp.setBodyBorder(false);
    cp.setHeading("RowEditor TreeGrid");
    cp.setButtonAlign(HorizontalAlignment.CENTER);
    cp.setLayout(new FitLayout());
    cp.setFrame(true);
    cp.setSize(600, 300);

    TreeGrid<ModelData> tree = new TreeGrid<ModelData>(store, cm);
    tree.setBorders(true);
    tree.getStyle().setLeafIcon(Resources.ICONS.music());
    tree.setSize(400, 400);
    tree.setAutoExpandColumn("name");
    tree.setTrackMouseOver(false);
    
    RowEditor<ModelData> editor = new RowEditor<ModelData>();
    tree.addPlugin(editor);

    cp.add(tree);

    add(cp);
  }

}
