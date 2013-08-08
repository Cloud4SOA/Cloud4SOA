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

package eu.cloud4soa.frontend.commons.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import eu.cloud4soa.frontend.commons.client.datamodel.frontend.paas.PaaSOfferingModel;

/**
 * This event notifies that a request to show the full details of a paas offers was issued.
 * <p/>
 * todo check if it's still applicable
 *
 * @author Yosu Gorroñogoitia
 * @since 13/10/11 21.54
 */
public class PaaSOfferingDetailsRequestedEvent extends GwtEvent<PaaSOfferingDetailsRequestedEvent.Handler> {
    public interface Handler extends EventHandler {
        void onPaaSOfferingDetailsRequested(PaaSOfferingDetailsRequestedEvent event);
    }

    public static Type<Handler> TYPE = new Type<Handler>();

    private PaaSOfferingModel paasOffering;

    public PaaSOfferingDetailsRequestedEvent(PaaSOfferingModel content) {
        this.paasOffering = content;
    }

    public PaaSOfferingModel getPaaSOffering() {
        return paasOffering;
    }

    @Override
    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onPaaSOfferingDetailsRequested(this);
    }

}
