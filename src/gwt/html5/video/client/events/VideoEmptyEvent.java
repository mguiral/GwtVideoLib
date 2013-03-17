package gwt.html5.video.client.events;

import com.google.gwt.event.shared.GwtEvent;

import gwt.html5.video.client.handlers.VideoEmptyHandler;

/**
 * The media element has not yet been initialized. All attributes are in their initial states.
 * 
 * @author michael.guiral
 * 
 */
public class VideoEmptyEvent extends GwtEvent<VideoEmptyHandler> {
    private static final Type<VideoEmptyHandler> TYPE = new Type<VideoEmptyHandler>();

    public static Type<VideoEmptyHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(VideoEmptyHandler handler) {
        handler.onEmptyState(this);
    }

    @Override
    public Type<VideoEmptyHandler> getAssociatedType() {
        return TYPE;
    }
}
