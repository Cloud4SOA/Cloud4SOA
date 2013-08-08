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

import java.util.List;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.CardPanel;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.RowData;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;

import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;
import eu.cloud4soa.frontend.widget.search.client.views.PaaSOfferingDetailsView;
import eu.cloud4soa.frontend.widget.search.client.views.SearchResultsView;

public class SearchResultGXTViewImpl extends ContentPanel implements
		SearchResultsView, PaaSOfferingDetailsView.Presenter {
	private Presenter presenter;
	private CardPanel cardPanel;
	private SearchResultGrid grid;
	private PaaSOfferingDetailsView details;
	private LayoutContainer detailsContainer;
	private LayoutContainer resultsContainer;

	public SearchResultGXTViewImpl() {
		createView();
	}

	public void showPaaSOfferingDetailsView() {
		setHeading("PaaS Offers Details");
		cardPanel.setActiveItem(detailsContainer);
	}

	public void showPaaSOfferingResultsView() {
		setHeading("Matchings PaaS Offers");
		cardPanel.setActiveItem(resultsContainer);
	}

	private void createView() {
		setLayout(new FitLayout());
		setHeading("Matching PaaS Offers");
		addStyleName("c4s-white-bg");

		cardPanel = new CardPanel();
		cardPanel.setBorders(false);

		resultsContainer = new LayoutContainer();
		resultsContainer.setLayout(new RowLayout(Orientation.HORIZONTAL));
		cardPanel.add(resultsContainer);
		resultsContainer.setBorders(true);

		grid = new SearchResultGrid(this);

		resultsContainer.add(grid, new RowData(1, 1, new Margins(0)));

		detailsContainer = new LayoutContainer();
		detailsContainer.setLayout(new RowLayout(Orientation.HORIZONTAL));
		cardPanel.add(detailsContainer);
		detailsContainer.setBorders(true);

		details = new PaaSOfferingDetailsGXTView();
		details.setPresenter(this);
		detailsContainer.add((LayoutContainer) details, new RowData(1, 1,
				new Margins(0)));

		cardPanel.setActiveItem(resultsContainer);

		add(cardPanel);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void setPaaSOfferingResults(List<PaaSOfferingModel> offerings) {
		grid.setPaaSOfferingResults(offerings);
	}

	@Override
	public void showResultsContainer(boolean show) {
		// TODO Auto-generated method stub

	}

	@Override
	public Presenter getPresenter() {
		return presenter;
	}

	@Override
	public void showPaaSOfferingDetails(PaaSOfferingModel paaSOffering) {
		details.showPaaSOfferingDetails(paaSOffering);
	}

	@Override
	public void onCloseButtonClick() {
		showPaaSOfferingResultsView();
	}

}
