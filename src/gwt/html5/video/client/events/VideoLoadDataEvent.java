package gwt.html5.video.client.events;

import com.google.gwt.event.shared.GwtEvent;

import gwt.html5.video.client.handlers.VideoLoadDataHandler;

/**
 * The user agent can render the media data at the current playback position for the first time.
 * 
 * @author michael.guiral
 * 
 */
public class VideoLoadDataEvent extends GwtEvent<VideoLoadDataHandler> {
    private static final Type<VideoLoadDataHandler> TYPE = new Type<VideoLoadDataHandler>();

    public static Type<VideoLoadDataHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(VideoLoadDataHandler handler) {
        handler.onDataLoaded(this);
    }

    @Override
    public Type<VideoLoadDataHandler> getAssociatedType() {
        return TYPE;
    }
}
