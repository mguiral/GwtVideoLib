package gwt.html5.video.client.events;

import com.google.gwt.event.shared.GwtEvent;

import gwt.html5.video.client.handlers.VideoSuspendHandler;

/**
 * The user agent is intentionally not currently fetching media data, but does not have the entire media resource
 * downloaded.
 * 
 * @author michael.guiral
 * 
 */
public class VideoSuspendEvent extends GwtEvent<VideoSuspendHandler> {
    private static final Type<VideoSuspendHandler> TYPE = new Type<VideoSuspendHandler>();

    public static Type<VideoSuspendHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(VideoSuspendHandler handler) {
        handler.onSuspend(this);
    }

    @Override
    public Type<VideoSuspendHandler> getAssociatedType() {
        return TYPE;
    }
}
