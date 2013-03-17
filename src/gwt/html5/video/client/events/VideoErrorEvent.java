package gwt.html5.video.client.events;

import com.google.gwt.event.shared.GwtEvent;

import gwt.html5.video.client.handlers.VideoErrorHandler;

/**
 * An error occurs while fetching the media data.
 * 
 * @author michael.guiral
 * 
 */
public class VideoErrorEvent extends GwtEvent<VideoErrorHandler> {
    private static final Type<VideoErrorHandler> TYPE = new Type<VideoErrorHandler>();

    public static Type<VideoErrorHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(VideoErrorHandler handler) {
        handler.onError(this);
    }

    @Override
    public Type<VideoErrorHandler> getAssociatedType() {
        return TYPE;
    }
}
