package eu.cloud4soa.frontend.widget.search.client.views;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.Style.SelectionMode;
import com.extjs.gxt.ui.client.event.BaseEvent;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.GridEvent;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionChangedEvent;
import com.extjs.gxt.ui.client.event.SelectionEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ToggleButton;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

import eu.cloud4soa.frontend.widget.search.client.data.Application;
import eu.cloud4soa.frontend.widget.search.client.data.ApplicationStore;
import eu.cloud4soa.frontend.widget.search.client.resources.ResourceBundle;

public class DeployedApplicationsGXTViewImpl extends LayoutContainer {
	public enum DeployedApplicationCommands {START, STOP, UNDEPLOY, SEE_MONITORING_DETAILS};
	
	private final ResourceBundle rb = GWT.create(ResourceBundle.class);
	private Button btnStartStop;
	private Grid<Application> grid;

	@Override
	protected void onRender(Element parent, int index) {
		super.onRender(parent, index);

		// Toolbar
		final ToolBar toolBar = new ToolBar();

		final Button btnStartStop = new Button("Start/Stop",
				IconHelper.createStyle("add16"));
		btnStartStop.setToolTip("Start/Stop application");
		toolBar.add(btnStartStop);

		SelectionListener<ButtonEvent> sl = new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				String commandName = ce.getButton().getText();
				Application application = grid.getSelectionModel().getSelectedItem();
				String message = "";
				DeployedApplicationCommands command = null;
				if (application == null){
					message = "Please, select one deployed application";
					showErrorDialog(message);
				}else {
					if (commandName.equals("Start")){
						 message = "Do you want to start the application " +
						 application.get("acronym") + "?";
						 command = DeployedApplicationCommands.START;
					}else if (commandName.equals("Stop")){
						 message = "Do you want to stop the application " +
						 application.get("acronym") + "?";
						 command = DeployedApplicationCommands.STOP;
					}else if (commandName.equals("Undeploy")){
						 message = "Do you want to undeploy application " +
						 application.get("acronym") + "?";
						 command = DeployedApplicationCommands.UNDEPLOY;
					}else if (commandName.equals("See Monitoring Details")){
						 message = "Do you want to see monitoring details of application " +
						 application.get("acronym") + "?";
						 command = DeployedApplicationCommands.SEE_MONITORING_DETAILS;
					}
					showConfirmationDialog(message, command,(String) application.get("acronym"));
				}
					
				

			}
		};
		
		btnStartStop.addListener(Events.Select, sl);

		Button btnUndeploy = new Button("Undeploy",
				IconHelper.createStyle("add16"));
		btnUndeploy.setToolTip("Undeploy application");
		toolBar.add(btnUndeploy);

		btnUndeploy.addListener(Events.Select, sl);

		Button btnMonitor = new Button("See Monitoring Details",
				IconHelper.createStyle("add16"));
		btnMonitor.setToolTip("See application monitoring details");
		toolBar.add(btnMonitor);

		btnMonitor.addListener(Events.Select, sl);

		// GridCellRenderer<Application> buttonRenderer = new
		// GridCellRenderer<Application>() {
		//
		// private boolean init;
		//
		// public Object render(final Application model, final String property,
		// ColumnData config, final int rowIndex,
		// final int colIndex, ListStore<Application> store, Grid<Application>
		// grid) {
		//
		// //Add listener that manages changes in column size for columns that
		// contains buttons.
		// if (!init) {
		// init = true;
		// grid.addListener(Events.ColumnResize, new
		// Listener<GridEvent<Application>>() {
		//
		// public void handleEvent(GridEvent<Application> be) {
		// for (int i = 0; i < be.getGrid().getStore().getCount(); i++) {
		// if (be.getGrid().getView().getWidget(i, be.getColIndex()) != null
		// && be.getGrid().getView().getWidget(i, be.getColIndex()) instanceof
		// BoxComponent) {
		// ((BoxComponent) be.getGrid().getView().getWidget(i,
		// be.getColIndex())).setWidth(be.getWidth() - 10);
		// }
		// }
		// }
		// });
		// }
		//
		// // Renders a button
		// Button b = new Button((String) model.get(property), new
		// SelectionListener<ButtonEvent>() {
		//
		// @Override
		// public void componentSelected(ButtonEvent ce) {
		// //Manage button click event
		// String message = "";
		//
		// if (property.equals("command")){
		// message = "Do you want to " + model.get(property) + " application " +
		// model.get("acronym") + "?";
		// }else if (property.equals("undeploy")){
		// message = "Do you want to undeploy application " +
		// model.get("acronym") + "?";
		// }else if (property.equals("seemonitoringdata")){
		// message = "Do you want to see monitoring data of application " +
		// model.get("acronym") + "?";
		// }
		// // Info.display("Button selected", message);
		// showConfirmationDialog(message, (String) model.get(property),
		// (String) model.get("acronym"));
		// }
		//
		// private void showConfirmationDialog(String message, final String
		// command, final String application) {
		// final Dialog simple = new Dialog();
		// simple.setHeading("Confirmation");
		// simple.setButtons(Dialog.YESNO);
		// simple.setBodyStyleName("pad-text");
		// simple.addText(message);
		// simple.getItem(0).getFocusSupport().setIgnore(true);
		// simple.setScrollMode(Scroll.AUTO);
		// simple.setHideOnButtonClick(true);
		// simple.show();
		// simple.getButtonById(Dialog.YES).addListener(Events.Select, new
		// SelectionListener<ButtonEvent>(){
		//
		// @Override
		// public void componentSelected(ButtonEvent ce) {
		// Info.display("Accepted", "Apply " + command + " on application " +
		// application);
		// }});
		//
		// simple.getButtonById(Dialog.NO).addListener(Events.Select, new
		// SelectionListener<ButtonEvent>(){
		//
		// @Override
		// public void componentSelected(ButtonEvent ce) {
		// Info.display("Rejected", "Apply " + command + " on application " +
		// application);
		// }});
		// }
		//
		// });
		// //Set fix column size
		// b.setWidth(grid.getColumnModel().getColumnWidth(colIndex) - 10);
		// b.setToolTip(property.equals("seemonitoringdata")?model.get(property)
		// + " of application":model.get(property) + " application");
		// return b;
		// }
		// };

		GridCellRenderer<Application> status = new GridCellRenderer<Application>() {
			public Object render(Application model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore<Application> store, Grid<Application> grid) {
				boolean enabled = (Boolean) model.get(property);
				ImageResource resource = enabled ? rb.online() : rb.offline();
				Image icon = new Image();
				icon.setUrl(resource.getURL());
				return icon;
			}
		};

		List<ColumnConfig> configs = new ArrayList<ColumnConfig>();

		ColumnConfig column = new ColumnConfig();
		column.setId("acronym");
		column.setHeader("Application");
		column.setWidth(200);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("provider");
		column.setHeader("Provider");
		column.setWidth(200);
		configs.add(column);

		column = new ColumnConfig();
		column.setId("status");
		column.setHeader("Status");
		column.setRenderer(status);
		column.setWidth(75);
		column.setAlignment(HorizontalAlignment.CENTER);
		configs.add(column);

		// column = new ColumnConfig();
		// column.setId("command");
		// column.setHeader("");
		// column.setWidth(70);
		// column.setRenderer(buttonRenderer);
		// configs.add(column);
		//
		// column = new ColumnConfig();
		// column.setId("undeploy");
		// column.setHeader("");
		// column.setWidth(90);
		// column.setRenderer(buttonRenderer);
		// configs.add(column);
		//
		// column = new ColumnConfig();
		// column.setId("seemonitoringdata");
		// column.setHeader("");
		// column.setWidth(120);
		// column.setRenderer(buttonRenderer);
		// configs.add(column);

		final ListStore<Application> store = new ListStore<Application>();
		store.add(new ApplicationStore().getApplications());

		ColumnModel cm = new ColumnModel(configs);

		grid = new Grid<Application>(store, cm);
		grid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		grid.setStyleAttribute("borderTop", "none");
		// grid.setAutoExpandColumn("acronym");
		grid.setBorders(true);

		// Getting selection
		grid.getSelectionModel().addListener(Events.SelectionChange,
				new Listener<SelectionChangedEvent<Application>>() {

					@Override
					public void handleEvent(
							SelectionChangedEvent<Application> be) {
						if (be.getSelectedItem()==null){
							return;
						}
						Info.display("Selected application", (String) be
								.getSelectedItem().get("acronym"));
						btnStartStop.setText((Boolean) be.getSelectedItem()
								.get("status") ? "Stop" : "Start");
						btnStartStop.setToolTip((Boolean) be.getSelectedItem()
								.get("status") ? "Stop application"
								: "Start application");
					}

				});

		ContentPanel cp = new ContentPanel();
		cp.setHeaderVisible(false);
		cp.setTopComponent(toolBar);
		cp.add(grid);
		setLayout(new FitLayout());
		final int height = 300;
		setHeight(height);
		add (cp);
		
		//Setting correct Height
		grid.addListener(Events.Render, new Listener<ComponentEvent>(){
			@Override
			public void handleEvent(ComponentEvent be) {
				grid.setHeight(height - toolBar.getHeight());
				layout();
			}});
	}

	private void showConfirmationDialog(String message, final DeployedApplicationCommands command,
			final String application) {
		final Dialog simple = new Dialog();
		simple.setHeading("Confirmation");
		simple.setButtons(Dialog.YESNO);
		simple.setBodyStyleName("pad-text");
		simple.addText(message);
		simple.getItem(0).getFocusSupport().setIgnore(true);
		simple.setScrollMode(Scroll.AUTO);
		simple.setHideOnButtonClick(true);
		simple.show();
		simple.getButtonById(Dialog.YES).addListener(Events.Select,
				new SelectionListener<ButtonEvent>() {

					@Override
					public void componentSelected(ButtonEvent ce) {
						Info.display("Accepted", "Apply " + command
								+ " on application " + application);
					}
				});

		simple.getButtonById(Dialog.NO).addListener(Events.Select,
				new SelectionListener<ButtonEvent>() {

					@Override
					public void componentSelected(ButtonEvent ce) {
						Info.display("Rejected", "Apply " + command
								+ " on application " + application);
					}
				});
	}
	
	private void showErrorDialog(String message) {
		final Dialog simple = new Dialog();
		simple.setHeading("Error");
		simple.setButtons(Dialog.CLOSE);
		simple.setBodyStyleName("pad-text");
		simple.addText(message);
		simple.getItem(0).getFocusSupport().setIgnore(true);
		simple.setScrollMode(Scroll.AUTO);
		simple.setHideOnButtonClick(true);
		simple.show();
	}
}
