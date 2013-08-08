package eu.cloud4soa.frontend.widget.search.client;


import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.event.IconButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.fx.Draggable;
import com.extjs.gxt.ui.client.fx.Resizable;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.CardPanel;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ToolButton;
import com.extjs.gxt.ui.client.widget.custom.Portal;
import com.extjs.gxt.ui.client.widget.custom.Portlet;
import com.extjs.gxt.ui.client.widget.layout.FillData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout.HBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.MarginData;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import eu.cloud4soa.frontend.widget.search.client.dialog.FormDialogExampleView;
import eu.cloud4soa.frontend.widget.search.client.views.AdvancedChartExample;
import eu.cloud4soa.frontend.widget.search.client.views.BasicChartExample;
import eu.cloud4soa.frontend.widget.search.client.views.DeployedApplicationsGXTViewImpl;
import eu.cloud4soa.frontend.widget.search.client.views.FacetedSearchGXTViewImpl;
import eu.cloud4soa.frontend.widget.search.client.views.FacetedSearchPanel;
import eu.cloud4soa.frontend.widget.search.client.views.KeysFormDialog;
import eu.cloud4soa.frontend.widget.search.client.views.MonitoringViewGXTImpl;
import eu.cloud4soa.frontend.widget.search.client.views.MonitoringViewImpl;
import eu.cloud4soa.frontend.widget.search.client.views.PaaSOfferingDetailsGXTViewImpl;
import eu.cloud4soa.frontend.widget.search.client.views.RegistrationForm;
import eu.cloud4soa.frontend.widget.search.client.views.SLAViolationsGXTViewImpl;
import eu.cloud4soa.frontend.widget.search.client.views.SearchResultGXTViewImpl;
import eu.cloud4soa.frontend.widget.search.client.views.SearchResultGrid;
import eu.cloud4soa.frontend.widget.search.client.views.WaitMessageBoxExample;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class C4s_frontend_widget_search_gwt implements EntryPoint {
	Portal portal;
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * This is the entry point method.
	 */
	
	public void onModuleLoad() {

//		LayoutContainer c = createPaaSOfferingDetailsGXTViewImpl();
//		LayoutContainer c = createDeployedApplicationsXTViewImpl();
//		LayoutContainer c = createFacetedSearchGXTViewImpl();
//		LayoutContainer c = createSearchResultGXTViewImpl();
//		LayoutContainer c = createSearchResultGrid();
//		MonitoringViewImpl c = new MonitoringViewImpl();
		MonitoringViewGXTImpl c = new MonitoringViewGXTImpl("Application A");
//		BasicChartExample c = new BasicChartExample();
//		AdvancedChartExample c = new AdvancedChartExample();
//		WaitMessageBoxExample c = new WaitMessageBoxExample();
//		KeysFormDialog c = new KeysFormDialog();
//		RegistrationForm c = new RegistrationForm();
//		c.show();
		
        Viewport viewport = new Viewport();
        viewport.setLayout(new FitLayout());
        viewport.add(c);
        RootPanel.get().add(viewport);
//		
		

//		Widget c = new DeployedApplicationsGXTViewImpl(); //OK
//		Widget c = new PaaSOfferingDetailsGXTViewImpl(); //OK
//		Widget c = new SearchResultGXTViewImpl(); //OK
//		Widget c = new SearchResultGrid(null); //OK
//		Widget c = new FacetedSearchGXTViewImpl(); //OK
//		Widget c = new SLAViolationsGXTViewImpl();
		
//		portal = new Portal(2);
//		portal.setColumnWidth(0, 0.5);
		
//		
//		HasOneWidget widget = createNewWidget("SLA Violations", false, 0, 0);
//		widget.setWidget(c);
//		
//		RootPanel.get().add(portal);
		
//		Dialog dialog = new KeysFormDialog();
//		dialog.show();
		
		
	}
	
    public HasOneWidget createNewWidget(String heading, boolean allowClosing, int index, int column) {
        Portlet portlet = new Portlet();
        portlet.setHeading(heading);
        HasOneWidget container = configPanel(portlet, allowClosing);
        portal.insert(portlet, index, column);
        // TODO validate index and column
        return container;
    }

    private HasOneWidget configPanel(final ContentPanel panel, boolean allowClosing) {
        panel.setCollapsible(true);
        panel.setAnimCollapse(false);
        panel.setExpanded(true);
        if (allowClosing) {
            panel.getHeader().addTool(
                    new ToolButton("x-tool-close", new SelectionListener<IconButtonEvent>() {

                        @Override
                        public void componentSelected(IconButtonEvent ce) {
                            panel.removeFromParent();
                        }

                    }));
        }
        SimplePanel widget = new SimplePanel();
        panel.add(widget);
        return widget;
    }
	
//    public HasOneWidget createNewWidget(String heading, boolean allowClosing, int index, int column) {
//        Portlet portlet = new Portlet();
//        portlet.setLayout(new FitLayout());
//        portlet.setHeight(300);
////        portlet.setAutoWidth(true);
//        portlet.setHeading(heading);
//        HasOneWidget container = configPanel(portlet, allowClosing);
//        portal.insert(portlet, index, column);
//        // TODO validate index and column
//        return container;
//    }
//
//    private HasOneWidget configPanel(final ContentPanel panel, boolean allowClosing) {
//        panel.setCollapsible(true);
//        panel.setAnimCollapse(false);
//        panel.setExpanded(true);
//        if (allowClosing) {
//            panel.getHeader().addTool(
//                    new ToolButton("x-tool-close", new SelectionListener<IconButtonEvent>() {
//
//                        @Override
//                        public void componentSelected(IconButtonEvent ce) {
//                            panel.removeFromParent();
//                        }
//
//                    }));
//        }
//        HasOneWidgetPanel widget = new HasOneWidgetPanel();
//        widget.setLayout(new FitLayout());
//        panel.add(widget);
//        return widget;
//    }
//    
    
    class HasOneWidgetPanel extends LayoutContainer implements HasOneWidget{
    	private Widget widget;
    	
		@Override
		public void setWidget(IsWidget w) {
			remove(this.widget);
			this.widget = w.asWidget();
			add (w.asWidget());
		}

		@Override
		public Widget getWidget() {
			return widget;
		}

		@Override
		public void setWidget(Widget w) {
			remove(this.widget);
			this.widget = w;
			add (w);
		}
    	
    }
    
    private LayoutContainer createPaaSOfferingDetailsGXTViewImpl(){
    	
    	LayoutContainer c = new LayoutContainer();
        VBoxLayout layout = new VBoxLayout();
        layout.setVBoxLayoutAlign(VBoxLayout.VBoxLayoutAlign.STRETCH);
        c.setLayout(layout);
//        c.setSize(600, 400);
        
        VBoxLayoutData flex = new VBoxLayoutData();  
        flex.setFlex(1);
               
        PaaSOfferingDetailsGXTViewImpl panel = new PaaSOfferingDetailsGXTViewImpl();
        c.add(panel, flex);
        
		return c; 
    }
    
    private LayoutContainer createDeployedApplicationsXTViewImpl(){
    	
    	LayoutContainer c = new LayoutContainer();
    	c.setLayout(new FitLayout());
        c.setSize(600, 400);               
        DeployedApplicationsGXTViewImpl panel = new DeployedApplicationsGXTViewImpl();
        c.add(panel);
		return c; 
    }
    
    private LayoutContainer createSearchResultGXTViewImpl(){
    	
    	LayoutContainer c = new LayoutContainer();
        VBoxLayout layout = new VBoxLayout();
        layout.setVBoxLayoutAlign(VBoxLayout.VBoxLayoutAlign.STRETCH);
        c.setLayout(layout);
//        c.setSize(600, 400);
        
        VBoxLayoutData flex = new VBoxLayoutData();  
        flex.setFlex(1);
               
        SearchResultGXTViewImpl panel = new SearchResultGXTViewImpl();
        c.add(panel, flex);
        
		return c; 
    }
    
    private LayoutContainer createSearchResultGrid(){
    	
    	LayoutContainer c = new LayoutContainer();
        VBoxLayout layout = new VBoxLayout();
        layout.setVBoxLayoutAlign(VBoxLayout.VBoxLayoutAlign.STRETCH);
        c.setLayout(layout);
        c.setSize(600, 400);
        
        VBoxLayoutData flex = new VBoxLayoutData();  
        flex.setFlex(1);
               
        SearchResultGrid panel = new SearchResultGrid(null);
        c.add(panel, flex);
        
		return c; 
    }
    
    private LayoutContainer createFacetedSearchGXTViewImpl(){
    	
    	LayoutContainer c = new LayoutContainer();
        VBoxLayout layout = new VBoxLayout();
        layout.setVBoxLayoutAlign(VBoxLayout.VBoxLayoutAlign.STRETCH);
        c.setLayout(layout);
        c.setSize(600, 400);
        
        VBoxLayoutData flex = new VBoxLayoutData();  
        flex.setFlex(1);
               
        FacetedSearchGXTViewImpl panel = new FacetedSearchGXTViewImpl();
        c.add(panel, flex);
        
		return c; 
    }
	
}

