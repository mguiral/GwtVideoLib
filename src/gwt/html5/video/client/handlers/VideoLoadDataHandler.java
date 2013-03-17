package gwt.html5.video.client.handlers;

import com.google.gwt.event.shared.EventHandler;

import gwt.html5.video.client.events.VideoLoadDataEvent;

public interface VideoLoadDataHandler extends EventHandler {
    void onDataLoaded(VideoLoadDataEvent event);
}
