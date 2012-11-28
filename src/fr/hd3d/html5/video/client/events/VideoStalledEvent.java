package fr.hd3d.html5.video.client.events;

import com.google.gwt.event.shared.GwtEvent;

import fr.hd3d.html5.video.client.handlers.VideoStalledHandler;

/**
 * The user agent is trying to fetch media data, but data is unexpectedly not forthcoming
 * 
 * @author michael.guiral
 * 
 */
public class VideoStalledEvent extends GwtEvent<VideoStalledHandler> {
    private static final Type<VideoStalledHandler> TYPE = new Type<VideoStalledHandler>();

    public static Type<VideoStalledHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(VideoStalledHandler handler) {
        handler.onStalled(this);
    }

    @Override
    public Type<VideoStalledHandler> getAssociatedType() {
        return TYPE;
    }
}
