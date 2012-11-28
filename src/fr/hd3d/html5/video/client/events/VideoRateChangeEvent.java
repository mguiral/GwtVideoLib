package fr.hd3d.html5.video.client.events;

import com.google.gwt.event.shared.GwtEvent;

import fr.hd3d.html5.video.client.handlers.VideoRateChangeHandler;

/**
 * Either the defaultPlaybackRate or the playbackRate attribute has just been updated.
 * 
 * @author michael.guiral
 * 
 */
public class VideoRateChangeEvent extends GwtEvent<VideoRateChangeHandler> {
    private static final Type<VideoRateChangeHandler> TYPE = new Type<VideoRateChangeHandler>();

    public static Type<VideoRateChangeHandler> getType() {
        return TYPE;
    }

    @Override
    protected void dispatch(VideoRateChangeHandler handler) {
        handler.onRateChange(this);
    }

    @Override
    public Type<VideoRateChangeHandler> getAssociatedType() {
        return TYPE;
    }
}
