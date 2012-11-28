package fr.hd3d.html5.video.client.events;

import com.google.gwt.event.shared.GwtEvent;

import fr.hd3d.html5.video.client.handlers.VideoLoadStartHandler;

/**
 * The user agent begins looking for media data, as part of the resource selection algorithm.
 * 
 * @author michael.guiral
 * 
 */
public class VideoLoadStartEvent extends GwtEvent<VideoLoadStartHandler> {
    private static final Type<VideoLoadStartHandler> TYPE = new Type<VideoLoadStartHandler>();

    public static Type<VideoLoadStartHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(VideoLoadStartHandler handler) {
        handler.onLoadStart(this);
    }

    @Override
    public Type<VideoLoadStartHandler> getAssociatedType() {
        return TYPE;
    }
}
