/*
 * Ext GWT 2.2.4 - Ext for GWT
 * Copyright(c) 2007-2010, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://extjs.com/license
 */
package com.extjs.gxt.samples.client;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.samples.client.examples.binding.BasicBindingExample;
import com.extjs.gxt.samples.client.examples.binding.GridBindingExample;
import com.extjs.gxt.samples.client.examples.binding.GridStoreBindingExample;
import com.extjs.gxt.samples.client.examples.button.ButtonAlignExample;
import com.extjs.gxt.samples.client.examples.button.ButtonsExample;
import com.extjs.gxt.samples.client.examples.chart.AdvancedChartExample;
import com.extjs.gxt.samples.client.examples.chart.BasicChartExample;
import com.extjs.gxt.samples.client.examples.chart.ChartGalleryExample;
import com.extjs.gxt.samples.client.examples.core.TemplateExample;
import com.extjs.gxt.samples.client.examples.dnd.BasicDNDExample;
import com.extjs.gxt.samples.client.examples.dnd.DualListFieldExample;
import com.extjs.gxt.samples.client.examples.dnd.GridToGridExample;
import com.extjs.gxt.samples.client.examples.dnd.ListViewDNDExample;
import com.extjs.gxt.samples.client.examples.dnd.MultiComponentExample;
import com.extjs.gxt.samples.client.examples.dnd.ReorderingGridExample;
import com.extjs.gxt.samples.client.examples.dnd.ReorderingTreeGridExample;
import com.extjs.gxt.samples.client.examples.dnd.ReorderingTreePanelExample;
import com.extjs.gxt.samples.client.examples.dnd.TreeGridToTreeGridExample;
import com.extjs.gxt.samples.client.examples.dnd.TreePanelToTreePanelExample;
import com.extjs.gxt.samples.client.examples.forms.AdvancedComboBoxExample;
import com.extjs.gxt.samples.client.examples.forms.AdvancedFormsExample;
import com.extjs.gxt.samples.client.examples.forms.ComboBoxExample;
import com.extjs.gxt.samples.client.examples.forms.CustomFormExample;
import com.extjs.gxt.samples.client.examples.forms.FileUploadExample;
import com.extjs.gxt.samples.client.examples.forms.FormsExample;
import com.extjs.gxt.samples.client.examples.grid.AggregationGridExample;
import com.extjs.gxt.samples.client.examples.grid.AutoHeightGridExample;
import com.extjs.gxt.samples.client.examples.grid.BeanModelGridExample;
import com.extjs.gxt.samples.client.examples.grid.BufferedGridExample;
import com.extjs.gxt.samples.client.examples.grid.CheckGroupingGridExample;
import com.extjs.gxt.samples.client.examples.grid.ColumnGroupingExample;
import com.extjs.gxt.samples.client.examples.grid.EditableBufferedGridExample;
import com.extjs.gxt.samples.client.examples.grid.EditableGridExample;
import com.extjs.gxt.samples.client.examples.grid.FilterGridExample;
import com.extjs.gxt.samples.client.examples.grid.GridExample;
import com.extjs.gxt.samples.client.examples.grid.GridPluginsExample;
import com.extjs.gxt.samples.client.examples.grid.GroupingGridExample;
import com.extjs.gxt.samples.client.examples.grid.JsonGridExample;
import com.extjs.gxt.samples.client.examples.grid.LiveGridExample;
import com.extjs.gxt.samples.client.examples.grid.MemoryPagingGridExample;
import com.extjs.gxt.samples.client.examples.grid.PagingBeanModelGridExample;
import com.extjs.gxt.samples.client.examples.grid.PagingGridExample;
import com.extjs.gxt.samples.client.examples.grid.RemoteFilterGridExample;
import com.extjs.gxt.samples.client.examples.grid.RowEditorExample;
import com.extjs.gxt.samples.client.examples.grid.TotalsGridExample;
import com.extjs.gxt.samples.client.examples.grid.WidgetRenderingExample;
import com.extjs.gxt.samples.client.examples.grid.XmlGridExample;
import com.extjs.gxt.samples.client.examples.layouts.AccordionLayoutExample;
import com.extjs.gxt.samples.client.examples.layouts.AnchorLayoutExample;
import com.extjs.gxt.samples.client.examples.layouts.BorderLayoutExample;
import com.extjs.gxt.samples.client.examples.layouts.CardLayoutExample;
import com.extjs.gxt.samples.client.examples.layouts.CenterLayoutExample;
import com.extjs.gxt.samples.client.examples.layouts.HBoxLayoutExample;
import com.extjs.gxt.samples.client.examples.layouts.RowLayoutExample;
import com.extjs.gxt.samples.client.examples.layouts.VBoxLayoutExample;
import com.extjs.gxt.samples.client.examples.misc.CustomSliderExample;
import com.extjs.gxt.samples.client.examples.misc.DatePickerExample;
import com.extjs.gxt.samples.client.examples.misc.DraggableExample;
import com.extjs.gxt.samples.client.examples.misc.FxExample;
import com.extjs.gxt.samples.client.examples.misc.ResizableExample;
import com.extjs.gxt.samples.client.examples.misc.SliderExample;
import com.extjs.gxt.samples.client.examples.misc.ToolTipsExample;
import com.extjs.gxt.samples.client.examples.model.Category;
import com.extjs.gxt.samples.client.examples.model.Entry;
import com.extjs.gxt.samples.client.examples.organizer.ImageOrganizerExample;
import com.extjs.gxt.samples.client.examples.portal.PortalExample;
import com.extjs.gxt.samples.client.examples.tabs.AdvancedTabExample;
import com.extjs.gxt.samples.client.examples.tabs.BasicTabExample;
import com.extjs.gxt.samples.client.examples.toolbar.AdvancedToolBarExample;
import com.extjs.gxt.samples.client.examples.toolbar.MenuBarExample;
import com.extjs.gxt.samples.client.examples.toolbar.StatusToolBarExample;
import com.extjs.gxt.samples.client.examples.toolbar.ToolBarExample;
import com.extjs.gxt.samples.client.examples.toolbar.ToolBarOverflowExample;
import com.extjs.gxt.samples.client.examples.treegrid.AsyncTreeGridExample;
import com.extjs.gxt.samples.client.examples.treegrid.EditorTreeGridExample;
import com.extjs.gxt.samples.client.examples.treegrid.FilterTreeGridExample;
import com.extjs.gxt.samples.client.examples.treegrid.RemoteSortTreeGridExample;
import com.extjs.gxt.samples.client.examples.treegrid.RowEditorTreeGridExample;
import com.extjs.gxt.samples.client.examples.treegrid.RowNumberTreeGridExample;
import com.extjs.gxt.samples.client.examples.treegrid.TreeGridExample;
import com.extjs.gxt.samples.client.examples.treegrid.WidgetTreeGridExample;
import com.extjs.gxt.samples.client.examples.treepanel.AsyncTreePanelExample;
import com.extjs.gxt.samples.client.examples.treepanel.AsyncXmlTreePanelExample;
import com.extjs.gxt.samples.client.examples.treepanel.BasicTreePanelExample;
import com.extjs.gxt.samples.client.examples.treepanel.CheckBoxTreePanelExample;
import com.extjs.gxt.samples.client.examples.treepanel.ContextMenuTreePanelExample;
import com.extjs.gxt.samples.client.examples.treepanel.FastTreePanelExample;
import com.extjs.gxt.samples.client.examples.treepanel.FilterTreePanelExample;
import com.extjs.gxt.samples.client.examples.view.CheckBoxListViewExample;
import com.extjs.gxt.samples.client.examples.view.ImageChooserExample;
import com.extjs.gxt.samples.client.examples.view.ListViewExample;
import com.extjs.gxt.samples.client.examples.windows.AccordionWindowExample;
import com.extjs.gxt.samples.client.examples.windows.DialogExample;
import com.extjs.gxt.samples.client.examples.windows.HelloWindowExample;
import com.extjs.gxt.samples.client.examples.windows.MessageBoxExample;
import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.samples.resources.client.images.ExampleImages;
import com.extjs.gxt.ui.client.Style.HideMode;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.TreeModel;

