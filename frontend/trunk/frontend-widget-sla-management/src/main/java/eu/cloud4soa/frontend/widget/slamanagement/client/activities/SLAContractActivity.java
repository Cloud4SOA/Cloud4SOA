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

package eu.cloud4soa.frontend.widget.slamanagement.client.activities;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import eu.cloud4soa.frontend.commons.client.Cloud4SOAUIClientFactory;
import eu.cloud4soa.frontend.commons.client.Cloud4SoaActivity;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.sla.SLAContractModel;
import eu.cloud4soa.frontend.commons.client.dialog.DialogHelper;
import eu.cloud4soa.frontend.commons.client.events.SLAContractRequestedEvent;
import eu.cloud4soa.frontend.commons.client.services.soa.GovernanceService;
import eu.cloud4soa.frontend.commons.client.services.soa.GovernanceServiceAsync;
import eu.cloud4soa.frontend.widget.slamanagement.client.views.SLAContractView;

public class SLAContractActivity extends Cloud4SoaActivity implements
		SLAContractView.Presenter, EventHandler {

	// Services
	private GovernanceServiceAsync governanceService = GWT
			.create(GovernanceService.class);

	// View
	private SLAContractView slaContractView;

	public SLAContractActivity(Cloud4SOAUIClientFactory clientFactory,
			String slaContractId) {
		super(null, clientFactory);
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		this.slaContractView = GWT.create(SLAContractView.class);
		this.slaContractView.setPresenter(this);

		containerWidget.setWidget(this.slaContractView.asWidget());
		registerViewDetacher(slaContractView);
	}

	/**
	 * @param event
	 */
	public void onSLAContractRequested(SLAContractRequestedEvent event) {
		governanceService.getSLAContract(event.getSLAContractId(),
				new AsyncCallback<SLAContractModel>() {

					@Override
					public void onFailure(Throwable caught) {
						DialogHelper
								.showErrorDialog("SLA Contract not available. Please, contact site administrator");
						slaContractView.asWidget().setVisible(false);
					}

					@Override
					public void onSuccess(SLAContractModel slaContractModel) {
						slaContractView.asWidget().setVisible(true);
						slaContractView
								.bindSLAContract(slaContractModel);

					}
				});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.cloud4soa.frontend.widget.appdeployed.client.views.gxt.sla.SLAContractView
	 * .Presenter#onCloseSLAContractButtonClick()
	 */
	@Override
	public void onCloseSLAContractButtonClick() {
		// TODO Auto-generated method stub

	}

	
//	private SLAContractModel parseSLAContract(String slaContract) {
//		SLAContractModel sLAContractModel = new SLAContractModel(
//				"SLA Contract", "SLA Contract");
//
//		Document dom = XMLParser.parse(slaContract);
//
//		// Context
//		SLAContractContextModel sLAContractContextModel = new SLAContractContextModel(
//				"SLA Contract Context", "SLA Contract Context");
//		sLAContractContextModel.setAgreementInitiator(dom
//				.getElementsByTagName("AgreementInitiator").item(0)
//				.getFirstChild().getNodeValue());
//		sLAContractContextModel.setServiceProvider(dom
//				.getElementsByTagName("ServiceProvider").item(0)
//				.getFirstChild().getNodeValue());
//		sLAContractContextModel.setExpirationTime(dom
//				.getElementsByTagName("ExpirationTime").item(0).getFirstChild()
//				.getNodeValue());
//		sLAContractModel.setContext(sLAContractContextModel);
//
//		// Service
//		SLAContractServiceModel sLAContractServiceModel = new SLAContractServiceModel(
//				"SLA Contract Service", "SLA Contract Service");
//		Node sdt = dom.getElementsByTagName("ServiceDescriptionTerm").item(0);
//		sLAContractServiceModel.setServiceName(((Element) sdt)
//				.getAttribute("wsag:ServiceName"));
//		sLAContractModel.setService(sLAContractServiceModel);
//
//		// Guarantee Terms
//		List<SLAContractGuaranteeTermModel> gts = sLAContractModel
//				.getGuaranteeTerms();
//
//		NodeList gtNodes = dom.getElementsByTagName("GuaranteeTerm");
//		Node node;
//		for (int i = 0; i < gtNodes.getLength(); i++) {
//			Element gtNode = (Element) gtNodes.item(i);
//
//			SLAContractGuaranteeTermModel gt = new SLAContractGuaranteeTermModel(
//					"Guarantee Term", (gtNode).getAttribute("wsag:Name"));
//
//			// Service Level Objectives
//			SLAContractGuaranteeTermSLOModel slo = new SLAContractGuaranteeTermSLOModel(
//					"SLO", "Service Level Objectives");
//			slo.setGuaranteeTermName((gtNode).getAttribute("wsag:Name"));
//
//			node = gtNode.getElementsByTagName("KPIName").item(0);
//			slo.setKPIName(node != null ? node.getFirstChild().getNodeValue()
//					: "");
//			node = gtNode.getElementsByTagName("CustomServiceLevel").item(0);
//			slo.setCustomServiceLevel(node != null ? node.getFirstChild()
//					.getNodeValue() : "");
//			gt.setServiceLevelObjectives(slo);
//
//			// Business Level Objectives
//			SLAContractGuaranteeTermBLOModel blo = new SLAContractGuaranteeTermBLOModel(
//					"BLO", "Business Level Objectives");
//
//			Element penaltyNode = (Element) gtNode.getElementsByTagName(
//					"Penalty").item(0);
//
//			node = penaltyNode.getElementsByTagName("TimeInterval").item(0);
//			blo.setPenaltyAssessmentInterval(node != null ? node
//					.getFirstChild().getNodeValue() : "");
//			node = penaltyNode.getElementsByTagName("ValueUnit").item(0);
//			blo.setPenaltyValueUnit(node != null ? node.getFirstChild()
//					.getNodeValue() : "");
//			node = penaltyNode.getElementsByTagName("ValueExpression").item(0);
//			blo.setPenaltyValueExpression(node != null ? node.getFirstChild()
//					.getNodeValue() : "");
//
//			Element rewardNode = (Element) gtNode
//					.getElementsByTagName("Reward").item(0);
//
//			node = rewardNode.getElementsByTagName("TimeInterval").item(0);
//			blo.setRewardAssessmentInterval(node != null ? node.getFirstChild()
//					.getNodeValue() : "");
//			node = rewardNode.getElementsByTagName("ValueUnit").item(0);
//			blo.setRewardValueUnit(node != null ? node.getFirstChild()
//					.getNodeValue() : "");
//			node = rewardNode.getElementsByTagName("ValueExpression").item(0);
//			blo.setRewardValueExpression(node != null ? node.getFirstChild()
//					.getNodeValue() : "");
//
//			gt.setBusinessLevelObjectives(blo);
//
//			gts.add(gt);
//		}
//
//		return sLAContractModel;
//	}

}
