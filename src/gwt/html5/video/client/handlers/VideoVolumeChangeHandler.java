package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoVolumeChangeEvent;

public interface VideoVolumeChangeHandler extends EventHandler {
    void onVolumeChange(VideoVolumeChangeEvent event);
}
