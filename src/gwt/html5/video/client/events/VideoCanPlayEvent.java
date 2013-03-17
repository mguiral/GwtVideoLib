package gwt.html5.video.client.events;

import com.google.gwt.event.shared.GwtEvent;

import gwt.html5.video.client.handlers.VideoCanPlayHandler;

/**
 * The user agent can resume playback of the media data, but estimates that if playback were to be started now, the
 * media resource could not be rendered at the current playback rate up to its end without having to stop for further
 * buffering of content.
 * 
 * @author michael.guiral
 * 
 */
public class VideoCanPlayEvent extends GwtEvent<VideoCanPlayHandler> {
    private static final Type<VideoCanPlayHandler> TYPE = new Type<VideoCanPlayHandler>();

    public static Type<VideoCanPlayHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(VideoCanPlayHandler handler) {
        handler.onCanPlay(this);
    }

    @Override
    public Type<VideoCanPlayHandler> getAssociatedType() {
        return TYPE;
    }
}
