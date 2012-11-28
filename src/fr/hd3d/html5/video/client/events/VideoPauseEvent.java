package fr.hd3d.html5.video.client.events;

import com.google.gwt.event.shared.GwtEvent;

import fr.hd3d.html5.video.client.handlers.VideoPauseHandler;

/**
 * Playback has been paused. Fired after the pause() method has returned.
 * 
 * @author michael.guiral
 * 
 */
public class VideoPauseEvent extends GwtEvent<VideoPauseHandler> {
    private static final Type<VideoPauseHandler> TYPE = new Type<VideoPauseHandler>();

    public static Type<VideoPauseHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(VideoPauseHandler handler) {
        handler.onPause(this);
    }

    @Override
    public Type<VideoPauseHandler> getAssociatedType() {
        return TYPE;
    }
}
