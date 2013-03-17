package gwt.html5.video.client.events;

import com.google.gwt.event.shared.GwtEvent;

import gwt.html5.video.client.handlers.VideoPlayHandler;

/**
 * Playback has begun. Fired after the play() method has returned, or when the autoplay attribute has caused playback to
 * begin
 * 
 * @author michael.guiral
 * 
 */
public class VideoPlayEvent extends GwtEvent<VideoPlayHandler> {
    private static final Type<VideoPlayHandler> TYPE = new Type<VideoPlayHandler>();

    public static Type<VideoPlayHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(VideoPlayHandler handler) {
        handler.onPlay(this);
    }

    @Override
    public Type<VideoPlayHandler> getAssociatedType() {
        return TYPE;
    }
}
