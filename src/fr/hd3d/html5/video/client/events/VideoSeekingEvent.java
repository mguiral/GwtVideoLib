package fr.hd3d.html5.video.client.events;

import com.google.gwt.event.shared.GwtEvent;

import fr.hd3d.html5.video.client.handlers.VideoSeekingHandler;

/**
 * The seeking attribute changed to true and the seek operation is taking long enough that the user agent has time to
 * fire the event.
 * 
 * @author michael.guiral
 * 
 */
public class VideoSeekingEvent extends GwtEvent<VideoSeekingHandler> {
    private static final Type<VideoSeekingHandler> TYPE = new Type<VideoSeekingHandler>();

    public static Type<VideoSeekingHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(VideoSeekingHandler handler) {
        handler.onSeeking(this);
    }

    @Override
    public Type<VideoSeekingHandler> getAssociatedType() {
        return TYPE;
    }
}
