package gwt.html5.video.client.events;

import com.google.gwt.event.shared.GwtEvent;

import gwt.html5.video.client.handlers.VideoSeekedHandler;

/**
 * The seeking attribute changed to false.
 * 
 * @author michael.guiral
 * 
 */
public class VideoSeekedEvent extends GwtEvent<VideoSeekedHandler> {
    private static final Type<VideoSeekedHandler> TYPE = new Type<VideoSeekedHandler>();

    public static Type<VideoSeekedHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(VideoSeekedHandler handler) {
        handler.onSeeked(this);
    }

    @Override
    public Type<VideoSeekedHandler> getAssociatedType() {
        return TYPE;
    }
}
