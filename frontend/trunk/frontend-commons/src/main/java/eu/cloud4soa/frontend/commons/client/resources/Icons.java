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
 * Provide various icons for the UI.
 * 
 * @author Yosu Gorroñogoitia (ATOS)
 * @author Stefano Travelli (Cyntelix)
 */
public interface Icons extends ClientBundle {

	public static final Icons RESOURCES = GWT.create(Icons.class);

	@Source("back.png")
	ImageResource back();

	@Source("application.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource application();

	@Source("button-add.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonAdd();

	@Source("button-begin.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonBegin();

	@Source("button-check.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonCheck();

	@Source("button-cross.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonCross();

	@Source("button-eject.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonEject();

	@Source("button-end.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonEnd();

	@Source("button-ff.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonFastForward();

	@Source("button-pause.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonPause();

	@Source("button-play.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonPlay();

	@Source("button-power.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonPower();

	@Source("button-remove.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonRemove();

	@Source("button-rew.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonRewind();

	@Source("button-rotate-ccw.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonRotateCcw();

	@Source("button-rotate-cw.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonRotateCw();

	@Source("button-shuffle.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonShuffle();

	@Source("button-stop.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonStop();

	@Source("button-synchronize.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonSynchronize();

	@Source("document-edit.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource documentEdit();

	// this is the same image as "more details" at the moment
	@Source("search.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonSearch();

	@Source("hard-drive-upload.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource hardDriveUpload();

	@Source("home.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource home();

	@Source("magic-wand.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource magicWand();

	@Source("oscilloscope.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource oscilloscope();

	@Source("weather-clouds.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource weatherClouds();

	@Source("oscilloscope.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource buttonOscilloscope();

	@Source("search.png")
	@ImageResource.ImageOptions(height = 24, width = 24)
	ImageResource moreDetails();

	@Source("exclamation-circle.png")
	@ImageResource.ImageOptions(height = 24, width = 24)
	ImageResource exclamationCircle();

	@Source("briefcase.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource slaContract();

	@Source("alarm-clock.png")
	@ImageResource.ImageOptions(height = 32, width = 32)
	ImageResource slaViolation();

}
