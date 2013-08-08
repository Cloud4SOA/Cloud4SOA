package eu.cloud4soa.frontend.widget.deployment.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * Manual instructions to be shown when Cloud4SOA cannot manage deployment.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ManualInstructionsView extends Composite {

    private static ManualInstructionsViewUiBinder binder = GWT.create(ManualInstructionsView.class);

    interface ManualInstructionsViewUiBinder extends UiBinder<HTMLPanel, ManualInstructionsView> {
    }

    public ManualInstructionsView() {
        initWidget(binder.createAndBindUi(this));
    }


}
