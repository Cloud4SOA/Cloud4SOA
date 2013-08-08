/*
 * This file is part of Cloud4SOA Frontend.
 *
 *     Cloud4SOA Frontend is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cloud4SOA Frontend is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cloud4SOA Frontend.  If not, see <http://www.gnu.org/licenses/>.
 */

package eu.cloud4soa.frontend.widget.search.client.views.gxt;

import java.util.Date;
import java.util.List;

import com.extjs.gxt.ui.client.Style.ButtonScale;
import com.extjs.gxt.ui.client.Style.IconAlign;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.Events;
import com.extjs.gxt.ui.client.event.Listener;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.TabItem;
import com.extjs.gxt.ui.client.widget.TabPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateContextModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateGuaranteeTermBLOModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateGuaranteeTermModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateGuaranteeTermSLOModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateModel;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLATemplateServiceModel;
import eu.cloud4soa.frontend.commons.client.resources.Icons;
import eu.cloud4soa.frontend.widget.search.client.views.PaaSOfferingDetailsView;
import eu.cloud4soa.frontend.widget.slamanagement.client.views.SLATemplateView;
import eu.cloud4soa.frontend.widget.slamanagement.client.views.SLATemplateViewGxtImpl;
import eu.cloud4soa.frontend.widget.usermanagement.client.views.OfferEditorROView;
import eu.cloud4soa.frontend.widget.usermanagement.client.views.OfferEditorROViewGxtImpl;