public class ExamplesModel extends BaseTreeModel {

  protected List<Entry> entries = new ArrayList<Entry>();

  public ExamplesModel() {
    ExampleImages g = Resources.IMAGES;

    Category grids = new Category("Grids");
    grids.add("Basic Grid", new GridExample(), g.basicgrid().getHTML());
    grids.add("Auto Height Grid", new AutoHeightGridExample(), g.basicgrid().getHTML());
    grids.add("Column Grouping", new ColumnGroupingExample(), g.columngrouping().getHTML());
    grids.add("Aggregation Row Grid", new AggregationGridExample(), g.aggregationrowgrid().getHTML());
    grids.add("Grid Plugins", new GridPluginsExample(), g.gridplugins().getHTML());
    grids.add("Editable Grid", new EditableGridExample(), g.editablegrid().getHTML());
    grids.add("RowEditor Grid", new RowEditorExample(), g.roweditorgrid().getHTML());
    grids.add("Xml Grid", new XmlGridExample(), g.xmlgrid().getHTML());
    grids.add("Json Grid", new JsonGridExample(), g.jsongrid().getHTML());
    grids.add("Paging", new PagingGridExample(), g.paging().getHTML());
    grids.add("Local Paging", new MemoryPagingGridExample(), g.localpaging().getHTML());
    grids.add("Grouping", new GroupingGridExample(), g.grouping().getHTML());
    grids.add("Check Grouping", new CheckGroupingGridExample(), g.grouping().getHTML());
    grids.add("Live Group Summary", new TotalsGridExample(), g.livegroupsummary().getHTML());
    grids.add("BeanModel Grid", new BeanModelGridExample(), g.beanmodelgrid().getHTML());
    grids.add("Paging BeanModel Grid", new PagingBeanModelGridExample(), g.pagingbeanmodelgrid().getHTML());
    grids.add("Buffered Grid", new BufferedGridExample(), g.bufferedgrid().getHTML());
    grids.add("Editable Buffered Grid", new EditableBufferedGridExample(), g.editablebufferedgrid().getHTML());
    grids.add("Widget Renderer Grid", new WidgetRenderingExample(), g.widgetrenderergrid().getHTML());
    grids.add("Filter Grid", new FilterGridExample(), g.filtergrid().getHTML());
    grids.add("Remote Filter Grid", new RemoteFilterGridExample(), g.basicgrid().getHTML());
    grids.add("Live Grid", new LiveGridExample(), g.livegrid().getHTML());
    add(grids);

    Category treeGrids = new Category("TreeGrid");
    treeGrids.add("Basic TreeGrid", new TreeGridExample(), Resources.IMAGES.basictreegrid().getHTML());
    treeGrids.add("Filter TreeGrid", new FilterTreeGridExample(), Resources.IMAGES.filtertreegrid().getHTML());
    treeGrids.add("Async TreeGrid", new AsyncTreeGridExample(), Resources.IMAGES.asynctreegrid().getHTML());
    treeGrids.add("Remote Sort TreeGrid", new RemoteSortTreeGridExample(), Resources.IMAGES.asynctreegrid().getHTML());
    treeGrids.add("RowNumber TreeGrid", new RowNumberTreeGridExample(), g.rownumbertreegrid().getHTML());
    treeGrids.add("EditorTreeGrid", new EditorTreeGridExample(), Resources.IMAGES.editortreegrid().getHTML());
    treeGrids.add("RowEditor TreeGrid", new RowEditorTreeGridExample(), g.roweditortreegrid().getHTML());
    treeGrids.add("Widget Renderer TreeGrid", new WidgetTreeGridExample(), g.widgetrenderertreegrid().getHTML());
    add(treeGrids);

    Category treePanels = new Category("TreePanel");
    treePanels.add("Basic Tree", new BasicTreePanelExample(), g.basictree().getHTML());
    treePanels.add("Context Menu Tree", new ContextMenuTreePanelExample(), g.contextmenutree().getHTML());
    treePanels.add("Async Tree", new AsyncTreePanelExample(), g.asynctree().getHTML());
    treePanels.add("Async Xml Tree", new AsyncXmlTreePanelExample(), g.asyncxmltreepanel().getHTML());
    treePanels.add("Filter Tree", new FilterTreePanelExample(), g.filtertree().getHTML());
    treePanels.add("Checkbox Tree", new CheckBoxTreePanelExample(), g.checkboxtree().getHTML());
    treePanels.add("Fast Tree", new FastTreePanelExample(), g.fasttree().getHTML());
    add(treePanels);

    Category tabs = new Category("Tabs");
    tabs.add("Basic Tabs", new BasicTabExample(), g.basictabs().getHTML());
    tabs.add("Advanced Tabs", new AdvancedTabExample(), g.advancedtabs().getHTML());
    add(tabs);

    Category ch = new Category("Charts");
    ch.add("Basic Chart", new BasicChartExample(), g.basicchart().getHTML(), false, true, HideMode.OFFSETS);
    ch.add("Chart Gallery", new ChartGalleryExample(), g.chartgallery().getHTML(), false, true, HideMode.OFFSETS);
    ch.add("Advanced Charts", new AdvancedChartExample(), g.advancedcharts().getHTML(), false, true, HideMode.OFFSETS);
    add(ch);

    Category dnd = new Category("Drag and Drop");
    dnd.add("Basic DnD", new BasicDNDExample(), g.basicdnd().getHTML());
    dnd.add("List to List", new ListViewDNDExample(), g.listtolist().getHTML());
    dnd.add("Grid to Grid", new GridToGridExample(), g.gridtogrid().getHTML());
    dnd.add("Reordering Grid", new ReorderingGridExample(), g.gridtogrid().getHTML());
    dnd.add("Tree to Tree", new TreePanelToTreePanelExample(), g.treetotree().getHTML());
    dnd.add("Reordering Tree", new ReorderingTreePanelExample(), g.reorderingtree().getHTML());
    dnd.add("TreeGrid to TreeGrid", new TreeGridToTreeGridExample(), g.treegridtotreegrid().getHTML());
    dnd.add("Reordering TreeGrid", new ReorderingTreeGridExample(), g.reorderingtreegrid().getHTML());
    dnd.add("Image Organizer", new ImageOrganizerExample(), g.imageorganizer().getHTML());
    dnd.add("Multiple Components", new MultiComponentExample(), g.multicomponent().getHTML());
    add(dnd);

    Category windows = new Category("Windows");
    windows.add("Hello World", new HelloWindowExample(), g.helloworld().getHTML());
    windows.add("Accordion Window", new AccordionWindowExample(), g.accordionwindow().getHTML());
    windows.add("Dialog", new DialogExample(), Resources.IMAGES.dialog().getHTML());
    windows.add("MessageBox", new MessageBoxExample(), g.messagebox().getHTML());
    add(windows);

    Category layouts = new Category("Layouts");
    layouts.add("AccordionLayout", new AccordionLayoutExample(), Resources.IMAGES.accordionlayout().getHTML());
    layouts.add("AnchorLayout", new AnchorLayoutExample(), Resources.IMAGES.anchorlayout().getHTML());
    layouts.add("BorderLayout", new BorderLayoutExample(), Resources.IMAGES.borderlayout().getHTML(), true);
    layouts.add("CardLayout", new CardLayoutExample(), Resources.IMAGES.cardlayout().getHTML());
    layouts.add("CenterLayout", new CenterLayoutExample(), Resources.IMAGES.centerlayout().getHTML(), true);
    layouts.add("RowLayout", new RowLayoutExample(), Resources.IMAGES.rowlayout().getHTML(), true);
    layouts.add("Portal", new PortalExample(), Resources.IMAGES.portal().getHTML(), true);
    layouts.add("VBoxLayout", new VBoxLayoutExample(), Resources.IMAGES.vboxlayout().getHTML(), true);
    layouts.add("HBoxLayout", new HBoxLayoutExample(), Resources.IMAGES.hboxlayout().getHTML(), true);
    add(layouts);

    Category combos = new Category("Combos");
    combos.add("ComboBox", new ComboBoxExample(), g.combobox().getHTML());
    combos.add("Advanced ComboBox", new AdvancedComboBoxExample(), g.advancedcombobox().getHTML());
    add(combos);

    Category forms = new Category("Forms");
    forms.add("Forms", new FormsExample(), g.forms().getHTML());
    forms.add("Custom Form", new CustomFormExample(), g.forms().getHTML());
    forms.add("Advanced Forms", new AdvancedFormsExample(), g.advancedforms().getHTML(), false, true, HideMode.OFFSETS);
    forms.add("DualListField", new DualListFieldExample(), g.duallistfield().getHTML());
    forms.add("File Upload", new FileUploadExample(), g.fileupload().getHTML());
    add(forms);

    Category binding = new Category("Binding");
    binding.add("Basic Binding", new BasicBindingExample(), g.basicbinding().getHTML());
    binding.add("Grid Binding", new GridBindingExample(), g.gridbinding().getHTML());
    binding.add("Grid Store Binding", new GridStoreBindingExample(), g.gridstorebinding().getHTML());
    add(binding);

    Category toolbar = new Category("ToolBar & Menus");
    toolbar.add("Basic Toolbar", new ToolBarExample(), g.basictoolbar().getHTML());
    toolbar.add("Status Toolbar", new StatusToolBarExample(), g.statustoolbar().getHTML());
    toolbar.add("Advanced Toolbar", new AdvancedToolBarExample(), g.advancedtoolbar().getHTML());
    toolbar.add("Overflow Toolbar", new ToolBarOverflowExample(), g.overflowtoolbar().getHTML());
    toolbar.add("MenuBar", new MenuBarExample(), g.menubar().getHTML());
    add(toolbar);

    Category templates = new Category("Templates & Lists");
    templates.add("Templates", new TemplateExample(), g.templates().getHTML());
    templates.add("ListView", new ListViewExample(), g.listview().getHTML());
    templates.add("CheckBoxListView", new CheckBoxListViewExample(), g.checkboxlistview().getHTML());
    templates.add("Advanced ListView", new ImageChooserExample(), g.advancedlistview().getHTML());
    add(templates);

    Category button = new Category("Button");
    button.add("Buttons", new ButtonsExample(), g.buttons().getHTML());
    button.add("Button Aligning", new ButtonAlignExample(), g.buttonaligning().getHTML());
    add(button);

    Category misc = new Category("Misc");
    misc.add("ToolTips", new ToolTipsExample(), g.tooltips().getHTML());
    misc.add("DatePicker", new DatePickerExample(), g.datepicker().getHTML());
    misc.add("Draggable", new DraggableExample(), g.draggable().getHTML(), true);
    misc.add("Resizable", new ResizableExample(), g.resizable().getHTML(), true);
    misc.add("Slider", new SliderExample(), g.slider().getHTML());
    misc.add("Custom Slider", new CustomSliderExample(), g.customslider().getHTML());
    misc.add("Fx", new FxExample(), g.fx().getHTML(), true);
    add(misc);

    loadEntries(this);
  }

  public Entry findEntry(String name) {
    if (get(name) != null) {
      return (Entry) get(name);
    }
    for (Entry entry : getEntries()) {
      if (name.equals(entry.getId())) {
        return entry;
      }
    }
    return null;
  }

  public List<Entry> getEntries() {
    return entries;
  }

  private void loadEntries(TreeModel model) {
    for (ModelData child : model.getChildren()) {
      if (child instanceof Entry) {
        entries.add((Entry) child);
      } else if (child instanceof Category) {
        loadEntries((Category) child);
      }
    }
  }
}
