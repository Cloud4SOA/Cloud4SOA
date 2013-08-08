package eu.cloud4soa.frontend.widget.search.client.events;


import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.EventHandler;

import eu.cloud4soa.frontend.widget.search.client.data.Facet;


public class SelectedFacetChangedEvent extends GwtEvent<SelectedFacetChangedEvent.Handler> {

	private Facet.FACET_TYPE facet_type;
	private boolean selected;
	
	public Facet.FACET_TYPE getFacet_type() {
		return facet_type;
	}

	public boolean isSelected() {
		return selected;
	}
	
	public SelectedFacetChangedEvent (Facet.FACET_TYPE facet_type, boolean selected){
		this.facet_type = facet_type;
		this.selected = selected;
	}

	public interface Handler extends EventHandler
    {
        void onSelectedFacetChanged(SelectedFacetChangedEvent event);
    }

    public static Type<Handler> TYPE = new Type<Handler>();
	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<Handler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(Handler handler) {
		handler.onSelectedFacetChanged(this);
	}

}
