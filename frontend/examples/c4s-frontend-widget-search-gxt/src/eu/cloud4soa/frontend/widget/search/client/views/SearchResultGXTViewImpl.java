package eu.cloud4soa.frontend.widget.search.client.views;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.util.Size;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.Html;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.CardPanel;
import com.extjs.gxt.ui.client.widget.HorizontalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.custom.Portlet;
import com.extjs.gxt.ui.client.widget.layout.CardLayout;
import com.extjs.gxt.ui.client.widget.layout.FillData;
import com.extjs.gxt.ui.client.widget.layout.FitData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowData;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayoutData;
import com.extjs.gxt.ui.client.widget.layout.LayoutData;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.layout.TableData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.HBoxLayout.HBoxLayoutAlign;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.SimplePanel;

public class SearchResultGXTViewImpl extends CardPanel{
	private CardPanel cardPanel;
	private LayoutContainer lc2;
	

	public void showDetails(){
		cardPanel.setActiveItem(lc2);
	}
	
	public SearchResultGXTViewImpl() {
	
		cardPanel = new CardPanel();
		cardPanel.setBorders(true);
				
		Button btn1 = new Button(">");
				
		Html h2 = new Html("<h1>PaaS Offering details</h1><br><span>Work in progress</span>");
		h2.setBorders(true);
		
		Button btn2 = new Button("<");
		
		final LayoutContainer lc1 = new LayoutContainer();
		lc1.setLayout(new RowLayout(Orientation.HORIZONTAL));
		cardPanel.add(lc1);
		lc1.setBorders(true);
		
		final SearchResultGrid grid = new SearchResultGrid(this);
		
		lc1.add(grid, new RowData (.97, 1, new Margins (0)));
		lc1.add(btn1, new RowData (.03, 1, new Margins (0)));
		
		lc2 = new LayoutContainer();
		lc2.setLayout(new RowLayout(Orientation.HORIZONTAL));
		cardPanel.add(lc2);
		lc2.setBorders(true);
		
		lc2.add(h2, new RowData (.95, 1, new Margins (1)));
		lc2.add(btn2, new RowData (.05, 1, new Margins (1)));
		
		cardPanel.setActiveItem(lc1);
				
		btn1.addListener(Events.Select, new Listener<ButtonEvent>(){
			@Override
			public void handleEvent(ButtonEvent be) {
				cardPanel.setActiveItem(lc2);
//				grid.changeDataProvider();
			}
			
		});
		
		btn2.addListener(Events.Select, new Listener<ButtonEvent>(){
			@Override
			public void handleEvent(ButtonEvent be) {
				cardPanel.setActiveItem(lc1);
			}
			
		});		
 
		add (cardPanel);
		setHeight(300);
	}

}
