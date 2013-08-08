package eu.cloud4soa.frontend.widget.search.client.views;

import java.util.HashMap;
import java.util.Map;

import javax.activation.UnsupportedDataTypeException;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.util.Padding;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteData;
import com.extjs.gxt.ui.client.widget.layout.AbsoluteLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayout.VBoxLayoutAlign;
import com.extjs.gxt.ui.client.widget.layout.VBoxLayoutData;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.CheckBox;

import eu.cloud4soa.frontend.widget.search.client.data.Facet;
import eu.cloud4soa.frontend.widget.search.client.events.SelectedFacetChangedEvent;

public class CustomizeFacetsPanel extends LayoutContainer {

	Map<Facet.FACET_TYPE, CheckBox> cbFacets = new HashMap<Facet.FACET_TYPE, CheckBox>();

	public Map<Facet.FACET_TYPE, CheckBox> getFacetCustomisation() {
		return cbFacets;
	}

	public CustomizeFacetsPanel(final FacetedSearchGXTViewImpl view) {
		setLayout(new FitLayout());
		
		setHeight("172");
		setScrollMode(Scroll.NONE);
		setBorders(false);
		VBoxLayout layout = new VBoxLayout();  
        layout.setPadding(new Padding(5));  
        layout.setVBoxLayoutAlign(VBoxLayoutAlign.LEFT);  
        setLayout(layout);  
        VBoxLayoutData vboxData = new VBoxLayoutData(new Margins(2));

		ValueChangeHandler<Boolean> facetHandler = new ValueChangeHandler<Boolean>() {
			public void onValueChange(ValueChangeEvent<Boolean> event) {
				System.out.println("Facet "
						+ ((CheckBox) event.getSource()).getText()
						+ " selected is "
						+ ((CheckBox) event.getSource()).getValue());
				// Send facet customisation change to FacetedSearchPanel
				view.getEventBus().fireEvent(
						new SelectedFacetChangedEvent(Facet.FACET_TYPE
								.getByName(((CheckBox) event.getSource())
										.getText()), ((CheckBox) event
								.getSource()).getValue()));
			}
		};

		// TODO Manage default selected facet from user's preferences

		CheckBox chckbxProviders = new CheckBox(
				Facet.FACET_TYPE.PROVIDER.getName());
		chckbxProviders.addValueChangeHandler(facetHandler);
		add(chckbxProviders, vboxData);
		chckbxProviders.setSize("73px", "15px");
		chckbxProviders.setValue(true);
		cbFacets.put(Facet.FACET_TYPE.PROVIDER, chckbxProviders);

		CheckBox chckbxTechnologies = new CheckBox(
				Facet.FACET_TYPE.TECHNOLOGY.getName());
		chckbxTechnologies.addValueChangeHandler(facetHandler);
		add(chckbxTechnologies, vboxData);
		chckbxTechnologies.setSize("97px", "15px");
		chckbxTechnologies.setValue(true);
		cbFacets.put(Facet.FACET_TYPE.TECHNOLOGY, chckbxTechnologies);

		CheckBox chckbxTools = new CheckBox(Facet.FACET_TYPE.TOOL.getName());
		add(chckbxTools, vboxData);
		chckbxTools.addValueChangeHandler(facetHandler);
		chckbxTools.setValue(true);
		cbFacets.put(Facet.FACET_TYPE.TOOL, chckbxTools);

		CheckBox chckbxChannels = new CheckBox(
				Facet.FACET_TYPE.CHANNEL.getName());
		add(chckbxChannels, vboxData);
		chckbxChannels.addValueChangeHandler(facetHandler);
		chckbxChannels.setValue(true);
		cbFacets.put(Facet.FACET_TYPE.CHANNEL, chckbxChannels);

		CheckBox chckbxRatings = new CheckBox(Facet.FACET_TYPE.RATING.getName());
		add(chckbxRatings, vboxData);
		chckbxRatings.addValueChangeHandler(facetHandler);
		cbFacets.put(Facet.FACET_TYPE.RATING, chckbxRatings);

		CheckBox chckbxResources = new CheckBox(
				Facet.FACET_TYPE.RESOURCE.getName());
		add(chckbxResources, vboxData);
		chckbxResources.addValueChangeHandler(facetHandler);
		cbFacets.put(Facet.FACET_TYPE.RESOURCE, chckbxResources);

		CheckBox chckbxFeatures = new CheckBox(
				Facet.FACET_TYPE.FEATURE.getName());
		add(chckbxFeatures, vboxData);
		chckbxFeatures.addValueChangeHandler(facetHandler);
		cbFacets.put(Facet.FACET_TYPE.FEATURE, chckbxFeatures);

		CheckBox chckbxPrincingPolicies = new CheckBox(
				Facet.FACET_TYPE.PRICING_POLICY.getName());
		add(chckbxPrincingPolicies, vboxData);
		chckbxPrincingPolicies.addValueChangeHandler(facetHandler);
		cbFacets.put(Facet.FACET_TYPE.PRICING_POLICY, chckbxPrincingPolicies);
	}
}
