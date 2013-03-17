package gwt.html5.video.client.events;

import com.google.gwt.event.shared.GwtEvent;

import gwt.html5.video.client.handlers.VideoWaitingHandler;

/**
 * Playback has stopped because the next frame is not available, but the user agent expects that frame to become
 * available in due course.
 * 
 * @author michael.guiral
 * 
 */
public class VideoWaitingEvent extends GwtEvent<VideoWaitingHandler> {
    private static final Type<VideoWaitingHandler> TYPE = new Type<VideoWaitingHandler>();

    public static Type<VideoWaitingHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(VideoWaitingHandler handler) {
        handler.onWaiting(this);
    }

    @Override
    public Type<VideoWaitingHandler> getAssociatedType() {
        return TYPE;
    }
}
