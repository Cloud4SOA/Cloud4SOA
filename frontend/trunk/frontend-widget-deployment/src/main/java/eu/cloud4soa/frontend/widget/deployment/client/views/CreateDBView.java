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

package eu.cloud4soa.frontend.widget.deployment.client.views;

import com.google.gwt.user.client.ui.IsWidget;

import eu.cloud4soa.frontend.commons.client.Cloud4SoaPresenter;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.application.SoftwareComponentModel;

/**
 * Contract of the Create DB view.
 * 
 * @author Yosu Gorroñogoitia (Atos)
 */
public interface CreateDBView extends IsWidget {

	void submitDBInitializationFiles();

	void setPresenter(Presenter presenter);

	void bindDBForm(SoftwareComponentModel applicationModel);

	boolean isInitializationRequested();

	public interface Presenter extends Cloud4SoaPresenter {
		void onDBCreationClick();
		void onCancelDBCreationClick();
		void onDBCreationUploadComplete();
	}

}
