package eu.cloud4soa.frontend.widget.search.client.views;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.samples.resources.client.Resources;
import com.extjs.gxt.ui.client.store.GroupingStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridGroupRenderer;
import com.extjs.gxt.ui.client.widget.grid.GroupColumnData;
import com.extjs.gxt.ui.client.widget.grid.GroupingView;
import com.extjs.gxt.ui.client.widget.layout.FitData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.user.client.Element;

import eu.cloud4soa.frontend.widget.search.client.data.PaaSOfferingDetails;
import eu.cloud4soa.frontend.widget.search.client.data.PaasOfferingStore;
  
public class PaaSOfferingDetailsGXTViewImpl extends LayoutContainer {  
  
  @Override  
  protected void onRender(Element parent, int index) {  
    super.onRender(parent, index);  
  
    GroupingStore<PaaSOfferingDetails> store = new GroupingStore<PaaSOfferingDetails>();  
    store.add(PaasOfferingStore.getPaaSOfferingDetails());  
    store.groupBy("section");  
  
    ColumnConfig property = new ColumnConfig("property", "Property", 300); 
    property.setStyle("color:blue;font-weight:bold");
    ColumnConfig value = new ColumnConfig("value", "Value", 300); 
    ColumnConfig section = new ColumnConfig("section", "section", 0);  
  
    List<ColumnConfig> config = new ArrayList<ColumnConfig>();  
    config.add(property);  
    config.add(value);  
    config.add(section);   
  
    final ColumnModel cm = new ColumnModel(config);  
  
    GroupingView view = new GroupingView();  
    view.setShowGroupedColumn(false);  
    view.setForceFit(true);  
    view.setAutoFill(true);
    view.setGroupRenderer(new GridGroupRenderer() {  
      public String render(GroupColumnData data) {  
        return data.group;  
      }  
    });  
  
    Grid<PaaSOfferingDetails> grid = new Grid<PaaSOfferingDetails>(store, cm);  
    grid.setView(view);
    grid.setBorders(true);  
//    grid.setAutoHeight(false);
//    grid.setAutoWidth(false);
    grid.setAutoExpandColumn("property");
     
//    setSize(700, 450);  
//    setLayout(new FitLayout()); 
//    add(grid, new FitData(1));  
    setLayout (new FitLayout());
    add (grid, new FitData(1));
    setHeight(300);
  }  
  
}  
