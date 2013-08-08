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

/**
 * This event requests the main activity to expand or collapse the left pane.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class MainViewWestExpandEvent extends GwtEvent<MainViewWestExpandEvent.Handler> {

    public interface Handler extends EventHandler {
        void onMainViewWestExpandRequest(MainViewWestExpandEvent event);
    }

    public static Type<Handler> TYPE = new Type<Handler>();

    private boolean expand;

    public MainViewWestExpandEvent(boolean expand) {
        this.expand = expand;
    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onMainViewWestExpandRequest(this);
    }

    @Override
    public Type<Handler> getAssociatedType() {
        return TYPE;
    }

    public boolean isExpand() {
        return expand;
    }
}
