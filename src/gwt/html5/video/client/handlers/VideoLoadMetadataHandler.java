package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoLoadMetadataEvent;

public interface VideoLoadMetadataHandler extends EventHandler {
    void onMetadataLoaded(VideoLoadMetadataEvent event);
}
