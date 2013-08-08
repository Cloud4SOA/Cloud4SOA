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

package eu.cloud4soa.frontend.commons.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * Icons at 64x64
 *
 * @author Stefano Travelli (Cyntelix)
 */
public interface BigIcons extends ClientBundle {

    public static final BigIcons RESOURCES = GWT.create(BigIcons.class);



    @Source("application.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource application();

    @Source("button-add.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonAdd();

    @Source("button-begin.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonBegin();

    @Source("button-check.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonCheck();

    @Source("button-cross.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonCross();

    @Source("button-eject.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonEject();

    @Source("button-end.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonEnd();

    @Source("button-ff.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonFastForward();

    @Source("button-pause.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonPause();

    @Source("button-play.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonPlay();

    @Source("button-power.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonPower();

    @Source("button-remove.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonRemove();

    @Source("button-rew.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonRewind();

    @Source("button-rotate-ccw.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonRotateCcw();

    @Source("button-rotate-cw.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonRotateCw();

    @Source("button-shuffle.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonShuffle();

    @Source("button-stop.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonStop();

    @Source("button-synchronize.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource buttonSynchronize();

    @Source("hard-drive-upload.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource hardDriveUpload();

    @Source("home.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource home();

    @Source("magic-wand.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource magicWand();

    @Source("oscilloscope.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource oscilloscope();

    @Source("weather-clouds.png")
    @ImageResource.ImageOptions(height = 64, width = 64)
    ImageResource weatherClouds();


}
