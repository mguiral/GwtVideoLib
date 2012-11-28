package fr.hd3d.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import fr.hd3d.html5.video.client.events.VideoLoadMetadataEvent;

public interface VideoLoadMetadataHandler extends EventHandler {
    void onMetadataLoaded(VideoLoadMetadataEvent event);
}
