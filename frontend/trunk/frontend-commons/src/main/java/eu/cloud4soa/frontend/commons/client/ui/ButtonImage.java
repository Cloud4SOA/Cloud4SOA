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

package eu.cloud4soa.frontend.commons.client.ui;

import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;

/**
 * An image that behaves as a button.
 *
 * @author Stefano Travelli (Cyntelix)
 */
public class ButtonImage extends Image {

    private ImageResource imageNormal;
    private ImageResource imageSelected;
    private ImageResource imageOver;
    private String title;

    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
        super.setTitle(title);
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        updateResource();
    }

    private void updateResource() {
        if (selected)
            setResource(imageSelected);
        else
            setResource(imageNormal);

        // set the title again, since it get lost after changing the resource.
        setTitle(title);
    }

    /**
     * Set the image to be shown.
     *
     * @param resource the image resource
     */
    public void setImageNormal(ImageResource resource) {
        this.imageNormal = resource;
        this.updateResource();
    }

    /**
     * Set the image to be shown when the item is selected.
     *
     * @param resource the image resource
     */
    public void setImageSelected(ImageResource resource) {
        this.imageSelected = resource;
        this.updateResource();
    }

    /**
     * Set the image to be shown when the mouse is over the button.
     *
     * @param resource the image resource
     */
    public void setImageOver(ImageResource resource) {
        this.imageOver = resource;
    }

    public ButtonImage() {
        addDomHandler(new MouseOverHandler() {
            @Override
            public void onMouseOver(MouseOverEvent event) {
                if (!selected)
                    setResource(imageOver);
            }
        }, MouseOverEvent.getType());

        addDomHandler(new MouseOutHandler() {
            @Override
            public void onMouseOut(MouseOutEvent event) {
                if (!selected)
                    setResource(imageNormal);
            }
        }, MouseOutEvent.getType());

    }
}
