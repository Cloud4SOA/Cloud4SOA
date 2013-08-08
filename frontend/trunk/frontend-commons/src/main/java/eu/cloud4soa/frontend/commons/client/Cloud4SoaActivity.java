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

package eu.cloud4soa.frontend.commons.client;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.gwt.ss.client.exceptions.GwtSecurityException;
import eu.cloud4soa.frontend.commons.client.events.RPCFailureOccurredEvent;
import eu.cloud4soa.frontend.commons.client.places.LoginPlace;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An abstract Cloud4SOA frontend activity.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public abstract class Cloud4SoaActivity extends AbstractActivity implements
        Cloud4SoaPresenter, Disposable {


    public enum Cloud4SoaActivityTimer {
        DeployedApplications, Monitoring
    }

    protected abstract class ActivityCallback<T> implements AsyncCallback<T> {
        @Override
        public final void onFailure(Throwable caught) {
            handleRPCFailure(caught);
        }
    }


    protected Cloud4SOAUIClientFactory clientFactory;

    protected Place place;

    private Set<HandlerRegistration> handlerRegistrations = new HashSet<HandlerRegistration>();

    protected Cloud4SoaActivity(Place place, Cloud4SOAUIClientFactory clientFactory) {
        this.place = place;
        this.clientFactory = clientFactory;
    }

    protected Cloud4SoaActivity() {
    }

    protected void handleRPCFailure(Throwable caught) {

        if (caught instanceof GwtSecurityException) {
            goTo(new LoginPlace(Strings.EMPTY));
        } else {
            clientFactory.getEventBus().fireEvent(new RPCFailureOccurredEvent(caught));
        }
    }

    protected void handleRPCFailure(String message, Throwable caught) {
        final Logger logger = Logger.getLogger(this.getClass().getName());
        logger.log(Level.SEVERE, message, caught);
        clientFactory.getEventBus().fireEvent(
                new RPCFailureOccurredEvent(caught));
    }

    public Cloud4SOAUIClientFactory getClientFactory() {
        return this.clientFactory;
    }

    @Override
    public final void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }

    /**
     * Add an event handler to the event bus. Handler will be removed on view
     * detaching.
     *
     * @param type    The type of the event
     * @param handler The handler
     */
    protected <H extends EventHandler> void addHandler(GwtEvent.Type<H> type,
                                                       H handler) {
        handlerRegistrations.add(clientFactory.getEventBus().addHandler(type,
                handler));
    }

    protected void registerViewDetacher(IsWidget view) {
        handlerRegistrations.add(view.asWidget().addAttachHandler(
                new AttachEvent.Handler() {
                    @Override
                    public void onAttachOrDetach(AttachEvent event) {
                        if (!event.isAttached())
                            // on view detaching remove all event handlers.
                            removeHandlers();

                        // Dispose resources in the activity
                        dispose();
                    }
                }));
    }

    private void removeHandlers() {
        for (HandlerRegistration handlerRegistration : handlerRegistrations)
            handlerRegistration.removeHandler();
    }

    /*
      * (non-Javadoc)
      *
      * @see eu.cloud4soa.frontend.commons.client.Disposable#dispose() Override
      * this method to release resources allocated by this activity, when the
      * place associated to this activity changes and the activity should be
      * disposed of.
      */
    @Override
    public void dispose() {
        // Empty implementation. Should be override by subclasses, if required
    }
}