public class PaaSOfferingDetailsGXTView extends ContentPanel implements
		PaaSOfferingDetailsView {

	private TabPanel tabPanel;
	private TabItem tIPaaSOffer;
	private TabItem tISLATemplate;
	private OfferEditorROView paaSOfferView;
	private SLATemplateView sLATemplateView;
	private Presenter presenter;

	public PaaSOfferingDetailsGXTView() {
		createView();
	}

	void createView() {
		setLayout(new FitLayout());
		setHeaderVisible(false);
		setBorders(false);
		addStyleName("c4s-white-bg");

		ToolBar toolBar = new ToolBar();
		toolBar.addStyleName("c4s-white-bg");
		setTopComponent(toolBar);

		Button btBack = new Button("Back");
		btBack.setScale(ButtonScale.LARGE);
		btBack.setIconAlign(IconAlign.BOTTOM);
		btBack.setIcon(AbstractImagePrototype.create(Icons.RESOURCES
				.buttonRewind()));
		btBack.setToolTip("Back to previous view");
		toolBar.add(btBack);
		toolBar.add(new FillToolItem());

		btBack.addListener(Events.Select, new SelectionListener<ButtonEvent>() {
			@Override
			public void componentSelected(ButtonEvent ce) {
				presenter.onCloseButtonClick();
			}
		});

		tabPanel = new TabPanel();
		tabPanel.setBorders(true);

		tIPaaSOffer = new TabItem("PaaS Offer");
		tIPaaSOffer.setLayout(new FitLayout());
		tIPaaSOffer.setLayoutOnChange(true);
		tIPaaSOffer.addListener(Events.Select, new Listener<ComponentEvent>() {
			@Override
			public void handleEvent(ComponentEvent be) {
				layout();
			}
		});
		paaSOfferView = new OfferEditorROViewGxtImpl();
		tIPaaSOffer.add(paaSOfferView.asWidget());
		// tIPaaSOffer.setHeight(210);
		tIPaaSOffer.setBorders(true);
		tabPanel.add(tIPaaSOffer);

		tISLATemplate = new TabItem("SLA Template");
		tISLATemplate.setLayoutOnChange(true);
		tISLATemplate.setLayout(new FitLayout());
		tISLATemplate.addListener(Events.Select,
				new Listener<ComponentEvent>() {
					@Override
					public void handleEvent(ComponentEvent be) {
						layout();
					}
				});
		sLATemplateView = new SLATemplateViewGxtImpl();
		tISLATemplate.add(sLATemplateView.asWidget());
		// tISLATemplate.setHeight(210);
		tISLATemplate.setBorders(true);
		tabPanel.add(tISLATemplate);

		add(tabPanel);
	}

	@Override
	public void showPaaSOfferingDetails(PaaSOfferingModel paaSOfferingModel) {
		if (paaSOfferingModel == null)
			return;
		paaSOfferView.bindPaaSOffering(paaSOfferingModel);
		// SLATemplateModel sLATemplateModel = createHackSLATemplateModel();
		if (paaSOfferingModel.getSLATemplate() != null) // SLATemplate no
														// generated in
														// Catalogue Browsing
														// sLATemplateView.bindSLATemplate(parseSLATemplate(paaSOfferingModel
		// .getSLATemplate()));

			sLATemplateView.bindSLATemplate(paaSOfferingModel.getSLATemplate());
	}

	private SLATemplateModel parseSLATemplate(String slaTemplate) {
		SLATemplateModel sLATemplateModel = new SLATemplateModel(
				"SLA Template", "SLA Template");

		Document dom = XMLParser.parse(slaTemplate);

		// Context
		SLATemplateContextModel sLATemplateContextModel = new SLATemplateContextModel(
				"SLA Template Context", "SLA Template Context");
		sLATemplateContextModel.setAgreementInitiator(dom
				.getElementsByTagName("AgreementInitiator").item(0)
				.getFirstChild().getNodeValue());
		sLATemplateContextModel.setServiceProvider(dom
				.getElementsByTagName("ServiceProvider").item(0)
				.getFirstChild().getNodeValue());
		sLATemplateContextModel.setExpirationTime(dom
				.getElementsByTagName("ExpirationTime").item(0).getFirstChild()
				.getNodeValue());
		sLATemplateModel.setContext(sLATemplateContextModel);

		// Service
		SLATemplateServiceModel sLATemplateServiceModel = new SLATemplateServiceModel(
				"SLA Template Service", "SLA Template Service");
		Node sdt = dom.getElementsByTagName("ServiceDescriptionTerm").item(0);
		sLATemplateServiceModel.setServiceName(((Element) sdt)
				.getAttribute("wsag:ServiceName"));
		sLATemplateModel.setService(sLATemplateServiceModel);

		// Guarantee Terms
		List<SLATemplateGuaranteeTermModel> gts = sLATemplateModel
				.getGuaranteeTerms();

		NodeList gtNodes = dom.getElementsByTagName("GuaranteeTerm");
		Node node;
		for (int i = 0; i < gtNodes.getLength(); i++) {
			Element gtNode = (Element) gtNodes.item(i);

			SLATemplateGuaranteeTermModel gt = new SLATemplateGuaranteeTermModel(
					"Guarantee Term", (gtNode).getAttribute("wsag:Name"));

			// Service Level Objectives
			SLATemplateGuaranteeTermSLOModel slo = new SLATemplateGuaranteeTermSLOModel(
					"SLO", "Service Level Objectives");
			slo.setGuaranteeTermName((gtNode).getAttribute("wsag:Name"));

			node = gtNode.getElementsByTagName("KPIName").item(0);
			slo.setKPIName(node != null ? node.getFirstChild().getNodeValue()
					: "");
			node = gtNode.getElementsByTagName("CustomServiceLevel").item(0);
			slo.setCustomServiceLevel(node != null ? node.getFirstChild()
					.getNodeValue() : "");
			gt.setServiceLevelObjectives(slo);

			// Business Level Objectives
			SLATemplateGuaranteeTermBLOModel blo = new SLATemplateGuaranteeTermBLOModel(
					"BLO", "Business Level Objectives");

			Element penaltyNode = (Element) gtNode.getElementsByTagName(
					"Penalty").item(0);

			node = penaltyNode.getElementsByTagName("TimeInterval").item(0);
			blo.setPenaltyAssessmentInterval(node != null ? node
					.getFirstChild().getNodeValue() : "");
			node = penaltyNode.getElementsByTagName("ValueUnit").item(0);
			blo.setPenaltyValueUnit(node != null ? node.getFirstChild()
					.getNodeValue() : "");
			node = penaltyNode.getElementsByTagName("ValueExpression").item(0);
			blo.setPenaltyValueExpression(node != null ? node.getFirstChild()
					.getNodeValue() : "");

			Element rewardNode = (Element) gtNode
					.getElementsByTagName("Reward").item(0);

			node = rewardNode.getElementsByTagName("TimeInterval").item(0);
			blo.setRewardAssessmentInterval(node != null ? node.getFirstChild()
					.getNodeValue() : "");
			node = rewardNode.getElementsByTagName("ValueUnit").item(0);
			blo.setRewardValueUnit(node != null ? node.getFirstChild()
					.getNodeValue() : "");
			node = rewardNode.getElementsByTagName("ValueExpression").item(0);
			blo.setRewardValueExpression(node != null ? node.getFirstChild()
					.getNodeValue() : "");

			gt.setBusinessLevelObjectives(blo);

			gts.add(gt);
		}

		return sLATemplateModel;
	}

	// /**
	// * Retrieves a child node by tag
	// * @param node
	// * @param tag
	// * @return
	// */
	// private Node getElementByTagFrom (Element parent, String tag){
	// Node match = null;
	// NodeList children = parent.getChildNodes();
	// for (int i=0; i< children.getLength(); i++){
	// Element child = (Element) children.item(i);
	// if (child.get.equals(tag)){
	// match = child;
	// break;
	// }
	// }
	//
	// return match;
	// }

	private SLATemplateModel createHackSLATemplateModel() {
		SLATemplateModel sLATemplateModel = new SLATemplateModel(
				"SLA Template", "SLA Template");

		SLATemplateContextModel sLATemplateContextModel = new SLATemplateContextModel(
				"SLA Template Context", "SLA Template Context");
		sLATemplateContextModel.setAgreementInitiator("User");
		sLATemplateContextModel.setServiceProvider("PaaS Provider");
		sLATemplateContextModel.setExpirationTime(new Date().toString());
		sLATemplateModel.setContext(sLATemplateContextModel);

		SLATemplateServiceModel sLATemplateServiceModel = new SLATemplateServiceModel(
				"SLA Template Service", "SLA Template Service");
		sLATemplateServiceModel.setServiceName("UserService1");
		sLATemplateModel.setService(sLATemplateServiceModel);

		List<SLATemplateGuaranteeTermModel> gts = sLATemplateModel
				.getGuaranteeTerms();

		SLATemplateGuaranteeTermModel gt1 = new SLATemplateGuaranteeTermModel(
				"Guarantee Term", "LATENCY_GUARANTEE");

		SLATemplateGuaranteeTermSLOModel slo1 = new SLATemplateGuaranteeTermSLOModel(
				"SLO", "Service Level Objectives");
		slo1.setGuaranteeTermName("LATENCY_GUARANTEE");
		slo1.setKPIName("LATENCY");
		slo1.setCustomServiceLevel("LATENCY &lt;=100ms");
		gt1.setServiceLevelObjectives(slo1);

		SLATemplateGuaranteeTermBLOModel blo1 = new SLATemplateGuaranteeTermBLOModel(
				"BLO", "Business Level Objectives");
		blo1.setPenaltyAssessmentInterval("Weekly");
		blo1.setPenaltyValueUnit("EUR");
		blo1.setPenaltyValueExpression("5");
		blo1.setRewardAssessmentInterval("Weekly");
		blo1.setRewardValueUnit("EUR");
		blo1.setRewardValueExpression("10");
		gt1.setBusinessLevelObjectives(blo1);

		gts.add(gt1);

		SLATemplateGuaranteeTermModel gt2 = new SLATemplateGuaranteeTermModel(
				"Guarantee Term", "UPTIME_GUARANTEE");

		SLATemplateGuaranteeTermSLOModel slo2 = new SLATemplateGuaranteeTermSLOModel(
				"SLO", "Service Level Objectives");
		slo2.setGuaranteeTermName("UPTIME_GUARANTEE");
		slo2.setKPIName("UPTIME");
		slo2.setCustomServiceLevel("UPTIME &lt;=99,9");
		gt2.setServiceLevelObjectives(slo2);

		SLATemplateGuaranteeTermBLOModel blo2 = new SLATemplateGuaranteeTermBLOModel(
				"BLO", "Business Level Objectives");
		blo2.setPenaltyAssessmentInterval("Weekly");
		blo2.setPenaltyValueUnit("EUR");
		blo2.setPenaltyValueExpression("5");
		blo2.setRewardAssessmentInterval("Weekly");
		blo2.setRewardValueUnit("EUR");
		blo2.setRewardValueExpression("10");
		gt2.setBusinessLevelObjectives(blo2);

		gts.add(gt2);

		return sLATemplateModel;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public Presenter getPresenter() {
		return presenter;
	}

}
